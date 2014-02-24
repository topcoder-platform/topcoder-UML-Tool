/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter.accuracytests;

import com.topcoder.swing.imageexporter.DefaultVisibleMaker;

import javax.swing.JComponent;
import javax.swing.JLabel;

import junit.framework.TestCase;

/**
 * Accuracy Test for DefaultVisibleMaker.
 *
 * @author smallka
 * @version 1.0
 */
public class DefaultVisibleMakerAccuracyTest extends TestCase {

    /** An instance of DefaultVisibleMaker for testing. */
    private DefaultVisibleMaker maker;

    /** An instance of JComponent for testing. */
    private JComponent component;

    /**
     * Sets up the environment.
     */
    protected void setUp() {
        maker = new DefaultVisibleMaker();
        component = new JLabel("Visible");
        component.setVisible(false);
    }

    /**
     * Test the constructor.
     */
    public void testDefaultVisibleMakerAccuracy() {
        assertNotNull("fail to construct the instance", maker);
    }

    /**
     * Test method makeVisible.
     */
    public void testMakeVisibleAccuracy() {
        assertFalse("invisible expected", component.isVisible());
        maker.makeVisible(component);
        assertTrue("visible expected", component.isVisible());

        component.setVisible(true);
        assertTrue("visible expected", component.isVisible());
        maker.makeVisible(component);
        assertTrue("visible expected", component.isVisible());
    }

    /**
     * Test method restoreVisibility.
     */
    public void testRestoreVisibilityAccuracy() {
        maker.makeVisible(component);
        assertTrue("visible expected", component.isVisible());
        maker.restoreVisibility(component);
        assertFalse("invisible expected", component.isVisible());

        component.setVisible(true);
        maker.makeVisible(component);
        assertTrue("visible expected", component.isVisible());
        maker.restoreVisibility(component);
        assertTrue("visible expected", component.isVisible());
    }
}