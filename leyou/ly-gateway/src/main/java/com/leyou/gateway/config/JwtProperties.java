package com.leyou.gateway.config;

import com.leyou.common.utils.RsaUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.security.PublicKey;

@Slf4j
@Data
@ConfigurationProperties(prefix = "ly.jwt")
public class JwtProperties {

    private String pubKeyPath;
    private String cookieName;

    private PublicKey publicKey;

    // 对象一旦实例化后加载, 就应该读取公钥和私钥. static不行
    /**
     * @PostContruct：在构造方法执行之后执行该方法
     */
    @PostConstruct
    public void init() throws Exception{

            // 获取公钥
            this.publicKey = RsaUtils.getPublicKey(pubKeyPath);

    }
}
