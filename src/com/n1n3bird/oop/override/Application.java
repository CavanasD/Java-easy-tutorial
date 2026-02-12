package com.n1n3bird.oop.override;

public class Application {
    public static void main(String[] args) {

        ExampleA a = new ExampleA();
        a.test();

        ExampleB b = new ExampleA();
        b.test();

        a.test2();
        b.test2();


    }
}
/*
静态方法 vs 非静态方法
   - static 方法：属于类，不属于实例。调用只和左边的引用类型有关 (编译期绑定)。
     如果 test() 是 static 的，b.test() 就会输出 "B test"。
   - 非 static 方法：属于实例。调用和右边的实际对象类型有关 (运行时多态)。
     因为 test() 是非 static 的，b 虽然声明为 ExampleB 类型，但它实际指向内存中的 ExampleA 对象，所以调用 ExampleA 的 test()。
*/
