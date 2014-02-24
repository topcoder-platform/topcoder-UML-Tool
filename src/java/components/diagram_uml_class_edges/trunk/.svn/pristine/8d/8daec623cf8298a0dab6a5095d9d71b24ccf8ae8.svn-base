/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.event;

import java.awt.event.MouseEvent;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;
import com.topcoder.gui.diagramviewer.uml.classedges.UnitTestsHelper;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for <code>TextInputTrigger</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class TextInputTriggerUnitTests extends TestCase {

    /** <code>TextInputTrigger</code> instance for testing. */
    private TextInputTrigger trigger;

    /** <code>TextField</code> instance for testing. */
    private TextField textField;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        textField = new TextField(new GraphNode());
        trigger = new TextInputTrigger(textField);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        textField = null;
        trigger = null;
    }

    /**
     * <p>
     * Failure test of constructor.
     * With null <code>textField</code>.
     * Should throw IAE.
     * </p>
     */
    public void testCtor_Failure() {
        try {
            new TextInputTrigger(null);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Accuracy test of constructor.
     * Should create the instance successfully.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Should create the instance successfully.", trigger);
    }

    /**
     * <p>
     * Accuracy test of method <code>mouseClicked(MouseEvent)</code>.
     * With null <code>event</code>.
     * Should return directly.
     * </p>
     */
    public void testMouseClicked_NullEvent() {
        MouseEvent event = null;

        trigger.mouseClicked(event);
        //return directly
    }

    /**
     * <p>
     * Accuracy test of method <code>mouseClicked(MouseEvent)</code>.
     * With not left mouse click <code>event</code>.
     * Should return directly.
     * </p>
     */
    public void testMouseClicked_NotLeftClickMouseEvent() {
        MouseEvent event = new MouseEvent(UnitTestsHelper.createDirectedAssociation(),
                MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON2);

        trigger.mouseClicked(event);
        //return directly
    }

    /**
     * <p>
     * Accuracy test of method <code>mouseClicked(MouseEvent)</code>.
     * With click count is not 2.
     * Should return directly.
     * </p>
     */
    public void testMouseClicked_NotDoubleClick() {
        MouseEvent event = new MouseEvent(UnitTestsHelper.createDirectedAssociation(),
                MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON1);

        trigger.mouseClicked(event);
        //return directly
    }

}
