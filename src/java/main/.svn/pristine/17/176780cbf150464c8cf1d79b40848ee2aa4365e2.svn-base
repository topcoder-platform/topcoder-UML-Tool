/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.InterfaceNode;
import com.topcoder.gui.diagramviewer.uml.classelements.TextField;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedListener;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.ChangeEntityNameAction;

/**
 * <p>
 * This implementation class listens to text change event of Class component's nodes.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ClassNameChangedHandler implements TextChangedListener {

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
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public ClassNameChangedHandler(MainFrame mainframe) {
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
     * @param e
     *            the text changed event
     * @throws IllegalArgumentException
     *             if e is null
     */
    public void textChanged(TextChangedEvent e) {
        DeployHelper.checkNotNull(e, "event");
        if (!e.getOldText().equals(e.getNewText())) {
            // Retrieve the TextField, and node
            TextField textField = (TextField) e.getSource();
            Node node = (Node) textField.getParent();
            // Get the model element
            GraphNode graphNode = node.getGraphNode();
            ModelElement modelElement = DeployHelper.getElement(graphNode);

            // Actually change the name
            if ((node instanceof ClassNode) && !(node instanceof InterfaceNode)) {
                // Change constructors' name automatically for class
                DeployHelper.changeConstructors(mainFrame, (ClassImpl) modelElement, e.getNewText(), DeployHelper
                        .getComponent(modelElement, mainFrame));
            } else {
                ChangeEntityNameAction changeNameAction = new ChangeEntityNameAction(modelElement, e.getNewText(), false);
                mainFrame.handleActionEvent(changeNameAction, DeployHelper.getComponent(modelElement, mainFrame),
                        "Name changed");
            }
        }
    }

}
