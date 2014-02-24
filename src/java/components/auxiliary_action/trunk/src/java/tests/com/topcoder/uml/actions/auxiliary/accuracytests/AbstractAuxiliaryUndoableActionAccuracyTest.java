/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.AbstractAuxiliaryUndoableAction;

/**
 * <p>
 * Set of accuracy tests for AbstractAuxiliaryUndoableAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AbstractAuxiliaryUndoableActionAccuracyTest extends TestCase {

    /**
     * String for testing.
     */
    private String name = "name";

    /**
     * Instance of AbstractAuxiliaryUndoableAction for testing.
     */
    private AbstractAuxiliaryUndoableAction abstractAuxiliaryUndoableAction;

    /**
     * Setting up environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        abstractAuxiliaryUndoableAction = new AbstractAuxiliaryUndoableAction(name) {
            public void execute() {
            }
        };
    }

    /**
     * Constructor under test AbstractAuxiliaryUndoableAction(String). Accuracy
     * testing of correctly assigned name.
     */
    public final void testAbstractAuxiliaryUndoableAction() {
        AbstractAuxiliaryUndoableAction currentAbstractAuxiliaryUndoableAction =
            new AbstractAuxiliaryUndoableAction(name) {
                public void execute() {
                }
            };
        assertEquals("names must be equal", name, currentAbstractAuxiliaryUndoableAction.getPresentationName());
    }

    /**
     * Method under test
     * AbstractAuxiliaryUndoableAction().getPresentationName(). Accuracy testing
     * of correctly retrieved name.
     */
    public final void testGetPresentationName() {
        assertEquals("names must be equal", name, abstractAuxiliaryUndoableAction.getPresentationName());
    }

    /**
     * Tearing down environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.clearConfiguration();
    }
}