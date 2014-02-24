/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.uml.actions.general.ChangeZOrderAction;
import com.topcoder.uml.actions.general.operationtypes.ChangeZOrderOperationType;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This is an action to be used to move specified component backward.
 * </p>
 * @author ly
 * @version 1.0
 */
public class MoveBackwardAction extends AbstractAction {
    /**
     * <p>
     * Represents the component which will be moved to front by this action.
     * </p>
     */
    private final JComponent component;

    /**
     * <p>
     * Reference to main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Defines an <code>MoveBackwardAction</code> object with the specified description string for specified
     * component.
     * </p>
     * @param name
     *            name for this action
     * @param component
     *            the component to be moved
     * @param mainFrame
     *            main frame window
     */
    public MoveBackwardAction(String name, JComponent component, MainFrame mainFrame) {
        super(name);
        this.component = component;
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Moves specified component backward.
     * </p>
     * @param e
     *            the action event
     */
    public void actionPerformed(ActionEvent e) {
        if (component instanceof Node) {
            Node node = (Node) component;
            DiagramElement diagramElement = null;
            if (node instanceof PolylineNode) {
                diagramElement = ((PolylineNode) node).getPolyline();
            } else {
                diagramElement = node.getGraphNode();
            }
            ChangeZOrderAction changeZOrderAction = new ChangeZOrderAction(diagramElement,
                    ChangeZOrderOperationType.BACKWARD);
            mainFrame.handleActionEvent(changeZOrderAction, node, "Move to Front");
        }
    }

}
