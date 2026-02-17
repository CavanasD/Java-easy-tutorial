# Hello, Jvav 
注意，本笔记使用`jdk21`进行学习，前面的许多什么jdkjrejvm介绍，解释型语言与编译型语言的区别，java特性、优点、发展史，推荐观看[【狂神说Java】Java零基础学习视频通俗易懂]([https://www.bilibili.com/video/BV12J41137hu?p=23&vd_source=8ba8b48a842130e7e5302ef05a128736])
（本菜狗会一些C++，所以很多东西略讲）

# 开始的开始  
*Java才是世界上最好的语言！*
![[attachments/Pasted image 20260115231104.png]]
*What are you looking for? I'm just a Cute DUKE!*
![[attachments/Pasted image 20260115231113.png]]
# 0x1  Hello, World
```java
public class Main {  
    public static void main(String[] args) {  
        System.out.println("Hello,World!");  
    }  
}
```
非常简单
 # 0x2 数据类型 
> [!warning] 
> Java 是一种**强类型语言**，这意味着每个变量都必须声明其类型
> *==！！强类型！！==*
##  Primitive Type 原始类型

| **类型**  | **关键字**      | **大小 (Bit)** | **取值范围**           | **默认值**  | **备注**          |
| ------- | ------------ | ------------ | ------------------ | -------- | --------------- |
| **整数型** | `byte`       | 8            | -128 ~ 127         | 0        | 节省空间            |
|         | `short`      | 16           | -32,768 ~ 32,767   | 0        | 较少使用            |
|         | **`int`**    | 32           | -21亿 ~ 21亿         | 0        | **最常用**         |
|         | `long`       | 64           | -2^63 ~ 2^63-1     | 0L       | 需加 `L` 后缀       |
| **浮点型** | `float`      | 32           | 1.4E-45 ~ 3.4E38   | 0.0f     | 需加 `f` 后缀       |
|         | **`double`** | 64           | 4.9E-324 ~ 1.8E308 | 0.0d     | **最常用**         |
| **字符型** | `char`       | 16           | 0 ~ 65,535         | '\u0000' | 存储单个 Unicode 字符 |
| **布尔型** | `boolean`    | -            | `true` 或 `false`   | false    | 逻辑判断            |
## Reference Type 引用类型
- **类 (Class):** 如 `String`, `Integer` 或自定义类。
- **接口 (Interface):** 如 `List`, `Map`。
- **数组 (Array):** 如 `int[]`, `String[]`。
> [!tip]
> `String` 不是基本类型，它是一个对象。

## Type Conversion
### 自动类型转换（隐式）
小容量转大容量。 `byte` → `short` → `char` → `int` → `long` → `float` → `double`
```java
int i = 100;
double d = i; // 自动转换，d 为 100.0
```
### 强制类型转换（显式）
大容量转小容量，可能会导致溢出或精度丢失。
```java
double pi = 3.14;
int i = (int)pi; // i 为 3，小数部分丢失
```

```java
public class DataType {
    public static void main(String[] args) {
        // 举例几个需要注意的，int等就不再举例
        long worldPopulation = 8000000000L; // long型必须加L
        float price = 19.99f;               // float型必须加f
        char grade = 'A';                   // char用单引号
        boolean isJavaFun = true;

        // 字符串拼接
        String message = "Hello, Java!";
        
        System.out.println("Population: " + worldPopulation);
    }
}
```

### 不要使用浮点数进行比较！
```java
public class Main {  
    public static void main(String[] args) {  
        float num1 = 0.1f;  
        double num2 = 1.0/10;  
        System.out.println(num1 == num2);  
        System.out.println(num1);  
        System.out.println(num2);  
  // ===================================================
        float num3 = 1145141919810f;  
        float num4 = num3 + 1;  
        System.out.println(num3 == num4);  
        System.out.println(num3);  
        System.out.println(num4);  
    }  
}
```
现在来看一下这段代码运行结果应该是什么呢？
![[attachments/Pasted image 20260116122846.png]]
下断点也可以发现，num1就是0.1，num2也是0.1，而num3和num4显然不相等，这是为什么？
问了一下Gemini大手子
> [!note] 
> 浮点数在计算机底层是二进制存储的。  
> 十进制的 `0.1` 在二进制中是无限循环小数，无法精确存储。  
> `float` (32位) 和 `double` (64位) 的精度从不同位置截断。  
> `0.1f` 的存储值 ≈ `0.10000000149`  
> `0.1d` 的存储值 ≈ `0.1000000000000000055`
> 二者近似程度不同，所以不相等。
>  类似地，`float` 的有效数字（尾数）只有 23 位（加上隐含位共 24 位），约等于 7 位十进制数字。  
>  当数值非常大时（例如 10^12），相邻两个可表示的 float 数值之间的间隔（也叫 ULP）会变得很大（比如大于 1）  在这个量级下，`+1` 的变化太微小，无法体现在有限的尾数位中，从而被丢弃。

*==所以，大数计算请使用BigDecimal==*

# 0x3 变量、常量、作用域
## 直接上代码，没什么好说的
```java
public class VarFinalScope {  
    //常量，必须初始化  
    static final double MY_AGE = 18;  
    //类变量，从属于类  
    static double monthSalary = 700000;  
    //实例变量，从属于对象，如果不自行初始化，为默认值  
    /* (String 默认值为 null，
    int 默认值为 0, 
    boolean 默认值为 false, 
    char 默认值为 '\u0000')*/       
    String name;  
    int age;  
    char gender;  
    public static void main(String[] args) {  
        //局部变量，从属于方法，如果不自行初始化，则不能使用  
        int number = 10;  
        System.out.println(number);  
        // 在堆里创建一个对象、返回引用  
        VarFinalScope varfinalscope = new VarFinalScope();//  
        System.out.println(varfinalscope.name);  
        System.out.println(varfinalscope.age);  
        System.out.println(varfinalscope.gender);  
        System.out.println(MY_AGE);  
    }  
  
    public void aTest() {  
	  // LOL this is a empty Method :)
    }  
}
```
## 命名规范
1) 类名/接口名：用大驼峰，名词，如 VarFinalScope。  
2) 方法名/变量名（实例变量、局部变量）：用小驼峰，动词/名词短语，如 test(), salary（若非静态常量）。  
3) 常量（static final）：UPPER_SNAKE_CASE（全大写+下划线），如 MY_AGE。  
4) 不要用拼音缩写/无意义缩写（a、b、tmp 除非很短作用域）；尽量表达含义。  
5) 布尔变量首选 is/has/can 开头：isEnabled、hasMoney、canRun。  

