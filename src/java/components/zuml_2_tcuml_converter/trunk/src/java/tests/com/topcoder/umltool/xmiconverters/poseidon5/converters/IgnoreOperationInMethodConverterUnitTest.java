/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.converters;

import com.topcoder.umltool.xmiconverters.poseidon5.TestHelper;
import com.topcoder.umltool.xmiconverters.poseidon5.handlers.ZUMLHeaderHandler;
import com.topcoder.umltool.xmiconverters.poseidon5.handlers.ZUMLMethodHandler;

import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;


/**
 * <p>
 * Unit tests for <code>IgnoreOperationInMethodConverter</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class IgnoreOperationInMethodConverterUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(IgnoreOperationInMethodConverterUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>IgnoreOperationInMethodConverter()</code>.
     * </p>
     */
    public void testCtor() {
        IgnoreOperationInMethodConverter converter = new IgnoreOperationInMethodConverter();
        assertNotNull("Unable to create IgnoreOperationInMethodConverter instance.",
            converter);
    }

    /**
     * <p>
     * Accuracy test for <code>startElement()</code>.
     * It's hard to verify the IgnoreOperationInMethodConverter's startElement, as it
     * does nothing. So we just check it process successfully, and see the coverage report
     * to check whether it's executed.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testStartElement() throws Exception {
        XMIReader reader = new XMIReader();

        //Add handler for UML:Method
        reader.addHandler("UML:Method", new ZUMLMethodHandler());

        //Create a XMIConverterHandler for UML:Operation
        XMIHandler handler = TestHelper.createXMIConverterHandler(new ZUMLMethodHandler(),
                reader);
        TestHelper.addConverter(handler, new IgnoreOperationInMethodConverter());
        reader.addHandler("UML:Operation", handler);

        //It should process successfully
        //We can't verfy it, just see the coverage report
        reader.parseZipFile("test_files" + File.separator
                + "sample.zuml");

        //Test Case for the original handler is not ZUMLHeaderHandler
        reader = new XMIReader();
        reader.addHandler("UML:Method", new ZUMLHeaderHandler(new String[0]));
        handler = TestHelper.createXMIConverterHandler(new ZUMLMethodHandler(),
                reader);
        TestHelper.addConverter(handler, new IgnoreOperationInMethodConverter());

        reader.addHandler("UML:Operation", handler);

        //It should process successfully
        //We can't verify it, just see the coverage report
        reader.parseZipFile("test_files" + File.separator
                + "sample.zuml");
    }

    /**
     * <p>
     * Accuracy test for <code>endElement(String, String, String, XMIConverterChain, XMIReader, XMIHandler)</code>.
     * It's hard to verify the IgnoreOperationInMethodConverter's endElement, as it
     * does nothing. So we just check it process successfully, and see the coverage report
     * to check whether it's executed.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testEndElement() throws Exception {
        XMIReader reader = new XMIReader();

        //Add handler for UML:Method
        reader.addHandler("UML:Method", new ZUMLMethodHandler());

        //Create a XMIConverterHandler for UML:Operation
        XMIHandler handler = TestHelper.createXMIConverterHandler(new ZUMLMethodHandler(),
                reader);
        TestHelper.addConverter(handler, new IgnoreOperationInMethodConverter());
        reader.addHandler("UML:Operation", handler);

        //It should process successfully
        //We can't verfy it, just see the coverage report
        reader.parseZipFile("test_files" + File.separator
                + "sample.zuml");

        //Test Case for the original handler is not ZUMLHeaderHandler
        reader = new XMIReader();
        reader.addHandler("UML:Method", new ZUMLHeaderHandler(new String[0]));
        handler = TestHelper.createXMIConverterHandler(new ZUMLMethodHandler(),
                reader);
        TestHelper.addConverter(handler, new IgnoreOperationInMethodConverter());

        reader.addHandler("UML:Operation", handler);

        //It should process successfully
        //We can't verify it, just see the coverage report
        reader.parseZipFile("test_files" + File.separator
                + "sample.zuml");
    }
}
