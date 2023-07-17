package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

// component => Spring 이 인스턴스 알아서 생성하도록.
// (bean 따로 만들지않고 하기)
@Component
public class Packman implements GamingConsole{
    @Override
    public void up() {
        System.out.println("팩맨 점프");
    }

    @Override
    public void down() {
        System.out.println("팩맨 엎드리기");
    }

    @Override
    public void right() {
        System.out.println("팩맨 오른쪽이동");
    }

    @Override
    public void left() {
        System.out.println("팩맨 뒤로가기");
    }
}
