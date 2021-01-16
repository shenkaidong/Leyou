package com.leyou.user.sercice;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.utils.NumberUtils;
import com.leyou.user.mapper.UserMapper;
import com.leyou.user.pojo.User;
import com.leyou.user.utils.CodecUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String KEY_PREFIX = "user.verify:phone";

    public Boolean checkData(String data, Integer type) {
        // 判断数据类型
        User record = new User();
        switch (type) {
            case 1:
                record.setUsername(data);
                break;
            case 2:
                record.setPhone(data);
                break;
            default:
                throw new LyException(ExceptionEnum.INVALID_USER_DATA_TYPE);
        }

        record.setUsername(data);
        return userMapper.selectCount(record) == 0 ;
    }

    public void sendCode(String phone) {
        // 生成key
        String key = KEY_PREFIX + phone;
        // 生成验证码
        String code = NumberUtils.generateCode(6); // TODO 验证码生成
        Map<String, String> msg = new HashMap<>();
        msg.put("phone",phone);
        msg.put("code",code);
        // 发送验证码
        amqpTemplate.convertAndSend("ly.sms.exchange","sms.verify.code",msg);

        // 保存验证码
        redisTemplate.opsForValue().set(key, code,5, TimeUnit.MINUTES);
    }

    public void register(User user, String code) {
        // 从redis中取出验证码
        String cachCode = redisTemplate.opsForValue().get(KEY_PREFIX + user.getPhone());
        // 校验验证码
        if (!StringUtils.equals(code, cachCode)) {
            throw new LyException(ExceptionEnum.INVALID_VERIFY_CODE);
        }
        // 生成盐
        String salt = CodecUtils.generateSalt();
        user.setSalt(salt);
        // 对密码加密
        user.setPassword(CodecUtils.md5Hex(user.getPassword(),salt));

        // 写入数据库
        user.setCreated(new Date());
        userMapper.insert(user);
    }

    public User queryUserByUsernameAndPassword(String username, String password) {
        // 查询用户
        User record = new User();
        record.setUsername(username);
        User user = userMapper.selectOne(record);
        // 校验
        if (user==null) {
            throw new LyException(ExceptionEnum.INVALID_USERNAME_PASSWORD);
        }
        // 校验密码, 这样写代码的可读性强, 避免if和else嵌套
        if (!StringUtils.equals(user.getPassword(), CodecUtils.md5Hex(password,user.getSalt()))) {
            throw new LyException(ExceptionEnum.INVALID_USERNAME_PASSWORD);
        }
        // 用户名和密码正确
        return user;
    }
}
