/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.diagramviewer.elements.NodeContainerFailureTests;
import com.topcoder.gui.diagramviewer.elements.NodeFailureTests;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerMouseListenerFailureTests;

/**
 * <p>
 * This class aggregates all failure testcases for the component Diagram Elements. The version tested is version
 * 1.0.
 * </p>
 * 
 * @author ch_music
 * @version 1.0
 */
public class FailureTests extends TestCase {

    /**
     * <p>
     * Returns a Test instance containing all the failure testcases.
     * </p>
     * 
     * @return a Test instance containing all the failure testcases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        // DragEventAdapter class: No failure test for this class.
        suite.addTest(new TestSuite(LocationEventFailureTests.class));
        suite.addTest(new TestSuite(NodeFailureTests.class));
        suite.addTest(new TestSuite(NodeContainerFailureTests.class));
        // NodeMouseListener class: No failure test for this class.
        suite.addTest(new TestSuite(SelectionBoundEventFailureTests.class));
        suite.addTest(new TestSuite(SelectionCornerFailureTests.class));
        suite.addTest(new TestSuite(SelectionCornerMouseListenerFailureTests.class));

        return suite;
    }
}
