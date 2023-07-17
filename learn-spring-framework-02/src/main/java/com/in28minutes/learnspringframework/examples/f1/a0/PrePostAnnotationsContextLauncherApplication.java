package com.in28minutes.learnspringframework.examples.f1.a0;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All Dependencies are ready ! ");
    }

    @PostConstruct
    // PostConstruct : 의존성 주입이 완료 된 후 실행해야하는 메소드에서 사용.
    // ex) database 에서 data 가져오려는 경우도 사용 가능.
    public void initialize() {
        someDependency.getReady();
    }

    // PreDestroy : container 에서 삭제하는 과정 중 임을 알려주는 콜백 알림으로 method 에서 사용.
    // 일반적으로 보유하고 있는 resource 를 해제하는데 사용.
    @PreDestroy
    public void cleanUp() {
        System.out.println("Clean up");
    }

}

@Component
class SomeDependency {
    public void getReady() {
        System.out.println("Some logic using SomeDependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String[] args) {

        try (
                var context =
                        new AnnotationConfigApplicationContext
                                (PrePostAnnotationsContextLauncherApplication.class);
        ) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }
    }
}
