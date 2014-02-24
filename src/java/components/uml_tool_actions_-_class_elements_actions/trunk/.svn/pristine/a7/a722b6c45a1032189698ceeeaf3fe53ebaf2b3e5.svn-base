/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.MockPackageUtil;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

/**
 * Accuracy tests for PackageUtil.
 * 
 * @author superZZ
 * @version 1.0
 */
public class PackageUtilTest extends TestCase {
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
     * PackageUtil instance for test.
     */
    private final MockPackageUtil util = new MockPackageUtil();

    /**
     * Package instance for test.
     */
    private final PackageImpl element = new PackageImpl();

    /**
     * Test method for {@link PackageUtil#PackageUtil()}.
     */
    public void testPackageUtil() {
        new MockPackageUtil();
    }

    /**
     * Test method for {@link PackageUtil#copyElement(ModelElement)}.
     */
    public void testCopyElementModelElement() {
        element.setLeaf(!element.isLeaf());

        PackageImpl newElement = (PackageImpl) util.copyElement(element);

        assertEquals("IsRoot is incorrect.", element.isRoot(), newElement
                .isRoot());
        assertEquals("isLeaf is incorrect.", element.isLeaf(), newElement
                .isLeaf());
        assertEquals("isAbstract is incorrect.", element.isAbstract(),
                newElement.isAbstract());
    }
}
