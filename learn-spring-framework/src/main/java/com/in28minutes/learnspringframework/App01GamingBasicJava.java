package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.Packman;

public class App01GamingBasicJava {
    public static void main(String[] args) {


//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new Packman(); // 1) 객체 생성
        var gameRunner = new GameRunner(game); // 2) 객체 생성 + 종속성 연결 ( Wiring of Dependencies )
        gameRunner.run();

    }
}
