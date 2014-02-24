/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.w3c.dom.Document;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.UnknownElementException;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PropertyTransformer;

/**
 * <p>
 * Unit Tests for {@link Diagram2XMITransformer} class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Diagram2XMITransformerTest extends TestCase {

    /**
     * <p>
     * Map < String, DiagramInterchangeElementTransformer> instance used for testing.
     * Map of transformers known by this instance.
     * </p>
     */
    private Map < String, DiagramInterchangeElementTransformer > transformers;

    /**
     * <p>
     * Map< String, String> instance used for testing.
     * Map of class names with XML tag names.
     * </p>
     */
    private Map < String, String > tagNameMappings;

    /**
     * <p>
     * Transformer instance used for testing.
     * </p>
     */
    private Transformer xmlTransformer;

    /**
     * <p>
     * PrintStream instance used for testing.
     * </p>
     */
    private PrintStream out = new PrintStream(new ByteArrayOutputStream());

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to Junit
     */
    protected void setUp() throws Exception {
        transformers = new HashMap < String, DiagramInterchangeElementTransformer >();
        tagNameMappings = new HashMap < String, String >();
        xmlTransformer = TransformerFactory.newInstance().newTransformer();
        xmlTransformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        xmlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        transformers = null;
        xmlTransformer = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(Diagram2XMITransformerTest.class);
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map < String, DiagramInterchangeElementTransformer>,
     * Map< String,String >)' for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created Diagram2XMITransformer instance should not be null.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtorMap() throws Exception {
        assertNotNull("Fail to create a Diagram2XMITransformer instance.",
                new Diagram2XMITransformer(transformers, tagNameMappings));
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     * Map < String,String>)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when Map is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtorWithNullTransformerMap() throws Exception {
        try {
            new Diagram2XMITransformer(null, tagNameMappings);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     * Map< String,String>)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when Map contains any null key and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtorTransformerMapWithNullKey() throws Exception {
        transformers.put(null, new PropertyTransformer());
        try {
            new Diagram2XMITransformer(transformers, tagNameMappings);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     * Map< String,String>)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when Map contains any empty key and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtorTransformerMapWithEmptyKey() throws Exception {
        transformers.put("   ", new PropertyTransformer());
        try {
            new Diagram2XMITransformer(transformers, tagNameMappings);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     * Map< String,String>)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when Map contains any null value and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtorTransformerMapWithNullValue() throws Exception {
        transformers.put("Not Null", null);
        try {
            new Diagram2XMITransformer(transformers, tagNameMappings);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     * Map< String,String>)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transformers is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtorWithNullTagNameMappingsMap() throws Exception {
        try {
            new Diagram2XMITransformer(transformers, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     * Map< String,String>)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tagNameMappings contains any null key and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtorTagNameMappingsMapWithNullKey() throws Exception {
        tagNameMappings.put(null, "Not null");
        try {
            new Diagram2XMITransformer(transformers, tagNameMappings);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     * Map< String,String>)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tagNameMappings contains any null value and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtorTagNameMappingsMapWithNullValue() throws Exception {
        tagNameMappings.put("Not Null", null);
        try {
            new Diagram2XMITransformer(transformers, tagNameMappings);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     * Map< String,String>)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tagNameMappings contains any empty key and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtorTagNameMappingsMapWithEmptyKey() throws Exception {
        tagNameMappings.put("   ", "Not null");
        try {
            new Diagram2XMITransformer(transformers, tagNameMappings);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     * Map< String,String>)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tagNameMappings contains any empty value and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtorTagNameMappingsMapWithEmptyValue() throws Exception {
        tagNameMappings.put("Not Null", "   ");
        try {
            new Diagram2XMITransformer(transformers, tagNameMappings);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created Diagram2XMITransformer instance should not be null.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2() throws Exception {
        assertNotNull("Fail to create a Diagram2XMITransformer instance.",
                new Diagram2XMITransformer(transformers, tagNameMappings, xmlTransformer, true));
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transformers is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2WithNullTransformersMapWithExceptions() throws Exception {
        try {
            new Diagram2XMITransformer(null, tagNameMappings, xmlTransformer, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tagNameMappings is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2WithNullTagNameMappingsMapWithExceptions() throws Exception {
        try {
            new Diagram2XMITransformer(transformers, null, xmlTransformer, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transformers contains null keys and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2TransformersMapWithNullKeyWithExceptions() throws Exception {
        transformers.put(null, new PropertyTransformer());
        try {
            new Diagram2XMITransformer(transformers, tagNameMappings, xmlTransformer, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transformers contains empty keys and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2TransformersMapWithEmptyKeyWithExceptions() throws Exception {
        transformers.put("   ", new PropertyTransformer());
        try {
            new Diagram2XMITransformer(transformers, tagNameMappings, xmlTransformer, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transformers contains null values and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2TransformersMapWithNullValueWithExceptions() throws Exception {
        transformers.put("Not Null", null);
        try {
            new Diagram2XMITransformer(transformers, tagNameMappings, xmlTransformer, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tagNameMappings contains null keys and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2TagNameMappingsWithNullKeyWithExceptions() throws Exception {
        tagNameMappings.put(null, "Not Null");
        try {
            new Diagram2XMITransformer(transformers, tagNameMappings, xmlTransformer, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tagNameMappings contains null values and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2TagNameMappingsWithNullValueWithExceptions() throws Exception {
        tagNameMappings.put("Not Null", null);
        try {
            new Diagram2XMITransformer(transformers, tagNameMappings, xmlTransformer, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tagNameMappings contains emmpty keys and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2TagNameMappingsWithEmmptyKeyWithExceptions() throws Exception {
        tagNameMappings.put("  ", "Not Null");
        try {
            new Diagram2XMITransformer(transformers, tagNameMappings, xmlTransformer, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tagNameMappings contains emmpty values and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2TagNameMappingsWithEmptyValueWithExceptions() throws Exception {
        tagNameMappings.put("Not Null", "  ");
        try {
            new Diagram2XMITransformer(transformers, tagNameMappings, xmlTransformer, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when Transformer is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2WithNullTransformerWithExceptions() throws Exception {
        try {
            new Diagram2XMITransformer(transformers, tagNameMappings, null, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }


    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transformers is null and withException is false.
     * Expects no Exception.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2WithNullTransformersMapWithoutExceptions() throws Exception {
        assertNotNull("Fail to create a Diagram2XMITransformer instance.",
            new Diagram2XMITransformer(null, tagNameMappings, xmlTransformer, false));
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tagNameMappings is null and withException is false.
     * Expects no Exception.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2WithNullTagNameMappingsMapWithoutExceptions() throws Exception {
        assertNotNull("Fail to create a Diagram2XMITransformer instance.",
            new Diagram2XMITransformer(transformers, null, xmlTransformer, false));
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transformers contains null keys and withException is false.
     * Expects no Exception.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2TransformersMapWithNullKeyWithoutExceptions() throws Exception {
        transformers.put(null, new PropertyTransformer());
        assertNotNull("Fail to create a Diagram2XMITransformer instance.",
            new Diagram2XMITransformer(transformers, tagNameMappings, xmlTransformer, false));
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transformers contains empty keys and withException is false.
     * Expects no Exception.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2TransformersMapWithEmptyKeyWithoutExceptions() throws Exception {
        transformers.put("  ", new PropertyTransformer());
        assertNotNull("Fail to create a Diagram2XMITransformer instance.",
            new Diagram2XMITransformer(transformers, tagNameMappings, xmlTransformer, false));
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transformers contains null values and withException is false.
     * Expects no Exception.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2TransformersMapWithNullValueWithoutExceptions() throws Exception {
        transformers.put("Not Null", null);
        assertNotNull("Fail to create a Diagram2XMITransformer instance.",
            new Diagram2XMITransformer(transformers, tagNameMappings, xmlTransformer, false));
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tagNameMappings contains null keys and withException is false.
     * Expects no Exception.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2TagNameMappingsWithNullKeyWithoutExceptions() throws Exception {
        tagNameMappings.put(null, "Not Null");
        assertNotNull("Fail to create a Diagram2XMITransformer instance.",
            new Diagram2XMITransformer(transformers, tagNameMappings, xmlTransformer, false));
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tagNameMappings contains null values and withException is false.
     * Expects no Exception.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2TagNameMappingsWithNullValueWithoutExceptions() throws Exception {
        tagNameMappings.put("Not Null", null);
        assertNotNull("Fail to create a Diagram2XMITransformer instance.",
            new Diagram2XMITransformer(transformers, tagNameMappings, xmlTransformer, false));
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tagNameMappings contains empty keys and withException is false.
     * Expects no Exception.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2TagNameMappingsWithEmptyKeyWithoutExceptions() throws Exception {
        tagNameMappings.put(" ", "Not Null");
        assertNotNull("Fail to create a Diagram2XMITransformer instance.",
            new Diagram2XMITransformer(transformers, tagNameMappings, xmlTransformer, false));
    }

    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tagNameMappings contains empty values and withException is false.
     * Expects no Exception.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2TagNameMappingsWithEmptyValueWithoutExceptions() throws Exception {
        tagNameMappings.put("Not Null", "  ");
        assertNotNull("Fail to create a Diagram2XMITransformer instance.",
            new Diagram2XMITransformer(transformers, tagNameMappings, xmlTransformer, false));
    }


    /**
     * <p>
     * Test constructor for 'Diagram2XMITransformer(Map< String, DiagramInterchangeElementTransformer>,
     *  Map< String,String>, Transformer, boolean)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that when Transformer is null and withException is false.
     * Expects no Exception.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testCtor2WithNullTransformerWithoutExceptions() throws Exception {
        assertNotNull("Fail to create a Diagram2XMITransformer instance.",
               new Diagram2XMITransformer(transformers, tagNameMappings, null, false));
    }

    /**
     * <p>
     * Test method for 'transform(Object, PrintStream)' for accuracy.
     * </p>
     *
     * <p>
     * Verify : transform(Object, PrintStream) is correct.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectPrintStream() throws Exception {
        Object element = new Object();
        MockDiagramInterchangeElementTransformer mockTransformer = new MockDiagramInterchangeElementTransformer();
        transformers.put(element.getClass().getName(), mockTransformer);
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        d2XMITransformer.transform(element, new PrintStream(bout));
        // create a DOMReult instance from the PrintStream instance.
        ByteArrayInputStream in = new ByteArrayInputStream(bout.toByteArray());
        DOMResult dom = new DOMResult();
        d2XMITransformer.getXMLTransformer().transform(new StreamSource(in), dom);
        // check whether the node's localName is the same as the first Child's NodeName of the dom.
        assertEquals("The tagNames of the node should be the same.",
                mockTransformer.getTagName(), dom.getNode().getFirstChild().getNodeName());
    }


    /**
     * <p>
     * Test method for 'transform(Object, PrintStream)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is true and object is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectPrintStreamWithNullObjectWithExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(true);
        try {
            d2XMITransformer.transform(null, out);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, PrintStream)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is false and object is null and expects no IllegalArgumentException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectPrintStreamWithNullObjectWithoutExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(false);
        try {
            d2XMITransformer.transform(null, out);
            // good
        } catch (IllegalArgumentException e) {
            fail("No IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, PrintStream)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is true and PrintStream is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectPrintStreamWithNullPrintStreamWithExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(true);
        try {
            d2XMITransformer.transform(new Object(), (PrintStream) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, PrintStream)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is true and PrintStream is null and expects no
     * IllegalArgumentException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectPrintStreamWithNullPrintStreamWithoutExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(false);
        try {
            d2XMITransformer.transform(new Object(), (PrintStream) null);
            // good
        } catch (IllegalArgumentException e) {
            fail("No IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, PrintStream)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is true and a <code>DiagramInterchangeElementTransformer</code>
     * cannot be obtained for its class, expects UnknownElementException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectPrintStreamUnknowElementWithExceptions() throws Exception {
        Object element = new Object();
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(true);
        try {
            d2XMITransformer.transform(element, out);
            fail("UnknownElementException is expected.");
        } catch (UnknownElementException e) {
            // OK
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, PrintStream)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is false and a <code>DiagramInterchangeElementTransformer</code>
     * cannot be obtained for its class, expects no UnknownElementException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectPrintStreamUnknowElementWithoutExceptions() throws Exception {
        Object element = new Object();
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(false);
        try {
            d2XMITransformer.transform(element, out);
            // good
        } catch (UnknownElementException e) {
            fail("No UnknownElementException is expected.");
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, PrintStream)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is true and the transformer() method of the
     * <code>MockDiagramInterchangeElementTransformer</code> class always throws a ClassCastException, expects
     * XMITransformException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectPrintStreamClassCastExceptionWithExceptions() throws Exception {
        Object element = new Object();
        MockDiagramInterchangeElementTransformer mockTransformer = new MockDiagramInterchangeElementTransformer();
        mockTransformer.setIsThrowClassCastException(true);
        transformers.put(element.getClass().getName(), mockTransformer);
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(true);
        try {
            d2XMITransformer.transform(element, out);
            fail("XMITransformException is expected.");
        } catch (XMITransformException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, PrintStream)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is false and the transformer() method of the
     * <code>MockDiagramInterchangeElementTransformer</code> class always throws a ClassCastException, expects no
     * XMITransformException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectPrintStreamClassCastExceptionWithoutExceptions() throws Exception {
        Object element = new Object();
        MockDiagramInterchangeElementTransformer mockTransformer = new MockDiagramInterchangeElementTransformer();
        mockTransformer.setIsThrowClassCastException(true);
        transformers.put(element.getClass().getName(), mockTransformer);
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(false);
        try {
            d2XMITransformer.transform(element, out);
            // good
        } catch (XMITransformException e) {
            fail("No XMITransformException is expected.");
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, PrintStream)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is true and the transformer() method of the
     * <code>MockDiagramInterchangeElementTransformer</code> class always throws a XMITransformException, expects
     * XMITransformException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectPrintStreamXMITransformExceptionWithExceptions() throws Exception {
        Object element = new Object();
        MockDiagramInterchangeElementTransformer mockTransformer = new MockDiagramInterchangeElementTransformer();
        mockTransformer.setIsThrowXMITransformException(true);
        transformers.put(element.getClass().getName(), mockTransformer);
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(true);
        try {
            d2XMITransformer.transform(element, out);
            fail("XMITransformException is expected.");
        } catch (XMITransformException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, PrintStream)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is false and the transformer() method of the
     * <code>MockDiagramInterchangeElementTransformer</code> class always throw a XMITransformException, expects no
     * XMITransformException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectPrintStreamXMITransformExceptionWithoutExceptions() throws Exception {
        Object element = new Object();
        MockDiagramInterchangeElementTransformer mockTransformer = new MockDiagramInterchangeElementTransformer();
        mockTransformer.setIsThrowXMITransformException(true);
        transformers.put(element.getClass().getName(), mockTransformer);
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(false);
        try {
            d2XMITransformer.transform(element, out);
            // good
        } catch (XMITransformException e) {
            fail("No XMITransformException is expected.");
        }
    }


    /**
     * <p>
     * Test method for 'transform(Object, Document)' for accuracy.
     * </p>
     *
     * <p>
     * Verify : transform(Object, Document) is correct.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectDocument() throws Exception {
        Object element = new Object();
        MockDiagramInterchangeElementTransformer mockTransformer = new MockDiagramInterchangeElementTransformer();
        transformers.put(element.getClass().getName(), mockTransformer);
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        // check whether the MockDiagramInterchangeElementTransformer#transform() method has been invoked.
        assertSame("The node is incorrect.",
                d2XMITransformer.transform(element, document), mockTransformer.getNode());
        assertSame("The element object is incorrect.", element, mockTransformer.getElement());
        assertSame("The document object is incorrect.", document, mockTransformer.getDocument());
    }


    /**
     * <p>
     * Test method for 'transform(Object, Document)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is true and object is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectDocumentWithNullObjectWithExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(true);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        try {
            d2XMITransformer.transform(null, document);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, Document)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is false and object is null and expects no IllegalArgumentException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectDocumentWithNullObjectWithoutExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(false);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        try {
            assertNull("The object returned should be null.", d2XMITransformer.transform(null, document));
            // good
        } catch (IllegalArgumentException e) {
            fail("No IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, Document)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is true and document is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectDocumentWithNullDocumentWithExceptions() throws Exception {
        Object element = new Object();
        MockDiagramInterchangeElementTransformer mockTransformer = new MockDiagramInterchangeElementTransformer();
        transformers.put(element.getClass().getName(), mockTransformer);
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(true);
        try {
            d2XMITransformer.transform(element, (Document) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, Document)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is true and document is null and expects no IllegalArgumentException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectDocumentWithNullDocumentWithoutExceptions() throws Exception {
        Object element = new Object();
        MockDiagramInterchangeElementTransformer mockTransformer = new MockDiagramInterchangeElementTransformer();
        transformers.put(element.getClass().getName(), mockTransformer);
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(false);
        try {
            assertNull("The object returned should be null.", d2XMITransformer.transform(element, (Document) null));
            // good
        } catch (IllegalArgumentException e) {
            fail("No IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, Document)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is true and the transformer() method of the
     * <code>MockDiagramInterchangeElementTransformer</code> class always throws a ClassCastException, expects
     * XMITransformException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectDocumentClassCastExceptionWithExceptions() throws Exception {
        Object element = new Object();
        MockDiagramInterchangeElementTransformer mockTransformer = new MockDiagramInterchangeElementTransformer();
        mockTransformer.setIsThrowClassCastException(true);
        transformers.put(element.getClass().getName(), mockTransformer);
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(true);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        try {
            d2XMITransformer.transform(element, document);
            fail("XMITransformException is expected.");
        } catch (XMITransformException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, Document)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is false and the transformer() method of the
     * <code>MockDiagramInterchangeElementTransformer</code> class always throws a ClassCastException, expects no
     * XMITransformException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectDocumentClassCastExceptionWithoutExceptions() throws Exception {
        Object element = new Object();
        MockDiagramInterchangeElementTransformer mockTransformer = new MockDiagramInterchangeElementTransformer();
        mockTransformer.setIsThrowClassCastException(true);
        transformers.put(element.getClass().getName(), mockTransformer);
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(false);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        try {
            assertNull("The object returned should be null.", d2XMITransformer.transform(element, document));
            // good
        } catch (XMITransformException e) {
            fail("No XMITransformException is expected.");
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, Document)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is true and the transformer() method of the
     * <code>MockDiagramInterchangeElementTransformer</code> class always throws a XMITransformException, expects
     * XMITransformException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectDocumentXMITransformExceptionWithExceptions() throws Exception {
        Object element = new Object();
        MockDiagramInterchangeElementTransformer mockTransformer = new MockDiagramInterchangeElementTransformer();
        mockTransformer.setIsThrowXMITransformException(true);
        transformers.put(element.getClass().getName(), mockTransformer);
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(true);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        try {
            d2XMITransformer.transform(element, document);
            fail("XMITransformException is expected.");
        } catch (XMITransformException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, Document)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is false and the transformer() method of the
     * <code>MockDiagramInterchangeElementTransformer</code> class always throw a XMITransformException, expects no
     * XMITransformException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectDocumentXMITransformExceptionWithoutExceptions() throws Exception {
        Object element = new Object();
        MockDiagramInterchangeElementTransformer mockTransformer = new MockDiagramInterchangeElementTransformer();
        mockTransformer.setIsThrowXMITransformException(true);
        transformers.put(element.getClass().getName(), mockTransformer);
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(false);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        try {
            assertNull("The object returned should be null.", d2XMITransformer.transform(element, document));
            // good
        } catch (XMITransformException e) {
            fail("No XMITransformException is expected.");
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, Document)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is true and a <code>DiagramInterchangeElementTransformer</code>
     * cannot be obtained for its class, expects UnknownElementException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectDocumentUnknowElementWithExceptions() throws Exception {
        Object element = new Object();
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(true);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        try {
            d2XMITransformer.transform(element, document);
            fail("UnknownElementException is expected.");
        } catch (UnknownElementException e) {
            // OK
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, Document)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the withExceptions is false and a <code>DiagramInterchangeElementTransformer</code>
     * cannot be obtained for its class, expects no UnknownElementException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformObjectDocumentUnknowElementWithoutExceptions() throws Exception {
        Object element = new Object();
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(false);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        try {
            assertNull("The object returned should be null.", d2XMITransformer.transform(element, document));
            // good
        } catch (UnknownElementException e) {
            fail("No UnknownElementException is expected.");
        }
    }

    /**
     * <p>
     * Test method for 'resolveID(Object)' for accuracy.
     * </p>
     *
     * <p>
     * Verify : resolveID(Object) returns the xmi.id value for the given object, possibly creating a new one
     * if no current ID is stored.
     * </p>
     * @throws Exception to Junit
     */
    public void testResolveID() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        // set the XMIWriter.
        Map<TransformerType, XMITransformer> xmiTransformers = new HashMap < TransformerType, XMITransformer >();
        xmiTransformers.put(TransformerType.Model,  new MockXMITransformer());
        xmiTransformers.put(TransformerType.ActivityGraph,  new MockXMITransformer());
        xmiTransformers.put(TransformerType.Diagram,  new MockXMITransformer());
        XMIWriter xmiWriter = new XMIWriter(new UMLModelManager(), xmiTransformers);
        d2XMITransformer.setXMIWriter(xmiWriter);
        Object obj = new Object();
        // return the xmi.id value for the given object
        String id = d2XMITransformer.resolveID(obj);
        assertNotNull("The xmi.id should not be null.", id);
        // check whether the object exists in the xmiWriter.
        assertSame("The xmi.id is incorrect.", id, xmiWriter.getElementId(obj));
        // check again
        assertSame("The xmi.id obtained again is incorrect.", id, d2XMITransformer.resolveID(obj));
    }

    /**
     * <p>
     * Test method for 'resolveID(Object)' for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object is null and withExceptions is false.
     * Expects IllegalArgumentException.
     * </p>
     * @throws Exception to Junit
     */
    public void testResolveIDWithNullObjWithException() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        // set the XMIWriter.
        Map<TransformerType, XMITransformer> xmiTransformers = new HashMap < TransformerType, XMITransformer >();
        xmiTransformers.put(TransformerType.Model,  new MockXMITransformer());
        xmiTransformers.put(TransformerType.ActivityGraph,  new MockXMITransformer());
        xmiTransformers.put(TransformerType.Diagram,  new MockXMITransformer());
        XMIWriter xmiWriter = new XMIWriter(new UMLModelManager(), xmiTransformers);
        d2XMITransformer.setXMIWriter(xmiWriter);
        d2XMITransformer.setWithExceptions(true);
        try {
            d2XMITransformer.resolveID(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'resolveID(Object)' for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object is null and withExceptions is false.
     * Expects no IllegalArgumentException.
     * </p>
     * @throws Exception to Junit
     */
    public void testResolveIDWithNullObjWithoutExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        // set the XMIWriter.
        Map<TransformerType, XMITransformer> xmiTransformers = new HashMap < TransformerType, XMITransformer >();
        xmiTransformers.put(TransformerType.Model,  new MockXMITransformer());
        xmiTransformers.put(TransformerType.ActivityGraph,  new MockXMITransformer());
        xmiTransformers.put(TransformerType.Diagram,  new MockXMITransformer());
        XMIWriter xmiWriter = new XMIWriter(new UMLModelManager(), xmiTransformers);
        d2XMITransformer.setXMIWriter(xmiWriter);
        d2XMITransformer.setWithExceptions(false);
        try {
            assertNull("The object returned should be null.", d2XMITransformer.resolveID(null));
            // good
        } catch (IllegalArgumentException e) {
            fail("No IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Test method for 'isWithExceptions()' for accuracy.
     * </p>
     *
     * <p>
     * Verify : isWithExceptions() is correct.
     * </p>
     * @throws Exception to Junit
     */
    public void testIsWithExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings,
                xmlTransformer, true);
        assertTrue("The withExceptions should be true.", d2XMITransformer.isWithExceptions());
        d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings, xmlTransformer, false);
        assertFalse("The withExceptions should be true.", d2XMITransformer.isWithExceptions());
    }

    /**
     * <p>
     * Test method for 'isWithExceptions()' for the default Diagram2XMITransformer(Map) instance.
     * </p>
     *
     * <p>
     * Verifies : isWithExceptions() of the default Diagram2XMITransformer(Map) instance returns true.
     * </p>
     * @throws Exception to Junit
     */
    public void testIsWithExceptionsWithDefaultCtor() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        assertTrue("The withExceptions should be true.", d2XMITransformer.isWithExceptions());
    }

    /**
     * <p>
     * Test method for 'setWithExceptions(boolean)'.
     * </p>
     *
     * <p>
     * Verify : setWithExceptions(boolean) is correct.
     * </p>
     * @throws Exception to Junit
     */
    public void testSetWithExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(true);
        assertTrue("The withExceptions should be true.", d2XMITransformer.isWithExceptions());
        d2XMITransformer.setWithExceptions(false);
        assertFalse("The withExceptions should be false.", d2XMITransformer.isWithExceptions());
    }

    /**
     * <p>
     * Test method for 'getXMLTransformer()'.
     * </p>
     *
     * <p>
     * Verify : getXMLTransformer() is correct.
     * </p>
     * @throws Exception to Junit
     */
    public void testGetXMLTransformer() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings,
                xmlTransformer, true);
        assertSame("The XMLTransformer is incorrect.", xmlTransformer, d2XMITransformer.getXMLTransformer());
    }

    /**
     * <p>
     * Test method for 'getXMLTransformer()' of the default Diagram2XMITransformer(Map) instance.
     * </p>
     *
     * <p>
     * Verify : getXMLTransformer() of the default Diagram2XMITransformer(Map) instance returns a Transformer
     * which is not null.
     * </p>
     * @throws Exception to Junit
     */
    public void testGetXMLTransformerWithDefaultCtor() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        assertNotNull("The XMLTransformer should not be null.", d2XMITransformer.getXMLTransformer());
    }

    /**
     * <p>
     * Test method for 'getElementTransformer(String)' for accuracy.
     * </p>
     *
     * <p>
     * Verify : getElementTransformers(String) is correct.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testGetElementTransformerWithString() throws Exception {
        // puts the samples (key,value)
        PropertyTransformer ptransformer = new PropertyTransformer();
        String key = "Key1";
        transformers.put(key, ptransformer);
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        assertSame("The Element Transformer is incorrect.", ptransformer, d2XMITransformer.getElementTransformer(key));
    }

    /**
     * <p>
     * Test method for 'getElementTransformer(String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case when the className is null and withExceptions is false
     * Expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testGetElementTransformerWithNullStringWithExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        try {
            d2XMITransformer.getElementTransformer(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'getElementTransformer(String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case when the className is empty and withExceptions is false
     * Expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testGetElementTransformerWithEmptyStringWithExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        try {
            d2XMITransformer.getElementTransformer("   ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'getElementTransformer(String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case when the className is null and withExceptions is false.
     * Expects no IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testGetElementTransformerWithNullStringWithoutExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(false);
        try {
            assertNull("The object returned should be null.", d2XMITransformer.getElementTransformer("  "));
            // good
        } catch (IllegalArgumentException e) {
            fail("No IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Test method for 'getElementTransformer(String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case when the className is empty and withExceptions is false.
     * Expects no IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testGetElementTransformerWitEmptyStringWithoutExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(false);
        try {
            assertNull("The object returned should be null.", d2XMITransformer.getElementTransformer(null));
            // good
        } catch (IllegalArgumentException e) {
            fail("No IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Test method for 'getElementTransformer(String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case when the className doesn't exist in the map and withExceptions is true.
     * Expects UnknownElementException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testGetElementTransformerWithNonexistsStringWithException() throws Exception {
        // puts the samples (key,value)
        transformers.put("key1", new PropertyTransformer());
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(true);
        try {
            d2XMITransformer.getElementTransformer("key2");
            fail("UnknownElementException is expected.");
        } catch (UnknownElementException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'getElementTransformer(String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case when the className doesn't exist in the map and withExceptions is false.
     * Expects No UnknownElementException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testGetElementTransformerWithNonexistsStringWithoutExceptions() throws Exception {
        // puts the samples (key,value)
        transformers.put("key1", new PropertyTransformer());
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(false);
        try {
            assertNull("The object returned should be null.", d2XMITransformer.getElementTransformer("key2"));
            // good
        } catch (UnknownElementException e) {
            fail("No UnknownElementException is expected.");
        }
    }

    /**
     * <p>
     * Test method for 'getElementTransformers()' for accuracy.
     * </p>
     *
     * <p>
     * Verify : getElementTransformers() should return a copy of transformers map.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testGetElementTransformers() throws Exception {
        // puts the samples (key,value)
        transformers.put("key1", new PropertyTransformer());
        transformers.put("key2", new PropertyTransformer());
        transformers.put("key3", new PropertyTransformer());

        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        Map < String, DiagramInterchangeElementTransformer > map = d2XMITransformer.getElementTransformers();
        // verifies whether the map is a copy of transformers map.
        assertSame("The Map should be the same as transformers map.", transformers, map);
    }

    /**
     * <p>
     * Test method for 'getTagName(String)' for accuracy.
     * </p>
     *
     * <p>
     * Verify : getTagNames(String) is correct.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testGetTagNameWithString() throws Exception {
        // puts the samples (key,value)
        String key = "Key1";
        tagNameMappings.put(key, "tagName");
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        assertSame("The Element Transformer is incorrect.", "tagName", d2XMITransformer.getTagName(key));
    }

    /**
     * <p>
     * Test method for 'getTagName(String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case when the className is null and withExceptions is false
     * Expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testGetTagNameWithNullStringWithExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        try {
            d2XMITransformer.getTagName(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'getTagName(String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case when the className is empty and withExceptions is false
     * Expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testGetTagNameWithEmptyStringWithExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        try {
            d2XMITransformer.getTagName("   ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'getTagName(String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case when the className is null and withExceptions is false.
     * Expects no IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testGetTagNameWithNullStringWithoutExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(false);
        try {
            assertNull("The object returned should be null.", d2XMITransformer.getTagName(null));
            // good
        } catch (IllegalArgumentException e) {
            fail("No IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Test method for 'getTagName(String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case when the className is empty and withExceptions is false.
     * Expects no IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testGetTagNameWithEmptyStringWithoutExceptions() throws Exception {
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(false);
        try {
            assertNull("The object returned should be null.", d2XMITransformer.getTagName(null));
            // good
        } catch (IllegalArgumentException e) {
            fail("No IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Test method for 'getTagName(String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case when the className doesn't exist in the map and withExceptions is true.
     * Expects UnknownElementException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testGetTagNameWithNonexistsStringWithException() throws Exception {
        // puts the samples (key,value)
        tagNameMappings.put("key1", "tagName");
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(true);
        try {
            d2XMITransformer.getTagName("key2");
            fail("UnknownElementException is expected.");
        } catch (UnknownElementException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'getTagName(String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case when the className doesn't exist in the map and withExceptions is false.
     * Expects No UnknownElementException.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testGetTagNameWithNonexistsStringWithoutExceptions() throws Exception {
        // puts the samples (key,value)
        tagNameMappings.put("key1", "tagName");
        Diagram2XMITransformer d2XMITransformer = new Diagram2XMITransformer(transformers, tagNameMappings);
        d2XMITransformer.setWithExceptions(false);
        try {
            assertNull("The object returned should be null.", d2XMITransformer.getTagName("key2"));
            // good
        } catch (UnknownElementException e) {
            fail("No UnknownElementException is expected.");
        }
    }

}
