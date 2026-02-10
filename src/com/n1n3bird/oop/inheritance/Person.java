package com.n1n3bird.oop.inheritance;

public class Person {
    public int money = 111111111;
    String name = "gaoxi";
    public void speak(){
        System.out.println(this.name +" is Speaking...");
    }

    public Person() {
        this.money = 99999999;// 如果Student不写无参构造，还是会调用父类的无参构造，默认为super(), 所以money会被赋值为99999999
    }
    public Person(String name) {
        this.name = name; // Student不会继承父类的构造方法，所以如果Student需要一个带参构造方法，就必须自己写一个，并且在这个构造方法中调用父类的构造方法来初始化父类的属性
    }
}
