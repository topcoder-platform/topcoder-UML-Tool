/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.converters;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.Property;

import com.topcoder.uml.modelmanager.UMLModelManager;

import com.topcoder.umltool.xmiconverters.poseidon5.TestHelper;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterConfigurationException;
import com.topcoder.umltool.xmiconverters.poseidon5.propertytransformers.RegexToLowerPropertyValueTransformer;

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

import java.util.List;
import java.util.Map;


/**
 * <p>
 * Unit tests for <code>GraphPropertiesConverter</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GraphPropertiesConverterUnitTest extends TestCase {
    /**
     * <p>
     * The constant represents the default namespace to configure this converter. The key-to-key pairs
     * and the transformers ObjectFactory names will be in the namespace of ConfigManager.
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
        return new TestSuite(GraphPropertiesConverterUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>GraphPropertiesConverter()</code>.
     *
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtor() throws Exception {
        ConfigManager.getInstance()
                 .add("test_files" + File.separator
                    + "GraphPropertiesConverter1.xml");

        GraphPropertiesConverter converter = new GraphPropertiesConverter();
        assertNotNull("Unable to create GraphPropertiesConverter instance.",
            converter);

        Field fdKeys = converter.getClass()
                                .getDeclaredField("toReplacePropertyKeys");
        fdKeys.setAccessible(true);

        Map keys = (Map) fdKeys.get(converter);
        assertEquals("There are two key pairs.", 2, keys.size());
        assertEquals("The key for fill is FILL_COLOR.", "FILL_COLOR",
            keys.get("fill"));
        assertEquals("The key for font-color is FONT_COLOR", "FONT_COLOR",
            keys.get("font-color"));

        Field fdTransformers = converter.getClass()
                                        .getDeclaredField("transformers");
        fdTransformers.setAccessible(true);

        List transformers = (List) fdTransformers.get(converter);
        assertEquals("There is one transformer.", 0, transformers.size());
    }

    /**
     * <p>
     * Accuracy test for constructor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     *
     * @throws Exceptoin if any error occurs
     */
    public void testCtorStr() throws Exception {
        ConfigManager.getInstance()
                 .add("test_files" + File.separator
                    + "GraphPropertiesConverter.xml");

        GraphPropertiesConverter converter = new GraphPropertiesConverter(DEFAULT_NAMESPACE);
        assertNotNull("Unable to create GraphPropertiesConverter instance.",
            converter);

        Field fdKeys = converter.getClass()
                                .getDeclaredField("toReplacePropertyKeys");
        fdKeys.setAccessible(true);

        Map keys = (Map) fdKeys.get(converter);
        assertEquals("There are two key pairs.", 2, keys.size());
        assertEquals("The key for fill is FILL_COLOR.", "FILL_COLOR",
            keys.get("fill"));
        assertEquals("The key for font-color is FONT_COLOR", "FONT_COLOR",
            keys.get("font-color"));

        Field fdTransformers = converter.getClass()
                                        .getDeclaredField("transformers");
        fdTransformers.setAccessible(true);

        List transformers = (List) fdTransformers.get(converter);
        assertEquals("There is one transformer.", 1, transformers.size());

        RegexToLowerPropertyValueTransformer tf = (RegexToLowerPropertyValueTransformer) transformers.get(0);
        assertEquals("The pattern is .* ", ".*", tf.getKeyPattern().pattern());
    }

    /**
     * <p>
     * Accuracy test for constructor <code>GraphPropertiesConverter(String)</code>.
     * Using transformer's key like key:identifier.
     * </p>
     *
     * @throws Exceptoin if any error occurs
     */
    public void testCtorStr2() throws Exception {
        ConfigManager.getInstance()
                 .add("test_files" + File.separator
                    + "GraphPropertiesConverter2.xml");

        GraphPropertiesConverter converter = new GraphPropertiesConverter(DEFAULT_NAMESPACE);
        assertNotNull("Unable to create GraphPropertiesConverter instance.",
            converter);

        Field fdKeys = converter.getClass()
                                .getDeclaredField("toReplacePropertyKeys");
        fdKeys.setAccessible(true);

        Map keys = (Map) fdKeys.get(converter);
        assertEquals("There are two key pairs.", 2, keys.size());
        assertEquals("The key for fill is FILL_COLOR.", "FILL_COLOR",
            keys.get("fill"));
        assertEquals("The key for font-color is FONT_COLOR", "FONT_COLOR",
            keys.get("font-color"));

        Field fdTransformers = converter.getClass()
                                        .getDeclaredField("transformers");
        fdTransformers.setAccessible(true);

        List transformers = (List) fdTransformers.get(converter);
        assertEquals("There is one transformer.", 1, transformers.size());

        RegexToLowerPropertyValueTransformer tf = (RegexToLowerPropertyValueTransformer) transformers.get(0);
        assertEquals("The pattern is .* ", ".*", tf.getKeyPattern().pattern());
    }

    /**
     * <p>
     * Failure test for constructor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the nameSpace is null, IllegalArgumentException is expected.
     * </p>
     * @throws XMIConverterConfigurationException if any error occurs
     */
    public void testCtorStr_Failure() throws XMIConverterConfigurationException {
        try {
            new GraphPropertiesConverter(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the nameSpace doesn't exist, XMIConverterConfigurationException is expected.
     * </p>
     */
    public void testCtorStr_Failure2() {
        try {
            //The namespace doesn't exist
            new GraphPropertiesConverter(DEFAULT_NAMESPACE);

            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If item of toReplacePropertyKeys have more than one values,
     * XMIConverterConfigurationException is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure3() throws Exception {
        try {
            ConfigManager.getInstance()
                    .add("test_files" + File.separator
                        + "GraphPropertiesConverterInvalid1.xml");

            new GraphPropertiesConverter(DEFAULT_NAMESPACE);

            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If object factory's namespace doesn't exist, XMIConverterConfigurationException
     * is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure4() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator +
                "GraphPropertiesConverterInvalid2.xml");

            new GraphPropertiesConverter(DEFAULT_NAMESPACE);

            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the config item for object factory doesn't exist, XMIConverterConfigurationException
     * is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure5() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator +
                "GraphPropertiesConverterInvalid3.xml");

            new GraphPropertiesConverter(DEFAULT_NAMESPACE);

            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the key for transformers doesn't exist in object factory, XMIConverterConfigurationException
     * is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure6() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator +
                "GraphPropertiesConverterInvalid4.xml");

            new GraphPropertiesConverter(DEFAULT_NAMESPACE);

            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the key for transformers is invalid, XMIConverterConfigurationException
     * is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure7() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator +
                "GraphPropertiesConverterInvalid5.xml");

            new GraphPropertiesConverter(DEFAULT_NAMESPACE);

            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the key for transformers is invalid, XMIConverterConfigurationException
     * is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure8() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator +
                "GraphPropertiesConverterInvalid6.xml");

            new GraphPropertiesConverter(DEFAULT_NAMESPACE);

            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the key for transformers is invalid, XMIConverterConfigurationException
     * is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure9() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator +
                "GraphPropertiesConverterInvalid7.xml");

            new GraphPropertiesConverter(DEFAULT_NAMESPACE);

            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the transformer doesn't implements PropertyValueTransformer, XMIConverterConfigurationException
     * is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure10() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator +
                "GraphPropertiesConverterInvalid8.xml");

            new GraphPropertiesConverter(DEFAULT_NAMESPACE);

            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the object factory's configuration has errors, XMIConverterConfigurationException
     * is expected.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testCtorStr_Failure11() throws Exception {
        try {
            ConfigManager.getInstance()
                         .add("test_files" + File.separator +
                "GraphPropertiesConverterInvalid9.xml");

            new GraphPropertiesConverter(DEFAULT_NAMESPACE);

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
     * <p>
     * Verify:There is only toReplace keys, and the GraphPropertiesTest.xmi's all properties are named 'fill',
     * it should be replaced by 'FILL_COLOR'
     * </p>
     * @throws Exception if any error occurs
     */
    public void testEndElement() throws Exception {
        //Add the namespace for GraphPropertiesConverter
        ConfigManager.getInstance()
                     .add("test_files" + File.separator +
            "GraphPropertiesConverter3.xml");

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
        TestHelper.addConverter(converterHandler, new GraphPropertiesConverter());
        reader.addHandler("UML:Diagram", converterHandler);

        reader.parse(new File("test_files" + File.separator +
                "GraphPropertiesTest.xmi"));

        UMLModelManager manager = handler.getUmlModelManager();

        for (Diagram diagram : manager.getDiagrams()) {
            verifyReplace(diagram);
        }
    }

    /**
     * <p>Verify that all the 'fill' property has been replaced by 'FILL_COLOR'.</p>
     *
     * @param element the graph element to verify
     * @throws Exception if the FILL still existed
     */
    private void verifyReplace(DiagramElement element)
        throws Exception {
        for (Property property : element.getProperties()) {
            if (!property.getKey().equals("FILL_COLOR")) {
                throw new Exception("The fill isn't been transformed.");
            }
        }

        if (element instanceof GraphElement) {
            for (DiagramElement de : ((GraphElement) element).getContaineds()) {
                verifyReplace(de);
            }
        }
    }

    /**
     * <p>
     * Accuracy test for <code>endElement(String, String, String, XMIConverterChain, XMIReader, XMIHandler)</code>.
     * </p>
     *
     * <p>
     * Verify:There is transformers, and the GraphPropertiesTest.xmi's all properties are named 'fill', and its values
     * are all '#FFFFFF', it should be transformed to '#ffffff'.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testEndElement2() throws Exception {
        //Add the namespace for GraphPropertiesConverter
        ConfigManager.getInstance()
                     .add("test_files" + File.separator +
            "GraphPropertiesConverter4.xml");

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
        TestHelper.addConverter(converterHandler, new GraphPropertiesConverter());
        reader.addHandler("UML:Diagram", converterHandler);

        reader.parse(new File("test_files" + File.separator +
                "GraphPropertiesTest.xmi"));

        UMLModelManager manager = handler.getUmlModelManager();

        for (Diagram diagram : manager.getDiagrams()) {
            verifyTransform(diagram);
        }
    }

    /**
     * <p>Verify that all the 'fill' property has been transformed from #FFFFFF to #ffffff.</p>
     *
     * @param element the graph element to verify
     * @throws Exception if the FILL still existed
     */
    private void verifyTransform(DiagramElement element)
        throws Exception {
        for (Property property : element.getProperties()) {
            if (!property.getValue().equals("#ffffff")) {
                throw new Exception("The #FFFFFF isn't been transformed.");
            }
        }

        if (element instanceof GraphElement) {
            for (DiagramElement de : ((GraphElement) element).getContaineds()) {
                verifyTransform(de);
            }
        }
    }
}
