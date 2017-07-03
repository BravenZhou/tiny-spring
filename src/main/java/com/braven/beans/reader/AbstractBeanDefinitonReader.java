/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.braven.beans.reader;

import com.braven.beans.BeanDefinition;
import com.braven.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wb-zy280602
 * @version $Id: AbstractBeanDefinitonReader.java, v 0.1 2017年06月30日 11:39 wb-zy280602 Exp $
 */
public abstract class AbstractBeanDefinitonReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitonReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry(){
        return registry;
    }

    public ResourceLoader getResourceLoader(){
        return resourceLoader;
    }

}