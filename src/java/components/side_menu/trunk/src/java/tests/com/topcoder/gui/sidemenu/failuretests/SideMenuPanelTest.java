/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu.failuretests;

import java.beans.PropertyChangeEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import junit.framework.TestCase;

import com.topcoder.gui.sidemenu.DefaultCollapsedSideMenuPanel;
import com.topcoder.gui.sidemenu.DefaultExpandedSideMenuPanel;
import com.topcoder.gui.sidemenu.DefaultSideMenuModel;
import com.topcoder.gui.sidemenu.SideMenuModel;
import com.topcoder.gui.sidemenu.SideMenuPanel;
import com.topcoder.gui.sidemenu.accuracytests.MySideMenuPanel;
import com.topcoder.gui.sidemenu.accuracytests.TestHelper;

/**
 * <p>
 * Failure test class: <code>SideMenuPanel</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SideMenuPanelTest extends TestCase {
    /**
     * <p>
     * An instance of <code>SideMenuPanel</code> which is tested.
     * </p>
     */
    private SideMenuPanel target = null;

    /**
     * <p>
     * An instance of <code>SideMenuModel</code> used in tests.
     * </p>
     */
    private SideMenuModel sideMenuModel;

    /**
     * <p>
     * An instance of <code>DefaultCollapsedSideMenuPanel</code> used in tests.
     * </p>
     */
    private DefaultCollapsedSideMenuPanel collapsedComponent;

    /**
     * <p>
     * An instance of <code>DefaultExpandedSideMenuPanel</code> used in tests.
     * </p>
     */
    private DefaultExpandedSideMenuPanel expandedComponent;

    /**
     * <p>
     * An instance of <code>JFrame</code> used in tests.
     * </p>
     */
    private JFrame jFrame;

    /**
     * <p>
     * setUp() routine.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        target = new SideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
        sideMenuModel = new DefaultSideMenuModel(TestHelper.TITLE);
        collapsedComponent = new DefaultCollapsedSideMenuPanel(sideMenuModel);
        expandedComponent = new DefaultExpandedSideMenuPanel(sideMenuModel, TestHelper.CONTENT);
        jFrame = new JFrame();
        jFrame.add(target);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    /**
     * <p>
     * tearDown() routine.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        jFrame.dispose();
        jFrame = null;
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.SideMenuPanel(String, JComponent, Icon, Icon)</code> for
     * proper behavior. Verifies that IllegalArgumentException if title is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_JComponent_Icon_Icon_failure1() throws Exception {
        try {
            new SideMenuPanel(null, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                    TestHelper.COLLAPSE_ICON);
            fail("IllegalArgumentException if title is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.SideMenuPanel(String, JComponent, Icon, Icon)</code> for
     * proper behavior. Verifies that IllegalArgumentException if title is empty.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_JComponent_Icon_Icon_failure2() throws Exception {
        try {
            new SideMenuPanel("   ", TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                    TestHelper.COLLAPSE_ICON);
            fail("IllegalArgumentException if title is empty.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.SideMenuPanel(String, JComponent, Icon, Icon)</code> for
     * proper behavior. Verifies that IllegalArgumentException if the content is null
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_JComponent_Icon_Icon_failure3() throws Exception {
        try {
            new SideMenuPanel(TestHelper.TITLE, null, TestHelper.EXPAND_ICON,
                    TestHelper.COLLAPSE_ICON);
            fail("IllegalArgumentException if the content is null");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.SideMenuPanel(SideMenuModel, JComponent, JComponent)</code>
     * for proper behavior. Verifies that IllegalArgumentException if sideMenuModel is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_JComponent_JComponent_failure1() throws Exception {
        try {
            new SideMenuPanel(null, collapsedComponent, expandedComponent);
            fail("IllegalArgumentException if sideMenuModel is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.SideMenuPanel(SideMenuModel, JComponent, JComponent)</code>
     * for proper behavior. Verifies that IllegalArgumentException if collapsedComponent is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_JComponent_JComponent_failure2() throws Exception {
        try {
            new SideMenuPanel(sideMenuModel, null, expandedComponent);
            fail("IllegalArgumentException if collapsedComponent is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.SideMenuPanel(SideMenuModel, JComponent, JComponent)</code>
     * for proper behavior. Verifies that IllegalArgumentException if expandedComponent is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_JComponent_JComponent_failure3() throws Exception {
        try {
            new SideMenuPanel(sideMenuModel, collapsedComponent, null);
            fail("IllegalArgumentException if expandedComponent is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.SideMenuPanel(String, JComponent, Icon, Icon, Icon)</code>
     * for proper behavior. Verifies that IllegalArgumentException if title is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_JComponent_Icon_Icon_Icon_failure1() throws Exception {
        try {
            new SideMenuPanel(null, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                    TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
            fail("IllegalArgumentException if title is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.SideMenuPanel(String, JComponent, Icon, Icon, Icon)</code>
     * for proper behavior. Verifies that IllegalArgumentException if title is empty.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_JComponent_Icon_Icon_Icon_failure2() throws Exception {
        try {
            new SideMenuPanel("   ", TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                    TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
            fail("IllegalArgumentException if title is empty.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.SideMenuPanel(String, JComponent, Icon, Icon, Icon)</code>
     * for proper behavior. Verifies that IllegalArgumentException if content is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_JComponent_Icon_Icon_Icon_failure3() throws Exception {
        try {
            new SideMenuPanel(TestHelper.TITLE, null, TestHelper.EXPAND_ICON,
                    TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
            fail("IllegalArgumentException if content is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setCollapsedComponent(JComponent)</code> for proper behavior. Verify that
     * IllegalArgumentException if component is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetCollapsedComponent_JComponent_failure1() throws Exception {
        try {
            target.setCollapsedComponent(null);
            fail("IllegalArgumentException if component is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setCollapsedComponent(JComponent)</code> for proper behavior. Verify that
     * IllegalStateException if sideMenuModel is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetCollapsedComponent_JComponent_failure2() throws Exception {
        try {
            DefaultCollapsedSideMenuPanel newCollapsedComponent = new DefaultCollapsedSideMenuPanel(
                    target.getSideMenuModel());
            target.setSideMenuModel(null);
            target.setCollapsedComponent(newCollapsedComponent);
            fail("IllegalStateException if sideMenuModel is null.");
        } catch (IllegalStateException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setAbsoluteWidth(int)</code> for proper behavior. Verifies that
     * IllegalArgumentException if absolute value is 0.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetAbsoluteWidth_int_failure1() throws Exception {
        try {
            target.setAbsoluteWidth(0);
            fail("IllegalArgumentException if absolute value is 0.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setAbsoluteWidth(int)</code> for proper behavior. Verifies that
     * IllegalArgumentException if absolute value is < -1.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetAbsoluteWidth_int_failure2() throws Exception {
        try {
            target.setAbsoluteWidth(-2);
            fail("IllegalArgumentException if absolute value is < -1.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setTitle(String)</code> for proper behavior. Verifies that
     * IllegalArgumentException if title is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetTitle_String_failure1() throws Exception {
        try {
            target.setTitle(null);
            fail("IllegalArgumentException if title is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setTitle(String)</code> for proper behavior. Verifies that
     * IllegalArgumentException if title is empty.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetTitle_String_failure2() throws Exception {
        try {
            target.setTitle("   ");
            fail("IllegalArgumentException if title is empty.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setExpandedComponent(JComponent)</code> for proper behavior. Verifies that
     * IllegalArgumentException if component is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetExpandedComponent_JComponent_failure1() throws Exception {
        try {
            target.setExpandedComponent(null);
            fail("IllegalArgumentException if component is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. IllegalArgumentException if the event is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent_failure1()
        throws Exception {
        try {
            target = new MySideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT,
                    TestHelper.EXPAND_ICON, TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
            ((MySideMenuPanel) target).sideMenuModelPropertyChange(null);
            fail("IllegalArgumentException if the event is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. IllegalArgumentException if value type is invalid.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent_failure2()
        throws Exception {
        try {
            PropertyChangeEvent event = new PropertyChangeEvent(target.getSideMenuModel(),
                    SideMenuModel.ABSOLUTE_WIDTH, false, true);
            target = new MySideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT,
                    TestHelper.EXPAND_ICON, TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
            ((MySideMenuPanel) target).sideMenuModelPropertyChange(event);
            fail("IllegalArgumentException if the event is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setCollapsedComponent(JComponent component)</code> for proper behavior.
     * IllegalStateException if sideMenuModel is removed(sideMenuModel is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test_setCollapsedComponent_failure1() throws Exception {
        target.setSideMenuModel(null);
        try {
            target.setCollapsedComponent(new JPanel());
            fail("IllegalStateException if sideMenuModel is removed(sideMenuModel is null).");
        } catch (IllegalStateException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setCollapsedComponent(JComponent component)</code> for proper behavior.
     * IllegalArgumentException if the new component contains different sideMenuModel.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test_setCollapsedComponent_failure2() throws Exception {
        try {
            target.setCollapsedComponent(new DefaultCollapsedSideMenuPanel(
                    new DefaultSideMenuModel("xx")));
            fail("IllegalArgumentException if the new component contains different sideMenuModel.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setExpandedComponent(JComponent component)</code> for proper behavior.
     * IllegalStateException if sideMenuModel is removed(sideMenuModel is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test_setExpandedComponent_failure1() throws Exception {
        target.setSideMenuModel(null);
        try {
            target.setExpandedComponent(new JPanel());
            fail("IllegalStateException if sideMenuModel is removed(sideMenuModel is null).");
        } catch (IllegalStateException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setExpandedComponent(JComponent component)</code> for proper behavior.
     * IllegalArgumentException if the new component contains different sideMenuModel.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test_setExpandedComponent_failure2() throws Exception {
        try {
            target.setExpandedComponent(new DefaultExpandedSideMenuPanel(new DefaultSideMenuModel(
                    "xx"), new JPanel()));
            fail("IllegalArgumentException if the new component contains different sideMenuModel.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>isExpanded()</code> for proper behavior. IllegalStateException if
     * sideMenuModel is removed(sideMenuModel is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test_isExpanded_failure() throws Exception {
        target.setSideMenuModel(null);
        try {
            target.isExpanded();
            fail("IllegalStateException if sideMenuModel is removed(sideMenuModel is null).");
        } catch (IllegalStateException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setExpanded(boolean expand)</code> for proper behavior.
     * IllegalStateException if sideMenuModel is removed(sideMenuModel is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test_setExpanded_failure() throws Exception {
        target.setSideMenuModel(null);
        try {
            target.setExpanded(false);
            fail("IllegalStateException if sideMenuModel is removed(sideMenuModel is null).");
        } catch (IllegalStateException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>getTitle()</code> for proper behavior. IllegalStateException if
     * sideMenuModel is removed(sideMenuModel is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test_getTitle_failure() throws Exception {
        target.setSideMenuModel(null);
        try {
            target.getTitle();
            fail("IllegalStateException if sideMenuModel is removed(sideMenuModel is null).");
        } catch (IllegalStateException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setTitle(String title)</code> for proper behavior. IllegalStateException if
     * sideMenuModel is removed(sideMenuModel is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test_setTitle_failure() throws Exception {
        target.setSideMenuModel(null);
        try {
            target.setTitle("xxxx");
            fail("IllegalStateException if sideMenuModel is removed(sideMenuModel is null).");
        } catch (IllegalStateException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>isFloating()</code> for proper behavior. IllegalStateException if
     * sideMenuModel is removed(sideMenuModel is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test_isFloating_failure() throws Exception {
        target.setSideMenuModel(null);
        try {
            target.isFloating();
            fail("IllegalStateException if sideMenuModel is removed(sideMenuModel is null).");
        } catch (IllegalStateException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setFloating(boolean floating)</code> for proper behavior.
     * IllegalStateException if sideMenuModel is removed(sideMenuModel is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test_setFloating_failure() throws Exception {
        target.setSideMenuModel(null);
        try {
            target.setFloating(false);
            fail("IllegalStateException if sideMenuModel is removed(sideMenuModel is null).");
        } catch (IllegalStateException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>getAbsoluteWidth()</code> for proper behavior. IllegalStateException if
     * sideMenuModel is removed(sideMenuModel is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test_getAbsoluteWidth_failure() throws Exception {
        target.setSideMenuModel(null);
        try {
            target.getAbsoluteWidth();
            fail("IllegalStateException if sideMenuModel is removed(sideMenuModel is null).");
        } catch (IllegalStateException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setAbsoluteWidth(int width)</code> for proper behavior.
     * IllegalStateException if sideMenuModel is removed(sideMenuModel is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test_setAbsoluteWidth_failure() throws Exception {
        target.setSideMenuModel(null);
        try {
            target.setAbsoluteWidth(1);
            fail("IllegalStateException if sideMenuModel is removed(sideMenuModel is null).");
        } catch (IllegalStateException e) {
            // ok
        }
    }
}
