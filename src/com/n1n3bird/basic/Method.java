package com.n1n3bird.basic;

public class Method {
    public static void main(String[] args) {
        // 1. 调用普通方法
        int result = add(10, 20);
        System.out.println("整数和: " + result);

        // 2. 调用重载方法（根据参数类型自动匹配）
        double result2 = add(10.5, 20.5);
        System.out.println("小数和: " + result2);

        // 3. 调用可变参数方法
        printNames("Alice", "Bob", "Charlie");

        // 4. 递归计算阶乘 5! = 120
        System.out.println("5的阶乘: " + factorial(5));

        //命令行传参
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "]" +args[i]);

        }
    }

    // 方法定义
    public static int add(int a, int b) {
        int result = a + b;
        return result;
    }

    // 方法重载 (Overloading)
    public static double add(double a, double b) {
        return a + b;
    }

    // 可变参数 (VARARGS)，必须放在最后
    public static void printNames(String... names) {
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();
    }

    // 递归 (Recursion)
    public static int factorial(int n) {
        if (n == 1) {
            return 1; // 递归头：程序停止调用的条件
        } else {
            return n * factorial(n - 1); // 递归体
        }
    }
}


