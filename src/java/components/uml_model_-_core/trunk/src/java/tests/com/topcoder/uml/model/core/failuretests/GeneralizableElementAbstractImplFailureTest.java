/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.GeneralizableElementAbstractImpl;

/**
 * Aggregates all failure tests for GeneralizableElementAbstractImpl class.
 * @author vilain
 * @version 1.0
 */
public class GeneralizableElementAbstractImplFailureTest extends TestCase {

    /**
     * Instance of GeneralizableElementAbstractImpl for testing.
     */
    private GeneralizableElementAbstractImpl generalizableElementAbstractImpl;

    /**
     * Setting up environment for each test case.
     */
    protected void setUp() {
        generalizableElementAbstractImpl = new GeneralizableElementAbstractImpl() {
        };
    }

    /**
     * Method under test
     * GeneralizableElementAbstractImpl.addGeneralization(Generalization).
     * Failure testing of exception in case generalization is null.
     */
    public final void testAddGeneralizationNull() {
        try {
            generalizableElementAbstractImpl.addGeneralization(null);
            fail("IllegalArgumentException is expected since generalization is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * GeneralizableElementAbstractImpl.removeGeneralization(Generalization).
     * Failure testing of exception in case generalization is null.
     */
    public final void testRemoveGeneralizationNull() {
        try {
            generalizableElementAbstractImpl.removeGeneralization(null);
            fail("IllegalArgumentException is expected since generalization is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * GeneralizableElementAbstractImpl.containsGeneralization(Generalization).
     * Failure testing of exception in case generalization is null.
     */
    public final void testContainsGeneralizationNull() {
        try {
            generalizableElementAbstractImpl.containsGeneralization(null);
            fail("IllegalArgumentException is expected since generalization is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * GeneralizableElementAbstractImpl.addSpecialization(Generalization).
     * Failure testing of exception in case specialization is null.
     */
    public final void testAddSpecializationNull() {
        try {
            generalizableElementAbstractImpl.addSpecialization(null);
            fail("IllegalArgumentException is expected since specialization is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * GeneralizableElementAbstractImpl.removeSpecialization(Generalization).
     * Failure testing of exception in case specialization is null.
     */
    public final void testRemoveSpecializationNull() {
        try {
            generalizableElementAbstractImpl.removeSpecialization(null);
            fail("IllegalArgumentException is expected since specialization is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * GeneralizableElementAbstractImpl.containsSpecialization(Generalization).
     * Failure testing of exception in case specialization is null.
     */
    public final void testContainsSpecializationNull() {
        try {
            generalizableElementAbstractImpl.containsSpecialization(null);
            fail("IllegalArgumentException is expected since specialization is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}