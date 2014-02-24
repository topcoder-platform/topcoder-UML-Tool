/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Edges Version 1.0 Accuracytests.
 *
 * @ AnchorTypeAccuracyTests.java
 */
package com.topcoder.gui.diagramviewer.edges.accuracytests;

import com.topcoder.gui.diagramviewer.edges.AnchorType;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>AnchorType</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>AnchorType</code> enumeration.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class AnchorTypeAccuracyTests extends TestCase {
    /**
     * <p>
     * Test suite of <code>AnchorTypeAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>AnchorTypeAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(AnchorTypeAccuracyTests.class);
    }

    /**
     * <p>
     * Accuracy Test of the <code>AnchorType</code>'s attributes.
     * </p>
     */
    public void testAttributes() {
        // check the number of the attributes.
        assertEquals("AnchorType should have 3 attributes.", 3,
            AnchorType.values().length);

        // check the AnchorType has the attribute : LeftEnding.
        assertSame("AnchorType should contain LeftEnding.",
            AnchorType.LeftEnding, AnchorType.valueOf("LeftEnding"));
        // check the AnchorType has the attribute : RightEnding.
        assertSame("AnchorType should contain RightEnding.",
            AnchorType.RightEnding, AnchorType.valueOf("RightEnding"));
        // check the AnchorType has the attribute : Line.
        assertSame("AnchorType should contain Line.", AnchorType.Line,
            AnchorType.valueOf("Line"));
    }
}
