package com.fuguo.aigorithm;

/**
 * Created by MBENBEN on 2018/4/8.
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(check(123321));
    }

    /**
     * 判断是否n是回文数
     * @param n
     * @return 如果是返回true，否则返回false
     */
    public static boolean check(int n) {
        int m = 0;
        for (int i = n; i > 0; i /= 10) {
            int tail = i % 10;
            m = m * 10 + tail;
        }
        if(n == m) {
            return true;
        }
        return false;
    }
}
