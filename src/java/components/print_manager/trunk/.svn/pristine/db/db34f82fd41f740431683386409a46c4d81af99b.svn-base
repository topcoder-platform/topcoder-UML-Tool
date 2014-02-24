/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.impl;

import com.topcoder.swing.print.PrintingPanel;

import junit.framework.TestCase;

import java.awt.Component;


/**
 * Test case for DefaultComponentVisibleMaker.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultComponentVisibleMakerTest extends TestCase {
    /** DefaultComponentVisibleMaker used in this test. */
    private DefaultComponentVisibleMaker visibleMaker;

    /** Component used in this test. */
    private Component component;

    /**
     * Sests up test environment.
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        visibleMaker = new DefaultComponentVisibleMaker();

        component = new PrintingPanel(400, 400, "DefaultComponentVisibleMakerTest");
    }

    /**
     * Test ctor. DefaultComponentVisibleMaker should be instantiated successfully.
     */
    public void testDefaultComponentVisibleMaker() {
        assertNotNull(visibleMaker);

        //success
    }

    /**
     * Test {@link DefaultComponentVisibleMaker#makeVisible(Component)} with invisible component.
     */
    public void testMakeVisible() {
        component.setVisible(false);
        visibleMaker.makeVisible(component);

        assertTrue("component should be visible", component.isVisible());
    }

    /**
     * Test {@link DefaultComponentVisibleMaker#makeInvisible(Component)} with a visible component.
     */
    public void testMakeInvisible() {
        //make the invisible component visible
        component.setVisible(false);
        visibleMaker.makeVisible(component);

        assertTrue("component should be visible", component.isVisible());

        //restore it to invisible state
        visibleMaker.makeInvisible(component);
        assertFalse("component should be invisible", component.isVisible());
    }

    /**
     * Test {@link DefaultComponentVisibleMaker#makeInvisible(Component)} before the component being made
     * visible by makeVisible().
     */
    public void testMakeInvisibleIllegal() {
        try {
            visibleMaker.makeInvisible(component);
            fail("makeVisible() should be call before makeInvisible, IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link DefaultComponentVisibleMaker#clear()}.
     */
    public void testClear() {
        visibleMaker.clear();

        //success
    }
}
