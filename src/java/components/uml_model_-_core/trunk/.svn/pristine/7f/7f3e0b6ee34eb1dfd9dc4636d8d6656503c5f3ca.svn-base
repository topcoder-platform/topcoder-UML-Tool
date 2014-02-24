/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.NamespaceAbstractImpl;

/**
 * Aggregates all failure tests for NamespaceAbstractImpl class.
 * @author vilain
 * @version 1.0
 */
public class NamespaceAbstractImplFailureTest extends TestCase {

    /**
     * Instance of NamespaceAbstractImpl for testing.
     */
    private NamespaceAbstractImpl namespaceAbstractImpl;

    /**
     * Setting up environment for each test case.
     */
    protected void setUp() {
        namespaceAbstractImpl = new NamespaceAbstractImpl() {
        };
    }

    /**
     * Method under test NamespaceAbstractImpl.addOwnedElement(ModelElement).
     * Failure testing of exception in case owned element is null.
     */
    public final void testAddOwnedElementNull() {
        try {
            namespaceAbstractImpl.addOwnedElement(null);
            fail("IllegalArgumentException is expected since owned element is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test NamespaceAbstractImpl.removeOwnedElement(ModelElement).
     * Failure testing of exception in case owned element is null.
     */
    public final void testRemoveOwnedElementNull() {
        try {
            namespaceAbstractImpl.removeOwnedElement(null);
            fail("IllegalArgumentException is expected since owned element is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * NamespaceAbstractImpl.containsOwnedElement(ModelElement). Failure testing
     * of exception in case owned element is null.
     */
    public final void testContainsOwnedElementNull() {
        try {
            namespaceAbstractImpl.containsOwnedElement(null);
            fail("IllegalArgumentException is expected since owned element is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}