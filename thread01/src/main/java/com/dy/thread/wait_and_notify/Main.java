package com.dy.thread.wait_and_notify;

/**
 * @Author: dy
 * @Date: 2024/9/18 19:53
 * @Description:
 */
public class Main {
    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        MyThread01 myThread01 = new MyThread01();
        MyThread02 myThread02 = new MyThread02();

        Thread thread1 = new Thread(myThread01, "线程1");
        thread1.start();

        Thread.sleep(1000);

        Thread thread2 = new Thread(myThread02, "线程2");
        thread2.start();

    }


    static class MyThread01 implements Runnable{


        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "初次获得对象锁，执行中，调用共享对象的wait()方法...");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "再次获取对象锁...");
            }
        }
    }

   static class MyThread02 implements Runnable{



        @Override
        public void run() {
            synchronized (object) {
                object.notify();
                System.out.println(Thread.currentThread().getName() + "获得对象锁，执行中，调用了共享对象的notify()方法");
            }
        }
    }

}



