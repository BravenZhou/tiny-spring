/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.braven.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wb-zy280602
 * @version $Id: PropertyValues.java, v 0.1 2017年06月30日 11:03 wb-zy280602 Exp $
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();

    public PropertyValues() {
    }

    public List<PropertyValue> getPropertyValues() {
        return this.propertyValues;
    }

    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValues.add(propertyValue);
    }
}