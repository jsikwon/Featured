package edu.wccnet.jwon1.mp2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCApp2 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Battle b = (Battle) context.getBean("battle");
        b.fight();

        ((ClassPathXmlApplicationContext)context).close();

    }
}
