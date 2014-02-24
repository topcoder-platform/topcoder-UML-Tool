package com.topcoder.umltool.deploy.actions.undoable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

public class UpdateModelElementAction extends CompositeUndoableAction {

    private final ModelElement modelElement;

    private final List<UndoableAction> actions;

    private MainFrame mainFrame;

    public UpdateModelElementAction(ModelElement modelElement) {
        super("Updating model element");
        this.modelElement = modelElement;
        actions = new ArrayList<UndoableAction>();
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setEventManager(mainFrame.getEventManager());

        for (UndoableAction action : actions) {
            put(action, DeployHelper.getComponent(modelElement, mainFrame));
        }
    }

    public void executeAction() throws ActionExecutionException {
        super.executeAction();

        for (JComponent comp : DeployHelper.getComponent(modelElement, mainFrame)) {
            if (comp instanceof Node) {
                Node node = (Node) comp;
                DeployHelper.nodeNotifyChange(node, "refreshing view", mainFrame);
            }
        }
    }

    public void undoAction() {
        super.undoAction();

        for (JComponent comp : DeployHelper.getComponent(modelElement, mainFrame)) {
            if (comp instanceof Node) {
                Node node = (Node) comp;
                DeployHelper.nodeNotifyChange(node, "refreshing view", mainFrame);
            }
        }
    }

    public void redoAction() {
        super.redoAction();

        for (JComponent comp : DeployHelper.getComponent(modelElement, mainFrame)) {
            if (comp instanceof Node) {
                Node node = (Node) comp;
                DeployHelper.nodeNotifyChange(node, "refreshing view", mainFrame);
            }
        }
    }

    public void put(UndoableAction action) {
        actions.add(action);
    }

}
