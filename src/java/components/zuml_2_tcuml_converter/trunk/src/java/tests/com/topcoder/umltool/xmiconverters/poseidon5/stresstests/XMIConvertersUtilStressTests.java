/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.stresstests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.umltool.xmiconverters.poseidon5.PropertyValueTransformer;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConvertersUtil;
import com.topcoder.umltool.xmiconverters.poseidon5.propertytransformers.RegexToLowerPropertyValueTransformer;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.diagraminterchange.DiagramInterchangeXMIHandler;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;

/**
 * <p>
 * Stress tests for class XMIConvertersUtil.
 * </p>
 *
 * @author extra
 * @version 1.0
 */
public class XMIConvertersUtilStressTests extends BaseStressTests {

    /**
     * <p>
     * Represents instance of XMIReader for test.
     * </p>
     */
    private XMIReader reader;

    /**
     * <p>
     * Sets up the envrionment.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    protected void setUp() throws Exception {
        clearConfig();
        addConfig("factory_config.xml");
        addConfig("reader_config.xml");
        addConfig("Converters.xml");
        reader = new XMIReader();
        DiagramInterchangeXMIHandler innerHandler = (DiagramInterchangeXMIHandler) reader.getHandler("UML:Diagram");
        innerHandler.setModelElementFactory(new ModelElementFactory(ModelElementFactory.class.getName()));

    }

    /**
     * <p>
     * Tests method config(XMIReader, String) for stress, it runs 100 times.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testConfig() throws Exception {
        reader.parse(getFile("Sample.xmi"));
        begin();
        for (int i = 0; i < 100; i++) {
            XMIConvertersUtil.config(reader, "com.topcoder.umltool.xmiconverters.poseidon5");
        }
        printResult("config(XMIReader, String)", 100);
    }

    /**
     * <p>
     * Tests method config(XMIReader, String) for stress, it uses big file.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testConfig_BigFile() throws Exception {
        reader.parse(getFile("BigFile.xmi"));
        begin();
        for (int i = 0; i < 100; i++) {
            XMIConvertersUtil.config(reader, "com.topcoder.umltool.xmiconverters.poseidon5");
        }
        printResult("config(XMIReader, String) with big file", 100);
    }

    /**
     * <p>
     * Tests method adjustGraphNodeSize(GraphNode, double, double, double) for
     * stress, it runs 100 times.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAdjustGraphNodeSize() throws Exception {
        reader.parse(getFile("Sample.xmi"));
        GraphNode graphNode = (GraphNode) reader.getElement("I76e51adfm115fa1721c8mm7e5c");
        begin();

        for (int i = 0; i < 100; i++) {
            XMIConvertersUtil.adjustGraphNodeSize(graphNode, 200, 100, 10);
        }
        printResult("adjustGraphNodeSize(GraphNode, double, double, double)", 100);
    }

    /**
     * <p>
     * Tests method adjustGraphNodeSize(GraphNode, double, double, double) for
     * stress, it uses a big file.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAdjustGraphNodeSize_BigFile() throws Exception {
        reader.parse(getFile("BigFile.xmi"));
        GraphNode graphNode = (GraphNode) reader.getElement("Im7b1a488am1157acc62acmm44b2");
        begin();
        for (int i = 0; i < 100; i++) {
            XMIConvertersUtil.adjustGraphNodeSize(graphNode, 200, 100, 10);
        }
        printResult("adjustGraphNodeSize(GraphNode, double, double, double) with big file", 100);
    }

    /**
     * <p>
     * Tests method replacePropertyKeys for stress, it runs 100 times.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testReplacePropertyKeys() throws Exception {
        reader.parse(getFile("Sample.xmi"));
        GraphNode graphNode = (GraphNode) reader.getElement("I76e51adfm115fa1721c8mm7dc4");
        Map<String, String> toReplacePropertyKeys = new HashMap<String, String>();
        toReplacePropertyKeys.put("fill", "#ff0000");
        toReplacePropertyKeys.put("font-size", "12");
        toReplacePropertyKeys.put("font-color", "#ffff00");

        begin();
        for (int i = 0; i < 100; i++) {
            XMIConvertersUtil.replacePropertyKeys(graphNode, toReplacePropertyKeys);
        }
        printResult("replacePropertyKeys(DiagramElement, Map<String, String>)", 100);
    }

    /**
     * <p>
     * Tests method replacePropertyKeys for stress, it uses big file.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testReplacePropertyKeys_BigFile() throws Exception {
        reader.parse(getFile("BigFile.xmi"));
        GraphNode graphNode = (GraphNode) reader.getElement("Im7b1a488am1157acc62acmm44b2");
        Map<String, String> toReplacePropertyKeys = new HashMap<String, String>();
        toReplacePropertyKeys.put("fill", "#ff0000");
        toReplacePropertyKeys.put("font-size", "12");
        toReplacePropertyKeys.put("font-color", "#ffff00");

        begin();
        for (int i = 0; i < 100; i++) {
            XMIConvertersUtil.replacePropertyKeys(graphNode, toReplacePropertyKeys);
        }
        printResult("replacePropertyKeys(DiagramElement, Map<String, String>) with big file", 100);
    }

    /**
     * <p>
     * Tests method transformPropertyValues for stress, it runs 100 times.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testTransformPropertyValues() throws Exception {
        reader.parse(getFile("Sample.xmi"));
        List<PropertyValueTransformer> transformers = new ArrayList<PropertyValueTransformer>();
        transformers.add(new RegexToLowerPropertyValueTransformer(".*"));
        transformers.add(new RegexToLowerPropertyValueTransformer("a.*"));

        GraphNode graphNode = (GraphNode) reader.getElement("I76e51adfm115fa1721c8mm7dc4");
        begin();
        for (int i = 0; i < 100; i++) {
            XMIConvertersUtil.transformPropertyValues(graphNode, transformers);
        }
        printResult("transformPropertyValues(DiagramElement, List<PropertyValueTransformer>)", 100);
    }

    /**
     * <p>
     * Tests method transformPropertyValues for stress, it uses big file.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testTransformPropertyValues_BigFile() throws Exception {
        reader.parse(getFile("BigFile.xmi"));
        List<PropertyValueTransformer> transformers = new ArrayList<PropertyValueTransformer>();
        transformers.add(new RegexToLowerPropertyValueTransformer(".*"));
        transformers.add(new RegexToLowerPropertyValueTransformer("a.*"));

        GraphNode graphNode = (GraphNode) reader.getElement("Im7b1a488am1157acc62acmm44b2");
        begin();
        for (int i = 0; i < 100; i++) {
            XMIConvertersUtil.transformPropertyValues(graphNode, transformers);
        }
        printResult("transformPropertyValues(DiagramElement, List<PropertyValueTransformer>) with big file", 100);
    }

    /**
     * <p>
     * Tests method convertDiagramTitleToText for stress, it runs 100 times.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testConvertDiagramTitleToText() throws Exception {
        reader.parse(getFile("Sample.xmi"));
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("name", "Sample1");
        properties.put("zoom", "2.0");

        Diagram diagram = (Diagram) reader.getElement("I76e51adfm115fa1721c8mm7e5c");

        begin();
        for (int i = 0; i < 100; i++) {
            XMIConvertersUtil.convertDiagramTitleToText(diagram, properties);
        }
        printResult("convertDiagramTitleToText(Diagram, Map<String, String>)", 100);
    }

    /**
     * <p>
     * Tests method for stress, it uses big file.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testConvertDiagramTitleToText_BigFile() throws Exception {
        reader.parse(getFile("BigFile.xmi"));
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("name", "Sample1");
        properties.put("zoom", "2.0");

        Diagram diagram = (Diagram) reader.getElement("Im7b1a488am1157acc62acmm44b2");

        begin();
        for (int i = 0; i < 100; i++) {
            XMIConvertersUtil.convertDiagramTitleToText(diagram, properties);
        }
        printResult("convertDiagramTitleToText(Diagram, Map<String, String>) with big file", 100);
    }

    /**
     * <p>
     * Tests method removeDiagramTitle(Diagram) for stress, it runs 100 times.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testRemoveDiagramTitle() throws Exception {
        reader.parse(getFile("Sample.xmi"));
        Diagram diagram = (Diagram) reader.getElement("I76e51adfm115fa1721c8mm7e5c");

        begin();
        for (int i = 0; i < 100; i++) {
            XMIConvertersUtil.removeDiagramTitle(diagram);
        }
        printResult("removeDiagramTitle(Diagram)", 100);
    }

    /**
     * <p>
     * Tests method removeDiagramTitle(Diagram) for stress, it uses big file.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testRemoveDiagramTitle_BigFile() throws Exception {
        reader.parse(getFile("BigFile.xmi"));
        Diagram diagram = (Diagram) reader.getElement("Im7b1a488am1157acc62acmm44b2");

        begin();
        for (int i = 0; i < 100; i++) {
            XMIConvertersUtil.removeDiagramTitle(diagram);
        }
        printResult("removeDiagramTitle(Diagram) with big file", 100);
    }
}
