/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.failuretests;

import com.topcoder.diagraminterchange.GraphConnector;

import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphConnectorTransformer;


/**
 * <p>
 * Failure tests for class GraphConnectorTransformer. Tests the exceptions in invalid condition.
 * </p>
 *
 * @author magicpig
 * @version 1.0
 */
public class GraphConnectorTransformerFailureTests extends TransformerFailureBase {
    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        element = new GraphConnector();
        suhClassName = "GraphConnectorTransformerFailureTests";
        this.instance = new GraphConnectorTransformer();
    }
}
