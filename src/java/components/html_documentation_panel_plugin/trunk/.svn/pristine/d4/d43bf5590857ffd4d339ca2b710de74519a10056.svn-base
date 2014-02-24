/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * HTMLDocumentationEditorTest.java
 */
package com.topcoder.gui.panels.documentation.plugins.html;

import com.topcoder.configuration.ConfigurationObject;
import com.topcoder.configuration.persistence.ConfigurationFileManager;
import com.topcoder.gui.panels.documentation.DocumentationPanelConfigurationException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.event.FocusEvent;


/**
 * <p>Unit tests for <code>HTMLDocumentationEditor</code> class.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class HTMLDocumentationEditorTest extends TestCase {
    /**
     * <p>Default namespace for configuration file.</p>
     */
    private static final String DEFAULT_NS = TestHelper.DEFAULT_NS;

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(HTMLDocumentationEditorTest.class);
    }

    /**
     * <p>Accuracy test for constructor <code>HTMLDocumentationEditorException(namespace)</code>.</p>
     *  <p>Verify that the instance can be created successfully.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtorAccuracy() throws Exception {
        HTMLDocumentationEditor instance = new HTMLDocumentationEditor(DEFAULT_NS);
        assertNotNull("Unable to create HTMLDocumentationEditor instance.", instance);
        assertTrue("Should be instance of HTMLDocumentationEditor.", instance instanceof HTMLDocumentationEditor);
    }

    /**
     * <p>Failure test for constructor <code>HTMLDocumentationEditorException(namespace)</code>.</p>
     *  <p>namespace is null, IAE should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtorFailure1() throws Exception {
        try {
            new HTMLDocumentationEditor((String) null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>Failure test for constructor <code>HTMLDocumentationEditorException(namespace)</code>.</p>
     *  <p>namespace is wrong, DocumentationPanelConfigurationException should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtorFailure2() throws Exception {
        try {
            new HTMLDocumentationEditor("not_exist_ns");
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (DocumentationPanelConfigurationException e) {
            //success
        }
    }

    /**
     * <p>Failure test for constructor <code>HTMLDocumentationEditorException(namespace)</code>.</p>
     *  <p>vsbPolicy is invalid, HTMLDocumentationEditorException should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtorFailure3() throws Exception {
        try {
            new HTMLDocumentationEditor("invalid8");
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }

    /**
     * <p>Failure test for constructor <code>HTMLDocumentationEditorException(namespace)</code>.</p>
     *  <p>hsbPolicy is invalid, HTMLDocumentationEditorException should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtorFailure4() throws Exception {
        try {
            new HTMLDocumentationEditor("invalid9");
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }

    /**
     * <p>Failure test for constructor <code>HTMLDocumentationEditorException(namespace)</code>.</p>
     *  <p>toolBar class not found, HTMLDocumentationEditorException should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtorFailure5() throws Exception {
        try {
            new HTMLDocumentationEditor("invalid10");
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }

    /**
     * <p>Failure test for constructor <code>HTMLDocumentationEditorException(namespace)</code>.</p>
     *  <p>No specified constructor, HTMLDocumentationEditorException should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtorFailure6() throws Exception {
        try {
            new HTMLDocumentationEditor("invalid11");
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }

    /**
     * <p>Failure test for constructor <code>HTMLDocumentationEditorException(namespace)</code>.</p>
     *  <p>invalid constructor parameters, HTMLDocumentationEditorException should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtorFailure7() throws Exception {
        try {
            new HTMLDocumentationEditor("invalid12");
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }

    /**
     * <p>Accuracy test for constructor <code>HTMLDocumentationEditorException(config)</code>.</p>
     *  <p>Verify that the instance can be created successfully.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtorWithConfigAccuracy() throws Exception {
        ConfigurationFileManager configManager = new ConfigurationFileManager();
        ConfigurationObject config = configManager.getConfiguration(DEFAULT_NS);

        HTMLDocumentationEditor instance = new HTMLDocumentationEditor(config);
        assertNotNull("Unable to create HTMLDocumentationEditor instance.", instance);
        assertTrue("Should be instance of HTMLDocumentationEditor.", instance instanceof HTMLDocumentationEditor);
    }

    /**
     * <p>Failure test for constructor <code>HTMLDocumentationEditorException(config)</code>.</p>
     *  <p>configuration object is null, IAE should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtorWithConfigFailure1() throws Exception {
        try {
            new HTMLDocumentationEditor((ConfigurationObject) null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>Accuracy test for method <code>setTarget(element)</code>.</p>
     *  <p>Verify that can set target correctly.</p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTargetAccuracy1() throws Exception {
        HTMLDocumentationEditor instance = new HTMLDocumentationEditor(DEFAULT_NS);
        instance.setTarget(TestHelper.genModelElement());
        assertNotSame("Initialized document should not be empty.", "", instance.getContent().getText());
    }

    /**
     * <p>Accuracy test for method <code>setTarget(element)</code>.</p>
     *  <p>Verify that can set target correctly.</p>
     *  <p>No tagged value.</p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTargetAccuracy2() throws Exception {
        HTMLDocumentationEditor instance = new HTMLDocumentationEditor(DEFAULT_NS);
        instance.setTarget(TestHelper.genModelElementWithoutTaggedValue());
        assertNotSame("Initialized document should not be empty.", "", instance.getContent().getText());
    }

    /**
     * <p>Failure test for method <code>setTarget(element)</code>.</p>
     *  <p>Verify that can set target correctly.</p>
     *  <p>No tagged value.</p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTargetFailure() throws Exception {
        HTMLDocumentationEditor instance = new HTMLDocumentationEditor("invalid13");
        instance.setTarget(TestHelper.genModelElementWithoutTaggedValue());
        assertNotSame("Initialized document should not be empty.", "", instance.getContent().getText());

        //xsd path is invalid, print the stacktrace
    }

    /**
     * <p>Accuracy test for method <code>getContentText()</code>.</p>
     *  <p>Verify that can get content text correctly.</p>
     *
     * @throws Exception to JUnit
     */
    public void testGetContentTextAccuracy() throws Exception {
        HTMLDocumentationEditor instance = new HTMLDocumentationEditor(DEFAULT_NS);
        String newText = "new_text";
        instance.getContent().setText("new_text");

        assertTrue("content should be the same.", instance.getContentText().contains(newText));
    }

    /**
     * <p>Accuracy test for method <code>setToolBar(toolBar)</code>.</p>
     *  <p>Verify that can set toolBar correctly.</p>
     *
     * @throws Exception to JUnit
     */
    public void testSetToolBarAccuracy() throws Exception {
        HTMLDocumentationEditorToolBar toolBar = TestHelper.genToolBar(DEFAULT_NS);
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor(DEFAULT_NS);
        HTMLDocumentationEditorToolBar oldToolBar = editor.getToolBar();
        editor.setToolBar(toolBar);

        assertEquals("toolBar should be the same.", toolBar, editor.getToolBar());
        assertFalse("old toolBar has been removed.", TestHelper.containComponent(editor.getComponents(), oldToolBar));
        assertTrue("new toolBar has been added.", TestHelper.containComponent(editor.getComponents(), toolBar));
    }

    /**
     * <p>Failure test for method <code>setToolBar(toolBar)</code>.</p>
     *  <p>toolBar is null, IAE should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testSetToolBarFailure() throws Exception {
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor(DEFAULT_NS);

        try {
            editor.setToolBar(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>Accuracy test for method <code>getToolBar()</code>.</p>
     *  <p>Verify that can get toolBar correctly.</p>
     *
     * @throws Exception to JUnit
     */
    public void testGetToolBarAccuracy() throws Exception {
        HTMLDocumentationEditorToolBar toolBar = TestHelper.genToolBar(DEFAULT_NS);
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor(DEFAULT_NS);
        editor.setToolBar(toolBar);

        assertEquals("toolBar should be the same.", toolBar, editor.getToolBar());
    }

    /**
     * <p>Accuracy test for method <code>focusGained(event)</code>.</p>
     *  <p>Verify that handle the focus lost event correctly.</p>
     *
     * @throws Exception to JUnit
     */
    public void testFocusGainedAccuracy() throws Exception {
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor(DEFAULT_NS);
        FocusEvent event = new FocusEvent(editor, FocusEvent.FOCUS_GAINED);
        editor.focusLost(event);

        //do nothing
    }

    /**
     * <p>Accuracy test for method <code>focusLost(event)</code>.</p>
     *  <p>Verify that handle the focus lost event correctly.</p>
     *
     * @throws Exception to JUnit
     */
    public void testFocusLostAccuracy1() throws Exception {
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor(DEFAULT_NS);
        editor.setTarget(TestHelper.genModelElement());

        FocusEvent event = new FocusEvent(editor.getContent(), FocusEvent.FOCUS_LOST);
        editor.focusLost(event);
    }

    /**
     * <p>Accuracy test for method <code>focusLost(event)</code>.</p>
     *  <p>Verify that handle the focus lost event correctly.</p>
     *
     * @throws Exception to JUnit
     */
    public void testFocusLostAccuracy2() throws Exception {
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor(DEFAULT_NS);
        editor.setTarget(TestHelper.genModelElement());
        editor.getContent().setText("abc");

        FocusEvent event = new FocusEvent(editor.getContent(), FocusEvent.FOCUS_LOST);
        editor.focusLost(event);
        editor.getContent().setText("def");
        editor.focusLost(event);
    }
}