# 0x4 运算符 
其实也没什么说的，跟别的语言也没什么区别
我就直接上代码，主要是math类
```java
public class Operator {  
    public static void main(String[] args) {  
        int a = 10;  
        int b = 20;  
        int c = 25;  
        int d = 30;  
        // + - * / % & ^ | ~ 都不必讲了，跟别的语言一样  
        // 三目运算符：条件 ? 值1 : 值2  
        int max = (a > b) ? a : b;  
        System.out.println("max(a,b) = " + max);  
        String msg = (d % 2 == 0) ? "d is even" : "d is odd";  
        System.out.println(msg);  
  
        // 位运算：& | ^ ~  （按二进制位运算）  
        int p = 6; // 0b0110  
        int q = 3; // 0b0011  
        System.out.println("p & q = " + (p & q)); // 2  
        System.out.println("p | q = " + (p | q)); // 7  
        System.out.println("p ^ q = " + (p ^ q)); // 5  
        System.out.println("~p    = " + (~p));    // 按位取反
  
        // 位移：<< 左移, >> 算术右移, >>> 逻辑右移（高位补0）  
        System.out.println("p << 1  = " + (p << 1));  
        System.out.println("p >> 1  = " + (p >> 1));  
        int neg = -8;  
        System.out.println("neg >> 1  = " + (neg >> 1));  
        System.out.println("neg >>> 1 = " + (neg >>> 1));  
  
        // 位运算复合赋值：&= |= ^= <<= >>= >>>=  
        int m = 12;  
        m &= 10;  
        m |= 3;  
        m ^= 5;  
        m <<= 1;  
        System.out.println("m(after bit ops) = " + m);  
  
        // Math 类  
        System.out.println("Math.abs(-7) = " + Math.abs(-7));  
        System.out.println("Math.max(a, b) = " + Math.max(a, b));  
        System.out.println("Math.min(a, b) = " + Math.min(a, b));  
        System.out.println("Math.pow(2, 10) = " + Math.pow(2, 10));  
        System.out.println("Math.sqrt(81) = " + Math.sqrt(81));  
  
        // random(): [0.0, 1.0)  
        double r = Math.random();  
        System.out.println("Math.random() = " + r);  
  
        // round/ceil/floor：四舍五入/向上取整/向下取整  
        double v = 12.34;  
        System.out.println("Math.round(12.34) = " + Math.round(v));      // long  
        System.out.println("Math.ceil(12.34)  = " + Math.ceil(v));       // double  
        System.out.println("Math.floor(12.34) = " + Math.floor(v));      // double  
    }  
}
```

## 闲散的东西讲讲
### 1. 包 (Package)

**核心目的：**
- **解决命名冲突**：避免不同开发者编写同名类导致程序崩溃。
- **访问控制**：配合访问修饰符（如 `protected`）控制类与成员的可见性。
- **代码管理**：将功能相似或相关的类逻辑化分类，便于维护。
    

**命名规范：**
>  **标准写法**：`com.公司名.项目名.模块名`

