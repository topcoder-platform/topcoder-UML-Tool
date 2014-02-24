/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;

/**
 * <p>
 * Test the functionality of <code>ChangeMultiplicityActionTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeMultiplicityActionTest extends TestCase {
    /**
     * Represents the ChangeMultiplicityAction instance used for tests.
     */
    private ChangeMultiplicityAction testChangeMultiplicityAction;

    /**
     * Represents the association end model element to change the multiplicity.
     */
    private AssociationEnd element;

    /**
     * Represents the old multiplicity of the model element before the action performed.
     */
    private final Multiplicity oldMultiplicity = new MultiplicityImpl();

    /**
     * Represents the new multiplicity of the model element the action will performed.
     */
    private final Multiplicity newMultiplicity = new MultiplicityImpl();

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new AssociationEndImpl();
        element.setMultiplicity(oldMultiplicity);
        testChangeMultiplicityAction = new ChangeMultiplicityAction(element, newMultiplicity);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The multiplicity value of the ModelElememt should be
     * set to oldMultiplicity;
     */
    public void testUndoAction() {
        testChangeMultiplicityAction.undoAction();
        assertEquals("ChangeMultiplicityAction undoAction incorrectly.", oldMultiplicity, element.getMultiplicity());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The multiplicity value of the ModelElememt should be
     * set to newMultiplicity;
     */
    public void testRedoAction() {
        testChangeMultiplicityAction.redoAction();
        assertEquals("ChangeMultiplicityAction redoAction incorrectly.", newMultiplicity, element.getMultiplicity());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The multiplicity value of the ModelElememt should
     * be set to newMultiplicity;
     */
    public void testExecuteAction() {
        testChangeMultiplicityAction.executeAction();
        assertEquals("ChangeMultiplicityAction executeAction incorrectly.", newMultiplicity, element.getMultiplicity());
    }

    /**
     * Test ChangeMultiplicityAction constructor.
     */
    public void testChangeMultiplicityActionConstructor() {
        UndoableAbstractAction action = new ChangeMultiplicityAction(element, oldMultiplicity);
        assertNotNull("Create ChangeMultiplicityAction incorrectly.", action);
    }

    /**
     * Test ChangeMultiplicityAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeMultiplicityActionConstructorNullElement() {
        try {
            new ChangeMultiplicityAction(null, oldMultiplicity);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeMultiplicityAction constructor with null new multiplicity. Should throw IllegalArgumentException.
     */
    public void testChangeMultiplicityActionConstructorNullNewMultiplicity() {
        try {
            new ChangeMultiplicityAction(element, null);
            fail("IllegalArgumentException should be thrown when the passed new multiplicity is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

}
