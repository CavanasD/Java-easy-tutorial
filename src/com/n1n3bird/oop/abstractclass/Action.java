package com.n1n3bird.oop.abstractclass;

public abstract class Action {

    // 抽象方法，只有方法名字，没有方法的实现！
    public abstract void doSomething();

    // 1. 不能new这个抽象类，只能靠子类去实现它：约束！
    // 2. 抽象类中可以写普通的方法~
    // 3. 抽象方法必须在抽象类中~
    // 抽象的抽象：约束~
    public void sayHello() {
        System.out.println("Hello");
    }
}
