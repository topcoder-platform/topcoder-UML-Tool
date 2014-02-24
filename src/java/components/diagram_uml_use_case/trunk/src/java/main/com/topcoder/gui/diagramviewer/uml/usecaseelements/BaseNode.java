/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EditBoxTrigger;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.PopupMenuTrigger;

/**
 * <p>
 * This is the base Node of this component. It defines the common behaviors of all nodes in this component.
 * </p>
 * <p>
 * It contains four properties. They are fill color, stroke color, font color, and font. Especially, JComponent#setFont
 * and getFont methods are reused to support the font property.
 * </p>
 * <p>
 * Name compartment, stereotype compartment and namespace compartment are defined in this class. This class also
 * implements adds EditBoxTrigger in constructor automatically to allow name editing.
 * </p>
 * <p>
 * BoundChangeEvent would be triggered by this node. It indicates the node's bound is changed.
 * </p>
 * <p>
 * <b>Thread safety</b>: This class is mutable, and not thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public abstract class BaseNode extends Node {
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
    private static final Color DEFAULT_FILL_COLOR = Color.BLACK;

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
     * Represents the connector of this Node. Application will use this connector to connect to this node.
     * </p>
     * <p>
     * It is initialized in setConnector, and never changed later. Never null after initialized.
     * </p>
     */
    private Connector connector;

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
    private Color fillColor = null;

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
    private Color strokeColor = null;

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
    private Color fontColor = null;

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
     * It is initialized in constructor, and never changed later, not null. Neither the key nor the value could be null
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
     * Construct a Base Node.
     * </p>
     *
     * @param graphNode the graphNode corresponding to this Node
     * @param properties the property names mappings(See field document for explanation).
     * @param name the TextField representing the name
     * @param stereotype the TextField representing the stereotype
     * @param namespace the TextField representing the namespace
     * @throws IllegalArgumentException if any argument is null. Or map contains null/empty element
     */
    protected BaseNode(GraphNode graphNode, Map<String, String> properties, TextField name, TextField stereotype,
            TextField namespace) {
        super(graphNode, new Point(), new Rectangle(), Arrays.asList(Utils.DEFAULT_SELECTION_CORNER_TYPE));
        Utils.checkNull(properties, "properties");
        Utils.checkNull(name, "name");
        Utils.checkNull(stereotype, "stereotype");
        Utils.checkNull(namespace, "namespace");
        Utils.checkValidProperties(properties);

        // clone the properties, since it may be changed outside
        this.properties = new HashMap<String, String>(properties);
        this.name = name;
        this.stereotype = stereotype;
        this.namespace = namespace;

        // call to notifyPropertiesChange() to retrieve properties
        notifyPropertiesChange();

        // register PopupMenuTrigger to this instance to allow popup
        this.addMouseListener(new PopupMenuTrigger());

        // register EditBoxTrigger to these compartments
        this.name.addMouseListener(new EditBoxTrigger(this.name));
        this.stereotype.addMouseListener(new EditBoxTrigger(this.stereotype));
        this.namespace.addMouseListener(new EditBoxTrigger(this.namespace));

        // add name compartment and stereotype compartment as a Swing child
        add(name);
        add(stereotype);
        add(namespace);
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
     * Setter of connector field. See field document for explanation.
     * </p>
     * <p>
     * It should be set in the concrete class constructor, and never changed later.
     * </p>
     *
     * @param connector the connector used to connect this node
     * @throws IllegalArgumentException if <code>connector</code> is null
     */
    protected void setConnector(Connector connector) {
        Utils.checkNull(connector, "connector");
        this.connector = connector;
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
     * Notify the contained graphNode is changed. It is provided for the concrete implementation to update the
     * size/location of this node, and also update the nested compartments.
     * </p>
     * <p>
     * The message parameter is usually used as a reason to tell how the GraphNode is changed. Maybe something like
     * "stereotype is made visible", "name is changed".
     * </p>
     *
     * @param message message telling how the graphNode is changed.
     * @throws IllegalGraphElementException if the structure of graphNode is invalid.
     */
    public abstract void notifyGraphNodeChange(String message) throws IllegalGraphElementException;

    /**
     * <p>
     * Get the preferred graph node size. Please note this is different from JComponent#getPreferredSize(). The returned
     * value indicating the preferred size of core shape of this node. This method is provided for the application to
     * set proper size of graph node.
     * </p>
     *
     * @return the preferred size of graph node.
     */
    public abstract Dimension getPreferredGraphNodeSize();

    /**
     * <p>
     * Consume the event when the diagram viewer is in the status of adding new element. Because all the Nodes in this
     * component don't react such events, we provide a default implementation here.
     * </p>
     * <p>
     * Always return false, indicating the event can't be consumed in this Node.
     * </p>
     *
     * @return always false
     * @param event the mouse event
     */
    protected boolean consumeEvent(MouseEvent event) {
        return false;
    }

    /**
     * <p>
     * Add {@link BoundaryChangedListener} to the listenerList.
     * </p>
     *
     * @param listener the BoundChangeListener to be registered.
     */
    public void addBoundaryChangeListener(BoundaryChangedListener listener) {
        super.listenerList.add(BoundaryChangedListener.class, listener);
    }

    /**
     * <p>
     * Remove an BoundChangeListener from listenerList.
     * </p>
     *
     * @param listener the listener to be removed.
     */
    public void removeBoundaryChangeListener(BoundaryChangedListener listener) {
        super.listenerList.remove(BoundaryChangedListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for BoundaryChangedEvent.
     * </p>
     *
     * @param event the BoundChangeEvent
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
     * Notify the "isVisibile" attribute of stereotype compartment has been changed. This is a convenient variant of
     * notifyGraphNodeChange method.
     * </p>
     * <p>
     * The visual appearance of this node would change according to the current value of GraphNode. JComponent node's
     * boundary may be changed to accommodate the new GraphNode value.
     * </p>
     *
     * @throws IllegalGraphElementException if the contained graphNode is incorrect
     */
    public void notifyStereotypeVisibilityChange() throws IllegalGraphElementException {
        notifyGraphNodeChange("stereotype compartment's visibility is changed.");
    }
}
