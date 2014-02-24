/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>ParameterImpl</code> class.
 * </p>
 *
 * @author vividmxx
 * @version 1.0
 */
public class ParameterImplUnitTests extends TestCase {
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
     * This class extends the <code>BehavioralFeatureAbstractImpl</code>. It is only used in unit test.
     */
    private class BehavioralFeatureImpl extends BehavioralFeatureAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public BehavioralFeatureImpl() {
        }
    }

    /**
     * <p>
     * Represents the <code>ParameterImpl</code> instance used for tests.
     * </p>
     */
    private ParameterImpl testParameterImpl;

    /**
     * <p>
     * Set up the test environment.
     * </p>
     */
    protected void setUp() {
        testParameterImpl = new ParameterImpl();
    }

    /**
     * <p>
     * Accuracy test the OperationImpl constructor.
     * </p>
     */
    public void testParameterImplConstructor() {
        assertNotNull("Create ParameterImpl object incorrectly.", new ParameterImpl());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setDefaultValue(Expression)</code>, the <code>DefaultValue</code>
     * field should be set.
     * </p>
     */
    public void testSetDefaultValue() {
        Expression defaultValue = new ExpressionImpl();
        testParameterImpl.setDefaultValue(defaultValue);
        assertEquals("The DefaultValue field should be set.", defaultValue, testParameterImpl.getDefaultValue());

        testParameterImpl.setDefaultValue(null);
        assertNull("The DefaultValue field should be null.", testParameterImpl.getDefaultValue());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getDefaultValue()</code>, the <code>DefaultValue</code> field should
     * be returned.
     * </p>
     */
    public void testGetDefaultValue() {
        Expression defaultValue = new ExpressionImpl();
        testParameterImpl.setDefaultValue(defaultValue);
        assertEquals("The DefaultValue field should be get.", defaultValue, testParameterImpl.getDefaultValue());

        testParameterImpl.setDefaultValue(null);
        assertNull("The DefaultValue field should be null.", testParameterImpl.getDefaultValue());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setKind(ParameterDirectionKind)</code>, the <code>Kind</code> field
     * should be set.
     * </p>
     */
    public void testSetKind() {
        ParameterDirectionKind kind = ParameterDirectionKind.OUT;
        testParameterImpl.setKind(kind);
        assertEquals("The Kind field should be set.", kind, testParameterImpl.getKind());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getKind()</code>, the <code>Kind</code> field should be returned.
     * </p>
     */
    public void testGetKind() {
        ParameterDirectionKind kind = ParameterDirectionKind.IN;
        testParameterImpl.setKind(kind);
        assertEquals("The Kind field should be get.", kind, testParameterImpl.getKind());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setType(Classifier)</code>, the <code>Type</code> field should be set.
     * </p>
     */
    public void testSetType() {
        Classifier type = new ClassifierImpl();
        testParameterImpl.setType(type);
        assertEquals("The Type field should be set.", type, testParameterImpl.getType());

        testParameterImpl.setType(null);
        assertNull("The Type field should be null.", testParameterImpl.getType());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getType()</code>, the <code>Type</code> field should be returned.
     * </p>
     */
    public void testGetType() {
        Classifier type = new ClassifierImpl();
        testParameterImpl.setType(type);
        assertEquals("The Type field should be get.", type, testParameterImpl.getType());

        testParameterImpl.setType(null);
        assertNull("The Type field should be null.", testParameterImpl.getType());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setBehavioralFeature(BehavioralFeature)</code>, the
     * <code>BehavioralFeature</code> field should be set.
     * </p>
     */
    public void testSetBehavioralFeature() {
        BehavioralFeature behavioralFeature = new BehavioralFeatureImpl();
        testParameterImpl.setBehavioralFeature(behavioralFeature);
        assertEquals("The BehavioralFeature field should be set.", behavioralFeature, testParameterImpl
                .getBehavioralFeature());

        testParameterImpl.setBehavioralFeature(null);
        assertNull("The BehavioralFeature field should be null.", testParameterImpl.getBehavioralFeature());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getBehavioralFeature()</code>, the <code>BehavioralFeature</code>
     * field should be returned.
     * </p>
     */
    public void testGetBehavioralFeature() {
        BehavioralFeature behavioralFeature = new BehavioralFeatureImpl();
        testParameterImpl.setBehavioralFeature(behavioralFeature);
        assertEquals("The BehavioralFeature field should be get.", behavioralFeature, testParameterImpl
                .getBehavioralFeature());

        testParameterImpl.setBehavioralFeature(null);
        assertNull("The BehavioralFeature field should be null.", testParameterImpl.getBehavioralFeature());
    }
}
