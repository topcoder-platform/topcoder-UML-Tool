/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.general.ChangeSizeAction;

/**
 * Accuracy test cases for ChangeSizeAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class ChangeSizeActionAccuracyTest extends TestCase {
    /**
     * Represents the ChangeSizeAction instance used for tests.
     */
    private ChangeSizeAction instance;

    /**
     * Represents the graph node to be changing the size.
     */
    private GraphNode node;

    /**
     * Represents the old size of the graph node before this action performed.
     */
    private Dimension oldSize;

    /**
     * Represents the new size of the graph node after this action performed.
     */
    private Dimension newSize;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        AccuracyHelper.loadDefaultConfig();
        node = new GraphNode();
        oldSize = new Dimension();
        oldSize.setHeight(1.0);
        oldSize.setWidth(1.0);
        newSize = new Dimension();
        newSize.setHeight(2.0);
        newSize.setWidth(2.0);
        node.setSize(oldSize);
        instance = new ChangeSizeAction(node, newSize);
    }

    /**
     * Clear the environment.
     */
    protected void tearDown() {
        AccuracyHelper.unloadConfig();
    }

    /**
     * Test undoAction().
     */
    public void testUndoAction() {
        instance.undoAction();
        assertEquals("undoAction() is incorrect.", oldSize, node.getSize());
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.undoAction();
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", newSize, node.getSize());
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {

        instance.executeAction();
        assertEquals("executeAction() is incorrect.", newSize, node.getSize());
    }

    /**
     * Test constructor.
     */
    public void testChangeSizeAction() {
        assertEquals("node is incorrect.", node, AccuracyHelper.getObjectFieldValue(instance,
            "node"));
        assertEquals("oldSize is incorrect.", oldSize, AccuracyHelper.getObjectFieldValue(instance,
            "oldSize"));
        assertEquals("newSize is incorrect.", newSize, AccuracyHelper.getObjectFieldValue(instance,
            "newSize"));
    }

}
