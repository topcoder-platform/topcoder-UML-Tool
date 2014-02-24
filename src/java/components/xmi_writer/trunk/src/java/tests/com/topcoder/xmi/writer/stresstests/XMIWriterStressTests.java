/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.stresstests;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.stresstests.MockXMITransformer;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.xmiheader.XMIHeaderTransformer;

import junit.framework.TestCase;

/**
 * <p> Stress tests for <code>XMIWriter</code>. </p>
 *
 * @author yinzi
 * @version 1.0
 */
public class XMIWriterStressTests extends TestCase {
    /** The number of operations in the stress tests. */
    private static final int TIMES = 1000;

    /** Represents the <code>XMIWriter</code> instance used for testing. */
    private XMIWriter xmiWriter;

    /**
     * <p> Represents the output file name. </p>
     */
    private String outputFileString = "test_files/stresstests/test.xmi";

    /**
     * <p> Represents the zip file name. </p>
     */
    private String zipFileString = "test_files/stresstests/testzip.zuml";

    /**
     * <p> Set up the test environment. </p>
     */
    protected void setUp() {
        xmiWriter = new XMIWriter(createUMLModelManager(), createTransformers());
    }

    /**
     * <p> Stress test of constructor <code>XMIWriter(UMLModelManager, Map)</code>. </p>
     */
    public void testConstructor1() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < TIMES; i++) {
            xmiWriter = new XMIWriter(createUMLModelManager(), createTransformers());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "XMIWriter(UMLModelManager, Map) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");

        assertNotNull("should create the instance successfully.", xmiWriter);
    }

    /**
     * <p> Stress test of constructor <code>XMIWriter(UMLModelManager, Map, Map)</code>. </p>
     */
    public void testConstructor2() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < TIMES; i++) {
            xmiWriter = new XMIWriter(createUMLModelManager(), createTransformers(), createXMIRootAttributes());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "XMIWriter(UMLModelManager, Map, Map) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");

        assertNotNull("should create the instance successfully.", xmiWriter);
    }

    /**
     * <p> Stress test of methods <code>putElementId(Object, String)</code> and <code>getElementId(Object)</code>. </p>
     *
     * @throws Exception to JUnit
     */
    public void testElementIdPutAndGet() throws Exception {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < TIMES; i++) {
            Object element = new Object();
            String xmiId = "some xmi id";
            xmiWriter.putElementId(element, xmiId);
            assertEquals("should get the proper value.", xmiId, xmiWriter.getElementId(element));
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "putElementId(Object, String) and getElementId(Object) in "
                + TIMES + " times takes " + (endTime - startTime) + "ms");
    }

    /**
     * <p> Stress test of methods <code>getXMIRootAttribute(String)</code>,
     * <code>getXMIRootAttributeKeys()</code>, <code>putXMIRootAttribute(String, String)</code>,
     * <code>removeXMIRootAttribute(String)</code> and <code>clearXMIRootAttributes()</code>. </p>
     */
    public void testXMIRootAttributeMapOperations() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < TIMES; i++) {
            // Create the xmiWriter
            xmiWriter = new XMIWriter(createUMLModelManager(), createTransformers());

            //get all the keys
            String[] keys = xmiWriter.getXMIRootAttributeKeys();
            assertEquals("the length of keys array is 3.", 3, keys.length);
            assertEquals("should get the proper keys.", "xmlns:UML2",  keys[0]);
            assertEquals("should get the proper keys.", "xmlns:UML",   keys[1]);
            assertEquals("should get the proper keys.", "xmi.version", keys[2]);

            //put a custom attribute
            xmiWriter.putXMIRootAttribute("some custom key", "some custom value");
            assertEquals("some custom value", xmiWriter.getXMIRootAttribute("some custom key"));

            //remove the custom attribute
            xmiWriter.removeXMIRootAttribute("some custom key");
            assertNull(xmiWriter.getXMIRootAttribute("some custom key"));

            //clear the XMI Root Attributes
            xmiWriter.clearXMIRootAttributes();
            assertNull(xmiWriter.getXMIRootAttribute("xmlns:UML"));
            assertNull(xmiWriter.getXMIRootAttribute("xmlns:UML2"));
            assertNull(xmiWriter.getXMIRootAttribute("xmi.version"));
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "getXMIRootAttribute(String), getXMIRootAttributeKeys(), "
                + "putXMIRootAttribute(String, String), removeXMIRootAttribute(String) and clearXMIRootAttributes() "
                + "in " + TIMES + " times takes " + (endTime - startTime) + "ms");
    }


    /**
     * <p> Stress test of method <code>transform(File, boolean)</code>. </p>
     *
     * @throws Exception to JUnit
     */
    public void testTransformToFile() throws Exception {
        File outputFile = new File(outputFileString);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            //transform the data to a File
            xmiWriter.transform(outputFile, true);
            //verify the result
            assertTrue("Should create the file to disk.", outputFile.exists());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "transform(File, boolean) "
                + "in " + TIMES + " times takes " + (endTime - startTime) + "ms");
        outputFile.delete();
    }

    /**
     * <p> Stress test of method <code>transform(OutputStream, boolean)</code>. </p>
     *
     * @throws Exception to JUnit
     */
    public void testTransformToOutputStream() throws Exception {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        try {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < TIMES; i++) {
                //transform the data into the ByteArrayOutputStream
                xmiWriter.transform(stream, true);
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Stress tests: " + "transform(OutputStream, boolean) "
                    + "in " + TIMES + " times takes " + (endTime - startTime) + "ms");
        } finally {
            stream.close();
        }
    }

    /**
     * <p> Stress test of method <code>transformToZipFile(File, boolean)</code>. </p>
     *
     * @throws Exception to JUnit
     */
    public void testTransformToZipFile() throws Exception {
        //transform the data to a File
        File zipFile = new File(zipFileString);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            xmiWriter.transformToZipFile(zipFile, true);
            //verify the result
            assertTrue("Should create the file to disk.", zipFile.exists());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "transformToZipFile(File, boolean) "
                + "in " + TIMES + " times takes " + (endTime - startTime) + "ms");

        zipFile.delete();
    }

    /**
     * <p> Return the <code>UMLModelManager</code> instance. </p>
     *
     * @return the <tt>UMLModelManager</tt> instance
     */
    private static UMLModelManager createUMLModelManager() {
        UMLModelManager modelManager = new UMLModelManager();
        modelManager.addActivityGraph(new ActivityGraphImpl());
        modelManager.addDiagram(new Diagram());
        return modelManager;
    }

    /**
     * <p> Return the transformers map. </p>
     *
     * @return the transformers map
     */
    private static Map<TransformerType, XMITransformer> createTransformers() {
        Map<TransformerType, XMITransformer> transformers = new HashMap<TransformerType, XMITransformer>();

        transformers.put(TransformerType.Model, new MockXMITransformer("model content"));
        transformers.put(TransformerType.Diagram, new MockXMITransformer("activity graph content"));
        transformers.put(TransformerType.ActivityGraph, new MockXMITransformer("diagram content"));
        transformers.put(TransformerType.Header, new XMIHeaderTransformer("TCUML", "1.0", "1.2"));

        return transformers;
    }


    /**
     * <p> Return the custom XMI Root Attributes map used for testing. </p>
     *
     * @return the custom XMI Root Attributes map instance
     */
    private static Map<String, String> createXMIRootAttributes() {
        Map<String, String> attributes = new HashMap<String, String>();

        attributes.put("xmlns:UML", "org.omg.xmi.namespace.UML");
        attributes.put("xmlns:UML2", "org.omg.xmi.namespace.UML2");
        attributes.put("xmi.version", "1.5");

        return attributes;
    }
}
