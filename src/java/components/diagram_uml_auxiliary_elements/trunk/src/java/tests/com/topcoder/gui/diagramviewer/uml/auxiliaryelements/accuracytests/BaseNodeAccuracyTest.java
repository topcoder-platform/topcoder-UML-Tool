/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import java.awt.Rectangle;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BoundaryChangeEvent;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BoundaryChangeListener;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Accuracy test for <code>BaseNode</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class BaseNodeAccuracyTest extends TestCase {

    /**
     * <p>
     * BaseNode instance used for test.
     * </p>
     */
    private BaseNode baseNode;

    /**
     * <p>
     * PropertyMapping instance used for test.
     * </p>
     */
    private PropertyMapping propertyMapping;

    /**
     * <p>
     * The GraphNode instance used for test.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * The Uml1SemanticModelBridge instance used for test.
     * </p>
     */
    private Uml1SemanticModelBridge usmb;

    /**
     * <p>
     * The Property instance used for test.
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
     * Sets up test environment.
     * </p>
     */
    protected void setUp() throws Exception {
        // load configuration
        ConfigHelper.clearConfigration();
        ConfigHelper.loadXMLConfigrationFile(ConfigHelper.ACC_CONFIG_FILE);
        // create propertyMapping
        propertyMapping = new PropertyMapping(ConfigHelper.ACC_NAMESPACE + ".basenode");
        // create property
        property = new Property();
        // create Uml1SemanticModelBridge
        usmb = new Uml1SemanticModelBridge();
        usmb.setElement(new CommentImpl());
        // create graphNode
        graphNode = new GraphNode();
        graphNode.setSemanticModel(usmb);
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        graphNode.setSize(new com.topcoder.diagraminterchange.Dimension());
        // create baseNode
        baseNode = new CommentNode(graphNode, propertyMapping);
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
        view.add(baseNode);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    protected void tearDown() throws Exception {
        // clear configuration
        ConfigHelper.clearConfigration();
        // instances
        baseNode = null;
        propertyMapping = null;
        viewer = null;
        viewer = null;
    }

    /**
     * <p>
     * Test accuracy of constructor.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("baseNode should have MouseListeners.", baseNode.getMouseListeners());
    }

    /**
     * <p>
     * Tests accuracy of <code>GetStrokeColor()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetStrokeColorAccuracy() throws Exception {
        assertNull("initial value should be null.", baseNode.getStrokeColor());
        // set property
        property.setKey("stroke_color");
        property.setValue("0xFF0000");
        graphNode.addProperty(property);
        baseNode = new CommentNode(graphNode, propertyMapping);
        // create node
        assertNotNull("color should not be null", baseNode.getStrokeColor());
        assertEquals("color should be setted correctly.", 0xFF, baseNode.getStrokeColor().getRed());
        assertEquals("color should be setted correctly.", 0x00, baseNode.getStrokeColor().getGreen());
        assertEquals("color should be setted correctly.", 0x00, baseNode.getStrokeColor().getBlue());
    }

    /**
     * <p>
     * Tests accuracy of <code>GetFillColor()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetFillColorAccuracy() throws Exception {
        assertNull("initial value should be null.", baseNode.getFillColor());
        // set property
        property.setKey("fill_color");
        property.setValue("0xFF00F0");
        graphNode.addProperty(property);
        // create node
        baseNode = new CommentNode(graphNode, propertyMapping);
        assertNotNull("color should not be null", baseNode.getFillColor());
        assertEquals("color should be setted correctly.", 0xFF, baseNode.getFillColor().getRed());
        assertEquals("color should be setted correctly.", 0x00, baseNode.getFillColor().getGreen());
        assertEquals("color should be setted correctly.", 0xF0, baseNode.getFillColor().getBlue());
    }

    /**
     * <p>
     * Tests accuracy of <code>GetFontColor</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetFontColorAccuracy() throws Exception {
        assertNull("initial value should be null.", baseNode.getFontColor());
        // set property
        property.setKey("font_color");
        property.setValue("0xFF00F0");
        graphNode.addProperty(property);
        // create node
        baseNode = new CommentNode(graphNode, propertyMapping);
        assertNotNull("color should not be null", baseNode.getFontColor());
        assertEquals("color should be setted correctly.", 0xFF, baseNode.getFontColor().getRed());
        assertEquals("color should be setted correctly.", 0x00, baseNode.getFontColor().getGreen());
        assertEquals("color should be setted correctly.", 0xF0, baseNode.getFontColor().getBlue());
    }

    /**
     * <p>
     * Tests accuracy of <code>NotifyPropertiesChange()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testNotifyPropertiesChange() throws Exception {
        // first, only set the 'font_color' property
        property = new Property();
        property.setKey("font_color");
        property.setValue("0x0F0F0F");
        graphNode.addProperty(property);
        baseNode = new CommentNode(graphNode, propertyMapping);

        // set new value for 'font_color'
        property.setKey("font_color");
        property.setValue("0x010101");
        graphNode.addProperty(property);
        // set new value for 'fill_color'
        property = new Property();
        property.setKey("fill_color");
        property.setValue("0x010101");
        graphNode.addProperty(property);
        // set new value for 'stroke_color'
        property = new Property();
        property.setKey("stroke_color");
        property.setValue("0x010101");
        graphNode.addProperty(property);
        // set new value for 'font_family'
        property = new Property();
        property.setKey("font_family");
        property.setValue("Arial");
        graphNode.addProperty(property);
        // set new value for 'font_size'
        property = new Property();
        property.setKey("font_size");
        property.setValue("12.34");
        graphNode.addProperty(property);

        // check before notify
        assertEquals("font color should be correct.", 0x0F, baseNode.getFontColor().getRed());

        // notify properties change
        baseNode.notifyPropertiesChange();

        // check after notify
        assertEquals("font color should be setted correctly.", 1, baseNode.getFontColor().getRed());
        assertEquals("fill color should be setted correctly.", 1, baseNode.getFillColor().getRed());
        assertEquals("stroke color should be setted correctly.", 1, baseNode.getStrokeColor().getRed());
        assertEquals("font family should be setted correctly.", "Arial", baseNode.getFont().getFamily());
        assertEquals("font size should be setted correctly", 12, baseNode.getFont().getSize());
    }

    /**
     * <p>
     * Tests accuracy of <code>consumeEvent(MouseEvent)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testConsumeEventMouseEventAccuracy() throws Exception {
        // node
        MockBaseNode mockNode = new MockBaseNode(graphNode, propertyMapping);
        assertFalse("returned value should be false.", mockNode.consumeEvent(null));
    }

    /**
     * <p>
     * Tests accuracy of <code>addBoundaryChangeListener(BoundaryChangeListener)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testAddBoundaryChangeListeneBoundaryChangeListenerrAccuracy() throws Exception {
        // listener
        BoundaryChangeListener listener = new MockBoundaryChangeListener();
        // add
        baseNode.addBoundaryChangeListener(listener);
        // validate
        BoundaryChangeListener[] listeners = baseNode.getListeners(BoundaryChangeListener.class);
        assertEquals("value should be added correctly.", 1, listeners.length);
        assertEquals("value should be added correctly.", listener, listeners[0]);
    }

    /**
     * <p>
     * Tests accuracy of <code>removeBoundaryChangeListener(BoundaryChangeListener)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testRemoveBoundaryChangeListenerAccuracy() throws Exception {
        BoundaryChangeListener listener = new MockBoundaryChangeListener();
        // add listener
        baseNode.addBoundaryChangeListener(listener);
        // remove listener
        baseNode.removeBoundaryChangeListener(listener);
        BoundaryChangeListener[] listeners = baseNode.getListeners(BoundaryChangeListener.class);
        assertEquals("Listener should be removed correctly.", 0, listeners.length);
    }

    /**
     * <p>
     * Tests Accuracy of <code>fireBoundaryChange(BoundaryChangeEvent)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testFireBoundaryChangeBoundaryChangeEventAccuracy() throws Exception {
        // listener
        MockBoundaryChangeListener listener = new MockBoundaryChangeListener();
        // node
        MockBaseNode mockNode = new MockBaseNode(graphNode, propertyMapping);
        // add listener to node
        mockNode.addBoundaryChangeListener(listener);
        // boundary change event
        BoundaryChangeEvent event = new BoundaryChangeEvent(mockNode, new Rectangle(), new Rectangle());
        // before fire
        assertEquals("Event should be fired correctly.", 0, listener.flag);
        // fire
        mockNode.fireBoundaryChange(event);
        // validate
        assertEquals("Event should be fired correctly.", 1, listener.flag);
    }
}
