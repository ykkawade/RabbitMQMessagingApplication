package com.messengerproject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

public class Sender4 {

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();

        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
            channel.queueDeclare("hello world",false,false,false,null);

            String message = "Sender 4 " + LocalDateTime.now();

            while(true) {
                channel.basicPublish("", "hello world", false, null, message.getBytes(StandardCharsets.UTF_8));
                System.out.println("Sender 4 "  + LocalDateTime.now());
            }

        }


    }
}
