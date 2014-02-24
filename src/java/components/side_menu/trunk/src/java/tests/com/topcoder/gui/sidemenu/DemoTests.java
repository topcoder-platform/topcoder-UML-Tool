/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu;

import java.awt.BorderLayout;
import java.awt.Container;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import junit.framework.TestCase;

/**
 * <p>
 * This is the Demo test for Side Menu component.
 * </p>
 *
 * @author KingStone
 * @version 1.0
 */
public class DemoTests extends TestCase {
    /**
     * A very simple demo.
     */
    public void testDemo1() {
        // Assume there is a panel called appPanel that the side menu will be added to
        // (on the west side via BorderLayout) and we have an icon for both the expanded
        // buttons and collapse buttons
        JFrame frame = new JFrame("Side Menu Demo");
        final Container appPane = frame.getContentPane();

        // assume there is a tools panel, here we simply use an empty panel.
        JPanel toolsPanel = new JPanel();

        // Create the side menu for it
        SideMenuPanel smp = new SideMenuPanel("Tools", toolsPanel, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON);

        // Set the width to 100
        smp.setAbsoluteWidth(100);

        // Start it in an expanded state
        smp.setExpanded(true);

        // Add it to our panel
        appPane.add(smp, BorderLayout.WEST);
    }

    /**
     * Visual Studio has a 'collapsed' panel that will expand when clicked and the panel can be
     * pinned or floating. The following demo will provide a look that is similar.
     */
    public void testDemo2() {
        JFrame frame = new JFrame("Side Menu Demo");
        final Container appPane = frame.getContentPane();

        // Create a side menu model with a title of tools, expanded
        // with not-floating panel (when expanded) with a size of 100
        SideMenuModel smm = new DefaultSideMenuModel("Tools", true, false, 100);

        // Setup the default collapsed panel using the above model
        // with no expansion buttons and setting click to expand to true
        DefaultCollapsedSideMenuPanel dcp = new DefaultCollapsedSideMenuPanel(smm, null, true);

        // assume there is a tools panel, here we simply use an empty panel.
        JPanel toolsPanel = new JPanel();

        // Setup the default expansion panel using the above model
        // with no expansion buttons and setting click to expand to true
        DefaultExpandedSideMenuPanel dep = new DefaultExpandedSideMenuPanel(smm, toolsPanel,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);

        // Create the side menu for it
        SideMenuPanel smp = new SideMenuPanel(smm, dcp, dep);

        // Add it to our panel
        appPane.add(smp, BorderLayout.CENTER);
    }

    /**
     * The Side Menu Model can be used to perform custom actions when the menu is expanded or
     * collapsed.
     */
    public void testDemo3() {
        // assume there is a tools panel, here we simply use an empty panel.
        JPanel toolsPanel = new JPanel();

        // Create the side menu for it
        SideMenuPanel smp = new SideMenuPanel("Tools", toolsPanel, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON);

        // Add a handler for expanded events
        smp.getSideMenuModel().addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                // If expansion changed - notify an application class
                if (evt.getPropertyName().equals(SideMenuModel.EXPANDED)) {
                    // assume appNotification is the controller of application
                    // toolsExpanded is a method deal with tools expanded event
                    // appNotification.toolsExpanded(evt.getNewValue());
                }
            }
        });
    }
}
