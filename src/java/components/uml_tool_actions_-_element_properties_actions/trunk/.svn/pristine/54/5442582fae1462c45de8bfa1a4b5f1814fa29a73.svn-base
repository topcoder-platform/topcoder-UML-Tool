/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.uml.actions.general.ChangePositionAction;

/**
 * Accuracy test cases for ChangePositionAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class ChangePositionActionAccuracyTest extends TestCase {
    /**
     * Represents the ChangePositionAction instance used for tests.
     */
    private ChangePositionAction instance;

    /**
     * Represents the graph element to change the position.
     */
    private GraphElement element;

    /**
     * Represents the old position of the graph element before this action performed.
     */
    private Point oldPosition;

    /**
     * Represents the new position of the graph element after this action will perform.
     */
    private Point newPosition;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        AccuracyHelper.loadDefaultConfig();
        element = new GraphNode();
        oldPosition = new Point();
        oldPosition.setX(0.0);
        oldPosition.setY(1.1);
        newPosition = new Point();
        newPosition.setX(1.1);
        newPosition.setY(0.0);
        element.setPosition(oldPosition);
        instance = new ChangePositionAction(element, newPosition);
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
        instance.undoAction();
        assertEquals("undoAction() is incorrect.", oldPosition, element.getPosition());
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.undoAction();
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", newPosition, element.getPosition());
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {
        instance.executeAction();
        assertEquals("executeAction() is incorrect.", newPosition, element.getPosition());
    }

    /**
     * Test constructor.
     */
    public void testChangePositionActionConstructor() {
        assertEquals("Element is incorrect.", element, AccuracyHelper.getObjectFieldValue(instance,
            "element"));
        assertEquals("newPosition is incorrect.", newPosition, AccuracyHelper.getObjectFieldValue(
            instance, "newPosition"));
        assertEquals("oldPosition is incorrect.", oldPosition, AccuracyHelper.getObjectFieldValue(
            instance, "oldPosition"));
    }

}
