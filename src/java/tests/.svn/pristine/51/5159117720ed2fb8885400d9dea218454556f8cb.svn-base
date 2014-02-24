/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ResizeEvent;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Test the functionality of <code>ObjectNodeResizeHandler</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ObjectNodeResizeHandlerTest extends TestCase {
    /** Reference to main frame for testing */
    private MainFrame mainFrame;

    /** An instance of <code>ObjectNodeResizeHandler</code> for testing. */
    private ObjectNodeResizeHandler handler;

    /** An instance of <code>ResizeEvent</code> */
    private ResizeEvent resizeEvent;

    /** Object node for testing */
    private ObjectNode objectNode;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        mainFrame = TestHelper.getMainFrame();
        handler = new ObjectNodeResizeHandler(mainFrame);
        objectNode = TestHelper.createObjectNode();
        resizeEvent = new ResizeEvent(objectNode, "Testing");
    }

    /**
     * Test method for 'ObjectNodeResizeHandler(MainFrame)'. The instance should be created successfully.
     */
    public void testObjectNodeResizeHandler_Accuracy() {
        assertNotNull("Test method for 'ObjectNodeResizeHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'ObjectNodeResizeHandler(MainFrame)'. The argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testObjectNodeResizeHandler_Null() {
        try {
            new ObjectNodeResizeHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'ObjectNodeResizeHandler.resizeNeeded(ResizeEvent)'.
     */
    public void testResizeNeeded_Accuracy() {
        handler.resizeNeeded(resizeEvent);

    }

    /**
     * Test method for 'ObjectNodeResizeHandler.resizeNeeded(ResizeEvent)'.The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testResizeNeeded_Null() {
        try {
            handler.resizeNeeded(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        objectNode = null;
        resizeEvent = null;
        handler = null;
    }
}
