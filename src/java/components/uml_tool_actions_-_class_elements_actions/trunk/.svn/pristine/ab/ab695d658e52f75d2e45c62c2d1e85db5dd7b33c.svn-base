/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.RemovePackageAction;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

/**
 * Accuracy tests for RemovePackageAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class RemovePackageActionTest extends TestCase {
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
     * RemovePackageAction instance used for test.
     */
    private RemovePackageAction action;

    /**
     * Test method for {@link RemovePackageAction#RemovePackageAction(Package)}.
     */
    public void testRemovePackageAction() {
        action = new RemovePackageAction(new PackageImpl());
    }

    /**
     * Test method for {@link RemovePackageAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        testRemovePackageAction();

        assertEquals("Presentation name is incorrect.", "Remove Package",
                action.getPresentationName());
    }

}
