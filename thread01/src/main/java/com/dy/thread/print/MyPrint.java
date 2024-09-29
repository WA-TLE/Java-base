package com.dy.thread.print;

/**
 * @Author: dy
 * @Date: 2024/9/18 20:07
 * @Description:
 */
public class MyPrint {
    public static void main(String[] args) {
        PrintNumber print = new PrintNumber();
//        PrintNumber print2 = new PrintNumber();

        Thread thread1 = new Thread(print, "奇数线程");
        Thread thread2 = new Thread(print, "偶数线程");

        thread1.start();

        thread2.start();


    }
}
