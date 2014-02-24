/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu.accuracytests;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;

import javax.swing.JPanel;

import junit.framework.TestCase;

import com.topcoder.event.manager.EventManager;
import com.topcoder.gui.sidemenu.AbstractSideMenuPanel;
import com.topcoder.gui.sidemenu.DefaultSideMenuModel;
import com.topcoder.gui.sidemenu.SideMenuModel;

/**
 * <p>
 * Accuracy test class: <code>AbstractSideMenuPanel</code>.
 * </p>
 *
 * @author TCSDEVELOPER
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
    private SideMenuModel sideMenuModel;

    /**
     * <p>
     * An instance of <code>MyPropertyChangeListener</code> used in tests.
     * </p>
     */
    private MyPropertyChangeListener myPropertyChangeListener;

    /**
     * <p>
     * setUp() routine.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        myPropertyChangeListener = new MyPropertyChangeListener();
        sideMenuModel = new DefaultSideMenuModel("Side Menu");
        target = new MyAbstractSideMenuPanel(sideMenuModel);
        // add a myPropertyChangeListener to get the PropertyChangeEvent
        target.addPropertyChangeListener(myPropertyChangeListener);
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
     * Tests the <code>AbstractSideMenuPanel(SideMenuModel)</code> for proper behavior. Verify
     * that propertyChangeListener is created, sideMenuModel is set and listener should be added to
     * sideMenuModel.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_SideMenuModel() throws Exception {
        assertEquals("sideMenuModel is invalid.", sideMenuModel, target.getSideMenuModel());
        PropertyChangeListener listener = (PropertyChangeListener) TestHelper.getPrivateField(
                AbstractSideMenuPanel.class, target, "propertyChangeListener");
        // check listener
        assertNotNull("propertyChangeListener should be set.", listener);
        listener.propertyChange(new PropertyChangeEvent(target,
                AbstractSideMenuPanel.SIDE_MENU_MODEL, null, null));
        assertTrue("Method SideMenuModelPropertyChange should be called.",
                ((MyAbstractSideMenuPanel) target).isSideMenuModelPropertyChangeCalled());
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
     * Tests the <code>setSideMenuModel(SideMenuModel)</code> for proper behavior.
     * </p>
     * <p>
     * SideMenuModel: non-null SideMenuModel instance
     * </p>
     * <p>
     * Verifies that sideMenuModel should be set correctly, listener should be removed from old one,
     * listener should be added to new one, event should be fired, and sideMenuModelPropertyChange
     * should be called.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetSideMenuModel_SideMenuModel1() throws Exception {
        PropertyChangeListener listener = (PropertyChangeListener) TestHelper.getPrivateField(
                AbstractSideMenuPanel.class, target, "propertyChangeListener");
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
        // sideMenuModelPropertyChange should be called
        assertTrue("sideMenuModelPropertyChange should be called.",
                ((MyAbstractSideMenuPanel) target).isSideMenuModelPropertyChangeCalled());
    }

    /**
     * <p>
     * Tests the <code>setSideMenuModel(SideMenuModel)</code> for proper behavior.
     * </p>
     * <p>
     * SideMenuModel: null
     * </p>
     * <p>
     * Verifies that null sideMenuModel should be set correctly, listener should be removed from old
     * one, listener should not be added to new one, event should be fired, and
     * sideMenuModelPropertyChange should be called.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetSideMenuModel_SideMenuModel2() throws Exception {
        SideMenuModel newSideMenuModel = null;
        target.setSideMenuModel(newSideMenuModel);
        // check fields
        assertEquals("sideMenuModel set incorrectly.", newSideMenuModel, target.getSideMenuModel());
        Collection<?> listeners = ((EventManager) TestHelper.getPrivateField(
                DefaultSideMenuModel.class, sideMenuModel, "listeners")).getListeners();
        assertEquals("propertyChangeListener should be removed from old sideMenuModel.", 0,
                listeners.size());
        // check firePropertyChange
        PropertyChangeEvent event = myPropertyChangeListener.getEvent();
        TestHelper.assertEvent(event, AbstractSideMenuPanel.SIDE_MENU_MODEL, sideMenuModel,
                newSideMenuModel);
        // sideMenuModelPropertyChange should be called
        assertTrue("sideMenuModelPropertyChange should be called.",
                ((MyAbstractSideMenuPanel) target).isSideMenuModelPropertyChangeCalled());
    }

    /**
     * <p>
     * Tests the <code>setSideMenuModel(SideMenuModel)</code> for proper behavior.
     * </p>
     * <p>
     * SideMenuModel: non-null SideMenuModel instance, but the old SideMenuModel is null.
     * </p>
     * <p>
     * Verifies that sideMenuModel should be set correctly, listener should be removed from old one,
     * listener should be added to new one, event should be fired, and sideMenuModelPropertyChange
     * should be called.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetSideMenuModel_SideMenuModel3() throws Exception {
        // set SideMenuModel to null
        target.setSideMenuModel(null);
        PropertyChangeListener listener = (PropertyChangeListener) TestHelper.getPrivateField(
                AbstractSideMenuPanel.class, target, "propertyChangeListener");
        SideMenuModel newSideMenuModel = new DefaultSideMenuModel("xxxx");
        target.setSideMenuModel(newSideMenuModel);
        // check fields
        assertEquals("sideMenuModel set incorrectly.", newSideMenuModel, target.getSideMenuModel());
        Collection<?> listeners = ((EventManager) TestHelper.getPrivateField(
                DefaultSideMenuModel.class, newSideMenuModel, "listeners")).getListeners();
        assertEquals("propertyChangeListener should be added to new sideMenuModel.", 1, listeners
                .size());
        assertTrue("propertyChangeListener should be added to new sideMenuModel.", listeners
                .contains(listener));
        // check firePropertyChange
        PropertyChangeEvent event = myPropertyChangeListener.getEvent();
        TestHelper
                .assertEvent(event, AbstractSideMenuPanel.SIDE_MENU_MODEL, null, newSideMenuModel);
        // sideMenuModelPropertyChange should be called
        assertTrue("sideMenuModelPropertyChange should be called.",
                ((MyAbstractSideMenuPanel) target).isSideMenuModelPropertyChangeCalled());
    }

    /**
     * <p>
     * Tests the <code>getSideMenuModel()</code> for proper behavior. Verifies that sideMenuModel
     * should return correctly.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodGetSideMenuModel() throws Exception {
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
        ((MyAbstractSideMenuPanel) target).sideMenuModelPropertyChange(event);
        // nothing happen
    }

}
