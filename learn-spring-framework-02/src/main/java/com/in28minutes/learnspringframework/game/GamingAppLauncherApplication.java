package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @Primary : 여러 부호가 자격이 있는경우 Bean에게 우선권을 줌.
// @ Qualifier : 특정 Bean이 자동 와이어링 되어야한다. (특정 알고리즘만 원할때)
// Qualifier >>>>> primary 우선순위 !!!!

// @ Autowired : 가장 적합한 알고리즘 울 달라고 요청 . (어떤 알고리즘을 사용해도 괜찮다면 Autowired씀)
// 특정? => @primary


@Configuration
// 컴포넌트 있는곳 "~~~" 이 패키지에서 찾아라 .
@ComponentScan("com.in28minutes.learnspringframework.game")
public class GamingAppLauncherApplication {

    public static void main(String[] args) {

        try(
                var context =
                        new AnnotationConfigApplicationContext
                                (GamingAppLauncherApplication.class);
                ){
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();
        }
    }
}
