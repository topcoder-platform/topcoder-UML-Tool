/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.failuretests;

import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.Uml1SemanticModelBridgeTransformer;


/**
 * <p>
 * Failure tests for class Uml1SemanticModelBridgeTransformer. Tests the exceptions in invalid
 * condition.
 * </p>
 *
 * @author magicpig
 * @version 1.0
 */
public class Uml1SemanticModelBridgeTransformerFailureTests extends TransformerFailureBase {
    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        element = new Uml1SemanticModelBridge();
        suhClassName = "Uml1SemanticModelBridgeTransformerFailureTests";
        this.instance = new Uml1SemanticModelBridgeTransformer();
    }
}
