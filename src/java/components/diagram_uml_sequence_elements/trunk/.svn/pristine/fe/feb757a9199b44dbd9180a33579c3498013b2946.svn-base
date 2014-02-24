/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;

import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNodePropertyType;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link ObjectNode}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class ObjectNodeFailureTests extends TestCase {
    /**
     * <p>
     * Represents the ObjectNode instance.
     * </p>
     */
    private ObjectNode objectNode;

    /**
     * <p>
     * Represents Object instance.
     * </p>
     */
    private Object object;

    /**
     * <p>
     * Represents GraphConnector instance.
     * </p>
     */
    private GraphConnector graphConnector;

    /**
     * <p>
     * Represents GraphNode instance.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * Represents Point instance.
     * </p>
     */
    private Point position;

    /**
     * <p>
     * Represents Rectangle instance.
     * </p>
     */
    private Rectangle bound;

    /**
     * <p>
     * Represents The corners collection.
     * </p>
     */
    private Collection<SelectionCornerType> corners;

    /**
     * <p>
     * Represents The propertyNameMapping map.
     * </p>
     */
    private EnumMap<ObjectNodePropertyType, String> propertyNameMapping;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        propertyNameMapping = new EnumMap<ObjectNodePropertyType, String>(ObjectNodePropertyType.class);
        propertyNameMapping.put(ObjectNodePropertyType.FILL_COLOR, "red");
        corners = FailureTestHelper.createSelectionCorner();
        bound = new Rectangle();
        position = new Point();
        graphNode = FailureTestHelper.createGraphNode();
        graphConnector = new GraphConnector();
        object = new ObjectImpl();
        object.setName("name");
        objectNode = new ObjectNode(object, graphConnector, graphNode, position, bound, corners, propertyNameMapping);
    }

    /**
     * <p>
     * Assertion the construction of <code>ObjectNode</code> instance.
     * </p>
     */
    private void assertObjectNodeCtor() {
        try {
            new ObjectNode(object, graphConnector, graphNode, position, bound, corners, propertyNameMapping);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link ObjectNode#ObjectNode(Object, GraphConnector, GraphNode, Point, Rectangle, Collection, EnumMap)}</code>
     * constructor.
     * </p>
     */
    public void testObjectNode_NullObject() {
        object = null;

        assertObjectNodeCtor();
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link ObjectNode#ObjectNode(Object, GraphConnector, GraphNode, Point, Rectangle, Collection, EnumMap)}</code>
     * constructor.
     * </p>
     */
    public void testObjectNode_NullGraphConnector() {
        graphConnector = null;

        assertObjectNodeCtor();
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link ObjectNode#ObjectNode(Object, GraphConnector, GraphNode, Point, Rectangle, Collection, EnumMap)}</code>
     * constructor.
     * </p>
     */
    public void testObjectNode_NullGraphNode() {
        graphNode = null;

        assertObjectNodeCtor();
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link ObjectNode#ObjectNode(Object, GraphConnector, GraphNode, Point, Rectangle, Collection, EnumMap)}</code>
     * constructor.
     * </p>
     */
    public void testObjectNode_NullPosition() {
        position = null;

        assertObjectNodeCtor();
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link ObjectNode#ObjectNode(Object, GraphConnector, GraphNode, Point, Rectangle, Collection, EnumMap)}</code>
     * constructor.
     * </p>
     */
    public void testObjectNode_NullBound() {
        bound = null;

        assertObjectNodeCtor();
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link ObjectNode#ObjectNode(Object, GraphConnector, GraphNode, Point, Rectangle, Collection, EnumMap)}</code>
     * constructor.
     * </p>
     */
    public void testObjectNode_NullCorners() {
        corners = null;

        assertObjectNodeCtor();
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link ObjectNode#ObjectNode(Object, GraphConnector, GraphNode, Point, Rectangle, Collection, EnumMap)}</code>
     * constructor.
     * </p>
     */
    public void testObjectNode_NullPropertyNameMapping() {
        propertyNameMapping = null;

        assertObjectNodeCtor();
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link ObjectNode#ObjectNode(Object, GraphConnector, GraphNode, Point, Rectangle, Collection, EnumMap)}</code>
     * constructor.
     * </p>
     */
    public void testObjectNode_EmptyPropertyNameMapping() {
        propertyNameMapping.clear();

        assertObjectNodeCtor();
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setName(String)}</code> method.
     * </p>
     */
    public void testSetName_NullName() {
        try {
            objectNode.setName(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setStrokeColor(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetStrokeColor_NullColor() {
        try {
            objectNode.setStrokeColor(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setFillColor(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetFillColor_NullColor() {
        try {
            objectNode.setFillColor(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setFillColor2(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetFillColor2_NullColor() {
        try {
            objectNode.setFillColor2(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setShadowColor(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetShadowColor_NullColor() {
        try {
            objectNode.setShadowColor(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setFontColor(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetFontColor_NullColor() {
        try {
            objectNode.setFontColor(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setFontFamily(String)}</code> method.
     * </p>
     */
    public void testSetFontFamily_NullFontFamily() {
        try {
            objectNode.setFontFamily(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setFontFamily(String)}</code> method.
     * </p>
     */
    public void testSetFontFamily_EmptyFontFamily() {
        try {
            objectNode.setFontFamily("");
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setFontFamily(String)}</code> method.
     * </p>
     */
    public void testSetFontFamily_TrimmedEmptyFontFamily() {
        try {
            objectNode.setFontFamily("  ");
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setPosition(Point)}</code> method.
     * </p>
     */
    public void testSetPosition_NullPosition() {
        try {
            objectNode.setPosition(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setRoundingRadius(int)}</code> method.
     * </p>
     */
    public void testSetRoundingRadius_NegativeRadius() {
        try {
            objectNode.setRoundingRadius(-1);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setShadowLength(int)}</code> method.
     * </p>
     */
    public void testSetShadowLength_NegativeLength() {
        try {
            objectNode.setShadowLength(-1);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setPopup(javax.swing.JPopupMenu)}</code> method.
     * </p>
     */
    public void testSetPopup_NullPopup() {
        try {
            objectNode.setPopup(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#applyNewName(String, String)}</code> method.
     * </p>
     */
    public void testApplyNewName_NullOldName() {
        try {
            objectNode.applyNewName(null, "Name");
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#applyNewName(String, String)}</code> method.
     * </p>
     */
    public void testApplyNewName_NullNewName() {
        try {
            objectNode.applyNewName("Name", null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setPropertyNameMappingElement(ObjectNodePropertyType, String)}</code>
     * method.
     * </p>
     */
    public void testSetPropertyNameMappingElement_NullKey() {
        try {
            objectNode.setPropertyNameMappingElement(null, "Value");
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setPropertyNameMappingElement(ObjectNodePropertyType, String)}</code>
     * method.
     * </p>
     */
    public void testSetPropertyNameMappingElement_NullValue() {
        try {
            objectNode.setPropertyNameMappingElement(ObjectNodePropertyType.FILL_COLOR, null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setPropertyNameMappingElement(ObjectNodePropertyType, String)}</code>
     * method.
     * </p>
     */
    public void testSetPropertyNameMappingElement_EmptyValue() {
        try {
            objectNode.setPropertyNameMappingElement(ObjectNodePropertyType.FILL_COLOR, "");
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setPropertyNameMappingElement(ObjectNodePropertyType, String)}</code>
     * method.
     * </p>
     */
    public void testSetPropertyNameMappingElement_TrimmedEmptyValue() {
        try {
            objectNode.setPropertyNameMappingElement(ObjectNodePropertyType.FILL_COLOR, " ");
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setFontSize(int)}</code> method.
     * </p>
     */
    public void testSetFontSize_zeroSize() {
        try {
            objectNode.setFontSize(0);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ObjectNode#setFontSize(int)}</code> method.
     * </p>
     */
    public void testSetFontSize_NegateiveSize() {
        try {
            objectNode.setFontSize(-1);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}