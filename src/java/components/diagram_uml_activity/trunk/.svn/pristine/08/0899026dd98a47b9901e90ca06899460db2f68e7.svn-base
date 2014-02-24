/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.accuracytests;

import java.awt.Dimension;
import java.awt.Point;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.TextField;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedEvent;

/**
 * Accuracy tests for the class TextChangedEvent.
 * 
 * @author kinfkong
 * @version 1.0
 *
 */
public class TextChangedEventAccuracyTest extends AccuracyBase {

    /**
     * Represents the event.
     */
    private TextChangedEvent event;

    /**
     * Represents the graph node.
     */
    private GraphNode graphNode;

    /**
     * Represents the text field.
     */
    private TextField textField;

    /**
     * Sets up the test environment.
     */
    protected void setUp() {

        graphNode = createGraphNode("ObjectFlowNode", new Point(5, 5), new Dimension(50, 50),
                        "FFFFFF");

        textField = new TextField(graphNode);

        event = new TextChangedEvent(textField, "oldValue", "newValue");
    }

    /**
     * Tests the constructor: TextChangedEvent.
     *
     */
    public void testTextChangedEvent() {

        assertNotNull("The instance cannot be created.", event);
    }

    /**
     * Tests the method: getOldValue.
     *
     */
    public void testGetOldValue() {

        assertEquals("The method does not work properly.", event.getOldValue(), "oldValue");
    }

    /**
     * Tests the method: getNewValue.
     *
     */
    public void testGetNewValue() {

        assertEquals("The method does not work properly.", event.getNewValue(), "newValue");
    }
}