/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.accuracytests;

import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy tests for <code>AttributeImpl</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class AttributeImplAccuracyTests extends TestCase {

    /** Represents the mocked <code>AttributeImpl</code> instance used for testing. */
    private AttributeImpl attribute;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        //creates the AttributeImpl instance
        attribute = new AttributeImpl();
    }

    /**
     * Accuracy test of method <code>setInitialValue(Expression)</code> and <code>getInitialValue()</code>.
     */
    public void testInitialValueSetterAndGetter() {
        //initial value is null
        assertNull(attribute.getInitialValue());
        //set the InitialValue with specified Expression
        attribute.setInitialValue(new ExpressionImpl());
        assertNotNull(attribute.getInitialValue());
        //set the InitialValue with null
        attribute.setInitialValue(null);
        assertNull(attribute.getInitialValue());
    }

    /**
     * Accuracy test of method <code>setAssociationEnd(AssociationEnd)</code> and <code>getAssociationEnd()</code>.
     */
    public void testAssociationEndSetterAndGetter() {
        //initial value is null
        assertNull(attribute.getAssociationEnd());
        //set the AssociationEnd with specified AssociationEnd
        attribute.setAssociationEnd(new AssociationEndImpl());
        assertNotNull(attribute.getAssociationEnd());
        //set the AssociationEnd with null
        attribute.setAssociationEnd(null);
        assertNull(attribute.getAssociationEnd());
    }
}
