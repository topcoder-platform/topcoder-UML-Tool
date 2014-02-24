/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.accuracytests.componentgenerators;

import javax.swing.JTextField;
import junit.framework.TestCase;
import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;
import com.topcoder.gui.configurationmanager.componentgenerators.FreeTextPropertyComponentGenerator;

/**
 * <p>
 * This class contains a set of tests for {@link FreeTextPropertyComponentGenerator} class.
 * </p>
 *
 * @author uhmateush
 * @version 1.0
 */
public class FreeTextPropertyComponentGeneratorTests extends TestCase {

    /**
     * <p>
     * Represents a test string for tests.
     * </p>
     */
    private static final String TEST_STRING_0 = "test0";

    /**
     * <p>
     * Represents a test string for tests.
     * </p>
     */
    private static final String TEST_STRING_1 = "test1";

    /**
     * <p>
     * Represents an instance of <code>PropertyDefinition</code> for tests.
     * </p>
     */
    private PropertyDefinition definition;

    /**
     * Represents an instance of <code>FreeTextPropertyComponentGenerator</code> class for tests.
     */
    private FreeTextPropertyComponentGenerator generator;

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
        definition.setPropertyType(PropertyType.FREE_TEXT);
        definition.setPropertyValue(TEST_STRING_0);

        generator = new FreeTextPropertyComponentGenerator();
    }

    /**
     * <p>
     * Tests class constructor and <code>getPropertyType()</code> method.
     * Method should return {@link PropertyType#FREE_TEXT} value.
     * </p>
     */
    public void testGetPropertyType() {
        assertEquals("Method getPropertyType() works incorrect. PropertyType.FREE_TEXT value should be returned.",
            PropertyType.FREE_TEXT, generator.getPropertyType());
    }

    /**
     * <p>
     * Tests <code>generateComponent(PropertyDefinition)</code> method.
     * According to definition value JTextField value should be set to TEST_STRING_1.
     * </p>
     */
    public void testGenerateComponent0() {
        definition.setPropertyValue(TEST_STRING_1);
        JTextField textField = generator.generateComponent(definition);

        assertEquals("JTextField.getText() should return the same value as definition value.",
            TEST_STRING_1, textField.getText());
    }

    /**
     * <p>
     * Tests <code>generateComponent(PropertyDefinition)</code> method.
     * </p>
     * <p>
     * Definition value should be consistent with JTextField text.
     * </p>
     */
    public void testGenerateComponent1() {
        JTextField textField = generator.generateComponent(definition);

        textField.setText(TEST_STRING_1);
        assertEquals("Definition value should be updated according to JTextField text.",
            TEST_STRING_1, definition.getPropertyValue());

        textField.setText(TEST_STRING_0);
        assertEquals("Definition value should be updated according to JTextField text.",
            TEST_STRING_0, definition.getPropertyValue());
    }
}