package com.sb02.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);

        SingletonComponent singletonComponent1 = (SingletonComponent) context.getBean("singletonComponent");
        System.out.println(singletonComponent1.getRandomInt());
        SingletonComponent singletonComponent2 = (SingletonComponent) context.getBean("singletonComponent");
        System.out.println(singletonComponent2.getRandomInt());

        PrototypeComponent prototypeComponent1 = (PrototypeComponent) context.getBean("prototypeComponent");
        System.out.println(prototypeComponent1.getRandomInt());
        PrototypeComponent prototypeComponent2 = (PrototypeComponent) context.getBean("prototypeComponent");
        System.out.println(prototypeComponent2.getRandomInt());
    }
}
