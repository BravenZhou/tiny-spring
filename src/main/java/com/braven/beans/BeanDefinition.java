/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.braven.beans;

/**
 *
 * bean的内容及元数据，保存在BeanFactory中，包装bean的实体
 * @author wb-zy280602
 * @version $Id: BeanDefinition.java, v 0.1 2017年06月30日 11:10 wb-zy280602 Exp $
 */
public class BeanDefinition {

    private Object bean;

    private Class beanClass;

    private String beanClassName;

    private PropertyValues propertyValues = new PropertyValues();

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}