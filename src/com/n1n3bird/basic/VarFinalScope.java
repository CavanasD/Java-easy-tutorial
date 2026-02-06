package com.n1n3bird.basic;

public class VarFinalScope {
    //常量，必须初始化
    static final double MY_AGE = 18;
    //类变量，从属于类
    static double monthSalary = 700000;
    //实例变量，从属于对象，如果不自行初始化，为默认值
    // (String 默认值为 null，int 默认值为 0, boolean 默认值为 false, char 默认值为 '\u0000')
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
    // 1) 类名/接口名：用大驼峰，名词，如 com.n1n3bird.basic.VarFinalScope。
    // 2) 方法名/变量名（实例变量、局部变量）：用小驼峰，动词/名词短语，如 test(), salary（若非静态常量）。
    // 3) 常量（static final）：UPPER_SNAKE_CASE（全大写+下划线），如 MY_AGE。
    // 4) 不要用拼音缩写/无意义缩写（a、b、tmp 除非很短作用域）；尽量表达含义。
    // 5) 布尔变量首选 is/has/can 开头：isEnabled、hasMoney、canRun。
    public void aTest() {

    }

}
