/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.edges.connectors.RectangleConnector;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EdgeAddEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EdgeAddListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EditBoxTrigger;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.NodeAddEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.NodeAddListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.PopupMenuTrigger;

/**
 * <p>
 * This class represents a Subsystem element in UML Model.
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
 * BoundChangeEvent would be triggered by this node. It indicates the node's bound is changed.
 * </p>
 * <p>
 * This class support Drag-And-Drop, and new node or edge adding event can be fired by this class.
 * </p>
 * <p>
 * The structure of the GraphNode that corresponds to a Subsystem is as follows:
 * </p>
 * <p>
 * Uml1SemanticModelBridge.element = UML:Subsystem
 *   SimpleSemanticModelElement.typeInfo = "NameCompartment"
 *     SimpleSemanticModelElement.typeInfo = "StereotypeCompartment"
 *     SimpleSemanticModelElement.typeInfo = "Name"
 *   SimpleSemanticModelElement.typeInfo = "BodyCompartment"
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is mutable, and not thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class SubsystemNodeContainer extends NodeContainer {
    /**
     * <p>
     * Represents the default main color for foreground elements.
     * </p>
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     * <p>
     * This variable is not mutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_STROKE_COLOR = Color.BLACK;

    /**
     * <p>
     * Represents the default main fill color.
     * </p>
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     * <p>
     * This variable is not mutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_FILL_COLOR = Color.WHITE;

    /**
     * <p>
     * Represents the default color for font.
     * </p>
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     * <p>
     * This variable is not mutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_FONT_COLOR = Color.BLACK;

    /**
     * <p>
     * Represents the default family of the font.
     * </p>
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     * <p>
     * This variable is not mutable and can not be null or empty.
     * </p>
     */
    private static final String DEFAULT_FONT_FAMILY = "Arial";

    /**
     * <p>
     * Represents the default size of the font in points.
     * </p>
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     * <p>
     * This variable is not mutable and can be any positive (not 0) value.
     * </p>
     */
    private static final double DEFAULT_FONT_SIZE = 10.0;

    /**
     * <p>
     * The name of the property storing stroke color to be used.
     * </p>
     */
    private static final String STROKE_COLOR = "StrokeColor";

    /**
     * <p>
     * The name of the property storing fill color to be used.
     * </p>
     */
    private static final String FILL_COLOR = "FillColor";

    /**
     * <p>
     * The name of the property storing font color to be used.
     * </p>
     */
    private static final String FONT_COLOR = "FontColor";

    /**
     * <p>
     * The name of the property storing font family to be used.
     * </p>
     */
    private static final String FONT_FAMILY = "FontFamily";

    /**
     * <p>
     * The name of the property storing font size to be used.
     * </p>
     */
    private static final String FONT_SIZE = "FontSize";

    /**
     * <p>
     * Represents the number of compartments should be contained in the graphNode.
     * </p>
     */
    private static final int NUMBER_OF_COMPARTMENTS = 3;

    /**
     * <p>
     * Represents the default width of SubsystemNodeContainer, if it contains nothing.
     * </p>
     */
    private static final int DEFAULT_WIDTH = 100;

    /**
     * <p>
     * Represents the default height of SubsystemNodeContainer, if it contains nothing.
     * </p>
     */
    private static final int DEFAULT_HEIGHT = 80;

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
     * Represents the property name mapping.
     * </p>
     * <p>
     * Same property may have different property names, because the property names are standardized. For example, fill
     * color property may be named as "FillColor", "fill_color", or etc.
     * </p>
     * <p>
     * The key is the predefine property keys, and the value is the actual property name. In this class, "FillColor",
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
     * Construct a SubsystemContainer.
     * </p>
     * <p>
     * Name, stereotype and namespace compartments will be created according to the information contained in the given
     * graphNode.
     * </p>
     *
     * @param graphNode the graphNode corresponding to this Node
     * @param properties the property name mappings.
     * @param handler the transfer handler
     * @throws IllegalArgumentException if any argument is null, or the map contains null/empty element
     * @throws IllegalGraphElementException if the structure of graphNode is invalid.
     */
    public SubsystemNodeContainer(GraphNode graphNode, Map<String, String> properties, TransferHandler handler)
        throws IllegalGraphElementException {
        super(checkValidGraphNode(graphNode), new Point(), new Rectangle(),
                Arrays.asList(Utils.DEFAULT_SELECTION_CORNER_TYPE));
        Utils.checkNull(properties, "properties");
        Utils.checkNull(handler, "handler");
        Utils.checkValidProperties(properties);

        // clone the properties, since it may be changed outside
        this.properties = new HashMap<String, String>(properties);

        // register PopupMenunTrigger to this instance to allow popup.
        this.addMouseListener(new PopupMenuTrigger());

        // create compartements
        this.name = getCompartment(graphNode, 1);
        this.stereotype = getCompartment(graphNode, 0);
        this.namespace = getCompartment(graphNode, 2);

        // add them as a Swing child (to make them to be displayed automatically)
        add(this.name);
        add(this.stereotype);
        add(this.namespace);

        // call to notifyPropertiesChange() to retrieve properties
        notifyPropertiesChange();

        // Register a EditBoxTrigger to allow double-click edit name
        name.addMouseListener(new EditBoxTrigger(name));

        this.setTransferHandler(handler);

        this.connector = new RectangleConnector(this.getSelectionBound());

        // set the actor node's size/relativePosition/selectionBound
        // and load the name, stereotype and namespace's information
        notifyGraphNodeChange(null);
    }

    /**
     * <p>
     * Override of JComponent#setTransferHandler. It is overrode to prohibit null value, because this container is a
     * drag-drop-target.
     * </p>
     *
     * @param newHandler the new transfer handler.
     * @throws IllegalArgumentException if newHandler is null
     */
    public void setTransferHandler(TransferHandler newHandler) {
        Utils.checkNull(newHandler, "newHandler");
        super.setTransferHandler(newHandler);
    }

    /**
     * <p>
     * Override of contains method.
     * </p>
     * <p>
     * The rectangle is retrieved from graphNode.getSize()/getLocation(), but not the boundary of this node.
     * </p>
     *
     * @return whether the given point is contained.
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public boolean contains(int x, int y) {
        /*
         * BugFix: UML-10122
         * Use selection bound.
         */
        // old code
