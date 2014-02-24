/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.uml.activityelements.Transition;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.TextNode;
import com.topcoder.gui.diagramviewer.uml.classedges.BaseEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextInputListener;
import com.topcoder.gui.diagramviewer.uml.classelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.gui.diagramviewer.uml.classelements.TextField;
import com.topcoder.gui.diagramviewer.uml.classelements.event.EditBoxListener;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.gui.panels.zoom.ZoomPanel;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * Rename element action.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RenameElementAction extends AbstractAction {

    /**
     * <p>
     * Action name.
     * <p>
     */
    private static final String ACTION_NAME = "Rename element";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Rename elements.";

    /**
     * <p>
     * Acceleration key.
     * <p>
     */
    private static final KeyStroke DEFAULT_ACCELERATOR_KEY = KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0);

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Constructs an instance of copy element action.
     * <p>
     *
     * @param mainFrame
     *            main frame of uml tool
     */
    public RenameElementAction(MainFrame mainFrame) {
        super(ACTION_NAME);
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Performing the action.
     * <p>
     *
     * @param actionEvent
     *            the action event
     */
    public void actionPerformed(ActionEvent actionEvent) {
        DiagramViewer diagramViewer = mainFrame.getDiagramViewer();
        JTabbedPane tabbedPane = diagramViewer.getTabbedPane();
        if (tabbedPane.getSelectedIndex() == -1) {
            return;
        }
        ZoomPanel zoomPanel = (ZoomPanel) tabbedPane.getSelectedComponent();
        ZoomPane zoomPane = (ZoomPane) zoomPanel.getViewport().getComponent(0);
        DiagramView view = (DiagramView) zoomPane.getComponent(0);

        List<JComponent> filteredSelectedElements = diagramViewer.getAllSelectedElements();
        if (filteredSelectedElements.size() == 1) {
            JComponent comp = filteredSelectedElements.get(0);
            TextInputBox textInputBox = diagramViewer.getTextInputBox();
            if (comp instanceof BaseNode) {
                TextField nameCompartment = ((BaseNode) comp).getNameCompartment();
                textInputBox.addTextInputListener(new EditBoxListener(nameCompartment));
                textInputBox.setText(nameCompartment.getText());
                textInputBox.setSize(nameCompartment.getPreferredSize());

                double zoomFactor = zoomPane.getTransform().getZoomFactor();
                Point pos = SwingUtilities.convertPoint(nameCompartment, 0, 0, view);
                int x = (int) Math.round((view.getX() + pos.x) * zoomFactor);
                int y = (int) Math.round((view.getY() + pos.y) * zoomFactor);
                textInputBox.show(zoomPane, x, y);

                JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
                textArea.requestFocus();
                textArea.selectAll();
            } else if (comp instanceof com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode) {
                com.topcoder.gui.diagramviewer.uml.activityelements.TextField nameCompartment =
                    ((com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode) comp).getNameCompartment();
                textInputBox
                    .addTextInputListener(new com.topcoder.gui.diagramviewer.uml.activityelements.event.TextInputListener(
                        nameCompartment));
                textInputBox.setText(nameCompartment.getText());
                textInputBox.setSize(nameCompartment.getPreferredSize());

                double zoomFactor = zoomPane.getTransform().getZoomFactor();
                Point pos = SwingUtilities.convertPoint(nameCompartment, 0, 0, view);
                int x = (int) Math.round((view.getX() + pos.x) * zoomFactor);
                int y = (int) Math.round((view.getY() + pos.y) * zoomFactor);
                textInputBox.show(zoomPane, x, y);

                JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
                textArea.requestFocus();
                textArea.selectAll();
            } else if (comp instanceof com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) {
                com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField nameCompartment =
                    ((com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) comp).getNameCompartment();
                textInputBox
                    .addTextInputListener(new com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EditBoxListener(
                        nameCompartment));
                textInputBox.setText(nameCompartment.getText());
                textInputBox.setSize(nameCompartment.getPreferredSize());

                double zoomFactor = zoomPane.getTransform().getZoomFactor();
                Point pos = SwingUtilities.convertPoint(nameCompartment, 0, 0, view);
                int x = (int) Math.round((view.getX() + pos.x) * zoomFactor);
                int y = (int) Math.round((view.getY() + pos.y) * zoomFactor);
                textInputBox.show(zoomPane, x, y);

                JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
                textArea.requestFocus();
                textArea.selectAll();
            } else if (comp instanceof com.topcoder.gui.diagramviewer.uml.auxiliaryelements.TextNode) {
                TextNode textNode = (TextNode) comp;
                textInputBox
                    .addTextInputListener(new com.topcoder.gui.diagramviewer.uml.auxiliaryelements.EditBoxListener(
                        textNode));
                textInputBox.setText(textNode.getText());
                textInputBox.setSize(textNode.getSize());

                double zoomFactor = zoomPane.getTransform().getZoomFactor();
                Point pos = SwingUtilities.convertPoint(textNode, 0, 0, view);
                int x = (int) Math.round((view.getX() + pos.x) * zoomFactor);
                int y = (int) Math.round((view.getY() + pos.y) * zoomFactor);
                textInputBox.show(zoomPane, x, y);

                JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
                textArea.requestFocus();
                textArea.selectAll();
            } else if (comp instanceof ObjectNode) {
                ObjectNode objectNode = (ObjectNode) comp;
                textInputBox
                    .addTextInputListener(new com.topcoder.gui.diagramviewer.uml.sequenceelements.TextInputListener(
                        objectNode));
                textInputBox.setText(objectNode.getName());

                double zoomFactor = zoomPane.getTransform().getZoomFactor();
                int x =
                    (int) Math.round((objectNode.getLocation().x + objectNode.getSelectionBound().x) * zoomFactor);
                int y =
                    (int) Math.round((objectNode.getLocation().y + objectNode.getSelectionBound().y) * zoomFactor);
                textInputBox.show(zoomPane, x, y);

                JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
                textArea.requestFocus();
                textArea.selectAll();

            } else if (comp instanceof PackageNode) {
                TextField nameCompartment = ((PackageNode) comp).getNameCompartment();
                textInputBox.addTextInputListener(new EditBoxListener(nameCompartment));
                textInputBox.setText(nameCompartment.getText());
                textInputBox.setSize(nameCompartment.getPreferredSize());

                double zoomFactor = zoomPane.getTransform().getZoomFactor();
                Point pos = SwingUtilities.convertPoint(nameCompartment, 0, 0, view);
                int x = (int) Math.round((view.getX() + pos.x) * zoomFactor);
                int y = (int) Math.round((view.getY() + pos.y) * zoomFactor);
                textInputBox.show(zoomPane, x, y);

                JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
                textArea.requestFocus();
                textArea.selectAll();
            } else if (comp instanceof SubsystemNodeContainer) {
                com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField nameCompartment =
                    ((SubsystemNodeContainer) comp).getNameCompartment();
                textInputBox
                    .addTextInputListener(new com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EditBoxListener(
                        nameCompartment));
                textInputBox.setText(nameCompartment.getText());
                textInputBox.setSize(nameCompartment.getPreferredSize());

                double zoomFactor = zoomPane.getTransform().getZoomFactor();
                Point pos = SwingUtilities.convertPoint(nameCompartment, 0, 0, view);
                int x = (int) Math.round((view.getX() + pos.x) * zoomFactor);
                int y = (int) Math.round((view.getY() + pos.y) * zoomFactor);
                textInputBox.show(zoomPane, x, y);

                JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
                textArea.requestFocus();
                textArea.selectAll();
            } else if (comp instanceof BaseEdge) {

                com.topcoder.gui.diagramviewer.uml.classedges.TextField nameCompartment =
                    ((BaseEdge) comp).getNameCompartment();
                TextInputListener listener = new TextInputListener(nameCompartment);
                textInputBox.addTextInputListener(listener);
                if (nameCompartment.getText() != null && nameCompartment.getText().trim().length() > 0) {
                    textInputBox.setText(nameCompartment.getText());
                } else {
                    textInputBox.clearText();
                }
                textInputBox.setSize(nameCompartment.getPreferredSize());
                double zoomFactor = zoomPane.getTransform().getZoomFactor();
                Point pos = SwingUtilities.convertPoint(nameCompartment, 0, 0, view);
                int x = (int) Math.round((view.getX() + pos.x) * zoomFactor);
                int y = (int) Math.round((view.getY() + pos.y) * zoomFactor);
                textInputBox.show(zoomPane, x, y);
                JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
                textArea.requestFocus();
                textArea.selectAll();
            } else if (comp instanceof com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseEdge) {

                com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField nameCompartment =
                    ((com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseEdge) comp).getNameCompartment();
                textInputBox
                    .addTextInputListener(new com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EditBoxListener(
                        nameCompartment));
                if (nameCompartment.getText() != null && nameCompartment.getText().trim().length() > 0) {
                    textInputBox.setText(nameCompartment.getText());
                } else {
                    textInputBox.clearText();
                }
                textInputBox.setSize(nameCompartment.getPreferredSize());
                double zoomFactor = zoomPane.getTransform().getZoomFactor();
                Point pos = SwingUtilities.convertPoint(nameCompartment, 0, 0, view);
                int x = (int) Math.round((view.getX() + pos.x) * zoomFactor);
                int y = (int) Math.round((view.getY() + pos.y) * zoomFactor);
                textInputBox.show(zoomPane, x, y);
                JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
                textArea.requestFocus();
                textArea.selectAll();
            } else if (comp instanceof Transition) {

                com.topcoder.gui.diagramviewer.uml.activityelements.TextField nameCompartment =
                    ((Transition) comp).getNameCompartment();
                textInputBox
                    .addTextInputListener(new com.topcoder.gui.diagramviewer.uml.activityelements.event.TextInputListener(
                        nameCompartment));
                if (nameCompartment.getText() != null && nameCompartment.getText().trim().length() > 0) {
                    textInputBox.setText(nameCompartment.getText());
                } else {
                    textInputBox.clearText();
                }
                textInputBox.setSize(nameCompartment.getPreferredSize());
                double zoomFactor = zoomPane.getTransform().getZoomFactor();
                Point pos = SwingUtilities.convertPoint(nameCompartment, 0, 0, view);
                int x = (int) Math.round((view.getX() + pos.x) * zoomFactor);
                int y = (int) Math.round((view.getY() + pos.y) * zoomFactor);
                textInputBox.show(zoomPane, x, y);
                JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
                textArea.requestFocus();
                textArea.selectAll();
            } else if (comp instanceof SequenceEdge) {

                com.topcoder.gui.diagramviewer.uml.sequenceelements.TextField nameCompartment =
                    ((SequenceEdge) comp).getNameCompartment();
                textInputBox
                    .addTextInputListener(new com.topcoder.gui.diagramviewer.uml.sequenceelements.TextInputListener(
                        nameCompartment));
                if (nameCompartment.getText() != null && nameCompartment.getText().trim().length() > 0) {
                    textInputBox.setText(nameCompartment.getText());
                } else {
                    textInputBox.clearText();
                }
                textInputBox.setSize(nameCompartment.getPreferredSize());
                double zoomFactor = zoomPane.getTransform().getZoomFactor();
                Point pos = SwingUtilities.convertPoint(nameCompartment, 0, 0, view);
                int x = (int) Math.round((view.getX() + pos.x) * zoomFactor);
                int y = (int) Math.round((view.getY() + pos.y) * zoomFactor);
                textInputBox.show(zoomPane, x, y);
                JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
                textArea.requestFocus();
                textArea.selectAll();
            } else if (comp instanceof StereotypeTextField) {

                TextField nameCompartment = ((TextField) comp);
                textInputBox.addTextInputListener(new EditBoxListener(nameCompartment));
                if (nameCompartment.getText() != null && nameCompartment.getText().trim().length() > 0) {
                    textInputBox.setText(nameCompartment.getText());
                } else {
                    textInputBox.clearText();
                }
                textInputBox.setSize(nameCompartment.getPreferredSize());
                double zoomFactor = zoomPane.getTransform().getZoomFactor();
                Point pos = SwingUtilities.convertPoint(nameCompartment, 0, 0, view);
                int x = (int) Math.round((view.getX() + pos.x) * zoomFactor);
                int y = (int) Math.round((view.getY() + pos.y) * zoomFactor);
                textInputBox.show(zoomPane, x, y);
                JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
                textArea.requestFocus();
                textArea.selectAll();
            }
        }
    }
}
