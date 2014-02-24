/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CutInterfaceAction;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;

/**
 * Accuracy tests for CutInterfaceAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CutInterfaceActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
        action = new CutInterfaceAction(new InterfaceImpl());
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
     * CutInterfaceAction instance for test.
     */
    private CutInterfaceAction action;

    /**
     * Test method for {@link CutInterfaceAction#CutInterfaceAction(Interface)}.
     */
    public void testCutInterfaceActionInterface() {
        new CutInterfaceAction(new InterfaceImpl());
    }

    /**
     * Test method for
     * {@link CutInterfaceAction#CutInterfaceAction(Interface, Clipboard)}.
     */
    public void testCutInterfaceActionInterfaceClipboard() {
        new CutInterfaceAction(new InterfaceImpl(), TestUtil.CLIPBORAD);
    }

    /**
     * Test method for {@link CutInterfaceAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        assertEquals("Presentation name is incorrect.", "Cut Interface", action
                .getPresentationName());
    }

}
