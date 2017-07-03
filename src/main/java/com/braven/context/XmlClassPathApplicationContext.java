/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.braven.context;

import com.braven.beans.BeanDefinition;
import com.braven.beans.io.ResourceLoader;
import com.braven.beans.xml.XmlBeanDefinitionReader;
import com.braven.factory.AbstractBeanFactory;
import com.braven.factory.AutoCapableBeanFactory;

import java.util.Map;

/**
 *
 * @author wb-zy280602
 * @version $Id: XmlClassPathApplicationContext.java, v 0.1 2017年06月30日 15:50 wb-zy280602 Exp $
 */
public class XmlClassPathApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public XmlClassPathApplicationContext(String configLocation) throws Exception {
        //TODO
        this(new AutoCapableBeanFactory(),configLocation);
    }

    public XmlClassPathApplicationContext(AbstractBeanFactory beanFactory,  String configLocation) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    protected void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitons(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }
    }
}