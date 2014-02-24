/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.gui.diagramviewer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Unit test cases.
 * </p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class UnitTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        // package com.topcoder.gui.diagramviewer
        suite.addTestSuite(CloseTabActionUnitTests.class);
        suite.addTestSuite(ConfigurationExceptionUnitTests.class);
        suite.addTestSuite(DiagramViewUnitTests.class);
        suite.addTestSuite(DiagramViewerUnitTests.class);
        suite.addTestSuite(DVHelperUnitTests.class);
        suite.addTestSuite(TextInputBoxUnitTests.class);
        suite.addTestSuite(ZoomActionUnitTests.class);
        suite.addTestSuite(ZoomTextFieldActionUnitTests.class);

        // package com.topcoder.gui.diagramviewer.event
        suite.addTestSuite(AddNewElementEventUnitTests.class);
        suite.addTestSuite(AddNewElementHandlerUnitTests.class);
        suite.addTestSuite(MouseDragHandlerUnitTests.class);
        suite.addTestSuite(PopupMenuTriggerUnitTests.class);
        suite.addTestSuite(ScrollEventUnitTests.class);
        suite.addTestSuite(ScrollTriggerUnitTests.class);
        suite.addTestSuite(SelectElementsHandlerUnitTests.class);
        suite.addTestSuite(SelectionEventUnitTests.class);
        suite.addTestSuite(SelectionHandlerUnitTests.class);
        suite.addTestSuite(TextInputBoxKeyHandlerUnitTests.class);
        suite.addTestSuite(TextInputEventUnitTests.class);
        suite.addTestSuite(ZoomEventUnitTests.class);
        suite.addTestSuite(ZoomTriggerUnitTests.class);
        // package com.topcoder.gui.diagramviewer.gridrenderers
        suite.addTestSuite(SimpleGridRendererUnitTests.class);
        //Demo
        suite.addTestSuite(Demo.class);
        return suite;
    }

}
