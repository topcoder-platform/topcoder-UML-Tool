/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.CompositeUndoableAction;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * Action to cut elements.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class CutElementAction extends AbstractAction {
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
    private static final String ACTION_NAME = "Cut Element";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Cut Element.";

    /**
     * <p>
     * Icon file name for menu.
     * <p>
     */
    private static final String ICON_FILE_NAME = "/images/Cut_16.png";

    /**
     * <p>
     * Acceleration key.
     * <p>
     */
    private static final KeyStroke DEFAULT_ACCELERATOR_KEY = KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit()
            .getMenuShortcutKeyMask());

    /**
     * <p>
     * Icon file for tool bar.
     * <p>
     */
    private static final String TOOLBAR_ICON_FILE_NAME = "/images/Cut.png";

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Map to indicate whether a model element had already been cut.
     * <p>
     */
    private Map<ModelElement, Boolean> isCutMap = new HashMap<ModelElement, Boolean>();

    /**
     * <p>
     * Constructs an instance of cut element action.
     * <p>
     * @param mainFrame
     *            main frame of uml tool
     */
    public CutElementAction(MainFrame mainFrame) {
        super(ACTION_NAME, new ImageIcon(CutElementAction.class.getResource(ICON_FILE_NAME)));
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

        this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(CutElementAction.class
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
        CompositeUndoableAction compositeAction = new CompositeUndoableAction("Cut elements");
        mainFrame.getClipboardMap().clear();
        List<Object> cutObjects = getCutObjects();

        for (Object object : cutObjects) {
            if (object instanceof Diagram) {
                // TODO
            } else if (object instanceof Collaboration) {
                // TODO
            } else if (object instanceof PolylineNode) {
                CopyPasteCutUtil.copyPolylineNode(mainFrame, (PolylineNode) object);
                UndoableAction action = DeployHelper.createRemoveNodeAction((PolylineNode) object, mainFrame, false);
                compositeAction.put(action, (PolylineNode) object);
            } else if (object instanceof JComponent) {
                ModelElement modelElement = DeployHelper.getElement((JComponent) object);
                boolean isComplete = modelElement == null || !getIsCut(modelElement);
                if (object instanceof Edge) {
                    CopyPasteCutUtil.cutGraphElement(mainFrame, object, ((Edge) object).getGraphEdge(),
                            compositeAction, isComplete);
                } else if (object instanceof Node) {
                    CopyPasteCutUtil.cutNode(mainFrame, (Node) object, compositeAction, isComplete);
                } else if (object instanceof StereotypeTextField) {
                    CopyPasteCutUtil.cutStereotypeTextField(mainFrame, (StereotypeTextField) object, compositeAction, isComplete);
                }
            } else {
                // TODO
            }
        }

        CopyPasteCutUtil.filterCopyGraphElement(mainFrame);

        // cuts model elements
        Map<Object, Clipboard> modelElementMap = new HashMap<Object, Clipboard>();
        for (Object object : mainFrame.getClipboardMap().keySet()) {
            if (object instanceof Node || object instanceof Edge) {
                Clipboard clipboard = new Clipboard("CopyModelElement");
                ModelElement modelElement = DeployHelper.getElement((JComponent) object);
                if (modelElement != null) {
                    CopyPasteCutUtil.copyModelElement(mainFrame, modelElement, clipboard);

                    // resets model element in clone graph element
                    GraphElement graphElement = (GraphElement) CopyPasteCutUtil.getCloneDiagramElement(mainFrame,
                            object);
                    DeployHelper.setElement(graphElement, CopyPasteCutUtil.getCloneModelElement(mainFrame,
                            modelElement, clipboard.getContents(mainFrame)));

                    // adds to model element transferable data map
                    modelElementMap.put(modelElement, clipboard);
                }
            }
        }

        // merges two transferable data maps
        mainFrame.getClipboardMap().putAll(modelElementMap);

        mainFrame.handleActionEvent(compositeAction, mainFrame, compositeAction.getPresentationName());
    }

    /**
     * <p>
     * Gets all components need to be remove.
     * </p>
     * @return the set of components need to be remove
     */
    private List<Object> getCutObjects() {
        // gets all selected component from current tree view
        List<Object> objects = DeployHelper.getFilteredSelectedNodes(mainFrame);

        // set of objects to be remove, first adds all components from tree
        List<Object> cutObjects = new ArrayList<Object>(objects);

        // finds more components need to be remove by model element
        isCutMap.clear();
        for (Object object : objects) {
            if (object instanceof JComponent) {
                ModelElement modelElement = DeployHelper.getElement((JComponent) object);
                if (modelElement != null) {
                    List<JComponent> components = DeployHelper.getComponent(modelElement, mainFrame);
                    cutObjects.remove(object);
                    cutObjects.addAll(components);

                    // initialize the remove map for each model element
                    isCutMap.put(modelElement, false);
                }
            }
        }

        return cutObjects;
    }

    /**
     * <p>
     * Gets whether a model element had already been cut.
     * </p>
     * @param modelElement
     *            the model element to check
     * @return true if the given model element is already cut, otherwise false
     */
    private boolean getIsCut(ModelElement modelElement) {
        boolean isCut = true;
        if (!isCutMap.get(modelElement)) {
            isCut = false;
            isCutMap.remove(modelElement);
            isCutMap.put(modelElement, true);
        }
        return isCut;
    }
}
