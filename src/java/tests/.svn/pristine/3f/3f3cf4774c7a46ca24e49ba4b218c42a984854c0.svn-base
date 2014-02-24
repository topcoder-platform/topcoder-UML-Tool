/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.AggregationKind;

/**
 * <p>
 * Test the functionality of <code>ChangeAggregationActionTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeAggregationActionTest extends TestCase {
    /**
     * Represents the ChangeAggregationAction instance used for tests.
     */
    private ChangeAggregationAction testChangeAggregationAction;

    /**
     * Represents the association end model element to change the aggregation.
     */
    private AssociationEnd element;

    /**
     * Represents the old aggregation kind of the model element before the action performed.
     */
    private final AggregationKind oldAggregation = AggregationKind.AGGREGATE;

    /**
     * Represents the new aggregation kind of the model element the action will performed.
     */
    private final AggregationKind newAggregation = AggregationKind.COMPOSITE;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new AssociationEndImpl();
        element.setAggregation(oldAggregation);
        testChangeAggregationAction = new ChangeAggregationAction(element, newAggregation);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The aggregation value of the ModelElememt should be
     * set to oldAggregation;
     */
    public void testUndoAction() {
        testChangeAggregationAction.undoAction();
        assertEquals("ChangeAggregationAction undoAction incorrectly.", oldAggregation, element.getAggregation());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The aggregation value of the ModelElememt should be
     * set to newAggregation;
     */
    public void testRedoAction() {
        testChangeAggregationAction.redoAction();
        assertEquals("ChangeAggregationAction redoAction incorrectly.", newAggregation, element.getAggregation());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The aggregation value of the ModelElememt should be
     * set to newAggregation;
     */
    public void testExecuteAction() {
        testChangeAggregationAction.executeAction();
        assertEquals("ChangeAggregationAction executeAction incorrectly.", newAggregation, element.getAggregation());
    }

    /**
     * Test ChangeAggregationAction constructor.
     */
    public void testChangeAggregationActionConstructor() {
        UndoableAbstractAction action = new ChangeAggregationAction(element, oldAggregation);
        assertNotNull("Create ChangeAggregationAction incorrectly.", action);
    }

    /**
     * Test ChangeAggregationAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeAggregationActionConstructorNullElement() {
        try {
            new ChangeAggregationAction(null, oldAggregation);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeAggregationAction constructor with null new aggregation kind. Should throw IllegalArgumentException.
     */
    public void testChangeAggregationActionConstructorNullNewAggregation() {
        try {
            new ChangeAggregationAction(element, null);
            fail("IllegalArgumentException should be thrown when the passed new aggregation is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
