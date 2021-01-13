package com.leyou.auth.client;

import com.leyou.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

// 这里为什么用Feign可以调用, 应该具体再研究一下. 并且为什么需要新生成一个User的接口
@FeignClient(value = "user-service")
public interface UserClient extends UserApi {
}
