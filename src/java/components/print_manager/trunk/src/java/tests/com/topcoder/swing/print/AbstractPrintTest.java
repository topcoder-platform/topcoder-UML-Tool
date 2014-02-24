/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import junit.framework.TestCase;

import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.JFrame;


/**
 * Test case for AbstractPrint. Mock implementation MockAbstractPrint is used in this test.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AbstractPrintTest extends TestCase {
    /** Default component used in this test. */
    private Component component;

    /** Default rectangle used in this test. */
    private Rectangle rectangle;

    /**
     * Sets up test environment.
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        this.component = new JFrame();
        this.rectangle = new Rectangle();
    }

    /**
     * Test AbstractPrintComponent#ctor(Component). It should be instantiated successfully.
     */
    public void testAbstractPrintComponent() {
        new MockAbstractPrint(component);

        //success
    }

    /**
     * Test AbstractPrintComponent#ctor(Component) with null component. IAE is expected.
     */
    public void testAbstractPrintNullComponent() {
        try {
            new MockAbstractPrint(null);
            fail("IllegalArgumentException should be thrown since component is null");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test AbstractPrintComponent#ctor(Component, Rectangle) with proper arguments. It's should be
     * instantiated successfully.
     */
    public void testAbstractPrintComponentRectangle() {
        new MockAbstractPrint(component, rectangle);

        //success
    }

    /**
     * Test AbstractPrintComponent#ctor(Component, Rectangle) with null component. IAE is expected.
     */
    public void testAbstractPrintNullComponentRectangle() {
        try {
            new MockAbstractPrint(null, rectangle);
            fail("IllegalArgumentException should be thrown since component is null");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test AbstractPrintComponent#ctor(Component, Rectangle) with null rectangle. IAE is expected.
     */
    public void testAbstractPrintComponentNullRectangle() {
        try {
            new MockAbstractPrint(component, null);
            fail("IllegalArgumentException should be thrown since rectangle is null");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test AbstractPrintComponent#getComponent(), obtaining the value set in ctor.
     */
    public void testGetComponent1() {
        AbstractPrint print = new MockAbstractPrint(component);
        assertEquals("component obtained should equal", component, print.getComponent());
    }

    /**
     * Test AbstractPrintComponent#getComponent(), obtaining the value set in ctor.
     */
    public void testGetComponent2() {
        AbstractPrint print = new MockAbstractPrint(component, rectangle);
        assertEquals("component obtained should equal", component, print.getComponent());
    }

    /**
     * Test AbstractPrintComponent#getRectangle(), obtaining the value set in ctor.
     */
    public void testGetRectangle() {
        AbstractPrint print = new MockAbstractPrint(component, rectangle);
        assertEquals("rectangle obtained should equal", rectangle, print.getRectangle());
    }
}
