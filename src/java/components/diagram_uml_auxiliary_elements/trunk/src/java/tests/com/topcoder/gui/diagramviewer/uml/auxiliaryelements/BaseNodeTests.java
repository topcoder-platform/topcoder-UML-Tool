/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import java.awt.Color;
import java.awt.Rectangle;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;


/**
 * <p>
 * Unit test cases for BaseNode.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class BaseNodeTests extends TestCase {
    /**
     * <p>
     * Static final String for valid namespace.
     * </p>
     */
    private static final String VALID_NAMESPACE =
        "com.topcoder.gui.diagramviewer.uml.auxiliaryelements".intern();

    /**
     * <p>
     * The BaseNode instance for helping testing.
     * </p>
     */
    private BaseNode node;

    /**
     * <p>
     * The PropertyMapping instance for helping testing.
     * </p>
     */
    private PropertyMapping mapping;

    /**
     * <p>
     * The GraphNode instance for helping testing.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * The Uml1SemanticModelBridge instance for helping testing.
     * </p>
     */
    private Uml1SemanticModelBridge usmb;

    /**
     * <p>
     * The Property instance for helping testing.
     * </p>
     */
    private Property property;

    /**
     * <p>
     * The DiagramViewer instance for helping testing.
     * </p>
     */
    private DiagramViewer viewer;

    /**
     * <p>
     * The DiagramView instance for helping testing.
     * </p>
     */
    private DiagramView view;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);
        mapping = new PropertyMapping(VALID_NAMESPACE);
        property = new Property();
        graphNode = new GraphNode();
        usmb = new Uml1SemanticModelBridge();
        usmb.setElement(new CommentImpl());
        graphNode.setSemanticModel(usmb);
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        graphNode.setSize(new com.topcoder.diagraminterchange.Dimension());
        node = new PolylineNode(new Polyline(), mapping);
        viewer = new DiagramViewer();
        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        diagram.setSize(dimension);
        view = viewer.createDiagramView(diagram);
        view.add(node);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
        mapping = null;
        property = null;
        graphNode = null;
        usmb = null;
        node = null;
        viewer = null;
        view = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(BaseNodeTests.class);
    }

    /**
     * <p>
     * Tests constructor BaseNode#BaseNode(GraphNode graphNode, PropertyMapping properties) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created BaseNode instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor() throws Exception {
        assertNotNull("Failed to create a new BaseNode instance.", node);
        assertNotNull("The newly created BaseNode will have MouseListeners.", node.getMouseListeners());
    }

    /**
     * <p>
     * Tests constructor BaseNode#BaseNode(GraphNode graphNode, PropertyMapping properties) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor_NullGraphNode() throws Exception {
        try {
            new CommentNode(null, mapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor BaseNode#BaseNode(GraphNode graphNode, PropertyMapping properties) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when properties is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor_NullProperties() throws Exception {
        try {
            new CommentNode(graphNode, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests BaseNode#getStrokeColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : BaseNode#getStrokeColor() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetStrokeColor() throws Exception {
        assertNull("The Stroke Color should be null.", node.getStrokeColor());
        property.setKey(mapping.getPropertyKey(PropertyMapping.STROKE_COLOR));
        property.setValue("000000");
        graphNode.addProperty(property);
        node = new CommentNode(graphNode, mapping);
        assertNotNull("The Stroke Color should not be null.", node.getStrokeColor());
        assertEquals("The Stroke Color should be Color.black.", node.getStrokeColor(), Color.black);
    }

    /**
     * <p>
     * Tests BaseNode#getFillColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : BaseNode#getFillColor() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetFillColor() throws Exception {
        assertNull("The Fill Color should be null.", node.getFillColor());
        property.setKey(mapping.getPropertyKey(PropertyMapping.FILL_COLOR));
        property.setValue("000000");
        graphNode.addProperty(property);
        node = new CommentNode(graphNode, mapping);
        assertNotNull("The Fill Color should not be null.", node.getFillColor());
        assertEquals("The Fill Color should be Color.black.", node.getFillColor(), Color.black);
    }

    /**
     * <p>
     * Tests BaseNode#getFontColor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : BaseNode#getFontColor() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetFontColor() throws Exception {
        assertNull("The Font Color should be null.", node.getFontColor());
        property.setKey(mapping.getPropertyKey(PropertyMapping.FONT_COLOR));
        property.setValue("000000");
        graphNode.addProperty(property);
        node = new CommentNode(graphNode, mapping);
        assertNotNull("The Font Color should not be null.", node.getFontColor());
        assertEquals("The Font Color should be Color.black.", node.getFontColor(), Color.black);
    }

    /**
     * <p>
     * Tests BaseNode#notifyPropertiesChange() for accuracy.
     * </p>
     *
     * <p>
     * Verify : BaseNode#notifyPropertiesChange() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyPropertiesChange() throws Exception {
        node = new CommentNode(graphNode, mapping);

        property.setKey(mapping.getPropertyKey(PropertyMapping.FONT_COLOR));
        property.setValue("000000");
        graphNode.addProperty(property);
        property = new Property();
        property.setKey(mapping.getPropertyKey(PropertyMapping.FILL_COLOR));
        property.setValue("000000");
        graphNode.addProperty(property);
        property = new Property();
        property.setKey(mapping.getPropertyKey(PropertyMapping.STROKE_COLOR));
        property.setValue("000000");
        graphNode.addProperty(property);
        property = new Property();
        property.setKey(mapping.getPropertyKey(PropertyMapping.FONT_FAMILY));
        property.setValue("Webdings");
        graphNode.addProperty(property);
        property = new Property();
        property.setKey(mapping.getPropertyKey(PropertyMapping.FONT_SIZE));
        property.setValue("13.0");
        graphNode.addProperty(property);

        node.notifyPropertiesChange();

        assertNotNull("The Font Color should not be null.", node.getFontColor());
        assertEquals("The Font Color should be Color.black.", node.getFontColor(), Color.black);
        assertNotNull("The Fill Color should not be null.", node.getFillColor());
        assertEquals("The Fill Color should be Color.black.", node.getFillColor(), Color.black);
        assertNotNull("The Stroke Color should not be null.", node.getStrokeColor());
        assertEquals("The Stroke Color should be Color.black.", node.getStrokeColor(), Color.black);
        assertNotNull("The Font Family should not be null.", node.getFont().getFamily());
        assertEquals("The Font Family should be Webdings.", node.getFont().getFamily(), "Webdings");
        assertEquals("The Font Size should be 13.", node.getFont().getSize(), 13);
    }

    /**
     * <p>
     * Tests BaseNode#notifyPropertiesChange() for failure.
     * </p>
     *
     * <p>
     * It tests the case that when color is invalid and expects IllegalGraphNodeException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyPropertiesChange_InvalidColor() throws Exception {
        try {
            node = new CommentNode(graphNode, mapping);
            property.setKey(mapping.getPropertyKey(PropertyMapping.FONT_COLOR));
            property.setValue("00g000");
            graphNode.addProperty(property);
            node.notifyPropertiesChange();

            fail("IllegalGraphNodeException expected.");
        } catch (IllegalGraphNodeException ige) {
            // good
        }
    }

    /**
     * <p>
     * Tests BaseNode#notifyPropertiesChange() for failure.
     * </p>
     *
     * <p>
     * It tests the case that when font size is not Double and expects IllegalGraphNodeException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyPropertiesChange_NotDoubleFontSize() throws Exception {
        try {
            node = new CommentNode(graphNode, mapping);
            property.setKey(mapping.getPropertyKey(PropertyMapping.FONT_SIZE));
            property.setValue("abc");
            graphNode.addProperty(property);
            node.notifyPropertiesChange();

            fail("IllegalGraphNodeException expected.");
        } catch (IllegalGraphNodeException ige) {
            // good
        }
    }

    /**
     * <p>
     * Tests BaseNode#consumeEvent(MouseEvent event) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the BaseNode#consumeEvent(MouseEvent event) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConsumeEvent() throws Exception {
        assertFalse("The BaseNode#ConsumeEvent() should always return false.", node.consumeEvent(null));
    }

    /**
     * <p>
     * Tests BaseNode#addBoundaryChangeListener(BoundaryChangeListener listener) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the BaseNode#addBoundaryChangeListener(BoundaryChangeListener listener) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddBoundaryChangeListener() throws Exception {
        node.addBoundaryChangeListener(new MockBoundaryChangeListener());
        assertEquals("After add, this node should have one BoundaryChangeListener.",
                node.getListeners(BoundaryChangeListener.class).length, 1);
    }

    /**
     * <p>
     * Tests BaseNode#removeBoundaryChangeListener(BoundaryChangeListener listener) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the BaseNode#removeBoundaryChangeListener(BoundaryChangeListener listener) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRemoveBoundaryChangeListener() throws Exception {
        BoundaryChangeListener listener = new MockBoundaryChangeListener();
        node.addBoundaryChangeListener(listener);
        node.removeBoundaryChangeListener(listener);
        assertEquals("After add and remove, this node should not have BoundaryChangeListener.",
                node.getListeners(BoundaryChangeListener.class).length, 0);
    }

    /**
     * <p>
     * Tests BaseNode#fireBoundaryChange(BoundaryChangeEvent event) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the BaseNode#fireBoundaryChange(BoundaryChangeEvent event) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFireBoundaryChange() throws Exception {
        MockBoundaryChangeListener listener = new MockBoundaryChangeListener();
        node.addBoundaryChangeListener(listener);
        node.fireBoundaryChange(new BoundaryChangeEvent(node, new Rectangle(), new Rectangle()));
        assertTrue("The listener should be triggered.", listener.getChanged());
    }
}
