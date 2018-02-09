package com.fuguo.simplefactory;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-02-09 11:04
 * @since V1.0.0
 */
public class TestFactory {

    public static void main(String[] args){

        Api api = Factory.createApi();
        api.operation("别紧张，只是个测试!");
        System.out.println();

    }
}
