package com.dercg.rabbit.Simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("211.159.148.205");
        factory.setPassword("password");
        factory.setUsername("user");
        factory.setPort(5672);

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            for (int i = 0; i < 1000; i++) {
                String message = "Hello World!"+i;
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            }

        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
