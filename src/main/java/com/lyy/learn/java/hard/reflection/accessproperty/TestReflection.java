package com.lyy.learn.java.hard.reflection.accessproperty;

import com.lyy.learn.java.hard.reflection.Hero;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 * 反射机制：通过反射机制访问对象属性
 * <p>
 * getFiled与getDeclaredFiled的区别
 * <p>
 * 1. getFiled只能用于获取public字段，包括从父类继承来的字段
 * 2. getDeclaredFiled只能用于获取本类(不能获取到父类)中的字段，并且包括private字段。
 * 注意这里只能获取到private字段，但是不能访问该private字段的值，除非加上setAccessible(true)；
 */
public class TestReflection {

    public static void main(String[] args) {
//        Hero h = new Hero();
//        //使用传统方式修改name的值为garen
//        h.name = "temmo";
//
//        System.out.println(h);
//        try {
//            //获取Hero类中叫做"name"的字段属性
//            Field f1 = h.getClass().getDeclaredField("name");
//
//            //修改该字段的名字
//            f1.set(h, "garren");
//            System.out.println(h);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Hero h = new Hero();

        try {
            //var1: 获取的方法的名字  var2：该方法的参数类型
            Method m = h.getClass().getMethod("setName", String.class);

            //对h对象调用m方法，
            m.invoke(h, "temmo");

            System.out.println(h.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
