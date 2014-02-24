/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests.event;

import java.awt.event.MouseEvent;
import java.io.File;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.accuracytests.AccuracyTestsHelper;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.event.SelectElementsHandler;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>SelectElementsHandler</c>.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class SelectElementsHandlerAccuracyTests extends TestCase {

    /**
     * <p>
     * The path of config file used for test.
     * </p>
     */
    private static final String CONFIG = "accuracyTests" + File.separator + "AccuracyDefaultConfig.xml";

    /**
     * Represent the instance of <c>SelectElementsHandler</c> used for test.
     */
    private SelectElementsHandler handler;

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
        handler = new SelectElementsHandler();
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
     * Accuracy test for the constructor <code>SelectElementsHandler</code>. The instance of
     * <code>SelectElementsHandler</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of SelectElementsHandler should be created", new SelectElementsHandler());
    }

    /**
     * <p>
     * Accuracy test for the method <code>mouseDragged</code> The should be returned.
     * </p>
     */
    public void testMouseDraggedAccuracy() {
        try {
            MouseEvent event;
            DiagramViewer viewer = new DiagramViewer();
            viewer.setNewElementType(Node.class);

            Diagram diagram = new Diagram();
            Dimension dimension = new Dimension();
            dimension.setWidth(500.0);
            dimension.setHeight(500.0);
            diagram.setSize(dimension);

            Point point = new Point();
            point.setX(5);
            point.setY(5);
            diagram.setPosition(point);

            event = new MouseEvent(viewer.createDiagramView(diagram), 0, 0, 0, 0, 0, 0, true);
            handler.mouseDragged(event);
            viewer.setState(DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE);
            event = new MouseEvent(viewer.createDiagramView(diagram), 0, 0, 0, 0, 0, 0, true);

            handler.mouseDragged(event);
            viewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
            event = new MouseEvent(viewer.createDiagramView(diagram), 0, 0, 0, 0, 0, 0, true);

            handler.mouseDragged(event);

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

}
