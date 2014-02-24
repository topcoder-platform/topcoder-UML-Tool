/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.accuracytests.componentgenerators;

import javax.swing.JCheckBox;

import junit.framework.TestCase;

import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;
import com.topcoder.gui.configurationmanager.componentgenerators.CheckBoxPropertyComponentGenerator;

/**
 * <p>
 * This class contains a set of tests for {@link CheckBoxPropertyComponentGenerator} class.
 * </p>
 *
 * @author uhmateush
 * @version 1.0
 */
public class CheckBoxPropertyComponentGeneratorTests extends TestCase {

    /**
     * <p>
     * Represents an instance of <code>PropertyDefinition</code> for tests.
     * </p>
     */
    private PropertyDefinition definition;

    /**
     * Represents an instance of <code>CheckBoxPropertyComponentGenerator</code> class for tests.
     */
    private CheckBoxPropertyComponentGenerator generator;

    /**
     * <p>
     * Initializes test environment.
     * </p>
     *
     * @throws Exception exception to jUnit.
     */
    protected void setUp() throws Exception {
        definition = new PropertyDefinition();
        definition.setPromptText("text0");
        definition.setPropertyName("name0");
        definition.setPropertyType(PropertyType.CHECK_BOX);
        definition.setPropertyValue("value0");

        generator = new CheckBoxPropertyComponentGenerator();
    }

    /**
     * <p>
     * Tests class constructor and <code>getPropertyType()</code> method.
     * Method should return {@link PropertyType#CHECK_BOX} value.
     * </p>
     */
    public void testGetPropertyType() {
        assertEquals("Method getPropertyType() works incorrect. PropertyType.CHECK_BOX value should be returned.",
            PropertyType.CHECK_BOX, generator.getPropertyType());
    }

    /**
     * <p>
     * Tests <code>generateComponent(PropertyDefinition)</code> method.
     * According to definition value CheckBox value should be set to true.
     * </p>
     */
    public void testGenerateComponent0() {
        definition.setPropertyValue(Boolean.TRUE.toString());
        JCheckBox checkBox = generator.generateComponent(definition);

        assertTrue("CheckBox.isSelected() should return the same value as definition value.",
            checkBox.isSelected());
    }

    /**
     * <p>
     * Tests <code>generateComponent(PropertyDefinition)</code> method.
     * According to definition value CheckBox value should be set to false.
     * </p>
     */
    public void testGenerateComponent1() {
        definition.setPropertyValue(Boolean.FALSE.toString());
        JCheckBox checkBox = generator.generateComponent(definition);

        assertFalse("CheckBox.isSelected() should return the same value as definition value.",
            checkBox.isSelected());
    }

    /**
     * <p>
     * Tests <code>generateComponent(PropertyDefinition)</code> method.
     * </p>
     * <p>
     * When the CheckBox change status, the associated property value should be automatically updated.
     * </p>
     */
    public void testGenerateComponent3() {
        definition.setPropertyValue(Boolean.TRUE.toString());
        JCheckBox checkBox = generator.generateComponent(definition);

        checkBox.setSelected(false);
        assertEquals("PropertyValue of the definition should be updated.",
            Boolean.FALSE.toString(), definition.getPropertyValue());

        checkBox.setSelected(true);
        assertEquals("PropertyValue of the definition should be updated.",
            Boolean.TRUE.toString(), definition.getPropertyValue());
    }
}