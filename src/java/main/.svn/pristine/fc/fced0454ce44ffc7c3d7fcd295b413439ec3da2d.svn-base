/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedListener;
import com.topcoder.uml.actions.general.ChangeEntityVisibilityAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.ChangeEntityNameAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeInitialValueAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeTypeAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdateNodeContainerAction;

/**
 * <p>
 * This implementation class listens to text change event from attributes of Class component's nodes.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AttributeTextChangedHandler implements TextChangedListener {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>ClassNameChangedHandler</code>.
     * </p>
     *
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public AttributeTextChangedHandler(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * Handles the text changed event.
     * </p>
     * <p>
     * The event parameter could tell which TextField text is changed, and what is the old text and new text value.
     * </p>
     *
     * @param e
     *            the text changed event
     * @throws IllegalArgumentException
     *             if e is null
     */
    public void textChanged(TextChangedEvent e) {
        DeployHelper.checkNotNull(e, "event");
        String text = e.getNewText().trim();
        if (text.length() == 0 || text.equals(e.getOldText())) {
            return;
        }

        // Retrieve the TextField, and node
        StereotypeTextField textField = (StereotypeTextField) e.getSource();
        textField.setOpaque(true);
        mainFrame.getDiagramViewer().addSelectedElement(textField);

        Node node = (Node) textField.getParent().getParent();
        ModelElement modelElement = DeployHelper.getElement(node);

        // Get the model element
        GraphNode graphNode = textField.getGraphNode();
        Attribute attribute = (Attribute) DeployHelper.getElement(graphNode);
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(node, "Attribute text changed.");
        // Parse the new text and change attribute
        VisibilityKind visibilityKind = DeployHelper.parseVisibilityKind(text);
        if (visibilityKind != null) {
            text = text.substring(1);
        } else {
            visibilityKind = attribute.getVisibility();
        }
        if (attribute.getVisibility() != visibilityKind) {
            ChangeEntityVisibilityAction changeVisibilityAction =
                new ChangeEntityVisibilityAction(attribute, visibilityKind);
            compositeAction.put(changeVisibilityAction, DeployHelper.getComponent(modelElement, mainFrame));
        }
        if (text.length() != 0) {
            String name = parseName(text);
            text = text.substring(name.length());
            if (!attribute.getName().equals(name)) {
                ChangeEntityNameAction changeNameAction =
                    new ChangeEntityNameAction(attribute, name, mainFrame.isAutoGenerateMethods());
                compositeAction.put(changeNameAction, DeployHelper.getComponent(modelElement, mainFrame));
            }
            text = trimFirstCharacter(text);
        }
        if (text.length() != 0) {
            Classifier classifier = attribute.getType();
            String type = parseType(text);
            text = text.substring(type.length());
            if (classifier == null || !classifier.getName().equals(type)) {
                ChangeTypeAction changeTypeAction =
                    new ChangeTypeAction(attribute, DeployHelper.findType(type, mainFrame), mainFrame
                        .isAutoGenerateMethods());
                compositeAction.put(changeTypeAction, DeployHelper.getComponent(modelElement, mainFrame));
            }
            text = trimFirstCharacter(text);
        }
        if (text.length() != 0) {
            Expression initialValue = attribute.getInitialValue();
            if (initialValue == null || !initialValue.getBody().equals(text)) {
                ChangeInitialValueAction changeInitialValueAction = new ChangeInitialValueAction(attribute, text);
                compositeAction.put(changeInitialValueAction, DeployHelper.getComponent(modelElement, mainFrame));
            }
        }
        mainFrame.handleActionEvent(compositeAction, node, "Attribute changed");
    }

    /**
     * <p>
     * Trims the first character for given string.
     * </p>
     *
     * @param text
     *            the string to be trimmed
     * @return the trimmed string
     */
    private String trimFirstCharacter(String text) {
        if (text.length() != 0) {
            text = text.substring(1);
        }
        return text;
    }

    /**
     * <p>
     * Parses attribute name from given text.
     * </p>
     *
     * @param text
     *            text for an attribute
     * @return parsed name
     */
    private String parseName(String text) {
        int index = text.indexOf(':');
        if (index == -1) {
            index = text.length();
        }
        String name = text.substring(0, index);
        return name;
    }

    /**
     * <p>
     * Parses attribute type from given text.
     * </p>
     *
     * @param text
     *            text for an attribute
     * @return parsed type
     */
    private String parseType(String text) {
        int index = text.indexOf('=');
        if (index == -1) {
            index = text.length();
        }
        String type = text.substring(0, index);
        return type;
    }
}
