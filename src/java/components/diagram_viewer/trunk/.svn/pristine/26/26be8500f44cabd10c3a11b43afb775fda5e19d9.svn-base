/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests.event;

import java.awt.Rectangle;
import java.io.File;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.accuracytests.AccuracyTestsHelper;
import com.topcoder.gui.diagramviewer.event.SelectionEvent;
import com.topcoder.gui.diagramviewer.event.SelectionHandler;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>SelectionHandler</c>.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class SelectionHandlerAccuracyTests extends TestCase {

    /**
     * <p>
     * The path of config file used for test.
     * </p>
     */
    private static final String CONFIG = "accuracyTests" + File.separator
            + "AccuracyDefaultConfig.xml";

    /**
     * Represent the instance of <c>SelectionHandler</c> used for test.
     */
    private SelectionHandler handler;

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
        handler = new SelectionHandler();
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
     * Accuracy test for the constructor <code>SelectionHandler</code>. The
     * instance of <code>SelectionHandler</code> should be created
     * successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of SelectionHandler should be created",
                new SelectionHandler());
    }

    /**
     * <p>
     * Accuracy test for the method <code>selectionRectangleChanged</code>.
     * </p>
     */
    public void testSelectionRectangleChangedAccuracy() {
        try {
            Diagram diagram = new Diagram();
            Dimension dimension = new Dimension();
            dimension.setWidth(500.0);
            dimension.setHeight(500.0);
            diagram.setSize(dimension);

            Point point = new Point();
            point.setX(5);
            point.setY(5);
            diagram.setPosition(point);

            DiagramView viewer = new DiagramViewer()
                    .createDiagramView(diagram);
            Rectangle rectangle = new Rectangle();
            SelectionEvent event = new SelectionEvent(viewer, rectangle);
            handler.selectionRectangleChanged(event);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
