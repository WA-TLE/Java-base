package com.dy.thread.create.thread03;


import java.util.concurrent.Callable;

/**
 * @Author: dy
 * @Date: 2024/4/24 10:58
 * @Description:
 */
//public class MyCallable implements Callable<Integer> {
//    public Integer call() throws Exception {
//        System.out.println("!!!");
//        int sum = 0;
//        for (int i = 0; i < 100; i++) {
//            sum += i;
//            System.out.println(i);
//        }
//        return sum;
//    }
//}
public class MyCallable implements Callable<String> {

    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("跟女孩表白" + i);
        }
        //返回值就表示线程运行完毕之后的结果
        return "答应";
    }
}