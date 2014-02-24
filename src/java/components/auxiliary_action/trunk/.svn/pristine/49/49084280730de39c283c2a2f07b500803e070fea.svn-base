/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AbstractAddGraphElementAction;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Set of accuracy tests for AbstractAddGraphElementAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AbstractAddGraphElementActionAccuracyTest extends TestCase {

    /**
     * String for testing.
     */
    private String name = "name";

    /**
     * Instance of GraphElement for testing.
     */
    private GraphElement child;

    /**
     * Instance of GraphNode for testing.
     */
    private GraphNode parent;

    /**
     * Instance of UMLModelManager for testing.
     */
    private UMLModelManager modelManager;

    /**
     * Instance of AbstractAddGraphElementAction for testing.
     */
    private AbstractAddGraphElementAction abstractAddGraphElementAction;

    /**
     * Setting up environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        child = new GraphElement() {
        };
        parent = new GraphNode();
        modelManager = AccuracyTestsHelper.getModelManager();
        abstractAddGraphElementAction = new AbstractAddGraphElementAction(name, child, parent, modelManager) {
        };
    }

    /**
     * Constructor under test AbstractAddGraphElementAction(String,
     * GraphElement, GraphNode, UMLModelManager). Accuracy testing of correctly
     * assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testAbstractAddGraphElementAction() throws Exception {
        AbstractAddGraphElementAction currentAbstractAddGraphElementAction =
            new AbstractAddGraphElementAction(name, child, parent, modelManager) {
            };
        assertSame("names must be the same", name, currentAbstractAddGraphElementAction.getPresentationName());
    }

    /**
     * Method under test AbstractAddGraphElementAction.execute(). Accuracy
     * testing of correct execution.
     * @throws Exception wraps all exceptions
     */
    public final void testExecute() throws Exception {
        // run successfully
        abstractAddGraphElementAction.execute();
        assertTrue("child must be added to parent", parent.containsContained(child));
        assertSame("parent must contain child", parent, child.getContainer());
    }

    /**
     * Method under test AbstractAddGraphElementAction.execute(). Accuracy
     * testing of correct undo.
     */
    public final void testUndo() {
        // run successfully
        abstractAddGraphElementAction.undo();
        assertFalse("parent must not contain child", parent.containsContained(child));
        assertNull("child must not contain parent", child.getContainer());
    }

    /**
     * Tearing down environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.clearConfiguration();
    }
}