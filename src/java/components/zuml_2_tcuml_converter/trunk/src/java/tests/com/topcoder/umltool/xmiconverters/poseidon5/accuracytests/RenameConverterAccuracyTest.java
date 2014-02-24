/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import java.util.Map;

import com.topcoder.umltool.xmiconverters.poseidon5.DefaultXMIConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.GraphPropertiesConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.RenameConverter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Accuracy test cases for class RenameConverter.
 * </p>
 *
 * @author abram
 * @version 1.0
 */
public class RenameConverterAccuracyTest extends TestCase {

    /**
     * Represents the default namespace.
     */
    private static final String DEFAULT_NAMESPACE = "com.topcoder.umltool.xmiconverters.poseidon5";

    /**
     * The instance of RenameConverter for testing..
     */
    private RenameConverter converter;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(RenameConverterAccuracyTest.class);
    }

    /**
     * Sets up the environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        AccuracyTestHelper.clearConfig();
        AccuracyTestHelper.loadConfig("config_rename_converter.xml");
        converter = new RenameConverter();
    }

    /**
     * Cleans up the environment.
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        AccuracyTestHelper.clearConfig();
    }

    /**
     * <p>
     * Accuracy test for the base class.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testStaticFields_Accuracy() throws Exception {
        assertEquals("Expected Namespace:", DEFAULT_NAMESPACE,
                GraphPropertiesConverter.DEFAULT_NAMESPACE);
    }

    /**
     * <p>
     * Accuracy test for the base class.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testBase_Accuracy() throws Exception {
        assertTrue("Should implement DefaultXMIConverter",
                converter instanceof DefaultXMIConverter);
    }

    /**
     * <p>
     * Accuracy test for <code>RenameConverter(String)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>RenameConverter(String)</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCtor1_Accuracy() throws Exception {
        converter = new RenameConverter(DEFAULT_NAMESPACE);
        assertNotNull("Should not be null", converter);
        Map map = (Map) AccuracyTestHelper.getField(converter, converter.getClass(),
                "toRenameNames");
        assertEquals("Expected number of map: ", 3, map.size());
        assertEquals("Expected value: ", "UML:StructuralFeature.type", map
                .get("UML2:TypedElement.type"));
        assertEquals("Expected value: ", "UML:Classifier", map.get("UML:Class"));
        assertEquals("Expected value: ", "UML:Classifier", map.get("UML:DateType"));
    }

    /**
     * <p>
     * Accuracy test for <code>RenameConverter()</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>RenameConverter()</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCtor2_Accuracy() throws Exception {
        assertNotNull("Should not be null", converter);
        Map map = (Map) AccuracyTestHelper.getField(converter, converter
            .getClass(), "toRenameNames");
        assertEquals("Expected number of map: ", 3, map.size());
        assertEquals("Expected value: ", "UML:StructuralFeature.type", map
                .get("UML2:TypedElement.type"));
        assertEquals("Expected value: ", "UML:Classifier", map.get("UML:Class"));
        assertEquals("Expected value: ", "UML:Classifier", map.get("UML:DateType"));
    }
}
