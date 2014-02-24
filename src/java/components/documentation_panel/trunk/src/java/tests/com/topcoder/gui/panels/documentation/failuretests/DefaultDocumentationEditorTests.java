/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.failuretests;

import com.topcoder.gui.panels.documentation.DocumentationEditor;
import com.topcoder.gui.panels.documentation.DocumentationPanelConfigurationException;
import com.topcoder.gui.panels.documentation.plugins.DefaultDocumentationEditor;

import junit.framework.TestCase;


/**
 * <p>Failure test cases for the class DefaultDocumentationEditor.</p>
 *
 * @author waits
 * @version 1.0
 */
public class DefaultDocumentationEditorTests extends TestCase {
    /** DefaultDocumentationEditor instance to test against. */
    private DocumentationEditor editor = null;

    /**
     * create instance for testing.
     *
     * @throws Exception into Junit
     */
    protected void setUp() throws Exception {
        Helper.addConfigFile(Helper.DOC_EDITOR_CONFIG_FILE);
        editor = new DefaultDocumentationEditor(Helper.DOC_EDITOR_NAMESPACE_PREFIX + "1");
    }

    /**
     * @see junit.framework.TestCase#tearDown()
     * @throws Exception to JUnit
     */
    @Override
    protected void tearDown() throws Exception {
        Helper.clearConfiguration();
    }

    /**
     * Create the editor with null namespace, DocumentationPanelConfigurationException expected.
     */
    public void testCtor_nullNamespace() {
        try {
            new DefaultDocumentationEditor(null);
            fail("The namespace is null.");
        } catch (DocumentationPanelConfigurationException e) {
            // ignore
        }
    }

    /**
     * Create the editor with empty namespace, DocumentationPanelConfigurationException expected.
     */
    public void testCtor_emptyNamespace() {
        try {
            new DefaultDocumentationEditor("  ");
            fail("The namespace is empty.");
        } catch (DocumentationPanelConfigurationException e) {
            // ignore
        }
    }

    /**
     * Create the editor with not exists namespace, DocumentationPanelConfigurationException expected.
     */
    public void testCtor_notExistNamespace() {
        try {
            new DefaultDocumentationEditor("notExistnamespace");
            fail("The namespace does not exist.");
        } catch (DocumentationPanelConfigurationException e) {
            // ignore
        }
    }

    /**
     * Test setTarget with null element.
     *
     * @throws Exception into JUnit
     */
    public void testSetTarget_nullElement() throws Exception {
        try {
            this.editor.setTarget(null);
            fail("The target is null.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Test addDocumentationListener method. The DocumentListener to add is null, IllegalArgumentException expected
     */
    public void testAddDocumentationListener_nullParam() {
        try {
            this.editor.addDocumentationListener(null);
            fail("The listener is null.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}
