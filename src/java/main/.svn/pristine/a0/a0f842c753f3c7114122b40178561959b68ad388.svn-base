/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.CompositeUndoableAction;

/**
 * <p>
 * Action to duplicate elements.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class DuplicateElementAction extends AbstractAction {
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
    private static final String ACTION_NAME = "Duplicate Element";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Duplicate Element.";

    /**
     * <p>
     * Icon file name for menu.
     * <p>
     */
    private static final String ICON_FILE_NAME = "/images/Delete_16.png";

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
     *
     * @param mainFrame
     *            main frame of uml tool
     */
    public DuplicateElementAction(MainFrame mainFrame) {
        super(ACTION_NAME, new ImageIcon(DuplicateElementAction.class.getResource(ICON_FILE_NAME)));
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);

        this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(DuplicateElementAction.class
            .getResource(TOOLBAR_ICON_FILE_NAME)));

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
        List<Object> removeObjects = getDuplicateObjects();

        CompositeUndoableAction compositeAction = new CompositeUndoableAction("Duplicate diagram");
        for (Object object : removeObjects) {
            if (object instanceof Diagram) {
                compositeAction.put(new DuplicateDiagramAction(mainFrame, (Diagram) object), mainFrame);
            }
        }

        mainFrame.handleActionEvent(compositeAction, mainFrame, compositeAction.getPresentationName());
    }

    /**
     * <p>
     * Gets all components need to be remove.
     * </p>
     *
     * @return the list of components need to be remove
     */
    private List<Object> getDuplicateObjects() {
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
     * Filters stereo type text fields in class nodes to be remove.
     * </p>
     *
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
