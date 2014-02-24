/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

class CommonColorPanel extends JPanel {
    /**
     * <p>
     * Represents the default colors for the color chooser.
     * </p>
     */
    private static final Color[] DEFAULT_COLORS = new Color[] {new Color(255, 255, 255), new Color(0, 0, 0),
        new Color(204, 204, 255), new Color(255, 102, 102), new Color(204, 255, 204), new Color(255, 255, 0),
        new Color(153, 50, 205), new Color(255, 242, 204), new Color(191, 255, 128), new Color(255, 204, 204)};

    /**
     * <p>
     * Represents the default width for every palette.
     * </p>
     */
    private static final int DEFAULT_PALETTE_WIDTH = 30;

    /**
     * <p>
     * Represents the default height for every palette.
     * </p>
     */
    private static final int DEFAULT_PALETTE_HEIGHT = 15;

    /**
     * <p>
     * Represents the default number of columns.
     * </p>
     */
    private static final int DEFAULT_PALETTE_COLUMNS = 10;

    /**
     * <p>
     * Represents all of the colors in the palette.
     * </p>
     * <p>
     * The dimension of the array should match palleteWidth * palleteHeight.
     * </p>
     * <p>
     * Is immutable and will never be null.
     * </p>
     */
    private final Color[] colors;

    /**
     * <p>
     * Represents the width of a palette.
     * </p>
     * <p>
     * It should be a positive integer.
     * </p>
     * <p>
     * It is immutable.
     * </p>
     */
    private final int paletteWidth;

    /**
     * <p>
     * Represents the height of a palette.
     * </p>
     * <p>
     * It should be a positive integer.
     * </p>
     * <p>
     * It is immutable.
     * </p>
     */
    private final int paletteHeight;

    /**
     * <p>
     * Represents the number of columns.
     * </p>
     * <p>
     * It should be a positive integer.
     * </p>
     * <p>
     * It is immutable.
     * </p>
     */
    private final int paletteColumns;

    /**
     * <p>
     * Default constructor.
     * </p>
     * <p>
     * The default values are used if the RecentColorPanel instance is constructed using this constructor.
     * </p>
     */
    public CommonColorPanel() {
        this.paletteWidth = DEFAULT_PALETTE_WIDTH;
        this.paletteHeight = DEFAULT_PALETTE_HEIGHT;
        this.paletteColumns = DEFAULT_PALETTE_COLUMNS;
        this.colors = DEFAULT_COLORS;

        initialize();
    }

    /**
     * <p>
     * Initialize the palette panel widget.
     * </p>
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
     * <p>
     * Each palette will be painted using the Color initialized in the constructor.
     * </p>
     * <p>
     * The row and column number of palette are specified in the constructor too.
     * </p>
     * @param g
     *            the graphics to be painted
     */
    protected void paintComponent(Graphics g) {
        // save the old color for restore
        Color oldColor = g.getColor();

        // draw the whole panel
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        // draw each palette
        for (int column = 0; column < paletteColumns; column++) {
            g.setColor(colors[column]);

            // fill the palette
            int x = column * (paletteWidth + 1);
            g.fillRect(x, 0, paletteWidth, paletteHeight);

            // draw the lines for the palette
            g.setColor(Color.black);
            g.drawLine(x + paletteWidth - 1, 0, x + paletteWidth - 1, paletteHeight - 1);
            g.drawLine(x, paletteHeight - 1, x + paletteWidth - 1, paletteHeight - 1);
        }

        // restore the original color
        g.setColor(oldColor);
    }

    /**
     * <p>
     * Returns the preferred size based on width, height, columns, and rows of the palette panel.
     * </p>
     * @return the preferred size based on width, height, columns, and rows of the palette panel.
     */
    public Dimension getPreferredSize() {
        int x = this.paletteColumns * (this.paletteWidth + 1) - 1;
        int y = this.paletteHeight;
        return new Dimension(x, y);
    }

    /**
     * <p>
     * This method specifies this widget can not be focus traversable.
     * </p>
     * @return false to specify this widget can not be focus traversable
     */
    public boolean isFocusable() {
        return false;
    }

    /**
     * <p>
     * Show RGB value in the tool tip.
     * </p>
     * <p>
     * The representation is the form as below: <b>RED + ", " + GREEN + ", " + BLUE</b>
     * </p>
     * @param e
     *            the mouse event
     * @return the color string (using <b>RED + ", " + GREEN + ", " + BLUE</b> format) of the color under the the mouse
     *         as the tool tip string.
     */
    public String getToolTipText(MouseEvent e) {
        Color color = getColorForLocation(e.getX(), e.getY());
        return color.getRed() + ", " + color.getGreen() + ", " + color.getBlue();
    }

    /**
     * <p>
     * Return the color on the given x and y coordinate.
     * </p>
     * @param x
     *            axis position
     * @param y
     *            ordinate position
     * @return the color on the given x and y coordinate
     * @throws IllegalArgumentException
     *             if x or y is less than 0, or if x >= width or y >= height
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
        return colors[column];
    }
}