- **倒置域名**：使用公司域名反转形式（如 `com.google`），确保全球唯一性。 
- **全小写**：严禁使用大写字母或下划线。
- **层级清晰**：使用点号 `.` 分隔，反映物理文件夹结构。
    

**代码示例：**
```Java
package com.baidu.search.util; // 声明包：必须位于源文件非注释的第一行

import java.util.Scanner;       // 导入指定类（推荐）
import com.baidu.search.core.*;  // 通配符导入（不推荐，易引起命名冲突）

public class StringHelper {
    // 类体内容
}
```

### 2. JavaDoc (文档注释)

**主要用途：**

1. **自动生成 API**：通过工具直接生成 HTML 格式的标准化说明文档。
2. **IDE 智能提示**：在 IntelliJ IDEA 等编辑器中悬停时，可实时预览代码说明。

**常用标签表：**

|**标签**|**描述**|**适用范围**|
|---|---|---|
|`@author`|作者姓名|类、接口|
|`@version`|版本号|类、接口|
|`@since`|起始版本（如 JDK 1.8）|类、接口、方法|
|`@param`|**方法参数**说明|方法|
|`@return`|**返回值**说明|方法|
|`@throws`|异常抛出说明|方法|
|`@see`|参考链接/相关类|所有|

**规范示例：**
```java
/**
 * 演示 JavaDoc 及其标签使用的工具类。
 * <p>这个类展示了如何编写符合标准的文档注释。</p>
 *
 * @author CavanasD
 * @version 1.0
 * @since 1.8
 */
public class Calculator {

    /**
     * 计算两个整数的和。
     *
     * @param a 第一个加数
     * @param b 第二个加数
     * @return 两个整数相加的代数和
     * @throws ArithmeticException 如果计算过程中出现溢出或算术错误
     */
    public int manualAdd(int a, int b) {
        return a + b;
    }
}
```

**文档生成方式：**

**终端命令行：**
```Bash
javadoc -d docs -encoding UTF-8 -charset UTF-8 src/*.java
```
IDEA
 在 IntelliJ IDEA 中选择 `Tools` -> `Generate JavaDoc...`，并在 `Other command line arguments` 栏输入 `-encoding UTF-8 -charset UTF-8` 以防止中文乱码。

# 0x5 流程控制
其实还是没什么，跟C++那一套基本没什么区别for while if else dowhile switch
值得一说的就是Scanner的使用
```java
Scanner sc = new Scanner(System.in);
```

# 0x6 方法

## 何为方法？
在开始的开始，我们输出HelloWorld
用的是System.out.println() ，也就是System类的out对象的一个println方法
学过C++就不难理解了，其实不就是C++里面的函数嘛
定义、调用、重载，很好说了，跟C++没啥区别
```java
import java.nio.file.SimpleFileVisitor;  
import java.util.Scanner;  
  
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
  
        // 4. 递归计算阶乘 5! = 120        System.out.println("5的阶乘: " + factorial(5));  
  
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
  
    // 方法重载 (Overloading)    public static double add(double a, double b) {  
        return a + b;  
    }  
  
    // 可变参数 (VARARGS)，必须放在最后  
    public static void printNames(String... names) {  
        for (String name : names) {  
            System.out.print(name + " ");  
        }  
        System.out.println();  
    }  
  
    // 递归 (Recursion)    public static int factorial(int n) {  
        if (n == 1) {  
            return 1; // 递归头：程序停止调用的条件  
        } else {  
            return n * factorial(n - 1); // 递归体  
        }  
    }  
}
```

## 命令行传参
*知道有这么个东西应该就行了*
```java
public class CommandLine {  
    public static void main(String[] args) {  
        for (int i = 0; i < args.length; i++) {  
            System.out.println("args[" + i + "]=" + args[i]);  
        }  
    }  
}
```
![[attachments/Pasted image 20260123225511.png]]

## 可变参数
```java
public class VariableArgs {  
    public static void main(String[] args) {  
        PrintMax(new double[]{1.2, 3.4, 5.6});  
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
}
```
## 递归
这里也没什么可说的，demo里我写了个factorial，非常简单，看一下就行

# 0x5 数组
## Array 声明与创建

```java
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
        int sum = 0;  
        for (int i = 0; i < numbers.length; i++) {  
            sum += numbers[i];  
        }  
        System.out.println("数组的和是：" + sum);  
    }  
}
```


## Java 内存布局

### 栈 
- **存储内容**：
    - **基本变量类型**：直接存放该类型的具体数值。
    - **引用对象变量**：存放该引用在堆里的具体地址。
- **特点**：线程私有。
### 堆
- **存储内容**：存放 **new 出来的对象和数组**。
- **特点**：
    - **线程共享**：可以被所有线程共享。
    - 不会存放别的对象引用。

### 方法区 
- **存储内容**：包含所有的 **class** 和 **static** 变量。
- **特点**：**线程共享**，可以被所有线程共享。

### 栈与堆区别

