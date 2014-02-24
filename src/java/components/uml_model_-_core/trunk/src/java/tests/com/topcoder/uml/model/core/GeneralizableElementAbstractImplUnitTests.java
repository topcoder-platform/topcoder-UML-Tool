/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import junit.framework.TestCase;
import java.util.Collection;
import java.util.ArrayList;

/**
 * <p>
 * Unit test for <code>GeneralizableElementAbstractImpl</code> class.
 * </p>
 *
 * @author vividmxx
 * @version 1.0
 */
public class GeneralizableElementAbstractImplUnitTests extends TestCase {
    /**
     * This class extends <code>GeneralizableElementAbstractImpl</code>. It is only used in unit test.
     */
    private class GeneralizableElementImpl extends GeneralizableElementAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public GeneralizableElementImpl() {
        }
    }

    /**
     * <p>
     * Represents the <code>GeneralizableElementAbstractImpl</code> instance used for tests.
     * </p>
     */
    private GeneralizableElementAbstractImpl testGeneralizableElementAbstractImpl;

    /**
     * <p>
     * Set up the test environment.
     * </p>
     */
    protected void setUp() {
        testGeneralizableElementAbstractImpl = new GeneralizableElementImpl();
    }

    /**
     * <p>
     * Accuracy test the <code>GeneralizableElementAbstractImpl()</code> constructor. GeneralizableElementAbstractImpl
     * instance should be created.
     * </p>
     */
    public void testGeneralizableElementAbstractImplConstructor() {
        assertNotNull("Create GeneralizableElementAbstractImpl object incorrectly.", new GeneralizableElementImpl());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setRoot(boolean)</code>, the <code>Root</code> field should be set.
     * </p>
     */
    public void testSetRoot() {
        testGeneralizableElementAbstractImpl.setRoot(true);
        assertEquals("The Root field should be set.", true, testGeneralizableElementAbstractImpl.isRoot());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>isRoot()</code>, the <code>Root</code> field should be returned.
     * </p>
     */
    public void testIsRoot() {
        testGeneralizableElementAbstractImpl.setRoot(false);
        assertEquals("The Root field should be get.", false, testGeneralizableElementAbstractImpl.isRoot());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setLeaf(boolean)</code>, the <code>Leaf</code> field should be set.
     * </p>
     */
    public void testSetLeaf() {
        testGeneralizableElementAbstractImpl.setLeaf(true);
        assertEquals("The Leaf field should be set.", true, testGeneralizableElementAbstractImpl.isLeaf());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>isLeaf()</code>, the <code>Leaf</code> field should be returned.
     * </p>
     */
    public void testIsLeaf() {
        testGeneralizableElementAbstractImpl.setLeaf(false);
        assertEquals("The Leaf field should be get.", false, testGeneralizableElementAbstractImpl.isLeaf());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setAbstract(boolean)</code>, the <code>Abstract</code> field should be
     * set.
     * </p>
     */
    public void testSetAbstract() {
        testGeneralizableElementAbstractImpl.setAbstract(false);
        assertEquals("The Abstract field should be set.", false, testGeneralizableElementAbstractImpl.isAbstract());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>isAbstract()</code>, the <code>Abstract</code> field should be
     * returned.
     * </p>
     */
    public void testIsAbstract() {
        testGeneralizableElementAbstractImpl.setAbstract(true);
        assertEquals("The Abstract field should be get.", true, testGeneralizableElementAbstractImpl.isAbstract());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addGeneralization(Generalization)</code>.
     * </p>
     */
    public void testAddGeneralization() {
        Generalization generalization = new GeneralizationImpl();
        testGeneralizableElementAbstractImpl.addGeneralization(generalization);
        assertTrue("Add generalization incorrectly.", testGeneralizableElementAbstractImpl
                .removeGeneralization(generalization));
    }

    /**
     * <p>
     * Test the method of <code>addGeneralization(Generalization)</code> with null generalization. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddGeneralizationNullGeneralization() {
        try {
            testGeneralizableElementAbstractImpl.addGeneralization(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeGeneralization(Generalization)</code>.
     * </p>
     */
    public void testRemoveGeneralization() {
        Generalization generalization = new GeneralizationImpl();
        testGeneralizableElementAbstractImpl.addGeneralization(generalization);
        assertTrue("Remove generalization incorrectly.", testGeneralizableElementAbstractImpl
                .removeGeneralization(generalization));
    }

    /**
     * <p>
     * Test the method of <code>removeGeneralization(Generalization)</code> with null generalization. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveGeneralizationNullGeneralization() {
        try {
            testGeneralizableElementAbstractImpl.removeGeneralization(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearGeneralizations()</code>.
     * <p>
     */
    public void testClearGeneralizations() {
        testGeneralizableElementAbstractImpl.clearGeneralizations();
        assertEquals("The count of generalization should be 0.", 0, testGeneralizableElementAbstractImpl
                .countGeneralizations());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getGeneralizations()</code>.
     * </p>
     */
    public void testGetGeneralizations() {
        testGeneralizableElementAbstractImpl.clearGeneralizations();
        Collection<Generalization> generalizations = new ArrayList<Generalization>();
        for (int i = 0; i < 3; ++i) {
            Generalization generalization = new GeneralizationImpl();
            generalizations.add(generalization);
            testGeneralizableElementAbstractImpl.addGeneralization(generalization);
        }
        assertEquals("Get generalizations incorrectly.", generalizations, testGeneralizableElementAbstractImpl
                .getGeneralizations());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsGeneralization(Generalization)</code>.
     * </p>
     */
    public void testContainsGeneralization() {
        Generalization generalization = new GeneralizationImpl();
        testGeneralizableElementAbstractImpl.addGeneralization(generalization);
        assertTrue("Contains generalization incorrectly.", testGeneralizableElementAbstractImpl
                .containsGeneralization(generalization));

        assertFalse("Contains Generalization incorrectly.", testGeneralizableElementAbstractImpl
                .containsGeneralization(new GeneralizationImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsGeneralization(Generalization)</code> with null generalization. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsGeneralizationNullGeneralization() {
        try {
            testGeneralizableElementAbstractImpl.containsGeneralization(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countGeneralizations()</code>.
     * </p>
     */
    public void testCountGeneralizations() {
        testGeneralizableElementAbstractImpl.clearGeneralizations();
        assertEquals("The count of generalizations should be 0.", 0, testGeneralizableElementAbstractImpl
                .countGeneralizations());

        testGeneralizableElementAbstractImpl.addGeneralization(new GeneralizationImpl());
        assertEquals("The count of generalizations should be 1.", 1, testGeneralizableElementAbstractImpl
                .countGeneralizations());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addSpecialization(Specialization)</code>.
     * </p>
     */
    public void testAddSpecialization() {
        Generalization specialization = new GeneralizationImpl();
        testGeneralizableElementAbstractImpl.addSpecialization(specialization);
        assertTrue("Add specialization incorrectly.", testGeneralizableElementAbstractImpl
                .removeSpecialization(specialization));
    }

    /**
     * <p>
     * Test the method of <code>addSpecialization(Generalization)</code> with null specialization. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddSpecializationNullGeneralization() {
        try {
            testGeneralizableElementAbstractImpl.addSpecialization(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeSpecialization(Generalization)</code>.
     * </p>
     */
    public void testRemoveSpecialization() {
        Generalization specialization = new GeneralizationImpl();
        testGeneralizableElementAbstractImpl.addSpecialization(specialization);
        assertTrue("Remove specialization incorrectly.", testGeneralizableElementAbstractImpl
                .removeSpecialization(specialization));
    }

    /**
     * <p>
     * Test the method of <code>removeSpecialization(Generalization)</code> with null specialization. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveSpecializationNullGeneralization() {
        try {
            testGeneralizableElementAbstractImpl.removeSpecialization(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearSpecializations()</code>.
     * <p>
     */
    public void testClearSpecializations() {
        testGeneralizableElementAbstractImpl.clearSpecializations();
        assertEquals("The count of specialization should be 0.", 0, testGeneralizableElementAbstractImpl
                .countSpecializations());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getSpecializations()</code>.
     * </p>
     */
    public void testGetSpecializations() {
        testGeneralizableElementAbstractImpl.clearSpecializations();
        Collection<Generalization> specializations = new ArrayList<Generalization>();
        for (int i = 0; i < 3; ++i) {
            Generalization specialization = new GeneralizationImpl();
            specializations.add(specialization);
            testGeneralizableElementAbstractImpl.addSpecialization(specialization);
        }
        assertEquals("Get specializations incorrectly.", specializations, testGeneralizableElementAbstractImpl
                .getSpecializations());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsSpecialization(Generalization)</code>.
     * </p>
     */
    public void testContainsSpecialization() {
        Generalization specialization = new GeneralizationImpl();
        testGeneralizableElementAbstractImpl.addSpecialization(specialization);
        assertTrue("Contains specialization incorrectly.", testGeneralizableElementAbstractImpl
                .containsSpecialization(specialization));

        assertFalse("Contains Specialization incorrectly.", testGeneralizableElementAbstractImpl
                .containsSpecialization(new GeneralizationImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsSpecialization(Generalization)</code> with null specialization. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsSpecializationNullSpecialization() {
        try {
            testGeneralizableElementAbstractImpl.containsSpecialization(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countSpecializations()</code>.
     * </p>
     */
    public void testCountSpecializations() {
        testGeneralizableElementAbstractImpl.clearSpecializations();
        assertEquals("The count of specializations should be 0.", 0, testGeneralizableElementAbstractImpl
                .countSpecializations());

        testGeneralizableElementAbstractImpl.addSpecialization(new GeneralizationImpl());
        assertEquals("The count of specializations should be 1.", 1, testGeneralizableElementAbstractImpl
                .countSpecializations());
    }
}
