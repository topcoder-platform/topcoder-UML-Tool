/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.general.ChangeSizeAction;

/**
 * Aggregates all failure tests for ChangeSizeAction class.
 * @author vilain
 * @version 1.0
 */
public class ChangeSizeActionFailureTest extends TestCase {

    /**
     * Constructor under test ChangeSizeAction(GraphNode, Dimension). Failure
     * testing of exception in case node is null.
     */
    public final void testChangeSizeActionFailureNodeNull() {
        try {
            new ChangeSizeAction(null, new Dimension());
            fail("IllegalArgumentException is expected since node is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test ChangeSizeAction(GraphNode , Dimension). Failure
     * testing of exception in case size is null.
     */
    public final void testChangeSizeActionFailureSizeNull() {
        try {
            new ChangeSizeAction(new GraphNode() {
            }, null);
            fail("IllegalArgumentException is expected since size is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}