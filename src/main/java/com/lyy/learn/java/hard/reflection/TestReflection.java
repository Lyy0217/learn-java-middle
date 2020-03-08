package com.lyy.learn.java.hard.reflection;


/**
 * @des：反射机制
 * 1.类对象的概念：描述类都具有什么方法、属性的。获取类对象有三种方式
 *      1.1 Class.forName();
 *      1.2 Hero.class;
 *      1.3 new Hero().getClass();
 * 在一个JVM中（准确的说是在一个ClassLoader中），一种类，只有一个类对象存在。所以上述三种方法获取的类对象都是一样的。
 * 这里要区别类实例化后的对象与这的类对象的区别。
 *
 * 2. 无论什么途径获取类对象，都会导致静态属性被初始化，而且只会初始化一次。（除了使用Class c = Hero.class 这种方式，这种方式不会导致静态属性被初始化）
 * <p>
 *
 * 3. 在静态方法前加synchronized，同步对象是什么？
 *      3.1 同步对象就是这个类的类对象。
 *    在对象方法前，加上修饰符synchronized，同步对象是当前实例
 *    在类前加上synchronized，同步的是该类的所有实例
 */
public class TestReflection {

    public static void main(String[] args) throws InterruptedException {
//        String heroClassName = "com.lyy.learn.java.hard.reflection.Hero";
//        try {
//            Class pClass1 = Class.forName(heroClassName);
//            Class pClass2 = new Hero().getClass();
//            Class pClass3 = Hero.class;
//            System.out.println(pClass1 == pClass2);
//            System.out.println(pClass1 == pClass3);
//            System.out.println(pClass2 == pClass3);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        Thread t1 = new Thread() {
            public void run() {
                //调用method1
                TestReflection.method1();
            }
        };
        t1.setName("第一个线程");
        t1.start();

        //保证第一个线程先调用method1
        Thread.sleep(1000);

        Thread t2 = new Thread() {
            public void run() {
                //调用method2
                TestReflection.method2();
            }
        };
        t2.setName("第二个线程");
        t2.start();
    }

    public static void method1() {

        synchronized (TestReflection.class) {
            // 对于method1而言，同步对象是TestReflection.class，只有占用TestReflection.class才可以执行到这里
            System.out.println(Thread.currentThread().getName() + " 进入了method1方法");
            try {
                System.out.println("运行5秒");
                Thread.sleep(5000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }

    public static synchronized void method2() {
        // 对于mehotd2而言，必然有个同步对象，通过观察发现，当某个线程在method1中，占用了TestReflection.class之后
        // 就无法进入method2，推断出，method2的同步对象，就是TestReflection.class
        System.out.println(Thread.currentThread().getName() + " 进入了method2方法");
        try {
            System.out.println("运行5秒");
            Thread.sleep(5000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }
}
