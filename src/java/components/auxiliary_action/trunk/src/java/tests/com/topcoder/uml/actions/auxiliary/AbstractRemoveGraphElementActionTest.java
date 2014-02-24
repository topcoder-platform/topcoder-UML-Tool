/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import java.util.List;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Unit tests on class <code>AbstractRemoveGraphElementAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class AbstractRemoveGraphElementActionTest extends TestCase {

    /**
     * <p>
     * Instance of <code>DummyAbstractRemoveGraphElementAction</code> used in this test.
     * </p>
     */
    private DummyAbstractRemoveGraphElementAction action;

    /**
     * <p>
     * Instance of <code>GraphElement</code> used in this test.
     */
    private GraphElement child;

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
        this.child = new GraphNode();
        this.parent = new GraphNode();
        // set up the contained relationship
        this.parent.addContained(this.child);
        this.child.setContainer(this.parent);
        this.action = new DummyAbstractRemoveGraphElementAction(this.name, this.child);
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
     * Test constructor <code>DummyAbstractRemoveGraphElementAction(String name, GraphElement node)</code>
     * for failure with null name, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullName() {
        try {
            new DummyAbstractRemoveGraphElementAction(null, this.child);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>DummyAbstractRemoveGraphElementAction(String name, GraphElement node)</code>
     * for failure with empty name, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_EmptyName() {
        try {
            new DummyAbstractRemoveGraphElementAction("  ", this.child);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>DummyAbstractRemoveGraphElementAction(String name, GraphElement node)</code>
     * for failure with null node, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullNode() {
        try {
            new DummyAbstractRemoveGraphElementAction(this.name, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>DummyAbstractRemoveGraphElementAction(String name, GraphElement node)</code>
     * for failure with node without container, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NodeWithoutContainer() {
        try {
            new DummyAbstractRemoveGraphElementAction(this.name, new GraphNode());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>DummyAbstractRemoveGraphElementAction(String name, GraphElement node)</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new DummyAbstractRemoveGraphElementAction(this.name, this.child));
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
        assertNull("Failed to execute the action!", this.child.getContainer());
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
        assertNull("Failed to execute the action!", this.child.getContainer());

        // undo the action
        this.action.undo();
        containeds = this.parent.getContaineds();
        assertEquals("Failed to undo the action!", 1, containeds.size());
        assertEquals("Failed to undo the action!", this.child, containeds.get(0));
        assertEquals("Failed to undo the action!", this.parent, this.child.getContainer());
    }
    /**
     * <p>
     * Dummy implementation of <code>AbstractRemoveGraphElementAction</code>, it is used for testing.
     * </p>
     * @version 1.0
     * @author TCSDEVELOPER
     */
    private static final class DummyAbstractRemoveGraphElementAction extends AbstractRemoveGraphElementAction {
        /**
         * <p>
         * Create a new <code>DummyAbstractRemoveGraphElementAction</code> with given
         * presentation name and the graph element to remove.
         * </p>
         * @param name
         *            the presentation name of the undoable action.
         * @param node
         *            the child graph element to remove from its parent graph node.
         * @throws IllegalArgumentException If any argument is null, or name is empty string,
         *      or node's container is null.
         */
        public DummyAbstractRemoveGraphElementAction(String name, GraphElement node) {
            super(name, node);
        }
    }
}
