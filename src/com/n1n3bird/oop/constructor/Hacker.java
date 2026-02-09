package com.n1n3bird.oop.constructor;

public class Hacker {
    String name;

    public Hacker() {
        this.name = "klare";
    }

    public Hacker(String name) {
        this.name = name;
    }
    /* 注意，有参构造就必须写无参构造，否则会报错，
    因为在Application.java中创建了一个Hacker对象时
    没有传入参数，所以会调用无参构造，如果没有无参构造就会报错
    （不写有参构造，也不写无参构造，JRE自动给你写个空的无参构造）
     */

}
