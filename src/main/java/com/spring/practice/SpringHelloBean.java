package com.spring.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

public class SpringHelloBean {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("beans-config.xml");
        HelloBean helloBean = (HelloBean) context.getBean("hellobean");
        System.out.println(helloBean.getHelloWord());
    }
}
