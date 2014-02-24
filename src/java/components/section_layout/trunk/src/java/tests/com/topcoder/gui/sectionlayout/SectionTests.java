/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.lang.reflect.Field;

import javax.swing.JPanel;

import com.topcoder.gui.sectionlayout.dock.DragInitListener;
import com.topcoder.gui.sectionlayout.dock.MockDragInitListener;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit test cases for <code>Section</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SectionTests extends TestCase {

    /**
     * <p>
     * The DragInitListener instance for helping testing.
     * </p>
     */
    private DragInitListener dragInitListener;

    /**
     * <p>
     * The SectionExpandContractListener instance for helping testing.
     * </p>
     */
    private SectionExpandContractListener expandContractListener;

    /**
     * <p>
     * The Component instance for helping testing.
     * </p>
     */
    private Component component;

    /**
     * <p>
     * The Section instance for helping testing.
     * </p>
     */
    private Section section;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.configUIManager();

        dragInitListener = new MockDragInitListener();
        expandContractListener = new MockSectionExpandContractListener();
        component = new JPanel();
        section = new Section(component);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        dragInitListener = null;
        expandContractListener = null;
        component = null;
        section = null;
    }

    /**
     * <p>
     * Return the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(SectionTests.class);
    }

    /**
     * <p>
     * Tests Section#Section(Component) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#Section(Component) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1() throws Exception {
        assertNotNull("The newly created Section should not be null.", section);
        Field field = Section.class.getDeclaredField("component");
        field.setAccessible(true);
        assertEquals("The component should be equal.", component, field.get(section));
        assertTrue("The section should be vertical.", section.isVertical());
        assertTrue("The section should be expanded.", section.isExpanded());
    }

    /**
     * <p>
     * Tests Section#Section(Component) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_Null() throws Exception {
        try {
            new Section(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Section#Section(Component, boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#Section(Component, boolean) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor2() throws Exception {
        section = new Section(component, false);
        assertNotNull("The newly created Section should not be null.", section);
        Field field = Section.class.getDeclaredField("component");
        field.setAccessible(true);
        assertEquals("The component should be equal.", component, field.get(section));
        assertFalse("The section should not be vertical.", section.isVertical());
        assertTrue("The section should be expanded.", section.isExpanded());
    }

    /**
     * <p>
     * Tests Section#Section(Component, boolean) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor2_Null() throws Exception {
        try {
            new Section(null, false);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Section#Section(Component, boolean, boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#Section(Component, boolean, boolean) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor3() throws Exception {
        section = new Section(component, false, false);
        assertNotNull("The newly created Section should not be null.", section);
        Field field = Section.class.getDeclaredField("component");
        field.setAccessible(true);
        assertEquals("The component should be equal.", component, field.get(section));
        assertFalse("The section should not be vertical.", section.isVertical());
        assertFalse("The section should not be expanded.", section.isExpanded());
    }

    /**
     * <p>
     * Tests Section#Section(Component, boolean, boolean) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor3_Null() throws Exception {
        try {
            new Section(null, false, false);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Section#isFloating() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#isFloating() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testIsFloating() throws Exception {
        assertFalse("The section should not be floating.", section.isFloating());
        section.setFloating(true);
        assertTrue("The section should be floating.", section.isFloating());
    }

    /**
     * <p>
     * Tests Section#setFloating(boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#setFloating(boolean) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetFloating() throws Exception {
        assertFalse("The section should not be floating.", section.isFloating());
        section.setFloating(true);
        assertTrue("The section should be floating.", section.isFloating());
    }

    /**
     * <p>
     * Tests Section#isExpanded() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#isExpanded() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testIsExpanded() throws Exception {
        assertTrue("The section should be expanded.", section.isExpanded());
        section.setExpanded(false);
        assertFalse("The section should not be expanded.", section.isExpanded());
    }

    /**
     * <p>
     * Tests Section#setExpanded(boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#setExpanded(boolean) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetExpanded() throws Exception {
        assertTrue("The section should be expanded.", section.isExpanded());
        section.setExpanded(false);
        assertFalse("The section should not be expanded.", section.isExpanded());
    }

    /**
     * <p>
     * Tests Section#getTitle() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#getTitle() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetTitle() throws Exception {
        assertEquals("The section's title should be empty string.", "", section.getTitle());
        section.setTitle("title");
        assertEquals("The section's title should be \"title\".", "title", section.getTitle());
    }

    /**
     * <p>
     * Tests Section#setTitle(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#setTitle(String) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTitle() throws Exception {
        assertEquals("The section's title should be empty string.", "", section.getTitle());
        section.setTitle("title");
        assertEquals("The section's title should be \"title\".", "title", section.getTitle());
    }

    /**
     * <p>
     * Tests Section#setTitle(String) for failure.
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
            section.setTitle(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Section#isVertical() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#isVertical() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testIsVertical() throws Exception {
        assertTrue("The section should be vertical.", section.isVertical());
        section.setVertical(false);
        assertFalse("The section should not be vertical.", section.isVertical());
    }

    /**
     * <p>
     * Tests Section#setVertical(boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#setVertical(boolean) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetVertical() throws Exception {
        assertTrue("The section should be vertical.", section.isVertical());
        section.setVertical(false);
        assertFalse("The section should not be vertical.", section.isVertical());
    }

    /**
     * <p>
     * Tests Section#isExpandToFill() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#isExpandToFill() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testIsExpandToFill() throws Exception {
        assertFalse("The section should not be expandToFill.", section.isExpandToFill());
        section.setExpandToFill(true);
        assertTrue("The section should be expandToFill.", section.isExpandToFill());
    }

    /**
     * <p>
     * Tests Section#setExpandToFill(boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#setExpandToFill(boolean) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetExpandToFill() throws Exception {
        assertFalse("The section should not be expandToFill.", section.isExpandToFill());
        section.setExpandToFill(true);
        assertTrue("The section should be expandToFill.", section.isExpandToFill());
    }

    /**
     * <p>
     * Tests Section#setSize(int, int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#setSize(int, int) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetSize() throws Exception {
        section.setSize(3, 5);
        assertEquals("The section's size should be equal.", 3, section.getPreferredSize().width);
        assertEquals("The section's size should be equal.", 5, section.getPreferredSize().height);
    }

    /**
     * <p>
     * Tests Section#setSize(int, int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when width is not positive and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetSize_Width_NotPositive() throws Exception {
        try {
            section.setSize(0, 5);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Section#setSize(int, int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when height is not positive and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetSize_Height_NotPositive() throws Exception {
        try {
            section.setSize(3, -5);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Section#getMaximumSize() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#getMaximumSize() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetMaximumSize() throws Exception {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        section.setExpandToFill(true);
        section.setExpanded(true);
        assertEquals("The size should be equal.", screenSize.width, section.getMaximumSize().width);
        assertEquals("The size should be equal.", screenSize.height, section.getMaximumSize().height);
        section.setExpanded(false);
        section.setVertical(true);
        assertEquals("The size should be equal.", screenSize.width, section.getMaximumSize().width);
        assertEquals("The size should be equal.", section.getPreferredSize().height, section.getMaximumSize().height);
        section.setVertical(false);
        assertEquals("The size should be equal.", section.getPreferredSize().width, section.getMaximumSize().width);
        assertEquals("The size should be equal.", screenSize.height, section.getMaximumSize().height);
    }

    /**
     * <p>
     * Tests Section#getMinimumSize() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#getMinimumSize() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetMinimumSize() throws Exception {
        assertEquals("The size should be equal.", section.getPreferredSize().width, section.getMinimumSize().width);
        assertEquals("The size should be equal.", section.getPreferredSize().height, section.getMinimumSize().height);
    }

    /**
     * <p>
     * Tests Section#getDockType() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#getDockType() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDockType() throws Exception {
        assertEquals("The dock type should be equal.", Section.DOCK_TYPE, section.getDockType());
    }

    /**
     * <p>
     * Tests Section#getDockableComponent() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#getDockableComponent() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDockableComponent() throws Exception {
        assertEquals("The dockable component should be equal.", section, section.getDockableComponent());
    }

    /**
     * <p>
     * Tests Section#setDragInitListener(DragInitListener) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#setDragInitListener(DragInitListener) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetDragInitListener() throws Exception {
        assertNull("The dragInitListener should be Null.", section.getDragInitListener());
        section.setDragInitListener(dragInitListener);
        assertEquals("The dragInitListener should be equal.", dragInitListener, section.getDragInitListener());
        section.setDragInitListener(null);
        assertNull("The dragInitListener should be Null.", section.getDragInitListener());
    }

    /**
     * <p>
     * Tests Section#getDragInitListener() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#getDragInitListener() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDragInitListener() throws Exception {
        assertNull("The dragInitListener should be Null.", section.getDragInitListener());
        section.setDragInitListener(dragInitListener);
        assertEquals("The dragInitListener should be equal.", dragInitListener, section.getDragInitListener());
        section.setDragInitListener(null);
        assertNull("The dragInitListener should be Null.", section.getDragInitListener());
    }

    /**
     * <p>
     * Tests Section#addExpandContractListener(SectionExpandContractListener) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#addExpandContractListener(SectionExpandContractListener) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddExpandContractListener() throws Exception {
        assertNotNull("The listeners should not be null.", section.getExpandContractListeners());
        assertEquals("The listeners' size should be 0.", 0, section.getExpandContractListeners().size());
        section.addExpandContractListener(expandContractListener);
        assertEquals("The listeners' size should be 1.", 1, section.getExpandContractListeners().size());
    }

    /**
     * <p>
     * Tests Section#addExpandContractListener(SectionExpandContractListener) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddExpandContractListener_Null() throws Exception {
        try {
            section.addExpandContractListener(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Section#removeExpandContractListener(SectionExpandContractListener) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#removeExpandContractListener(SectionExpandContractListener) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRemoveExpandContractListener() throws Exception {
        assertNotNull("The listeners should not be null.", section.getExpandContractListeners());
        assertEquals("The listeners' size should be 0.", 0, section.getExpandContractListeners().size());
        section.addExpandContractListener(expandContractListener);
        assertEquals("The listeners' size should be 1.", 1, section.getExpandContractListeners().size());
        section.removeExpandContractListener(expandContractListener);
        assertEquals("The listeners' size should be 0.", 0, section.getExpandContractListeners().size());
    }

    /**
     * <p>
     * Tests Section#removeExpandContractListener(SectionExpandContractListener) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRemoveExpandContractListener_Null() throws Exception {
        try {
            section.removeExpandContractListener(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Section#getExpandContractListeners() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#getExpandContractListeners() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetExpandContractListeners() throws Exception {
        assertNotNull("The listeners should not be null.", section.getExpandContractListeners());
        assertEquals("The listeners' size should be 0.", 0, section.getExpandContractListeners().size());
        section.addExpandContractListener(expandContractListener);
        assertEquals("The listeners' size should be 1.", 1, section.getExpandContractListeners().size());
        section.removeExpandContractListener(expandContractListener);
        assertEquals("The listeners' size should be 0.", 0, section.getExpandContractListeners().size());
    }

    /**
     * <p>
     * Tests Section#propertyChange(PropertyChangeEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#propertyChange(PropertyChangeEvent) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPropertyChange() throws Exception {
        section.addExpandContractListener(expandContractListener);
        PropertyChangeEvent event = new PropertyChangeEvent(this, "title", "old", "new");
        section.setExpanded(true);
        section.propertyChange(event);
        assertTrue("The section should be expanded.",
                ((MockSectionExpandContractListener) expandContractListener).getExpanded());
        section.setExpanded(false);
        section.propertyChange(event);
        assertFalse("The section should be contracted.",
                ((MockSectionExpandContractListener) expandContractListener).getExpanded());
    }

    /**
     * <p>
     * Tests Section#fireExpanded() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#fireExpanded() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFireExpanded() throws Exception {
        section.addExpandContractListener(expandContractListener);
        section.fireExpanded();
        assertTrue("The section should be expanded.",
                ((MockSectionExpandContractListener) expandContractListener).getExpanded());
    }

    /**
     * <p>
     * Tests Section#fireContracted() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the Section#fireContracted() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFireContracted() throws Exception {
        section.addExpandContractListener(expandContractListener);
        section.fireContracted();
        assertFalse("The section should be contracted.",
                ((MockSectionExpandContractListener) expandContractListener).getExpanded());
    }
}
