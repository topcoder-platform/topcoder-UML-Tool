/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.TestHelper;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.modelmanager.UMLModelManager;
import javax.swing.tree.DefaultMutableTreeNode;
import junit.framework.TestCase;

/**
 * <p>
 * This is a common parent for a number of classes testing different view types. It makes some common definitions
 * and performs some common setupping.
 * </p>
 *
 * @author Orange_Cloud
 * @version 1.1
 */
public class BaseViewTestCase extends TestCase {
    /**
     * <p>
     * The DocumentTreePanel instance for helping testing.
     * </p>
     */
    protected DocumentTreePanel parent;

    /**
     * <p>
     * The UMLModelManager instance for testing.
     * </p>
     */
    protected UMLModelManager manager;

    /**
     * <p>
     * The Package instance for testing.
     * </p>
     */
    protected Package umlPackage;

    /**
     * <p>
     * The DefaultMutableTreeNode instance for testing.
     * </p>
     */
    protected DefaultMutableTreeNode umlPackageNode;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfigurations();

        manager = TestHelper.createUMLModelManager();
        umlPackage = (Package) manager.getModel().getOwnedElements().iterator().next();

        DocumentTreeTabbedPane tabbedPane = new DocumentTreeTabbedPaneImpl(manager, TestHelper.NAMESPACE);

        parent = tabbedPane.createNewPanel();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
        super.tearDown();
    }
}
