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
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.event.AddNewElementEvent;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>AddNewElementEvent</c>.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class AddNewElementEventAccuracyTests extends TestCase {

    /**
     * <p>
     * The path of config file used for test.
     * </p>
     */
    private static final String CONFIG = "accuracyTests" + File.separator + "AccuracyDefaultConfig.xml";

    /**
     * Represent the instance of <c>AddNewElementEvent</c> used for test.
     */
    private AddNewElementEvent event;

    /**
     * <p>
     * Represent the instance of <c>Rectangle</c> used for test.
     * </p>
     */
    private Rectangle newBounds;

    /**
     * <p>
     * Represent the instance of <c>DiagramView</c> used for test.
     * </p>
     */
    private DiagramView diagramView;

    /**
     * <p>
     * Represent the instance of <c>Class</c> used for test.
     * </p>
     */
    private Class newType;

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
        this.newType = Node.class;
        this.newBounds = new Rectangle();
        event = new AddNewElementEvent(diagramView, newType);
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
     * Accuracy test for the constructor <code>AddNewElementEvent(DiagramView, Class)</code>. The instance of
     * <code>AddNewElementEvent</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        event = new AddNewElementEvent(diagramView, newType);
        assertNotNull("instance of AddNewElementEvent should be created", event);
        assertEquals("Failed to create AddNewElementEvent instance.", this.newType, event.getNewElementType());
        assertEquals("Failed to create AddNewElementEvent instance.", this.diagramView,
                (DiagramView) event.getSource());
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>AddNewElementEvent(DiagramView, Class, Rectangle)</code>. The instance of
     * <code>AddNewElementEvent</code> should be created successfully.
     * </p>
     */
    public void testConstructor2Accuracy() {
        event = new AddNewElementEvent(diagramView, newType, newBounds);
        assertNotNull("instance of AddNewElementEvent should be created", event);
        assertEquals("Failed to create AddNewElementEvent instance.", this.newType, event.getNewElementType());
        assertEquals("Failed to create AddNewElementEvent instance.", this.diagramView,
                (DiagramView) event.getSource());
        assertEquals("Failed to create AddNewElementEvent instance.", new Rectangle(this.newBounds), event
                        .getNewElementBounds());
    }

    /**
     * <p>
     * Accuracy test for the method <code>getNewElementType</code> The ElementType should be returned.
     * </p>
     */
    public void testGetNewElementTypeAccuracy() {
        try {
            assertEquals("the ElementType should be returned", newType, event.getNewElementType());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>getNewElementBounds</code> The newElementBounds should be returned.
     * </p>
     */
    public void testGetNewElementBoundsAccuracy() {
        try {
            assertEquals("the newElementBounds should be returned", newBounds, event.getNewElementBounds());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
