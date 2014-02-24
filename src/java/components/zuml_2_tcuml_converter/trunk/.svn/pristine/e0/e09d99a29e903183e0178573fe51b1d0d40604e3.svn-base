/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.umltool.xmiconverters.poseidon5.DefaultXMIConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.GraphPropertiesConverter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Accuracy test cases for class GraphPropertiesConverter.
 * </p>
 *
 * @author abram
 * @version 1.0
 */
public class GraphPropertiesConverterAccuracyTest extends TestCase {

    /**
     * Represents the default namespace.
     */
    private static final String DEFAULT_NAMESPACE = "com.topcoder.umltool.xmiconverters.poseidon5";

    /**
     * The instance of GraphPropertiesConverter for testing..
     */
    private GraphPropertiesConverter converter;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(GraphPropertiesConverterAccuracyTest.class);
    }

    /**
     * Sets up the environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        AccuracyTestHelper.clearConfig();
        AccuracyTestHelper.loadConfig("config_graph_properties_converter.xml");

        converter = new GraphPropertiesConverter();
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
     * Accuracy test for <code>GraphPropertiesConverter(String)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>GraphPropertiesConverter(String)</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCtor1_Accuracy() throws Exception {
        assertNotNull("Should not be null", new GraphPropertiesConverter(DEFAULT_NAMESPACE));
    }

    /**
     * <p>
     * Accuracy test for <code>GraphPropertiesConverter()</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>GraphPropertiesConverter()</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCtor2_Accuracy() throws Exception {
        assertNotNull("Should not be null", converter);
    }
}
