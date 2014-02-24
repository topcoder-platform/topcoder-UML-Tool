/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.stresstests;

import java.util.Arrays;
import java.util.HashSet;

import com.topcoder.gui.configurationmanager.PropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;
import com.topcoder.gui.configurationmanager.componentgenerators.CheckBoxPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.componentgenerators.DropDownPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.componentgenerators.FreeTextPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.componentgenerators.RadioButtonsPropertyComponentGenerator;

/**
 * Stress tests for implementation of <code>PropertyComponentGenerator</code>.
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GeneratorStressTests extends BaseStressTest {
    /**
     * The first load to test.
     */
    private static final int LOAD1 = 10;

    /**
     * The second load to test.
     */
    private static final int LOAD2 = 100;

    /**
     * Represents PropertyDefinition instance used in tests.
     */
    private PropertyDefinition propertyDefinition;

    /**
     * PropertyComponentGenerator instance to test.
     */
    private PropertyComponentGenerator target;

    /**
     * Create PropertyDefinition instance.
     * 
     * @throws Exception
     *             to JUnit.
     */
    protected void setUp() throws Exception {
        propertyDefinition = new PropertyDefinition();
        propertyDefinition.setPromptText("prompt");
        propertyDefinition.setPropertyName("name");
    }

    /**
     * Stress test method for <code>CheckBoxPropertyComponentGenerator#generateComponent()</code>
     * with low burden.
     */
    public void testCheckBoxPropertyComponentGenerator1() {
        propertyDefinition.setPropertyType(PropertyType.CHECK_BOX);
        propertyDefinition.setPropertyValue("false");
        target = new CheckBoxPropertyComponentGenerator();

        this.start();
        for (int i = 0; i < LOAD1; i++) {
            target.generateComponent(propertyDefinition);
        }
        this.stop();
        // print execute info
        System.out.println("Run generateComponent() method of CheckBoxPropertyComponentGenerator "
                + "for " + LOAD1 + " times consumes " + getMilliseconds() + " milliseconds.");
    }

    /**
     * Stress test method for <code>CheckBoxPropertyComponentGenerator#generateComponent()</code>
     * with high burden.
     */
    public void testCheckBoxPropertyComponentGenerator2() {
        propertyDefinition.setPropertyType(PropertyType.CHECK_BOX);
        propertyDefinition.setPropertyValue("false");
        target = new CheckBoxPropertyComponentGenerator();

        this.start();
        for (int i = 0; i < LOAD2; i++) {
            target.generateComponent(propertyDefinition);
        }
        this.stop();
        // print execute info
        System.out.println("Run generateComponent() method of CheckBoxPropertyComponentGenerator "
                + "for " + LOAD2 + " times consumes " + getMilliseconds() + " milliseconds.");
    }

    /**
     * Stress test method for <code>DropDownPropertyComponentGenerator#generateComponent()</code>
     * with low burden.
     */
    public void testDropDownPropertyComponentGenerator1() {
        propertyDefinition.setPropertyType(PropertyType.DROP_DOWN);
        propertyDefinition.setPropertyValue("2");
        propertyDefinition.setValueChoices(new HashSet<String>(Arrays.asList("1", "2", "3")));
        target = new DropDownPropertyComponentGenerator();

        this.start();
        for (int i = 0; i < LOAD1; i++) {
            target.generateComponent(propertyDefinition);
        }
        this.stop();
        // print execute info
        System.out.println("Run generateComponent() method of DropDownPropertyComponentGenerator "
                + "for " + LOAD1 + " times consumes " + getMilliseconds() + " milliseconds.");
    }

    /**
     * Stress test method for <code>DropDownPropertyComponentGenerator#generateComponent()</code>
     * with low burden.
     */
    public void testDropDownPropertyComponentGenerator2() {
        propertyDefinition.setPropertyType(PropertyType.DROP_DOWN);
        propertyDefinition.setPropertyValue("2");
        propertyDefinition.setValueChoices(new HashSet<String>(Arrays.asList("1", "2", "3")));
        target = new DropDownPropertyComponentGenerator();

        this.start();
        for (int i = 0; i < LOAD2; i++) {
            target.generateComponent(propertyDefinition);
        }
        this.stop();
        // print execute info
        System.out.println("Run generateComponent() method of DropDownPropertyComponentGenerator "
                + "for " + LOAD2 + " times consumes " + getMilliseconds() + " milliseconds.");
    }

    /**
     * Stress test method for <code>FreeTextPropertyComponentGenerator#generateComponent()</code>
     * with low burden.
     */
    public void testFreeTextPropertyComponentGenerator1() {
        propertyDefinition.setPropertyType(PropertyType.FREE_TEXT);
        propertyDefinition.setPropertyValue("2");
        target = new FreeTextPropertyComponentGenerator();

        this.start();
        for (int i = 0; i < LOAD1; i++) {
            target.generateComponent(propertyDefinition);
        }
        this.stop();
        // print execute info
        System.out.println("Run generateComponent() method of FreeTextPropertyComponentGenerator "
                + "for " + LOAD1 + " times consumes " + getMilliseconds() + " milliseconds.");
    }

    /**
     * Stress test method for <code>FreeTextPropertyComponentGenerator#generateComponent()</code>
     * with low burden.
     */
    public void testFreeTextPropertyComponentGenerator2() {
        propertyDefinition.setPropertyType(PropertyType.FREE_TEXT);
        propertyDefinition.setPropertyValue("2");
        target = new FreeTextPropertyComponentGenerator();

        this.start();
        for (int i = 0; i < LOAD2; i++) {
            target.generateComponent(propertyDefinition);
        }
        this.stop();
        // print execute info
        System.out.println("Run generateComponent() method of FreeTextPropertyComponentGenerator "
                + "for " + LOAD2 + " times consumes " + getMilliseconds() + " milliseconds.");
    }

    /**
     * Stress test method for
     * <code>RadioButtonsPropertyComponentGenerator#generateComponent()</code> with low burden.
     */
    public void testRadioButtonsPropertyComponentGenerator1() {
        propertyDefinition.setPropertyType(PropertyType.RADIO_BUTTONS);
        propertyDefinition.setPropertyValue("2");
        propertyDefinition.setValueChoices(new HashSet<String>(Arrays.asList("1", "2", "3")));
        target = new RadioButtonsPropertyComponentGenerator();

        this.start();
        for (int i = 0; i < LOAD1; i++) {
            target.generateComponent(propertyDefinition);
        }
        this.stop();
        // print execute info
        System.out
                .println("Run generateComponent() method of RadioButtonsPropertyComponentGenerator "
                        + "for "
                        + LOAD1
                        + " times consumes "
                        + getMilliseconds()
                        + " milliseconds.");
    }

    /**
     * Stress test method for
     * <code>RadioButtonsPropertyComponentGenerator#generateComponent()</code> with low burden.
     */
    public void testRadioButtonsPropertyComponentGenerator2() {
        propertyDefinition.setPropertyType(PropertyType.RADIO_BUTTONS);
        propertyDefinition.setPropertyValue("2");
        propertyDefinition.setValueChoices(new HashSet<String>(Arrays.asList("1", "2", "3")));
        target = new RadioButtonsPropertyComponentGenerator();

        this.start();
        for (int i = 0; i < LOAD2; i++) {
            target.generateComponent(propertyDefinition);
        }
        this.stop();
        // print execute info
        System.out
                .println("Run generateComponent() method of RadioButtonsPropertyComponentGenerator "
                        + "for "
                        + LOAD2
                        + " times consumes "
                        + getMilliseconds()
                        + " milliseconds.");
    }
}
