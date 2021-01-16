package com.leyou.mq;

import com.aliyuncs.exceptions.ClientException;
import com.leyou.common.utils.JsonUtils;
import com.leyou.sms.config.SmsProperties;
import com.leyou.sms.utils.SmsUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;

@Slf4j
@Component
@EnableConfigurationProperties(SmsProperties.class)
public class SmsListener {

    @Autowired
    private SmsProperties prop;

    @Autowired
    private SmsUtils smsUtils;

    /**
     * 发送短信验证码
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "sms.verify.code.queue",durable = "true"),
            exchange = @Exchange(name = "ly.sms.exchange", type = ExchangeTypes.TOPIC),
            key = {"sms.verify.code"}
    ))
    public void listenInserOrUpdate(Map<String,String> msg){
        if(CollectionUtils.isEmpty(msg)){
            return;
        }
        String phone = msg.remove("phone");
        if (StringUtils.isBlank(phone)){
            return;
        }
        // 处理消息, 对索引库进行新增或修改
        // 这里失败不要回滚. 应为是验证码, 回滚可能会出现其他的问题

        try {
            smsUtils.sendSms(phone,prop.getSignName(),prop.getVerifyCodeTemplate(), JsonUtils.serialize(msg));
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }


}
