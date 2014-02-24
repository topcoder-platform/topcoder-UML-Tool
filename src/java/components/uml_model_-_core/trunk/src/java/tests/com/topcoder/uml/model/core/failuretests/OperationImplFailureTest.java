/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.OperationImpl;

/**
 * Aggregates all failure tests for NamespaceAbstractImpl class.
 * @author vilain
 * @version 1.0
 */
public class OperationImplFailureTest extends TestCase {

    /**
     * Instance of OperationImpl for testing.
     */
    private OperationImpl operationImpl;

    /**
     * Setting up environment for each test case.
     */
    protected void setUp() {
        operationImpl = new OperationImpl();
    }

    /**
     * Method under test OperationImpl.addMethod(Method). Failure testing of
     * exception in case method is null.
     */
    public final void testAddMethodNull() {
        try {
            operationImpl.addMethod(null);
            fail("IllegalArgumentException is expected since method is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test OperationImpl.removeMethod(Method). Failure testing of
     * exception in case method is null.
     */
    public final void testRemoveMethodNull() {
        try {
            operationImpl.removeMethod(null);
            fail("IllegalArgumentException is expected since method is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test OperationImpl.containsMethod(Method). Failure testing
     * of exception in case method is null.
     */
    public final void testContainsMethodNull() {
        try {
            operationImpl.containsMethod(null);
            fail("IllegalArgumentException is expected since method is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}