package com.dy.thread.create.thread02;

/**
 * @Author: dy
 * @Date: 2024/4/24 10:36
 * @Description:
 */
public class MyRunnable implements Runnable{
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
    }
}
