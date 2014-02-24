/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.MockClassUtil;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * Accuracy tests for ClassUtil.
 * 
 * @author superZZ
 * @version 1.0
 */
public class ClassUtilTest extends TestCase {
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
     * Test method for {@link ClassUtil#copyElement(ModelElement)}.
     */
    public void testCopyElement() {
        MockClassUtil util = new MockClassUtil();

        ClassImpl oldClass = new ClassImpl();
        oldClass.setActive(false);
        ClassImpl newClass = (ClassImpl) util.copyElement(oldClass);

        assertFalse("isActive is incorrect.", newClass.isActive());

        oldClass.setActive(true);
        newClass = (ClassImpl) util.copyElement(oldClass);

        assertTrue("isActive is incorrect.", newClass.isActive());
    }

    /**
     * Test method for {@link¡¡ClassUtil#ClassUtil()}.
     */
    public void testClassUtil() {
        new MockClassUtil();
    }
}
