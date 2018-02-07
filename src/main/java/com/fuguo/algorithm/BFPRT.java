package com.fuguo.algorithm;

import java.util.Arrays;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-12 14:38
 * @since V1.0.0
 */
public class BFPRT {

    public static void getMid(Integer[] arr, int left, int right) {
        int size = (right - left) / 5;
        int j = left;
        for (int i = left; i < size; i++) {
            insertSort(arr, i * 5, (i + 1) * 5);
            swap(arr, j , i * 5 + 2);
            j++;
        }
    }

    public static void insertSort(Integer[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            Integer temp = arr[i];
            int j = i - 1;
            for (; j >= left; j--) {
                if(arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    public static void swap(Integer[] arr, int i, int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){

        Integer[] arr = {10, 8, 6, 7, 2, 5, 3, 1};
        insertSort(arr, 0 , arr.length - 1);
        System.out.println(Arrays.asList(arr));

    }
}
