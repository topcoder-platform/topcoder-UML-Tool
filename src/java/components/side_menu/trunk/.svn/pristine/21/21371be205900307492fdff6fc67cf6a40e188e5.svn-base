/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Popup;

import junit.framework.TestCase;

/**
 * <p>
 * Test class: <code>SideMenuPanel</code>.
 * </p>
 *
 * @author KingStone
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
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies <code>SideMenuPanel</code> subclasses <code>AbstractSideMenuPanel</code>.
     * </p>
     */
    public void testInheritance() {
        assertTrue("SideMenuPanel does not subclasses AbstractSideMenuPanel.",
                target instanceof AbstractSideMenuPanel);
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.SideMenuPanel(String, JComponent, Icon, Icon)</code> for
     * proper behavior. Verifies that all fields are initialized correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_JComponent_Icon_Icon() throws Exception {
        target = new SideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON);
        // check fields
        checkSideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, null);
    }

    /**
     * Assert the created SideMenuPanel for fields.
     *
     * @param title
     *            the title expected
     * @param content
     *            the content expected
     * @param expandIcon
     *            the expandIcon expected
     * @param collapseIcon
     *            the collapseIcon expected
     * @param pinIcon
     *            the pinIcon expected
     */
    private void checkSideMenuPanel(String title, JComponent content, Icon expandIcon,
            Icon collapseIcon, Icon pinIcon) {
        sideMenuModel = target.getSideMenuModel();
        DefaultExpandedSideMenuPanel expandedComponent = (DefaultExpandedSideMenuPanel) target
                .getExpandedComponent();
        DefaultCollapsedSideMenuPanel collapseComponent = (DefaultCollapsedSideMenuPanel) target
                .getCollapsedComponent();
        // assert fields
        assertEquals("title", title, sideMenuModel.getTitle());
        assertEquals("content", content, expandedComponent.getContent());
        assertEquals("collapseIcon", collapseIcon, expandedComponent.getCollapseIcon());
        assertEquals("pinIcon", pinIcon, expandedComponent.getPinIcon());
        assertEquals("expandIcon", expandIcon, collapseComponent.getUpperExpandButton().getIcon());
        assertTrue("BorderLayout should be set.", target.getLayout() instanceof BorderLayout);
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
     * for proper behavior. Verifies that all fields are set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_JComponent_JComponent() throws Exception {
        target = new SideMenuPanel(sideMenuModel, collapsedComponent, expandedComponent);
        assertEquals("sideMenuModel", sideMenuModel, target.getSideMenuModel());
        assertEquals("collapsedComponent", collapsedComponent, target.getCollapsedComponent());
        assertEquals("expandedComponent", expandedComponent, target.getExpandedComponent());
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
     * for proper behavior. Verifies that all fields are set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_JComponent_Icon_Icon_Icon() throws Exception {
        checkSideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
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
     * Tests the <code>isFloating()</code> for proper behavior.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodIsFloating() throws Exception {
        target.setFloating(true);
        assertEquals("Floating", true, target.isFloating());
        target.setFloating(false);
        assertEquals("Floating", false, target.isFloating());
    }

    /**
     * <p>
     * Tests the <code>setCollapsedComponent(JComponent)</code> for proper behavior. Verify that
     * field is set and PropertyChange is fired.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetCollapsedComponent_JComponent() throws Exception {
        DefaultCollapsedSideMenuPanel newCollapsedComponent = new DefaultCollapsedSideMenuPanel(
                target.getSideMenuModel());
        JComponent oldCollapsedComponent = target.getCollapsedComponent();
        MyPropertyChangeListener listener = new MyPropertyChangeListener();
        target.addPropertyChangeListener(listener);
        target.setCollapsedComponent(newCollapsedComponent);
        // check result
        assertEquals("CollapsedComponent", newCollapsedComponent, target.getCollapsedComponent());
        checkCollapsed(newCollapsedComponent);
        TestHelper.assertEvent(listener.getEvent(), SideMenuPanel.COLLAPSED_COMPONENT,
                oldCollapsedComponent, newCollapsedComponent);
    }

    /**
     * Check collapsed status.
     *
     * @param component
     *            the new CollapsedComponent
     */
    private void checkCollapsed(JComponent component) {
        assertEquals("Should only contains 1 component", 1, target.getComponents().length);
        assertEquals("new/old CollapsedComponent should be added/removed.", component, target
                .getComponents()[0]);
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
     * Tests the <code>setSideMenuModel(SideMenuModel)</code> for proper behavior. Verify that
     * null is set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetSideMenuModel_SideMenuModel1() throws Exception {
        target.setSideMenuModel(null);
        assertEquals("SideMenuModel", null, target.getSideMenuModel());
    }

    /**
     * <p>
     * Tests the <code>setSideMenuModel(SideMenuModel)</code> for proper behavior. Verify that
     * model is set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetSideMenuModel_SideMenuModel2() throws Exception {
        DefaultSideMenuModel model = new DefaultSideMenuModel("xxx");
        target.setSideMenuModel(model);
        assertEquals("SideMenuModel", model, target.getSideMenuModel());
    }

    /**
     * <p>
     * Tests the <code>setFloating(boolean)</code> for proper behavior. Verifies that property is
     * set and PropertyChange is fired.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetFloating_boolean() throws Exception {
        // add PropertyChangeListener
        MyPropertyChangeListener listener = new MyPropertyChangeListener();
        target.getSideMenuModel().addPropertyChangeListener(listener);
        target.setFloating(true);
        assertEquals("floating", true, target.isFloating());
        TestHelper.assertEvent(listener.getEvent(), SideMenuModel.FLOATING, false, true);
    }

    /**
     * <p>
     * Tests the <code>setAbsoluteWidth(int)</code> for proper behavior. Verifies that property is
     * set and PropertyChange is fired.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetAbsoluteWidth_int() throws Exception {
        int width = 300;
        int oldWidth = target.getAbsoluteWidth();
        // add PropertyChangeListener
        MyPropertyChangeListener listener = new MyPropertyChangeListener();
        target.getSideMenuModel().addPropertyChangeListener(listener);
        target.setAbsoluteWidth(width);
        assertEquals("absoluteWidth", width, target.getAbsoluteWidth());
        TestHelper.assertEvent(listener.getEvent(), SideMenuModel.ABSOLUTE_WIDTH, oldWidth, width);
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
     * Tests the <code>setTitle(String)</code> for proper behavior. Verifies that property is set
     * and PropertyChange is fired.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetTitle_String() throws Exception {
        String newTitle = "new";
        // add PropertyChangeListener
        MyPropertyChangeListener listener = new MyPropertyChangeListener();
        target.getSideMenuModel().addPropertyChangeListener(listener);
        target.setTitle(newTitle);
        assertEquals("title", newTitle, target.getTitle());
        TestHelper
                .assertEvent(listener.getEvent(), SideMenuModel.TITLE, TestHelper.TITLE, newTitle);
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
     * Tests the <code>isExpanded()</code> for proper behavior.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodIsExpanded() throws Exception {
        assertEquals("Expanded", false, target.isExpanded());
    }

    /**
     * <p>
     * Tests the <code>setExpandedComponent(JComponent)</code> for proper behavior. Verifies that
     * property is set and PropertyChange is fired.(expanded:true, floating:false)
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetExpandedComponent_JComponent1() throws Exception {
        DefaultExpandedSideMenuPanel newExpandedComponent = new DefaultExpandedSideMenuPanel(target
                .getSideMenuModel(), TestHelper.CONTENT);
        JComponent oldExpandedComponent = target.getExpandedComponent();
        MyPropertyChangeListener listener = new MyPropertyChangeListener();
        target.addPropertyChangeListener(listener);
        // expand panel
        target.setExpanded(true);
        target.setExpandedComponent(newExpandedComponent);
        // check result
        assertEquals("ExpandedComponent", newExpandedComponent, target.getExpandedComponent());
        checkExpanded(newExpandedComponent);
        TestHelper.assertEvent(listener.getEvent(), SideMenuPanel.EXPANDED_COMPONENT,
                oldExpandedComponent, newExpandedComponent);
    }

    /**
     * Check expanded status.
     * @param component the new ExpandedComponent
     */
    private void checkExpanded(JComponent component) {
        assertEquals("Should only contains 1 component", 1, target.getComponents().length);
        assertEquals("new/old ExpandedComponent should be added/removed.", component, target
                .getComponents()[0]);
    }

    /**
     * <p>
     * Tests the <code>setExpandedComponent(JComponent)</code> for proper behavior. Verifies that
     * property is set and PropertyChange is fired.(expanded:false, floating:false)
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetExpandedComponent_JComponent2() throws Exception {
        DefaultExpandedSideMenuPanel newExpandedComponent = new DefaultExpandedSideMenuPanel(target
                .getSideMenuModel(), TestHelper.CONTENT);
        JComponent oldExpandedComponent = target.getExpandedComponent();
        MyPropertyChangeListener listener = new MyPropertyChangeListener();
        target.addPropertyChangeListener(listener);
        target.setExpandedComponent(newExpandedComponent);
        // check result
        assertEquals("ExpandedComponent", newExpandedComponent, target.getExpandedComponent());
        TestHelper.assertEvent(listener.getEvent(), SideMenuPanel.EXPANDED_COMPONENT,
                oldExpandedComponent, newExpandedComponent);
    }

    /**
     * <p>
     * Tests the <code>setExpandedComponent(JComponent)</code> for proper behavior. Verifies that
     * property is set and PropertyChange is fired.(expanded:true, floating:true)
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetExpandedComponent_JComponent3() throws Exception {
        DefaultExpandedSideMenuPanel newExpandedComponent = new DefaultExpandedSideMenuPanel(target
                .getSideMenuModel(), TestHelper.CONTENT);
        JComponent oldExpandedComponent = target.getExpandedComponent();
        MyPropertyChangeListener listener = new MyPropertyChangeListener();
        target.addPropertyChangeListener(listener);
        // expand panel
        target.setExpanded(true);
        target.setFloating(true);
        target.setExpandedComponent(newExpandedComponent);
        // check result
        assertEquals("ExpandedComponent", newExpandedComponent, target.getExpandedComponent());
        // expanded panel is still there
        checkFloating();
        TestHelper.assertEvent(listener.getEvent(), SideMenuPanel.EXPANDED_COMPONENT,
                oldExpandedComponent, newExpandedComponent);
    }

    /**
     * Check floating status.
     */
    private void checkFloating() {
        assertEquals("Should only contains 1 component", 1, target.getComponents().length);
        Popup floatingPopup = (Popup) TestHelper.getPrivateField(SideMenuPanel.class, target,
                "floatingPopup");
        assertNotNull("floatingPopup", floatingPopup);
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
     * Tests the <code>getTitle()</code> for proper behavior.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetTitle() throws Exception {
        assertEquals("title", TestHelper.TITLE, target.getTitle());
    }

    /**
     * <p>
     * Tests the <code>getCollapsedComponent()</code> for proper behavior.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetCollapsedComponent() throws Exception {
        assertEquals("collapsedComponent", TestHelper.getPrivateField(SideMenuPanel.class, target,
                "collapsedComponent"), target.getCollapsedComponent());
    }

    /**
     * <p>
     * Tests the <code>getExpandedComponent()</code> for proper behavior.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetExpandedComponent() throws Exception {
        assertEquals("expandedComponent", TestHelper.getPrivateField(SideMenuPanel.class, target,
                "expandedComponent"), target.getExpandedComponent());
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. Verifies that when expanded is change from false to true, panel change UI
     * correctly.(floating:false)
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent1() throws Exception {
        target.setFloating(false);
        PropertyChangeEvent event = new PropertyChangeEvent(target.getSideMenuModel(),
                SideMenuModel.EXPANDED, false, true);
        target.sideMenuModelPropertyChange(event);
        // check component
        checkExpanded(target.getExpandedComponent());
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. Verifies that when expanded is change from false to true, panel change UI
     * correctly.(floating:true)
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent2() throws Exception {
        target.setFloating(true);
        PropertyChangeEvent event = new PropertyChangeEvent(target.getSideMenuModel(),
                SideMenuModel.EXPANDED, false, true);
        target.sideMenuModelPropertyChange(event);
        // check component
        checkFloating();
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. Verifies that when expanded is change from true to false, panel change UI
     * correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent3() throws Exception {
        PropertyChangeEvent event = new PropertyChangeEvent(target.getSideMenuModel(),
                SideMenuModel.EXPANDED, true, false);
        target.sideMenuModelPropertyChange(event);
        // check component
        checkCollapsed(target.getCollapsedComponent());
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. Verifies that when FLOATING event coming(from true to false), panel change UI
     * correctly.(expand:true)
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent_FLOATING4()
        throws Exception {
        target.setExpanded(true);
        PropertyChangeEvent event = new PropertyChangeEvent(target.getSideMenuModel(),
                SideMenuModel.FLOATING, true, false);
        target.sideMenuModelPropertyChange(event);
        // check component
        checkExpanded(target.getExpandedComponent());
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. Verifies that when FLOATING event coming(from false to true), panel change UI
     * correctly.(expand:true)
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent_FLOATING5()
        throws Exception {
        target.setExpanded(true);
        PropertyChangeEvent event = new PropertyChangeEvent(target.getSideMenuModel(),
                SideMenuModel.FLOATING, false, true);
        target.sideMenuModelPropertyChange(event);
        // check component
        checkFloating();
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. when ABSOLUTE_WIDTH event coming.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent_ABSOLUTE_WIDTH6()
        throws Exception {
        target.setExpanded(true);
        PropertyChangeEvent event = new PropertyChangeEvent(target.getSideMenuModel(),
                SideMenuModel.ABSOLUTE_WIDTH, 300, 400);
        target.sideMenuModelPropertyChange(event);
        // check component
        // the size of target cannot be determined
        // assertEquals("width", 400.0, target.getExpandedComponent().getSize().getWidth());
        assertEquals("Preferred width", 400.0, target.getExpandedComponent().getPreferredSize()
                .getWidth());
        assertEquals("Minimum width", 400.0, target.getExpandedComponent().getMinimumSize()
                .getWidth());
        assertEquals("Maximum width", 400.0, target.getExpandedComponent().getMaximumSize()
                .getWidth());
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
            target.sideMenuModelPropertyChange(null);
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
            target.sideMenuModelPropertyChange(event);
            fail("IllegalArgumentException if the event is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setExpanded(boolean)</code> for proper behavior.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetExpanded_boolean() throws Exception {
        target.setExpanded(true);
        assertEquals("expanded", true, target.isExpanded());
    }

    /**
     * <p>
     * Tests the <code>getAbsoluteWidth()</code> for proper behavior.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetAbsoluteWidth1() throws Exception {
        assertEquals("AbsoluteWidth", -1, target.getAbsoluteWidth());
    }

    /**
     * <p>
     * Tests the <code>getAbsoluteWidth()</code> for proper behavior.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetAbsoluteWidth2() throws Exception {
        target.setAbsoluteWidth(300);
        assertEquals("AbsoluteWidth", 300, target.getAbsoluteWidth());
    }
}
