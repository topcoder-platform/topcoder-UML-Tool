/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import com.topcoder.uml.actions.model.classifiers.CutEnumerationAction;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;

import junit.framework.TestCase;

/**
 * Accuracy tests for CutEnumerationAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CutEnumerationActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();

        action = new CutEnumerationAction(new EnumerationImpl());
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
     * CutEnumerationAction instance for test.
     */
    private CutEnumerationAction action;

    /**
     * Test method for
     * {@link CutEnumerationAction#CutEnumerationAction(Enumeration)}.
     */
    public void testCutEnumerationActionEnumeration() {
        new CutEnumerationAction(new EnumerationImpl());
    }

    /**
     * Test method for
     * {@link CutEnumerationAction#CutEnumerationAction(Enumeration, Clipboard)}.
     */
    public void testCutEnumerationActionEnumerationClipboard() {
        new CutEnumerationAction(new EnumerationImpl(), TestUtil.CLIPBORAD);
    }

    /**
     * Test method for {@link CutEnumerationAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        assertEquals("Presentation name is incorrect.", "Cut Enumeration",
                action.getPresentationName());
    }

}
