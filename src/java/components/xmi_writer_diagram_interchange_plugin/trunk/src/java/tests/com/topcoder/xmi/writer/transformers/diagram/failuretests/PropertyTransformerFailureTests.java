/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.failuretests;

import com.topcoder.diagraminterchange.Property;

import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PropertyTransformer;


/**
 * <p>
 * Failure tests for class PropertyTransformer. Tests the exceptions in invalid condition.
 * </p>
 *
 * @author magicpig
 * @version 1.0
 */
public class PropertyTransformerFailureTests extends TransformerFailureBase {
    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        element = new Property();
        suhClassName = "PropertyTransformerFailureTests";
        this.instance = new PropertyTransformer();
    }
}
