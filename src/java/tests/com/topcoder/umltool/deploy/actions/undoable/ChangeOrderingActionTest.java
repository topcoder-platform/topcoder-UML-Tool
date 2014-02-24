/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.OrderingKind;

/**
 * <p>
 * Test the functionality of <code>ChangeOrderingActionTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeOrderingActionTest extends TestCase {
    /**
     * Represents the ChangeOrderingAction instance used for tests.
     */
    private ChangeOrderingAction testChangeOrderingAction;

    /**
     * Represents the association end model element to change the ordering.
     */
    private AssociationEnd element;

    /**
     * Represents the old ordering kind of the model element before the action performed.
     */
    private final OrderingKind oldOrdering = OrderingKind.ORDERED;

    /**
     * Represents the new ordering kind of the model element the action will performed.
     */
    private final OrderingKind newOrdering = OrderingKind.UNORDERED;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new AssociationEndImpl();
        element.setOrdering(oldOrdering);
        testChangeOrderingAction = new ChangeOrderingAction(element, newOrdering);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The ordering value of the ModelElememt should be set
     * to oldOrdering;
     */
    public void testUndoAction() {
        testChangeOrderingAction.undoAction();
        assertEquals("ChangeOrderingAction undoAction incorrectly.", oldOrdering, element.getOrdering());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The ordering value of the ModelElememt should be set
     * to newOrdering;
     */
    public void testRedoAction() {
        testChangeOrderingAction.redoAction();
        assertEquals("ChangeOrderingAction redoAction incorrectly.", newOrdering, element.getOrdering());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The ordering value of the ModelElememt should be
     * set to newOrdering;
     */
    public void testExecuteAction() {
        testChangeOrderingAction.executeAction();
        assertEquals("ChangeOrderingAction executeAction incorrectly.", newOrdering, element.getOrdering());
    }

    /**
     * Test ChangeOrderingAction constructor.
     */
    public void testChangeOrderingActionConstructor() {
        UndoableAbstractAction action = new ChangeOrderingAction(element, oldOrdering);
        assertNotNull("Create ChangeOrderingAction incorrectly.", action);
    }

    /**
     * Test ChangeOrderingAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeOrderingActionConstructorNullElement() {
        try {
            new ChangeOrderingAction(null, oldOrdering);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeOrderingAction constructor with null new ordering kind. Should throw IllegalArgumentException.
     */
    public void testChangeOrderingActionConstructorNullNewOrdering() {
        try {
            new ChangeOrderingAction(element, null);
            fail("IllegalArgumentException should be thrown when the passed new ordering is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

}
