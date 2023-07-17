package com.in28minutes.learnspringframework.examples.d1.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
class  A{}

@Component
@Lazy
class B{
    private A a;

    public B(A a) {
        // Logic
        System.out.println("Some Initialization Logic");
        this.a = a;
    }

    public void doSomeThing(){
        System.out.println("Do SomeThing");
    }
}


@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {

        try(
                var context =
                        new AnnotationConfigApplicationContext
                                (LazyInitializationLauncherApplication.class);
                ){
            System.out.println("Initialization of context is completed");

            context.getBean(B.class).doSomeThing();
        }
    }
}
