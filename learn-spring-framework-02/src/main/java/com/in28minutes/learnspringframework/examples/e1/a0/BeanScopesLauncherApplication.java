package com.in28minutes.learnspringframework.examples.e1.a0;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//Normal class => 항상 같은 인스턴스
//             >> SingleTon
@Component
class Normal{}

@Component
// prototype class 만들기
// prototype 이란?
// 호출 떄마다 새로운 인스턴스로 호출 (서로 다른 해시코드,값)
// => 스프링이 context 에서 계속 새로운 Bean을 가져오는 것
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class Prototype{}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

    public static void main(String[] args) {

        try(
                var context =
                        new AnnotationConfigApplicationContext
                                (BeanScopesLauncherApplication.class);
                ){

            System.out.println(context.getBean(Normal.class));
            System.out.println(context.getBean(Normal.class));

            System.out.println(context.getBean(Prototype.class));
            System.out.println(context.getBean(Prototype.class));
            System.out.println(context.getBean(Prototype.class));
        }
    }
}

/**
 * Java Singleton (GOF) vs Spring Singleton
 *
 * java singleton : One object instance per JVM.
 * Spring Singleton : One object instance per Spring IOC Container.
 * ( spring ioc container 여러개 생성시 다른 의미 )
 * 일반적으로 여러개 생성 안함. >> 99.99% 자바싱글톤과 같은 의미.!!!
 * */