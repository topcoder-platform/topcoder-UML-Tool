/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;

/**
 * <p>
 * Test the functionality of <code>ChangeNavigableActionTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeNavigableActionTest extends TestCase {
    /**
     * Represents the ChangeNavigableAction instance used for tests.
     */
    private ChangeNavigableAction testChangeNavigableAction;

    /**
     * Represents the association end model element to change the navigable.
     */
    private AssociationEnd element;

    /**
     * Represents the old navigable of the model element before the action performed.
     */
    private final boolean oldNavigable = true;

    /**
     * Represents the new navigable of the model element the action will performed.
     */
    private final boolean newNavigable = false;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new AssociationEndImpl();
        element.setNavigable(oldNavigable);
        testChangeNavigableAction = new ChangeNavigableAction(element, newNavigable);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The navigable value of the ModelElememt should be set
     * to oldNavigable;
     */
    public void testUndoAction() {
        testChangeNavigableAction.undoAction();
        assertEquals("ChangeNavigableAction undoAction incorrectly.", oldNavigable, element.isNavigable());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The navigable value of the ModelElememt should be set
     * to newNavigable;
     */
    public void testRedoAction() {
        testChangeNavigableAction.redoAction();
        assertEquals("ChangeNavigableAction redoAction incorrectly.", newNavigable, element.isNavigable());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The navigable value of the ModelElememt should be
     * set to newNavigable;
     */
    public void testExecuteAction() {
        testChangeNavigableAction.executeAction();
        assertEquals("ChangeNavigableAction executeAction incorrectly.", newNavigable, element.isNavigable());
    }

    /**
     * Test ChangeNavigableAction constructor.
     */
    public void testChangeNavigableActionConstructor() {
        UndoableAbstractAction action = new ChangeNavigableAction(element, oldNavigable);
        assertNotNull("Create ChangeNavigableAction incorrectly.", action);
    }

    /**
     * Test ChangeNavigableAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeNavigableActionConstructorNullElement() {
        try {
            new ChangeNavigableAction(null, oldNavigable);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
