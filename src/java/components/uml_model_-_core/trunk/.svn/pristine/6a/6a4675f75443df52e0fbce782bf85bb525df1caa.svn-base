/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>StructuralFeatureAbstractImpl</code> class.
 * </p>
 *
 * @author vividmxx
 * @version 1.0
 */
public class StructuralFeatureAbstractImplUnitTests extends TestCase {
    /**
     * <p>
     * This class extends the <code>StructuralFeatureAbstractImpl</code>. It is only used in unit test.
     * </p>
     */
    public class StructuralFeatureImpl extends StructuralFeatureAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public StructuralFeatureImpl() {
        }
    }

    /**
     * <p>
     * This class extends the <code>ClassifierAbstractImpl</code>. It is only used in unit test.
     * </p>
     */
    private class ClassifierImpl extends ClassifierAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public ClassifierImpl() {
        }
    }

    /**
     * <p>
     * Represents the <code>StructuralFeatureAbstractImpl</code> instance used for tests.
     * </p>
     */
    private StructuralFeatureAbstractImpl testStructuralFeatureAbstractImpl;

    /**
     * <p>
     * Set up the test environment.
     * </p>
     */
    protected void setUp() {
        testStructuralFeatureAbstractImpl = new StructuralFeatureImpl();
    }

    /**
     * <p>
     * Accuracy test the StructuralFeatureAbstractImpl constructor.
     * </p>
     */
    public void testStructuralFeatureAbstractImplConstructor() {
        assertNotNull("Create StructuralFeatureAbstractImpl object incorrectly.", new StructuralFeatureImpl());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setMultiplicity(Multiplicity)</code>, the <code>Multiplicity</code>
     * field should be set.
     * </p>
     */
    public void testSetMultiplicity() {
        Multiplicity multiplicity = new MultiplicityImpl();
        testStructuralFeatureAbstractImpl.setMultiplicity(multiplicity);
        assertEquals("The Multiplicity field should be set.", multiplicity, testStructuralFeatureAbstractImpl
                .getMultiplicity());

        testStructuralFeatureAbstractImpl.setMultiplicity(null);
        assertNull("The Multiplicity field should be null.", testStructuralFeatureAbstractImpl.getMultiplicity());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getMultiplicity()</code>, the <code>Multiplicity</code> field should
     * be returned.
     * </p>
     */
    public void testGetMultiplicity() {
        Multiplicity multiplicity = new MultiplicityImpl();
        testStructuralFeatureAbstractImpl.setMultiplicity(multiplicity);
        assertEquals("The Multiplicity field should be get.", multiplicity, testStructuralFeatureAbstractImpl
                .getMultiplicity());

        testStructuralFeatureAbstractImpl.setMultiplicity(null);
        assertNull("The Multiplicity field should be null.", testStructuralFeatureAbstractImpl.getMultiplicity());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setChangeability(ChangeableKind)</code>, the <code>Changeability</code>
     * field should be set.
     * </p>
     */
    public void testSetChangeability() {
        ChangeableKind changeability = ChangeableKind.ADD_ONLY;
        testStructuralFeatureAbstractImpl.setChangeability(changeability);
        assertEquals("The Changeability field should be set.", changeability, testStructuralFeatureAbstractImpl
                .getChangeability());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getChangeability()</code>, the <code>Changeability</code> field should
     * be returned.
     * </p>
     */
    public void testGetChangeability() {
        ChangeableKind changeability = ChangeableKind.FROZEN;
        testStructuralFeatureAbstractImpl.setChangeability(changeability);
        assertEquals("The Changeability field should be get.", changeability, testStructuralFeatureAbstractImpl
                .getChangeability());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setTargetScope(ScopeKind)</code>, the <code>TargetScope</code> field
     * should be set.
     * </p>
     */
    public void testSetTargetScope() {
        ScopeKind targetScope = ScopeKind.INSTANCE;
        testStructuralFeatureAbstractImpl.setTargetScope(targetScope);
        assertEquals("The TargetScope field should be set.", targetScope, testStructuralFeatureAbstractImpl
                .getTargetScope());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getTargetScope()</code>, the <code>TargetScope</code> field should be
     * returned.
     * </p>
     */
    public void testGetTargetScope() {
        ScopeKind targetScope = ScopeKind.CLASSIFIER;
        testStructuralFeatureAbstractImpl.setTargetScope(targetScope);
        assertEquals("The TargetScope field should be get.", targetScope, testStructuralFeatureAbstractImpl
                .getTargetScope());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setType(Classifier)</code>, the <code>Type</code> field should be set.
     * </p>
     */
    public void testSetType() {
        Classifier type = new ClassifierImpl();
        testStructuralFeatureAbstractImpl.setType(type);
        assertEquals("The Type field should be set.", type, testStructuralFeatureAbstractImpl.getType());

        testStructuralFeatureAbstractImpl.setType(null);
        assertNull("The Type field should be null.", testStructuralFeatureAbstractImpl.getType());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getType()</code>, the <code>Type</code> field should be returned.
     * </p>
     */
    public void testGetType() {
        Classifier type = new ClassifierImpl();
        testStructuralFeatureAbstractImpl.setType(type);
        assertEquals("The Type field should be get.", type, testStructuralFeatureAbstractImpl.getType());

        testStructuralFeatureAbstractImpl.setType(null);
        assertNull("The Type field should be null.", testStructuralFeatureAbstractImpl.getType());
    }
}
