/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.failuretests;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.AcceptEventAction;
import com.topcoder.gui.diagramviewer.uml.activityelements.IllegalGraphElementException;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link AcceptEventAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class AcceptEventActionFailureTests extends TestCase {

    /**
     * <p>
     * Represents the GraphNode instance.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        graphNode = FailureTestHelper.createGraphNodeForAction(new SimpleStateImpl());
    }

    /**
     * <p>
     * Failure test
     * <code>{@link AcceptEventAction#AcceptEventAction(GraphNode, Map, Point, Rectangle, Collection)}</code>
     * constructor.
     * </p>
     */
    public void testAcceptEventActionIAE1() {
        try {
            new AcceptEventAction(null, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test
     * <code>{@link AcceptEventAction#AcceptEventAction(GraphNode, Map, Point, Rectangle, Collection)}</code>
     * constructor.
     * </p>
     */
    public void testAcceptEventActionIAE2() {
        try {
            new AcceptEventAction(graphNode, null, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test
     * <code>{@link AcceptEventAction#AcceptEventAction(GraphNode, Map, Point, Rectangle, Collection)}</code>
     * constructor.
     * </p>
     */
    public void testAcceptEventActionIAE3() {
        Map<String, String> map = new HashMap<String, String>();
        map.put(null, "Hello");
        try {
            new AcceptEventAction(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test
     * <code>{@link AcceptEventAction#AcceptEventAction(GraphNode, Map, Point, Rectangle, Collection)}</code>
     * constructor.
     * </p>
     */
    public void testAcceptEventActionIAE4() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", null);
        try {
            new AcceptEventAction(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test
     * <code>{@link AcceptEventAction#AcceptEventAction(GraphNode, Map, Point, Rectangle, Collection)}</code>
     * constructor.
     * </p>
     */
    public void testAcceptEventActionIAE5() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new AcceptEventAction(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test
     * <code>{@link AcceptEventAction#AcceptEventAction(GraphNode, Map, Point, Rectangle, Collection)}</code>
     * constructor.
     * </p>
     */
    public void testAcceptEventActionIAE6() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new AcceptEventAction(graphNode, map, new Point(), new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test
     * <code>{@link AcceptEventAction#AcceptEventAction(GraphNode, Map, Point, Rectangle, Collection)}</code>
     * constructor.
     * </p>
     */
    public void testAcceptEventActionIAE8() {
        try {
            new AcceptEventAction(graphNode, new HashMap<String, String>(), null, new Rectangle());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test
     * <code>{@link AcceptEventAction#AcceptEventAction(GraphNode, Map, Point, Rectangle, Collection)}</code>
     * constructor.
     * </p>
     */
    public void testAcceptEventActionIAE9() {
        try {
            new AcceptEventAction(graphNode, new HashMap<String, String>(), new Point(), null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test
     * <code>{@link AcceptEventAction#AcceptEventAction(GraphNode, Map, Point, Rectangle, Collection)}</code>
     * constructor.
     * </p>
     */
    public void testAcceptEventActionIllegalGraphElementException1() {
        graphNode.clearContaineds();
        try {
            new AcceptEventAction(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test
     * <code>{@link AcceptEventAction#AcceptEventAction(GraphNode, Map, Point, Rectangle, Collection)}</code>
     * constructor.
     * </p>
     */
    public void testAcceptEventActionIllegalGraphElementException2() {
        graphNode.removeContained(0);
        try {
            new AcceptEventAction(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test
     * <code>{@link AcceptEventAction#AcceptEventAction(GraphNode, Map, Point, Rectangle, Collection)}</code>
     * constructor.
     * </p>
     */
    public void testAcceptEventActionIllegalGraphElementException3() {
        graphNode.addContained(new GraphNode());
        try {
            new AcceptEventAction(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test
     * <code>{@link AcceptEventAction#AcceptEventAction(GraphNode, Map, Point, Rectangle, Collection)}</code>
     * constructor.
     * </p>
     */
    public void testAcceptEventActionIllegalGraphElementException4() {
        graphNode.addContained(0, new GraphEdge());
        try {
            new AcceptEventAction(graphNode, new HashMap<String, String>(), new Point(), new Rectangle());
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }
}
