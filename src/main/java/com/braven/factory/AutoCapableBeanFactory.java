/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.braven.factory;

import com.braven.aop.BeanFactoryAware;
import com.braven.bean.BeanReference;
import com.braven.beans.BeanDefinition;
import com.braven.beans.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author wb-zy280602
 * @version $Id: AutoCapableBeanFactory.java, v 0.1 2017年06月30日 16:09 wb-zy280602 Exp $
 */
public class AutoCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected void applyPropertyValues(BeanDefinition beanDefinition, Object bean) throws Exception{
        if (bean instanceof BeanFactoryAware){
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()){
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference){
                BeanReference beanReference = (BeanReference) value;
                bean = getBean(beanReference.getName());
            }
            try {
                Method declaredMethod = bean.getClass().getDeclaredMethod("set" + propertyValue.getName().substring(0,1).toUpperCase() +
                        propertyValue.getName().substring(1),value.getClass());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e){
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                Object value2 = propertyValue.getValue();
                if (value2 instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value2;
                    value2 = getBean(beanReference.getName());
                }
                declaredField.set(bean, value2);
            }
        }
    }

}