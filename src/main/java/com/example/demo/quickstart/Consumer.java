package com.example.demo.quickstart;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws Exception {
        //1.创建connectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.175.128");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        //2.通过连接工厂创建连接
        Connection connection = connectionFactory.newConnection();
        //3.通过connection创建一个Channel
        Channel channel = connection.createChannel();
        //4.声明一个队列  参数 queue,durable(是否是持久化，服务重启了还能运行),exclusive(是否是独占信道),autodelete自动删除队列（脱离减缓及参数后自动删除），argument额外参数
        String queueName = "test001";
        channel.queueDeclare(queueName,true,false,false,null);
        //5.创建消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        //6.设置channel 第二个属性是是否自动获取
        channel.basicConsume(queueName,true,queueingConsumer);
        //7.获取消息
        while (true){
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String msg = new String((delivery.getBody()));
            System.out.println("消费端："+msg);
            //Envelope envelope = delivery.getEnvelope();
        }
    }
}
