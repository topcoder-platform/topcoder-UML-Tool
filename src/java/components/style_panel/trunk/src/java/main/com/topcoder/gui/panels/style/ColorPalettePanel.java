/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Map;

/**
 * <p>
 * This class extends JPanel.
 * </p>
 *
 * <p>
 * This class is responsible to show the palette in ColorChooserPanel.
 * </p>
 *
 * <p>
 * Every palette is a small box (size is configurable), and every palette contains
 * a color (also configurable).
 * </p>
 *
 * <p>
 * The instance of this class' scope is kept as long as the application is shown.
 * </p>
 *
 * <p>
 * Thread safety: This class extends JPanel and so is not thread safe. But this
 * is not a problem since the class is only running in Event Dispatching Thread.
 * </p>
 *
 * @author enefem21, TCSDEVELOPER
 * @version 1.0
 */
class ColorPalettePanel extends JPanel {
    /**
     * <p>
     * Represents the default colors for the color chooser.
     * </p>
     *
     * <p>
     * The row number is 9 and the column number is 31.
     * </p>
     */
    private static final Color[][] DEFAULT_COLORS = new Color[][] {
    // row 1
        {new Color(255, 255, 255), new Color(204, 255, 255), new Color(204, 204, 255), new Color(204, 204, 255),
            new Color(204, 204, 255), new Color(204, 204, 255), new Color(204, 204, 255), new Color(204, 204, 255),
            new Color(204, 204, 255), new Color(204, 204, 255), new Color(204, 204, 255), new Color(255, 204, 255),
            new Color(255, 204, 204), new Color(255, 204, 204), new Color(255, 204, 204), new Color(255, 204, 204),
            new Color(255, 204, 204), new Color(255, 204, 204), new Color(255, 204, 204), new Color(255, 204, 204),
            new Color(255, 204, 204), new Color(255, 255, 204), new Color(204, 255, 204), new Color(204, 255, 204),
            new Color(204, 255, 204), new Color(204, 255, 204), new Color(204, 255, 204), new Color(204, 255, 204),
            new Color(204, 255, 204), new Color(204, 255, 204), new Color(204, 255, 204)},
        // row 2
        {new Color(204, 204, 204), new Color(153, 255, 255), new Color(153, 204, 255), new Color(153, 153, 255),
            new Color(153, 153, 255), new Color(153, 153, 255), new Color(153, 153, 255), new Color(153, 153, 255),
            new Color(153, 153, 255), new Color(153, 153, 255), new Color(204, 153, 255), new Color(255, 153, 255),
            new Color(255, 153, 204), new Color(255, 153, 153), new Color(255, 153, 153), new Color(255, 153, 153),
            new Color(255, 153, 153), new Color(255, 153, 153), new Color(255, 153, 153), new Color(255, 153, 153),
            new Color(255, 204, 153), new Color(255, 255, 153), new Color(204, 255, 153), new Color(153, 255, 153),
            new Color(153, 255, 153), new Color(153, 255, 153), new Color(153, 255, 153), new Color(153, 255, 153),
            new Color(153, 255, 153), new Color(153, 255, 153), new Color(153, 255, 204)},
        // row 3
        {new Color(204, 204, 204), new Color(102, 255, 255), new Color(102, 204, 255), new Color(102, 153, 255),
            new Color(102, 102, 255), new Color(102, 102, 255), new Color(102, 102, 255), new Color(102, 102, 255),
            new Color(102, 102, 255), new Color(153, 102, 255), new Color(204, 102, 255), new Color(255, 102, 255),
            new Color(255, 102, 204), new Color(255, 102, 153), new Color(255, 102, 102), new Color(255, 102, 102),
            new Color(255, 102, 102), new Color(255, 102, 102), new Color(255, 102, 102), new Color(255, 153, 102),
            new Color(255, 204, 102), new Color(255, 255, 102), new Color(204, 255, 102), new Color(153, 255, 102),
            new Color(102, 255, 102), new Color(102, 255, 102), new Color(102, 255, 102), new Color(102, 255, 102),
            new Color(102, 255, 102), new Color(102, 255, 153), new Color(102, 255, 204)},
        // row 4
        {new Color(153, 153, 153), new Color(51, 255, 255), new Color(51, 204, 255), new Color(51, 153, 255),
            new Color(51, 102, 255), new Color(51, 51, 255), new Color(51, 51, 255), new Color(51, 51, 255),
            new Color(102, 51, 255), new Color(153, 51, 255), new Color(204, 51, 255), new Color(255, 51, 255),
            new Color(255, 51, 204), new Color(255, 51, 153), new Color(255, 51, 102), new Color(255, 51, 51),
            new Color(255, 51, 51), new Color(255, 51, 51), new Color(255, 102, 51), new Color(255, 153, 51),
            new Color(255, 204, 51), new Color(255, 255, 51), new Color(204, 255, 51), new Color(153, 244, 51),
            new Color(102, 255, 51), new Color(51, 255, 51), new Color(51, 255, 51), new Color(51, 255, 51),
            new Color(51, 255, 102), new Color(51, 255, 153), new Color(51, 255, 204)},
        // row 5
        {new Color(153, 153, 153), new Color(0, 255, 255), new Color(0, 204, 255), new Color(0, 153, 255),
            new Color(0, 102, 255), new Color(0, 51, 255), new Color(0, 0, 255), new Color(51, 0, 255),
            new Color(102, 0, 255), new Color(153, 0, 255), new Color(204, 0, 255), new Color(255, 0, 255),
            new Color(255, 0, 204), new Color(255, 0, 153), new Color(255, 0, 102), new Color(255, 0, 51),
            new Color(255, 0, 0), new Color(255, 51, 0), new Color(255, 102, 0), new Color(255, 153, 0),
            new Color(255, 204, 0), new Color(255, 255, 0), new Color(204, 255, 0), new Color(153, 255, 0),
            new Color(102, 255, 0), new Color(51, 255, 0), new Color(0, 255, 0), new Color(0, 255, 51),
            new Color(0, 255, 102), new Color(0, 255, 153), new Color(0, 255, 204)},
        // row 6
        {new Color(102, 102, 102), new Color(0, 204, 204), new Color(0, 204, 204), new Color(0, 153, 204),
            new Color(0, 102, 204), new Color(0, 51, 204), new Color(0, 0, 204), new Color(51, 0, 204),
            new Color(102, 0, 204), new Color(153, 0, 204), new Color(204, 0, 204), new Color(204, 0, 204),
            new Color(204, 0, 204), new Color(204, 0, 153), new Color(204, 0, 102), new Color(204, 0, 51),
            new Color(204, 0, 0), new Color(204, 51, 0), new Color(204, 102, 0), new Color(204, 153, 0),
            new Color(204, 204, 0), new Color(204, 204, 0), new Color(204, 204, 0), new Color(153, 204, 0),
            new Color(102, 204, 0), new Color(51, 204, 0), new Color(0, 204, 0), new Color(0, 204, 51),
            new Color(0, 204, 102), new Color(0, 204, 153), new Color(0, 204, 204)},
        // row 7
        {new Color(102, 102, 102), new Color(0, 153, 153), new Color(0, 153, 153), new Color(0, 153, 153),
            new Color(0, 102, 153), new Color(0, 51, 153), new Color(0, 0, 153), new Color(51, 0, 153),
            new Color(102, 0, 153), new Color(153, 0, 153), new Color(153, 0, 153), new Color(153, 0, 153),
            new Color(153, 0, 153), new Color(153, 0, 153), new Color(153, 0, 102), new Color(153, 0, 51),
            new Color(153, 0, 0), new Color(153, 51, 0), new Color(153, 102, 0), new Color(153, 153, 0),
            new Color(153, 153, 0), new Color(153, 153, 0), new Color(153, 153, 0), new Color(153, 153, 0),
            new Color(102, 153, 0), new Color(51, 153, 0), new Color(0, 153, 0), new Color(0, 153, 51),
            new Color(0, 153, 102), new Color(0, 153, 153), new Color(0, 153, 153)},
        // row 8
        {new Color(51, 51, 51), new Color(0, 102, 102), new Color(0, 102, 102), new Color(0, 102, 102),
            new Color(0, 102, 102), new Color(0, 51, 102), new Color(0, 0, 102), new Color(51, 0, 102),
            new Color(102, 0, 102), new Color(102, 0, 102), new Color(102, 0, 102), new Color(102, 0, 102),
            new Color(102, 0, 102), new Color(102, 0, 102), new Color(102, 0, 102), new Color(102, 0, 51),
            new Color(102, 0, 0), new Color(102, 51, 0), new Color(102, 102, 0), new Color(102, 102, 0),
            new Color(102, 102, 0), new Color(102, 102, 0), new Color(102, 102, 0), new Color(102, 102, 0),
            new Color(102, 102, 0), new Color(51, 102, 0), new Color(0, 102, 0), new Color(0, 102, 51),
            new Color(0, 102, 102), new Color(0, 102, 102), new Color(0, 102, 102)},
        //  row 9
        {new Color(0, 0, 0), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51),
            new Color(0, 51, 51), new Color(0, 0, 51), new Color(51, 0, 51), new Color(51, 0, 51),
            new Color(51, 0, 51), new Color(51, 0, 51), new Color(51, 0, 51), new Color(51, 0, 51),
            new Color(51, 0, 51), new Color(51, 0, 51), new Color(51, 0, 51), new Color(51, 0, 0),
            new Color(51, 51, 0), new Color(51, 51, 0), new Color(51, 51, 0), new Color(51, 51, 0),
            new Color(51, 51, 0), new Color(51, 51, 0), new Color(51, 51, 0), new Color(51, 51, 0),
            new Color(0, 51, 0), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51),
            new Color(0, 51, 51), new Color(51, 51, 51)}};

    /**
     * <p>
     * Represents the default width for every palette.
     * </p>
     */
    private static final int DEFAULT_PALETTE_WIDTH = 9;

    /**
     * <p>
     * Represents the default height for every palette.
     * </p>
     */
    private static final int DEFAULT_PALETTE_HEIGHT = 10;

    /**
     * <p>
     * Represents the default number of columns.
     * </p>
     */
    private static final int DEFAULT_PALETTE_COLUMNS = 31;

    /**
     * <p>
     * Represents the default number of rows.
     * </p>
     */
    private static final int DEFAULT_PALETTE_ROWS = 9;

    /**
     * <p>
     * Represents all of the colors in the palette.
     * </p>
     *
     * <p>
     * The dimension of the array should match palleteWidth * palleteHeight.
     * </p>
     *
     * <p>
     * Is immutable and will never be null.
     * </p>
     */
    private final Color[][] colors;

    /**
     * <p>
     * Represents the width of a palette.
     * </p>
     *
     * <p>
     * It should be a positive integer.
     * </p>
     *
     * <p>
     * It is immutable.
     * </p>
     */
    private final int paletteWidth;

    /**
     * <p>
     * Represents the height of a palette.
     * </p>
     *
     * <p>
     * It should be a positive integer.
     * </p>
     *
     * <p>
     * It is immutable.
     * </p>
     */
    private final int paletteHeight;

    /**
     * <p>
     * Represents the number of columns.
     * </p>
     *
     * <p>
     * It should be a positive integer.
     * </p>
     *
     * <p>
     * It is immutable.
     * </p>
     */
    private final int paletteColumns;

    /**
     * <p>
     * Represents the number of rows.
     * </p>
     *
     * <p>
     * It should be a positive integer.
     * </p>
     *
     * <p>
     * It is immutable.
     * </p>
     */
    private final int paletteRows;

    /**
     * <p>
     * Default constructor.
     * </p>
     *
     * <p>
     * The default values are used if the ColorPalettePanel instance is constructed using this constructor.
     * </p>
     */
    public ColorPalettePanel() {
        this.colors = DEFAULT_COLORS;
        this.paletteWidth = DEFAULT_PALETTE_WIDTH;
        this.paletteHeight = DEFAULT_PALETTE_HEIGHT;
        this.paletteColumns = DEFAULT_PALETTE_COLUMNS;
        this.paletteRows = DEFAULT_PALETTE_ROWS;

        initialize();
    }

    /**
     * <p>
     * Constructor with namespace as the parameter.
     * </p>
     *
     * <p>
     * Sample configuration:
     * &lt;Property name=&quot;palette&quot;&gt;
     *     &lt;Property name=&quot;width&quot;&gt;
     *         &lt;Value&gt;10&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;height&quot;&gt;
     *         &lt;Value&gt;10&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;columns&quot;&gt;
     *         &lt;Value&gt;2&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;rows&quot;&gt;
     *         &lt;Value&gt;2&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;color&quot;&gt;
     *        &lt;Property name=&quot;col0row0&quot;&gt;
     *            &lt;Value&gt;#000000&lt;/Value&gt;
     *        &lt;/Property&gt;
     *        &lt;Property name=&quot;col0row1&quot;&gt;
     *           &lt;Value&gt;#0000FF&lt;/Value&gt;
     *        &lt;/Property&gt;
     *        &lt;Property name=&quot;col1row0&quot;&gt;
     *            &lt;Value&gt;#00FF00&lt;/Value&gt;
     *        &lt;/Property&gt;
     *        &lt;Property name=&quot;col1row1&quot;&gt;
     *            &lt;Value&gt;#FF0000&lt;/Value&gt;
     *        &lt;/Property&gt;
     *    &lt;/Property&gt;
     * &lt;/Property&gt;
     * </p>
     *
     * @param namespace the namespace in the configuration file from which the configuration properties needs to be read
     *
     * @throws IllegalArgumentException if namespace is null or empty
     * @throws StylePanelConfigurationException if there is an invalid configuration
     */
    public ColorPalettePanel(String namespace) {
        Util.checkString(namespace, "namespace");

        Map<String, String> paletteMap = Util.getPropertyMap(namespace, "palette");

        if (paletteMap == null) {
            // The property is missing, then use default values
            this.colors = DEFAULT_COLORS;
            this.paletteWidth = DEFAULT_PALETTE_WIDTH;
            this.paletteHeight = DEFAULT_PALETTE_HEIGHT;
            this.paletteColumns = DEFAULT_PALETTE_COLUMNS;
            this.paletteRows = DEFAULT_PALETTE_ROWS;
        } else {
            // get the config value for width property and height property
            // The two properties should be configed together
            if (paletteMap.containsKey("width")) {
                if (paletteMap.containsKey("height")) {
                    // The two properties are both configed
                    this.paletteWidth = Util.convertInteger(paletteMap.get("width"), "palette.width");
                    this.paletteHeight = Util.convertInteger(paletteMap.get("height"), "palette.height");
                } else {
                    throw new StylePanelConfigurationException("The width property is present in the "
                        + "configuration file but the height property is not present.");
                }
            } else {
                if (paletteMap.containsKey("height")) {
                    throw new StylePanelConfigurationException("The height property is present in the "
                        + "configuration file but the width property is not present.");
                } else {
                    // The two properties are both not configed, use the default value
                    this.paletteWidth = DEFAULT_PALETTE_WIDTH;
                    this.paletteHeight = DEFAULT_PALETTE_HEIGHT;
                }
            }

            // get the config value for columns property and rows property
            // The two properties should be configed together
            if (paletteMap.containsKey("columns")) {
                if (paletteMap.containsKey("rows")) {
                    // The two properties are both configed
                    this.paletteColumns = Util.convertInteger(paletteMap.get("columns"), "palette.columns");
                    this.paletteRows = Util.convertInteger(paletteMap.get("rows"), "palette.rows");

                    // The colors are read from configuration as well
                    this.colors = new Color[this.paletteRows][this.paletteColumns];
                    configColors(namespace);
                } else {
                    throw new StylePanelConfigurationException("The columns property is present in the "
                        + "configuration file but the rows property is not present.");
                }
            } else {
                if (paletteMap.containsKey("rows")) {
                    throw new StylePanelConfigurationException("The rows property is present in the "
                        + "configuration file but the columns property is not present.");
                } else {
                    // The two properties are both not configed, use the default value
                    this.paletteColumns = DEFAULT_PALETTE_COLUMNS;
                    this.paletteRows = DEFAULT_PALETTE_ROWS;
                    this.colors = DEFAULT_COLORS;
                }
            }
        }

        initialize();
    }

    /**
     * <p>
     * This method loads the colors property from configuration file.
     * </p>
     *
     * <p>
     * The color string in configuration file is using the #RRGGBB format.
     * </p>
     *
     * @param namespace the namespace in the configuration file from
     * which the configuration properties needs to be read
     *
     * @throws StylePanelConfigurationException if there is some color
     * property is missing or invalid color string
     */
    private void configColors(String namespace) {
        Map<String, String> colorMap = Util.getPropertyMap(namespace, "palette.color");

        // The colors property is missing
        if (colorMap == null) {
            throw new StylePanelConfigurationException("The palette.color property is missing.");
        }

        // for each color, get its value from configuration file
        for (int i = 0; i < paletteRows; i++) {
            for (int j = 0; j < paletteColumns; j++) {
                // compose the property name
                String propertyName = "col" + j + "row" + i;

                // the property is missing
                if (!colorMap.containsKey(propertyName)) {
                    throw new StylePanelConfigurationException("The " + propertyName + " property "
                        + "which is under palette.color property is missing in the configuration file.");
                }

                // convert the color string to the Color instance
                colors[i][j] = convertColor(colorMap.get(propertyName), "palette.colors." + propertyName);
            }
        }
    }

    /**
     * <p>
     * Converts a color string to the Color representation.
     * </p>
     *
     * <p>
     * The format for the color string is <b>#RRGGBB</b>.
     * </p>
     *
     * @param colorString the color string value
     * @param propName the property name where the color string is read from
     *
     * @return the Color instance that represents the given color string
     *
     * @throws StylePanelConfigurationException if the color string
     * is not conform to the #RRGGBB format
     */
    private Color convertColor(String colorString, String propName) {
        Color color = Util.convertColor(colorString, null);

        // The color string is not conform to the #RRGGBB format
        if (color == null) {
            throw new StylePanelConfigurationException("The " + propName
                + " property is not a valid color string representation, its value is " + colorString);
        }

        return color;
    }

    /**
     * <p>
     * Initialize the palette panel widget.
     * </p>
     *
     * <p>
     * It is used by the two constructors.
     * </p>
     */
    private void initialize() {
        setToolTipText("");
        setOpaque(true);
        setBackground(Color.WHITE);
        setRequestFocusEnabled(false);
    }

    /**
     * <p>
     * Paint the palette.
     * </p>
     *
     * <p>
     * Each palette will be painted using the Color initialized in the constructor.
     * </p>
     *
     * <p>
     * The row and column number of palette are specified in the constructor too.
     * </p>
     *
     * @param g the graphics to be painted
     */
    protected void paintComponent(Graphics g) {
        // save the old color for restore
        Color oldColor = g.getColor();

        // draw the whole panel
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        // draw each palette
        for (int row = 0; row < paletteRows; row++) {
            for (int column = 0; column < paletteColumns; column++) {
                g.setColor(colors[row][column]);

                // fill the palette
                int x = column * (paletteWidth + 1);
                int y = row * (paletteHeight + 1);
                g.fillRect(x, y, paletteWidth, paletteHeight);

                // draw the lines for the palette
                g.setColor(Color.black);
                g.drawLine(x + paletteWidth - 1, y, x + paletteWidth - 1, y + paletteHeight - 1);
                g.drawLine(x, y + paletteHeight - 1, x + paletteWidth - 1, y + paletteHeight - 1);
            }
        }

        // restore the original color
        g.setColor(oldColor);
    }

    /**
     * <p>
     * Returns the preferred size based on width, height, columns, and rows of the palette panel.
     * </p>
     *
     * @return the preferred size based on width, height, columns, and rows of the palette panel.
     */
    public Dimension getPreferredSize() {
        int x = this.paletteColumns * (this.paletteWidth + 1) - 1;
        int y = this.paletteRows * (this.paletteHeight + 1) - 1;
        return new Dimension(x, y);
    }

    /**
     * <p>
     * This method specifies this widget can not be focus traversable.
     * </p>
     *
     * @return false to specify this widget can not be focus traversable
     */
    public boolean isFocusable() {
        return false;
    }

    /**
     * <p>
     * Show RGB value in the tool tip.
     * </p>
     *
     * <p>
     * The representation is the form as below:
     * <b>RED + ", " + GREEN + ", " + BLUE</b>
     * </p>
     *
     * @param e the mouse event
     *
     * @return the color string (using <b>RED + ", " + GREEN + ", " + BLUE</b> format)
     * of the color under the the mouse as the tool tip string.
     */
    public String getToolTipText(MouseEvent e) {
        Color color = getColorForLocation(e.getX(), e.getY());
        return color.getRed() + ", " + color.getGreen() + ", " + color.getBlue();
    }

    /**
     * <p>
     * Return the color on the given x and y coordinate.
     * </p>
     *
     * @param x axis position
     * @param y ordinate position
     *
     * @return the color on the given x and y coordinate
     *
     * @throws IllegalArgumentException if x or y is less
     * than 0, or if x &gt;= width or y &gt;= height
     */
    public Color getColorForLocation(int x, int y) {
        if (x < 0) {
            throw new IllegalArgumentException("The x position is negative.");
        }
        if (y < 0) {
            throw new IllegalArgumentException("The y position is negative.");
        }

        // get the width and height of the palette panel
        Dimension size = this.getPreferredSize();

        // compare the x value and y value with the size of this palette panel
        if (x >= size.width) {
            throw new IllegalArgumentException("The x position is large than or equal to the "
                + "width of the palette panel.");
        }
        if (y >= size.height) {
            throw new IllegalArgumentException("The y position is large than or equal to the "
                + "height of the palette panel.");
        }

        int column = x / (paletteWidth + 1);
        int row = y / (paletteHeight + 1);
        return colors[row][column];
    }
}
