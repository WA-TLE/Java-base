package com.dy.thread.sellticket;

import java.util.Objects;

/**
 * @Author: dy
 * @Date: 2024/9/15 20:36
 * @Description:
 */
public class SellTicket implements Runnable {
    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {

            if (method()) break;

        }
    }

    private synchronized static boolean method() {
        if (ticket <= 0) {
            System.out.println("电影票出售完毕!");
            return true;
        } else {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticket--;
            System.out.println(Thread.currentThread().getName() + ": 在卖票, 还剩下: " + ticket);
        }
        return false;
    }
}
