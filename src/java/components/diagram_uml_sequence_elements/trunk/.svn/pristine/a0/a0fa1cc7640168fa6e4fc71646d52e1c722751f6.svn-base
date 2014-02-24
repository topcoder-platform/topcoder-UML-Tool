/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.stresstests;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.EditNameListener;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNodePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ResizeListener;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SetNameListener;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;

/**
 * Stress test for ObjectNode.
 *
 * @author radium
 * @version 1.0
 */
public class ObjectNodeTestStress extends TestCase {
    /**
     * The max number of items adding to the objectNode.
     */
    private int max = 10000;

    /**
     * <p>
     * ObjectNode instance for testing.
     * </p>
     */
    private ObjectNode objectNode;

    /**
     * <p>
     * Object instance for testing.
     * </p>
     */
    private Object object;

    /**
     * <p>
     * GraphConnector instance for testing.
     * </p>
     */
    private GraphConnector graphConnector;

    /**
     * <p>
     * GraphNode instance for testing.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * Point instance for testing.
     * </p>
     */
    private Point position;

    /**
     * <p>
     * Rectangle instance for testing.
     * </p>
     */
    private Rectangle bound;

    /**
     * <p>
     * The corners collection for testing.
     * </p>
     */
    private Collection<SelectionCornerType> corners;

    /**
     * <p>
     * The propertyNameMapping map for testing.
     * </p>
     */
    private EnumMap<ObjectNodePropertyType, String> propertyNameMapping;

    /**
     * <p>
     * Sets up test environment for testing.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        propertyNameMapping = new EnumMap<ObjectNodePropertyType, String>(ObjectNodePropertyType.class);
        propertyNameMapping.put(ObjectNodePropertyType.FILL_COLOR, "black");
        corners = StressTestsHelper.createSelectionCorner();
        bound = new Rectangle();
        position = new Point();
        graphNode = StressTestsHelper.createGraphNode();
        graphConnector = new GraphConnector();
        object = new ObjectImpl();
        object.setName("name");
        objectNode = new ObjectNode(object, graphConnector, graphNode, position, bound, corners,
            propertyNameMapping);
    }

    /**
     * Test method for addEditNameListener(EditNameListener).
     */
    public void testAddEditNameListener() {
        for (int i = 0; i < this.max; i++) {
            this.objectNode.addEditNameListener(new StressMockEditNameListener());
        }
        assertEquals("Should be equal.", this.max, this.objectNode.getListeners(EditNameListener.class).length);
    }

    /**
     * Test method for addSetNameListener(SetNameListener).
     */
    public void testAddSetNameListener() {
        for (int i = 0; i < this.max; i++) {
            this.objectNode.addSetNameListener(new StressMockSetNameListener());
        }
        assertEquals("Should be equal.", this.max, this.objectNode.getListeners(SetNameListener.class).length);
    }

    /**
     * Test method for addResizeListener(ResizeListener).
     */
    public void testAddResizeListener() {
        for (int i = 0; i < this.max; i++) {
            this.objectNode.addResizeListener(new StressMockResizeListener());
        }
        assertEquals("Should be equal.", this.max, this.objectNode.getListeners(ResizeListener.class).length);
    }

    /**
     * Test method for removeEditNameListener(EditNameListener).
     */
    public void testRemoveEditNameListener() {
        for (int i = 0; i < this.max; i++) {
            EditNameListener et = new StressMockEditNameListener();
            this.objectNode.addEditNameListener(et);
            this.objectNode.removeEditNameListener(et);
        }
        assertEquals("Should be equal.", 0, this.objectNode.getListeners(EditNameListener.class).length);
    }

    /**
     * Test method for removeSetNameListener(SetNameListener).
     */
    public void testRemoveSetNameListener() {
        for (int i = 0; i < this.max; i++) {
            SetNameListener et = new StressMockSetNameListener();
            this.objectNode.addSetNameListener(et);
            this.objectNode.removeSetNameListener(et);
        }
        assertEquals("Should be equal.", 0, this.objectNode.getListeners(SetNameListener.class).length);
    }

    /**
     * Test method for removeResizeListener(ResizeListener).
     */
    public void testRemoveResizeListener() {
        for (int i = 0; i < this.max; i++) {
            ResizeListener et = new StressMockResizeListener();
            this.objectNode.addResizeListener(et);
            this.objectNode.removeResizeListener(et);
        }
        assertEquals("Should be equal.", 0, this.objectNode.getListeners(ResizeListener.class).length);
    }

}
