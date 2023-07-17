package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.Packman;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {


        try(
                var context =
                        new AnnotationConfigApplicationContext
                                (GamingConfiguration.class);
                ){
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();
        }


//        var game = new MarioGame();
//        var game = new SuperContraGame();
//        var game = new Packman(); // 1) 객체 생성
//        var gameRunner = new GameRunner(game); // 2) 객체 생성 + 종속성 연결 ( Wiring of Dependencies )
//        gameRunner.run()

    }
}
