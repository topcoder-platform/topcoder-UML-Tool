/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import junit.framework.TestCase;

import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterConfigurationException;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.DiagramTitleConverter;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * Failure test fixture for <code>DiagramTitleConverter</code> class.
 * </p>
 * @author Thinfox
 * @version 1.0
 */
public class DiagramTitleConverterFailureTests extends TestCase {
    /**
     * <p>
     * Set up the environment.
     * </p>
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        FailureTestHelper.clearConfig();
        ConfigManager.getInstance().add("failure/DiagramTitleConverter.xml");        
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
     * Tests the ctor <code>DiagramTitleConverter(String)</code>.
     * </p>
     * <p>
     * When the namespace is null, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_Null() throws Exception {
        try {
            new DiagramTitleConverter(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>DiagramTitleConverter(String)</code>.
     * </p>
     * <p>
     * When the namespace is empty, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_Empty() throws Exception {
        try {
            new DiagramTitleConverter("  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>DiagramTitleConverter(String)</code>.
     * </p>
     * <p>
     * When the namespace doesn't exist, XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_Unknown() throws Exception {
        try {
            new DiagramTitleConverter("unknown");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>DiagramTitleConverter(String)</code>.
     * </p>
     * <p>
     * When the property DefaultTextElementProperties contains a sub-property with multi-values,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_DefaultTextElementPropertiesMultiValues() throws Exception {
        try {
            new DiagramTitleConverter("DefaultTextElementPropertiesMultiValues");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }    
}
