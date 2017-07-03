/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.braven.pojo;

/**
 *
 * @author wb-zy280602
 * @version $Id: OutputServiceImpl.java, v 0.1 2017年06月30日 15:16 wb-zy280602 Exp $
 */
public class OutputServiceImpl implements OutputService {
    @Override
    public void output(String text) {
        System.out.println("hello " + text);
    }
}