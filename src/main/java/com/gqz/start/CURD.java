package com.gqz.start;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * <p></p>
 *
 * @author gqz20
 * @create 2021-06-03 19:56
 **/
public class CURD {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");

        context.start();
        CURDUtils curdUtils = (CURDUtils) context.getBean("CURDUtils");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要选择的参数");
        System.out.println("a:添加图书\n" +
                "b:删除图书\n" +
                "c:更新图书\n" +
                "d:查看图书\n");
        String s = scanner.nextLine();

        switch (s) {
            case "a":
                curdUtils.a();
                break;
            case "b":
                curdUtils.b();
                break;
            case "c":
                curdUtils.c();
                break;
            case "d":
                curdUtils.d();
                break;
            default:
                System.out.println("您输入的参数有误!");
        }
    }
}
