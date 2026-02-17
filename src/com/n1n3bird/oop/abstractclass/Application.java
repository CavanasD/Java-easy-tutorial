package com.n1n3bird.oop.abstractclass;

public class Application {
    public static void main(String[] args) {
        // new Action(); // 抽象类不能new~
        A a = new A();
        a.doSomething();
        a.sayHello();
    }
}

