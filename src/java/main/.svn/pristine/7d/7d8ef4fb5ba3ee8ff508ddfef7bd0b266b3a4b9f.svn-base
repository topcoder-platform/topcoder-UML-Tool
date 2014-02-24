/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;

/**
 * <p>
 * This class is the base class of AttributeAddButton and OperationAddButton.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public abstract class FeatureAddButton extends JButton {

    /**
     * <p>
     * Represents the fill color to paint.
     * </p>
     */
    private Color fillColor;

    /**
     * <p>
     * Creates an instance of FeatureAddButton.
     * </p>
     * @param action
     *            action to add feature
     */
    public FeatureAddButton(FeatureAddAction action) {
        super(action);
        setSize(10, 10);
    }

    /**
     * <p>
     * Sets the fill color.
     * </p>
     * @param color
     *            the fill color to set
     */
    public void setFillColor(Color color) {
        fillColor = color;
    }

    /**
     * <p>
     * Sets the class node for action.
     * </p>
     * @param classNode
     *            the ClassNode which needs feature added
     */
    public void setClassNode(ClassNode classNode) {
        FeatureAddAction action = (FeatureAddAction) getAction();
        action.setClassNode(classNode);
    }

    /**
     * <p>
     * Paints this button.
     * </p>
     * @param g
     *            the graphics
     */
    protected void paintComponent(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(fillColor);
        g.fillRect(0, getHeight() / 2, getWidth(), getHeight() / 2);
        g.setColor(oldColor);
    }
}
