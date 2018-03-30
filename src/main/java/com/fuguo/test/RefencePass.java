package com.fuguo.test;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-09 13:25
 * @since V1.0.0
 */
public class RefencePass {

    public static void stringReplace(String str) {
        str = str.replace("j", "l");
    }

    public static void stringBuffer(StringBuffer str) {
        str = str.append("c");
    }


    public static void main(String[] args){

        String str = new String("java");
        StringBuffer sb = new StringBuffer("java");
        stringReplace(str);
        stringBuffer(sb);
        System.out.println(str + sb);
        
        int[] arr = new int[10];
        System.out.println(arr[1]);
        
        Integer[] arri = new Integer[10];
        System.out.println(arri[1]);
        
        try {
            throw new NullPointerException();
        }catch (NullPointerException e) {
            System.out.println(1);
        } catch (Exception e) {
            System.out.println(2);
        } finally {
            System.out.println(3);
        }

    }
}