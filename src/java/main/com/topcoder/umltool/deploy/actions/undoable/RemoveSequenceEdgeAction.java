/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.util.List;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.AsynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.CreateMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ReturnMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SendSignalMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SynchronousMessageEdge;
import com.topcoder.uml.actions.model.sequence.RemoveAsynchronousMessageAction;
import com.topcoder.uml.actions.model.sequence.RemoveCreateMessageAction;
import com.topcoder.uml.actions.model.sequence.RemoveReturnMessageAction;
import com.topcoder.uml.actions.model.sequence.RemoveSendSignalMessageAction;
import com.topcoder.uml.actions.model.sequence.RemoveSynchronousMessageAction;
import com.topcoder.uml.actions.model.sequence.SequenceConfigurationException;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * This action is used for remove sequence edges from the diagram view.
 * </p>
 * <p>
 * RemoveMessageAction and RemoveDiagramElementAction are used.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveSequenceEdgeAction extends RemoveEdgeAction {
    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Sequence Edge";

    /**
     * <p>
     * Action to layout sequence edges.
     * </p>
     */
    private LayoutSequenceEdgeAction layoutSequenceEdgeAction;

    /**
     * <p>
     * Creates an instance of RemoveSequenceEdgeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param edge
     *            sequence edge to remove
     */
    public RemoveSequenceEdgeAction(MainFrame mainFrame, SequenceEdge edge) {
        this(mainFrame, edge, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveSequenceEdgeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param edge
     *            sequence edge to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveSequenceEdgeAction(MainFrame mainFrame, SequenceEdge edge, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, edge, isComplete ? createRemoveMessageAction(mainFrame, edge) : null);

    }

    /**
     * <p>
     * Creates the RemoveMessageEdgeAction for the given direction edge direction.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param edge
     *            sequence edge to remove
     * @throws IllegalArgumentException
     *             if mainFrame or edge is null
     */
    private static UndoableAction createRemoveMessageAction(MainFrame mainFrame, SequenceEdge edge) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        DeployHelper.checkNotNull(edge, "edge");
        Stimulus stimulus = ((List<Stimulus>) edge.getLink().getStimuli()).get(0);
        Class currentEdgeClass = edge.getClass();
        UndoableAction removeMessageAction = null;
        try {
            if (currentEdgeClass == AsynchronousMessageEdge.class) {
                removeMessageAction = new RemoveAsynchronousMessageAction(stimulus);
            } else if (currentEdgeClass == SynchronousMessageEdge.class) {
                removeMessageAction = new RemoveSynchronousMessageAction(stimulus);
            } else if (currentEdgeClass == CreateMessageEdge.class) {
                removeMessageAction = new RemoveCreateMessageAction(stimulus);
            } else if (currentEdgeClass == SendSignalMessageEdge.class) {
                removeMessageAction = new RemoveSendSignalMessageAction(stimulus);
            } else if (currentEdgeClass == ReturnMessageEdge.class) {
                removeMessageAction = new RemoveReturnMessageAction(stimulus);
            }
        } catch (SequenceConfigurationException e) {
            DeployHelper.handleException(mainFrame, e, "create remove message action failed");
        }
        return removeMessageAction;
    }

    /**
     * <p>
     * Creates the LayoutSequenceEdgeAction.
     * </p>
     */
    private void createLayoutSequenceEdgeAction() {
        Edge edge = super.getEdge();
        DiagramView view = (DiagramView) edge.getParent();
        List<SequenceEdge> oldEdgeList = DeployHelper.getSequenceEdges(view);
        view.remove(edge);
        List<SequenceEdge> newEdgeList = DeployHelper.getSequenceEdges(view);
        view.add(edge);
        layoutSequenceEdgeAction = new LayoutSequenceEdgeAction(super.getMainFrame(), oldEdgeList, newEdgeList);
    }

    /**
     * <p>
     * Removes the sequence edge.
     * </p>
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    protected void executeRemove() throws ActionExecutionException {
        createLayoutSequenceEdgeAction();
        super.executeRemove();
        try {
            layoutSequenceEdgeAction.execute();
        } catch (ActionExecutionException e) {
            DeployHelper.handleException(super.getMainFrame(), e, "Fail to layout sequence edges");
        }
    }

    /**
     * <p>
     * Undo the remove.
     * </p>
     */
    protected void undoRemove() {
        super.undoRemove();
        layoutSequenceEdgeAction.undo();
    }

    /**
     * <p>
     * Redo the remove.
     * </p>
     */
    protected void redoRemove() {
        super.redoRemove();
        layoutSequenceEdgeAction.redo();
    }
}
