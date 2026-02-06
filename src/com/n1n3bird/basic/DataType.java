package com.n1n3bird.basic;

public class DataType {
    public static void main(String[] args) {
        // 基本类型：byte/short/int/long/float/double/char/boolean
        int i = 10;
        double d = 0.1;
        boolean ok = true;
        char c = 'A';
        // 引用类型：类/接口/数组/枚举…（变量里存的是“引用”，对象在堆上）
        // String 不是基本类型；它是一个类，s 变量保存的是 String 对象的引用。
        String s = "hello";
        int[] arr = {1, 2, 3};

        // 可以拼接的哦
        System.out.println("i=" + i);               // -> "i=10"
        System.out.println("i + d = " + (i + d));   // 括号里先做数值运算

        // char 参与 + 时：如果没有 String，会按“字符的 Unicode 编码值”做数值运算
        System.out.println('A' + 1);                 // 66（65 + 1）
        System.out.println("" + 'A' + 1);           // "A1"（一旦有 String 就是拼接）

        //自动类型转换
        // 小容量转大容量。 `byte` → `short` → `char` → `int` → `long` → `float` → `double`
        long L = i;          // int -> long
        double D = L;        // long -> double
        System.out.println("L=" + L + ", D=" + D);

        // 强制类型转换
        double price = 12.99;
        int intPrice = (int) price; // 截断小数，不是四舍五入
        System.out.println("(int)12.99 = " + intPrice);

        // 溢出示例：int 的范围是 [-2147483648, 2147483647]
        int big = 1_500_000_000;
        int overflow = big * 2; // 这里发生 int 溢出（不会报错，会变成负数）
        long correct = (long) big * 2; // 先提升到 long 再乘，避免溢出
        System.out.println("overflow(int)=" + overflow);
        System.out.println("correct(long)=" + correct);

        // ===== 5) 计算中“至少有一个 long/double”，才能整体提升 =====
        System.out.println(1 / 2);       // 0（int/int 还是 int）
        System.out.println(1 / 2.0);     // 0.5（有 double）

        //6)  == / equals
        // ==：比较“引用是否同一个对象”；equals：通常比较“内容”（String 重写了 equals）
        String a = "abc";
        String b = new String("abc");
        System.out.println(a == b);          // false（通常不是同一个对象）
        System.out.println(a.equals(b));     // true（内容相同）

        // null
        String n = null;
        System.out.println(n);               // 打印 null（别对 null 调方法，会 NPE）

    }
}
