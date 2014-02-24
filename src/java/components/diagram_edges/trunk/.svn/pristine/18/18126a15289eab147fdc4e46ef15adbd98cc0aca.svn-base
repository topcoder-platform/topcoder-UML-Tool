/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.stresstests;

import com.topcoder.gui.diagramviewer.edges.LineStyle;

import junit.framework.TestCase;

/**
 * Stress test for <code>LineStyle</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class LineStyleStressTests extends TestCase {

    /**
     * Represents the <code>LineStyle</code> instance used to test against.
     */
    private LineStyle lineStyle = new LineStyle(2, 1);

    /**
     * Stress test for <code>LineStyle</code> class.
     */
    public void testLineStyleStress() {
        // record the start time
        TestHelper.startTimer();

        for (int i = 0; i < TestHelper.NUMBER; i++) {
            // get dash length
            lineStyle.getDashLength();
            // set new dash length
            lineStyle.setDashLength(3);
            // get black length
            lineStyle.getBlankLength();
            // set new blank length
            lineStyle.setBlankLength(2);
        }

        // print the result
        TestHelper.printResultMulTimes("LineStyle");
    }
}
