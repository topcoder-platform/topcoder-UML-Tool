/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.failuretests;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.AbstractXMITransformer;
import com.topcoder.xmi.writer.ElementAlreadyExistsException;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.UnknownElementException;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Failure test for XMIWriter class.
 *
 * @author iamajia
 * @version 1.0
 */
public class XMIWriterFailureTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private Map<String, String> xmiRootAttributes = new HashMap<String, String>();
    /**
     * This instance is used in the test.
     */
    private Map<TransformerType, XMITransformer> transformers = new HashMap<TransformerType, XMITransformer>();
    /**
     * This instance is used in the test.
     */
    private UMLModelManager modelManager = new UMLModelManager();
    /**
     * This instance is used in the test.
     */
    private XMIWriter xmiWriter;
    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(XMIWriterFailureTest.class);
    }

    /**
     * Sets up the environment for the TestCase.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        transformers.put(TransformerType.ActivityGraph, new MockXMITransformer());
        transformers.put(TransformerType.Diagram, new MockXMITransformer());
        transformers.put(TransformerType.Model, new MockXMITransformer());
        xmiRootAttributes.put("xmlns:UML", "org.omg.xmi.namespace.UML");
        xmiRootAttributes.put("xmlns:UML2", "org.omg.xmi.namespace.UML2");
        xmiRootAttributes.put("xmi.version", "1.5");
        xmiWriter = new XMIWriter(modelManager, transformers);
    }

    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager,
     * Map&lt;TransformerType, XMITransformer&gt; transformers)</code> constructor.
     *
     * <p>
     * manager is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter1FailureNullManager() throws Exception {
        try {
            new XMIWriter(null, transformers);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager,
     * Map&lt;TransformerType, XMITransformer&gt; transformers)</code> constructor.
     *
     * <p>
     * transformers is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter1FailureNullTransformers() throws Exception {
        try {
            new XMIWriter(modelManager, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager,
     * Map&lt;TransformerType, XMITransformer&gt; transformers)</code> constructor.
     * <p>
     * transformers does not contain activity graph transformer.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter1FailureNoActivityGraphTransformer() throws Exception {
        transformers.remove(TransformerType.ActivityGraph);
        try {
            new XMIWriter(modelManager, transformers);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager,
     * Map&lt;TransformerType, XMITransformer&gt; transformers)</code> constructor.
     * <p>
     * transformers does not contain model transformer.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter1FailureNoModelTransformer() throws Exception {
        transformers.remove(TransformerType.Model);
        try {
            new XMIWriter(modelManager, transformers);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager,
     * Map&lt;TransformerType, XMITransformer&gt; transformers)</code> constructor.
     * <p>
     * transformers does not contain diagram transformer.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter1FailureNoDiagramTransformer() throws Exception {
        transformers.remove(TransformerType.Diagram);
        try {
            new XMIWriter(modelManager, transformers);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager,
     * Map&lt;TransformerType, XMITransformer&gt; transformers)</code> constructor.
     * <p>
     * diagram transformer is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter1FailureNullDiagramTransformer() throws Exception {
        transformers.put(TransformerType.Diagram, null);
        try {
            new XMIWriter(modelManager, transformers);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager,
     * Map&lt;TransformerType, XMITransformer&gt; transformers)</code> constructor.
     * <p>
     * activity graph transformer is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter1FailureNullActivityGraphTransformer() throws Exception {
        transformers.put(TransformerType.ActivityGraph, null);
        try {
            new XMIWriter(modelManager, transformers);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager,
     * Map&lt;TransformerType, XMITransformer&gt; transformers)</code> constructor.
     * <p>
     * model transformer is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter1FailureNullModelTransformer() throws Exception {
        transformers.put(TransformerType.Model, null);
        try {
            new XMIWriter(modelManager, transformers);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager,
     * Map&lt;TransformerType, XMITransformer&gt; transformers)</code> constructor.
     * <p>
     * header transformer is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter1FailureNullHeaderTransformer() throws Exception {
        transformers.put(TransformerType.Header, null);
        try {
            new XMIWriter(modelManager, transformers);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager, Map&lt;TransformerType,XMITransformer&gt; transformers,
     * Map&lt;String, String&gt; xmiRootAttributes)</code> constructor.
     *
     * <p>
     * manager is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter2FailureNullManager() throws Exception {
        try {
            new XMIWriter(null, transformers, xmiRootAttributes);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager, Map&lt;TransformerType,XMITransformer&gt; transformers,
     * Map&lt;String, String&gt; xmiRootAttributes)</code> constructor.
     *
     * <p>
     * transformers is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter2FailureNullTransformers() throws Exception {
        try {
            new XMIWriter(modelManager, null, xmiRootAttributes);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager, Map&lt;TransformerType,XMITransformer&gt; transformers,
     * Map&lt;String, String&gt; xmiRootAttributes)</code> constructor.
     *
     * <p>
     * transformers does not contain activity graph transformer.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter2FailureNoActivityGraphTransformer() throws Exception {
        transformers.remove(TransformerType.ActivityGraph);
        try {
            new XMIWriter(modelManager, transformers, xmiRootAttributes);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager, Map&lt;TransformerType,XMITransformer&gt; transformers,
     * Map&lt;String, String&gt; xmiRootAttributes)</code> constructor.
     *
     * <p>
     * transformers does not contain model transformer.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter2FailureNoModelTransformer() throws Exception {
        transformers.remove(TransformerType.Model);
        try {
            new XMIWriter(modelManager, transformers, xmiRootAttributes);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager, Map&lt;TransformerType,XMITransformer&gt; transformers,
     * Map&lt;String, String&gt; xmiRootAttributes)</code> constructor.
     *
     * <p>
     * transformers does not contain diagram transformer.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter2FailureNoDiagramTransformer() throws Exception {
        transformers.remove(TransformerType.Diagram);
        try {
            new XMIWriter(modelManager, transformers, xmiRootAttributes);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager, Map&lt;TransformerType,XMITransformer&gt; transformers,
     * Map&lt;String, String&gt; xmiRootAttributes)</code> constructor.
     *
     * <p>
     * diagram transformer is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter2FailureNullDiagramTransformer() throws Exception {
        transformers.put(TransformerType.Diagram, null);
        try {
            new XMIWriter(modelManager, transformers, xmiRootAttributes);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager, Map&lt;TransformerType,XMITransformer&gt; transformers,
     * Map&lt;String, String&gt; xmiRootAttributes)</code> constructor.
     *
     * <p>
     * activity graph transformer is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter2FailureNullActivityGraphTransformer() throws Exception {
        transformers.put(TransformerType.ActivityGraph, null);
        try {
            new XMIWriter(modelManager, transformers, xmiRootAttributes);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager, Map&lt;TransformerType,XMITransformer&gt; transformers,
     * Map&lt;String, String&gt; xmiRootAttributes)</code> constructor.
     *
     * <p>
     * model transformer is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter2FailureNullModelTransformer() throws Exception {
        transformers.put(TransformerType.Model, null);
        try {
            new XMIWriter(modelManager, transformers, xmiRootAttributes);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager, Map&lt;TransformerType,XMITransformer&gt; transformers,
     * Map&lt;String, String&gt; xmiRootAttributes)</code> constructor.
     *
     * <p>
     * header transformer is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter2FailureNullHeaderTransformer() throws Exception {
        transformers.put(TransformerType.Header, null);
        try {
            new XMIWriter(modelManager, transformers, xmiRootAttributes);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager, Map&lt;TransformerType,XMITransformer&gt; transformers,
     * Map&lt;String, String&gt; xmiRootAttributes)</code> constructor.
     *
     * <p>
     * xmiRootAttributes is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter2FailureNullXMIRootAttributes() throws Exception {
        try {
            new XMIWriter(modelManager, transformers, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager, Map&lt;TransformerType,XMITransformer&gt; transformers,
     * Map&lt;String, String&gt; xmiRootAttributes)</code> constructor.
     *
     * <p>
     * xmiRootAttributes contains null key.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter2FailureXMIRootAttributesContainsNullKey() throws Exception {
        xmiRootAttributes.put(null, "test");
        try {
            new XMIWriter(modelManager, transformers, xmiRootAttributes);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager, Map&lt;TransformerType,XMITransformer&gt; transformers,
     * Map&lt;String, String&gt; xmiRootAttributes)</code> constructor.
     *
     * <p>
     * xmiRootAttributes contains empty key.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter2FailureXMIRootAttributesContainsEmptyKey() throws Exception {
        xmiRootAttributes.put("  ", "test");
        try {
            new XMIWriter(modelManager, transformers, xmiRootAttributes);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager, Map&lt;TransformerType,XMITransformer&gt; transformers,
     * Map&lt;String, String&gt; xmiRootAttributes)</code> constructor.
     *
     * <p>
     * xmiRootAttributes contains null value.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter2FailureXMIRootAttributesContainsNullValue() throws Exception {
        xmiRootAttributes.put("test", null);
        try {
            new XMIWriter(modelManager, transformers, xmiRootAttributes);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>XMIWriter(UMLModelManager manager, Map&lt;TransformerType,XMITransformer&gt; transformers,
     * Map&lt;String, String&gt; xmiRootAttributes)</code> constructor.
     *
     * <p>
     * xmiRootAttributes contains empty value.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIWriter2FailureXMIRootAttributesContainsEmptyValue() throws Exception {
        xmiRootAttributes.put("test", "   ");
        try {
            new XMIWriter(modelManager, transformers, xmiRootAttributes);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>getElementId(Object element)</code> method.
     *
     * <p>
     * element is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetElementIdFailureNullElement() throws Exception {
        try {
            xmiWriter.getElementId(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>getElementId(Object element)</code> method.
     *
     * <p>
     * element is unknown.
     * </p>
     *
     * <p>
     * Expect UnknownElementException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetElementIdFailureUnknownElement() throws Exception {
        try {
            xmiWriter.getElementId(new Object());
            fail("Expect IllegalArgumentException.");
        } catch (UnknownElementException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>putElementId(Object element, String xmiId)</code> method.
     *
     * <p>
     * element is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testPutElementIdFailureNullElement() throws Exception {
        try {
            xmiWriter.putElementId(null, "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>putElementId(Object element, String xmiId)</code> method.
     *
     * <p>
     * xmiId is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testPutElementIdFailureNullXMIId() throws Exception {
        try {
            xmiWriter.putElementId(new Object(), null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>putElementId(Object element, String xmiId)</code> method.
     *
     * <p>
     * xmiId is empty.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testPutElementIdFailureEmptyXMIId() throws Exception {
        try {
            xmiWriter.putElementId(new Object(), "   ");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>putElementId(Object element, String xmiId)</code> method.
     *
     * <p>
     * element already exists.
     * </p>
     *
     * <p>
     * Expect ElementAlreadyExistsException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testPutElementIdFailureElementAlreadyExists() throws Exception {
        Object element = new Object();
        xmiWriter.putElementId(element, "test");
        try {
            xmiWriter.putElementId(element, "test");
            fail("Expect ElementAlreadyExistsException.");
        } catch (ElementAlreadyExistsException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>putXMIRootAttribute(String attrKey, String attrValue)</code> method.
     *
     * <p>
     * attrKey is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testPutXMIRootAttributeFailureNullAttrKey() throws Exception {
        try {
            xmiWriter.putXMIRootAttribute(null, "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>putXMIRootAttribute(String attrKey, String attrValue)</code> method.
     *
     * <p>
     * attrKey is empty.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testPutXMIRootAttributeFailureEmptyAttrKey() throws Exception {
        try {
            xmiWriter.putXMIRootAttribute("  ", "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>putXMIRootAttribute(String attrKey, String attrValue)</code> method.
     *
     * <p>
     * attrValue is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testPutXMIRootAttributeFailureNullAttrValue() throws Exception {
        try {
            xmiWriter.putXMIRootAttribute("test", null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>putXMIRootAttribute(String attrKey, String attrValue)</code> method.
     *
     * <p>
     * attrValue is empty.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testPutXMIRootAttributeFailureEmptyAttrValue() throws Exception {
        try {
            xmiWriter.putXMIRootAttribute("test", "   ");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>getXMIRootAttribute(String attrKey)</code> method.
     *
     * <p>
     * attrKey is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetXMIRootAttributeFailureNullAttrKey() throws Exception {
        try {
            xmiWriter.getXMIRootAttribute(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>getXMIRootAttribute(String attrKey)</code> method.
     *
     * <p>
     * attrKey is empty.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetXMIRootAttributeFailureEmptyAttrKey() throws Exception {
        try {
            xmiWriter.getXMIRootAttribute("   ");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeXMIRootAttribute(String attrKey)</code> method.
     *
     * <p>
     * attrKey is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveXMIRootAttributeFailureNullAttrKey() throws Exception {
        try {
            xmiWriter.removeXMIRootAttribute(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeXMIRootAttribute(String attrKey)</code> method.
     *
     * <p>
     * attrKey is empty.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveXMIRootAttributeFailureEmptyAttrKey() throws Exception {
        try {
            xmiWriter.removeXMIRootAttribute("   ");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>transform(File outputFile, boolean withDiagramData)</code> method.
     *
     * <p>
     * outputFile is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testTransformFailureNullOutputFile() throws Exception {
        try {
            xmiWriter.transform((File) null, true);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>transform(OutputStream outputStream, boolean withDiagramData)</code> method.
     *
     * <p>
     * outputStream is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testTransformFailureNullOutputStream() throws Exception {
        try {
            xmiWriter.transform((OutputStream) null, true);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>transformToZipFile(File zipFile, boolean withDiagramData)</code> method.
     *
     * <p>
     * zipFile is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testTransformToZipFileFailureNullZipFile() throws Exception {
        try {
            xmiWriter.transformToZipFile(null, true);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * This mock class is used in the test.
     *
     * @author iamajia
     * @version 1.0
     */
    private class MockXMITransformer extends AbstractXMITransformer {
        /**
         * <p>
         * Do nothing.
         * </p>
         *
         * @param element
         *            the element to transform.
         * @param out
         *            the PrintStream object to write the transformation data.
         */
        public void transform(Object element, PrintStream out) {
            // do nothing.
        }
    }
}
