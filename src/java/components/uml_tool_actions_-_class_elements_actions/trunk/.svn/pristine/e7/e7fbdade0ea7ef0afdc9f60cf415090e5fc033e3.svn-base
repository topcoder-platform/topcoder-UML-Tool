/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.InvalidDataContentException;
import com.topcoder.uml.actions.model.classifiers.RemoveExceptionAction;

/**
 * Accuracy tests for RemoveExceptionAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class RemoveExceptionActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
    }

    /**
     * Unload logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        TestUtil.unloadConfiguration();
    }

    /**
     * RemoveExceptionAction instance used for test.
     */
    private RemoveExceptionAction action;

    /**
     * Test method for
     * {@link RemoveExceptionAction#RemoveExceptionAction(Exception)}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testRemoveExceptionAction() throws InvalidDataContentException {
        action = new RemoveExceptionAction(TestUtil.getInstance()
                .getException());
    }

    /**
     * Test method for {@link RemoveExceptionAction#getPresentationName()}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testGetPresentationName() throws InvalidDataContentException {
        testRemoveExceptionAction();

        assertEquals("Presentation name is incorrect.", "Remove Exception",
                action.getPresentationName());
    }

}
