package com.n1n3bird.oop.basic;

public class Student{
    String name;
    int age;
    // Creation of Class and Object
    public void easyGotFlag(){
        System.out.println(this.name + " cat Flag easily!");

    }

    // 方法复习小节所用方法
    public static void changeNameToNailong(Student stu) {
        stu.name = "Nailong";
    }
    public static void study(){
        System.out.println("Student Studying...");
    }
    public void speak(){
        System.out.println("Student Speaking...");
    }
    public static int studentCalculateAdd(int a, int b){
        return a + b;
    }
}
