/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.accuracytests;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JTextField;
import com.topcoder.gui.configurationmanager.ConfigurationManagerEditorPanel;
import com.topcoder.gui.configurationmanager.PropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;
import com.topcoder.gui.configurationmanager.PropertyValidator;
import com.topcoder.gui.configurationmanager.ValidationResultSet;
import com.topcoder.gui.configurationmanager.componentgenerators.CheckBoxPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.componentgenerators.DropDownPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.componentgenerators.FreeTextPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.componentgenerators.RadioButtonsPropertyComponentGenerator;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.Property;
import junit.framework.TestCase;

/**
 * <p>
 * This class contains a set of tests for {@link ConfigurationManagerEditorPanel} class.
 * </p>
 *
 * @author uhmateush
 * @version 1.0
 */
public class ConfigurationManagerEditorPanelTests extends TestCase {

    /**
     * <p>
     * Represents a property namespace for tests.
     * </p>
     */
    private static final String NAMESPACE = "SomeClass";

    /**
     * <p>
     * Represents a key to get properties namespace from <code>ConfigManager</code>.
     * </p>
     */
    private static final String PROP_NAMESPACE_KEY = "propertiesNamespace";

    /**
     * <p>
     * Represents a key to get property definitions from <code>ConfigManager</code>.
     * </p>
     */
    private static final String PROP_DEFINITIONS_KEY = "propertyDefinitions";

    /**
     * <p>
     * Represents a key to get rows spacing from <code>ConfigManager</code>.
     * </p>
     */
    private static final String ROWS_SPACING_KEY = "rowsSpacing";

    /**
     * <p>
     * Represents a key to get columns spacing from <code>ConfigManager</code>.
     * </p>
     */
    private static final String COLUMNS_SPACING_KEY = "columnsSpacing";

    /**
     * <p>
     * Represents a key to get font name from <code>ConfigManager</code>.
     * </p>
     */
    private static final String FONT_NAME_KEY = "fontName";

    /**
     * <p>
     * Represents a key to get font style from <code>ConfigManager</code>.
     * </p>
     */
    private static final String FONT_STILE_KEY = "fontStyle";

    /**
     * <p>
     * Represents a key to get font size from <code>ConfigManager</code>.
     * </p>
     */
    private static final String FONT_SIZE_KEY = "fontSize";

    /**
     * <p>
     * Represents a key to get font color from <code>ConfigManager</code>.
     * </p>
     */
    private static final String FONT_COLOR_KEY = "fontColor";

    /**
     * <p>
     * Represents a test values for ComboBox and RadioButtons generation.
     * </p>
     */
    private static final String[] VALUES = {"value0", "value1", "value2"};

    /**
     * <p>
     * Represents an instance of <code>ConfigurationManagerEditorPanel</code> class for tests.
     * </p>
     */
    private ConfigurationManagerEditorPanel panel;

    /**
     * <p>
     * Represents a validator for type field.
     * </p>
     */
    private PropertyValidator typeValidator;

    /**
     * <p>
     * Represents a validator for name field.
     * </p>
     */
    private PropertyValidator nameValidator;

    /**
     * <p>
     * A list of component generators for tests.
     * </p>
     */
    private ArrayList<PropertyComponentGenerator> componentGenerators;

    /**
     * <p>
     * A list of definitions for tests.
     * </p>
     */
    private ArrayList<PropertyDefinition> definitions;

    /**
     * <p>
     * Initializes test environment.
     * </p>
     *
     * @throws Exception exception to jUnit.
     */
    protected void setUp() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        Iterator<String> namespaces = cm.getAllNamespaces();
        while (namespaces.hasNext()) {
            cm.removeNamespace(namespaces.next());
        }
        
        cm.add("accuracy/accuracy_config.xml");
        cm.add("accuracy/accuracy_SomeClass.xml");

        typeValidator = new MockTypeValidator();
        nameValidator = new MockNameValidator();

        definitions = new ArrayList<PropertyDefinition>();

        PropertyDefinition definition = new PropertyDefinition();
        definition.setPromptText("Name:");
        definition.setPropertyName("name");
        definition.setPropertyType(PropertyType.FREE_TEXT);
        definition.setPropertyValue("testValue");
        definitions.add(definition);

        definition = new PropertyDefinition();
        definition.setPromptText("Name:");
        definition.setPropertyName("testCheckBox");
        definition.setPropertyType(PropertyType.CHECK_BOX);
        definition.setPropertyValue(Boolean.TRUE.toString());
        definitions.add(definition);

