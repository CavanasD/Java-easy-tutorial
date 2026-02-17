package com.n1n3bird.oop.jiekou;

public interface UserService {
    // 定义方法都是 public abstract 的
    void addUser();
    void deleteUser();
    void updateUser();
    void queryUser();
    // 定义变量则都是 public static final
    public static final String name = "n1n3bird";
}
