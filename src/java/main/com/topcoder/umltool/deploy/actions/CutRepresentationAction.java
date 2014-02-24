/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.CompositeUndoableAction;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * Action to cut elements representation.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class CutRepresentationAction extends AbstractAction {
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
    private static final String ACTION_NAME = "Cut Representation";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Cut Representation.";

    /**
     * <p>
     * Icon file name for menu.
     * <p>
     */
    private static final String ICON_FILE_NAME = "/images/Cut_16.png";

    /**
     * <p>
     * Icon file for tool bar.
     * <p>
     */
    private static final String TOOLBAR_ICON_FILE_NAME = "/images/Cut.png";

    /**
     * <p>
     * Acceleration key.
     * <p>
     */
    private static final KeyStroke DEFAULT_ACCELERATOR_KEY = KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit()
            .getMenuShortcutKeyMask()
            | Event.SHIFT_MASK);

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Constructs an instance of cut element representation action.
     * <p>
     * @param mainFrame
     *            main frame of uml tool
     */
    public CutRepresentationAction(MainFrame mainFrame) {
        super(ACTION_NAME, new ImageIcon(CutRepresentationAction.class.getResource(ICON_FILE_NAME)));
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

        this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(CutRepresentationAction.class
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
        CompositeUndoableAction compositeAction = new CompositeUndoableAction(mainFrame, "Cut Representation");
        List<Object> cutObjects = DeployHelper.getFilteredSelectedNodes(mainFrame);
        mainFrame.getClipboardMap().clear();

        for (Object object : cutObjects) {
            if (object instanceof Diagram) {
                // TODO
            } else if (object instanceof Collaboration) {
                // TODO
            } else if (object instanceof PolylineNode) {
                CopyPasteCutUtil.copyPolylineNode(mainFrame, (PolylineNode) object);
                UndoableAction action = DeployHelper.createRemoveNodeAction((PolylineNode) object, mainFrame, false);
                compositeAction.put(action, (PolylineNode) object);
            } else if (object instanceof Edge) {
                CopyPasteCutUtil.cutGraphElement(mainFrame, object, ((Edge) object).getGraphEdge(), compositeAction,
                        false);
            } else if (object instanceof Node) {
                CopyPasteCutUtil.cutNode(mainFrame, (Node) object, compositeAction, false);
            } else if (object instanceof StereotypeTextField) {
                CopyPasteCutUtil.cutStereotypeTextField(mainFrame, (StereotypeTextField) object, compositeAction, false);
            }
        }

        CopyPasteCutUtil.filterCopyGraphElement(mainFrame);
        mainFrame.handleActionEvent(compositeAction, mainFrame, compositeAction.getPresentationName());
    }
}
