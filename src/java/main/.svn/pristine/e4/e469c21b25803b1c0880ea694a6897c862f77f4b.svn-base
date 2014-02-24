/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Component;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.GroupTextField;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This action is used for reorder StereotypeTextField from the diagram view.
 * </p>
 *
 * @author ly
 * @version 1.0
 */
public class ReorderStereotypeTextFieldAction extends UndoableAbstractAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Reorder StereotypeTextField";

    /**
     * <p>
     * Reference to the main frame.
     * </p>
     */
    private MainFrame mainFrame;

    /**
     * <p>
     * Represents the class node contains the stereo type text field.
     * </p>
     */
    private ClassNode classNode;

    /**
     * <p>
     * Represents the group text field contains the text field.
     * </p>
     */
    private GroupTextField groupTextField;

    /**
     * <p>
     * Represents the corresponding classifier.
     * </p>
     */
    private Classifier classifier;

    /**
     * <p>
     * Represents the corresponding feature of text field.
     * </p>
     */
    private Feature feature;

    /**
     * <p>
     * Represents the old position of the feature in classifier.
     * </p>
     */
    private int oldPosition;

    /**
     * <p>
     * Represents the new position of the feature in classifier.
     * </p>
     */
    private int newPosition;

    /**
     * <p>
     * Creates an instance of ReorderStereotypeTextFieldAction.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param textField
     *            stereo type text filed to remove
     * @param newPosition
     *            new position of text field
     */
    public ReorderStereotypeTextFieldAction(MainFrame mainFrame, StereotypeTextField textField, int newPosition) {
        super(PRESENTATION_NAME);
        this.mainFrame = mainFrame;
        this.groupTextField = (GroupTextField) textField.getParent();
        this.classNode = (ClassNode) groupTextField.getParent();
        this.classifier = (Classifier) DeployHelper.getElement(classNode.getGraphNode());
        this.feature = (Feature) DeployHelper.getElement(textField);
        this.oldPosition = classifier.getFeatures().indexOf(feature);
        this.newPosition = newPosition;
    }

    /**
     * <p>
     * The method actually execute this auction.
     * </p>
     *
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        performAction(newPosition);
    }

    /**
     * <p>
     * Selectes the feature after action is undone.
     * </p>
     */
    private void selectFeature() {
        Component[] components = groupTextField.getComponents();
        for (Component component : components) {
            if (component instanceof StereotypeTextField) {
                StereotypeTextField textField = (StereotypeTextField) component;
                if (DeployHelper.getElement(textField) == feature) {
                    DiagramViewer viewer = mainFrame.getDiagramViewer();
                    mainFrame.getDocumentTree().updateTree();
                    viewer.addSelectedElement(textField);
                    mainFrame.getDocumentTree().updateTree();
                    DeployHelper.notifySelectionChanged(mainFrame, (DiagramView) classNode.getParent());
                    textField.setOpaque(true);
                    textField.requestFocus();
                    break;
                }
            }
        }
    }

    /**
     * <p>
     * The method actually undo the edit that was made. If any exception prevents redo/undo methods from completing
     * successfully, it should be log with logError.
     * </p>
     */
    public void undoAction() {
        performAction(oldPosition);
    }

    /**
     * <p>
     * The method actually redo the edit. If any exception prevents redo/undo methods from completing successfully,
     * it should be log with logError.
     * </p>
     */
    public void redoAction() {
        performAction(newPosition);
    }

    /**
     * <p>
     * Performs the removing action of StereotypeTextField.
     * </p>
     */
    private void performAction(int position) {
        classifier.removeFeature(feature);
        classifier.addFeature(position, feature);
        mainFrame.getDocumentTree().updateTree();
        DeployHelper.nodeNotifyChange(classNode, PRESENTATION_NAME, mainFrame);
        selectFeature();
    }
}
