/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.stresstests;

import java.awt.Point;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.edges.TextField;

import junit.framework.TestCase;

/**
 * Stress test for <code>TextField</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class TextFieldStressTests extends TestCase {

    /**
     * Represents the <code>TextField</code> instance instance used to test against.
     */
    private TextField textField = new TextField(new GraphNode(), "Text", AnchorType.Line);

    /**
     * Stress test for <code>TextField</code> class.
     */
    public void testLineStyleStress() {
        // record the start time
        TestHelper.startTimer();

        for (int i = 0; i < TestHelper.NUMBER; i++) {
            // get graph node
            textField.getGraphNode();
            // get anchor type
            textField.getAnchorType();
            // get anchorage
            textField.getAnchorage();
            // set new anchorage
            textField.setAnchorage(new Point(i, -i));
            // get isSelected flag
            textField.isSelected();
            // set new isSelected flag
            textField.setSelected(i % 2 == 0);
            // update the anchorage
            textField.updateAnchorage();
        }

        // print the result
        TestHelper.printResultMulTimes("TextField");
    }
}
