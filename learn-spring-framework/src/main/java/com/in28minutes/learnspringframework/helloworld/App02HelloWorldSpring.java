package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {

        try(
                // 1) Spring Application or Spring context 를 실행하는 단계
                var context = new AnnotationConfigApplicationContext(HelloWoldConfiguration.class);
                ){

            // 2) Configure the things that we want Spring to manage ㅡ@configuration
            // HelloWorldConfiguration -@Configuration
            // name - @Bean

            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println("-------------");
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean("person2ByMethodCall"));
            System.out.println("person 3333----------");
            System.out.println(context.getBean("person3ByParameters"));

            System.out.println("---- ADDRESS CLASS ----");
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean("address3"));
            System.out.println("-------------------------");

            System.out.println("---- Person CLASS ----");
            System.out.println(context.getBean(Person.class));
            System.out.println(context.getBean("person5Qualifiers"));

//        Arrays.stream(context.getBeanDefinitionNames())
//                .forEach(System.out::println);
        }


    }
}
