/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for PropertyOperation.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PropertyOperationTests extends TestCase {
    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(PropertyOperationTests.class);
    }

    /**
     * <p>
     * Tests PropertyOperation#valueOf(String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies PropertyOperation#valueOf(String) is correct.
     * </p>
     */
    public void testValueOf() {
        assertSame("It verifies the ADD PropertyOperation", PropertyOperation.ADD, PropertyOperation.valueOf("ADD"));
        assertSame("It verifies the REMOVE PropertyOperation", PropertyOperation.REMOVE,
            PropertyOperation.valueOf("REMOVE"));
        assertSame("It verifies the MODIFY PropertyOperation", PropertyOperation.MODIFY,
            PropertyOperation.valueOf("MODIFY"));
    }

    /**
     * <p>
     * Tests PropertyOperation#values() for accuracy.
     * </p>
     *
     * <p>
     * It verifies PropertyOperation#values() is correct.
     * </p>
     */
    public void testValues() {
        PropertyOperation[] operations = PropertyOperation.values();

        assertEquals("There should be three property operations defined.", 3, operations.length);
        assertSame("It verifies the ADD PropertyOperation", PropertyOperation.ADD, operations[0]);
        assertSame("It verifies the REMOVE PropertyOperation", PropertyOperation.REMOVE, operations[1]);
        assertSame("It verifies the MODIFY PropertyOperation", PropertyOperation.MODIFY, operations[2]);
    }

}