/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests on class <code>AuxiliaryElementCloneException</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class AuxiliaryElementCloneExceptionTest extends TestCase {
    /**
     * <p>
     * Test constructor <code>AuxiliaryElementCloneException(String message)</code> for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create AuxiliaryElementCloneException!",
                new AuxiliaryElementCloneException("message"));
    }
    /**
     * <p>
     * Test constructor <code>AuxiliaryElementCloneException(String message, Throwable cause)</code> for accuracy.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create AuxiliaryElementCloneException!",
                new AuxiliaryElementCloneException("message", new Exception()));
    }
}
