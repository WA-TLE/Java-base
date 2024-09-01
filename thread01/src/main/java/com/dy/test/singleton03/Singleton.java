package com.dy.test.singleton03;

public class Singleton {
    private volatile static Singleton uniqueInstance;

    // 私有化构造⽅法
    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
//先判断对象是否已经实例过，没有实例化过才进⼊加锁代码
        if (uniqueInstance == null) {
//类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}