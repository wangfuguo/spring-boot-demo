package com.fuguo.algorithm;

import java.util.Arrays;

import static com.fuguo.algorithm.BFPRT.insertSort;
import static com.fuguo.algorithm.BFPRT.swap;

/**
 * 把所有的数每五个分为一组，找出每一组中的中位数，将每一组中的中位数放在整个数组的最前面(不是每一组的最前面)，
 * 然后递归的求出这些中位数的中位数，直到只有一个中位数，然后以这个中位数为枢轴分割数组，
 * 将比她小的数放在前面，比他大的放在后面(像快速排序一样)，然后判断要找的数个数和当前的枢轴的下标，
 * 如果大，在右边递归BRPRT反之一样
 * @author MBENBEN
 *
 */
public class LinearSearch {

    public static void main(String[] args) {

        Integer[] arr = {10, 5, 12, 6, 8, 15, 18, 3, 9, 16, 2, 2, 1, 1};
        LinearSearch linearSearch = new LinearSearch();

        int bfprt = linearSearch.BFPRT(arr, 0, arr.length - 1, 14);
        System.out.println(Arrays.asList(arr));
        System.out.println(bfprt);

    }

    public int BFPRT(Integer[] arr, int left, int right, int id){
        if(id > arr.length) {
            throw new RuntimeException("超过数组的长度");
        }
        if(right - left + 1 <= 5){
            insertSort(arr, left, right);
            return arr[left + id - 1];
        }

        int t = left - 1;
        for (int st = left, ed; (ed = st + 4) <= right; st += 5) //每5个进行处理
        {
            insertSort(arr, st, ed); //5个数的排序
            t++;
            swap(arr, t, st+2); //将中位数替换到数组前面，便于递归求取中位数的中位数
        }
        int pivotId = (left + t) >> 1; //l到t的中位数的下标，作为主元的下标
        BFPRT(arr, left, t, pivotId - left + 1);//不关心中位数的值，保证中位数在正确的位置
        int m = partition(arr, left, right, pivotId), cur = m - left + 1;
        if (id == cur){
            return arr[m];                   //刚好是第id个数
        }
        else if(id < cur){
            return BFPRT(arr, left, m-1, id);//第id个数在左边
        }
        else{
            return BFPRT(arr, m+1, right, id-cur);         //第id个数在右边
        }

    }

    public int partition(Integer[] arr, int left, int right, int pivotId){
        swap(arr, pivotId, right);
        int j = left - 1;
        for(int i = left; i < right; i++){
            if(arr[i] <= arr[right]){
                swap(arr, ++j, i);
            }
        }
        swap(arr, ++j, right);
        return j;
    }
}