| 维度 | 栈 (Stack) | 堆 (Heap) |
| :--- | :--- | :--- |
| **管理方式** | 自动分配与释放（入栈/出栈） | 垃圾回收器 (GC) 手动/自动管理 |
| **存储内容** | 局部变量、方法调用链 | 对象实体、成员变量 |
| **可见性** | 线程私有 | 线程共享 |
| **空间连续性** | 连续空间，速度快 | 不连续空间，碎片化 |

## 数组初始化

### 1. 静态初始化
- **特点**：声明同时直接赋值，最简洁。
```java
int[] arr = {1, 2, 3};
```
## 2. 动态初始化 (指定长度)
- **特点**：只分配内存空间，系统赋默认值（如 0 或 null，跟变量初始化一样）。

```java
int[] arr = new int[5];
```

## 3. 动态初始化 (指定内容)
- **特点**：明确指定内容，常用于不声明变量直接传递数组参数。
```java
int[] arr = new int[]{1, 2, 3};
```

## 数组使用

在Demo里写了遍历反转、打印，知道array.length即可
### 二维数组
跟C/C++没什么区别
只要注意下标

## Arrays 类
数组的工具类`java.util.Arrays`
由于数组对象本身并没有什么方法可以供我们调用，但API中提供了一个工具类Arrays供我们使用，从而可以对数据对象进行一些基本的操作。
 [jdk21帮助文档](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Arrays.html)
 Arrays类中的方法都是static修饰的静态方法，在使用的时候可以直接使用类名进行调用，而“不用“使用对象来调用（注意：是“不用“而不是“不能"）
具有以下常用功能：
- 给数组赋值：通过filI方法。
- 对数组排序：通过sort方法，按升序。
- 比较数组：通过equals方法比较数组中元素值是否相等。
- 查找数组元素：通过binarySearch方法能对排序好的数组进行二分查找法操作。
还是上代码重要
```java
import java.util.Arrays;  
  
public class ArraysClass {  
  
    public static void main(String[] args) {  
        int[] arr = {1, 3, 4, 55, 3, 3, 21, 6, 7, 8, 9};  
  
        // 1. 打印数组内容 Arrays.toString()        System.out.println("Original (hashcode): " + arr);  
        System.out.println("Arrays.toString(): " + Arrays.toString(arr));  
  
        // 2. 排序 Arrays.sort()        Arrays.sort(arr);  
        System.out.println("Sorted: " + Arrays.toString(arr));  
  
        // 3. 二分查找 Arrays.binarySearch() (必须先排序)  
        // 返回索引，如果没找到返回 (-(插入点) - 1)  
        int index = Arrays.binarySearch(arr, 55);  
        System.out.println("Index of 55: " + index);  
  
        // 4. 填充数组 Arrays.fill()        int[] arr2 = new int[5];  
        Arrays.fill(arr2, 10);  
        System.out.println("Filled arr2: " + Arrays.toString(arr2));  
        Arrays.fill(arr2, 1, 4, 20); // 填充部分区间 [1, 4)        System.out.println("Partially filled arr2: " + Arrays.toString(arr2));  
        // 5. 比较数组 Arrays.equals()        int[] arr3 = {10, 10, 10, 10, 10};  
        System.out.println("arr2 equals arr3: " + Arrays.equals(arr2, arr3));  
  
        // 6. 复制数组 Arrays.copyOf()        // 扩容或截断时常用  
        int[] copy = Arrays.copyOf(arr, 3);  
        System.out.println("Copy of first 3: " + Arrays.toString(copy));  
    }  
}
```
### 冒泡排序
```java
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
```
写代码要优雅，这个唯一的优化方法可以是加一个`boolean flag = false;` 这样可以避免已经排序好的浪费时间
### 稀疏数组(Sparse Arrays)
当一个数组中大部分元素为0，或者为同一值的数组时，可以使用稀疏数组来保存该数组。
稀疏数组的处理方式是：
记录数组一共有几行几列，有多少个不同值
把具有不同值的元素和行列及值记录在一个小规模的数组中，从而缩小程序的规模
如下图：左边是原始数组，右边是稀疏数组
$$  
A =   
\begin{bmatrix}  
0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\  
0 & 0 & 1 & 0 & 0 & 0 & 0 & 0 \\  
0 & 0 & 0 & 2 & 0 & 0 & 0 & 0 \\  
0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\  
0 & 0 & 0 & 0 & 0 & 2 & 0 & 0 \\  
0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\  
0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\  
0 & 0 & 0 & 0 & 0 & 0 & 0 & 0   
\end{bmatrix}  
$$
![[attachments/7abb62bdfffe86abb62a902fcf59de4f.png]]

