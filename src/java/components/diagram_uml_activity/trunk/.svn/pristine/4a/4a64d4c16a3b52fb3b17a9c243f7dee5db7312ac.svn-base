/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedListener;

/**
 * <p>
 * This class represents pure text compartment of Node or Edge. It could be used to represent name compartment,
 * stereotype compartment and etc. Text field would be displayed as pure text with font and color inherited form
 * parent node or edge. There is no decorator around or on the text.
 * </p>
 * <p>
 * Thread safety: This class is mutable, and not thread-safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class TextField extends com.topcoder.gui.diagramviewer.edges.TextField {
    /**
     * <p>
     * Represents the text to be displayed on this TextField.
     * </p>
     * <p>
     * Initialized as a empty string, can not be null.
     * </p>
     */
    private String text;

    /**
     * <p>
     * Represents the font color value.
     * </p>
     * <p>
     * Initialized as Color.black, can not be null.
     * </p>
     */
    private Color fontColor;

    /**
     * <p>
     * Creates an instance of <code>TextField</code>.
     * </p>
     *
     * @param graphNode
     *            the GraphNode associated with this text field
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    public TextField(GraphNode graphNode) {
        super(graphNode, "", AnchorType.Line);
        text = "";
        fontColor = Color.BLACK;
        this.setOpaque(false);
    }

    /**
     * <p>
     * Gets the text value.
     * </p>
     *
     * @return the text field value
     */
    public String getText() {
        return text;
    }

    /**
     * <p>
     * Sets the text field.
     * </p>
     *
     * @param text
     *            the new text, null is treated as empty string
     */
    public void setText(String text) {
        /*
         * BugFix: UML-10105 Null should be treated as empty string.
         */
        // old code
        // Util.checkNotNull(text, "text");
        // this.text = text;
        if (text != null) {
            this.text = text;
        } else {
            this.text = "";
        }
    }

    /**
     * <p>
     * Gets the fontColor field.
     * </p>
     *
     * @return the font color field
     */
    public Color getFontColor() {
        return fontColor;
    }

    /**
     * <p>
     * Sets the fontColor field.
     * </p>
     * <p>
     * Null is allowed to use default color (black).
     * </p>
     *
     * @param color
     *            the new font color
     */
    public void setFontColor(Color color) {
        if (color == null) {
            color = Color.BLACK;
        }
        fontColor = color;
    }

    /**
     * <p>
     * Notifies the text is going to be changed. This method doesn't change this.text actually, application should
     * register a TextChangeListener to listen event, and do the actual change.
     * </p>
     * <p>
     * Null argument is allowed to be treat as an empty string.
     * </p>
     *
     * @param newText
     *            the new text, null is treated as empty string.
     */
    public void notifyTextChange(String newText) {
        if (newText == null) {
            newText = "";
        }
        TextChangedEvent textChangedEvent = new TextChangedEvent(this, text, newText);
        fireTextChange(textChangedEvent);
    }

    /**
     * <p>
     * Measures the text size according to font.
     * </p>
     *
     * @return the size of current text
     */
    public Dimension getPreferredSize() {
        if (text.equals("")) {
            return new Dimension(0, 0);
        }

        Font font = (getParent() == null) ? new Font("Arial", Font.PLAIN, 10) : getParent().getFont();
        FontMetrics fontMetrics = getFontMetrics(font);
        /*
         * BugFix: BUGID UML-7181 Description: This method uses the sum of fontMetrics's height, ascent and descent
         * as the preferred height. It should only use fontMetric's height instead. Solution: Code is modified to
         * only use fontMetric's height instead.
         */
        // old code
        // return new Dimension(SwingUtilities.computeStringWidth(fontMetrics, text), fontMetrics.getHeight()
        // + fontMetrics.getAscent() + fontMetrics.getDescent());
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
     * Adds a TextChangeListener to the listenerList.
     * </p>
     * <p>
     * Null will be ignored by EventListener#add().
     * </p>
     *
     * @param listener
     *            the TextChangeListener to be registered.
     */
    public void addTextChangedListener(TextChangedListener listener) {
        listenerList.add(TextChangedListener.class, listener);
    }

    /**
     * <p>
     * Removes a TextChangeListener from listenerList.
     * </p>
     * <p>
     * Null will be ignored by EventListener#remove().
     * </p>
     *
     * @param listener
     *            the listener to be removed.
     */
    public void removeTextChangedListener(TextChangedListener listener) {
        listenerList.remove(TextChangedListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for TextChangeEvent.
     * </p>
     * <p>
     * Null parameter will be ignored.
     * </p>
     *
     * @param event
     *            the TextChangeEvent
     */
    protected void fireTextChange(TextChangedEvent event) {
        for (TextChangedListener listener : listenerList.getListeners(TextChangedListener.class)) {
            listener.textChanged(event);
        }
    }

    /**
     * <p>
     * Paints the text without any border.
     * </p>
     *
     * @param graphics
     *            the graphics context
     */
    protected void paintComponent(Graphics graphics) {
        if (!isVisible()) {
            return;
        }

        Graphics2D g2 = (Graphics2D) graphics;
        // g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Font oldFont = g2.getFont();
        Color color = g2.getColor();
        g2.setFont(getFont());
        g2.setColor(fontColor);
        /*
         * BugFix: BUGID UML-7182 Description: The text string should be drawn at the baseline, so the third
         * argument of drawString should be FontMetrics.getHeight()-FontMetrics.getDescent(). Solution: Code is
         * modified to show draw the string at the baseline.
         */
        // old code
        // graphics.drawString(text, 0, getFontMetrics(getFont()).getHeight());
        g2.drawString(text, 0, getFontMetrics(getFont()).getHeight() - getFontMetrics(getFont()).getDescent());
        g2.setFont(oldFont);
        g2.setColor(color);
    }
}
