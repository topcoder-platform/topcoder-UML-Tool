/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.failuretests;

import com.topcoder.diagraminterchange.SimpleSemanticModelElement;

import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.SimpleSemanticModelElementTransformer;


/**
 * <p>
 * Failure tests for class SimpleSemanticModelElementTransformer. Tests the exceptions in invalid
 * condition.
 * </p>
 *
 * @author magicpig
 * @version 1.0
 */
public class SimpleSemanticModelElementTransformerFailureTests extends TransformerFailureBase {
    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        element = new SimpleSemanticModelElement();
        suhClassName = "SimpleSemanticModelElementTransformerFailureTests";
        this.instance = new SimpleSemanticModelElementTransformer();
    }
}
