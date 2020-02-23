package org.apache.dubbo.samples.echo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;


public class EchoProvider {

    public static void main(String[] args) throws Exception {
        new EmbeddedZooKeeper(2182, false).start();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/echo-provider.xml");
        context.start();

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }
}
