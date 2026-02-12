package com.n1n3bird.oop.duoTai;

public class Application {
    public static void main(String[] args) {
        Hacker shyler = new Hacker();
        Person n1n3bird = new Hacker();// 父类引用指向子类对象,但注意，子类独有的方法无法通过父类调用
        Object klare = new Hacker();// Object祖宗类
        /* 一个对象的实际类型是确定的，
        但他的引用类型就不一定了
         */
        shyler.run();
        n1n3bird.run();
        /* 这里虽然 n1n3bird 的引用类型是 Person，但它实际指向一个 Hacker 对象，所以调用 run() 方法时会执行 Hacker 类中的*/
        n1n3bird.hack();// 会报错
        ((Hacker) n1n3bird).hack();// 强制转换


    }
}
