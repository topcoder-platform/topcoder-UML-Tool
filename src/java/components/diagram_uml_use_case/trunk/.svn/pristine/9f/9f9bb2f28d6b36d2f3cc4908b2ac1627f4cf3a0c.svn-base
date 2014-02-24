/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.TextChangeEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.TextChangeListener;

/**
 * <p>
 * Text field represents pure text compartment of Node or Edge. It could be used to represent name compartment,
 * stereotype compartment and etc. Text field would be displayed as pure text with font and color inherited form parent
 * node or edge. There is no decorator around or on the text.
 * </p>
 * <p>
 * It extends from com.topcoder.gui.diagramviewer.edges.TextField to allow to be added to Edge. After the Diagram Edges
 * component is finally released, the methods and attributes already defined in base class should be removed in this
 * class.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable, and not thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class TextField extends com.topcoder.gui.diagramviewer.edges.TextField {
    /**
     * <p>
     * The GraphNode which represents this compartment in diagram interchange. Initialized in constructor, never changed
     * later. Can't be null.
     * </p>
     */
    private final GraphNode graphNode;

    /**
     * <p>
     * Represents the text to be displayed on this TextField. It is empty string initially.
     * </p>
     * <p>
     * It can be accessed by setter/getter.
     * </p>
     */
    private String text = "";

    /**
     * <p>
     * List of linebreaks for the text. This allows the TextField to display multiply lines of text.
     * Used by the UseCaseNode.
     * </p>
     * <p>
     * Can be accessed by setter/getter.
     * Never null
     * </p>
     */
    private List<Integer> lineBreaks = new ArrayList<Integer>();


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
     * Construct an instance of TextField using the passed <code>graphNode</code>.
     * </p>
     *
     * @param graphNode the graphNode in diagram interchange
     * @throws IllegalArgumentException if <code>graphNode</code> is null.
     */
    public TextField(GraphNode graphNode) {
        this(graphNode, AnchorType.Line);
    }

    /**
     * <p>
     * Construct an instance of TextField using the passed <code>graphNode</code> and <code>anchorType</code>.
     * </p>
     *
     * @param graphNode the graphNode in diagram interchange
     * @param anchorType the anchorType to be used
     * @throws IllegalArgumentException if <code>graphNode</code> is null.
     */
    public TextField(GraphNode graphNode, AnchorType anchorType) {
        super(graphNode, "", anchorType);
        this.graphNode = graphNode;
        this.setOpaque(false);
    }

    /**
     * <p>
     * Getter of graphNode field. See field document for explanation.
     * </p>
     *
     * @return the graphNode field value.
     */
    public GraphNode getGraphNode() {
        return graphNode;
    }



    /**
     * <p>
     * Getter of lineBreaks value.
     * </p>
     *
     * @return the lineBreaks List
     */
    public List getLineBreaks() {
        return lineBreaks;
    }


    /**
     * <p>
     * Setter of lineBreaks value. Null will be converted to empty list.
     * </p>
     *
     * @param lineBreaks the new lineBreaks value.
     */
    public void setLineBreaks(List<Integer> lineBreaks) {
        if (lineBreaks == null) {
	    this.lineBreaks = new ArrayList<Integer>();
	} else {
	    this.lineBreaks = lineBreaks;
	}
	
    }

    /**
     * <p>
     * Getter of text value.
     * </p>
     *
     * @return the text value
     */
    public String getText() {
        return text;
    }



    /**
     * <p>
     * Set new text to be displayed. Null will be converted to empty string.
     * </p>
     *
     * @param text the new text value.
     */
    public void setText(String text) {
        if (text != null) {
            this.text = text;
        } else {
            this.text = "";
        }
        repaint();
    }

    /**
     * <p>
     * Getter of fontColor field. See field document for explanation.
     * </p>
     *
     * @return this.fontColor.
     */
    public Color getFontColor() {
        return fontColor;
    }

    /**
     * <p>
     * Setter of fontColor field. Null is allowed to use default color(Black).
     * </p>
     *
     * @param color the new font color.
     */
    public void setFontColor(Color color) {
        if (color != null) {
            this.fontColor = color;
        } else {
            this.fontColor = Color.BLACK;
        }
    }

    /**
     * <p>
     * Notify the text is going to be changed. This method doensn't change this.text actually. Application should
     * register a TextChangeListener to listen event, and do the actual change.
     * </p>
     *
     * @param newText the new text, null is treated as empty string.
     */
    public void notifyTextChange(String newText) {
        TextChangeEvent textChangeEvent = new TextChangeEvent(this, text, newText);
        fireTextChange(textChangeEvent);
    }

    /**
     * <p>
     * Get preferred size of current compartment.
     * </p>
     *
     * @return the preferred size
     */
    public Dimension getPreferredSize() {
	return measureSize(getText());
    }

    /**
     * <p>
     * Measure the text size according to font.
     * </p>
     * <p>
     * Empty string is allowed.
     * </p>
     *
     * @return the size of text in current environment
     * @param text the text to be measured.
     * @throws IllegalArgumentException if given text is null
     */
    public Dimension measureSize(String text) {
        Utils.checkNull(text, "text");

        if (text.equals("")) {
            return new Dimension(0, 0);
        }

        Font font = getParent().getFont();
        FontMetrics fm = getFontMetrics(font);
	// default width of zero.
	int width = 0;
	int height = 0;
	int oldIndex = 0;
	for (Integer index : lineBreaks) {
	    if (index > text.length()) {
		index = text.length();
	    }
	    String txt = text.substring(oldIndex, index);	    
	    txt = txt.trim(); 
	    if (width < fm.stringWidth(txt)) {
		width = fm.stringWidth(txt);
	    }
	    height += fm.getHeight();
	    oldIndex = index;
	}
	// the line of text after the last line break.
	if (oldIndex < text.length()) {
	    height += fm.getHeight();
	}
	if ( width < fm.stringWidth(text.substring(oldIndex, text.length()))) {
	    String tx = text.substring(oldIndex, text.length());
	    tx = tx.trim();
	    width = fm.stringWidth(tx); 

	} 
	
	
        return new Dimension(width, height);
    }

    /**
     * <p>
     * Paint component.
     * </p>
     *
     * @param g the graphics to paint on.(null will be ignored).
     */
    protected void paintComponent(Graphics g) {
        if (g == null || !this.isVisible()) {
            return;
        }
        // backup the color
        Color oldColor = g.getColor();
        // backup the font
        Font oldFont = g.getFont();

        g.setColor(fontColor);
        if (this.getParent() != null) {
            g.setFont(this.getParent().getFont());
        }
        /*
         * UML-7164
         */
        // old code
//        g.drawString(text, 0, g.getFontMetrics().getHeight());
        
	int oldIndex = 0;
	int y = 0;
	for (Integer index : lineBreaks) {	  
	    if (index > text.length()) {
		index = text.length();
	    }
	    String txt = text.substring(oldIndex, index);	    
	    // delete leading and trailing whitespace
	    txt = txt.trim();
	    int yOffset = g.getFontMetrics().getHeight() - g.getFontMetrics().getDescent();	    
	    y += yOffset;
	    g.drawString(txt, 0, y);
	    oldIndex = index;
	}

	// draw the line of text after the last line break.	
	y += g.getFontMetrics().getHeight() - g.getFontMetrics().getDescent();	
	g.drawString(text.substring(oldIndex, text.length()).trim(), 0, y);

        g.setColor(oldColor);
        g.setFont(oldFont);
    }

    /**
     * <p>
     * Add {@link TextChangeListener} to the listenerList.
     * </p>
     *
     * @param listener the TextChangeListener to be registered.
     */
    public void addTextChangeListener(TextChangeListener listener) {
        super.listenerList.add(TextChangeListener.class, listener);
    }

    /**
     * <p>
     * Remove an TextChangeListener from listenerList.
     * </p>
     *
     * @param listener the listener to be removed.
     */
    public void removeTextChangeListener(TextChangeListener listener) {
        super.listenerList.remove(TextChangeListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for TextChangeEvent.
     * </p>
     *
     * @param event the TextChangeEvent
     */
    protected void fireTextChange(TextChangeEvent event) {
        if (event != null) {
            TextChangeListener[] listeners = listenerList.getListeners(TextChangeListener.class);
            for (TextChangeListener listener : listeners) {
                listener.textChange(event);
            }
        }
    }
}
