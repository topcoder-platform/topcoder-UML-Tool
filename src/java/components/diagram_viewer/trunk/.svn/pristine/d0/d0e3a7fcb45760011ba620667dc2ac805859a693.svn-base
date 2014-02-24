/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.Rectangle;
import java.util.Map;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.event.AddNewElementEvent;
import com.topcoder.gui.diagramviewer.elements.Node;
import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for AddNewElementEvent.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddNewElementEventUnitTests extends TestCase {

    /**
     * <p>
     * Class instance for testing.
     * </p>
     */
    private Class newElementType;

    /**
     * <p>
     * Rectangle instance for testing.
     * </p>
     */
    private Rectangle newElementBounds;

    /**
     * <p>
     * DiagramView instance for testing.
     * </p>
     */
    private DiagramView diagramView;

    /**
     * AddNewElementEvent instance for testing.
     */
    private AddNewElementEvent ane;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        // loads the valid configuration
        UnitTestsHelper.loadConfig("config.xml");

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
        this.newElementType = Node.class;
        this.newElementBounds = new Rectangle();
        ane = new AddNewElementEvent(diagramView, newElementType);
    }

    /**
     * <p>
     * This is the accuracy test for constructor: AddNewElementEvent(DiagramView
     * source, Class type). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1() throws Exception {
        assertNotNull("Failed to create AddNewElementEvent instance.", ane);
    }

    /**
     * <p>
     * This is the failure test for constructor: AddNewElementEvent(DiagramView
     * source, Class type).<br>
     * Failure condition: at least one of the are is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1WithNullValue() throws Exception {
        try {
            new AddNewElementEvent(null, newElementType);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new AddNewElementEvent(diagramView, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
        try {
            new AddNewElementEvent(null, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the failure test for constructor: AddNewElementEvent(DiagramView
     * source, Class type). <br>
     * Failure condition: the class type is invalid. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1WithInValidClassType() throws Exception {

        try {
            new AddNewElementEvent(diagramView, Map.class);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the accuracy test for constructor:
     * AddNewElementEvent(diagramView, newElementType, newElementBounds). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2() throws Exception {
        ane = new AddNewElementEvent(diagramView, newElementType, newElementBounds);
        assertNotNull("Failed to create AddNewElementEvent instance.", ane);
        assertEquals("Failed to create AddNewElementEvent instance.", this.newElementType, ane.getNewElementType());
        assertEquals("Failed to create AddNewElementEvent instance.", this.diagramView, (DiagramView) ane.getSource());
        assertEquals("Failed to create AddNewElementEvent instance.", new Rectangle(this.newElementBounds), ane
                .getNewElementBounds());
    }

    /**
     * <p>
     * This is the failure test for constructor: AddNewElementEvent(diagramView,
     * newElementType, newElementBounds).<br>
     * Failure condition: at least one of the are is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2WithNullValue() throws Exception {
        try {
            new AddNewElementEvent(null, newElementType, this.newElementBounds);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new AddNewElementEvent(diagramView, null, this.newElementBounds);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new AddNewElementEvent(this.diagramView, newElementType, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new AddNewElementEvent(null, null, this.newElementBounds);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new AddNewElementEvent(null, null, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

    }

    /**
     * <p>
     * This is the failure test for constructor: AddNewElementEvent(diagramView,
     * newElementType, newElementBounds). <br>
     * Failure condition: the class type is invalid. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2WithInValidClassType() throws Exception {

        try {
            new AddNewElementEvent(diagramView, Map.class, this.newElementBounds);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getNewElementType().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetNewElementTypeAccuracy() throws Exception {
        ane = new AddNewElementEvent(diagramView, newElementType, newElementBounds);
        assertEquals("Failed to get newElementType.", this.newElementType, ane.getNewElementType());

    }

    /**
     * <p>
     * This is the Accuracy test for Method: getNewElementBounds().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetNewElementBoundsAccuracy() throws Exception {
        ane = new AddNewElementEvent(diagramView, newElementType, newElementBounds);
        assertEquals("Failed to get NewElementBounds.", new Rectangle(this.newElementBounds),
                ane.getNewElementBounds());
    }

}
