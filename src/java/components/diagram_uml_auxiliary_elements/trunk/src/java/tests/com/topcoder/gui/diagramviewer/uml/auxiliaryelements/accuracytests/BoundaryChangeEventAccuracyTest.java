/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import java.awt.Rectangle;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BoundaryChangeEvent;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;

/**
 * <p>
 * Accuracy test of <code>BoundaryChangeEvent</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class BoundaryChangeEventAccuracyTest extends TestCase {

    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private Rectangle oldBoundary;

    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private Rectangle newBoundary;

    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private String message;

    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private Node node;

    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private BoundaryChangeEvent boundaryChangeEvent;

    /**
     * <p>
     * The DiagramViewer instance for helping testing.
     * </p>
     */
    private DiagramViewer viewer;

    /**
     * <p>
     * The DiagramView instance for helping testing.
     * </p>
     */
    private DiagramView view;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        ConfigHelper.loadXMLConfigrationFile(ConfigHelper.ACC_CONFIG_FILE);

        // old boundary
        oldBoundary = new Rectangle(0, 0, 100, 100);
        // new boundary
        newBoundary = new Rectangle(100, 100, 50, 50);
        // event node
        node = new PolylineNode(new Polyline(), new PropertyMapping());
        // message
        message = "boundary changed";
        // create BoundaryChangeEvent
        boundaryChangeEvent = new BoundaryChangeEvent(node, oldBoundary, newBoundary, message);
        viewer = new DiagramViewer();
        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        diagram.setSize(dimension);
        view = viewer.createDiagramView(diagram);
        view.add(node);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        ConfigHelper.clearConfigration();

        // old boundary
        oldBoundary = null;
        // new boundary
        newBoundary = null;
        // event node
        node = null;
        // message
        message = null;
        // boundaryChangeEvent
        boundaryChangeEvent = null;
        viewer = null;
        view = null;
    }

    /**
     * <p>
     * Tests accuracy of <code>getOldBoundary()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetOldBoundaryAccuracy() throws Exception {
        assertEquals("value should be getted correctly", oldBoundary, boundaryChangeEvent.getOldBoundary());
    }

    /**
     * <p>
     * Tests accuracy of <code>getNewBoundary()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetNewBoundaryAccuracy() throws Exception {
        assertEquals("value should be getted correctly", newBoundary, boundaryChangeEvent.getNewBoundary());
    }

    /**
     * <p>
     * Tests accuracy of getMessage()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetMessageAccuracy() throws Exception {
        assertEquals("value should be getted correctly", message, boundaryChangeEvent.getMessage());
    }
}
