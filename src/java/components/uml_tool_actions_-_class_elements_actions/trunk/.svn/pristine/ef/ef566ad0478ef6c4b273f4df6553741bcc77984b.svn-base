/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Transferable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer;
import com.topcoder.uml.actions.model.classifiers.InvalidDataContentException;
import com.topcoder.uml.actions.model.classifiers.PastePackageAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

/**
 * Accuracy tests for PastePackageAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class PastePackageActionTest extends TestCase {
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
     * PastePackageAction instance used for test.
     */
    private PastePackageAction action;

    /**
     * Test method for
     * {@link PastePackageAction#PastePackageAction(Transferable, Namespace)}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testPastePackageAction() throws InvalidDataContentException {
        action = new PastePackageAction(new ClassElementsTransfer(
                new PackageImpl()), TestUtil.getInstance().getNamespace());
    }

    /**
     * Test method for {@link PastePackageAction#getPresentationName()}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testGetPresentationName() throws InvalidDataContentException {
        testPastePackageAction();

        assertEquals("Presentation name is incorrect.", "Paste Package", action
                .getPresentationName());
    }

}
