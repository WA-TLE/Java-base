package com.dy.test.singleton01;

public class Singleton {

// 私有化构造方法

    private Singleton() {

    }

// 对外提供获取实例的公共方法

    public static Singleton getInstance() {

        return SingletonInner.INSTANCE;

    }

    private static class SingletonInner {

        private final static Singleton INSTANCE = new Singleton();
    }
}