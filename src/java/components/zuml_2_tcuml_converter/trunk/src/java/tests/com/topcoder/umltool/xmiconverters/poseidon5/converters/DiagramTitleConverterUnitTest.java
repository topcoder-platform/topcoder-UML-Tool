/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.converters;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;

import com.topcoder.uml.modelmanager.UMLModelManager;

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
 * Unit tests for <code>DiagramTitleConverter</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DiagramTitleConverterUnitTest extends TestCase {
    /**
     * <p>
     * The constant represents the default namespace to configure this converter. The convertToTextElement
     * and default properties for text node will be in the namespace of ConfigManager.
     * </p>
     */
    public static final String DEFAULT_NAMESPACE = "com.topcoder.umltool.xmiconverters.poseidon5";

    /**
     * <p>Set up the environment.</p>
     */
    protected void setUp() {
        TestHelper.resetConfig();
    }

    /**
     * <p>Tear down the environment.</p>
     */
    protected void tearDown() {
        TestHelper.resetConfig();
    }

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DiagramTitleConverterUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>DiagramTitleConverter()</code>.
     * </p>
     * @throws Exception if any error occurs
     */
    public void testCtor() throws Exception {
        ConfigManager.getInstance()
                     .add("test_files" + File.separator
                        + "DiagramTitleConverter.xml");

        DiagramTitleConverter converter = new DiagramTitleConverter();
        assertNotNull("Unable to create DiagramTitleConverter instance.",
            converter);

        Field fdConvert = converter.getClass()
                                   .getDeclaredField("convertToTextElement");
        fdConvert.setAccessible(true);

        boolean convert = ((Boolean) fdConvert.get(converter)).booleanValue();
        assertTrue("The convert is set to true.", convert);

        Field fdProperties = converter.getClass()
                                      .getDeclaredField("textElementProperties");
        fdProperties.setAccessible(true);

        Map map = (Map) fdProperties.get(converter);
        assertEquals("The FILL_COLOR is set to CCFFCC.", "CCFFCC",
            map.get("FILL_COLOR"));
        assertEquals("The FONT_FAMILY is set to Arial.", "Arial",
            map.get("FONT_FAMILY"));
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>DiagramTitleConverter(String)</code>.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr() throws Exception {
        ConfigManager.getInstance()
                     .add("test_files" + File.separator
                        + "DiagramTitleConverter.xml");

        DiagramTitleConverter converter = new DiagramTitleConverter(DEFAULT_NAMESPACE);
        assertNotNull("Unable to create DiagramTitleConverter instance.",
            converter);

        Field fdConvert = converter.getClass()
                                   .getDeclaredField("convertToTextElement");
        fdConvert.setAccessible(true);

        boolean convert = ((Boolean) fdConvert.get(converter)).booleanValue();
        assertTrue("The convert is set to true.", convert);

        Field fdProperties = converter.getClass()
                                      .getDeclaredField("textElementProperties");
        fdProperties.setAccessible(true);

        Map map = (Map) fdProperties.get(converter);
        assertEquals("The FILL_COLOR is set to CCFFCC.", "CCFFCC",
            map.get("FILL_COLOR"));
        assertEquals("The FONT_FAMILY is set to Arial.", "Arial",
            map.get("FONT_FAMILY"));
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>DiagramTitleConverter(String)</code>.
     * ConvertDiagramTitleToTextElement is not presented in the config file, using false as default.
     * And there is no text element properties.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr1() throws Exception {
        ConfigManager.getInstance()
                     .add("test_files" + File.separator
                        + "DiagramTitleConverter1.xml");

        DiagramTitleConverter converter = new DiagramTitleConverter(DEFAULT_NAMESPACE);
        assertNotNull("Unable to create DiagramTitleConverter instance.",
            converter);

        Field fdConvert = converter.getClass()
                                   .getDeclaredField("convertToTextElement");
        fdConvert.setAccessible(true);

        boolean convert = ((Boolean) fdConvert.get(converter)).booleanValue();
        assertFalse("The convert is set to true.", convert);

        Field fdProperties = converter.getClass()
                                      .getDeclaredField("textElementProperties");
        fdProperties.setAccessible(true);

        Map map = (Map) fdProperties.get(converter);
        assertTrue("The properties is emtpy.", map.isEmpty());
    }

    /**
     * <p>
     * Failure test for the constructor <code>DiagramTitleConverter(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the namespace is null, IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure1() throws Exception {
        try {
            new DiagramTitleConverter(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for the constructor <code>DiagramTitleConverter(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the namespace is empty, IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure2() throws Exception {
        try {
            new DiagramTitleConverter("  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for the constructor <code>DiagramTitleConverter(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the namespace doesn't exist, XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure3() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "DiagramTitleConverter.xml");

            new DiagramTitleConverter("unknow namespace");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for the constructor <code>DiagramTitleConverter(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the namespace the config file is invalid, XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure4() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "DiagramTitleConverterInvalid.xml");

            new DiagramTitleConverter(DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>endElement(String, String, String, XMIConverterChain, XMIReader, XMIHandler)</code>.
     * Test the situation that convertToTextElement is true.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testEndElement1() throws Exception {
        //Add the namespaces for DiagramTitleConverter
        ConfigManager.getInstance()
                     .add("test_files" + File.separator
                        + "DiagramTitleConverter.xml");

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
        TestHelper.addConverter(converterHandler, new DiagramTitleConverter());
        reader.addHandler("UML:Diagram", converterHandler);

        reader.parse(new File("test_files" + File.separator
            + "DiagramSizeTest.xmi"));

        UMLModelManager manager = handler.getUmlModelManager();

        //The NameCompartment node should not exist any more, it's changed to FreeText
        boolean existed = false;

        for (Diagram diagram : manager.getDiagrams()) {
            for (DiagramElement element : diagram.getContaineds()) {
                if (element instanceof GraphNode) {
                    SemanticModelBridge model = ((GraphNode) element).getSemanticModel();

                    if (model instanceof SimpleSemanticModelElement) {
                        String typeInfo = ((SimpleSemanticModelElement) model).getTypeInfo();
                        assertFalse("The title node should be changed.",
                            "NameCompartment".equals(typeInfo));

                        if ("FreeText".equals(typeInfo)) {
                            existed = true;
                        }
                    }
                }
            }
        }

        assertTrue("The FreeText node should be added.", existed);
    }

    /**
     * <p>
     * Accuracy test for <code>endElement(String, String, String, XMIConverterChain, XMIReader, XMIHandler)</code>.
     * Test the situation that convertToTextElement is false, it will remove the title node.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testEndElement2() throws Exception {
        //Add the namespaces for DiagramTitleConverter, the config item is empty
        ConfigManager.getInstance()
                     .add("test_files" + File.separator
                        + "DiagramTitleConverter1.xml");

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
        TestHelper.addConverter(converterHandler, new DiagramTitleConverter());
        reader.addHandler("UML:Diagram", converterHandler);

        reader.parse(new File("test_files" + File.separator
            + "DiagramSizeTest.xmi"));

        UMLModelManager manager = handler.getUmlModelManager();

        //The NameCompartment node should not exist any more, and not FreeText node added(means the node is removed.)
        boolean existed = false;

        for (Diagram diagram : manager.getDiagrams()) {
            for (DiagramElement element : diagram.getContaineds()) {
                if (element instanceof GraphNode) {
                    SemanticModelBridge model = ((GraphNode) element).getSemanticModel();

                    if (model instanceof SimpleSemanticModelElement) {
                        String typeInfo = ((SimpleSemanticModelElement) model).getTypeInfo();
                        assertFalse("The title node should be changed.",
                            "NameCompartment".equals(typeInfo));

                        if ("FreeText".equals(typeInfo)) {
                            existed = true;
                        }
                    }
                }
            }
        }

        assertFalse("The FreeText node should not be added.", existed);
    }
}
