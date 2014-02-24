/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.failuretests;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;

import junit.framework.TestCase;

/**
 * Failure tests for DiagramViewer class.
 * 
 * @author Yeung
 * @version 1.0
 */
public class ClassNodeFailureTests extends TestCase {

    /**
     * The GraphNode instance for testing.
     */
    private GraphNode graphNode;

    /**
     * The properties for testing.
     */
    private Map<String, String> properties;

    /**
     * Sets up test environment.
     * 
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        graphNode = FailureTestHelper.createClassGraphNode(new Point(50, 50), new Dimension(20, 20), false, false);
        graphNode.setContainer(new GraphNode());

        properties = FailureTestHelper.createProperties();
    }

    /**
     * Tests the constructor ClassNode(GraphNode, Map&lt;String, String&gt;) with null graphNode, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullGraphNode() throws Exception {
        try {
            new ClassNode(null, properties);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor ClassNode(GraphNode, Map&lt;String, String&gt;) with null properties, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullProperties() throws Exception {
        try {
            new ClassNode(graphNode, null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor ClassNode(GraphNode, Map&lt;String, String&gt;) with null element properties, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullElementProperties() throws Exception {
        properties.put("null", null);
        try {
            new ClassNode(graphNode, properties);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor ClassNode(GraphNode, Map&lt;String, String&gt;) with empty element properties, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_EmptyElementProperties() throws Exception {
        properties.put("empty", "");
        try {
            new ClassNode(graphNode, properties);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
