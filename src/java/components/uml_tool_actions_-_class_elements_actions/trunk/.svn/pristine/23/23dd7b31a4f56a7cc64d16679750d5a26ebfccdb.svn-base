/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Transferable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer;
import com.topcoder.uml.actions.model.classifiers.InvalidDataContentException;
import com.topcoder.uml.actions.model.classifiers.PasteDependencyAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;

/**
 * Accuracy tests for PasteDependencyAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class PasteDependencyActionTest extends TestCase {
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
     * PasteDependencyAction instance used for test.
     */
    private PasteDependencyAction action;

    /**
     * Test method for
     * {@link PasteDependencyAction#PasteDependencyAction(Transferable, Namespace)}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testPasteDependencyAction() throws InvalidDataContentException {
        action = new PasteDependencyAction(new ClassElementsTransfer(
                new DependencyImpl()), TestUtil.getInstance().getNamespace());
    }

    /**
     * Test method for {@link PasteDependencyAction#getPresentationName()}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testGetPresentationName() throws InvalidDataContentException {
        testPasteDependencyAction();

        assertEquals("Presentation name is incorrect.", "Paste Dependency",
                action.getPresentationName());
    }

}
