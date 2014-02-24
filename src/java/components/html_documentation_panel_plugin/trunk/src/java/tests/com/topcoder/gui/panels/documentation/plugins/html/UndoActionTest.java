/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * UndoActionTest.java
 */
package com.topcoder.gui.panels.documentation.plugins.html;

import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditorToolBar.UndoAction;
import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditorToolBar.UndoHandler;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.event.ActionEvent;

import java.lang.reflect.Field;

import javax.swing.Action;
import javax.swing.event.UndoableEditEvent;


/**
 * <p>Unit tests for <code>UndoAction</code> class.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UndoActionTest extends TestCase {
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
        return new TestSuite(UndoActionTest.class);
    }

    /**
     * <p>Accuracy test for constructor <code>UndoAction()</code>.</p>
     *  <p>Verify that the instance can be created successfully.</p>
     */
    public void testCtor() {
        HTMLDocumentationEditorToolBar instance = TestHelper.genToolBar(DEFAULT_NS);
        UndoAction action = instance.new UndoAction();
        assertNotNull("Unable to create UndoAction instance.", action);
        assertTrue("Should be instance of UndoAction.", action instanceof UndoAction);
        assertEquals("Action name should be the same.", "Undo", action.getValue(Action.NAME));
        assertFalse("isEnable should be true.", action.isEnabled());
    }

    /**
     * <p>Accuracy test for method <code>actionPerformed(event)</code>.</p>
     *  <p>Verify that the instance can be created successfully.</p>
     *
     * @throws Exception to JUnit
     */
    public void testActionPerformedAccuracy() throws Exception {
        HTMLDocumentationEditorToolBar toolBar = TestHelper.genToolBar(DEFAULT_NS);
        HTMLDocumentationEditor editor = TestHelper.genEditor(DEFAULT_NS);

        Field field = toolBar.getClass().getSuperclass().getDeclaredField("undoAction");
        field.setAccessible(true);

        UndoAction action = (UndoAction) field.get(toolBar);

        ActionEvent actionEvent = new ActionEvent(editor, 1, "Undo");

        UndoHandler handler = toolBar.new UndoHandler();

        UndoableEditEvent event = new UndoableEditEvent(editor, new MockUndoableEdit());
        handler.undoableEditHappened(event);

        action.actionPerformed(actionEvent);
    }

    /**
     * <p>Failure test for method <code>actionPerformed(event)</code>.</p>
     *  <p>Undo when it can not undo.</p>
     *
     * @throws Exception to JUnit
     */
    public void testActionPerformedFailure() throws Exception {
        HTMLDocumentationEditorToolBar toolBar = TestHelper.genToolBar(DEFAULT_NS);
        HTMLDocumentationEditor editor = TestHelper.genEditor(DEFAULT_NS);

        Field field = toolBar.getClass().getSuperclass().getDeclaredField("undoAction");
        field.setAccessible(true);

        UndoAction action = (UndoAction) field.get(toolBar);

        ActionEvent actionEvent = new ActionEvent(editor, 1, "Undo");
        action.actionPerformed(actionEvent);
    }

    /**
     * <p>Failure test for method <code>actionPerformed(event)</code>.</p>
     *  <p>Verify that the instance can be created successfully.</p>
     */
    public void testActionPerformedFailure1() {
        HTMLDocumentationEditorToolBar instance = TestHelper.genToolBar(DEFAULT_NS);
        UndoAction action = instance.new UndoAction();

        try {
            action.actionPerformed(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}
