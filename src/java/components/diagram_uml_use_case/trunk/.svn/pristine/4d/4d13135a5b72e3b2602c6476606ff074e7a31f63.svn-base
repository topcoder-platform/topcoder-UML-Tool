/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * BoundaryChangedEventFailureTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.failuretests;

import junit.framework.TestCase;

import java.util.HashMap;
import java.awt.Rectangle;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TestHelper;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedEvent;
import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * This is a failure tests for <code>BoundaryChangedEvent</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class BoundaryChangedEventFailureTest extends TestCase {

    /**Message.*/
    private static final String MESSAGE = "message";

    /**Node instance that is used for testing.*/
    private Node node;

    /**OldBoundary value that is used for testing.*/
    private Rectangle oldBoundary;

    /**NewBoundary value that is used for testing.*/
    private Rectangle newBoundary;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        oldBoundary = new Rectangle();
        newBoundary = new Rectangle();
        GraphNode graphNode = TestHelper.createGraphNodeForUseCase();
        node = new UseCaseNode(graphNode, new HashMap<String, String>());
    }

    /**
     * <p>
     * Tests constructor BoundaryChangedEvent(node, oldBound, newBound) if node is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1IfNodeNull() {
        try {
            new BoundaryChangedEvent(null, oldBoundary, newBoundary);
            fail("IllegalArgumentException is expected because node cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor BoundaryChangedEvent(node, oldBound, newBound) if oldBound is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1IfOldBoundNull() {
        try {
            new BoundaryChangedEvent(node, null, newBoundary);
            fail("IllegalArgumentException is expected because oldBound cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor BoundaryChangedEvent(node, oldBound, newBound) if newBound is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1IfNewBoundNull() {
        try {
            new BoundaryChangedEvent(node, oldBoundary, null);
            fail("IllegalArgumentException is expected because newBound cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor BoundaryChangedEvent(node, oldBound, newBound, message) if node is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2IfNodeNull() {
        try {
            new BoundaryChangedEvent(null, oldBoundary, newBoundary, MESSAGE);
            fail("IllegalArgumentException is expected because node cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor BoundaryChangedEvent(node, oldBound, newBound, message) if oldBound is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2IfOldBoundNull() {
        try {
            new BoundaryChangedEvent(node, null, newBoundary, MESSAGE);
            fail("IllegalArgumentException is expected because oldBound cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor BoundaryChangedEvent(node, oldBound, newBound. message) if newBound is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2IfNewBoundNull() {
        try {
            new BoundaryChangedEvent(node, oldBoundary, null, MESSAGE);
            fail("IllegalArgumentException is expected because newBound cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}