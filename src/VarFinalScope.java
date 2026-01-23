public class Var_and_Final {
    //常量，必须初始化
    final double myAge = 18;
    //类变量，从属于类
    static double salary = 700000;
    //实例变量，从属于对象，如果不自行初始化，为默认值
    // (String 默认值为 null，int 默认值为 0, boolean 默认值为 false, char 默认值为 '\u0000')
    String name;
    int age;
    char gender;
    public static void main(String[] args) {
        //局部变量，从属于方法，如果不自行初始化，则不能使用
        int number = 10;
        System.out.println(number);

        Var_and_Final varandFinal = new Var_and_Final();//
        System.out.println(varandFinal.name);
        System.out.println(varandFinal.age);
        System.out.println(varandFinal.gender);

    }

    public void test() {

    }

}
