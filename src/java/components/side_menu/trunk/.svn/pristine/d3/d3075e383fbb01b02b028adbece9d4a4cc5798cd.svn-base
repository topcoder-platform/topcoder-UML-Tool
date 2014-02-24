/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu;

import java.beans.PropertyChangeEvent;
import java.util.Collection;

import javax.swing.JPanel;

import junit.framework.TestCase;

import com.topcoder.event.manager.EventManager;

/**
 * <p>
 * Test class: <code>AbstractSideMenuPanel</code>.
 * </p>
 *
 * @author KingStone
 * @version 1.0
 */
public class AbstractSideMenuPanelTest extends TestCase {
    /**
     * <p>
     * An instance of <code>AbstractSideMenuPanel</code> which is tested.
     * </p>
     */
    private AbstractSideMenuPanel target = null;

    /**
     * <p>
     * An instance of <code>SideMenuModel</code> used in tests.
     * </p>
     */
    private SideMenuModel sideMenuModel = null;

    /**
     * <p>
     * setUp() routine.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        sideMenuModel = new DefaultSideMenuModel("Side Menu");
        target = new MySideMenuPanel(sideMenuModel);
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies <code>AbstractSideMenuPanel</code> subclasses <code>JPanel</code>.
     * </p>
     */
    public void testInheritance() {
        assertTrue("AbstractSideMenuPanel does not subclasses JPanel.", target instanceof JPanel);
    }

    /**
     * <p>
     * Tests the <code>com.topcoder.gui.sidemenu.AbstractSideMenuPanel(SideMenuModel)</code> for
     * proper behavior.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel() throws Exception {
        assertEquals("sideMenuModel is invalid.", sideMenuModel, target.getSideMenuModel());
        Object listener = TestHelper.getPrivateField(AbstractSideMenuPanel.class, target,
                "propertyChangeListener");
        assertNotNull("propertyChangeListener should be set.", listener);
        // check sideMenuModel
        Collection<?> listeners = ((EventManager) TestHelper.getPrivateField(
                DefaultSideMenuModel.class, sideMenuModel, "listeners")).getListeners();
        assertEquals("1 propertyChangeListener should be added to sideMenuModel.", 1, listeners
                .size());
        assertTrue("propertyChangeListener should be added to sideMenuModel.", listeners
                .contains(listener));
    }

    /**
     * <p>
     * Tests the <code>com.topcoder.gui.sidemenu.AbstractSideMenuPanel(SideMenuModel)</code> for
     * proper behavior. Verifies that IllegalArgumentException if sideMenuModel is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel_failure1() throws Exception {
        try {
            new MySideMenuPanel(null);
            fail("IllegalArgumentException if sideMenuModel is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setSideMenuModel(SideMenuModel)</code> for proper behavior. Verifies that
     * sideMenuModel should be set correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetSideMenuModel_SideMenuModel() throws Exception {
        MyPropertyChangeListener myPropertyChangeListener = new MyPropertyChangeListener();
        Object listener = TestHelper.getPrivateField(AbstractSideMenuPanel.class, target,
                "propertyChangeListener");
        target.addPropertyChangeListener(myPropertyChangeListener);
        SideMenuModel newSideMenuModel = new DefaultSideMenuModel("xxxx");
        target.setSideMenuModel(newSideMenuModel);
        // check fields
        assertEquals("sideMenuModel set incorrectly.", newSideMenuModel, target.getSideMenuModel());
        Collection<?> listeners = ((EventManager) TestHelper.getPrivateField(
                DefaultSideMenuModel.class, sideMenuModel, "listeners")).getListeners();
        assertEquals("propertyChangeListener should be removed from old sideMenuModel.", 0,
                listeners.size());
        listeners = ((EventManager) TestHelper.getPrivateField(DefaultSideMenuModel.class,
                newSideMenuModel, "listeners")).getListeners();
        assertEquals("propertyChangeListener should be added to new sideMenuModel.", 1, listeners
                .size());
        assertTrue("propertyChangeListener should be added to new sideMenuModel.", listeners
                .contains(listener));
        // check firePropertyChange
        PropertyChangeEvent event = myPropertyChangeListener.getEvent();
        TestHelper.assertEvent(event, AbstractSideMenuPanel.SIDE_MENU_MODEL, sideMenuModel,
                newSideMenuModel);
    }

    /**
     * <p>
     * Tests the <code>setSideMenuModel(SideMenuModel)</code> for proper behavior. Verifies that
     * IllegalArgumentException unexpected if sideMenuModel is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetSideMenuModel_SideMenuModel_failure1() throws Exception {
        try {
            target.setSideMenuModel(null);
            // ok
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException unexpected if sideMenuModel is null.");
        }
    }

    /**
     * <p>
     * Tests the <code>getSideMenuModel()</code> for proper behavior. Verifies that sideMenuModel
     * should returned correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetSideMenuModel() throws Exception {
        target.setSideMenuModel(sideMenuModel);
        assertEquals("sideMenuModel get incorrectly.", sideMenuModel, target.getSideMenuModel());
    }

    /**
     * <p>
     * Tests the <code>sideMenuModelPropertyChange(PropertyChangeEvent)</code> for proper
     * behavior.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSideMenuModelPropertyChange_PropertyChangeEvent() throws Exception {
        PropertyChangeEvent event = new PropertyChangeEvent(new Object(), "name", new Object(),
                new Object());
        target.sideMenuModelPropertyChange(event);
        // nothing happen
    }

}
