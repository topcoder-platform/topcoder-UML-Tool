/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CutClassAction;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * Accuracy tests for CutClassAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CutClassActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
        action = new CutClassAction(new ClassImpl());

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
     * CutClassAction instance for test.
     */
    private CutClassAction action;

    /**
     * Test method for {@link CutClassAction#CutClassAction(Class)}.
     */
    public void testCutClassActionClass() {
        new CutClassAction(new ClassImpl());
    }

    /**
     * Test method for {@link CutClassAction#CutClassAction(Class, Clipboard)}.
     */
    public void testCutClassActionClassClipboard() {
        new CutClassAction(new ClassImpl(), TestUtil.CLIPBORAD);
    }

    /**
     * Test method for {@link CutClassAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        assertEquals("Presentation name is incorrect.", "Cut Class", action
                .getPresentationName());
    }

}
