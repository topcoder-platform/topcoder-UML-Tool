/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.topcoder.uml.actions.UnitTestsHelper;
import com.topcoder.uml.actions.general.operationtypes.SetEntityStereotypesOperationType;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the SetEntityStereotypesAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class SetEntityStereotypesActionUnitTests extends TestCase {
    /**
     * Represents the SetEntityStereotypesAction instance used for tests.
     */
    private SetEntityStereotypesAction testSetEntityStereotypesAction;

    /**
     * Represents the model element to update the stereotype.
     */
    private ModelElement element;

    /**
     * Represents the old stereotypes of the element before this action performed.
     */
    private Set<Stereotype> oldStereotypes;

    /**
     * Represents the new stereotypes of the elements after this action performed.
     */
    private Set<Stereotype> newStereotypes;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new OperationImpl();
        oldStereotypes = new HashSet<Stereotype>();
        newStereotypes = new HashSet<Stereotype>();
        for (int i = 0; i < 3; ++i) {
            Stereotype type = new StereotypeImpl();
            element.addStereotype(type);
            oldStereotypes.add(type);
            newStereotypes.add(new StereotypeImpl());
        }
        testSetEntityStereotypesAction = new SetEntityStereotypesAction(element, newStereotypes,
                SetEntityStereotypesOperationType.ADD);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. newStereotypes should be removed
     * from the ModelElement.
     */
    public void testUndoAction() {
        testSetEntityStereotypesAction.undoAction();
        Iterator<Stereotype> iter = newStereotypes.iterator();
        while (iter.hasNext()) {
            assertFalse("SetEntityStereotypesAction undoAction incorrectly", element.containsStereotype(iter.next()));
        }
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. newStereotypes should be added
     * from the ModelElement.
     */
    public void testRedoAction() {
        testSetEntityStereotypesAction.redoAction();
        Iterator<Stereotype> iter = newStereotypes.iterator();
        while (iter.hasNext()) {
            assertTrue("SetEntityStereotypesAction redoAction incorrectly", element.containsStereotype(iter.next()));
        }
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. newStereotypes should be added
     * from the ModelElement.
     */
    public void testExecuteAction() {
        testSetEntityStereotypesAction.executeAction();
        Iterator<Stereotype> iter = newStereotypes.iterator();
        while (iter.hasNext()) {
            assertTrue("SetEntityStereotypesAction undoAction incorrectly",
                    element.containsStereotype(iter.next()));
        }
    }

    /**
     * Test SetEntityStereotypesAction constructor.
     */
    public void testSetEntityStereotypesAction() {
        assertNotNull("Create SetEntityStereotypesAction incorrectly.", testSetEntityStereotypesAction);
        assertEquals("Create SetEntityStereotypesAction incorrectly.", element,
                UnitTestsHelper.getObjectFieldValue(testSetEntityStereotypesAction, "element"));
        assertEquals("Create SetEntityStereotypesAction incorrectly.", newStereotypes,
                UnitTestsHelper.getObjectFieldValue(testSetEntityStereotypesAction, "newStereotypes"));
        assertEquals("Create SetEntityStereotypesAction incorrectly.", SetEntityStereotypesOperationType.ADD,
                UnitTestsHelper.getObjectFieldValue(testSetEntityStereotypesAction, "operationType"));
    }

    /**
     * Test SetEntityStereotypesAction constructor with null element. Should throw
     * IllegalArgumentException.
     */
    public void testSetEntityStereotypesActionNullElement() {
        try {
            new SetEntityStereotypesAction(null, newStereotypes, SetEntityStereotypesOperationType.ADD);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test SetEntityStereotypesAction constructor with null newStereotypes. Should throw
     * IllegalArgumentException.
     */
    public void testSetEntityStereotypesActionNullNewStereotypes() {
        try {
            new SetEntityStereotypesAction(element, null, SetEntityStereotypesOperationType.ADD);
            fail("IllegalArgumentException should be thrown when the passed stereotypes is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test SetEntityStereotypesAction constructor with newStereotypes contains null. Should throw
     * IllegalArgumentException.
     */
    public void testSetEntityStereotypesActionStereotypesContiansNull() {
        try {
            Set<Stereotype> types = new HashSet<Stereotype>();
            types.add(null);
            new SetEntityStereotypesAction(element, types, SetEntityStereotypesOperationType.ADD);
            fail("IllegalArgumentException should be thrown when the passed stereotypes contains null element.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test SetEntityStereotypesAction constructor with null set kind. Should throw
     * IllegalArgumentException.
     */
    public void testSetEntityStereotypesActionNullSetKind() {
        try {
            new SetEntityStereotypesAction(element, newStereotypes, null);
            fail("IllegalArgumentException should be thrown when the passed kind is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
