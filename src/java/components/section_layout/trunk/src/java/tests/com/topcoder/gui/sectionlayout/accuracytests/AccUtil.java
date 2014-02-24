/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.accuracytests;

import com.topcoder.gui.sectionlayout.ui.DefaultSectionHeaderUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.UIManager;


/**
 * A helper class for testing.
 *
 * @author Chenhong
 * @version 1.0
 */
final class AccUtil {
    /**
     * Private ctor.
     */
    private AccUtil() {
        // Empty
    }

    /**
     * <p>
     * Configues the UIManager.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public static void configUIManager() throws Exception {
        // set properties
        UIManager.put("SectionHeaderUI", "com.topcoder.gui.sectionlayout.ui.DefaultSectionHeaderUI");
        UIManager.put(DefaultSectionHeaderUI.class,
            DefaultSectionHeaderUI.class.getDeclaredMethod("createUI", new Class[] { JComponent.class }));
        UIManager.put("SectionHeader.font", new Font("Arial", Font.BOLD, 10));
        UIManager.put("SectionHeader.expandedHeaderForeGroundColor", Color.blue);
        UIManager.put("SectionHeader.contractedHeaderForeGroundColor", Color.red);
        UIManager.put("SectionHeader.dragAreaLeftX", new Integer(5));
        UIManager.put("SectionHeader.dragAreaUpperY", new Integer(5));
        UIManager.put("SectionHeader.dragAreaWidth", new Integer(1000));
        UIManager.put("SectionHeader.dragAreaHeight", new Integer(3000));
        UIManager.put("SectionHeader.expandedIcon", new ImageIcon("./test_files/acc_files/icon.png"));
        UIManager.put("SectionHeader.contractedIcon", new ImageIcon("./test_files/acc_files/3690.png"));
        UIManager.put("SectionHeader.iconX", new Integer(500));
        UIManager.put("SectionHeader.iconY", new Integer(500));
        UIManager.put("SectionHeader.titleX", new Integer(150));
        UIManager.put("SectionHeader.titleY", new Integer(150));
        UIManager.put("SectionHeader.expandedBgLeftIcon", new ImageIcon("./test_files/acc_files/3690.png"));
        UIManager.put("SectionHeader.expandedBgRightIcon", new ImageIcon("./test_files/acc_files/test2.jpg"));
        UIManager.put("SectionHeader.expandedBgMidIcon", new ImageIcon("./test_files/acc_files/test0.png"));

        UIManager.put("SectionHeader.contractedBgLeftIcon", new ImageIcon("./test_files/acc_files/3690.png"));
        UIManager.put("SectionHeader.contractedBgRightIcon", new ImageIcon("./test_files/acc_files/test2.jpg"));
        UIManager.put("SectionHeader.contractedBgMidIcon", new ImageIcon("./test_files/acc_files/test0.png"));
    }
}
