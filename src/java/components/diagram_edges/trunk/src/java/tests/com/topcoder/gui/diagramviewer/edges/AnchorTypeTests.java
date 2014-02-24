/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AnchorType.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AnchorTypeTests extends TestCase {
    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(AnchorTypeTests.class);
    }

    /**
     * <p>
     * Tests the AnchorType enumeration using the AnchorType#valueOf(String).
     * </p>
     *
     * <p>
     * Verify : The three AnchorType enumerations should be returned.
     * </p>
     */
    public void testValueOf() {
        assertSame("Verify the LeftEnding AnchorType.", AnchorType.LeftEnding, AnchorType.valueOf("LeftEnding"));
        assertSame("Verify the RightEnding AnchorType.", AnchorType.RightEnding, AnchorType.valueOf("RightEnding"));
        assertSame("Verify the Line AnchorType.", AnchorType.Line, AnchorType.valueOf("Line"));
    }

    /**
     * <p>
     * Tests the AnchorType enumeration using the AnchorType#values().
     * </p>
     *
     * <p>
     * Verify : The three AnchorType enumerations should be returned.
     * </p>
     */
    public void testValues() {
        AnchorType[] anchorTypes = AnchorType.values();

        assertEquals("There should be three anchor types defined.", 3, anchorTypes.length);
        assertSame("Verify the LeftEnding AnchorType.", AnchorType.LeftEnding, anchorTypes[0]);
        assertSame("Verify the RightEnding AnchorType.", AnchorType.RightEnding, anchorTypes[1]);
        assertSame("Verify the Line AnchorType.", AnchorType.Line, anchorTypes[2]);
    }
}