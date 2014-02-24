/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.util.List;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * Action to update the sequence edge layout.
 * </p>
 * @author ly
 * @version 1.0
 */
public class LayoutSequenceEdgeAction extends UndoableAbstractAction {
    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Move Sequence Edge";

    /**
     * <p>
     * Reference to main frame.
     * </p>
     */
    private MainFrame mainFrame;

    /**
     * <p>
     * Old sequence edge list.
     * </p>
     */
    private List<SequenceEdge> oldEdgeList;

    /**
     * <p>
     * New sequence edge list.
     * </p>
     */
    private List<SequenceEdge> newEdgeList;

    /**
     * <p>
     * Creates an instance of <code>LayoutSequenceEdgeAction</code>.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param oldEdgeList
     *            old edge lists
     * @param newEdgeList
     *            new edge lists
     */
    public LayoutSequenceEdgeAction(MainFrame mainFrame, List<SequenceEdge> oldEdgeList, List<SequenceEdge> newEdgeList) {
        super(PRESENTATION_NAME);
        this.mainFrame = mainFrame;
        this.oldEdgeList = oldEdgeList;
        this.newEdgeList = newEdgeList;
    }

    /**
     * <p>
     * Undo the action.
     * </p>
     */
    public void undoAction() {
        DeployHelper.layoutSequenceEdges(mainFrame, DeployHelper.getDiagramView(mainFrame), oldEdgeList);
    }

    /**
     * <p>
     * Redo the action.
     * </p>
     */
    public void redoAction() {
        DeployHelper.layoutSequenceEdges(mainFrame, DeployHelper.getDiagramView(mainFrame), newEdgeList);
    }

    /**
     * <p>
     * Execute the action.
     * </p>
     */
    public void executeAction() {
        redoAction();
    }
}
