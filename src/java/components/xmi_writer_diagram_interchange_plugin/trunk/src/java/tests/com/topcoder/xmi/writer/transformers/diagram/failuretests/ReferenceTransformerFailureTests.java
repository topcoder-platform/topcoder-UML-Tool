/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.failuretests;

import com.topcoder.diagraminterchange.Reference;

import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.ReferenceTransformer;


/**
 * <p>
 * Failure tests for class ReferenceTransformer. Tests the exceptions in invalid condition.
 * </p>
 *
 * @author magicpig
 * @version 1.0
 */
public class ReferenceTransformerFailureTests extends TransformerFailureBase {
    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        element = new Reference();
        suhClassName = "ReferenceTransformerFailureTests";
        this.instance = new ReferenceTransformer();
    }
}
