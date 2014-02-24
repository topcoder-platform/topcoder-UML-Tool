/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.edges.AnchorType;

import com.topcoder.gui.diagramviewer.uml.classedges.event.TextChangeEvent;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextChangeListener;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.ScopeKind;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.FontMetrics;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

/**
 * <p>
 * Text field represents pure text compartment of Edge. It could be used to represent name compartment, stereotype
 * compartment and etc. Text field would be displayed as pure text with font and color inherited form parent edge. There
 * is no decorator around or on the text.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is mutable, and not thread-safe.
 * </p>
 *
 * @author MiG-29, littlebull
 * @version 1.0
 */
public class TextField extends com.topcoder.gui.diagramviewer.edges.TextField {

    /**
     * <p>
     * Represents the text to be displayed on this TextField.
     * </p>
     *
     * <p>
     * It is empty string initially. Can not be null. It can be accessed by setter/getter.
     * </p>
     */
    private String text = "";

    /**
     * <p>
     * Represents the font color value.
     * </p>
     *
     * <p>
     * It will be used to paint text. It will be accessed by setter/getter. Never null.
     * </p>
     */
    private Color fontColor = Color.BLACK;

    /**
     * <p>
     * Construct a <code>TextField</code> with specified <code>GraphNode</code>.
     * The <code>AnchorType</code> is <code>AnchorType.Line</code>.
     * </p>
     *
     * @param graphNode
     *            the graphNode in diagram interchange
     *
     * @throws IllegalArgumentException
     *             if graphNode is null
     */
    public TextField(GraphNode graphNode) {
        this(graphNode, AnchorType.Line);
    }

    /**
     * <p>
     * Construct a <code>TextField</code> with specified <code>GraphNode</code> and <code>AnchorType</code>.
     * </p>
     *
     * @param graphNode
     *            the graphNode in diagram interchange
     * @param anchorType
     *            describes how to anchor the text field.
     *
     * @throws IllegalArgumentException
     *             if any argument is null
     */
    public TextField(GraphNode graphNode, AnchorType anchorType) {
        super(graphNode, "", anchorType);
    }

    /**
     * <p>
     * Getter of text value.
     * </p>
     *
     * @return the text string
     */
    public String getText() {
        return text;
    }

    /**
     * <p>
     * Set new text to be displayed. Null will be converted to empty string.
     * </p>
     *
     * @param text
     *            the new text value
     */
    public void setText(String text) {
        if (text == null) {
            text = "";
        }
        this.text = text;
        repaint();
    }

    /**
     * <p>
     * Getter of fontColor field.
     * </p>
     *
     * @return the font color
     */
    public Color getFontColor() {
        return fontColor;
    }

    /**
     * <p>
     * Setter of fontColor field. Null is allowed to use default color(Black).
     * </p>
     *
     * @param color
     *            the new font color
     */
    public void setFontColor(Color color) {
        if (color == null) {
            color = Color.BLACK;
        }
        this.fontColor = color;
    }

    /**
     * <p>
     * Add a <code>TextChangeListener</code> to <code>listenerList</code>.
     * </p>
     *
     * @param listener
     *            the TextChangeListener to be registered (ignore null)
     */
    public void addTextChangeListener(TextChangeListener listener) {
        listenerList.add(TextChangeListener.class, listener);
    }

    /**
     * <p>
     * Remove a <code>TextChangeListener</code> from <code>listenerList</code>.
     * </p>
     *
     * @param listener
     *            the listener to be removed (ignore null)
     */
    public void removeTextChangeListener(TextChangeListener listener) {
        listenerList.remove(TextChangeListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for <code>TextChangeEvent</code>.
     * </p>
     *
     * @param event
     *            the TextChangeEvent (ignore null)
     */
    protected void fireTextChange(TextChangeEvent event) {
        if (event == null) {
            return;
        }

        for (TextChangeListener listener : listenerList.getListeners(TextChangeListener.class)) {
            listener.textChange(event);
        }
    }

    /**
     * <p>
     * Notify the text is going to be changed.
     * </p>
     *
     * <p>
     * This method doensn't change <code>this.text</code> actually. Application should register a
     * <code>TextChangeListener</code> to listen event, and do the actual change.
     * </p>
     *
     * @param newText
     *            the new text, null is treated as empty string
     *
     * @throws IllegalArgumentException
     *             if newText is null (empty string is allowed)
     */
    public void notifyTextChange(String newText) {
        Utils.checkObjectNotNull(newText, "newText");

        TextChangeEvent event = new TextChangeEvent(this, text, newText);
        fireTextChange(event);
    }

    /**
     * <p>
     * Measure the text size according to font.
     * </p>
     *
     * @return the size of text in current environment
     *
     * @param text
     *            the text to be measured
     *
     * @throws IllegalArgumentException
     *             if given text is null (empty string is allowed)
     */
    public Dimension measureSize(String text) {
        Utils.checkObjectNotNull(text, "text");

        // old code
//        FontMetrics fontMetrics = getFontMetrics(getParent().getFont());
        Font font = getParent().getFont();
        if (font == null) {
            font = getFont();
        }
        FontMetrics fontMetrics = getFontMetrics(font);

        return new Dimension(fontMetrics.stringWidth(text), fontMetrics.getHeight());
    }

    /**
     * <p>
     * Get preferred size of current compartment.
     * </p>
     *
     * @return the preferred size
     */
    public Dimension getPreferredSize() {
        return measureSize(text);
    }

    /**
     * <p>
     * Paint component.
     * </p>
     *
     * @param g
     *            the graphics to paint on (null will be ignored)
     */
    protected void paintComponent(Graphics g) {
        //Return directly is not visible
        if (g == null || !isVisible()) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g;

        //back up the old color and font
        Color oldColor = g2.getColor();
        Font oldFont = g2.getFont();

        //set the font properties
        g2.setFont(getParent().getFont());
        g2.setColor(fontColor);

        //draw the text
      if (text.length() != 0 && isStaticAssociationEndText()) {
          AttributedString as = new AttributedString(text);
          as.addAttribute(TextAttribute.FONT, g.getFont());
          as.addAttribute(TextAttribute.UNDERLINE,
              TextAttribute.UNDERLINE_ON);
          g.drawString(as.getIterator(), 0, g2.getFontMetrics().getAscent());
      } else {
          g2.drawString(text, 0, g2.getFontMetrics().getAscent());
      }

        //set back the old color and font
        g2.setColor(oldColor);
        g2.setFont(oldFont);
    }

    /**
     * <p>
     * Checks whether the text field is for a static association end.
     * </p>
     *
     * @return true if the text is for for a static association end, false otherwise
     */
    private boolean isStaticAssociationEndText() {
        GraphElement graphElement = getGraphNode().getContainer();
        SemanticModelBridge semanticModel = graphElement.getSemanticModel();
        if (semanticModel instanceof Uml1SemanticModelBridge) {
            Element element = ((Uml1SemanticModelBridge) semanticModel).getElement();
            if (element instanceof AssociationEnd) {
                AssociationEnd associationEnd = (AssociationEnd) element;
                if (associationEnd.getTargetKind() == ScopeKind.CLASSIFIER) {
                    return true;
                }
            }
        }
        return false;
    }

}
