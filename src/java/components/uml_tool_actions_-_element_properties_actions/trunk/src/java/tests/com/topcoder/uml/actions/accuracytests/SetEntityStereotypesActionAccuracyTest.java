/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.SetEntityStereotypesAction;
import com.topcoder.uml.actions.general.operationtypes.SetEntityStereotypesOperationType;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;

/**
 * Accuracy test cases for SetEntityStereotypesAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class SetEntityStereotypesActionAccuracyTest extends TestCase {
    /**
     * Represents the SetEntityStereotypesAction instance used for tests.
     */
    private SetEntityStereotypesAction instance;

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
        AccuracyHelper.loadDefaultConfig();
        element = new OperationImpl();
        oldStereotypes = new HashSet<Stereotype>();
        newStereotypes = new HashSet<Stereotype>();
        for (int i = 0; i < 3; ++i) {
            Stereotype type = new StereotypeImpl();
            element.addStereotype(type);
            oldStereotypes.add(type);
        }
        for (int i = 0; i < 2; i++) {
            newStereotypes.add(new StereotypeImpl());
        }
        instance = new SetEntityStereotypesAction(element, newStereotypes,
            SetEntityStereotypesOperationType.ADD);
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
        instance.redoAction();
        instance.undoAction();
        Iterator<Stereotype> iter = newStereotypes.iterator();
        while (iter.hasNext()) {
            assertFalse("undoAction() is incorrect.", element.containsStereotype(iter.next()));
        }
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction2() {
        instance = new SetEntityStereotypesAction(element, oldStereotypes,
            SetEntityStereotypesOperationType.REMOVE);
        instance.redoAction();
        Iterator<Stereotype> iter = oldStereotypes.iterator();
        while (iter.hasNext()) {
            assertFalse("redoAction() is incorrect.", element.containsStereotype(iter.next()));
        }
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.redoAction();
        Iterator<Stereotype> iter = newStereotypes.iterator();
        while (iter.hasNext()) {
            assertTrue("redoAction() is incorrect.", element.containsStereotype(iter.next()));
        }
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {

        instance.executeAction();
        Iterator<Stereotype> iter = newStereotypes.iterator();
        while (iter.hasNext()) {
            assertTrue("executeAction() is incorrect.", element.containsStereotype(iter.next()));
        }
    }

    /**
     * Test constructor.
     */
    public void testSetEntityStereotypesAction1() {
        assertEquals("element is incorrect.", element, AccuracyHelper.getObjectFieldValue(instance,
            "element"));

        Set resStereotype = (Set) AccuracyHelper.getObjectFieldValue(instance, "newStereotypes");
        Iterator<Stereotype> iter = newStereotypes.iterator();
        while (iter.hasNext()) {
            assertTrue("newStereotypes is incorrect.", resStereotype.contains(iter.next()));
        }
        assertNull("oldStereotypes is incorrect.", AccuracyHelper.getObjectFieldValue(instance,
            "oldStereotypes"));

    }

    /**
     * Test constructor.
     */
    public void testSetEntityStereotypesAction2() {
        instance = new SetEntityStereotypesAction(element, newStereotypes,
            SetEntityStereotypesOperationType.REMOVE);
        assertEquals("element is incorrect.", element, AccuracyHelper.getObjectFieldValue(instance,
            "element"));
        Set resStereotype = (Set) AccuracyHelper.getObjectFieldValue(instance, "newStereotypes");
        Iterator<Stereotype> iter = newStereotypes.iterator();
        while (iter.hasNext()) {
            assertTrue("newStereotypes is incorrect.", resStereotype.contains(iter.next()));
        }
        assertNull("oldStereotypes is incorrect.", AccuracyHelper.getObjectFieldValue(instance,
            "oldStereotypes"));
    }

    /**
     * Test constructor.
     */
    public void testSetEntityStereotypesAction3() {
        instance = new SetEntityStereotypesAction(element, newStereotypes,
            SetEntityStereotypesOperationType.UPDATE);
        assertEquals("element is incorrect.", element, AccuracyHelper.getObjectFieldValue(instance,
            "element"));
        Set resStereotype = (Set) AccuracyHelper.getObjectFieldValue(instance, "oldStereotypes");
        Iterator<Stereotype> iter = oldStereotypes.iterator();
        while (iter.hasNext()) {
            assertTrue("oldStereotypes is incorrect.", resStereotype.contains(iter.next()));
        }
        resStereotype = (Set) AccuracyHelper.getObjectFieldValue(instance, "newStereotypes");
        iter = newStereotypes.iterator();
        while (iter.hasNext()) {
            assertTrue("newStereotypes is incorrect.", resStereotype.contains(iter.next()));
        }

    }
}
