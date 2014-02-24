/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.event.ZoomTrigger;

/**
 * <p>
 * Unit test cases for ZoomTrigger.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ZoomTriggerUnitTests extends TestCase {

    /**
     * ZoomTrigger instance for testing.
     */
    private ZoomTrigger zt;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        // loads the valid configuration
        UnitTestsHelper.loadConfig("config.xml");
        zt = new ZoomTrigger();
    }

    /**
     * <p>
     * This is the accuracy test for constructor: ZoomTrigger(). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1() throws Exception {
        assertNotNull("Failed to create ZoomTrigger instance.", zt);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: mouseWheelMoved(MouseWheelEvent
     * event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testMouseWheelMovedAccuracy1() throws Exception {
        UnitTestsHelper.loadConfig("config.xml");
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
        viewer.openDiagramView(diagram);
        for (int i = 0; i < 10; i++) {
            viewer.addZoomListener(new MockZoomHander());
        }
        MouseWheelEvent event = new MouseWheelEvent(viewer, 0, 0, KeyEvent.CTRL_DOWN_MASK, 0, 0, 0, true, 0, 0, 10);
        try {
            zt.mouseWheelMoved(event);
        } catch (IllegalArgumentException e) {
            // good.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: mouseWheelMoved(MouseWheelEvent
     * event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testMouseWheelMovedAccuracy2() throws Exception {
        UnitTestsHelper.loadConfig("config.xml");
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
        viewer.openDiagramView(diagram);
        for (int i = 0; i < 10; i++) {
            viewer.addZoomListener(new MockZoomHander());
        }
        MouseWheelEvent event = new MouseWheelEvent(viewer, 0, 0, KeyEvent.CTRL_DOWN_MASK, 0, 0, 0, true, 0, 0, -10);
        zt.mouseWheelMoved(event);
    }
}
