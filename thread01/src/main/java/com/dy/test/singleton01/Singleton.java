package com.dy.test.singleton01;

public class Singleton {

    // 私有化构造方法
    private Singleton() {

    }

    // 提供公共获取实例的方法
    public static Singleton getInstance() {
        return SingletonInner.INSTANCE;
    }

    private static class SingletonInner{
        private final static Singleton INSTANCE = new Singleton();
    }

}