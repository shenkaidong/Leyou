package com.leyou.auth.web;

import com.leyou.auth.config.JwtProperties;
import com.leyou.auth.entity.UserInfo;
import com.leyou.auth.service.AuthService;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.utils.JwtUtils;
import com.leyou.common.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@EnableConfigurationProperties(JwtProperties.class)
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtProperties prop;

    //@Value("${ly.jwt.cookieName}")
    //private String cookieName;


    /**
     * 登录授权工程
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public ResponseEntity<String> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response){
        // 登录
        String token = this.authService.login(username,password);
        // TODO 写入cookie domain
        // Cookie cookie = new Cookie("LY_TOKEN", token);
        CookieUtils.setCookie(request,response,prop.getCookieName(),
                token, prop.getCookieMaxAge(),true);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 校验用户登陆状态
     * @return
     */
    @GetMapping("verify")
        public ResponseEntity<UserInfo> verify(
                @CookieValue("LY_TOKEN") String token,
                HttpServletRequest request,
                HttpServletResponse response){
        try{
            // 解析token
            UserInfo info = JwtUtils.getInfoFromToken(token, prop.getPublicKey());
            // 刷新token, 因为这个请求要维持用户登录的状态, 所以要是生成新的token, 过去的token时间还是旧的. 这里面要更新
            String newToken = JwtUtils.generateToken(info, prop.getPrivateKey(), prop.getExpire());
            // 写回cookie当中
            CookieUtils.setCookie(request,response,prop.getCookieName(),
                    token, prop.getCookieMaxAge(),true);
            return ResponseEntity.ok(info);
        } catch (Exception e){
            // token 已过期, 或者无效, 被篡改
            throw new LyException(ExceptionEnum.UNAUTHORIZED);
        }
        }
}
