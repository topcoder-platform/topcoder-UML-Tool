/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.event;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JButton;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.GroupTextField;
import com.topcoder.gui.diagramviewer.uml.classelements.TestUtil;

/**
 * <p>
 * Test the functionality of <code>PopupGroupFieldTrigger</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PopupGroupFieldTriggerTest extends TestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 40);

    /** An instance of <code>ClassNode</code> for testing. */
    private ClassNode classNode;

    /** An instance of <code>PopupGroupFieldTrigger</code> for testing. */
    private PopupGroupFieldTrigger trigger;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        GraphNode graphNode = TestUtil.createClassGraphNode(POSITION, SIZE, false, false);
        graphNode.setContainer(new GraphNode());

        Map<String, String> properties = TestUtil.createProperties();

        classNode = new ClassNode(graphNode, properties);

        trigger = new PopupGroupFieldTrigger();

        classNode.getAttributesCompartment().addMouseListener(trigger);
    }

    /**
     * Test method for 'PopupGroupFieldTrigger()'. The instance should be created successfully.
     */
    public void testPopupGroupFieldTrigger() {
        assertNotNull("Test method for 'PopupGroupFieldTrigger()' failed.", trigger);
    }

    /**
     * Test method for 'mouseClicked(MouseEvent)'. The argument is null, should be ignored.
     */
    public void testMouseClicked_null() {
        trigger.mouseClicked(null);
    }

    /**
     * Test method for 'mouseClicked(MouseEvent)'. Left button event, should be ignored.
     */
    public void testMouseClicked_WrongButton() {
        MouseEvent event = new MouseEvent(classNode, MouseEvent.MOUSE_CLICKED, 1000, MouseEvent.ALT_DOWN_MASK, 0, 0, 1,
                true, MouseEvent.BUTTON2);
        trigger.mouseClicked(event);
    }

    /**
     * Test method for 'mouseClicked(MouseEvent)'. Event source is not correct Node, should be ignored.
     */
    public void testMouseClicked_WrongSource() {
        MouseEvent event = new MouseEvent(new JButton(), MouseEvent.MOUSE_CLICKED, 1000, MouseEvent.ALT_DOWN_MASK, 0,
                0, 1, true, MouseEvent.BUTTON3);
        trigger.mouseClicked(event);
    }

    /**
     * Test method for 'mouseClicked(MouseEvent)'. Mouse is right clicked, should be processed correctly.
     */
    public void testMouseRightClicked() {
        GroupTextField attributes = classNode.getAttributesCompartment();
        MouseEvent event = new MouseEvent(attributes, MouseEvent.MOUSE_CLICKED, 1000, MouseEvent.ALT_DOWN_MASK, 0, 0,
                1, true, MouseEvent.BUTTON3);
        trigger.mouseClicked(event);
    }

    /**
     * Test method for 'mouseClicked(MouseEvent)'. Mouse is left clicked, should be processed correctly.
     */
    public void testMouseLeftClicked() {
        GroupTextField attributes = classNode.getAttributesCompartment();
        MouseEvent event = new MouseEvent(attributes, MouseEvent.MOUSE_CLICKED, 1000, MouseEvent.ALT_DOWN_MASK, 0, 0,
                1, false, MouseEvent.BUTTON1);
        trigger.mouseClicked(event);
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        trigger = null;

        classNode = null;
    }
}
