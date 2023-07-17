package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address){}
record Address(String firstLine, String city){}

@Configuration
public class HelloWoldConfiguration {

    @Bean
    public String name(){
        return "Cheol EUi";
    }

    @Bean
    public int age(){
        return 20;
    }

    @Bean
    public Person person(){
        return new Person("Cheol", 22, new Address("hard_coded","GyeonGi"));
    }
    // Spring Bean 이 이미 관리하고 있는 bean 활용하여 새로운 Spring bean 메소드 만들기.
    @Bean
    public  Person person2ByMethodCall(){
        return new Person(name(), age(), address());
    }

    // 메개변수 활용하여 Spring Bean 재활용하여 새로운 bean 메소드 만들기.
    @Bean
    public  Person person3ByParameters(String name, int age, Address address3){//name, age, address2
        return new Person(name, age, address3);
    }

    @Bean
    @Primary
    public  Person person4ByParameters(String name, int age, Address address){//name, age, address2
        return new Person(name, age, address);
    }
    @Bean
    public  Person person5Qualifiers(String name, int age,@Qualifier("address4Qualifier") Address address){//name, age, address2
        return new Person(name, age, address);
    }

    @Bean(name = "address2")
    public Address address(){
        return new Address("first_Line", "seoul");
    }

    @Bean(name = "address3")
    @Primary
    public Address addresstwo(){
        return new Address("primary-do 입니다.", "primary_city");
    }

    @Bean(name = "address4")
    @Qualifier("address4Qualifier")
    public Address addressThree(){
        return new Address("qualify-do 입니다.", "qualifier_city");
    }
}
