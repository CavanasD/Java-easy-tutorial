#  
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
> [!caution] 
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
## 怎么调用？
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

# 0x7 Final Chapter——异常