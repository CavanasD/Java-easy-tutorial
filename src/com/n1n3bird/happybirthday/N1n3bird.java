package com.n1n3bird.happybirthday;

class Hacker {
    protected String name = "N1n3bird";
    public void fastHack() {
        System.out.println("Hacking");
    }
}
public class N1n3bird extends Hacker {
    public static void main(String[] args) {
        N1n3bird me = new N1n3bird();
        me.fastHack();
        int age = 19;
        if (age == 19) {
            System.out.println("Happy Birthday, " + me.name);
        }
    }
}