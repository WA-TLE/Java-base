package com.dy.thread.practice.sellticket;


/**
 * @Author: dy
 * @Date: 2024/9/15 23:07
 * @Description:
 */
public class SellTicketDemo {
    public static void main(String[] args) {
        SellTicket st1 = new SellTicket();
        SellTicket st2 = new SellTicket();
        st1.setName("窗口1");
        st2.setName("窗口2");
        st1.start();
        st2.start();
    }
}
