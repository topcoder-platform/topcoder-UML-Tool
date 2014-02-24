/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.gui.panels.style.StyleEvent;
import com.topcoder.gui.panels.style.StyleObject;
import com.topcoder.gui.panels.style.styleobject.GraphNodeStyleObjectAdapter;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Test the functionality of <code>StyleHandlerTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class StyleHandlerTest extends TestCase {
    /** Main frame window for testing. */
    private MainFrame MAINFRAME = TestHelper.getMainFrame();

    /** An instance of UseCaseNode for testing. */
    private UseCaseNode node;

    /** An instance of GraphNode for testing. */
    private GraphNode graphNode;

    /** An instance of StyleObject for testing. */
    private StyleObject styleObject;

    /** An instance of DiagramView for testing. */
    private DiagramView diagramView;

    /** An instance of <code>StyleHandler</code> for testing. */
    private StyleHandler handler;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        handler = new StyleHandler(MAINFRAME);
        node = TestHelper.addUseCaseNode();
        graphNode = node.getGraphNode();
        styleObject = new GraphNodeStyleObjectAdapter(graphNode);
        MAINFRAME.getStylePanel().setStyleObject(styleObject);
        MAINFRAME.getDiagramViewer().addSelectedElement(node);
        diagramView = TestHelper.getDiagramView(DiagramType.USECASE);
        diagramView.setSize(600, 600);
        MAINFRAME.getDiagramViewer().openDiagramView(diagramView.getDiagram());
    }

    /**
     * Test method for 'StyleHandler(MainFrame)'.The instance should be created successfully.
     */
    public void testStyleHandler_Accuracy() {
        assertNotNull("Test method for 'StyleHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'StyleHandler(MainFrame)'.The argument is null, IllegalArgumentException should be thrown.
     */
    public void testStyleHandler_null() {
        try {
            new StyleHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'styleChanged(StyleEvent)'.Valid event is given, should perform successfully.
     */
    public void testStyleChanged_Accuracy1() {
        StyleEvent event = new StyleEvent(styleObject, MAINFRAME.getStylePanel().getWidthKey(), String
                .valueOf(graphNode.getSize().getWidth()), "200");
        handler.styleChanged(event);
        assertEquals("The graph node should be moved to the position", (int) graphNode.getSize().getWidth(), 200);
    }

    /**
     * Test method for 'styleChanged(StyleEvent)'.Null event is given, IllegalArgumentException should be thrown.
     */
    public void testStyleChanged_null() {
        try {
            handler.styleChanged(null);
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

        diagramView.remove(node);

        diagramView.getDiagram().removeContained(node.getGraphNode());

        MAINFRAME.getDocumentTree().updateTree();

        handler = null;

        diagramView = null;

        node = null;

        graphNode = null;

        styleObject = null;
    }

}
