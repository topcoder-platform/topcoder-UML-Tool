/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.elements;

import junit.framework.TestCase;

import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Tests for adding, removing, and persistence for a diagram.
 * </p>
 * @author ly
 * @version 1.0
 */
public abstract class DiagramTest extends TestCase {

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        createDiagram();
    }

    /**
     * <p>Creates diagram for testing.</p>
     *
     */
    public abstract void createDiagram();

    /**
     * <p>
     * Tests the deletion of element. The element should have been removed successfully.
     * </p>
     */
    public void testRemove() {
        TestHelper.selectAll();
        TestHelper.deleteSelectedElements();
    }

    /**
     * <p>
     * Tests the functionality of copy/paste for specified element. A new element should have been pasted correctly.
     * </p>
     */
    public void testCopyPaste() {
        TestHelper.selectAll();

        TestHelper.copySelectedElements();

        TestHelper.deleteSelectedElements();

        TestHelper.pasteElements();
    }

    /**
     * <p>
     * Tests the persistence for specified element. The element should have been loaded correctly.
     * </p>
     */
    public void testPersitence() {
        try {
            TestHelper.save();
            TestHelper.load();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }

        TestHelper.restoreMainFrame();
    }
}
