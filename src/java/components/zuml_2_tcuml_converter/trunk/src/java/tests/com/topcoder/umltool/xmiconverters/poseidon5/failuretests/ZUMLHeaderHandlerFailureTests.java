/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import junit.framework.TestCase;

import com.topcoder.umltool.xmiconverters.poseidon5.handlers.ZUMLHeaderHandler;

/**
 * <p>
 * Failure tests for <code>ZUMLHeaderHandler</code> class.
 * </p>
 * @author Thinfox
 * @version 1.0
 */
public class ZUMLHeaderHandlerFailureTests extends TestCase {
    /**
     * <p>
     * Tests the ctor <code>ZUMLHeaderHandler(String[])</code>.
     * </p>
     * <p>
     * When the acceptableVersions is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_Null() {
        try {
            new ZUMLHeaderHandler(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>ZUMLHeaderHandler(String[])</code>.
     * </p>
     * <p>
     * When the acceptableVersions contains null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_NullElement() {
        try {
            new ZUMLHeaderHandler(new String[] {null});
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>ZUMLHeaderHandler(String[])</code>.
     * </p>
     * <p>
     * When the acceptableVersions contains an empty string, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_EmptyElement() {
        try {
            new ZUMLHeaderHandler(new String[] {"   "});
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
