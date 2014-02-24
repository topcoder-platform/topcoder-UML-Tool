/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

/**
 * <p>
 * The special class representing a group of text fields for XXXNode in this namespace. It contains a list of inner
 * compartments: items. These text fields are created by the external class and will be registered as child components
 * of the GroupTextField class. So they will be shown automatically. This class only provides the bounding filled
 * rectangle. The coordinates of this class and its compartments are maintained by the external (contained) class.
 * </p>
 * <p>
 * This class is mutable, and not thread-safe.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class GroupTextField extends JComponent {

    /**
     * <p>
     * Represents the minimum size of the compartment. Initialized directly and never changed. Can't be null. Used in
     * any resize operations implemented in the contained class. This value will be assigned to the minimum size of the
     * related JComponent in the constructor.
     * </p>
     */
    public static final Dimension DEFAULT_MINIMUM_SIZE = new Dimension(60, 15);

    /**
     * <p>
     * Represents the items of the group. It could be list of attributes or list of operations. The items are stored as
     * StereotypeTextField - no null elements allowed, but the list can be empty. The variable is assigned in the
     * constructor and never changes. Only the list values can change.
     * </p>
     */
    private final List<StereotypeTextField> items;

    /**
     * <p>
     * Represents the background color value.
     * </p>
     * <p>
     * It will be used to fill a bounding rectangle of this compartment.
     * </p>
     * <p>
     * It will be accessed by setter/getter. Never null.
     * </p>
     */
    private Color fillColor = Color.WHITE;

    /**
     * <p>
     * Represents the line color value.
     * </p>
     * <p>
     * It will be used to paint a bounding rectangle of this compartment.
     * </p>
     * <p>
     * It will be accessed by setter/getter. Never null.
     * </p>
     */
    private Color strokeColor = Color.BLACK;

    /**
     * <p>
     * Represents the font color value.
     * </p>
     * <p>
     * It will be used to paint text.
     * </p>
     * <p>
     * It will be accessed by setter/getter. Never null.
     * </p>
     */
    private Color fontColor = Color.BLACK;

    /**
     * <p>
     * Constructs the GroupTextField instance.
     * </p>
     * @param items
     *            the items contained in this group
     * @throws IllegalArgumentException
     *             if items is null or any of its element is null
     */
    public GroupTextField(ArrayList<StereotypeTextField> items) {
        Util.checkCollectionNotNull(items, "items");
        this.items = items;

        setItems(items);
    }

    /**
     * <p>
     * Gets the items value. Refer to the variable's documentation.
     * </p>
     * @return The items value (the list of stereotype text fields)
     */
    public List<StereotypeTextField> getItems() {
        return items;
    }

    /**
     * <p>
     * Setter method for the items variable. Refer to the variable's documentation. Clear the items list and set its new
     * elements from the argument. No null elements allowed. But the list can be empty. It should also remove the all
     * child graphical components and register the all new text fields as its children.
     * </p>
     * @param items
     *            the list of stereotype text fields to be set to the items variable
     * @throws IllegalArgumentException
     *             if items is null or any of its element is null
     */
    public void setItems(ArrayList<StereotypeTextField> items) {
        Util.checkCollectionNotNull(items, "items");

        // Remove old items
        for (StereotypeTextField item : this.items) {
            remove(item);
        }
        this.items.clear();

        // Add new items
        for (StereotypeTextField item : items) {
            this.items.add(item);
            add(item);
        }
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
     * Sets the fill color. Null is allowed to use default color(White).
     * </p>
     * @param fillColor
     *            the new fill color
     */
    public void setFillColor(Color fillColor) {
        if (fillColor == null) {
            this.fillColor = Color.WHITE;
        } else {
            this.fillColor = fillColor;
        }
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
     * Sets the strokeColor field. Null is allowed to use default color(Black).
     * </p>
     * @param strokeColor
     *            the new stroke color
     */
    public void setStrokeColor(Color strokeColor) {
        if (strokeColor == null) {
            this.strokeColor = Color.BLACK;
        } else {
            this.strokeColor = strokeColor;
        }
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
     * Set the font color. Null is allowed to use default color(Black).
     * </p>
     * @param fontColor
     *            the new font color
     */
    public void setFontColor(Color fontColor) {
        if (fontColor == null) {
            this.fontColor = Color.BLACK;
        } else {
            this.fontColor = fontColor;
        }
    }

    /**
     * <p>
     * Gets preferred size of current compartment. It should take the preferred size of the all stereotype text fields.
     * </p>
     * @return the preferred size
     */
    public Dimension getPreferredSize() {
        Dimension size = new Dimension(0, 0);
        // This variable records the last visible item's size
        Dimension last = null;
        for (StereotypeTextField item : items) {
            if (item.isVisible()) {
                last = item.getPreferredSize();
                Util.combineSize(size, last, true);
            }
        }
        // Remove the last gap if it exits
        if (last != null) {
            size.height -= (int) Math.round(last.height * Util.GAP_PERCENT);
        }

        // If the size's width or height is small than the default minimum, adjust it
        size.width = Math.max(size.width, DEFAULT_MINIMUM_SIZE.width);
        size.height = Math.max(size.height, DEFAULT_MINIMUM_SIZE.height);
        return size;
    }

    /**
     * <p>
     * Paints the component.
     * </p>
     * @param g
     *            the graphics to paint on(null will be ignored)
     */
    protected void paintComponent(Graphics g) {
        if (g == null) {
            return;
        }
        if (!isVisible()) {
            return;
        }
        Color oldColor = g.getColor();
        g.setColor(fillColor);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(strokeColor);
        g.drawRect(0, 0, getWidth(), getHeight());
        g.setColor(oldColor);
    }

    /**
     * <p>
     * Calculates the index of the 'items' variable element, which is under given graphical position. Then this element
     * (StereotypeTextField) return back. This function is useful to find the element in the group, that was clicked by
     * mouse.
     * </p>
     * @param pos
     *            Graphics coordinates of the element to search
     * @return found element of the 'items' list, if not found null value returned
     * @throws IllegalArgumentException
     *             if given position is null
     */
    public StereotypeTextField findItem(Point pos) {
        Util.checkNotNull(pos, "pos");

        // Search all items, return the item which bound contains given point
        for (StereotypeTextField item : items) {
            if (item.getBounds().contains(pos)) {
                return item;
            }
        }

        return null;
    }
}
