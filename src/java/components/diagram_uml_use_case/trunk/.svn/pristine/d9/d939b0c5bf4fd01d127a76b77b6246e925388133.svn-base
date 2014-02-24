/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;

/**
 * <p>
 * Unit test cases for EditBoxListener.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EditBoxListenerTests extends TestCase {
    /**
     * <p>
     * EditBoxListener instance for testing.
     * </p>
     */
    private EditBoxListener listener;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        listener = new EditBoxListener(new TextField(new GraphNode()));
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        listener = null;
    }

    /**
     * <p>
     * Tests EditBoxListener#EditBoxListener(TextField) for accuracy.
     * </p>
     * <p>
     * It verifies the newly created EditBoxListener instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to crate an EditBoxListener instance.", listener);
    }

    /**
     * <p>
     * Tests EditBoxListener#EditBoxListener(TextField) for failure.
     * </p>
     * <p>
     * It tests the case that when TextField is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullTextField() {
        try {
            new EditBoxListener(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests EditBoxListener#textEntered(TextInputEvent) for accuracy.
     * </p>
     * <p>
     * It verifies EditBoxListener#textEntered(TextInputEvent) is correct.
     * </p>
     */
    public void testTextEntered() {
        TextField textField = new TextField(new GraphNode());
        listener = new EditBoxListener(textField);

        // Construct a text change listener and register it to the textField
        MockTextChangeListener textChangeListener = new MockTextChangeListener();
        textField.addTextChangeListener(textChangeListener);

        /*
         * BugFix: UML-7162
         */
        // old code
//        DiagramViewer viewer = DiagramViewer.getInstance();
//        // register it to the DiagramViewer
//        viewer.addEditBoxListener(listener);
//
//        listener.onEntered(new EditBoxEvent(viewer, "new text"));
//
//        assertEquals("OnEntered behavior is wrong.", 0, viewer
//                .getListeners(com.topcoder.gui.diagramviewer.EditBoxListener.class).length);
//        assertTrue("OnEntered behavior is wrong", textChangeListener.getIsExecute());
//
//        viewer.removeEditBoxListener(listener);
//        // the code above result is based on the mock of DiagramViewer, should be fixed when the real component is ready
        TextInputBox box = new TextInputBox();
        box.addTextInputListener(listener);
        listener.textEntered(new TextInputEvent(box, "new text"));
        assertEquals("Text should be changed correctly.", textField.getText(), "new text");
    }

    /**
     * <p>
     * Tests EditBoxListener#textEntered(TextInputEvent) for accuracy.
     * </p>
     * <p>
     * It tests the case that when TextInputEvent is null and expects success.
     * </p>
     */
    public void testTextEntered_NullE() {
        TextField textField = new TextField(new GraphNode());
        listener = new EditBoxListener(textField);

        // Construct a text change listener and register it to the textField
        MockTextChangeListener textChangeListener = new MockTextChangeListener();
        textField.addTextChangeListener(textChangeListener);

        /*
         * BugFix: UML-7162
         */
        // old code
//        DiagramViewer viewer = DiagramViewer.getInstance();
//        // register it to the DiagramViewer
//        viewer.addEditBoxListener(listener);
//
//        listener.onEntered(null);
//
//        assertEquals("OnEntered behavior is wrong.", 1, viewer
//                .getListeners(com.topcoder.gui.diagramviewer.EditBoxListener.class).length);
//        assertFalse("OnEntered behavior is wrong", textChangeListener.getIsExecute());
//
//        viewer.removeEditBoxListener(listener);
//        // the code above result is based on the mock of DiagramViewer, should be fixed when the real component is ready
        textField.setText("old text");
        listener.textEntered(null);
        assertEquals("Null event should be ignored.", textField.getText(), "old text");
    }

    /**
     * <p>
     * Tests EditBoxListener#onCancelled(EditBoxEvent) for accuracy.
     * </p>
     * <p>
     * It verifies EditBoxListener#onCancelled(EditBoxEvent) is correct.
     * </p>
     */
    public void testTextCancelled() {
        TextField textField = new TextField(new GraphNode());
        listener = new EditBoxListener(textField);

        // Construct a text change listener and register it to the textField
        MockTextChangeListener textChangeListener = new MockTextChangeListener();
        textField.addTextChangeListener(textChangeListener);

        /*
         * BugFix: UML-7162
         */
        // old code
//        DiagramViewer viewer = DiagramViewer.getInstance();
//        // register it to the DiagramViewer
//        viewer.addEditBoxListener(listener);
//
//        listener.onCancelled(new EditBoxEvent(viewer, "new text"));
//
//        assertEquals("OnCancelled behavior is wrong.", 0, viewer
//                .getListeners(com.topcoder.gui.diagramviewer.EditBoxListener.class).length);
//        assertFalse("OnCancelled behavior is wrong", textChangeListener.getIsExecute());
//
//        viewer.removeEditBoxListener(listener);
//        // the code above result is based on the mock of DiagramViewer, should be fixed when the real component is ready
        textField.setText("old text");
        TextInputBox box = new TextInputBox();
        box.addTextInputListener(listener);
        listener.textCancelled(new TextInputEvent(box, "new text"));
        assertEquals("Text should not be changed.", textField.getText(), "old text");
    }

    /**
     * <p>
     * Tests EditBoxListener#onCancelled(EditBoxEvent) for accuracy.
     * </p>
     * <p>
     * It tests the case that when EditBoxEvent is null and expects success.
     * </p>
     */
    public void testTextCancelled_NullE() {
        TextField textField = new TextField(new GraphNode());
        listener = new EditBoxListener(textField);

        // Construct a text change listener and register it to the textField
        MockTextChangeListener textChangeListener = new MockTextChangeListener();
        textField.addTextChangeListener(textChangeListener);

        /*
         * BugFix: UML-7162
         */
        // old code
//        DiagramViewer viewer = DiagramViewer.getInstance();
//        // register it to the DiagramViewer
//        viewer.addEditBoxListener(listener);
//
//        listener.onCancelled(null);
//
//        assertEquals("OnCancelled behavior is wrong.", 1, viewer
//                .getListeners(com.topcoder.gui.diagramviewer.EditBoxListener.class).length);
//        assertFalse("OnCancelled behavior is wrong", textChangeListener.getIsExecute());
//
//        viewer.removeEditBoxListener(listener);
//        // the code above result is based on the mock of DiagramViewer, should be fixed when the real component is ready
        textField.setText("old text");
        listener.textCancelled(null);
        assertEquals("Text should not be changed.", textField.getText(), "old text");
    }
}
