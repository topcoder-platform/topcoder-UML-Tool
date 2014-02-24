/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.gui.diagramviewer.accuracytests;

import com.topcoder.gui.diagramviewer.accuracytests.event.AddNewElementEventAccuracyTests;
import com.topcoder.gui.diagramviewer.accuracytests.event.AddNewElementHandlerAccuracyTests;
import com.topcoder.gui.diagramviewer.accuracytests.event.MouseDragHandlerAccuracyTests;
import com.topcoder.gui.diagramviewer.accuracytests.event.PopupMenuTriggerAccuracyTests;
import com.topcoder.gui.diagramviewer.accuracytests.event.ScrollEventAccuracyTests;
import com.topcoder.gui.diagramviewer.accuracytests.event.ScrollTriggerAccuracyTests;
import com.topcoder.gui.diagramviewer.accuracytests.event.SelectElementsHandlerAccuracyTests;
import com.topcoder.gui.diagramviewer.accuracytests.event.SelectionEventAccuracyTests;
import com.topcoder.gui.diagramviewer.accuracytests.event.SelectionHandlerAccuracyTests;
import com.topcoder.gui.diagramviewer.accuracytests.event.TextInputBoxKeyHandlerAccuracyTests;
import com.topcoder.gui.diagramviewer.accuracytests.event.TextInputEventAccuracyTests;
import com.topcoder.gui.diagramviewer.accuracytests.event.ZoomEventAccuracyTests;
import com.topcoder.gui.diagramviewer.accuracytests.event.ZoomTriggerAccuracyTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all accuracy test cases.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class AccuracyTests extends TestCase {
    /**
     * <p>
     * The test suite.
     * </p>
     *
     * @return the test suite.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        // package com.topcoder.gui.diagramviewer
        suite.addTestSuite(CloseTabActionAccuracyTests.class);
        suite.addTestSuite(DiagramViewAccuracyTests.class);
        suite.addTestSuite(DiagramViewerAccuracyTests.class);
        suite.addTestSuite(TextInputBoxAccuracyTests.class);
        suite.addTestSuite(ZoomActionAccuracyTests.class);
        suite.addTestSuite(ZoomTextFieldActionAccuracyTests.class);

        // package com.topcoder.gui.diagramviewer.gridrenderers
        suite.addTestSuite(SimpleGridRendererAccuracyTests.class);

        // event.
        suite.addTestSuite(AddNewElementEventAccuracyTests.class);
        suite.addTestSuite(AddNewElementHandlerAccuracyTests.class);
        suite.addTestSuite(MouseDragHandlerAccuracyTests.class);
        suite.addTestSuite(PopupMenuTriggerAccuracyTests.class);
        suite.addTestSuite(ScrollEventAccuracyTests.class);
        suite.addTestSuite(ScrollTriggerAccuracyTests.class);
        suite.addTestSuite(SelectElementsHandlerAccuracyTests.class);
        suite.addTestSuite(SelectionEventAccuracyTests.class);
        suite.addTestSuite(SelectionHandlerAccuracyTests.class);
        suite.addTestSuite(TextInputBoxKeyHandlerAccuracyTests.class);
        suite.addTestSuite(TextInputEventAccuracyTests.class);
        suite.addTestSuite(ZoomEventAccuracyTests.class);
        suite.addTestSuite(ZoomTriggerAccuracyTests.class);

        return suite;
    }
}