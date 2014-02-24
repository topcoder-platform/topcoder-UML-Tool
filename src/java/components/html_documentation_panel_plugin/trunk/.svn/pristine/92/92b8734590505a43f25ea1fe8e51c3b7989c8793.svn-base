/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins.html.failuretests;

import javax.swing.ImageIcon;
import javax.swing.text.StyledEditorKit;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.configuration.ConfigurationObject;
import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditor;
import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditorToolBar;
import com.topcoder.gui.panels.documentation.plugins.html.toolbars.DefaultHTMLDocumentationEditorToolBar;

/**
 * <p>
 * FailureTest for HTMLDocumentationEditorToolBar class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class HTMLDocumentationEditorToolBarFailureTest extends TestCase {
    /** Provide the config for toolbar. */
    private ConfigurationObject toolbarConfig;

    /** Provide the config for editor. */
    private ConfigurationObject editorConfig;

    /** Create the editor for testing. */
    private HTMLDocumentationEditor editor;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(HTMLDocumentationEditorToolBarFailureTest.class);
    }

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        toolbarConfig = FailureTestHelper.getToolBarConfig();
        editorConfig = FailureTestHelper.getEditorConfig();
        editor = new HTMLDocumentationEditor(editorConfig);
    }

    /**
     * <p>
     * Failure test of <code>addToolBarButton(Icon icon, Action action, Character key, String tip)</code> method.
     * </p>
     * <p>
     * Test with null icon.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddToolBarButtonFailure1() throws Exception {
        HTMLDocumentationEditorToolBar toolbar = new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);

        try {
            toolbar.addToolBarButton(null, new StyledEditorKit.CutAction(), 'X', "tooltip");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>addToolBarButton(Icon icon, Action action, Character key, String tip)</code> method.
     * </p>
     * <p>
     * Test with null action.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddToolBarButtonFailure2() throws Exception {
        HTMLDocumentationEditorToolBar toolbar = new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);

        try {
            toolbar.addToolBarButton(new ImageIcon("test_files/failuretests/cut.png"), null, 'X', "tooltip");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
