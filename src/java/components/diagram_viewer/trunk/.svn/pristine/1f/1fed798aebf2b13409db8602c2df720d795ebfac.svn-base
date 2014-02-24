/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;

import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

/**
 * <p>
 * This class represents a graph node in UML diagram. It is an extension of <code>JComponent</code>.
 * </p>
 * <p>
 * All the concrete implementations should draw the visual look by overriding the <code>paintComponent</code> and the
 * <code>contains</code> methods. The selection corners are added as a child component of this node, so we don't need
 * to draw it. But the selection corners are configurable by specifying corners type and selection bound.
 * </p>
 * <p>
 * When a user change the size of this node, there are several values to be set. User should call <code>setSize</code>,
 * <code>setRelativePosition</code> and <code>setSelectionBound</code> to make the node look good.
 * </p>
 * <p>
 * This class provides two kinds of events. User can register this event as other events. They are selection corners
 * dragged event and node dragged event. Besides the event registration, when the diagram viewer is in the state of
 * adding element, it will treat the event differently.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable, and not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public abstract class Node extends JComponent {

    /**
     * <p>
     * Represents the <code>GraphNode</code> instance defining this node.
     * </p>
     * <p>
     * It is initialized in the constructor, and never changed later. It can not be null.
     * </p>
     */
    private final GraphNode graphNode;

    /**
     * <p>
     * Represents all the selection corners belonging to this node.
     * </p>
     * <p>
     * It is initialized in the constructor, and never changed later (including the content). The location and size of
     * the selection corner may be changed. It can never be null, or contain null.
     * </p>
     */
    private final Collection<SelectionCorner> corners;

    /**
     * <p>
     * Represents the selection bound. The selection corners will be displayed around bound according their corners.
     * </p>
     * <p>
     * It is initialized in the constructor, can be accessed by setter and getter. It can never be null.
     * </p>
     */
    private Rectangle selectionBound;

    /**
     * <p>
     * Represents the relative position of the visual node to the <code>JComponent</code> node. The position of visual
     * node is the GraphNode's position in Diagram Interchange.
     * </p>
     * <p>
     * It is initialized in the constructor, can be accessed by setter and getter. It can never be null.
     * </p>
     */
    private Point relativePosition;

    /**
     * <p>
     * Constructs a <code>Node</code> instance.
     * </p>
     * <p>
     * Since <code>Point</code> and <code>Rectangle</code> classes are mutable, cloned objects are used.
     * </p>
     *
     * @param graphNode
     *            the <code>GraphNode</code> instance associated to this node
     * @param position
     *            the relative position of visual node
     * @param bound
     *            the selection bound of corners
     * @param corners
     *            all the supported selection corners
     * @throws IllegalArgumentException
     *             if <code>graphNode</code>, <code>position</code>, <code>bound</code> or <code>corners</code>
     *             is null, or <code>corners</code> contains null element or duplicated elements
     */
    protected Node(GraphNode graphNode, Point position, Rectangle bound, Collection<SelectionCornerType> corners) {
        if (graphNode == null) {
            throw new IllegalArgumentException("graphNode should not be null.");
        }
        if (bound == null) {
            throw new IllegalArgumentException("bound should not be null.");
        }
        if (corners == null) {
            throw new IllegalArgumentException("corners should not be null.");
        }
        setRelativePosition(position);
        this.graphNode = graphNode;
        this.corners = new ArrayList<SelectionCorner>();
        this.selectionBound = new Rectangle(bound);

        Set<SelectionCornerType> cornersSet = new HashSet<SelectionCornerType>();
        for (SelectionCornerType corner : corners) {
            if (corner == null) {
                throw new IllegalArgumentException("corners should not contain null.");
            }
            if (!cornersSet.add(corner)) {
                throw new IllegalArgumentException("corners should not contain duplicated elements.");
            }
        }

        for (SelectionCornerType type : corners) {
            // create selection corner
            SelectionCorner corner = new SelectionCorner(type, getCornerCenter(bound, type));
            // set selection corner to invisible
            corner.setVisible(false);
            // register the SelectionCornerMouseListener to each selection corner
            SelectionCornerMouseListener selectionCornerMouseListener = new SelectionCornerMouseListener(this);
            corner.addMouseListener(selectionCornerMouseListener);
            corner.addMouseMotionListener(selectionCornerMouseListener);
            // add the selection corner as the child component
            add(corner);
            this.corners.add(corner);
        }

        // register the NodeMouseListener to this node
        NodeMouseListener nodeMouseListener = new NodeMouseListener();
        this.addMouseListener(nodeMouseListener);
        this.addMouseMotionListener(nodeMouseListener);
    }

    /**
     * <p>
     * Gets the <code>GraphNode</code> instance associated to this node.
     * </p>
     *
     * @return the <code>GraphNode</code> instance associated to this node
     */
    public GraphNode getGraphNode() {
        return graphNode;
    }

    /**
     * <p>
     * Gets the diagram viewer containing this node.
     * </p>
     * <p>
     * The returned value may be null if this node has no parent or the parent is not DiagramViewer instance.
     * </p>
     *
     * @return the diagram viewer containing this node
     */
    protected DiagramViewer getDiagramViewer() {
        DiagramView view = getDiagramView();
        if (view != null) {
            return view.getViewer();
        }
        return null;
    }

    /**
     * <p>
     * Gets the diagram view containing this element.
     * </p>
     * @return the diagram view containing this element
     */
    private DiagramView getDiagramView() {
        Container con = getParent();
        while ( con != null && !(con instanceof DiagramView)) {
            con = con.getParent();
        }
        return (DiagramView) con;
    }

    /**
     * <p>
     * This method is called when the node become unselected.
     * </p>
     */
    public void notifyUnselected() {
        for (SelectionCorner corner : corners) {
            corner.setVisible(false);
        }
    }

    /**
     * <p>
     * Overrides the <code>getLocation</code> method of base class.
     * </p>
     * <p>
     * The location is calculated according to the diagram hierarchy and the relative position.
     * </p>
     *
     * @param point
     *            the point to get location, or null a new point will be created to store the value
     * @return the location point storing the calculated value
     */
    public Point getLocation(Point point) {
        if (point == null) {
            point = new Point();
        }
        // the visual node's position is relative value, need to get the absolute position of the visual node
        double x = 0;
        double y = 0;
        for (GraphElement node = graphNode; node.getContainer() != null; node = node.getContainer()) {
            x += node.getPosition().getX();
            y += node.getPosition().getY();
        }
        // the component position should be calculated from the relative position of visual node to component node
        // and the absolute position of visual node
        point.x = (int) Math.round(x) - relativePosition.x;
        point.y = (int) Math.round(y) - relativePosition.y;
        return point;
    }

    /**
     * <p>
     * Gets selection corners belonging to this node.
     * </p>
     * <p>
     * The returned value is an unmodifiable collection.
     * </p>
     *
     * @return an unmodifiable collection of selection corners belonging to this node
     */
    public Collection<SelectionCorner> getSelectionCorners() {
        return Collections.unmodifiableCollection(corners);
    }

    /**
     * <p>
     * Sets the relative position of the visual node to the <code>JComponent</code> node.
     * </p>
     * <p>
     * This method should be used together with <code>setSelectionBound</code> and <code>setSize</code>.
     * </p>
     * <p>
     * Since <code>Point</code> class is mutable, cloned object is set.
     * </p>
     *
     * @param position
     *            the new relative position of the visual node to the <code>JComponent</code> node
     * @throws IllegalArgumentException
     *             if <code>position</code> is null
     */
    public void setRelativePosition(Point position) {
        if (position == null) {
            throw new IllegalArgumentException("position should not be null.");
        }
        relativePosition = new Point(position);
    }

    /**
     * <p>
     * Gets the relative position of the visual node to the <code>JComponent</code> node.
     * </p>
     * <p>
     * Since <code>Point</code> class is mutable, cloned object is returned.
     * </p>
     *
     * @return the relative position of the visual node to the <code>JComponent</code> node
     */
    public Point getRelativePosition() {
        return new Point(relativePosition);
    }

    /**
     * <p>
     * Sets the selection bound of this node.
     * </p>
     * <p>
     * This method should be used together with <code>setRelativePosition</code> and <code>setSize</code>.
     * </p>
     * <p>
     * Since <code>Rectangle</code> class is mutable, cloned object is set.
     * </p>
     *
     * @param bound
     *            the new selection bound of this node
     * @throws IllegalArgumentException
     *             if <code>bound</code> is null
     */
    public void setSelectionBound(Rectangle bound) {
        if (bound == null) {
            throw new IllegalArgumentException("bound should not be null.");
        }
        selectionBound = new Rectangle(bound);
        // update the center point of selection corners
        for (SelectionCorner corner : corners) {
            corner.setCenter(getCornerCenter(selectionBound, corner.getType()));
        }
    }

    /**
     * <p>
     * Gets the selection bound of this node.
     * </p>
     * <p>
     * Since <code>Rectangle</code> class is mutable, cloned object is returned.
     * </p>
     *
     * @return the selection bound of this node
     */
    public Rectangle getSelectionBound() {
        return new Rectangle(selectionBound);
    }

    /**
     * <p>
     * Consumes event when the diagram viewer is in the state of adding element.
     * </p>
     * <p>
     * This method should be implemented by concrete node.
     * </p>
     * <p>
     * If true is returned, it means that the event is consumed in the element; if false is returned, it means that the
     * event should be passed behind.
     * </p>
     *
     * @param event
     *            the mouse event or mouse motion event
     * @return true if the event is consumed, otherwise false
     */
    protected abstract boolean consumeEvent(MouseEvent event);

    /**
     * <p>
     * Passes event to the element behind this node (considering the diagram view hierarchy, not graph node container
     * hierarchy).
     * </p>
     *
     * @param event
     *            the mouse event to be passed
     */
    protected void passEventBehind(MouseEvent event) {
        if (event == null) {
            return;
        }

        /*
         * BugFix: UML-9865
         * This event should be passed behind to diagram view, not diagram viewer.
         */
        // old code
//        DiagramViewer viewer = getDiagramViewer();
//        if (viewer != null) {
//            int myIndex = viewer.getComponentZOrder(this);
//            Component[] childs = viewer.getComponents();
//            for (int i = myIndex - 1; i >= 0; i--) {
//                if (childs[i].contains(event.getPoint())) {
//                    // the coordinate system is changed
//                    event.getPoint().setLocation(
//                            event.getPoint().getX() + getLocation().getX() - childs[i].getLocation().getX(),
//                            event.getPoint().getY() + getLocation().getY() - childs[i].getLocation().getY());
//                    // pass event to the element behind this node
//                    childs[i].dispatchEvent(event);
//                    return;
//                }
//            }
//            // no child is found, pass event to diagram viewer
//            viewer.dispatchEvent(event);
//        }
        DiagramView view = (DiagramView) getDiagramView();
        if (view != null) {
            int myIndex = view.getComponentZOrder(this);
            Component[] childs = view.getComponents();
            for (int i = myIndex - 1; i >= 0; i--) {
                Point position = SwingUtilities.convertPoint(this, event.getX(), event.getY(), childs[i]);
                if (childs[i].contains(position)) {
                    // the coordinate system is changed
                    event = new MouseEvent(childs[i], event.getID(), event.getWhen(), event.getModifiers(),
                            position.x, position.y,
                            event.getClickCount(), event.isPopupTrigger(), event.getButton());

                    // pass event to the element behind this node
                    childs[i].dispatchEvent(event);
                    return;
                }
            }
            // no child is found, pass event to diagram view
            Point position = SwingUtilities.convertPoint(this, event.getX(), event.getY(), view);
            event = new MouseEvent(view, event.getID(), event.getWhen(), event.getModifiers(), position.x,
                    position.y, event.getClickCount(), event.isPopupTrigger(), event.getButton());
            view.dispatchEvent(event);
        }
    }

    /**
     * <p>
     * Overrides the <code>processMouseEvent</code> method of base class.
     * </p>
     * <p>
     * It can treat mouse event differently when diagram viewer is in different state.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     *
     * @param e
     *            the mouse event
     */
    protected void processMouseEvent(MouseEvent e) {
        if (e == null) {
            return;
        }

        // Gets the flag indicating whether diagram viewer is in state of adding element.
        boolean isViewerInAddingState = false;
        DiagramViewer viewer = getDiagramViewer();
        if (viewer != null) {
            /*
             * Bugfix: UML-9601
             * Two new DiagramStates, ADD_SOLID_EDGE and ADD_DASHED_EDGE have been added in
             * Diagram Viewer component.
             */
            // old code
//            isViewerInAddingState = (viewer.getState() == DiagramState.ADD_ELEMENT_BY_CLICK
//                || viewer.getState() == DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE);
            isViewerInAddingState = (viewer.getState() != DiagramState.SELECT_ELEMENT);
        }

        if (isViewerInAddingState) {
            // treat mouse event differently when diagram viewer is in different state
            if (!consumeEvent(e)) {
                passEventBehind(e);
            }
        } else {
            // process it normally
            super.processMouseEvent(e);
        }
    }

    /**
     * <p>
     * Overrides the <code>processMouseMotionEvent</code> method of base class.
     * </p>
     * <p>
     * It can treat mouse event differently when diagram viewer is in different state.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     *
     * @param e
     *            the mouse motion event
     */
    protected void processMouseMotionEvent(MouseEvent e) {
        if (e == null) {
            return;
        }

        // Gets the flag indicating whether diagram viewer is in state of adding element.
        boolean isViewerInAddingState = false;
        DiagramViewer viewer = getDiagramViewer();
        if (viewer != null) {
            /*
             * Bugfix: UML-9601
             * Two new DiagramStates, ADD_SOLID_EDGE and ADD_DASHED_EDGE have been added in
             * Diagram Viewer component.
             */
            // old code
//            isViewerInAddingState = (viewer.getState() == DiagramState.ADD_ELEMENT_BY_CLICK
//                || viewer.getState() == DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE);
            isViewerInAddingState = (viewer.getState() != DiagramState.SELECT_ELEMENT);
        }

        if (isViewerInAddingState) {
            // treat mouse event differently when diagram viewer is in different state
            if (!consumeEvent(e)) {
                passEventBehind(e);
            }
        } else {
            // process it normally
            super.processMouseMotionEvent(e);
        }
    }

    /**
     * <p>
     * Adds the given <code>NodeDragListener</code> instance to the listener list.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     *
     * @param listener
     *            the <code>NodeDragListener</code> instance to add
     */
    public void addNodeDragListener(NodeDragListener listener) {
        if (listener == null) {
            return;
        }
        listenerList.add(NodeDragListener.class, listener);
    }

    /**
     * <p>
     * Removes the given <code>NodeDragListener</code> instance from the listener list.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     *
     * @param listener
     *            the <code>NodeDragListener</code> instance to remove
     */
    public void removeNodeDragListener(NodeDragListener listener) {
        if (listener == null) {
            return;
        }
        listenerList.remove(NodeDragListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for node drag event.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     *
     * @param event
     *            the node drag event
     */
    protected void fireNodeDrag(LocationEvent event) {
        if (event != null) {
            for (NodeDragListener listener : listenerList.getListeners(NodeDragListener.class)) {
                listener.nodeDragged(event);
            }
        }
    }

    /**
     * <p>
     * Adds the given <code>CornerDragListener</code> instance to the listener list.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     *
     * @param listener
     *            the <code>CornerDragListener</code> instance to add
     */
    public void addCornerDragListener(CornerDragListener listener) {
        if (listener == null) {
            return;
        }
        listenerList.add(CornerDragListener.class, listener);
    }

    /**
     * <p>
     * Removes the given <code>CornerDragListener</code> instance from the listener list.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     *
     * @param listener
     *            the <code>CornerDragListener</code> instance to remove
     */
    public void removeCornerDragListener(CornerDragListener listener) {
        if (listener == null) {
            return;
        }
        listenerList.remove(CornerDragListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for corner drag event.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     *
     * @param event
     *            the node drag event
     */
    protected void fireCornerDrag(SelectionBoundEvent event) {
        if (event != null) {
            for (CornerDragListener listener : listenerList.getListeners(CornerDragListener.class)) {
                listener.cornerDragged(event);
            }
        }
    }

    /**
     * <p>
     * Calculates the center point of the selection corner basing the selection bound and the corner type.
     * </p>
     *
     * @param bound
     *            the selection bound of this node
     * @param type
     *            the type of the selection corner
     * @return the center point of the selection corner
     */
    private Point getCornerCenter(Rectangle bound, SelectionCornerType type) {
        if (type == SelectionCornerType.EAST) {
            return new Point(bound.x + bound.width, (int) Math.round(bound.y + bound.getHeight() / 2));
        } else if (type == SelectionCornerType.SOUTH) {
            return new Point((int) Math.round(bound.x + bound.getWidth() / 2), bound.y + bound.height);
        } else if (type == SelectionCornerType.WEST) {
            return new Point(bound.x, (int) Math.round(bound.y + bound.getHeight() / 2));
        } else if (type == SelectionCornerType.NORTH) {
            return new Point((int) Math.round(bound.x + bound.getWidth() / 2), bound.y);
        } else if (type == SelectionCornerType.NORTHEAST) {
            return new Point(bound.x + bound.width, bound.y);
        } else if (type == SelectionCornerType.NORTHWEST) {
            return new Point(bound.x, bound.y);
        } else if (type == SelectionCornerType.SOUTHEAST) {
            return new Point(bound.x + bound.width, bound.y + bound.height);
        } else {
            return new Point(bound.x, bound.y + bound.height);
        }
    }

    /*
     * BugFix: BUGID UML-7170
     * Description:
     * This class should have provided a public method to relocate its selection
     * corners in case its selection bound is changed.
     * This class should have provided a public method to make its selection
     * corners visible.
     */
    /**
     * <p>
     * This method is called when the node become selected.
     * </p>
     */
    public void notifySelected() {
        for (SelectionCorner corner : corners) {
            corner.setVisible(true);
        }
    }

    /**
     * <p>
     * Relocates this node's selection corners in case the selection bound is changed.
     * </p>
     */
    public void relocateSelectionCorners() {
        // update the center point of selection corners
        for (SelectionCorner corner : corners) {
            corner.setCenter(getCornerCenter(selectionBound, corner.getType()));
        }
    }
}
