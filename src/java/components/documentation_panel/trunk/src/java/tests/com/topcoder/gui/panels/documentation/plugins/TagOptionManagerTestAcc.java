/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins;

import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.gui.panels.documentation.TestHelper;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;


/**
 * <p>
 * This test case contains accuracy tests for
 * <code>TagOptionManager</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class TagOptionManagerTestAcc extends TestCase {

    /**
     * <p>
     * GLOBAL name.
     * </p>
     */
    private static final String GLOBAL = "GLOBAL";

    /**
     * <p>
     * OPERATION name.
     * </p>
     */
    private static final String OPERATION = OperationImpl.class.getName();

    /**
     * <p>
     * CLASS name.
     * </p>
     */
    private static final String CLASS = ClassImpl.class.getName();

    /**
     * <p>
     * PARAMETER name.
     * </p>
     */
    private static final String PARAMETER = ParameterImpl.class.getName();

    /**
     * <p>
     * Global options.
     * </p>
     */
    private List < String > golbalOptions;

    /**
     * <p>
     * Operation options.
     * </p>
     */
    private List < String > operationOptions;
    /**
     * <p>
     * Class options.
     * </p>
     */
    private List < String > classOptions;
    /**
     * <p>
     * Parameter options.
     * </p>
     */
    private List < String > parameterOptions;
    /**
     * <p>
     * <code>TagOptionManager</code> used in this test case.
     * </p>
     */
    private TagOptionManager manager = null;

    /**
     * <p>
     * Set up the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        golbalOptions = TestHelper.getGlobalOptions();
        operationOptions = TestHelper.getOperationOptions();
        classOptions = TestHelper.getClassOptions();
        parameterOptions = TestHelper.getParameterOptions();
        TestHelper.addConfig("UnitTest/tagOptions.xml");
    }

    /**
     * <p>
     * Tear down the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        golbalOptions = null;
        operationOptions = null;
        classOptions = null;
        parameterOptions = null;
        manager = null;
        TestHelper.removeConfigManagerNS();
        super.tearDown();
    }

    /**
     * <p>
     * Assert the constructor.
     * </p>
     *
     * @param namespace of <code>TagOptionManager</code>
     *
     * @throws Exception to JUnit
     */
    private void assertManager(String namespace) throws Exception {
        manager = new TagOptionManager(namespace);
        assertNotNull("Initialized", manager);
    }
    /**
     * <p>
     * Test accuracy of method <code>TagOptionManager()</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTagOptionManager1() throws Exception {
        assertManager("tagOptions_1");
    }

    /**
     * <p>
     * Test accuracy of method <code>TagOptionManager()</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTagOptionManager2() throws Exception {
        assertManager("tagOptions_2");
    }

    /**
     * <p>
     * Test accuracy of method <code>TagOptionManager()</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTagOptionManager3() throws Exception {
        assertManager("tagOptions_3");
    }

    /**
     * <p>
     * Assert global options.
     * </p>
     *
     * @param options Global options
     */
    private void assertGlobalOptions(List < String > options) {
        assertEquals(options.size(), 3);
        for (String opt : options) {
            assertTrue("Global options contain " + opt, golbalOptions.contains(opt));
        }
    }
    /**
     * <p>
     * Assert operation options.
     * </p>
     *
     * @param options Operation options
     */
    private void assertOperationOptions(List < String > options) {
        assertEquals(options.size(), 5);
        for (String opt : options) {
            assertTrue("Operation options contain " + opt, operationOptions.contains(opt));
        }
    }
    /**
     * <p>
     * Assert class options.
     * </p>
     *
     * @param options Class options
     */
    private void assertClassOptions(List < String > options) {
        assertEquals(options.size(), 5);
        for (String opt : options) {
            assertTrue("Class options contain " + opt, classOptions.contains(opt));
        }
    }
    /**
     * <p>
     * Assert parameter options.
     * </p>
     *
     * @param options Parameter options
     */
    private void assertParameterOptions(List < String > options) {
        assertEquals(options.size(), 3);
        for (String opt : options) {
            assertTrue("Parameter options contain " + opt, parameterOptions.contains(opt));
        }
    }
    /**
     * <p>
     * Test accuracy of method <code>getTagOptions()</code>.
     * </p>
     *
     * <p>
     * "com.topcoder.model.uml.core.ParameterImpl" is defined
     * in "TYPES" property, but connected to no options.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetTagOptions1() throws Exception {
        assertManager("tagOptions_1");
        assertGlobalOptions(manager.getTagOptions(GLOBAL));
        assertOperationOptions(manager.getTagOptions(OPERATION));
        assertClassOptions(manager.getTagOptions(CLASS));
        assertEquals("Parameter options is empty", manager.getTagOptions(PARAMETER).size(), 0);
    }
    /**
     * <p>
     * Test accuracy of method <code>getTagOptions()</code>.
     * </p>
     *
     * <p>
     * "com.topcoder.model.uml.core.ParameterImpl" is not defined
     * in "TYPES" property, should be ignored.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetTagOptions2() throws Exception {
        assertManager("tagOptions_2");
        assertGlobalOptions(manager.getTagOptions(GLOBAL));
        assertOperationOptions(manager.getTagOptions(OPERATION));
        assertClassOptions(manager.getTagOptions(CLASS));
        Map options = (Map) TestHelper.getField(this.manager, "options");
        assertFalse("Parameter should not exist", options.containsKey(PARAMETER));
    }
    /**
     * <p>
     * Test accuracy of method <code>getTagOptions()</code>.
     * </p>
     *
     * <p>
     * The duplicate options should be moved. See tagOptions.xml for details.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetTagOptions3() throws Exception {
        assertManager("tagOptions_3");
        assertGlobalOptions(manager.getTagOptions(GLOBAL));
        assertOperationOptions(manager.getTagOptions(OPERATION));
        assertClassOptions(manager.getTagOptions(CLASS));
        assertParameterOptions(manager.getTagOptions(PARAMETER));
    }
    /**
     * <p>
     * Test accuracy of method <code>getTagOptions()</code>.
     * </p>
     *
     * <p>
     * Much links. See tagOptions.xml for details.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetTagOptions4() throws Exception {
        assertManager("tagOptions_4");
        assertGlobalOptions(manager.getTagOptions(GLOBAL));
        assertOperationOptions(manager.getTagOptions(OPERATION));
        assertClassOptions(manager.getTagOptions(CLASS));
        assertParameterOptions(manager.getTagOptions(PARAMETER));
    }
}
