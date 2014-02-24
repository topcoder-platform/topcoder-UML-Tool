/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.modelmanagement.PackageImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class CutPackageAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutPackageActionTest extends TestCase {

    /**
     * The Package instance for the test.
     */
    private com.topcoder.uml.model.modelmanagement.Package packagee = new PackageImpl();

    /**
     * The Clipboard instance for the test.
     */
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    /**
     * Test Constructor(Package), with correct package.
     */
    public void testCtor1() {
        CutPackageAction cutAction = new CutPackageAction(packagee);

        assertEquals("Should return ModelElement instance.", packagee, cutAction.getModelElement());
    }

    /**
     * Test Constructor(Package), with null package. IllegalArgumentException is
     * expected.
     */
    public void testCtor1WithNullPackage() {
        try {
            new CutPackageAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Package, Clipboard), with correct package and clipboard.
     */
    public void testCtor2() {
        CutPackageAction cutAction = new CutPackageAction(packagee, clipboard);

        assertEquals("Should return ModelElement instance.", packagee, cutAction.getModelElement());
    }

    /**
     * Test Constructor(Package, Clipboard), with null package.
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullPackage() {
        try {
            new CutPackageAction(null, clipboard);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Package, Clipboard), with null clipboard. Do the same as
     * it is not null, for the constructor will assign the default clipboard.
     */
    public void testCtor2WithNullClipboard() {
        try {
            new CutPackageAction(packagee, null);
            // pass
        } catch (IllegalArgumentException iae) {
            fail("IllegalArgumentException is not expected.");
        }
    }

    /**
     * Test getPresentationName.
     */
    public void testGetPresentationName() {
        CutPackageAction cutAction = new CutPackageAction(packagee);

        assertEquals("Should return PRESENTATION_NAME.", "Cut Package", cutAction.getPresentationName());
    }
}