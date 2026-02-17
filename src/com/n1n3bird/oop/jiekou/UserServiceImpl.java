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
