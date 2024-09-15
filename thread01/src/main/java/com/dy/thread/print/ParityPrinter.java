package com.dy.thread.print;

public class ParityPrinter {
    private final int max;
    // 从1开始计数
    private int count = 1;
    private final Object lock = new Object();

    public ParityPrinter(int max) {
        this.max = max;
    }

    public void printOdd() {
        print(true);
    }

    public void printEven() {
        print(false);
    }

    private void print(boolean isOdd) {
        for (int i = 1; i <= max; i += 2)
            // 确保同⼀时间只有⼀个线程可以执⾏内部代码块
            synchronized (lock) {
                // 等待直到轮到当前线程打印
                // count为奇数时奇数线程打印，count为偶数时偶数线程打印
                while (isOdd == (count % 2 == 0)) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": 等待" );
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + count++);
                // 通知等待的线程
                lock.notify();
            }
    }

    public static void main(String[] args) {
        // 打印 1-100
        ParityPrinter printer = new ParityPrinter(100);
        // 创建打印奇数和偶数的线程
        Thread t1 = new Thread(printer::printOdd, "Odd");
        Thread t2 = new Thread(printer::printEven, "Even");
        t1.start();
        t2.start();
    }
}
