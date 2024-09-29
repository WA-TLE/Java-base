package com.dy;
import java.util.*;

public class Main{

    static int n, len;
    static final int N = 100010;
    static PII[] a = new PII[N], b = new PII[N];

    static class PII implements Comparable<PII>{
        int x;
        int y;
        PII(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(PII other) {
            return Integer.compare(this.x, other.x);
        }
    }

    static boolean check(int x) {

        int cnt = 0;

        // 判断满足条件的区间
        for (int i= 0; i < n; i ++) {
            int s = a[i].x;
            int t = a[i].y;

            if (x >= t) {
                int l = Math.max(s - (x - t), 1);
                int r = Math.min(s + (x - t), len);
                b[cnt ++] = new PII(l, r);
            }
        }

        Arrays.sort(b, 0, cnt);

        //  区间合并
        int start = -1, end = -1;
        for (int i = 0; i < cnt; i ++) {
            if (b[i].x > end + 1) {
                start = b[i].x;
                end = b[i].y;
            } else {
                end = Math.max(end, b[i].y);
            }
        }

        return start == 1 && end == len;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        len = in.nextInt();

        for (int i = 0; i < n; i ++) {
            int s = in.nextInt();
            int t = in.nextInt();

            a[i] = new PII(s, t);
        }

        //  开始二分
        int left = 1, right = 2000000010;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);

    }
}