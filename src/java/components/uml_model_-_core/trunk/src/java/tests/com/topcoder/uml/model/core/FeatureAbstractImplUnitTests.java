/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.ScopeKind;
import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>FeatureAbstractImpl</code> class.
 * </p>
 *
 * @author vividmxx
 * @version 1.0
 */
public class FeatureAbstractImplUnitTests extends TestCase {

    /**
     * This class extends the <code>FeatureAbstractImpl</code>. It is only used in unit test.
     */
    private class FeatureImpl extends FeatureAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public FeatureImpl() {
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
     * Represents the <code>FeatureAbstractImpl</code> instance used for tests.
     * </p>
     */
    private FeatureAbstractImpl testFeatureAbstractImpl;

    /**
     * <p>
     * Set up the test environment.
     * </p>
     */
    protected void setUp() {
        testFeatureAbstractImpl = new FeatureImpl();
    }

    /**
     * <p>
     * Accuracy test the <code>FeatureAbstractImpl()</code> constructor. FeatureAbstractImpl instance should be
     * created.
     * </p>
     */
    public void testFeatureAbstractImplConstructor() {
        assertNotNull("Create FeatureAbstractImpl object incorrectly.", new FeatureImpl());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setOwner(Classifier)</code>, the <code>Owner</code> field should be
     * set.
     * </p>
     */
    public void testSetOwner() {
        Classifier owner = new ClassifierImpl();
        testFeatureAbstractImpl.setOwner(owner);
        assertEquals("The Owner field should be set.", owner, testFeatureAbstractImpl.getOwner());

        testFeatureAbstractImpl.setOwner(null);
        assertNull("The Owner field should be null.", testFeatureAbstractImpl.getOwner());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getOwner()</code>, the <code>Owner</code> field should be returned.
     * </p>
     */
    public void testGetOwner() {
        Classifier owner = new ClassifierImpl();
        testFeatureAbstractImpl.setOwner(owner);
        assertEquals("The Owner field should be get.", owner, testFeatureAbstractImpl.getOwner());

        testFeatureAbstractImpl.setOwner(null);
        assertNull("The Owner field should be null.", testFeatureAbstractImpl.getOwner());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setOwnerScope(ScopeKind)</code>, the <code>OwnerScope</code> field
     * should be set.
     * </p>
     */
    public void testSetOwnerScope() {
        ScopeKind scopeKind = ScopeKind.CLASSIFIER;
        testFeatureAbstractImpl.setOwnerScope(scopeKind);
        assertEquals("The OwnerScope field should be set.", scopeKind, testFeatureAbstractImpl.getOwnerScope());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getOwnerScope()</code>, the <code>OwnerScope</code> field should be
     * returned.
     * </p>
     */
    public void testGetOwnerScope() {
        ScopeKind scopeKind = ScopeKind.INSTANCE;
        testFeatureAbstractImpl.setOwnerScope(scopeKind);
        assertEquals("The OwnerScope field should be get.", scopeKind, testFeatureAbstractImpl.getOwnerScope());
    }
}
