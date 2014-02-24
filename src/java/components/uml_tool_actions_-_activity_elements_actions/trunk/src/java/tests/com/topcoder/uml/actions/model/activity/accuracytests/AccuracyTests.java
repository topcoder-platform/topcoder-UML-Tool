/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.actions.model.activity.ActivityObjectClipboardUtilityAccuracyTests;
import com.topcoder.uml.actions.model.activity.ActivityObjectCloneUtilityAccuracyTests;

/**
 * This class aggregates all accuracy test cases for the component UML Tool Actions - Activity Elements Actions.
 *
 * @author ch_music
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    /**
     * Returns a Test object containing all the accuracy tests.
     *
     * @return a Test object containing all the accuracy tests
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(new TestSuite(AbstractActivityUndoableActionAccuracyTests.class));
        suite.addTest(new TestSuite(ActivityDataFlavorAccuracyTests.class));
        suite.addTest(new TestSuite(ActivityObjectClipboardUtilityAccuracyTests.class));
        suite.addTest(new TestSuite(ActivityObjectCloneExceptionAccuracyTests.class));
        suite.addTest(new TestSuite(ActivityObjectCloneUtilityAccuracyTests.class));
        suite.addTest(new TestSuite(ActivityObjectSelectionAccuracyTests.class));

        suite.addTest(new TestSuite(AddStateNodeAbstractActionAccuracyTests.class));
        suite.addTest(new TestSuite(AddStateNodeAbstractActionImplementationsAccuracyTests.class));
        suite.addTest(new TestSuite(AddTransitionActionAccuracyTests.class));

        suite.addTest(new TestSuite(CopyStateNodeAbstractActionAccuracyTests.class));
        suite.addTest(new TestSuite(CopyStateNodeAbstractActionImplementationsAccuracyTests.class));
        suite.addTest(new TestSuite(CopyTransitionActionAccuracyTests.class));

        suite.addTest(new TestSuite(CutStateNodeAbstractActionAccuracyTests.class));
        suite.addTest(new TestSuite(CutStateNodeAbstractActionImplementationsAccuracyTests.class));
        suite.addTest(new TestSuite(CutTransitionActionAccuracyTests.class));

        suite.addTest(new TestSuite(PasteStateNodeAbstractActionAccuracyTests.class));
        suite.addTest(new TestSuite(PasteStateNodeAbstractActionImplementationsAccuracyTests.class));
        suite.addTest(new TestSuite(PasteTransitionActionAccuracyTests.class));

        suite.addTest(new TestSuite(RemoveStateNodeAbstractActionAccuracyTests.class));
        suite.addTest(new TestSuite(RemoveStateNodeAbstractActionImplementationsAccuracyTests.class));
        suite.addTest(new TestSuite(RemoveTransitionActionAccuracyTests.class));

        return suite;
    }
}
