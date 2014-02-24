/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import com.topcoder.gui.panels.properties.MockModelElementChangeListener;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.MultiplicityRange;
import com.topcoder.uml.model.datatypes.MultiplicityRangeImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for MultiplicityPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MultiplicityPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The MultiplicityPropertyPanel instance for testing.
     * </p>
     */
    private MultiplicityPropertyPanel panel;

    /**
     * <p>
     * The PropertiesPanel instance for testing.
     * </p>
     */
    private PropertiesPanel propertiesPanel;

    /**
     * <p>
     * A list of Multiplicity instances for testing.
     * </p>
     */
    private List<Multiplicity> multiplicities;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, TestHelper.CONFIG_FILE);

        Multiplicity multiplicity = new MultiplicityImpl();
        propertiesPanel = new PropertiesPanel(new UMLModelManager());
        multiplicities = new ArrayList<Multiplicity>();
        multiplicities.add(multiplicity);

        panel = new MultiplicityPropertyPanel(propertiesPanel, multiplicities);
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
        multiplicities = null;
        propertiesPanel = null;

        TestHelper.clearConfigFile(TestHelper.NAMESPACE);
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(MultiplicityPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor MultiplicityPropertyPanel#MultiplicityPropertyPanel(PropertiesPanel,List) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created MultiplicityPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new MultiplicityPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor MultiplicityPropertyPanel#MultiplicityPropertyPanel(PropertiesPanel,List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new MultiplicityPropertyPanel(null, multiplicities);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor MultiplicityPropertyPanel#MultiplicityPropertyPanel(PropertiesPanel,List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when multiplicities is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullMultiplicities() {
        try {
            new MultiplicityPropertyPanel(propertiesPanel, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests MultiplicityPropertyPanel#MultiplicityPropertyPanel(PropertiesPanel,List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when multiplicities is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyMultiplicities() {
        multiplicities = new ArrayList<Multiplicity>();
        try {
            new MultiplicityPropertyPanel(propertiesPanel, multiplicities);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests MultiplicityPropertyPanel#MultiplicityPropertyPanel(PropertiesPanel,List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when multiplicities contains null element and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullInMultiplicities() {
        multiplicities.add(null);
        try {
            new MultiplicityPropertyPanel(propertiesPanel, multiplicities);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests MultiplicityPropertyPanel#MultiplicityPropertyPanel(PropertiesPanel,List) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when multiplicities contains invalid element and expects
     * IllegalArgumentException.
     * </p>
     */
    public void testCtor_InvalidMultiplicities() {
        Multiplicity multiplicity = new MultiplicityImpl();
        MultiplicityRange range = new MultiplicityRangeImpl();
        range.setLower(5);
        range.setUpper(3);
        multiplicity.addRange(range);
        multiplicities.add(multiplicity);

        try {
            new MultiplicityPropertyPanel(propertiesPanel, multiplicities);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests MultiplicityPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies MultiplicityPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel() {
        List<ModelElement> elements = new ArrayList<ModelElement>();
        Multiplicity multiplicity = new MultiplicityImpl();
        Attribute element1 = new AttributeImpl();
        element1.setMultiplicity(multiplicity);
        AssociationEnd element2 = new AssociationEndImpl();
        element2.setMultiplicity(multiplicity);

        elements.add(element1);
        elements.add(element2);
        panel.configurePanel(elements);

        assertEquals("Failed to refresh panel correctly.", 2,
            ((JComboBox) panel.retrievePanel().getComponent(2)).getItemCount());
    }

    /**
     * <p>
     * Tests MultiplicityPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies MultiplicityPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoVisible() {
        panel.refreshPanel();

        assertEquals("Failed to refresh panel correctly.", 0,
            ((JComboBox) panel.retrievePanel().getComponent(2)).getItemCount());
    }

    /**
     * <p>
     * Tests MultiplicityPropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies MultiplicityPropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute() {
        Multiplicity multiplicity = new MultiplicityImpl();
        Attribute element = new AttributeImpl();
        element.setMultiplicity(multiplicity);
        panel.configurePanel(element);

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }

}