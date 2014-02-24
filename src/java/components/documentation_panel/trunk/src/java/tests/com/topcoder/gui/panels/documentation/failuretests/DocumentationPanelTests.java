/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.failuretests;

import com.topcoder.gui.panels.documentation.DocumentationPanel;
import com.topcoder.gui.panels.documentation.DocumentationPanelConfigurationException;

import junit.framework.TestCase;


/**
 * Test the class DocumentationPanel.
 *
 * @author waits
 * @version 1.0
 */
public class DocumentationPanelTests extends TestCase {
    /** DocumentationPanel instance to test against. */
    private DocumentationPanel panel = null;

    /**
     * create instances for testing.
     *
     * @throws Exception into JUnit
     */
    protected void setUp() throws Exception {
        Helper.clearConfiguration();
        Helper.addConfigFile(Helper.CONFIG_FILE);
        Helper.addConfigFile(Helper.DOC_EDITOR_CONFIG_FILE);
        Helper.addConfigFile(Helper.DOC_PANEL_CONFIG_FILE);
        Helper.addConfigFile(Helper.TAG_EDITOR_CONFIG_FILE);
        Helper.addConfigFile(Helper.TAG_OPTION_MANAGER_CONFIG_FILE);
        panel = new DocumentationPanel(Helper.NAMESPACE);
    }

    /**
     * The namespace is null. DocumentationPanelConfigurationException expected.
     */
    public void testCtor_nullValue() {
        try {
            new DocumentationPanel(null);
            fail("The namespace is null.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * The namespace is empty. DocumentationPanelConfigurationException expected.
     */
    public void testCtor_emptyValue() {
        try {
            new DocumentationPanel(" ");
            fail("The namespace is empty.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * The namespace does not exist. DocumentationPanelConfigurationException expected.
     */
    public void testCtor_notExistNamespace() {
        try {
            new DocumentationPanel("notExists");
            fail("The namespace does not exist.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * The 'objectFactoryNamespace' is missing. DocumentationPanelConfigurationException expected
     */
    public void testCtor_invalidConfig1() {
        try {
            new DocumentationPanel(Helper.DOC_EDITOR_NAMESPACE_PREFIX + "1");
            fail("The objectFactoryNamespace does not exist.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * The 'objectFactoryNamespace' is empty. DocumentationPanelConfigurationException expected
     */
    public void testCtor_invalidConfig2() {
        try {
            new DocumentationPanel(Helper.DOC_EDITOR_NAMESPACE_PREFIX + "2");
            fail("The objectFactoryNamespace is empty.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * The 'objectFactoryNamespace' 's value point to a not exist namespace.
     * DocumentationPanelConfigurationException expected
     */
    public void testCtor_invalidConfig3() {
        try {
            new DocumentationPanel(Helper.DOC_EDITOR_NAMESPACE_PREFIX + "3");
            fail("The objectFactoryNamespace is invalid with unknown namespace.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * The 'objectFactoryNamespace' with invalid config. DocumentationPanelConfigurationException expected
     */
    public void testCtor_invalidConfig4() {
        try {
            new DocumentationPanel(Helper.DOC_EDITOR_NAMESPACE_PREFIX + "4");
            fail("The objectFactoryNamespace is invalid.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * The 'objectFactoryNamespace' with invalid config. DocumentationPanelConfigurationException expected
     */
    public void testCtor_invalidConfig5() {
        try {
            new DocumentationPanel(Helper.DOC_EDITOR_NAMESPACE_PREFIX + "5");
            fail("The objectFactoryNamespace is invalid.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * The 'objectFactoryNamespace' with invalid config. DocumentationPanelConfigurationException expected
     */
    public void testCtor_invalidConfig6() {
        try {
            new DocumentationPanel(Helper.DOC_EDITOR_NAMESPACE_PREFIX + "6");
            fail("The objectFactoryNamespace is invalid.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * The 'objectFactoryNamespace' with invalid config. DocumentationPanelConfigurationException expected
     */
    public void testCtor_invalidConfig7() {
        try {
            new DocumentationPanel(Helper.DOC_EDITOR_NAMESPACE_PREFIX + "7");
            fail("The objectFactoryNamespace is invalid.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * The 'objectFactoryNamespace' with invalid config. DocumentationPanelConfigurationException expected
     */
    public void testCtor_invalidConfig8() {
        try {
            new DocumentationPanel(Helper.DOC_EDITOR_NAMESPACE_PREFIX + "8");
            fail("The objectFactoryNamespace is invalid.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * The 'objectFactoryNamespace' with invalid config. DocumentationPanelConfigurationException expected
     */
    public void testCtor_invalidConfig9() {
        try {
            new DocumentationPanel(Helper.DOC_EDITOR_NAMESPACE_PREFIX + "9");
            fail("The objectFactoryNamespace is invalid.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * The two editors are null.
     */
    public void testCtor_NullTagEdtior() {
        try {
            new DocumentationPanel(null, null);
            fail("The tag is null");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * The target is null.
     */
    public void testSetTarget_null() {
        this.panel.setTarget(null);
    }

    /**
     * Test addDocumentationListener method with null value, IllegalArgumentException expected.
     */
    public void testAddDocumentationListener() {
        try {
            this.panel.addDocumentationListener(null);
            fail("The listener is null.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * Test addTagListener method with null value, IllegalArgumentException expected.
     */
    public void testAddTagListener() {
        try {
            this.panel.addTagListener(null);
            fail("The listener is null.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * clear the environment.
     *
     * @throws Exception into Junit
     */
    protected void tearDown() throws Exception {
        Helper.clearConfiguration();
    }
}
