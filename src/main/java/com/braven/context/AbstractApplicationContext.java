package com.braven.context;

import com.braven.factory.AbstractBeanFactory;

public abstract class AbstractApplicationContext implements ApplicationContext {

	protected AbstractBeanFactory beanFactory;

	public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	@Override
	public Object getBean(String beanName) throws Exception {
		return beanFactory.getBean(beanName);
	}

	//TODO refresh
	public void refresh() throws Exception{
		loadBeanDefinitions(beanFactory);
		// TODO beanPostProcessors

	}

	protected void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception{}

}
