/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;

/**
 * <p>
 * This class represents an edge in uml diagram.
 * </p>
 *
 * <p>
 * It is an extension of JComponent. This custom component draws the line by
 * itself. All the selection corners, line endings, and anchored text fields are
 * represented as its children and drawn by the corresponding classes.
 * </p>
 *
 * <p>
 * In this swing component, the following properties are configurable:
 * <ul>
 * <li>The line style</li>
 * <li>Active width - the active area of the edge</li>
 * <li>Align deviation - the deviation in which two segments will be aligned
 * automatically</li>
 * </ul>
 *
 * <p>
 * This class provides two kinds of events. User can register this event as
 * other events. They are way point dragged event and edge dragged event.
 * </p>
 *
 * <p>
 * Thread Safety : This class is mutable, and not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public abstract class Edge extends JComponent {
	/**
	 * <p>
	 * Represents the default active width value.
	 * </p>
	 */
	public static final int DEFAULT_ACTIVE_WIDTH = 10;

	/**
	 * <p>
	 * Represents the default align deviation value.
	 * </p>
	 */
	public static final double DEFAULT_ALIGN_DEVIATION = 0.5;

	/**
	 * <p>
	 * Represent the gap spaces when calculating the position of a text field.
	 * </p>
	 */
	private static final int GAP = 5;

	/**
	 * <p>
	 * Represent all the selection corners of way point on this edge.
	 * </p>
	 *
	 * <p>
	 * It is initialized in the constructor, and its content is filled by the
	 * wayPoints defined in GraphEdge. Its content can be changed by
	 * notifyAdd/Remove/ChangeWayPoint.
	 * </p>
	 *
	 * <p>
	 * It will never be null, and the element will never be null.
	 * </p>
	 *
	 * <p>
	 * Note, it has the same order as way points in GraphEdge.
	 * </p>
	 */
	private final List<SelectionCorner> wayPoints = new ArrayList<SelectionCorner>();

	/**
	 * <p>
	 * Represent the flag to tell whether to show text fields when the edge is
	 * not selected.
	 * </p>
	 *
	 * <p>
	 * The default value for this variable is false.
	 * </p>
	 *
	 * <p>
	 * This variable can be accessed by setter/getter.
	 * </p>
	 */
	private boolean showTextFields = false;

	/**
	 * <p>
	 * Represent all the text fields anchored on the edge.
	 * </p>
	 *
	 * <p>
	 * It is empty initially and can be accessed by the corresponding
	 * add/remove/get methods.
	 * </p>
	 *
	 * <p>
	 * It will never be null, and the element will never be null.
	 * </p>
	 */
	private final Map<GraphNode, TextField> textFields = new HashMap<GraphNode, TextField>();

	/**
	 * <p>
	 * Represent all the left anchored text fields whose position is not set
	 * initially.
	 * </p>
	 *
	 * <p>
	 * It is empty initially and is updated according to the textFields
	 * variable.
	 * </p>
	 */
	private final List<TextField> leftAnchoredTextFields = new ArrayList<TextField>();

	/**
	 * <p>
	 * Represent all the right anchored text fields whose position is not set
	 * initially.
	 * </p>
	 *
	 * <p>
	 * It is empty initially and is updated according to the textFields
	 * variable.
	 * </p>
	 */
	private final List<TextField> rightAnchoredTextFields = new ArrayList<TextField>();

	/**
	 * <p>
	 * Represent all the line anchored fields whose position is not set
	 * initially.
	 * </p>
	 *
	 * <p>
	 * The size of this variable is the size of the segments of the edge. Each
	 * element in this variable is a list, which represent a set of text fields
	 * anchored on the segment.
	 * </p>
	 *
	 * <p>
	 * It is empty initially and is updated according to the textFields
	 * variable.
	 * </p>
	 */
	private final List<List<TextField>> segmentsTextFields = new ArrayList<List<TextField>>();

	/**
	 * <p>
	 * Represent the active width of this edge.
	 * </p>
	 *
	 * <p>
	 * It means the edge can response mouse event in the range of active width.
	 * </p>
	 *
	 * <p>
	 * It is initialized with DEFAULT_AVTIVEWIDTH initially and can be accessed
	 * by getter/setter.
	 * </p>
	 */
	private int activeWidth = DEFAULT_ACTIVE_WIDTH;

	/**
	 * <p>
	 * Represent the align deviation of this edge.
	 * </p>
	 *
	 * <p>
	 * It means two neighbor segments whose angle is less than this value will
	 * be merged.
	 * </p>
	 *
	 * <p>
	 * It is initialized with DEFAULT_ALIGNDEVIATION initially and can be
	 * accessed by getter/setter.
	 * </p>
	 */
	private double alignDeviation = DEFAULT_ALIGN_DEVIATION;

	/**
	 * <p>
	 * Represent the GraphEdge instance defining this Edge.
	 * </p>
	 *
	 * <p>
	 * Initialized in constructor, and never changed later.
	 * </p>
	 *
	 * <p>
	 * It will never be null.
	 * </p>
	 */
	private final GraphEdge graphEdge;

	/**
	 * <p>
	 * Represent the line style of this Edge.
	 * </p>
	 *
	 * <p>
	 * Initialized in constructor, and never changed later.
	 * </p>
	 *
	 * <p>
	 * It will never be null.
	 * </p>
	 */
	private final LineStyle lineStyle;

	/**
	 * <p>
	 * Represent the left ending of this Edge.
	 * </p>
	 *
	 * <p>
	 * Initialized in constructor, and never changed later.
	 * </p>
	 *
	 * <p>
	 * It can be null, which means no left ending is needed.
	 * </p>
	 */
	private EdgeEnding leftEnding;

	/**
	 * <p>
	 * Represent the right ending of this Edge.
	 * </p>
	 *
	 * <p>
	 * Initialized in constructor, and never changed later.
	 * </p>
	 *
	 * <p>
	 * It can be null, which means no right ending is needed.
	 * </p>
	 */
	private EdgeEnding rightEnding;

	/**
	 * <p>
	 * Represent the left ending connector of this Edge.
	 * </p>
	 *
	 * <p>
	 * It is null initially and can be accessed by setter/getter.
	 * </p>
	 *
	 * <p>
	 * When it is null, it means no left connector is needed.
	 * </p>
	 */
	private Connector leftConnector;

	/**
	 * <p>
	 * Represent the right ending connector of this Edge.
	 * </p>
	 *
	 * <p>
	 * It is null initially and can be accessed by setter/getter.
	 * </p>
	 *
	 * <p>
	 * When it is null, it means no right connector is needed.
	 * </p>
	 */
	private Connector rightConnector;

	/*
	 * BugFix: BUGID UML-7694 Description: The Diagram Edges component should
	 * use the color mentioned in the properties of GraphEdge to paint the edge -
	 * the stroke color. The component should also use the font family, font
	 * color and font size properties of GraphEdge to paint the text fields
	 * anchored to the edge. The names of the properties should be configurable.
	 * The color values are represented like this: "#RRGGBB". Solution: Add the
	 * property map, which is used to get the property keys. Add strokeColor and
	 * fontColor fields. Add a public notifyProperitesChange method to retrieve
	 * properties from graph edge. Add a setter of fontColor to TextField class.
	 */
	/**
	 * <p>
	 * Represents the property name mapping.
	 * </p>
	 * <p>
	 * Each key in the map is used to get the text string of the graphEdge
	 * property. This string will be used to get the current value from the
	 * graphEdge.getProperties map. These properties are: color (stroke and
	 * font), font (color, family, size) and so on.
	 * </p>
	 * <p>
	 * Same property may have different property names, because the property
	 * names are standard. For example, font color property may be named as
	 * "FontColor", "font_color", or etc.
	 * </p>
	 * <p>
	 * The key is the predefined property keys, and the value is the actual
	 * property name. In this class, "StrokeColor", "FontColor", and
	 * "FontFamily", "FontSize" are used as predefined keys.
	 * </p>
	 * <p>
	 * It can be acessed by setter. Neither the key nor the value could be null
	 * or empty.
	 * </p>
	 */
	private Map<String, String> properties;

	/**
	 * <p>
	 * Represents the stroke color value retrieved from GraphEdge property.
	 * </p>
	 * <p>
	 * It will be used by concrete node to draw the node shape.
	 * </p>
	 * It can be null, if there is no corresponding property. It will be first
	 * retrieved in constructor, and updated in notifyPropertiesChange. Default
	 * to black.
	 */
	private Color strokeColor = Color.BLACK;

	/**
	 * <p>
	 * Represents the font color value retrieved from GraphEdge property.
	 * </p>
	 * <p>
	 * It will be used by concrete node to write text on the node.
	 * </p>
	 * It can be null, if there is no corresponding property. It will be first
	 * retrieved in constructor, and updated in notifyPropertiesChange. Default
	 * to black.
	 */
	private Color fontColor = Color.BLACK;

	/**
	 * <p>
	 * Construct an Edge with graph edge, line style, left ending and right
	 * ending given.
	 * </p>
	 *
	 * <p>
	 * Each way point in the given graph edge will have its corresponding
	 * selection corner in this edge instance.
	 * </p>
	 *
	 * <p>
	 * Each selection corner will have a WayPointMouseListener instance
	 * registered automatically. This edge will have a EdgeMouseListerner
	 * registered automatically.
	 * </p>
	 *
	 * @param graphEdge
	 *            the associated graphEdge
	 * @param lineStyle
	 *            the line style of this edge
	 * @param leftEnding
	 *            the left ending of this edge
	 * @param rightEnding
	 *            the right ending of this edge.
	 *
	 * @throws IllegalArgumentException
	 *             if graphEdge or lineStyle is null, or the size of way points
	 *             of the graph edge is less than two
	 */
	protected Edge(GraphEdge graphEdge, LineStyle lineStyle,
			EdgeEnding leftEnding, EdgeEnding rightEnding) {
		Util.checkNull(graphEdge, "graphEdge");
		Util.checkNull(lineStyle, "lineStyle");
		if (graphEdge.getWaypoints().size() < 2) {
			throw new IllegalArgumentException(
					"The size of way points for the given way edge is less than 2.");
		}

		this.graphEdge = graphEdge;
		this.leftEnding = leftEnding;
		this.rightEnding = rightEnding;

		this.lineStyle = lineStyle;

		// get the absolution position of the container of the graph edge in the
		// graph node container hierarchy
		Point refPoint = getAbsoluatePosition(graphEdge.getContainer());

		for (com.topcoder.diagraminterchange.Point point : graphEdge
				.getWaypoints()) {
			wayPoints.add(createSelectionCorner(refPoint, point));
		}

		// for each segment, create an empty list entry in segmentsTextFields
		for (int i = 0; i < wayPoints.size() - 1; i++) {
			segmentsTextFields.add(new ArrayList<TextField>());
		}

		EdgeMouseListener edgeMouseListener = new EdgeMouseListener();
		this.addMouseListener(edgeMouseListener);
		this.addMouseMotionListener(edgeMouseListener);

		if (this.leftEnding != null) {
			add(leftEnding);

			// update the angle and the ending point
			Point pt1 = wayPoints.get(0).getCenter();
			Point pt2 = wayPoints.get(1).getCenter();
			updateEdgeEnding(this.leftEnding, pt1, pt2, pt1);
		}

		if (rightEnding != null) {
			add(rightEnding);

			// update the angle and the ending point
			int size = wayPoints.size();
			Point pt1 = wayPoints.get(size - 2).getCenter();
			Point pt2 = wayPoints.get(size - 1).getCenter();
			updateEdgeEnding(this.rightEnding, pt1, pt2, pt2);
		}
	}

	/**
	 * <p>
	 * This method creates a SelectionCorner instance based on the given
	 * reference point and the diagram interchange point.
	 * </p>
	 *
	 * @param refPoint
	 *            the absolute position of the graph element who contains the
	 *            edge
	 * @param point
	 *            the way point position in the diagram interchange graph
	 *            element
	 *
	 * @return the corresponding SelectionCorner instance
	 */
	private SelectionCorner createSelectionCorner(Point refPoint,
			com.topcoder.diagraminterchange.Point point) {
		SelectionCorner corner = new SelectionCorner(convertPoint(point,
				refPoint));

		// register the WayPointMouseListener instance
		WayPointMouseListener waypointMouseListener = new WayPointMouseListener(
				this);
		corner.addMouseListener(waypointMouseListener);
		corner.addMouseMotionListener(waypointMouseListener);

		/*
		 * Bugfix: UML-9581 After the selection corner is created it should be
		 * set to invisible.
		 */
		corner.setVisible(false);
		this.add(corner);
		return corner;
	}

	/**
	 * <p>
	 * Update the given edge ending according to the given segment and its
	 * ending point.
	 * </p>
	 *
	 * @param edgeEnding
	 *            the EdgeEnding instance
	 * @param pt1
	 *            the start point
	 * @param pt2
	 *            the end point
	 * @param endingPt
	 *            the ending point
	 */
	private void updateEdgeEnding(EdgeEnding edgeEnding, Point pt1, Point pt2,
			Point endingPt) {
		edgeEnding.setAngle(Util.calculateLineAngle(pt1, pt2));
		edgeEnding.setEndingPoint(endingPt);
	}

	/**
	 * <p>
	 * Get diagram viewer containing this Node.
	 * </p>
	 *
	 * <p>
	 * Note, the return value may be null if the parent is not diagram viewer.
	 * </p>
	 *
	 * @return the diagram viewer containing this node, or null if the parent is
	 *         not diagram viewer
	 */
	protected DiagramViewer getDiagramViewer() {
		Container parent = this.getParent();
		// BugFix: UML-9432
		// An edge's parent should be an instance of DiagramView, not
		// DiagramViewer
		// return (parent instanceof DiagramViewer) ? (DiagramViewer) parent :
		// null;
		return (parent instanceof DiagramView) ? ((DiagramView) parent)
				.getViewer() : null;
	}

	/**
	 * <p>
	 * Get grpahEdge associated with this edge.
	 * </p>
	 *
	 * @return the graphEdge associated with this edge.
	 */
	public GraphEdge getGraphEdge() {
		return graphEdge;
	}

	/**
	 * <p>
	 * This method overrides the contains method for defining custom shape.
	 * </p>
	 *
	 * <p>
	 * If (x, y) is in the range of activeWidth or the point is inside any child
	 * component, return true, otherwise return false.
	 * </p>
	 *
	 * <p>
	 * Note, this method is invoked by the Swing framework, in order to make
	 * sure the child components receive the mouse event, the contains method of
	 * child components are invoked and the point is transformed before passing
	 * to child component.
	 * </p>
	 *
	 * @param x
	 *            the x-coordinate value
	 * @param y
	 *            the y-coordinate value
	 *
	 * @return true if the given point is inside this edge or any of its child
	 *         component, false otherwise
	 */
	public boolean contains(int x, int y) {
		// check the point is in the range of activeWidth
		for (int i = 0; i < wayPoints.size() - 1; i++) {
			Point pt1 = wayPoints.get(i).getCenter();
			Point pt2 = wayPoints.get(i + 1).getCenter();
			if (Line2D.ptSegDist(pt1.x, pt1.y, pt2.x, pt2.y, x, y) <= activeWidth / 2) {
				return true;
			}
		}

		// check the child components
		for (int i = 0; i < getComponentCount(); i++) {
			Component c = getComponent(i);
			Point pt = SwingUtilities.convertPoint(this, x, y, c);
			if (c.contains(pt.x, pt.y)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * <p>
	 * Override the getSize() method.
	 * </p>
	 *
	 * <p>
	 * In this method, the size of the edge is marked as large as its parent.
	 * </p>
	 *
	 * <p>
	 * Note, if the parent component is null then this method return a dimension
	 * with zero width and zero height.
	 * </p>
	 *
	 * @return the size of this edge.
	 */
	public Dimension getSize() {
		Container parent = getParent();

		return parent == null ? new Dimension(0, 0) : parent.getSize();
	}

	/**
	 * <p>
	 * Notify the edge that it is un-selected.
	 * </p>
	 *
	 * <p>
	 * This method will hide the text field if show text fields flag is false
	 * and hide all the selection corners.
	 * </p>
	 */
	public void notifyUnselected() {
		/*
		 * BugFix: BUGID UML-7684 Description: The stereotype and edge name for
		 * edges should be shown at all times, not just when the edge is
		 * selected. Solution: Remove the code to set text fields invisible,
		 * since they're always visible.
		 */
		// old code
		// // hide the text fields if showTextFields is false
		// if (!showTextFields) {
		// for (TextField textField : textFields.values()) {
		// textField.setVisible(false);
		// }
		// }
		// hide all the selection corners
		for (SelectionCorner corner : this.wayPoints) {
			corner.setVisible(false);
		}

		repaint();
	}

	/**
	 * <p>
	 * Get all the contained waypoints.
	 * </p>
	 *
	 * <p>
	 * Note, the return list is unmodifiable.
	 * </p>
	 *
	 * @return the unmodifiable list of waypoints.
	 */
	public List<SelectionCorner> getWayPoints() {
		return Collections.unmodifiableList(wayPoints);
	}

	/**
	 * <p>
	 * Notify the edge that a way point is removed.
	 * </p>
	 *
	 * <p>
	 * The position of affected anchored text fields will be updated and the
	 * selection corner will be removed.
	 * </p>
	 *
	 * <p>
	 * Note, the size of way points after remove operation is less than 2.
	 * </p>
	 *
	 * @param index
	 *            the index of removed way point
	 * @param removedPoint
	 *            the position of the removed way point
	 *
	 * @throws IllegalArgumentException
	 *             is removedPoint is null
	 * @throws IndexOutOfBoundsException
	 *             if index is out of bounds
	 */
	public void notifyRemoveWayPoint(int index, Point removedPoint) {
		Util.checkNull(removedPoint, "removedPoint");

		// the edge must have at least two way points
		if (this.wayPoints.size() == 2) {
			throw new IllegalArgumentException(
					"The size of way points after remove operation is less than 2.");
		}

		// get all the affected text fields
		List<TextField> affectedTextFields = new ArrayList<TextField>();
		if (index == 0) {
			affectedTextFields.addAll(this.leftAnchoredTextFields);
			affectedTextFields.addAll(this.segmentsTextFields.get(0));
		} else if (index == this.wayPoints.size() - 1) {
			affectedTextFields.addAll(this.rightAnchoredTextFields);
			affectedTextFields.addAll(this.segmentsTextFields
					.get(this.segmentsTextFields.size() - 1));
		} else {
			affectedTextFields.addAll(this.segmentsTextFields.get(index - 1));
			affectedTextFields.addAll(this.segmentsTextFields.get(index));
		}

		// remove the selection corner
		SelectionCorner corner = this.wayPoints.remove(index);
		remove(corner);
		segmentsTextFields.remove(index);

		// update the positions of all the affected text fields
		for (TextField textField : affectedTextFields) {
			removeTextField(textField);
		}

		for (TextField textField : affectedTextFields) {
			updateTextFieldPosition(textField);
		}

		repaint();
	}

	/**
	 * <p>
	 * Notify the edge that a way point is added.
	 * </p>
	 *
	 * <p>
	 * The position of affected anchored text fields will be updated and a new
	 * selection corner will be added.
	 * </p>
	 *
	 * @param index
	 *            the index of new way point
	 *
	 * @throws IndexOutOfBoundsException
	 *             if index is out of bounds.
	 */
	public void notifyAddWayPoint(int index) {
		// get all the affected text fields
		List<TextField> affectedTextFields = new ArrayList<TextField>();
		if (index == 0) {
			affectedTextFields.addAll(this.leftAnchoredTextFields);
		} else if (index == this.wayPoints.size()) {
			affectedTextFields.addAll(this.rightAnchoredTextFields);
		} else {
			affectedTextFields.addAll(this.segmentsTextFields.get(index - 1));
		}

		// add the corresponding selection corner
		Point refPoint = getAbsoluatePosition(graphEdge.getContainer());
		this.wayPoints.add(index, this.createSelectionCorner(refPoint,
				graphEdge.getWaypoints().get(index)));
		this.segmentsTextFields.add(index, new ArrayList<TextField>());

		// update the positions of all the affected text fields
		for (TextField textField : affectedTextFields) {
			removeTextField(textField);
		}

		for (TextField textField : affectedTextFields) {
			updateTextFieldPosition(textField);
		}

		repaint();
	}

	/**
	 * <p>
	 * Notify the edge that the position of a way point is changed.
	 * </p>
	 *
	 * <p>
	 * The position of affected anchored text fields will be updated and the
	 * position of selection corner will be updated.
	 * </p>
	 *
	 * @param index
	 *            the index of changed way point
	 * @param oldPoint
	 *            the old position of way point.
	 *
	 * @throws IllegalArgumentException
	 *             if oldPoint is null
	 * @throws IndexOutOfBoundsException
	 *             if index is out of bounds.
	 */
	public void notifyChangeWayPoint(int index, Point oldPoint) {
		Util.checkNull(oldPoint, "oldPoint");

		// update the selection corner
		Point refPoint = getAbsoluatePosition(graphEdge.getContainer());
		Point newPoint = convertPoint(graphEdge.getWaypoints().get(index),
				refPoint);
		this.wayPoints.get(index).setCenter(newPoint);

		// update the positions of all the affected text fields

		// update the left segment of the changed way point
		if (index - 1 >= 0) {
			Point startPoint = wayPoints.get(index - 1).getCenter();

			Line2D line = new Line2D.Double(wayPoints.get(index - 1)
					.getCenter(), wayPoints.get(index).getCenter());

			double rotateAngle = Util.calculateLineAngle(startPoint, newPoint)
					- Util.calculateLineAngle(startPoint, oldPoint);
			/*
			 * BugFix: BUGID UML-7094 Description: Rotation angle is computed
			 * wrong. Supposing a point's old angle is -3PI/4, then it is
			 * dragged to a new position with 3PI/4 angle clockwise, this method
			 * will treat the rotating angle as 3PI/2, but it should be PI/2.
			 * Solution: Adjust the angle if it is outside the range [-PI, PI].
			 */
			if (rotateAngle > Math.PI) {
				rotateAngle = rotateAngle - Math.PI * 2;
			} else if (rotateAngle < -Math.PI) {
				rotateAngle = Math.PI * 2 + rotateAngle;
			}

			// create an AffineTransform instance
			/*
			 * BugFix: BUGID UML-7094 Description: When using AffineTransform
			 * class, only rotate is used. This needs to be looked at, because
			 * distance between waypoints can also be changed. Solution: Create
			 * the AffineTransform according to the angle and distance changed.
			 */
			// old code
			// AffineTransform at =
			// AffineTransform.getRotateInstance(rotateAngle, startPoint.x,
			// startPoint.y);
			AffineTransform at = new AffineTransform();
			at.setToTranslation(startPoint.x, startPoint.y);
			double newDistance = startPoint.distance(newPoint);
			double oldDistance = startPoint.distance(oldPoint);
			at.rotate(rotateAngle);
			// BUGR-175: text can move erratically because of division by zero
			if (oldDistance > 0.0000000000000001) {
				at.scale(newDistance / oldDistance, newDistance / oldDistance);
			}
			at.translate(-startPoint.x, -startPoint.y);

			// rotate the text fields that are right anchored
			if (index == wayPoints.size() - 1) {
				rotateTextFields(at, rightAnchoredTextFields, line, rotateAngle);
			}
			if (index == 1) {
				rotateTextFields(at, leftAnchoredTextFields, line, rotateAngle);
			}

			// rotate the text fields that are line anchored
			rotateTextFields(at, segmentsTextFields.get(index - 1), line,
					rotateAngle);
		}

		// update the right segment of the changed way point
		if (index + 1 < wayPoints.size()) {
			Point startPoint = wayPoints.get(index + 1).getCenter();

			Line2D line = new Line2D.Double(wayPoints.get(index).getCenter(),
					wayPoints.get(index + 1).getCenter());

			double rotateAngle = Util.calculateLineAngle(startPoint, newPoint)
					- Util.calculateLineAngle(startPoint, oldPoint);
			/*
			 * BugFix: BUGID UML-7094 Description: Rotation angle is computed
			 * wrong. Supposing a point's old angle is -3PI/4, then it is
			 * dragged to a new position with 3PI/4 angle clockwise, this method
			 * will treat the rotating angle as 3PI/2, but it should be PI/2.
			 * Solution: Adjust the angle if it is outside the range [-PI, PI].
			 */
			if (rotateAngle > Math.PI) {
				rotateAngle = rotateAngle - Math.PI * 2;
			} else if (rotateAngle < -Math.PI) {
				rotateAngle = Math.PI * 2 + rotateAngle;
			}

			// create an AffineTransform instance
			/*
			 * BugFix: BUGID UML-7094 Description: When using AffineTransform
			 * class, only rotate is used. This needs to be looked at, because
			 * distance between waypoints can also be changed. Solution: Create
			 * the AffineTransform according to the angle and distance changed.
			 */
			// old code
			// AffineTransform at =
			// AffineTransform.getRotateInstance(rotateAngle, startPoint.x,
			// startPoint.y);
			AffineTransform at = new AffineTransform();
			at.setToTranslation(startPoint.x, startPoint.y);
			double newDistance = startPoint.distance(newPoint);
			double oldDistance = startPoint.distance(oldPoint);
			at.rotate(rotateAngle);
			// BUGR-175: text can move erratically because of division by zero
			if (oldDistance > 0.0000000000000001) {
				at.scale(newDistance / oldDistance, newDistance / oldDistance);
			}
			at.translate(-startPoint.x, -startPoint.y);

			// rotate the text fields that are left anchored
			if (index == 0) {
				rotateTextFields(at, leftAnchoredTextFields, line, rotateAngle);
			}

			// rotate the text fields that are left anchored
			if (index == wayPoints.size() - 2) {
				rotateTextFields(at, rightAnchoredTextFields, line, rotateAngle);
			}

			// rotate the text fields that are line anchored
			rotateTextFields(at, segmentsTextFields.get(index), line,
					rotateAngle);
		}

		/*
		 * BugFix: BUGID UML-7094 Description: When the ending waypoint is
		 * changed, the EdgeEnding should also be updated. Solution: Code is
		 * added as follows to update affected edge endings.
		 */
		if (index == 0 && leftEnding != null) {
			int size = wayPoints.size();
			Point start = wayPoints.get(1).getCenter();
			Point end = wayPoints.get(0).getCenter();
			updateEdgeEnding(leftEnding, start, end, end);
			if (size == 2 && rightEnding != null) {
				updateEdgeEnding(rightEnding, end, start, start);
			}
		} else if (index == wayPoints.size() - 1 && rightEnding != null) {
			int size = wayPoints.size();
			Point start = wayPoints.get(size - 2).getCenter();
			Point end = wayPoints.get(size - 1).getCenter();
			updateEdgeEnding(rightEnding, start, end, end);
			if (size == 2 && leftEnding != null) {
				updateEdgeEnding(leftEnding, end, start, start);
			}
		}

		repaint();
	}

	/**
	 * <p>
	 * This method rotates the position of the given <code>TextField</code>
	 * list.
	 * </p>
	 *
	 * <p>
	 * Note, the location and the anchorage of each text field are rotated.
	 * </p>
	 *
	 * @param at
	 *            the <code>AffineTransform</code> instance for rotating all
	 *            the text fields
	 * @param textFields
	 *            the list of text fields to rotate
	 * @param line
	 *            the given line
	 */
	private void rotateTextFields(AffineTransform at,
			List<TextField> textFields, Line2D line, double angle) {
		for (TextField textField : textFields) {

			Point d = new Point(-textField.getAnchorage().x
					+ textField.getLocation().x, -textField.getAnchorage().y
					+ textField.getLocation().y);

			if (textField.getAnchorType().equals(AnchorType.Line)) {
				Point newLoc = transform(at, textField.getAnchorage());

				double len2 = Math.pow(line.getX2() - line.getX1(), 2)
						+ Math.pow(line.getY2() - line.getY1(), 2);
				double u = ((((double) newLoc.getLocation().x - line.getX1()) * (line
						.getX2() - line.getX1())) + (((double) newLoc.y - line
						.getY1()) * (line.getY2() - line.getY1())))
						/ (len2);
				double x = line.getX1() + u * (line.getX2() - line.getX1());
				double y = line.getY1() + u * (line.getY2() - line.getY1());
				if (new Double(u).isNaN()) {
					x = line.getX1();
					y = line.getY1();
				} else if (len2 < 500) {
					x = (line.getX1() + line.getX2()) / 2;
					y = (line.getY1() + line.getY2()) / 2;
				} else if (Math.abs(myPtSegDist(line.getX1(), line.getY1(),
						line.getX2(), line.getY2(), x, y)
						- line.ptLineDist(new Point2D.Double(x, y))) > 0.0001) {

					double d1 = line.getP1().distance(new Point2D.Double(x, y));
					double d2 = line.getP2().distance(new Point2D.Double(x, y));
					if (d1 < d2) {
						x = line.getX1();
						y = line.getY1();
					} else {
						x = line.getX2();
						y = line.getY2();
					}
				} else {
					x = line.getX1() + u * (line.getX2() - line.getX1());
					y = line.getY1() + u * (line.getY2() - line.getY1());
				}

				textField.setAnchorage(new Point((int) Math.round(x),
						(int) Math.round(y)));
			} else if (textField.getAnchorType().equals(AnchorType.RightEnding)) {
				textField.setAnchorage(new Point((int) line.getX2(), (int) line
						.getY2()));
			} else if (textField.getAnchorType().equals(AnchorType.LeftEnding)) {
				textField.setAnchorage(new Point((int) line.getX1(), (int) line
						.getY1()));
			}

			AffineTransform t = new AffineTransform();
			t.rotate(angle);
			d = transform(t, d);

			textField.setLocation(textField.getAnchorage().x + d.x, textField
					.getAnchorage().y
					+ d.y);

			GraphNode graphNode = textField.getGraphNode();
			com.topcoder.diagraminterchange.Point position = new com.topcoder.diagraminterchange.Point();
			position.setX(textField.getX());
			position.setY(textField.getY());
			graphNode.setPosition(position);
		}
	}

	/**
	 * Returns the minimum distance of point from a line.
	 *
	 * @param x1
	 *            x1 of the line
	 * @param y1
	 *            y1 of the line
	 * @param x2
	 *            x2 of the line
	 * @param y2
	 *            y2 of the line
	 * @param px
	 *            x of the point
	 * @param py
	 *            y of the point
	 * @return the distance
	 */
	static double myPtSegDist(double x1, double y1, double x2, double y2,
			double px, double py) {
		x2 -= x1;
		y2 -= y1;
		px -= x1;
		py -= y1;
		double dotprod = px * x2 + py * y2;
		if (dotprod <= 0.0) {
			return Math.sqrt(px * px + py * py);
		} else {
			px = x2 - px;
			py = y2 - py;
			dotprod = px * x2 + py * y2;
			if (dotprod <= 0.0) {
				return Math.sqrt(px * px + py * py);
			} else {
				return Math.abs(px * y2 - py * x2)
						/ Math.sqrt(x2 * x2 + y2 * y2);
			}
		}
	}

	/**
	 * <p>
	 * This method rotates the given point according to the given
	 * <code>AffineTransform</code> instance.
	 * </p>
	 *
	 * <p>
	 * </p>
	 *
	 * @param at
	 *            the <code>AffineTransform</code> instance for rotating the
	 *            given point
	 * @param oldPoint
	 *            the point to rotate
	 *
	 * @return the point rotated from the given old point based on the
	 *         <code>AffineTransform</code> instance
	 */
	private Point transform(AffineTransform at, Point oldPoint) {
		Point2D newPoint = at.transform(oldPoint, null);

		/*
		 * BugFix: BUGID UML-7173 Description: After transformation, the
		 * coordinate should have been rounded to int, not cast to and int
		 * directly. Less errors will happen this way. Solution: Code is
		 * modified touse Math.round to get the rounded value.
		 */
		// old code
		// return new Point((int) newPoint.getX(), (int) newPoint.getY());
		return new Point((int) Math.round(newPoint.getX()), (int) Math
				.round(newPoint.getY()));
	}

	/**
	 * <p>
	 * Add a TextField for the given GraphNode.
	 * </p>
	 *
	 * <p>
	 * A new TextFieldMouseListener instance will be registered and the
	 * TextField will be added as a child component automatically.
	 * </p>
	 *
	 * <p>
	 * Note, the position of the text field can be got from the graph node, if
	 * it is not found, then it will be determined automatically.
	 * </p>
	 *
	 * @param graphNode
	 *            a GraphNode defined for TextField
	 * @param text
	 *            the text string value
	 * @param type
	 *            the text field anchor type
	 * @return the newly added TextField instance
	 *
	 * @throws IllegalArgumentException
	 *             if any argument is null.
	 */
	public TextField addTextField(GraphNode graphNode, String text,
			AnchorType type) {
		Util.checkNull(graphNode, "graphNode");
		Util.checkNull(text, "text");
		Util.checkNull(type, "type");

		// create a TextField instance
		TextField textField = new TextField(graphNode, text, type);
		this.textFields.put(graphNode, textField);

		// add as a child component
		add(textField);

		if (graphNode.getPosition() != null) {
			// the position is from the given graph node
			Point position = getAbsoluatePosition(graphNode);
			Rectangle bounds = new Rectangle();
			FontMetrics fm = textField.getFontMetrics(textField.getFont());
			bounds.width = SwingUtilities.computeStringWidth(fm, text);
			bounds.height = fm.getHeight();
			bounds.x = position.x;
			bounds.y = position.y;
			textField.setBounds(bounds);
		} else {
			// the position is determined automatically
			updateTextFieldPosition(textField);
		}

		textField.updateAnchorage();

		// if the position of the text field is not determined automatically
		// then add the text field to the local caches based on the anchor
		// type and the anchorage
		// this is done if the position is determined automatically
		// in updateTextFieldPosition(TextField) method
		if (graphNode.getPosition() != null) {
			switch (textField.getAnchorType()) {
			case LeftEnding: {
				leftAnchoredTextFields.add(textField);
				break;
			}
			case RightEnding: {
				rightAnchoredTextFields.add(textField);
				break;
			}
			case Line: {
				Point anchorage = textField.getAnchorage();
				for (int i = 0; i < wayPoints.size() - 1; i++) {
					Point pt1 = wayPoints.get(i).getCenter();
					Point pt2 = wayPoints.get(i + 1).getCenter();

					// check the anchorage point is on the current segment
					if (Line2D.ptSegDist(pt1.getX(), pt1.getY(), pt2.getX(),
							pt2.getY(), anchorage.getX(), anchorage.getY()) < activeWidth) {
						segmentsTextFields.get(i).add(textField);
					}
				}
				break;
			}
			default: {
				// does nothing
			}
			}
		}

		repaint();

		return textField;
	}

	/*
	 * BugFix: BUGID UML-7174 Description: There needs to be a method that
	 * allows a user to add a custom TextField to the edge. Solution: This
	 * method is added.
	 */
	/**
	 * <p>
	 * Add a TextField to this edge.
	 * </p>
	 * <p>
	 * A new TextFieldMouseListener instance will be registered and the
	 * TextField will be added as a child component automatically.
	 * </p>
	 * <p>
	 * Note, the position of the text field can be got from the graph node, if
	 * it is not found, then it will be determined automatically.
	 * </p>
	 *
	 * @param textField
	 *            a TextField needs to be added
	 * @param type
	 *            the text field anchor type
	 * @throws IllegalArgumentException
	 *             if any argument is null.
	 */
	public void addTextField(TextField textField, AnchorType type) {
		Util.checkNull(textField, "textField");
		Util.checkNull(type, "type");

		GraphNode graphNode = textField.getGraphNode();
		this.textFields.put(graphNode, textField);

		// add as a child component
		add(textField);

		if (graphNode.getPosition() != null) {
			// the position is from the given graph node
			Point position = getAbsoluatePosition(graphNode);
			Rectangle bounds = new Rectangle();
			FontMetrics fm = textField.getFontMetrics(textField.getFont());
			bounds.width = SwingUtilities.computeStringWidth(fm, textField
					.getText());
			bounds.height = fm.getHeight();
			bounds.x = position.x;
			bounds.y = position.y;
			textField.setBounds(bounds);
		} else {
			// the position is determined automatically
			updateTextFieldPosition(textField);
		}

		textField.updateAnchorage();

		// if the position of the text field is not determined automatically
		// then add the text field to the local caches based on the anchor
		// type and the anchorage
		// this is done if the position is determined automatically
		// in updateTextFieldPosition(TextField) method
		if (graphNode.getPosition() != null) {
			switch (textField.getAnchorType()) {
			case LeftEnding: {
				leftAnchoredTextFields.add(textField);
				break;
			}
			case RightEnding: {
				rightAnchoredTextFields.add(textField);
				break;
			}
			case Line: {
				Point anchorage = textField.getAnchorage();
				for (int i = 0; i < wayPoints.size() - 1; i++) {
					Point pt1 = wayPoints.get(i).getCenter();
					Point pt2 = wayPoints.get(i + 1).getCenter();

					// check the anchorage point is on the current segment
					if (Line2D.ptSegDist(pt1.getX(), pt1.getY(), pt2.getX(),
							pt2.getY(), anchorage.getX(), anchorage.getY()) < activeWidth) {
						segmentsTextFields.get(i).add(textField);
					}
				}
				break;
			}
			default: {
				// does nothing
			}
			}
		}

		repaint();
	}

	/**
	 * <p>
	 * This method determines the position of the given text field
	 * automatically.
	 * </p>
	 *
	 * <p>
	 * When the type of the text field is Left Ending Anchor, the position of
	 * the text field will near the most left way point.
	 * </p>
	 *
	 * <p>
	 * When the type of the text field is Right Ending Anchor, the position of
	 * the text field will near the most right way point.
	 * </p>
	 *
	 * <p>
	 * When the type of the text field is Line Anchor, the position of the text
	 * field will above or below any segment which has the least number of
	 * anchor text fields.
	 * </p>
	 *
	 * @param textField
	 *            the given text field instance to calculate its position
	 */
	private void updateTextFieldPosition(TextField textField) {
		Rectangle bounds = new Rectangle();
		FontMetrics fm = textField.getFontMetrics(textField.getFont());
		bounds.width = SwingUtilities.computeStringWidth(fm, textField
				.getText()) + 1;
		bounds.height = fm.getHeight() + 2;

		switch (textField.getAnchorType()) {
		case LeftEnding: {
			// set the position near to the most left way point
			SelectionCorner leftCorner = this.wayPoints.get(0);
			Point pt = leftCorner.getCenter();
			if (leftAnchoredTextFields.isEmpty()) {
				bounds.x = pt.x + GAP;
				bounds.y = pt.y - bounds.height - GAP;
			} else {
				bounds.x = pt.x + GAP;
				bounds.y = leftAnchoredTextFields.get(
						leftAnchoredTextFields.size() - 1).getY()
						- bounds.height;
			}
			if (!leftAnchoredTextFields.contains(textField)) {
				leftAnchoredTextFields.add(textField);
			}
			break;
		}
		case RightEnding: {
			// set the position near to the most right way point
			int index = this.wayPoints.size() - 1;
			SelectionCorner corner = this.wayPoints.get(index);
			Point pt = corner.getCenter();

			if (rightAnchoredTextFields.isEmpty()) {
				textField.setLocation(pt.x - textField.getWidth() - GAP, pt.y
						+ GAP);
				bounds.x = pt.x - bounds.width + GAP;
				bounds.y = pt.y + GAP;
			} else {
				bounds.x = pt.x - bounds.width + GAP;
				bounds.y = rightAnchoredTextFields.get(
						rightAnchoredTextFields.size() - 1).getY()
						+ bounds.height;
			}
			if (!rightAnchoredTextFields.contains(textField)) {
				rightAnchoredTextFields.add(textField);
			}
			break;
		}
		case Line: {
			// set the position above or below the segment which has the least
			// anchored text fields

			// get the index of the segment
			int index = 0;
			int minSize = segmentsTextFields.get(0).size()
					+ leftAnchoredTextFields.size();
			for (int i = 1; i < segmentsTextFields.size(); i++) {
				segmentsTextFields.get(i).remove(textField);
				int size = segmentsTextFields.get(i).size();
				if (i == segmentsTextFields.size() - 1) {
					size += rightAnchoredTextFields.size();
				}

				// find a segment which has less anchored text fields
				if (size < minSize) {
					minSize = size;
					index = i;
				}
			}

			// get the two points of the segment
			Point pt1 = this.wayPoints.get(index).getCenter();
			Point pt2 = this.wayPoints.get(index + 1).getCenter();

			List<TextField> segmentTextFields = segmentsTextFields.get(index);
			boolean isAbove = pt2.y < pt1.y;

			if (segmentTextFields.isEmpty()) {
				bounds.x = (pt1.x + pt2.x) / 2;
				bounds.y = (pt1.y + pt2.y) / 2 - (isAbove ? bounds.height : 0);
			} else {
				bounds.x = (pt1.x + pt2.x) / 2 + GAP;
				bounds.y = segmentTextFields.get(segmentTextFields.size() - 1)
						.getY()
						- (isAbove ? bounds.height : -bounds.height);
			}

			segmentTextFields.add(textField);
			break;
		}
		default: {
			// does nothing
		}

		}

		textField.setBounds(bounds);
		textField.updateAnchorage();
	}

	/**
	 * <p>
	 * Gets the TextField associated with the given GraphNode.
	 * </p>
	 *
	 * @param graphNode
	 *            a GraphNode defined for TextField
	 * @return the associated text field, or null if there no graphNode.
	 *
	 * @throws IllegalArgumentException
	 *             if graphNode is null.
	 */
	public TextField getTextField(GraphNode graphNode) {
		Util.checkNull(graphNode, "graphNode");

		return textFields.get(graphNode);
	}

	/**
	 * <p>
	 * Removes the TextField associated with the given GraphNode.
	 * </p>
	 *
	 * <p>
	 * Note, if no such GraphNode, this method does nothing.
	 * </p>
	 *
	 * @return the associated text field, or null if there no graphNode
	 * @param graphNode
	 *            a GraphNode defined for TextField
	 *
	 * @throws IllegalArgumentException
	 *             if graphNode is null.
	 */
	public TextField removeTextField(GraphNode graphNode) {
		Util.checkNull(graphNode, "graphNode");

		TextField textField = textFields.get(graphNode);
		if (textField != null) {
			textFields.remove(graphNode);
			removeTextField(textField);
			this.remove(textField);

			// update the UI
			repaint();
		}

		return textField;
	}

	/**
	 * <p>
	 * Removes the text fields from the local reference in this edge.
	 * </p>
	 *
	 * @param textField
	 *            the text field to remove
	 */
	private void removeTextField(TextField textField) {
		switch (textField.getAnchorType()) {
		case LeftEnding: {
			leftAnchoredTextFields.remove(textField);
			break;
		}
		case RightEnding: {
			rightAnchoredTextFields.remove(textField);
			break;
		}
		case Line: {
			for (List<TextField> list : segmentsTextFields) {
				list.remove(textField);
				break;
			}
			break;
		}
		default: {
			// does nothing
		}

		}
	}

	/**
	 * <p>
	 * Returns the flag that whether to show the text fields when the edge is
	 * un-selected.
	 * </p>
	 *
	 * @return the flag that whether to show the text fields when the edge is
	 *         un-selected.
	 */
	public boolean isShowTextFields() {
		return showTextFields;
	}

	/**
	 * <p>
	 * Sets the flag that whether to show the text fields when the edge is
	 * un-selected.
	 * </p>
	 *
	 * @param showTextFields
	 *            the new flag value to set
	 */
	public void setShowTextFields(boolean showTextFields) {
		if (this.showTextFields != showTextFields) {
			this.showTextFields = showTextFields;

			// if the value is changed, then the edge should be repainted to
			// update the UI
			repaint();
		}
	}

	/**
	 * <p>
	 * Gets the active width of the edge.
	 * </p>
	 *
	 * <p>
	 * The active width means the edge can response mouse event in the range of
	 * active width.
	 * </p>
	 *
	 * @return the active width value.
	 */
	public int getActiveWidth() {
		return activeWidth;
	}

	/**
	 * <p>
	 * Set the active width of the edge.
	 * </p>
	 *
	 * <p>
	 * The active width means the edge can response mouse event in the range of
	 * active width.
	 * </p>
	 *
	 * @param activeWidth
	 *            the new active width value to set
	 *
	 * @throws IllegalArgumentException
	 *             if given value is not positive.
	 */
	public void setActiveWidth(int activeWidth) {
		Util.checkNotPositive(activeWidth, "activeWidth");

		this.activeWidth = activeWidth;
	}

	/**
	 * <p>
	 * Gets the align deviation of the edge.
	 * </p>
	 *
	 * <p>
	 * The align deviation means two neighbor segments whose angle is less than
	 * this value will be merged.
	 * </p>
	 *
	 * @return the align deviation value.
	 */
	public double getAlignDeviation() {
		return alignDeviation;
	}

	/**
	 * <p>
	 * Sets the align deviation of the edge.
	 * </p>
	 *
	 * <p>
	 * The align deviation means two neighbored segments whose angle is less
	 * than this value will be merged.
	 * </p>
	 *
	 * @param deviation
	 *            the new align deviation value.
	 *
	 * @throws IllegalArgumentException
	 *             if given value is negative.
	 */
	public void setAlignDeviation(double deviation) {
		if (deviation < 0) {
			throw new IllegalArgumentException(
					"The deviation is negative, its value is " + deviation);
		}

		alignDeviation = deviation;
	}

	/**
	 * <p>
	 * Gets the line style of the edge.
	 * </p>
	 *
	 * @return the line style of this edge.
	 */
	public LineStyle getLineStyle() {
		return lineStyle;
	}

	/**
	 * <p>
	 * Gets the left ending of the edge.
	 * </p>
	 *
	 * @return the left ending of this edge.
	 */
	public EdgeEnding getLeftEnding() {
		return leftEnding;
	}

	/**
	 * <p>
	 * Gets the right ending of the edge.
	 * </p>
	 *
	 * @return the right ending of this edge.
	 */
	public EdgeEnding getRightEnding() {
		return rightEnding;
	}

	/**
	 * <p>
	 * Set the left ending.
	 * </p>
	 */
	public void setLeftEnding(EdgeEnding ending) {
		/*
		 * BugFix: UML-9874 Old ending should be removed, new ending should be
		 * added.
		 */
		// old code
		// this.leftEnding = ending;
		remove(leftEnding);
		this.leftEnding = ending;
		add(leftEnding);
	}

	/**
	 * <p>
	 * Set the right ending.
	 * </p>
	 */
	public void setRightEnding(EdgeEnding ending) {
		/*
		 * BugFix: UML-9874 Old ending should be removed, new ending should be
		 * added.
		 */
		// old code
		// this.rightEnding = ending;
		remove(rightEnding);
		this.rightEnding = ending;
		add(rightEnding);
	}

	/**
	 * <p>
	 * Paints the component.
	 * </p>
	 *
	 * <p>
	 * This method draw lines to link all the waypoints using the line style for
	 * this edge, and draw the line between the text field and anchorage if the
	 * text field is selected.
	 * </p>
	 *
	 * <p>
	 * Note, edge endings, selection corners, and text fields are added as
	 * children, so they can be painted automatically.
	 * </p>
	 *
	 * @param g
	 *            the graphics to paint on
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		/*
		 * BugFix: BUGID UML-7694 Description: The Diagram Edges component
		 * should use the color mentioned in the properties of GraphEdge to
		 * paint the edge - the stroke color. The component should also use the
		 * font family, font color and font size properties of GraphEdge to
		 * paint the text fields anchored to the edge. The names of the
		 * properties should be configurable. The color values are represented
		 * like this: "#RRGGBB". Solution: Add the property map, which is used
		 * to get the property keys. Add strokeColor and fontColor fields. Add a
		 * public notifyProperitesChange method to retrieve properties from
		 * graph edge. Add a setter of fontColor to TextField class.
		 */
		g.setColor(strokeColor);

		for (int i = 0; i < wayPoints.size() - 1; i++) {
			// paint the line
			lineStyle.paint(g, wayPoints.get(i).getCenter(), wayPoints.get(
					i + 1).getCenter());
		}

		// needn't draw the line
		// // draw the line between the text field and anchorage if the text
		// field is selected
		// for (TextField textField : this.textFields.values()) {
		// if (textField.isVisible() && textField.isSelected()) {
		// Point anchorage = textField.getAnchorage();
		// Point endPoint = Util.getClosestPoint(anchorage,
		// textField.getBounds());
		// g.drawLine(anchorage.x, anchorage.y, endPoint.x, endPoint.y);
		// }
		// }
	}

	/**
	 * <p>
	 * Consumes event when the diagram viewer is in the state of adding element.
	 * </p>
	 *
	 * <p>
	 * This method is abstract and should be implemented by concrete Edge.
	 * </p>
	 *
	 * <p>
	 * If true is returned, it means that the event is consumed in the element,
	 * otherwise, it means that the event should be passed behind.
	 * </p>
	 *
	 * @param event
	 *            the mouse event or mouse motion event.
	 *
	 * @return true if the event is consumed, otherwise false.
	 */
	protected abstract boolean consumeEvent(MouseEvent event);

	/**
	 * <p>
	 * Passes event to the element behind this edge.
	 * </p>
	 *
	 * <p>
	 * Note, this method will consider the diagram view hierarchy, instead of
	 * the graph node container hierarchy.
	 * </p>
	 *
	 * @param event
	 *            a mouse event to be passed.
	 */
	protected void passEventBehind(MouseEvent event) {
		DiagramViewer diagramViewer = this.getDiagramViewer();
		if (diagramViewer != null) {
			List<Component> childs = Arrays.asList(diagramViewer
					.getComponents());
			int myIndex = childs.indexOf(this);

			// go through the child component that behind this edge
			for (int i = myIndex - 1; i >= 0; --i) {
				Component child = childs.get(i);
				int x = event.getX() + this.getLocation().x
						- child.getLocation().x;
				int y = event.getY() + this.getLocation().y
						- child.getLocation().y;
				if (child.contains(new Point(x, y))) {
					child.dispatchEvent(event);
				}
			}
		}
	}

	/**
	 * <p>
	 * This method overrides processMouseEvent method.
	 * </p>
	 *
	 * <p>
	 * When the diagram viewer is in state of adding element, the mouse event
	 * will be treated differently according to the concrete implementation of
	 * the edge.
	 * </p>
	 *
	 * @param e
	 *            the mouse event, if it is null, method will be returned
	 *            directly.
	 */
	protected void processMouseEvent(MouseEvent e) {
		if (e != null) {
			if (isDiagramViewerAddingElement()) {
				// note, the isDiagramViewerAddingElement() checks whether the
				// diagram viewer is
				// in the state of adding element
				if (!consumeEvent(e)) {
					passEventBehind(e);
				}
			} else {
				super.processMouseEvent(e);
			}
		}
	}

	/**
	 * <p>
	 * This method overrides processMouseMotionEvent method.
	 * </p>
	 *
	 * <p>
	 * When the diagram viewer is in state of adding element, the mouse event
	 * will be treated differently according to the concrete implementation of
	 * the edge.
	 * </p>
	 *
	 * @param e
	 *            the mouse motion event, if it is null, method will be returned
	 *            directly.
	 */
	protected void processMouseMotionEvent(MouseEvent e) {
		if (e != null) {
			// note, the isDiagramViewerAddingElement() checks whether the
			// diagram viewer is
			// in the state of adding element
			if (isDiagramViewerAddingElement()) {
				if (!consumeEvent(e)) {
					passEventBehind(e);
				}
			} else {
				super.processMouseMotionEvent(e);
			}
		}
	}

	/**
	 * <p>
	 * Adds a WayPointListener instance to the listener list.
	 * </p>
	 *
	 * <p>
	 * Note, null listener will be ignored by this method.
	 * </p>
	 *
	 * @param listener
	 *            the WayPointListener to be registered.
	 */
	public void addWayPointDragListener(WayPointListener listener) {
		super.listenerList.add(WayPointListener.class, listener);
	}

	/**
	 * <p>
	 * Removes the given WayPointListener instance from listener list.
	 * </p>
	 *
	 * <p>
	 * Note, null listener will be ignored by this method.
	 * </p>
	 *
	 * @param listener
	 *            the listener to be removed.
	 */
	public void removeWayPointDragListener(WayPointListener listener) {
		super.listenerList.remove(WayPointListener.class, listener);
	}

	/**
	 * <p>
	 * Notifies all listeners that are registered for way point drag event.
	 * </p>
	 *
	 * <p>
	 * Note, null event will be ignored and the notification will be cancelled.
	 * </p>
	 *
	 * @param event
	 *            the node drag event.
	 */
	protected void fireWayPointDrag(WayPointEvent event) {
		if (event != null) {
			for (WayPointListener listener : super.listenerList
					.getListeners(WayPointListener.class)) {
				listener.wayPointDragged(event);
			}
		}
	}

	/**
	 * <p>
	 * Adds the given EdgeDragListener instance to the listener list.
	 * </p>
	 *
	 * <p>
	 * Note, null listener will be ignored by this method.
	 * </p>
	 *
	 * @param listener
	 *            the EdgeDragListener to be registered.
	 */
	public void addEdgeDragListener(EdgeDragListener listener) {
		super.listenerList.add(EdgeDragListener.class, listener);
	}

	/**
	 * <p>
	 * Removes the given EdgeDragListener instance from listener list.
	 * </p>
	 *
	 * <p>
	 * Note, null listener will be ignored by this method.
	 * </p>
	 *
	 * @param listener
	 *            the listener to be removed.
	 */
	public void removeEdgeDragListener(EdgeDragListener listener) {
		super.listenerList.remove(EdgeDragListener.class, listener);
	}

	/**
	 * <p>
	 * Notifies all listeners that are registered for edge drag event.
	 * </p>
	 *
	 * <p>
	 * Note, null event will be ignored and the notification will be cancelled.
	 * </p>
	 *
	 * @param event
	 *            the way point drag event.
	 */
	protected void fireEdgeDrag(WayPointEvent event) {
		if (event != null) {
			for (EdgeDragListener listener : super.listenerList
					.getListeners(EdgeDragListener.class)) {
				listener.edgeDragged(event);
			}
		}
	}

	/**
	 * <p>
	 * Gets the left connector of the edge.
	 * </p>
	 *
	 * @return the left connector of the edge
	 */
	public Connector getLeftConnector() {
		return this.leftConnector;
	}

	/**
	 * <p>
	 * Sets the left connector of the edge.
	 * </p>
	 *
	 * <p>
	 * Null value is allowed.
	 * </p>
	 *
	 * @param connector
	 *            the new left connector value
	 */
	public void setLeftConnector(Connector connector) {
		this.leftConnector = connector;
	}

	/**
	 * <p>
	 * Gets the right connector of the edge.
	 * </p>
	 *
	 * @return the right connector of the edge
	 */
	public Connector getRightConnector() {
		return this.rightConnector;
	}

	/**
	 * <p>
	 * Sets the right connector of the edge.
	 * </p>
	 *
	 * <p>
	 * Null value is allowed.
	 * </p>
	 *
	 * @param connector
	 *            the new right connector value
	 */
	public void setRightConnector(Connector connector) {
		this.rightConnector = connector;
	}

	/**
	 * <p>
	 * This method overrides the setLocation method.
	 * </p>
	 *
	 * <p>
	 * Note, both the given x and y value must be zero.
	 * </p>
	 *
	 * @param x
	 *            the x coordinate value
	 * @param y
	 *            the y coordinate value
	 * @throws IllegalArgumentException
	 *             if x or y is not zero
	 */
	public void setLocation(int x, int y) {
		checkNonZero(x, "x");
		checkNonZero(y, "y");

		super.setLocation(x, y);
	}

	/**
	 * <p>
	 * This method overrides the setBounds method.
	 * </p>
	 *
	 * <p>
	 * Note, both the given x and y value must be zero and the width and height
	 * must be positive.
	 * </p>
	 *
	 * @param x
	 *            x coordinate value
	 * @param y
	 *            y coordinate value
	 * @param width
	 *            the new width of this edge
	 * @param height
	 *            the new height of this edge
	 *
	 * @throws IllegalArgumentException
	 *             if x, y is not 0, or width, height is not positive
	 */
	public void setBounds(int x, int y, int width, int height) {
		checkNonZero(x, "x");
		checkNonZero(y, "y");
		Util.checkNotPositive(width, "width");
		Util.checkNotPositive(height, "height");

		// update the bounds of the child component as well
		for (int i = 0; i < getComponentCount(); i++) {
			Component component = getComponent(i);
			/*
			 * Bugfix: UML-9582 It's incorrect to set all child component's
			 * location to the given (x,y) except the text fields, especially
			 * for the edge's selection corners.
			 */
			// old code
			if (component.isVisible()
					&& !(component instanceof TextField || component instanceof SelectionCorner)) {
				getComponent(i).setBounds(x, y, width, height);
			}
		}

		super.setBounds(x, y, width, height);
	}

	/*
	 * BugFix: BUGID UML-7175 Description: The notifySelected method is package
	 * private, it should be public. Solution: This method is changed to public.
	 */
	/**
	 * <p>
	 * Notifies this edge that it is selected.
	 * <p>
	 *
	 * <p>
	 * The text fields and selection corners will be made visible in this
	 * method.
	 * </p>
	 */
	public void notifySelected() {
		/*
		 * BugFix: BUGID UML-7684 Description: The stereotype and edge name for
		 * edges should be shown at all times, not just when the edge is
		 * selected. Solution: Remove the code to show text fields, since
		 * they're always visible.
		 */
		// old code
		// // show the text fields.
		// for (TextField textField : textFields.values()) {
		// textField.setVisible(true);
		// }
		// show the selection corners.
		for (SelectionCorner corner : this.wayPoints) {
			corner.setVisible(true);
		}

		repaint();
	}

	/**
	 * <p>
	 * Checks the given integer is zero or not.
	 * </p>
	 *
	 * <p>
	 * If the given integer is not zero, then IllegalArgumentException will be
	 * thrown.
	 * </p>
	 *
	 * @param value
	 *            the integer value to check
	 * @param name
	 *            the name of the value
	 *
	 * @throws IllegalArgumentException
	 *             if the given integer is not zero
	 */
	private void checkNonZero(int value, String name) {
		if (value != 0) {
			throw new IllegalArgumentException("The " + name
					+ " value is not zero.");
		}
	}

	/**
	 * <p>
	 * Converts the given diagram interchange point to the swing point based on
	 * the reference point.
	 * </p>
	 *
	 * @param point
	 *            the diagram interchanged point
	 * @param refPoint
	 *            the reference point
	 *
	 * @return the converted swing point
	 */
	private Point convertPoint(com.topcoder.diagraminterchange.Point point,
			Point refPoint) {
		return new Point((int) point.getX() + refPoint.x, (int) point.getY()
				+ refPoint.y);
	}

	/**
	 * <p>
	 * Gets the absolute position for the given graph element.
	 * </p>
	 *
	 * <p>
	 * Because the diagram interchange component uses the relative position so
	 * in order to draw the graph element, the absolution position should
	 * calculated.
	 * </p>
	 *
	 * @param graphElement
	 *            the graph element to get its absolute position
	 *
	 * @return the absolute position of the given graph element
	 */
	private Point getAbsoluatePosition(GraphElement graphElement) {
		double x = 0;
		double y = 0;

		// the root graph element is Diagram and its position is (0, 0)
		// so we don't add the position of the root diagram.
		if (graphElement != null) {
			while (graphElement.getContainer() != null) {
				com.topcoder.diagraminterchange.Point position = graphElement
						.getPosition();
				if (position != null) {
					x += position.getX();
					y += position.getY();
				}

				graphElement = graphElement.getContainer();
			}
		}

		return new Point((int) x, (int) y);
	}

	/**
	 * <p>
	 * This method checks whether the diagram viewer is at the state of adding
	 * element.
	 * </p>
	 *
	 * @return true if the diagram viewer is at the state of adding element,
	 *         false otherwise, if no diagram viewer can be found, then return
	 *         false
	 */
	private boolean isDiagramViewerAddingElement() {
		DiagramViewer diagramViewer = this.getDiagramViewer();
		return (diagramViewer != null)
				&& (diagramViewer.getState().equals(
						DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE) || diagramViewer
						.getState().equals(DiagramState.ADD_ELEMENT_BY_CLICK));
	}

	/*
	 * BugFix: BUGID UML-7694 Description: The Diagram Edges component should
	 * use the color mentioned in the properties of GraphEdge to paint the edge -
	 * the stroke color. The component should also use the font family, font
	 * color and font size properties of GraphEdge to paint the text fields
	 * anchored to the edge. The names of the properties should be configurable.
	 * The color values are represented like this: "#RRGGBB". Solution: Add the
	 * property map, which is used to get the property keys. Add strokeColor and
	 * fontColor fields. Add a public notifyProperitesChange method to retrieve
	 * properties from graph edge. Add a setter of fontColor to TextField class.
	 */
	/**
	 * <p>
	 * Setter of properties, see field doc for explanation.
	 * </p>
	 *
	 * @param properties
	 *            property map to be set
	 * @throws IllegalArgumentException
	 *             if given properties contains null/empty element
	 */
	public void setProperties(Map<String, String> properties) {
		Util.checkMapNullOrContainingEmpty(properties, "properties");
		this.properties = properties;
	}

	/**
	 * <p>
	 * Notifies this node, the properties in GraphEdge is changed. So we should
	 * try to update the fillColor, strokeColor, fontColor, and font values.
	 * </p>
	 */
	public void notifyPropertiesChange() {
		GraphEdge graphEdge = getGraphEdge();

		// Get string values
		String strokeColorValue = Util.getPropertyValue(graphEdge, properties,
				"StrokeColor");
		String fontColorValue = Util.getPropertyValue(graphEdge, properties,
				"FontColor");
		String fontFamilyValue = Util.getPropertyValue(graphEdge, properties,
				"FontFamily");
		String fontStyleValue = Util.getPropertyValue(graphEdge, properties,
				"FontStyle");
		String fontSizeValue = Util.getPropertyValue(graphEdge, properties,
				"FontSize");

		// Parse the string values
		if (strokeColorValue != null) {
			strokeColor = Util.parseColor(strokeColorValue);
		}
		if (fontColorValue != null) {
			fontColor = Util.parseColor(fontColorValue);
		}
		if (fontFamilyValue != null && fontStyleValue != null
				&& fontSizeValue != null) {
			String fontName = Util.parseFontFamily(fontFamilyValue);
			int fontStyle = Util.parseFontStyle(fontStyleValue);
			double fontSize = Util.parseFontSize(fontSizeValue);

			// Set this edge's font
			setFont(new Font(fontName, fontStyle, (int) fontSize));

		}

		// Set properties to text fields
		for (TextField textField : this.textFields.values()) {
			textField.setFont(getFont());
			textField.setFontColor(fontColor);
		}
	}
}
