/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class ExceptionUtil.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ExceptionUtilTest extends TestCase {
    /**
     * The Excpetion instance for the test.
     */
    private com.topcoder.uml.model.core.classifiers.Class exception = new ClassImpl();

    /**
     * Test empty constructor.
     */
    public void testCtor() {
        ExceptionUtil exceptionUtil = new ExceptionUtil();

        assertTrue("Should return a ExceptionUtil instance.", exceptionUtil instanceof ExceptionUtil);
    }

    /**
     * Test isException, with correct exception.
     */
    public void testIsException() {
        // create a Exception
        Stereotype stereoType = new StereotypeImpl();
        stereoType.setName("Exception");
        exception.addStereotype(stereoType);

        ExceptionUtil exceptionUtil = new ExceptionUtil();

        assertTrue("Should return true.", exceptionUtil.isException(exception));
    }

    /**
     * Test isException, with correct exception, lowercase is OK too.
     */
    public void testIsException2() {
        // create a Exception
        Stereotype stereoType = new StereotypeImpl();
        stereoType.setName("exception");
        exception.addStereotype(stereoType);

        ExceptionUtil exceptionUtil = new ExceptionUtil();

        assertTrue("Should return true.", exceptionUtil.isException(exception));
    }

    /**
     * Test isException, with wrong exception.
     */
    public void testIsExceptionWithWrongException() {
        ExceptionUtil exceptionUtil = new ExceptionUtil();

        assertFalse("Should return false, for this is actually a Class instance.",
                exceptionUtil.isException(exception));
    }

    /**
     * Test isException, with null exception. IllegalArgumentException is
     * expected.
     */
    public void testIsExceptionWithNullException() {
        try {
            ExceptionUtil exceptionUtil = new ExceptionUtil();

            exceptionUtil.isException(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }
}