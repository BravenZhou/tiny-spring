/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.braven.beans.reader;

/**
 * 从配置中读取BeanDefinition
 * @author wb-zy280602
 * @version $Id: BeanDefinitionReader.java, v 0.1 2017年06月30日 11:38 wb-zy280602 Exp $
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitons(String location) throws Exception;
}