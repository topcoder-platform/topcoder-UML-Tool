/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu.accuracytests;

import java.beans.PropertyChangeListener;

import junit.framework.TestCase;

import com.topcoder.event.manager.EventManager;
import com.topcoder.gui.sidemenu.DefaultSideMenuModel;
import com.topcoder.gui.sidemenu.SideMenuModel;

/**
 * <p>
 * Accuracy test class: <code>DefaultSideMenuModel</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultSideMenuModelTest extends TestCase {
    /**
     * <p>
     * An instance of <code>DefaultSideMenuModel</code> which is tested.
     * </p>
     */
    private DefaultSideMenuModel target = null;

    /**
     * <p>
     * An expanded flag used in tests.
     * </p>
     */
    private boolean expanded = true;

    /**
     * <p>
     * A floating flag used in tests.
     * </p>
     */
    private boolean floating = true;

    /**
     * <p>
     * An absoluteWidth used in tests.
     * </p>
     */
    private int absoluteWidth = 323;

    /**
     * <p>
     * setUp() routine.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        target = new DefaultSideMenuModel(TestHelper.TITLE, expanded, floating, absoluteWidth);
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies <code>DefaultSideMenuModel</code> implements <code>SideMenuModel</code>.
     * </p>
     */
    public void testInheritance() {
        assertTrue("DefaultSideMenuModel does not implements SideMenuModel.",
                target instanceof SideMenuModel);
    }

    /**
     * <p>
     * Tests the <code>DefaultSideMenuModel(String, boolean, boolean, int)</code> for proper
     * behavior. Verifies that all fields are set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_boolean_boolean_int() throws Exception {
        // check fields
        assertSideMenuModel(TestHelper.TITLE, expanded, floating, absoluteWidth);
    }

    /**
     * This method check SideMenuModel.
     *
     * @param title
     *            the title
     * @param expanded
     *            if expanded
     * @param floating
     *            if floating
     * @param absoluteWidth
     *            the absolute width
     */
    private void assertSideMenuModel(String title, boolean expanded, boolean floating,
            int absoluteWidth) {
        assertEquals("title", title, target.getTitle());
        assertEquals("expanded", expanded, target.isExpanded());
        assertEquals("floating", floating, target.isFloating());
        assertEquals("absoluteWidth", absoluteWidth, target.getAbsoluteWidth());
        PropertyChangeListener listeners = (PropertyChangeListener) TestHelper.getPrivateField(
                DefaultSideMenuModel.class, target, "listeners");
        assertTrue("listeners should be instance of EventManager.",
                listeners instanceof EventManager);
    }

    /**
     * <p>
     * Tests the <code>com.topcoder.gui.sidemenu.DefaultSideMenuModel(String)</code> for proper
     * behavior. Verifies that fields are set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String() throws Exception {
        target = new DefaultSideMenuModel(TestHelper.TITLE);
        assertSideMenuModel(TestHelper.TITLE, false, false, -1);
    }

    /**
     * <p>
     * Tests the <code>getAbsoluteWidth()</code> for proper behavior.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetAbsoluteWidth() throws Exception {
        assertEquals("absoluteWidth", absoluteWidth, target.getAbsoluteWidth());
    }

    /**
     * <p>
     * Tests the <code>addPropertyChangeListener(PropertyChangeListener)</code> for proper
     * behavior.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodAddPropertyChangeListener_PropertyChangeListener1() throws Exception {
        PropertyChangeListener listener = new MyPropertyChangeListener();
        target.addPropertyChangeListener(listener);
        EventManager listeners = (EventManager) TestHelper.getPrivateField(
                DefaultSideMenuModel.class, target, "listeners");
        assertTrue("PropertyChangeListener should be added.", listeners.getListeners().contains(
                listener));
    }
    
    /**
     * <p>
     * Tests the <code>addPropertyChangeListener(PropertyChangeListener)</code> for proper
     * behavior. add listener for 2 times.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodAddPropertyChangeListener_PropertyChangeListener2() throws Exception {
        PropertyChangeListener listener = new MyPropertyChangeListener();
        target.addPropertyChangeListener(listener);
        // add listener again
        target.addPropertyChangeListener(listener);
        // check result
        EventManager listeners = (EventManager) TestHelper.getPrivateField(
                DefaultSideMenuModel.class, target, "listeners");
        assertTrue("PropertyChangeListener should be added.", listeners.getListeners().contains(
                listener));
    }

    /**
     * <p>
     * Tests the <code>setAbsoluteWidth(int)</code> for proper behavior. Verifies that filed is
     * set and PropertyChangeEvent is fired.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetAbsoluteWidth_int() throws Exception {
        int newAbsoluteWidth = absoluteWidth + 1;
        MyPropertyChangeListener myPropertyChangeListener = new MyPropertyChangeListener();
        target.addPropertyChangeListener(myPropertyChangeListener);
        target.setAbsoluteWidth(newAbsoluteWidth);
        // check field
        assertEquals("absoluteWidth", newAbsoluteWidth, target.getAbsoluteWidth());
        // check PropertyChangeEvent fired
        TestHelper.assertEvent(myPropertyChangeListener.getEvent(),
                DefaultSideMenuModel.ABSOLUTE_WIDTH, absoluteWidth, newAbsoluteWidth);
    }

    /**
     * <p>
     * Tests the <code>setTitle(String)</code> for proper behavior. Verifies that filed is set and
     * PropertyChangeEvent is fired.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetTitle_String() throws Exception {
        String newTitle = "new title";
        MyPropertyChangeListener myPropertyChangeListener = new MyPropertyChangeListener();
        target.addPropertyChangeListener(myPropertyChangeListener);
        target.setTitle(newTitle);
        // check field
        assertEquals("title", newTitle, target.getTitle());
        // check PropertyChangeEvent fired
        TestHelper.assertEvent(myPropertyChangeListener.getEvent(), DefaultSideMenuModel.TITLE,
                TestHelper.TITLE, newTitle);
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
        assertEquals("expanded", expanded, target.isExpanded());
    }

    /**
     * <p>
     * Tests the <code>setExpanded(boolean)</code> for proper behavior. Verifies that filed is set
     * and PropertyChangeEvent is fired.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetExpanded_boolean() throws Exception {
        boolean newExpanded = false;
        MyPropertyChangeListener myPropertyChangeListener = new MyPropertyChangeListener();
        target.addPropertyChangeListener(myPropertyChangeListener);
        target.setExpanded(newExpanded);
        // check field
        assertEquals("expanded", newExpanded, target.isExpanded());
        // check PropertyChangeEvent fired
        TestHelper.assertEvent(myPropertyChangeListener.getEvent(), DefaultSideMenuModel.EXPANDED,
                expanded, newExpanded);
    }

    /**
     * <p>
     * Tests the <code>setFloating(boolean)</code> for proper behavior. Verifies that filed is set
     * and PropertyChangeEvent is fired.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetFloating_boolean() throws Exception {
        boolean newFloating = false;
        MyPropertyChangeListener myPropertyChangeListener = new MyPropertyChangeListener();
        target.addPropertyChangeListener(myPropertyChangeListener);
        target.setFloating(newFloating);
        // check field
        assertEquals("floating", newFloating, target.isFloating());
        // check PropertyChangeEvent fired
        TestHelper.assertEvent(myPropertyChangeListener.getEvent(), DefaultSideMenuModel.FLOATING,
                floating, newFloating);
    }

    /**
     * <p>
     * Tests the <code>removePropertyChangeListener(PropertyChangeListener)</code> for proper
     * behavior.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodRemovePropertyChangeListener_PropertyChangeListener() throws Exception {
        MyPropertyChangeListener myPropertyChangeListener = new MyPropertyChangeListener();
        target.addPropertyChangeListener(myPropertyChangeListener);
        target.removePropertyChangeListener(myPropertyChangeListener);
        EventManager listeners = (EventManager) TestHelper.getPrivateField(
                DefaultSideMenuModel.class, target, "listeners");
        // check removed
        assertFalse("myPropertyChangeListener should be removed.", listeners
                .containsListener(myPropertyChangeListener));
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
     * Tests the <code>isFloating()</code> for proper behavior.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodIsFloating() throws Exception {
        assertEquals("floating", floating, target.isFloating());
    }

}
