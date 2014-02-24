/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import junit.framework.TestCase;

import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterConfigurationException;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.RenameConverter;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * Failure test fixture for <code>RenameConverter</code> class.
 * </p>
 * @author Thinfox
 * @version 1.0
 */
public class RenameConverterFailureTests extends TestCase {
    /**
     * <p>
     * Set up the environment.
     * </p>
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        FailureTestHelper.clearConfig();
        ConfigManager.getInstance().add("failure/RenameConverter.xml");
    }

    /**
     * <p>
     * Tear down the environment.
     * </p>
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        FailureTestHelper.clearConfig();
    }

    /**
     * <p>
     * Tests the ctor <code>RenameConverter()</code>.
     * </p>
     * <p>
     * When the namespace is null, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_Null() throws Exception {
        try {
            new RenameConverter(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>RenameConverter()</code>.
     * </p>
     * <p>
     * When the namespace is empty, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_Empty() throws Exception {
        try {
            new RenameConverter(" ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>RenameConverter()</code>.
     * </p>
     * <p>
     * When the namespace is unknown, XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_UnknownNamespace() throws Exception {
        try {
            new RenameConverter("unknown");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>RenameConverter()</code>.
     * </p>
     * <p>
     * When the property ToRenameNames contains a sub-property with multi-values,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_ToRenameNamesMultiValues() throws Exception {
        try {
            new RenameConverter("ToRenameNamesMultiValues");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }
}
