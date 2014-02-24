/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu.accuracytests;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import junit.framework.TestCase;

import com.topcoder.gui.sidemenu.AbstractSideMenuPanel;
import com.topcoder.gui.sidemenu.DefaultExpandedSideMenuPanel;
import com.topcoder.gui.sidemenu.DefaultSideMenuModel;
import com.topcoder.gui.sidemenu.SideMenuModel;

/**
 * <p>
 * Accuracy test class: <code>DefaultExpandedSideMenuPanel</code>.
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
        // create target
        target = new DefaultExpandedSideMenuPanel(sideMenuModel, TestHelper.CONTENT,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
        listener = new MyPropertyChangeListener();
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
    public void testConstructor_SideMenuModel_JComponent_Icon_Icon1() throws Exception {
        checkDefaultExpandedSideMenuPanel(TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
    }

    /**
     * <p>
     * Tests the <code>DefaultExpandedSideMenuPanel(SideMenuModel, JComponent, Icon, Icon)</code>
     * for proper behavior. Verifies that null collapseIcon is ok and all fields are set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_JComponent_Icon_Icon2() throws Exception {
        target = new DefaultExpandedSideMenuPanel(sideMenuModel, TestHelper.CONTENT, null,
                TestHelper.PIN_ICON);
        checkDefaultExpandedSideMenuPanel(null, TestHelper.PIN_ICON);
    }

    /**
     * <p>
     * Tests the <code>DefaultExpandedSideMenuPanel(SideMenuModel, JComponent, Icon, Icon)</code>
     * for proper behavior. Verifies that null pinIcon is ok and all fields are set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_JComponent_Icon_Icon3() throws Exception {
        target = new DefaultExpandedSideMenuPanel(sideMenuModel, TestHelper.CONTENT,
                TestHelper.COLLAPSE_ICON, null);
        checkDefaultExpandedSideMenuPanel(TestHelper.COLLAPSE_ICON, null);
    }

    /**
     * This method check DefaultExpandedSideMenuPanel.
     *
     * @param collapseIcon
     *            the collapse icon
     * @param pinIcon
     *            the pin icon
     */
    private void checkDefaultExpandedSideMenuPanel(Icon collapseIcon, Icon pinIcon) {
        assertEquals("sideMenuModel", sideMenuModel, target.getSideMenuModel());
        ActionListener buttonListener = (ActionListener) TestHelper.getPrivateField(
                DefaultExpandedSideMenuPanel.class, target, "buttonListener");
        // check buttonListener
        assertNotNull("buttonListener", buttonListener);
        // ((JToggleButton) target.getPinButton()).setSelected(true);
        // buttonListener.actionPerformed(new ActionEvent(target.getPinButton(), 1, "xxx"));
        // assertEquals("should be floating", true, sideMenuModel.isFloating());
        ((JToggleButton) target.getPinButton()).setSelected(false);
        buttonListener.actionPerformed(new ActionEvent(target.getPinButton(), 1, "xxx"));
        assertEquals("should not be floating", false, sideMenuModel.isFloating());
        buttonListener.actionPerformed(new ActionEvent(target.getCollapseButton(), 1, "xxx"));
        assertEquals("should not be expanded", false, sideMenuModel.isExpanded());
        // check other fields
        assertEquals("content", TestHelper.CONTENT, target.getContent());
        TestHelper.checkButton(target.getCollapseButton(), buttonListener, collapseIcon);
        TestHelper.checkButton(target.getPinButton(), buttonListener, pinIcon);
        assertEquals("Selected status", sideMenuModel.isFloating(), target.getPinButton()
                .isSelected());
        JLabel textLabel = (JLabel) TestHelper.getPrivateField(DefaultExpandedSideMenuPanel.class,
                target, "textLabel");
        assertEquals("text of textLabel", sideMenuModel.getTitle(), textLabel.getText());
        assertEquals("HorizontalAlignment of textLabel", SwingConstants.CENTER, textLabel
                .getHorizontalAlignment());
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
    public void testConstructor_SideMenuModel_JComponent_Icon1() throws Exception {
        target = new DefaultExpandedSideMenuPanel(sideMenuModel, TestHelper.CONTENT,
                TestHelper.COLLAPSE_ICON);
        checkDefaultExpandedSideMenuPanel(TestHelper.COLLAPSE_ICON, null);
    }

    /**
     * <p>
     * Tests the <code>DefaultExpandedSideMenuPanel(SideMenuModel, JComponent, Icon)</code> for
     * proper behavior. Verifies that null collapse icon is ok and all fields are set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_JComponent_Icon2() throws Exception {
        target = new DefaultExpandedSideMenuPanel(sideMenuModel, TestHelper.CONTENT, null);
        checkDefaultExpandedSideMenuPanel(null, null);
    }

    /**
     * <p>
     * Tests the <code>DefaultExpandedSideMenuPanel(SideMenuModel, JComponent)</code> for proper
     * behavior. Verifies that all fields are set correctly.
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
     * behavior. Verifies that TextLabel is updated if propertyName == SideMenuModel.TITLE.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent1() throws Exception {
        target = new MyDefaultExpandedSideMenuPanel(sideMenuModel, TestHelper.CONTENT);
        Object newValue = "new";
        Object oldValue = "old";
        PropertyChangeEvent event = new PropertyChangeEvent(new Object(), SideMenuModel.TITLE,
                oldValue, newValue);
        ((MyDefaultExpandedSideMenuPanel) target).sideMenuModelPropertyChange(event);
        // check result
        assertEquals("title", newValue, target.getTextLabel().getText());
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. Verifies that pinButton is updated if propertyName == SideMenuModel.FLOATING.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent2() throws Exception {
        target = new MyDefaultExpandedSideMenuPanel(sideMenuModel, TestHelper.CONTENT);
        Object newValue = true;
        Object oldValue = false;
        PropertyChangeEvent event = new PropertyChangeEvent(new Object(), SideMenuModel.FLOATING,
                oldValue, newValue);
        ((MyDefaultExpandedSideMenuPanel) target).sideMenuModelPropertyChange(event);
        // check result
        assertEquals("pin button should be selected.", true, target.getPinButton().isSelected());
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. Verifies that if sideMenuModel is null, nothing happen.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent3() throws Exception {
        target = new MyDefaultExpandedSideMenuPanel(sideMenuModel, TestHelper.CONTENT);
        target.setSideMenuModel(null);
        Object newValue = "new";
        Object oldValue = "old";
        PropertyChangeEvent event = new PropertyChangeEvent(new Object(), SideMenuModel.TITLE,
                oldValue, newValue);
        ((MyDefaultExpandedSideMenuPanel) target).sideMenuModelPropertyChange(event);
        // check result
        assertEquals("title should not be changed.", TestHelper.TITLE, target.getTextLabel()
                .getText());
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior. Verifies that if label and pinButton should be updated if propertyName ==
     * SIDE_MENU_MODEL.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent4() throws Exception {
        target = new MyDefaultExpandedSideMenuPanel(sideMenuModel, TestHelper.CONTENT);
        String newTitle = "new model";
        DefaultSideMenuModel newValue = new DefaultSideMenuModel(newTitle);
        newValue.setFloating(true);
        target.setSideMenuModel(newValue);
        PropertyChangeEvent event = new PropertyChangeEvent(new Object(),
                AbstractSideMenuPanel.SIDE_MENU_MODEL, sideMenuModel, newValue);
        ((MyDefaultExpandedSideMenuPanel) target).sideMenuModelPropertyChange(event);
        // check result
        assertEquals("title should be changed.", newTitle, target.getTextLabel().getText());
        assertEquals("pin button should be selected.", true, target.getPinButton().isSelected());
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
