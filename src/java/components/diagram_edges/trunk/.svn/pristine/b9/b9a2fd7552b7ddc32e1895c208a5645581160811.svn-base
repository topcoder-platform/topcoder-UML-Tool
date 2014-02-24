/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.stresstests;

import java.awt.Color;
import java.awt.Point;

import com.topcoder.gui.diagramviewer.edges.SelectionCorner;

import junit.framework.TestCase;

/**
 * Stress test for <code>SelectionCorner</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class SelectionCornerStressTests extends TestCase {

    /**
     * Represents the <code>SelectionCorner</code> instance used to test against.
     */
    private SelectionCorner selectionCorner = new SelectionCorner(new Point());

    /**
     * Stress test for <code>SelectionCorner</code> class.
     */
    public void testSelectionCornerStress() {
        // record the start time
        TestHelper.startTimer();

        for (int i = 0; i < TestHelper.NUMBER; i++) {
            // get radius
            selectionCorner.getRadius();
            // set new radius
            selectionCorner.setRadius(i + 1);
            // get center
            selectionCorner.getCenter();
            // set new center
            selectionCorner.setCenter(new Point(i, -i));
            // get stroke color
            selectionCorner.getStrokeColor();
            // set new stroke color
            selectionCorner.setStrokeColor(Color.RED);
            // get fill color
            selectionCorner.getFillColor();
            // set new fill color
            selectionCorner.setFillColor(Color.BLUE);
            // determine whether the point is contained
            selectionCorner.contains(i, i);
        }

        // print the result
        TestHelper.printResultMulTimes("SelectionCorner");
    }
}
