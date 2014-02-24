/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import junit.framework.TestCase;

import com.topcoder.gui.verticallabel.JVerticalLabel;

/**
 * <p>
 * Test class: <code>DefaultCollapsedSideMenuPanel</code>.
 * </p>
 *
 * @author KingStone
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
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies <code>DefaultCollapsedSideMenuPanel</code> subclasses
     * <code>AbstractSideMenuPanel</code>.
     * </p>
     */
    public void testInheritance() {
        assertTrue("DefaultCollapsedSideMenuPanel does not subclasses AbstractSideMenuPanel.",
                target instanceof AbstractSideMenuPanel);
    }

    /**
     * <p>
     * Tests the <code>DefaultCollapsedSideMenuPanel(SideMenuModel)</code> for proper behavior.
     * Verifies that all fields are set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel() throws Exception {
        target = new DefaultCollapsedSideMenuPanel(sideMenuModel);
        checkDefaultCollapsedSideMenuPanel(null, true);
    }

    /**
     * Check DefaultCollapsedSideMenuPanel for setting correctly.
     *
     * @param icon
     *            the expand icon
     * @param clickExpand
     *            whether click to expand
     */
    private void checkDefaultCollapsedSideMenuPanel(Icon icon, boolean clickExpand) {
        // check listeners
        MouseListener mouseListener = (MouseListener) TestHelper.getPrivateField(
                DefaultCollapsedSideMenuPanel.class, target, "mouseListener");
        assertNotNull("mouseListener should be set.", mouseListener);
        ActionListener buttonListener = (ActionListener) TestHelper.getPrivateField(
                DefaultCollapsedSideMenuPanel.class, target, "buttonListener");
        // check button
        checkButton(target.getUpperExpandButton(), buttonListener, icon);
        checkButton(target.getLowerExpandButton(), buttonListener, icon);
        // text label
        assertEquals("title", TestHelper.TITLE, target.getTextLabel().getText());
        // check click to expanded
        assertEquals("ClickToExpand", clickExpand, target.isClickToExpand());
        assertEquals("number of mouse listeners", clickExpand ? 1 : 0,
                target.getMouseListeners().length);
        if (clickExpand) {
            assertEquals("mouse listener", mouseListener, target.getMouseListeners()[0]);
        }

        // check layout
        assertTrue("GridBagLayout should be set.", target.getLayout() instanceof GridBagLayout);
    }

    /**
     * Check button for setting correctly.
     *
     * @param button
     *            the button to check
     * @param buttonListener
     *            the button listener to be added to button
     * @param icon
     *            the icon to be added to button
     */
    private void checkButton(JButton button, ActionListener buttonListener, Icon icon) {
        assertEquals("ExpandIcon", icon, button.getIcon());
        assertEquals("1 listener should be added.", 1, button.getActionListeners().length);
        assertEquals("buttonListener", buttonListener, button.getActionListeners()[0]);
        assertFalse("ContentAreaFilled", button.isContentAreaFilled());
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
     * proper behavior. Verifies that all fields are set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_Icon_boolean1() throws Exception {
        target = new DefaultCollapsedSideMenuPanel(sideMenuModel, TestHelper.EXPAND_ICON, true);
        checkDefaultCollapsedSideMenuPanel(TestHelper.EXPAND_ICON, true);
    }

    /**
     * <p>
     * Tests the <code>DefaultCollapsedSideMenuPanel(SideMenuModel, Icon, boolean)</code> for
     * proper behavior. Verifies that null icon is ok.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_Icon_boolean2() throws Exception {
        target = new DefaultCollapsedSideMenuPanel(sideMenuModel, null, true);
        checkDefaultCollapsedSideMenuPanel(null, true);
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
     * behavior. Verifies that all fields are set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_Icon1() throws Exception {
        target = new DefaultCollapsedSideMenuPanel(sideMenuModel, TestHelper.EXPAND_ICON);
        checkDefaultCollapsedSideMenuPanel(TestHelper.EXPAND_ICON, false);
    }

    /**
     * <p>
     * Tests the <code>DefaultCollapsedSideMenuPanel(SideMenuModel, Icon)</code> for proper
     * behavior. Verifies that null icon is ok.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_Icon2() throws Exception {
        target = new DefaultCollapsedSideMenuPanel(sideMenuModel, null);
        checkDefaultCollapsedSideMenuPanel(null, false);
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
     * Tests the <code>isClickToExpand()</code> for proper behavior. Verifies that ClickToExpand
     * is returned correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodIsClickToExpand1() throws Exception {
        assertEquals("ClickToExpand", false, target.isClickToExpand());
    }

    /**
     * <p>
     * Tests the <code>isClickToExpand()</code> for proper behavior. Verifies that ClickToExpand
     * is returned correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodIsClickToExpand2() throws Exception {
        target = new DefaultCollapsedSideMenuPanel(sideMenuModel, null, true);
        assertEquals("ClickToExpand", true, target.isClickToExpand());
    }

    /**
     * <p>
     * Tests the <code>setTextLabel(JVerticalLabel)</code> for proper behavior. Verifies field is
     * set, UI is updated, event is fired.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetTextLabel_JVerticalLabel() throws Exception {
        JVerticalLabel newValue = new JVerticalLabel("new");
        JVerticalLabel oldValue = target.getTextLabel();
        target.setTextLabel(newValue);
        // check field
        assertEquals("textLabel", newValue, target.getTextLabel());
        assertEquals("title", TestHelper.TITLE, target.getTextLabel().getText());
        // check UI
        assertEquals("component number", 3, target.getComponentCount());
        assertEquals("new textLabel should be added.", newValue, target.getComponents()[2]);
        // check event
        TestHelper.assertEvent(listener.getEvent(), DefaultCollapsedSideMenuPanel.TEXT_LABEL,
                oldValue, newValue);
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
     * Tests the <code>getTextLabel()</code> for proper behavior. Verifies that field return as
     * is.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetTextLabel() throws Exception {
        assertEquals("textLabel", TestHelper.getPrivateField(DefaultCollapsedSideMenuPanel.class,
                target, "textLabel"), target.getTextLabel());
    }

    /**
     * <p>
     * Tests the <code>setUpperExpandButton(JButton)</code> for proper behavior. Verifies that
     * field is set, UI is updated, event is fired.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetUpperExpandButton_JButton() throws Exception {
        JButton newValue = new JButton("new");
        JButton oldValue = target.getUpperExpandButton();
        target.setUpperExpandButton(newValue);
        // check field
        assertEquals("UpperExpandButton", newValue, target.getUpperExpandButton());
        assertEquals("buttonListener", TestHelper.getPrivateField(
                DefaultCollapsedSideMenuPanel.class, target, "buttonListener"), newValue
                .getActionListeners()[0]);
        // check UI
        assertEquals("component number", 3, target.getComponentCount());
        assertEquals("new textLabel should be added.", newValue, target.getComponents()[2]);
        // check event
        TestHelper.assertEvent(listener.getEvent(),
                DefaultCollapsedSideMenuPanel.UPPER_EXPAND_BUTTON, oldValue, newValue);
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
     * Tests the <code>setUpperExpandButtonVisible(boolean)</code> for proper behavior. Verifies
     * that UpperExpandButton visible is set.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetUpperExpandButtonVisible_boolean() throws Exception {
        target.setUpperExpandButtonVisible(false);
        assertEquals("UpperExpandButtonVisible", false, target.getUpperExpandButton().isVisible());
    }

    /**
     * <p>
     * Tests the <code>isLowerExpandButtonVisible()</code> for proper behavior. Verifies that
     * LowerExpandButtonVisible is returned correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodIsLowerExpandButtonVisible() throws Exception {
        assertEquals("LowerExpandButtonVisible", true, target.isLowerExpandButtonVisible());
        target.setLowerExpandButtonVisible(false);
        assertEquals("LowerExpandButtonVisible", false, target.isLowerExpandButtonVisible());
    }

    /**
     * <p>
     * Tests the <code>setLowerExpandButtonVisible(boolean)</code> for proper behavior. Verifies
     * that LowerExpandButtonVisible is set.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetLowerExpandButtonVisible_boolean() throws Exception {
        target.setLowerExpandButtonVisible(false);
        assertEquals("LowerExpandButtonVisible", false, target.getLowerExpandButton().isVisible());
    }

    /**
     * <p>
     * Tests the <code>getExpandIcon()</code> for proper behavior. Verifies that ExpandIcon is
     * returned as is.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetExpandIcon1() throws Exception {
        assertEquals("ExpandIcon", TestHelper.EXPAND_ICON, target.getExpandIcon());
    }

    /**
     * <p>
     * Tests the <code>getExpandIcon()</code> for proper behavior. Verifies that ExpandIcon of
     * upperExpandButton should be returned first.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetExpandIcon2() throws Exception {
        JButton button = new JButton(new ImageIcon());
        target.setUpperExpandButton(button);
        assertEquals("ExpandIcon of upperExpandButton should be returned first.", button.getIcon(),
                target.getExpandIcon());
    }

    /**
     * <p>
     * Tests the <code>getExpandIcon()</code> for proper behavior. Verifies that if ExpandIcon of
     * upperExpandButton is null, ExpandIcon of lowerExpandButton should be returned.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetExpandIcon3() throws Exception {
        JButton button = new JButton(new ImageIcon());
        target.setUpperExpandButton(new JButton());
        target.setLowerExpandButton(button);
        assertEquals("if ExpandIcon of upperExpandButton is null, "
                + "ExpandIcon of lowerExpandButton should be returned.", button.getIcon(), target
                .getExpandIcon());
    }

    /**
     * <p>
     * Tests the <code>getExpandIcon()</code> for proper behavior. Verifies that if ExpandIcons of
     * upperExpandButton and lowerExpandButton are both null, null should be returned.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetExpandIcon4() throws Exception {
        target.setUpperExpandButton(new JButton());
        target.setLowerExpandButton(new JButton());
        assertEquals("if ExpandIcons of upperExpandButton and lowerExpandButton "
                + "are both null, null should be returned.", null, target.getExpandIcon());
    }

    /**
     * <p>
     * Tests the <code>setClickToExpand(boolean)</code> for proper behavior. Verifies that click
     * to expand is set.(previous click to expand is false)
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetClickToExpand_boolean1() throws Exception {
        target.setClickToExpand(false);
        assertEquals("ClickToExpand", false, target.isClickToExpand());
        assertEquals("There should be no mouse listener.", 0, target.getMouseListeners().length);
    }

    /**
     * <p>
     * Tests the <code>setClickToExpand(boolean)</code> for proper behavior. Verifies that click
     * to expand is set.(previous click to expand is false)
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetClickToExpand_boolean2() throws Exception {
        target.setClickToExpand(true);
        assertEquals("ClickToExpand", true, target.isClickToExpand());
        assertEquals("There should be 1 mouse listener.", 1, target.getMouseListeners().length);
    }

    /**
     * <p>
     * Tests the <code>setClickToExpand(boolean)</code> for proper behavior. Verifies that click
     * to expand is set.(previous click to expand is true)
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetClickToExpand_boolean3() throws Exception {
        target.setClickToExpand(true);
        // set again
        target.setClickToExpand(false);
        assertEquals("ClickToExpand", false, target.isClickToExpand());
        assertEquals("There should be no mouse listener.", 0, target.getMouseListeners().length);
    }

    /**
     * <p>
     * Tests the <code>setClickToExpand(boolean)</code> for proper behavior. Verifies that click
     * to expand is set.(previous click to expand is true)
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetClickToExpand_boolean4() throws Exception {
        target.setClickToExpand(true);
        // set again
        target.setClickToExpand(true);
        assertEquals("ClickToExpand", true, target.isClickToExpand());
        assertEquals("There should be 1 mouse listener.", 1, target.getMouseListeners().length);
    }

    /**
     * <p>
     * Tests the <code>setExpandIcon(Icon)</code> for proper behavior. Verifies that icon should
     * be set to both upper/lower expandButton.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetExpandIcon_Icon1() throws Exception {
        Icon icon = new ImageIcon();
        target.setExpandIcon(icon);
        assertEquals("new icon", icon, target.getUpperExpandButton().getIcon());
        assertEquals("new icon", icon, target.getLowerExpandButton().getIcon());
    }

    /**
     * <p>
     * Tests the <code>setExpandIcon(Icon)</code> for proper behavior. Verifies null icon is ok.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetExpandIcon_Icon2() throws Exception {
        Icon icon = null;
        target.setExpandIcon(icon);
        assertEquals("new icon", icon, target.getUpperExpandButton().getIcon());
        assertEquals("new icon", icon, target.getLowerExpandButton().getIcon());
    }

    /**
     * <p>
     * Tests the <code>isUpperExpandButtonVisible()</code> for proper behavior. Verifies that
     * UpperExpandButtonVisible is returned correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodIsUpperExpandButtonVisible1() throws Exception {
        assertEquals("UpperExpandButtonVisible", true, target.isUpperExpandButtonVisible());
    }

    /**
     * <p>
     * Tests the <code>isUpperExpandButtonVisible()</code> for proper behavior. Verifies that
     * UpperExpandButtonVisible is returned correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodIsUpperExpandButtonVisible2() throws Exception {
        target.setUpperExpandButtonVisible(false);
        assertEquals("UpperExpandButtonVisible", false, target.isUpperExpandButtonVisible());
    }

    /**
     * <p>
     * Tests the <code>setLowerExpandButton(JButton)</code> for proper behavior. Verifies that
     * field is set, UI is updated, event is fired.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetLowerExpandButton_JButton() throws Exception {
        JButton newValue = new JButton("new");
        JButton oldValue = target.getLowerExpandButton();
        target.setLowerExpandButton(newValue);
        // check field
        assertEquals("LowerExpandButton", newValue, target.getLowerExpandButton());
        assertEquals("buttonListener", TestHelper.getPrivateField(
                DefaultCollapsedSideMenuPanel.class, target, "buttonListener"), newValue
                .getActionListeners()[0]);
        // check UI
        assertEquals("component number", 3, target.getComponentCount());
        assertEquals("new textLabel should be added.", newValue, target.getComponents()[2]);
        // check event
        TestHelper.assertEvent(listener.getEvent(),
                DefaultCollapsedSideMenuPanel.LOWER_EXPAND_BUTTON, oldValue, newValue);
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
     * Tests the <code>getLowerExpandButton()</code> for proper behavior. Verifies that field is
     * returned as is.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetLowerExpandButton() throws Exception {
        assertEquals("lowerExpandButton", TestHelper.getPrivateField(
                DefaultCollapsedSideMenuPanel.class, target, "lowerExpandButton"), target
                .getLowerExpandButton());
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. Verifies that text label is set when SideMenuModel.TITLE event arrived.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent() throws Exception {
        PropertyChangeEvent event = new PropertyChangeEvent(target, SideMenuModel.TITLE, "old",
                "new");
        target.sideMenuModelPropertyChange(event);
        assertEquals("label text", "new", target.getTextLabel().getText());
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
            target.sideMenuModelPropertyChange(null);
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
            target.sideMenuModelPropertyChange(event);
            fail("IllegalArgumentException if value of specific property is invalid.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>getUpperExpandButton()</code> for proper behavior. Verifies that field is
     * returned as is.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetUpperExpandButton() throws Exception {
        assertEquals("upperExpandButton", TestHelper.getPrivateField(
                DefaultCollapsedSideMenuPanel.class, target, "upperExpandButton"), target
                .getUpperExpandButton());
    }
}
