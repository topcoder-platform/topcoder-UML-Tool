/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model.stresstests;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.model.Model2XMITransformer;
import com.topcoder.xmi.writer.transformers.model.XMIDescription;

import junit.framework.TestCase;
/**
 * The Stress test of the class Model2XMITransformer.
 *
 * @author haozhangr
 * @version 1.0
 */
public class Model2XMITransformerStressTests extends TestCase {
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
     * The PrintStream instance for testing.
     */
    private PrintStream out = System.out;
    /**
     * The setUp of the unit test.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        StressTestHelper.clearConfig();
        StressTestHelper.addConfig();
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
        StressTestHelper.clearConfig();
    }
    /**
     * The stress test of the method transform,
     * it is excuted for 400 times, and the costed time is printed.
     *
     * @throws Exception to JUnit
     */
    public void test_stress_transform() throws Exception {
        StressImplement element = new StressImplement();
        long start = System.currentTimeMillis();
        for(int i = 0; i < StressTestHelper.TIMES; i++) {
            transformer.transform(element, out);
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("Excute 400 times of Model2XMITransformer#transform cost " + (end - start) + " ms.");
    }
}
