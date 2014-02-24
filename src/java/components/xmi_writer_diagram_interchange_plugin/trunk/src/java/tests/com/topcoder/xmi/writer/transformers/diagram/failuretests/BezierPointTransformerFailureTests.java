/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.failuretests;

import com.topcoder.diagraminterchange.BezierPoint;

import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.BezierPointTransformer;


/**
 * <p>
 * Failure tests for class BezierPointTransformer. Tests the exceptions in invalid condition.
 * </p>
 *
 * @author magicpig
 * @version 1.0
 */
public class BezierPointTransformerFailureTests extends TransformerFailureBase {
    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        element = new BezierPoint();
        suhClassName = "BezierPointTransformerFailureTests";
        this.instance = new BezierPointTransformer();
    }
}
