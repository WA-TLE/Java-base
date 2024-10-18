package com.dy.review.sort;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: dy
 * @Date: 2024/10/12 16:47
 * @Description:
 */
public class Main {
    public static void main(String[] args) {

        int n, q;

        LinkedList<Integer> linkedList = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        q = in.nextInt();

        for (int i = 1; i <= n; i++) {

            linkedList.add(i);
        }

        Integer a, b, op;
        for (int i = 0; i < q; i++) {
            a = in.nextInt();
            b = in.nextInt();
            op = in.nextInt();

            linkedList.remove(a);
            int index = linkedList.indexOf(b);

            index += op;

            linkedList.add(index, a);


        }

        linkedList.forEach(integer -> System.out.printf(integer + " "));


    }
}
