package com.fuguo.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

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
        Map map = new HashMap<String, String>();
        map.put("1", "google");
        map.put("2", "amazon");
        System.out.println(map);
        Calendar instance = Calendar.getInstance();
        instance.set(2017, 0, 1, 0, 0, 0);
        System.out.println(instance.getTimeInMillis());
        //instance.setTimeInMillis(1483200000008L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(instance.getTime()));

    }
}
