/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classedges.NoArrow;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;
import com.topcoder.gui.diagramviewer.uml.classedges.event.EdgeEndingSelectionTrigger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>EdgeEndingSelectionTrigger</code> class.
 *
 * @author still
 * @version 1.0
 */
public class EdgeEndingSelectionTriggerFailureTest extends TestCase {

    /**
     * Test suite of EdgeEndingSelectionTrigger.
     *
     * @return Test suite of EdgeEndingSelectionTrigger.
     */
    public static Test suite() {
        return new TestSuite(EdgeEndingSelectionTriggerFailureTest.class);
    }


    /**
     * <p>
     * Test of EdgeEndingSelectionTrigger(ActiveEdgeEnding) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null ActiveEdgeEnding.
     */
    public void testEdgeEndingSelectionTriggerForException() {
        try {
            new EdgeEndingSelectionTrigger(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of mouseClicked(MouseEvent) for ignoring null event.
     * </p>
     *
     * No exception should be thrown when encountering null event.
     */
    public void testMouseClickedForIngoreNullMouseEvent() {
        TextField textField1 = new TextField(new GraphNode());
        TextField textField2 = new TextField(new GraphNode());
        new EdgeEndingSelectionTrigger(new NoArrow(textField1, textField2)).mouseClicked(null);
    }

}
