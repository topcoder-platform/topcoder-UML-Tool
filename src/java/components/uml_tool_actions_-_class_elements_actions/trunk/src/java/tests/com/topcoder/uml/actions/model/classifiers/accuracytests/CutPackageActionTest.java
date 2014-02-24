/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CutPackageAction;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

/**
 * Accuracy tests for CutPackageAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CutPackageActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
        action = new CutPackageAction(new PackageImpl());
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
     * CutPackageAction instance used for test.
     */
    private CutPackageAction action;

    /**
     * Test method for {@link CutPackageAction#CutPackageAction(Package)}.
     */
    public void testCutPackageActionPackage() {
        new CutPackageAction(new PackageImpl());
    }

    /**
     * Test method for
     * {@link CutPackageAction#CutPackageAction(Package, Clipboard)}.
     */
    public void testCutPackageActionPackageClipboard() {
        new CutPackageAction(new PackageImpl(), TestUtil.CLIPBORAD);
    }

    /**
     * Test method for {@link CutPackageAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        assertEquals("Presentation name is incorrect.", "Cut Package", action
                .getPresentationName());
    }

}
