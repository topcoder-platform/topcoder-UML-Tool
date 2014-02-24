/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.failuretests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.topcoder.gui.configurationmanager.ConfigurationException;
import com.topcoder.gui.configurationmanager.ConfigurationManagerEditorPanel;
import com.topcoder.gui.configurationmanager.NotValidNamespaceException;
import com.topcoder.gui.configurationmanager.PropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;
import com.topcoder.gui.configurationmanager.PropertyValidator;
import com.topcoder.gui.configurationmanager.componentgenerators.CheckBoxPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.componentgenerators.FreeTextPropertyComponentGenerator;

import junit.framework.TestSuite;
import junit.framework.Test;
import junit.framework.TestCase;

/**
 * <p>
 * Failure test cases for ConfigurationManagerEditorPanel.
 * </p>
 *
 * @author victorsam
 * @version 1.0
 */
public class ConfigurationManagerEditorPanelFailureTests extends TestCase {
    /**
     * <p>
     * The ConfigurationManagerEditorPanel instance for testing.
     * </p>
     */
    private ConfigurationManagerEditorPanel instance;

    /**
     * <p>
     * The PropertyDefinition list for testing.
     * </p>
     */
    private List<PropertyDefinition> propertyDefinitions;

    /**
     * <p>
     * The PropertyComponentGenerator list for testing.
     * </p>
     */
    private List<PropertyComponentGenerator> generators;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.clearConfig();
        TestHelper.loadXMLConfig("test_files/failuretests/config.xml");
        TestHelper.loadXMLConfig("test_files/failuretests/invalidConfig.xml");

        propertyDefinitions = new ArrayList<PropertyDefinition>();
        PropertyDefinition property = new PropertyDefinition();
        property.setPropertyType(PropertyType.FREE_TEXT);
        property.setPropertyName("propertyName");
        propertyDefinitions.add(property);
        generators = new ArrayList<PropertyComponentGenerator>();
        generators.add(new FreeTextPropertyComponentGenerator());

