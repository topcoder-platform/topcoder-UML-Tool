/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.accuracytests;

import java.util.Collection;

import com.topcoder.uml.model.core.GeneralizableElementAbstractImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy tests for <code>GeneralizableElementAbstractImpl</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class GeneralizableElementAbstractImplAccuracyTests extends TestCase {

    /** Represents the <code>GeneralizableElementAbstractImpl</code> instance used for testing. */
    private GeneralizableElementAbstractImpl element;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        //creates the mocked GeneralizableElementAbstractImpl instance
        element = new MockGeneralizableElementImpl();
    }

    /**
     * Accuracy test of method <code>setRoot(boolean)</code> and <code>isRoot()</code>.
     */
    public void testRootSetterAndGetter() {
        //initial value is false
        assertFalse(element.isRoot());
        //sets the Root with true
        element.setRoot(true);
        assertTrue(element.isRoot());
        //sets the Root with false
        element.setRoot(false);
        assertFalse(element.isRoot());
    }

    /**
     * Accuracy test of method <code>setLeaf(boolean)</code> and <code>isLeaf()</code>.
     */
    public void testLeafSetterAndGetter() {
        //initial value is false
        assertFalse(element.isLeaf());
        //sets the Leaf with true
        element.setLeaf(true);
        assertTrue(element.isLeaf());
        //sets the Leaf with false
        element.setLeaf(false);
        assertFalse(element.isLeaf());
    }

    /**
     * Accuracy test of method <code>setAbstract(boolean)</code> and <code>isAbstract()</code>.
     */
    public void testAbstractSetterAndGetter() {
        //initial value is false
        assertFalse(element.isAbstract());
        //sets the Abstract with true
        element.setAbstract(true);
        assertTrue(element.isAbstract());
        //sets the Abstract with false
        element.setAbstract(false);
        assertFalse(element.isAbstract());
    }

    /**
     * Accuracy test of method <code>addGeneralization(Generalization)</code>,
     * <code>removeGeneralization(Generalization)</code>, <code>containsGeneralization(Generalization)</code>,
     * <code>clearGeneralizations()</code>, <code>getGeneralizations()</code> and
     * <code>countGeneralizations()</code>.
     */
    public void testGeneralizationOperations() {
        //initial value is an empty ArrayList
        assertEquals(0, element.countGeneralizations());
        //add a Generalization
        Generalization generalization0 = new GeneralizationImpl();
        element.addGeneralization(generalization0);
        assertEquals(1, element.countGeneralizations());
        assertTrue(element.containsGeneralization(generalization0));
        //add another two Generalizations
        Generalization generalization1 = new GeneralizationImpl();
        element.addGeneralization(generalization1);
        Generalization generalization2 = generalization1;
        element.addGeneralization(generalization2);
        assertEquals(3, element.countGeneralizations());
        //get all the Generalizations
        Collection<Generalization> generalizations = element.getGeneralizations();
        assertEquals(3, generalizations.size());
        //remove a Generalization
        assertTrue(element.removeGeneralization(generalization1));
        assertEquals(2, element.countGeneralizations());
        assertFalse(element.removeGeneralization(new GeneralizationImpl()));
        //clear all the Generalizations
        element.clearGeneralizations();
        assertEquals(0, element.countGeneralizations());
    }

    /**
     * Accuracy test of method <code>addSpecialization(Generalization)</code>,
     * <code>removeSpecialization(Generalization)</code>, <code>containsSpecialization(Generalization)</code>,
     * <code>clearSpecializations()</code>, <code>getSpecializations()</code> and
     * <code>countSpecializations()</code>.
     */
    public void testSpecializationOperations() {
        //initial value is an empty ArrayList
        assertEquals(0, element.countSpecializations());
        //add a Specialization
        Generalization specialization0 = new GeneralizationImpl();
        element.addSpecialization(specialization0);
        assertEquals(1, element.countSpecializations());
        assertTrue(element.containsSpecialization(specialization0));
        //add another two Specializations
        Generalization specialization1 = new GeneralizationImpl();
        element.addSpecialization(specialization1);
        Generalization specialization2 = specialization1;
        element.addSpecialization(specialization2);
        assertEquals(3, element.countSpecializations());
        //get all the Specializations
        Collection<Generalization> specializations = element.getSpecializations();
        assertEquals(3, specializations.size());
        //remove a Specialization
        assertTrue(element.removeSpecialization(specialization1));
        assertEquals(2, element.countSpecializations());
        assertFalse(element.removeSpecialization(new GeneralizationImpl()));
        //clear all the Specializations
        element.clearSpecializations();
        assertEquals(0, element.countSpecializations());
    }
}
