package com.n1n3bird.oop.InsiderClass;

public class OuterClass {

    private int id = 10;
    public void out() {
        System.out.println("这是外部类的方法");
    }

    // 1. 成员内部类
    public class Inner {
        public void in() {
            System.out.println("这是内部类的方法");
        }

        // 获得外部类的私有属性
        public void getID() {
            System.out.println(id);
        }
    }

    // 2. 静态内部类
    public static class StaticInner {
        public void in() {
            System.out.println("这是静态内部类的方法");
        }
    }

    // 3. 局部内部类
    public void method() {
        class LocalInner {
            public void in() {
                System.out.println("这是局部内部类的方法");
            }
        }
    }

}
// 4. 匿名内部类（没有名字初始化类，不用将实例保存到变量中）
class Test {
    public static void main(String[] args) {
        // 成员内部类实例化
        OuterClass outer = new OuterClass();
        // 通过外部类对象来实例化内部类
        OuterClass.Inner inner = outer.new Inner();
        inner.in();
        inner.getID();
        // 静态内部类实例化
        // 静态内部类可以直接实例化，不需要外部类对象
        // 注意：静态内部类无法直接访问外部类的非静态属性
        OuterClass.StaticInner staticInner = new OuterClass.StaticInner();
        staticInner.in();
        // 匿名内部类
        // 没有名字初始化类, 不用实例保存到变量中
        new Apple().eat();
        // 也可以实现接口
        new UserService() {
            @Override
            public void hello() {
                System.out.println("Hello from Anonymous Inner Class");
            }
        };
    }
}

class Apple {
    public void eat() {
        System.out.println("1");
    }
}

interface UserService {
    void hello();
}
