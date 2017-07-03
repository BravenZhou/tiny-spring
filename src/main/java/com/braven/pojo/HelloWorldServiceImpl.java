/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.braven.pojo;

/**
 *
 * @author wb-zy280602
 * @version $Id: HelloWorldServiceImpl.java, v 0.1 2017年06月30日 15:13 wb-zy280602 Exp $
 */
public class HelloWorldServiceImpl implements HelloWorldService {
    private String text;

    private OutputService outputService;

    @Override
    public void sayHello(){
        //outputService.output(text);
        System.out.println("Hello");
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}