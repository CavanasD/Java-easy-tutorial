package com.n1n3bird.basic;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        bubbleSort(arr);
        System.out.println("排序后的数组：" + Arrays.toString(arr));

    }
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            boolean flag = false;
            for(int j = 0; j < arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
}
