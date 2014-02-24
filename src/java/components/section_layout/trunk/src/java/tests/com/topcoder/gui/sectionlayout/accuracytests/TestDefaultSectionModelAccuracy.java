/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.accuracytests;

import com.topcoder.gui.sectionlayout.model.DefaultSectionModel;

import junit.framework.TestCase;


/**
 * Accuracy test cases for class <code>DefaultSectionModel </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestDefaultSectionModelAccuracy extends TestCase {
    /** Represents the DefaultSectionModel instance for testing. */
    private DefaultSectionModel model = null;

    /**
     * Set up.
     */
    public void setUp() {
        model = new DefaultSectionModel();
    }

    /**
     * Test the default ctor.
     */
    public void testDefaultSectionModel() {
        assertNotNull(model);
    }

    /**
     * Test method <code> boolean isFloating() </code>.
     */
    public void testIsFloating() {
        assertFalse("The default floating value is false.", model.isFloating());
    }

    /**
     * Test method <code>setFloating(boolean floating) </code>.
     */
    public void testSetFloating() {
        model.setFloating(true);
        assertTrue(model.isFloating());
    }

    /**
     * Test method <code>boolean isExpanded()  </code>.
     */
    public void testIsExpanded() {
        assertTrue("The default is true.", model.isExpanded());
    }

    /**
     * Test metho dsetexpanded.
     */
    public void testSetExpanded() {
        model.setExpanded(false);

        assertFalse(model.isExpanded());
    }

    /**
     * Test method getTitle.
     */
    public void testGetTitle() {
        assertEquals("Equal to empty string.", "", model.getTitle());
    }

    /**
     * Test method setTitle.
     */
    public void testSetTitle() {
        model.setTitle("title");
        assertEquals("Equal to title.", "title", model.getTitle());
    }

    /**
     * Test method isVertical.
     */
    public void testIsVertical() {
        assertTrue(model.isVertical());
    }

    /**
     * Test method setVertical.
     */
    public void testSetVertical() {
        model.setVertical(false);

        assertFalse(model.isVertical());
    }

    /**
     * Test method boolean isExpandToFill().
     */
    public void testIsExpandToFill() {
        assertFalse(model.isExpandToFill());
    }

    /**
     * Test method <code>setExpandToFill(boolean expandToFill) </code>.
     */
    public void testSetExpandToFill() {
        model.setExpandToFill(true);

        assertTrue(model.isExpandToFill());
    }
}
