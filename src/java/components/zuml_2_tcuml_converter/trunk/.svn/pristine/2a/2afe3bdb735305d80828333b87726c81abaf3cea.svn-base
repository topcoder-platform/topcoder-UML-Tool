/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.topcoder.diagraminterchange.CoreSemanticModelBridge;
import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Ellipse;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.umltool.xmiconverters.poseidon5.PropertyValueTransformer;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConvertersUtil;
import com.topcoder.umltool.xmiconverters.poseidon5.handlers.ZUMLHeaderHandler;
import com.topcoder.umltool.xmiconverters.poseidon5.propertytransformers.RegexToLowerPropertyValueTransformer;
import com.topcoder.xmi.reader.XMIReader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Accuracy test cases for class XMIConvertersUtil.
 * </p>
 *
 * @author abram
 * @version 1.0
 */
public class XMIConvertersUtilAccuracyTest extends TestCase {

    /**
     * The instance of XMIReader for testing..
     */
    private XMIReader reader;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(XMIConvertersUtilAccuracyTest.class);
    }

    /**
     * <p>
     * Accuracy test for public static field.
     * </p>
     *
     * <p>
     * Target: Verify that public static field is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testStaticField_Accuracy() throws Exception {
        assertEquals("Expected default namespace:", "com.topcoder.umltool.xmiconverters.poseidon5",
                XMIConvertersUtil.DEFAULT_NAMESPACE);
    }

    /**
     * <p>
     * Accuracy test for <code>config(XMIReader)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>config(XMIReader)</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testConfig1_Accuracy() throws Exception {
        AccuracyTestHelper.clearConfig();
        reader = new XMIReader();
        reader.addHandler("UML:Diagram", new ZUMLHeaderHandler(new String[0]));

        AccuracyTestHelper.loadConfig("config_xmi_converters_util.xml");

        XMIConvertersUtil.config(reader);
        assertNotNull("Should not be null.", reader.getHandler("XMI.header"));

        AccuracyTestHelper.clearConfig();
    }

    /**
     * <p>
     * Accuracy test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>config(XMIReader, String)</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testConfig2_Accuracy() throws Exception {
        AccuracyTestHelper.clearConfig();
        reader = new XMIReader();
        reader.addHandler("UML:Diagram", new ZUMLHeaderHandler(new String[0]));

        AccuracyTestHelper.loadConfig("config_xmi_converters_util.xml");

        XMIConvertersUtil.config(reader, "com.topcoder.umltool.xmiconverters.poseidon5");
        assertNotNull("Should not be null.", reader.getHandler("XMI.header"));

        AccuracyTestHelper.clearConfig();
    }

    /**
     * <p>
     * Accuracy test for <code>adjustGraphNodeSize(GraphNode, double, double, double)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>adjustGraphNodeSize(GraphNode, double, double, double)</code> is
     * correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAdjustGraphNodeSize_Accuracy() throws Exception {
        GraphNode node = createGraphNode();

        XMIConvertersUtil.adjustGraphNodeSize(node, 75, 75, 75);

        assertEquals("Expected Width:", 200d, node.getSize().getWidth());
        assertEquals("Expected Heigth:", 200d, node.getSize().getHeight());
    }

    /**
     * <p>
     * Accuracy test for <code>replacePropertyKeys(DiagramElement, Map<String, String>)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>replacePropertyKeys(DiagramElement, Map<String, String>)</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testReplacePropertyKeys_Accuracy() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "newKey1");
        map.put("key2", "newKey2");
        map.put("key3", "newKey3");

        // set the property for rootNode
        GraphNode rootNode = new GraphNode();

        Property prop1 = new Property();
        prop1.setKey("key1");
        prop1.setValue("value1");
        rootNode.addProperty(prop1);

        Property prop2 = new Property();
        prop2.setKey("key10");
        prop2.setValue("value10");
        rootNode.addProperty(prop2);

        // set the property for child node
        GraphNode childNode = new GraphNode();
        rootNode.addContained(childNode);

        Property prop3 = new Property();
        prop3.setKey("key2");
        prop3.setValue("value2");
        childNode.addProperty(prop3);


        XMIConvertersUtil.replacePropertyKeys(rootNode, map);

        assertEquals("Expected key: ", "newKey1", prop1.getKey());
        assertEquals("Expected key: ", "key10", prop2.getKey());
        assertEquals("Expected key: ", "newKey2", prop3.getKey());
    }

    /**
     * <p>
     * Accuracy test for
     * <code>transformPropertyValues(DiagramElement, List<PropertyValueTransformer>)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that
     * <code>transformPropertyValues(DiagramElement, List<PropertyValueTransformer>)</code> is
     * correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testTransformPropertyValues_Accuracy() throws Exception {
        List<PropertyValueTransformer> transformers = new ArrayList<PropertyValueTransformer>();
        transformers.add(new RegexToLowerPropertyValueTransformer("key[0-9]"));

        // set up the root node
        GraphNode rootNode = new GraphNode();
        Property prop1 = new Property();
        prop1.setKey("key1");
        prop1.setValue("VALUE1");
        rootNode.addProperty(prop1);

        Property prop2 = new Property();
        prop2.setKey("keyA");
        prop2.setValue("VALUE2");
        rootNode.addProperty(prop2);

        // add a child node
        GraphNode childNode = new GraphNode();
        rootNode.addContained(childNode);

        Property prop3 = new Property();
        prop3.setKey("key2");
        prop3.setValue("Value3");
        childNode.addProperty(prop3);

        // invoke transformPropertyValues
        XMIConvertersUtil.transformPropertyValues(rootNode, transformers);
        assertEquals("Expected value:", "value1", prop1.getValue());
        assertEquals("Expected value:", "VALUE2", prop2.getValue());
        assertEquals("Expected value:", "value3", prop3.getValue());
    }

    /**
     * <p>
     * Accuracy test for <code>convertDiagramTitleToText(Diagram, Map<String, String>)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>convertDiagramTitleToText(Diagram, Map<String, String>)</code>
     * is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testConvertDiagramTitleToText_Accuracy() throws Exception {
        Diagram diagram = new Diagram();

        // add a node (which is not title)
        SimpleSemanticModelElement model = new SimpleSemanticModelElement();
        model.setTypeInfo("SomeType");

        GraphNode node = new GraphNode();
        node.setSemanticModel(model);
        diagram.addContained(node);

        // add a title node
        GraphNode titleNode = new GraphNode();
        diagram.addContained(titleNode);

        model = new SimpleSemanticModelElement();
        model.setTypeInfo("NameCompartment");
        titleNode.setSemanticModel(model);

        // add typeInfo for the diagram
        model = new SimpleSemanticModelElement();
        model.setTypeInfo("ClassDiagram");
        diagram.setSemanticModel(model);
        diagram.setName("diagram1");

        Map<String, String> properties = new HashMap<String, String>();
        properties.put("key", "value");

        // call convertDiagramTitleToText
        XMIConvertersUtil.convertDiagramTitleToText(diagram, properties);

        assertEquals("Expected size of the properties: ", 1, titleNode.getProperties().size());
        Property prop = (Property) titleNode.getProperties().toArray()[0];
        assertEquals("Expected key: ", "key", prop.getKey());
        assertEquals("Expected value: ", "value", prop.getValue());

        boolean exist = false;

        for (DiagramElement element : titleNode.getContaineds()) {
            if (element instanceof TextElement) {
                exist = true;
                assertEquals("Expected Text: ", "cd:diagram1", ((TextElement) element).getText());
            }
        }

        assertTrue("TextElement should be met.", exist);
    }

    /**
     * <p>
     * Accuracy test for <code>removeDiagramTitle(Diagram)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>removeDiagramTitle(Diagram)</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testRemoveDiagramTitle_Accuracy() throws Exception {
        Diagram diagram = new Diagram();

        // add a core node
        GraphNode node = new GraphNode();
        node.setSemanticModel(new CoreSemanticModelBridge());
        diagram.addContained(node);

        // add a title node
        GraphNode titleNode = new GraphNode();
        diagram.addContained(titleNode);

        SimpleSemanticModelElement model = new SimpleSemanticModelElement();
        model.setTypeInfo("NameCompartment");
        titleNode.setSemanticModel(model);

        int size = 2;
        assertEquals("Expected size of contained node:", size, diagram.getContaineds().size());
        XMIConvertersUtil.removeDiagramTitle(diagram);
        assertEquals("Expected size of contained node:", size - 1, diagram.getContaineds().size());
    }

    /**
     * <p>
     * Creates and returns a GraphNode instance for testing.
     * </p>
     *
     * @return a GraphNode instance
     */
    private static GraphNode createGraphNode() {
        GraphNode graphNode = new GraphNode();

        // add a contained element which is not a GraphNode or GraphEdge
        graphNode.addContained(new Ellipse());

        //add a contained element which is a GraphNode
        GraphNode childNode = new GraphNode();
        Dimension d = new Dimension();
        d.setHeight(50);
        d.setWidth(50);
        childNode.setSize(d);

        Point p = new Point();
        p.setX(75);
        p.setY(75);
        childNode.setPosition(p);
        graphNode.addContained(childNode);

        // add a contained element which is a GraphEdge
        GraphEdge edge = new GraphEdge();
        Point point = new Point();
        point.setX(100);
        point.setY(100);
        edge.addWaypoint(point);
        graphNode.addContained(edge);

        return graphNode;
    }
}
