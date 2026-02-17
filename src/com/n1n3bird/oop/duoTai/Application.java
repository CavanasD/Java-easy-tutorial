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
        // n1n3bird.hack();// 会报错
        ((Hacker) n1n3bird).hack();// 强制转换

        /*
        instanceof 关键字简单笔记:
        1. 作用：测试左边的对象是否是右边类的实例（或者是其子类的实例）。
        2. 返回值：boolean 类型 (true/false)。
        3. 编译通过条件：X instanceof Y，X 的引用类型与 Y 之间必须有父子关系，否则编译报错。
        4. 运行结果：看 X 实际指向的对象是不是 Y 类型的子类/实现类。
        */

        // System.out.println(X instanceof Y); // 能不能编译通过？ -> X的引用类型 与 Y 是否有父子关系
        // 结果是 true 还是 false？ -> X实际指向的对象 是不是 Y 的子类型

        // Object > Person > Hacker
        // Object > String
        // Teacher (假设有)

        System.out.println(klare instanceof Hacker); // true
        System.out.println(klare instanceof Person); // true
        System.out.println(klare instanceof Object); // true
        System.out.println(klare instanceof String); // false

        System.out.println(n1n3bird instanceof Hacker); // true
        System.out.println(n1n3bird instanceof Person); // true
        System.out.println(n1n3bird instanceof Object); // true
        // System.out.println(n1n3bird instanceof String); // 编译报错！Person 和 String 没关系

        System.out.println(shyler instanceof Hacker); // true
        System.out.println(shyler instanceof Person); // true
        System.out.println(shyler instanceof Object); // true
        // System.out.println(shyler instanceof String); // 编译报错！Hacker 和 String 没关系
    }
}
