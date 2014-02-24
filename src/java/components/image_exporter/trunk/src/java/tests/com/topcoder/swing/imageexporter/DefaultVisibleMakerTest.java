/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import junit.framework.TestCase;

import javax.swing.JComponent;
import javax.swing.JPanel;


/**
 * Test case for DefaultVisibleMaker.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultVisibleMakerTest extends TestCase {
    /** DefaultVisibleMaker instance used in this test. */
    private DefaultVisibleMaker visibleMaker;

    /** Default jcomponent used in this test. */
    private JComponent component;

    /**
     * Test {@link DefaultVisibleMaker#DefaultVisibleMaker()}. An instance should be created successfully.
     */
    public void testDefaultVisibleMaker() {
        assertNotNull("DefaultVisibleMaker should be created", visibleMaker);
    }

    /**
     * Test {@link DefaultVisibleMaker#makeVisible(JComponent)}, an unvisible component should be made visible
     * by this method.
     */
    public void testMakeVisible() {
        component.setVisible(false);
        visibleMaker.makeVisible(component);
        assertTrue("component should be made to visible", component.isVisible());
    }

    /**
     * Test {@link DefaultVisibleMaker#makeVisible(JComponent)}, component is null and IAE is expected.
     */
    public void testMakeVisibleNull() {
        try {
            visibleMaker.makeVisible(null);
            fail("component is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link DefaultVisibleMaker#restoreVisibility(JComponent)}, componet should be restore its original
     * visibility by this method.
     */
    public void testRestoreVisibility() {
        component.setVisible(false);
        //the component is invisible firstly, and we make it visible here
        visibleMaker.makeVisible(component);

        //then restore it's visibility(false)
        visibleMaker.restoreVisibility(component);
        assertFalse("component should be made invisible", component.isVisible());
    }

    /**
     * Test {@link DefaultVisibleMaker#restoreVisibility(JComponent)}, this method is called before the
     * component made visible, and {@link IllegalArgumentException} is expected.
     */
    public void testRestoreVisibilityIllegalUse() {
        try {
            visibleMaker.restoreVisibility(component);
            fail("component is not made visiblity previously, IllegalStateException is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link DefaultVisibleMaker#restoreVisibility(JComponent)}, null is given and IAE is expected.
     */
    public void testRestoreVisibilityNull() {
        try {
            visibleMaker.restoreVisibility(null);
            fail("component is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Sets up test environment.
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        visibleMaker = new DefaultVisibleMaker();
        component = new JPanel();
        component.setVisible(true);
    }
}
