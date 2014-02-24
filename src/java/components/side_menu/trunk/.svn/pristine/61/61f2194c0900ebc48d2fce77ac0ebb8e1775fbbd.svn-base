/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu.failuretests;

import junit.framework.TestCase;

import com.topcoder.gui.sidemenu.AbstractSideMenuPanel;
import com.topcoder.gui.sidemenu.DefaultSideMenuModel;
import com.topcoder.gui.sidemenu.SideMenuModel;
import com.topcoder.gui.sidemenu.accuracytests.MyAbstractSideMenuPanel;

/**
 * <p>
 * Failure test class: <code>AbstractSideMenuPanel</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AbstractSideMenuPanelTest extends TestCase {
    /**
     * <p>
     * An instance of <code>AbstractSideMenuPanel</code> which is tested.
     * </p>
     */
    private AbstractSideMenuPanel target = null;

    /**
     * <p>
     * An instance of <code>SideMenuModel</code> used in tests.
     * </p>
     */
    private SideMenuModel sideMenuModel = null;

    /**
     * <p>
     * setUp() routine.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        sideMenuModel = new DefaultSideMenuModel("Side Menu");
        target = new MyAbstractSideMenuPanel(sideMenuModel);
    }

    /**
     * <p>
     * Tests the <code>com.topcoder.gui.sidemenu.AbstractSideMenuPanel(SideMenuModel)</code> for
     * proper behavior. Verifies that IllegalArgumentException if sideMenuModel is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_failure1() throws Exception {
        try {
            new MyAbstractSideMenuPanel(null);
            fail("IllegalArgumentException if sideMenuModel is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setSideMenuModel(SideMenuModel)</code> for proper behavior. Verifies that
     * IllegalArgumentException unexpected if sideMenuModel is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetSideMenuModel_SideMenuModel_failure1() throws Exception {
        try {
            target.setSideMenuModel(null);
            // ok
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException unexpected if sideMenuModel is null.");
        }
    }
}
