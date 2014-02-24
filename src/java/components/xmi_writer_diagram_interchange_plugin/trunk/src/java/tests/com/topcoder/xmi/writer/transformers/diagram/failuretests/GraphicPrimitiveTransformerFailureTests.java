/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.failuretests;

import com.topcoder.diagraminterchange.GraphicPrimitive;

import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphicPrimitiveTransformer;


/**
 * <p>
 * Failure tests for class GraphicPrimitiveTransformer. Tests the exceptions in invalid condition.
 * </p>
 *
 * @author magicpig
 * @version 1.0
 */
public class GraphicPrimitiveTransformerFailureTests extends TransformerFailureBase {
    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        element = new GraphicPrimitive() {
            };
        suhClassName = "GraphicPrimitiveTransformerFailureTests";
        this.instance = new GraphicPrimitiveTransformer();
    }
}
