/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.converters;

import com.topcoder.diagraminterchange.Diagram;

import com.topcoder.uml.modelmanager.UMLModelManager;

import com.topcoder.umltool.xmiconverters.poseidon5.TestHelper;

import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.diagraminterchange.DiagramInterchangeXMIHandler;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;


/**
 * <p>
 * Unit tests for <code>DiagramSizeConverter</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DiagramSizeConverterUnitTest extends TestCase {
    /**
     * <p>
     * XMIReader instance for test purpose.
     * </p>
     */
    private XMIReader reader;

    /**
     * <p>Set up the environment.</p>
     *
     * @throws Exception if any error occurs
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(XMIReader.class.getName(),
            "test_files" + File.separator + "reader_config.xml");
        TestHelper.loadSingleXMLConfig(ModelElementFactory.class.getName(),
            "test_files" + File.separator + "factory_config.xml");

        reader = new XMIReader();

        DiagramInterchangeXMIHandler handler = (DiagramInterchangeXMIHandler) reader.getHandler(
                "UML:Diagram");
        handler.setModelElementFactory(new ModelElementFactory(
                ModelElementFactory.class.getName()));
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfigFile(XMIReader.class.getName());
        TestHelper.clearConfigFile(ModelElementFactory.class.getName());
    }

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DiagramSizeConverterUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>DiagramSizeConverter(double, double, double)</code>.
     * </p>
     */
    public void testCtor() {
        DiagramSizeConverter converter = new DiagramSizeConverter(100, 200, 400);
        assertNotNull("Unable to create DiagramSizeConverter instance.",
            converter);
    }

    /**
     * <p>
     * Failure test for constructor <code>DiagramSizeConverter(double, double, double)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the emptyWidth is negative, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_Failure1() {
        try {
            new DiagramSizeConverter(-1, 0, 0);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>DiagramSizeConverter(double, double, double)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the emptyHeight is negative, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_Failure2() {
        try {
            new DiagramSizeConverter(0, -1, 0);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>DiagramSizeConverter(double, double, double)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the margin is negative, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_Failure3() {
        try {
            new DiagramSizeConverter(0, 0, -1);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>endElement(String, String, String, XMIConverterChain, XMIReader, XMIHandler)</code>.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testEndElement() throws Exception {
        XMIHandler handler = reader.getHandler("UML:Diagram");

        XMIHandler converterHandler = TestHelper.createXMIConverterHandler(handler,
                reader);
        //Add the converter to the XMIConverterHandler
        TestHelper.addConverter(converterHandler,
            new DiagramSizeConverter(100, 200, 10));

        //Replace the old handler with new XMIConverterHandler
        reader.addHandler("UML:Diagram", converterHandler);

        //This xmi's diagram's elements are all 0.0, 0.0 length and at (0.0, 0.0) position
        reader.parse(new File("test_files/DiagramSizeTest.xmi"));

        DiagramInterchangeXMIHandler dhandler = (DiagramInterchangeXMIHandler) handler;
        UMLModelManager manager = dhandler.getUmlModelManager();

        for (Diagram diagram : manager.getDiagrams()) {
            assertEquals("The length should be default.", 200.0d,
                diagram.getSize().getHeight());
            assertEquals("The width should be default.", 100.0d,
                diagram.getSize().getWidth());
        }
    }
}
