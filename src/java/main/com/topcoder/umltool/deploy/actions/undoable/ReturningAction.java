package com.topcoder.umltool.deploy.actions.undoable;

import java.util.List;

import com.topcoder.util.actionmanager.UndoableAction;

public interface ReturningAction extends UndoableAction {
    public List<UpdateModelElementAction> getActions();
}
