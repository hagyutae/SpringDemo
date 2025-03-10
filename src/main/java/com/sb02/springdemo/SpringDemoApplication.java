package com.sb02.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);

        SingletonComponent singletonComponent1 = (SingletonComponent) context.getBean("singletonComponent");
        SingletonComponent singletonComponent2 = (SingletonComponent) context.getBean("singletonComponent");
        System.out.println("SingletonComponent random int values: " + singletonComponent1.getRandomInt() + ", " + singletonComponent2.getRandomInt());


        PrototypeComponent prototypeComponent1 = (PrototypeComponent) context.getBean("prototypeComponent");
        PrototypeComponent prototypeComponent2 = (PrototypeComponent) context.getBean("prototypeComponent");
        System.out.println("PrototypeComponent random int values: " + prototypeComponent1.getRandomInt() + ", " + prototypeComponent2.getRandomInt());
    }
}
