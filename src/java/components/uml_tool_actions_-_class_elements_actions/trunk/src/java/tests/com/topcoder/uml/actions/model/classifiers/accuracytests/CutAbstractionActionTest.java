/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CutAbstractionAction;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;

/**
 * Accuracy tests for CutAbstractionAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CutAbstractionActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
        action = new CutAbstractionAction(new AbstractionImpl());
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
     * CutAbstractionAction instance for test.
     */
    private CutAbstractionAction action;

    /**
     * Test method for
     * {@link CutAbstractionAction#CutAbstractionAction(Abstraction)}.
     */
    public void testCutAbstractionActionAbstraction() {
        new CutAbstractionAction(new AbstractionImpl());
    }

    /**
     * Test method for
     * {@link CutAbstractionAction#CutAbstractionAction(Abstraction, Clipboard)}.
     */
    public void testCutAbstractionActionAbstractionClipboard() {
        new CutAbstractionAction(new AbstractionImpl(), TestUtil.CLIPBORAD);
    }

    /**
     * Test method for {@link CutAbstractionAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        assertEquals("Presentation name is incorrect.", "Cut Abstraction",
                action.getPresentationName());
    }

}
