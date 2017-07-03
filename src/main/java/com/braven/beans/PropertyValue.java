/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.braven.beans;

/**
 *
 * @author wb-zy280602
 * @version $Id: PropertyValue.java, v 0.1 2017年06月30日 11:02 wb-zy280602 Exp $
 */
public class PropertyValue {
    private String name;

    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}