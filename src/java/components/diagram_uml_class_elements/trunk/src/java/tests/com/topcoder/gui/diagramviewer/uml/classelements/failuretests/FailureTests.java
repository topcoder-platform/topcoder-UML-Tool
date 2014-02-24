package com.topcoder.gui.diagramviewer.uml.classelements.failuretests;

import com.topcoder.gui.diagramviewer.uml.classelements.failuretests.event.BoundaryChangedEventFailureTests;
import com.topcoder.gui.diagramviewer.uml.classelements.failuretests.event.EdgeAddEventFailureTests;
import com.topcoder.gui.diagramviewer.uml.classelements.failuretests.event.EditBoxTriggerFailureTests;
import com.topcoder.gui.diagramviewer.uml.classelements.failuretests.event.NodeAddEventFailureTests;
import com.topcoder.gui.diagramviewer.uml.classelements.failuretests.event.TextChangedEventFailureTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all failure test cases.
 * </p>
 * 
 * @author Yeung
 * @version 1.0
 */
public class FailureTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        // suite.addTest(XXX.suite());
        suite.addTestSuite(BaseNodeFailureTests.class);
        suite.addTestSuite(ClassNodeFailureTests.class);
        suite.addTestSuite(ClassConnectorFailureTests.class);
        suite.addTestSuite(EnumerationConnectorFailureTests.class);
        suite.addTestSuite(EnumerationNodeFailureTests.class);
        suite.addTestSuite(ExceptionNodeFailureTests.class);
        suite.addTestSuite(GroupTextFieldFailureTests.class);
        suite.addTestSuite(InterfaceNodeFailureTests.class);
        suite.addTestSuite(PackageNodeFailureTests.class);
        suite.addTestSuite(PackageNodeConnectorFailureTests.class);
        suite.addTestSuite(StereotypeTextFieldFailureTests.class);
        suite.addTestSuite(TextFieldFailureTests.class);
        
        suite.addTestSuite(BoundaryChangedEventFailureTests.class);
        suite.addTestSuite(EdgeAddEventFailureTests.class);
        suite.addTestSuite(EditBoxTriggerFailureTests.class);
        suite.addTestSuite(NodeAddEventFailureTests.class);
        suite.addTestSuite(TextChangedEventFailureTests.class);

        return suite;
    }

}
