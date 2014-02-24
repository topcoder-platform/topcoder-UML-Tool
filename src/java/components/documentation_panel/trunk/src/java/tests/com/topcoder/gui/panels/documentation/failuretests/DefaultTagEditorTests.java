/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.failuretests;

import com.topcoder.gui.panels.documentation.DocumentationPanelConfigurationException;
import com.topcoder.gui.panels.documentation.TagEditor;
import com.topcoder.gui.panels.documentation.UnknownElementTypeException;
import com.topcoder.gui.panels.documentation.plugins.DefaultTagEditor;

import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.TestCase;


/**
 * Test cases for the class DefaultTagEditor.
 *
 * @author waits
 * @version 1.0
 */
public class DefaultTagEditorTests extends TestCase {
    /** DefaultTagEditor instance to test against. */
    private TagEditor editor = null;

    /**
     * create instances for testing.
     *
     * @throws Exception into JUnit
     */
    protected void setUp() throws Exception {
        Helper.clearConfiguration();
        Helper.addConfigFile(Helper.TAG_EDITOR_CONFIG_FILE);
        Helper.addConfigFile(Helper.TAG_OPTION_MANAGER_CONFIG_FILE);
        this.editor = new DefaultTagEditor(Helper.TAG_EDITOR_NAMESPACE_PREFIX + "valid");
    }

    /**
     * The tag option manager's namespace is invalid. DocumentationPanelConfigurationException expected.
     */
    public void testCtor_invalidOptionManagerConfig() {
        try {
            new DefaultTagEditor(Helper.TAG_EDITOR_NAMESPACE_PREFIX + "1");
            fail("The tag option manager namespace is invalid.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * The 'columnnames' is invalid. DocumentationPanelConfigurationException expected.
     */
    public void testCtor_invalidColumnNames() {
        try {
            new DefaultTagEditor(Helper.TAG_EDITOR_NAMESPACE_PREFIX + "2");
            fail("The 'columnnames' values should be of size 2.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * The 'columnnames' is invalid. DocumentationPanelConfigurationException expected.
     */
    public void testCtor_invalidColumnNames2() {
        try {
            new DefaultTagEditor(Helper.TAG_EDITOR_NAMESPACE_PREFIX + "3");
            fail("The 'columnnames' values should be of size 2.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * The 'valueprompt' is invalid. DocumentationPanelConfigurationException expected.
     */
    public void testCtor_invalidValueprompt() {
        try {
            new DefaultTagEditor(Helper.TAG_EDITOR_NAMESPACE_PREFIX + "4");
            fail("The 'valueprompt' values is empty.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * The target to set is null, IllegalArgumentException expected.
     * </p>
     *
     * @throws Exception into JUnit
     */
    public void testSetTarget_nullParam() throws Exception {
        try {
            this.editor.setTarget(null);
            fail("The target is null.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * <p>
     * The target to set is unknown, UnknownElementTypeException expected.
     * </p>
     *
     * @throws Exception into JUnit
     */
    public void testSetTarget_emptyTarget() throws Exception {
        try {
            this.editor.setTarget(new AttributeImpl());
            fail("The model has no tag options.");
        } catch (UnknownElementTypeException e) {
            //good
        }
    }

    /**
     * Add null listener, iae expected.
     */
    public void testAddTagListener_nullParam() {
        try {
            this.editor.addTagListener(null);
            fail("The listener to add is null");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * The tagName is null. IllegalArgumentException expected.
     */
    public void testFireTagCreated_nullParam() {
        try {
            this.editor.fireTagCreated(new TaggedValueImpl(), null, "not");
            fail("The tagName is null.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * The tagName is empty. IllegalArgumentException expected.
     */
    public void testFireTagCreated_emptyParam() {
        try {
            this.editor.fireTagCreated(new TaggedValueImpl(), " ", "not");
            fail("The tagName is empty.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * The current is null. IllegalArgumentException expected.
     */
    public void testFireTagCreated_nullParam2() {
        try {
            this.editor.fireTagCreated(new TaggedValueImpl(), "not", null);
            fail("The current is null.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * The current is empty. IllegalArgumentException expected.
     */
    public void testFireTagCreated_emptyParam2() {
        try {
            this.editor.fireTagCreated(new TaggedValueImpl(), "not", null);
            fail("The current is empty.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * The tagName is null. IllegalArgumentException expected.
     */
    public void testFireTagDeleted_nullParam() {
        try {
            this.editor.fireTagDeleted(new TaggedValueImpl(), null, "not");
            fail("The tagName is null.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * The tagName is empty. IllegalArgumentException expected.
     */
    public void testFireTagDeleted_emptyParam() {
        try {
            this.editor.fireTagDeleted(new TaggedValueImpl(), " ", "not");
            fail("The tagName is empty.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * The current is null. IllegalArgumentException expected.
     */
    public void testFireTagDeleted_nullParam2() {
        try {
            this.editor.fireTagDeleted(new TaggedValueImpl(), "not", null);
            fail("The current is null.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * The current is empty. IllegalArgumentException expected.
     */
    public void testFireTagDeleted_emptyParam2() {
        try {
            this.editor.fireTagDeleted(new TaggedValueImpl(), "not", null);
            fail("The current is empty.");
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
