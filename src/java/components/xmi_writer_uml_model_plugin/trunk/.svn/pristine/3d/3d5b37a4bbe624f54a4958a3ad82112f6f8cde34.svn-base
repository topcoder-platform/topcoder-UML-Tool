/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.xmi.writer.transformers.model.Implement1;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.model.Model2XMITransformer;
import com.topcoder.xmi.writer.transformers.model.XMIDescription;

import junit.framework.TestCase;
/**
 * <p>
 * The demo usage of the component.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {
    /**
     * The namespace.
     */
    private static final String NAMESPACE = "com.topcoder.xmi.writer.transformers.model.Model2XMITransformer";
    /**
     * The Model2XMITransformer instance for testing.
     */
    private Model2XMITransformer transformer = null;
    /**
     * The XMIDescription instance.
     */
    private XMIDescription xmiDescription = null;
    /**
     * The XMIWriter instance for testing.
     */
    private XMIWriter writer = null;
    /**
     * The PrintStream instance for testing, it is the System.out.
     */
    private PrintStream out = System.out;
    /**
     * The setUp of the unit test.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.clearConfig();
        TestHelper.addConfig();
        Map <TransformerType, XMITransformer> map = new HashMap<TransformerType, XMITransformer>();

        transformer = new Model2XMITransformer(NAMESPACE);
        map.put(TransformerType.Model, transformer);
        map.put(TransformerType.ActivityGraph, transformer);
        map.put(TransformerType.Diagram, transformer);
        //create a XMIWriter instance
        writer = new XMIWriter(new UMLModelManager(), map);
        transformer.setXMIWriter(writer);
        xmiDescription = transformer.getXMIDescription();
    }
    /**
     * The tear down of the unit test, remove the configuration.
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
    }
    /**
     * The demo usage of creating the transformer.
     *
     * @throws Exception to JUnit
     */
    public void test_demo_create_transformer() throws Exception {
        //create the instance with configuration
        XMITransformer  transformer = new Model2XMITransformer(NAMESPACE);

        //create the Model2XMITransformer with the given XMIDescription and setIgnoreUnknownElementType
        transformer = new Model2XMITransformer(xmiDescription, false);
    }
    /**
     * The demo usage of using the transformer.
     *
     * @throws Exception to JUnit
     */
    public void test_demo_use_transformer() throws Exception {
        //transform an element and print it to the PrintStream
        transformer.transform(new Implement1(), out);

        //set whether we should ignore the unknown element type or not
        transformer.setIgnoreUnknownElementType(false);

        //get whether we should ignore the unknown element type or not
        transformer.isIgnoreUnknownElementType();
    }
    /**
     * The demo usage of using the component as a plugin of XMIWriter.
     *
     * @throws Exception to JUnit
     */
    public void test_demo_with_XMIWriter() throws Exception {
        Map <TransformerType, XMITransformer> map = new HashMap<TransformerType, XMITransformer>();

        transformer = new Model2XMITransformer(NAMESPACE);
        map.put(TransformerType.Model, transformer);
        map.put(TransformerType.ActivityGraph, transformer);
        map.put(TransformerType.Diagram, transformer);
        //create a XMIWriter instance
        writer = new XMIWriter(new UMLModelManager(), map);

        writer.transform(System.out, true);
    }
}
