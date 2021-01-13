package com.leyou.user.web;

import com.leyou.user.pojo.User;
import com.leyou.user.sercice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 校验数据
     * @param data
     * @param type
     * @return
     */
    @GetMapping("/check/{data}/{type}")
    public ResponseEntity<Boolean> checkData(@PathVariable("data") String data, @PathVariable("type") Integer type){
        return ResponseEntity.ok(userService.checkData(data, type));
    }

    /**
     * 发送短信
     * @param phone
     * @return
     */
     //@PostMapping("code")
    @PostMapping("send")
    public ResponseEntity<Void> sendCode(@RequestParam("phone") String phone){
        userService.sendCode(phone);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("register")
        public ResponseEntity<Void> register(@Valid User user, BindingResult result, @RequestParam("code") String code){
//        if (result.hasFieldErrors()){
//            throw new RuntimeException(result.getFieldErrors().stream()
//                    .map(e ->e.getDefaultMessage()).collect(Collectors.joining("|")));
//        }
            userService.register(user,code);
            // 没有返回值, 不需要写Body, 所以直接build
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        @GetMapping("/query")
        public ResponseEntity<User> queryUserByUsernameAndPassword(
                @RequestParam("username") String username,
                @RequestParam("password") String password
        ){
            return ResponseEntity.ok(userService.queryUserByUsernameAndPassword(username,password));
        }
}
