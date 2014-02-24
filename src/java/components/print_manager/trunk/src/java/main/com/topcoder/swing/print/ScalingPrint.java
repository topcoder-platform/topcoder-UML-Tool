/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.print.PageFormat;


/**
 * <p>This class extends from AbstractPrint class. This class aims to split given component into several simple
 * grids and print each grid into a page. scaleFactor will be given to scale the component before being printed.</p>
 *  <p>This class is thread safe since it is immutable.</p>
 *
 * @author Xuchen, TCSDEVELOPER
 * @version 1.0
 */
public class ScalingPrint extends AbstractPrint {
    /**
     * <p>Represents scaling factor used in printing. It must be positive.</p>
     */
    private final double scaleFactor;

    /**
     * <p>Represents the grids into which the component be split.</p>
     */
    private Rectangle[] grids;

    /**
     * <p>
     * Create ScalingPrint instance with given component and scale.
     * </p>
     *
     *
     * @param component    the component to be printed
     * @param scaleFactor   the scale factor used to scale given component when printed
     * @throws IllegalArgumentException  if given component is null and scale factor is not positive.
     */
    public ScalingPrint(Component component, double scaleFactor) {
        super(component);
        checkNotPositive("scaleFactor", scaleFactor);
        this.scaleFactor = scaleFactor;
    }

    /**
     * <p>
     * Create ScalingPrint instance with given component, rectangle and scale.
     * </p>
     *
     *
     * @param component  the component to be printed
     * @param rectangle  the rectangle area within which the component is to be printed
     * @param scaleFactor the scale factor used to scale given component when printed
     * @throws IllegalArgumentException  if any argument is null or scale factor is not positive.
     */
    public ScalingPrint(Component component, Rectangle rectangle, double scaleFactor) {
        super(component, rectangle);
        checkNotPositive("scaleFactor", scaleFactor);
        this.scaleFactor = scaleFactor;
    }

    /**
     * <p>Print the component with the given PageFormat and page index.</p>
     *
     * @param graphics the context into which the page is drawn
     * @param pageFormat the size and orientation of the page being drawn
     * @param pageIndex the zero based index of the page to be drawn
     *
     * @return PAGE_EXISTS if the page is rendered successfully or NO_SUCH_PAGE if pageIndex specifies a non-existent
     *         page.
     */
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
        //initialize the grids at the first time
        if (grids == null) {
            init(pageFormat);
        }

        //if given pageIndex is greater or equal to grids' length, return NO_SUCH_PAGE
        if (pageIndex >= grids.length) {
            return NO_SUCH_PAGE;
        }

        //grid to be printed in this page
        Rectangle grid = grids[pageIndex];

        //left top coordinate of the printed grid
        double gridX = grid.getX();
        double gridY = grid.getY();

        //left top coordinate of the page's printable area
        double pageX = pageFormat.getImageableX();
        double pageY = pageFormat.getImageableY();

        Graphics2D g2d = (Graphics2D) graphics;

        g2d.scale(scaleFactor, scaleFactor); //scale the graphics
        g2d.translate(((pageX / scaleFactor) - gridX), ((pageY / scaleFactor) - gridY)); //adjust origin
        g2d.setClip(grid); //set current grid as printed area

        getComponent().print(graphics);

        return PAGE_EXISTS;
    }

    /**
     * Split the printed area into grids according to the scale factor.
     *
     * @param pageFormat the size and orientation of the page being drawn
     */
    private void init(PageFormat pageFormat) {
        //calculates page width
        double pageWidth = pageFormat.getImageableWidth() / scaleFactor;
        double pageHeight = pageFormat.getImageableHeight() / scaleFactor;

        Component component = this.getComponent();

        //calculates the width and height of the area that will be printed
        int areaWidth, areaHeight;
        double areaX, areaY, maxAreaX, maxAreaY;

        Rectangle rectangle = this.getRectangle();

        //if rectangle specified, take the rectangle as print area
        if (rectangle != null) {
            areaWidth = (int) rectangle.getWidth();
            areaHeight = (int) rectangle.getHeight();
            areaX = rectangle.getX();
            areaY = rectangle.getY();
        } else {
            areaWidth = (int) component.getWidth();
            areaHeight = (int) component.getHeight();
            areaX = 0;
            areaY = 0;
        }

        maxAreaX = areaX + areaWidth;
        maxAreaY = areaY + areaHeight;

        //caculate the number of rows and columns the printed area will be split into grids.
        int numberRow = (int) Math.ceil(areaHeight / pageHeight);
        int numberColumn = (int) Math.ceil(areaWidth / pageWidth);

        grids = new Rectangle[numberRow * numberColumn];

        double x, y, w, h; //x,y, width, height of the split grid

        for (int row = 0; row < numberRow; row++) {
            y = areaY + (row * pageHeight);

            //ensure the height of the marginal grid will not exceed the printed area
            h = Math.min(pageHeight, maxAreaY - y);

            for (int col = 0; col < numberColumn; col++) {
                x = areaX + (col * pageWidth);

                //ensure the width of the marginal grid will not exceed the printed area
                w = Math.min(pageWidth, maxAreaX - x);
                grids[(row * numberColumn) + col] = new Rectangle((int) x, (int) y, (int) w, (int) h);
            }
        }
    }

    /**
     * <p>Return the scale factor. It must be positive.</p>
     *
     * @return the scale factor
     */
    public double getScaleFactor() {
        return this.scaleFactor;
    }

    /**
     * Checks and throws IllegalArgumentException if the parameter is not positive.
     *
     * @param paramName name of the parameter
     * @param value value to be checked
     *
     * @throws IllegalArgumentException if the parameter is not positive
     */
    private static void checkNotPositive(String paramName, double value) {
        if (value <= 0) {
            throw new IllegalArgumentException(paramName + " is not positive:" + value);
        }
    }
}
