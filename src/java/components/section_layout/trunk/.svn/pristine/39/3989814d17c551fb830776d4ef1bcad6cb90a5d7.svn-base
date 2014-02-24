/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock.dndimpl;

import java.awt.Component;

import javax.swing.JPanel;

import com.topcoder.gui.sectionlayout.dock.DragInitListener;
import com.topcoder.gui.sectionlayout.dock.MockDragInitListener;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit test cases for <code>DockableWrapper</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DockableWrapperTests extends TestCase {

    /**
     * <p>
     * The DragInitListener instance for helping testing.
     * </p>
     */
    private DragInitListener listener;

    /**
     * <p>
     * The Component instance for helping testing.
     * </p>
     */
    private Component component;

    /**
     * <p>
     * The DockableWrapper instance for helping testing.
     * </p>
     */
    private DockableWrapper wrapper;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        listener = new MockDragInitListener();
        component = new JPanel();
        wrapper = new DockableWrapper(component);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        listener = null;
        component = null;
        wrapper = null;
    }

    /**
     * <p>
     * Return the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DockableWrapperTests.class);
    }

    /**
     * <p>
     * Tests DockableWrapper#DockableWrapper(Component) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockableWrapper#DockableWrapper(Component) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor() throws Exception {
        assertNotNull("The newly created DockableWrapper should not be null.", wrapper);
        assertFalse("The wrapper should not be floating.", wrapper.isFloating());
    }

    /**
     * <p>
     * Tests DockableWrapper#DockableWrapper(Component) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Null() throws Exception {
        try {
            new DockableWrapper(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DockableWrapper#getDockableComponent() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockableWrapper#getDockableComponent() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDockableComponent() throws Exception {
        assertEquals("The dockable component should not be equal.", wrapper, wrapper.getDockableComponent());
    }

    /**
     * <p>
     * Tests DockableWrapper#setDragInitListener(DragInitListener) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockableWrapper#setDragInitListener(DragInitListener) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetDragInitListener() throws Exception {
        try {
            wrapper.setDragInitListener(listener);
            wrapper.setDragInitListener(null);
        } catch (IllegalArgumentException e) {
            fail("IAE should not be thrown.");
        }
    }

    /**
     * <p>
     * Tests DockableWrapper#getDockType() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockableWrapper#getDockType() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDockType() throws Exception {
        assertEquals("The dock type should not be equal.",
                DockableWrapper.class.getSimpleName(), wrapper.getDockType());
    }

    /**
     * <p>
     * Tests DockableWrapper#isFloating() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockableWrapper#isFloating() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testIsFloating() throws Exception {
        assertFalse("The wrapper should not be floating.", wrapper.isFloating());
        wrapper.setFloating(true);
        assertTrue("The wrapper should be floating.", wrapper.isFloating());
    }

    /**
     * <p>
     * Tests DockableWrapper#setFloating(boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockableWrapper#setFloating(boolean) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetFloating() throws Exception {
        assertFalse("The wrapper should not be floating.", wrapper.isFloating());
        wrapper.setFloating(true);
        assertTrue("The wrapper should be floating.", wrapper.isFloating());
    }
}
