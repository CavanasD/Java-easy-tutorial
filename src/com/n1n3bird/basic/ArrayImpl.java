package com.n1n3bird.basic;

public class ArrayImpl {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        printArrays(arr);
        System.out.println("-----reverse-----");
        printArrays(reverseArray(arr));
        int[][] TwoDimArr = {{1,2}, {3,4}, {5,6} };
        System.out.println("-----two dimension array-----");
        System.out.println(TwoDimArr.length);
        System.out.println(TwoDimArr[0].length);
        System.out.println(TwoDimArr[1][1]);
/*        arr[][0]   arr[][1]
            1          2      arr[0]
            3          4      arr[1]
            5          6      arr[2]
            */
    }
    public static int[] reverseArray(int[] arrays){
        int[] result = new int[arrays.length];
        for (int i =0;i<arrays.length;i++){
            result[i] = arrays[arrays.length -1 -i];
    }
        return result;
    }
    public static void printArrays(int[] arrays){
        for (int array : arrays) {
            System.out.println(array + " ");
        }
    }
}
