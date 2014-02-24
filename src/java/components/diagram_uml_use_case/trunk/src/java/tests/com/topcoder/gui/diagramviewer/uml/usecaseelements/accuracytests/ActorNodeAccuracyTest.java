/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.accuracytests;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ActorNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IllegalGraphElementException;

/**
 * Accuracy test for AcotorNode.
 * 
 * @author radium
 * @version 1.0
 */
public class ActorNodeAccuracyTest extends TestCase {
    /**
     * Sample GraphNode for testing.
     */
    private GraphNode graphNode;

    /**
     * Sample ActorNode for testing.
     */
    private ActorNode actorNode;

    /**
     * Set up the environment for testing.
     */
    protected void setUp() throws Exception {
        graphNode = AccuracyTestHelper.createGraphNodeForActor();
        Map hashMap = new HashMap<String, String>();
        hashMap.put("String", "String");
        actorNode = new ActorNode(graphNode, hashMap);
    }

    /**
     * Test method for contains(int, int).
     */
    public void testContainsIntInt() {
        assertTrue("Should be true.", this.actorNode.contains(20, 20));
        assertTrue("should be true.", this.actorNode.contains(90, 90));
        assertFalse("should be false.", this.actorNode.contains(200, 200));
    }

    /**
     * Test method for notifyGraphNodeChange(String).
     * 
     * @throws IllegalGraphElementException
     *             if error occurs.
     */
    public void testNotifyGraphNodeChange() throws IllegalGraphElementException {
        graphNode.setSize(AccuracyTestHelper.createDimension(1000, 1000));
        actorNode.notifyGraphNodeChange("hello world.");
        assertTrue("Should be true.", actorNode.contains(900, 900));
    }

    /**
     * Test method for getPreferredGraphNodeSize(). Because the developer can
     * choose the preferredSize freely, this test just test whether it is run
     * successfully.
     */
    public void testGetPreferredGraphNodeSize() {
        actorNode.getPreferredGraphNodeSize();
    }
}
