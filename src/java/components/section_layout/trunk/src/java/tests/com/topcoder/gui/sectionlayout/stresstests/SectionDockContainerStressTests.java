/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.stresstests;

import java.awt.Point;

import javax.swing.JPanel;

import junit.framework.TestCase;

import com.topcoder.gui.sectionlayout.Section;
import com.topcoder.gui.sectionlayout.SectionDockContainer;
import com.topcoder.gui.sectionlayout.dock.Dock;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DefaultDock;

/**
 * <p>
 * Stress test cases for class SectionDockContainer.
 * </p>
 *
 * @author extra
 * @version 1.0
 */
public class SectionDockContainerStressTests extends TestCase {

    /**
     * <p>
     * Stress test for dock(Dock dock, int index) method.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testDock() throws Exception {
        StressTestHelper.configUIManager();
        SectionDockContainer container = new SectionDockContainer(new JPanel());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            Dock dock = new DefaultDock(new Section(new JPanel()));
            container.dock(dock, i);
        }
        System.out.println("dock 20 times cost " + (System.currentTimeMillis() - start) + " milliseconds.");
        assertEquals("dock size", 20, container.getDockSize());
    }

    /**
     * <p>
     * Stress test for markDockGesture(Dock dock, Point location) method.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testMarkDockGesture() throws Exception {
        StressTestHelper.configUIManager();
        SectionDockContainer container = new SectionDockContainer(new JPanel());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            Dock dock = new DefaultDock(new Section(new JPanel()));
            container.markDockGesture(dock, new Point(10 * i, 10 * i));
        }

        System.out.println("markDockGesture 20 times cost " + (System.currentTimeMillis() - start) + " milliseconds.");
    }
}
