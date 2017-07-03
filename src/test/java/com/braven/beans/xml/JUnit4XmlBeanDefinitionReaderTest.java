/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.braven.beans.xml;

import com.braven.beans.BeanDefinition;
import com.braven.beans.PropertyValue;
import com.braven.beans.PropertyValues;
import com.braven.beans.io.ResourceLoader;
import com.braven.context.ApplicationContext;
import com.braven.context.XmlClassPathApplicationContext;
import com.braven.factory.AutoCapableBeanFactory;
import com.braven.factory.BeanFactory;
import com.braven.pojo.HelloWorldService;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author wb-zy280602
 * @version $Id: JUnit4XmlBeanDefinitionReaderTest.java, v 0.1 2017年06月30日 15:06 wb-zy280602 Exp $
 */
public class JUnit4XmlBeanDefinitionReaderTest {

    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitons("tinyioc.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        for (Entry<String, BeanDefinition> entry:registry.entrySet()) {
            System.out.println("entry:" + entry.getKey() + " : " + entry.getValue());
        }
    }

    @Test
    public void test2() throws Exception {
        ApplicationContext applicationContext = new XmlClassPathApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.sayHello();
    }

    @Test
    public void test3() throws Exception {
        // 1.初始化beanfactory
        AutoCapableBeanFactory beanFactory = new AutoCapableBeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.braven.pojo.HelloWorldServiceImpl");
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.sayHello();
    }

    @Test
    public void test4() throws Exception {
        // 1.初始化beanfactory
        AutoCapableBeanFactory beanFactory = new AutoCapableBeanFactory();

        // 2.bean定义
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.braven.pojo.HelloWorldServiceImpl");

        // 3.设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello World!"));
        beanDefinition.setPropertyValues(propertyValues);

        // 4.生成bean
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 5.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.sayHello();
    }

    @Test
    public void test5() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitons("tinyioc.xml");

        // 2.初始化BeanFactory并注册bean
        AutoCapableBeanFactory beanFactory = new AutoCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.sayHello();
    }

}