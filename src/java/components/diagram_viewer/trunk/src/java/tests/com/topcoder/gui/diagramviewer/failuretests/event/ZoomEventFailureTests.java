/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.failuretests.event;

import java.util.Iterator;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.event.ZoomEvent;
import com.topcoder.gui.panels.zoom.ZoomPanel;
import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * Failure tests for ZoomEvent class.
 *
 * @author Yeung
 * @version 1.0
 */
public class ZoomEventFailureTests extends TestCase {
    /**
     * This instance is used in the test.
     */
    private ZoomPanel zoomPanel;

    /**
     * Sets up the test environment.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    protected void setUp() throws Exception {
		tearDown();
        ConfigManager cm = ConfigManager.getInstance();
        cm.add("failure/config.xml");

        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);

        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);

        zoomPanel = new ZoomPanel(new DiagramViewer().createDiagramView(diagram));
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
     * Tests the constructor ZoomEvent(ZoomPanel, double) with null source, expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullSource() throws Exception {
        try {
            new ZoomEvent(null, 10);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor ZoomEvent(ZoomPanel, double) with zero newZoomFactor, expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_ZeroNewZoomFactor() throws Exception {
        try {
            new ZoomEvent(zoomPanel, 0);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor ZoomEvent(ZoomPanel, double) with negative newZoomFactor, expected
     * IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NegativeNewZoomFactor() throws Exception {
        try {
            new ZoomEvent(zoomPanel, -1);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}
