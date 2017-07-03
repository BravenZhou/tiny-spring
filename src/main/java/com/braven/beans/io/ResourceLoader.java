/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.braven.beans.io;

import java.net.URL;

/**
 *
 * @author wb-zy280602
 * @version $Id: ResourceLoader.java, v 0.1 2017年06月30日 11:48 wb-zy280602 Exp $
 */
public class ResourceLoader {

    public Resource getResource(String location){
        URL resource  = this.getClass().getClassLoader().getResource(location);
        return new URLResource(resource);
    }

}