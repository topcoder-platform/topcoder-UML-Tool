package com.topcoder.gui.diagramviewer.uml.classelements.failuretests.event;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.failuretests.FailureTestHelper;

/**
 * Failure tests for BoundaryChangedEvent class.
 * 
 * @author Yeung
 * @version 1.0
 */
public class BoundaryChangedEventFailureTests extends TestCase {
    /**
     * Old boundary of BoundaryChangedEvent for testing.
     */
    private Rectangle oldBoundary;

    /**
     * New boundary of BoundaryChangedEvent for testing.
     */
    private Rectangle newBoundary;

    /**
     * An instance of ClassNode for testing.
     */
    private ClassNode classNode;

    /**
     * Sets up test environment.
     * 
     * @throws Exception
     *             to junit
     */
    public void setUp() throws Exception {
        super.setUp();
        oldBoundary = new Rectangle(0, 0, 20, 10);
        newBoundary = new Rectangle(10, 10, 30, 20);

        GraphNode graphNode = FailureTestHelper.createClassGraphNode(new Point(50, 50), new Dimension(20, 20), false,
                false);
        graphNode.setContainer(new GraphNode());

        Map<String, String> properties = FailureTestHelper.createProperties();

        classNode = new ClassNode(graphNode, properties);
    }

    /**
     * Tests the constructor BoundaryChangedEvent(Node, Rectangle, Rectangle) with null node, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullNode() throws Exception {
        try {
            new BoundaryChangedEvent(null, oldBoundary, newBoundary);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor BoundaryChangedEvent(Node, Rectangle, Rectangle) with null oldBoundary, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullOldBoundary() throws Exception {
        try {
            new BoundaryChangedEvent(classNode, null, newBoundary);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor BoundaryChangedEvent(Node, Rectangle, Rectangle) with null newBoundary, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullNewBoundary() throws Exception {
        try {
            new BoundaryChangedEvent(classNode, oldBoundary, null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor BoundaryChangedEvent(Node, Rectangle, Rectangle, String) with null node, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullNode2() throws Exception {
        try {
            new BoundaryChangedEvent(null, oldBoundary, newBoundary, null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor BoundaryChangedEvent(Node, Rectangle, Rectangle, String) with null oldBoundary, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullOldBoundary2() throws Exception {
        try {
            new BoundaryChangedEvent(classNode, null, newBoundary, null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor BoundaryChangedEvent(Node, Rectangle, Rectangle, String) with null newBoundary, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullNewBoundary2() throws Exception {
        try {
            new BoundaryChangedEvent(classNode, oldBoundary, null, null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

}
