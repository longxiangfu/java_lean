package com.lxf.springSource.spring3;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/17 9:51
 * @Version 1.0
 **/
public class Demo {
    public static void main(String[] args) {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("beanFactory.xml"));
        xmlBeanFactory.getBean("long");
    }
}
