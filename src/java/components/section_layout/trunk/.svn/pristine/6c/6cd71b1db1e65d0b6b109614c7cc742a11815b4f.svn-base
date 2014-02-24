/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit test cases for <code>DefaultSectionModel</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultSectionModelTests extends TestCase {

    /**
     * <p>
     * The DefaultSectionModel instance for helping testing.
     * </p>
     */
    private DefaultSectionModel model;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        model = new DefaultSectionModel();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        model = null;
    }

    /**
     * <p>
     * Return the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DefaultSectionModelTests.class);
    }

    /**
     * <p>
     * Tests DefaultSectionModel#DefaultSectionModel() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionModel#DefaultSectionModel() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor() throws Exception {
        assertNotNull("The newly created DefaultSectionModel should not be null.", model);
    }

    /**
     * <p>
     * Tests DefaultSectionModel#isFloating() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionModel#isFloating() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testIsFloating() throws Exception {
        assertFalse("The model should not be floating.", model.isFloating());
        model.setFloating(true);
        assertTrue("The model should be floating.", model.isFloating());
    }

    /**
     * <p>
     * Tests DefaultSectionModel#setFloating(boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionModel#setFloating(boolean) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetFloating() throws Exception {
        assertFalse("The model should not be floating.", model.isFloating());
        model.setFloating(true);
        assertTrue("The model should be floating.", model.isFloating());
    }

    /**
     * <p>
     * Tests DefaultSectionModel#isExpanded() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionModel#isExpanded() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testIsExpanded() throws Exception {
        assertTrue("The model should be expanded.", model.isExpanded());
        model.setExpanded(false);
        assertFalse("The model should not be expanded.", model.isExpanded());
    }

    /**
     * <p>
     * Tests DefaultSectionModel#setExpanded(boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionModel#setExpanded(boolean) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetExpanded() throws Exception {
        assertTrue("The model should be expanded.", model.isExpanded());
        model.setExpanded(false);
        assertFalse("The model should not be expanded.", model.isExpanded());
    }

    /**
     * <p>
     * Tests DefaultSectionModel#getTitle() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionModel#getTitle() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetTitle() throws Exception {
        assertEquals("The model's title should be empty string.", "", model.getTitle());
        model.setTitle("title");
        assertEquals("The model's title should be \"title\".", "title", model.getTitle());
    }

    /**
     * <p>
     * Tests DefaultSectionModel#setTitle(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionModel#setTitle(String) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTitle() throws Exception {
        assertEquals("The model's title should be empty string.", "", model.getTitle());
        model.setTitle("title");
        assertEquals("The model's title should be \"title\".", "title", model.getTitle());
    }

    /**
     * <p>
     * Tests DefaultSectionModel#setTitle(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTitle_Null() throws Exception {
        try {
            model.setTitle(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultSectionModel#isVertical() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionModel#isVertical() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testIsVertical() throws Exception {
        assertTrue("The model should be vertical.", model.isVertical());
        model.setVertical(false);
        assertFalse("The model should not be vertical.", model.isVertical());
    }

    /**
     * <p>
     * Tests DefaultSectionModel#setVertical(boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionModel#setVertical(boolean) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetVertical() throws Exception {
        assertTrue("The model should be vertical.", model.isVertical());
        model.setVertical(false);
        assertFalse("The model should not be vertical.", model.isVertical());
    }

    /**
     * <p>
     * Tests DefaultSectionModel#isExpandToFill() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionModel#isExpandToFill() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testIsExpandToFill() throws Exception {
        assertFalse("The model should not be expandToFill.", model.isExpandToFill());
        model.setExpandToFill(true);
        assertTrue("The model should be expandToFill.", model.isExpandToFill());
    }

    /**
     * <p>
     * Tests DefaultSectionModel#setExpandToFill(boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultSectionModel#setExpandToFill(boolean) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetExpandToFill() throws Exception {
        assertFalse("The model should not be expandToFill.", model.isExpandToFill());
        model.setExpandToFill(true);
        assertTrue("The model should be expandToFill.", model.isExpandToFill());
    }
}
