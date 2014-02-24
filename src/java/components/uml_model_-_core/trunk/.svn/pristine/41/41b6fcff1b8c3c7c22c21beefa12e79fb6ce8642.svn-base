/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import junit.framework.TestCase;

import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;

/**
 * <p>
 * Unit test for <code>AttributeImplUnitTests</code> class.
 * </p>
 *
 * @author vividmxx
 * @version 1.0
 */
public class AttributeImplUnitTests extends TestCase {

    /**
     * <p>
     * Represents the <code>AttributeImpl</code> instance used for tests.
     * </p>
     */
    private AttributeImpl testAttributeImpl;

    /**
     * <p>
     * Set up the test environment.
     * </p>
     */
    protected void setUp() {
        testAttributeImpl = new AttributeImpl();
    }

    /**
     * <p>
     * Accuracy test the <code>AttributeImpl()</code> constructor. AttributeImpl instance should be created.
     * </p>
     */
    public void testAttributeImplConstructor() {
        assertNotNull("Create AttributeImpl object incorrectly.", new AttributeImpl());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setInitialValue(Expression)</code>, the <code>initialValue</code>
     * field should be set.
     * </p>
     */
    public void testSetInitialValue() {
        Expression initialValue = new ExpressionImpl();
        testAttributeImpl.setInitialValue(initialValue);
        assertEquals("The InitialValue field should be set.", initialValue, testAttributeImpl.getInitialValue());

        testAttributeImpl.setInitialValue(null);
        assertNull("The InitialValue field should be null.", testAttributeImpl.getInitialValue());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getInitialValue()</code>, the <code>initialValue</code> field should
     * be returned.
     * </p>
     */
    public void testGetInitialValue() {
        Expression initialValue = new ExpressionImpl();
        testAttributeImpl.setInitialValue(initialValue);
        assertEquals("The InitialValue field should be get.", initialValue, testAttributeImpl.getInitialValue());

        testAttributeImpl.setInitialValue(null);
        assertNull("The InitialValue field should be null.", testAttributeImpl.getInitialValue());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setAssociationEnd(AssociationEnd)</code>, the
     * <code>associationEnd</code> field should be set.
     * </p>
     */
    public void testSetAssociationEnd() {
        AssociationEnd associationEnd = new AssociationEndImpl();
        testAttributeImpl.setAssociationEnd(associationEnd);
        assertEquals("The associationEnd field should be set.", associationEnd, testAttributeImpl.getAssociationEnd());

        testAttributeImpl.setAssociationEnd(null);
        assertNull("The associationEnd field should be null.", testAttributeImpl.getAssociationEnd());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getAssociationEnd()</code>, the <code>associationEnd</code> field
     * should be returned.
     * </p>
     */
    public void testGetAssociationEnd() {
        AssociationEnd associationEnd = new AssociationEndImpl();
        testAttributeImpl.setAssociationEnd(associationEnd);
        assertEquals("The associationEnd field should be get.", associationEnd, testAttributeImpl.getAssociationEnd());

        testAttributeImpl.setAssociationEnd(null);
        assertNull("The associationEnd field should be null.", testAttributeImpl.getAssociationEnd());
    }
}
