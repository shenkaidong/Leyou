package com.leyou.cart.service;

import com.leyou.cart.interceptor.UserInterceptor;
import com.leyou.cart.pojo.Cart;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.auth.entity.UserInfo;
import com.leyou.common.utils.JsonUtils;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String KEY_PREFIX = "cart:user:id:";

    public void addCart(Cart cart) {
        // 获取登录用户
        UserInfo user = UserInterceptor.getUser();
        String key = KEY_PREFIX + user.getId();
        String hashKey = cart.getSkuId().toString();
        // 原来的数量
        Integer num = cart.getNum();
        BoundHashOperations<String, Object, Object> operations = redisTemplate.boundHashOps(key);
        // 判断当前购物车商品是否存在
        if (operations.hasKey(hashKey)) {
            // 是, 修改数量
            String json = operations.get(hashKey).toString();
            cart = JsonUtils.parse(json, Cart.class);
            cart.setNum(cart.getNum() + num);
        }
        // 写回redis
        operations.put(hashKey, JsonUtils.serialize(cart));
    }

    public List<Cart> queryCartList() {
        // 获取登录用户
        UserInfo user = UserInterceptor.getUser();
        String key = KEY_PREFIX + user.getId();
        if (!redisTemplate.hasKey(key)) {
            // key不存在, 返回404
            throw new LyException(ExceptionEnum.CART_NOT_FOUND);
        }
        BoundHashOperations<String, Object, Object> operations = redisTemplate.boundHashOps(key);
        List<Object> values = operations.values();
        List<Cart> carts = values.stream()
                .map(o -> JsonUtils.parse(o.toString(), Cart.class))
                .collect(Collectors.toList());
        return carts;
    }

    public void updateNum(Long skuId, Integer num) {
        // 获取登录用户
        UserInfo user = UserInterceptor.getUser();
        String key = KEY_PREFIX + user.getId();
        BoundHashOperations<String, Object, Object> operations = redisTemplate.boundHashOps(key);
        String hashKey = skuId.toString();
        if (!operations.hasKey(hashKey)) {
            throw new LyException(ExceptionEnum.CART_NOT_FOUND);
        }
        String json = operations.get(hashKey).toString();
        Cart cart = JsonUtils.parse(json, Cart.class);
        cart.setNum(num);
        // 写回redis
        operations.put(hashKey, JsonUtils.serialize(cart));
    }

    public void deleteCart(Long skuId) {
        // 获取登录用户
        UserInfo user = UserInterceptor.getUser();
        String key = KEY_PREFIX + user.getId();

        // 删除
        redisTemplate.opsForHash().delete(key, skuId.toString());
    }
}

/*

package com.leyou.cart.service;

import com.leyou.auth.entity.UserInfo;
import com.leyou.cart.interceptor.UserInterceptor;
import com.leyou.cart.pojo.Cart;
import com.leyou.common.utlis.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String KEY_PREFIX = "cart:uid";

    public void addCart(Cart cart) {
        // 获取登陆的用户
        UserInfo user = UserInterceptor.getUser();
        // key
        String key = KEY_PREFIX + user.getId();
        // hashKey
        String hashKey = cart.getSkuId().toString();
        // 记录num
        Integer num = cart.getNum();
        BoundHashOperations<String, Object, Object> operation = redisTemplate.boundHashOps(key);
        // 判断当前购物车商品, 是否存在
        if (operation.hasKey(hashKey)) {
            // 存在, 修改数量
            String json = operation.get(hashKey).toString();
            cart = JsonUtils.parse(json, Cart.class);
            cart.setNum(cart.getNum()+ num);
        }
        // 写回redis
        operation.put(hashKey,JsonUtils.serialize(cart));
    }
}

*/