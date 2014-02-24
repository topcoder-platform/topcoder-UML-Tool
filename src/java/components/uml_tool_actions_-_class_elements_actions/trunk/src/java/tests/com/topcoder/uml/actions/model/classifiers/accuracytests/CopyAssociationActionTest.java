/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CopyAssociationAction;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationImpl;

/**
 * Accuracy tests for CopyAssociationAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CopyAssociationActionTest extends TestCase {
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
     * {@link CopyAssociationAction#CopyAssociationAction(Association)}.
     */
    public void testCopyAssociationActionAssociation() {
        new CopyAssociationAction(new AssociationImpl());
    }

    /**
     * Test method for
     * {@link CopyAssociationAction#CopyAssociationAction(Association, Clipboard)}.
     */
    public void testCopyAssociationActionAssociationClipboard() {
        new CopyAssociationAction(new AssociationImpl(), TestUtil.CLIPBORAD);
    }
}
