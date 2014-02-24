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
import com.topcoder.gui.sectionlayout.SectionHeader;
import com.topcoder.gui.sectionlayout.ui.DefaultSectionHeaderUI;

/**
 * <p>
 * Failure test for <code>SectionHeader</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class SectionHeaderFailureTest extends TestCase {

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        UIManager.put("SectionHeaderUI", "com.topcoder.gui.sectionlayout.ui.DefaultSectionHeaderUI");
        UIManager.put(DefaultSectionHeaderUI.class,
                DefaultSectionHeaderUI.class.getDeclaredMethod("createUI", new Class[]{JComponent.class}));
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
    }

    /**
     * <p>
     * Tears down test environment.
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
     * the section is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSectionHeaderA() {
        try {
            new SectionHeader(null, new SectionModelImpl());
            fail("the section is null, IllegalArgumentException is expected.");
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
     * the model is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSectionHeaderB() {
        try {
            new SectionHeader(new Section(new JPanel()), null);
            fail("the model is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
