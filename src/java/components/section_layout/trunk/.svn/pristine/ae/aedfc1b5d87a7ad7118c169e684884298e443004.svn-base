/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.UIManager;

import com.topcoder.gui.sectionlayout.ui.DefaultSectionHeaderUI;

/**
 * <p>
 * Helper class for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class TestHelper {

    /**
     * <p>
     * Creates a new instance of <code>TestHelper</code> class.
     * Private empty constructor to prevent instantiation.
     * </p>
     */
    private TestHelper() {
        // empty
    }

    /**
     * <p>
     * Configues the UIManager.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    public static void configUIManager() throws Exception {
        // set properties
        UIManager.put("SectionHeaderUI", "com.topcoder.gui.sectionlayout.ui.DefaultSectionHeaderUI");
        UIManager.put(DefaultSectionHeaderUI.class,
                DefaultSectionHeaderUI.class.getDeclaredMethod("createUI", new Class[]{JComponent.class}));
        UIManager.put("SectionHeader.font", new Font("Arial", Font.BOLD, 10));
        UIManager.put("SectionHeader.height", new Integer(50));
        UIManager.put("SectionHeader.expandedHeaderForeGroundColor", Color.blue);
        UIManager.put("SectionHeader.contractedHeaderForeGroundColor", Color.red);
        UIManager.put("SectionHeader.dragAreaLeftX", new Integer(50));
        UIManager.put("SectionHeader.dragAreaUpperY", new Integer(5));
        UIManager.put("SectionHeader.dragAreaWidth", new Integer(100));
        UIManager.put("SectionHeader.dragAreaHeight", new Integer(30));
        UIManager.put("SectionHeader.expandedIcon", new ImageIcon("./test_files/expand.jpg"));
        UIManager.put("SectionHeader.contractedIcon", new ImageIcon("./test_files/contract.jpg"));
        UIManager.put("SectionHeader.iconX", new Integer(5));
        UIManager.put("SectionHeader.iconY", new Integer(5));
        UIManager.put("SectionHeader.titleX", new Integer(50));
        UIManager.put("SectionHeader.titleY", new Integer(15));
        UIManager.put("SectionHeader.expandedBgLeftIcon", new ImageIcon("./test_files/expand_left.png"));
        UIManager.put("SectionHeader.expandedBgRightIcon", new ImageIcon("./test_files/expand_right.png"));
        UIManager.put("SectionHeader.expandedBgMidIcon", new ImageIcon("./test_files/expand_fill.png"));
        UIManager.put("SectionHeader.contractedBgLeftIcon", new ImageIcon("./test_files/contract_left.png"));
        UIManager.put("SectionHeader.contractedBgRightIcon", new ImageIcon("./test_files/contract_right.png"));
        UIManager.put("SectionHeader.contractedBgMidIcon", new ImageIcon("./test_files/contract_fill.png"));
    }
}
