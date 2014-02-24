/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.accuracytests.event;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.uml.classedges.TextField;
import com.topcoder.gui.diagramviewer.uml.classedges.UnitTestsHelper;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextInputTrigger;

import junit.framework.TestCase;

import java.awt.event.MouseEvent;


/**
 * <p>Test the accuracy of EditBoxTrigger class.</p>
 *
 * @author KLW
 * @version 1.0
 */
public class TextInputTriggerAccuracyTests extends TestCase {
    /** <code>EditBoxTrigger</code> instance for testing. */
    private TextInputTrigger trigger;

    /** <code>TextField</code> instance for testing. */
    private TextField textField;

    /**
     * <p>Sets up test environment.</p>
     */
    protected void setUp() {
        textField = new TextField(new GraphNode());
        trigger = new TextInputTrigger(textField);
    }

    /**
     * <p>Tears down test environment.</p>
     */
    protected void tearDown() {
        textField = null;
        trigger = null;
    }

    /**
     * <p>Accuracy test of constructor. Should create the instance successfully.</p>
     */
    public void testCtor() {
        assertNotNull("Should create the instance successfully.", trigger);
    }

    /**
     * <p>Accuracy test of method <code>mouseClicked(MouseEvent)</code>. With not left
     * mouse click <code>event</code>. Should return directly.</p>
     */
    public void testMouseClicked() {
        MouseEvent event = new MouseEvent(UnitTestsHelper.createDirectedAssociation(),
                MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON2);

        trigger.mouseClicked(event);
    }
}
