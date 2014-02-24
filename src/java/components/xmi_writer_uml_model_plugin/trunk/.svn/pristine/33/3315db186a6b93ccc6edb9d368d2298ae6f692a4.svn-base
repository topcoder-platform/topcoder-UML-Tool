/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model.accuracytests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;


import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.xmi.writer.transformers.model.accuracytests.MockModelElement;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.model.Model2XMITransformer;
import com.topcoder.xmi.writer.transformers.model.XMIDescription;
import com.topcoder.xmi.writer.transformers.model.xmidescription.ReflectedXMIDescription;


import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>Model2XMITransformer</c>.
 * </p>
 * 
 * @author catcher
 * @version 1.0
 */
public class Model2XMITransformerAccuracyTests extends TestCase {

    /**
     * <p>
     * The path of config file used for test.
     * </p>
     */
    private static final String CONFIG = "accuracy/sample_config.xml";

    /**
     * Represents the configuration namespace.
     */
    private static final String NAMESPACE = "com.topcoder.xmi.writer.transformers.model";

    /**
     * Represent the instance of <c>Model2XMITransformer</c> used for test
     */
    private Model2XMITransformer transformer;

    /**
     * Represent the instance of <c>XMIDescription</c> used for test
     */
    private XMIDescription description;
    
    /**
     * XMIWriter instance used for test.
     *
     */
    private XMIWriter writer;
    
    /**
     * Represents the UMLModelManager instance used to create XMIWriter object.
     */
    private UMLModelManager manager;

    /**
     * <p>
     * Set up test environment.
     * </p>
     * 
     * @throws Exception
     *         if any error occurs when set up
     */
    protected void setUp() throws Exception {
        TestsHelper.removeAllCMNamespaces();
        ConfigManager.getInstance().add(CONFIG);
        ConfigManager.getInstance().add("accuracy/SingleDescription.xml");
        description = new ReflectedXMIDescription(
                        "com.topcoder.xmi.writer.transformers.model.ReflectedXMIDescription");

        transformer = new Model2XMITransformer(NAMESPACE);
        Map<TransformerType, XMITransformer> transformers = new HashMap<TransformerType, XMITransformer>();
        transformers.put(TransformerType.Model, transformer);
        transformers.put(TransformerType.ActivityGraph, new MockTransformer("ActivityGraph"));
        transformers.put(TransformerType.Diagram, new MockTransformer("Diagram"));
        manager=new UMLModelManager();
        writer = new XMIWriter(manager, transformers);
    }

    /**
     * <p>
     * Tear down test environment.
     * </p>
     * 
     * @throws Exception
     *         if any error occurs when tear down
     */
    protected void tearDown() throws Exception {
        TestsHelper.removeAllCMNamespaces();
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>Model2XMITransformer(XMIDescription,boolean)</code>. The instance of
     * <code>Model2XMITransformer</code> should be created successfully.
     * </p>
     * 
     * @throws Exception
     *         to JUnit
     */
    public void testConstructorAccuracy() throws Exception {

        Model2XMITransformer transformer = new Model2XMITransformer(description, true);
        assertNotNull("Model2XMITransformer creation failed", transformer);
        // assert the variable initialization
        assertEquals("Model2XMITransformer creation failed", transformer.getXMIDescription(), description);
        assertEquals("Model2XMITransformer creation failed", transformer.isIgnoreUnknownElementType(), true);
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>Model2XMITransformer(String)</code>. The instance of
     * <code>Model2XMITransformer</code> should be created successfully.
     * </p>
     * 
     * @throws Exception
     *         to JUnit
     */
    public void testConstructorAccuracy2() throws Exception {
        transformer = new Model2XMITransformer(NAMESPACE);

        assertNotNull("Model2XMITransformer creation failed", transformer);

        assertEquals("Model2XMITransformer creation failed", transformer.isIgnoreUnknownElementType(), true);
    }

    /**
     * <p>
     * Accuracy test for the method <code>setisIgnoreUnknownElementType</code>, the <c>IgnoreUnknownElementType</c>
     * field should be set correctly.
     * </p>
     */
    public void testIgnoreUnknownElementTypeAccuracy() {
        try {
            transformer.setIgnoreUnknownElementType(false);
            assertEquals("The IgnoreUnknownElementType field should be set correctly", false, transformer
                            .isIgnoreUnknownElementType());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>getXMIDescription()</code> The XMIDescription should be returned.
     * </p>
     */
    public void testGetXMIDescriptionAccuracy() {
        try {
            Model2XMITransformer transformer = new Model2XMITransformer(description, true);
            assertEquals("the XMIDescription should be returned", description, transformer.getXMIDescription());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>transform(Object,PrintStream)</code>
     * </p>
     * 
     * @throws Exception
     *         to JUnit
     */
    public void testtransformAccuracy() throws Exception {

        // create the PrintStream
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        transformer.transform(TestsHelper.createSimpleModelInstance(), printStream);
        
        String result=stream.toString();
        System.out.println(result);
        StringBuilder buffer=new StringBuilder(result);
        assertTrue(buffer.indexOf("isSpecification='false'") >= 0);
        assertTrue(buffer.indexOf("<UML:Namespace.ownedElement>") >= 0);
        assertTrue(buffer.indexOf("isRoot='false'") >= 0);
        assertTrue(buffer.indexOf("accuracyModel") >= 0);
        assertTrue(buffer.indexOf("<UML:ModelElement.name>") >= 0);
    }
    
    /**
     * <p>
     * Accuracy test for the method <code>transform(Object,PrintStream)</code>
     * </p>
     * 
     * @throws Exception
     *         to JUnit
     */
    public void testtransformAccuracy2() throws Exception {

        // create the PrintStream
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        MockModelElement granddad=new MockModelElement();
        granddad.setBody("granddad");
        
        MockModelElement father=new MockModelElement();
        father.setBody("father");
        granddad.addChild(father);
        father.setFather(granddad);
        
        MockModelElement son=new MockModelElement();
        father.addChild(son);
        son.setBody("son");
        son.setFather(father);
        
        MockModelElement daughter=new MockModelElement();
        father.addChild(daughter);
        daughter.setBody("daughter");
        daughter.setFather(father);
        
        transformer.transform(granddad, printStream);
        
        String result=stream.toString();
        System.out.println(result);
        
        StringBuilder buffer=new StringBuilder(result);
        assertTrue(buffer.indexOf("<UML:MockModelElement.father>") >= 0);
        assertTrue(buffer.indexOf("<UML:MockModelElement.child>") >= 0);
        assertTrue(buffer.indexOf("MockModelElement.body") >= 0);
        assertTrue(buffer.indexOf("granddad") >= 0);
        assertTrue(buffer.indexOf("son") >= 0);
        assertTrue(buffer.indexOf("daughter") >= 0);
        assertTrue(buffer.indexOf("transformerType='diagram'") >= 0);
        assertTrue(buffer.indexOf("isBooleanForTest='true'") >= 0);
    }

}
