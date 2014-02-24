/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.datatypes.ScopeKind;

/**
 * <p>
 * The modified TextField class with stereotype attribute. The stereotype can be visible or hidden. This class will show
 * the full text with stereotype. But on double click event the only text field (without stereotype) will go to the edit
 * control. So, the TextField.text will contain full string without stereotype. On the double click this string will go
 * to the edit control. But in paintComponent function the concatenated string (stereotype + text) will be shown.
 * </p>
 * <p>
 * This class is mutable, and not thread-safe.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class StereotypeTextField extends TextField {

    /**
     * <p>
     * Represents the margin for displaying text.
     * </p>
     */
    private static int MARGIN = 4;

    /**
     * <p>
     * Represents the stereotype to be displayed together with 'text' variable on this StereotypeTextField. It is empty
     * string initially. The value can't be null.
     * </p>
     * <p>
     * It can be accessed by setter/getter.
     * </p>
     */
    private String stereotype = "";

    /**
     * <p>
     * Represents the visibility flag for 'stereotype' variable. It can be any value and can be accessed through
     * getter/setter methods.
     * </p>
     */
    private boolean isStereotypeVisible = false;

    /**
     * <p>
     * Creates an instance of <code>StereotypeTextField</code>.
     * </p>
     * @param graphNode
     *            the graphNode in diagram interchange
     * @throws IllegalArgumentException
     *             if graphNode is null
     */
    public StereotypeTextField(GraphNode graphNode) {
        this(graphNode, AnchorType.Line);
    }

    /**
     * <p>
     * Creates an instance of <code>StereotypeTextField</code>.
     * </p>
     * @param graphNode
     *            the graphNode in diagram interchange
     * @param anchorType
     *            Describes how to anchor the stereotype text field
     * @throws IllegalArgumentException
     *             if graphNode or anchorType is null
     */
    public StereotypeTextField(GraphNode graphNode, AnchorType anchorType) {
        super(graphNode, anchorType);
        /*
         * BugFix: BUGID UML-8191
         * Description:
         * The constructor should call setOpaque(false), since it is not selected.
         * Solution:
         * Call setOpaque(false).
         */
        setOpaque(false);
    }

    /**
     * <p>
     * Gets preferred size of current compartment.
     * </p>
     * @return the preferred size
     */
    public Dimension getPreferredSize() {
        Dimension preferredSize = null;
        if (isStereotypeVisible) {
            preferredSize = measureSize(getStereotype() + getText());
        } else {
            preferredSize = measureSize(getText());
        }
        preferredSize.width += MARGIN * 2;
        return preferredSize;
    }

    /**
     * <p>
     * Paints this text field.
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
        Font oldFont = g.getFont();
        Color oldColor = g.getColor();
        /*
         * BugFix: BUGID UML-8191
         * Description:
         * In paintComponent, the method should paint the background with background color set, in case it is selected.
         * Solution:
         * Paint the background if this text field is opaque.
         */
        // paint the background
        if (isOpaque()) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        Font font = getFont();
        g.setFont(font);

        GraphNode graphNode = getGraphNode();
        ModelElement modelElement = Util.getElement(graphNode);
        if (modelElement instanceof Operation) {
            Operation operation = (Operation) modelElement;
            if (operation.isAbstract()) {
                g.setFont(new Font(font.getName(), Font.ITALIC, font.getSize()));
            }
        }

        Color fontColor = getFontColor();
        if (fontColor == null) {
            GroupTextField grouptTextField = (GroupTextField) getParent();
            fontColor = grouptTextField.getFontColor();
        }
        g.setColor(fontColor);

        String text = getText();
        if (isStereotypeVisible) {
            text = stereotype + text;
        }
        /*
         * BugFix: BUGID UML-8191
         * Description:
         * In paintComponent, the text string should be drawn at the baseline, so the third argument of drawString
         * should be FontMetrics.getHeight() - FontMetrics.getDescent().
         * Solution:
         * Draw the string at the baseline.
         */
        // old code
//        g.drawString(text, 0, getFontMetrics(font).getHeight());
        if (modelElement instanceof Feature && ((Feature) modelElement).getOwnerScope() == ScopeKind.CLASSIFIER) {
            AttributedString as = new AttributedString(text);
            as.addAttribute(TextAttribute.FONT, g.getFont());
            as.addAttribute(TextAttribute.UNDERLINE,
                TextAttribute.UNDERLINE_ON);
            g.drawString(as.getIterator(), MARGIN, getFontMetrics(font).getHeight() - getFontMetrics(font).getDescent());

        } else  {
            g.drawString(text, MARGIN, getFontMetrics(font).getHeight() - getFontMetrics(font).getDescent());
        }
        g.setFont(oldFont);
        g.setColor(oldColor);
    }

    /**
     * <p>
     * Gets the stereotype value.
     * </p>
     * @return the stereotype string
     */
    public String getStereotype() {
        return stereotype;
    }

    /**
     * <p>
     * Sets new stereotype to be displayed. Null will be converted to empty string.
     * </p>
     * @param stereotype
     *            the new stereotype value
     */
    public void setStereotype(String stereotype) {
        if (stereotype == null) {
            stereotype = "";
        }
        this.stereotype = stereotype;
    }

    /**
     * <p>
     * Gets the isStereotypeVisible flag.
     * </p>
     * @return The isStereotypeVisible value
     */
    public boolean isStereotypeVisible() {
        return isStereotypeVisible;
    }

    /**
     * <p>
     * Sets the isStereotypeVisible flag.
     * </p>
     * @param isStereotypeVisible
     *            the new isStereotypeVisible value
     */
    public void stereotypeVisible(boolean isStereotypeVisible) {
        this.isStereotypeVisible = isStereotypeVisible;
    }
}
