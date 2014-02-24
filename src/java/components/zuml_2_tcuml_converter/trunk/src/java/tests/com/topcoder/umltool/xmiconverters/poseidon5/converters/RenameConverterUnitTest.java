/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.converters;

import com.topcoder.umltool.xmiconverters.poseidon5.TestHelper;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterConfigurationException;

import com.topcoder.util.config.ConfigManager;

import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.diagraminterchange.DiagramInterchangeXMIHandler;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;

import java.lang.reflect.Field;

import java.util.Map;


/**
 * <p>
 * Unit tests for <code>RenameConverter</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RenameConverterUnitTest extends TestCase {
    /**
     * <p>
     * The constant represents the default namespace to configure this converter.
     * The name-to-name pairs will be in the namespace of ConfigManager.
     * </p>
     */
    public static final String DEFAULT_NAMESPACE = "com.topcoder.umltool.xmiconverters.poseidon5";

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(RenameConverterUnitTest.class);
    }

    /**
     * <p>Set up the environment.</p>
     */
    protected void setUp() {
        //Clear all namespace in the ConfigManager
        TestHelper.resetConfig();
    }

    /**
     * <p>Destroy the environment.</p>
     */
    protected void tearDown() {
        TestHelper.resetConfig();
    }

    /**
     * <p>
     * Accuracy test for constructor <code>RenameConverter()</code>.
     * </p>
     * @throws Exception if any error occurs
     */
    public void testCtor() throws Exception {
        ConfigManager.getInstance()
                 .add("test_files" + File.separator
                    + "RenameConverter1.xml");

        RenameConverter converter = new RenameConverter();
        assertNotNull("Unable to create RenameConverter instance.", converter);

        Field fdMaps = converter.getClass().getDeclaredField("toRenameNames");
        fdMaps.setAccessible(true);

        Map map = (Map) fdMaps.get(converter);
        assertEquals("There is not rename maps.", 0, map.size());
    }

    /**
     * <p>
     * Accuracy test for constructor <code>RenameConverter(String)</code>.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr() throws Exception {
        ConfigManager.getInstance()
                 .add("test_files" + File.separator
                    + "RenameConverter.xml");

        RenameConverter converter = new RenameConverter(DEFAULT_NAMESPACE);
        assertNotNull("Unable to create RenameConverter instance.", converter);

        Field fdMaps = converter.getClass().getDeclaredField("toRenameNames");
        fdMaps.setAccessible(true);

        Map map = (Map) fdMaps.get(converter);
        assertEquals("The UML2:TypedElement.type should be renamed to UML:StructuralFeature.type",
            "UML:StructuralFeature.type", map.get("UML2:TypedElement.type"));
        assertEquals("The UML:Class should be renamed to UML:Classifier",
            "UML:Classifier", map.get("UML:Class"));
        assertEquals("The UML:DateType should be renamed to UML:Class",
            "UML:Classifier", map.get("UML:DateType"));
    }

    /**
     * <p>
     * Failure test for constructor <code>RenameConverter()</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the nameSpace is null, IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure1() throws Exception {
        try {
            new RenameConverter(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>RenameConverter()</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the nameSpace is empty, IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure2() throws Exception {
        try {
            new RenameConverter(" ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>RenameConverter()</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the nameSpace doesn't exist, XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure3() throws Exception {
        try {
            new RenameConverter(DEFAULT_NAMESPACE);

            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>RenameConverter()</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the one property has more than 1 values, XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure4() throws Exception {
        try {
            ConfigManager.getInstance()
                     .add("test_files" + File.separator
                        + "RenameConverterInvalid1.xml");
            new RenameConverter(DEFAULT_NAMESPACE);

            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>endElement(String, String, String, XMIConverterChain, XMIReader, XMIHandler)</code>.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testStartElement() throws Exception {
        //Add the namespace for GraphPropertiesConverter
        ConfigManager.getInstance()
                 .add("test_files" + File.separator
                    + "RenameConverter.xml");

        //Add configuration for XMIReader
        TestHelper.loadSingleXMLConfig(XMIReader.class.getName(),
            "test_files" + File.separator + "reader_config.xml");
        TestHelper.loadSingleXMLConfig(ModelElementFactory.class.getName(),
            "test_files" + File.separator + "factory_config.xml");

        XMIReader reader = new XMIReader();

        //Set up diagram interchange xmi handler config
        DiagramInterchangeXMIHandler handler = (DiagramInterchangeXMIHandler) reader.getHandler(
                "UML:Diagram");
        handler.setModelElementFactory(new ModelElementFactory(
                ModelElementFactory.class.getName()));

        XMIHandler converterHandler = TestHelper.createXMIConverterHandler(handler,
                reader);
        TestHelper.addConverter(converterHandler, new RenameConverter());
        reader.addHandler("UML:Diagram", converterHandler);

        //It should process successfully
        reader.parse(new File("test_files" + File.separator + "RenameTest.xmi"));
    }

    /**
     * <p>
     * Accuracy test for <code>endElement(String, String, String, XMIConverterChain, XMIReader, XMIHandler)</code>.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testEndElement() throws Exception {
        //Add the namespace for GraphPropertiesConverter
        ConfigManager.getInstance()
                 .add("test_files" + File.separator
                    + "RenameConverter2.xml");

        //Add configuration for XMIReader
        TestHelper.loadSingleXMLConfig(XMIReader.class.getName(),
            "test_files" + File.separator + "reader_config.xml");
        TestHelper.loadSingleXMLConfig(ModelElementFactory.class.getName(),
            "test_files" + File.separator + "factory_config.xml");

        XMIReader reader = new XMIReader();

        //Set up diagram interchange xmi handler config
        DiagramInterchangeXMIHandler handler = (DiagramInterchangeXMIHandler) reader.getHandler(
                "UML:Diagram");
        handler.setModelElementFactory(new ModelElementFactory(
                ModelElementFactory.class.getName()));

        XMIHandler converterHandler = TestHelper.createXMIConverterHandler(handler,
                reader);
        TestHelper.addConverter(converterHandler, new RenameConverter());
        reader.addHandler("UML:Diagram", converterHandler);

        //It should process successfully
        reader.parse(new File("test_files" + File.separator + "RenameTest.xmi"));
    }
}
