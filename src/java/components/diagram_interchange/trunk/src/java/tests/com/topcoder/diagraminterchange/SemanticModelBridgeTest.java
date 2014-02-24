/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class SemanticModelBridge. Since SemanticModelBridge is an abstract class, A mock concrete
 * class is provided to extend it for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SemanticModelBridgeTest extends TestCase {

    /**
     * An instance of SemanticModelBridge for testing.
     */
    private SemanticModelBridge instance;

    /**
     * Sets up the environment. Creates an instance of SemanticModelBridge.
     */
    protected void setUp() {
        instance = new MockSemanticModelBridge();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testSemanticModelBridgeCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertNull("null expected", instance.getPresentation());
        assertNull("null expected", instance.getDiagram());
        assertNull("null expected", instance.getGraphElement());
    }

    /**
     * Tests method getPresentation. The correspond field should be returned properly.
     */
    public void testGetPresentation() {
        String[] strings = TestHelper.getRandomStrings();

        for (String item : strings) {
            instance.setPresentation(item);
            assertEquals("incorrect string", item, instance.getPresentation());
        }
    }

    /**
     * Tests method setPresentation. The correspond field should be updated properly.
     */
    public void testSetPresentation() {
        String[] strings = TestHelper.getRandomStrings();

        for (String item : strings) {
            instance.setPresentation(item);
            assertEquals("incorrect string", item, instance.getPresentation());
        }
    }

    /**
     * Tests method setPresentation with null value. Null value should be allowed.
     */
    public void testSetPresentationNull() {
        instance.setPresentation(null);
        assertNull("null value should be allowed", instance.getPresentation());
    }

    /**
     * Tests method setPresentation with empty value. Empty value should be allowed.
     */
    public void testSetPresentationEmpty() {
        instance.setPresentation(TestHelper.EMPTY_STRING);
        assertEquals("empty value should be allowed", TestHelper.EMPTY_STRING, instance.getPresentation());
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
}

/**
 * <p>
 * A mock concrete class extends SemanticModelBridge for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class MockSemanticModelBridge extends SemanticModelBridge {
    // empty
}