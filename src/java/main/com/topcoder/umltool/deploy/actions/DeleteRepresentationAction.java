/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.CompositeUndoableAction;

/**
 * <p>
 * Action to delete elements representation.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class DeleteRepresentationAction extends AbstractAction {
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
    private static final String ACTION_NAME = "Delete Representation";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Delete Representation.";

    /**
     * <p>
     * Icon file name for menu.
     * <p>
     */
    private static final String ICON_FILE_NAME = "/images/DeleteRepresentation_16.png";

    /**
     * <p>
     * Acceleration key.
     * <p>
     */
    private static final KeyStroke DEFAULT_ACCELERATOR_KEY = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,
            Event.SHIFT_MASK);

    /**
     * <p>
     * Icon file for tool bar.
     * <p>
     */
    private static final String TOOLBAR_ICON_FILE_NAME = "/images/DeleteRepresentation.png";

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Constructs an instance of delete element representation action.
     * <p>
     * @param mainFrame
     *            main frame of uml tool
     */
    public DeleteRepresentationAction(MainFrame mainFrame) {
        super(ACTION_NAME, new ImageIcon(DeleteRepresentationAction.class.getResource(ICON_FILE_NAME)));
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

        this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(DeleteRepresentationAction.class
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
        List<Object> objects = DeployHelper.getFilteredSelectedNodes(mainFrame);

        CompositeUndoableAction compositeAction = new CompositeUndoableAction("Delete elements");
        for (Object object : objects) {
            if (object instanceof Diagram) {
                CopyPasteCutUtil.deleteDiagram(mainFrame, (Diagram) object, compositeAction);
            } else if (object instanceof Collaboration) {
                // CopyPasteCutUtil.deleteCollaboration(mainFrame,
                // (Collaboration) object, compositeAction);
            } else if (object instanceof Edge) {
                CopyPasteCutUtil.deleteEdge(mainFrame, (Edge) object, compositeAction, false);
            } else if (object instanceof Node) {
                CopyPasteCutUtil.deleteNode(mainFrame, (Node) object, compositeAction, false);
            } else {
                // TODO
            }
        }

        mainFrame.handleActionEvent(compositeAction, mainFrame, compositeAction.getPresentationName());
    }
}
