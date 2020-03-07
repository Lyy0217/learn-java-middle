package com.lyy.learn.java.application.log4j;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class TestLog4j {
    //基于类的名称获取日志对象
    static Logger logger = Logger.getLogger(TestLog4j.class);


    public static void main(String[] args) throws InterruptedException {
        //进行默认配置
//        BasicConfigurator.configure();

        //Log4j的配置方式按照log4j.properties中的设置进行
//        PropertyConfigurator.configure("/Users/lyy0217/Documents/learn/how2j/learn-java-middle/src/main/profiles/log4j.properties");
        DOMConfigurator.configure("/Users/lyy0217/Documents/learn/how2j/learn-java-middle/src/main/profiles/log4j.xml");

        for (int i = 0; i < 5000; i++) {
            logger.trace("跟踪信息");
            logger.debug("调试信息");
            logger.info("输出信息");
            logger.warn("警告信息");
            logger.error("错误信息");
            logger.fatal("致命信息");
        }
    }
}
