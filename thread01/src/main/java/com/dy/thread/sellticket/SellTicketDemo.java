package com.dy.thread.sellticket;

/**
 * @Author: dy
 * @Date: 2024/9/15 20:36
 * @Description:
 */
public class SellTicketDemo {
    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        Thread t1 = new Thread(sellTicket, "窗口1");
        Thread t2 = new Thread(sellTicket, "窗口2");
        Thread t3 = new Thread(sellTicket, "窗口3");


        t3.start();
        t1.start();
        t2.start();
    }
}
