/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests.event;

import java.io.File;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.accuracytests.AccuracyTestsHelper;
import com.topcoder.gui.diagramviewer.event.ZoomEvent;
import com.topcoder.gui.panels.zoom.ZoomPanel;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>ZoomEvent</c>.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class ZoomEventAccuracyTests extends TestCase {

    /**
     * <p>
     * The path of config file used for test.
     * </p>
     */
    private static final String CONFIG = "accuracyTests" + File.separator + "AccuracyDefaultConfig.xml";

    /**
     * Represent the instance of <c>ZoomEvent</c> used for test.
     */
    private ZoomEvent event;

    /**
     * Represent the instance of ZoomPanel instance for testing.
     */
    private ZoomPanel zoomPanel;

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
        event = new ZoomEvent(zoomPanel, 99);
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
     * Accuracy test for the constructor <code>ZoomEvent</code>. The instance of <code>ZoomEvent</code> should be
     * created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of ZoomEvent should be created", new ZoomEvent(zoomPanel, 99));
    }

    /**
     * <p>
     * Accuracy test for the method <code>getNewZoomFactor</code> The ZoomFactor should be returned.
     * </p>
     */
    public void testgetNewZoomFactorAccuracy() {
        try {
            assertEquals("the  should be returned", 99.0, event.getNewZoomFactor());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
