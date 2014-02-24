/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import java.lang.reflect.Method;


/**
 * <p>
 * This class describes an XMI nested child element. It extends from NodeDescription class,
 * and add a reference flag. So it contains two attributes, name and methods as which in NodeDescription.
 * And the additional refrence flag is used to indicate whether this child should be stored as a reference or not.
 * </p>
 *
 * <p>
 * This class is immutable, thus thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class ChildDescription extends NodeDescription {
    /**
     * Represents a flag indicating whether this child should be stored as a reference.
     * <p>
     * It is initialized in the constructor and never changed later.
     * It can be accessed by getter.
     * </p>
     *
     */
    private final boolean isReference;

    /**
     * The constructor with the given name, method and reference tag.
     *
     * @param name the child name
     * @param method the method to retrieve child value.
     * @param isReference flag indicating whether this child is only a reference.
     * @throws IllegalArgumentException if any paramter is null, or name is an empty string after trimmed,
     * or method contains some parameter.
     */
    public ChildDescription(String name, Method method, boolean isReference) {
        super(name, method);
        this.isReference = isReference;
    }

    /**
     * Getter of reference tag in this child description.
     *
     * @return the isReference flag
     */
    public boolean isReference() {
        return isReference;
    }
}
