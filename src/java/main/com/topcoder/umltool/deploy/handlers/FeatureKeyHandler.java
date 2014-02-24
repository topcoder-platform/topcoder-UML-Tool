/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.GroupTextField;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.ReorderStereotypeTextFieldAction;

/**
 * <p>
 * This handler will react to up down key to reorder features in GroupTextField.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class FeatureKeyHandler implements KeyListener {

    /**
     * <p>
     * Represents the main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>FeatureCompartmentKeyHandler</code>.
     * </p>
     *
     * @param mainFrame
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public FeatureKeyHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Invoked when a key has been typed. See the class description for {@link KeyEvent} for a definition of a key
     * typed event.
     * </p>
     *
     * @param e
     *            key event
     */
    public void keyTyped(KeyEvent e) {
    }

    /**
     * <p>
     * Invoked when a key has been pressed. See the class description for {@link KeyEvent} for a definition of a
     * key pressed event.
     * </p>
     *
     * @param e
     *            key event
     */
    public void keyPressed(KeyEvent e) {
        if (e == null || !(e.getSource() instanceof StereotypeTextField)
            || (e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN)) {
            return;
        }
        e.consume();
    }

    /**
     * <p>
     * Invoked when a key has been released. See the class description for {@link KeyEvent} for a definition of a
     * key released event.
     * </p>
     *
     * @param e
     *            key event
     */
    public void keyReleased(KeyEvent e) {
        if (e == null || !(e.getSource() instanceof StereotypeTextField)
            || (e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN)) {
            return;
        }
        StereotypeTextField textField = (StereotypeTextField) e.getSource();
        GroupTextField compartment = (GroupTextField) textField.getParent();
        ClassNode classNode = (ClassNode) compartment.getParent();
        Classifier classifier = (Classifier) DeployHelper.getElement(classNode.getGraphNode());
        Feature feature = (Feature) DeployHelper.getElement(textField);
        int oldosition = classifier.getFeatures().indexOf(feature);
        int newPosition =
            getNewPosition(classifier, feature.getClass(), e.getKeyCode() == KeyEvent.VK_UP, oldosition);
        if (newPosition != -1) {
            ReorderStereotypeTextFieldAction action =
                new ReorderStereotypeTextFieldAction(mainFrame, textField, newPosition);
            mainFrame.handleActionEvent(action, textField, action.getPresentationName());
        }
        e.consume();
    }

    /**
     * <p>
     * Gets the destination position of the reordering.
     * </p>
     *
     * @param classifier
     *            the classifier contains features
     * @param featureType
     *            the class type of the feature
     * @param isMoveUp
     *            flag to indicate move up or move down
     * @param oldPosition
     *            the old position of the feature
     * @return the new position to reorder the feature, -1 means invalid new position
     */
    private int getNewPosition(Classifier classifier, Class<?> featureType, boolean isMoveUp, int oldPosition) {
        int newPosition;
        List<Feature> features = classifier.getFeatures();
        if (isMoveUp) {
            for (newPosition = oldPosition - 1; newPosition >= 0; --newPosition) {
                if (featureType == features.get(newPosition).getClass()) {
                    return newPosition;
                }
            }
            return -1;
        } else {
            for (newPosition = oldPosition + 1; newPosition < features.size(); ++newPosition) {
                if (featureType == features.get(newPosition).getClass()) {
                    return newPosition;
                }
            }
            return -1;
        }
    }
}
