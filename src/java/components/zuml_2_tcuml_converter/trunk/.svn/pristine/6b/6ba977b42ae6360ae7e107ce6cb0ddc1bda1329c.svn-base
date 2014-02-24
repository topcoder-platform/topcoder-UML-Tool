/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import com.topcoder.diagraminterchange.Diagram;

import com.topcoder.uml.modelmanager.UMLModelManager;

import com.topcoder.umltool.xmiconverters.poseidon5.handlers.ZUMLHeaderHandler;
import com.topcoder.umltool.xmiconverters.poseidon5.handlers.ZUMLMethodHandler;
import com.topcoder.umltool.xmiconverters.poseidon5.propertytransformers.RegexToLowerPropertyValueTransformer;

import com.topcoder.util.config.ConfigManager;

import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.diagraminterchange.DiagramInterchangeXMIHandler;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * Demo of this component.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {
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
        return new TestSuite(Demo.class);
    }

    /**
     * <p>
     * Demo1 of this component. It will use default namespace to config
     * the reader and then parse a zuml file by the reader.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testDemo() throws Exception {
        ConfigManager.getInstance()
                     .add("test_files" + File.separator + "demo1.xml");

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

        XMIConvertersUtil.config(reader);

        assertNotNull("The XMI.header's handler is added.",
            reader.getHandler("XMI.header"));
        assertNotNull("The UML:Method's handler is added.",
            reader.getHandler("UML:Method"));
        assertTrue("The XMI.header's handler is added.",
            reader.getHandler("XMI.header") instanceof ZUMLHeaderHandler);
        assertTrue("The UML:Method's handler is added.",
            reader.getHandler("UML:Method") instanceof ZUMLMethodHandler);

        assertTrue("Converter is added for UML:Diagram.",
            reader.getHandler("UML:Diagram") instanceof XMIConverterHandler);
        assertTrue("Converter is added for UML:Atribute.",
            reader.getHandler("UML:Diagram") instanceof XMIConverterHandler);
        assertTrue("Converter is added for UML:Parameter.",
            reader.getHandler("UML:Diagram") instanceof XMIConverterHandler);
        assertTrue("Converter is added for UML:Operation.",
            reader.getHandler("UML:Diagram") instanceof XMIConverterHandler);

        //It should process successfully
        reader.parseZipFile("test_files" + File.separator + "sample.zuml");
    }

    /**
     * <p>
     * Demo2 of this component. It will use specified namespace to config
     * the reader and then parse a zuml file by the reader.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testDemo2() throws Exception {
        ConfigManager.getInstance()
                     .add("test_files" + File.separator + "demo2.xml");

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

        //Using demo as the namespace to reader config from.
        XMIConvertersUtil.config(reader, "demo");

        assertNotNull("The XMI.header's handler is added.",
            reader.getHandler("XMI.header"));
        assertNotNull("The UML:Method's handler is added.",
            reader.getHandler("UML:Method"));
        assertTrue("The XMI.header's handler is added.",
            reader.getHandler("XMI.header") instanceof ZUMLHeaderHandler);
        assertTrue("The UML:Method's handler is added.",
            reader.getHandler("UML:Method") instanceof ZUMLMethodHandler);

        assertTrue("Converter is added for UML:Diagram.",
            reader.getHandler("UML:Diagram") instanceof XMIConverterHandler);
        assertTrue("Converter is added for UML:Atribute.",
            reader.getHandler("UML:Diagram") instanceof XMIConverterHandler);
        assertTrue("Converter is added for UML:Parameter.",
            reader.getHandler("UML:Diagram") instanceof XMIConverterHandler);
        assertTrue("Converter is added for UML:Operation.",
            reader.getHandler("UML:Diagram") instanceof XMIConverterHandler);

        //It should process successfully
        reader.parseZipFile("test_files" + File.separator + "sample.zuml");
    }

    /**
     * <p>
     * Demo3 of this component. Do not configure the converters, use XMIConvertersUtil directly
     * to modify Diagram instances. It will use UMLModelManager to get the Diagrams which are built
     * by XMI Reader diagram Interchange plugin.
     * </p>
     *
     * @throws Exception is any error occurs
     */
    public void testDemo3() throws Exception {
        // Add configuration for XMIReader
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

        reader.parseZipFile("test_files" + File.separator + "sample.zuml");

        //Get the UMLModelManager of the DiagramInterchangeXMIHandler
        UMLModelManager manager = handler.getUmlModelManager();

        List<Diagram> list = manager.getDiagrams();

        for (Diagram diagram : list) {
            //Convert the diagram's title
            Map<String, String> properties = new HashMap<String, String>();
            properties.put("FILL_COLOR", "000000");
            XMIConvertersUtil.convertDiagramTitleToText(diagram, properties);

            //For each diagram remove title
            XMIConvertersUtil.removeDiagramTitle(diagram);

            //Adjust the diagram the size
            XMIConvertersUtil.adjustGraphNodeSize(diagram, 200, 100, 10);

            List<PropertyValueTransformer> transformers = new ArrayList<PropertyValueTransformer>();
            transformers.add(new RegexToLowerPropertyValueTransformer("font-.*"));
            transformers.add(new RegexToLowerPropertyValueTransformer("fill"));

            //Transformer the properties
            XMIConvertersUtil.transformPropertyValues(diagram, transformers);

            Map<String, String> toReplacePropertyKeys = new HashMap<String, String>();
            toReplacePropertyKeys.put("fill", "FILL_COLOR");

            //Replace the properties' keys
            XMIConvertersUtil.replacePropertyKeys(diagram, toReplacePropertyKeys);
        }
    }
}
