package com.dy.thread.wait_and_notify;

/**
 * @Author: dy
 * @Date: 2024/9/18 19:49
 * @Description:
 */
public class MyThread02 implements Runnable{

    private Object object = new Object();

    @Override
    public void run() {
        synchronized (Main.class) {
            object.notify();
            System.out.println(Thread.currentThread().getName() + "获得对象锁，执行中，调用了共享对象的notify()方法");
        }
    }
}
