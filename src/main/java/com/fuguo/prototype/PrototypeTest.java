package com.fuguo.prototype;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-04 15:11
 * @since V1.0.0
 */
public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {

        SerializableObject serializableObject = new SerializableObject();
        System.out.println(serializableObject.hashCode());
        Prototype prototype = new Prototype();
        prototype.setString("google");
        prototype.setObj(serializableObject);
        Prototype clone = (Prototype) prototype.clone();
        System.out.println(clone.getObj().hashCode());
        Prototype deepClone = (Prototype) prototype.deepClone();
        System.out.println(deepClone.getObj().hashCode());


        System.out.println(Timestamp.valueOf(LocalDateTime.of(2018, 1, 1, 0, 0, 0, 0)).getTime());

        Fruit fruit = new Apple();
        System.out.println(fruit.getName());
        System.out.println(fruit.getTestName());

    }
}

class StaticThreadSafe {

    public static void staticMethod() {
        final int i = 10;

    }
}

class Fruit {
    private String id;
    public String name = "fruit";

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

    public String getTestName() {
        return this.name;
    }
}

class Apple extends Fruit {
    private String id;
    public String name = "apple";

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
}