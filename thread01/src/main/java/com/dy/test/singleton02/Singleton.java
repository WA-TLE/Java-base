package com.dy.test.singleton02;

public enum Singleton {
    INSTANCE;

    public void doSomething(String str) {
        System.out.println(str);
    }
}