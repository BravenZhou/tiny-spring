/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.braven.beans.xml;

import com.braven.bean.BeanReference;
import com.braven.beans.BeanDefinition;
import com.braven.beans.PropertyValue;
import com.braven.beans.io.ResourceLoader;
import com.braven.beans.reader.AbstractBeanDefinitonReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 *
 * @author wb-zy280602
 * @version $Id: XmlBeanDefinitionReader.java, v 0.1 2017年06月30日 14:08 wb-zy280602 Exp $
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitonReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitons(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitons(inputStream);
    }

    protected void doLoadBeanDefinitons(InputStream inputStream) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        registerBeanDefinition(document);
        inputStream.close();
    }

    public void registerBeanDefinition(Document doc){
        Element root = doc.getDocumentElement();
        parseBeanDefinitions(root);
    }

    protected void parseBeanDefinitions(Element root){
        NodeList nodeList = root.getChildNodes();
        for (int i=0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);
            if (node instanceof Element){
                Element ele = (Element) node;
                processBeanDefinition(ele);
            }
        }
    }

    protected void processBeanDefinition(Element element){
        String name = element.getAttribute("id");
        String className = element.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processPorperty(element,beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name,beanDefinition);
    }

    /**
     *
     * @param ele
     * @param beanDefinition
     */
    protected void processPorperty(Element ele, BeanDefinition beanDefinition){
        NodeList propertyNode = ele.getElementsByTagName("property");
        for (int i=0;i<propertyNode.getLength();i++){
            Node node = propertyNode.item(i);
            if (node instanceof Element){
                Element e = (Element)node;
                String name = e.getAttribute("name");
                String value = e.getAttribute("value");
                if (value !=null && value.length()>0){
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
                } else {
                    String ref = e.getAttribute("ref");
                    if (ref == null || ref.length()==0){
                        throw new IllegalArgumentException("must be a value or a ref");
                    }
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,beanDefinition));
                }
            }
        }
    }
}