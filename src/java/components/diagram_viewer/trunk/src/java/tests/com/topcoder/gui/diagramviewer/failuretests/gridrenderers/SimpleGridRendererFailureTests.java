/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.failuretests.gridrenderers;

import java.util.Iterator;

import javax.swing.DebugGraphics;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.gridrenderers.SimpleGridRenderer;
import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * Failure tests for SimpleGridRenderer class.
 *
 * @author Yeung
 * @version 1.0
 */
public class SimpleGridRendererFailureTests extends TestCase {

    /**
     * This instance is used in the test.
     */
    private SimpleGridRenderer renderer;

    /**
     * This instance is used in the test.
     */
    private DiagramViewer viewer;

    /**
     * This instance is used in the test.
     */
    private DiagramView view;

    /**
     * Sets up the test environment.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    protected void setUp() throws Exception {
		tearDown();
        // get the config manager
        ConfigManager cm = ConfigManager.getInstance();
        cm.add("failure/config.xml");

        viewer = new DiagramViewer();
        renderer = new SimpleGridRenderer(2);
        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);

        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        view = viewer.createDiagramView(diagram);
    }

    /**
     * Tears down the test environment.
     *
     * @throws Exception
     *             if any error occurred when tear down
     */
    protected void tearDown() throws Exception {
        ConfigManager manager = ConfigManager.getInstance();
        for (Iterator iter = manager.getAllNamespaces(); iter.hasNext();) {
            manager.removeNamespace((String) iter.next());
        }
    }

    /**
     * Tests the method renderGrid(Graphics, DiagramView) with null graphics, expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testRenderGrid_NullGraphics() throws Exception {
        try {
            renderer.renderGrid(null, view);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method renderGrid(Graphics, DiagramView) with null diagramView, expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testRenderGrid_NullDiagramView() throws Exception {
        try {
            renderer.renderGrid(new DebugGraphics(), null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method setGridSize(int) with zero gridSize, expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testSetGridSize_ZeroGridSize() throws Exception {
        try {
            renderer.setGridSize(0);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method setGridSize(int) with negative gridSize, expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testSetGridSize_NegativeGridSize() throws Exception {
        try {
            renderer.setGridSize(-1);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}
