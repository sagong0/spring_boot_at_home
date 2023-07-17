package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.Packman;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game(){
        var game = new Packman();

        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        var gameRunner = new GameRunner(game);

        return gameRunner;
    }
    //        var game = new MarioGame();
//        var game = new SuperContraGame();
//    var game = new Packman(); // 1) 객체 생성
//    var gameRunner = new GameRunner(game); // 2) 객체 생성 + 종속성 연결 ( Wiring of Dependencies )
//        gameRunner.run();
}
