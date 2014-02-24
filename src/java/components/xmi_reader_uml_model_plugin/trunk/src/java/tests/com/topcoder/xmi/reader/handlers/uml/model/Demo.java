/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.model;

import java.io.File;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The unit test class is used for component demonstration.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {
    /**
     * <p>
     * XMIReader instance for demonstration purpose.
     * </p>
     */
    private XMIReader reader;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(XMIReader.class.getName(), "test_files" + File.separator + "reader_config.xml");
        TestHelper.loadSingleXMLConfig(ModelElementFactory.class.getName(), "test_files" + File.separator
            + "factory_config.xml");
        reader = new XMIReader();

        XMI2ModelHandler handler = (XMI2ModelHandler) reader.getHandler("UML:Model");
        handler.setModelElementFactory(new ModelElementFactory(ModelElementFactory.class.getName()));
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfigFile(XMIReader.class.getName());
        TestHelper.clearConfigFile(ModelElementFactory.class.getName());
        reader = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(Demo.class);
    }

    /**
     * <p>
     * This test case demonstrates the usage of XMIReader and XMI2ModelHandler to
     * parse a xmi file for all the uml model elements except for State Machine and
     * Activity Graph model elements.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testModelDemo() throws Exception {
        // get the associated uml model manager
        XMI2ModelHandler handler = (XMI2ModelHandler) reader.getHandler("UML:Model");
        UMLModelManager manager = handler.getUmlModelManager();

        reader.parse(new File("test_files" + File.separator + "demo.xmi"));

        // now we can access the model using xmi id values
        Model model = (Model) reader.getElement("I1aa8eb7m10f6dbd4de0mm7f51");
        System.out.println("Model(Got from the xmi id) name : " + model.getName());

        // we can use the uml model manager to access the model as well
        model = manager.getModel();
        System.out.println("Model(Got from the uml model manager) name : " + model.getName());
    }

    /**
     * <p>
     * This test case demonstrates the functionality of ModelElementFactory.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testModelElementFactoryDemo() throws Exception {
        // Create a default instance
        ModelElementFactory modelElementFactory = new ModelElementFactory();

        // Create an instance with configuration data
        modelElementFactory = new ModelElementFactory(ModelElementFactory.class.getName());

        // Adds a new mapping to the class
        modelElementFactory.addMapping("UML:Model", "com.topcoder.uml.model.modelmanagement.ModelImpl");

        // Creates an actual instance maps to the specific xml element
        modelElementFactory.createModelElement("UML:Model");

        // Gets the class name for the given xml element
        modelElementFactory.getMapping("UML:Model");

        // Return the complete mapping
        modelElementFactory.getAllMappings();

        // Remove the xml element mapping
        modelElementFactory.removeMapping("UML:Model");
    }
}
