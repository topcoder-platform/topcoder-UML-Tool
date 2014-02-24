/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedListener;

/**
 * <p>
 * Text field represents pure text compartment of Node or Edge. It could be used to represent name compartment,
 * stereotype compartment and etc. Text field would be displayed as pure text with font and color inherited form
 * parent node or edge. There is no decorator around or on the text.
 * </p>
 * <p>
 * It extends from com.topcoder.gui.diagramviewer.edges.TextField to allow to be added to Edge. After the Diagram
 * Edges component is finally released, the methods and attributes already defined in base class should be removed
 * in this class.
 * </p>
 * <p>
 * Please note, because this class contains all Font properties (through GraphNode reference). These properties
 * include font size, font family name, and italics style (for abstract class name or methods).
 * </p>
 * <p>
 * This class is mutable, and not thread-safe.
 * </p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class TextField extends com.topcoder.gui.diagramviewer.edges.TextField {
    /**
     * <p>
     * Represents the text to be displayed on this TextField. It is empty string initially. The value can't be
     * null.
     * </p>
     * <p>
     * It can be accessed by setter/getter.
     * </p>
     */
    private String text = "";

    /**
     * <p>
     * Represents the font color value.
     * </p>
     * <p>
     * It will be used to paint text.
     * </p>
     * <p>
     * It will be accessed by setter/getter. Can be null.
     * </p>
     */
    private Color fontColor = Color.BLACK;

    /**
     * <p>
     * Creates an instance of <code>TextField</code>.
     * </p>
     *
     * @param graphNode
     *            the graphNode in diagram interchange
     * @throws IllegalArgumentException
     *             if graphNode is null
     */
    public TextField(GraphNode graphNode) {
        this(graphNode, AnchorType.Line);
    }

    /**
     * <p>
     * Creates an instance of <code>TextField</code>.
     * </p>
     *
     * @param graphNode
     *            the graphNode in diagram interchange
     * @param anchorType
     *            anchor type of the text field
     * @throws IllegalArgumentException
     *             if graphNode or anchorType is null
     */
    public TextField(GraphNode graphNode, AnchorType anchorType) {
        super(graphNode, "", anchorType);
        this.setOpaque(false);
    }

    /**
     * <p>
     * Gets the text value.
     * </p>
     *
     * @return the text string
     */
    public String getText() {
        return text;
    }

    /**
     * <p>
     * Sets new text to be displayed. Null will be converted to empty string.
     * </p>
     *
     * @param text
     *            the new text value
     */
    public void setText(String text) {
        if (text == null) {
            this.text = "";
        } else {
            this.text = text;
        }
    }

    /**
     * <p>
     * Gets the font color of this text field.
     * </p>
     *
     * @return the font color
     */
    public Color getFontColor() {
        return fontColor;
    }

    /**
     * <p>
     * Sets the font color. Null is allowed.
     * </p>
     *
     * @param fontColor
     *            the new font color
     */
    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    /**
     * <p>
     * Notifies the text is going to be changed. This method doesn't change this.text actually. Application should
     * register a TextChangedListener to listen event, and do the actual change.
     * </p>
     *
     * @param newText
     *            the new text, null is treated as empty string
     */
    public void notifyTextChange(String newText) {
        if (newText == null) {
            newText = "";
        }
        TextChangedEvent textChangedEvent = new TextChangedEvent(this, text, newText);
        fireTextChanged(textChangedEvent);
    }

    /**
     * <p>
     * Gets preferred size of current compartment.
     * </p>
     *
     * @return the preferred size
     */
    public Dimension getPreferredSize() {
        return measureSize(getText());
    }

    /**
     * <p>
     * Measures the text size according to font.
     * </p>
     *
     * @param text
     *            the text to be measured
     * @return the size of text in current environment
     * @throws IllegalArgumentException
     *             if given text is null
     * @throws IllegalStateException
     *             if can not get the font
     */
    public Dimension measureSize(String text) {
        Util.checkNotNull(text, "text");
        Font font = getFont();
        if (font == null) {
            throw new IllegalStateException("Font of this text field should not be null.");
        }
        if (text.equalsIgnoreCase("")) {
            return new Dimension(0, 0);
        }
        FontMetrics fontMetrics = getFontMetrics(font);
        /*
         * BugFix: BUGID UML-8189 Description: In measureSize, the preferred height is calculated as the sum of
         * fontMetric's height and descent as the preferred height. This should only use fontMetric's height.
         * Solution: Use fontMetric's height instead.
         */
        // old code
        // return new Dimension(SwingUtilities.computeStringWidth(fontMetrics, text), fontMetrics.getHeight()
        // + fontMetrics.getDescent());
        String lcOSName = System.getProperty("os.name").toLowerCase();
        boolean MAC_OS_X = lcOSName.startsWith("mac os x");
        if (font.getSize() <= 10 && MAC_OS_X) {
            return new Dimension((int) (SwingUtilities.computeStringWidth(fontMetrics, text) * 1.08), fontMetrics
                .getHeight());
        } else {
            return new Dimension(SwingUtilities.computeStringWidth(fontMetrics, text), fontMetrics
                .getHeight());
        }

    }

    /**
     * <p>
     * Paints this text field.
     * </p>
     *
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
        Graphics2D g2 = (Graphics2D) g;
        // g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Font oldFont = g2.getFont();
        Color oldColor = g2.getColor();
        Font font = getFont();
        g2.setFont(font);
        g2.setColor(fontColor);
        /*
         * BugFix: BUGID UML-8189 Description: In paintComponent, the text string should be drawn at the baseline,
         * so the third argument of drawString should be FontMetrics.getHeight() - FontMetrics.getDescent.
         * Solution: Draw the string at the baseline.
         */
        // old code
        // g.drawString(text, 0, getFontMetrics(font).getHeight());
        g2.drawString(text, 0, getFontMetrics(font).getHeight() - getFontMetrics(font).getDescent());
        g2.setFont(oldFont);
        g2.setColor(oldColor);
    }

    /**
     * <p>
     * Adds <code>TextChangedListener</code> to the listenerList.
     * </p>
     *
     * @param listener
     *            the TextChangedListener to be registered
     */
    public void addTextChangedListener(TextChangedListener listener) {
        listenerList.add(TextChangedListener.class, listener);
    }

    /**
     * <p>
     * Removes an <code>TextChangedListener</code> from listenerList.
     * </p>
     *
     * @param listener
     *            the listener to be removed
     */
    public void removeTextChangedListener(TextChangedListener listener) {
        listenerList.remove(TextChangedListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for TextChangedEvent.
     * </p>
     *
     * @param event
     *            the TextChangedEvent
     */
    protected void fireTextChanged(TextChangedEvent event) {
        if (event != null) {
            TextChangedListener[] listeners = listenerList.getListeners(TextChangedListener.class);
            for (TextChangedListener listener : listeners) {
                listener.textChanged(event);
            }
        }
    }
}
