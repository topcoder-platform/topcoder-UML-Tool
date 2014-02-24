/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests;

import java.awt.Graphics;

import javax.swing.DebugGraphics;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.MockGrahpics;
import com.topcoder.gui.diagramviewer.gridrenderers.SimpleGridRenderer;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test cases for <c>SimpleGridRenderer</c>.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class SimpleGridRendererAccuracyTests extends TestCase {

    /**
     * SimpleGridRenderer instance for testing.
     */
    private SimpleGridRenderer sgr;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        sgr = new SimpleGridRenderer(10);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: renderGrid(Graphics graphics,
     * DiagramView diagramView).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testRenderGrid() throws Exception {
        AccuracyTestsHelper.loadConfig(AccuracyTestsHelper.DefaultConfig);

        Graphics graphics = new MockGrahpics();
        DiagramViewer viewer = new DiagramViewer();
        Diagram diagram = new Diagram();
        diagram.setName("Mock Diagram");
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);
        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        Diagram diagram2 = new Diagram();
        diagram2.setName("Test");
        diagram2.setSize(dimension);
        diagram2.setPosition(point);
        diagram.setContainer(diagram2);
        DiagramView view = viewer.openDiagramView(diagram);

        this.sgr.renderGrid(graphics, view);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getGridSize().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetGridSize() throws Exception {
        assertEquals("Fail to get gridSize.", 10, sgr.getGridSize());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setGridSize(int gridSize).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetGridSize() throws Exception {
        assertEquals("Fail to get gridSize.", 10, sgr.getGridSize());
        sgr.setGridSize(1000);
        assertEquals("Fail to get gridSize.", 1000, sgr.getGridSize());
        sgr.setGridSize(956321);
        assertEquals("Fail to get gridSize.", 956321, sgr.getGridSize());
    }
}
