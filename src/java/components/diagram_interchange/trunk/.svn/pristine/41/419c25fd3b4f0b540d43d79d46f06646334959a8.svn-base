/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class DiagramLink.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DiagramLinkTest extends TestCase {

    /**
     * An instance of DiagramLink for testing.
     */
    private DiagramLink instance;

    /**
     * Sets up the environment. Creates an instance of DiagramLink.
     */
    protected void setUp() {
        instance = new DiagramLink();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testDiagramLinkCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertTrue("zero expected", TestHelper.DEFAULT_DOUBLE == instance.getZoom());
        assertNull("null expected", instance.getViewport());
        assertNull("null expected", instance.getGraphElement());
        assertNull("null expected", instance.getDiagram());
    }

    /**
     * Tests method getZoom. The correspond field should be returned properly.
     */
    public void testGetZoom() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setZoom(item);
            assertTrue("incorrect double value", item == instance.getZoom());
        }
    }

    /**
     * Tests method setZoom. The correspond field should be updated properly.
     */
    public void testSetZoom() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setZoom(item);
            assertTrue("incorrect double value", item == instance.getZoom());
        }
    }

    /**
     * Tests method getViewport. The correspond field should be returned properly.
     */
    public void testGetViewport() {
        Point point = new Point();
        instance.setViewport(point);
        assertEquals("incorrect Viewport", point, instance.getViewport());
    }

    /**
     * Tests method setViewport. The correspond field should be updated properly.
     */
    public void testSetViewport() {
        Point point = new Point();
        instance.setViewport(point);
        assertEquals("incorrect Viewport", point, instance.getViewport());
    }

    /**
     * Tests method setViewport with null value. Null value should be allowed.
     */
    public void testSetViewportNull() {
        instance.setViewport(null);
        assertNull("null value should be allowed", instance.getViewport());
    }

    /**
     * Tests method getGraphElement. The correspond field should be returned properly.
     */
    public void testGetGraphElement() {
        GraphElement graphElement = new MockGraphElement();
        instance.setGraphElement(graphElement);
        assertEquals("incorrect GraphElement", graphElement, instance.getGraphElement());
    }

    /**
     * Tests method setGraphElement. The correspond field should be updated properly.
     */
    public void testSetGraphElement() {
        GraphElement graphElement = new MockGraphElement();
        instance.setGraphElement(graphElement);
        assertEquals("incorrect GraphElement", graphElement, instance.getGraphElement());
    }

    /**
     * Tests method setGraphElement with null value. Null value should be allowed.
     */
    public void testSetGraphElementNull() {
        instance.setGraphElement(null);
        assertNull("null value should be allowed", instance.getGraphElement());
    }

    /**
     * Tests method getDiagram. The correspond field should be returned properly.
     */
    public void testGetDiagram() {
        Diagram diagram = new Diagram();
        instance.setDiagram(diagram);
        assertEquals("incorrect Diagram", diagram, instance.getDiagram());
    }

    /**
     * Tests method setDiagram. The correspond field should be updated properly.
     */
    public void testSetDiagram() {
        Diagram diagram = new Diagram();
        instance.setDiagram(diagram);
        assertEquals("incorrect Diagram", diagram, instance.getDiagram());
    }

    /**
     * Tests method setDiagram with null value. Null value should be allowed.
     */
    public void testSetDiagramNull() {
        instance.setDiagram(null);
        assertNull("null value should be allowed", instance.getDiagram());
    }
}