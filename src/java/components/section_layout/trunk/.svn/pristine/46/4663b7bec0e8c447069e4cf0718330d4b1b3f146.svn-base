/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.failuretests;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.UIManager;

import junit.framework.TestCase;

import com.topcoder.gui.sectionlayout.Section;
import com.topcoder.gui.sectionlayout.SectionHeader;
import com.topcoder.gui.sectionlayout.ui.DefaultSectionHeaderUI;

/**
 * <p>
 * Failure test for <code>DefaultSectionHeaderUI</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class DefaultSectionHeaderUIFailureTest extends TestCase {

    /**
     * <p>
     * The DefaultSectionHeaderUI instance for testing.
     * </p>
     */
    private DefaultSectionHeaderUI header;

    /**
     * <p>
     * The SectionHeader instance for testing.
     * </p>
     */
    private SectionHeader sectionHeader;

    /**
     * <p>
     * Sets up testing environment.
     * </p>
     *
     * @throws Exception to JUnit
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
        header = new DefaultSectionHeaderUI();
        sectionHeader = new SectionHeader(new Section(new JPanel()), new SectionModelImpl());
    }

    /**
     * <p>
     * Tear down the testing environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        // empty
    }

    /**
     * <p>
     * Test for the <code>installUI(JComponent component)</code>.
     * </p>
     *
     * <p>
     * the component is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testInstallUIJComponentNull() {
        try {
            header.installUI(null);
            fail("the component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>installUI(JComponent component)</code>.
     * </p>
     *
     * <p>
     * the component is of type JButton, IllegalArgumentException is expected.
     * </p>
     */
    public void testInstallUIJComponentInvalid() {
        try {
            header.installUI(new JButton("test"));
            fail("the component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>uninstallUI(JComponent component)</code>.
     * </p>
     *
     * <p>
     * the component is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testUninstallUIJComponent() {
        try {
            header.uninstallUI(null);
            fail("the component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>uninstallUI(JComponent component)</code>.
     * </p>
     *
     * <p>
     * the component is of type JButton, IllegalArgumentException is expected.
     * </p>
     */
    public void testUninstallUIJComponentInvalid() {
        try {
            header.uninstallUI(null);
            fail("the component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>paint(Graphics g, JComponent c)</code>.
     * </p>
     *
     * <p>
     * the component is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPaintGraphicsJComponentNull() {
        try {
            header.paint(new JButton().getGraphics(), null);
            fail("the component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>paint(Graphics g, JComponent c)</code>.
     * </p>
     *
     * <p>
     * the component is of type JButton, IllegalArgumentException is expected.
     * </p>
     */
    public void testPaintGraphicsJComponentInvalidType() {
        try {
            header.paint(new JButton().getGraphics(), new JButton());
            fail("the component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>installUI(JComponent component)</code>.
     * </p>
     *
     * <p>
     * SectionHeader.font in UIManager is null, IllegalArgumentException is expected.
     * </p>
     */
    public final void testInstallUIJComponentNullFont() {
        UIManager.put("SectionHeader.font", null);
        try {
            header.installUI(sectionHeader);
            fail("SectionHeader.font in UIManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>installUI(JComponent component)</code>.
     * </p>
     *
     * <p>
     * SectionHeader.expandedHeaderForeGroundColor in UIManager is null, IllegalArgumentException is expected.
     * </p>
     */
    public final void testInstallUIJComponentNullExpandedColor() {
        UIManager.put("SectionHeader.expandedHeaderForeGroundColor", null);
        try {
            header.installUI(sectionHeader);
            fail("SectionHeader.expandedHeaderForeGroundColor in UIManager is null, "
                + "IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>installUI(JComponent component)</code>.
     * </p>
     *
     * <p>
     * SectionHeader.contractedHeaderForeGroundColor in UIManager is null, IllegalArgumentException is
     * expected.
     * </p>
     */
    public final void testInstallUIJComponentNullContractedColor() {
        UIManager.put("SectionHeader.contractedHeaderForeGroundColor", null);

        try {
            header.installUI(sectionHeader);
            fail("SectionHeader.contractedHeaderForeGroundColor in UIManager is null,"
                + " IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>installUI(JComponent component)</code>.
     * </p>
     *
     * <p>
     * SectionHeader.expandedIcon in UIManager is null, IllegalArgumentException is expected.
     * </p>
     */
    public final void testInstallUIJComponentExpandedIconNull() {
        UIManager.put("SectionHeader.expandedIcon", null);

        try {
            header.installUI(sectionHeader);
            fail("SectionHeader.expandedIcon in UIManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>installUI(JComponent component)</code>.
     * </p>
     *
     * <p>
     * SectionHeader.contractedIcon in UIManager is -1, IllegalArgumentException is expected.
     * </p>
     */
    public final void testInstallUIJComponentContractedIconNull() {
        UIManager.put("SectionHeader.contractedIcon", null);

        try {
            header.installUI(sectionHeader);
            fail("SectionHeader.contractedIcon in UIManager is -1, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>installUI(JComponent component)</code>.
     * </p>
     *
     * <p>
     * SectionHeader.expandedBgLeftIcon in UIManager is null, IllegalArgumentException is expected.
     * </p>
     */
    public final void testInstallUIJComponentExpandedBgLeftIconNull() {
        UIManager.put("SectionHeader.expandedBgLeftIcon", null);

        try {
            header.installUI(sectionHeader);
            fail("SectionHeader.expandedBgLeftIcon in UIManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>installUI(JComponent component)</code>.
     * </p>
     *
     * <p>
     * SectionHeader.expandedBgRightIcon in UIManager is null, IllegalArgumentException is expected.
     * </p>
     */
    public final void testInstallUIJComponentExpandedBgRightIconNull() {
        UIManager.put("SectionHeader.expandedBgRightIcon", null);

        try {
            header.installUI(sectionHeader);
            fail("SectionHeader.expandedBgRightIcon in UIManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>installUI(JComponent component)</code>.
     * </p>
     *
     * <p>
     * SectionHeader.expandedBgMidIcon in UIManager is null, IllegalArgumentException is expected.
     * </p>
     */
    public final void testInstallUIJComponentExpandedBgMidIconNull() {
        UIManager.put("SectionHeader.expandedBgMidIcon", null);

        try {
            header.installUI(sectionHeader);
            fail("SectionHeader.expandedBgMidIcon in UIManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>installUI(JComponent component)</code>.
     * </p>
     *
     * <p>
     * SectionHeader.contractedBgLeftIcon in UIManager is null, IllegalArgumentException is expected.
     * </p>
     */
    public final void testInstallUIJComponentContractedBgLeftIconNull() {
        UIManager.put("SectionHeader.contractedBgLeftIcon", null);
        try {
            header.installUI(sectionHeader);
            fail("SectionHeader.contractedBgLeftIcon in UIManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>installUI(JComponent component)</code>.
     * </p>
     *
     * <p>
     * SectionHeader.contractedBgRightIcon in UIManager is null, IllegalArgumentException is expected.
     * </p>
     */
    public final void testInstallUIJComponentContractedBgRightIconNull() {
        UIManager.put("SectionHeader.contractedBgRightIcon", null);

        try {
            header.installUI(sectionHeader);
            fail("SectionHeader.contractedBgRightIcon in UIManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>installUI(JComponent component)</code>.
     * </p>
     *
     * <p>
     * SectionHeader.contractedBgMidIcon in UIManager is null, IllegalArgumentException is expected.
     * </p>
     */
    public final void testInstallUIJComponentContractedBgMidIconNull() {
        UIManager.put("SectionHeader.contractedBgMidIcon", null);

        try {
            header.installUI(sectionHeader);
            fail("SectionHeader.contractedBgMidIcon in UIManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
