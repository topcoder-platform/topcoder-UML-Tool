/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager;

import com.topcoder.gui.configurationmanager.componentgenerators.CheckBoxPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.componentgenerators.DropDownPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.componentgenerators.FreeTextPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.componentgenerators.RadioButtonsPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.validators.DirectoryValidator;

import com.topcoder.util.config.ConfigManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JFrame;

import junit.framework.TestCase;

/**
 * The demo for this component.
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class SwingDemo extends TestCase {

    /**
     * Setup test environment.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        ConfigManager cm = ConfigManager.getInstance();
        cm.add("config.xml");
        cm.add("MyClass.xml");
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
     * Demo.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public void testDemo() throws Exception {
        // create the frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create the panel
        ConfigurationManagerEditorPanel panel = null;

        // new
        // ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel");
        PropertyDefinition pd = new PropertyDefinition();
        pd.setPromptText("Name :");
        pd.setPropertyName("name");
        pd.setPropertyType(PropertyType.FREE_TEXT);
        pd.setPropertyValue("value");

        ArrayList<PropertyDefinition> pds = new ArrayList<PropertyDefinition>();
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

        ArrayList<PropertyComponentGenerator> pcgs = new ArrayList<PropertyComponentGenerator>();
        pcgs.add(new FreeTextPropertyComponentGenerator());
        pcgs.add(new CheckBoxPropertyComponentGenerator());
        pcgs.add(new DropDownPropertyComponentGenerator());
        pcgs.add(new RadioButtonsPropertyComponentGenerator());

        panel = new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel");
        panel = new ConfigurationManagerEditorPanel("MyClass", pds, 1, 1, pcgs);

        panel.setSize(400, 400);
        panel.setVisible(true);
        // add it to the frame
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);

        // Add this point the panel is shown
        // (see the RS for a picture of the panel editor). The user click to
        // modify the "size" property 8use 20) with the combobox. Then also
        // modify the name with the text field (write "Michael")

        // Set validators
        panel.addPropertyTypeValidator(PropertyType.FREE_TEXT, new DirectoryValidator());
        panel.addPropertyTypeValidator(PropertyType.RADIO_BUTTONS, new DirectoryValidator());
        panel.addPropertyTypeValidator(PropertyType.DROP_DOWN, new DirectoryValidator());
        panel.addPropertyTypeValidator(PropertyType.CHECK_BOX, new DirectoryValidator());

        // validate the properties
        ValidationResultSet resultSet = panel.validateProperties();

        // the properties are validated

        // check the validation
        if (resultSet.isSuccess()) {
            // save the properties
            // the validation is already performed since I can call directly the
            // save method
            panel.saveProperties();
            // the properties now are saved to the related namespace
        }
    }
}
