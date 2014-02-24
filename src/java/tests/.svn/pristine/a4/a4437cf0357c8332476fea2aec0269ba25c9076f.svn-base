/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Rectangle;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.elements.SelectionBoundEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.umltool.deploy.handlers.CornerDragHandler.CornerDragType;

/**
 * <p>
 * Test the functionality of <code>CornerDragHandler</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class CornerDragHandlerTest extends TestCase {

    /** An instance of <code>CornerDragHandler</code> for testing. */
    private CornerDragHandler handler;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        handler = new CornerDragHandler(TestHelper.getMainFrame());
    }

    /**
     * Test method for 'CornerDragHandler()'. The instance should be created successfully.
     */
    public void testCornerDragHandler() {
        assertNotNull("Test method for 'CornerDragHandler()' failed.", handler);
    }

    /**
     * Test method for 'CornerDragHandler(CornerDragType)'. A valid argument is given, the instance should be created
     * successfully.
     */
    public void testCornerDragHandlerCornerDragType_Accuracy() {
        assertNotNull("Test method for 'CornerDragHandler(CornerDragType)' failed.", new CornerDragHandler(TestHelper
                .getMainFrame(), CornerDragType.BOTH));
    }

    /**
     * Test method for 'CornerDragHandler(CornerDragType)'. The argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testCornerDragHandlerCornerDragType_null() {
        try {
            new CornerDragHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'cornerDragged(SelectionBoundEvent)'. A valid event is passed, node's bound should be changed
     * correctly.
     */
    public void testCornerDragged_Accuracy() {
        UseCaseNode node = TestHelper.addUseCaseNode();
        Rectangle oldBound = node.getSelectionBound();
        Rectangle newBound = new Rectangle(oldBound);
        newBound.width *= 2;
        newBound.height *= 2;

        SelectionBoundEvent event = new SelectionBoundEvent(node, oldBound, newBound);
        handler.cornerDragged(event);
        assertEquals("Test method for 'cornerDragged(SelectionBoundEvent)' failed.", node.getSelectionBound(), newBound);
    }

    /**
     * Test method for 'cornerDragged(SelectionBoundEvent)'. The argument is null, should be ignored.
     */
    public void testCornerDragged_null() {
        handler.cornerDragged(null);
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        handler = null;
    }
}
