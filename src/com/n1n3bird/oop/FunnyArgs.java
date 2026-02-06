package com.n1n3bird.oop;

import static com.n1n3bird.oop.Student.changeNameToNailong;

public class FunnyArgs {

    public static void FunnyArgsMain(String[] args) {
        // 值传递
        int a = 1;
        System.out.println(a);
        changeValue(a);
        System.out.println(a);
        //引用传递
        Student n1n3bird = new Student();
        System.out.println(n1n3bird.name);
        changeNameToNailong(n1n3bird);
        System.out.println(n1n3bird.name);
    }

    private static void changeValue(int a) {
        a = 100;
    }
}
