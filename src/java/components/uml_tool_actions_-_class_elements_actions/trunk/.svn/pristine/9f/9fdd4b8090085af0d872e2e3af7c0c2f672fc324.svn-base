/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CutAssociationAction;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationImpl;

/**
 * Accuracy tests for CutAssociationAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CutAssociationActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
        action = new CutAssociationAction(new AssociationImpl());
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
     * CutAssociationAction instance for test.
     */
    private CutAssociationAction action;

    /**
     * Test method for
     * {@link CutAssociationAction#CutAssociationAction(Association)}.
     */
    public void testCutAssociationActionAssociation() {
        new CutAssociationAction(new AssociationImpl());
    }

    /**
     * Test method for
     * {@link CutAssociationAction#CutAssociationAction(Association, Clipboard)}.
     */
    public void testCutAssociationActionAssociationClipboard() {
        new CutAssociationAction(new AssociationImpl(), TestUtil.CLIPBORAD);
    }

    /**
     * Test method for {@link CutAssociationAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        assertEquals("Presentation name is incorrect.", "Cut Association",
                action.getPresentationName());
    }

}
