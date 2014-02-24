/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import java.awt.datatransfer.Clipboard;
import java.util.List;

import javax.swing.undo.CannotRedoException;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Unit tests on class <code>AbstractCutGraphElementAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class AbstractCutGraphElementActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>DummyAbstractCutGraphElementAction</code> used in this test.
     * </p>
     */
    private DummyAbstractCutGraphElementAction action;

    /**
     * <p>
     * Instance of <code>GraphElement</code> used in this test.
     */
    private GraphElement node;

    /**
     * <p>
     * Instance of <code>GraphNode</code> used in this test.
     */
    private GraphNode parent;

    /**
     * <p>
     * Action name.
     * </p>
     */
    private String name;
    /**
     * <p>
     * Set up environment.
     * </p>
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        UnitTestHelper.loadConfig(UnitTestHelper.CONFIG_FILE);
        this.name = "Action";
        this.node = new GraphNode();
        this.parent = new GraphNode();
        // set up the contained relationship
        this.parent.addContained(this.node);
        this.node.setContainer(this.parent);
        this.action = new DummyAbstractCutGraphElementAction(this.name, this.node, null);
    }

    /**
     * <p>
     * Clear the environment.
     * </p>
     */
    public void tearDown() {
        UnitTestHelper.clearConfig();
    }

    /**
     * <p>
     * Test constructor <code>AbstractCutGraphElementAction(String name, GraphElement node, Clipboard clipboard)
     * </code> for failure with null name, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullName() {
        try {
            new DummyAbstractCutGraphElementAction(null, this.node, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AbstractCutGraphElementAction(String name, GraphElement node, Clipboard clipboard)
     * </code> for failure with empty name, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_EmptyName() {
        try {
            new DummyAbstractCutGraphElementAction("  ", this.node, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AbstractCutGraphElementAction(String name, GraphElement node, Clipboard clipboard)
     * </code> for failure with null node, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullNode() {
        try {
            new DummyAbstractCutGraphElementAction(this.name, null, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AbstractCutGraphElementAction(String name, GraphElement node, Clipboard clipboard)
     * </code> for failure with node without container, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NodeWithoutContainer() {
        try {
            new DummyAbstractCutGraphElementAction(this.name, new GraphNode(), null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AbstractCutGraphElementAction(String name, GraphElement node, Clipboard clipboard)
     * </code> for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new DummyAbstractCutGraphElementAction(this.name, this.node, null));
    }

    /**
     * <p>
     * Test method <code>execute()</code> for accuracy.
     * </p>
     * @throws ActionExecutionException to JUnit
     */
    public void testExecute() throws ActionExecutionException {
        // execute the action
        this.action.execute();
        List<DiagramElement> containeds = this.parent.getContaineds();
        assertTrue("Failed to execute the action!", containeds.isEmpty());
        assertNull("Failed to execute the action!", this.node.getContainer());
        assertTrue("Failed to execute the action!", this.action.isCopied());
    }

    /**
     * <p>
     * Test method <code>undo()</code> for accuracy.
     * </p>
     * @throws ActionExecutionException to JUnit
     */
    public void testUndo() throws ActionExecutionException {
        // execute the action
        this.action.execute();
        List<DiagramElement> containeds = this.parent.getContaineds();
        assertTrue("Failed to execute the action!", containeds.isEmpty());
        assertNull("Failed to execute the action!", this.node.getContainer());
        assertTrue("Failed to execute the action!", this.action.isCopied());

        // undo the action
        this.action.undo();
        containeds = this.parent.getContaineds();
        assertEquals("Failed to undo the action!", 1, containeds.size());
        assertEquals("Failed to undo the action!", this.node, containeds.get(0));
        assertEquals("Failed to undo the action!", this.parent, this.node.getContainer());
        assertFalse("Failed to execute the action!", this.action.isCopied());
    }
    /**
     * <p>
     * Dummy implementation of <code>AbstractCutGraphElementAction</code>, it is used for testing.
     * </p>
     * @version 1.0
     * @author TCSDEVELOPER
     */
    private static final class DummyAbstractCutGraphElementAction extends AbstractCutGraphElementAction {
        /**
         * <p>
         * Indicates if the node is copied to the clipboard.
         * </p>
         */
        private boolean isCopied = false;
        /**
         * <p>
         * Create a new <code>DummyAbstractCutGraphElementAction</code> with given
         * presentation name, the child graph element to cut, and the clipboard
         * to which the child graph element is copied to.
         * </p>
         * @param name
         *            the presentation name of the action
         * @param node
         *            the child graph element to remove from its parent graph node
         * @param clipboard
         *            the clipboard the child graph element is copied to
         * @throws IllegalArgumentException If any argument except clipboard is null, or
         *      name is empty string, or node's container is null.
         */
        public DummyAbstractCutGraphElementAction(String name, GraphElement node, Clipboard clipboard) {
            super(name, node, clipboard);
        }
        /**
         * <p>
         * This method should copy the given graph element to the given clipboard,
         * if the given clipboard is null, use system clipboard instead.
         * </p>
         * @param node
         *            the graph element to copy to clipboard.
         * @param clipboard
         *            the clipboard to copy the graph element to.
         * @throws IllegalArgumentException If the node is null.
         * @throws ActionExecutionException If fail to copy the graph element to the clipboard.
         */
        protected void copyToClipboard(GraphElement node, Clipboard clipboard) throws ActionExecutionException {
            this.isCopied = true;
        }

        /**
         * <p>
         * Undo the action.
         * </p>
         * @throws CannotRedoException If <code>canRedo</code> returns <code>false</code>.
         */
        public void undo() {
            super.undo();
            this.isCopied = false;
        }

        /**
         * <p>
         * Return if the node is copied.
         * </p>
         * @return if the node is copied.
         */
        public boolean isCopied() {
            return this.isCopied;
        }
    }
}