        definition = new PropertyDefinition();
        definition.setPromptText("Name:");
        definition.setPropertyName("size");
        definition.setPropertyType(PropertyType.DROP_DOWN);
        definition.setValueChoices(new HashSet<String>(Arrays.asList(VALUES)));
        definition.setPropertyValue(VALUES[1]);
        definitions.add(definition);

        definition = new PropertyDefinition();
        definition.setPromptText("Name:");
        definition.setPropertyName("testRadioBattons");
        definition.setPropertyType(PropertyType.RADIO_BUTTONS);
        definition.setPropertyValue(VALUES[1]);
        definition.setValueChoices(new HashSet<String>(Arrays.asList(VALUES)));
        definitions.add(definition);

        componentGenerators = new ArrayList<PropertyComponentGenerator>();
        componentGenerators.add(new FreeTextPropertyComponentGenerator());
        componentGenerators.add(new CheckBoxPropertyComponentGenerator());
        componentGenerators.add(new DropDownPropertyComponentGenerator());
        componentGenerators.add(new RadioButtonsPropertyComponentGenerator());

        panel = new ConfigurationManagerEditorPanel(NAMESPACE, definitions, 1, 1, componentGenerators);
    }

    /**
     * <p>
     * Clears test environment.
     * </p>
     *
     * @throws Exception exception to jUnit.
     */
    protected void tearDown() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        Iterator<String> namespaces = cm.getAllNamespaces();
        while (namespaces.hasNext()) {
            cm.removeNamespace(namespaces.next());
        }
    }

    /**
     * <p>
     * Tests class constructor ConfigurationManagerEditorPanel(String, List, int, int, List).
     * This constructor using for all other test cases and tested indirectly.
     * </p>
     * @throws Exception exception to jUnit.
     */
    public void testConstructor0() throws Exception {
        assertNotNull("Object should be created",
            new ConfigurationManagerEditorPanel(NAMESPACE, definitions, 1, 1, componentGenerators));
    }

    /**
     * <p>
     * Test constructor takes configurationNamespace as parameter.
     * </p>
     *
     * @throws Exception exception to jUnit.
     */
    public void testConstructor1() throws Exception {
        String configurationNamespace = "accuracy" + ConfigurationManagerEditorPanel.class.getSimpleName();
        ConfigManager cm = ConfigManager.getInstance();

        ConfigurationManagerEditorPanel instance =
            new ConfigurationManagerEditorPanel(configurationNamespace);
        assertEquals("Fiels properties namespace set incorrect. It should be initialied from config as: " + NAMESPACE,
            cm.getProperty(configurationNamespace, PROP_NAMESPACE_KEY), instance.getPropertiesNamespace());
        assertTrue("Parameter " + ROWS_SPACING_KEY + " is not correct.",
            Integer.parseInt(cm.getProperty(configurationNamespace, ROWS_SPACING_KEY).toString())
            == instance.getRowsSpacing());
        assertTrue("Parameter " + COLUMNS_SPACING_KEY + " is not correct.",
                Integer.parseInt(cm.getProperty(configurationNamespace, COLUMNS_SPACING_KEY).toString())
                == instance.getColumnsSpacing());

        Font font = instance.getFont();
        assertEquals("Parameter " + FONT_NAME_KEY + " is not correct.",
            cm.getProperty(configurationNamespace, FONT_NAME_KEY).toString(), font.getName());
        assertTrue("Parameter " + FONT_STILE_KEY + " is not correct.",
            Integer.parseInt(cm.getProperty(configurationNamespace, FONT_STILE_KEY).toString()) == font.getStyle());
        assertTrue("Parameter " + FONT_SIZE_KEY + " is not correct.",
                Integer.parseInt(cm.getProperty(configurationNamespace, FONT_SIZE_KEY).toString()) == font.getSize());
        assertEquals("Parameter " + FONT_COLOR_KEY + " is not correct.",
            getColorFromString(cm.getProperty(configurationNamespace, FONT_COLOR_KEY).toString()),
            instance.getFontColor());

        Set<PropertyDefinition> actualDefinitions = instance.getPropertyDefinitions().keySet();
        Set<PropertyDefinition> expectedDefinitions = getPropertyDefinitions(cm, configurationNamespace, NAMESPACE);

        assertTrue("Incorrect count of property definitions.", expectedDefinitions.size() == actualDefinitions.size());
        for (PropertyDefinition definition : expectedDefinitions) {
            for (Iterator<PropertyDefinition> it = actualDefinitions.iterator(); it.hasNext();) {
                PropertyDefinition ad = it.next();
                if (ad.getPropertyName().equals(definition.getPropertyName())) {
                    break;
                }
                if (!it.hasNext()) {
                    fail("Definisions set should contains all definition from the configuration file.");
                }
            }
        }
    }

    /**
     * <p>
     * Tests {@link ConfigurationManagerEditorPanel#validateProperties()} method.
     * </p>
     *
     * @throws Exception exception to jUnit.
     */
    public void testValidateProperties() throws Exception {

        panel.addPropertyTypeValidator(PropertyType.RADIO_BUTTONS, new MockTypeValidator());
        panel.addPropertyTypeValidator(PropertyType.DROP_DOWN, new MockTypeValidator());

        ValidationResultSet validateProperties = panel.validateProperties();
        assertTrue("Method validateProperties works not correct.", validateProperties.isSuccess());

        panel.addPropertyTypeValidator(PropertyType.FREE_TEXT, new MockTypeValidator());
        validateProperties = panel.validateProperties();
        assertFalse("Method validateProperties works not correct.", validateProperties.isSuccess());
    }

    /**
     * <p>
     * Tests {@link ConfigurationManagerEditorPanel#saveProperties()} method.
     * </p>
     *
     * @throws Exception exception to jUnit.
     */
    public void testSaveProperties() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        for (Component component : panel.getComponents()) {
            if (component instanceof JTextField) {
                JTextField tb = (JTextField) component;
                tb.setText("New name");
            }
        }

        panel.saveProperties();
        Object property = cm.getProperty(NAMESPACE, "name");
        assertEquals("Saving failed.", "New name", property);
    }

    /**
     * Tests {@link ConfigurationManagerEditorPanel#removePropertyTypeValidator(PropertyType)},
     * {@link ConfigurationManagerEditorPanel#addPropertyTypeValidator(PropertyType, PropertyValidator)} methods.
     */
    public void testRemovePropertyTypeValidator() {
        assertTrue("Property type validators should be empty.", panel.getPropertyNameValidators().size() == 0);

        PropertyType key = definitions.get(2).getPropertyType();
        panel.addPropertyTypeValidator(key, typeValidator);

        Map<PropertyType, PropertyValidator> actualValidators = panel.getPropertyTypeValidators();
        assertTrue("Validators should contains added validator.", actualValidators.containsKey(key));
        assertEquals("Added validator should be exist.", typeValidator, actualValidators.get(key));

        assertTrue("Validator should be removed.", panel.removePropertyTypeValidator(key));

        assertTrue("Method clearPropertyTypeValidators() works not correct.",
            panel.getPropertyTypeValidators().size() == 0);
    }

    /**
     * <p>
     * Tests {@link ConfigurationManagerEditorPanel#removePropertyNameValidator(String)},
     * {@link ConfigurationManagerEditorPanel#addPropertyNameValidator(String, PropertyValidator)} methods.
     * </p>
     */
    public void testRemovePropertyNameValidator() {
        assertTrue("Property name validators should be empty.", panel.getPropertyNameValidators().size() == 0);

        String key = definitions.get(0).getPropertyName();
        panel.addPropertyNameValidator(key, nameValidator);

        Map<String, PropertyValidator> actualValidators = panel.getPropertyNameValidators();
        assertTrue("Validators should contains added validator.", actualValidators.containsKey(key));
        assertEquals("Added validator should be exist.", nameValidator, actualValidators.get(key));

        assertTrue("Validator should be removed.", panel.removePropertyNameValidator(key));

        assertTrue("Method clearPropertyNameValidators() works not correct.",
            panel.getPropertyNameValidators().size() == 0);
    }

    /**
     * <p>
     * Tests {@link ConfigurationManagerEditorPanel#clearPropertyTypeValidators()},
     * {@link ConfigurationManagerEditorPanel#addPropertyTypeValidator(PropertyType, PropertyValidator)} methods.
     * </p>
     */
    public void testClearPropertyTypeValidators() {
        assertTrue("Property type validators should be empty.", panel.getPropertyNameValidators().size() == 0);

        PropertyType key = definitions.get(2).getPropertyType();
        panel.addPropertyTypeValidator(key, typeValidator);

        Map<PropertyType, PropertyValidator> actualValidators = panel.getPropertyTypeValidators();
        assertTrue("Validators should contains added validator.", actualValidators.containsKey(key));
        assertEquals("Added validator should be exist.", typeValidator, actualValidators.get(key));

        panel.clearPropertyTypeValidators();

        assertTrue("Method clearPropertyTypeValidators() works not correct.",
            panel.getPropertyTypeValidators().size() == 0);
    }

    /**
     * <p>
     * Tests {@link ConfigurationManagerEditorPanel#clearPropertyNameValidators()},
     * {@link ConfigurationManagerEditorPanel#addPropertyNameValidator(String, PropertyValidator)} methods.
     * </p>
     */
    public void testClearPropertyNameValidators() {
        assertTrue("Property name validators should be empty.", panel.getPropertyNameValidators().size() == 0);

        String key = definitions.get(0).getPropertyName();
        panel.addPropertyNameValidator(key, nameValidator);

        Map<String, PropertyValidator> actualValidators = panel.getPropertyNameValidators();
        assertTrue("Validators should contains added validator.", actualValidators.containsKey(key));
        assertEquals("Added validator should be exist.", nameValidator, actualValidators.get(key));

        panel.clearPropertyNameValidators();

        assertTrue("Method clearPropertyNameValidators() works not correct.",
            panel.getPropertyNameValidators().size() == 0);
    }

    /**
     * <p>
     * Tests {@link ConfigurationManagerEditorPanel#setPropertyTypeValidators(Map)}
     * and {@link ConfigurationManagerEditorPanel#getPropertyTypeValidators()} methods.
     * </p>
     */
    public void testSetPropertyTypeValidators() {
        assertTrue("Property type validators should be empty.", panel.getPropertyNameValidators().size() == 0);

        Map<PropertyType, PropertyValidator> propertyTypeValidators = new HashMap<PropertyType, PropertyValidator>();

        PropertyType key = definitions.get(2).getPropertyType();
        propertyTypeValidators.put(key, typeValidator);

        panel.setPropertyTypeValidators(propertyTypeValidators);

        Map<PropertyType, PropertyValidator> actualValidators = panel.getPropertyTypeValidators();
        assertTrue("Validators should contains added validator.", actualValidators.containsKey(key));
        assertEquals("Added validator should be exist.", propertyTypeValidators.get(key), actualValidators.get(key));
    }

    /**
     * <p>
     * Tests {@link ConfigurationManagerEditorPanel#setPropertyNameValidators(Map)}
     * and {@link ConfigurationManagerEditorPanel#getPropertyNameValidators()} methods.
     * </p>
     */
    public void testSetPropertyNameValidators() {
        assertTrue("Property name validators should be empty.", panel.getPropertyNameValidators().size() == 0);

        Map<String, PropertyValidator> propertyNameValidators = new HashMap<String, PropertyValidator>();

        String key = definitions.get(0).getPropertyName();
        propertyNameValidators.put(key, nameValidator);

        panel.setPropertyNameValidators(propertyNameValidators);

        Map<String, PropertyValidator> actualValidators = panel.getPropertyNameValidators();
        assertTrue("Validators should contains added validator.", actualValidators.containsKey(key));
        assertEquals("Added validator should be exist.", propertyNameValidators.get(key), actualValidators.get(key));
    }

    /**
     * <p>
     * Tests {@link ConfigurationManagerEditorPanel#getPropertiesNamespace()} method.
     * </p>
     */
    public void testGetPropertiesNamespace() {
        assertEquals("Namespace should be equals to set.", NAMESPACE, panel.getPropertiesNamespace());
    }

    /**
     * <p>
     * Tests {@link ConfigurationManagerEditorPanel#getOldPropertiesValues()} method.
     * </p>
     *
     * @throws Exception exception to jUnit.
     */
    public void testGetOldPropertiesValues() throws Exception {
        Map<String, String> oldPropertiesValues = new HashMap<String, String>();
        ConfigManager cm = ConfigManager.getInstance();
        for (PropertyDefinition property : definitions) {
            String propertyName = property.getPropertyName();
            oldPropertiesValues.put(propertyName,
                cm.getString(NAMESPACE, propertyName));
        }

        Map<String, String> actualOldPropertiesValues = panel.getOldPropertiesValues();
        for (String key : oldPropertiesValues.keySet()) {
            assertTrue("Key: " + key + " should be exist.", actualOldPropertiesValues.containsKey(key));
            assertEquals("Illegal value with key: " + key,
                oldPropertiesValues.get(key), actualOldPropertiesValues.get(key));
        }
    }

    /**
     * <p>
     * Tests {@link ConfigurationManagerEditorPanel#getPropertyDefinitions()} method.
     * </p>
     */
    public void testGetPropertyDefinitions() {
        assertTrue("A count of component generators should be equals.",
            definitions.size() == panel.getPropertyDefinitions().size());
    }

    /**
     * <p>
     * Tests {@link ConfigurationManagerEditorPanel#getComponentGenerators()} method.
     * </p>
     */
    public void testGetComponentGenerators() {
        assertTrue("A count of component generators should be equals.",
            componentGenerators.size() == panel.getComponentGenerators().size());
        for (PropertyComponentGenerator generator : componentGenerators) {
            assertEquals("Every set generator should be exist.", generator,
                panel.getComponentGenerators().get(generator.getPropertyType()));
        }
    }

    /**
     * <p>
     * Tests {@link ConfigurationManagerEditorPanel#getRowsSpacing()} method.
     * </p>
     */
    public void testGetRowsSpacing() {
        assertTrue("Rows spacing shold be equals to set.", 1 == panel.getRowsSpacing());
    }

    /**
     * <p>
     * Tests {@link ConfigurationManagerEditorPanel#getColumnsSpacing()} method.
     * </p>
     */
    public void testGetColumnsSpacing() {
        assertTrue("Columns spacing shold be equals to set.", 1 == panel.getColumnsSpacing());
    }

    /**
     * <p>
     * Tests {@link ConfigurationManagerEditorPanel#setFont(Font)} method.
     */
    public void testSetFontFont() {
        Font font = new Font("arial",1,10);
        panel.setFont(font);
        assertEquals("Font should be equal to set.", font, panel.getFont());
    }

    /**
     * <p>
     * Creates a <code>Color</code> object from string representation.
     * </p>
     *
     * @param color a string representation of the color.
     * @return <code>Color</code> object according to specified parameter or null if color object cannot be created.
     */
    private Color getColorFromString(String color) {
        Field field = null;
        try {
            if (color != null) {
                field = Color.class.getDeclaredField(color);

                // set the field accessible.
                field.setAccessible(true);

                Object fieldValue = field.get(null);

                // get the value
                if (fieldValue == null || !(fieldValue instanceof Color)) {
                    return null;
                }
                return (Color) fieldValue;
            }
        } catch (Exception e) {
            // ignore and return null
        } finally {
            if (field != null) {
                // reset the accessibility
                field.setAccessible(false);
            }
        }
        return null;
    }
    
    /**
     * <p>
     * Returns a list of <code>PropertyDefinition</code> from the configuration file.
     * </p>
     * @param cm configuration manager.
     * @param configurationNamespace a main namespace.
     * @param propertiesNamespace properties namespace.
     * @return a list with definitions.
     * @throws Exception exception to jUnit.
     */
    private Set<PropertyDefinition> getPropertyDefinitions(ConfigManager cm, String configurationNamespace, String propertiesNamespace)
        throws Exception {
        Set<PropertyDefinition> propertyDefinitions = new HashSet<PropertyDefinition>();
        Property propertiyDefinitionsProperty = cm.getPropertyObject(configurationNamespace, PROP_DEFINITIONS_KEY);

        List<Property> list = propertiyDefinitionsProperty.list();
        for (Object element : list) {
            PropertyDefinition pd = new PropertyDefinition();
            propertyDefinitions.add(pd);

            Property subProperty = (Property) element;

            pd.setPropertyName(subProperty.getName());
            String[] values = subProperty.getValues();

            String promptText = values[0];
            pd.setPromptText(promptText);
            PropertyType propertyType = PropertyType.valueOf(values[1]);
            pd.setPropertyType(propertyType);

            // Read property value from ConfigManager.
            pd.setPropertyValue((String) cm.getProperty(propertiesNamespace, subProperty.getName()));

            // Set value choices.
            if (PropertyType.DROP_DOWN.equals(propertyType) || PropertyType.RADIO_BUTTONS.equals(propertyType)) {
                Set<String> valueChoices = new HashSet<String>();
                for (int i = 2; i < values.length; ++i) {
                    valueChoices.add(values[i]);
                }
                pd.setValueChoices(valueChoices);
            }
        }
        return propertyDefinitions;
    }
}