package com.sdl.common.core.amqp;

import com.sdl.common.core.enums.AmqpArgs;
import com.sdl.common.wrapper.WrapMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program flowerPaaS
 * @description: RibbitMq发送消息
 * @author: songdeling
 * @create: 2019/12/24 11:04
 */

@Component
public class MessageSender {

    @Resource
    AmqpTemplate amqpTemplate;

    public void send(Object object) {
        amqpTemplate.convertAndSend(AmqpArgs.DIRECT_EXCHANGE, AmqpArgs.DIRECT_ROUTING, WrapMapper.ok(object));
    }
}
