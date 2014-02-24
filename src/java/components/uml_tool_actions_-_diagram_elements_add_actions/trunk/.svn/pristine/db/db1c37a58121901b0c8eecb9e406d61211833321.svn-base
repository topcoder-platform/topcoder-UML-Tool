/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateSizeAction;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>UpdateSizeAction </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestUpdateSizeActionAccuracy extends TestCase {

    /**
     * Test the constructor.
     *
     */
    public void testUpdateSizeAction() {
        GraphNode node = HelperUtil.createGraphNodeInstance();

        Dimension d = new Dimension();
        d.setWidth(new Double(10));
        d.setHeight(new Double(100));

        UpdateSizeAction action = new UpdateSizeAction(node, d);
        assertNotNull("The UpdateSizeAction should be created.", action);
    }

    /**
     * Test the update size functionality.
     *
     * @throws Exception
     *             to junit.
     */
    public void testExecute_1() throws Exception {
        GraphNode node = HelperUtil.createGraphNodeInstance();

        Dimension d = new Dimension();
        d.setWidth(new Double(10));
        d.setHeight(new Double(100));

        UpdateSizeAction action = new UpdateSizeAction(node, d);
        assertNotNull("The UpdateSizeAction should be created.", action);

        // update the size.

        action.execute();

        Dimension size = ((GraphNode) action.getElement()).getSize();
        assertEquals("The height should be 100.", 100.0, size.getHeight());
        assertEquals("The width should be 10", 10.0, size.getWidth());

    }

    /**
     * Test the update size functionality.
     *
     * @throws Exception
     *             to junit.
     */
    public void testExecute_2() throws Exception {
        GraphNode node = HelperUtil.createGraphNodeInstance();

        Dimension d = new Dimension();

        UpdateSizeAction action = new UpdateSizeAction(node, d);
        assertNotNull("The UpdateSizeAction should be created.", action);

        // update the size.

        action.execute();

        Dimension size = ((GraphNode) action.getElement()).getSize();
        assertEquals("The height should be 0.", 0.0, size.getHeight());
        assertEquals("The width should be 0.", 0.0, size.getWidth());
    }

    /**
     * Test the update size functionality.
     *
     * @throws Exception
     *             to junit.
     */
    public void testExecute_3() throws Exception {
        GraphNode node = HelperUtil.createGraphNodeInstance();

        Dimension d = new Dimension();
        d.setHeight(new Double(1));

        UpdateSizeAction action = new UpdateSizeAction(node, d);
        assertNotNull("The UpdateSizeAction should be created.", action);

        // update the size.

        action.execute();

        Dimension size = ((GraphNode) action.getElement()).getSize();
        assertEquals("The height should be 1.", 1.0, size.getHeight());
        assertEquals("The width should be 0.", 0.0, size.getWidth());
    }

    /**
     * Test the update size functionality.
     *
     * @throws Exception
     *             to junit.
     */
    public void testExecute_4() throws Exception {
        GraphNode node = HelperUtil.createGraphNodeInstance();

        Dimension d = new Dimension();
        d.setWidth(new Double(1));

        UpdateSizeAction action = new UpdateSizeAction(node, d);
        assertNotNull("The UpdateSizeAction should be created.", action);

        // update the size.

        action.execute();

        Dimension size = ((GraphNode) action.getElement()).getSize();
        assertEquals("The width should be 1.", 1.0, size.getWidth());
        assertEquals("The height should be 0.", 0.0, size.getHeight());
    }

    /**
     * Test method undo.
     *
     * @throws Exception
     *             to junit.
     */
    public void testUndo() throws Exception {
        GraphNode node = HelperUtil.createGraphNodeInstance();

        assertNull("The size should be null.", node.getSize());

        Dimension d = new Dimension();
        d.setWidth(new Double(10));
        d.setHeight(new Double(100));

        UpdateSizeAction action = new UpdateSizeAction(node, d);
        assertNotNull("The UpdateSizeAction should be created.", action);

        // update the size.

        action.execute();

        Dimension size = ((GraphNode) action.getElement()).getSize();
        assertEquals("The height should be 100.", 100.0, size.getHeight());
        assertEquals("The width should be 10", 10.0, size.getWidth());

        action.undo();

        assertNull("After undo the size should be null.", ((GraphNode) action.getElement()).getSize());
    }

    /**
     * Test method redo.
     *
     * @throws Exception
     *             to junit.
     */
    public void testRedo() throws Exception {
        GraphNode node = HelperUtil.createGraphNodeInstance();

        assertNull("The size should be null.", node.getSize());

        Dimension d = new Dimension();
        d.setWidth(new Double(10));
        d.setHeight(new Double(100));

        UpdateSizeAction action = new UpdateSizeAction(node, d);
        assertNotNull("The UpdateSizeAction should be created.", action);

        // update the size.

        action.execute();

        Dimension size = ((GraphNode) action.getElement()).getSize();
        assertEquals("The height should be 100.", 100.0, size.getHeight());
        assertEquals("The width should be 10", 10.0, size.getWidth());
        // undo.
        action.undo();

        assertNull("After undo the size should be null.", ((GraphNode) action.getElement()).getSize());

        // redo
        action.redo();

        size = ((GraphNode) action.getElement()).getSize();
        assertEquals("The height should be 100.", 100.0, size.getHeight());
        assertEquals("The width should be 10", 10.0, size.getWidth());
    }
}