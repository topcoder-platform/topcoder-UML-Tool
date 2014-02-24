/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.failuretests.event;

import java.awt.Rectangle;
import java.util.Iterator;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.event.SelectionEvent;
import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * Failure tests for SelectionEvent class.
 *
 * @author Yeung
 * @version 1.0
 */
public class SelectionEventFailureTests extends TestCase {
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
     * Tests the constructor SelectionEvent(DiagramView, Rectangle) with null source, expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullSource() throws Exception {
        try {
            new SelectionEvent(null, new Rectangle());
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor SelectionEvent(DiagramView, Rectangle) with null rectangle, expected
     * IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullRectangle() throws Exception {
        try {
            new SelectionEvent(view, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}