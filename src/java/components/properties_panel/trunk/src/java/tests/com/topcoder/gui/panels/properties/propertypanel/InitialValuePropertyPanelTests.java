/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import javax.swing.JFormattedTextField;

import com.topcoder.gui.panels.properties.MockModelElementChangeListener;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpressionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for InitialValuePropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class InitialValuePropertyPanelTests extends TestCase {
    /**
     * <p>
     * The InitialValuePropertyPanel instance for testing.
     * </p>
     */
    private InitialValuePropertyPanel panel;

    /**
     * <p>
     * The PropertiesPanel instance for testing.
     * </p>
     */
    private PropertiesPanel propertiesPanel;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, TestHelper.CONFIG_FILE);
        propertiesPanel = new PropertiesPanel(new UMLModelManager());

        panel = new InitialValuePropertyPanel(propertiesPanel);
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
        return new TestSuite(InitialValuePropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor InitialValuePropertyPanel#InitialValuePropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created InitialValuePropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new InitialValuePropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor InitialValuePropertyPanel#InitialValuePropertyPanel(PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new InitialValuePropertyPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests InitialValuePropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the registered ModelElement is Attribute type and verifies
     * InitialValuePropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_AttributeType() {
        BooleanExpression expression = new BooleanExpressionImpl();
        expression.setBody("body");
        Attribute element = new AttributeImpl();
        element.setInitialValue(expression);

        panel.configurePanel(element);

        assertEquals("Failed to refresh panel correctly.", "body",
            ((JFormattedTextField) panel.retrievePanel().getComponent(2)).getText());
    }

    /**
     * <p>
     * Tests InitialValuePropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the registered ModelElement is AssociationEnd type and verifies
     * InitialValuePropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_AssociationEndType() {
        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType("initialValue");
        TaggedValue value = new TaggedValueImpl();
        value.setType(tagDefinition);
        value.setDataValue("dataValue");
        AssociationEnd element = new AssociationEndImpl();
        element.addTaggedValue(value);

        panel.configurePanel(element);

        assertEquals("Failed to refresh panel correctly.", "dataValue",
            ((JFormattedTextField) panel.retrievePanel().getComponent(2)).getText());
    }

    /**
     * <p>
     * Tests InitialValuePropertyPanel#execute() for accuracy.
     * </p>
     *
     * <p>
     * It verifies InitialValuePropertyPanel#execute() is correct.
     * </p>
     */
    public void testExecute() {
        panel.configurePanel(new AttributeImpl());

        MockModelElementChangeListener listener = new MockModelElementChangeListener();
        propertiesPanel.addModelElementChangeListener(listener);

        panel.execute();

        assertTrue("Failed to execute correctly.", listener.getIsExecuted());
    }

}