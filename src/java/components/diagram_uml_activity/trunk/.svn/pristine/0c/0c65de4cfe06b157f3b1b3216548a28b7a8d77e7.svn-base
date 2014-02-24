/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.accuracytests;

import java.awt.Dimension;
import java.awt.Point;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.TextField;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextInputListener;
   
/**
 * Accuracy tests for the clas: TextInputListener.
 * 
 * @author kinfkong
 * @version 1.0
 *
 */
public class TextInputListenerAccuracyTest extends AccuracyBase {

    /**
     * Represents the text input listener for accuracy tests.
     */
    private TextInputListener listener;

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

        listener = new TextInputListener(textField);
    }

    /**
     * Tests the constructor: TextInputListener.
     */
    public void testTextInputListener() {

        assertNotNull("The instance cannot be created", listener);
    }
}