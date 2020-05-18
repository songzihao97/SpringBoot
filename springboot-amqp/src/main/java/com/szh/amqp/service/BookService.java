package com.szh.amqp.service;

import com.szh.amqp.domain.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "szh.news")
    public void receive(Book book){
        System.out.println("收到消息："+book);
    }

    @RabbitListener(queues = "szh")
    public void receive2(Message message){
        MessageProperties messageProperties = message.getMessageProperties();
        System.out.println(messageProperties);
        byte[] body = message.getBody();
        System.out.println(body);

    }
}
