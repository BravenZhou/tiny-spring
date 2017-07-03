package com.braven.factory;

import com.braven.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory implements BeanFactory {

	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	private final List<String> beanDefinitionNames = new ArrayList<String>();

	@Override
	public Object getBean(String beanName) throws Exception {
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		if (beanDefinition==null){
			throw new IllegalArgumentException(beanName + "的bean不存在");
		}
		Object bean = beanDefinition.getBean();
		if (bean == null){
			bean = doCreateBean(beanDefinition);
			// TODO initializeBean

			beanDefinition.setBean(bean);
		}
		return bean;
	}

	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception{
		beanDefinitionNames.add(name);
		beanDefinitionMap.put(name,beanDefinition);
	}

	protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
		// 1.创建bean实例
		Object bean = createBeanInstance(beanDefinition);
		beanDefinition.setBean(bean);
		applyPropertyValues(beanDefinition,bean);
		return bean;
	}

	protected abstract void applyPropertyValues(BeanDefinition beanDefinition, Object bean) throws Exception ;

	protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
		return beanDefinition.getBeanClass().newInstance();
	}

}
