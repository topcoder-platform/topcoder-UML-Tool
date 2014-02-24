/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.event;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.TestUtil;

/**
 * <p>
 * Test the functionality of <code>NodeAddEvent</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class NodeAddEventTest extends TestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 40);

    /** An instance of <code>NodeAddEvent</code> for testing. */
    private NodeAddEvent event;

    /** Location of <code>NodeAddEvent</code>. */
    private Point location = new Point(10, 20);

    /** An instance of <code>ClassNode</code> for testing. */
    private ClassNode classNode;

    /** A GraphNode for <code>ClassNode</code>. */
    private GraphNode graphNode;

    /** Properties for testing. */
    private Map<String, String> properties;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        graphNode = TestUtil.createClassGraphNode(POSITION, SIZE, false, false);
        graphNode.setContainer(new GraphNode());

        properties = TestUtil.createProperties();

        classNode = new ClassNode(graphNode, properties);

        event = new NodeAddEvent(classNode, location);
    }

    /**
     * Test method for 'NodeAddEvent(Node, Point, boolean)'. The instance should be created successfully.
     */
    public void testNodeAddEvent_Accuracy() {
        assertNotNull("Test method for 'NodeAddEvent(Node, Point, boolean)' failed.", event);
    }

    /**
     * Test method for 'NodeAddEvent(Node, Point, boolean)'. The source is null, IllegalArgumentException should be
     * thrown.
     */
    public void testNodeAddEvent_null_1() {
        try {
            new NodeAddEvent(null, location);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'NodeAddEvent(Node, Point, boolean)'. The location is null, IllegalArgumentException should be
     * thrown.
     */
    public void testNodeAddEvent_null_2() {
        try {
            new NodeAddEvent(classNode, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'NodeAddEvent.getLocation()', location should be got correctly.
     */
    public void testGetLocation() {
        assertEquals("location should be got correctly.", event.getLocation(), location);
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        event = null;

        location = null;

        graphNode = null;

        properties = null;

        classNode = null;
    }
}
