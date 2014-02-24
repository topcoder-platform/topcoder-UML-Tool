/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.diagraminterchange.GraphNode;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.FontMetrics;
import java.awt.Graphics2D;


/**
 * <p>
 * This abstract class defines a <code>Node</code> which contains only text values.
 * It provides some methods to display the text, and to measure the text.
 * </p>
 *
 * <p>
 * <code>TextChangeEvent</code> could be triggered by this class.
 * It indicates the text is expected to be changed.
 * </p>
 *
 * <p>
 * This class is mutable, and not thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public abstract class TextNode extends BaseNode {
    /**
     * <p>
     * A flag indicating whether the text should be displayed or not.
     * </p>
     *
     * <p>
     * It can be accessed by setter/getter. And it is true initially.
     * </p>
     */
    private boolean displayText = true;

    /**
     * <p>
     * Constructs a Text Node.
     * </p>
     *
     * @param graphNode - the graphNode corresponding to this Node
     * @param properties - the porperty mappings. (See corresponding variable doc for details)
     *
     * @throws IllegalArgumentException - if any arg is null
     * @throws IllegalGraphNodeException - if the graphNode is illegal
     */
    protected TextNode(GraphNode graphNode, PropertyMapping properties) {
        // Passes graphNode and properties to super constructor.
        // the super constructor will check whether the properties is null,
        // and if it is null, a IAE will be thrown.
        // the super constructor will configured the 8 corners.
        // the super constructor will store the properties.
        // The Helper class will check whether the graphNode is null,
        // and if it is null, a IAE will be thrown.
        // The Helper class will also check whether the graphNode is a Comment Node,
        // and if it isn't a Comment Node, a IGE will be thrown.
        // if it is valid, itself will returned.
        super(AuxiliaryElementsHelper.validateGraphNodeForTextNode(graphNode), properties);

        // Adds a MouseListener for this TextNode
        this.addMouseListener(new TextNodeMouseListener());

        super.notifyPropertiesChange();
    }

    /**
     * <p>
     * Gets the displayText field. See field doc for explanation.
     * </p>
     *
     * @return the displayText flag.
     */
    public boolean isDisplayText() {
        return this.displayText;
    }

    /**
     * <p>
     * Sets the displayText field. See field doc for explanation.
     * </p>
     *
     * @param displayText - the new flag value.
     */
    public void setDisplayText(boolean displayText) {
        this.displayText = displayText;
    }

    /**
     * <p>
     * Gets the text to display.
     * It should be implemented by concrete <code>Node</code>.
     * </p>
     *
     * @return the text to be display.
     */
    public abstract String getText();

    /**
     * <p>
     * Calculates the preferred size if the text is changed to given value.
     * It should be implemented by concrete Node.
     * </p>
     *
     * <p>
     * <code>Null</code> will be treated as empty string.
     * </p>
     *
     * @return the preferred node size for given text.
     *
     * @param text - the new text to be used.
     */
    public abstract Dimension getPreferredSize(String text);

    /**
     * <p>
     * Gets the preferred size of this node.
     * </p>
     *
     * @return the preferred size of this node.
     */
    public Dimension getPreferredSize() {
        return getPreferredSize(getText());
    }

    /**
     * <p>
     * Gets minimum size of this node.
     * </p>
     *
     * @return the minimum size of this node.
     */
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    /**
     * <p>
     * Measures size of given text.
     * Note, in this measurement, the pure text bound is calculated.
     * It could be used by subclasses to calculate the size of whole node.
     * </p>
     *
     * @return the size of given text.
     *
     * @param text - the text to be measured.
     */
    protected Dimension measureText(String text) {
        // If the text is null or empty.
        if (text == null || text.length() == 0) {
            return new Dimension(0, 0);
        }

        // Gets the FontMetrics.
        FontMetrics fontMetrics = getFontMetrics(getFont());

        // calculates the size of the text.
        int width = 0;
        String[] parts = text.split("\n");
        for (String part : parts) {
            int d = fontMetrics.stringWidth(part);
            if (d > width) {
                width = d;
            }
        }
        return new Dimension(width, parts.length * fontMetrics.getHeight());
    }

    /**
     * <p>
     * Paints text on the graphics, the left up corner is defined by offset.
     * This is method can be used by subclass to paint the node.
     * </p>
     *
     * @param g - the graphics to paint on
     * @param offset - the offset value.
     *
     * @throws IllegalArgumentException - if any arg is null.
     */
    protected void paintText(Graphics g, Point offset) {
        // Checks whether the args is null,
        // if any one is null, a IAE will be thrown.
        AuxiliaryElementsHelper.checkNotNull(g, "graphics");
        AuxiliaryElementsHelper.checkNotNull(offset, "offset");

        // if text should not be displayed or the text is null.
        if (!this.displayText || getText() == null) {
            return;
        }

        // splits the text, and then draw the string one by one.
        Graphics2D g2d = (Graphics2D) g.create();
        String[] parts = getText().split("\n");
        int y = offset.y + g2d.getFontMetrics().getHeight();
        for (String part : parts) {
            g2d.drawString(part, offset.x, y);
            y += g2d.getFontMetrics().getHeight();
        }
    }

    /**
     * <p>
     * Paints text on the graphics, the left up corner is defined by offset.
     * This is method can be used by subclass to paint the node.
     * Wrap the text within the bounds given.
     * </p>
     *
     * @param g - the graphics to paint on
     * @param offset - the offset value.
     * @param maxWidth - the maximum width in which the text must be drawn.
     * @param maxHeight - the maximum height in which the text must be drawn.
     *
     * @throws IllegalArgumentException - if any arg is null.
     */
    protected void paintTextWrap(Graphics g, Point offset, int maxWidth, int maxHeight) {
        // Checks whether the args is null,
        // if any one is null, a IAE will be thrown.
        AuxiliaryElementsHelper.checkNotNull(g, "graphics");
        AuxiliaryElementsHelper.checkNotNull(offset, "offset");

        // if text should not be displayed or the text is null.
        if (!this.displayText || getText() == null) {
            return;
        }

        // splits the text, and then draw the string one by one.
        Graphics2D g2d = (Graphics2D) g.create();
        String[] parts = getText().split("\n");
        int y = offset.y + g2d.getFontMetrics().getHeight();
        for (String part : parts) {
            int spaceAdvance = g2d.getFontMetrics().stringWidth(" ");
            int maxAdvance = g2d.getFontMetrics().getMaxAdvance();
            String displayPart = "";
            int currentWidth = offset.x;
            String[] subParts = part.split(" ");
            for (String subPart : subParts) {
                int subPartWidth = g2d.getFontMetrics().stringWidth(subPart);
                if (currentWidth + subPartWidth + maxAdvance >= maxWidth) {
                    if (y+g2d.getFontMetrics().getHeight()<=maxHeight) {
                        g2d.drawString(displayPart, offset.x, y);
                        y += g2d.getFontMetrics().getHeight();
                    }
                    displayPart = subPart;
                    currentWidth = offset.x + subPartWidth;
                }
                else {
                    currentWidth += subPartWidth + spaceAdvance;
                    displayPart += " " + subPart;
                }
            }
            if (currentWidth > offset.x && y+g2d.getFontMetrics().getHeight()<=maxHeight) {
                g2d.drawString(displayPart, offset.x, y);
                y += g2d.getFontMetrics().getHeight();
            }
        }
    }

    /**
     * <p>
     * Adds {@link TextChangeListener} to the listenerList.
     * </p>
     *
     * @param listener - the TextChangeListener to be registered. (null will be ignored)
     */
    public void addTextChangeListener(TextChangeListener listener) {
        super.listenerList.add(TextChangeListener.class, listener);
    }

    /**
     * <p>
     * Removes an <code>TextChangeListener</code> from listenerList.
     * </p>
     *
     * @param listener - the listener to be removed. (null will be ignored)
     */
    public void removeTextChangeListener(TextChangeListener listener) {
        super.listenerList.remove(TextChangeListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for <code>TextChangeEvent</code>.
     * </p>
     *
     * @param event - the TextChangeEvent (null will be ignored)
     */
    protected void fireTextChange(TextChangeEvent event) {
        // Gets all TextChangeListeners
        TextChangeListener[] listeners = listenerList.getListeners(TextChangeListener.class);

        // Notifies all these listeners
        for (TextChangeListener listener : listeners) {
            listener.textChanged(event);
        }
    }
}