```java
public class SparseArray {  
    public static void main(String[] args) {  
  
        int[][] chessArr1 = new int[8][8];  
        chessArr1[1][2] = 1;  
        chessArr1[2][3] = 2;  
        chessArr1[4][5] = 2;  
          
        System.out.println("原始的二维数组~~");  
        for (int[] row : chessArr1) {  
            for (int data : row) {  
                System.out.printf("%d\t", data);  
            }  
            System.out.println();  
        }  
  
        // 将二维数组 转 稀疏数组  
        // 遍历二维数组 得到非0数据的个数  
        int sum = 0;  
        for (int i = 0; i < 8; i++) {  
            for (int j = 0; j < 8; j++) {  
                if (chessArr1[i][j] != 0) {  
                    sum++;  
                }  
            }  
        }  
        int[][] sparseArr = new int[sum + 1][3];  
        sparseArr[0][0] = 8;  
        sparseArr[0][1] = 8;  
        sparseArr[0][2] = sum;  
  
        // 遍历二维数组，将非0的值存放到 sparseArr中  
        int count = 0; //count 用于记录是第几个非0数据  
        for (int i = 0; i < 8; i++) {  
            for (int j = 0; j < 8; j++) {  
                if (chessArr1[i][j] != 0) {  
                    count++;  
                    sparseArr[count][0] = i;  
                    sparseArr[count][1] = j;  
                    sparseArr[count][2] = chessArr1[i][j];  
                }  
            }  
        }  
        System.out.println();  
        System.out.println("得到的稀疏数组为~~");  
        for (int[] row : sparseArr) {  
            for (int data : row) {  
                System.out.printf("%d\t", data);  
            }  
            System.out.println();  
        }  
        // 还原  
        // 读取l1  
        int[][] newChessArr = new int[sparseArr[0][0]][sparseArr[0][1]];  
  
        // 读取all  
        for (int i = 1; i <= sum; i++) {  
            int row = sparseArr[i][0];  
            int col = sparseArr[i][1];  
            int value = sparseArr[i][2];  
            newChessArr[row][col] = value;  
        }  
  
        // 还原  
        System.out.println();  
        System.out.println("还原后的二维数组~~");  
        for (int[] row : newChessArr) {  
            for (int data : row) {  
                System.out.printf("%d\t", data);  
            }  
            System.out.println();  
        }  
    }  
}
```
跑一下
![[attachments/Pasted image 20260206214700.png]]
哦吼，跑出来了
看着很赏心悦目
![[attachments/Pasted image 20260206214858.png]]
后续会写篇博客美化？

# 0x6 面向对象
## 对比一下我们学过的POP和OOP
**面向过程思想**
	步骤清晰简单，第一步做什么，第二步做什么.
	面对过程适合处理一些较为简单的问题
**面向对象思想**
	物以类聚，分类的思维模式，思考问题首先会解决问题需要哪些分类，然后对这些分类进行单独思考。最后，才对某个分类下的细节进行面向过程的思索。
	面向对象适合处理复杂的问题，适合处理需要多人协作的问题！

OOP本质：**以类的方式组织代码，以对象的组织封装数据**
三大特性：封装继承多态

## 你再看看方法呢
### 怎么调用？
注意非static要实例化就行了
### 参数传递
我写了例子
```java
package com.n1n3bird.oop;  
  
import static com.n1n3bird.oop.Student.changeNameToNailong;  
  
public class FunnyArgs {  
    public static void main(String[] args) {  
        // 值传递  
        int a = 1;  
        System.out.println(a);  
        changeValue(a);  
        System.out.println(a);  
        //引用传递  
        Student n1n3bird = new Student();  
        System.out.println(n1n3bird.name);  
        changeNameToNailong(n1n3bird);  
        System.out.println(n1n3bird.name);  
    }  
  
    private static void changeValue(int a) {  
        a = 100;  
    }  
}
```

```java
package com.n1n3bird.oop;  
  
public class Student{  
    String name;  
  
    public static void changeNameToNailong(Student stu) {  
        stu.name = "Nailong";  
    }  
    
}
```
![[attachments/Pasted image 20260206233552.png]]
ok，看输出结果，相当显然，传值和传对象显然不同
也就是说，简单记忆一下：
传`Array` `Object` `String`等是会改变原有内容的，这叫`引用传递`
传一些基本类型`int` `boolean` `char` 等，不会改变原有内容，这叫`值传递`（跟当时基本数据类型、引用数据类型也差不多）

## 类与对象创建
### 先看看怎么创建
![[attachments/Pasted image 20260207220213.png]]
没必要说了，至于this，后面会讲
### 构造器
使用new关键字创建的时候，除了分配内存空间之外，还会给创建好的对象 进行默认的初始化以及对类中构造器的调用（一个类即使什么也不写，）
类中的`构造器`也称为`构造方法`，是在进行创建对象的时候必须要调用的。并且构造器有以下2个特点:
1. 必须和类的名字相同
2. 必须没有返回类型,也不能写void
![[attachments/Pasted image 20260207233906.png]]
注意看我的注释
`Alt` + `INSERT` 可以快速生成构造函数
- 内存部分这里暂时不再叙述，我只是想把这份note作为简单的语言笔记

