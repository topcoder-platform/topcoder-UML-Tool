/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.codegen.test;

import java.awt.Robot;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import swingunit.extensions.ExtendedRobotEventFactory;
import swingunit.framework.EventPlayer;
import swingunit.framework.FinderMethodSet;
import swingunit.framework.Scenario;
import swingunit.framework.TestUtility;

/**
 * <p>
 * This test case aggregates all functional test cases for the <i>TopCoder UML Tool Code Generation</i>
 * tests.
 * </p>
 *
 * @author tweg
 * @version 1.0
 */
public class FunctionalTests extends TestCase {
    /**
     * Returns all functional test cases for the <i>TopCoder UML Tool Code Generation</i> tests.
     *
     * @return all test cases for the <i>TopCoder UML Tool Code Generation</i> tests
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(CTests.class);
        suite.addTestSuite(JavaTests.class);
        TestSetup wrapper = new TestSetup(suite) {
            protected void setUp() {
                try {
                    Scenario scenario = new Scenario(new ExtendedRobotEventFactory(), new FinderMethodSet());
                    Robot robot = new Robot();
                    scenario.read(TestHelper.getScriptBase() + "/GenerateCode.xml");

                    String umlBase = TestHelper.getUMLBase();
                    String codegenBase = TestHelper.getCodeGenBase();
                    scenario.setTestSetting("New scenario(1)", "UML_BASE", umlBase);
                    scenario.setTestSetting("New scenario(1)", "CODEGEN_BASE", codegenBase);
                    EventPlayer player = new EventPlayer(scenario);
                    player.run(robot, "New scenario(1)");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        TestUtility.waitForCalm();
                    } catch (InterruptedException e) {
                        // ignore the case.
                    }
                }
            }
        };

        return wrapper;
    }
}
