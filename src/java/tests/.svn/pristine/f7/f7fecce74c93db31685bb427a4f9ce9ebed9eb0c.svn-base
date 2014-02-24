/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.ChangeableKind;

/**
 * <p>
 * Test the functionality of <code>ChangeChangeabilityActionTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeChangeabilityActionTest extends TestCase {
    /**
     * Represents the ChangeChangeabilityAction instance used for tests.
     */
    private ChangeChangeabilityAction testChangeChangeabilityAction;

    /**
     * Represents the association end model element to change the changeability.
     */
    private AssociationEnd element;

    /**
     * Represents the old changeability of the model element before the action performed.
     */
    private final ChangeableKind oldChangeability = ChangeableKind.ADD_ONLY;

    /**
     * Represents the new changeability of the model element the action will performed.
     */
    private final ChangeableKind newChangeability = ChangeableKind.CHANGEABLE;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new AssociationEndImpl();
        element.setChangeability(oldChangeability);
        testChangeChangeabilityAction = new ChangeChangeabilityAction(element, newChangeability);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The changeability value of the ModelElememt should be
     * set to oldChangeability;
     */
    public void testUndoAction() {
        testChangeChangeabilityAction.undoAction();
        assertEquals("ChangeChangeabilityAction undoAction incorrectly.", oldChangeability, element.getChangeability());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The changeability value of the ModelElememt should be
     * set to newChangeability;
     */
    public void testRedoAction() {
        testChangeChangeabilityAction.redoAction();
        assertEquals("ChangeChangeabilityAction redoAction incorrectly.", newChangeability, element.getChangeability());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The changeability value of the ModelElememt should
     * be set to newChangeability;
     */
    public void testExecuteAction() {
        testChangeChangeabilityAction.executeAction();
        assertEquals("ChangeChangeabilityAction executeAction incorrectly.", newChangeability, element
                .getChangeability());
    }

    /**
     * Test ChangeChangeabilityAction constructor.
     */
    public void testChangeChangeabilityActionConstructor() {
        UndoableAbstractAction action = new ChangeChangeabilityAction(element, oldChangeability);
        assertNotNull("Create ChangeChangeabilityAction incorrectly.", action);
    }

    /**
     * Test ChangeChangeabilityAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeChangeabilityActionConstructorNullElement() {
        try {
            new ChangeChangeabilityAction(null, oldChangeability);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeChangeabilityAction constructor with null new changeability kind. Should throw
     * IllegalArgumentException.
     */
    public void testChangeChangeabilityActionConstructorNullNewChangeability() {
        try {
            new ChangeAggregationAction(element, null);
            fail("IllegalArgumentException should be thrown when the passed new changeability is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

}
