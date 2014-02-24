/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Test the functionality of <code>ModelElementSelectionHandlerTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ModelElementSelectionHandlerTest extends TestCase {
    /** Main frame window for testing. */
    private MainFrame MAINFRAME = TestHelper.getMainFrame();

    /** An instance of UseCaseNode for testing. */
    private UseCaseNode node;

    /** An instance of GraphNode for testing. */
    private GraphNode graphNode;

    /** An instance of ModelElement for testing. */
    private ModelElement modelElement;

    /** An instance of DiagramView for testing. */
    private DiagramView diagramView;

    /** An instance of <code>ModelElementSelectionHandler</code> for testing. */
    private ModelElementSelectionHandler handler;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        handler = new ModelElementSelectionHandler(MAINFRAME);
        node = TestHelper.addUseCaseNode();
        graphNode = node.getGraphNode();
        modelElement = DeployHelper.getElement(graphNode);
        modelElement.setName("test");
        MAINFRAME.getDocumentTree().updateTree();
        MAINFRAME.getDocumentTree().setCurrentViewType(DocumentTreeViewType.DIAGRAM_CENTRIC);
        diagramView = TestHelper.getDiagramView(DiagramType.USECASE);
        MAINFRAME.getDiagramViewer().openDiagramView(diagramView.getDiagram());
    }

    /**
     * Test method for 'ModelElementSelectionHandler(MainFrame)'. The instance should be created successfully.
     */
    public void testModelElementSelectionHandler_Accuracy() {
        assertNotNull("Test method for 'ModelElementSelectionHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'ModelElementSelectionHandler(MainFrame)'. The argument is null, IllegalArgumentException should
     * be thrown.
     */
    public void testModelElementSelectionHandler_null() {
        try {
            new ModelElementSelectionHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for selectionChanged(ModelElement)'.Valid model element is given, should perform successfully.
     */
    public void testSelectionChanged_Accuracy() {
        handler.selectionChanged(modelElement);
        assertEquals("The corresponded document tree node should be selected", (MAINFRAME.getDocumentTree()
                .getSelectedTreeNodes())[0].getNodeObject(), graphNode);
    }

    /**
     * Test method for selectionChanged(ModelElement)'.Null model element is given, IllegalArgumentException should be
     * thrown.
     */
    public void testSelectionChanged_null() {
        try {
            handler.selectionChanged(null);
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

        MAINFRAME.getDocumentTree().updateTree();

        diagramView.remove(node);

        diagramView.getDiagram().removeContained(node.getGraphNode());

        diagramView = null;

        handler = null;

        node = null;

        graphNode = null;

        modelElement = null;
    }

}
