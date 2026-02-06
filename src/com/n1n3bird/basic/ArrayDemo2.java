package com.n1n3bird.basic;

public class ArrayDemo2 {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50};
        int[] nnnums = new int[]{1, 2, 3, 4, 5, 6};
        int[] nnnnums = new int[50000000];
        String[] string = new String[666];
        System.out.println(nums.length);
        System.out.println(nnnums.length);
        System.out.println(nnnnums.length);
        System.out.println(nnnnums[114514]); // 显然，默认初始化之后值为 0
        System.out.println(string[0]);
    }
}

