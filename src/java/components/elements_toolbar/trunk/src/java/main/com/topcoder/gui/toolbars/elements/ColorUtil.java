/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements;

import java.awt.Color;

/**
 * Class utility for color conversion.
 *
 * @author enefem21
 * @version 1.0
 */
class ColorUtil {

    /**
     * Private constructor to avoid an instantiation of this utility class.
     */
    private ColorUtil() {
        // do nothing
    }

    /**
     * Returns color from a string. Several colors are supported, those are white, lightgray, gray, darkgray,
     * black, red, pink, orange, yellow, green, magenta, cyan and blue. A string with #RRGGBB is also supported.
     *
     * @param colorString
     *            the color in string
     *
     * @return the color
     */
    static Color getColor(String colorString) {
        if (ArgumentCheckUtil.isNullOrEmptyString(colorString)) {
            return Color.LIGHT_GRAY;
        } else if (colorString.toLowerCase().equals("white")) {
            return Color.WHITE;
        } else if (colorString.toLowerCase().equals("lightgray")) {
            return Color.LIGHT_GRAY;
        } else if (colorString.toLowerCase().equals("gray")) {
            return Color.GRAY;
        } else if (colorString.toLowerCase().equals("darkgray")) {
            return Color.DARK_GRAY;
        } else if (colorString.toLowerCase().equals("black")) {
            return Color.BLACK;
        } else if (colorString.toLowerCase().equals("red")) {
            return Color.RED;
        } else if (colorString.toLowerCase().equals("pink")) {
            return Color.PINK;
        } else if (colorString.toLowerCase().equals("orange")) {
            return Color.ORANGE;
        } else if (colorString.toLowerCase().equals("yellow")) {
            return Color.YELLOW;
        } else if (colorString.toLowerCase().equals("green")) {
            return Color.GREEN;
        } else if (colorString.toLowerCase().equals("magenta")) {
            return Color.MAGENTA;
        } else if (colorString.toLowerCase().equals("cyan")) {
            return Color.CYAN;
        } else if (colorString.toLowerCase().equals("blue")) {
            return Color.BLUE;
        } else if (colorString.toLowerCase().equals("light_gray")) {
            return Color.LIGHT_GRAY;
        } else if (colorString.toLowerCase().equals("dark_gray")) {
            return Color.DARK_GRAY;
        } else if (colorString.startsWith("#") && colorString.length() == 7) {
            // for #RRGGBB format
            try {
                return new Color(Integer.parseInt(colorString.substring(1, 3), 16), Integer.parseInt(colorString
                    .substring(3, 5), 16), Integer.parseInt(colorString.substring(5), 16));
            } catch (NumberFormatException e) {
                return Color.LIGHT_GRAY;
            }
        } else {
            return Color.LIGHT_GRAY;
        }
    }
}
