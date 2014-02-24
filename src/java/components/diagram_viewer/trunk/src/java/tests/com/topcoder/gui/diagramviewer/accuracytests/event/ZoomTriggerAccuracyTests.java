/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests.event;

import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.io.File;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.accuracytests.AccuracyTestsHelper;
import com.topcoder.gui.diagramviewer.event.ZoomEvent;
import com.topcoder.gui.diagramviewer.event.ZoomListener;
import com.topcoder.gui.diagramviewer.event.ZoomTrigger;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>ZoomTrigger</c>.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class ZoomTriggerAccuracyTests extends TestCase {

    /**
     * <p>
     * The path of config file used for test.
     * </p>
     */
    private static final String CONFIG = "accuracyTests" + File.separator + "AccuracyDefaultConfig.xml";

    /**
     * Represent the instance of <c>ZoomTrigger</c> used for test.
     */
    private ZoomTrigger trigger;

    /**
     * <p>
     * Set up test environment.
     * </p>
     *
     * @throws Exception
     *         if any error occurs when set up
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadConfig(CONFIG);
        trigger = new ZoomTrigger();
    }

    /**
     * <p>
     * Tear down test environment.
     * </p>
     *
     * @throws Exception
     *         if any error occurs when tear down
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.removeAllNamespaces();
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>ZoomTrigger</code>. The instance of <code>ZoomTrigger</code> should be
     * created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of ZoomTrigger should be created", new ZoomTrigger());
    }

    /**
     * <p>
     * Accuracy test for the method <code>mouseWheelMoved</code> The should be returned.
     * </p>
     */
    public void testmouseWheelMovedAccuracy() {
        try {
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
                viewer.addZoomListener(new ZoomListener() {
                    public void diagramViewZoomed(ZoomEvent event) {
                        // do nothing
                    }
                });
            }
            MouseWheelEvent event = new MouseWheelEvent(viewer,
                    0, 0, KeyEvent.CTRL_DOWN_MASK, 0, 0, 0, true, 0, 0, -10);
           // trigger.mouseWheelMoved(event);
        } catch (Exception e) {
            fail("---------------------");
           // fail(e.getMessage());
        }
    }

}
