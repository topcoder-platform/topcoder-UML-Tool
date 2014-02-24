/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * UndoHandlerTest.java
 */
package com.topcoder.gui.panels.documentation.plugins.html;

import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditorToolBar.UndoHandler;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.lang.reflect.Field;

import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.UndoManager;


/**
 * <p>Unit tests for <code>UndoHandler</code> class.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UndoHandlerTest extends TestCase {
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
        return new TestSuite(UndoHandlerTest.class);
    }

    /**
     * <p>Accuracy test for constructor <code>UndoHandler()</code>.</p>
     *  <p>Verify that the instance can be created successfully.</p>
     */
    public void testCtorAccuracy() {
        HTMLDocumentationEditorToolBar toolBar = TestHelper.genToolBar(DEFAULT_NS);
        UndoHandler handler = toolBar.new UndoHandler();
        assertNotNull("Unable to create UndoHandler instance.", handler);
        assertTrue("Should be instance of UndoHandler.", handler instanceof UndoHandler);
    }

    /**
     * <p>Accuracy test for method <code>undoableEditHappened(event)</code>.</p>
     *  <p>Verify that can handle event correctly.</p>
     *
     * @throws Exception to JUnit
     */
    public void testUndoableEditHappenedAccuracy() throws Exception {
        HTMLDocumentationEditorToolBar toolBar = TestHelper.genToolBar(DEFAULT_NS);
        HTMLDocumentationEditor editor = TestHelper.genEditor(DEFAULT_NS);

        Field field = toolBar.getClass().getSuperclass().getDeclaredField("undoManager");
        field.setAccessible(true);

        UndoManager manager = (UndoManager) field.get(toolBar);
        assertFalse("manager can not undo.", manager.canUndo());

        UndoHandler handler = toolBar.new UndoHandler();

        UndoableEditEvent event = new UndoableEditEvent(editor, new MockUndoableEdit());
        handler.undoableEditHappened(event);
        assertTrue("manager can not undo.", manager.canUndo());
    }

    /**
     * <p>Failure test for method <code>undoableEditHappened(event)</code>.</p>
     *  <p>Event is null, IAE should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testUndoableEditHappenedFailure() throws Exception {
        HTMLDocumentationEditorToolBar toolBar = TestHelper.genToolBar(DEFAULT_NS);

        UndoHandler handler = toolBar.new UndoHandler();

        try {
            handler.undoableEditHappened(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}
