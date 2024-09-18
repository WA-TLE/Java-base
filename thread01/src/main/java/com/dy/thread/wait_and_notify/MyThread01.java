package com.dy.thread.wait_and_notify;

/**
 * @Author: dy
 * @Date: 2024/9/18 19:49
 * @Description:
 */
public class MyThread01 implements Runnable{

    private Object object = new Object();

    @Override
    public void run() {
        synchronized (Main.class) {
            System.out.println(Thread.currentThread().getName() + "初次获得对象锁，执行中，调用共享对象的wait()方法...");
            try {
                object.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "再次获取对象锁...");
        }
    }
}
