/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * DefaultHTMLDocumentationEditorToolBar.java
 */
package com.topcoder.gui.panels.documentation.plugins.html.toolbars;

import com.topcoder.configuration.ConfigurationAccessException;
import com.topcoder.configuration.ConfigurationObject;

import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditorException;
import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditor;
import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditorToolBar;

import java.awt.Color;
import java.awt.GraphicsEnvironment;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.text.StyledEditorKit;


/**
 * <p>
 * This is the default tool bar used by the editor. It inherits from the
 * <code>HTMLDocumentationEditorToolBar</code>. Besides the basic commands from the super class, it also contains the
 * commands to select font name, font size, and font color for texts.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class is not thread safe since the super class is not thread safe.
 * </p>
 *
 * @author morehappiness, TCSDEVELOPER
 * @version 1.0
 */
@SuppressWarnings("serial")
public class DefaultHTMLDocumentationEditorToolBar extends HTMLDocumentationEditorToolBar {
    /**
     * <p>Constant for content font size length.</p>
     */
    private static final int FONT_SIZE_LENGTH = 3;

    /**
     * <p>Construct the tool bar. It will add font name, font size, and color choose to the tool bar.</p>
     *
     * @param config the configuration object for the constructor, can not be null.
     * @param editor the editor which the tool bar belongs to
     *
     * @throws IllegalArgumentException if configuration or editor is null
     * @throws HTMLDocumentationEditorException
     *     if there are problems reading configuration or the configuration has invalid properties
     */
    public DefaultHTMLDocumentationEditorToolBar(ConfigurationObject config, HTMLDocumentationEditor editor)
        throws HTMLDocumentationEditorException {
        super(config, editor);

        //create menu bar
        JMenuBar menuBar = new JMenuBar();

        //create font name menu
        JMenu fontNameMenu = new JMenu("Font Name");

        //get system font family list
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        //Add the font names to font name menu
        if (fontNames != null) {
            //for each fontName in fontNames
            for (String fontName : fontNames) {
                //create menu item
                JMenuItem fontNameItem = new JMenuItem(fontName);

                //set action for it
                fontNameItem.setAction(new StyledEditorKit.FontFamilyAction(String.valueOf(fontName), fontName));

                //add it to font name menu
                fontNameMenu.add(fontNameItem);
            }
        }

        //Add font name menu to menu bar
        menuBar.add(fontNameMenu);

        //create font size menu
        JMenu fontSizeMenu = new JMenu("Font Size");

        //get font size configuration from configuration file
        //make font size array by the fontSizeConfig
        int[] fontSizes = getFontSizes(config);

        //Add the font sizes to font size menu
        //for each fontSize in fontSizes
        if (fontSizes[0] < fontSizes[1]) {
            for (int i = fontSizes[0]; i <= fontSizes[1]; i = i + fontSizes[2]) {
                addFontSizeItem(i, fontSizeMenu);
            }
        } else if (fontSizes[0] > fontSizes[1]) {
            for (int i = fontSizes[0]; i >= fontSizes[1]; i = i + fontSizes[2]) {
                addFontSizeItem(i, fontSizeMenu);
            }
        }

        //Add font size menu to menu bar
        menuBar.add(fontSizeMenu);

        //create foreground color menu
        JMenu colorMenu = new JMenu("Choose Color");

        //create color menu items from the static fields of Color, and add them to colorMenu.
        Color[] colors = new Color[]{Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
            Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
            Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};

        for (Color color : colors) {
            addColorItems(color, colorMenu);
        }

        //add color menu to menu bar
        menuBar.add(colorMenu);

        //add the menu bar to tool bar
        add(menuBar);
    }

    /**
     * <p>Add font size item to size menu.</p>
     *
     * @param fontSize the font size
     * @param fontSizeMenu the size menu
     */
    private void addFontSizeItem(int fontSize, JMenu fontSizeMenu) {
        //create menu item
        JMenuItem fontSizeItem = new JMenuItem(String.valueOf(fontSize));

        //set action for it
        fontSizeItem.setAction(new StyledEditorKit.FontSizeAction(String.valueOf(fontSize), fontSize));

        //add it to font size menu
        fontSizeMenu.add(fontSizeItem);
    }

    /**
     * <p>Add color item to color menu.</p>
     *
     * @param color the color
     * @param colorMenu the color menu
     */
    private void addColorItems(Color color, JMenu colorMenu) {
        //create color menu item
        JMenuItem colorItem = new JMenuItem(new StyledEditorKit.ForegroundAction(color.toString(), color));

        //add color menu item
        colorMenu.add(colorItem);
    }

    /**
     * <p>Get font sizes.</p>
     *
     * @param config the configuration object
     *
     * @return font sizes array
     *
     * @throws HTMLDocumentationEditorException if there are problems reading configuration or the configuration has
     *         invalid properties
     */
    private int[] getFontSizes(ConfigurationObject config)
        throws HTMLDocumentationEditorException {
        int[] fontSizes = new int[FONT_SIZE_LENGTH];

        try {
            Object[] fontSizeConfig = config.getPropertyValues("fontSizeConfig");

            if ((fontSizeConfig == null) || (fontSizeConfig.length != FONT_SIZE_LENGTH)) {
                throw new HTMLDocumentationEditorException("Field 'fontSizeConfig' value is invalid.");
            }

            for (int i = 0; i < fontSizes.length; i++) {
                if (fontSizeConfig[i] == null) {
                    throw new HTMLDocumentationEditorException("Field 'fontSizeConfig' value is missing.");
                }

                try {
                    fontSizes[i] = Integer.valueOf(fontSizeConfig[i].toString().trim());
                } catch (NumberFormatException e) {
                    throw new HTMLDocumentationEditorException("Field 'fontSizeConfig' value is not an integer.");
                }
            }

            if ((fontSizes[0] < 0 || fontSizes[1] < 0  || fontSizes[2] == 0)
                || (fontSizes[0] < fontSizes[1] && fontSizes[2] < 0)
                || (fontSizes[0] > fontSizes[1] && fontSizes[2] > 0)) {
                throw new HTMLDocumentationEditorException("Field 'fontSizeConfig' value is invalid.");
            }
        } catch (ConfigurationAccessException e) {
            throw new HTMLDocumentationEditorException("Error occurs while accessing configuration.", e);
        }

        return fontSizes;
    }
}
