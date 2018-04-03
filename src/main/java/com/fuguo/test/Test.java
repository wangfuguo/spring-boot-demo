package com.fuguo.test;

import java.util.List;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-12 15:06
 * @since V1.0.0
 */
public class Test {

    public String buildRequestString(Object obj) {
        return "xmlns:soapenc=\\\"http://schemas.xmlsoap.org/soap/encoding/" + objectToXml(obj) + "";
    }

    public String objectToXml(Object obj) {
        return "<root>...<root>";
    }

    public void send(Object obj) {
        send(buildRequestString(obj));
    }

    public void sendBatch(List<Object> list) {
        for (int i = 0; i < list.size(); i++) {
            try {
                send(list.get(i));
            } catch (Exception e) {

            }
        }
    }

    public Test() {
        System.out.println(666);
    }

    {
        System.out.println(111);
    }

    {
        System.out.println(222);
    }

    static {
        System.out.println(333);
    }

    static {
        System.out.println(444);
    }


    public static void main(String[] args){

        String string = "1";
        int pointLen = string.indexOf(".") == -1 ? 0 :  string.length() - string.indexOf(".") - 1;
        //System.out.println(pointLen);

        SubTest test = new SubTest();
        //Test test1 = new Test();
        System.out.println(2<<3);
        System.out.println(((10 << 5) - 10));

        for (int  i  = 0; i < 10; i++) {
            if(i == 5) {
                throw new RuntimeException("sss");
            }
            System.out.println(12);
        }

    }
}

class SubTest extends Test {

    //private Test test = new Test();

    {
        System.out.println(11111);
    }


    static {
        System.out.println(22222);
    }

    public SubTest() {
        System.out.println(33333);
    }


}
