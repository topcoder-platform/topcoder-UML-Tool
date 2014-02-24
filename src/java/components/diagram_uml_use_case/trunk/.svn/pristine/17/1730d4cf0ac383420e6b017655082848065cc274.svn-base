/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.accuracytests;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IllegalGraphElementException;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;

/**
 * Accuracy test for UseCaseNode.
 *
 * @author radium
 * @version 1.0
 */
public class UseCaseNodeAccuracyTest extends TestCase {
    /**
     * Sample UseCaseNode for testing.
     */
    private UseCaseNode ucn;

    /**
     * Sample GraphNode for testing.
     */
    private GraphNode graphNode;

    /**
     * Set up the environment for testing.
     */
    protected void setUp() throws Exception {
        graphNode = AccuracyTestHelper.createGraphNodeForUseCase();
        Map hashMap = new HashMap<String, String>();
        hashMap.put("String", "String");
        ucn = new UseCaseNode(graphNode, hashMap);
    }

    /**
     * Test method for contains(int, int).
     */
    public void testContainsIntInt() {
        assertTrue("Should be true.", ucn.contains(20, 20));
        assertFalse("Should be false.", ucn.contains(200, 200));
    }

    /**
     * Test method for notifyGraphNodeChange(String).
     *
     * @throws IllegalGraphElementException
     *             if error occurs.
     */
    public void testNotifyGraphNodeChange() throws IllegalGraphElementException {
        ucn.getGraphNode().setSize(AccuracyTestHelper.createDimension(200, 200));
        ucn.notifyGraphNodeChange("hello");
        assertTrue("Should be true.", ucn.contains(150, 150));
    }
}
