package com.n1n3bird.basic;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] numbers;
        numbers = new int[5];
        int l = numbers.length;
        System.out.println("数组的长度是：" + l);
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 4;
        numbers[4] = 5;
        System.out.println(numbers[5]);
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("数组的和是：" + sum);
    }
}
