/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.util.List;

import javax.swing.JLabel;

import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * This class represents the text field anchored on Edge. This class extends
 * SWING JLabel class.
 * </p>
 *
 * <p>
 * This swing custom component represents a graph node which represents the text
 * field in UML Diagram.
 * </p>
 *
 * <p>
 * Thread Safety : This class is mutable and not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class TextField extends JLabel {
    /**
     * <p>
     * Represent the background when this text field is selected.
     * </p>
     */
    private static final Color SELECTED_BACKGROUND = Color.YELLOW;

    /**
     * <p>
     * Represent the background when this text field is not selection.
     * </p>
     */
    private static final Color UNSELECTED_BACKGROUND = new Color(0, 0, 0, 0);

    /**
     * <p>
     * The GraphNode representing this text field in UML Diagram Interchange.
     * </p>
     *
     * <p>
     * It is initialized in constructor, and never changed later.
     * </p>
     *
     * <p>
     * It will never be null and can be accessed via getter.
     * </p>
     */
    private final GraphNode graphNode;

    /**
     * <p>
     * Represent the point on the edge where this text field is anchored.
     * </p>
     *
     * <p>
     * A line will be draw between this point and the text field if edge is selected.
     * </p>
     *
     * <p>
     * It can be calculated in updateAnchorage method, and also can be accessed by setter/getter.
     * It is null initially.
     * </p>
     *
     */
    private Point anchorage;

    /**
     * <p>
     * This is the flag indicating whether this text field is selected or not.
     * </p>
     *
     * <p>
     * The component UI will draw the background relies on this value.
     * </p>
     *
     * <p>
     * It can be accessed by setter/getter, and it is false initially.
     * </p>
     *
     */
    private boolean isSelected = false;

    /**
     * <p>
     * The anchor type of this text field.
     * </p>
     *
     * <p>
     * It is initialized in the constructor, and never changed later.
     * </p>
     *
     * <p>
     * It will never be null, and can be accessed by getter.
     * </p>
     */
    private final AnchorType anchorType;

    /**
     * <p>
     * Construct a TextField instance with graph node, text and type given.
     * </p>
     *
     * <p>
     * A TextFieldMouseListener instance will be registered automatically.
     * </p>
     *
     * @param graphNode the GraphNode associated with this text field
     * @param text the text string value
     * @param type achorType of this text field
     *
     * @throws IllegalArgumentException if any parameter is null.
     */
    public TextField(GraphNode graphNode, String text, AnchorType type) {
        super((String) Util.checkNull(text, "text"));

        Util.checkNull(graphNode, "graphNode");
        Util.checkNull(type, "type");

        this.graphNode = graphNode;
        this.anchorType = type;

        TextFieldMouseListener listener = new TextFieldMouseListener();
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);

        // this makes the background color work
        this.setOpaque(true);
    }

    /**
     * <p>
     * Get the graph node representing this text field in UML Diagram Interchange.
     * </p>
     *
     * @return the graphNode field.
     */
    public GraphNode getGraphNode() {
        return graphNode;
    }

    /**
     * <p>
     * Get the anchor type of this text field.
     * </p>
     *
     * @return the anchor type of this text field.
     */
    public AnchorType getAnchorType() {
        return anchorType;
    }

    /**
     * <p>
     * Get the anchorage of the text field.
     * </p>
     *
     * <p>
     * Note, the anchorage point is cloned.
     * </p>
     *
     * @return the anchorage of the text field.
     */
    public Point getAnchorage() {
        return (anchorage == null) ? null : new Point(anchorage);
    }

    /**
     * <p>
     * Set the anchorage point of this text field.
     * </p>
     *
     * <p>
     * Note, the given anchorage point is cloned.
     * </p>
     *
     * @param anchorage the new anchorage to set
     *
     * @throws IllegalArgumentException if anchorage is null
     */
    public void setAnchorage(Point anchorage) {
        Util.checkNull(anchorage, "anchorage");

        this.anchorage = new Point(anchorage);
    }

    /**
     * <p>
     * Check whether this text field is selected.
     * </p>
     *
     * @return true if this text field is selected, false otherwise.
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     * <p>
     * Set the text field to be selected or not according the given flag.
     * </p>
     *
     * <p>
     * Note, the background color of this text field is updated as well.
     * </p>
     *
     * @param isSelected the flag to mark this text field selected or not
     */
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;

        setBackground(isSelected ? SELECTED_BACKGROUND : UNSELECTED_BACKGROUND);

        // The edge should be repainted as well because the line between
        // the anchorage and the text field should be drawn or not
        // based depends on the selected state of this text field
        Container container = getParent();
        if (container instanceof Edge) {
            Edge edge = (Edge) container;
            edge.repaint();
        }
    }

    /**
     * <p>
     * This method will adjust the anchorage of this text field according to the location.
     * </p>
     *
     * <p>
     * The anchorage is located using the following strategy:
     * <ul>
     * <li>Left Ending Anchor - The most left way point of the edge</li>
     * <li>Right Ending Anchor - The most right way point of the edge</li>
     * <li>Line Anchor - The closest point on the segments of edge to the text field</li>
     * </ul>
     * </p>
     *
     * <p>
     * Note, this method will take effect when the parent of this swing component is an Edge,
     * otherwise it does nothing.
     * </p>
     */
    public void updateAnchorage() {
        // the parent component should be an edge
        // if no, it does nothing
        Container container = getParent();
        if (!(container instanceof Edge)) {
            return;
        }

        Edge edge = (Edge) container;
        switch (anchorType) {
        case LeftEnding: {
            // find the most left way point
            anchorage = edge.getWayPoints().get(0).getCenter();
            break;
        }
        case RightEnding: {
            // find the most right way point
            List<SelectionCorner> corners = edge.getWayPoints();
            anchorage = corners.get(corners.size() - 1).getCenter();
            break;
        }
        case Line: {
            // find the closest point on the segments of edge
            double shorestDist = Double.MAX_VALUE;
            Point shorestPoint = new Point();

            List<SelectionCorner> wayPoints = edge.getWayPoints();
            Point curPoint = new Point();
            for (int i = 0; i < wayPoints.size() - 1; i++) {
                double dist = Util.getClosestPoint(this.getLocation(), wayPoints.get(i).getCenter(), wayPoints.get(
                    i + 1).getCenter(), curPoint);
                if (dist < shorestDist) {
                    shorestDist = dist;
                    shorestPoint.setLocation(curPoint);
                }
            }

            anchorage = shorestPoint;
            break;
        }
        default: {
            // does nothing
        }
        }
    }

    /*
     * BugFix: BUGID UML-7694
     * Description:
     * The Diagram Edges component should use the color mentioned in the properties of
     * GraphEdge to paint the edge - the stroke color.
     * The component should also use the font family, font color and font size properties
     * of GraphEdge to paint the text fields anchored to the edge.
     * The names of the properties should be configurable.
     * The color values are represented like this: "#RRGGBB".
     * Solution:
     * Add the property map, which is used to get the property keys. Add strokeColor and
     * fontColor fields. Add a public notifyProperitesChange method to retrieve properties
     * from graph edge. Add a setter of fontColor to TextField class.
     */
    /**
     * <p>
     * Setter of font color of this TextField. This method should be overriden by
     * subclasses.
     * </p>
     */
    public void setFontColor(Color fontColor) {
        // do nothing as this method will be overriden
    }
}
