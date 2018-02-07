package com.fuguo.test;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-02-05 8:44
 * @since V1.0.0
 */
public interface DataCenterInfo {

    class Name {
        public void getName() {
            System.out.println("google dataCenter.");
        }
    }

    void getData();

    static void main(String[] args){
        DataCenterInfo.Name name = new Name();
        name.getName();
        System.out.println();

    }
}
