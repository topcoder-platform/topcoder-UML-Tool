/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.EditNameEvent;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Test the functionality of <code>ObjectNodeEditNameHandler</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ObjectNodeEditNameHandlerTest extends TestCase {

    /** Reference to main frame for testing */
    private MainFrame mainFrame;

    /** An instance of <code>ObjectNodeEditNameHandler</code> for testing. */
    private ObjectNodeEditNameHandler handler;

    /** The object node to change name */
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

        handler = new ObjectNodeEditNameHandler();
        objectNode = TestHelper.createObjectNode();
        TestHelper.getDiagramView(DiagramType.SEQUENCE).add(objectNode);
        mainFrame = TestHelper.getMainFrame();
        mainFrame.setVisible(true);
    }

    /**
     * Test method for 'ObjectNodeEditNameHandler.nameEditStarted(EditNameEvent)'. The text input box should be showed
     * out.
     */
    public void testNameEditStarted_Accuracy() {
        EditNameEvent editNameEvent = new EditNameEvent(new Point(), "new name", objectNode);
        handler.nameEditStarted(editNameEvent);
        assertTrue("Text input box in diagram viewer is not showed.", mainFrame.getDiagramViewer().getTextInputBox()
                .isShowing());
    }

    /**
     * Test method for 'ObjectNodeEditNameHandler.nameEditStarted(EditNameEvent)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testNameEditStarted_Null() {
        try {
            handler.nameEditStarted(null);
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

        TestHelper.getDiagramView(DiagramType.SEQUENCE).remove(objectNode);
        objectNode = null;
        handler = null;
        mainFrame.setVisible(false);
    }

}
