/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Accuracy tests for the ZUML to TCUML Converter Sequence Diagrams component.
 *
 * @author RachaelLCook
 * @version 1.0
 */

public class AccuracyTests extends TestCase {
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(EventOccurrenceImplTests.class);
        suite.addTestSuite(LifelineImplTests.class);
        suite.addTestSuite(InteractionImplTests.class);
        suite.addTestSuite(MessageImplTests.class);
        suite.addTestSuite(XMISequenceDiagramConverterUtilTests.class);
        return suite;
    }
}
