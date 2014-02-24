/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import com.topcoder.umltool.xmiconverters.poseidon5.converters.DiagramSizeConverterUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.DiagramTitleConverterUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.GraphPropertiesConverterUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.IgnoreOperationInMethodConverterUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.RenameConverterUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.handlers.UnsupportedVersionExceptionUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.handlers.ZUMLHeaderHandlerUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.handlers.ZUMLMethodHandlerUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.propertytransformers.RegexToLowerPropertyValueTransformerUnitTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {
    /**
     * <p>Return the suite all unit test cases.</p>
     *
     * @return the suite of all unit test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(Demo.suite());

        suite.addTest(DefaultXMIConverterUnitTest.suite());
        suite.addTest(DefaultXMIConverterChainUnitTest.suite());
        suite.addTest(HelperUnitTest.suite());
        suite.addTest(XMIConverterConfigurationExceptionUnitTest.suite());
        suite.addTest(XMIConverterHandlerUnitTest.suite());
        suite.addTest(XMIConvertersUtilUnitTest.suite());

        suite.addTest(DiagramSizeConverterUnitTest.suite());
        suite.addTest(DiagramTitleConverterUnitTest.suite());
        suite.addTest(GraphPropertiesConverterUnitTest.suite());
        suite.addTest(IgnoreOperationInMethodConverterUnitTest.suite());
        suite.addTest(RenameConverterUnitTest.suite());

        suite.addTest(UnsupportedVersionExceptionUnitTest.suite());
        suite.addTest(ZUMLHeaderHandlerUnitTest.suite());
        suite.addTest(ZUMLMethodHandlerUnitTest.suite());

        suite.addTest(RegexToLowerPropertyValueTransformerUnitTest.suite());

        return suite;
    }
}
