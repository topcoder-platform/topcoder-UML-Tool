/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.accuracytests;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.print.PageFormat;

import junit.framework.TestCase;

import com.topcoder.swing.print.AbstractPrint;

/**
 * This class aggregates accuracy tests for AbstractPrint abstract class.
 * 
 * @author ch_music
 * @version 1.0
 */
public class AbstractPrintAccuracyTests extends TestCase {

    /**
     * A placeholder for MockAbstractPrint.
     */
    private MockAbstractPrint test;

    /**
     * A Component for unit testing purposes.
     */
    private Component component = new Label();

    /**
     * A Rectangle for unit testing purposes.
     */
    private Rectangle rectangle = new Rectangle();

    /**
     * Sets up testing environment.
     */
    public void setUp() {
        test = new MockAbstractPrint(component, rectangle);
    }

    /**
     * Tests constructor(Component). No exception is expected.
     */
    public void testAbstractPrintComponent() {
        test = new MockAbstractPrint(component);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set component.", component, test.getComponent());
        assertNull("Constructor fails to set rectangle.", test.getRectangle());
    }

    /**
     * Tests constructor(Component, Rectangle). No exception is expected.
     */
    public void testAbstractPrintComponentRectangle() {
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set component.", component, test.getComponent());
        assertEquals("Constructor fails to set rectangle.", rectangle, test.getRectangle());
    }

    /**
     * Tests getComponent method. No exception is expected.
     */
    public void testGetComponent() {
        assertEquals("getComponent returns wrong instance.", component, test.getComponent());
    }

    /**
     * Tests getRectangle method. No exception is expected.
     */
    public void testGetRectangle() {
        assertEquals("getRectangle returns wrong instance.", rectangle, test.getRectangle());
    }

    /**
     * <p>
     * A mock implementation of AbstractPrint abstract class.
     * </p>
     * 
     * @author ch_music
     * @version 1.0
     */
    private static final class MockAbstractPrint extends AbstractPrint {

        /**
         * <p>
         * Creates a new MockAbstractPrint with the given component.
         * </p>
         * 
         * @param component the component to print
         * @throws IllegalArgumentException if given component is null
         */
        public MockAbstractPrint(Component component) {
            super(component);
        }

        /**
         * <p>
         * Creates a new MockAbstractPrint with the given component and rectangle.
         * </p>
         * 
         * @param component the component to print
         * @param rectangle the rectangle area within which the component is printed
         * @throws IllegalArgumentException if any argument is null
         */
        public MockAbstractPrint(Component component, Rectangle rectangle) {
            super(component, rectangle);
        }

        /**
         * <p>
         * A mock implementation, does nothing, returns 0.
         * </p>
         * 
         * @param graphics the context into which the page is drawn
         * @param pageFormat the size and orientation of the page being drawn
         * @param pageIndex the zero based index of the page to be drawn
         * @return PAGE_EXISTS if the page is rendered successfully or NO_SUCH_PAGE if pageIndex specifies a
         *         non-existent page
         */
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
            return 0;
        }
    }
}
