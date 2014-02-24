/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu.failuretests;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;

import junit.framework.TestCase;

import com.topcoder.gui.sidemenu.DefaultCollapsedSideMenuPanel;
import com.topcoder.gui.sidemenu.DefaultSideMenuModel;
import com.topcoder.gui.sidemenu.SideMenuModel;
import com.topcoder.gui.sidemenu.accuracytests.MyDefaultCollapsedSideMenuPanel;
import com.topcoder.gui.sidemenu.accuracytests.MyPropertyChangeListener;
import com.topcoder.gui.sidemenu.accuracytests.TestHelper;
import com.topcoder.gui.verticallabel.JVerticalLabel;

/**
 * <p>
 * Failure test class: <code>DefaultCollapsedSideMenuPanel</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultCollapsedSideMenuPanelTest extends TestCase {
    /**
     * <p>
     * An instance of <code>DefaultCollapsedSideMenuPanel</code> which is tested.
     * </p>
     */
    private DefaultCollapsedSideMenuPanel target = null;

    /**
     * <p>
     * An instance of <code>SideMenuModel</code> used in tests.
     * </p>
     */
    private SideMenuModel sideMenuModel;

    /**
     * <p>
     * An instance of <code>MyPropertyChangeListener</code> used in tests.
     * </p>
     */
    private MyPropertyChangeListener listener;

    /**
     * <p>
     * setUp() routine.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        sideMenuModel = new DefaultSideMenuModel(TestHelper.TITLE);
        listener = new MyPropertyChangeListener();
        // create target
        target = new DefaultCollapsedSideMenuPanel(sideMenuModel, TestHelper.EXPAND_ICON);
        target.addPropertyChangeListener(listener);
    }

    /**
     * <p>
     * Tests the <code>DefaultCollapsedSideMenuPanel(SideMenuModel)</code> for proper behavior.
     * IllegalArgumentException if sideMenuModel is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_failure1() throws Exception {
        try {
            target = new DefaultCollapsedSideMenuPanel(null);
            fail("IllegalArgumentException if sideMenuModel is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>DefaultCollapsedSideMenuPanel(SideMenuModel, Icon, boolean)</code> for
     * proper behavior. IllegalArgumentException if the sideMenuModel is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_Icon_boolean_failure1() throws Exception {
        try {
            target = new DefaultCollapsedSideMenuPanel(null, TestHelper.EXPAND_ICON, true);
            fail("IllegalArgumentException if the sideMenuModel is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>DefaultCollapsedSideMenuPanel(SideMenuModel, Icon)</code> for proper
     * behavior. IllegalArgumentException if the sideMenuModel is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_Icon_failure1() throws Exception {
        try {
            target = new DefaultCollapsedSideMenuPanel(null, null);
            fail("IllegalArgumentException if the sideMenuModel is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setTextLabel(JVerticalLabel)</code> for proper behavior.
     * IllegalArgumentException if textLabel is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetTextLabel_JVerticalLabel_failure1() throws Exception {
        try {
            target.setTextLabel(null);
            fail("IllegalArgumentException if textLabel is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setUpperExpandButton(JButton)</code> for proper behavior.
     * IllegalArgumentException if button is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetUpperExpandButton_JButton_failure1() throws Exception {
        try {
            target.setUpperExpandButton(null);
            fail("IllegalArgumentException if button is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setLowerExpandButton(JButton)</code> for proper behavior.
     * IllegalArgumentException if button is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetLowerExpandButton_JButton_failure1() throws Exception {
        try {
            target.setLowerExpandButton(null);
            fail("IllegalArgumentException if button is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. IllegalArgumentException if event is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent_failure1()
        throws Exception {
        try {
            target = new MyDefaultCollapsedSideMenuPanel(sideMenuModel, TestHelper.EXPAND_ICON);
            ((MyDefaultCollapsedSideMenuPanel) target).sideMenuModelPropertyChange(null);
            fail("IllegalArgumentException if event is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. IllegalArgumentException if value of specific property is invalid.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent_failure2()
        throws Exception {
        try {
            PropertyChangeEvent event = new PropertyChangeEvent(target, SideMenuModel.TITLE, 12, 34);
            target = new MyDefaultCollapsedSideMenuPanel(sideMenuModel, TestHelper.EXPAND_ICON);
            ((MyDefaultCollapsedSideMenuPanel) target).sideMenuModelPropertyChange(event);
            fail("IllegalArgumentException if value of specific property is invalid.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>mouseListener</code> for proper behavior. IllegalStateException if
     * sideMenuModel is removed(sideMenuModel is null).
     * </p>
     *
     *
     * @throws Exception
     *             to JUnit
     */
    public void test_mouseListener_failure() throws Exception {
        try {
            target.setSideMenuModel(null);
            MouseAdapter mouseListener = (MouseAdapter) TestHelper.getPrivateField(
                    DefaultCollapsedSideMenuPanel.class, target, "mouseListener");
            mouseListener.mouseClicked(new MouseEvent(target, 1, System.currentTimeMillis(), 1, 1,
                    1, 1, false));
            fail("IllegalStateException if sideMenuModel is removed(sideMenuModel is null).");
        } catch (IllegalStateException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setTextLabel(JVerticalLabel textLabel)</code> for proper behavior. IllegalStateException if
     * sideMenuModel is removed(sideMenuModel is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test_setTextLabel_failure() throws Exception {
        target.setSideMenuModel(null);
        try {
            target.setTextLabel(new JVerticalLabel());
            fail("IllegalStateException if sideMenuModel is removed(sideMenuModel is null).");
        } catch (IllegalStateException e) {
            // ok
        }
    }
}
