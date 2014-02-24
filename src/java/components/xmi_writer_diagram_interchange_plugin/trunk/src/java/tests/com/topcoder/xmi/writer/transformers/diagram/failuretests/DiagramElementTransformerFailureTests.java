/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.failuretests;

import com.topcoder.diagraminterchange.DiagramElement;

import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DiagramElementTransformer;


/**
 * <p>
 * Failure tests for class DiagramElementTransformer. Tests the exceptions in invalid condition.
 * </p>
 *
 * @author magicpig
 * @version 1.0
 */
public class DiagramElementTransformerFailureTests extends TransformerFailureBase {
    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        element = new MockDiagramElement();
        suhClassName = "DiagramElementTransformerFailureTests";
        this.instance = new DiagramElementTransformer();
    }

    /**
     * Mock class of DiagramElement.
     *
     * @author magicpig
     * @version 1.0
     */
    public class MockDiagramElement extends DiagramElement {
    }
}
