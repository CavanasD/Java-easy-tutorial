package com.n1n3bird.oop;

public class Student{
    String name;

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
