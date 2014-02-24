/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.failuretests;

import java.io.PrintStream;
import java.util.Map;

import javax.xml.transform.Transformer;

import org.w3c.dom.Document;

import com.topcoder.diagraminterchange.Property;
import com.topcoder.xmi.writer.UnknownElementException;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PropertyTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.ReferenceTransformer;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test cases for class Diagram2XMITransformer. Tests the exceptions in invalid condition.
 * </p>
 *
 * @author magicpig
 * @version 1.0
 */
public class Diagram2XMITransformerFailureTests extends TestCase {
    /**
     * Document for testing.
     */
    private Document document;

    /**
     * Transformer map for testing.
     */
    private Map<String, DiagramInterchangeElementTransformer> transformerMap;

    /**
     * Tag name map for testing.
     */
    private Map<String, String> tagNameMappings;

    /**
     * Transformer instance for testing.
     */
    private Transformer xmlTransformer;

    /**
     * Diagram2XMITransformer instance for testing.
     */
    private Diagram2XMITransformer instance;

    /**
     * <p>
     * Sets up testing environment.
     * </p>
     *
     * @exception when
     *                error occurs
     */
    protected void setUp() throws Exception {
        transformerMap = FailureHelper.createTransformersMap();
        tagNameMappings = FailureHelper.createTagNameMap();
        xmlTransformer = FailureHelper.createTransformer();
        instance = new Diagram2XMITransformer(transformerMap, tagNameMappings);
        document = FailureHelper.createDocument();
    }

