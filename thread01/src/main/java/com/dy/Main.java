package com.dy;
import java.util.*;
class Main {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static Pair[] a;
    static int n, len;

    public static boolean check(long x) {
        List<Pair> segs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = a[i].first, s = a[i].second;
            if (s > x)
                continue;

            int left = Math.max(1, l - (int) x + s);
            int right = Math.min(len, l + (int) x - s);
            segs.add(new Pair(left, right));
        }

        int cnt = segs.size();
        segs.sort((p1, p2) -> {
            if (p1.first != p2.first) {
                return p1.first - p2.first;
            }
            return p1.second - p2.second;
        });

        if (segs.isEmpty())
            return false;
        if (segs.get(0).first > 1)
            return false;

        int dl = segs.get(0).first, dr = segs.get(0).second;
        for (int i = 1; i < cnt; i++) {
            if (segs.get(i).first > dr + 1)
                return false;

            dr = Math.max(dr, segs.get(i).second);
        }

        return dr == len;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        len = scanner.nextInt();

        a = new Pair[n];
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int s = scanner.nextInt();
            a[i] = new Pair(l, s);
        }

        long l = 1, r = 2_000_000_000;
        while (l < r) {
            long mid = l + r >> 1;
            if (check(mid))
                r = mid;
            else
                l = mid + 1;
        }

        System.out.println(l);
    }
}
