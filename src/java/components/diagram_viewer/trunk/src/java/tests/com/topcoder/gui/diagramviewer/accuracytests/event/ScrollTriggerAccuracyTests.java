/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests.event;

import java.awt.event.AdjustmentEvent;
import java.io.File;

import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.accuracytests.AccuracyTestsHelper;
import com.topcoder.gui.diagramviewer.event.ScrollTrigger;

import com.topcoder.gui.panels.zoom.ZoomPanel;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>ScrollTrigger</c>.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class ScrollTriggerAccuracyTests extends TestCase {

    /**
     * <p>
     * The path of config file used for test.
     * </p>
     */
    private static final String CONFIG = "accuracyTests" + File.separator + "AccuracyDefaultConfig.xml";


    /**
     * Represent the instance of <c>ScrollTrigger</c> used for test.
     */
    private ScrollTrigger trigger;

    /**
     * <p>
     * Set up test environment.
     * </p>
     *
     * @throws Exception
     *             if any error occurs when set up
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadConfig(CONFIG);
        trigger = new ScrollTrigger();
    }

    /**
     * <p>
     * Tear down test environment.
     * </p>
     *
     * @throws Exception
     *             if any error occurs when tear down
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.removeAllNamespaces();
    }

    /**
    * <p>
    * Accuracy test for the constructor <code>ScrollTrigger</code>.
    * The instance of <code>ScrollTrigger</code> should be created successfully.
    * </p>
    */
    public void testConstructorAccuracy() {
        assertNotNull("instance of ScrollTrigger should be created", new ScrollTrigger());
    }

    /**
     * <p>
     * This is the Accuracy test for Method adjustmentValueChanged(AdjustmentEvent event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testAdjustmentValueChangedAccuracy() throws Exception {
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

        AdjustmentEvent event = new AdjustmentEvent(bar, 10, 10, 10);
        try {
            trigger.adjustmentValueChanged(event);
        } catch (ClassCastException e) {
            // good.
        }
    }
}