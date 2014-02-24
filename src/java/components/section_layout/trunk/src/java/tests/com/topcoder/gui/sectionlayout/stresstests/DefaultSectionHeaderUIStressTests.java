/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.stresstests;

import java.awt.event.InputEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import junit.framework.TestCase;

import com.topcoder.gui.sectionlayout.Section;
import com.topcoder.gui.sectionlayout.SectionHeader;
import com.topcoder.gui.sectionlayout.dock.Dockable;
import com.topcoder.gui.sectionlayout.dock.DragInitListener;
import com.topcoder.gui.sectionlayout.model.DefaultSectionModel;
import com.topcoder.gui.sectionlayout.model.SectionModel;
import com.topcoder.gui.sectionlayout.ui.DefaultSectionHeaderUI;

/**
 * <p>
 * Stress test cases for class DefaultSectionHeaderUI.
 * </p>
 *
 * @author extra
 * @version 1.0
 */
public class DefaultSectionHeaderUIStressTests extends TestCase {
    /**
     * Represents instance of DefaultSectionHeaderUI for test.
     */
    private DefaultSectionHeaderUI ui;

    /**
     * Represents instance of SectionHeader for test.
     */
    private SectionHeader header;

    /**
     * Sets up test environment.
     *
     * @throws Exception
     *             to JUnit.
     */
    protected void setUp() throws Exception {
        StressTestHelper.configUIManager();
        ui = new DefaultSectionHeaderUI();
        SectionModel model = new DefaultSectionModel();
        Section section = new Section(new JPanel());
        section.setDragInitListener(new MockDragInitListener());
        header = new SectionHeader(section, model);
        super.setUp();
    }

    /**
     * <p>
     * Stress test for installUI(JComponent component) method.
     * </p>
     */
    public void testInstallUI() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            ui.installUI(header);
        }
        System.out.println("install ui 20 times cost " + (System.currentTimeMillis() - start) + " milliseconds.");
    }

    /**
     * <p>
     * Stress test for uninstallUI(JComponent component) method.
     * </p>
     */
    public void testUninstallUI() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            ui.uninstallUI(header);
        }
        System.out.println("uninstall ui 20 times cost " + (System.currentTimeMillis() - start) + " milliseconds.");
    }

    /**
     * <p>
     * Stress test for paint(Graphics, JComponent) method.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testPaint1() throws Exception {
        header.getModel().setExpanded(false);
        ui.installUI(header);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            JFrame frame = new JFrame();
            frame.getContentPane().add(header);
            frame.pack();
            frame.setVisible(true);
            frame.setVisible(false);
            frame.dispose();
        }
        System.out.println("paint ui 20 times cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");
    }

    /**
     * <p>
     * Stress test for paint(Graphics, JComponent) method.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testPaint2() throws Exception {
        header.getModel().setExpanded(true);
        ui.installUI(header);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            JFrame frame = new JFrame();
            frame.getContentPane().add(header);
            frame.pack();
            frame.setVisible(true);
            frame.setVisible(false);
            frame.dispose();
        }
        System.out.println("paint ui 20 times cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");
    }

    /**
     * Mock class implements DragInitListener.
     *
     * @author extra
     * @version 1.0
     */
    private class MockDragInitListener implements DragInitListener {
        /**
         * drag initialized.
         *
         * @param event
         *            the event.
         * @param dockable
         *            the dock
         */
        public void dragInitialized(InputEvent event, Dockable dockable) {
            System.out.println("dragInitialized");
        }
    }
}
