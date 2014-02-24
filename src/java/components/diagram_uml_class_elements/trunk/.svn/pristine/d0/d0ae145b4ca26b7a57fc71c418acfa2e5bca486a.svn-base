/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.event;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.TestUtil;

/**
 * <p>
 * Test the functionality of <code>BoundaryChangedEvent</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class BoundaryChangedEventTest extends TestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 40);

    /** An instance of <code>BoundaryChangedEvent</code> for testing. */
    private BoundaryChangedEvent event;

    /** Message of <code>BoundaryChangedEvent</code>. */
    private String message = "test message";

    /** Old boundary of <code>BoundaryChangedEvent</code>. */
    private Rectangle oldBoundary;

    /** New boundary of <code>BoundaryChangedEvent</code>. */
    private Rectangle newBoundary;

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
        oldBoundary = new Rectangle(0, 0, 20, 10);
        newBoundary = new Rectangle(10, 10, 30, 20);

        graphNode = TestUtil.createClassGraphNode(POSITION, SIZE, false, false);
        graphNode.setContainer(new GraphNode());

        properties = TestUtil.createProperties();

        classNode = new ClassNode(graphNode, properties);

        event = new BoundaryChangedEvent(classNode, oldBoundary, newBoundary, message);
    }

    /**
     * Test method for 'BoundaryChangedEvent(Node, Rectangle, Rectangle)'. The instance should be created successfully.
     */
    public void testBoundaryChangedEvent_1_Accuracy() {
        assertNotNull("Test method for 'BoundaryChangedEvent(BaseNode, Rectangle, Rectangle)' failed.",
                new BoundaryChangedEvent(classNode, oldBoundary, newBoundary));
    }

    /**
     * Test method for 'BoundaryChangedEvent(Node, Rectangle, Rectangle, String)'. The instance should be created
     * successfully.
     */
    public void testBoundaryChangedEvent_2_Accuracy() {
        assertNotNull("Test method for 'BoundaryChangedEvent(BaseNode, Rectangle, Rectangle, String)' failed.", event);
    }

    /**
     * Test method for 'BoundaryChangedEvent(Node, Rectangle, Rectangle)'. The source is null, IllegalArgumentException
     * should be thrown.
     */
    public void testBoundaryChangedEvent_1_null_1() {
        try {
            new BoundaryChangedEvent(null, oldBoundary, newBoundary);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'BoundaryChangedEvent(Node, Rectangle, Rectangle)'. The old boundary is null,
     * IllegalArgumentException should be thrown.
     */
    public void testBoundaryChangedEvent_1_null_2() {
        try {
            new BoundaryChangedEvent(classNode, null, newBoundary);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'BoundaryChangedEvent(Node, Rectangle, Rectangle)'. The new boundary is null,
     * IllegalArgumentException should be thrown.
     */
    public void testBoundaryChangedEvent_1_null_3() {
        try {
            new BoundaryChangedEvent(classNode, oldBoundary, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'BoundaryChangedEvent(Node, Rectangle, Rectangle, String)'. The source is null,
     * IllegalArgumentException should be thrown.
     */
    public void testBoundaryChangedEvent_2_null_1() {
        try {
            new BoundaryChangedEvent(null, oldBoundary, newBoundary, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'BoundaryChangedEvent(Node, Rectangle, Rectangle, String)'. The old boundary is null,
     * IllegalArgumentException should be thrown.
     */
    public void testBoundaryChangedEvent_2_null_2() {
        try {
            new BoundaryChangedEvent(classNode, null, newBoundary, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'BoundaryChangedEvent(Node, Rectangle, Rectangle, String)'. The new boundary is null,
     * IllegalArgumentException should be thrown.
     */
    public void testBoundaryChangedEvent_2_null_3() {
        try {
            new BoundaryChangedEvent(classNode, oldBoundary, null, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'getMessage()', message should be got correctly.
     */
    public void testGetMessage() {
        assertEquals("Message should be got correctly.", event.getMessage(), message);
    }

    /**
     * Test method for 'getOldBoundary()', old boundary should be got correctly.
     */
    public void testGetOldBoundary() {
        assertEquals("Old boundary should be got correctly.", event.getOldBoundary(), oldBoundary);
    }

    /**
     * Test method for 'getNewBoundary()', new boundary should be got correctly.
     */
    public void testGetNewBoundary() {
        assertEquals("New boundary should be got correctly.", event.getNewBoundary(), newBoundary);
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        event = null;

        message = null;

        oldBoundary = null;

        newBoundary = null;

        graphNode = null;

        properties = null;

        classNode = null;
    }
}
