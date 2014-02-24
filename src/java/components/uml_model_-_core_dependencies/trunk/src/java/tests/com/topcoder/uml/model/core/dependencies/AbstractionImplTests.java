/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Collaborations Version 1.0
 *
 * @ AbstractionImplTest.java
 */

package com.topcoder.uml.model.core.dependencies;

import com.topcoder.uml.model.datatypes.expressions.MappingExpression;
import com.topcoder.uml.model.datatypes.expressions.MappingExpressionImpl;

import junit.framework.TestCase;

/**
 * <p>Tests for AbstractionImpl class.</p>
 *
 * @author yinzi
 * @version 1.0
 */
public class AbstractionImplTests extends TestCase {
    /**
     * <p>AbstractionImpl used for testing. It is instantiated in SetUp.</p>
     */
    private AbstractionImpl abstractionImpl;

    /**
     * <p>Sets up test environment, creates object used for test.</p>
     */
    public void setUp() {
        abstractionImpl = new AbstractionImpl();
    }

    /**
     * <p>Tears down test environment, disposes object used for test.</p>
     */
    public void tearDown() {
        abstractionImpl = null;
    }

    /**
     * <p>Tests inheritance of <c>AbstractionImpl</c>.</p>
     * <p><c>AbstractionImpl</c> should inherit from <c>Message</c>.</p>
     */
    public void testAbstractionImplAccuracyInheritAbstraction() {
        assertEquals("AbstractionImpl should inherit from Message.", true, abstractionImpl instanceof Abstraction);
    }

    /**
     * <p>Tests accuracy of <c>getMapping</c> method.</p>
     * <p>Value should be gotten correctly.</p>
     */
    public void testGetMappingAccuracy() {
        assertEquals("Value should be gotten correctly.", null, abstractionImpl.getMapping());
        MappingExpression testObj = new MappingExpressionImpl();
        abstractionImpl.setMapping(testObj);
        assertEquals("Value should be gotten correctly.", testObj, abstractionImpl.getMapping());
    }

    /**
     * <p>Tests accuracy of <c>setMapping</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testSetMappingAccuracy() {
        assertEquals("Value should be gotten correctly.", null, abstractionImpl.getMapping());
        MappingExpression testObj = new MappingExpressionImpl();
        abstractionImpl.setMapping(testObj);
        assertEquals("Value should be gotten correctly.", testObj, abstractionImpl.getMapping());
    }

    /**
     * <p>Tests accuracy of <c>AbstractionImpl()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testAbstractionImplAccuracy() {
        assertEquals("Value should be gotten correctly.", null, abstractionImpl.getMapping());
    }
}
