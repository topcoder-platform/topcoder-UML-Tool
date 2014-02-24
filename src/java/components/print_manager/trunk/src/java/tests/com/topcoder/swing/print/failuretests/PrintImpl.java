/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.failuretests;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.print.PageFormat;

import com.topcoder.swing.print.AbstractPrint;

/**
 * <p>
 * This is a mocked implementation of AbstractPrint.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class PrintImpl extends AbstractPrint {
    /**
     * <p>
     * Constructs an <code>PrintImpl</code> instance with the given component.
     * </p>
     *
     * @param component the component to print
     * @throws IllegalArgumentException if given component is null
     */
    public PrintImpl(Component component) {
        super(component);
    }

    /**
     * <p>
     * Constructs an <code>PrintImpl</code> instance with the given component
     * and rectangle.
     * </p>
     *
     * @param component the component to print
     * @param rectangle the rectangle area within which the component to print.
     *            It can be null.
     * @throws IllegalArgumentException if the component is null
     */
    public PrintImpl(Component component, Rectangle rectangle) {
        super(component, rectangle);
    }

    /**
     * <p>
     * This is a mocked implementation.
     * </p>
     *
     * @param graphics the context into which the page is drawn
     * @param pageFormat the size and orientation of the page being drawn
     * @param pageIndex the zero based index of the page to be drawn
     * @return PAGE_EXISTS if the page is rendered successfully or NO_SUCH_PAGE
     *         if pageIndex specifies a non-existent page.
     */
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
        return NO_SUCH_PAGE;
    }

}
