/**
 * Copyright (c) 2007, TopCoder, Inc. All rights reserved
 */
 package com.topcoder.gui.diagramviewer.failuretests;

import com.topcoder.gui.diagramviewer.failuretests.event.AddNewElementEventFailureTests;
import com.topcoder.gui.diagramviewer.failuretests.event.ScrollEventFailureTests;
import com.topcoder.gui.diagramviewer.failuretests.event.ScrollTriggerFailureTests;
import com.topcoder.gui.diagramviewer.failuretests.event.SelectionEventFailureTests;
import com.topcoder.gui.diagramviewer.failuretests.event.SelectionHandlerFailureTests;
import com.topcoder.gui.diagramviewer.failuretests.event.TextInputEventFailureTests;
import com.topcoder.gui.diagramviewer.failuretests.event.ZoomEventFailureTests;
import com.topcoder.gui.diagramviewer.failuretests.gridrenderers.SimpleGridRendererFailureTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Failure test cases.</p>
 *
 * @author Yeung
 * @version 1.0
 */
public class FailureTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        //suite.addTest(XXX.suite());
        suite.addTestSuite(DiagramViewerFailureTests.class);
        suite.addTestSuite(CloseTabActionFailureTests.class);
        suite.addTestSuite(DiagramViewFailureTests.class);
        suite.addTestSuite(TextInputBoxFailureTests.class);
        suite.addTestSuite(ZoomActionFailureTests.class);
        suite.addTestSuite(ZoomTextFieldActionFailureTests.class);

        suite.addTestSuite(SimpleGridRendererFailureTests.class);

        suite.addTestSuite(AddNewElementEventFailureTests.class);
        suite.addTestSuite(ScrollEventFailureTests.class);
        suite.addTestSuite(ScrollTriggerFailureTests.class);
        suite.addTestSuite(SelectionEventFailureTests.class);
        suite.addTestSuite(SelectionHandlerFailureTests.class);
        suite.addTestSuite(TextInputEventFailureTests.class);
        suite.addTestSuite(ZoomEventFailureTests.class);

        return suite;
    }

}
