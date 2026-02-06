package com.n1n3bird.oop;
// How to call methods in Java
// Look at Student.java
public class CallMethod {
    public static void CallMethodMain(String[] args) {
        Student.study();
        //Student.say();会报错，因为say()是一个实例方法，必须通过对象来调用
        Student NineBird = new Student();// 直接输入new Student() 按一下Alt+Enter即可
        NineBird.speak();
        int result = Student.studentCalculateAdd(4,6);
        System.out.println(result);

    }
}
