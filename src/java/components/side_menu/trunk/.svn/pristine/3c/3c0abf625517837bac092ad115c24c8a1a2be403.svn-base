/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu.failuretests;

import java.beans.PropertyChangeEvent;

import javax.swing.JLabel;
import javax.swing.JToggleButton;

import junit.framework.TestCase;

import com.topcoder.gui.sidemenu.DefaultExpandedSideMenuPanel;
import com.topcoder.gui.sidemenu.DefaultSideMenuModel;
import com.topcoder.gui.sidemenu.SideMenuModel;
import com.topcoder.gui.sidemenu.accuracytests.MyDefaultExpandedSideMenuPanel;
import com.topcoder.gui.sidemenu.accuracytests.MyPropertyChangeListener;
import com.topcoder.gui.sidemenu.accuracytests.TestHelper;

/**
 * <p>
 * Failure test class: <code>DefaultExpandedSideMenuPanel</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultExpandedSideMenuPanelTest extends TestCase {
    /**
     * <p>
     * An instance of <code>DefaultExpandedSideMenuPanel</code> which is tested.
     * </p>
     */
    private DefaultExpandedSideMenuPanel target = null;

    /**
     * <p>
     * An instance of <code>MyPropertyChangeListener</code> used in tests.
     * </p>
     */
    private MyPropertyChangeListener listener;

    /**
     * <p>
     * An instance of <code>SideMenuModel</code> used in tests.
     * </p>
     */
    private SideMenuModel sideMenuModel;

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
        target = new DefaultExpandedSideMenuPanel(sideMenuModel, TestHelper.CONTENT,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
        target.addPropertyChangeListener(listener);
    }

    /**
     * <p>
     * Tests the <code>DefaultExpandedSideMenuPanel(SideMenuModel, JComponent, Icon, Icon)</code>
     * for proper behavior. IllegalArgumentException if the sideMenuModel is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_JComponent_Icon_Icon_failure1() throws Exception {
        try {
            new DefaultExpandedSideMenuPanel(null, TestHelper.CONTENT, TestHelper.COLLAPSE_ICON,
                    TestHelper.PIN_ICON);
            fail("IllegalArgumentException if the sideMenuModel is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>DefaultExpandedSideMenuPanel(SideMenuModel, JComponent, Icon, Icon)</code>
     * for proper behavior. IllegalArgumentException if the content is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_JComponent_Icon_Icon_failure2() throws Exception {
        try {
            new DefaultExpandedSideMenuPanel(sideMenuModel, null, TestHelper.COLLAPSE_ICON,
                    TestHelper.PIN_ICON);
            fail("IllegalArgumentException if the content is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>DefaultExpandedSideMenuPanel(SideMenuModel, JComponent, Icon)</code> for
     * proper behavior. IllegalArgumentException if the sideMenuModel is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_JComponent_Icon_failure1() throws Exception {
        try {
            new DefaultExpandedSideMenuPanel(null, TestHelper.CONTENT, TestHelper.COLLAPSE_ICON);
            fail("IllegalArgumentException if the sideMenuModel is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>DefaultExpandedSideMenuPanel(SideMenuModel, JComponent, Icon)</code> for
     * proper behavior. IllegalArgumentException if the content is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_JComponent_Icon_failure2() throws Exception {
        try {
            new DefaultExpandedSideMenuPanel(sideMenuModel, null, TestHelper.COLLAPSE_ICON);
            fail("IllegalArgumentException if the content is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>DefaultExpandedSideMenuPanel(SideMenuModel, JComponent)</code> for proper
     * behavior. IllegalArgumentException if the sideMenuModel is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_JComponent_failure1() throws Exception {
        try {
            new DefaultExpandedSideMenuPanel(null, TestHelper.CONTENT);
            fail("IllegalArgumentException if the sideMenuModel is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>DefaultExpandedSideMenuPanel(SideMenuModel, JComponent)</code> for proper
     * behavior. IllegalArgumentException if the content is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_JComponent_failure2() throws Exception {
        try {
            new DefaultExpandedSideMenuPanel(sideMenuModel, null);
            fail("IllegalArgumentException if the content is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setContent(JComponent)</code> for proper behavior. Verifies that
     * IllegalArgumentException if content is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetContent_JComponent_failure() throws Exception {
        try {
            target.setContent(null);
            fail("IllegalArgumentException if the content is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setCollapseButton(JButton)</code> for proper behavior. Verifies that
     * IllegalArgumentException if the button is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetCollapseButton_JButton_failure1() throws Exception {
        try {
            target.setCollapseButton(null);
            fail("IllegalArgumentException if the button is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setTextLabel(JLabel)</code> for proper behavior. IllegalArgumentException
     * if textLabel is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetTextLabel_JLabel_failure() throws Exception {
        try {
            target.setTextLabel(null);
            fail("IllegalArgumentException if textLabel is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. Verifies that IllegalArgumentException if event is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent_failure1()
        throws Exception {
        try {
            target = new MyDefaultExpandedSideMenuPanel(sideMenuModel, TestHelper.CONTENT);
            ((MyDefaultExpandedSideMenuPanel) target).sideMenuModelPropertyChange(null);
            fail("IllegalArgumentException if event is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. Verifies that IllegalArgumentException if value of property is invalid.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent_failure2()
        throws Exception {
        try {
            PropertyChangeEvent event = new PropertyChangeEvent(new Object(),
                    SideMenuModel.FLOATING, 12, 32);
            target = new MyDefaultExpandedSideMenuPanel(sideMenuModel, TestHelper.CONTENT);
            ((MyDefaultExpandedSideMenuPanel) target).sideMenuModelPropertyChange(event);
            fail("IllegalArgumentException if value of property is invalid.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setPinButton(JToggleButton button)</code> for proper behavior.
     * IllegalStateException if sideMenuModel is removed(sideMenuModel is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test_setPinButton_failure() throws Exception {
        target.setSideMenuModel(null);
        try {
            target.setPinButton(new JToggleButton());
            fail("IllegalStateException if sideMenuModel is removed(sideMenuModel is null).");
        } catch (IllegalStateException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setTextLabel(JLabel textLabel)</code> for proper behavior.
     * IllegalStateException if sideMenuModel is removed(sideMenuModel is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test_setTextLabel_failure() throws Exception {
        target.setSideMenuModel(null);
        try {
            target.setTextLabel(new JLabel());
            fail("IllegalStateException if sideMenuModel is removed(sideMenuModel is null).");
        } catch (IllegalStateException e) {
            // ok
        }
    }

}
