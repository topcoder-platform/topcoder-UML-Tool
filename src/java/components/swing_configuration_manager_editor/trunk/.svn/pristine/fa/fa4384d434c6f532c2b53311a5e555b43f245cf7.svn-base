/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JTextField;

import com.topcoder.gui.configurationmanager.componentgenerators.CheckBoxPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.componentgenerators.DropDownPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.componentgenerators.FreeTextPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.componentgenerators.RadioButtonsPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.validators.DirectoryValidator;
import com.topcoder.gui.configurationmanager.validators.MultipleChoiceValidator;
import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * The unit test for the class {@link ConfigurationManagerEditorPanel}.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ConfigurationManagerEditorPanelTest extends TestCase {
    /**
     * Represents ConfigurationManagerEditorPanel instance for test.
     */
    private ConfigurationManagerEditorPanel instance;
    /**
     * Represents PropertyValidator used for test.
     */
    private PropertyValidator typeValidator;

    /**
     * Represents PropertyValidator used for test.
     */
    private PropertyValidator nameValidator;
    /**
     * Represents PropertyComponentGenerator list for test.
     */
    private ArrayList<PropertyComponentGenerator> pcgs;

    /**
     * Represents PropertyDefinition list for test.
     */
    private ArrayList<PropertyDefinition> pds;

    /**
     * Setup test environment.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        ConfigManager cm = ConfigManager.getInstance();
        Iterator allNamespaces = cm.getAllNamespaces();
        while (allNamespaces.hasNext()) {
            cm.removeNamespace((String) allNamespaces.next());
        }
        
        cm.add("config_badPropertiyDefinitions.xml");
        cm.add("config_emptyFontColor.xml");
        cm.add("config_emptyFontName.xml");
        cm.add("config_emptyFontStyle.xml");
        cm.add("config_emptyPropertiesNamespace.xml");
        cm.add("config_missingPropertiesNamespace.xml");
        cm.add("config_negativeColumnsSpacing.xml");
        cm.add("config_negativeFontSize.xml");
        cm.add("config_negativeRowsSpacing.xml");
        cm.add("config_undefinedFontColor.xml");
        cm.add("config_undefinedFontName.xml");
        cm.add("config_undefinedFontStyle.xml");
        cm.add("config_unexistPropertiesNamespace.xml");
        cm.add("config.xml");
        cm.add("MyClass.xml");

        instance = new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel");

        typeValidator = new MultipleChoiceValidator();
        nameValidator = new DirectoryValidator();

        PropertyDefinition pd = new PropertyDefinition();
        pd.setPromptText("Name :");
        pd.setPropertyName("name");
        pd.setPropertyType(PropertyType.FREE_TEXT);
        pd.setPropertyValue("value");

        pds = new ArrayList<PropertyDefinition>();
        pds.add(pd);

        pd = new PropertyDefinition();
        pd.setPromptText("Name :");
        pd.setPropertyName("name");
        pd.setPropertyType(PropertyType.CHECK_BOX);
        pd.setPropertyValue("true");
        pds.add(pd);

        pd = new PropertyDefinition();
        pd.setPromptText("Name :");
        pd.setPropertyName("name");
        pd.setPropertyType(PropertyType.DROP_DOWN);
        pd.setValueChoices(new HashSet<String>(Arrays.asList("value", "1", "2")));
        pd.setPropertyValue("value");
        pds.add(pd);

        pd = new PropertyDefinition();
        pd.setPromptText("Name :");
        pd.setPropertyName("name");
        pd.setPropertyType(PropertyType.RADIO_BUTTONS);
        pd.setPropertyValue("value");
        pd.setValueChoices(new HashSet<String>(Arrays.asList("value", "1", "2")));
        pds.add(pd);

        pcgs = new ArrayList<PropertyComponentGenerator>();
        pcgs.add(new FreeTextPropertyComponentGenerator());
        pcgs.add(new CheckBoxPropertyComponentGenerator());
        pcgs.add(new DropDownPropertyComponentGenerator());
        pcgs.add(new RadioButtonsPropertyComponentGenerator());

        String user = ConfigurationManagerEditorPanel.class.getName();
        cm.lock("MyClass", user);
        cm.createTemporaryProperties("MyClass");
        cm.setProperty("MyClass", "name", "John");
        cm.commit("MyClass", user);
    }

    /**
     * Tear down test environment.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        ConfigManager cm = ConfigManager.getInstance();
        Iterator allNamespaces = cm.getAllNamespaces();
        while (allNamespaces.hasNext()) {
            cm.removeNamespace((String) allNamespaces.next());
        }
    }

    /**
     * Test constructor ConfigurationManagerEditorPanel(String, List, int, int,
     * List)} .
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor0() throws Exception {
        instance = new ConfigurationManagerEditorPanel("MyClass", pds, 1, 1, pcgs);
    }

    /**
     * Test constructor ConfigurationManagerEditorPanel(String, List, int, int,
     * List)} .
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor0_EmptyNamespace() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("", pds, 1, 1, pcgs);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test constructor ConfigurationManagerEditorPanel(String, List, int, int,
     * List)} .
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor0_NullNamespace() throws Exception {
        try {
            new ConfigurationManagerEditorPanel(null, pds, 1, 1, pcgs);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test constructor ConfigurationManagerEditorPanel(String, List, int, int,
     * List)} .
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor0_NullPropertyDefinitions() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("MyClass", null, 1, 1, pcgs);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test constructor ConfigurationManagerEditorPanel(String, List, int, int,
     * List)} .
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor0_NullPropertyDefinition() throws Exception {
        pds.add(null);
        try {
            new ConfigurationManagerEditorPanel("MyClass", pds, 1, 1, pcgs);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test constructor ConfigurationManagerEditorPanel(String, List, int, int,
     * List)} .
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor0_NullPropertyGenerators() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("MyClass", pds, 1, 1, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test constructor ConfigurationManagerEditorPanel(String, List, int, int,
     * List)} .
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor0_NullPropertyGenerator() throws Exception {
        pcgs.add(null);
        try {
            new ConfigurationManagerEditorPanel("MyClass", pds, 1, 1, pcgs);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test constructor ConfigurationManagerEditorPanel(String, List, int, int,
     * List)} .
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor0_NegativeRowsSpacing() throws Exception {
        pcgs.add(null);
        try {
            new ConfigurationManagerEditorPanel("MyClass", pds, -1, 1, pcgs);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test constructor ConfigurationManagerEditorPanel(String, List, int, int,
     * List)} .
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor0_NegativeColumnsSpacing() throws Exception {
        pcgs.add(null);
        try {
            new ConfigurationManagerEditorPanel("MyClass", pds, 1, -1, pcgs);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test constructor ConfigurationManagerEditorPanel(String, List, int, int,
     * List)} .
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor0_NotValidNamespace() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("Unexisting", pds, 1, 1, pcgs);
            fail("NotValidNamespaceException is expected.");
        } catch (NotValidNamespaceException e) {
            // success.
        }
    }

    /**
     * Test constructor takes configurationNamespace as parameter.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor() throws Exception {
        new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel");
    }

    /**
     * Test constructor takes configurationNamespace as parameter.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor_badPropertyDefinitions() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel.badPropertiyDefinitions");
            fail("ConfigurationException is expected.");
        } catch (ConfigurationException e) {
            // success.
        }
    }

    /**
     * Test constructor takes configurationNamespace as parameter.
     *
     * ConfigurationException is expected.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor_emptyFontColor() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel.emptyFontColor");
            fail("ConfigurationException is expected.");
        } catch (ConfigurationException e) {
            // success.
        }
    }

    /**
     * Test constructor takes configurationNamespace as parameter.
     *
     * ConfigurationException is expected.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor_emptyFontName() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel.emptyFontName");
            fail("ConfigurationException is expected.");
        } catch (ConfigurationException e) {
            // success.
        }
    }

    /**
     * Test constructor takes configurationNamespace as parameter.
     *
     * ConfigurationException is expected.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor_emptyFontStyle() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel.emptyFontStyle");
            fail("ConfigurationException is expected.");
        } catch (ConfigurationException e) {
            // success.
        }
    }

    /**
     * Test constructor takes configurationNamespace as parameter.
     *
     * ConfigurationException is expected.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor_emptyPropertiesNamespace() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel.emptyPropertiesNamespace");
            fail("ConfigurationException is expected.");
        } catch (ConfigurationException e) {
            // success.
        }
    }

    /**
     * Test constructor takes configurationNamespace as parameter.
     *
     * ConfigurationException is expected.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor_missingPropertiesNamespace() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel.missingPropertiesNamespace");
            fail("ConfigurationException is expected.");
        } catch (ConfigurationException e) {
            // success.
        }
    }

    /**
     * Test constructor takes configurationNamespace as parameter.
     *
     * ConfigurationException is expected.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor_negativeColumnsSpacing() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel.negativeColumnsSpacing");
            fail("ConfigurationException is expected.");
        } catch (ConfigurationException e) {
            // success.
        }
    }

    /**
     * Test constructor takes configurationNamespace as parameter.
     *
     * ConfigurationException is expected.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor_negativeFontSize() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel.negativeFontSize");
            fail("ConfigurationException is expected.");
        } catch (ConfigurationException e) {
            // success.
        }
    }

    /**
     * Test constructor takes configurationNamespace as parameter.
     *
     * ConfigurationException is expected.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor_negativeRowsSpacing() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel.negativeRowsSpacing");
            fail("ConfigurationException is expected.");
        } catch (ConfigurationException e) {
            // success.
        }
    }

    /**
     * Test constructor takes configurationNamespace as parameter.
     *
     * ConfigurationException is expected.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor_undefinedFontColor() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel.undefinedFontColor");
            fail("ConfigurationException is expected.");
        } catch (ConfigurationException e) {
        }
    }

    /**
     * Test constructor takes configurationNamespace as parameter.
     *
     * ConfigurationException is expected.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor_undefinedFontName() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel.undefinedFontName");
            fail("ConfigurationException is expected.");
        } catch (ConfigurationException e) {
        }
    }

    /**
     * Test constructor takes configurationNamespace as parameter.
     *
     * ConfigurationException is expected.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor_undefinedFontStyle() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel.undefinedFontStyle");
            fail("ConfigurationException is expected.");
        } catch (ConfigurationException e) {
        }
    }

    /**
     * Test constructor takes configurationNamespace as parameter.
     *
     * NotValidNamespaceException is expected.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testConstructor_unexistPropertiesNamespace() throws Exception {
        try {
            new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel.unexistPropertiesNamespace");
            fail("NotValidNamespaceException is expected.");
        } catch (NotValidNamespaceException e) {
        }
    }

    /**
     * Test method for {@link ConfigurationManagerEditorPanel#initialize()} .
     */
    public void testInitialize() {
        instance.initialize();
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#validateProperties()} .
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testValidateProperties() throws Exception {
        instance.addPropertyTypeValidator(PropertyType.FREE_TEXT, new DirectoryValidator());
        instance.addPropertyTypeValidator(PropertyType.RADIO_BUTTONS, new DirectoryValidator());
        instance.addPropertyTypeValidator(PropertyType.DROP_DOWN, new DirectoryValidator());
        ValidationResultSet validateProperties = instance.validateProperties();
        assertTrue("validateProperties is incorrect.", validateProperties.isSuccess());
    }

    /**
     * Test method for {@link ConfigurationManagerEditorPanel#saveProperties()}
     * .
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testSaveProperties() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        for (Component component : instance.getComponents()) {
            if (component instanceof JTextField) {
                JTextField tb = (JTextField) component;
                tb.setText("New name");
            }
        }

        Object oldProperty = cm.getProperty("MyClass", "name");
        assertEquals("Old property is incorrect.", "John", oldProperty);

        instance.saveProperties();
        Object property = cm.getProperty("MyClass", "name");
        assertEquals("Saving failed.", "New name", property);
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#addPropertyTypeValidator(PropertyType, PropertyValidator)}
     * .
     */
    public void testAddPropertyTypeValidator() {
        instance.clearPropertyTypeValidators();

        instance.addPropertyTypeValidator(PropertyType.CHECK_BOX, typeValidator);
        Map<PropertyType, PropertyValidator> propertyTypeValidators = instance.getPropertyTypeValidators();
        assertSame(typeValidator, propertyTypeValidators.get(PropertyType.CHECK_BOX));
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#addPropertyTypeValidator(PropertyType, PropertyValidator)}
     * .
     */
    public void testAddPropertyTypeValidator_NullPropertyType() {
        try {
            instance.addPropertyTypeValidator(null, typeValidator);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#addPropertyTypeValidator(PropertyType, PropertyValidator)}
     * .
     */
    public void testAddPropertyTypeValidator_NullPropertyValidator() {
        try {
            instance.addPropertyTypeValidator(PropertyType.CHECK_BOX, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#addPropertyNameValidator(String, PropertyValidator)}
     * .
     */
    public void testAddPropertyNameValidator() {
        instance.addPropertyNameValidator("propertyName", nameValidator);
    }

    /**
     * Test method addPropertyNameValidator. .
     */
    public void testAddPropertyNameValidator_NullPropertyName() {
        try {
            instance.addPropertyNameValidator(null, typeValidator);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test method PropertyNameValidator.
     */
    public void testAddPropertyNameValidator_EmptyPropertyName() {
        try {
            instance.addPropertyNameValidator(" ", typeValidator);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test method addPropertyNameValidator. .
     */
    public void testAddPropertyNameValidator_NullPropertyValidator() {
        try {
            instance.addPropertyNameValidator("name", null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#removePropertyTypeValidator(PropertyType)}
     * .
     */
    public void testRemovePropertyTypeValidator() {
        instance.removePropertyTypeValidator(PropertyType.CHECK_BOX);
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#removePropertyTypeValidator(PropertyType)}
     * .
     */
    public void testRemovePropertyTypeValidator_PropertyType() {
        try {
            instance.removePropertyTypeValidator(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#removePropertyNameValidator(String)}
     * .
     */
    public void testRemovePropertyNameValidator() {
        instance.removePropertyNameValidator("propertyName");
    }

    /**
     * Test method removePropertyNameValidator. .
     */
    public void testRemovePropertyNameValidator_PropertyType() {
        try {
            instance.removePropertyNameValidator(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#clearPropertyTypeValidators()} .
     */
    public void testClearPropertyTypeValidators() {
        instance.clearPropertyTypeValidators();
        assertEquals("PropertyTypeValidators should be empty.", 0, instance.getPropertyTypeValidators().size());
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#clearPropertyNameValidators()} .
     */
    public void testClearPropertyNameValidators() {
        instance.clearPropertyNameValidators();
        assertEquals("PropertyNameValidators should be empty.", 0, instance.getPropertyNameValidators().size());
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#getPropertyTypeValidators()} .
     */
    public void testGetPropertyTypeValidators() {
        instance.getPropertyTypeValidators();
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#getPropertyNameValidators()} .
     */
    public void testGetPropertyNameValidators() {
        instance.getPropertyNameValidators();
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#setPropertyTypeValidators(Map)} .
     */
    public void testSetPropertyTypeValidators1() {
        Map<PropertyType, PropertyValidator> propertyTypeValidators = new HashMap<PropertyType, PropertyValidator>();
        instance.setPropertyTypeValidators(propertyTypeValidators);
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#setPropertyTypeValidators(Map)} .
     */
    public void testSetPropertyTypeValidators2() {
        Map<PropertyType, PropertyValidator> propertyTypeValidators = new HashMap<PropertyType, PropertyValidator>();
        instance.setPropertyTypeValidators(propertyTypeValidators);
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#setPropertyNameValidators(Map)} .
     */
    public void testSetPropertyNameValidators2() {
        Map<String, PropertyValidator> propertyNameValidators = new HashMap<String, PropertyValidator>();
        instance.setPropertyNameValidators(propertyNameValidators);
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#getPropertiesNamespace()} .
     */
    public void testGetPropertiesNamespace() {
        instance.getPropertiesNamespace();
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#getOldPropertiesValues()} .
     */
    public void testGetOldPropertiesValues() {
        instance.getOldPropertiesValues();
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#getPropertyDefinitions()} .
     */
    public void testGetPropertyDefinitions() {
        instance.getPropertyDefinitions();
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#getComponentGenerators()} .
     */
    public void testGetComponentGenerators() {
        instance.getComponentGenerators();
    }

    /**
     * Test method for {@link ConfigurationManagerEditorPanel#getRowsSpacing()}
     * .
     */
    public void testGetRowsSpacing() {
        instance.getRowsSpacing();
    }

    /**
     * Test method for
     * {@link ConfigurationManagerEditorPanel#getColumnsSpacing()} .
     */
    public void testGetColumnsSpacing() {
        instance.getColumnsSpacing();
    }

    /**
     * Test method for {@link ConfigurationManagerEditorPanel#setFont(Font)} .
     */
    public void testSetFontFont() {
        Font font = new Font("Arial",0,10);
        instance.setFont(font);
    }

    /**
     * Test method for {@link ConfigurationManagerEditorPanel#getFontColor()} .
     */
    public void testGetFontColor() {
        instance.getFontColor();
    }
}
