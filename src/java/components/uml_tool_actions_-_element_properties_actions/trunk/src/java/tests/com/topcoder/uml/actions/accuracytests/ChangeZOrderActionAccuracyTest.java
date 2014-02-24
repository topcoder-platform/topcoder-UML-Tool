/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.general.ChangeZOrderAction;
import com.topcoder.uml.actions.general.operationtypes.ChangeZOrderOperationType;

/**
 * Accuracy test cases for ChangeZOrderAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class ChangeZOrderActionAccuracyTest extends TestCase {
    /**
     * Represents the ChangeZOrderAction instance used for tests.
     */
    private ChangeZOrderAction instance;

    /**
     * Represents the graph element to change the z-order.
     */
    private GraphElement element;

    /**
     * Represents the old z-order of the graph element before this action performed.
     */
    private int oldZOrder;

    /**
     * Represents the new z-order of the graph element after this action performed.
     */
    private int newZOrder;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        AccuracyHelper.loadDefaultConfig();
        oldZOrder = 0;
        newZOrder = 1;
        element = new GraphNode();
        GraphElement node = new GraphNode();
        element.setContainer(node);
        node.addContained(element);
        node.addContained(new GraphNode());
        instance = new ChangeZOrderAction(element, ChangeZOrderOperationType.FORWARD);
    }

    /**
     * Clear the environment.
     */
    protected void tearDown() {
        AccuracyHelper.unloadConfig();
    }

    /**
     * Test undoAction().
     */
    public void testUndoAction() {
        instance.redoAction();
        instance.undoAction();
        assertEquals("undoAction() is incorrect.", oldZOrder, element.getContainer()
            .getContaineds().indexOf(element));
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", newZOrder, element.getContainer()
            .getContaineds().indexOf(element));
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction2() {
        instance = new ChangeZOrderAction(element, ChangeZOrderOperationType.BACKWARD);
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", 0, element.getContainer().getContaineds()
            .indexOf(element));
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {

        instance.executeAction();
        assertEquals("executeAction() is incorrect.", newZOrder, element.getContainer()
            .getContaineds().indexOf(element));
    }

    /**
     * Test constructor.
     */
    public void testChangeZOrderAction1() {
        assertEquals("oldZOrder is incorrect.", oldZOrder, AccuracyHelper.getObjectFieldValue(
            instance, "oldZOrder"));
        assertEquals("newZOrder is incorrect.", newZOrder, AccuracyHelper.getObjectFieldValue(
            instance, "newZOrder"));
    }

    /**
     * Test constructor.
     */
    public void testChangeZOrderAction2() {
        oldZOrder = 0;
        newZOrder = 0;
        element = new GraphNode();
        GraphElement node = new GraphNode();
        element.setContainer(node);
        node.addContained(element);
        node.addContained(new GraphNode());
        instance = new ChangeZOrderAction(element, ChangeZOrderOperationType.BACKWARD);
        assertEquals("oldZOrder is incorrect.", oldZOrder, AccuracyHelper.getObjectFieldValue(
            instance, "oldZOrder"));
        assertEquals("newZOrder is incorrect.", newZOrder, AccuracyHelper.getObjectFieldValue(
            instance, "newZOrder"));
    }

    /**
     * Test constructor.
     */
    public void testChangeZOrderAction3() {
        oldZOrder = 1;
        newZOrder = 2;
        element = new GraphNode();
        GraphElement node = new GraphNode();
        element.setContainer(node);
        node.addContained(new GraphNode());
        node.addContained(element);
        node.addContained(new GraphNode());
        instance = new ChangeZOrderAction(element, ChangeZOrderOperationType.TOFRONT);
        assertEquals("oldZOrder is incorrect.", oldZOrder, AccuracyHelper.getObjectFieldValue(
            instance, "oldZOrder"));
        assertEquals("newZOrder is incorrect.", newZOrder, AccuracyHelper.getObjectFieldValue(
            instance, "newZOrder"));
    }

    /**
     * Test constructor.
     */
    public void testChangeZOrderAction4() {
        oldZOrder = 1;
        newZOrder = 0;
        element = new GraphNode();
        GraphElement node = new GraphNode();
        element.setContainer(node);
        node.addContained(new GraphNode());
        node.addContained(element);
        node.addContained(new GraphNode());
        instance = new ChangeZOrderAction(element, ChangeZOrderOperationType.TOBACK);
        assertEquals("oldZOrder is incorrect.", oldZOrder, AccuracyHelper.getObjectFieldValue(
            instance, "oldZOrder"));
        assertEquals("newZOrder is incorrect.", newZOrder, AccuracyHelper.getObjectFieldValue(
            instance, "newZOrder"));
    }
}
