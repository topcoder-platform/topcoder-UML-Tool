/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEvent;
import com.topcoder.util.eventmanager.ActionEventListener;
import com.topcoder.util.eventmanager.EventManager;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * This class defines composite undoable action used for handle multiple undoable actions.
 * </p>
 * <p>
 * Corresponding methods of actions in the action list are called in the method of composite action.
 * </p>
 *
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class CompositeUndoableAction extends UndoableAbstractAction {
    /**
     * <p>
     * A list of actions to be executed.
     * </p>
     */
    private List<UndoableAction> actionList;

    /**
     * <p>
     * A list of sources corresponding to the actions.
     * </p>
     */
    private List<Object> sourceList;

    /**
     * <p>
     * Reference to the event manager.
     * </p>
     */
    private EventManager eventManager;

    /**
     * <p>
     * Reference to main frame.
     * </p>
     */
    private MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>CompositeUndoableAction</code>.
     * </p>
     *
     * @param presentationName
     *            the non null, non empty string representing the presentation name
     */
    public CompositeUndoableAction(String presentationName) {
        this(null, presentationName);
    }

    /**
     * <p>
     * Creates an instance of <code>CompositeUndoableAction</code>.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param presentationName
     *            the non null, non empty string representing the presentation name
     */
    public CompositeUndoableAction(MainFrame mainFrame, String presentationName) {
        super(presentationName);
        this.mainFrame = mainFrame;
        actionList = new ArrayList<UndoableAction>();
        sourceList = new ArrayList<Object>();
    }

    /**
     * <p>
     * Puts new action and source to lists.
     * </p>
     *
     * @param action
     *            an UndoableAction
     * @param source
     *            the action source
     */
    public void put(UndoableAction action, Object source) {
        DeployHelper.checkNotNull(action, "action");
        DeployHelper.checkNotNull(source, "source");
        actionList.add(action);
        sourceList.add(source);
    }

    /**
     * <p>
     * Puts new action and source to lists at specified index.
     * </p>
     *
     * @param action
     *            an UndoableAction
     * @param source
     *            the action source
     * @param index
     *            the index
     */
    protected void put(UndoableAction action, Object source, int index) {
        DeployHelper.checkNotNull(action, "action");
        DeployHelper.checkNotNull(source, "source");
        actionList.add(index, action);
        sourceList.add(index, source);
    }

    /**
     * <p>
     * Set the event manager reference.
     * </p>
     *
     * @param eventManager
     *            reference to the event manager
     */
    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    /**
     * <p>
     * Indicates whether there's no action in the list.
     * </p>
     *
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return actionList.isEmpty();
    }

    /**
     * <p>
     * Gets the count of actions in the list.
     * </p>
     *
     * @return the count
     */
    public int countActions() {
        return actionList.size();
    }

    /**
     * <p>
     * The method actually execute this action.
     * </p>
     *
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        executeFrom(0);
    }

    /**
     * <p>
     * Executes the actions from given index in the list.
     * </p>
     *
     * @param index
     *            the index of start action
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    protected void executeFrom(int index) throws ActionExecutionException {
        for (int i = index; i < actionList.size(); i++) {
            UndoableAction action = actionList.get(i);
            action.execute();
            if (eventManager != null) {
                Set<ActionEventListener> listeners = eventManager.getActionEventListener(action.getClass());
                ActionEvent actionEvent = new ActionEvent(action, sourceList.get(actionList.indexOf(action)));
                for (ActionEventListener listener : listeners) {
                    listener.actionPerformed(actionEvent, EventValidation.SUCCESSFUL);
                }
            }
        }
        if (mainFrame != null) {
            mainFrame.getDocumentTree().updateTree();
            mainFrame.updateDiagramView();
        }
    }

    /**
     * <p>
     * The method actually undo the edit that was made. If any exception prevents redo/undo methods from completing
     * successfully, it should be log with logError.
     * </p>
     */
    public void undoAction() {
        int size = actionList.size();
        for (int i = size - 1; i >= 0; --i) {
            UndoableAction action = actionList.get(i);
            action.undo();
            Set<ActionEventListener> listeners = eventManager.getActionEventListener(action.getClass());
            UndoChangesEvent actionEvent = new UndoChangesEvent(action, sourceList.get(i));
            for (ActionEventListener listener : listeners) {
                listener.undoActionPerformed(actionEvent, action);
            }
        }
        if (mainFrame != null) {
            mainFrame.getDocumentTree().updateTree();
            mainFrame.updateDiagramView();
        }
    }

    /**
     * <p>
     * The method actually redo the edit. If any exception prevents redo/undo methods from completing successfully,
     * it should be log with logError.
     * </p>
     */
    public void redoAction() {
        for (UndoableAction action : actionList) {
            action.redo();
            Set<ActionEventListener> listeners = eventManager.getActionEventListener(action.getClass());
            RedoChangesEvent actionEvent =
                new RedoChangesEvent(action, sourceList.get(actionList.indexOf(action)));
            for (ActionEventListener listener : listeners) {
                listener.redoActionPerformed(actionEvent, action);
            }
        }
        if (mainFrame != null) {
            mainFrame.getDocumentTree().updateTree();
            mainFrame.updateDiagramView();
        }
    }

    public List<UndoableAction> getActionList() {
        return actionList;
    }
}
