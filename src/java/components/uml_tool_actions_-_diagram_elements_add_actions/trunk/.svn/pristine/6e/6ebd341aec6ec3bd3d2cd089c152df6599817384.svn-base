/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateVisibilityAction;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>UpdateVisibilityAction </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestUpdateVisibilityActionAccuracy extends TestCase {

    /**
     * Test the constructor.
     *
     */
    public void testUpdateVisibilityAction() {
        GraphNode node = HelperUtil.createGraphNodeInstance();

        UpdateVisibilityAction action = new UpdateVisibilityAction(node, false);

        assertNotNull("The UpdateVisibilityAction should be created.", action);
    }

    /**
     * Test the functionality of update visibility.
     *
     * @throws Exception to junit.
     */
    public void testExecute() throws Exception  {
        GraphNode node = HelperUtil.createGraphNodeInstance();

        UpdateVisibilityAction action = new UpdateVisibilityAction(node, false);

        assertNotNull("The UpdateVisibilityAction should be created.", action);

        // update the visibility to false.
        action.execute();

        assertFalse("The visibility should be false.", action.getElement().isVisible());

        action = new UpdateVisibilityAction(node, true);

        // update the visibility to true.
        action.execute();

        assertTrue("The visibility is updated to true now.", action.getElement().isVisible());
    }
}