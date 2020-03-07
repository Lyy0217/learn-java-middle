package com.lyy.learn.java.middle.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1. 打开的文件可能不存在，所以可能会抛出异常FileNotFoundException，此时需要catch住
 * 2. e instanceof exception
 * 3. finally 在返回值返回之前会先执行。如果在finally中return，则返回finally中的值
 * 4. 异常分类：
 *      4.1 Exception
 *          4.12 不可查异常（运行时异常）
 *          4.13 可检查异常
 *      4.2 Error
 */
public class TestException {
    private static int method() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {

        System.out.println(method());

//        File file = new File("d:/LOL.exe");

//        try {
//            System.out.println("试图打开 d:/LOL.exe");
//            new FileInputStream(file);
//            System.out.println("成功打开");
//
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = sdf.parse("2020-03-07");
//        } catch (FileNotFoundException | ParseException e) {
//            if (e instanceof FileNotFoundException) {
//                System.out.println("FileNotFoundException");
//            }
//            if (e instanceof ParseException) {
//                System.out.println("ParseException");
//            }
//        } finally {
//            System.out.println("finally");
//        }
    }
}
