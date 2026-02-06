package com.n1n3bird.basic;

import java.util.Arrays;

public class ArraysClass {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 55, 3, 3, 21, 6, 7, 8, 9};

        // 1. 打印数组内容 Arrays.toString()
        System.out.println("Original (hashcode): " + arr);
        System.out.println("Arrays.toString(): " + Arrays.toString(arr));

        // 2. 排序 Arrays.sort()
        Arrays.sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));

        // 3. 二分查找 Arrays.binarySearch() (必须先排序)
        // 返回索引，如果没找到返回 (-(插入点) - 1)
        int index = Arrays.binarySearch(arr, 55);
        System.out.println("Index of 55: " + index);

        // 4. 填充数组 Arrays.fill()
        int[] arr2 = new int[5];
        Arrays.fill(arr2, 10);
        System.out.println("Filled arr2: " + Arrays.toString(arr2));
        Arrays.fill(arr2, 1, 4, 20); // 填充部分区间 [1, 4)
        System.out.println("Partially filled arr2: " + Arrays.toString(arr2));
        // 5. 比较数组 Arrays.equals()
        int[] arr3 = {10, 10, 10, 10, 10};
        System.out.println("arr2 equals arr3: " + Arrays.equals(arr2, arr3));

        // 6. 复制数组 Arrays.copyOf()
        // 扩容或截断时常用
        int[] copy = Arrays.copyOf(arr, 3);
        System.out.println("Copy of first 3: " + Arrays.toString(copy));
    }
}
