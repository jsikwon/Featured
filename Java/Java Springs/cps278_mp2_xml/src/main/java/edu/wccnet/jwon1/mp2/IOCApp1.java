package edu.wccnet.jwon1.mp2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCApp1 {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
        Battle b = (Battle) context.getBean("battle");
        b.fight();
    }
}

