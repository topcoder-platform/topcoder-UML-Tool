/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.failuretests;

import com.topcoder.diagraminterchange.DiagramLink;

import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DiagramLinkTransformer;


/**
 * <p>
 * Failure tests for class DiagramLinkTransformer. Tests the exceptions in invalid condition.
 * </p>
 *
 * @author magicpig
 * @version 1.0
 */
public class DiagramLinkTransformerFailureTests extends TransformerFailureBase {
    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        element = new DiagramLink();
        suhClassName = "DiagramLinkTransformerFailureTests";
        this.instance = new DiagramLinkTransformer();
    }
}
