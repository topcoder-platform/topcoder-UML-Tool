/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.AsynchronousMessageEdgeAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.CreateMessageEdgeAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNodeAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ReturnMessageEdgeAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SendSignalMessageEdgeAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdgeAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SynchronousMessageEdgeAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.EmptyArrowEdgeEndingAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.FilledArrowEdgeEndingAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.HalfEmptyArrowEdgeEndingAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.NothingEdgeEndingAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineAccuracyTest;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegmentAccuracyTest;

/**
 * <p>
 * This class aggregates all accuracy tests for the component Diagram UML Sequence Elements. The version tested is
 * 1.0.
 * </p>
 *
 * @author ch_music, RachaelLCook
 * @version 1.1
 */
public class AccuracyTests extends TestCase {

    /**
     * Returnes a Test object containing all the accuracy tests.
     *
     * @return a Test object containing all the accuracy tests
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(new TestSuite(AsynchronousMessageEdgeAccuracyTests.class));
        suite.addTest(new TestSuite(CreateMessageEdgeAccuracyTests.class));
        suite.addTest(new TestSuite(EditControlHandlerAccuracyTests.class));
        suite.addTest(new TestSuite(EditNameEventAccuracyTests.class));
        suite.addTest(new TestSuite(ObjectNodeAccuracyTests.class));
        suite.addTest(new TestSuite(ResizeEventAccuracyTests.class));
        suite.addTest(new TestSuite(ReturnMessageEdgeAccuracyTests.class));
        suite.addTest(new TestSuite(SendSignalMessageEdgeAccuracyTests.class));
        suite.addTest(new TestSuite(SequenceEdgeAccuracyTests.class));
        suite.addTest(new TestSuite(SequenceElementsConfigurationExceptionAccuracyTests.class));
        suite.addTest(new TestSuite(SetNameEventAccuracyTests.class));
        suite.addTest(new TestSuite(SynchronousMessageEdgeAccuracyTests.class));

        suite.addTest(new TestSuite(ConfiguredEdgeEndingAccuracyTests.class));
        suite.addTest(new TestSuite(EmptyArrowEdgeEndingAccuracyTests.class));
        suite.addTest(new TestSuite(FilledArrowEdgeEndingAccuracyTests.class));
        suite.addTest(new TestSuite(HalfEmptyArrowEdgeEndingAccuracyTests.class));
        suite.addTest(new TestSuite(NothingEdgeEndingAccuracyTests.class));

        suite.addTest(new TestSuite(DefaultEdgeLayoutStrategyAccuracyTests.class));
        suite.addTest(new TestSuite(LifelineAccuracyTest.class));
        suite.addTest(new TestSuite(LifelineSegmentAccuracyTest.class));

        return suite;
    }
}
