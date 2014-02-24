/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CopyGeneralizationAction;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;

/**
 * Accuracy tests for CopyGeneralizationAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CopyGeneralizationActionTest extends TestCase {
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
     * Test method for
     * {@link CopyGeneralizationAction#CopyGeneralizationAction(Generalization)}.
     */
    public void testCopyGeneralizationActionGeneralization() {
        new CopyGeneralizationAction(new GeneralizationImpl());
    }

    /**
     * Test method for
     * {@link CopyGeneralizationAction#CopyGeneralizationAction(Generalization, Clipboard)}.
     */
    public void testCopyGeneralizationActionGeneralizationClipboard() {
        new CopyGeneralizationAction(new GeneralizationImpl(),
                TestUtil.CLIPBORAD);
    }
}
