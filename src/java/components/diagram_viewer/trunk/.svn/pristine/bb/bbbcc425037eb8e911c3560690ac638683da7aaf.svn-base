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

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>SelectionEvent</c>.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class SelectionEventAccuracyTests extends TestCase {

    /**
     * <p>
     * The path of config file used for test.
     * </p>
     */
    private static final String CONFIG = "accuracyTests" + File.separator + "AccuracyDefaultConfig.xml";

    /**
     * Represent the instance of <c>SelectionEvent</c> used for test.
     */
    private SelectionEvent event;

    /**
     * <p>
     * Represent the instance of <c>DiagramView</c> used for test.
     * </p>
     */
    private DiagramView diagramView;

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

        diagramView = new DiagramViewer().createDiagramView(diagram);
        event = new SelectionEvent(diagramView, new Rectangle(0, 0, 1, 1));
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
     * Accuracy test for the constructor <code>SelectionEvent</code>. The instance of <code>SelectionEvent</code>
     * should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of SelectionEvent should be created", new SelectionEvent(diagramView, new Rectangle()));
    }

    /**
     * <p>
     * Accuracy test for the method <code>getSelectionRectangle</code> The Rectangle should be returned.
     * </p>
     */
    public void testgetSelectionRectangleAccuracy() {
        try {
            assertEquals("the  should be returned", new Rectangle(0, 0, 1, 1), event.getSelectionRectangle());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
