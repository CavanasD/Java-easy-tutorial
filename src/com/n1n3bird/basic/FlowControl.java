package com.n1n3bird.basic;

import java.util.Scanner;

public class FlowControl {
    public static void main(String[] args) {
        // 1. Scanner 使用 (进阶 hasNext)
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个整数验证: ");
        //TIP hasNextXxx() 用于判断输入流中是否有指定类型的数据，避免 InputMismatchException
        if (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            System.out.println("用户输入了整数: " + i);
        } else {
            System.out.println("用户没有输入整数。");
            String trash = scanner.next(); //虽然不是整数，但要读取出来清空缓冲区
            System.out.println("跳过内容: " + trash);
        }

        // 2. Switch 语句 (支持 break 穿透)

        System.out.println("\n2. 请输入等级 (A, B, C): ");

        String grade = "B";

        switch (grade) {
            case "A":
                System.out.println("优秀");
                break;
            case "B":
                System.out.println("良好");
                // 如果不写break会怎样？

            case "C":
                System.out.println("及格 (因B级穿透也会打印此行)");
                break;
            case "D":
                System.out.println("不及格");
                break;
            default:
                System.out.println("未知等级");
        }

        // 3. While & Do-While

        int count = 0;
        while (count < 3) {
            System.out.print("While run " + count + " | ");
            count++;
        }
        System.out.println();

        // do-while 至少执行一次，即使条件一开始就不满足
        do {
            System.out.println("Do-While 至少执行一次");
        } while (false);

        // 4. For 循环 & 99乘法表

        // 嵌套循环实现二维输出
        for (int r = 1; r <= 9; r++) {
            for (int c = 1; c <= r; c++) {
                // \t 是制表符，对齐用
                System.out.print(c + "*" + r + "=" + (r * c) + "\t");
            }
            System.out.println();
        }

        // 5. 打印个三角形试试？
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 6. Break, Continue & Goto (Label)
        // 普通 break/continue
        for (int i = 0; i < 5; i++) {
            if (i == 1) continue; // 跳过本次循环
            if (i == 3) break;    // 终止循环
            System.out.print(i + " "); // 输出 0 2
        }
        System.out.println();

        // Java 没有 goto，但可以使用 Label (标签) 配合 break/continue 实现跳转
        // 多用于跳出多重嵌套循环
        outerLoop: // 定义标签
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    System.out.println("遇到 i=1,j=1，跳出最外层循环 (goto style)");
                    break outerLoop; // 跳出 outerLoop 标签所在的循环
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }

        // 这里的代码会在 break outerLoop 后执行
        System.out.println("程序结束");

        // 记得关闭资源
        scanner.close();
    }
}
