/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * This class extends the Edge class and is used for demonstration.
 * </p>
 *
 * <p>
 * This class implements the WayPointListener and EdgeDragListener interface and when any event
 * is received, it will print the received object to console.
 * </p>
 *
 * <p>
 * This edge implements a generalization edge.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GeneralizationEdge extends Edge implements WayPointListener, EdgeDragListener {
    /**
     * <p>
     * Construct a GeneralizationEdge with graph edge and right ending given.
     * </p>
     *
     * @param graphEdge the associated graphEdge
     * @param rightEdgeEnding the right ending of this edge
     *
     * @throws IllegalArgumentException if graphEdge is null, or the size of way points
     * of the graph edge is less than two
     */
    public GeneralizationEdge(GraphEdge graphEdge, TriangleEdgeEnding rightEdgeEnding) {
        super(graphEdge, new LineStyle(5, 2), null, rightEdgeEnding);

        this.addEdgeDragListener(this);
        this.addWayPointDragListener(this);
    }

    /**
     * <p>
     * This method implements the abstract method of Edge class.
     * </p>
     *
     * @param e the mouse event
     *
     * @return false always
     */
    protected boolean consumeEvent(MouseEvent e) {
        // always ignore the event
        return false;
    }

    /**
     * <p>
     * This method implements the contract of WayPointListener interface.
     * </p>
     *
     * <p>
     * This method prints the received event to the console .
     * </p>
     *
     * @param e the way point event
     */
    public void wayPointDragged(WayPointEvent e) {
        System.out.printf("Receive a way point dragged event, "
            + "the old position is %s, the new position is %s, the offset is %s.\r\n", e.getOldPosition(),
            e.getNewPosition(), e.getOffset());
    }

    /**
     * <p>
     * This method implements the contract of EdgeDragListener interface.
     * </p>
     *
     * <p>
     * This method prints the received event to the console .
     * </p>
     *
     * @param e the way point event
     */
    public void edgeDragged(WayPointEvent e) {
        System.out.printf("Receive a edge dragged event, "
            + "the old position is %s, the new position is %s, the offset is %s.\r\n", e.getOldPosition(),
            e.getNewPosition(), e.getOffset());
    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        // set up the diagram instance
        Diagram diagram = new Diagram();
        GraphEdge edge = new GraphEdge();
        edge.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
        edge.addWaypoint(TestHelper.createDiagramInterchangePoint(200, 200));
        edge.addWaypoint(TestHelper.createDiagramInterchangePoint(300, 400));
        diagram.addContained(edge);

        // set up the edge instance
        TriangleEdgeEnding ending = new TriangleEdgeEnding(0, new Point(200, 100));

        GeneralizationEdge gEdge = new GeneralizationEdge(edge, ending);
        gEdge.setShowTextFields(true);
        gEdge.addTextField(new GraphNode(), "Head", AnchorType.LeftEnding);
        gEdge.addTextField(new GraphNode(), "Head2", AnchorType.LeftEnding);
        gEdge.addTextField(new GraphNode(), "Tail", AnchorType.RightEnding);
        gEdge.addTextField(new GraphNode(), "Tail2", AnchorType.RightEnding);
        gEdge.addTextField(new GraphNode(), "Middle", AnchorType.Line);
        gEdge.addTextField(new GraphNode(), "Middle2", AnchorType.Line);

        // set up the JFrame instance and show it
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MouseAdapter adapter = new ContentPaneMouseListener(gEdge);
        frame.getContentPane().addMouseListener(adapter);
        frame.getContentPane().add(gEdge);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
    }
}

/**
 * <p>
 * This class extends the MouseAdapter class and is used as a mouse listen to listen to
 * the mouse press event.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
class ContentPaneMouseListener extends MouseAdapter {
    /**
     * <p>
     * The GeneralizationEdge instance that this listener is interested.
     * </p>
     */
    private GeneralizationEdge edge;

    /**
     * <p>
     * Construct a ContentPaneMouseListener instance with edge given.
     * </p>
     *
     * @param edge the GeneralizationEdge instance
     */
    public ContentPaneMouseListener(GeneralizationEdge edge) {
        this.edge = edge;
    }

    /**
     * <p>
     * This method is invoked when the mouse is clicked on the
     * </p>
     *
     * <p>
     * The edge instance set in the constructor and its child TextField components
     * will be notified un-selected in this method.
     * </p>
     *
     * @param e the mouse event instance
     */
    public void mousePressed(MouseEvent e) {
        edge.notifyUnselected();

        for (int i = 0; i < edge.getComponentCount(); i++) {
            Component c = edge.getComponent(i);

            if (c instanceof TextField) {
                TextField textField = (TextField) c;
                textField.setSelected(false);
            }
        }
    }
}