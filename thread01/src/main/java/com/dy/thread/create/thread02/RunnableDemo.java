package com.dy.thread.create.thread02;

/**
 * @Author: dy
 * @Date: 2024/4/24 10:33
 * @Description:
 */
public class RunnableDemo {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread dy = new Thread(myRunnable, "dy");
        Thread yx = new Thread(myRunnable, "yx");

        dy.start();
        yx.start();


    }


}
