/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.braven.beans.io;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;

/**
 * Spring内部定位资源的接口
 * @author wb-zy280602
 * @version $Id: Resource.java, v 0.1 2017年06月30日 11:43 wb-zy280602 Exp $
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}