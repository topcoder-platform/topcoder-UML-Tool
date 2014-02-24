/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class defines undoable action for removing collaboration.
 * </p>
 * <p>
 * New created collaboration is removed or added from root model of UMLModelManager.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveCollaborationAction extends UndoableAbstractAction {
    /**
     * <p>
     * Presentation name for super class.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Collaboration";

    /**
     * <p>
     * Collaboration to add or remove from root of UMLModelManager.
     * </p>
     */
    private Collaboration collaboration;

    /**
     * <p>
     * Root node of UMLModelManager.
     * </p>
     */
    private Model model;

    /**
     * <p>
     * Reference to mainFrame, used to update the document tree.
     * </p>
     */
    private MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of RemoveCollaborationAction.
     * </p>
     * @param mainFrame
     *            mainFrame used for update document tree
     * @param collaboration
     *            collaboration to remove
     */
    public RemoveCollaborationAction(MainFrame mainFrame, Collaboration collaboration) {
        super(PRESENTATION_NAME);
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        DeployHelper.checkNotNull(collaboration, "collaboration");
        this.mainFrame = mainFrame;
        model = UMLModelManager.getInstance().getModel();
        this.collaboration = collaboration;
    }

    /**
     * <p>
     * The method actually execute this auction.
     * </p>
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        model.removeOwnedElement(collaboration);
        mainFrame.getDocumentTree().updateTree();
    }

    /**
     * <p>
     * The method actually undo the edit that was made. If any exception prevents redo/undo methods from completing
     * successfully, it should be log with logError.
     * </p>
     */
    public void undoAction() {
        model.addOwnedElement(collaboration);
        mainFrame.getDocumentTree().updateTree();
    }

    /**
     * <p>
     * The method actually redo the edit. If any exception prevents redo/undo methods from completing successfully, it
     * should be log with logError.
     * </p>
     */
    public void redoAction() {
        model.removeOwnedElement(collaboration);
        mainFrame.getDocumentTree().updateTree();
    }

}
