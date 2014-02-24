/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

import java.awt.event.MouseEvent;

import java.util.Arrays;
import java.util.Collection;


/**
 * <p>
 * This is the base Node of this component.
 * It defines the common behaviors of all nodes in this component.
 * </p>
 *
 * <p>
 * It contains four properties.
 * They are fill color, stroke color, font color, and font.
 * Especially, <code>JComponent#setFont</code> and <code>getFont</code> methods
 * are reused to support the font property.
 * A <code>PropertyMapping</code> instance is also contained to provide the property name mappings.
 * </p>
 *
 * <p>
 * <code>BoundaryChangeEvent</code> would be triggered by this node.
 * It indicates the node's bound is changed.
 * </p>
 *
 * <p>
 * This class is mutable, and not thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public abstract class BaseNode extends Node {
    /**
     * <p>
     * Static final field for string "Arial".
     * </p>
     */
    private static final String ARIAL = "Arial".intern();

    /**
     * <p>
     * Constant for default font size.
     * </p>
     */
    private static final double DEFAULT_FONTSIZE = 11.0;

    /**
     * <p>
     * Represents the fill color value retrieved from <code>GraphNode</code> property.
     * It is the color used to fill the node shape by concrete Node.
     * </p>
     *
     * <p>
     * It can be <code>null</code>, if there is not corresponding property.
     * It will be first retrieved in constructor, and updated in <code>notifyPropertiesChange</code>.
     * </p>
     */
    private Color fillColor;

    /**
     * <p>
     * Represents the stroke color value retrieved from <code>GraphNode</code> property.
     * It is the color which will be used to draw the node shape boundary by concrete Node.
     * </p>
     *
     * <p>
     * It can be <code>null</code>, if there is not corresponding property.
     * It will be first retrieved in constructor, and updated in <code>notifyPropertiesChange</code>.
     * </p>
     */
    private Color strokeColor;

    /**
     * <p>
     * Represents the font color value retrieved from <code>GraphNode</code> property.
     * It is the color which will be used to render the text in concrete Node.
     * </p>
     *
     * <p>
     * It can be <code>null</code>, if there is not corresponding property.
     * It will be first retrieved in constructor, and updated in <code>notifyPropertiesChange</code>.
     * </p>
     */
    private Color fontColor;

    /**
     * <p>
     * Represents the <code>PropertyMapping</code> value for this Node.
     * It will be used to retrieve the actual property name in <code>notifyPropertiesChange</code>.
     * </p>
     *
     * <p>
     * It is initialized in constructor, and never changed later, can't be <code>null</code>.
     * </p>
     */
    private final PropertyMapping properties;

    /**
     * <p>
     * Constructs a Base Node.
     * </p>
     *
     * @param graphNode - the graphNode corresponding to this Node
     * @param properties - the property mappings.(See corresponding variable doc for details)
     *
     * @throws IllegalArgumentException - if any arg is null
     */
    protected BaseNode(GraphNode graphNode, PropertyMapping properties) {
        // Passes graphNode to super constructor.
        // The super constructor will check whether any of the args is null,
        // and if any arg is null, a IAE will be thrown.
        // configures the 8 corners.
        super(graphNode, new Point(), new Rectangle(), Arrays.asList(SelectionCornerType.values()));

        // Checks whether the properties is null,
        // if it is null, a IAE will be thrown.
        AuxiliaryElementsHelper.checkNotNull(properties, "properties");

        // assigns properties.
        this.properties = properties;

        // registers PopupMenunTrigger to this instance to allow popup.
        this.addMouseListener(new PopupMenuTrigger());
    }

    /**
     * <p>
     * Gets the stroke color. See field doc for explanation.
     * </p>
     *
     * @return the stroke color - this.strokeColor
     */
    public Color getStrokeColor() {
        return this.strokeColor;
    }

    /**
     * <p>
     * Gets the fill color. See field doc for explanation.
     * </p>
     *
     * @return the fill color - this.fillColor
     */
    public Color getFillColor() {
        return this.fillColor;
    }

    /**
     * <p>
     * Gets the font color. See field doc for explanation.
     * </p>
     *
     * @return the font color.
     */
    public Color getFontColor() {
        return this.fontColor;
    }

    /**
     * <p>
     * Gets the diagram element storing properties.
     * </p>
     *
     * @return the diagram element storing properties.
     */
    protected DiagramElement getPropertiesDiagramElement() {
        return super.getGraphNode();
    }

    /**
     * <p>
     * Notifies this node, the properties in <code>GraphNode</code> is changed.
     * So we should try to update the fillColor, strokeColor, fontColor, and font values.
     * </p>
     *
     * @throws IllegalGraphNodeException - if any error occurs while parsing the color, font name or etc.
     */
    public void notifyPropertiesChange() {
        // Gets properties of GraphNode
        Collection<Property> graphNodeProperties = getPropertiesDiagramElement().getProperties();

        // Default value of FONT_FAMILY and FONT_SIZE
        String fontFamily = ARIAL;
        double fontSize = DEFAULT_FONTSIZE;

        // updates the fillColor, strokeColor, fontColor, and font values.
        for (Property property : graphNodeProperties) {
            if (property.getKey().equals(this.properties.getPropertyKey(PropertyMapping.FILL_COLOR))) {
                this.fillColor =
                    AuxiliaryElementsHelper.parseColor(super.getGraphNode(), property.getValue());
            } else if (property.getKey().equals(this.properties.getPropertyKey(PropertyMapping.STROKE_COLOR))) {
                this.strokeColor =
                    AuxiliaryElementsHelper.parseColor(super.getGraphNode(), property.getValue());
            } else if (property.getKey().equals(this.properties.getPropertyKey(PropertyMapping.FONT_COLOR))) {
                this.fontColor =
                    AuxiliaryElementsHelper.parseColor(super.getGraphNode(), property.getValue());
            } else if (property.getKey().equals(this.properties.getPropertyKey(PropertyMapping.FONT_FAMILY))) {
                fontFamily = property.getValue();
            } else if (property.getKey().equals(this.properties.getPropertyKey(PropertyMapping.FONT_SIZE))) {
                try {
                    fontSize = Double.parseDouble(property.getValue());
                } catch (NumberFormatException nfe) {
                    throw new IllegalGraphNodeException(
                            super.getGraphNode(), "The fontSize should have a double value.");
                }
            }
        }

        // updates font
        this.setFont(new Font(fontFamily, Font.PLAIN, (int) fontSize));
    }

    /**
     * <p>
     * Consumes the event when the diagram viewer is in the status of adding new element.
     * Because all the Nodes in this component don't react such events,
     * We provide a default implementation here.
     * </p>
     *
     * <p>
     * Always return <code>false</code>,
     * indicating the event can't be consumed in this Node. (Including <code>null</code> param)
     * </p>
     *
     * @return always false
     *
     * @param event - the event to be consumed (null is allowed in this method)
     */
    protected boolean consumeEvent(MouseEvent event) {
        return false;
    }

    /**
     * <p>
     * Notifies the <code>graphNode</code> or its contained value is changed.
     * Maybe the node should be resized.
     * </p>
     *
     * @throws IllegalGraphNodeException - if the graphNode is illegal to update.
     */
    public abstract void notifyUpdate();

    /**
     * <p>
     * Adds {@link BoundaryChangeListener} to the listenerList.
     * </p>
     *
     * <p>
     * Note, <code>null</code> can be ignored automaticall by <code>listenerList#add</code> method.
     * </p>
     *
     * @param listener - the BoundaryChangeListener to be registered. (null value will be silently ignored)
     */
    public void addBoundaryChangeListener(BoundaryChangeListener listener) {
        this.listenerList.add(BoundaryChangeListener.class, listener);
    }

    /**
     * <p>
     * Removes an <code>BoundaryChangeListener</code> from listenerList.
     * </p>
     *
     * <p>
     * Note, <code>null</code> can be ignored by <code>listernList#remove</code> method.
     * </p>
     *
     * @param listener - the listener to be removed. (null value will be silently ignored)
     */
    public void removeBoundaryChangeListener(BoundaryChangeListener listener) {
        this.listenerList.remove(BoundaryChangeListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for <code>BoundaryChangeEvent</code>.
     * </p>
     *
     * <p>
     * Note, <code>null</code> param should be ignored.(return silently)
     * This just follows the similar methods in SWING framework.
     * </p>
     *
     * @param event - the BoundaryChangeEvent (null value will be silently ignored)
     */
    protected void fireBoundaryChange(BoundaryChangeEvent event) {
        // Gets all BoundaryChangeListeners
        BoundaryChangeListener[] listeners = listenerList.getListeners(BoundaryChangeListener.class);

        // notifies all these listeners
        for (BoundaryChangeListener listener : listeners) {
            listener.boundaryChanged(event);
        }
    }
}
