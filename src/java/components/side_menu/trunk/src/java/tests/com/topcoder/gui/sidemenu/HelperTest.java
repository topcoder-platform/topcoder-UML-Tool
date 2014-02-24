/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;

import junit.framework.TestCase;

/**
 * <p>
 * Test class: <code>Helper</code>.
 * </p>
 *
 * @author KingStone
 * @version 1.0
 */
public class HelperTest extends TestCase {
    /**
     * <p>
     * Tests the <code>checkNull(Object, String)</code> for proper behavior.
     * IllegalArgumentException if the given object is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodCheckNull_Object_String() throws Exception {
        try {
            Helper.checkNull(null, "name");
            fail("IllegalArgumentException if the given object is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>checkAbsoluteWidth(int)</code> for proper behavior.
     * IllegalArgumentException if the given absoluteWidth is 0.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodCheckAbsoluteWidth_int1() throws Exception {
        try {
            Helper.checkAbsoluteWidth(0);
            fail("IllegalArgumentException if the given absoluteWidth is 0.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>checkAbsoluteWidth(int)</code> for proper behavior.
     * IllegalArgumentException if the given absoluteWidth is < -1.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodCheckAbsoluteWidth_int2() throws Exception {
        try {
            Helper.checkAbsoluteWidth(-2);
            fail("IllegalArgumentException if the given absoluteWidth is < -1.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>checkString(String, String)</code> for proper behavior.
     * IllegalArgumentException if the given string is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodCheckString_String_String1() throws Exception {
        try {
            Helper.checkString(null, "name");
            fail("IllegalArgumentException if the given string is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>checkString(String, String)</code> for proper behavior.
     * IllegalArgumentException if the given string is empty.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodCheckString_String_String2() throws Exception {
        try {
            Helper.checkString("   ", "name");
            fail("IllegalArgumentException if the given string is empty.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>checkComponent(JComponent, SideMenuModel, String)</code> for proper behavior.
     * IllegalArgumentException if the given string is component.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodcheckComponent1() throws Exception {
        try {
            SideMenuModel model = new DefaultSideMenuModel("tt");
            Helper.checkComponent(null, model, "new component");
            fail("IllegalArgumentException if the given string is component.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>checkComponent(JComponent, SideMenuModel, String)</code> for proper behavior.
     * IllegalArgumentException if the new component contains different sideMenuModel.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodcheckComponent2() throws Exception {
        try {
            SideMenuModel model = new DefaultSideMenuModel("tt");
            JComponent component = new DefaultCollapsedSideMenuPanel(new DefaultSideMenuModel("cc"));
            Helper.checkComponent(component, model, "new component");
            fail("IllegalArgumentException if the new component contains different sideMenuModel.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>checkState(SideMenuModel)</code> for proper behavior. IllegalStateException
     * if sideMenuModel is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodcheckState() throws Exception {
        try {
            Helper.checkState(null);
            fail("IllegalStateException if sideMenuModel is null.");
        } catch (IllegalStateException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setButton()</code> for proper behavior. button is set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodsetButton() throws Exception {
        AbstractButton button = new JButton();
        Icon icon = TestHelper.COLLAPSE_ICON;
        ActionListener buttonListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        };
        Helper.setButton(button, icon, buttonListener);

        // check fields
        assertEquals("icon", icon, button.getIcon());
        assertEquals("ContentAreaFilled", false, button.isContentAreaFilled());
        assertEquals("buttonListener", buttonListener, button.getActionListeners()[0]);
    }

}
