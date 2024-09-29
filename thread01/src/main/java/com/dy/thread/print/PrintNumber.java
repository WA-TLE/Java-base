package com.dy.thread.print;

/**
 * @Author: dy
 * @Date: 2024/9/15 23:21
 * @Description:
 */
public class PrintNumber implements Runnable {

    private Object object = new Object();
    private int count = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                object.notify();

                if (count > 100) {
                    break;
                }

                System.out.println(Thread.currentThread().getName() + "打印: " + count ++);
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
