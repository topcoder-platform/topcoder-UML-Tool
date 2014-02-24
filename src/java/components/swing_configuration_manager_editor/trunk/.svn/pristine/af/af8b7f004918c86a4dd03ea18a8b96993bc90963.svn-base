/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.accuracytests.componentgenerators;

import java.util.HashSet;
import java.util.Set;
import javax.swing.JComboBox;
import junit.framework.TestCase;
import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;
import com.topcoder.gui.configurationmanager.componentgenerators.DropDownPropertyComponentGenerator;

/**
 * <p>
 * This class contains a set of tests for {@link DropDownPropertyComponentGenerator} class.
 * </p>
 *
 * @author uhmateush
 * @version 1.0
 */
public class DropDownPropertyComponentGeneratorTests extends TestCase {

    /**
     * <p>
     * Represents a test values for ComboBox generation.
     * </p>
     */
    private static final String[] VALUES = {"value0", "value1", "value2"};

    /**
     * <p>
     * Represents an instance of <code>PropertyDefinition</code> for tests.
     * </p>
     */
    private PropertyDefinition definition;

    /**
     * Represents an instance of <code>DropDownPropertyComponentGenerator</code> class for tests.
     */
    private DropDownPropertyComponentGenerator generator;

    /**
     * <p>
     * Initializes test environment.
     * </p>
     *
     * @throws Exception exception to jUnit.
     */
    protected void setUp() throws Exception {
        definition = new PropertyDefinition();
        definition.setPromptText("text");
        definition.setPropertyName("name");
        definition.setPropertyType(PropertyType.DROP_DOWN);
        definition.setPropertyValue(VALUES[1]);

        Set<String> choices = new HashSet<String>();
        for (String s : VALUES) {
            choices.add(s);
        }

        definition.setValueChoices(choices);

        generator = new DropDownPropertyComponentGenerator();
    }


    /**
     * <p>
     * Tests class constructor and <code>getPropertyType()</code> method.
     * Method should return {@link PropertyType#DROP_DOWN} value.
     * </p>
     */
    public void testGetPropertyType() {
        assertEquals("Method getPropertyType() works incorrect. PropertyType.DROP_DOWN value should be returned.",
            PropertyType.DROP_DOWN, generator.getPropertyType());
    }

    /**
     * <p>
     * Tests <code>generateComponent(PropertyDefinition)</code> method.
     * According to definition items count should be 3.
     * </p>
     */
    public void testGenerateComponent0() {
        JComboBox comboBox = generator.generateComponent(definition);

        assertTrue("Generated ComboBox contains illegal count of items: " + comboBox.getItemCount()
            + " expected count: " + VALUES.length, VALUES.length == comboBox.getItemCount());
    }

    /**
     * <p>
     * Tests <code>generateComponent(PropertyDefinition)</code> method.
     * According to definition value selected value should be value at index 1 from values array.
     * </p>
     */
    public void testGenerateComponent1() {
        JComboBox comboBox = generator.generateComponent(definition);

        assertEquals("Generated ComboBox contains illegal selected value: " + comboBox.getSelectedItem().toString()
            + " expected value: " + VALUES[1], comboBox.getSelectedItem().toString(), VALUES[1]);
    }

    /**
     * <p>
     * Tests <code>generateComponent(PropertyDefinition)</code> method.
     * Definition value should be set according to ComboBox selected value.
     * </p>
     */
    public void testGenerateComponent2() {
        JComboBox comboBox = generator.generateComponent(definition);
        comboBox.setSelectedItem(VALUES[2]);

        assertEquals("PropertyDefinition selected value should be upadated: " + definition.getPropertyValue()
            + " expected value: " + VALUES[2], comboBox.getSelectedItem().toString(), VALUES[2]);
    }
}