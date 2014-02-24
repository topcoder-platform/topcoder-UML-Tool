/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.usecases.IncludeImpl;

/**
 * <p>
 * Unit test cases for Utils.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UtilsTests extends TestCase {
    /**
     * <p>
     * Tests Utils#checkNull(Object,String) for accuracy.
     * </p>
     */
    public void testCheckNull() {
        Utils.checkNull(" ", "test");
    }

    /**
     * <p>
     * Tests Utils#checkNull(Object,String) for failure.
     * </p>
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckNull_NullArg() {
        try {
            Utils.checkNull(null, "test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests {@link Utils#checkValidProperties(java.util.Map)} for accuracy.
     * </p>
     * <p>
     * It verifies the method is correct.
     * </p>
     */
    public void testCheckValidProperties() {
        Utils.checkValidProperties(TestHelper.createProperties());
    }

    /**
     * <p>
     * Tests {@link Utils#checkValidProperties(java.util.Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when properties contains null key and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckValidPropertiesContainsNullKey() {
        Map<String, String> prop = new HashMap<String, String>();
        prop.put(null, "test");
        try {
            Utils.checkValidProperties(prop);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests {@link Utils#checkValidProperties(java.util.Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when properties contains null value and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckValidPropertiesContainsNullValue() {
        Map<String, String> prop = new HashMap<String, String>();
        prop.put("test", null);
        try {
            Utils.checkValidProperties(prop);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests {@link Utils#checkValidProperties(java.util.Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when properties contains empty key and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckValidPropertiesContainsEmptyKey() {
        Map<String, String> prop = new HashMap<String, String>();
        prop.put(" ", "test");
        try {
            Utils.checkValidProperties(prop);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests {@link Utils#checkValidProperties(java.util.Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when properties contains empty value and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckValidPropertiesContainsEmptyValue() {
        Map<String, String> prop = new HashMap<String, String>();
        prop.put("test", "");
        try {
            Utils.checkValidProperties(prop);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /*
     * BugFix: UML-7167
     */
