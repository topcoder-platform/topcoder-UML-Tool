/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.modelmanagement.PackageImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class RemovePackageAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemovePackageActionTest extends TestCase {

    /**
     * Test Constructor, with correct package.
     */
    public void testCtor() {
        com.topcoder.uml.model.modelmanagement.Package packagee = new PackageImpl();

        RemovePackageAction removeAction = new RemovePackageAction(packagee);

        assertEquals("Should return ModelElement instance.", packagee, removeAction.getModelElement());
    }

    /**
     * Test Constructor, with null package. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullPackage() {
        try {
            new RemovePackageAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getPresentationName.
     */
    public void testGetPresentationName() {
        com.topcoder.uml.model.modelmanagement.Package packagee = new PackageImpl();

        RemovePackageAction removeAction = new RemovePackageAction(packagee);

        assertEquals("Should return PRESENTATION_NAME.", "Remove Package", removeAction.getPresentationName());
    }
}