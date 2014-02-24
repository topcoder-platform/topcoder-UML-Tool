/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.event.AdjustmentEvent;

import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.event.ScrollTrigger;
import com.topcoder.gui.panels.zoom.ZoomPanel;

/**
 * <p>
 * Unit test cases for ScrollTrigger.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ScrollTriggerUnitTests extends TestCase {

    /**
     * AdjustmentEvent event for testing.
     */
    private AdjustmentEvent event;

    /**
     * ScrollTrigger instance for testing.
     */
    private ScrollTrigger st;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        st = new ScrollTrigger();
    }

    /**
     * <p>
     * This is the accuracy test for constructor: ScrollTrigger(). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor() throws Exception {
        assertNotNull("Failed to create ScrollTrigger instance.", st);
    }

    /**
     * <p>
     * This is the Accuracy test for Method:
     * adjustmentValueChanged(AdjustmentEvent event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testAdjustmentValueChangedAccuracy() throws Exception {
        UnitTestsHelper.loadConfig("config.xml");
        // old code
//        JScrollBar bar = new JScrollBar();
//        ZoomPanel zoomPanel = new ZoomPanel(bar);
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
        // old code
//        Diagram diagram2 = new Diagram();
//        diagram2.setName("Test");
//        diagram2.setSize(dimension);
//        diagram2.setPosition(point);
//        diagram.setContainer(diagram2);
        viewer.openDiagramView(diagram);

        // new code
        JTabbedPane tabbedPane = viewer.getTabbedPane();
        ZoomPanel zoomPanel = (ZoomPanel) tabbedPane.getSelectedComponent();
        JScrollBar bar = zoomPanel.getVerticalScrollBar();

        // old code
//        zoomPanel.add(viewer);
//        zoomPanel.add(bar);

        event = new AdjustmentEvent(bar, 10, 10, 10);
        try {
            st.adjustmentValueChanged(event);
        } catch (ClassCastException e) {
            // good.
        }
    }

    /**
     * <p>
     * This is failure test for Method:adjustmentValueChanged(AdjustmentEvent
     * event).<br>
     * Failure condition: the arg is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testAdjustmentValueChangedWithNullValue() throws Exception {
        try {
            st.adjustmentValueChanged(null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }
}
