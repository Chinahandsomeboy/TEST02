package com.example.demo.quickstart;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建connectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.175.128");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        //2.通过连接工厂创建连接
        Connection connection = connectionFactory.newConnection();
        //3.通过connection创建一个Channel
        Channel channel = connection.createChannel();
        //4.通过channel发送数据
        for (int i =0;i<5;i++){
            String msg = "Hello RabbitMQ";
            //参数：1.exchange 空默认是第一个default的，他就按照routingkey的，找到和routingkey一模一样的队列名字
            //      2.如果1为空，routingkey 机制是找到和test001相同的queue名称
            //      The default exchange is implicitly bound to every queue, with a routing key equal to the queue name.
            //      It is not possible to explicitly bind to, or unbind from the default exchange. It also cannot be deleted.
            channel.basicPublish("","test001",null,msg.getBytes());
        }
        //5.记得关闭相关连接
        channel.close();
        connection.close();
    }
}