## 封装
### 高内聚，低耦合
- 高内聚就是类的内部数据操作细节自己完成，不允许外部干涉;低耦合:仅暴露少量的方法给外部使用。
### 封装(数据的隐藏)
- 通常，应禁止直接访问一个对象中数据的实际表示，而应通过操作接口来访问，这称为信息隐藏。

![[attachments/Pasted image 20260209001259.png]]
随便写几个get/set(`Alt` + `INSERT` 可以快速生成)
跑一下，为什么输出是Nailong\n Nailong呢？
事实上，虽然修改了 ZhiQiao 这个对象的内部属性，但是 hackerName这个变量仍然指向之前的旧字符串  （字符串在 Java 中是不可变的，且变量不会自动跟随  
对象属性变化而更新）  
 
## 继承
看demo就好，extends关键字
> [!tip] 
Java里只有单继承

![[attachments/Pasted image 20260210223951.png]]
欸我们发现这里怎么这么多方法？其实，java中，所有的类都默认继承Object

## Super关键字
super注意点：
1. super调用父类的构造方法，必须在构造方法的第一个
2. super必须只能出现在子类的方法或者构造方法中！
3. super和this不能同时调用构造方法！
和this什么区别？
代表的对象不同：
	this:
	本身调用者这个对象
	super:
	代表父类对象的应用
前提
	this：没继承也可以使用
	super：只能在继承条件才可以使用

## 方法重写
![[attachments/Pasted image 20260211172057.png]]
先运行一下，发现结果如图（这个是static，所以不会自动重写）
![[attachments/Pasted image 20260211163558.png]]
那如果我们重写呢？
方法的调用只和左边的数据类型有关系

