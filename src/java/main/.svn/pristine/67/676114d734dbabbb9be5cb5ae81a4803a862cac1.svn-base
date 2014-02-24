/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Container;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.uml.actions.general.ChangeZOrderAction;
import com.topcoder.uml.actions.general.operationtypes.ChangeZOrderOperationType;
import com.topcoder.util.actionmanager.Action;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEvent;
import com.topcoder.util.eventmanager.ActionEventListener;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Implementation of the ActionEventListener interface. This class is registered to change node's z order.
 * </p>
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 * @author ly
 * @version 1.0
 */
public class ChangeZOrderHandler implements ActionEventListener {

    /**
     * <p>
     * This array list is used to check operation type of ChangeZOrderAction.
     * </p>
     */
    private final List<ChangeZOrderOperationType> types = new ArrayList<ChangeZOrderOperationType>();

    /**
     * <p>
     * Creates an instance of change entity name handler with the mainframe.
     * </p>
     * @param mainFrame
     *            the mainFrame
     */
    public ChangeZOrderHandler() {
        types.add(ChangeZOrderOperationType.TOFRONT);
        types.add(ChangeZOrderOperationType.FORWARD);
        types.add(ChangeZOrderOperationType.BACKWARD);
        types.add(ChangeZOrderOperationType.TOBACK);
    }

    /**
     * <p>
     * This method is called to inform the handler that the event is performed.
     * </p>
     * @param event
     *            the non null event has been performed
     * @param eventValidation
     *            the non null validation result
     * @throws IllegalArgumentException
     *             if event or eventValidation is null
     */
    public void actionPerformed(EventObject event, EventValidation eventValidation) {
        ChangeZOrderOperationType type = getType(event);
        if (type != null && event.getSource() instanceof Node) {
            Node node = (Node) event.getSource();
            changeZOrder(node, type);
        }
    }

    /**
     * <p>
     * Changes node's z order.
     * </p>
     * @param node
     *            the node whose z order should be changed
     * @param type
     *            operation type of ChangeZOrderAction
     */
    private void changeZOrder(Node node, ChangeZOrderOperationType type) {
        Container container = node.getParent();
        int oldZOrder = container.getComponentZOrder(node);
        int count = container.getComponentCount();
        if (type == ChangeZOrderOperationType.TOFRONT) {
            if (oldZOrder > 0) {
                container.setComponentZOrder(node, 0);
            }
        } else if (type == ChangeZOrderOperationType.TOBACK) {
            if (oldZOrder < count - 1) {
                container.setComponentZOrder(node, count - 1);
            }
        } else if (type == ChangeZOrderOperationType.FORWARD) {
            if (oldZOrder > 0) {
                container.setComponentZOrder(node, oldZOrder - 1);
            }
        } else if (type == ChangeZOrderOperationType.BACKWARD) {
            if (oldZOrder < count - 1) {
                container.setComponentZOrder(node, oldZOrder + 1);
            }
        }
        node.repaint();
    }

    /**
     * <p>
     * Gets the operation type of ChangeZOrderAction.
     * </p>
     * @param event
     *            the event
     * @return the operation type, null if not an action event for ChangeZOrderAction
     */
    private ChangeZOrderOperationType getType(EventObject event) {
        if (event instanceof ActionEvent) {
            Action action = ((ActionEvent) event).getAction();
            if (action instanceof ChangeZOrderAction) {
                ChangeZOrderAction changeZOrderAction = (ChangeZOrderAction) action;
                for (ChangeZOrderOperationType type : types) {
                    if (changeZOrderAction.getPresentationName().endsWith(type.name())) {
                        return type;
                    }
                }
            }
        }
        return null;
    }

    /**
     * <p>
     * This method is called to inform the handler that the event is undone.
     * </p>
     * @param event
     *            the non null event has been undone
     * @param undoableAction
     *            the non null action which is undone
     * @throws IllegalArgumentException
     *             if event or undoableAction is null
     */
    public void undoActionPerformed(UndoChangesEvent event, UndoableAction undoableAction) {
        ChangeZOrderOperationType type = getType(event);
        // Change the type to opposite
        type = types.get(types.size() - 1 - types.indexOf(type));
        if (type != null && event.getSource() instanceof Node) {
            Node node = (Node) event.getSource();
            changeZOrder(node, type);
        }
    }

    /**
     * <p>
     * This method is called to inform the handler that the event is redone.
     * </p>
     * @param event
     *            the non null event which has been redone
     * @param undoableAction
     *            the non null action which is redone
     * @throws IllegalArgumentException
     *             if event or undoableAction is null
     */
    public void redoActionPerformed(RedoChangesEvent event, UndoableAction undoableAction) {
        actionPerformed(event, EventValidation.SUCCESSFUL);
    }
}
