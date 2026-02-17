package com.n1n3bird.oop.fuckustatic;

// 静态导入包
import static java.lang.Math.random;
import static java.lang.Math.PI;

public class DaShen {
    private static int age;
    private double score;

    public void run() {
        go(); // 非静态方法可以调用静态方法
    }
    public static void go() {
        System.out.println("go");
        // run(); // 静态方法不可以调用非静态方法
    }
    // 匿名代码块：创建对象时创建，在构造器之前
    {
        System.out.println("匿名代码块");
    }

    // 静态代码块：类加载一刻执行，永久只执行一次
    static {
        System.out.println("静态代码块");
    }

    // 构造方法
    public DaShen() {
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        new DaShen();
        System.out.println("==================");
        new DaShen();
        System.out.println("==================");
        System.out.println(random());
        System.out.println(PI);
    }
}
/* Gemini老师课堂开课了
static 修饰符用于创建类变量和类方法，它让属性和方法属于类本身，而不是属于某个具体的对象。
静态变量 (Static Variables):
    被 static 修饰的变量，在内存中只有一份，会被所有对象共享。
    推荐访问方式：类名.变量名 (例如 DaShen.age)。
静态方法 (Static Methods):
    可以通过 类名.方法名() 直接调用。
重要限制：静态方法中不能直接调用非静态的方法或变量（因为它不依赖于对象存在，而非静态成员必须依赖对象）。
    代码块执行顺序 (面试常考):
静态代码块 (static { ... }): 类加载时执行，且只执行一次。通常用于初始化静态资源。
    匿名代码块 ({ ... }): 每次创建对象（new）时都会执行，且在构造器之前执行。可以用来赋初值。
构造方法: 创建对象时执行，在匿名代码块之后。
    执行顺序总结：静态代码块 (一次) -> 匿名代码块 (多次) -> 构造方法 (多次)。
静态导入 (Static Import):
    用于导入类中的静态成员，导入后可以直接使用方法名或变量名，无需加类名。
    语法：import static 包名.类名.静态成员; 或 import static 包名.类名.*;
    例如：import static java.lang.Math.random; 后，可直接写 random()。
 */