//        Point point = new Point();
//        this.getLocation(point);
//        double width = this.getGraphNode().getSize().getWidth();
//        double height = this.getGraphNode().getSize().getHeight();
//
//        if (x >= point.getX() && x <= point.getY() + width && y >= point.getY() && y <= point.getY() + height) {
//            return true;
//        }
        if (getSelectionBound().contains(x, y)) {
            return true;
        }

        /*
         * BugFix: UML-10122
         */
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
     * Override of paintComponent method.
     * </p>
     * <p>
     * Note, The rectangle is retrieved from graphNode.getSize()/getLocation(). but not the boundary of this node.
     * </p>
     * <p>
     * NOTE, compartments are not need to paint here.
     * Because they are added as child swing component, they can be painted automatically.
     * </p>
     *
     * @param g the graphics to paint on (null is ignored.)
     */
    protected void paintComponent(Graphics g) {
        if (g != null) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            // back up the old color and restore it to the Graphics after the painting is finished
            // this is required by swing component
            Color oldColor = g2.getColor();

            /*
             * BugFix: UML-10118
             */
            // old code
//            Point point = new Point();
//            this.getLocation(point);
            Point point = getRelativePosition();
            int x = point.x;
            int y = point.y;
            int width = (int) this.getGraphNode().getSize().getWidth();
            int height = (int) this.getGraphNode().getSize().getHeight();

            g2.setColor(getFillColor());
            g2.fillRect(x, y, width, height);

            g2.setColor(getStrokeColor());
            g2.drawRect(x, y, width, height);

            // restore the color
            g2.setColor(oldColor);
        }
    }

    /**
     * <p>
     * Get the stroke color. See field document for explanation.
     * </p>
     *
     * @return the stroke color.
     */
    public Color getStrokeColor() {
        return strokeColor;
    }

    /**
     * <p>
     * Get the fill color. See field document for explanation.
     * </p>
     *
     * @return the fill color.
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * <p>
     * Get the font color. See field document for explanation.
     * </p>
     *
     * @return the font color.
     */
    public Color getFontColor() {
        return fontColor;
    }

    /**
     * <p>
     * Getter of connector field. See field document for explanation.
     * </p>
     *
     * @return the connector.
     */
    public Connector getConnector() {
        return connector;
    }

    /**
     * <p>
     * Getter of name compartment belonging to this node.
     * </p>
     *
     * @return the text field representing name compartment.
     */
    public TextField getNameCompartment() {
        return name;
    }

    /**
     * <p>
     * Getter of stereotype compartment belonging to this node.
     * </p>
     *
     * @return the text field representing stereotype compartment.
     */
    public TextField getStereotypeCompartment() {
        return stereotype;
    }

    /**
     * <p>
     * Getter of namespace compartment belonging to this node.
     * </p>
     *
     * @return the text field representing namespace compartment.
     */
    public TextField getNamespaceCompartment() {
        return namespace;
    }

    /**
     * <p>
     * Notify this node, the properties in GraphNode is changed. So we should try to update the fillColor, strokeColor,
     * fontColor, and font values.
     * </p>
     */
    public void notifyPropertiesChange() {
        // parse the colors
        fillColor = Utils.readColorProperty(super.getGraphNode(), properties.get(FILL_COLOR), DEFAULT_FILL_COLOR);
        strokeColor = Utils.readColorProperty(super.getGraphNode(),
                properties.get(STROKE_COLOR), DEFAULT_STROKE_COLOR);
        fontColor = Utils.readColorProperty(super.getGraphNode(), properties.get(FONT_COLOR), DEFAULT_FONT_COLOR);

        // parse the font
        String fontFamily = Utils.getStringProperty(super.getGraphNode(), properties.get(FONT_FAMILY));
        if (fontFamily == null) {
            fontFamily = DEFAULT_FONT_FAMILY;
        }
        double fontSize = Utils.readDoubleProperty(super.getGraphNode(), properties.get(FONT_SIZE), DEFAULT_FONT_SIZE);
        this.setFont(new Font(fontFamily, Font.PLAIN, (int) fontSize));

        // set the compartments' font color
        this.name.setFontColor(fontColor);
        this.stereotype.setFontColor(fontColor);
        this.namespace.setFontColor(fontColor);
    }

    /**
     * <p>
     * Reload diagram interchange information from contained <code>graphNode</code>.
     * </p>
     *
     * @param message telling how graphNode is changed (could be null).
     * @throws IllegalGraphElementException if the structure of graphNode is invalid.
     */
    public void notifyGraphNodeChange(String message) throws IllegalGraphElementException {
        /*
         * BugFix: UML-10119
         * Compartments should be updated first, including their text, font, font color, visibility, etc.
         * Node's graph node size should be compared with preferred size, it should be adjusted to preferred size if
         * it is too small.
         * A compartment' size should be its preferred size for new text, its location should be adjusted
         * according to node's graph node position and size, to make sure the compartment centered in horizontal
         * direction.
         * Since this node use RectangleConnector, the connector's bound should be reset if node's bound is changed.
         */
        // old code
//        Rectangle oldBound = this.getSelectionBound();
//
//        Utils.setNodeSizeRelativePosition(this, super.getGraphNode());
//
//        Rectangle newBound = this.getSelectionBound();
//        if (!newBound.equals(oldBound)) {
//            BoundaryChangedEvent event = new BoundaryChangedEvent(this, oldBound, newBound);
//            fireBoundaryChange(event);
//        }
//
//        // resize and relocate name, stereotype, namespace compartments
//        Utils.updateTextFieldSizeLocation(name);
//        Utils.updateTextFieldSizeLocation(stereotype);
//        Utils.updateTextFieldSizeLocation(namespace);
//
//        try {
//            Subsystem subsystemModel =
//                ((Subsystem) ((Uml1SemanticModelBridge) super.getGraphNode().getSemanticModel()).getElement());
//            name.setText(subsystemModel.getName());
//            stereotype.setText(Utils.getStereotypeText(null, subsystemModel.getStereotypes()));
//            namespace.setText(subsystemModel.getNamespace().getName());
//        } catch (NullPointerException e) {
//            throw new IllegalGraphElementException(getGraphNode(), "expects a correct semantic model", e);
//        } catch (ClassCastException e) {
//            throw new IllegalGraphElementException(getGraphNode(), "the element should be instance of Subsystem", e);
//        }
        GraphNode graphNode = getGraphNode();
        Utils.checkGraphNodeForSubsystem(graphNode);
        notifyPropertiesChange();

        // Get selection corner radius
        int radius = getSelectionCorners().iterator().next().getRadius();

        TextField stereotype = getStereotypeCompartment();
        TextField name = getNameCompartment();
        TextField namespace = getNamespaceCompartment();

        Utils.updateCompartments(this);

        Dimension compartmentSize = new Dimension(0, 0);

        stereotype.setSize(stereotype.getPreferredSize());
        if (stereotype.isVisible()) {
            compartmentSize.width = Math.max(compartmentSize.width, stereotype.getWidth());
            compartmentSize.height += stereotype.getHeight();
        }
        name.setSize(name.getPreferredSize());
        if (name.isVisible()) {
            compartmentSize.width = Math.max(compartmentSize.width, name.getWidth());
            compartmentSize.height += name.getHeight();
        }
        namespace.setSize(namespace.getPreferredSize());
        if (namespace.isVisible()) {
            compartmentSize.width = Math.max(compartmentSize.width, namespace.getWidth());
            compartmentSize.height += namespace.getHeight();
        }

        Dimension size = Utils.getGraphNodeSize(graphNode);
        Dimension preferredSize = getPreferredGraphNodeSize();
        if (size.width < preferredSize.width) {
            size.width = preferredSize.width;
            graphNode.getSize().setWidth(size.width);
        }
        if (size.height < preferredSize.height) {
            size.height = preferredSize.height;
            graphNode.getSize().setHeight(size.height);
        }

        size.width += radius * 2;
        size.height += radius * 2;

        int y = radius;
        if (stereotype.isVisible()) {
            stereotype.setLocation((int) Math.round((size.width - stereotype.getWidth()) * 0.5), y);
            y += stereotype.getHeight();
        }
        if (name.isVisible()) {
            name.setLocation((int) Math.round((size.width - name.getWidth()) * 0.5), y);
            y += name.getHeight();
        }
        if (namespace.isVisible()) {
            namespace.setLocation((int) Math.round((size.width - namespace.getWidth()) * 0.5), y);
        }

        Point location = Utils.getAbsolutePosition(graphNode);
        location.x -= radius;
        location.y -= radius;

        Utils.updateNodeBound(this, new Rectangle(location, size), Utils.getGraphNodeSize(graphNode), message);

        // Reset the connector's rectangle bound
        Rectangle bound = getSelectionBound();
        bound.x += getX();
        bound.y += getY();
        ((RectangleConnector) connector).setRectangle(bound);
    }

    /**
     * <p>
     * Get the preferred graph node size. Please note this is different from JComponent#getPreferredSize(). The returned
     * value indicating the preferred size of core shape of this node. This method is provided for the application to
     * set proper size of graph node.
     * </p>
     *
     * @return the preferred size of graph node.
     */
    public Dimension getPreferredGraphNodeSize() {
        TextField[] textFields = new TextField[] {name, stereotype, namespace};
        /*
         * BugFix: UML-7167
         */
        // old code
//        Rectangle rect = Utils.getBoundedRect(textFields);
//
//        int x1 = rect.x;
//        int y1 = rect.y;
//        int x2 = rect.x + rect.width;
//        int y2 = rect.y + rect.height;
//
//        Set<Node> nodes = getNodes("BodyCompartment");
//        if (nodes != null) {
//            for (Node node : nodes) {
//                int x = node.getLocation().x;
//                int y = node.getLocation().y;
//                int width = node.getSize().width;
//                int height = node.getSize().height;
//                if (x < x1) {
//                    x1 = x;
//                }
//                if (y < y1) {
//                    y1 = y;
//                }
//                if (x + width > x2) {
//                    x2 = x + width;
//                }
//                if (y + height > y2) {
//                    y2 = y + height;
//                }
//            }
//        }
//
//        // if all its compartments are hidden, and it has no child node, the default size will return
//        if (x1 == Integer.MAX_VALUE) {
//            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
//        }
//        return new Dimension(x2 - x1, y2 - y1);
        Dimension size = Utils.getBoundedRect(textFields);

        size.width = Math.max(size.width, DEFAULT_WIDTH);
        size.height = Math.max(size.height, DEFAULT_HEIGHT);

        return size;
    }

    /**
     * <p>
     * Consume the event when the diagram viewer is in the status of adding new element.
     * </p>
     *
     * @return a flag indicating whether the event is consumed
     * @param event the mouse event. (null should be ignored.)
     */
    protected boolean consumeEvent(MouseEvent event) {
        if (event == null) {
            return false;
        }

        return false;
    }

    /**
     * <p>
     * Add {@link BoundaryChangedListener} to the listenerList.
     * </p>
     *
     * @param listener the <code>BoundChangedListener</code> to be registered
     */
    public void addBoundaryChangeListener(BoundaryChangedListener listener) {
        this.listenerList.add(BoundaryChangedListener.class, listener);
    }

    /**
     * <p>
     * Remove a BoundChangeListener from listenerList.
     * </p>
     *
     * @param listener the listener to be removed.
     */
    public void removeBoundaryChangeListener(BoundaryChangedListener listener) {
        this.listenerList.remove(BoundaryChangedListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for BoundChangeEvent.
     * </p>
     *
     * @param event the BoundaryChangedEvent
     */
    protected void fireBoundaryChange(BoundaryChangedEvent event) {
        if (event != null) {
            BoundaryChangedListener[] listeners = listenerList.getListeners(BoundaryChangedListener.class);
            for (BoundaryChangedListener listener : listeners) {
                listener.boundaryChanged(event);
            }
        }
    }

    /**
     * <p>
     * Add {@link NodeAddListener} to the listenerList.
     * </p>
     *
     * @param listener the NodeAddListener to be registered.
     */
    public void addNodeAddListener(NodeAddListener listener) {
        super.listenerList.add(NodeAddListener.class, listener);
    }

    /**
     * <p>
     * Remove an NodeAddListener from listenerList.
     * </p>
     *
     * @param listener the listener to be removed.
     */
    public void removeNodeAddListener(NodeAddListener listener) {
        super.listenerList.remove(NodeAddListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for NodeAddEvent.
     * </p>
     *
     * @param event the NodeAddEvent
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
     * Add {@link EdgeAddListener} to the listenerList.
     * </p>
     *
     * @param listener the EdgeAddListener to be registered.
     */
    public void addEdgeAddListener(EdgeAddListener listener) {
        super.listenerList.add(EdgeAddListener.class, listener);
    }

    /**
     * <p>
     * Remove an EdgeAddListener from listenerList.
     * </p>
     *
     * @param listener the listener to be removed.
     */
    public void removeEdgeAddListener(EdgeAddListener listener) {
        super.listenerList.remove(EdgeAddListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for EdgeAddEvent.
     * </p>
     *
     * @param event the EdgeAddEvent
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
     * Notify the "isVisibile" attribute of stereotype compartment has been changed. This is a convenient variant of
     * notifyGraphNodeChange method.
     * </p>
     * <p>
     * The visual appearance of this node would change according to the current value of GraphNode. JComponent node's
     * boundary may be changed to accommodate the new GraphNode value.
     * </p>
     *
     * @throws IllegalGraphElementException if graphNode is incorrect when updating
     */
    public void notifyStereotypeVisibilityChange() throws IllegalGraphElementException {
        notifyGraphNodeChange("stereotype compartment's visibility is changed.");
    }

    /**
     * <p>
     * Notify the "isVisibile" attribute of namespace compartment has been changed. This is a convenient variant of
     * notifyGraphNodeChange method.
     * </p>
     * <p>
     * The visual appearance of this node would change according to the current value of GraphNode. JComponent node's
     * boundary may be changed to accommodate the new GraphNode value.
     * </p>
     *
     * @throws IllegalGraphElementException if the contained graphNode is incorrect
     */
    public void notifyNamespaceVisibilityChange() throws IllegalGraphElementException {
        notifyGraphNodeChange("namespace compartment's visibility is changed.");
    }

    /**
     * <p>
     * Helper function that checks valid for GraphNode instance.
     * </p>
     * <p>
     * Uml1SemanticModelBridge.element = UML:Subsystem
     *   SimpleSemanticModelElement.typeInfo = "NameCompartment"
     *     SimpleSemanticModelElement.typeInfo = "StereotypeCompartment"
     *     SimpleSemanticModelElement.typeInfo = "Name"
     *   SimpleSemanticModelElement.typeInfo = "BodyCompartment"
     * </p>
     *
     * @param graphNode the GraphNode instance for check
     * @return the instance of GraphNode
     * @throws IllegalGraphElementException if the GraphNode is not a valid UseCase node
     */
    private static GraphNode checkValidGraphNode(GraphNode graphNode) throws IllegalGraphElementException {
        if (graphNode == null) {
            throw new IllegalArgumentException("The graphNode can not be null.");
        }

        GraphElement element = (GraphElement) graphNode.getContaineds().get(0);

        // check if contains stereotype , name and namespace compartment.

        if (element.getContaineds().size() != NUMBER_OF_COMPARTMENTS) {
            throw new IllegalGraphElementException(graphNode, "does not contain 3 compartment.");
        }

        for (int i = 0; i < NUMBER_OF_COMPARTMENTS; i++) {
            if (!(element.getContaineds().get(i) instanceof GraphNode)) {
                throw new IllegalGraphElementException(graphNode, "The contained should be instance of GraphNode");
            }
        }

        return graphNode;
    }

    /**
     * <p>
     * Helper function that return the TextField based on the graphNode and index.
     * </p>
     *
     * @param graphNode the GraphNode instance that contains the information about the TextField
     * @param i the index of the TextField's information
     * @return the newly created TextField instance
     */
    private static TextField getCompartment(GraphNode graphNode, int i) {
        GraphElement element = (GraphElement) graphNode.getContaineds().get(0);

        return new TextField((GraphNode) element.getContaineds().get(i));
    }
}