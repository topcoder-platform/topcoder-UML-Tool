/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins;

import java.awt.event.FocusEvent;

import javax.swing.JTextArea;

import com.topcoder.gui.panels.documentation.DocumentationPanelConfigurationException;
import com.topcoder.gui.panels.documentation.TestHelper;

import junit.framework.TestCase;


/**
 * <p>
 * This test case contains exception tests for
 * <code>DefaultDocumentationEditor</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class DefaultDocumentationEditorTestExp extends TestCase {

    /**
     * <p>
     * <code>DefaultDocumentationEditor</code> used in this test case.
     * </p>
     */
    private DefaultDocumentationEditor docEditor = null;

    /**
     * <p>
     * Set up the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.addConfig("UnitTest/docEditor.xml");
        docEditor = new DefaultDocumentationEditor("defaultDocEditor_1");
    }

    /**
     * <p>
     * Tear down the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        docEditor = null;
        TestHelper.removeConfigManagerNS();
        super.tearDown();
    }

    /**
     * <p>
     * Test exception of method <code>DefaultDocumentationEditor()</code>.
     * </p>
     *
     * <p>
     * Namespace is null, <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     */
    public void testDefaultDocumentationEditor1() {
        try {
            new DefaultDocumentationEditor(null);
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf("The given namespace is null") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>DefaultDocumentationEditor()</code>.
     * </p>
     *
     * <p>
     * Namespace dose not exist, <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     */
    public void testDefaultDocumentationEditor2() {
        try {
            new DefaultDocumentationEditor("");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf("The given namespace is unknown") != -1);
        }
    }
    /**
     * <p>
     * Test exception of method <code>DefaultDocumentationEditor()</code>.
     * </p>
     *
     * <p>
     * Namespace dose not exist, <code>DocumentationPanelConfigurationException</code>
     * is expected.
     * </p>
     */
    public void testDefaultDocumentationEditor3() {
        try {
            new DefaultDocumentationEditor("NoSuchNamespace");
            fail("DocumentationPanelConfigurationException is expected");
        } catch (DocumentationPanelConfigurationException e) {
            assertTrue(e.getMessage().indexOf("The given namespace is unknown") != -1);
        }
    }

    /**
     * <p>
     * Test exception of method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>ModelElement</code> is null, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget() throws Exception {
        try {
            this.docEditor.setTarget(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "ModelElement whose documentation to be managed should not be null.");
        }
    }
    /**
     * <p>
     * Test exception of method <code>focusLost()</code>.
     * </p>
     *
     * <p>
     * No target is managed by editor, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFocusLost() throws Exception {
        try {
            JTextArea ta = (JTextArea) TestHelper.getField(docEditor, "content");
            ta.setText("xxxxx");
            FocusEvent e = new FocusEvent(ta, FocusEvent.FOCUS_LOST);
            this.docEditor.focusLost(e);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "ModelElement whose documentation being modified should not be null.");
        }
    }
}
