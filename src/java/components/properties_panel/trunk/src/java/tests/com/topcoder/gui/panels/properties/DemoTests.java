/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The unit test class is used for component demonstration.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTests extends TestCase {
    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestHelper.loadConfigurations();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DemoTests.class);
    }

    /**
     * <p>
     * This test case demonstrates the usage of using Properties Panel.
     * </p>
     * @throws Exception to JUnit
     */
    public void testPropertiesPanel() throws Exception {
        UMLModelManager umlModelManager = TestHelper.createUMLModelManager();
        ModelElement element = new GuardImpl();
        List<ModelElement> elements = new ArrayList<ModelElement>();
        elements.add(element);

        // Creates a new JPanel to contain the PropertiesPanel instance.
        JPanel pane = new JPanel();

        // Creates a new PropertiesPanel.
        PropertiesPanel propertiesPanel = new PropertiesPanel(umlModelManager);

        // Add the PropertiesPanel to JPanel.
        pane.add(propertiesPanel);

        // The following code will show the available properties
        // for a ModelElement element
        propertiesPanel.configurePanel(element);

        // The following code will show only the common properties
        // for the ModelElement instances. If elements only contains
        // 1 ModelElement, this call is exactly the same as the code above.
        propertiesPanel.configurePanel(elements);
    }

    /**
     * <p>
     * This test case demonstrates the usage of using Property Change Listener for Properties Panel.
     * </p>
     * @throws Exception to JUnit
     */
    public void testPropertyChangeListener() throws Exception {
        // Creates a new PropertiesPanel.
        PropertiesPanel propertiesPanel = new PropertiesPanel(TestHelper.createUMLModelManager());

        // Implements a listener that is notified when a property of a
        // ModelElement is changed through Properties Panel.
        ModelElementChangeListener propertyListener = new ModelElementChangeListener() {
            public void stateChanged(ModelElement modelElement, PropertyKind property, PropertyOperation op, Object o) {
                System.out.println("Receive State Changed Event : ModelElement is of ["
                    + modelElement.getClass().getSimpleName() + "] type, Property kind is [" + property
                    + "], property operation is [" + op + "], the object is of ["
                    + (o == null ? null : o.getClass().getSimpleName()) + "] type, value is ["
                    + (o == null ? null : o.toString()) + "]");
            }
        };

        // Adds the listener to the PropertiesPanel.
        propertiesPanel.addModelElementChangeListener(propertyListener);

        // Removes the listener from the PropertiesPanel.
        propertiesPanel.removeModelElementChangeListener(propertyListener);

        // Removes all the listener from the Properties Panel.
        propertiesPanel.removeAllModelElementChangeListeners();
    }

    /**
     * <p>
     * This test case demonstrates the usage of using Selection Change Listener for Properties Panel.
     * </p>
     * @throws Exception to JUnit
     */
    public void testSelectionChangeListener() throws Exception {
        // Creates a new PropertiesPanel.
        PropertiesPanel propertiesPanel = new PropertiesPanel(TestHelper.createUMLModelManager());

        // Implements a listener that is notified when the PropertiesPanel
        // switch focus to another ModelElement due to internal event
        // (such as a user clicking a link button for a Namespace to
        // view the property of that Namespace).
        ModelElementSelectionListener selectionListener = new ModelElementSelectionListener() {
            public void selectionChanged(ModelElement modelElement) {
                System.out.println("Receive Selection Changed Event : ModelElement is of ["
                    + modelElement.getClass().getSimpleName() + "] type");
            }
        };

        // Adds the listener to the PropertiesPanel.
        propertiesPanel.addModelElementSelectionListener(selectionListener);

        // Removes the listener from the PropertiesPanel.
        propertiesPanel.removeModelElementSelectionListener(selectionListener);

        // Removes all the listener from the Properties Panel.
        propertiesPanel.removeAllModelElementSelectionListeners();
    }
}
