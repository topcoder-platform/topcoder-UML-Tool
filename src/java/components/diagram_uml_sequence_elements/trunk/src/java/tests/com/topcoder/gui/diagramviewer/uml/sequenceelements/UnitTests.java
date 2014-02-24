/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.EmptyArrowEdgeEndingTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.FilledArrowEdgeEndingTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.HalfEmptyArrowEdgeEndingTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.NothingEdgeEndingTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgelayout.DefaultEdgeLayoutStrategyTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifeLineTest;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegmentTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * <p>
 * Change for 1.1:add unit tests on LifeLine,LifelineSegment and DefaultEdgeLayoutStrategy.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
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

        // tests for package com.topcoder.gui.diagramviewer.uml.sequenceelements
        suite.addTest(AsynchronousMessageEdgeTests.suite());
        suite.addTest(ResizeEventTests.suite());
        suite.addTest(SequenceElementsConfigurationExceptionTests.suite());
        suite.addTest(EditNameEventTests.suite());
        suite.addTest(SendSignalMessageEdgeTests.suite());
        suite.addTest(SetNameEventTests.suite());
        suite.addTest(UtilTests.suite());
        suite.addTest(ReturnMessageEdgeTests.suite());
        suite.addTest(ObjectNodeTests.suite());
        suite.addTest(SynchronousMessageEdgeTests.suite());
        suite.addTest(SequenceEdgeTests.suite());
        suite.addTest(EditControlHandlerTests.suite());
        suite.addTest(CreateMessageEdgeTests.suite());
        suite.addTest(EdgeLayoutExceptionTests.suite());

        // tests for package com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings
        suite.addTest(HalfEmptyArrowEdgeEndingTests.suite());
        suite.addTest(FilledArrowEdgeEndingTests.suite());
        suite.addTest(ConfiguredEdgeEndingTests.suite());
        suite.addTest(EmptyArrowEdgeEndingTests.suite());
        suite.addTest(NothingEdgeEndingTests.suite());

        // tests for com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline
        suite.addTest(LifeLineTest.suite());
        suite.addTest(LifelineSegmentTest.suite());
        
        //tests for com.topcoder.gui.diagramviewer.uml.sequenceelements.edgelayout
        suite.addTest(DefaultEdgeLayoutStrategyTests.suite());
        
        // tests for demo
        suite.addTest(DemoTests.suite());

        return suite;
    }

}
