package com.in28minutes.learnspringframework.examples.h1.a0;

import com.in28minutes.learnspringframework.game.GameRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class XmlConfigurationContextLauncherApplication {

    public static void main(String[] args) {

        try(
                var context =
                        // xml 위해 서 classPath 이거씀
                        new ClassPathXmlApplicationContext("contextConfiguration.xml")){
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            context.getBean(GameRunner.class).run();
        }
    }
}
