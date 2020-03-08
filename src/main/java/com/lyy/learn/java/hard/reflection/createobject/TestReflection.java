package com.lyy.learn.java.hard.reflection.createobject;

import com.lyy.learn.java.hard.reflection.Hero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 使用反射方式进行创建对象
 * <p>
 * 与传统的通过new的方式获取对象的方式不同
 * <p>
 * 1. 反射机制会先拿到Hero类的类对象，然后通过类对象获取构造器对象 getConstructor()
 * 2. 再通过构造器对象，创建一个对象。newInstance()
 */
public class TestReflection {

    public static void main(String[] args) {
        //使用传统的方式创建Hero 对象
//        Hero hero1 = new Hero();
//        hero1.setName("temmo");
//        System.out.println(hero1);
//
//        try {
//            //使用反射方式创建对象
//            String className = "com.lyy.learn.java.hard.reflection.Hero";
//
//            //获取类对象
//            Class pClass = Class.forName(className);
//
//            //通过类对象获取构造器
//            Constructor<Hero> c = pClass.getConstructor();
//
//            Hero hero2 = c.newInstance();
//            hero2.setName("garren");
//            System.out.println(hero2);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // 通过配置文件读取字符串，然后创建对象
        Hero hero = getHero();
        System.out.println(hero);
    }

    public static Hero getHero() {
        File file = new File("/Users/lyy0217/Documents/learn/how2j/learn-java-middle/src/main/profiles/hero.config");

        try (FileReader fileReader = new FileReader(file)) {

            char[] all = new char[(int) file.length()];

            int i = fileReader.read(all);

            String fileContent = new String(all);

            String[] cs = fileContent.split("\n");

            String hero1ClassName = cs[0];
            String hero1Name = cs[1];

            String hero2ClassName = cs[2];
            String hero2Name = cs[3];

            Class hero1Class = Class.forName(hero1ClassName);
            Class hero2Class = Class.forName(hero2ClassName);

            Constructor hero1Ct = hero1Class.getConstructor();
            Constructor hero2Ct = hero2Class.getConstructor();

            Hero hero1 = (Hero) hero1Ct.newInstance();
            Hero hero2 = (Hero) hero2Ct.newInstance();

            Field f1 = hero1Class.getField("name");
            Field f2 = hero2Class.getField("name");

            f1.set(hero1, "gareen");
            f2.set(hero2, "temmo");

            Method m = hero1Class.getMethod("attackHero", Hero.class);
            m.invoke(hero1, hero2);

            return hero1;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
