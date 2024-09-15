package com.dy.thread.practice.sellticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: dy
 * @Date: 2024/9/15 22:59
 * @Description:
 */
public class SellTicket extends Thread {

    private int ticket = 1000;
    private static Lock lock = new ReentrantLock();


    @Override
    public void run() {
        while (true) {
            lock.lock();

            try {
                if (ticket <= 0) {
                    break;
                } else {
                    Thread.sleep(10);
                    ticket --;
                    System.out.println(Thread.currentThread().getName() + ": 正在卖票, 剩余 " + ticket + "张");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }

        }
    }
}
