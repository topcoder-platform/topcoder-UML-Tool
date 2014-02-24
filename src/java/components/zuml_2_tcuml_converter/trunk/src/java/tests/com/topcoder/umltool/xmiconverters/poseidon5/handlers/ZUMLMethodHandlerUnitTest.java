/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.handlers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit tests for <code>ZUMLMethodHandler</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ZUMLMethodHandlerUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(ZUMLMethodHandlerUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>ZUMLMethodHandler()</code>.
     * The class is trivial, we just test whether it can be created.
     * </p>
     */
    public void testCtor() {
        ZUMLMethodHandler handler = new ZUMLMethodHandler();
        assertNotNull("Unable to create ZUMLMethodHandler.", handler);
    }
}
