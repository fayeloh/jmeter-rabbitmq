/**
 * TODO
 * 
 */
package com.fayeloh.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
/**
 * @author fayeloh
 * 生产者类
 */
public class P {
//创建队列
  private final static String QUEUE_NAME = "helloe";

  public static void main(String[] argv) throws Exception {
//    创建连接工厂
    ConnectionFactory factory = new ConnectionFactory();
//    链接的主机名
    factory.setHost("localhost");
//    创建链接
    Connection connection = factory.newConnection();
//    创建信息管道
    Channel channel = connection.createChannel();
//    声明队列
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    String message = "Hello Worlde!";
//   发送消息
    channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
    System.out.println("P [x] Sent '" + message + "'");

    channel.close();
    connection.close();
  }
}
