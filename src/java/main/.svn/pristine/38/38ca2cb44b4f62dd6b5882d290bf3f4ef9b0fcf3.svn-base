/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.gui.diagramviewer.uml.classelements.TextField;
import com.topcoder.gui.diagramviewer.uml.classelements.Util;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.uml.actions.model.classifiers.feature.AddOperationAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.umltool.deploy.actions.undoable.UpdateNodeContainerAction;

import com.topcoder.gui.diagramviewer.event.TextInputListener;

/**
 * <p>
 * This class is the base class to add operation.
 * </p>
 *
 * @author ly
 * @version 1.0
 */
public class OperationAddAction extends FeatureAddAction implements FocusListener {

    /**
     * <p>
     * Represents the default index for new created operation.
     * </p>
     */
    private static int DEFAULT_INDEX = 1;

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>OperationAddAction</code>.
     * </p>
     *
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public OperationAddAction(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * Adds operation to node.
     * </p>
     *
     * @param e
     *            action event
     */
    public void actionPerformed(ActionEvent e) {
        addOneOperation();
    }

    /**
     * <p>
     * Adds an operation to node.
     * </p>
     *
     */
    private void addOneOperation() {

        ClassNode classNode = getClassNode();
        GraphNode graphNode = classNode.getGraphNode();
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(classNode, "Operation added");

        Operation operation = DeployHelper.createOperation("operation" + DEFAULT_INDEX++, "void");

        Classifier classifier = (Classifier) DeployHelper.getElement(graphNode);

        // FIXME remove this code after AddOperationAction is fixed
        operation.setOwner(classifier);

        AddOperationAction addOperationAction =
            new AddOperationAction((Classifier) DeployHelper.getElement(graphNode), operation);
        compositeAction.put(addOperationAction, classNode);

        mainFrame.handleActionEvent(compositeAction, classNode, "Operation added");

        if (!mainFrame.isAutoAddOperation())
            return;

        List<StereotypeTextField> textFields = classNode.getOperationsCompartment().getItems();
        StereotypeTextField textField = textFields.get(textFields.size() - 1);
        /*
         * JTextField text=new JTextField(); if (text.getParent() != operationCompartment) {
         * operationCompartment.add(text); } text.setBounds(textField.getBounds()); text.addFocusListener(this);
         * text.addKeyListener(this); text.setText(textField.getText()); textField.setVisible(false);
         * text.setVisible(true); text.selectAll(); text.grabFocus();
         */
        textField.setVisible(false);
        Container view = classNode;
        for (; view != null;) {
            view = view.getParent();
            if (view instanceof DiagramView) {
                break;
            }
        }
        DiagramViewer viewer = ((DiagramView) view).getViewer();

        TextInputBox textInputBox = viewer.getTextInputBox();
        textInputBox.addTextInputListener(new AddOperationEditBoxListener(textField));
        textInputBox.setText(textField.getText());
        textInputBox.setSize(textField.getPreferredSize());

        ZoomPane zoomPane = (ZoomPane) view.getParent();
        double zoomFactor = zoomPane.getTransform().getZoomFactor();
        Point pos = SwingUtilities.convertPoint(textField, 0, 0, view);
        int x = (int) Math.round((view.getX() + pos.x) * zoomFactor);
        int y = (int) Math.round((view.getY() + pos.y) * zoomFactor);

        textInputBox.show(zoomPane, x, y);

        JTextArea textArea = (JTextArea) textInputBox.getComponent(0);

        // textArea.requestFocus();
        textArea.grabFocus();
        textArea.selectAll();
    }

    private class AddOperationEditBoxListener implements TextInputListener {
        /**
         * <p>
         * Represents the text field for which the edit box is used. It will be used in event handling methods.
         * </p>
         * <p>
         * Initialized in constructor, never changed later. Can't be null.
         * </p>
         */
        private final TextField textField;

        public AddOperationEditBoxListener(TextField textField) {
            Util.checkNotNull(textField, "textField");
            this.textField = textField;
        }

        /**
         * <p>
         * Handles text entered event.
         * </p>
         *
         * @param e
         *            the text entered event(ignore null)
         */
        public void textEntered(TextInputEvent e) {
            if (e == null) {
                return;
            }
            removeListener(e);
            textField.notifyTextChange(e.getText());
            textField.setVisible(true);

            if (e != null && mainFrame.isAutoAddOperation()) {
                int ret =
                    JOptionPane.showConfirmDialog(OperationAddAction.this.mainFrame, "Add Another Operation?",
                        "Operation", JOptionPane.YES_NO_OPTION);
                if (ret == JOptionPane.YES_OPTION) {
                    // OperationAddAction.this.addOneOperation();
                    ClassNode classNode = getClassNode();
                    classNode.addFocusListener(OperationAddAction.this);
                    classNode.grabFocus();
                }

            }
        }

        /**
         * <p>
         * Handles text cancelled event.
         * </p>
         *
         * @param e
         *            the cancelled event(ignore null)
         */
        public void textCancelled(TextInputEvent e) {
            if (e == null) {
                return;
            }
            removeListener(e);
            textField.setVisible(true);
        }

        /**
         * <p>
         * Removes this listener from given event's source.
         * </p>
         *
         * @param event
         *            the text input event, will not be null
         */
        private void removeListener(TextInputEvent event) {
            if (!(event.getSource() instanceof TextInputBox)) {
                return;
            }
            TextInputBox source = (TextInputBox) event.getSource();
            source.removeTextInputListener(this);
            source.setVisible(false);
        }

    }

    /**
     * <p>
     * Invoked when a component gains the keyboard focus.
     * </p>
     *
     * @param e
     *            focus event
     */
    public void focusGained(FocusEvent e) {
        // TODO Auto-generated method stub
        if (e.getComponent() instanceof ClassNode) {

            e.getComponent().removeFocusListener(this);
            addOneOperation();
        }
    }

    /**
     * <p>
     * Invoked when a component lost the keyboard focus.
     * </p>
     *
     * @param e
     *            focus event
     */
    public void focusLost(FocusEvent e) {

    }

}
