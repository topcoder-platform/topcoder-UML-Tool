/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.failuretests;

import com.topcoder.diagraminterchange.Dimension;

import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DimensionTransformer;


/**
 * <p>
 * Failure tests for class DimensionTransformer. Tests the exceptions in invalid condition.
 * </p>
 *
 * @author magicpig
 * @version 1.0
 */
public class DimensionTransformerFailureTests extends TransformerFailureBase {
    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        element = new Dimension();
        suhClassName = "DimensionTransformerFailureTests";
        this.instance = new DimensionTransformer();
    }
}
