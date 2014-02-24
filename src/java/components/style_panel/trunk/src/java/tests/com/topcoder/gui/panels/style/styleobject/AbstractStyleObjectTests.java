/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.styleobject;

import com.topcoder.gui.panels.style.StylePanel;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AbstractStyleObject.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AbstractStyleObjectTests extends TestCase {

    /**
     * <p>
     * The MockAbstractStyleObject instance for testing.
     * </p>
     */
    private MockAbstractStyleObject styleObject;

    /**
     * <p>
     * The StylePanel instance for testing.
     * </p>
     */
    private StylePanel stylePanel;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        styleObject = new MockAbstractStyleObject();
        stylePanel = new StylePanel();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        stylePanel = null;
        styleObject = null;

    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(AbstractStyleObjectTests.class);
    }

    /**
     * <p>
     * Tests ctor AbstractStyleObject#AbstractStyleObject() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created AbstractStyleObject instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new AbstractStyleObject instance.", styleObject);
    }

    /**
     * <p>
     * Tests AbstractStyleObject#getStylePanel() for accuracy.
     * </p>
     *
     * <p>
     * Verify : AbstractStyleObject#getStylePanel() is correct.
     * </p>
     */
    public void testGetStylePanel() {
        styleObject.setStylePanel(stylePanel);
        assertSame("The return style panel is not correct.", stylePanel, styleObject.getStylePanel());
    }

    /**
     * <p>
     * Tests AbstractStyleObject#setStylePanel(StylePanel) for accuracy.
     * </p>
     *
     * <p>
     * Verify : AbstractStyleObject#setStylePanel(StylePanel) is correct when the
     * style panel is not null.
     * </p>
     */
    public void testSetStylePanel() {
        styleObject.setStylePanel(stylePanel);
        assertSame("The style panel is not set correctly.", stylePanel, styleObject.getStylePanel());
    }

    /**
     * <p>
     * Tests AbstractStyleObject#setStylePanel(StylePanel) for accuracy.
     * </p>
     *
     * <p>
     * Verify : AbstractStyleObject#setStylePanel(StylePanel) is correct when the
     * style panel is null.
     * </p>
     */
    public void testSetStylePanel_NullStylePanel() {
        styleObject.setStylePanel(null);
        assertNull("The style panel is not set correctly.", styleObject.getStylePanel());
    }

}