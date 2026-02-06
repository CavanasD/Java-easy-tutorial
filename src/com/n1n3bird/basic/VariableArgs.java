package com.n1n3bird.basic;

public class VariableArgs {
    public static void main(String[] args) {

        PrintMax(new double[]{1.2, 3.4, 5.6});
        System.out.println(factorial(5));
    }

    public static void PrintMax(double... numbers){
        if (numbers.length ==0){
            System.out.println("No argument passed");
            return ;
        }
        double max = numbers[0];
        for (int i=1;i < numbers.length;i++){
            if (numbers[i]>max){
                max = numbers[i];
            }
        }
        System.out.println("最大值是：" + max);
    }
    // 写个简单的递归吧
    public static int factorial(int n){
        if (n ==1){
            return(1);
        }else {
            return(n * factorial(n-1));
        }
    }

}

