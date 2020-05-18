package com.szh.amqp;

import com.szh.amqp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootAmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    //点对点消息发送
    @Test
    void contextLoads() {
        Map<String,Object> map=new HashMap<>();
        map.put("msg","这是第一个消息！");
        map.put("data", Arrays.asList("HelloWorld",123,true));
        rabbitTemplate.convertAndSend("exchange.direct","szh.news",new Book("西游记","吴承恩"));
    }

    //点对点消息接收
    @Test
    public void receive(){
        //rabbitTemplate.receive("szh.news");
        Object o = rabbitTemplate.receiveAndConvert("szh.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    //广播消息发送
    @Test
    void fanout() {
        Map<String,Object> map=new HashMap<>();
        map.put("msg","这是第一个消息！");
        map.put("data", Arrays.asList("HelloWorld",123,true));
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("红楼梦","曹雪芹"));
    }

    @Test
    public void creatExchange(){
        //创建exchange
//        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));

        //创建一个队列
//        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue",true));
        //绑定队列
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE,"amqpAdmin.exchange","amqpAdmin.queue",null));
        System.out.println("创建成功");
    }
}
