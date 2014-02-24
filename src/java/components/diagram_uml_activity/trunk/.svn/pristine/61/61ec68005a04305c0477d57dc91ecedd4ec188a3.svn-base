/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.accuracytests;

import java.awt.Dimension;
import java.awt.Point;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.TextField;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextInputTrigger;

/**
 * Accuracy tests for the class: TextInputTrigger.
 * 
 * @author kinfkong
 * @version 1.0
 *
 */
public class TextInputTriggerAccuracyTest extends AccuracyBase {

    /**
     * Represents the text input trigger.
     */
    private TextInputTrigger trigger;

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

        trigger = new TextInputTrigger(textField);
    }

    /**
     * Tests the constructor: TextInputTrigger.
     *
     */
    public void testTextInputTrigger() {

        assertNotNull("Failed to instantiate TextInputTrigger.", trigger);
    }

}