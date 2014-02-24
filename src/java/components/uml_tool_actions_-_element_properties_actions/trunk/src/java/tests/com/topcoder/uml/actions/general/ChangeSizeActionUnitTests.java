/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.UnitTestsHelper;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the ChangeSizeAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class ChangeSizeActionUnitTests extends TestCase {
    /**
     * Represents the ChangeSizeAction instance used for tests.
     */
    private ChangeSizeAction testChangeSizeAction;

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
        node = new GraphNode();
        oldSize = new Dimension();
        oldSize.setHeight(1.0);
        oldSize.setWidth(1.0);
        newSize = new Dimension();
        newSize.setHeight(2.0);
        newSize.setWidth(2.0);
        node.setSize(oldSize);
        testChangeSizeAction = new ChangeSizeAction(node, newSize);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The size of the GraphNode should
     * be set to oldSize.
     */
    public void testUndoAction() {
        testChangeSizeAction.undoAction();
        assertEquals("ChangeSizeAction undoAction incorrectly", oldSize, node.getSize());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The size of the GraphNode should
     * be set to newSize.
     */
    public void testRedoAction() {
        testChangeSizeAction.redoAction();
        assertEquals("ChangeSizeAction redoAction incorrectly", newSize, node.getSize());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The size of the GraphNode
     * should be set to newSize.
     */
    public void testExecuteAction() {
        testChangeSizeAction.executeAction();
        assertEquals("ChangeSizeAction redoAction incorrectly", newSize, node.getSize());
    }

    /**
     * Test ChangeSizeAction constructor.
     */
    public void testChangeSizeAction() {
        UndoableAbstractAction action = new ChangeSizeAction(node, newSize);
        assertNotNull("Create ChangeSizeAction incorrectly.", action);
        assertEquals("Create ChangeSizeAction incorrectly.", newSize,
                UnitTestsHelper.getObjectFieldValue(action, "newSize"));
        assertEquals("Create ChangeSizeAction incorrectly.", node,
                UnitTestsHelper.getObjectFieldValue(action, "node"));
    }

    /**
     * Test ChangeSizeAction constructor with null node. Should throw IllegalArgumentException.
     */
    public void testChangeSizeActionNullNode() {
        try {
            new ChangeSizeAction(null, newSize);
            fail("IllegalArgumentException should be thrown when the passed node is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeSizeAction constructor with null newSize. Should throw IllegalArgumentException.
     */
    public void testChangeSizeActionNullNewSize() {
        try {
            new ChangeSizeAction(node, null);
            fail("IllegalArgumentException should be thrown when the passed new size is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
