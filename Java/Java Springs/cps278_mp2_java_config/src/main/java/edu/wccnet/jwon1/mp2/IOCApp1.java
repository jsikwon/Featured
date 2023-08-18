package edu.wccnet.jwon1.mp2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCApp1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IOCJavaConfig.class);
        Battle b = (Battle) context.getBean("battle");
        b.fight();
        context.close();
    }
}

