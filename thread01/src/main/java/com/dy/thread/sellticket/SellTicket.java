package com.dy.thread.sellticket;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: dy
 * @Date: 2024/9/15 20:36
 * @Description:
 */
public class SellTicket implements Runnable {
    private static int ticket = 100;
    private static Object obj = new Object();
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();

            try {
                if (ticket <= 0) {
                    System.out.println("电影票出售完毕!");
                    break;
                } else {
                        Thread.sleep(100);
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + ": 在卖票, 还剩下: " + ticket);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }

        }
    }

}
