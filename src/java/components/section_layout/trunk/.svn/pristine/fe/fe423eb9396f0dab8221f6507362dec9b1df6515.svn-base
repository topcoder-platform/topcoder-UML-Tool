/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.stresstests;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.UIManager;

import com.topcoder.gui.sectionlayout.ui.DefaultSectionHeaderUI;

/**
 * <p>
 * Helper class for stress testing.
 * </p>
 *
 * @author extra
 * @version 1.0
 */
public final class StressTestHelper {

    /**
     * <p>
     * Private constructor.
     * </p>
     */
    private StressTestHelper() {
    }

    /**
     * <p>
     * Configure the UIManager.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    public static void configUIManager() throws Exception {
        ImageIcon icon = new ImageIcon();
        // set properties
        UIManager.put("SectionHeaderUI", DefaultSectionHeaderUI.class.getName());
        UIManager.put(DefaultSectionHeaderUI.class,
                DefaultSectionHeaderUI.class.getDeclaredMethod("createUI", new Class[]{JComponent.class}));
//        UIManager.put(DefaultSectionHeaderUI.class,
//                DefaultSectionHeaderUI.class.getDeclaredMethod("createUI"));
        UIManager.put("SectionHeader.font", new Font("Arial", Font.BOLD, 11));
        UIManager.put("SectionHeader.expandedHeaderForeGroundColor", Color.BLUE);
        UIManager.put("SectionHeader.contractedHeaderForeGroundColor", Color.RED);
        UIManager.put("SectionHeader.height", 100);
        UIManager.put("SectionHeader.dragAreaLeftX", new Integer(5));
        UIManager.put("SectionHeader.dragAreaUpperY", new Integer(5));
        UIManager.put("SectionHeader.dragAreaWidth", new Integer(1000));
        UIManager.put("SectionHeader.dragAreaHeight", new Integer(1000));
        UIManager.put("SectionHeader.expandedIcon", icon);
        UIManager.put("SectionHeader.contractedIcon", icon);
        UIManager.put("SectionHeader.iconX", new Integer(50));
        UIManager.put("SectionHeader.iconY", new Integer(50));
        UIManager.put("SectionHeader.titleX", new Integer(200));
        UIManager.put("SectionHeader.titleY", new Integer(200));
        UIManager.put("SectionHeader.expandedBgLeftIcon", icon);
        UIManager.put("SectionHeader.expandedBgRightIcon", icon);
        UIManager.put("SectionHeader.expandedBgMidIcon", icon);
        UIManager.put("SectionHeader.contractedBgLeftIcon", icon);
        UIManager.put("SectionHeader.contractedBgRightIcon", icon);
        UIManager.put("SectionHeader.contractedBgMidIcon", icon);
    }
}
