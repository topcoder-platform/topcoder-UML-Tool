/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.AnchorType;


/**
 * Enhancement:UML 9627
 * Description:SequenceEdge##nameCompartment, stereotypeCompartment, getter and a customized TextField
 * class.Like other components such as Diagram Use Case Elements, Diagram Class Elements, Diagram
 * Activity Elements, there should be two textfield compartments(name and stereotype) for sequence edges,
 * and their corresponding getter methods. To represent these two compartements, a customized
 * TextField class is also required just like other Diagram Elements.
 */
/**
 * <p>
 * This class represents pure text compartment of Node or Edge. It could be used to represent name compartment,
 * stereotype compartment and etc. Text field would be displayed as pure text with font and color inherited form parent
 * node or edge. There is no decorator around or on the text.
 * </p>
 * <p>
 * Thread safety: This class is mutable, and not thread-safe.
 * </p>
 *
 * @author gniuxiao, TCSDEVELOPER
 * @version 1.1
 * @since 1.1
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
     * @param graphNode the GraphNode associated with this text field
     * @throws IllegalArgumentException if the argument is null
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
     * @return the text field value
     */
    public String getText() {
        return text;
    }

    /**
     * <p>
     * Sets the text field.
     * </p>
     * @param text the new text
     */
    public void setText(String text) {
      if (text == null) {
          text = "";
      }
      this.text = text;

      setSize(getPreferredSize());
    }

    /**
     * <p>
     * Gets the fontColor field.
     * </p>
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
     * @param color the new font color
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
     * @param newText the new text, null is treated as empty string.
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
     * @return the size of current text
     */
    public Dimension getPreferredSize() {
        Font font = (getParent() == null) ? new Font("Arial", Font.PLAIN, 10) : getParent().getFont();
        if (font == null) {
            font = new Font("Arial", Font.PLAIN, 10);
        }
        FontMetrics fontMetrics = getFontMetrics(font);

        String lcOSName = System.getProperty("os.name").toLowerCase();
        boolean MAC_OS_X = lcOSName.startsWith("mac os x");
        if (MAC_OS_X) {
            return new Dimension((int) (SwingUtilities.computeStringWidth(fontMetrics, text) * 1.08), fontMetrics.getHeight());
        } else {
            return new Dimension(SwingUtilities.computeStringWidth(fontMetrics, text), fontMetrics.getHeight());
        }

    }

    /**
     * <p>
     * Adds a TextChangeListener to the listenerList.
     * </p>
     * <p>
     * Null will be ignored by EventListener#add().
     * </p>
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
     * @param graphics the graphics context
     */
    protected void paintComponent(Graphics graphics) {
        if (!isVisible()) {
            return;
        }
        Graphics2D g2 = (Graphics2D)graphics;

        Font oldFont = g2.getFont();
        Color color = g2.getColor();
        g2.setFont(getFont());
        g2.setColor(fontColor);

        g2.drawString(text, 0, getFontMetrics(getFont()).getHeight() - getFontMetrics(getFont()).getDescent());
        g2.setFont(oldFont);
        g2.setColor(color);
    }
}
