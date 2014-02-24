/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.stresstests;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.gui.panels.properties.ModelElementChangeListener;
import com.topcoder.gui.panels.properties.ModelElementSelectionListener;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * Stress tests for the class: PropertiesPanel.
 *
 * @author kinfkong
 * @version 1.0
 */
public class PropertiesPanelStressTest extends StressBase {

    /**
     * Represents the instance of PropertiesPanel instance for stress test.
     */
    private PropertiesPanel panel = null;

    /**
     * Represents the instance of UML Model Manager for stress test.
     */
    private UMLModelManager manager = null;

    /**
     * Sets up the test environment.
     *
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        super.setUp();

        manager = new UMLModelManager();
        Model root = manager.getModel();
        root.setName("test");

        Namespace ns = new PackageImpl();
        ns.setName("com.topcoder.util");
        root.addOwnedElement(ns);

        Class type = new ClassImpl();
        type.setName("test");
        type.setNamespace(ns);
        ns.addOwnedElement(type);

        ProjectConfigurationManager configManager = new ProjectConfigurationManager(manager);

        manager.setProjectConfigurationManager(configManager);
        manager.setProjectLanguage("Java");

        // create the panel
        panel = new PropertiesPanel("com.topcoder.gui.panels.properties", manager);
    }

    /**
     * Clears the test environment.
     *
     * @throws Exception to JUnit
     */
    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Stress test for the method: configurePanelModelElement.
     *
     */
    public void testConfigurePanelModelElement() {

        Package packageObject = new PackageImpl();
        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.configurePanel(packageObject);
        }
        stopIt("configurePanelModelElement");
    }

    /**
     * Stress test for the method: configurePanel(list<ModelElement>).
     *
     */
    public void testConfigurePanelListOfModelElement() {
        // creates the list of mode elements
        Package packageObject = new PackageImpl();

        List<ModelElement> modelElements = new ArrayList<ModelElement>();
        for (int i = 0; i < 10; i++) {
            modelElements.add(packageObject);
        }
        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.configurePanel(modelElements);
        }
        stopIt("configurePanelListOfModelElement");
    }

    /**
     * Stress test for the method: refreshPanel.
     *
     */
    public void testRefreshPanel() {
        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.refreshPanel();
        }
        stopIt("refreshPanel");
    }

    /**
     * Stress test for the method: getUMLModelManager.
     *
     */
    public void testGetUMLModelManager() {
        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.getUMLModelManager();
        }
        stopIt("getUMLModelManager");
    }

    /**
     * Stress test for the method: configureProject.
     *
     */
    public void testConfigureProject() {
        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.configureProject(manager);
        }
        stopIt("configureProject");
    }

    /**
     * Stress test for the method: firePropertyChangeEvent.
     *
     */
    public void testFirePropertyChangeEvent() {
        startIt();

        for (int i = 0; i < STRESS_TEST_NUM; i++) {

            ModelElementChangeListener listener = new ModelElementChangeListener() {

                /**
                 * The changed method.
                 */
                public void stateChanged(ModelElement modelElement, PropertyKind kind, PropertyOperation operation, Object object) {
                    // do nothing
                }



            };
            panel.addModelElementChangeListener(listener);
            panel.firePropertyChangeEvent(new GuardImpl(), PropertyKind.ABSTRACT, PropertyOperation.ADD, "test");

        }
        stopIt("firePropertyChangeEvent");
    }

    /**
     * Stress tests for the method: fireSelectionChangeEvent.
     *
     */
    public void testFireSelectionChangeEvent() {
        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            ModelElementSelectionListener listener = new ModelElementSelectionListener() {

                /**
                 * The selection changed method.
                 */
                public void selectionChanged(ModelElement modelElement) {
                    // TODO Auto-generated method stub

                }



            };

            panel.addModelElementSelectionListener(listener);
            panel.fireSelectionChangeEvent(new GuardImpl());

        }
        stopIt("fireSelectionChangeEvent");
    }

    /**
     * Stress tests for the method: addModelElementChangeListener.
     *
     */
    public void testAddModelElementChangeListener() {
        startIt();

        for (int i = 0; i < STRESS_TEST_NUM; i++) {

            ModelElementChangeListener listener = new ModelElementChangeListener() {

                /**
                 * The changed method.
                 */
                public void stateChanged(ModelElement modelElement, PropertyKind kind, PropertyOperation operation, Object object) {
                    // do nothing
                }



            };
            panel.addModelElementChangeListener(listener);


        }
        stopIt("addModelElementChangeListener");
    }

    /**
     * Stress test for the method: removeModelElementChangeListener.
     *
     */
    public void testRemoveModelElementChangeListener() {
        startIt();

        for (int i = 0; i < STRESS_TEST_NUM; i++) {

            ModelElementChangeListener listener = new ModelElementChangeListener() {

                /**
                 * The changed method.
                 */
                public void stateChanged(ModelElement modelElement, PropertyKind kind, PropertyOperation operation, Object object) {
                    // do nothing
                }



            };
            panel.addModelElementChangeListener(listener);
            panel.removeModelElementChangeListener(listener);

        }
        stopIt("addModelElementChangeListener");
    }

    /**
     * Stress test for the method: removeAllModelElementChangeListeners.
     *
     */
    public void testRemoveAllModelElementChangeListeners() {
        startIt();

        for (int i = 0; i < STRESS_TEST_NUM; i++) {

            ModelElementChangeListener listener = new ModelElementChangeListener() {

                /**
                 * The changed method.
                 */
                public void stateChanged(ModelElement modelElement, PropertyKind kind, PropertyOperation operation, Object object) {
                    // do nothing
                }



            };
            panel.addModelElementChangeListener(listener);

        }

        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.removeAllModelElementChangeListeners();
        }
        stopIt("removeAllModelElementChangeListeners");
    }

    /**
     * Stress test for the method: addModelElementSelectionListener.
     *
     */
    public void testAddModelElementSelectionListener() {
        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            ModelElementSelectionListener listener = new ModelElementSelectionListener() {

                /**
                 * The selection changed method.
                 */
                public void selectionChanged(ModelElement modelElement) {
                    // empty

                }

            };
            panel.addModelElementSelectionListener(listener);
        }
        stopIt("addModelElementSelectionListener");
    }

    /**
     * Stress test for the method: removeModelElementSelectionListener.
     *
     */
    public void testRemoveModelElementSelectionListener() {
        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            ModelElementSelectionListener listener = new ModelElementSelectionListener() {

                /**
                 * The selection changed method.
                 */
                public void selectionChanged(ModelElement modelElement) {
                    // empty

                }

            };
            panel.addModelElementSelectionListener(listener);
            panel.removeModelElementSelectionListener(listener);
        }
        stopIt("removeModelElementSelectionListener");
    }

    /**
     * Stress test for the method: removeAllModelElementSelectionListeners.
     *
     */
    public void testRemoveAllModelElementSelectionListeners() {
        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            ModelElementSelectionListener listener = new ModelElementSelectionListener() {

                /**
                 * The selection changed method.
                 */
                public void selectionChanged(ModelElement modelElement) {
                    // empty

                }

            };
            panel.addModelElementSelectionListener(listener);

        }

        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.removeAllModelElementSelectionListeners();
        }
        stopIt("removeAllModelElementSelectionListeners");
    }

    /**
     * Stress test for the method: getStereotypes.
     *
     */
    public void testGetStereotypes() {
        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            List<Stereotype> stereotypes = panel.getStereotypes(InterfaceImpl.class);

            assertEquals("Failed to load the stereotype.", 2, stereotypes.size());
        }
        stopIt("getStereotypes");
    }

}
