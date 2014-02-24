/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins;

import com.topcoder.gui.panels.documentation.DocumentationPanelConfigurationException;
import com.topcoder.gui.panels.documentation.TestHelper;
import com.topcoder.gui.panels.documentation.UnknownElementTypeException;

import junit.framework.TestCase;


/**
 * <p>
 * This test case contains exception tests for
 * <code>TagOptionManager</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class TagOptionManagerTestExp extends TestCase {
    /**
     * <p>
     * Set up the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.addConfig("UnitTest/tagOptionsInvalid.xml");
    }

    /**
     * <p>
     * Tear down the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.removeConfigManagerNS();
        super.tearDown();
    }

    /**
     * <p>
     * Test exception of method <code>TagOptionManager()</code>.
     * </p>
     *
     * <p>
     * Namespace is null, <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     */
    public void testTagOptionManager1() {
        try {
            new TagOptionManager(null);
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf("The given namespace is null") != -1);
        }
    }

    /**
     * <p>
     * Test exception of method <code>TagOptionManager()</code>.
     * </p>
     *
     * <p>
     * Namespace is unknown, <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     */
    public void testTagOptionManager2() {
        try {
            new TagOptionManager("");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf("The given namespace is unknown") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>TagOptionManager()</code>.
     * </p>
     *
     * <p>
     * Namespace is unknown, <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     */
    public void testTagOptionManager3() {
        try {
            new TagOptionManager(" ");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf("The given namespace is unknown") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>TagOptionManager()</code>.
     * </p>
     *
     * <p>
     * Namespace is unknown, <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     */
    public void testTagOptionManager4() {
        try {
            new TagOptionManager("unknown");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf("The given namespace is unknown") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>TagOptionManager()</code>.
     * </p>
     *
     * <p>
     * TYPES contains empty value, <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     */
    public void testTagOptionManager5() {
        try {
            new TagOptionManager("tagOptions_invalid_1");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf("The given namespace contains empty(trimmed) value") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>TagOptionManager()</code>.
     * </p>
     *
     * <p>
     * GLOBAL contains empty value, <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     */
    public void testTagOptionManager6() {
        try {
            new TagOptionManager("tagOptions_invalid_2");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf("The given namespace contains empty(trimmed) value") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>TagOptionManager()</code>.
     * </p>
     *
     * <p>
     * Operation links to an empty type, <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     */
    public void testTagOptionManager7() {
        try {
            new TagOptionManager("tagOptions_invalid_3");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf("The given namespace contains empty(trimmed) value") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>TagOptionManager()</code>.
     * </p>
     *
     * <p>
     * Operation links to an undefined type, <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     */
    public void testTagOptionManager8() {
        try {
            new TagOptionManager("tagOptions_invalid_4");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf("Link value [UndefinedType] is not defined in TYPES property") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>TagOptionManager()</code>.
     * </p>
     *
     * <p>
     * TYPES contains non-exist type, <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     */
    public void testTagOptionManager9() {
        try {
            new TagOptionManager("tagOptions_invalid_5");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf("Defined type [NotExistType] is not configured.") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>TagOptionManager()</code>.
     * </p>
     *
     * <p>
     * GLOBAL links to INTER, INTER links to GLOBAL, loop is detected,
     * <code>DocumentationPanelConfigurationException</code> is expected.
     * </p>
     */
    public void testTagOptionManager10() {
        try {
            new TagOptionManager("tagOptions_invalid_loop_1");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf("Loop detected") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>TagOptionManager()</code>.
     * </p>
     *
     * <p>
     * GLOBAL links to INTER1, INTER1 links to INTER2,
     * INTER2 links to INTER3, INTER3 links to INTER2,
     * loop is detected,
     * <code>DocumentationPanelConfigurationException</code> is expected.
     * </p>
     */
    public void testTagOptionManager11() {
        try {
            new TagOptionManager("tagOptions_invalid_loop_2");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf("Loop detected") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>TagOptionManager()</code>.
     * </p>
     *
     * <p>
     * INTER1 links to INTER2, INTER2 links to INTER1, loop is detected,
     * <code>DocumentationPanelConfigurationException</code> is expected.
     * </p>
     */
    public void testTagOptionManager12() {
        try {
            new TagOptionManager("tagOptions_invalid_loop_3");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf("Loop detected") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>getTagOptions()</code>.
     * </p>
     *
     * <p>
     * Element type is unknown,
     * <code>UnknownElementTypeException</code> is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetTagOptions1() throws Exception {
        try {
            TestHelper.addConfig("UnitTest/tagOptions.xml");
            TagOptionManager manager = new TagOptionManager("tagOptions_2");
            manager.getTagOptions(null);
            fail("UnknownElementTypeException is expected");
        } catch (UnknownElementTypeException e) {
            assertEquals(e.getMessage(), "Element type [null] is unknown.");
        }
    }
    /**
     * <p>
     * Test exception of method <code>getTagOptions()</code>.
     * </p>
     *
     * <p>
     * Element type is empty,
     * <code>UnknownElementTypeException</code> is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetTagOptions2() throws Exception {
        try {
            TestHelper.addConfig("UnitTest/tagOptions.xml");
            TagOptionManager manager = new TagOptionManager("tagOptions_2");
            manager.getTagOptions("");
            fail("UnknownElementTypeException is expected");
        } catch (UnknownElementTypeException e) {
            assertEquals(e.getMessage(), "Element type [] is unknown.");
        }
    }
    /**
     * <p>
     * Test exception of method <code>getTagOptions()</code>.
     * </p>
     *
     * <p>
     * Element type is unknown,
     * <code>UnknownElementTypeException</code> is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetTagOptions3() throws Exception {
        try {
            TestHelper.addConfig("UnitTest/tagOptions.xml");
            TagOptionManager manager = new TagOptionManager("tagOptions_2");
            manager.getTagOptions("unknown type");
            fail("UnknownElementTypeException is expected");
        } catch (UnknownElementTypeException e) {
            assertEquals(e.getMessage(), "Element type [unknown type] is unknown.");
        }
    }
}
