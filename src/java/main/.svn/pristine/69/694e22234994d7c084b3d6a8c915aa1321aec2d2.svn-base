/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Set;

import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.elements.CornerDragListener;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.elements.SelectionBoundEvent;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.uml.actions.general.ChangePositionAction;
import com.topcoder.uml.actions.general.ChangeSizeAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This handler will resize a node when its selection corner is dragged.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class CornerDragHandler implements CornerDragListener {

    /**
     * <p>
     * Enumeration type for SelectionCorner dragging.
     * </p>
     * @author ly, FireIce, ylouis
     * @version 1.0
     */
    public enum CornerDragType {
        /**
         * <p>
         * Both horizontal and vertical direction dragging are allowed.
         * </p>
         */
        BOTH,
        /**
         * <p>
         * Only horizontal direction dragging is allowed.
         * </p>
         */
        HORIZONTAL,
        /**
         * <p>
         * Only vertical direction dragging is allowed.
         * </p>
         */
        VERTICAL
    };

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * ConerDrag type of this handler.
     * </p>
     */
    private CornerDragType dragType;

    /**
     * <p>
     * Creates an instance of <code>CornerDragHandler</code>.
     * </p>
     * @param mainFrame
     *            the mainframe
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public CornerDragHandler(MainFrame mainFrame) {
        this(mainFrame, CornerDragType.BOTH);
    }

    /**
     * <p>
     * Creates an instance of <code>CornerDragHandler</code>.
     * </p>
     * @param mainFrame
     *            the mainframe
     * @param type
     *            corner drag type
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public CornerDragHandler(MainFrame mainFrame, CornerDragType type) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        DeployHelper.checkNotNull(type, "type");
        this.mainFrame = mainFrame;
        dragType = type;
    }

    /**
     * <p>
     * Processes the corner dragged event.
     * </p>
     * @param event
     *            a <code>SelectionBoundEvent</code> instance used to indicate the corner drag event
     */
    public void cornerDragged(SelectionBoundEvent event) {
        if (event == null) {
            return;
        }
        Node node = (Node) event.getSource();
        Rectangle oldBound = event.getOldBound();
        Rectangle newBound = event.getNewBound();

        if (dragType == CornerDragType.HORIZONTAL) {
            newBound.y = oldBound.y;
            newBound.height = oldBound.height;
        } else if (dragType == CornerDragType.VERTICAL) {
            newBound.x = oldBound.x;
            newBound.width = oldBound.width;
        }

        Dimension preferredSize = getPreferredNodeSize(node);
        if (preferredSize != null) {
            if (newBound.width < preferredSize.width || newBound.height < preferredSize.height) {
                return;
            }
        }

        if (node instanceof NodeContainer) {
            Rectangle preferredBound = getPreferredBound((NodeContainer) node);
            Rectangle newBoundary = new Rectangle(newBound);
            newBoundary.x = node.getX() + node.getSelectionBound().x + newBound.x - oldBound.x;
            newBoundary.y = node.getY() + node.getSelectionBound().y + newBound.y - oldBound.y;
            if (preferredBound != null) {
                if (newBoundary.x > preferredBound.x
                        || newBoundary.x + newBoundary.width < preferredBound.x + preferredBound.width
                        || newBoundary.y > preferredBound.y
                        || newBoundary.y + newBoundary.height < preferredBound.y + preferredBound.height) {
                    return;
                }
            }
        }

        if (!oldBound.getLocation().equals(newBound.getLocation())) {
            Point oldPosition = node.getGraphNode().getPosition();
            Point newPosition = new Point();
            newPosition.setX(oldPosition.getX() + newBound.x - oldBound.x);
            newPosition.setY(oldPosition.getY() + newBound.y - oldBound.y);
            ChangePositionAction action = new ChangePositionAction(node.getGraphNode(), newPosition);
            action.executeAction();
        }
        if (!oldBound.getSize().equals(newBound.getSize())) {
            ChangeSizeAction action = new ChangeSizeAction(node.getGraphNode(), DeployHelper.createDimension(newBound
                    .getSize()));
            action.executeAction();
        }
        if (node instanceof SubsystemNodeContainer) {
            ((SubsystemNodeContainer) node).notifyGraphNodeChange("Corner dragged");
            DeployHelper.updateEdges(node);
        } else if (node instanceof PackageNode) {
            ((PackageNode) node).notifyGraphNodeChange("Corner dragged");
            DeployHelper.updateEdges(node);
        } else {
            DeployHelper.nodeNotifyChange(node, "Corner dragged", mainFrame);
        }
    }

    /**
     * <p>
     * Gets the preferred size for node.
     * </p>
     * @param node
     *            node to calculate preferred size
     * @return the preferred size for node
     */
    private Dimension getPreferredNodeSize(Node node) {
        Dimension preferredSize = null;
        if (node instanceof BaseNode) {
            preferredSize = ((BaseNode) node).getPreferredGraphNodeSize();
        } else if (node instanceof SubsystemNodeContainer) {
            preferredSize = ((SubsystemNodeContainer) node).getPreferredGraphNodeSize();
        } else if (node instanceof com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode) {
            preferredSize = ((com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode) node)
                    .getPreferredGraphNodeSize();
        } else if (node instanceof com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) {
            preferredSize = ((com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) node)
                    .getPreferredGraphNodeSize();
        } else if (node instanceof PackageNode) {
            preferredSize = ((PackageNode) node).getPreferredGraphNodeSize();
        } else if (node instanceof com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BaseNode) {
            preferredSize = ((com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BaseNode) node).getPreferredSize();
        }
        return preferredSize;
    }

    /**
     * <p>
     * Calculates a preferred rectangle bound to contain all contained nodes.
     * </p>
     * @param container
     *            a NodeContainer whose contained nodes are used to calculate the bound
     * @return a preferred bound
     */
    private Rectangle getPreferredBound(NodeContainer container) {
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        Set<Node> set = DeployHelper.getNodes(container);
        for (Node node : set) {
            x1 = Math.min(x1, node.getX());
            y1 = Math.min(y1, node.getY());
            x2 = Math.max(x2, node.getX() + node.getWidth());
            y2 = Math.max(y2, node.getY() + node.getHeight());
        }
        if (x1 == Integer.MAX_VALUE) {
            return null;
        }
        x1 -= SelectionCorner.DEFAULT_RADIUS;
        y1 -= SelectionCorner.DEFAULT_RADIUS;
        x2 += SelectionCorner.DEFAULT_RADIUS;
        y2 += SelectionCorner.DEFAULT_RADIUS;
        return new Rectangle(x1, y1, x2 - x1, y2 - y1);
    }

}
