/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.activitygraph.stresstests;

import java.io.File;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;
import com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Stress tests of ActivityGraphXMIHandler class.
 *
 * @author iamajia
 * @version 1.0
 */
public class ActivityGraphXMIHandlerStressTests extends TestCase {
    /**
     * Represents the XMIReader instance that is used in the test.
     */
    private XMIReader reader;

    /**
     * <p>
     * This test case aggregates all stress tests of ActivityGraphXMIHandler.
     * </p>
     *
     * @return all Unit test cases.
     */
    public static Test suite() {
        return new TestSuite(ActivityGraphXMIHandlerStressTests.class);
    }

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        if (ConfigManager.getInstance().existsNamespace("stress.ModelElementFactory")) {
            ConfigManager.getInstance().removeNamespace("stress.ModelElementFactory");
        }
        if (ConfigManager.getInstance().existsNamespace("stress.XMIReader")) {
            ConfigManager.getInstance().removeNamespace("stress.XMIReader");
        }
        ConfigManager.getInstance().add("stress/config.xml");
        reader = new XMIReader("stress.XMIReader");

        ActivityGraphXMIHandler handler = (ActivityGraphXMIHandler) reader.getHandler("UML:StateMachine");
        handler.setModelElementFactory(new ModelElementFactory("stress.ModelElementFactory"));
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        if (ConfigManager.getInstance().existsNamespace("stress.ModelElementFactory")) {
            ConfigManager.getInstance().removeNamespace("stress.ModelElementFactory");
        }
        if (ConfigManager.getInstance().existsNamespace("stress.XMIReader")) {
            ConfigManager.getInstance().removeNamespace("stress.XMIReader");
        }
    }

    /**
     * test stress of parsing a simple xmi file which has State Machine diagram.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testReadStatemachineDiagramSimple() throws Exception {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            reader.parse(new File("test_files/stress/statemachine_simple.xmi"));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("parse a simple xmi file 1000 times which has State Machine Diagram, cost "
            + (endTime - startTime) + "ms");
    }

    /**
     * test stress of parsing a complex xmi file which has State Machine
     * diagram.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testReadStatemachineDiagramComplex() throws Exception {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            reader.parse(new File("test_files/stress/statemachine_complex.xmi"));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("parse a complex xmi file 1000 times which has State Machine Diagram, cost "
            + (endTime - startTime) + "ms");
    }

    /**
     * test stress of parsing a simple xmi file which has Activity Graph
     * diagram.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testReadActivityGraphDiagramSimple() throws Exception {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            reader.parse(new File("test_files/stress/activitygraph_simple.xmi"));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("parse a simple xmi file 1000 times which has Activity Graph Diagram, cost "
            + (endTime - startTime) + "ms");
    }

    /**
     * test stress of parsing a simple xmi file which has Activity Graph
     * diagram.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testReadActivityGraphDiagramComplex() throws Exception {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            reader.parse(new File("test_files/stress/activitygraph_complex.xmi"));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("parse a complex xmi file 1000 times which has Activity Graph Diagram, cost "
            + (endTime - startTime) + "ms");
    }
}
