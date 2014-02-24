/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for PropertiesPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class PropertiesPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * The constant represents namespace for testing.
     * </p>
     */
    private static final String NAMESPACE = "com.topcoder.gui.panels.properties";

    /**
     * <p>
     * PropertiesPanel instance for testing.
     * </p>
     */
    private PropertiesPanel instance;

    /**
     * <p>
     * UMLModelManager instance for testing.
     * </p>
     */
    private UMLModelManager manager;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadXMLConfig(AccuracyTestsHelper.CONFIG_FILE);
        manager = new UMLModelManager();
        instance = new PropertiesPanel(manager);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        instance = null;
        manager = null;
        AccuracyTestsHelper.clearConfig();
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(PropertiesPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(String,UMLModelManager) for accuracy.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor1() throws Exception {
        assertNotNull("Failed to create PropertiesPanel instance.", new PropertiesPanel(NAMESPACE, manager));
    }

    /**
     * <p>
     * Tests ctor PropertiesPanel#PropertiesPanel(UMLModelManager) for accuracy.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create PropertiesPanel instance.", instance);
    }

    /**
     * <p>
     * Tests PropertiesPanel#configurePanel(List) for accuracy.
     * </p>
     */
    public void testConfigurePanel1() {
        Package packageObject = new PackageImpl();
        List<ModelElement> modelElements = new ArrayList<ModelElement>();
        modelElements.add(packageObject);
        instance.configurePanel(modelElements);

        assertEquals("Failed to configure the panel.", 4, ((JPanel) instance.getComponent(0)).getComponentCount());
        assertEquals("Failed to configure the panel.", 1, ((JPanel) instance.getComponent(1)).getComponentCount());
    }

    /**
     * <p>
     * Tests PropertiesPanel#configurePanel(ModelElement) for accuracy.
     * </p>
     */
    public void testConfigurePanel2() {
        instance.configurePanel(new PackageImpl());

        assertEquals("Failed to configure the panel.", 4, ((JPanel) instance.getComponent(0)).getComponentCount());
        assertEquals("Failed to configure the panel.", 1, ((JPanel) instance.getComponent(1)).getComponentCount());
    }

    /**
     * <p>
     * Tests PropertiesPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        Package packageObject = new PackageImpl();
        instance.configurePanel(packageObject);

        assertEquals("Failed to configure the left panel.", 4, ((JPanel) instance.getComponent(0)).getComponentCount());
        assertEquals("Failed to configure the right panel.", 1,
            ((JPanel) instance.getComponent(1)).getComponentCount());
    }

    /**
     * <p>
     * Tests PropertiesPanel#getUMLModelManager() for accuracy.
     * </p>
     */
    public void testGetUMLModelManager() {
        assertSame("Failed to get the UMLModelManager.", manager, instance.getUMLModelManager());
    }

    /**
     * <p>
     * Tests PropertiesPanel#configureProject(UMLModelManager) for accuracy.
     * </p>
     */
    public void testConfigureProject() {
        UMLModelManager umlModelManager = new UMLModelManager();
        instance.configureProject(umlModelManager);

        assertSame("Failed to configure project.", umlModelManager, instance.getUMLModelManager());
    }

    /**
     * <p>
     * Tests PropertiesPanel#firePropertyChangeEvent(ModelElement,PropertyKind,PropertyOperation,Object) for accuracy.
     * </p>
     */
    public void testFirePropertyChangeEvent() {
        ModelElementChangeListenerMock listener = new ModelElementChangeListenerMock();
        instance.addModelElementChangeListener(listener);
        instance.firePropertyChangeEvent(new GuardImpl(), PropertyKind.ACTIVE, PropertyOperation.MODIFY, "accuracy");
        assertTrue("Failed to fire the event.", listener.IsCalled());
    }

    /**
     * <p>
     * Tests PropertiesPanel#fireSelectionChangeEvent(ModelElement) for accuracy.
     * </p>
     */
    public void testFireSelectionChangeEvent() {
        ModelElementSelectionListenerMock listener = new ModelElementSelectionListenerMock();
        instance.addModelElementSelectionListener(listener);
        instance.fireSelectionChangeEvent(new GuardImpl());
        assertTrue("Failed to fire the event.", listener.IsCalled());
    }

    /**
     * <p>
     * Tests PropertiesPanel#addModelElementChangeListener(ModelElementChangeListener) for accuracy.
     * </p>
     */
    public void testAddModelElementChangeListener() {
        ModelElementChangeListenerMock listener = new ModelElementChangeListenerMock();
        instance.addModelElementChangeListener(listener);
        instance.firePropertyChangeEvent(new GuardImpl(), PropertyKind.ACTIVE, PropertyOperation.MODIFY, "accuracy");
        assertTrue("Failed to add the listener.", listener.IsCalled());
    }

    /**
     * <p>
     * Tests PropertiesPanel#removeModelElementChangeListener(ModelElementChangeListener) for accuracy.
     * </p>
     */
    public void testRemoveModelElementChangeListener() {
        ModelElementChangeListenerMock listener = new ModelElementChangeListenerMock();
        instance.addModelElementChangeListener(listener);
        instance.removeModelElementChangeListener(listener);
        instance.firePropertyChangeEvent(new GuardImpl(), PropertyKind.ACTIVE, PropertyOperation.MODIFY, "accuracy");
        assertFalse("Failed to remove the listener.", listener.IsCalled());
    }

    /**
     * <p>
     * Tests PropertiesPanel#removeAllModelElementChangeListeners() for accuracy.
     * </p>
     */
    public void testRemoveAllModelElementChangeListeners() {
        ModelElementChangeListenerMock listener = new ModelElementChangeListenerMock();
        instance.addModelElementChangeListener(listener);
        instance.removeAllModelElementChangeListeners();
        instance.firePropertyChangeEvent(new GuardImpl(), PropertyKind.ACTIVE, PropertyOperation.MODIFY, "accuracy");
        assertFalse("Failed to remove the listener.", listener.IsCalled());
    }

    /**
     * <p>
     * Tests PropertiesPanel#addModelElementSelectionListener(ModelElementSelectionListener) for accuracy.
     * </p>
     */
    public void testAddModelElementSelectionListener() {
        ModelElementSelectionListenerMock listener = new ModelElementSelectionListenerMock();
        instance.addModelElementSelectionListener(listener);
        instance.fireSelectionChangeEvent(new GuardImpl());
        assertTrue("Failed to fire the event.", listener.IsCalled());
    }

    /**
     * <p>
     * Tests PropertiesPanel#removeModelElementSelectionListener(ModelElementSelectionListener) for accuracy.
     * </p>
     */
    public void testRemoveModelElementSelectionListener() {
        ModelElementSelectionListenerMock listener = new ModelElementSelectionListenerMock();
        instance.addModelElementSelectionListener(listener);
        instance.removeModelElementSelectionListener(listener);
        instance.fireSelectionChangeEvent(new GuardImpl());
        assertFalse("Failed to remove the listener.", listener.IsCalled());
    }

    /**
     * <p>
     * Tests PropertiesPanel#removeAllModelElementSelectionListeners() for accuracy.
     * </p>
     */
    public void testRemoveAllModelElementSelectionListeners() {
        ModelElementSelectionListenerMock listener = new ModelElementSelectionListenerMock();
        instance.addModelElementSelectionListener(listener);
        instance.removeAllModelElementSelectionListeners();
        instance.fireSelectionChangeEvent(new GuardImpl());
        assertFalse("Failed to remove the listener.", listener.IsCalled());
    }

    /**
     * <p>
     * Tests PropertiesPanel#getStereotypes(Class) for accuracy.
     * </p>
     */
    public void testGetStereotypes() {
        assertEquals("Failed to get the stereotypes.", 0, instance.getStereotypes(InterfaceImpl.class).size());
    }

}