package com.fuguo.algorithm;

import java.util.Arrays;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-30 8:39
 * @since V1.0.0
 */
public class BinarySearch {

    /**
     * 递归进行二分查找
     * @param arr
     * @param left
     * @param right
     * @param key
     * @return
     */
    public static int binarySearch(Integer[] arr, int left, int right, Integer key) {
        if(left < right) {
            int partition = partition(arr, left, right);
            if(key < arr[partition]) {
                return binarySearch(arr, left, partition - 1, key);
            } else if (key > arr[partition]) {
                return binarySearch(arr, partition + 1, right, key);
            } else {
                return partition;
            }
        }
        return 0;
    }

    /**
     * 按照枢轴分数组元素
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(Integer[] arr, int left, int right) {
        int temp = left - 1;
        for(int i = left; i < right; i++) {
            if(arr[i] < arr[right]) {
                temp++;
                swap(arr, temp, i);
            }
        }
        swap(arr, temp + 1, right);
        return temp + 1;
    }

    /**
     * 交换数组元素
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(Integer[] arr, int i, int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){

        Integer[] arr = {8, 6, 2, 3, 2, 9, 1, 5, 7};
        System.out.println(binarySearch(arr, 0 ,arr.length - 1, 2));
        System.out.println(Arrays.asList(arr));

    }

}