//    /**
//     * <p>
//     * Tests {@link Utils#getBoundedRect(TextField[])} for accuracy.
//     * </p>
//     * <p>
//     * It verifies this method is correct.
//     * </p>
//     */
//    public void testGetBoundedRect1() {
//        TextField text = new TextField(new GraphNode());
//        text.setBounds(20, 20, 40, 40);
//        TextField[] textFields = new TextField[] {text};
//
//        assertEquals("Equal rectangle expected.", new Rectangle(20, 20, 40, 40), Utils.getBoundedRect(textFields));
//    }
//
//    /**
//     * <p>
//     * Tests {@link Utils#getBoundedRect(TextField[])} for accuracy.
//     * </p>
//     * <p>
//     * It verifies this method is correct.
//     * </p>
//     */
//    public void testGetBoundedRect2() {
//        TextField text1 = new TextField(new GraphNode());
//        text1.setBounds(20, 20, 40, 40);
//        TextField text2 = new TextField(new GraphNode());
//        text2.setBounds(10, 15, 20, 70);
//        TextField[] textFields = new TextField[] {text1, text2};
//
//        assertEquals("Equal rectangle expected.", new Rectangle(10, 15, 50, 70), Utils.getBoundedRect(textFields));
//    }
//
//    /**
//     * <p>
//     * Tests {@link Utils#getBoundedRect(TextField[])} for accuracy.
//     * </p>
//     * <p>
//     * It tests the case that all TextFields are hidden, and expects Rectangle.x and Rectangle.y it return should be
//     * Integer.MAX_VALUE
//     * </p>
//     */
//    public void testGetBoundedRect3() {
//        TextField text1 = new TextField(new GraphNode());
//        text1.setBounds(20, 20, 40, 40);
//        TextField text2 = new TextField(new GraphNode());
//        text2.setBounds(10, 15, 20, 70);
//        text1.setVisible(false);
//        text2.setVisible(false);
//        TextField[] textFields = new TextField[] {text1, text2};
//
//        assertEquals("Equal rectangle expected.", Integer.MAX_VALUE, Utils.getBoundedRect(textFields).x);
//        assertEquals("Equal rectangle expected.", Integer.MAX_VALUE, Utils.getBoundedRect(textFields).y);
//    }

    /**
     * <p>
     * Tests {@link Utils#getBoundedRect(TextField[])} for failure.
     * </p>
     * <p>
     * It tests the case that when textFields is null and expects IllegalArgumentException.
     * </p>
     */
    public void testGetBoundsRect_NullTextFields() {
        try {
            Utils.getBoundedRect(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests {@link Utils#getBoundedRect(TextField[])} for failure.
     * </p>
     * <p>
     * It tests the case that when textFields is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testGetBoundsRect_EmptyTextFields() {
        try {
            Utils.getBoundedRect(new TextField[0]);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests Utils#setNodeSizeRelativePosition(Node, GraphNode) for accuracy.
     * </p>
     * <p>
     * It verifies Utils#setNodeSizeRelativePosition(Node, GraphNode) is correct.
     * </p>
     */
    public void testSetNodeSizeRelativePosition() {
        GraphNode graphNode = new GraphNode();
        com.topcoder.diagraminterchange.Point point = new com.topcoder.diagraminterchange.Point();
        point.setX(10);
        point.setY(20);
        graphNode.setPosition(point);
        com.topcoder.diagraminterchange.Dimension dimension = new com.topcoder.diagraminterchange.Dimension();
        dimension.setWidth(50);
        dimension.setHeight(100);
        graphNode.setSize(dimension);

        Node node = TestHelper.createSubsystemNodeContainer();

        try {
            Utils.setNodeSizeRelativePosition(node, graphNode);
        } catch (IllegalGraphElementException e) {
            fail("no exception will be thrown.");
        }

        assertEquals("Failed to set the relative position", new Point(SelectionCorner.DEFAULT_RADIUS,
                SelectionCorner.DEFAULT_RADIUS), node.getRelativePosition());
        assertEquals("Failed to set the selection bound.", new Rectangle(SelectionCorner.DEFAULT_RADIUS,
                SelectionCorner.DEFAULT_RADIUS, (int) Math.round(graphNode.getSize().getWidth()), (int) Math
                        .round(graphNode.getSize().getHeight())), node.getSelectionBound());
    }

    /**
     * <p>
     * Tests Utils#setNodeSizeRelativePosition(Node, GraphNode) for failure.
     * </p>
     * <p>
     * It verifies the case that when node is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetNodeSizeRelativePosition_NullNode() {
        try {
            Utils.setNodeSizeRelativePosition(null, new GraphNode());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // the expected case
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
    }

    /**
     * <p>
     * Tests Utils#setNodeSizeRelativePosition(Node, GraphNode) for failure.
     * </p>
     * <p>
     * It verifies the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetNodeSizeRelativePosition_NullGraphNode() {
        try {
            Utils.setNodeSizeRelativePosition(TestHelper.createSubsystemNodeContainer(), null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // the expected case
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
    }

    /**
     * <p>
     * Tests {@link Utils#getAbsolutePosition(GraphNode)} for accuracy.
     * </p>
     * <p>
     * It verifies the method is correct.
     * </p>
     */
    public void testGetAbsolutePosition() {
        // graphNodeA#getPosition() = (0, 0)
        GraphNode graphNodeA = TestHelper.createGraphNodeForSubsystem();
        graphNodeA.setPosition(TestHelper.getPoint(0, 0));

        // graphNodeB#getPosition() = (40, 40)
        GraphNode graphNodeB = TestHelper.createGraphNodeForSubsystem();
        graphNodeB.setPosition(TestHelper.getPoint(40.0, 40.0));

        // graphNodeC#getPosition() = (30, 30)
        GraphNode graphNodeC = TestHelper.createGraphNodeForSubsystem();
        graphNodeC.setPosition(TestHelper.getPoint(30.0, 30.0));

        // graphNodeA contains graphNodeB
        // graphNodeB contains graphNodeC
        graphNodeC.setContainer(graphNodeB);
        graphNodeB.setContainer(graphNodeA);

        assertEquals(new Point(40, 40), Utils.getAbsolutePosition(graphNodeB));
        assertEquals(new Point(70, 70), Utils.getAbsolutePosition(graphNodeC));
    }

    /**
     * <p>
     * Tests {@link Utils#getAbsolutePosition(GraphNode)} for failure.
     * </p>
     * <p>
     * It tests the case that when graphNode is null and expects success.
     * </p>
     */
    public void testGetAbsolutePositionNull() {
        try {
            Utils.getAbsolutePosition(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests Utils#getStringProperty(DiagramElement,String) for accuracy.
     * </p>
     * <p>
     * It tests the case that property is found and expects the value is correct.
     * </p>
     */
    public void testGetStringProperty() {
        String value = Utils.getStringProperty(TestHelper.createGraphNode(), "FillColor");

        assertEquals("Failed to get the string property value.", "555555", value);
    }

    /**
     * <p>
     * Tests Utils#getStringProperty(DiagramElement,String) for accuracy.
     * </p>
     * <p>
     * It tests the case that property is not found and expects null.
     * </p>
     */
    public void testGetStringProperty_Unknown() {
        String value = Utils.getStringProperty(TestHelper.createGraphNode(), "value");

        assertNull("Failed to get the string property value.", value);
    }

    /**
     * <p>
     * Tests Utils#parseColorProperty(DiagramElement,String) for accuracy.
     * </p>
     * <p>
     * It tests the case that property is found and expects the value is correct.
     * </p>
     */
    public void testParseColorPropertyFromDiagramElement() {
        Color value = Utils.parseColorProperty(TestHelper.createGraphNode(), "FontColor");

        assertEquals("Failed to get the color property value.", new Color(255, 0, 0), value);
    }

    /**
     * <p>
     * Tests Utils#parseColorProperty(DiagramElement,String) for accuracy.
     * </p>
     * <p>
     * It tests the case that property is not found and expects null.
     * </p>
     */
    public void testParseColorPropertyFromDiagramElement_Unknown() {
        Color value = Utils.parseColorProperty(TestHelper.createGraphNode(), "value");

        assertNull("Failed to get the color property value.", value);
    }

    /**
     * <p>
     * Tests Utils#readColorProperty(DiagramElement,String,Color) for accuracy.
     * </p>
     * <p>
     * It tests the case that property is found and expects the value is correct.
     * </p>
     */
    public void testReadColorProperty() {
        Color value = Utils.readColorProperty(TestHelper.createGraphNode(), "StrokeColor", Color.RED);

        assertEquals("Failed to get the color property value.", new Color(0, 255, 0), value);
    }

    /**
     * <p>
     * Tests Utils#readColorProperty(DiagramElement,String,Color,String) for accuracy.
     * </p>
     * <p>
     * It tests the case that property is not found and expects the value is correct.
     * </p>
     */
    public void testReadColorProperty_Unknown() {
        Color value = Utils.readColorProperty(TestHelper.createGraphNode(), "UnknownColor", Color.RED);

        assertEquals("Failed to get the color property value.", Color.RED, value);
    }

    /**
     * <p>
     * Tests Utils#readDoubleProperty(DiagramElement,String,double) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is found and expects the value is correct.
     * </p>
     */
    public void testReadDoubleProperty() {
        double value = Utils.readDoubleProperty(TestHelper.createGraphNode(), "FontSize", 20.0);

        assertEquals("Failed to get the double property value.", 12.0, value);
    }

    /**
     * <p>
     * Tests Utils#readDoubleProperty(DiagramElement,String,double) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that property is not found and expects the value is correct.
     * </p>
     */
    public void testReadDoubleProperty_Unknown() {
        double value = Utils.readDoubleProperty(TestHelper.createGraphNode(), "UnknownValue", 20.0);

        assertEquals("Failed to get the double property value.", 20.0, value);
    }

    /**
     * <p>
     * Tests Util#getClosestPoint(Point,Point,Point,Point) for accuracy.
     * </p>
     * <p>
     * It tests the case when the closest point from the point to the segment is the left point of the segment and
     * verify the distance and closest point are correct.
     * </p>
     */
    public void testGetClosestPoint_LineLeft() {
        Point destPoint = new Point();

        assertEquals("Failed to get the closest point.", 50.0, Utils.getClosestPoint(new Point(50, 150), new Point(100,
                150), new Point(200, 50), destPoint), 0.01);
        assertEquals("Failed to get the closest point.", new Point(100, 150), destPoint);
    }

    /**
     * <p>
     * Tests Util#getClosestPoint(Point,Point,Point,Point) for accuracy.
     * </p>
     * <p>
     * It tests the case when the closest point from the point to the segment is the right point of the segment and
     * verify the distance and closest point are correct.
     * </p>
     */
    public void testGetClosestPoint_LineRight() {
        Point destPoint = new Point();

        assertEquals("Failed to get the closest point.", 50.0, Utils.getClosestPoint(new Point(200, 0), new Point(100,
                150), new Point(200, 50), destPoint), 0.01);
        assertEquals("Failed to get the closest point.", new Point(200, 50), destPoint);
    }

    /**
     * <p>
     * Tests Util#getClosestPoint(Point,Point,Point,Point) for accuracy.
     * </p>
     * <p>
     * It tests the case when the closest point from the point to the segment is on the interior the segment and verify
     * the distance and closest point are correct.
     * </p>
     */
    public void testGetClosestPoint_LineUp() {
        Point destPoint = new Point();

        assertEquals("Failed to get the closest point.", 106.066, Utils.getClosestPoint(new Point(50, 50), new Point(
                100, 150), new Point(200, 50), destPoint), 0.001);

        assertEquals("Failed to get the closest point.", new Point(125, 125), destPoint);
    }

    /**
     * <p>
     * Tests {@link Utils#updateTextFieldSizeLocation(TextField)} for accuracy.
     * </p>
     * <p>
     * It verifies this method is correct.
     * </p>
     *
     * @throws IllegalGraphElementException to JUnit
     */
    public void testUpdateTextFieldSizeLocation1() throws IllegalGraphElementException {
        GraphEdge edge = TestHelper.createGraphEdgeForEdge(new IncludeImpl());
        IncludeEdge includeEdge = new IncludeEdge(edge);

        TextField textField = includeEdge.getNameCompartment();
        Utils.updateTextFieldSizeLocation(textField);
        assertTrue("visibility is true expects", textField.isVisible());
    }

    /**
     * <p>
     * Tests {@link Utils#updateTextFieldSizeLocation(TextField)} for accuracy.
     * </p>
     * <p>
     * It verifies this method is correct.
     * </p>
     *
     * @throws IllegalGraphElementException to JUnit
     */
    public void testUpdateTextFieldSizeLocation2() throws IllegalGraphElementException {
        GraphEdge edge = TestHelper.createGraphEdgeForEdge(new IncludeImpl());
        IncludeEdge includeEdge = new IncludeEdge(edge);

        TextField textField = includeEdge.getNameCompartment();
        textField.getGraphNode().setVisible(false);

        Utils.updateTextFieldSizeLocation(textField);
        assertFalse("visibility is false expects", textField.isVisible());
    }

    /**
     * <p>
     * Tests {@link Utils#getStereotypeText(String, java.util.Collection)} for accuracy.
     * </p>
     * <p>
     * It verifies this method is correct.
     * </p>
     */
    public void testGetStereotypeText1() {
        assertEquals("getStereotypeText method is incorrect", "",
                Utils.getStereotypeText(null, new ArrayList<Stereotype>()));
    }

    /**
     * <p>
     * Tests {@link Utils#getStereotypeText(String, java.util.Collection)} for accuracy.
     * </p>
     * <p>
     * It verifies this method is correct.
     * </p>
     */
    public void testGetStereotypeText2() {
        assertEquals("getStereotypeText method is incorrect", "<<include>>",
                Utils.getStereotypeText("include", null));
    }

    /**
     * <p>
     * Tests {@link Utils#getStereotypeText(String, java.util.Collection)} for accuracy.
     * </p>
     * <p>
     * It verifies this method is correct.
     * </p>
     */
    public void testGetStereotypeText3() {
        assertEquals("getStereotypeText method is incorrect", "<<Extend>>",
                Utils.getStereotypeText("Extend", new ArrayList<Stereotype>()));
    }

    /**
     * <p>
     * Tests {@link Utils#getStereotypeText(String, java.util.Collection)} for accuracy.
     * </p>
     * <p>
     * It verifies this method is correct.
     * </p>
     */
    public void testGetStereotypeText4() {
        Collection<Stereotype> stereotypes = new ArrayList<Stereotype>();

        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("interface");
        stereotypes.add(stereotype);

        stereotype = new StereotypeImpl();
        stereotype.setName("stakeholder");
        stereotypes.add(stereotype);

        assertEquals("getStereotypeText method is incorrect", "<<include, interface, stakeholder>>",
                Utils.getStereotypeText("include", stereotypes));
    }

    /**
     * <p>
     * Tests {@link Utils#getStereotypeText(String, java.util.Collection)} for accuracy.
     * </p>
     * <p>
     * It verifies this method is correct.
     * </p>
     */
    public void testGetStereotypeText5() {
        Collection<Stereotype> stereotypes = new ArrayList<Stereotype>();

        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("interface");
        stereotypes.add(stereotype);

        stereotype = new StereotypeImpl();
        stereotype.setName("stakeholder");
        stereotypes.add(stereotype);

        assertEquals("getStereotypeText method is incorrect", "<<interface, stakeholder>>",
                Utils.getStereotypeText(null, stereotypes));
    }

    /**
     * <p>
     * Tests {@link Utils#getStereotypeText(String, java.util.Collection)} for accuracy.
     * </p>
     * <p>
     * It verifies this method is correct.
     * </p>
     */
    public void testGetStereotypeText6() {
        assertEquals("getStereotypeText method is incorrect", "", Utils.getStereotypeText(null, null));
    }
}