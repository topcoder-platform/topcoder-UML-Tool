/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout;

import com.topcoder.gui.sectionlayout.dock.DockEventTests;
import com.topcoder.gui.sectionlayout.dock.dndimpl.BasicDockContainerTests;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DefaultDockTests;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DialogFloatContainerTests;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DockableWrapperTests;
import com.topcoder.gui.sectionlayout.model.DefaultSectionModelTests;
import com.topcoder.gui.sectionlayout.ui.DefaultSectionHeaderUITests;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;


/**
 * <p>
 * This test case aggregates all Unit test cases.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {

    /**
     * <p>
     * This test case aggregates all Unit test cases.
     * </p>
     *
     * @return all Unit test cases.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        // tests for package com.topcoder.gui.sectionlayout
        suite.addTest(DockContainerPanelTests.suite());
        suite.addTest(HelperTests.suite());
        suite.addTest(SectionDockContainerTests.suite());
        suite.addTest(SectionHeaderTests.suite());
        suite.addTest(SectionTests.suite());

        // tests for package com.topcoder.gui.sectionlayout.dock
        suite.addTest(DockEventTests.suite());

        // tests for package com.topcoder.gui.sectionlayout.dock.dndimpl
        suite.addTest(BasicDockContainerTests.suite());
        suite.addTest(DefaultDockTests.suite());
        suite.addTest(DialogFloatContainerTests.suite());
        suite.addTest(DockableWrapperTests.suite());

        // tests for package com.topcoder.gui.sectionlayout.model
        suite.addTest(DefaultSectionModelTests.suite());

        // tests for package com.topcoder.gui.sectionlayout.ui
        suite.addTest(DefaultSectionHeaderUITests.suite());

        // tests for the demo
        suite.addTest(DemoTests.suite());

        return suite;
    }
}
