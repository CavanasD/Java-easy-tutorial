package com.n1n3bird.oop.inheritance;

public class Person {
    public int money = 111111111;
    protected String hobby = "coding"; // protected: 子类可见，同包可见
    String name = "gaoxi";
    public void speak(){
        System.out.println(this.name +" is Speaking...");
    }

    public Person() {
        this.money = 99999999;// 如果Student不写无参构造，还是会调用父类的无参构造，默认为super(), 所以money会被赋值为99999999
    }

    /*
    protected 和 继承的关系：
    1. 子类可以直接访问父类的 protected 属性和方法（也就是被继承过来了）。
    2. 不同包的非子类不能访问 protected 属性。
    3. 同包下的任何类都可以访问 protected 属性。

    访问权限总结:
    public:    所有类可见
    protected: 子类 + 同包可见
    default:   同包可见 (默认不写)
    private:   只有本类可见
     */
    public Person(String name) {
        this.name = name; // Student不会继承父类的构造方法，所以如果Student需要一个带参构造方法，就必须自己写一个，并且在这个构造方法中调用父类的构造方法来初始化父类的属性
    }
}
