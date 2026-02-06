package com.n1n3bird.basic;

public class Operator {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 25;
        int d = 30;
        // + - * / % & ^ | ~ 都不必讲了，跟别的语言一样
        // 三目运算符：条件 ? 值1 : 值2
        int max = (a > b) ? a : b;
        System.out.println("max(a,b) = " + max);
        String msg = (d % 2 == 0) ? "d is even" : "d is odd";
        System.out.println(msg);

        // 位运算：& | ^ ~  （按二进制位运算）
        int p = 6; // 0b0110
        int q = 3; // 0b0011
        System.out.println("p & q = " + (p & q)); // 2
        System.out.println("p | q = " + (p | q)); // 7
        System.out.println("p ^ q = " + (p ^ q)); // 5
        System.out.println("~p    = " + (~p));    // 按位取反（补码，会是负数）

        // 位移：<< 左移, >> 算术右移, >>> 逻辑右移（高位补0）
        System.out.println("p << 1  = " + (p << 1));
        System.out.println("p >> 1  = " + (p >> 1));
        int neg = -8;
        System.out.println("neg >> 1  = " + (neg >> 1));
        System.out.println("neg >>> 1 = " + (neg >>> 1));

        // 位运算复合赋值：&= |= ^= <<= >>= >>>=
        int m = 12;
        m &= 10;
        m |= 3;
        m ^= 5;
        m <<= 1;
        System.out.println("m(after bit ops) = " + m);

        // Math 类
        System.out.println("Math.abs(-7) = " + Math.abs(-7));
        System.out.println("Math.max(a, b) = " + Math.max(a, b));
        System.out.println("Math.min(a, b) = " + Math.min(a, b));
        System.out.println("Math.pow(2, 10) = " + Math.pow(2, 10));
        System.out.println("Math.sqrt(81) = " + Math.sqrt(81));

        // random(): [0.0, 1.0)
        double r = Math.random();
        System.out.println("Math.random() = " + r);

        // round/ceil/floor：四舍五入/向上取整/向下取整
        double v = 12.34;
        System.out.println("Math.round(12.34) = " + Math.round(v));      // long
        System.out.println("Math.ceil(12.34)  = " + Math.ceil(v));       // double
        System.out.println("Math.floor(12.34) = " + Math.floor(v));      // double
    }
}
