/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.AddExceptionAction;
import com.topcoder.uml.actions.model.classifiers.InvalidDataContentException;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * Accuracy tests for AddExceptionAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class AddExceptionActionTest extends TestCase {
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
     * AddExceptionAction instance.
     */
    private AddExceptionAction action;

    /**
     * Test method for
     * {@link AddExceptionAction#AddExceptionAction(Exception, UMLModelManager)}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testAddExceptionAction() throws InvalidDataContentException {
        com.topcoder.uml.model.core.classifiers.Class exception = TestUtil
                .getInstance().getException();

        action = new AddExceptionAction(exception, new UMLModelManager());
    }

    /**
     * Test method for {@link AddExceptionAction#getPresentationName()}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testGetPresentationName() throws InvalidDataContentException {
        testAddExceptionAction();

        assertEquals("Presentation name is incorrect.", "Add Exception", action
                .getPresentationName());
    }
}
