/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements.failuretests;

import junit.framework.TestCase;

import com.topcoder.gui.toolbars.elements.SectionPanel;
import com.topcoder.gui.toolbars.elements.SectionPanelConfigurationException;

/**
 * This class aggregates failure tests for SectionPanel constructor that requires configuration.
 * 
 * @author ch_music
 * @version 1.0
 */
public class SectionPanelConstructorWithConfigFailureTests extends TestCase {

    /**
     * Tears down testing environment.
     * 
     * @throws Exception to JUnit
     */
    public void tearDown() throws Exception {
        FailureTestHelper.tearConfig();
    }

    /**
     * Tests constructor(String) with null namespace. IllegalArgumentException is expected.
     * 
     * @throws Exception to JUnit
     */
    public void testSectionPanelString_NullNamespace() throws Exception {
        try {
            new SectionPanel(null);
            fail("Did not throw IllegalArgumentException with null namespace.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests constructor(String) with empty string namespace. IllegalArgumentException is expected.
     * 
     * @throws Exception to JUnit
     */
    public void testSectionPanelString_EmptyStrNamespace() throws Exception {
        try {
            new SectionPanel("");
            fail("Did not throw IllegalArgumentException with empty string namespace.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests constructor(String) with invalid namespace. SectionPanelConfigurationException is expected.
     * 
     * @throws Exception to JUnit
     */
    public void testSectionPanelString_InvalidNamespace() throws Exception {
        try {
            new SectionPanel(FailureTestHelper.NAMESPACE);
            fail("Did not throw SectionPanelConfigurationException with invalid namespace.");
        } catch (SectionPanelConfigurationException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests constructor(String) with invalid configuration fields. SectionPanelConfigurationException is expected.
     * 
     * @throws Exception to JUnit
     */
    public void testSectionPanelString_InvalidConfig1() throws Exception {
        FailureTestHelper.loadConfig(FailureTestHelper.NAMESPACE, FailureTestHelper.CONFIG_DIR
                + "failuretests1.xml");
        try {
            new SectionPanel(FailureTestHelper.NAMESPACE);
            fail("Did not throw SectionPanelConfigurationException with invalid configuration fields.");
        } catch (SectionPanelConfigurationException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests constructor(String) with invalid configuration fields. SectionPanelConfigurationException is expected.
     * 
     * @throws Exception to JUnit
     */
    public void testSectionPanelString_InvalidConfig2() throws Exception {
        FailureTestHelper.loadConfig(FailureTestHelper.NAMESPACE, FailureTestHelper.CONFIG_DIR
                + "failuretests2.xml");
        try {
            new SectionPanel(FailureTestHelper.NAMESPACE);
            fail("Did not throw SectionPanelConfigurationException with invalid configuration fields.");
        } catch (SectionPanelConfigurationException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests constructor(String) with invalid configuration fields. SectionPanelConfigurationException is expected.
     * 
     * @throws Exception to JUnit
     */
    public void testSectionPanelString_InvalidConfig3() throws Exception {
        FailureTestHelper.loadConfig(FailureTestHelper.NAMESPACE, FailureTestHelper.CONFIG_DIR
                + "failuretests3.xml");
        try {
            new SectionPanel(FailureTestHelper.NAMESPACE);
            fail("Did not throw SectionPanelConfigurationException with invalid configuration fields.");
        } catch (SectionPanelConfigurationException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests constructor(String) with invalid configuration fields. SectionPanelConfigurationException is expected.
     * 
     * @throws Exception to JUnit
     */
    public void testSectionPanelString_InvalidConfig4() throws Exception {
        FailureTestHelper.loadConfig(FailureTestHelper.NAMESPACE, FailureTestHelper.CONFIG_DIR
                + "failuretests4.xml");
        try {
            new SectionPanel(FailureTestHelper.NAMESPACE);
            fail("Did not throw SectionPanelConfigurationException with invalid configuration fields.");
        } catch (SectionPanelConfigurationException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests constructor(String) with invalid configuration fields. SectionPanelConfigurationException is expected.
     * 
     * @throws Exception to JUnit
     */
    public void testSectionPanelString_InvalidConfig5() throws Exception {
        FailureTestHelper.loadConfig(FailureTestHelper.NAMESPACE, FailureTestHelper.CONFIG_DIR
                + "failuretests5.xml");
        try {
            new SectionPanel(FailureTestHelper.NAMESPACE);
            fail("Did not throw SectionPanelConfigurationException with invalid configuration fields.");
        } catch (SectionPanelConfigurationException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests constructor(String) with invalid configuration fields. SectionPanelConfigurationException is expected.
     * 
     * @throws Exception to JUnit
     */
    public void testSectionPanelString_InvalidConfig6() throws Exception {
        FailureTestHelper.loadConfig(FailureTestHelper.NAMESPACE, FailureTestHelper.CONFIG_DIR
                + "failuretests6.xml");
        try {
            new SectionPanel(FailureTestHelper.NAMESPACE);
            fail("Did not throw SectionPanelConfigurationException with invalid configuration fields.");
        } catch (SectionPanelConfigurationException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests constructor(String) with invalid configuration fields. SectionPanelConfigurationException is expected.
     * 
     * @throws Exception to JUnit
     */
    public void testSectionPanelString_InvalidConfig7() throws Exception {
        FailureTestHelper.loadConfig(FailureTestHelper.NAMESPACE, FailureTestHelper.CONFIG_DIR
                + "failuretests7.xml");
        try {
            new SectionPanel(FailureTestHelper.NAMESPACE);
            fail("Did not throw SectionPanelConfigurationException with invalid configuration fields.");
        } catch (SectionPanelConfigurationException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests constructor(String) with invalid configuration fields. SectionPanelConfigurationException is expected.
     * 
     * @throws Exception to JUnit
     */
    public void testSectionPanelString_InvalidConfig8() throws Exception {
        FailureTestHelper.loadConfig(FailureTestHelper.NAMESPACE, FailureTestHelper.CONFIG_DIR
                + "failuretests8.xml");
        try {
            new SectionPanel(FailureTestHelper.NAMESPACE);
            fail("Did not throw SectionPanelConfigurationException with invalid configuration fields.");
        } catch (SectionPanelConfigurationException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }
}
