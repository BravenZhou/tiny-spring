package com.braven.factory;

/**
 * 
 * @author wb-zy280602
 *
 */
public interface BeanFactory {

	public Object getBean(String beanName) throws Exception;
}
