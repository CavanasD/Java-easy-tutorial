package com.n1n3bird.oop.encapsulation;

public class Application {
    public static void main(String[] args) {
        Hacker ZhiQiao = new Hacker();
        String hackerName = ZhiQiao.getName();
        System.out.println(hackerName);
        ZhiQiao.setName("XiaoZhiKE");
        System.out.println(hackerName);
        /*虽然修改了 ZhiQiao 这个对象的内部属性，但是 hackerName
        这个变量仍然指向之前的旧字符串
        （字符串在 Java 中是不可变的，且变量不会自动跟随
        对象属性变化而更新）
         */
        System.out.println(ZhiQiao.getName());
        ZhiQiao.setGender('S');
        System.out.println(ZhiQiao.getGender());
        ZhiQiao.setGender('M');
        System.out.println(ZhiQiao.getGender());
    }
}
