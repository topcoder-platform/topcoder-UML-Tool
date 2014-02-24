/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.uml.actions.general.ChangePositionAction;
import com.topcoder.uml.actions.general.ChangeSizeAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.UpdateNodeContainerAction;

/**
 * <p>
 * This handler will resize a node when its selection corner is dragged and released.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class CornerMouseHandler extends MouseAdapter {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Represents the old position for dragged graph node.
     * </p>
     */
    private Point oldPosition = new Point();

    /**
     * <p>
     * Represents the old size for dragged graph node.
     * </p>
     */
    private Dimension oldSize = new Dimension();

    /**
     * <p>
     * Creates an instance of <code>CornerMouseHandler</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public CornerMouseHandler(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * Handles the <b>MOUSE_PRESSED</b> event.
     * </p>
     * <p>
     * When mouse is pressed on a way point, record its index and old position.
     * </p>
     * @param e
     *            the mouse pressed event
     */
    public void mousePressed(MouseEvent e) {
        if (e == null) {
            return;
        }
        SelectionCorner corner = (SelectionCorner) e.getSource();
        Node node = (Node) corner.getParent();
        GraphNode graphNode = node.getGraphNode();
        oldPosition = new Point();
        oldPosition.setX(graphNode.getPosition().getX());
        oldPosition.setY(graphNode.getPosition().getY());
        oldSize.setWidth(graphNode.getSize().getWidth());
        oldSize.setHeight(graphNode.getSize().getHeight());
    }

    /**
     * <p>
     * Handles the <b>MOUSE_RELEASED</b> event.
     * </p>
     * <p>
     * When mouse is released, create an action for a way point moving, and pass it to event manager.
     * </p>
     * @param e
     *            the mouse pressed event
     */
    public void mouseReleased(MouseEvent e) {
        if (e == null) {
            return;
        }
        SelectionCorner corner = (SelectionCorner) e.getSource();
        Node node = (Node) corner.getParent();
        Point newPosition = new Point();
        newPosition.setX(node.getGraphNode().getPosition().getX());
        newPosition.setY(node.getGraphNode().getPosition().getY());
        Dimension newSize = new Dimension();
        newSize.setWidth(node.getGraphNode().getSize().getWidth());
        newSize.setHeight(node.getGraphNode().getSize().getHeight());
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(node, "Corner dragged");
        if (!oldPosition.equals(newPosition)) {
            node.getGraphNode().setPosition(oldPosition);
            ChangePositionAction action = new ChangePositionAction(node.getGraphNode(), newPosition);
            compositeAction.put(action, node);
        }
        if (!oldSize.equals(newSize)) {
            node.getGraphNode().setSize(oldSize);
            ChangeSizeAction action = new ChangeSizeAction(node.getGraphNode(), newSize);
            compositeAction.put(action, node);
        }
        if (node instanceof NodeContainer) {
            NodeContainer container = (NodeContainer) node;
            double xOff = newPosition.getX() - oldPosition.getX();
            double yOff = newPosition.getY() - oldPosition.getY();
            if (xOff != 0 || yOff != 0) {
                Set<Node> set = DeployHelper.getNodes(container);
                for (Node contained : set) {
                    Point oldPos = contained.getGraphNode().getPosition();
                    Point newPos = new Point();
                    newPos.setX(oldPos.getX() - xOff);
                    newPos.setY(oldPos.getY() - yOff);
                    ChangePositionAction action = new ChangePositionAction(contained.getGraphNode(), newPos);
                    compositeAction.put(action, contained);
                }
            }
        }
        mainFrame.handleActionEvent(compositeAction, node, "Corner dragged");
        StylePanel stylePanel = mainFrame.getStylePanel();
        stylePanel.setStyleObjectList(stylePanel.getStyleObjectList());
    }
}
