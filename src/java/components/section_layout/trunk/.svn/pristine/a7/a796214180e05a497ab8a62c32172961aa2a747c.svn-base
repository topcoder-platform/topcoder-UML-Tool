/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.stresstests;

import javax.swing.JPanel;

import junit.framework.TestCase;

import com.topcoder.gui.sectionlayout.Section;
import com.topcoder.gui.sectionlayout.dock.Dock;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DefaultDock;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DialogFloatContainer;

/**
 * <p>
 * Stress test cases for class DialogFloatContainer.
 * </p>
 *
 * @author extra
 * @version 1.0
 */
public class DialogFloatContainerStressTests extends TestCase {

    /**
     * <p>
     * Stress test for dock(Dock dock, int index) and undock(Dock dock) method.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testDockUndock() throws Exception {
        StressTestHelper.configUIManager();
        Dock dock = new DefaultDock(new Section(new JPanel()));
        DialogFloatContainer container = new DialogFloatContainer(dock);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            container.dock(dock, i);
            assertTrue("Is docked true.", container.isDocked());
            container.undock(dock);
            assertFalse("Is docked false.", container.isDocked());
        }

        System.out.println("dock and undock 20 times cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");
    }

}
