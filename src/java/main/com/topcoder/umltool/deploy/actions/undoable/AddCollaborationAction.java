/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSetImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class defines undoable action for adding collaboration.
 * </p>
 * <p>
 * New created collaboration is added or removed from root model of UMLModelManager.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddCollaborationAction extends UndoableAbstractAction {
    /**
     * <p>
     * Presentation name for super class.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Collaboration";

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
     * Counter for naming the created collaboration.
     * </p>
     */
    private static int counter = 1;

    /**
     * <p>
     * Creates an instance of AddCollaborationAction.
     * </p>
     * @param mainFrame
     *            mainFrame used for update document tree
     */
    public AddCollaborationAction(MainFrame mainFrame) {
        super(PRESENTATION_NAME);
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        this.mainFrame = mainFrame;
        model = UMLModelManager.getInstance().getModel();
        collaboration = new CollaborationImpl();
        collaboration.setName("Collaboration " + (counter++));
        CollaborationInstanceSet collaborationSet = new CollaborationInstanceSetImpl();
        collaborationSet.setCollaboration(collaboration);
        collaboration.addCollaborationInstanceSet(collaborationSet);
    }

    /**
     * <p>
     * Gets the collaboration created.
     * </p>
     * @return the created collaboration
     */
    public Collaboration getCollaboration() {
        return collaboration;
    }

    /**
     * <p>
     * The method actually execute this auction.
     * </p>
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        model.addOwnedElement(collaboration);
        mainFrame.getDocumentTree().updateTree();
    }

    /**
     * <p>
     * The method actually undo the edit that was made. If any exception prevents redo/undo methods from completing
     * successfully, it should be log with logError.
     * </p>
     */
    public void undoAction() {
        model.removeOwnedElement(collaboration);
        mainFrame.getDocumentTree().updateTree();
    }

    /**
     * <p>
     * The method actually redo the edit. If any exception prevents redo/undo methods from completing successfully, it
     * should be log with logError.
     * </p>
     */
    public void redoAction() {
        model.addOwnedElement(collaboration);
        mainFrame.getDocumentTree().updateTree();
    }

}
