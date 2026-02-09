package com.n1n3bird.oop.encapsulation;

public class Hacker {
    private String name;
    private char gender;
    private int age;

    public Hacker() {
        name = "Nailong";
        gender = '0';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if (gender == 'M' || gender == 'F') {
            this.gender = gender;
        }else  {
            System.out.println("InvalidGender");
        }

    }
}
