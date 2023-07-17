package com.in28minutes.learnspringframework.game;

public class SuperContraGame implements GamingConsole{
    public void up(){
        System.out.println("contra up");
    }

    public void down(){
        System.out.println("contra sit down");
    }

    public void left(){
        System.out.println("Go back");
    }
    public void right(){
        System.out.println("shoot a bullet");
    }
}
