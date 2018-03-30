package com.fuguo.aigorithm;

import java.util.Arrays;
import java.util.List;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-14 14:00
 * @since V1.0.0
 */
public class BinarySearch {

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1, 2, 4, 5, 6, 8, 10, 12, 16);
        System.out.println(binarySearch(list, 2) + 1);
//        System.out.println(indexedBinarySearch(list, 3) + 1);

    }

    public static int binarySearch(List<? extends Comparable> list, Object key) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if(list.get(mid).compareTo(key) > 0) {
                right = mid - 1;
            } else if (list.get(mid).compareTo(key) < 0) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -(left + 1);  // key not found;
    }

    private static <T>
    int indexedBinarySearch(List<? extends Comparable<? super T>> list, T key) {
        int low = 0;
        int high = list.size()-1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable<? super T> midVal = list.get(mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }
}