```java
package com.n1n3bird.oop.override;  
  
public class ExampleA extends ExampleB {  
  
    public static void test(){  
        System.out.println("A test");  
    }  
    @Override  
    public void test2(){  
        System.out.println("A test2");  
    }  
}
```
这样就重写啦，输出发现两个输出都是A test2
- 卧槽，这么难，好难分辨，实际上
- **静态方法是类的方法，非静态是对象的方法**
哈哈，这不就懂了
重写：需要有继承关系，子类重写父类的方法！
1. 方法名必须相同
2. 参数列表列表必须相同
3. 修饰符：范围可以扩大但不能缩小public>Protected>Default>private
4. 抛出的异常：范围，可以被缩小，但不能扩大；ClassNotFoundException>Exception(大）
重写，子类的方法和父类必要一致；方法体不同！
## 多态
### 方法调用规则（针对成员方法）：
编译看左边：编译器检查引用类型（等号左边的类）中是否有该方法。如果没有，编译报错（如代码中的 n1n3bird.hack()，因为 Person 类中没有 hack 方法）。
运行看右边：实际运行时，执行的是实际对象类型（等号右边的类）中重写的方法。如果子类重写了父类方法，则执行子类的方法；如果没重写，则执行父类的方法。
### 成员变量规则：
编译看左边，运行也看左边：多态只针对方法。如果是访问成员变量，编译器看引用类型，运行时获取的也是引用类型中的变量值，不看实际对象。
### 多态的三大前提：
有继承关系（Hacker extends Person）。
有方法重写（Hacker 重写了 run()）。
父类引用指向子类对象（Person p = new Hacker();）。

这个直接看demo里，强制转换
![[attachments/Pasted image 20260212204347.png]]

## instanceof 和类型转换
看一下多态的demo
```java
/*  
instanceof 关键字简单笔记:  
1. 作用：测试左边的对象是否是右边类的实例（或者是其子类的实例）。  
2. 返回值：boolean 类型 (true/false)。  
3. 编译通过条件：X instanceof Y，X 的引用类型与 Y 之间必须有父子关系，否则编译报错。  
4. 运行结果：看 X 实际指向的对象是不是 Y 类型的子类/实现类。  
*/  
  
// System.out.println(X instanceof Y); // 能不能编译通过？ -> X的引用类型 与 Y 是否有父子关系  
// 结果是 true 还是 false？ -> X实际指向的对象 是不是 Y 的子类型  
  
// Object > Person > Hacker  
// Object > String  
// Teacher (假设有)  
  
System.out.println(klare instanceof Hacker); // true  
System.out.println(klare instanceof Person); // true  
System.out.println(klare instanceof Object); // true  
System.out.println(klare instanceof String); // false  
  
System.out.println(n1n3bird instanceof Hacker); // true  
System.out.println(n1n3bird instanceof Person); // true  
System.out.println(n1n3bird instanceof Object); // true  
// System.out.println(n1n3bird instanceof String); // 编译报错！Person 和 String 没关系  
  
System.out.println(shyler instanceof Hacker); // true  
System.out.println(shyler instanceof Person); // true  
System.out.println(shyler instanceof Object); // true  
// System.out.println(shyler instanceof String); // 编译报错！Hacker 和 String 没关系
```
## static
学到这，其实快学完了，但是static是不是还是有点蒙？毕竟离最开始的声明变量也有点远了
其实就是初始化的时候是否加载，非static需要有对象哦
- 加了 static：它是跟着类走的。类加载了它就有了，大家共用一份，不用 new 对象也能用。
- 没加 static：它是跟着对象走的。必须先 new 出来一个对象，它才存在，每个对象各有一份。
### 让Gemini大手子教一教我

==static 修饰符用于创建类变量和类方法，它让属性和方法属于类本身，而不是属于某个具体的对象。==
- 静态变量 (Static Variables):
	被 static 修饰的变量，在内存中只有一份，会被所有对象共享。
	推荐访问方式：类名.变量名 (例如 DaShen.age)。
- 静态方法 (Static Methods):
	可以通过 类名.方法名() 直接调用。
- 重要限制：静态方法中不能直接调用非静态的方法或变量（因为它不依赖于对象存在，而非静态成员必须依赖对象）。
- 代码块执行顺序 
	静态代码块 (static { ... }): 类加载时执行，且只执行一次。通常用于初始化静态资源。
	匿名代码块 ({ ... }): 每次创建对象（new）时都会执行，且在构造器之前执行。可以用来赋初值。
- 构造方法: 创建对象时执行，在匿名代码块之后。
	执行顺序总结：静态代码块 (一次) -> 匿名代码块 (多次) -> 构造方法 (多次)。
- 静态导入 (Static Import):
	用于导入类中的静态成员，导入后可以直接使用方法名或变量名，无需加类名。
	语法：import static 包名.类名.静态成员; 或 import static 包名.类名.* ;
	例如：import static java.lang.Math.random; 后，可直接写 random()。
Talk is Cheap, Show me the code，
```Java
package com.n1n3bird.oop.fuckustatic;  
  
// 静态导入包  
import static java.lang.Math.random;  
import static java.lang.Math.PI;  
  
public class DaShen {  
    private static int age;  
    private double score;  
  
    public void run() {  
        go(); // 非静态方法可以调用静态方法  
    }  
    public static void go() {  
        System.out.println("go");  
        // run(); // 静态方法不可以调用非静态方法  
    }  
    // 匿名代码块：创建对象时创建，在构造器之前  
    {  
        System.out.println("匿名代码块");  
    }  
  
    // 静态代码块：类加载一刻执行，永久只执行一次  
    static {  
        System.out.println("静态代码块");  
    }  
  
    // 构造方法  
    public DaShen() {  
        System.out.println("构造方法");  
    }  
  
    public static void main(String[] args) {  
        new DaShen();  
        System.out.println("==================");  
        new DaShen();  
        System.out.println("==================");  
        System.out.println(random());  
        System.out.println(PI);  
    }  
}
```
## 抽象类

不能 new：抽象类本质是约束，不能直接 new 出来，只能 new 它的子类。
抽象方法：public abstract void doSomething();
只有方法名字，没有方法体（没有花括号 {}）。
必须存在于抽象类中。
子类的责任：继承了抽象类的非抽象子类，**必须重写（实现）** 所有的抽象方法。
共存：抽象类里可以写普通方法（哪怕它不能被 new，子类继承后也能直接用这些普通方法）。 
```java
public abstract class Action {  
  
    // 抽象方法，只有方法名字，没有方法的实现！  
    public abstract void doSomething();  
  
    // 1. 不能new这个抽象类，只能靠子类去实现它：约束！  
    // 2. 抽象类中可以写普通的方法~  
    // 3. 抽象方法必须在抽象类中~  
    // 抽象的抽象：约束~  
    public void sayHello() {  
        System.out.println("Hello");  
    }  
}
```

```java
public class A extends Action {  
    @Override  
    public void doSomething() {  
        System.out.println("A doSomething");  
    }  
}
```

## 接口定义、实现
interface
```java
package com.n1n3bird.oop.jiekou;  
  
public interface UserService {  
    // 定义方法都是 public abstract 的  
    void addUser();  
    void deleteUser();  
    void updateUser();  
    void queryUser();  
    // 定义变量则都是 public static final    public static final String name = "n1n3bird";  
}
```

```java
package com.n1n3bird.oop.jiekou;  
// Ctrl + i 实现接口的快捷键  
// 接口可以实现多继承，类只能单继承~  
public class UserServiceImpl implements  UserService,TimeService {  
    @Override  
    public void deleteUser() {  
  
    }  
    @Override  
    public void updateUser() {  
  
    }  
    @Override  
    public void queryUser() {  
  
    }  
    @Override  
    public void addUser() {  
        System.out.println("添加用户");  
    }  
}
```

关键字：**契约** 、**规范**

## 内部类
看demo就可以
```java
package com.n1n3bird.oop.InsiderClass;  
  
public class OuterClass {  
  
    private int id = 10;  
    public void out() {  
        System.out.println("这是外部类的方法");  
    }  
  
    // 1. 成员内部类  
    public class Inner {  
        public void in() {  
            System.out.println("这是内部类的方法");  
        }  
  
        // 获得外部类的私有属性  
        public void getID() {  
            System.out.println(id);  
        }  
    }  
  
    // 2. 静态内部类  
    public static class StaticInner {  
        public void in() {  
            System.out.println("这是静态内部类的方法");  
        }  
    }  
  
    // 3. 局部内部类  
    public void method() {  
        class LocalInner {  
            public void in() {  
                System.out.println("这是局部内部类的方法");  
            }  
        }  
    }  
  
}  
// 4. 匿名内部类（没有名字初始化类，不用将实例保存到变量中）  
class Test {  
    public static void main(String[] args) {  
        // 成员内部类实例化  
        OuterClass outer = new OuterClass();  
        // 通过外部类对象来实例化内部类  
        OuterClass.Inner inner = outer.new Inner();  
        inner.in();  
        inner.getID();  
        // 静态内部类实例化  
        // 静态内部类可以直接实例化，不需要外部类对象  
        // 注意：静态内部类无法直接访问外部类的非静态属性  
        OuterClass.StaticInner staticInner = new OuterClass.StaticInner();  
        staticInner.in();  
        // 匿名内部类  
        // 没有名字初始化类, 不用实例保存到变量中  
        new Apple().eat();  
        // 也可以实现接口  
        new UserService() {  
            @Override  
            public void hello() {  
                System.out.println("Hello from Anonymous Inner Class");  
            }  
        };  
    }  
}  
  
class Apple {  
    public void eat() {  
        System.out.println("1");  
    }  
}  
  
interface UserService {  
    void hello();  
}
```

# 0x7 Final Chapter——异常

## Error & Exception
Java把异常当作对象来处理，并定义一个基类java.lang.Throwable作为所有异常的超类。
在JavaAPl中已经定义了许多异常类，这些异常类分为两大类，错误Error和异常Exception
![[attachments/Pasted image 20260217233625.png]]
- 检查性异常：最具代表的检查性异常是用户错误或问题引起的异常，这是程序员无法预见的。
	例如要打开一个不存在文件时，一个异常就发生了，这些异常在编译时不能被简单地忽略。
- 运行时异常：运行时异常是可能被程序员避免的异常。与检查性异常相反，运行时异常可以在编译时被忽略。
- 错误：错误不是异常，而是脱离程序员控制的问题。错误在代码中通常被忽略。例如，当栈溢出时，一个错误就发生了，它们在编译也检查不到的
- Error类对象由Java虚拟机生成并抛出大多数错误与代码编写者所执行的操作无关。
- Java虚拟机运行错误(VirtualMachineError)，当JVM不再有继续执行操作所需的内存资源时，将出现OutOfMemoryError。这些异常发生时，Java虚拟机(JVM)一般会选择线程终止；
- 
还有发生在虚拟机试图执行应用时，如:
	类定义错误（NoClassDefFoundError）、链接错误（LinkageError）。这些错误是不可查的，因为它们在应用程序的控制和处理能力之外，而且绝大多数是程序运行时不允许出现的状况

在Exception分支中有一个重要的子类RuntimeException(运行时异常）
- ArrayIndexOutOfBoundsException(数组下标越界) 
- NullPointerException(空指针异常)
- ArithmeticException(算术异常)
- MissingResourceException(丢失资源)
- ClassNotFoundException（找不到类）等异常，这些异常是不检查异常，程序中可以选择捕获处理，也可以不处理。
	这些异常一般是由程序逻辑错误引起的，程序应该从逻辑角度尽可能避免这类异常的发生；
	
Error和Exception的区别：
	Error通常是灾难性的致命的错误，是程序无法控制和处理的，当出现这些异常时，JVM一般会选择终止线程；Exception通常情况下是可以被程序处理的，并且在程序中应该尽可能的去处理这些异常。
## 捕获和抛出异常
```java
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
  
    // 运行时异常示例：被 0 除会抛 ArithmeticException    private static int safeDivide(String a, String b) {  
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
```

# 完结有感
也算是用了大半个假期的时间，从头听了一遍Java SE，以前写mod接触过一些，不过现在看来当时还是皮毛，哈哈
收获很大，结合着C++的概念理解， JavaSE并不难，可能OOP部分有些地方稍微有点绕
## 纸上得来终觉浅，绝知此事要躬行
继续加油！

Finished By N1n3Bird -- 2026/2/17 大年初一![[attachments/7D963EA950DF100577AEA3CC87EF49F9.gif]]![[attachments/firefly.png]]流萤可爱喵