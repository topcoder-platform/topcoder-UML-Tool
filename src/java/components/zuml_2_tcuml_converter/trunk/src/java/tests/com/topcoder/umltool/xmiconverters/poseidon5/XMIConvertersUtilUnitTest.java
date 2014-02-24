/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

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

import com.topcoder.umltool.xmiconverters.poseidon5.converters.DiagramTitleConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.handlers.ZUMLHeaderHandler;
import com.topcoder.umltool.xmiconverters.poseidon5.propertytransformers.RegexToLowerPropertyValueTransformer;

import com.topcoder.util.config.ConfigManager;

import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * Unit tests for <code>XMIConvertersUtil</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class XMIConvertersUtilUnitTest extends TestCase {
    /**
     * <p>
     * The constant represents the default namespace to configure the XMIReader,
     * the additional handlers and XMIConverters are configured in the namespace of ConfigManager.
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
        return new TestSuite(XMIConvertersUtilUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for <code>config(XMIReader)</code>.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfig1() throws Exception {
        XMIReader reader = new XMIReader();
        reader.addHandler("UML:Diagram", new ZUMLHeaderHandler(new String[0]));

        ConfigManager.getInstance()
                     .add("test_files" + File.separator
                        + "XMIConvertersUtil.xml");

        XMIConvertersUtil.config(reader);
        assertNotNull("The addtional handler for XMI.Reader should be added.",
            reader.getHandler("XMI.header"));

        Field fdChain = reader.getHandler("UML:Diagram").getClass()
                              .getDeclaredField("rootChain");
        fdChain.setAccessible(true);

        DefaultXMIConverterChain chain = (DefaultXMIConverterChain) fdChain.get(reader.getHandler(
                    "UML:Diagram"));
        assertNotNull("The chain has one next chain.", chain.getNext());

        DefaultXMIConverterChain next = (DefaultXMIConverterChain) chain.getNext();
        assertNull("It's the end of the chain.", next.getNext());
        assertTrue("The converte added is instance of DiagramTitleConverter.",
            chain.getConverter() instanceof DiagramTitleConverter);
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the reader is null, IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfig_Failure1() throws Exception {
        try {
            XMIConvertersUtil.config(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr1() throws Exception {
        XMIReader reader = new XMIReader();
        reader.addHandler("UML:Diagram", new ZUMLHeaderHandler(new String[0]));

        ConfigManager.getInstance()
                     .add("test_files" + File.separator
                        + "XMIConvertersUtil.xml");

        XMIConvertersUtil.config(reader, DEFAULT_NAMESPACE);
        assertNotNull("The addtional handler for XMI.Reader should be added.",
            reader.getHandler("XMI.header"));

        Field fdChain = reader.getHandler("UML:Diagram").getClass()
                              .getDeclaredField("rootChain");
        fdChain.setAccessible(true);

        DefaultXMIConverterChain chain = (DefaultXMIConverterChain) fdChain.get(reader.getHandler(
                    "UML:Diagram"));
        assertNotNull("The chain has one next chain.", chain.getNext());

        DefaultXMIConverterChain next = (DefaultXMIConverterChain) chain.getNext();
        assertNull("It's the end of the chain.", next.getNext());
        assertTrue("The converte added is instance of DiagramTitleConverter.",
            chain.getConverter() instanceof DiagramTitleConverter);
    }

    /**
     * <p>
     * Accuracy test for <code>config(XMIReader, String)</code>.
     * There are not converters.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr2() throws Exception {
        XMIReader reader = new XMIReader();

        XMIHandler handler = reader.getHandler("XMI.header");
        assertNull("There are not handler for XMI.header.", handler);

        ConfigManager.getInstance()
                     .add("test_files" + File.separator
                        + "XMIConvertersUtil2.xml");

        XMIConvertersUtil.config(reader, DEFAULT_NAMESPACE);

        handler = reader.getHandler("XMI.header");
        assertNotNull("The addtional handler should be added.", handler);
    }

    /**
     * <p>
     * Accuracy test for <code>config(XMIReader, String)</code>.
     * There are not addtional handlers
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr3() throws Exception {
        XMIReader reader = new XMIReader();

        //Add converter handler
        reader.addHandler("UML:Diagram",
            new XMIConverterHandler(new ZUMLHeaderHandler(new String[0]), reader));

        ConfigManager.getInstance()
                     .add("test_files" + File.separator
                        + "XMIConvertersUtil3.xml");

        XMIConvertersUtil.config(reader, DEFAULT_NAMESPACE);

        Field fdChain = reader.getHandler("UML:Diagram").getClass()
                              .getDeclaredField("rootChain");
        fdChain.setAccessible(true);

        DefaultXMIConverterChain chain = (DefaultXMIConverterChain) fdChain.get(reader.getHandler(
                    "UML:Diagram"));
        assertNotNull("The chain has one next chain.", chain.getNext());

        DefaultXMIConverterChain next = (DefaultXMIConverterChain) chain.getNext();
        assertNull("It's the end of the chain.", next.getNext());
        assertTrue("The converte added is instance of DiagramTitleConverter.",
            chain.getConverter() instanceof DiagramTitleConverter);
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the reader is null, IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure() throws Exception {
        try {
            XMIConvertersUtil.config(null, DEFAULT_NAMESPACE);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the nameSpace is null, IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure2() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the nameSpace is empty, IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure3() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "   ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the namespace doesn't exist, XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure4() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the ObjectFactoryNamespace item doesn't exist,
     * XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure5() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "XMIConvertersUtilInvalid1.xml");

            XMIConvertersUtil.config(new XMIReader(), DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the namespace specified by ObjectFactoryNamespace item doesn't exist,
     * XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure6() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "XMIConvertersUtilInvalid2.xml");

            XMIConvertersUtil.config(new XMIReader(), DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the object factory's config has error,
     * XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure7() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "XMIConvertersUtilInvalid3.xml");

            XMIConvertersUtil.config(new XMIReader(), DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the handler's key doesn't exist in object factory's config,
     * XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure8() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "XMIConvertersUtilInvalid4.xml");

            XMIConvertersUtil.config(new XMIReader(), DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the handler has more than one values,
     * XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure9() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "XMIConvertersUtilInvalid5.xml");

            XMIConvertersUtil.config(new XMIReader(), DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the handler's value is wrong format like key:id:sss,
     * XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure10() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "XMIConvertersUtilInvalid6.xml");

            XMIConvertersUtil.config(new XMIReader(), DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the handler's value is wrong format like 'key:',
     * XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure11() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "XMIConvertersUtilInvalid7.xml");

            XMIConvertersUtil.config(new XMIReader(), DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the handler's value is wrong format like ':id',
     * XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure12() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "XMIConvertersUtilInvalid8.xml");

            XMIConvertersUtil.config(new XMIReader(), DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the handler is not instance of XMIHandler,
     * XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure13() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "XMIConvertersUtilInvalid9.xml");

            XMIConvertersUtil.config(new XMIReader(), DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the converter doesn't have any values,
     * XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure14() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "XMIConvertersUtilInvalid10.xml");

            XMIConvertersUtil.config(new XMIReader(), DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the converter's key is invalid (such ass "key:id:xxx"),
     * XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure15() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "XMIConvertersUtilInvalid11.xml");

            XMIConvertersUtil.config(new XMIReader(), DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the converter's key is invalid (such ass "key:"),
     * XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure16() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "XMIConvertersUtilInvalid12.xml");

            XMIConvertersUtil.config(new XMIReader(), DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the converter's key is invalid (such ass ":id"),
     * XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure17() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "XMIConvertersUtilInvalid13.xml");

            XMIConvertersUtil.config(new XMIReader(), DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the converter isn't instance of XMIConverter,
     * XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure18() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "XMIConvertersUtilInvalid14.xml");

            XMIConvertersUtil.config(new XMIReader(), DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>config(XMIReader, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the handler which the converter is added to doesn't exist,
     * XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testConfigStr_Failure19() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator
                            + "XMIConvertersUtilInvalid15.xml");

            XMIConvertersUtil.config(new XMIReader(), DEFAULT_NAMESPACE);
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Create GraphNode instance for adjustGraphNode's test.
     * </p>
     *
     * @return a GraphNode instance
     */
    private GraphNode createGraphNodeForAdjustTest() {
        GraphNode node = new GraphNode();

        //Add a non GraphNode and GraphEdge element
        node.addContained(new Ellipse());

        //Create a node at (100, 50) and size is (100, 50), then add it to the node
        GraphNode childNode1 = new GraphNode();
        Dimension d = new Dimension();
        d.setWidth(100);
        d.setHeight(50);
        childNode1.setSize(d);

        Point p = new Point();
        p.setX(100);
        p.setY(50);
        childNode1.setPosition(p);
        node.addContained(childNode1);

        //Create a node at (10, 20), size is (30, 70), then add it to the node
        GraphNode childNode2 = new GraphNode();
        d = new Dimension();
        d.setHeight(70);
        d.setWidth(30);
        childNode2.setSize(d);
        p = new Point();
        p.setX(10);
        p.setY(20);
        childNode2.setPosition(p);
        node.addContained(childNode2);

        //Create a edge at (200, 30), (100, 100), then add it to the node
        GraphEdge edge1 = createEdgeForTest();

        node.addContained(edge1);

        return node;
    }

    /**
     * <p>Create a edge at (200, 30), (100, 100) for testing.</p>
     * @return a edge at (200,30), (100, 100)
     */
    private GraphEdge createEdgeForTest() {
        //Create a edge at (200, 30), (100, 100)
        GraphEdge edge1 = new GraphEdge();

        Point wp1 = new Point();
        wp1.setX(200);
        wp1.setY(30);
        edge1.addWaypoint(wp1);

        Point wp2 = new Point();
        wp2.setX(100);
        wp1.setY(100);
        edge1.addWaypoint(wp2);

        return edge1;
    }

    /**
     * <p>
     * Accuracy test for <code>adjustGraphNodeSize(GraphNode, double, double, double)</code>.
     * </p>
     */
    public void testAdjustGraphNodeSize() {
        GraphNode node = createGraphNodeForAdjustTest();

        XMIConvertersUtil.adjustGraphNodeSize(node, 100, 50, 10);

        assertEquals("The new width should be 210.", 210d,
            node.getSize().getWidth());
        assertEquals("The new height should be 110.", 110d,
            node.getSize().getHeight());

        //Test a node with 0 width and height
        node = new GraphNode();
        XMIConvertersUtil.adjustGraphNodeSize(node, 100, 50, 10);
        assertEquals("The new width should be 100.", 100d,
            node.getSize().getWidth());
        assertEquals("The new height should be 50.", 50d,
            node.getSize().getHeight());
    }

    /**
     * <p>
     * Failure test for <code>adjustGraphNodeSize(GraphNode, double, double, double)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the node is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAdjustGraphNodeSize_Failure1() {
        try {
            XMIConvertersUtil.adjustGraphNodeSize(null, 0, 0, 0);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>adjustGraphNodeSize(GraphNode, double, double, double)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the emptyWidth is negative, IllegalArgumentException is expected.
     * </p>
     */
    public void testAdjustGraphNodeSize_Failure2() {
        try {
            XMIConvertersUtil.adjustGraphNodeSize(new GraphNode(), -1, 0, 0);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>adjustGraphNodeSize(GraphNode, double, double, double)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the emptyHeight is negative, IllegalArgumentException is expected.
     * </p>
     */
    public void testAdjustGraphNodeSize_Failure3() {
        try {
            XMIConvertersUtil.adjustGraphNodeSize(new GraphNode(), 0, -1, 0);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>adjustGraphNodeSize(GraphNode, double, double, double)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the margin is negative, IllegalArgumentException is expected.
     * </p>
     */
    public void testAdjustGraphNodeSize_Failure4() {
        try {
            XMIConvertersUtil.adjustGraphNodeSize(new GraphNode(), 0, 0, -1);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>Create a map for replace property key testing.</p>
     * @return a map for replace property keys
     */
    private Map<String, String> createMapForReplacePropertyKey() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("p1", "t1");
        map.put("p2", "t2");
        map.put("p4", "t4");

        return map;
    }

    /**
     * <p>
     * Accuracy test for <code>replacePropertyKeys(DiagramElement, Map&lt;String, String&gt;)</code>.
     * </p>
     */
    public void testReplacePropertyKeys() {
        Map<String, String> map = createMapForReplacePropertyKey();

        GraphNode root = new GraphNode();
        Property p1 = new Property();
        p1.setKey("p1");
        p1.setValue("VALUE1");
        root.addProperty(p1);

        GraphNode childNode1 = new GraphNode();
        root.addContained(childNode1);

        Property p2 = new Property();
        p2.setKey("p2");
        p2.setValue("Value2");
        childNode1.addProperty(p2);

        GraphNode childNode2 = new GraphNode();
        root.addContained(childNode2);

        Property p3 = new Property();
        p3.setKey("p3");
        p3.setValue("Value3");
        childNode2.addProperty(p3);

        GraphNode grandNode = new GraphNode();
        childNode2.addContained(grandNode);

        Property p4 = new Property();
        p4.setKey("p4");
        p4.setValue("Value4");
        childNode2.addProperty(p4);

        XMIConvertersUtil.replacePropertyKeys(root, map);

        assertEquals("The p1's key should be replaced.", "t1", p1.getKey());
        assertEquals("The p2's key should be replaced.", "t2", p2.getKey());
        assertEquals("The p3's key should not be replaced.", "p3", p3.getKey());
        assertEquals("The p4's key should be replaced.", "t4", p4.getKey());
    }

    /**
     * <p>
     * Failure test for <code>replacePropertyKeys(DiagramElement, Map&lt;String, String&gt;)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the diagram element is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testReplacePropertyKeys_Failure1() {
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("p1", "t1");

            XMIConvertersUtil.replacePropertyKeys(null, map);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>replacePropertyKeys(DiagramElement, Map&lt;String, String&gt;)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the map is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testReplacePropertyKeys_Failure2() {
        try {
            XMIConvertersUtil.replacePropertyKeys(new GraphNode(), null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>replacePropertyKeys(DiagramElement, Map&lt;String, String&gt;)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the map is empty, IllegalArgumentException is expected.
     * </p>
     */
    public void testReplacePropertyKeys_Failure3() {
        try {
            Map<String, String> map = new HashMap<String, String>();

            XMIConvertersUtil.replacePropertyKeys(new GraphNode(), map);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>replacePropertyKeys(DiagramElement, Map&lt;String, String&gt;)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the map contains null key, IllegalArgumentException is expected.
     * </p>
     */
    public void testReplacePropertyKeys_Failure4() {
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put(null, "t1");

            XMIConvertersUtil.replacePropertyKeys(new GraphNode(), map);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>replacePropertyKeys(DiagramElement, Map&lt;String, String&gt;)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the map contains empty key, IllegalArgumentException is expected.
     * </p>
     */
    public void testReplacePropertyKeys_Failure5() {
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("   ", "t1");

            XMIConvertersUtil.replacePropertyKeys(new GraphNode(), map);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>transformPropertyValues(DiagramElement, List&lt;PropertyValueTransformer&gt;)</code>.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testTransformPropertyValues() throws Exception {
        List<PropertyValueTransformer> transformers = new LinkedList<PropertyValueTransformer>();
        transformers.add(new RegexToLowerPropertyValueTransformer("PROPERTY.*"));

        GraphNode root = new GraphNode();
        Property p1 = new Property();
        p1.setKey("PROPERTY1");
        p1.setValue("VALUE1");
        root.addProperty(p1);

        GraphNode childNode1 = new GraphNode();
        root.addContained(childNode1);

        Property p2 = new Property();
        p2.setKey("PROPERTY2");
        p2.setValue("Value2");
        childNode1.addProperty(p2);

        GraphNode childNode2 = new GraphNode();
        root.addContained(childNode2);

        Property p3 = new Property();
        p3.setKey("UProperty3");
        p3.setValue("Value3");
        childNode2.addProperty(p3);

        GraphNode grandNode = new GraphNode();
        childNode2.addContained(grandNode);

        Property p4 = new Property();
        p4.setKey("PROPERTY4");
        p4.setValue("Value4");
        childNode2.addProperty(p4);

        XMIConvertersUtil.transformPropertyValues(root, transformers);
        assertEquals("The root node's property1 should be transformed.",
            "value1", p1.getValue());
        assertEquals("The childNode1's property2 should be transformed.",
            "value2", p2.getValue());
        assertEquals("The childNode2's UProperty3 should not be transformed.",
            "Value3", p3.getValue());
        assertEquals("The grandNode's PROPERTY4 should be tranformed.",
            "value4", p4.getValue());
    }

    /**
     * <p>
     * Failure test for <code>transformPropertyValues(DiagramElement, List&lt;PropertyValueTransformer&gt;)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the DiagramElement is null, IllegalArgumentException is expected.
     */
    public void testTransformPropertyValues_Failure1() {
        try {
            List<PropertyValueTransformer> transformers = new LinkedList<PropertyValueTransformer>();
            transformers.add(new RegexToLowerPropertyValueTransformer(".*"));

            XMIConvertersUtil.transformPropertyValues(null, transformers);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>transformPropertyValues(DiagramElement, List&lt;PropertyValueTransformer&gt;)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the list is null, IllegalArgumentException is expected.
     */
    public void testTransformPropertyValues_Failure2() {
        try {
            XMIConvertersUtil.transformPropertyValues(new GraphNode(), null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>transformPropertyValues(DiagramElement, List&lt;PropertyValueTransformer&gt;)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the DiagramElement is empty, IllegalArgumentException is expected.
     */
    public void testTransformPropertyValues_Failure3() {
        try {
            List<PropertyValueTransformer> transformers = new LinkedList<PropertyValueTransformer>();

            XMIConvertersUtil.transformPropertyValues(new GraphNode(),
                transformers);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>transformPropertyValues(DiagramElement, List&lt;PropertyValueTransformer&gt;)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the transformers contains null, IllegalArgumentException is expected.
     */
    public void testTransformPropertyValues_Failure4() {
        try {
            List<PropertyValueTransformer> transformers = new LinkedList<PropertyValueTransformer>();
            transformers.add(new RegexToLowerPropertyValueTransformer(".*"));
            transformers.add(null);

            XMIConvertersUtil.transformPropertyValues(new GraphNode(),
                transformers);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>convertDiagramTitleToText(Diagram, Properties)</code>.
     * </p>
     */
    public void testConvertDiagramTitleToText1() {
        Diagram diagram = new Diagram();

        //Test emtpy Diagram
        XMIConvertersUtil.convertDiagramTitleToText(diagram, null);

        diagram.addContained(new GraphEdge());

        //Add a Core node
        GraphNode node1 = new GraphNode();
        node1.setSemanticModel(new CoreSemanticModelBridge());
        diagram.addContained(node1);

        //Add a simple node but not title node
        SimpleSemanticModelElement model2 = new SimpleSemanticModelElement();
        model2.setTypeInfo("Unknow");

        GraphNode node2 = new GraphNode();
        node2.setSemanticModel(model2);
        diagram.addContained(node2);

        //There is not title node, it should process successfully
        XMIConvertersUtil.convertDiagramTitleToText(diagram, null);
    }

    /**
     * <p>
     * Accuracy test for <code>convertDiagramTitleToText(Diagram, Properties)</code>.
     * </p>
     */
    public void testConvertDiagramTitleToText2() {
        Diagram diagram = new Diagram();

        diagram.addContained(new GraphEdge());

        //Add a Core node
        GraphNode node1 = new GraphNode();
        node1.setSemanticModel(new CoreSemanticModelBridge());
        diagram.addContained(node1);

        //Add a simple node but not title node
        SimpleSemanticModelElement model2 = new SimpleSemanticModelElement();
        model2.setTypeInfo("Unknow");

        GraphNode node2 = new GraphNode();
        node2.setSemanticModel(model2);
        diagram.addContained(node2);

        //Add a title node
        GraphNode titleNode = new GraphNode();
        diagram.addContained(titleNode);

        SimpleSemanticModelElement model = new SimpleSemanticModelElement();
        model.setTypeInfo("NameCompartment");
        titleNode.setSemanticModel(model);

        XMIConvertersUtil.convertDiagramTitleToText(diagram, null);
        assertEquals("The typeInfo is changed to FreeText.", "FreeText",
            model.getTypeInfo());
    }

    /**
     * <p>
     * Accuracy test for <code>convertDiagramTitleToText(Diagram, Properties)</code>.
     * </p>
     */
    public void testConvertDiagramTitleToText3() {
        Diagram diagram = new Diagram();

        //Add a simple node but not title node
        SimpleSemanticModelElement model2 = new SimpleSemanticModelElement();
        model2.setTypeInfo("Unknow");

        GraphNode node2 = new GraphNode();
        node2.setSemanticModel(model2);
        diagram.addContained(node2);

        //Add a title node
        GraphNode titleNode = new GraphNode();
        diagram.addContained(titleNode);

        SimpleSemanticModelElement model = new SimpleSemanticModelElement();
        model.setTypeInfo("NameCompartment");
        titleNode.setSemanticModel(model);

        //Add typeInfo for the diagram
        SimpleSemanticModelElement diagramModel = new SimpleSemanticModelElement();
        diagramModel.setTypeInfo("ClassDiagram");
        diagram.setSemanticModel(diagramModel);
        diagram.setName("diagram1");

        Map<String, String> properties = new HashMap<String, String>();
        properties.put("key", "value");

        XMIConvertersUtil.convertDiagramTitleToText(diagram, properties);
        assertEquals("The titleNode's property has one element now.", 1,
            titleNode.getProperties().size());

        Property prop = (Property) titleNode.getProperties().toArray()[0];
        assertEquals("The property's key is key.", "key", prop.getKey());
        assertEquals("The property's value is value.", "value", prop.getValue());

        boolean existed = false;

        for (DiagramElement element : titleNode.getContaineds()) {
            if (element instanceof TextElement) {
                existed = true;
                assertEquals("The text element's text is cd:diagram1",
                    "cd:diagram1", ((TextElement) element).getText());
            }
        }

        assertTrue("The text element should be created.", existed);
    }

    /**
     * <p>
     * Failure test for <code>convertDiagramTitleToText(Diagram, Properties)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the diagram is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testConvertDiagramTitleToText_Failure() {
        try {
            XMIConvertersUtil.convertDiagramTitleToText(null,
                new HashMap<String, String>());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>removeDiagramTitle(Diagram)</code>.
     * </p>
     */
    public void testRemoveDiagramTitle() {
        //Test a diagram with only one title node
        Diagram diagram = new Diagram();

        //It should process successfully, do nothing
        XMIConvertersUtil.removeDiagramTitle(diagram);

        diagram = new Diagram();

        //Add a edge
        diagram.addContained(new GraphEdge());

        //Add a Core node
        GraphNode node1 = new GraphNode();
        node1.setSemanticModel(new CoreSemanticModelBridge());
        diagram.addContained(node1);

        //Add a simple node but now title node
        SimpleSemanticModelElement model2 = new SimpleSemanticModelElement();
        model2.setTypeInfo("Unknow");

        GraphNode node2 = new GraphNode();
        node2.setSemanticModel(model2);
        diagram.addContained(node2);

        //there is not title node, do nothing
        assertEquals("The diagram has 3 nodes.", 3,
            diagram.getContaineds().size());
        XMIConvertersUtil.removeDiagramTitle(diagram);
        assertEquals("The title node should be removed.", 3,
            diagram.getContaineds().size());

        //Add a title node
        GraphNode titleNode = new GraphNode();
        diagram.addContained(titleNode);

        SimpleSemanticModelElement model = new SimpleSemanticModelElement();
        model.setTypeInfo("NameCompartment");
        titleNode.setSemanticModel(model);

        //The title node should be removed
        assertEquals("The diagram has 4 nodes.", 4,
            diagram.getContaineds().size());
        XMIConvertersUtil.removeDiagramTitle(diagram);
        assertEquals("The title node should be removed.", 3,
            diagram.getContaineds().size());
    }

    /**
     * <p>
     * Failure test for <code>removeDiagramTitle(Diagram)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the diagram is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveDiagramTitle_Failure() {
        try {
            XMIConvertersUtil.removeDiagramTitle(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}
