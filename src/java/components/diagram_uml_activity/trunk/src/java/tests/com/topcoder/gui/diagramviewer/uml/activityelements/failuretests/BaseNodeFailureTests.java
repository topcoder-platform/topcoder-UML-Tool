/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.failuretests;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.EllipseConnector;
import com.topcoder.uml.model.statemachines.FinalStateImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link BaseNode}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class BaseNodeFailureTests extends TestCase {
    /**
     * <p>
     * Dummy class only for testing purpose.
     * </p>
     */
    private class FailureBaseNode extends BaseNode {

        protected FailureBaseNode(GraphNode graphNode, Map<String, String> properties, Connector connector,
            Point point, Rectangle bound, Collection<SelectionCornerType> corners) {
            super(graphNode, properties, connector, point, bound, corners);
        }

        @Override
        public Dimension getPreferredGraphNodeSize() {
            return null;
        }

        @Override
        public void notifyGraphNodeChange(String message) {
        }

    }

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

        graphNode = FailureTestHelper.createGraphNodeForState(new FinalStateImpl());
    }

    /**
     * <p>
     * Failure test <code>{@link BaseNode}</code> constructor.
     * </p>
     */
    public void testBaseNodeIAE1() {
        try {
            new FailureBaseNode(null, new HashMap<String, String>(), new EllipseConnector(), new Point(),
                new Rectangle(), new ArrayList<SelectionCornerType>());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link BaseNode}</code> constructor.
     * </p>
     */
    public void testBaseNodeIAE2() {
        try {
            new FailureBaseNode(graphNode, null, new EllipseConnector(), new Point(), new Rectangle(),
                new ArrayList<SelectionCornerType>());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link BaseNode}</code> constructor.
     * </p>
     */
    public void testBaseNodeIAE3() {
        Map<String, String> map = new HashMap<String, String>();
        map.put(null, "Hello");
        try {
            new FailureBaseNode(graphNode, map, new EllipseConnector(), new Point(), new Rectangle(),
                new ArrayList<SelectionCornerType>());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link BaseNode}</code> constructor.
     * </p>
     */
    public void testBaseNodeIAE4() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", null);
        try {
            new FailureBaseNode(graphNode, map, new EllipseConnector(), new Point(), new Rectangle(),
                new ArrayList<SelectionCornerType>());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link BaseNode}</code> constructor.
     * </p>
     */
    public void testBaseNodeIAE5() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new FailureBaseNode(graphNode, map, new EllipseConnector(), new Point(), new Rectangle(),
                new ArrayList<SelectionCornerType>());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link BaseNode}</code> constructor.
     * </p>
     */
    public void testBaseNodeIAE6() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Hello", "");
        try {
            new FailureBaseNode(graphNode, map, new EllipseConnector(), new Point(), new Rectangle(),
                new ArrayList<SelectionCornerType>());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link BaseNode}</code> constructor.
     * </p>
     */
    public void testBaseNodeIAE7() {
        try {
            new FailureBaseNode(graphNode, new HashMap<String, String>(), null, new Point(), new Rectangle(),
                new ArrayList<SelectionCornerType>());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link BaseNode}</code> constructor.
     * </p>
     */
    public void testBaseNodeIAE8() {
        try {
            new FailureBaseNode(graphNode, new HashMap<String, String>(), new EllipseConnector(), null,
                new Rectangle(), new ArrayList<SelectionCornerType>());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link BaseNode}</code> constructor.
     * </p>
     */
    public void testBaseNodeIAE9() {
        try {
            new FailureBaseNode(graphNode, new HashMap<String, String>(), new EllipseConnector(), new Point(), null,
                new ArrayList<SelectionCornerType>());
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link BaseNode}</code> constructor.
     * </p>
     */
    public void testBaseNodeIAE10() {
        try {
            new FailureBaseNode(graphNode, new HashMap<String, String>(), new EllipseConnector(), new Point(),
                new Rectangle(), null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test <code>{@link BaseNode}</code> constructor.
     * </p>
     */
    public void testBaseNodeIAE11() {
        Collection<SelectionCornerType> corners = new ArrayList<SelectionCornerType>();
        corners.add(null);
        try {
            new FailureBaseNode(graphNode, new HashMap<String, String>(), new EllipseConnector(), new Point(),
                new Rectangle(), corners);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
