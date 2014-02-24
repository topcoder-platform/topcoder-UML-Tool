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
 * Unit tests on class <code>AbstractPasteGraphElementAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class AbstractPasteGraphElementActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>DummyAbstractCutGraphElementAction</code> used in this test.
     * </p>
     */
    private DummyAbstractPasteGraphElementAction action;

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

        this.action = new DummyAbstractPasteGraphElementAction(this.name, this.node, this.parent);
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
     * Test constructor <code>AbstractPasteGraphElementAction(String name, Object content, GraphNode parent)</code>
     * for failure with null name, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullName() {
        try {
            new DummyAbstractPasteGraphElementAction(null, this.node, this.parent);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AbstractPasteGraphElementAction(String name, Object content, GraphNode parent)</code>
     * for failure with empty name, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_EmptyName() {
        try {
            new DummyAbstractPasteGraphElementAction("  ", this.node, this.parent);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AbstractPasteGraphElementAction(String name, Object content, GraphNode parent)</code>
     * for failure with null content, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullContent() {
        try {
            new DummyAbstractPasteGraphElementAction(this.name, null, this.parent);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AbstractPasteGraphElementAction(String name, Object content, GraphNode parent)</code>
     * for failure with illegal content(not GraphElement type), <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_IllegalContent() {
        try {
            new DummyAbstractPasteGraphElementAction(this.name, "String", this.parent);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AbstractPasteGraphElementAction(String name, Object content, GraphNode parent)</code>
     * for failure with null parent, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullParent() {
        try {
            new DummyAbstractPasteGraphElementAction(this.name, this.node, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AbstractPasteGraphElementAction(String name, Object content, GraphNode parent)</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
            new DummyAbstractPasteGraphElementAction(this.name, this.node, this.parent));
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
        assertEquals("Failed to execute the action!", 1, containeds.size());
        assertEquals("Failed to execute the action!", this.node, containeds.get(0));
        assertEquals("Failed to execute the action!", this.parent, this.node.getContainer());
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
        assertEquals("Failed to execute the action!", 1, containeds.size());
        assertEquals("Failed to execute the action!", this.node, containeds.get(0));
        assertEquals("Failed to execute the action!", this.parent, this.node.getContainer());

        // undo the action
        this.action.undo();
        containeds = this.parent.getContaineds();
        assertTrue("Failed to undo the action!", containeds.isEmpty());
        assertNull("Failed to undo the action!", this.node.getContainer());
    }

    /**
     * <p>
     * Dummy implementation of <code>AbstractPasteGraphElementAction</code>,
     * it is used for testing.
     * </p>
     * @version 1.0
     * @author TCSDEVELOPER
     */
    private static final class DummyAbstractPasteGraphElementAction extends AbstractPasteGraphElementAction {
        /**
         * <p>
         * Create a new <code>DummyAbstractPasteGraphElementAction</code> with the given
         * presentation name, the content to paste and the graph node to
         * which the content to paste to.
         * </p>
         * @param name
         *            the presentation name of the action.
         * @param content
         *            the child graph element to paste.
         * @param parent
         *            the parent graph node the child graph element to add to.
         * @throws IllegalArgumentException If any argument is null, or name is empty string,
         *              or the content is not of <code>GraphElement</code> type.
         */
        public DummyAbstractPasteGraphElementAction(String name, Object content, GraphNode parent) {
            super(name, content, parent);
        }

    }

}
