/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CutGeneralizationAction;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;

/**
 * Accuracy tests for CutGeneralizationAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CutGeneralizationActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();

        action = new CutGeneralizationAction(new GeneralizationImpl());
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
     * CutGeneralizationAction instance for test.
     */
    private CutGeneralizationAction action;

    /**
     * Test method for
     * {@link CutGeneralizationAction#CutGeneralizationAction(Generalization)}.
     */
    public void testCutGeneralizationActionGeneralization() {
        new CutGeneralizationAction(new GeneralizationImpl());
    }

    /**
     * Test method for
     * {@link CutGeneralizationAction#CutGeneralizationAction(Generalization, Clipboard)}.
     */
    public void testCutGeneralizationActionGeneralizationClipboard() {
        new CutGeneralizationAction(new GeneralizationImpl(),
                TestUtil.CLIPBORAD);
    }

    /**
     * Test method for {@link CutGeneralizationAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        assertEquals("Presentation name is incorrect.", "Cut Generalization",
                action.getPresentationName());
    }

}
