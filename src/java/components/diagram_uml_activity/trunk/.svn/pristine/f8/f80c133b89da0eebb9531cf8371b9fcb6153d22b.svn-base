/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.accuracytests;

import java.awt.Color;
import java.awt.Font;

import com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.ForkNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.JoinNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.TextField;

/**
 * The helper for accuracy tests.
 * 
 * @author kinfkong
 * @version 1.0
 */
public class TestHelper {

    /**
     * Represents the stroke color.
     */
    public static final String COLOR1 = "StrokeColor";

    /**
     * Represents the default stroke color.
     */
    public static final Color COLOR2 = Color.BLACK;

    /**
     * Represents fill color.
     */
    public static final String COLOR3 = "FillColor";

    /**
     * Represents default fill color.
     */
    public static final Color COLOR4 = Color.BLACK;

    /**
     * Represents the font color.
     */
    public static final String COLOR5 = "FontColor";

    /**
     * Represents the default font color.
     */
    public static final Color COLOR6 = Color.BLACK;

    /**
     * Represents the gradient color.
     */
    public static final String COLOR7 = "GradientColor";


    /**
     * Represents the default gradient color.
     */
    public static final Color COLOR8 = Color.BLUE;

    /**
     * Represents the shadow color.
     */
    public static final String COLOR9 = "ShadowColor";


    /**
     * Represents the gap between the lengths.
     */
    public static int diff = 5;


    /**
     * Represents the default shadow color.
     */
    public static final Color COLOR10 = Color.GRAY;


    /**
     * Represents the font size.
     */
    public static final String FONT_SIZE = "FontSize";

    /**
     * Represents the image file.
     */
    public static final String IMAGE_FILE = "ImageFile";

    /**
     * Represents the default image file.
     */
    public static final String DEFAULT_IMAGE_FILE = "";

    /**
     * Represents the font family.
     */
    public static final String FONT_FAMILY = "FontFamily";

    /**
     * Represents the default font family.
     */
    public static final String DEFAULT_FONT_FAMILY = "Arial";

    /**
     * Represents the font style.
     */
    public static final String FONT_STYLE = "FontStyle";

    /**
     * Represents the default font style.
     */
    public static final int DEFAULT_FONT_STYLE = Font.PLAIN;

    /**
     * Represents the method getting the heigh of the node.
     * 
     * @param node the node
     * 
     * @return the height
     */
    public static double getHeight(BaseNode node) {

        
        double minimumHeight = node.getMinimumSize().getHeight();
        
        if (node.getGraphNode().getSize() == null) {
            return minimumHeight;
        }
        double height = node.getGraphNode().getSize().getHeight();

        if ((node instanceof ForkNode) || (node instanceof JoinNode)) {

            return minimumHeight;
        }
        return ((height < minimumHeight) ? minimumHeight : height);

    }
    
    /**
     * Gets the width of the node.
     * 
     * @param node the node
     * 
     * @return the width
     */
    public static double getWidth(BaseNode node) {

        double minimumWidth = node.getMinimumSize().getWidth();
        if (node.getGraphNode().getSize() == null) {
            return minimumWidth;
        }
        double width = node.getGraphNode().getSize().getWidth();
        return ((width < minimumWidth) ? minimumWidth : width);
    }

    /**
     * Gets the preferred width.
     * 
     * @param radius the radius
     * @param width the width
     * @param stereo the stereo
     * @param name the name
     * 
     * @return the preferred width
     */
    public static int getPreferredWidth(int radius, int width, TextField stereo, TextField name) {

        int stereoWidth = (stereo.getPreferredSize().width + (2 * diff));
        int nameWidth = (name.getPreferredSize().width + (2 * diff));

        // assuming width is greatest width
        int preferredWidth = (width + (2 * radius));

        preferredWidth = (stereoWidth > preferredWidth) ? stereoWidth : preferredWidth;

        if (name.getText().trim().length() > 0) {

            preferredWidth = (nameWidth > preferredWidth) ? nameWidth : preferredWidth;
        }
        return preferredWidth;
    }

    /**
     * Gets the preferred height.
     * 
     * @param radius the radius
     * @param height the height
     * @param stereo the stereo
     * @param name the name
     * @return the preferred height
     */
    public static int getPreferredHeight(int radius, int height, TextField stereo, TextField name) {

        int stereoHeight = (stereo.getPreferredSize().height + diff);
        int nameHeight = (name.getPreferredSize().height + diff);

        int preferredHeight = height + (2 * radius) + stereoHeight;

        preferredHeight = (name.getText().trim().length() > 0) ? (preferredHeight + nameHeight) : preferredHeight;

        return preferredHeight;
    }

    /**
     * Gets the preferred action width.
     * 
     * @param radius the radius
     * @param width the width
     * @param stereo the stereo
     * @param name the name
     * 
     * @return the preferred width
     */
    public static int getPreferredActionWidth(int radius, int width, TextField stereo, TextField name) {

        int stereoWidth = stereo.getPreferredSize().width;
        int nameWidth = name.getPreferredSize().width;

        int preferredWidth = width + (2 * radius);

        if (stereo.getGraphNode().isVisible()) {

            preferredWidth = (stereoWidth > preferredWidth) ? (stereoWidth + (2 * radius)) : preferredWidth;
        }
        if (name.getText().trim().length() > 0) {

            preferredWidth = (nameWidth > preferredWidth) ? (nameWidth + (2 * radius)) : preferredWidth;
        }
        if ((stereo.getGraphNode().isVisible()) || (name.getText().trim().length() > 0)) {
            preferredWidth += (2 * diff);
        }
        return preferredWidth;
    }

    /**
     * Gets the preferred action height
     * 
     * @param radius the radius
     * @param height the height
     * @param stereo the stereo
     * @param name the name
     * 
     * @return the prefeered action height
     */
    public static int getPreferredActionHeight(int radius, int height, TextField stereo, TextField name) {

        int stereoHeight = stereo.getPreferredSize().height;
        int nameHeight = name.getPreferredSize().height;

        int preferredHeight = height + (2 * radius);

        preferredHeight = (stereo.getGraphNode().isVisible()) ? (preferredHeight + stereoHeight + (2 * diff))
                        : preferredHeight;

        preferredHeight = (name.getText().trim().length() > 0) ? (preferredHeight + nameHeight + (2 * diff))
                        : preferredHeight;

        return preferredHeight;
    }
}