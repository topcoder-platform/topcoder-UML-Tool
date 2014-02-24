/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu.accuracytests;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Popup;

import junit.framework.TestCase;

import com.topcoder.gui.sidemenu.AbstractSideMenuPanel;
import com.topcoder.gui.sidemenu.DefaultCollapsedSideMenuPanel;
import com.topcoder.gui.sidemenu.DefaultExpandedSideMenuPanel;
import com.topcoder.gui.sidemenu.DefaultSideMenuModel;
import com.topcoder.gui.sidemenu.SideMenuModel;
import com.topcoder.gui.sidemenu.SideMenuPanel;

/**
 * <p>
 * Accuracy test class: <code>SideMenuPanel</code>.
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
        target = new SideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
        sideMenuModel = new DefaultSideMenuModel(TestHelper.TITLE);
        collapsedComponent = new DefaultCollapsedSideMenuPanel(sideMenuModel);
        expandedComponent = new DefaultExpandedSideMenuPanel(sideMenuModel, TestHelper.CONTENT);
        // add listener
        listener = new MyPropertyChangeListener();
        target.addPropertyChangeListener(listener);
        // create frame
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
    public void testConstructor_String_JComponent_Icon_Icon1() throws Exception {
        target = new SideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON);
        // check fields
        checkSideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, null);
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.SideMenuPanel(String, JComponent, Icon, Icon)</code> for
     * proper behavior. Verifies that all fields are initialized correctly(expandIcon is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_JComponent_Icon_Icon2() throws Exception {
        target = new SideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, null,
                TestHelper.COLLAPSE_ICON);
        // check fields
        checkSideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, null, TestHelper.COLLAPSE_ICON,
                null);
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.SideMenuPanel(String, JComponent, Icon, Icon)</code> for
     * proper behavior. Verifies that all fields are initialized correctly(collapseIcon is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_JComponent_Icon_Icon3() throws Exception {
        target = new SideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                null);
        // check fields
        checkSideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON, null, null);
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
        // check sideMenuModelPropertyChange should be invoked
        assertEquals("collapseComponent should be added.", collapseComponent, target
                .getComponents()[0]);
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
        sideMenuModel.setExpanded(true);
        target = new SideMenuPanel(sideMenuModel, collapsedComponent, expandedComponent);
        assertEquals("sideMenuModel", sideMenuModel, target.getSideMenuModel());
        assertEquals("collapsedComponent", collapsedComponent, target.getCollapsedComponent());
        assertEquals("expandedComponent", expandedComponent, target.getExpandedComponent());
        assertTrue("BorderLayout should be set.", target.getLayout() instanceof BorderLayout);
        // check sideMenuModelPropertyChange should be invoked
        // for floating is set, popup should be shown
        checkExpanded(expandedComponent);
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
    public void testConstructor_String_JComponent_Icon_Icon_Icon1() throws Exception {
        checkSideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.SideMenuPanel(String, JComponent, Icon, Icon, Icon)</code>
     * for proper behavior. Verifies that all fields are set correctly(expandIcon is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_JComponent_Icon_Icon_Icon2() throws Exception {
        target = new SideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, null,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
        checkSideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, null, TestHelper.COLLAPSE_ICON,
                TestHelper.PIN_ICON);
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.SideMenuPanel(String, JComponent, Icon, Icon, Icon)</code>
     * for proper behavior. Verifies that all fields are set correctly(collapseIcon is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_JComponent_Icon_Icon_Icon3() throws Exception {
        target = new SideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                null, TestHelper.PIN_ICON);
        checkSideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON, null,
                TestHelper.PIN_ICON);
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.SideMenuPanel(String, JComponent, Icon, Icon, Icon)</code>
     * for proper behavior. Verifies that all fields are set correctly(pinIcon is null).
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_JComponent_Icon_Icon_Icon4() throws Exception {
        target = new SideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, null);
        checkSideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, null);
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
     * set.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetFloating_boolean() throws Exception {
        target.setFloating(true);
        assertEquals("floating", true, target.isFloating());
        // set again
        target.setFloating(false);
        assertEquals("floating", false, target.isFloating());
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
        target.setAbsoluteWidth(width);
        assertEquals("absoluteWidth", width, target.getAbsoluteWidth());
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
        target.setTitle(newTitle);
        assertEquals("title", newTitle, target.getTitle());
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
     *
     * @param component
     *            the new ExpandedComponent
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
        target = new MySideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
        target.setFloating(false);
        PropertyChangeEvent event = new PropertyChangeEvent(target.getSideMenuModel(),
                SideMenuModel.EXPANDED, false, true);
        ((MySideMenuPanel) target).sideMenuModelPropertyChange(event);
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
        target = new MySideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
        jFrame.add(target);
        target.setFloating(true);
        PropertyChangeEvent event = new PropertyChangeEvent(target.getSideMenuModel(),
                SideMenuModel.EXPANDED, false, true);
        ((MySideMenuPanel) target).sideMenuModelPropertyChange(event);
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
        target = new MySideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
        PropertyChangeEvent event = new PropertyChangeEvent(target.getSideMenuModel(),
                SideMenuModel.EXPANDED, true, false);
        ((MySideMenuPanel) target).sideMenuModelPropertyChange(event);
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
        target = new MySideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
        target.setExpanded(true);
        PropertyChangeEvent event = new PropertyChangeEvent(target.getSideMenuModel(),
                SideMenuModel.FLOATING, true, false);
        ((MySideMenuPanel) target).sideMenuModelPropertyChange(event);
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
        target = new MySideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
        jFrame.add(target);
        target.setExpanded(true);
        PropertyChangeEvent event = new PropertyChangeEvent(target.getSideMenuModel(),
                SideMenuModel.FLOATING, false, true);
        ((MySideMenuPanel) target).sideMenuModelPropertyChange(event);
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
        target = new MySideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
        target.setExpanded(true);
        PropertyChangeEvent event = new PropertyChangeEvent(target.getSideMenuModel(),
                SideMenuModel.ABSOLUTE_WIDTH, 300, 400);
        ((MySideMenuPanel) target).sideMenuModelPropertyChange(event);
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
     * behavior. if sideMenuModel == null, nothing happen.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent7() throws Exception {
        target = new MySideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
        target.setSideMenuModel(null);
        PropertyChangeEvent event = new PropertyChangeEvent(target, SideMenuModel.ABSOLUTE_WIDTH,
                300, 400);
        ((MySideMenuPanel) target).sideMenuModelPropertyChange(event);
        // check component
        assertNotSame("Preferred width should be not changed.", 400.0, target
                .getExpandedComponent().getPreferredSize().getWidth());
        assertNotSame("Minimum width should be not changed.", 400.0, target.getExpandedComponent()
                .getMinimumSize().getWidth());
        assertNotSame("Maximum width should be not changed.", 400.0, target.getExpandedComponent()
                .getMaximumSize().getWidth());
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. Verifies that when SIDE_MENU_MODEL event coming, panel change UI correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent8() throws Exception {
        target = new MySideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
        jFrame.add(target);
        SideMenuModel newModel = new DefaultSideMenuModel("xxx");
        newModel.setFloating(true);
        // trigger sideMenuModelPropertyChange
        target.setSideMenuModel(newModel);
        checkFloating();
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
        // set again
        target.setExpanded(false);
        assertEquals("expanded", false, target.isExpanded());
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
