/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Point;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JViewport;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.LocationEvent;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.elements.NodeDragListener;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.uml.actions.general.ChangePositionAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This handler will move the selected node and its connected edges when it is dragged.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class NodeDragHandler implements NodeDragListener {

    /**
     * <p>
     * Reference to main frame.
     * </p>
     */
    private MainFrame mainFrame;

    /**
     * <p>
     * Constructor, set the main frame reference.
     * </p>
     * @param mainFrame
     *            reference to main frame
     */
    public NodeDragHandler(MainFrame mainFrame) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Processes the node dragged event.
     * </p>
     * <p>
     * The selected node will be moved, and edges connected to it will be rotated.
     * </p>
     * <p>
     * Old location and new location contained by the event may be not exactly for this node, but their distance can be
     * used to calculate the new location of this node.
     * </p>
     * @param event
     *            a <code>LocationEvent</code> instance used to indicate the node drag event
     */
    public void nodeDragged(LocationEvent event) {
        if (event == null) {
            return;
        }

        Point oldLocation = event.getOldLocation();
        Point newLocation = event.getNewLocation();
        int offsetx = newLocation.x - oldLocation.x;
        int offsety = newLocation.y - oldLocation.y;

        // auto scroll
        Node node = (Node) event.getSource();
        DiagramView view = (DiagramView) node.getParent();
        
        /*
         * BUGR-85
         * Element dragging, scrolling is jerky.
         */
        DiagramViewer viewer = view.getViewer();
        int diagramViewGap = viewer.getDiagramViewGap();

        ZoomPane zoomPane = (ZoomPane) view.getParent();
        JViewport viewport = (JViewport) zoomPane.getParent();
        Point viewPos = viewport.getViewPosition();
        int viewHeight = viewport.getExtentSize().height;
        int viewWidth = viewport.getExtentSize().width;

        int xscroll = 0, yscroll = 0;

        // perform scrolling
        if (((newLocation.y - viewPos.y < diagramViewGap) && (offsety < 0))
                || ((viewPos.y + viewHeight - newLocation.y - node.getHeight() < diagramViewGap + 15) && (offsety > 0))) {
            yscroll = offsety;
        }
        if (((newLocation.x - viewPos.x < diagramViewGap) && (offsetx < 0))
                || ((viewPos.x + viewWidth - newLocation.x - node.getWidth() < diagramViewGap + 15) && (offsetx > 0))) {
            xscroll = offsetx;
        }
        
        /*
         * BUGR-85
         * Element dragging, scrolling is jerky.
         * Prevent resizing when position is less than zero.
         */
        if (viewPos.x + xscroll < 0) {
            xscroll = -viewPos.x;
        }
        if (viewPos.y + yscroll < 0) {
            yscroll = -viewPos.y;
        }
        

        if ((xscroll != 0) || (yscroll != 0)) {
            viewport.setViewPosition(new Point(viewPos.x + xscroll, viewPos.y + yscroll));
            /*
             * BUGR-85
             * Element dragging, scrolling is jerky.
             * Don't resize when position is less than zero.
             */
            // old code
            //if ((viewPos.x + offsetx < 0) || (viewPos.y + offsety < 0)
            //    || (viewPos.x + offsetx > view.getWidth() + 40 - viewWidth)
            //    || (viewPos.y + offsety > view.getHeight() + 40 - viewHeight)) { // resize diagram view
            if ((viewPos.x + offsetx + node.getWidth() > view.getWidth() + diagramViewGap*2 - viewWidth)
                || (viewPos.y + offsety + node.getHeight() > view.getHeight() + diagramViewGap*2 - viewHeight)) { // resize diagram view
                Dimension size = new Dimension();
              //  size.setWidth(view.getWidth() + Math.abs(xscroll));
                //size.setHeight(view.getHeight() + Math.abs(yscroll));
                size.setWidth(view.getWidth() + Math.abs(offsetx));
                size.setHeight(view.getHeight() + Math.abs(offsety));
                view.getDiagram().setSize(size);

                DeployHelper.resizeDiagramView(view);
            }
        }

        List<JComponent> filteredSlectedElements = DeployHelper.getFilteredSelectedElements(mainFrame, view);
        for (JComponent component : filteredSlectedElements) {
            if (component instanceof Node) {
                if (component instanceof ObjectNode) {
                    moveNode((Node) component, offsetx, 0);
                } else {
                    moveNode((Node) component, offsetx, offsety);
                }
            } else {
                DeployHelper.moveEdge((Edge) component, offsetx, offsety);
            }
        }
    }

    /**
     * <p>
     * Calls ChangePositionAction to move the graph node to right position. Position of the node is changed in the
     * ChangePositionHandler.
     * </p>
     * @param node
     *            the node to change position
     * @param offsetx
     *            horizontal position offset
     * @param offsety
     *            vertical position offset
     */
    protected void moveNode(Node node, int offsetx, int offsety) {
        if (node instanceof PolylineNode) {
            PolylineNode polylineNode = (PolylineNode) node;
            Polyline polyline = polylineNode.getPolyline();
            for (com.topcoder.diagraminterchange.Point wayPoint : polyline.getWaypoints()) {
                wayPoint.setX(wayPoint.getX() + offsetx);
                wayPoint.setY(wayPoint.getY() + offsety);
            }
        } else {
            if (node instanceof NodeContainer) {
                List<Edge> containedEdges = DeployHelper.getContainedEdges((NodeContainer) node);
                for (Edge edge : containedEdges) {
                    DeployHelper.moveEdge(edge, offsetx, offsety);
                }
            }
            GraphNode graphNode = node.getGraphNode();
            com.topcoder.diagraminterchange.Point oldPosition = graphNode.getPosition();
            com.topcoder.diagraminterchange.Point newPosition = new com.topcoder.diagraminterchange.Point();
            newPosition.setX(oldPosition.getX() + offsetx);
            newPosition.setY(oldPosition.getY() + offsety);

            ChangePositionAction changePositionAction = new ChangePositionAction(graphNode, newPosition);
            changePositionAction.executeAction();
        }
        DeployHelper.nodeNotifyChange(node, "Node moved", mainFrame);
        if (node instanceof NodeContainer) {
            DeployHelper.updateZOrder((NodeContainer) node);
        } else {
            DeployHelper.moveToFront((DiagramView) node.getParent(), node);
        }
    }
}
