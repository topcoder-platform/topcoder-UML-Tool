/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import java.lang.reflect.Method;

import com.topcoder.xmi.writer.transformers.model.NodeDescription;
/**
 * This is a simple mock extends the NodeDescription abstract class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockNodeDescription extends NodeDescription {
    /**
     * The constructor of the mock with name and method.
     *
     * @param name the name of the mock NodeDescription
     * @param method the method of the mock NodeDescription
     */
    public MockNodeDescription(String name, Method method) {
        super(name, method);
    }
}
