/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins;

import com.topcoder.gui.panels.documentation.DocumentationPanelConfigurationException;
import com.topcoder.gui.panels.documentation.TestHelper;
import com.topcoder.gui.panels.documentation.UnknownElementTypeException;
import com.topcoder.uml.model.core.MethodImpl;

import junit.framework.TestCase;


/**
 * <p>
 * This test case contains exception test
 * for <code>DefaultTagEditor</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class DefaultTagEditorTestExp extends TestCase {

    /**
     * <p>
     * <code>DefaultTagEditor</code> used in the test case.
     * </p>
     */
    private DefaultTagEditor tagEditor = null;

    /**
     * <p>
     * Set up the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.addConfig("UnitTest/tagEditor.xml");
        TestHelper.addConfig("UnitTest/tagOptions.xml");
        TestHelper.addConfig("UnitTest/tagEditorInvalid.xml");
        TestHelper.addConfig("UnitTest/tagOptionsInvalid.xml");
        tagEditor = new DefaultTagEditor("defaultTagEditor_1");
    }

    /**
     * <p>
     * Tear down the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        tagEditor = null;
        TestHelper.removeConfigManagerNS();
        super.tearDown();
    }

    /**
     * <p>
     * Test exception for method <code>DefaultTagEditor()</code>.
     * </p>
     *
     * <p>
     * Namespace is null,
     * <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultTagEditor1() throws Exception {
        try {
            new DefaultTagEditor(null);
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf(
                    "The given namespace is null") != -1);
        }
    }
    /**
     * <p>
     * Test exception for method <code>DefaultTagEditor()</code>.
     * </p>
     *
     * <p>
     * Namespace is unknown,
     * <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultTagEditor2() throws Exception {
        try {
            new DefaultTagEditor("");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf(
                    "The given namespace is unknown") != -1);
        }
    }
    /**
     * <p>
     * Test exception for method <code>DefaultTagEditor()</code>.
     * </p>
     *
     * <p>
     * Namespace is unknown,
     * <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultTagEditor3() throws Exception {
        try {
            new DefaultTagEditor("unknown");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf(
                    "The given namespace is unknown") != -1);
        }
    }
    /**
     * <p>
     * Test exception for method <code>DefaultTagEditor()</code>.
     * </p>
     *
     * <p>
     * The namespace of option manager points to an invalid config,
     * <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultTagEditor4() throws Exception {
        try {
            new DefaultTagEditor("defaultTagEditor_Invalid_1");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf(
                    "The given namespace contains empty(trimmed) value") != -1);
        }
    }
    /**
     * <p>
     * Test exception for method <code>DefaultTagEditor()</code>.
     * </p>
     *
     * <p>
     * The namespace of option manager points to an invalid config,
     * <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultTagEditor5() throws Exception {
        try {
            new DefaultTagEditor("defaultTagEditor_Invalid_2");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf(
                    "Loop detected") != -1);
        }
    }
    /**
     * <p>
     * Test exception for method <code>DefaultTagEditor()</code>.
     * </p>
     *
     * <p>
     * Size of column names is 1,
     * <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultTagEditor6() throws Exception {
        try {
            new DefaultTagEditor("defaultTagEditor_Invalid_3");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf(
                    "The configured properties for table model contain invalid values") != -1);
        }
    }
    /**
     * <p>
     * Test exception for method <code>DefaultTagEditor()</code>.
     * </p>
     *
     * <p>
     * Size of column names is 3,
     * <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultTagEditor7() throws Exception {
        try {
            new DefaultTagEditor("defaultTagEditor_Invalid_4");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf(
                    "The configured properties for table model contain invalid values") != -1);
        }
    }
    /**
     * <p>
     * Test exception for method <code>DefaultTagEditor()</code>.
     * </p>
     *
     * <p>
     * New value prompt is configured as empty,
     * <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultTagEditor8() throws Exception {
        try {
            new DefaultTagEditor("defaultTagEditor_Invalid_5");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf(
                    "The configured properties for table model contain invalid values") != -1);
        }
    }
    /**
     * <p>
     * Test exception for method <code>DefaultTagEditor()</code>.
     * </p>
     *
     * <p>
     * New tag prompt is configured as empty,
     * <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultTagEditor9() throws Exception {
        try {
            new DefaultTagEditor("defaultTagEditor_Invalid_6");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf(
                    "The configured properties for table model contain invalid values") != -1);
        }
    }
    /**
     * <p>
     * Test exception for method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * Target is null,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget1() throws Exception {
        try {
            this.tagEditor.setTarget(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().indexOf(
                    "ModelElement whose tag to be managed should not be null") != -1);
        }
    }
    /**
     * <p>
     * Test exception for method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * Target is an unknown element type,
     * <code>UnknownElementTypeException</code> is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget2() throws Exception {
        try {
            this.tagEditor.setTarget(new MethodImpl());
            fail("UnknownElementTypeException is expected");
        } catch (UnknownElementTypeException e) {
            assertTrue(e.getMessage().indexOf(
                    "Element type [com.topcoder.uml.model.core.MethodImpl] is unknown") != -1);
            DefaultTagTableModel model = (DefaultTagTableModel) TestHelper.getField(this.tagEditor, "tagModel");
            assertEquals("table model should be cleared", 1, model.getRowCount());
        }
    }
}
