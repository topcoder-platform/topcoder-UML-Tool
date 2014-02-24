/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import com.topcoder.gui.panels.properties.MockModelElementChangeListener;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.classifiers.DataTypeImpl;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for TypePropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TypePropertyPanelTests extends TestCase {
    /**
     * <p>
     * The TypePropertyPanel instance for testing.
     * </p>
     */
    private TypePropertyPanel panel;

    /**
     * <p>
     * The PropertiesPanel instance for testing.
     * </p>
     */
    private PropertiesPanel propertiesPanel;

    /**
     * <p>
     * The Icon instance for testing.
     * </p>
     */
    private Icon icon;

    /**
     * <p>
     * The Classifier instance for testing.
     * </p>
     */
    private Classifier classifier;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadConfigurations();

        classifier = new InterfaceImpl();
        Namespace namespace = new DataTypeImpl();
        namespace.addOwnedElement(classifier);
        Model model = new ModelImpl();
        model.addOwnedElement(namespace);
        UMLModelManager manager = new UMLModelManager();
        manager.setModel(model);
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
        propertiesPanel = new PropertiesPanel(manager);
        icon = new ImageIcon();

        panel = new TypePropertyPanel(propertiesPanel, icon);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        panel = null;
        icon = null;
        propertiesPanel = null;
        classifier = null;

        TestHelper.clearConfig();
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(TypePropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor TypePropertyPanel#TypePropertyPanel(PropertiesPanel,Icon) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created TypePropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new TypePropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor TypePropertyPanel#TypePropertyPanel(PropertiesPanel,Icon) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new TypePropertyPanel(null, icon);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor TypePropertyPanel#TypePropertyPanel(PropertiesPanel,Icon) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when icon is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullIcon() {
        try {
            new TypePropertyPanel(propertiesPanel, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests TypePropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when classifier is config and verifies
     * TypePropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_ClassifierConfig() {
        List<ModelElement> elements = new ArrayList<ModelElement>();
        Attribute element1 = new AttributeImpl();
        element1.setOwner(classifier);
        Parameter element2 = new ParameterImpl();
        element2.setType(classifier);
        AssociationEnd element3 = new AssociationEndImpl();
        element3.setParticipant(classifier);
        Object element4 = new ObjectImpl();
        element4.setClassifier(classifier);

        elements.add(element1);
        elements.add(element2);
        elements.add(element3);
        elements.add(element4);
        panel.configurePanel(elements);

        assertEquals("Failed to refresh panel correctly.", 0,
            ((JComboBox) panel.retrievePanel().getComponent(2)).getSelectedIndex());
    }

    /**
     * <p>
     * Tests TypePropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when classifier is not config and verifies
     * TypePropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoClassifierConfig() {
        panel.configurePanel(new AttributeImpl());

        assertEquals("Failed to refresh panel correctly.", 0,
            ((JComboBox) panel.retrievePanel().getComponent(2)).getSelectedIndex());
    }

    /**
     * <p>
     * Tests TypePropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies TypePropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute() {
        panel.configurePanel(new AttributeImpl());

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }

    /**
     * <p>
     * Tests TypePropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when empty item is selected and verifies
     * TypePropertyPanel#execute() is correct.
     * </p>
     * @throws Exception to JUnit
     */
    public void testExecute_EmptyItemSelected() throws Exception {
        UMLModelManager manager = new UMLModelManager();
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));

        propertiesPanel = new PropertiesPanel(manager);

        panel = new TypePropertyPanel(propertiesPanel, icon);
        panel.configurePanel(new AttributeImpl());

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertFalse("Failed to execute correctly.", listener.getIsExecuted());
    }

}