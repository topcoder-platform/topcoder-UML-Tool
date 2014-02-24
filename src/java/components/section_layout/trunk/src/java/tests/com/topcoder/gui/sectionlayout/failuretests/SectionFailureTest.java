/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.failuretests;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.UIManager;

import junit.framework.TestCase;

import com.topcoder.gui.sectionlayout.Section;

/**
 * <p>
 * Failure test for <code>Section</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class SectionFailureTest extends TestCase {

    /**
     * <p>
     * The Section instance for testing.
     * </p>
     */
    private Section section;

    /**
     * <p>
     * The JFrame instance for testing.
     * </p>
     */
    private JComponent component;

    /**
     * <p>
     * Set up the testing environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Font font = new Font("Dialog", Font.PLAIN, 10);
        Icon icon1 = new ImageIcon();
        Icon icon2 = new ImageIcon();
        UIManager.put("SectionHeader.font", font);
        UIManager.put("SectionHeader.expandedHeaderForeGroundColor", Color.GRAY);
        UIManager.put("SectionHeader.contractedHeaderForeGroundColor", Color.ORANGE);
        UIManager.put("SectionHeader.height", 100);
        UIManager.put("SectionHeader.dragAreaLeftX", 20);
        UIManager.put("SectionHeader.dragAreaUpperY", 20);
        UIManager.put("SectionHeader.dragAreaWidth", 50);
        UIManager.put("SectionHeader.dragAreaHeight", 50);
        UIManager.put("SectionHeader.expandedIcon", icon1);
        UIManager.put("SectionHeader.contractedIcon", icon2);
        UIManager.put("SectionHeader.iconX", 0);
        UIManager.put("SectionHeader.iconY", 0);
        UIManager.put("SectionHeader.titleX", 0);
        UIManager.put("SectionHeader.titleY", 0);
        UIManager.put("SectionHeader.expandedBgLeftIcon", icon1);
        UIManager.put("SectionHeader.expandedBgRightIcon", icon1);
        UIManager.put("SectionHeader.expandedBgMidIcon", icon1);
        UIManager.put("SectionHeader.contractedBgLeftIcon", icon1);
        UIManager.put("SectionHeader.contractedBgRightIcon", icon1);
        UIManager.put("SectionHeader.contractedBgMidIcon", icon1);
        component = new JPanel();
        section = new Section(component);
    }

    /**
     * <p>
     * Tear Down the testing environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        // empty
    }

    /**
     * <p>
     * Test for the constructor.
     * </p>
     *
     * <p>
     * the width is 0, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetSizeIntIntA() {
        try {
            section.setSize(0, 10);
            fail("the width is 0, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the constructor.
     * </p>
     *
     * <p>
     * the height is 0, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetSizeIntIntB() {
        try {
            section.setSize(10, 0);
            fail("the height is 0, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the constructor.
     * </p>
     *
     * <p>
     * the width is 0, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetSizeIntIntC() {
        try {
            section.setSize(-1, 10);
            fail("the width is -1, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the constructor.
     * </p>
     *
     * <p>
     * the height is 0, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetSizeIntIntD() {
        try {
            section.setSize(10, -1);
            fail("the height is -1, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the constructor.
     * </p>
     *
     * <p>
     * the component is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSectionComponent() {
        try {
            new Section(null);
            fail("the component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the constructor.
     * </p>
     *
     * <p>
     * the component is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSectionComponentBoolean() {
        try {
            new Section(null, false);
            fail("the component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the constructor.
     * </p>
     *
     * <p>
     * the component is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSectionComponentBooleanBoolean() {
        try {
            new Section(null, false, false);
            fail("the component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>setTitle(String title)</code>.
     * </p>
     *
     * <p>
     * the title is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetTitle() {
        try {
            section.setTitle(null);
            fail("the title is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>addExpandContractListener(SectionExpandContractListener listener)</code>.
     * </p>
     *
     * <p>
     * the listener is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddExpandContractListener() {
        try {
            section.addExpandContractListener(null);
            fail("the listener is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>removeExpandContractListener(SectionExpandContractListener listener)</code>.
     * </p>
     *
     * <p>
     * the listener is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveExpandContractListener() {
        try {
            section.removeExpandContractListener(null);
            fail("the listener is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

}
