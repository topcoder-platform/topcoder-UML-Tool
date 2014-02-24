/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


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
     * The unit test suite.
     *
     * @return the test suite.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTest(ActorUtilTest.suite());
        suite.addTest(AddActionTest.suite());
        suite.addTest(AddActorActionTest.suite());
        suite.addTest(AddExtendActionTest.suite());
        suite.addTest(AddIncludeActionTest.suite());
        suite.addTest(AddSubsystemActionTest.suite());
        suite.addTest(AddUseCaseActionTest.suite());
        suite.addTest(CopyActionTest.suite());
        suite.addTest(CopyActorActionTest.suite());
        suite.addTest(CopyExtendActionTest.suite());
        suite.addTest(CopyIncludeActionTest.suite());
        suite.addTest(CopySubsystemActionTest.suite());
        suite.addTest(CopyUseCaseActionTest.suite());
        suite.addTest(CutActionTest.suite());
        suite.addTest(CutActorActionTest.suite());
        suite.addTest(CutExtendActionTest.suite());
        suite.addTest(CutIncludeActionTest.suite());
        suite.addTest(CutSubsystemActionTest.suite());
        suite.addTest(CutUseCaseActionTest.suite());
        suite.addTest(ExtendUtilTest.suite());
        suite.addTest(IncludeUtilTest.suite());
        suite.addTest(InvalidDataContentExceptionTest.suite());
        suite.addTest(ModelTransferTest.suite());
        suite.addTest(PasteActionTest.suite());
        suite.addTest(PasteActorActionTest.suite());
        suite.addTest(PasteExtendActionTest.suite());
        suite.addTest(PasteIncludeActionTest.suite());
        suite.addTest(PasteSubsystemActionTest.suite());
        suite.addTest(PasteUseCaseActionTest.suite());
        suite.addTest(RemoveActionTest.suite());
        suite.addTest(RemoveActorActionTest.suite());
        suite.addTest(RemoveExtendActionTest.suite());
        suite.addTest(RemoveIncludeActionTest.suite());
        suite.addTest(RemoveSubsystemActionTest.suite());
        suite.addTest(RemoveUseCaseActionTest.suite());
        suite.addTest(SubsystemUtilTest.suite());
        suite.addTest(UsecaseToolUtilTest.suite());
        suite.addTest(UsecaseUndoableActionTest.suite());
        suite.addTest(UseCaseUtilTest.suite());

        suite.addTest(Demo.suite());

        return suite;
    }
}
