/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation;

import com.topcoder.gui.panels.documentation.plugins.DefaultDocumentationEditor;
import com.topcoder.util.config.UnknownNamespaceException;
import com.topcoder.util.objectfactory.InvalidClassSpecificationException;
import com.topcoder.util.objectfactory.impl.IllegalReferenceException;
import com.topcoder.util.objectfactory.impl.SpecificationConfigurationException;

import junit.framework.TestCase;


/**
 * <p>
 * This test case contains exception tests for
 * <code>DocumentationPanel</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class DocumentationPanelTestExp extends TestCase {

    /**
     * <p>
     * <code>DocumentationPanel</code> used in the test case.
     * </p>
     */
    private DocumentationPanel dp = null;

    /**
     * <p>
     * Set up the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.addConfig("UnitTest/docPanel.xml");
        TestHelper.addConfig("UnitTest/docPanelInvalid.xml");
        TestHelper.addConfig("UnitTest/docEditor.xml");
        TestHelper.addConfig("UnitTest/tagEditor.xml");
        TestHelper.addConfig("UnitTest/tagEditorInvalid.xml");
        TestHelper.addConfig("UnitTest/tagOptions.xml");
        TestHelper.addConfig("UnitTest/tagOptionsInvalid.xml");
        dp = new DocumentationPanel("docPanelNamespace1");
    }

    /**
     * <p>
     * Tear down the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        dp = null;
        TestHelper.removeConfigManagerNS();
        super.tearDown();
    }

    /**
     * <p>
     * Test exception of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * <p>
     * Namespace is null,
     * <code>DocumentationPanelConfigurationException</code> is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel1() throws Exception {
        try {
            new DocumentationPanel(null);
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getCause() instanceof NullPointerException);
            assertTrue(e.getMessage().indexOf(
                    "The given namespace is null") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * <p>
     * Namespace is unknown,
     * <code>DocumentationPanelConfigurationException</code> is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel2() throws Exception {
        try {
            new DocumentationPanel("unknown");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getCause() instanceof UnknownNamespaceException);
            assertTrue(e.getMessage().indexOf(
                    "The given namespace is unknown") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * <p>
     * "objectFactoryNamespace" property is missed,
     * <code>DocumentationPanelConfigurationException</code> is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel3() throws Exception {
        try {
            new DocumentationPanel("docPanel_Invalid_1");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getCause() instanceof IllegalArgumentException);
            assertTrue(e.getMessage().indexOf(
                    "Error occurs while getting ObjectFactory or creating object") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * <p>
     * value of "objectFactoryNamespace" property is empty,
     * <code>DocumentationPanelConfigurationException</code> is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel4() throws Exception {
        try {
            new DocumentationPanel("docPanel_Invalid_2");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getCause() instanceof IllegalArgumentException);
            assertTrue(e.getMessage().indexOf(
                    "Error occurs while getting ObjectFactory or creating object") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * <p>
     * value of "objectFactoryNamespace" property points to an unknown namespace,
     * <code>DocumentationPanelConfigurationException</code> is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel5() throws Exception {
        try {
            new DocumentationPanel("docPanel_Invalid_3");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getCause() instanceof SpecificationConfigurationException);
            assertTrue(e.getMessage().indexOf(
                    "Error occurs while getting ObjectFactory") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * <p>
     * value of "objectFactoryNamespace" property points to an invalid namespace,
     * <code>DocumentationPanelConfigurationException</code> is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel6() throws Exception {
        try {
            new DocumentationPanel("docPanel_Invalid_4");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getCause() instanceof IllegalReferenceException);
            assertTrue(e.getMessage().indexOf(
                    "Error occurs while getting ObjectFactory") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * <p>
     * value of "objectFactoryNamespace" property points to an invalid namespace,
     * <code>DocumentationPanelConfigurationException</code> is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel7() throws Exception {
        try {
            new DocumentationPanel("docPanel_Invalid_5");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getCause() instanceof InvalidClassSpecificationException);
            assertTrue(e.getMessage().indexOf(
                    "Error occurs while creating object through ObjectFactory") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * <p>
     * value of "objectFactoryNamespace" property points to an invalid namespace,
     * <code>DocumentationPanelConfigurationException</code> is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel8() throws Exception {
        try {
            new DocumentationPanel("docPanel_Invalid_6");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getCause() instanceof ClassCastException);
            assertTrue(e.getMessage().indexOf(
                    "Error occurs while creating editor through ObjectFactory") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * <p>
     * Document editor is null,
     * <code>DocumentationPanelConfigurationException</code> is expected.
     * </p>
     */
    public void testDocumentationPanel9() {
        try {
            new DocumentationPanel(null, null);
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf(
                    "Document editor should not be null.") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * <p>
     * Tag editor is null,
     * <code>DocumentationPanelConfigurationException</code> is expected.
     * </p>
     */
    public void testDocumentationPanel10() {
        try {
            new DocumentationPanel(new DefaultDocumentationEditor("defaultDocEditor_1"), null);
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf(
                    "Tag editor should not be null.") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * <p>
     * value of "objectFactoryNamespace" property points to an invalid namespace,
     * <code>DocumentationPanelConfigurationException</code> is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel11() throws Exception {
        try {
            new DocumentationPanel("docPanel_Invalid_7");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getCause() instanceof InvalidClassSpecificationException);
            assertTrue(e.getMessage().indexOf(
                    "Error occurs while creating object through ObjectFactory") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * <p>
     * value of "objectFactoryNamespace" property points to an invalid namespace,
     * <code>DocumentationPanelConfigurationException</code> is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel12() throws Exception {
        try {
            new DocumentationPanel("docPanel_Invalid_8");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getCause() instanceof InvalidClassSpecificationException);
            assertTrue(e.getMessage().indexOf(
                    "Error occurs while creating object through ObjectFactory") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>addDocumentationListener()</code>.
     * </p>
     *
     * <p>
     * Document listener is null, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testAddDocumentationListener() {
        try {
            this.dp.addDocumentationListener(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "DocumentationListener to be attached should not be null.");
        }
    }

    /**
     * <p>
     * Test exception of method <code>addTagListener()</code>.
     * </p>
     *
     * <p>
     * Tag listener is null, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testAddTagListener() {
        try {
            this.dp.addTagListener(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "TagListener to be attached should not be null.");
        }
    }
}
