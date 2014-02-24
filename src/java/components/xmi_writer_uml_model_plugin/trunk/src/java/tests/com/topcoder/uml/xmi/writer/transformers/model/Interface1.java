/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.xmi.writer.transformers.model;

import java.util.Collection;


/**
 * This is a simple interface used to do unit test of the component.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public interface Interface1 {
    /**
     * Get the namespace.
     *
     * @return the namespace.
     */
    public String getNamespace();
    /**
     * Get a boolean.
     *
     * @return a Boolean
     */
    public Boolean isLeaf();
    /**
     * Get a collection with name abc.
     *
     * @return a collection
     */
    public Collection getAbs();
    /**
     * Get a collection with name.
     *
     * @return a collection.
     */
    public Collection getChildren();
    /**
     * The method add child.
     *
     * @param child the String child
     */
    public void addChild(String child);
    /**
     * Get the excluded.
     *
     * @return a String
     */
    public String getExcluded();
    /**
     * Get a instance that is a mock class.
     *
     * @return a InnerBean instance.
     */
    public InnerBean getInnerBean();
    /**
     * Get a instance of Enum.
     *
     * @return a Enum instance.
     */
    public Enum1 getEnum1();
    /**
     * Get a instance of Reference.
     *
     * @return a instance of Reference
     */
    public Reference getReference();
}
