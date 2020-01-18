package com.sdl.common.core.enums;

/**
 * @program flowerPaaS
 * @description: RibbitMQ参数值
 * @author: songdeling
 * @create: 2019/12/24 11:09
 */
public interface AmqpArgs {

    String DIRECT_QUEUE = "flowerDirect";
    String DIRECT_EXCHANGE = "flower.direct";
    String DIRECT_ROUTING = "flower.direct.routing";

}
