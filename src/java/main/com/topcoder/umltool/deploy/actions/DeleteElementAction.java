/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.uml.actions.model.classifiers.RemoveClassAction;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.Primitive;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.CompositeUndoableAction;

/**
 * <p>
 * Action to delete elements.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class DeleteElementAction extends AbstractAction {
    /**
     * <p>
     * The version id.
     * <p>
     */
    private static final long serialVersionUID = -2873752707169317598L;

    /**
     * <p>
     * Action name.
     * <p>
     */
    private static final String ACTION_NAME = "Delete Element";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Delete Element.";

    /**
     * <p>
     * Icon file name for menu.
     * <p>
     */
    private static final String ICON_FILE_NAME = "/images/Delete_16.png";

    /**
     * <p>
     * Acceleration key.
     * <p>
     */
    private static final KeyStroke DEFAULT_ACCELERATOR_KEY = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);

    /**
     * <p>
     * Icon file for tool bar.
     * <p>
     */
    private static final String TOOLBAR_ICON_FILE_NAME = "/images/Delete.png";

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Map to indicate whether a model element had already been removed.
     * <p>
     */
    private Map<ModelElement, Boolean> isRemovedMap = new HashMap<ModelElement, Boolean>();

    /**
     * <p>
     * Constructs an instance of delete element action.
     * <p>
     * @param mainFrame
     *            main frame of uml tool
     */
    public DeleteElementAction(MainFrame mainFrame) {
        super(ACTION_NAME, new ImageIcon(DeleteElementAction.class.getResource(ICON_FILE_NAME)));
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

        this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(DeleteElementAction.class
                .getResource(TOOLBAR_ICON_FILE_NAME)));

        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Performing the action.
     * <p>
     * @param actionEvent
     *            the action event
     */
    public void actionPerformed(ActionEvent actionEvent) {
        List<Object> removeObjects = getRemoveObjects();

        CompositeUndoableAction compositeAction = new CompositeUndoableAction("Delete elements");
        for (Object object : removeObjects) {
            if (object instanceof Diagram) {
                CopyPasteCutUtil.deleteDiagram(mainFrame, (Diagram) object, compositeAction);
            } else if (object instanceof Collaboration) {
                CopyPasteCutUtil.deleteCollaboration(mainFrame, (Collaboration) object, compositeAction);
            } else if (object instanceof JComponent) {
                ModelElement modelElement = DeployHelper.getElement((JComponent) object);

                // gets whether the model element had already been removed
                boolean isComplete = modelElement == null || !getIsRemoved(modelElement);
                if (object instanceof Edge) {
                    CopyPasteCutUtil.deleteEdge(mainFrame, (Edge) object, compositeAction, isComplete);
                } else if (object instanceof Node) {
                    CopyPasteCutUtil.deleteNode(mainFrame, (Node) object, compositeAction, isComplete);
                } else if (object instanceof StereotypeTextField) {
                    CopyPasteCutUtil
                            .deleteStereotypeTextField(mainFrame, (StereotypeTextField) object, compositeAction);
                }
            } else if (!(object instanceof Primitive)) {
                // BUGR-148: remove class that is not part of any diagram
                DocumentTreeView view = mainFrame.getDocumentTree().getCurrentPanel().getCurrentView();
                TreePath[] treePaths = view.getTree().getSelectionPaths();
                if (treePaths != null) {
                    for (TreePath path : treePaths) {
                        DocumentTreeNode treeNode = (DocumentTreeNode)((DefaultMutableTreeNode)path.getLastPathComponent()).getUserObject();
                        if (treeNode.getNodeObject() == object) {
                            view.removeTreeNode(treeNode);
                            compositeAction.put(new RemoveClassAction((Class)object), view);
                        }
                    }
                }
            }
        }

        mainFrame.handleActionEvent(compositeAction, mainFrame, compositeAction.getPresentationName());
    }

    /**
     * <p>
     * Gets all components need to be remove.
     * </p>
     * @return the list of components need to be remove
     */
    private List<Object> getRemoveObjects() {
        // gets all selected component from current tree view
        List<Object> objects = DeployHelper.getFilteredSelectedNodes(mainFrame);

        // set of objects to be remove, first adds all components from tree
        List<Object> removeObjects = new ArrayList<Object>(objects);
        // removeObjects.addAll(objects);

        // filter stereo type text fields in class node to be remove
        filterStereoTypeTextFields(removeObjects);

        // finds more components need to be remove by model element
        isRemovedMap.clear();
        objects = new ArrayList<Object>(removeObjects);
        for (Object object : objects) {
            if (object instanceof JComponent) {
                ModelElement modelElement = DeployHelper.getElement((JComponent) object);
                if (modelElement != null) {
                    List<JComponent> components = DeployHelper.getComponent(modelElement, mainFrame);
                    removeObjects.remove(object);
                    removeObjects.addAll(components);
                    // initialize the remove map for each model element
                    isRemovedMap.put(modelElement, false);
                }
            }
        }

        return removeObjects;
    }

    /**
     * <p>
     * Gets whether a model element had already been removed.
     * </p>
     * @param modelElement
     *            the model element to check
     * @return true if the given model element is already removed, otherwise false
     */
    private boolean getIsRemoved(ModelElement modelElement) {
        boolean isRemoved = true;
        if (!isRemovedMap.get(modelElement)) {
            isRemoved = false;
            isRemovedMap.remove(modelElement);
            isRemovedMap.put(modelElement, true);
        }
        return isRemoved;
    }

    /**
     * <p>
     * Filters stereo type text fields in class nodes to be remove.
     * </p>
     * @param removeObjects
     *            current list of remove objects
     */
    private void filterStereoTypeTextFields(List<Object> removeObjects) {
        List<Object> cloneRemoveObjects = new ArrayList<Object>(removeObjects);
        for (Object object : cloneRemoveObjects) {
            if (object instanceof StereotypeTextField) {
                ClassNode classNode = (ClassNode) ((StereotypeTextField) object).getParent().getParent();
                if (cloneRemoveObjects.contains(classNode)) {
                    removeObjects.remove(object);
                }
            }
        }
    }
}
