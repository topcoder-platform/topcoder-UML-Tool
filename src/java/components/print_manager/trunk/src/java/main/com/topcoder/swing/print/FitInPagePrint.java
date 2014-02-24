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
 * <p>This class extends from AbstractPrint class. This class aims to print given component into a single page,
 * which means if the area of given component to be printed is too large or too small for one page, we need to scale
 * it to fit in just a single page.</p>
 *  <p>This class is thread safe since it is immutable.</p>
 *
 * @author Xuchen, TCSDEVELOPER
 * @version 1.0
 */
public class FitInPagePrint extends AbstractPrint {
    /**
     * <p>Create a FitInPagePrint instance.</p>
     * @param component the component to be printed
     * @throws IllegalArgumentException if component is null
     */
    public FitInPagePrint(Component component) {
        super(component);
    }

    /**
     * <p>Create a FitInPagePrint instance specified the printed area.</p>
     * @param component the component to print
     * @param rectangle the rectangle area within which the component is to printed
     * @throws IllegalArgumentException if any argument is null
     */
    public FitInPagePrint(Component component, Rectangle rectangle) {
        super(component, rectangle);
    }

    /**
     * <p>This method will print the component within given rectangle if it is provided.</p>
     *
     * @param graphics the context into which the page is drawn
     * @param pageFormat the size and orientation of the page being drawn
     * @param pageIndex the zero based index of the page to be drawn
     *
     * @return PAGE_EXISTS if the page is rendered successfully or NO_SUCH_PAGE if pageIndex specifies a non-existent
     *         page.
     */
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Component component = getComponent();

        //left top coordinate of the printed area
        double areaX, areaY;

        //width and height of the printed area
        double areaWidth, areaHeight;

        //if printing rectangle specified, adjust the max with and height of the printed area according to it
        Rectangle rectangle = getRectangle();

        if (rectangle != null) {
            areaWidth = rectangle.getWidth();
            areaHeight = rectangle.getHeight();
            areaX = rectangle.getX();
            areaY = rectangle.getY();
        } else {
            //the printed area is the component it self
            areaWidth = component.getWidth();
            areaHeight = component.getHeight();
            areaX = 0;
            areaY = 0;
        }

        //the width and height of the page's printable area
        double pageWidth = pageFormat.getImageableWidth();
        double pageHeight = pageFormat.getImageableHeight();

        //left top coordinate of the page's printable area
        double pageX = pageFormat.getImageableX();
        double pageY = pageFormat.getImageableY();

        //calculate the proper scale factor with witch the selected area of the component
        //can be printed totally to the whole page
        double scale = Math.min(pageWidth / areaWidth, pageHeight / areaHeight);

        Graphics2D g2d = (Graphics2D) graphics;

        //scale the graphics
        g2d.scale(scale, scale);
        g2d.translate(((pageX / scale) - areaX), ((pageY / scale) - areaY)); //adjust origin
        g2d.setClip((int) areaX, (int) areaY, (int) areaWidth, (int) areaHeight);

        component.print(graphics);

        return PAGE_EXISTS;
    }
}
