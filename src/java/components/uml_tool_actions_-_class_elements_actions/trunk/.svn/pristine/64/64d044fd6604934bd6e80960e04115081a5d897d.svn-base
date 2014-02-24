/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.MockInterfaceUtil;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;

/**
 * Accuracy tests for ClassUtil.
 * 
 * @author superZZ
 * @version 1.0
 */
public class InterfaceUtilTest extends TestCase {
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
     * Test method for {@link InterfaceUtil#copyElement(ModelElement)}.
     */
    public void testCopyElement() {
        MockInterfaceUtil util = new MockInterfaceUtil();
        InterfaceImpl oldInterface = new InterfaceImpl();

        oldInterface.setName("Interface");
        InterfaceImpl newElement = (InterfaceImpl) util
                .copyElement(oldInterface);

        assertEquals("Name is incorrect.", "Interface", newElement.getName());
    }

    /**
     * Test method for {@link InterfaceUtil#InterfaceUtil()}.
     */
    public void testInterfaceUtil() {
        new MockInterfaceUtil();
    }
}
