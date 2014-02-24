/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JPopupMenu;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.BoundaryChangedListener;
import com.topcoder.gui.diagramviewer.uml.classelements.event.EdgeAddEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.EdgeAddListener;
import com.topcoder.gui.diagramviewer.uml.classelements.event.EditBoxTrigger;
import com.topcoder.gui.diagramviewer.uml.classelements.event.PopupGroupFieldTrigger;
import com.topcoder.gui.diagramviewer.uml.classelements.event.PopupMenuTrigger;

/**
 * <p>
 * This is the base Node of this component. It defines the common behavior of all nodes in this component. The all nodes
 * of this component, which are not containers, should inherit from this class.
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
 * BoundaryChangedEvent would be triggered by this node. It indicates the node's bound is changed.
 * </p>
 * <p>
 * This class is mutable, and not thread-safe.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public abstract class BaseNode extends Node {
    /**
     * <p>
     * Represents the minimum size of the base node (only body part excluding external stacked compartments such as
     * attributes and operations). Initialized directly and never changed. Can't be null. Used in any resize operations
     * implemented in this class. Can be helpful for the external components too. This value will be assigned to the
     * minimum size of the related JComponent in the constructor.
     * </p>
     */
    public static final Dimension DEFAULT_MINIMUM_SIZE = new Dimension(60, 40);

    /**
     * <p>
     * Represents the connector of this Node. Application will use this connector to connect to this node.
     * </p>
     * <p>
     * It is initialized in constructor, and never changed later. Never null.
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
     * It can be null, if there is no corresponding property. It will be first retrieved in constructor, and updated in
     * notifyPropertiesChange.
     */
    private Color fillColor;

    /**
     * <p>
     * Represents the stroke color value retrieved from GraphNode property.
     * </p>
     * <p>
     * It will be used by concrete node to draw the node shape.
     * </p>
     * It can be null, if there is no corresponding property. It will be first retrieved in constructor, and updated in
     * notifyPropertiesChange.
     */
    private Color strokeColor;

    /**
     * <p>
     * Represents the font color value retrieved from GraphNode property.
     * </p>
     * <p>
     * It will be used by concrete node to write text on the node.
     * </p>
     * It can be null, if there is no corresponding property. It will be first retrieved in constructor, and updated in
     * notifyPropertiesChange.
     */
    private Color fontColor;

    /**
     * <p>
     * Represents the property name mapping.
     * </p>
     * <p>
     * Each key in the map is used to get the text string of the graphNode property. This string will be used to get the
     * current value from the graphNode.getProperties map. These properties are: color (stroke and fill), font (color,
     * family, size) and so on.
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
     * Represents the attributes compartment of this node. Initialized in constructor, never changed later, can't be
     * null. Can be accessed by getter.
     * </p>
     * <p>
     * The data/size/location of this GroupTextField will be updated in notifyGraphNodeChange method. The attributes'
     * data received by getFeatures method of concrete Model Element implementations: ClassImpl, InterfaceImpl,
     * EnumerationImpl. The attributes' elements should be ordered in the the same order as in features list.
     * </p>
     * <p>
     * The text of attribute contains the visibility, the name, the type and the initial value.
     * </p>
     */
    private final GroupTextField attributes;

    /**
     * <p>
     * Represents the operations compartment of this node. Initialized in constructor, never changed later, can't be
     * null. Can be accessed by getter.
     * </p>
     * <p>
     * The data/size/location of this GroupTextField will be updated in notifyGraphNodeChange method. The operations'
     * data received by getFeatures method of concrete Model Element implementations: ClassImpl, InterfaceImpl,
     * EnumerationImpl. The operations' elements should be ordered in the the same order as in features list.
     * </p>
     * <p>
     * The text of operation contains the visibility, the name, the parameters and the return type.
     * </p>
     */
    private final GroupTextField operations;

    /**
     * <p>
     * Represents a special popup menu for attributes and operations section. The value can be null. Use getter/setter
     * methods to mutate.
     * </p>
     */
    private JPopupMenu attributesOperationsPopup = null;

    /**
     * <p>
     * Constructs a Base Node.
     * </p>
     * @param graphNode
     *            the graphNode corresponding to this Node
     * @param properties
     *            the property names mappings(See field documentation for explanation)
     * @param name
     *            The name compartment object
     * @param stereotype
     *            The stereotype compartment object
     * @param namespace
     *            The namespace compartment object
     * @throws IllegalArgumentException
     *             if given graphNode, properties, name, stereotype, or namespace argument is null, or properties
     *             contains null/empty element
     * @throws IllegalGraphElementException
     *             if the structure of graphNode is invalid
     */
    protected BaseNode(GraphNode graphNode, Map<String, String> properties, TextField name, TextField stereotype,
        TextField namespace) {
        // Correct relative position and selection bound will be calculated in notifyGraphNodeChange
        super(graphNode, new Point(), new Rectangle(), Util.createSelectionCornerTypes());
        Util.checkGraphNode(this);
        Util.checkMapNotNullOrContainingEmpty(properties, "properties");
        Util.checkNotNull(name, "name");
        Util.checkNotNull(stereotype, "stereotype");
        Util.checkNotNull(namespace, "namespace");

        this.properties = properties;
        this.name = name;
        this.stereotype = stereotype;
        this.namespace = namespace;

        // Create attributes compartment and operation compartment
        attributes = new GroupTextField(new ArrayList<StereotypeTextField>());
        operations = new GroupTextField(new ArrayList<StereotypeTextField>());

        // Register PopupMenuTrigger to this instance to allow popup
        addMouseListener(new PopupMenuTrigger());

        // Add as child components
        add(name);
        add(stereotype);
        add(namespace);

        // Register a EditTextBoxTrigger to allow double-click to edit name
        name.addMouseListener(new EditBoxTrigger(name));

        // Register PopupGroupFieldTrigger to the attributes and operations compartments to allow special per
        // attribute/operation popup menu
        attributes.addMouseListener(new PopupGroupFieldTrigger());
        operations.addMouseListener(new PopupGroupFieldTrigger());

        // Add as child components
        add(attributes);
        add(operations);
    }

    /**
     * <p>
     * Sets the connector for this node.
     * </p>
     * @param connector
     *            the connector used to connect this node
     * @throws IllegalArgumentException
     *             if <code>connector</code> is null
     */
    protected void setConnector(Connector connector) {
        Util.checkNotNull(connector, "connector");
        this.connector = connector;
    }

    /**
     * <p>
     * Gets the stroke color.
     * </p>
     * <p>
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
     * Gets of connector.
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

        // Parse the font color for attributes and operations
        for (StereotypeTextField attribute : attributes.getItems()) {
            GraphNode attributeGraphNode = attribute.getGraphNode();
            String property = Util.getPropertyValue(attributeGraphNode, properties, "FontColor");
            attribute.setFontColor(Util.parseColor(property));
        }
        for (StereotypeTextField operation : operations.getItems()) {
            GraphNode operationGraphNode = operation.getGraphNode();
            String property = Util.getPropertyValue(operationGraphNode, properties, "FontColor");
            operation.setFontColor(Util.parseColor(property));
        }

        String fontName = Util.parseFontFamily(fontFamilyValue);
        int fontStyle = Util.parseFontStyle(fontStyleValue);
        double fontSize = Util.parseFontSize(fontSizeValue);

        // Set this node's font
        setFont(new Font(fontName, fontStyle, (int) fontSize));
    }

    /**
     * <p>
     * Notifies the contained graphNode is changed. It is provided for the concrete implementation to update the
     * size/location of this node, and also update the nested compartments.
     * </p>
     * <p>
     * The message parameter is usually used as a reason to tell how the GraphNode is changed. Maybe something like
     * "stereotype is made visible", "name is changed".
     * </p>
     * @param message
     *            message telling how the graphNode is changed
     * @throws IllegalGraphElementException
     *             if the structure of graphNode is invalid
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
     * Notifies the "isVisible" attribute of namespace compartment has been changed. This is a convenient variant of
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

    /**
     * <p>
     * Notifies the "isVisible" attribute of stereotype compartment has been changed. This is a convenient variant of
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
     * Notifies the "isVisible" attribute of attributes compartment has been changed. This is a convenient variant of
     * notifyGraphNodeChange method.
     * </p>
     * <p>
     * The visual appearance of this node would change according to the current value of GraphNode. JComponent node's
     * boundary may be changed to accommodate the new GraphNode value.
     * </p>
     * @throws IllegalGraphElementException
     *             if the contained graphNode is incorrect
     */
    public void notifyAttributesVisibilityChange() {
        notifyGraphNodeChange("attributes compartment's visibility is changed.");
    }

    /**
     * <p>
     * Notifies the "isVisible" attribute of operations compartment has been changed. This is a convenient variant of
     * notifyGraphNodeChange method.
     * </p>
     * <p>
     * The visual appearance of this node would change according to the current value of GraphNode. JComponent node's
     * boundary may be changed to accommodate the new GraphNode value.
     * </p>
     * @throws IllegalGraphElementException
     *             if the contained graphNode is incorrect
     */
    public void notifyOperationsVisibilityChange() {
        notifyGraphNodeChange("operations compartment's visibility is changed.");
    }

    /**
     * <p>
     * Gets the attributes compartment belonging to this node.
     * </p>
     * @return the group of text fields representing attributes compartment
     */
    public GroupTextField getAttributesCompartment() {
        return attributes;
    }

    /**
     * <p>
     * Gets the operations compartment belonging to this node.
     * </p>
     * @return the group of text fields representing operations compartment
     */
    public GroupTextField getOperationsCompartment() {
        return operations;
    }

    /**
     * <p>
     * Notifies the "isVisible" attribute of attributes' element stereotype has been changed. This is a convenient
     * variant of notifyGraphNodeChange method.
     * </p>
     * <p>
     * The visual appearance of this node would change according to the current value of GraphNode. JComponent node's
     * boundary may be changed to accommodate the new GraphNode value.
     * </p>
     * @throws IllegalGraphElementException
     *             if the contained graphNode is incorrect
     */
    public void notifyAttributesStereotypeVisibilityChange() {
        notifyGraphNodeChange("attributes' stereotype's visibility is changed.");
    }

    /**
     * <p>
     * Notify the "isVisible" attribute of operations' element stereotype has been changed. This is a convenient variant
     * of notifyGraphNodeChange method.
     * </p>
     * <p>
     * The visual appearance of this node would change according to the current value of GraphNode. JComponent node's
     * boundary may be changed to accommodate the new GraphNode value.
     * </p>
     * @throws IllegalGraphElementException
     *             if the contained graphNode is incorrect
     */
    public void notifyOperationsStereotypeVisibilityChange() {
        notifyGraphNodeChange("operations' stereotype's visibility is changed.");
    }

    /**
     * <p>
     * Gets the pop menu registered to attributes and operation compartment.
     * </p>
     * @return the popup menu reference registered to the attributes and operation compartment
     */
    public JPopupMenu getAttributesOperationsPopup() {
        return attributesOperationsPopup;
    }

    /**
     * <p>
     * Sets the pop menu registered to attributes and operation compartment. This value should be also set to popupMenu
     * property of the 'operations' and 'attributes'.
     * </p>
     * @param attributesOperationsPopup
     *            The new popup menu reference, to be registered to the 'operations' and 'attributes'
     */
    public void setAttributesOperationsPopup(JPopupMenu attributesOperationsPopup) {
        this.attributesOperationsPopup = attributesOperationsPopup;
        attributes.setComponentPopupMenu(attributesOperationsPopup);
        operations.setComponentPopupMenu(attributesOperationsPopup);
    }
}
