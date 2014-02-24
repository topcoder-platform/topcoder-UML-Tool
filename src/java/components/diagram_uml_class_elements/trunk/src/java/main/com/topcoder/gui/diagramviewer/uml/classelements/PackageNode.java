/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.uml.classelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.BoundaryChangedListener;
import com.topcoder.gui.diagramviewer.uml.classelements.event.EdgeAddEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.EdgeAddListener;
import com.topcoder.gui.diagramviewer.uml.classelements.event.EditBoxTrigger;
import com.topcoder.gui.diagramviewer.uml.classelements.event.NodeAddEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.NodeAddListener;
import com.topcoder.gui.diagramviewer.uml.classelements.event.PopupMenuTrigger;

/**
 * <p>
 * This class represents a Package element in UML Model. It allows to combine several nodes inside it. The presentation
 * and behavior are similar to Java package of namespace in C#.
 * </p>
 * <p>
 * It contains four properties. They are fill color, stroke color, font color, and font. Especially, JComponent#setFont
 * and getFont methods are reused to support the font property.
 * </p>
 * <p>
 * Name compartment, stereotype compartment and namespace compartment are defined in this class. This class also
 * registers EditBoxTrigger automatically to allow name editing.
 * </p>
 * <p>
 * BoundaryChangedEvent would be triggered by this node. It indicates the node's bound is changed.
 * </p>
 * <p>
 * This class support Drag-And-Drop, and new node or edge adding event can be fired by this class.
 * </p>
 * <p>
 * This class is mutable, and not thread-safe.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class PackageNode extends NodeContainer {
    /**
     * <p>
     * Represents the minimum size of the package. Initialized directly and never changed. Can't be null. Used in any
     * resize operations implemented in this class. Can be helpful for the external components too. This value will be
     * assigned to the minimum size of the related JComponent in the constructor.
     * </p>
     */
    public static final Dimension DEFAULT_MINIMUM_SIZE = new Dimension(120, 60);

    /**
     * <p>
     * Represents the connector of this Node. Application will use this connector to connect to this node.
     * </p>
     * <p>
     * It is initialized in constructor, and never changed later. Never null.
     * </p>
     */
    private final Connector connector;

    /**
     * <p>
     * Represents the fill color value retrieved from GraphNode property.
     * </p>
     * <p>
     * It will be used by concrete node to fill the node shape.
     * </p>
     * <p>
     * It can be null, if there is no corresponding property. It will be first retrieved in constructor, and updated in
     * notifyPropertiesChange.
     * </p>
     */
    private Color fillColor;

    /**
     * <p>
     * Represents the stroke color value retrieved from GraphNode property.
     * </p>
     * <p>
     * It will be used by concrete node to draw the node shape.
     * </p>
     * <p>
     * It can be null, if there is no corresponding property. It will be first retrieved in constructor, and updated in
     * notifyPropertiesChange.
     * </p>
     */
    private Color strokeColor;

    /**
     * <p>
     * Represents the font color value retrieved from GraphNode property.
     * </p>
     * <p>
     * It will be used by concrete node to write text on the node.
     * </p>
     * <p>
     * It can be null, if there is no corresponding property. It will be first retrieved in constructor, and updated in
     * notifyPropertiesChange.
     * </p>
     */
    private Color fontColor;

    /**
     * <p>
     * Represents the property name mapping. Each key in the map is used to get the text string of the graphNode
     * property. This string will be used to get the current value from the graphNode.getProperties map. These
     * properties are: color (stroke and fill), font (color, family, size) and so on.
     * </p>
     * <p>
     * Same property may have different property names, because the property names are standard. For example, fill color
     * property may be named as "FillColor", "fill_color", or etc.
     * </p>
     * <p>
     * The key is the predefined property keys, and the value is the actual property name. In this class, "FillColor",
     * "StrokeColor", "FontColor", and "FontFamily", "FontSize" are used as predefined keys.
     * </p>
     * <p>
     * It is initialized in constructor, and never changed later, not null. Nether the key nor the value could be null
     * or empty.
     * </p>
     */
    private final Map<String, String> properties;

    /**
     * <p>
     * Represents the name compartment of this node. Initialized in constructor, never changed later, can't be null. Can
     * be accessed by getter.
     * </p>
     * <p>
     * The text/size/location of this TextField will be updated in notifyGraphNodeChange method.
     * </p>
     */
    private final TextField name;

    /**
     * <p>
     * Represents the stereotype compartment of this node. Initialized in constructor, never changed later, can't be
     * null. Can be accessed by getter.
     * </p>
     * <p>
     * The text/size/location of this TextField will be updated in notifyGraphNodeChange method.
     * </p>
     */
    private final TextField stereotype;

    /**
     * <p>
     * Represents the namespace compartment of this node. Initialized in constructor, never changed later, can't be
     * null. Can be accessed by getter.
     * </p>
     * <p>
     * The text/size/location of this TextField will be updated in notifyGraphNodeChange method.
     * </p>
     */
    private final TextField namespace;

    /**
     * <p>
     * Represents the size of top rectangle.
     * </p>
     */
    private Dimension topSize;

    /**
     * <p>
     * Represents the size of bottom rectangle.
     * </p>
     */
    private Dimension bottomSize;

    /**
     * <p>
     * Constructs a PackageNode.
     * </p>
     * @param graphNode
     *            the graphNode corresponding to this Node
     * @param properties
     *            the property name mappings
     * @param handler
     *            the transfer handler
     * @throws IllegalArgumentException
     *             if given graphNode, properties, or handler is null, or the properties map contains null/empty element
     * @throws IllegalGraphElementException
     *             if the structure of graphNode is invalid
     */
    public PackageNode(GraphNode graphNode, Map<String, String> properties, TransferHandler handler) {
        // Correct relative position and selection bound will be calculated in notifyGraphNodeChange
        super(graphNode, new Point(), new Rectangle(), Util.createSelectionCornerTypes());
        Util.checkPackageGraphNode(graphNode);
        Util.checkMapNotNullOrContainingEmpty(properties, "properties");
        Util.checkNotNull(handler, "handler");

        this.properties = properties;

        // Register PopupMenuTrigger to this instance to allow popup
        addMouseListener(new PopupMenuTrigger());

        // Create three compartments
        this.name = new TextField(getCompartmentGraphNode(graphNode, 1));
        this.stereotype = new TextField(getCompartmentGraphNode(graphNode, 0));
        this.namespace = new TextField(getCompartmentGraphNode(graphNode, 2));

        // Add them as child components
        add(name);
        add(stereotype);
        add(namespace);

        // Register a EditTextBoxTrigger to allow double-click to edit name
        name.addMouseListener(new EditBoxTrigger(name));

        // Create a connector for this instance
        this.connector = new PackageNodeConnector(this);

        // Set the transfer handler
        this.setTransferHandler(handler);

        // Notify the PackageNode instance is created
        notifyGraphNodeChange("PackageNode instance created.");
    }

    /**
     * <p>
     * Gets the stereotype, name, or namespace graph node from given <code>GraphNode</code>.
     * </p>
     * @param graphNode
     *            the <code>GraphNode</code> which contains desired name graph node
     * @param index
     *            the sub graph node index of name compartment graph node, 0 for stereotype, 1 for name, 2 for namespace
     * @return the name graph node
     */
    private GraphNode getCompartmentGraphNode(GraphNode graphNode, int index) {
        GraphElement nameCompartment = (GraphElement) graphNode.getContaineds().get(0);
        return (GraphNode) nameCompartment.getContaineds().get(index);
    }

    /**
     * <p>
     * Sets the transfer handler for this node.
     * </p>
     * @param newHandler
     *            the new transfer handler
     * @throws IllegalArgumentException
     *             if newHandler is null
     */
    public void setTransferHandler(TransferHandler newHandler) {
        Util.checkNotNull(newHandler, "newHandler");
        super.setTransferHandler(newHandler);
    }

    /**
     * <p>
     * Determines whether given coordinate is in the shape of this component for the sake of mouse processing.
     * </p>
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     * @return whether the given point is contained
     */
    public boolean contains(int x, int y) {
        Point relative = getRelativePosition();
        Rectangle topRectangle = new Rectangle(relative, topSize);
        Rectangle bottomRectangle = new Rectangle(relative.x, relative.y + topSize.height, bottomSize.width,
                bottomSize.height);
        /*
         * BugFix: BUGID UML-8193
         * Description:
         * In contains, the selection corners around this node should be checked to determine whether or not the
         * point is contained.
         * Solution:
         * Code is added to check the child components.
         */
        // old code
//        return topRectangle.contains(x, y) || bottomRectangle.contains(x, y);
        if (topRectangle.contains(x, y) || bottomRectangle.contains(x, y)) {
            return true;
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
     * Rendering process of this node. Simply draw two rectangle shapes.
     * </p>
     * @param g
     *            the graphics to paint on (null is ignored)
     */
    protected void paintComponent(Graphics g) {
        if (g == null) {
            return;
        }
        Point relative = getRelativePosition();
        Color oldColor = g.getColor();

        // Paint the top rectangle
        Util.paintRectCompartment(g, topSize, relative.x, relative.y, fillColor, strokeColor);

        // Paint the bottom rectangle
        Util.paintRectCompartment(g, bottomSize, relative.x, relative.y + topSize.height, fillColor, strokeColor);

        // Set old color back
        g.setColor(oldColor);
    }

    /**
     * <p>
     * Gets the stroke color.
     * </p>
     * @return the stroke color
     */
    public Color getStrokeColor() {
        return strokeColor;
    }

    /**
     * <p>
     * Gets the fill color.
     * </p>
     * @return the fill color
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * <p>
     * Gets the font color.
     * </p>
     * @return the font color
     */
    public Color getFontColor() {
        return fontColor;
    }

    /**
     * <p>
     * Gets the connector for this node.
     * </p>
     * @return the connector
     */
    public Connector getConnector() {
        return connector;
    }

    /**
     * <p>
     * Gets the name compartment belonging to this node.
     * </p>
     * @return the text field representing name compartment
     */
    public TextField getNameCompartment() {
        return name;
    }

    /**
     * <p>
     * Gets the stereotype compartment belonging to this node.
     * </p>
     * @return the text field representing stereotype compartment
     */
    public TextField getStereotypeCompartment() {
        return stereotype;
    }

    /**
     * <p>
     * Gets the namespace compartment belonging to this node.
     * </p>
     * @return the text field representing namespace compartment
     */
    public TextField getNamespaceCompartment() {
        return namespace;
    }

    /**
     * <p>
     * Notifies this node, the properties in GraphNode is changed. So we should try to update the fillColor,
     * strokeColor, fontColor, and font values.
     * </p>
     */
    public void notifyPropertiesChange() {
        GraphNode graphNode = getGraphNode();

        // Get string values
        String fillColorValue = Util.getPropertyValue(graphNode, properties, "FillColor");
        String strokeColorValue = Util.getPropertyValue(graphNode, properties, "StrokeColor");
        String fontColorValue = Util.getPropertyValue(graphNode, properties, "FontColor");
        String fontFamilyValue = Util.getPropertyValue(graphNode, properties, "FontFamily");
        String fontStyleValue = Util.getPropertyValue(graphNode, properties, "FontStyle");
        String fontSizeValue = Util.getPropertyValue(graphNode, properties, "FontSize");

        // Parse the string values
        fillColor = Util.parseColor(fillColorValue);
        strokeColor = Util.parseColor(strokeColorValue);
        fontColor = Util.parseColor(fontColorValue);
        String fontName = Util.parseFontFamily(fontFamilyValue);
        int fontStyle = Util.parseFontStyle(fontStyleValue);
        double fontSize = Util.parseFontSize(fontSizeValue);

        // Set this node's font
        setFont(new Font(fontName, fontStyle, (int) fontSize));
    }

    /**
     * <p>
     * Reloads diagram interchange information from contained graphNode.
     * </p>
     * @param message
     *            telling how graphNode is changed (could be null)
     * @throws IllegalGraphElementException
     *             if the structure of graphNode is invalid
     */
    public void notifyGraphNodeChange(String message) {
        GraphNode graphNode = getGraphNode();
        Util.checkPackageGraphNode(graphNode);
        notifyPropertiesChange();

        // Get selection corner radius
        int radius = getSelectionCorners().iterator().next().getRadius();

        // Relocate and resize stereotype, name and namespace compartments, set their properties, and get the size to
        // hold them
        topSize = Util.rearrangeCompartments(this, radius);
        // Update the X coordinates for stereotype, name and namespace compartments
        Util.updateNameCompartments(radius, this, topSize.width);

        // Get body compartment's preferred size to hold contained nodes
        bottomSize = getPreferredBodySize(topSize);

        Dimension size = new Dimension(topSize);
        Util.combineSize(size, bottomSize, false);

        // Adjust the size to default if necessary
        if (size.width < DEFAULT_MINIMUM_SIZE.width) {
            bottomSize.width = DEFAULT_MINIMUM_SIZE.width;
            size.width = DEFAULT_MINIMUM_SIZE.width;
        }
        if (size.height < DEFAULT_MINIMUM_SIZE.height) {
            bottomSize.height = DEFAULT_MINIMUM_SIZE.height - topSize.height;
            size.height = DEFAULT_MINIMUM_SIZE.height;
        }

        /*
         * BugFix: BUGID UML-8193
         * Description:
         * In notifyGraphNodeChange, the calculated preferred size should be set to the graph node to keep consistency.
         * Solution:
         * Compare with user defined size first, then set the calculated size to the graph node to keep consistency.
         */
        Dimension graphSize = Util.getGraphNodeSize(graphNode);
        if (size.width < graphSize.width) {
            bottomSize.width = graphSize.width;
            size.width = graphSize.width;
        }
        if (size.height < graphSize.height) {
            bottomSize.height = graphSize.height - topSize.height;
            size.height = graphSize.height;
        }

        // Set the calculated size to graph node
        getGraphNode().getSize().setWidth(size.width);
        getGraphNode().getSize().setHeight(size.height);

        // Update this node's boundary
        Util.updateNodeBound(this, radius, size, message);
    }

    /**
     * <p>
     * Computes the suitable body size for contained nodes.
     * </p>
     *
     * @param preferredTopSize
     *            the preferred top size
     * @return the suitable body size for contained nodes
     */
    private Dimension getPreferredBodySize(Dimension preferredTopSize) {
        // Left top corner of the rectangle to hold contained nodes
        Point leftTop = null;
        // Right bottom corner of the rectangle to hold contained nodes
        Point rightBottom = null;
//        for (Node node : getNodes()) {
//            if (leftTop == null) {
//                leftTop = node.getLocation();
//                rightBottom = new Point(leftTop.x + node.getWidth(), leftTop.y + node.getHeight());
//            } else {
//                leftTop.x = Math.min(leftTop.x, node.getX());
//                leftTop.y = Math.min(leftTop.y, node.getY());
//                rightBottom.x = Math.max(rightBottom.x, node.getX() + node.getWidth());
//                rightBottom.y = Math.max(rightBottom.y, node.getY() + node.getHeight());
//            }
//        }
        Dimension size;
        if (leftTop == null) {
            size = new Dimension(0, 0);
        } else {
            size = new Dimension(rightBottom.x - leftTop.x, rightBottom.y - leftTop.y);
        }
        size.width = Math.max(size.width, DEFAULT_MINIMUM_SIZE.width);
        size.width = Math.max(size.width, preferredTopSize.width);
        size.height = Math.max(size.height, DEFAULT_MINIMUM_SIZE.height - preferredTopSize.height);
        return size;
    }

    /**
     * <p>
     * Gets the preferred graph node size. Please note this is different from JComponent#getPreferredSize(). The
     * returned value indicating the preferred size of core shape of this node. This method is provided for the
     * application to set proper size of graph node.
     * </p>
     * @return the preferred size of graph node
     */
    public Dimension getPreferredGraphNodeSize() {
        // Get preferred size to hold stereotype, name and namespace compartments
        Dimension size = Util.getPreferredCompartmentsSize(stereotype, name, namespace);

        // Combine with the preferred size of body compartment
        Dimension bodySize = getPreferredBodySize(size);
        Util.combineSize(size, bodySize, false);

        // If the size's width or height is small than the default minimum, adjust it
        size.width = Math.max(size.width, DEFAULT_MINIMUM_SIZE.width);
        size.height = Math.max(size.height, DEFAULT_MINIMUM_SIZE.height);
        return size;
    }

    /**
     * <p>
     * Consumes the event when the diagram viewer is in the status of adding new element.
     * </p>
     * @return a flag indicating whether the event is consumed
     * @param event
     *            the mouse event(null should be ignored)
     */
    protected boolean consumeEvent(MouseEvent event) {
        if (event == null || event.getSource() == null) {
            return false;
        }
        /*
         * BugFix: BUGID UML-8193
         * Description:
         * In consumeEvent, this method should simply return false to let the event pass behind.
         * Solution:
         * Following code is commented.
         */
        // old code
//        if (event.getSource() instanceof Node && event.getID() == MouseEvent.MOUSE_CLICKED) {
//            NodeAddEvent nodeAddEvent = new NodeAddEvent(this, event.getPoint());
//            fireNodeAdd(nodeAddEvent);
//            return true;
//        }
//        if (event.getSource() instanceof Edge) {
//            Edge edge = (Edge) event.getSource();
//            GraphEdge graphEdge = edge.getGraphEdge();
//            if (!(Util.getElement(graphEdge) instanceof Dependency)) {
//                return false;
//            }
//            if (event.getID() == MouseEvent.MOUSE_PRESSED) {
//                EdgeAddEvent edgeAddEvent = new EdgeAddEvent(this, event.getPoint(), true);
//                fireEdgeAdd(edgeAddEvent);
//            } else if (event.getID() == MouseEvent.MOUSE_RELEASED) {
//                EdgeAddEvent edgeAddEvent = new EdgeAddEvent(this, event.getPoint(), false);
//                fireEdgeAdd(edgeAddEvent);
//            }
//            return true;
//        }
        return false;
    }

    /**
     * <p>
     * Adds BoundaryChangedListener to the listenerList.
     * </p>
     * @param listener
     *            the BoundaryChangedListener to be registered
     */
    public void addBoundaryChangedListener(BoundaryChangedListener listener) {
        listenerList.add(BoundaryChangedListener.class, listener);
    }

    /**
     * <p>
     * Removes an BoundaryChangedListener from listenerList.
     * </p>
     * @param listener
     *            the listener to be removed
     */
    public void removeBoundaryChangedListener(BoundaryChangedListener listener) {
        listenerList.remove(BoundaryChangedListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for BoundaryChangedEvent.
     * </p>
     * @param event
     *            the BoundaryChangedEvent
     */
    protected void fireBoundaryChanged(BoundaryChangedEvent event) {
        if (event != null) {
            BoundaryChangedListener[] listeners = listenerList.getListeners(BoundaryChangedListener.class);
            for (BoundaryChangedListener listener : listeners) {
                listener.boundaryChanged(event);
            }
        }
    }

    /**
     * <p>
     * Adds NodeAddListener to the listenerList.
     * </p>
     * @param listener
     *            the NodeAddListener to be registered
     */
    public void addNodeAddListener(NodeAddListener listener) {
        listenerList.add(NodeAddListener.class, listener);
    }

    /**
     * <p>
     * Removes a NodeAddListener from listenerList.
     * </p>
     * @param listener
     *            the listener to be removed
     */
    public void removeNodeAddListener(NodeAddListener listener) {
        listenerList.remove(NodeAddListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for NodeAddEvent.
     * </p>
     * @param event
     *            the NodeAddEvent
     */
    protected void fireNodeAdd(NodeAddEvent event) {
        if (event != null) {
            NodeAddListener[] listeners = listenerList.getListeners(NodeAddListener.class);
            for (NodeAddListener listener : listeners) {
                listener.nodeAdd(event);
            }
        }
    }

    /**
     * <p>
     * Adds EdgeAddListener to the listenerList.
     * </p>
     * @param listener
     *            the EdgeAddListener to be registered
     */
    public void addEdgeAddListener(EdgeAddListener listener) {
        listenerList.add(EdgeAddListener.class, listener);
    }

    /**
     * <p>
     * Removes an EdgeAddListener from listenerList.
     * </p>
     * @param listener
     *            the listener to be removed
     */
    public void removeEdgeAddListener(EdgeAddListener listener) {
        listenerList.remove(EdgeAddListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for EdgeAddEvent.
     * </p>
     * @param event
     *            the EdgeAddEvent
     */
    protected void fireEdgeAdd(EdgeAddEvent event) {
        if (event != null) {
            EdgeAddListener[] listeners = listenerList.getListeners(EdgeAddListener.class);
            for (EdgeAddListener listener : listeners) {
                listener.edgeAdd(event);
            }
        }
    }

    /**
     * <p>
     * Notifies the "isVisibile" attribute of stereotype compartment has been changed. This is a convenient variant of
     * notifyGraphNodeChange method.
     * </p>
     * <p>
     * The visual appearance of this node will change according to the current value of GraphNode. JComponent node's
     * boundary may be changed to accommodate the new GraphNode value.
     * </p>
     * @throws IllegalGraphElementException
     *             if graphNode is incorrect when updating
     */
    public void notifyStereotypeVisibilityChange() {
        notifyGraphNodeChange("stereotype compartment's visibility is changed.");
    }

    /**
     * <p>
     * Notifies the "isVisibile" attribute of namespace compartment has been changed. This is a convenient variant of
     * notifyGraphNodeChange method.
     * </p>
     * <p>
     * The visual appearance of this node will change according to the current value of GraphNode. JComponent node's
     * boundary may be changed to accommodate the new GraphNode value.
     * </p>
     * @throws IllegalGraphElementException
     *             if the contained graphNode is incorrect
     */
    public void notifyNamespaceVisibilityChange() {
        notifyGraphNodeChange("namespace compartment's visibility is changed.");
    }
}
