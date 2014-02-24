/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.AbstractActivityUndoableAction;
import com.topcoder.uml.actions.model.activity.ActivityObjectCloneException;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * This class aggregates accuracy tests for AbstractActivityUndoableAction class.
 *
 * @author ch_music
 * @version 1.0
 */
public class AbstractActivityUndoableActionAccuracyTests extends TestCase {

    /**
     * An instance of MockAbstractActivityUndoableAction inner class used for testing purposes.
     */
    private MockAbstractActivityUndoableAction test;

    /**
     * Sets up testing environment.
     *
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.LOG_NAMESPACE, AccuracyTestHelper.LOG_CONFIGPATH);
        test = new MockAbstractActivityUndoableAction("test");
    }

    /**
     * Tears down testing environment.
     *
     * @throws Exception to JUnit
     */
    public void tearDown() throws Exception {
        AccuracyTestHelper.tearConfig();
    }

    /**
     * Tests constructor.
     */
    public void testAbstractActivityUndoableAction() {
        assertNotNull("Constructor fails to create instance.", test);
    }

    /**
     * Tests redo method.
     */
    public void testRedo1() {
        test.undo();
        test.redo();
        assertTrue("execute() method was not executed.", test.wasExecuted());
    }

    /**
     * Tests redo method.
     *
     * @throws Exception to JUnit
     */
    public void testRedo2() throws Exception {
        test.undo();

        System.setProperty("ThrowException", "ActionExecutionException");
        try {
            test.redo();
        } finally {
            System.clearProperty("ThrowException");
        }
    }

    /**
     * Tests logException method.
     */
    public void testLogException1() {
        IllegalArgumentException e1 = new IllegalArgumentException("testLogException1 e1.");
        ActivityObjectCloneException e2 = new ActivityObjectCloneException("testLogException1 e2.", e1);
        ActivityObjectCloneException e3 = new ActivityObjectCloneException("testLogException1 e3.", e2);
        System.out.println();
        System.out.println("Accuracy Test - testLogException1:");
        test.logException("testLogException1 message.", e3);
        System.out.println();
    }

    /**
     * Tests logException method.
     */
    public void testLogException2() {
        IllegalArgumentException e1 = new IllegalArgumentException("testLogException1 e1.");
        ActivityObjectCloneException e2 = new ActivityObjectCloneException("testLogException1 e2.", e1);
        ActivityObjectCloneException e3 = new ActivityObjectCloneException("testLogException1 e3.", e2);
        System.out.println();
        System.out.println("Accuracy Test - testLogException2:");
        test.logException(null, e3);
        System.out.println();
    }

    /**
     * Tests logException method.
     */
    public void testLogException3() {
        IllegalArgumentException e1 = new IllegalArgumentException("testLogException1 e1.");
        ActivityObjectCloneException e2 = new ActivityObjectCloneException("testLogException1 e2.", e1);
        ActivityObjectCloneException e3 = new ActivityObjectCloneException("testLogException1 e3.", e2);
        System.out.println();
        System.out.println("Accuracy Test - testLogException3:");
        test.logException(" ", e3);
        System.out.println();
    }

    /**
     * Tests getPresentationName method.
     */
    public void testGetPresentationName() {
        assertEquals("getPresentationName returns wrong value - expected: test", "test", test
                .getPresentationName());
    }

    /**
     * This is a mock class that extends AbstractActivityUndoableAction abstract class; used only for testing
     * purposes.
     *
     * @author ch_music
     * @version 1.0
     */
    private class MockAbstractActivityUndoableAction extends AbstractActivityUndoableAction {

        /**
         * <p>
         * Indicator for whether execute() method has been executed or not.
         * </P>
         */
        private boolean wasExecuted = false;

        /**
         * <p>
         * Constructor.
         * </P>
         *
         * @param name the presentation name of the undoable action
         */
        public MockAbstractActivityUndoableAction(String name) {
            super(name);
        }

        /**
         * <p>
         * Implements the mock execute() method.
         * </p>
         *
         * @throws ActionExecutionException if the value of system property &quot;exception&quot; is
         *             &quot;ActionExecutionException&quot;
         */
        public void execute() throws ActionExecutionException {
            wasExecuted = true;

            if ("ActionExecutionException".equals(System.getProperty("ThrowException"))) {
                throw new ActionExecutionException("Test.");
            }
        }

        /**
         * Logs exception using the same method in superclass.
         *
         * @param message the error message to log
         * @param exception the exception to log.
         */
        public void logException(String message, Throwable exception) {
            super.logException(message, exception);
        }

        /**
         * Determines whether the execute method has been executed.
         *
         * @return the tag for testing
         */
        public boolean wasExecuted() {
            return wasExecuted;
        }
    }
}
