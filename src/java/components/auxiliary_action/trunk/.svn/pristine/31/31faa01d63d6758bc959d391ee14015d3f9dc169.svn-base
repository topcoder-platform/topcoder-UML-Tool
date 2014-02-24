/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AbstractCutGraphElementAction;

/**
 * <p>
 * Set of accuracy tests for AbstractCutGraphElementAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AbstractCutGraphElementActionAccuracyTest extends TestCase {

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
     * Instance of Clipboard for testing.
     */
    private Clipboard clipboard;

    /**
     * Instance of AbstractCutGraphElementAction for testing.
     */
    private AbstractCutGraphElementAction abstractAddGraphElementAction;

    /**
     * Setting up environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        child = new GraphElement() {
        };
        parent = new GraphNode();
        child.setContainer(parent);
        parent.addContained(child);
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        abstractAddGraphElementAction = new AbstractCutGraphElementAction(name, child, clipboard) {
            protected void copyToClipboard(GraphElement node, Clipboard clipboard) {
            }
        };
    }

    /**
     * Constructor under test AbstractCutGraphElementAction(String,
     * GraphElement, GraphNode, UMLModelManager). Accuracy testing of correctly
     * assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testAbstractCutGraphElementAction() throws Exception {
        AbstractCutGraphElementAction currentAbstractCutGraphElementAction =
            new AbstractCutGraphElementAction(name, child, clipboard) {
                protected void copyToClipboard(GraphElement node, Clipboard clipboard) {
                }
            };
        assertSame("names must be the same", name, currentAbstractCutGraphElementAction.getPresentationName());
    }

    /**
     * Method under test AbstractCutGraphElementAction.execute(). Accuracy
     * testing of correct execution.
     * @throws Exception wraps all exceptions
     */
    public final void testExecute() throws Exception {
        // run successfully
        abstractAddGraphElementAction.execute();
        assertFalse("parent must not contain child", parent.containsContained(child));
        assertNull("child must not contain parent", child.getContainer());
    }

    /**
     * Method under test AbstractCutGraphElementAction.execute(). Accuracy
     * testing of correct undo.
     */
    public final void testUndo() {
        // run successfully
        abstractAddGraphElementAction.undo();
        assertTrue("child must be added to parent", parent.containsContained(child));
        assertSame("parent must contain child", parent, child.getContainer());
    }

    /**
     * Tearing down environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.clearConfiguration();
    }
}