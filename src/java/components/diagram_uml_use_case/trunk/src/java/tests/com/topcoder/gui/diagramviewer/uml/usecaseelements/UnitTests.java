/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedEventTests;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EdgeAddEventTests;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EditBoxListenerTests;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EditBoxTriggerTests;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.NodeAddEventTests;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.PopupMenuTriggerTests;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.TextChangeEventTests;

/**
 * <p>This test case aggregates all Unit test cases.</p>
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
        // This is the demo
        suite.addTest(new TestSuite(DemoTests.class));

        suite.addTest(new TestSuite(SubsystemNodeContainerTests.class));
        suite.addTest(new TestSuite(BaseNodeTests.class));
        suite.addTest(new TestSuite(ActorNodeTests.class));
        suite.addTest(new TestSuite(UseCaseNodeTests.class));
        suite.addTest(new TestSuite(ActorConnectorTests.class));
        suite.addTest(new TestSuite(UseCaseConnectorTests.class));
        suite.addTest(new TestSuite(TextFieldTests.class));
        suite.addTest(new TestSuite(BaseEdgeTests.class));
        suite.addTest(new TestSuite(IncludeEdgeTests.class));
        suite.addTest(new TestSuite(ExtendEdgeTests.class));
        suite.addTest(new TestSuite(SimpleArrowTests.class));
        suite.addTest(new TestSuite(IllegalGraphElementExceptionTests.class));
        suite.addTest(new TestSuite(UtilsTests.class));

        // tests for package com.topcoder.gui.diagramviewer.uml.usecaseelements.event
        suite.addTest(new TestSuite(BoundaryChangedEventTests.class));
        suite.addTest(new TestSuite(EdgeAddEventTests.class));
        suite.addTest(new TestSuite(NodeAddEventTests.class));
        suite.addTest(new TestSuite(TextChangeEventTests.class));
        suite.addTest(new TestSuite(EditBoxTriggerTests.class));
        suite.addTest(new TestSuite(EditBoxListenerTests.class));
        suite.addTest(new TestSuite(PopupMenuTriggerTests.class));
        return suite;
    }

}
