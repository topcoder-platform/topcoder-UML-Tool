/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CopyPackageAction;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

/**
 * Accuracy tests for CopyPackageAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CopyPackageActionTest extends TestCase {
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
     * Test method for {@link CopyPackageAction#CopyPackageAction(Package)}.
     */
    public void testCopyPackageActionPackage() {
        new CopyPackageAction(new PackageImpl());
    }

    /**
     * Test method for
     * {@link CopyPackageAction#CopyPackageAction(Package, Clipboard)}.
     */
    public void testCopyPackageActionPackageClipboard() {
        new CopyPackageAction(new PackageImpl(), TestUtil.CLIPBORAD);
    }
}
