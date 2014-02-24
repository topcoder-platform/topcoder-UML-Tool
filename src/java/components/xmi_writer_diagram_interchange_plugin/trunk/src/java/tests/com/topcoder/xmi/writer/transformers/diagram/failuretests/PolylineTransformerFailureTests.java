/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.failuretests;

import com.topcoder.diagraminterchange.Polyline;

import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PolylineTransformer;


/**
 * <p>
 * Failure tests for class PolylineTransformer. Tests the exceptions in invalid condition.
 * </p>
 *
 * @author magicpig
 * @version 1.0
 */
public class PolylineTransformerFailureTests extends TransformerFailureBase {
    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        element = new Polyline();
        suhClassName = "PolylineTransformerFailureTests";
        this.instance = new PolylineTransformer();
    }
}
