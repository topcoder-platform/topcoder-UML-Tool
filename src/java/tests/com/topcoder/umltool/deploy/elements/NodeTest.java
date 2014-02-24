/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.elements;

import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Tests for adding, removing, and persistence for node.
 * </p>
 *
 * @author ly
 * @version 1.0
 */
public abstract class NodeTest extends TestCase {

    /**
     * <p>
     * Node to test.
     * </p>
     */
    private Node node;

    /**
     * <p>
     * The node type.
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
        node = TestHelper.addNode(view, type, new Point(100, 100));
    }

    /**
     * <p>
     * Tests the adding of element. The element should have been added successfully.
     * </p>
     */
    public void testAdd() {
        assertNotNull(type.getName() + " should have been added to diagram", node);
        TestHelper.selectAll();
        TestHelper.deleteSelectedElements();
    }

    /**
     * <p>
     * Tests the deletion of element. The element should have been removed successfully.
     * </p>
     */
    public void testRemove() {
        TestHelper.deleteSelectedElements();
        assertNull(type.getName() + " should have been removed from diagram.", node.getParent());
    }

    /**
     * <p>
     * Tests the functionality of copy/paste for specified element. A new element should have been pasted
     * correctly.
     * </p>
     */
    public void testCopyPaste() {
        int count = node.getParent().getComponentCount();

        TestHelper.copySelectedElements();

        TestHelper.pasteElements();

        assertEquals(type.getName() + " should have been pasted. ", node.getParent().getComponentCount(),
            count + 1);
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

        assertTrue(type.getName() + " should have been loaded.", TestHelper.findElement(node));

        TestHelper.restoreMainFrame();
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
}
