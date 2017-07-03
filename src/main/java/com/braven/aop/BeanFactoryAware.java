/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.braven.aop;

import com.braven.factory.BeanFactory;

/**
 *
 * @author wb-zy280602
 * @version $Id: BeanFactoryAware.java, v 0.1 2017年06月30日 16:14 wb-zy280602 Exp $
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws Exception;

}