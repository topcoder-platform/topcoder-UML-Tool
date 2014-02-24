/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import java.lang.reflect.Method;


/**
 * <p>
 * This class describes an XMI attribute.
 * It extends from <code>NodeDescription</code> class without any additional methods.
 * So it contains two attributes, name and methods as which in NodeDescription.
 * </p>
 *
 * <p>
 * This class is immutable, so it is thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class AttributeDescription extends NodeDescription {
    /**
     * The Constructor with name and method.
     *
     * @param name the attribute name
     * @param method the method to retrieve attribute value.
     * @throws IllegalArgumentException if any paramter is null, or name is an empty string after trimmed,
     * or method contains any parameter.
     */
    public AttributeDescription(String name, Method method) {
        super(name, method);
    }
}