        instance =  new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel", propertyDefinitions, 1, 1, generators);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
        instance = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ConfigurationManagerEditorPanelFailureTests.class);
    }

    /**
     * <p>
     * Tests ctor ConfigurationManagerEditorPanel#ConfigurationManagerEditorPanel(String) for failure.
     * It tests the case that when configurationNamespace is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor1_NullConfigurationNamespace() throws Exception {
        try {
            new ConfigurationManagerEditorPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ConfigurationManagerEditorPanel#ConfigurationManagerEditorPanel(String) for failure.
     * It tests the case that when configurationNamespace is empty and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor1_EmptyConfigurationNamespace() throws Exception {
        try {
            new ConfigurationManagerEditorPanel(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ConfigurationManagerEditorPanel#ConfigurationManagerEditorPanel(String) for failure.
     * It tests the case that when configurationNamespace is unknown and Expects for NotValidNamespaceException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor1_UnknowNamespace() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("unknown");
            fail("NotValidNamespaceException expected.");
        } catch (NotValidNamespaceException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ConfigurationManagerEditorPanel#ConfigurationManagerEditorPanel(String) for failure.
     * It tests the case that when propertiesNamespace is missing and Expects for ConfigurationException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor1_propertiesNamespaceMissing() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("propertiesNamespace_missing");
            fail("ConfigurationException expected.");
        } catch (ConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ConfigurationManagerEditorPanel#ConfigurationManagerEditorPanel(String) for failure.
     * It tests the case that when propertiesNamespace is empty and Expects for ConfigurationException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor1_propertiesNamespaceEmpty() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("propertiesNamespace_empty");
            fail("ConfigurationException expected.");
        } catch (ConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ConfigurationManagerEditorPanel#ConfigurationManagerEditorPanel(String) for failure.
     * It tests the case that when propertiesNamespace is invalid and Expects for NotValidNamespaceException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor1_propertiesNamespaceInvalid() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("propertiesNamespace_invalid");
            fail("NotValidNamespaceException expected.");
        } catch (NotValidNamespaceException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ConfigurationManagerEditorPanel#ConfigurationManagerEditorPanel(String,List,int,int,List) for failure.
     * It tests the case that when propertiesNamespace is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_NullPropertiesNamespace() throws Exception {
        try {
            new ConfigurationManagerEditorPanel(null, propertyDefinitions, 1, 1, generators);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ConfigurationManagerEditorPanel#ConfigurationManagerEditorPanel(String,List,int,int,List) for failure.
     * It tests the case that when propertiesNamespace is empty and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_EmptyPropertiesNamespace() throws Exception {
        try {
            new ConfigurationManagerEditorPanel(" ", propertyDefinitions, 1, 1, generators);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ConfigurationManagerEditorPanel#ConfigurationManagerEditorPanel(String,List,int,int,List) for failure.
     * It tests the case that when propertyDefinitions is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_NullPropertyDefinitions() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("namespace", null, 1, 1, generators);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ConfigurationManagerEditorPanel#ConfigurationManagerEditorPanel(String,List,int,int,List) for failure.
     * It tests the case that when propertyDefinitions contains null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_NullInPropertyDefinitions() throws Exception {
        propertyDefinitions.add(null);
        try {
            new ConfigurationManagerEditorPanel("namespace", propertyDefinitions, 1, 1, generators);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#ConfigurationManagerEditorPanel(String,List,int,int,List) for failure.
     * It tests the case that when propertyDefinitions is empty and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_EmptyPropertyDefinitions() throws Exception {
        propertyDefinitions.clear();
        try {
            new ConfigurationManagerEditorPanel("propertiesNamespace_empty", propertyDefinitions, 1, 1, generators);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#ConfigurationManagerEditorPanel(String,List,int,int,List) for failure.
     * It tests the case that when rowsSpacing is negative and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_NegativeRowsSpacing() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("namespace", propertyDefinitions, -1, 1, generators);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#ConfigurationManagerEditorPanel(String,List,int,int,List) for failure.
     * It tests the case that when columnsSpacing is negative and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_NegativeColumnsSpacing() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("namespace", propertyDefinitions, 1, -1, generators);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ConfigurationManagerEditorPanel#ConfigurationManagerEditorPanel(String,List,int,int,List) for failure.
     * It tests the case that when generators is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_NullGenerators() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("namespace", propertyDefinitions, 1, 1, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#ConfigurationManagerEditorPanel(String,List,int,int,List) for failure.
     * It tests the case that when generators contains null element and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_NullInGenerators() throws Exception {
        generators.add(null);
        try {
            new ConfigurationManagerEditorPanel("namespace", propertyDefinitions, 1, 1, generators);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ConfigurationManagerEditorPanel#ConfigurationManagerEditorPanel(String,List,int,int,List) for failure.
     * Expects for NotValidNamespaceException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor2_NotValidNamespaceException() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("namespace", propertyDefinitions, 1, 1, generators);
            fail("NotValidNamespaceException expected.");
        } catch (NotValidNamespaceException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#addPropertyTypeValidator(PropertyType,PropertyValidator) for failure.
     * It tests the case that when propertyType is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testAddPropertyTypeValidator_NullPropertyType() throws Exception {
        try {
            instance.addPropertyTypeValidator(null, new MockPropertyValidator());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#addPropertyTypeValidator(PropertyType,PropertyValidator) for failure.
     * It tests the case that when validator is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testAddPropertyTypeValidator_NullValidator() throws Exception {
        try {
            instance.addPropertyTypeValidator(PropertyType.CHECK_BOX, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#addPropertyNameValidator(String,PropertyValidator) for failure.
     * It tests the case that when propertyName is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testAddPropertyNameValidator_NullPropertyName() throws Exception {
        try {
            instance.addPropertyNameValidator(null, new MockPropertyValidator());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#addPropertyNameValidator(String,PropertyValidator) for failure.
     * It tests the case that when propertyName is empty and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testAddPropertyNameValidator_EmptyPropertyName() throws Exception {
        try {
            instance.addPropertyNameValidator(" ", new MockPropertyValidator());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#addPropertyNameValidator(String,PropertyValidator) for failure.
     * It tests the case that when validator is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testAddPropertyNameValidator_NullValidator() throws Exception {
        try {
            instance.addPropertyNameValidator("propertyName", null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#removePropertyTypeValidator(PropertyType) for failure.
     * It tests the case that when propertyType is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testRemovePropertyTypeValidator_NullPropertyType() throws Exception {
        try {
            instance.removePropertyTypeValidator(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#removePropertyNameValidator(String) for failure.
     * It tests the case that when propertyName is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testRemovePropertyNameValidator_NullPropertyName() throws Exception {
        try {
            instance.removePropertyNameValidator(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#removePropertyNameValidator(String) for failure.
     * It tests the case that when propertyName is empty and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testRemovePropertyNameValidator_EmptyPropertyName() throws Exception {
        try {
            instance.removePropertyNameValidator(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#setPropertyNameValidators(Map) for failure.
     * It tests the case that when propertyNameValidators is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testSetPropertyNameValidators_NullPropertyNameValidators() throws Exception {
        try {
            instance.setPropertyNameValidators(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#setPropertyNameValidators(Map) for failure.
     * It tests the case that when key is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testSetPropertyNameValidators_NullKey() throws Exception {
        Map<String, PropertyValidator> propertyNameValidators = new HashMap<String, PropertyValidator>();
        propertyNameValidators.put(null, new MockPropertyValidator());
        try {
            instance.setPropertyNameValidators(propertyNameValidators);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#setPropertyNameValidators(Map) for failure.
     * It tests the case that when key is empty and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testSetPropertyNameValidators_EmptyKey() throws Exception {
        Map<String, PropertyValidator> propertyNameValidators = new HashMap<String, PropertyValidator>();
        propertyNameValidators.put("", new MockPropertyValidator());
        try {
            instance.setPropertyNameValidators(propertyNameValidators);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#setPropertyNameValidators(Map) for failure.
     * It tests the case that when value is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testSetPropertyNameValidators_NullValue() throws Exception {
        Map<String, PropertyValidator> propertyNameValidators = new HashMap<String, PropertyValidator>();
        propertyNameValidators.put("valid", null);
        try {
            instance.setPropertyNameValidators(propertyNameValidators);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfigurationManagerEditorPanel#setFont(Font) for failure.
     * It tests the case that when font is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit
     */
    public void testSetFont_NullFont() throws Exception {
        try {
            instance.setFont(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}