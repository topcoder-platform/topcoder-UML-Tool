/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPopupMenu;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.BoundaryChangedListener;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextInputTrigger;

/**
 * <p>
 * This class is the base <code>Node</code> of this component, it defines the common behavior of all nodes in this
 * component.
 * </p>
 * <p>
 * It contains four properties: fill color, stroke color, font color, and font. (JComponent#setFont and getFont methods
 * are reused to support the font property.)
 * </p>
 * <p>
 * It implements the <code>MouseListener</code> to react to a mouse double-click event, by showing the edit control of
 * the <code>DiagramViewer</code> in order to edit the name of the node.
 * </p>
 * <p>
 * Changes has been made to original design. The compartments are not final any more, and two setters have been added
 * correspondingly for concrete Nodes to update them.
 * </p>
 * <p>
 * Thread safety : This class is mutable and not thread safe.
 * </p>
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public abstract class BaseNode extends Node implements MouseListener {

    /**
     * <p>
     * Represents the stereotype compartment of this node. Initialized in constructor, can't be null. Can be accessed by
     * getter and setter.
     * </p>
     */
    private TextField stereotypeCompartment = null;

    /**
     * <p>
     * Represents the name compartment of this node. Initialized in constructor, can't be null. Can be accessed by
     * getter and setter.
     * </p>
     */
    private TextField nameCompartment = null;

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
     * "StrokeColor", "FontColor", and "FontFamily", "FontStyle", "FontSize" are used as predefined keys.
     * </p>
     * <p>
     * Initialized in constructor, and never changed later, not null, and neither the key nor the value could be null or
     * empty.
     * </p>
     */
    private final Map<String, String> properties;

    /**
     * <p>
     * Represents the fill color value retrieved from <code>GraphNode</code> property.
     * </p>
     * <p>
     * It can be used by concrete node to draw the node shape.
     * </p>
     * <p>
     * It can be null, if there is no corresponding property. It is first retrieved in the constructor, and updated in
     * <code>notifyPropertiesChange</code>.
     * </p>
     */
    private Color fillColor;

    /**
     * <p>
     * Represents the stroke color value retrieved from <code>GraphNode</code> property.
     * </p>
     * <p>
     * It can be used by concrete node to draw the node shape.
     * </p>
     * <p>
     * It can be null, if there is no corresponding property. It is first retrieved in the constructor, and updated in
     * <code>notifyPropertiesChange</code>.
     * </p>
     */
    private Color strokeColor;

    /**
     * <p>
     * Represents the font color value retrieved from <code>GraphNode</code> property.
     * </p>
     * <p>
     * It can be used by concrete node to draw the node shape.
     * </p>
     * <p>
     * It can be null, if there is no corresponding property. It is first retrieved in the constructor, and updated in
     * <code>notifyPropertiesChange</code>.
     * </p>
     */
    private Color fontColor;

    /**
     * <p>
     * Represents the connector of this node. Application will use this connector to connect to this node.
     * </p>
     * <p>
     * It is initialized in the constructor, and never changed later. Never null.
     * </p>
     */
    private final Connector connector;

    /**
     * <p>
     * Creates a <code>BaseNode</code> instance.
     * </p>
     * <p>
     * Compartments are created and added as children, and <code>TextInputTriggers</code> are registered to them.
     * </p>
     * @param graphNode
     *            the graphNode corresponding to this node
     * @param properties
     *            the property names mappings
     * @param connector
     *            the connector used to connect this node
     * @param position
     *            the relative position of visual node
     * @param bound
     *            the selection bound of corners
     * @param corners
     *            all the supported selection corners
     * @throws IllegalArgumentException
     *             if given graphNode, properties, connector, position, bound or corners is null, or properties contains
     *             null/empty element, or corners contains null element or duplicated elements
     * @throws IllegalGraphElementException
     *             if the structure of graphNode is invalid
     */
    protected BaseNode(GraphNode graphNode, Map<String, String> properties, Connector connector, Point position,
        Rectangle bound, Collection<SelectionCornerType> corners) {
        super(graphNode, position, bound, corners);
        Util.chekMapNotNullOrContainingEmpty(properties, "properties");
        Util.checkNotNull(bound, "bound");
        Util.checkNotNull(connector, "connector");

        this.properties = properties;
        this.connector = connector;

    }

    /**
     * <p>
     * Sets the stereotype compartment.
     * </p>
     * @param compartment
     *            new stereotype compartment
     */
    public void setStereotypeCompartment(TextField compartment) {
        if (stereotypeCompartment != null) {
            remove(stereotypeCompartment);
        }
        stereotypeCompartment = compartment;
        add(stereotypeCompartment);
    }

    /**
     * <p>
     * Sets the name compartment.
     * </p>
     * @param compartment
     *            new name compartment
     */
    public void setNameCompartment(TextField compartment) {
        if (nameCompartment != null) {
            remove(nameCompartment);
        }
        nameCompartment = compartment;
        nameCompartment.addMouseListener(new TextInputTrigger(nameCompartment));
        add(nameCompartment);
    }

    /**
     * <p>
     * Implements the MouseListener#mouseClicked() method to react a mouse clicked event. When the node is clicked by
     * the right mouse button, show a pop up menu which can be obtained as the source of the mouse event.
     * </p>
     * @param event
     *            the mouse event
     */
    public void mouseClicked(MouseEvent event) {
        if (event.getButton() != MouseEvent.BUTTON3)
            return;
        if (!(event.getSource() instanceof JComponent))
            return;
        JComponent source = (JComponent) event.getSource();
        JPopupMenu popupMenu = source.getComponentPopupMenu();
        if (popupMenu == null)
            return;
        Point position = event.getPoint();
        popupMenu.show(source, position.x, position.y);
    }

    /**
     * <p>
     * Gets the connector of this node.
     * </p>
     * @return the connector of this node
     */
    public Connector getConnector() {
        return connector;
    }

    /**
     * <p>
     * Gets the fillColor of this node.
     * </p>
     * @return the fill color of this node
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * <p>
     * Gets the strokeColor of this node.
     * </p>
     * @return the stroke color of this node
     */
    public Color getStrokeColor() {
        return strokeColor;
    }

    /**
     * <p>
     * Gets the fontColor of this node.
     * </p>
     * @return the font color of this node
     */
    public Color getFontColor() {
        return fontColor;
    }

    /**
     * <p>
     * Gets the name compartment of this node.
     * </p>
     * @return the text field representing name compartment
     */
    public TextField getNameCompartment() {
        return nameCompartment;
    }

    /**
     * <p>
     * Gets the stereotype compartment of this node.
     * </p>
     * @return the text field representing the stereotype compartment
     */
    public TextField getStereotypeCompartment() {
        return stereotypeCompartment;
    }

    /**
     * <p>
     * Notifies the "isVisibile" attribute of name compartment has been changed.
     * </p>
     * <p>
     * The visual appearance of this node will change according to the current value of GraphNode. JComponent node's
     * boundary may be changed to accommodate the new GraphNode value.
     * </p>
     * @throws IllegalGraphElementException
     *             if graphNode is incorrect when updating
     */
    public void notifyNameCompartmentVisibilityChange() {
        notifyGraphNodeChange("name compartment's visibility is changed.");
    }

    /**
     * <p>
     * Notifies the "isVisibile" attribute of stereotype compartment has been changed.
     * </p>
     * <p>
     * The visual appearance of this node will change according to the current value of GraphNode. JComponent node's
     * boundary may be changed to accommodate the new GraphNode value.
     * </p>
     * @throws IllegalGraphElementException
     *             if graphNode is incorrect when updating
     */
    public void notifyStereotypeCompartmentVisibilityChange() {
        notifyGraphNodeChange("stereotype compartment's visibility is changed.");
    }

    /**
     * <p>
     * Notifies this node, the properties in GraphNode is changed. So we should try to update the fillColor,
     * strokeColor, fontColor, and font values.
     * </p>
     */
    public void notifyPropertiesChange() {
        String fillColorValue = getPropertyValue("FillColor");
        String strokeColorValue = getPropertyValue("StrokeColor");
        String fontColorValue = getPropertyValue("FontColor");
        String fontFamilyValue = getPropertyValue("FontFamily");
        String fontStyleValue = getPropertyValue("FontStyle");
        String fontSizeValue = getPropertyValue("FontSize");

        fillColor = parseColor(fillColorValue);
        strokeColor = parseColor(strokeColorValue);
        fontColor = parseColor(fontColorValue);
        String fontName = parseFontFamily(fontFamilyValue);
        int fontStyle = parseFontStyle(fontStyleValue);
        double fontSize = parseFontSize(fontSizeValue);
        setFont(new Font(fontName, fontStyle, (int) fontSize));
    }

    /**
     * <p>
     * Parses font family string.
     * </p>
     * @param value
     *            a string which represents font family
     * @return font family value, "Arial" if given argument is null
     */
    private String parseFontFamily(String value) {
        if (value == null)
            return "Arial";
        return value;
    }

    /**
     * <p>
     * Parses font style string.
     * </p>
     * @param value
     *            a string which represents font style
     * @return font style value, 0 if given argument is null or incorrect
     */
    private int parseFontStyle(String value) {
        if (value == null)
            return 0;
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * <p>
     * Parses font size string.
     * </p>
     * @param value
     *            a string which represents font size
     * @return font size value, 11.0 if given argument is null or incorrect
     */
    private double parseFontSize(String value) {
        if (value == null)
            return 11.0;
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 11.0;
        }
    }

    /**
     * <p>
     * Parses color property string.
     * </p>
     * @param value
     *            a six characters string which means RRGGBB value (like 0F0F0F)
     * @return a Color object, null if given argument is null or incorrect
     */
    private Color parseColor(String value) {
        if (value == null || value.length() != 6)
            return null;
        int hexValue = 0;
        try {
            hexValue = Integer.parseInt(value, 16);
        } catch (NumberFormatException e) {
            return null;
        }
        return new Color(hexValue);
    }

    /**
     * <p>
     * Gets the property in GraphNode through predefined key.
     * </p>
     * @param key
     *            the predefined key
     * @return the property value in GraphNode, null if not found
     */
    private String getPropertyValue(String key) {
        GraphNode graphNode = getGraphNode();
        String propertyKey = properties.get(key);
        if (propertyKey == null) {
            return null;
        }
        for (Property property : graphNode.getProperties()) {
            if (property.getKey().equals(propertyKey)) {
                return property.getValue();
            }
        }
        return null;
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     */
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Invoked when a mouse button has been released on a component.
     */
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Invoked when the mouse enters a component.
     */
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Invoked when the mouse exits a component.
     */
    public void mouseExited(MouseEvent e) {
    }

    /**
     * <p>
     * Consumes event when the diagram viewer is in the state of adding element. Simply return false.
     * </p>
     * @param event
     *            the mouse event or mouse motion event
     * @return true if the event is consumed, otherwise false
     */
    protected boolean consumeEvent(MouseEvent event) {
        return false;
    }

    /**
     * <p>
     * Adds a BoundChangedListener to the <code>listenerList</code>.
     * </p>
     * @param listener
     *            the BoundaryChangedListener to be registered
     */
    public void addBoundaryChangedListener(BoundaryChangedListener listener) {
        listenerList.add(BoundaryChangedListener.class, listener);
    }

    /**
     * <p>
     * Removes a BoundChangedListener from <code>listenerList</code>.
     * </p>
     * @param listener
     *            the listener to be removed
     */
    public void removeBoundaryChangedListener(BoundaryChangedListener listener) {
        listenerList.remove(BoundaryChangedListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for BoundChangedEvent.
     * </p>
     * @param event
     *            the BoundaryChangedEvent
     */
    public void fireBoundaryChanged(BoundaryChangedEvent event) {
        for (BoundaryChangedListener listener : listenerList.getListeners(BoundaryChangedListener.class)) {
            listener.boundaryChanged(event);
        }
    }

    /**
     * <p>
     * Notifies the contained graph node is changed. It is provided for the concrete implementation to update the
     * size/location of this node, and also update the nested compartments.
     * </p>
     * <p>
     * The message parameter is usually used as a reason to tell how the GraphNode is changed. Maybe something like
     * "stereotype is made visible", "name is changed".
     * </p>
     * @param message
     *            message telling how the graphNode is changed
     * @throws IllegalGraphElementException
     *             if the structure of <code>GraphNode</code> is invalid
     */
    public abstract void notifyGraphNodeChange(String message);

    /**
     * <p>
     * Gets the preferred graph node size. Please note this is different from JComponent#getPreferredSize(). The
     * returned value indicating the preferred size of core shape of this node. This method is provided for the
     * application to set proper size of graph node.
     * </p>
     * @return the preferred size of graph node
     */
    public abstract Dimension getPreferredGraphNodeSize();
}
