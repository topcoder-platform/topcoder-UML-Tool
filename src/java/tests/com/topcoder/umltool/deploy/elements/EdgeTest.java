/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.elements;

import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.CreateMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SendSignalMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SynchronousMessageEdge;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Tests for adding, removing, and persistence for edge.
 * </p>
 *
 * @author ly
 * @version 1.0
 */
public abstract class EdgeTest extends TestCase {

    /**
     * <p>
     * Start node for edge.
     * </p>
     */
    private Node startNode;

    /**
     * <p>
     * End node for edge.
     * </p>
     */
    private Node endNode;

    /**
     * <p>
     * Edge for testing.
     * </p>
     */
    private Edge edge;

    /**
     * <p>
     * The type of start node.
     * </p>
     */
    private Class<?> startNodetype;

    /**
     * <p>
     * The type of end node.
     * </p>
     */
    private Class<?> endNodetype;

    /**
     * <p>
     * The type of edge.
     * </p>
     */
    private Class<?> type;

    /**
     * <p>
     * The diagram type.
     * </p>
     */
    private DiagramType diagramType;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        DiagramView view = TestHelper.getDiagramView(diagramType);
        startNode = TestHelper.addNode(view, startNodetype, new Point(50, 50));
        endNode = TestHelper.addNode(view, endNodetype, new Point(300, 300));
        edge = TestHelper.addEdge(view, type, startNode, endNode);
    }

    /**
     * <p>
     * Tests the adding of element. The element should have been added successfully.
     * </p>
     */
    public void testAdd() {
        assertNotNull(type.getName() + " should have been added to diagram", edge);
        TestHelper.selectAll();
        TestHelper.deleteSelectedElements();
    }

    /**
     * <p>
     * Tests the deletion of element. The element should have been removed successfully.
     * </p>
     */
    public void testRemove() {
        TestHelper.selectAll();
        TestHelper.deleteSelectedElements();
        assertNull(type.getName() + " should have been removed from diagram.", edge.getParent());
    }

    /**
     * <p>
     * Tests the functionality of copy/paste for specified element. A new element should have been pasted
     * correctly.
     * </p>
     */
    public void testCopyPaste() {
        int count = edge.getParent().getComponentCount();

        TestHelper.clearSelected();

        TestHelper.selectAll();

        TestHelper.copySelectedElements();

        TestHelper.pasteElements();

        if (type.equals(SynchronousMessageEdge.class) || type.equals(CreateMessageEdge.class)
            || type.equals(SendSignalMessageEdge.class)) {
            assertEquals(type.getName() + " should have been pasted. ", edge.getParent().getComponentCount(),
                count + 4);
        } else {
            assertEquals(type.getName() + " should have been pasted. ", edge.getParent().getComponentCount(),
                count + 3);
        }
    }

    /**
     * <p>
     * Tests the persistence for specified element. The element should have been loaded correctly.
     * </p>
     */
    public void testPersitence() {
        try {
            TestHelper.save();
            TestHelper.load();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }

        assertTrue(type.getName() + " should have been loaded.", TestHelper.findElement(edge));

        TestHelper.restoreMainFrame();
    }

    /**
     * <p>
     * Setter for diagram type.
     * </p>
     *
     * @param type
     *            diagram type
     */
    public void setDiagramType(DiagramType type) {
        this.diagramType = type;
    }

    /**
     * <p>
     * Setter for start node type.
     * </p>
     *
     * @param type
     *            start node type
     */
    public void setStartNodetype(Class<?> startNodetype) {
        this.startNodetype = startNodetype;
    }

    /**
     * <p>
     * Setter for end node type.
     * </p>
     *
     * @param type
     *            end node type
     */
    public void setEndNodetype(Class<?> endNodetype) {
        this.endNodetype = endNodetype;
    }

    /**
     * <p>
     * Setter for node type.
     * </p>
     *
     * @param type
     *            node type
     */
    public void setType(Class<?> type) {
        this.type = type;
    }
}
