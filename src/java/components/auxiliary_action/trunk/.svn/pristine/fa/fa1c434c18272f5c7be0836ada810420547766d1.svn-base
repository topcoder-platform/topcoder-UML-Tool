/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import java.util.List;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Unit tests on class <code>AbstractAddGraphElementAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class AbstractAddGraphElementActionTest extends TestCase {

    /**
     * <p>
     * Instance of <code>DummyAbstractAddGraphElementAction</code> used in this test.
     * </p>
     */
    private DummyAbstractAddGraphElementAction action;

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
     * Instance of <code>UMLModelManager</code> used in this test.
     */
    private UMLModelManager manager;

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
        manager = UMLModelManager.getInstance();
        manager.getModel().setNamespace(new PackageImpl());
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
        manager.setProjectLanguage("Java");
        this.action = new DummyAbstractAddGraphElementAction(this.name, this.child, this.parent, this.manager);
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
     * Test constructor <code>AbstractAddGraphElementAction(String name, GraphElement child, GraphNode parent,
     * UMLModelManager modelManager)</code> for failure with null name, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testCtor_NullName() {
        try {
            new DummyAbstractAddGraphElementAction(null, this.child, this.parent, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AbstractAddGraphElementAction(String name, GraphElement child, GraphNode parent,
     * UMLModelManager modelManager)</code> for failure with empty name, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testCtor_EmptyName() {
        try {
            new DummyAbstractAddGraphElementAction("  ", this.child, this.parent, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AbstractAddGraphElementAction(String name, GraphElement child, GraphNode parent,
     * UMLModelManager modelManager)</code> for failure with null child, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testCtor_NullChild() {
        try {
            new DummyAbstractAddGraphElementAction(this.name, null, this.parent, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AbstractAddGraphElementAction(String name, GraphElement child, GraphNode parent,
     * UMLModelManager modelManager)</code> for failure with null parent, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testCtor_NullParent() {
        try {
            new DummyAbstractAddGraphElementAction(this.name, this.child, null, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AbstractAddGraphElementAction(String name, GraphElement child, GraphNode parent,
     * UMLModelManager modelManager)</code> for failure with null manager, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testCtor_NullManager() {
        try {
            new DummyAbstractAddGraphElementAction(this.name, this.child, this.parent, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AbstractAddGraphElementAction(String name, GraphElement child, GraphNode parent,
     * UMLModelManager modelManager)</code> for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new DummyAbstractAddGraphElementAction(this.name, this.child, this.parent, this.manager));
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
        assertEquals("Failed to execute the action!", this.child, containeds.get(0));
        assertEquals("Failed to execute the action!", this.parent, this.child.getContainer());
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
        assertEquals("Failed to execute the action!", this.child, containeds.get(0));
        assertEquals("Failed to execute the action!", this.parent, this.child.getContainer());

        // undo the action
        this.action.undo();
        containeds = this.parent.getContaineds();
        assertTrue("Failed to undo the action!", containeds.isEmpty());
        assertNull("Failed to undo the action!", this.child.getContainer());
    }
    /**
     * <p>
     * Dummy implementation of <code>AbstractAddGraphElementAction</code>, it is used for testing.
     * </p>
     * @version 1.0
     * @author TCSDEVELOPER
     */
    private static final class DummyAbstractAddGraphElementAction extends AbstractAddGraphElementAction {
        /**
         * <p>
         * Create a new <code>DummyAbstractAddGraphElementAction</code> with the given presentation
         * name, the child graph element to add, the parent graph node and the UML model manager.
         * </p>
         * @param name
         *            the presentation name of the action
         * @param child
         *            the child graph element to add to the parent graph node
         * @param parent
         *            the parent graph node the child graph element to add to
         * @param modelManager
         *            the UMLModelManager object to apply initial formatting.
         * @throws IllegalArgumentException If any argument is null, or name is empty string.
         */
        public DummyAbstractAddGraphElementAction(String name, GraphElement child, GraphNode parent,
                UMLModelManager modelManager) {
            super(name, child, parent, modelManager);
        }
    }
}
