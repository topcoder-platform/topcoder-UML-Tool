/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu;

import java.beans.PropertyChangeEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import junit.framework.TestCase;

/**
 * <p>
 * Test class: <code>DefaultExpandedSideMenuPanel</code>.
 * </p>
 *
 * @author KingStone
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
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies <code>DefaultExpandedSideMenuPanel</code> subclasses
     * <code>AbstractSideMenuPanel</code>.
     * </p>
     */
    public void testInheritance() {
        assertTrue("DefaultExpandedSideMenuPanel does not subclasses AbstractSideMenuPanel.",
                target instanceof AbstractSideMenuPanel);
    }

    /**
     * <p>
     * Tests the <code>DefaultExpandedSideMenuPanel(SideMenuModel, JComponent, Icon, Icon)</code>
     * for proper behavior. Verifies that all fields are set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_JComponent_Icon_Icon() throws Exception {
        assertEquals("sideMenuModel", sideMenuModel, target.getSideMenuModel());
        checkDefaultExpandedSideMenuPanel(TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
    }

    /**
     * This method check DefaultExpandedSideMenuPanel.
     * @param collapseIcon the collapse icon
     * @param pinIcon the pin icon
     */
    private void checkDefaultExpandedSideMenuPanel(Icon collapseIcon, Icon pinIcon) {
        Object buttonListener = TestHelper.getPrivateField(DefaultExpandedSideMenuPanel.class,
                target, "buttonListener");
        assertNotNull("buttonListener", buttonListener);
        assertEquals("content", TestHelper.CONTENT, target.getContent());
        assertEquals("CollapseIcon", collapseIcon, target.getCollapseIcon());
        assertEquals("PinIcon", pinIcon, target.getPinIcon());
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
     * proper behavior. Verifies that all fields are set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_JComponent_Icon() throws Exception {
        target = new DefaultExpandedSideMenuPanel(sideMenuModel, TestHelper.CONTENT,
                TestHelper.COLLAPSE_ICON);
        checkDefaultExpandedSideMenuPanel(TestHelper.COLLAPSE_ICON, null);
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
     * behavior. Verifies that all fileds are set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_JComponent() throws Exception {
        target = new DefaultExpandedSideMenuPanel(sideMenuModel, TestHelper.CONTENT);
        checkDefaultExpandedSideMenuPanel(null, null);
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
     * Tests the <code>getTextLabel()</code> for proper behavior.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetTextLabel() throws Exception {
        assertEquals("textLabel", TestHelper.getPrivateField(DefaultExpandedSideMenuPanel.class,
                target, "textLabel"), target.getTextLabel());
    }

    /**
     * <p>
     * Tests the <code>setContent(JComponent)</code> for proper behavior. Verifies that field is
     * set, container is updated, property change event is fired.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetContent_JComponent() throws Exception {
        JComponent content = new JPanel();
        target.setContent(content);
        // check field
        assertEquals("Content", content, target.getContent());
        PropertyChangeEvent event = listener.getEvent();
        TestHelper.assertEvent(event, DefaultExpandedSideMenuPanel.CONTENT_COMPONENT,
                TestHelper.CONTENT, content);
        // check container
        assertEquals("only 4 components there should be.", 4, target.getComponentCount());
        assertEquals("content", content, target.getComponents()[3]);
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
     * Tests the <code>getContent()</code> for proper behavior.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetContent() throws Exception {
        assertEquals("content", TestHelper.CONTENT, target.getContent());
    }

    /**
     * <p>
     * Tests the <code>setCollapseButton(JButton)</code> for proper behavior. Verifies that field
     * is set, action listener should be removed, container is updated, property change event is
     * fired.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetCollapseButton_JButton() throws Exception {
        JButton button = new JButton();
        JButton oldButton = (JButton) TestHelper.getPrivateField(
                DefaultExpandedSideMenuPanel.class, target, "collapseButton");
        target.setCollapseButton(button);
        // check field
        assertEquals("CollapseButton", button, target.getCollapseButton());
        // check old button
        assertEquals("action listener should be removed.", 0, oldButton.getActionListeners().length);
        PropertyChangeEvent event = listener.getEvent();
        TestHelper.assertEvent(event, DefaultExpandedSideMenuPanel.COLLAPSE_BUTTON, oldButton,
                button);
        // check container
        assertEquals("only 4 components there should be.", 4, target.getComponentCount());
        assertEquals("content", button, target.getComponents()[3]);
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
     * Tests the <code>getPinButton()</code> for proper behavior. Verifies that field is returned
     * as it is.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetPinButton() throws Exception {
        assertEquals("pin buttion", TestHelper.getPrivateField(DefaultExpandedSideMenuPanel.class,
                target, "pinButton"), target.getPinButton());
    }

    /**
     * <p>
     * Tests the <code>getPinIcon()</code> for proper behavior. Verifies that field is returned as
     * it is.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetPinIcon() throws Exception {
        assertEquals("pinIcon", TestHelper.PIN_ICON, target.getPinIcon());
    }

    /**
     * <p>
     * Tests the <code>getCollapseButton()</code> for proper behavior. Verifies that field is
     * returned as it is.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetCollapseButton() throws Exception {
        assertEquals("collapseButton", TestHelper.getPrivateField(
                DefaultExpandedSideMenuPanel.class, target, "collapseButton"), target
                .getCollapseButton());
    }

    /**
     * <p>
     * Tests the <code>setTextLabel(JLabel)</code> for proper behavior.Verifies that field is set,
     * container is updated, title is set, property change event is fired.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetTextLabel_JLabel() throws Exception {
        JLabel label = new JLabel("new");
        JLabel old = target.getTextLabel();
        target.setTextLabel(label);
        // check field
        assertEquals("new lable", label, target.getTextLabel());
        assertEquals("title", TestHelper.TITLE, target.getTextLabel().getText());
        PropertyChangeEvent event = listener.getEvent();
        TestHelper.assertEvent(event, DefaultExpandedSideMenuPanel.TEXT_LABEL, old, label);
        // check container
        assertEquals("only 4 components there should be.", 4, target.getComponentCount());
        assertEquals("label", label, target.getComponents()[3]);
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
     * Tests the <code>setCollapseIcon(Icon)</code> for proper behavior. Verifies that field is
     * set as is.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetCollapseIcon_Icon() throws Exception {
        Icon icon = new ImageIcon();
        target.setCollapseIcon(icon);
        assertEquals("collapse icon", icon, target.getCollapseIcon());
    }

    /**
     * <p>
     * Tests the <code>setPinButton(JToggleButton)</code> for proper behavior. Verifies that field
     * is set, action listener should be removed, container is updated, property change event is
     * fired.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetPinButton_JToggleButton() throws Exception {
        JToggleButton button = new JToggleButton();
        JToggleButton oldButton = (JToggleButton) TestHelper.getPrivateField(
                DefaultExpandedSideMenuPanel.class, target, "pinButton");
        target.setPinButton(button);
        // check field
        assertEquals("pinButton", button, target.getPinButton());
        // check old button
        assertEquals("action listener should be removed.", 0, oldButton.getActionListeners().length);
        PropertyChangeEvent event = listener.getEvent();
        TestHelper.assertEvent(event, DefaultExpandedSideMenuPanel.PIN_BUTTON, oldButton, button);
        // check container
        assertEquals("only 4 components there should be.", 4, target.getComponentCount());
        assertEquals("content", button, target.getComponents()[3]);
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. Verifies that TextLabel is updated.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent1() throws Exception {
        Object newValue = "new";
        Object oldValue = "old";
        PropertyChangeEvent event = new PropertyChangeEvent(new Object(), SideMenuModel.TITLE,
                oldValue, newValue);
        target.sideMenuModelPropertyChange(event);
        // check result
        assertEquals("title", newValue, target.getTextLabel().getText());
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. Verifies that TextLabel is updated.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent2() throws Exception {
        Object newValue = true;
        Object oldValue = false;
        PropertyChangeEvent event = new PropertyChangeEvent(new Object(), SideMenuModel.FLOATING,
                oldValue, newValue);
        target.sideMenuModelPropertyChange(event);
        // check result
        assertEquals("pin button selected", true, target.getPinButton().isSelected());
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
            target.sideMenuModelPropertyChange(null);
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
            target.sideMenuModelPropertyChange(event);
            fail("IllegalArgumentException if value of property is invalid.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setPinIcon(Icon)</code> for proper behavior. Verifies that field is set as
     * is.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetPinIcon_Icon() throws Exception {
        Icon icon = new ImageIcon();
        target.setPinIcon(icon);
        assertEquals("pinIcon", icon, target.getPinIcon());
    }

    /**
     * <p>
     * Tests the <code>getCollapseIcon()</code> for proper behavior. Verifies that field is got as
     * is.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetCollapseIcon() throws Exception {
        assertEquals("collapseIcon", TestHelper.COLLAPSE_ICON, target.getCollapseIcon());
    }
}
