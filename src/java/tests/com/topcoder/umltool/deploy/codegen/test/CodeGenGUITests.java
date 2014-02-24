/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.codegen.test;

import java.awt.Robot;

import swingunit.extensions.ExtendedRobotEventFactory;
import swingunit.framework.EventPlayer;
import swingunit.framework.FinderMethodSet;
import swingunit.framework.Scenario;
import junit.framework.TestCase;

/**
 * <p>
 * Test Cases of Code Generation GUI.
 * </p>
 *
 * @author tweg
 * @version 1.0
 */
public class CodeGenGUITests extends TestCase {

    /** The scenario script used for testing. */
    private Scenario scenario;

    /** The scenario robot used for testing. */
    private Robot robot;

    /**
     * <p>
     * Test case number:1 REQ:3.1 Description: Verify presentation of generate menu element.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void test1() throws Exception {
        testNScenario("GUI1");
    }

    /**
     * <p>
     * Test case number:2 REQ:3.1 Description: Verify presentation of generate code menu element.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void test2() throws Exception {
        testNScenario("GUI2");
    }

    /**
     * <p>
     * Test case number:3 REQ:3.1 Description: Verify presentation of generate code sub window.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void test3() throws Exception {
        testNScenario("GUI3");
    }

    /**
     * <p>
     * Test case number:4 REQ:3.1 Description: Verify presentation of generate code sub window, through the
     * hotkey.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void test4() throws Exception {
        testNScenario("GUI4");
    }

    /**
     * <p>
     * Wrap method for run gui test scenarios.
     * </p>
     *
     * @param scenarioName the name of the scenario
     * @throws Exception if any error occurs
     */
    private void testNScenario(String scenarioName) throws Exception {
        if (robot == null) {
            robot = new Robot();
        }
        if (scenario == null) {
            scenario = new Scenario(new ExtendedRobotEventFactory(), new FinderMethodSet());
            scenario.read(TestHelper.getScriptBase() + "/GUITest.xml");
            String umlBase = TestHelper.getUMLBase();
            scenario.setTestSetting(scenarioName, "UML_BASE", umlBase);
        }
        EventPlayer player = new EventPlayer(scenario);
        player.run(robot, scenarioName);
    }
}
