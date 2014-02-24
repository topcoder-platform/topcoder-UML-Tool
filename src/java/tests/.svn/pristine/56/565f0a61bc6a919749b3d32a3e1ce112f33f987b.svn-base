/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.JComponent;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.umltool.deploy.actions.undoable.ChangeEntityNameAction;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Test the functionality of <code>ChangeEntityNameHandler</code> class.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeEntityNameHandlerTest extends TestCase {
    /** Main frame window for testing. */
    private MainFrame MAINFRAME = TestHelper.getMainFrame();

    /** An instance of UseCaseNode for testing. */
    private UseCaseNode node;

    /** An instance of ModelElement for testing. */
    private ModelElement modelElement;

    /** Old name of the model element for testing. */
    private String oldName = "OldName";

    /** New name of the model element for testing. */
    private String newName = "NewName";

    /** An instance of <code>ChangeEntityNameAction</code> for testing. */
    private ChangeEntityNameAction action;

    /** An instance of <code>ChangeEntityNameHandler</code> for testing. */
    private ChangeEntityNameHandler handler;

    /** Event for executing. */
    private EventObject event;

    /** Event for undoing. */
    private UndoChangesEvent undoEvent;

    /** Event for redoing. */
    private RedoChangesEvent redoEvent;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        handler = new ChangeEntityNameHandler(MAINFRAME);
        node = TestHelper.addUseCaseNode();
        modelElement = DeployHelper.getElement(node.getGraphNode());
        modelElement.setName(oldName);
        MAINFRAME.getDocumentTree().updateTree();
        MAINFRAME.getDocumentTree().setCurrentViewType(DocumentTreeViewType.DIAGRAM_CENTRIC);
        DiagramView view = TestHelper.getDiagramView(DiagramType.USECASE);
        MAINFRAME.getDiagramViewer().openDiagramView(view.getDiagram());
        action = new ChangeEntityNameAction(modelElement, newName, false);
        List<JComponent> jComponents = new ArrayList<JComponent>();
        jComponents.add(node);
        event = new EventObject(jComponents);
        undoEvent = new UndoChangesEvent(action, jComponents);
        redoEvent = new RedoChangesEvent(action, jComponents);
    }

    /**
     * Test method for 'ChangeEntityNameHandler(MainFrame)'. The instance should be created successfully.
     */
    public void testChangeEntityNameHandler_Accuracy() {
        assertNotNull("Test method for 'ChangeEntityNameHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'ChangeEntityNameHandler(MainFrame)'. The argument is null, IllegalArgumentException should
     * be thrown.
     */
    public void testChangeEntityNameHandler_null() {
        try {
            new ChangeEntityNameHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'actionPerformed(EventObject, EventValidation)'. Valid event is given, should perform
     * successfully.
     */
    public void testActionPerformed_Accuracy() {
        try {
            action.execute();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        handler.actionPerformed(event, EventValidation.SUCCESSFUL);
        assertEquals("The DocumentTree should display the new name.", DeployHelper.getDocumentTreeNode(
            modelElement, MAINFRAME.getDocumentTree().getCurrentPanel().getCurrentView()).get(0).toString(),
            newName);
    }

    /**
     * Test method for 'actionPerformed(EventObject, EventValidation)'. Null event is given,
     * IllegalArgumentException should be thrown.
     */
    public void testActionPerformed_null() {
        try {
            handler.actionPerformed(null, EventValidation.SUCCESSFUL);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'undoActionPerformed(UndoChangesEvent, UndoableAction)'. Valid event is given, should
     * perform successfully.
     */
    public void testUndoActionPerformed_Accuracy() {
        try {
            action.execute();
            handler.actionPerformed(event, EventValidation.SUCCESSFUL);
            action.undo();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        handler.undoActionPerformed(undoEvent, action);
        assertEquals("The DocumentTree should display the old name.", DeployHelper.getDocumentTreeNode(
            modelElement, MAINFRAME.getDocumentTree().getCurrentPanel().getCurrentView()).get(0).toString(),
            oldName);
    }

    /**
     * Test method for 'undoActionPerformed(UndoChangesEvent, UndoableAction)'. Null event is given,
     * IllegalArgumentException should be thrown.
     */
    public void testUndoActionPerformed_null() {
        try {
            handler.undoActionPerformed(null, action);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'redoActionPerformed(RedoChangesEvent, UndoableAction)'. Valid event is given, should
     * perform successfully.
     */
    public void testRedoActionPerformed_Accuracy() {
        try {
            action.execute();
            handler.actionPerformed(event, EventValidation.SUCCESSFUL);
            action.undo();
            handler.undoActionPerformed(undoEvent, action);
            action.redo();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        handler.redoActionPerformed(redoEvent, action);
        assertEquals("The DocumentTree should display the correct name.", DeployHelper.getDocumentTreeNode(
            modelElement, MAINFRAME.getDocumentTree().getCurrentPanel().getCurrentView()).get(0).toString(),
            newName);
    }

    /**
     * Test method for 'redoActionPerformed(RedoChangesEvent, UndoableAction)'. Null event is given,
     * IllegalArgumentException should be thrown.
     */
    public void testRedoActionPerformed_null() {
        try {
            handler.redoActionPerformed(null, action);
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

        TestHelper.getDiagramView(DiagramType.USECASE).remove(node);

        TestHelper.getDiagramView(DiagramType.USECASE).getDiagram().removeContained(node.getGraphNode());

        MAINFRAME.getDocumentTree().updateTree();

        action = null;

        handler = null;

        event = null;

        undoEvent = null;

        redoEvent = null;
    }
}
