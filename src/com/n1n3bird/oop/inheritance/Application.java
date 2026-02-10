package com.n1n3bird.oop.inheritance;

public class Application {
    public static void main(String[] args){
        Student gaoxi = new Student();
        gaoxi.name = "Gaoxi";
        System.out.println(gaoxi.name);
        System.out.println(gaoxi.money);
        gaoxi.speak();
        GuiJiShengWu alien = new GuiJiShengWu();
        alien.hashCode();

    }
}
