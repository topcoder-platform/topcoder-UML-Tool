/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.umltool.xmiconverters.poseidon5.PropertyValueTransformer;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterConfigurationException;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConvertersUtil;
import com.topcoder.umltool.xmiconverters.poseidon5.propertytransformers.RegexToLowerPropertyValueTransformer;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.xmi.reader.XMIReader;

/**
 * <p>
 * Failure tests fixture for <code>XMIConvertersUtil</code> class.
 * </p>
 * @author Thinfox
 * @version 1.0
 */
public class XMIConvertersUtilFailureTests extends TestCase {
    /**
     * <p>
     * The constant represents the default namespace to configure the XMIReader, the additional
     * handlers and XMIConverters are configured in the namespace of ConfigManager.
     * </p>
     */
    public static final String DEFAULT_NAMESPACE = "com.topcoder.umltool.xmiconverters.poseidon5";

    /**
     * <p>
     * Set up the environment.
     * </p>
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        FailureTestHelper.clearConfig();
        ConfigManager.getInstance().add("failure/XMIConvertersUtil.xml");
    }

    /**
     * <p>
     * Tear down the environment.
     * </p>
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        FailureTestHelper.clearConfig();
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader)</code>.
     * </p>
     * <p>
     * When the reader is null, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_Null() throws Exception {
        try {
            XMIConvertersUtil.config(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the reader is null, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_NullXMIReader() throws Exception {
        try {
            XMIConvertersUtil.config(null, DEFAULT_NAMESPACE);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the namespace is null, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_NullNamespace() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the namespace is empty, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_EmptyNamespace() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "   ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the namespace doesn't exist, XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_UnknownNamespace() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "unknown");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the property ObjectFactoryNamespace doesn't exist, XMIConverterConfigurationException is
     * expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_ObjectFactoryNamespaceMissing() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "ObjectFactoryNamespaceMissing");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the namespace specified by ObjectFactoryNamespace is empty,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_ObjectFactoryNamespaceEmpty() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "ObjectFactoryNamespaceEmpty");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the namespace specified by ObjectFactoryNamespace is unknown,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_ObjectFactoryNamespaceUnknown() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "ObjectFactoryNamespaceUnknown");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the property AdditionalHandlers contains an empty sub-property,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_EmptyAdditionalHandlerKey() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "EmptyAdditionalHandlerKey");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the property AdditionalHandlers contains an invalid sub-property,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_InvalidAdditionalHandlerKey1() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "InvalidAdditionalHandlerKey1");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the property AdditionalHandlers contains an invalid sub-property,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_InvalidAdditionalHandlerKey2() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "InvalidAdditionalHandlerKey2");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the property AdditionalHandlers contains an invalid sub-property,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_InvalidAdditionalHandlerKey3() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "InvalidAdditionalHandlerKey3");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the property AdditionalHandlers contains an invalid sub-property,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_InvalidAdditionalHandlerKey4() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "InvalidAdditionalHandlerKey4");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the property AdditionalHandlers contains a sub-property with multi-values,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_AdditionalHandlerMultiValues() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "AdditionalHandlerMultiValues");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the property Converters contains an empty sub-property,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_EmptyConverterKey() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "EmptyConverterKey");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the property Converters contains an invalid sub-property,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_InvalidConverterKey1() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "InvalidConverterKey1");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the property Converters contains an invalid sub-property,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_InvalidConverterKey2() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "InvalidConverterKey2");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the property Converters contains an invalid sub-property,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_InvalidConverterKey3() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "InvalidConverterKey3");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the property Converters contains an invalid sub-property,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_InvalidConverterKey4() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "InvalidConverterKey4");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>config(XMIReader, String)</code>.
     * </p>
     * <p>
     * When the property Converters contains a sub-property with multi-values,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConfig_ConverterMultiValues() throws Exception {
        try {
            XMIConvertersUtil.config(new XMIReader(), "ConverterMultiValues");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>adjustGraphNodeSize(GraphNode, double, double, double)</code>.
     * </p>
     * <p>
     * When the diagram is null, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testAdjustGraphNodeSize_NullDiagram() throws Exception {

        try {
            double emptyWidth = 200;
            double emptyHeight = 100;
            double margin = 10;
            XMIConvertersUtil.adjustGraphNodeSize(null, emptyWidth, emptyHeight, margin);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>adjustGraphNodeSize(GraphNode, double, double, double)</code>.
     * </p>
     * <p>
     * When the emptyWidth is NaN, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testAdjustGraphNodeSize_NaNEmptyWidth() throws Exception {
        try {
            double emptyWidth = Double.NaN;
            double emptyHeight = 1;
            double margin = 1;
            XMIConvertersUtil.adjustGraphNodeSize(new GraphNode(), emptyWidth, emptyHeight, margin);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>adjustGraphNodeSize(GraphNode, double, double, double)</code>.
     * </p>
     * <p>
     * When the emptyHeight is NaN, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testAdjustGraphNodeSize_NaNEmptyHeight() throws Exception {
        try {
            double emptyWidth = 1;
            double emptyHeight = Double.NaN;
            double margin = 1;
            XMIConvertersUtil.adjustGraphNodeSize(new GraphNode(), emptyWidth, emptyHeight, margin);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>adjustGraphNodeSize(GraphNode, double, double, double)</code>.
     * </p>
     * <p>
     * When the margin is NaN, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testAdjustGraphNodeSize_NaNMargin() throws Exception {
        try {
            double emptyWidth = 1;
            double emptyHeight = 1;
            double margin = Double.NaN;
            XMIConvertersUtil.adjustGraphNodeSize(new GraphNode(), emptyWidth, emptyHeight, margin);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>adjustGraphNodeSize(GraphNode, double, double, double)</code>.
     * </p>
     * <p>
     * When the emptyWidth is negative, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testAdjustGraphNodeSize_NegativeEmptyWidth() throws Exception {
        try {
            double emptyWidth = -1;
            double emptyHeight = 1;
            double margin = 1;
            XMIConvertersUtil.adjustGraphNodeSize(new GraphNode(), emptyWidth, emptyHeight, margin);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>adjustGraphNodeSize(GraphNode, double, double, double)</code>.
     * </p>
     * <p>
     * When the emptyHeight is negative, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testAdjustGraphNodeSize_NegativeEmptyHeight() throws Exception {
        try {
            double emptyWidth = 1;
            double emptyHeight = -1;
            double margin = 1;
            XMIConvertersUtil.adjustGraphNodeSize(new GraphNode(), emptyWidth, emptyHeight, margin);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>adjustGraphNodeSize(GraphNode, double, double, double)</code>.
     * </p>
     * <p>
     * When the margin is negative, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testAdjustGraphNodeSize_NegativeMargin() throws Exception {
        try {
            double emptyWidth = 1;
            double emptyHeight = 1;
            double margin = -1;
            XMIConvertersUtil.adjustGraphNodeSize(new GraphNode(), emptyWidth, emptyHeight, margin);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    /**
     * <p>
     * Tests the method <code>replacePropertyKeys(DiagramElement, Map)</code>.
     * </p>
     * <p>
     * When the diagram is null, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testReplacePropertyKeys_NullDiagram() throws Exception {
        try {
            Map < String, String > toReplacePropertyKeys = new HashMap < String, String >();
            toReplacePropertyKeys.put("fill", "FILL_COLOR");
            XMIConvertersUtil.replacePropertyKeys(null, toReplacePropertyKeys);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>replacePropertyKeys(DiagramElement, Map)</code>.
     * </p>
     * <p>
     * When the toReplacePropertyKeys is null, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testReplacePropertyKeys_NullMap() throws Exception {
        try {
            XMIConvertersUtil.replacePropertyKeys(new GraphNode(), null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>replacePropertyKeys(DiagramElement, Map)</code>.
     * </p>
     * <p>
     * When the toReplacePropertyKeys map is empty, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testReplacePropertyKeys_EmptyMap() throws Exception {
        try {
            Map < String, String > toReplacePropertyKeys = new HashMap < String, String >();

            XMIConvertersUtil.replacePropertyKeys(new GraphNode(), toReplacePropertyKeys);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>replacePropertyKeys(DiagramElement, Map)</code>.
     * </p>
     * <p>
     * When the toReplacePropertyKeys map contains null key, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testReplacePropertyKeys_NullKeyMap() throws Exception {
        try {
            Map < String, String > toReplacePropertyKeys = new HashMap < String, String >();
            toReplacePropertyKeys.put(null, "myValue");
            XMIConvertersUtil.replacePropertyKeys(new GraphNode(), toReplacePropertyKeys);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>replacePropertyKeys(DiagramElement, Map)</code>.
     * </p>
     * <p>
     * When the toReplacePropertyKeys map contains empty key, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testReplacePropertyKeys_EmptyKeyMap() throws Exception {
        try {
            Map < String, String > toReplacePropertyKeys = new HashMap < String, String >();
            toReplacePropertyKeys.put("  ", "empty");
            XMIConvertersUtil.replacePropertyKeys(new GraphNode(), toReplacePropertyKeys);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>transformPropertyValues(DiagramElement, List)</code>.
     * </p>
     * <p>
     * When the diagram is null, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testTransformPropertyValues_NullDiagram() throws Exception {
        try {
            List < PropertyValueTransformer > transformers = new ArrayList < PropertyValueTransformer >();
            PropertyValueTransformer transformer = new RegexToLowerPropertyValueTransformer(".*");
            transformers.add(transformer);
            XMIConvertersUtil.transformPropertyValues(null, transformers);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>transformPropertyValues(DiagramElement, List)</code>.
     * </p>
     * <p>
     * When the transformer list is null, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testTransformPropertyValues_NullList() throws Exception {
        try {
            XMIConvertersUtil.transformPropertyValues(new GraphNode(), null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>transformPropertyValues(DiagramElement, List)</code>.
     * </p>
     * <p>
     * When the transformer list contains null element, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testTransformPropertyValues_NullElementList() throws Exception {
        try {
            List < PropertyValueTransformer > transformers = new ArrayList < PropertyValueTransformer >();
            PropertyValueTransformer transformer = new RegexToLowerPropertyValueTransformer(".*");
            transformers.add(transformer);
            transformers.add(null);
            XMIConvertersUtil.transformPropertyValues(new GraphNode(), null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>convertDiagramTitleToText(Diagram, Map)</code>.
     * </p>
     * <p>
     * When the diagram is null, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testConvertDiagramTitleToText_NullDiagram() throws Exception {
        try {
            Map < String, String > properties = new HashMap < String, String >();
            properties.put("FILL_COLOR", "CCFFCC");
            properties.put("FONT_FAMILY", "Arial");

            XMIConvertersUtil.convertDiagramTitleToText(null, properties);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the method <code>removeDiagramTitle(Diagram)</code>.
     * </p>
     * <p>
     * When the diagram is null, IllegalArgumentException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testRemoveDiagramTitle_NullDiagram() throws Exception {
        try {
            XMIConvertersUtil.removeDiagramTitle(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
