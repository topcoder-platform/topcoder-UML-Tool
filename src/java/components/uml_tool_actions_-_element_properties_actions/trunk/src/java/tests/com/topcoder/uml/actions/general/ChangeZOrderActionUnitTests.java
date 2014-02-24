/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import com.topcoder.uml.actions.UnitTestsHelper;
import com.topcoder.uml.actions.general.operationtypes.ChangeZOrderOperationType;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the ChangeZOrderAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class ChangeZOrderActionUnitTests extends TestCase {
    /**
     * Represents the ChangeZOrderAction instance used for tests.
     */
    private ChangeZOrderAction testChangeZOrderAction;

    /**
     * Represents the graph element to change the z-order.
     */
    private GraphElement element;

    /**
     * Represents the old z-order of the graph element before this action performed.
     */
    private int oldZOrder;

    /**
     * Represents the new z-order of the graph element after this action performed.
     */
    private int newZOrder;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        oldZOrder = 0;
        newZOrder = 1;
        element = new GraphNode();
        GraphElement node = new GraphNode();
        element.setContainer(node);
        node.addContained(element);
        node.addContained(new GraphNode());
        testChangeZOrderAction = new ChangeZOrderAction(element, ChangeZOrderOperationType.FORWARD);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The Z-order of the element should
     * be changed to 0.
     */
    public void testUndoAction() {
        testChangeZOrderAction.redoAction();
        testChangeZOrderAction.undoAction();
        assertEquals("ChangeZOrderAction undoAction incorrectly", oldZOrder, element.getContainer().getContaineds()
                .indexOf(element));
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The Z-order of the element should
     * be changed to 1.
     */
    public void testRedoAction() {
        testChangeZOrderAction.redoAction();
        assertEquals("ChangeZOrderAction redoAction incorrectly", newZOrder, element.getContainer().getContaineds()
                .indexOf(element));
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The Z-order of the element
     * should be changed to 1.
     */
    public void testExecuteAction() {
        try {
            testChangeZOrderAction.executeAction();
            assertEquals("ChangeZOrderAction executeAction incorrectly", newZOrder, element.getContainer()
                    .getContaineds().indexOf(element));
        } catch (ActionExecutionException e) {
            fail("The index of the element should be changed to newZOrder.");
        }
    }

    /**
     * Test ChangeZOrderAction constructor.
     */
    public void testChangeZOrderAction() {
        assertNotNull("Create ChangeZOrderAction incorrectly.", testChangeZOrderAction);
        assertEquals("Create ChangeZOrderAction incorrectly.", oldZOrder,
                UnitTestsHelper.getObjectFieldValue(testChangeZOrderAction, "oldZOrder"));
        assertEquals("Create ChangeZOrderAction incorrectly.", newZOrder,
                UnitTestsHelper.getObjectFieldValue(testChangeZOrderAction, "newZOrder"));
        assertEquals("Create ChangeZOrderAction incorrectly.", element.getContainer().getContaineds(),
                ((GraphElement)UnitTestsHelper.getObjectFieldValue(testChangeZOrderAction, "container")).getContaineds());
    }

    /**
     * Test ChangeZOrderAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeZOrderActionNullElement() {
        try {
            new ChangeZOrderAction(null, ChangeZOrderOperationType.TOBACK);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeZOrderAction constructor with null change kind. Should throw
     * IllegalArgumentException.
     */
    public void testChangeZOrderActionNullChangeKind() {
        try {
            new ChangeZOrderAction(new GraphNode(), null);
            fail("IllegalArgumentException should be thrown when the passed changeKind is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeZOrderAction constructor with null change kind. Should throw
     * IllegalArgumentException.
     */
    public void testChangeZOrderActionElementNullContainer() {
        try {
            new ChangeZOrderAction(new GraphNode(), ChangeZOrderOperationType.BACKWARD);
            fail("IllegalArgumentException should be thrown when the passed graphNode has null container.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
