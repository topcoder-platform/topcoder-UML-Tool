/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.modelmanager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * UnitTest for UMLModelManager.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {
    /**
     * Add test suit to the unitTest.
     *
     * @return
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(UMLModelManagerTest.class);
        return suite;
    }

}
