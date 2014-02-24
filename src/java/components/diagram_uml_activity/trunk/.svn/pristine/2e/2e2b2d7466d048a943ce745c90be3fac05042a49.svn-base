/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.accuracytests;

import java.awt.Dimension;
import java.awt.Point;
import java.lang.reflect.Method;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.TextField;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedListener;

/**
 * Accuracy tests for the class: TextField.
 * 
 * @author kinfkong
 * @version 1.0
 *
 */
public class TextFieldAccuracyTest extends AccuracyBase {

    /**
     * Represents the text field.
     */
    private TextField textField;

    /**
     * Represents the graph node.
     */
    private GraphNode graphNode;

    /**
     * Sets up the test environment.
     */
    protected void setUp() {

        graphNode = createGraphNode("ObjectFlowNode", new Point(5, 5), new Dimension(50, 50),
                        "FFFFFF");

        textField = new TextField(graphNode);
    }

    /**
     * Tests the constructor: TextField
     *
     */
    public void testTextField() {

        assertNotNull("The instance cannot be created.", textField);
    }
    
    /**
     * Tests the method: addTextChangedListener.
     *
     */
    public void testAddTextChangedListener() {

        TextChangedListener listener = new DummyTextChangedListener();

        textField.addTextChangedListener(listener);
        TextChangedListener[] listeners = textField.getListeners(TextChangedListener.class);

        assertTrue("The method does not work properly.",
                        containsIt(listeners, DummyTextChangedListener.class));
    }

    /**
     * Tests the method: removeBoundaryChangedListener.
     *
     */
    public void testRemoveBoundaryChangedListener() {

        TextChangedListener listener = new DummyTextChangedListener();

        textField.addTextChangedListener(listener);
        textField.removeTextChangedListener(listener);

        TextChangedListener[] listeners = textField.getListeners(TextChangedListener.class);

        assertFalse("The method does not work properly.",
                        containsIt(listeners, DummyTextChangedListener.class));
    }

    /**
     * Tests the method: fireTextChanged.
     * 
     * @throws Exception to JUnit
     */
    public void testFireTextChanged() throws Exception {

        TextChangedListener listener = new DummyTextChangedListener();
        textField.addTextChangedListener(listener);

        TextChangedEvent testEvent = new TextChangedEvent(textField, "oldValue", "newValue");

        Method method = textField.getClass().getDeclaredMethod("fireTextChange", new Class[] {TextChangedEvent.class});
        method.setAccessible(true);
        method.invoke(textField, new Object[] {testEvent});

        assertTrue("The boolean value isTextChanged of MockTextChangedListener should be set to true..",
                        ((DummyTextChangedListener) listener).isChanged());
    }

    /**
     * Checks if the array contains a specified type of listener.
     * 
     * @param listeners the array of listeners
     * @param listenerType the listener type
     * @return true if it contains, false otherwise.
     */
    private static boolean containsIt(TextChangedListener[] listeners, Class listenerType) {

        for (int i = 0; i < listeners.length; i++) {

            if (listenerType.isInstance(listeners[i])) {
                return true;
            }
        }
        return false;
    }
}