/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * @ ExceptionAccuracyTests.java
 */
package com.topcoder.gui.panels.documentation.accuracytests;

import com.topcoder.gui.panels.documentation.DocumentationPanelConfigurationException;
import com.topcoder.gui.panels.documentation.UnknownElementTypeException;
import com.topcoder.util.errorhandling.BaseException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>UnknownElementTypeException</code> and <code>DocumentationPanelConfigurationException</code>'s
 * Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>UnknownElementTypeException</code> class and
 * <code>DocumentationPanelConfigurationException</code>
 * class.
 * </p>
 *
 * @author still
 * @version 1.0
 */
public class ExceptionAccuracyTests extends TestCase {
    /**
    * <p>
    * The string of message for accuracy test.
    * </p>
    */
    private static final String TEST_MESSAGE = "Exception Message.";

    /**
     * <p>
     * Test suite of <code>ExceptionAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>ExceptionAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(ExceptionAccuracyTests.class);
    }

    /**
     * <p>
     * Accuracy Test of the <code>UnknownElementTypeException</code> classs.
     * </p>
     */
    public void testUnknownElementTypeException() {
        // create a exception instance with error message for test.
        UnknownElementTypeException uetException = new UnknownElementTypeException(TEST_MESSAGE);

        // check for not null.
        assertNotNull("Create failed.", uetException);

        // get the error message to check the constructor.
        assertEquals("Equal message expected.", TEST_MESSAGE,
            uetException.getMessage());

        // create a new error.
        Throwable cause = new Error();

        // create a exception instance
        uetException = new UnknownElementTypeException(TEST_MESSAGE, cause);

        // check for not null.
        assertNotNull("Create failed.", uetException);

        // check error message and cause to check the constructor.
        assertEquals("Equal message expected.",
            TEST_MESSAGE + ", caused by null", uetException.getMessage());
        assertEquals("Equal cause expected.", cause, uetException.getCause());
    }

    /**
     * <p>
     * Accuracy Test of the <code>DocumentationPanelConfigurationException</code> classs.
     * </p>
     */
    public void testDocumentationPanelConfigurationException() {
        // create a exception instance with error message for test.
        DocumentationPanelConfigurationException dpcException =
            new DocumentationPanelConfigurationException(TEST_MESSAGE);

        // check for not null.
        assertNotNull("Create failed.", dpcException);

        // get the error message to check the constructor.
        assertEquals("Equal message expected.", TEST_MESSAGE,
            dpcException.getMessage());

        // create a new error.
        Throwable cause = new Error();

        // create a exception instance
        dpcException = new DocumentationPanelConfigurationException(TEST_MESSAGE,
                cause);

        // check for not null.
        assertNotNull("Create failed.", dpcException);

        // check error message and cause to check the constructor.
        assertEquals("Equal message expected.",
            TEST_MESSAGE + ", caused by null", dpcException.getMessage());
        assertEquals("Equal cause expected.", cause, dpcException.getCause());
    }

    /**
     * <p>
     * Accuracy Test of the the <code>UnknownElementTypeException</code> class and
     * <code>DocumentationPanelConfigurationException</code>
     * class.
     * It tests the class inheritance.
     * </p>
     */
    public void testRelationship() {
        UnknownElementTypeException uetException = new UnknownElementTypeException(TEST_MESSAGE);

        // test class inheritance.
        assertTrue("This class should extend from BaseException",
            uetException instanceof BaseException);

        DocumentationPanelConfigurationException dpcException =
            new DocumentationPanelConfigurationException(TEST_MESSAGE);

        // test class inheritance.
        assertTrue("This class should extend from BaseException",
            dpcException instanceof BaseException);
    }
}
