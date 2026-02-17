package com.n1n3bird.yichang;

public class Demo {
    // 异常笔记：
    // 1) Throwable 是所有异常/错误的父类：Error(程序通常不处理) vs Exception(可处理)。
    // 2) Exception 分为编译期异常(必须处理/throws)与运行时异常(可不处理，但会崩)。
    // 3) 处理方式：try-catch-finally；也可在方法上用 throws 抛给上层。
    // 4) throw 用于主动抛出异常；自定义异常继承 Exception 或 RuntimeException。

    public static void main(String[] args) {
        System.out.println("=== try-catch-finally ===");
        int result = safeDivide("10", "0");
        System.out.println("result = " + result);

        System.out.println("\n=== throws / throw / 自定义异常 ===");
        try {
            registerUser(" ");
        } catch (UserInputException e) {
            System.out.println("caught: " + e.getMessage());
        }

        System.out.println("\n=== 受检异常示例 ===");
        try {
            parsePositiveInt("-3");
        } catch (Exception e) {
            System.out.println("caught: " + e.getMessage());
        }
    }

    // 运行时异常示例：被 0 除会抛 ArithmeticException
    private static int safeDivide(String a, String b) {
        try {
            int x = Integer.parseInt(a);
            int y = Integer.parseInt(b);
            return x / y;
        } catch (NumberFormatException e) {
            System.out.println("输入不是数字: " + e.getMessage());
            return 0;
        } catch (ArithmeticException e) {
            System.out.println("除数不能为 0: " + e.getMessage());
            return 0;
        } finally {
            System.out.println("finally 一定会执行");
        }
    }

    // throws：把异常交给调用者处理
    private static int parsePositiveInt(String s) throws Exception {
        int v = Integer.parseInt(s);
        if (v <= 0) {
            throw new Exception("必须是正整数");
        }
        return v;
    }

    // throw：主动抛出自定义异常
    private static void registerUser(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new UserInputException("用户名不能为空");
        }
        System.out.println("注册成功: " + name);
    }
}

class UserInputException extends RuntimeException {
    public UserInputException(String message) {
        super(message);
    }
}
