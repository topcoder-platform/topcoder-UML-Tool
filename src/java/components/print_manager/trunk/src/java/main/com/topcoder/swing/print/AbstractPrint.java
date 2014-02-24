/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.print.PageFormat;
import java.awt.print.Printable;


/**
 * <p>This is an abstract class that implements java.awt.print.Printable interface. This class aims to provide
 * common elements for the requirements of this component. It has two subclasses: FitInPagePrint and ScalingPrint. The
 * aim of this class is to maintain java.awt.Component and java.awt.Rectangle instance.</p>
 *  <p>Thread safe: This class is immutable so it is thread safe.</p>
 *
 * @author Xuchen, TCSDEVELOPER
 * @version 1.0
 */
public abstract class AbstractPrint implements Printable {
    /**
     * <p>Represents the component to be printed.</p>
     */
    private final Component component;

    /**
     * <p>Represents the rectangle within which component will be print. It maybe null in which case the whole
     * component will be printed.</p>
     */
    private final Rectangle rectangle;

    /**
     * <p>Initialize its component field to its given argument and rectangle to null.</p>
     * @param component the component to be printed
     * @throws IllegalArgumentException if given component is null
     */
    public AbstractPrint(Component component) {
        ParameterCheck.checkNull("component", component);
        this.component = component;
        this.rectangle = null;
    }

    /**
     * <p>Initialize its component field to its given component argument and rectangle to given rectangle argument.</p>
     * @param component the component to be printed
     * @param rectangle the rectangle area within which the component to be printed
     * @throws IllegalArgumentException if any argument is null
     */
    public AbstractPrint(Component component, Rectangle rectangle) {
        ParameterCheck.checkNull("component", component);
        ParameterCheck.checkNull("rectangle", rectangle);
        this.component = component;
        this.rectangle = rectangle;
    }

    /**
     * <p>This is an abstract method which is needed to be implemented by its subclass. This method should print
     * the page at the specified index into the specified Graphics context in the specified format.</p>
     *
     * @param graphics the context into which the page is drawn
     * @param pageFormat the size and orientation of the page being drawn
     * @param pageIndex the zero based index of the page to be drawn
     *
     * @return PAGE_EXISTS if the page is rendered successfully or NO_SUCH_PAGE if pageIndex specifies a non-existent
     *         page.
     */
    public abstract int print(Graphics graphics, PageFormat pageFormat, int pageIndex);

    /**
     * <p>Return the component to be printed.</p>
     *
     * @return the inner component instance
     */
    public Component getComponent() {
        return this.component;
    }

    /**
     * <p>Return the inner Rectangle instance. It may be null.</p>
     *
     * @return the inner rectangle area. It maybe null
     */
    public Rectangle getRectangle() {
        return this.rectangle;
    }
}
