package com.fuguo.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-15 17:13
 * @since V1.0.0
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args){

        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        Apple apple = new Apple();
        apple.setId("1");
        apple.setName("apple");
        hashMap.put(apple, 11);
        hashMap.put("apple1", apple);
//        apple.setName("apple1");
        Apple apple2 = new Apple();
        apple2.setId("1");
        apple2.setName("apple");
        hashMap.put(apple2, apple);
        System.out.println(hashMap.get(apple));
        System.out.println(hashMap.get("apple1"));

    }

}

class Apple {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apple)) return false;

        Apple apple = (Apple) o;

        if (!getId().equals(apple.getId())) return false;
        return getName().equals(apple.getName());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