    /**
     * <p>
     * Failure test for constructor Diagram2XMITransformer(Map,Map). <br>
     * Failure condition: null transformers.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testCtor1WithNullTransformers() throws Exception {
        try {
            new Diagram2XMITransformer(null, tagNameMappings);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for constructor Diagram2XMITransformer(Map,Map). <br>
     * Failure condition: transformers contain null key.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testCtor1WithTransformersNullKey() throws Exception {
        transformerMap.put(null, new PropertyTransformer());
        try {
            new Diagram2XMITransformer(transformerMap, tagNameMappings);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for constructor Diagram2XMITransformer(Map,Map). <br>
     * Failure condition: transformers contain null value.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testCtor1WithTransformersNullValue() throws Exception {
        transformerMap.put("failure", null);
        try {
            new Diagram2XMITransformer(transformerMap, tagNameMappings);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for constructor Diagram2XMITransformer(Map,Map). <br>
     * Failure condition: null tagNameMappings.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testCtor1WithNulltagNameMappings() throws Exception {
        try {
            new Diagram2XMITransformer(transformerMap, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for constructor Diagram2XMITransformer(Map,Map). <br>
     * Failure condition: tagNameMappings contain null key.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testCtor1WithTagNameMappingsNullKey() throws Exception {
        tagNameMappings.put(null, "failure");
        try {
            new Diagram2XMITransformer(transformerMap, tagNameMappings);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for constructor Diagram2XMITransformer(Map,Map). <br>
     * Failure condition: tagNameMappings contain null value.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testCtor1WithTagNameMappingsNullValue() throws Exception {
        tagNameMappings.put("failure", null);
        try {
            new Diagram2XMITransformer(transformerMap, tagNameMappings);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for constructor Diagram2XMITransformer(Map,Map,Transformer,boolean). <br>
     * Failure condition: null transformers.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testCtor2WithNullTransformers() throws Exception {
        try {
            new Diagram2XMITransformer(null, tagNameMappings, xmlTransformer, true);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for constructor Diagram2XMITransformer(Map,Map,Transformer,boolean). <br>
     * Failure condition: transformers contain null key.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testCtor2WithTransformersNullKey() throws Exception {
        transformerMap.put(null, new PropertyTransformer());
        try {
            new Diagram2XMITransformer(transformerMap, tagNameMappings, xmlTransformer, true);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for constructor Diagram2XMITransformer(Map,Map,Transformer,boolean). <br>
     * Failure condition: transformers contain null value.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testCtor2WithTransformersNullValue() throws Exception {
        transformerMap.put("failure", null);
        try {
            new Diagram2XMITransformer(transformerMap, tagNameMappings, xmlTransformer, true);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for constructor Diagram2XMITransformer(Map,Map,Transformer,boolean). <br>
     * Failure condition: null tagNameMappings.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testCtor2WithNulltagNameMappings() throws Exception {
        try {
            new Diagram2XMITransformer(transformerMap, null, xmlTransformer, true);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for constructor Diagram2XMITransformer(Map,Map,Transformer,boolean). <br>
     * Failure condition: tagNameMappings contain null key.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testCtor2WithTagNameMappingsNullKey() throws Exception {
        tagNameMappings.put(null, "failure");
        try {
            new Diagram2XMITransformer(transformerMap, tagNameMappings, xmlTransformer, true);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for constructor Diagram2XMITransformer(Map,Map,Transformer,boolean). <br>
     * Failure condition: tagNameMappings contain null value.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testCtor2WithTagNameMappingsNullValue() throws Exception {
        tagNameMappings.put("failure", null);
        try {
            new Diagram2XMITransformer(transformerMap, tagNameMappings, xmlTransformer, true);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for constructor Diagram2XMITransformer(Map,Map,Transformer,boolean). <br>
     * Failure condition: null xmlTransformer.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testCtor2WithNullXmlTransformer() throws Exception {
        try {
            new Diagram2XMITransformer(transformerMap, tagNameMappings, null, true);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method transform(Object,PrintStream). <br>
     * Failure condition: null element.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testTransform1WithNullElement() throws Exception {
        try {
            instance.transform(null, System.out);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method transform(Object,PrintStream). <br>
     * Failure condition: null out.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testTransform1WithNullOut() throws Exception {
        try {
            instance.transform(new Property(), (PrintStream)null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method transform(Object,PrintStream). <br>
     * Failure condition: no suitable transformer.<br>
     * Expected result: UnknownElementException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testTransform1WithoutCorrectTransformer() throws Exception {
        try {
            instance.transform(new Property(), System.out);
            fail("UnknownElementException is expected.");
        } catch (UnknownElementException unee) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method transform(Object,PrintStream). <br>
     * Failure condition: invalid transformer.<br>
     * Expected result: XMITransformException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testTransform1WithInvalidTransformer() throws Exception {
        transformerMap.put(Property.class.getName(), new ReferenceTransformer());
        try {
            instance.transform(new Property(), System.out);
            fail("XMITransformException is expected.");
        } catch (XMITransformException xmite) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method transform(Object,PrintStream). <br>
     * Failure condition: null element.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testTransform2WithNullElement() throws Exception {
        try {
            instance.transform(null, document);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method transform(Object,PrintStream). <br>
     * Failure condition: null document.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testTransform2WithNullDocument() throws Exception {
        try {
            instance.transform(new Property(), (Document)null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method transform(Object,PrintStream). <br>
     * Failure condition: no suitable transformer.<br>
     * Expected result: UnknownElementException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testTransform2WithoutCorrectTransformer() throws Exception {
        try {
            instance.transform(new Property(), document);
            fail("UnknownElementException is expected.");
        } catch (UnknownElementException unee) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method transform(Object,PrintStream). <br>
     * Failure condition: invalid transformer.<br>
     * Expected result: XMITransformException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testTransform2WithInvalidTransformer() throws Exception {
        transformerMap.put(Property.class.getName(), new ReferenceTransformer());
        try {
            instance.transform(new Property(), document);
            fail("XMITransformException is expected.");
        } catch (XMITransformException xmite) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method resolveID. <br>
     * Failure condition: null element.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testResolveIDWithNullElement() throws Exception {
        try {
            instance.resolveID(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method resolveID. <br>
     * Failure condition: xmiWriter not set.<br>
     * Expected result: XMITransformException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testResolveIDWithWriterNotSet() throws Exception {
        try {
            instance.resolveID(new Object());
            fail("XMITransformException is expected.");
        } catch (XMITransformException xmite) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method getElementTransformer. <br>
     * Failure condition: null className.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testGetElementTransformerWithNullClassName() throws Exception {
        try {
            instance.getElementTransformer(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method getElementTransformer. <br>
     * Failure condition: no transformer for the className.<br>
     * Expected result: UnknownElementException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testGetElementTransformerWithNoTransformerForTheClassName() throws Exception {
        try {
            instance.getElementTransformer("failure");
            fail("UnknownElementException is expected.");
        } catch (UnknownElementException uee) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method getTagName. <br>
     * Failure condition: null className.<br>
     * Expected result: IllegalArgumentException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testGetTagNameWithNullClassName() throws Exception {
        try {
            instance.getTagName(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method getTagName. <br>
     * Failure condition: no name for the className.<br>
     * Expected result: UnknownElementException. <br>
     * </p>
     *
     * @exception when
     *                error occurs
     */
    public void testGetTagNameWithNoTransformerForTheClassName() throws Exception {
        try {
            instance.getTagName("failure");
            fail("UnknownElementException is expected.");
        } catch (UnknownElementException uee) {
            // pass
        }
    }
}
