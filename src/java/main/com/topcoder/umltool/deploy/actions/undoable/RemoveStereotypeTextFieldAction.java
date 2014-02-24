/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.GroupTextField;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This action is used for remove StereotypeTextField from the diagram view.
 * </p>
 * @author ly
 * @version 1.0
 */
public class RemoveStereotypeTextFieldAction extends UndoableAbstractAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove StereotypeTextField";

    /**
     * <p>
     * Reference to the main frame.
     * </p>
     */
    private MainFrame mainFrame;

    /**
     * <p>
     * Represents the stereo type text filed to remove.
     * </p>
     */
    private StereotypeTextField textField;

    /**
     * <p>
     * Represents the group text filed contains the stereo type text field.
     * </p>
     */
    private GroupTextField groupTextField;

    /**
     * <p>
     * Represents the class node contains the stereo type text field.
     * </p>
     */
    private ClassNode classNode;

    /**
     * <p>
     * Represents the undoable action to remove feature from classifier.
     * </p>
     */
    private UndoableAbstractAction removeFeatureAction;

    /**
     * <p>
     * Creates an instance of RemoveStereotypeTextFieldAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param textField
     *            stereo type text filed to remove
     */
    public RemoveStereotypeTextFieldAction(MainFrame mainFrame, StereotypeTextField textField) {
        super(PRESENTATION_NAME);
        this.mainFrame = mainFrame;
        this.textField = textField;
        this.groupTextField = (GroupTextField) textField.getParent();
        this.classNode = (ClassNode) groupTextField.getParent();
        createRemoveFeatureAction();
    }

    /**
     * <p>
     * Creates the undoable action to remove feature.
     * </p>
     */
    private void createRemoveFeatureAction() {
        Classifier classifier = (Classifier) DeployHelper.getElement(classNode.getGraphNode());
        if (groupTextField == classNode.getAttributesCompartment()) {
            Attribute attribute = (Attribute) DeployHelper.getElement(textField);
            removeFeatureAction = new RemoveAttributeAction(classifier, attribute);
        } else {
            Operation operation = (Operation) DeployHelper.getElement(textField);
            removeFeatureAction = new RemoveOperationAction(classifier, operation);
        }
    }

    /**
     * <p>
     * The method actually execute this auction.
     * </p>
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        removeFeatureAction.execute();

        mainFrame.getDocumentTree().updateTree();

        DeployHelper.selectNode(mainFrame.getDiagramViewer(), classNode);

        performAction();
    }

    /**
     * <p>
     * Selects the feature after action is undone.
     * </p>
     */
    private void selectFeature() {
        DiagramViewer viewer = mainFrame.getDiagramViewer();
        DeployHelper.clearSelected(viewer);
        viewer.addSelectedElement(textField);
        textField.setOpaque(true);
    }

    /**
     * <p>
     * The method actually undo the edit that was made. If any exception prevents redo/undo methods from completing
     * successfully, it should be log with logError.
     * </p>
     */
    public void undoAction() {
        removeFeatureAction.undo();

        mainFrame.getDocumentTree().updateTree();

        DeployHelper.nodeNotifyChange(classNode, PRESENTATION_NAME, mainFrame);
        textField = (StereotypeTextField) DeployHelper.getComponent(DeployHelper.getElement(textField), mainFrame).get(
                0);

        mainFrame.getDocumentTree().updateTree();
        selectFeature();
        DeployHelper.notifySelectionChanged(mainFrame, (DiagramView) classNode.getParent());
        textField.requestFocus(true);
    }

    /**
     * <p>
     * The method actually redo the edit. If any exception prevents redo/undo methods from completing successfully, it
     * should be log with logError.
     * </p>
     */
    public void redoAction() {
        removeFeatureAction.redo();

        mainFrame.getDocumentTree().updateTree();

        DeployHelper.selectNode(mainFrame.getDiagramViewer(), classNode);

        performAction();
    }

    /**
     * <p>
     * Performs the removing action of StereotypeTextField.
     * </p>
     */
    private void performAction() {
        DeployHelper.nodeNotifyChange(classNode, PRESENTATION_NAME, mainFrame);
        mainFrame.getDocumentTree().updateTree();
        DeployHelper.notifySelectionChanged(mainFrame, (DiagramView) classNode.getParent());
    }
}
