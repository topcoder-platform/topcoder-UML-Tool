/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

import java.util.List;

import com.topcoder.util.log.Level;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ActionManager.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class ActionManagerTests extends TestCase {
    /**
     * <p>
     * ActionManager instance for testing.
     * </p>
     */
    private ActionManager manager;

    /**
     * <p>
     * AddClassDiagramAction instance for helping testing.
     * </p>
     */
    private AddClassDiagramAction diagramAction;

    /**
     * <p>
     * AddClassMemberAction instance for helping testing.
     * </p>
     */
    private AddClassMemberAction memberAction;

    /**
     * <p>
     * The Log instance for helping testing.
     * </p>
     */
    private MyLogger logger;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        logger = new MyLogger("MyLogger");
        diagramAction = new AddClassDiagramAction();
        memberAction = new AddClassMemberAction();
        manager = new ActionManager();

        System.setProperty("isSignificant", "true");
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        diagramAction = null;
        memberAction = null;
        manager = null;

        System.clearProperty("isSignificant");
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ActionManagerTests.class);
    }

    /**
     * <p>
     * Tests ctor ActionManager#ActionManager(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1() throws Exception {
        try {
            TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);
            TestHelper.loadSingleXMLConfig("action_manager", "test_files/config.xml");

            assertNotNull("Failed to create a new ActionManager instance.", new ActionManager("action_manager"));
        } finally {
            TestHelper.clearConfigFile(TestHelper.LOG_NAMESPACE);
            TestHelper.clearConfigFile("action_manager");
        }

    }

    /**
     * <p>
     * Tests ctor ActionManager#ActionManager(String) for failure.
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_NullNamespace() throws Exception {
        try {
            new ActionManager(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ActionManager#ActionManager(String) for failure.
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_EmptyNamespace() throws Exception {
        try {
            new ActionManager("  ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ActionManager#ActionManager(String) for failure.
     * It tests the case when the namespace is not configed and expects for ActionManagerConfigurationException.
     * </p>
     */
    public void testCtor1_ActionManagerConfigurationException() {
        try {
            new ActionManager("namespace");
            fail("ActionManagerConfigurationException expected.");
        } catch (ActionManagerConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ActionManager#ActionManager(String) for failure.
     * It tests the case when MaximumUndoableActions property value is not an integer and
     * expects for ActionManagerConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_NotIntegerMaximumUndoableActions1() throws Exception {
        try {
            TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);
            TestHelper.loadSingleXMLConfig("action_manager", "test_files/NotInteger_MaximumUndoableActions.xml");

            new ActionManager("action_manager");
            fail("ActionManagerConfigurationException expected.");
        } catch (ActionManagerConfigurationException e) {
            //good
        } finally {
            TestHelper.clearConfigFile(TestHelper.LOG_NAMESPACE);
            TestHelper.clearConfigFile("action_manager");
        }
    }

    /**
     * <p>
     * Tests ctor ActionManager#ActionManager(String) for failure.
     * It tests the case when the MaximumUndoableActions property value is negative and expects for
     * ActionManagerConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_NegativeMaximumUndoableActions() throws Exception {
        try {
            TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);
            TestHelper.loadSingleXMLConfig("action_manager", "test_files/Negative_MaximumUndoableActions.xml");

            new ActionManager("action_manager");
            fail("ActionManagerConfigurationException expected.");
        } catch (ActionManagerConfigurationException e) {
            //good
        } finally {
            TestHelper.clearConfigFile(TestHelper.LOG_NAMESPACE);
            TestHelper.clearConfigFile("action_manager");
        }
    }

    /**
     * <p>
     * Tests ctor ActionManager#ActionManager(String) for failure.
     * It tests the case when MaximumUndoableActions property is missing and expects for
     * ActionManagerConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_MaximumUndoableActionsMissing() throws Exception {
        try {
            TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);
            TestHelper.loadSingleXMLConfig("action_manager", "test_files/MaximumUndoableActions_Missing.xml");

            new ActionManager("action_manager");
            fail("ActionManagerConfigurationException expected.");
        } catch (ActionManagerConfigurationException e) {
            //good
        } finally {
            TestHelper.clearConfigFile(TestHelper.LOG_NAMESPACE);
            TestHelper.clearConfigFile("action_manager");
        }
    }

    /**
     * <p>
     * Tests ctor ActionManager#ActionManager(String) for accuracy.
     * It tests the case when the LoggerName property is missing and expects the construction of
     * ActionManager success.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_LoggerNameMissing() throws Exception {
        try {
            TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);
            TestHelper.loadSingleXMLConfig("action_manager", "test_files/LoggerName_Missing.xml");

            assertNotNull("Failed to create a new ActionManager instance", new ActionManager("action_manager"));

        } catch (ActionManagerConfigurationException e) {
            //good
        } finally {
            TestHelper.clearConfigFile(TestHelper.LOG_NAMESPACE);
            TestHelper.clearConfigFile("action_manager");
        }
    }

    /**
     * <p>
     * Tests ctor ActionManager#ActionManager(String) for accuracy.
     * It tests the case when the LoggingLevel property is missing and expects the construction of
     * ActionManager success.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_LoggingLevelMissing() throws Exception {
        try {
            TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);
            TestHelper.loadSingleXMLConfig("action_manager", "test_files/LoggingLevel_Missing.xml");

            assertNotNull("Failed to create a new ActionManager instance", new ActionManager("action_manager"));

        } catch (ActionManagerConfigurationException e) {
            //good
        } finally {
            TestHelper.clearConfigFile(TestHelper.LOG_NAMESPACE);
            TestHelper.clearConfigFile("action_manager");
        }
    }

    /**
     * <p>
     * Tests ctor ActionManager#ActionManager(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the LoggingLevel property value is invalid and expects
     * ActionManagerConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_InvalidLoggingLevel() throws Exception {
        try {
            TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);
            TestHelper.loadSingleXMLConfig("action_manager", "test_files/Invalid_LoggingLevel.xml");

            new ActionManager("action_manager");

        } catch (ActionManagerConfigurationException e) {
            //good
        } finally {
            TestHelper.clearConfigFile(TestHelper.LOG_NAMESPACE);
            TestHelper.clearConfigFile("action_manager");
        }
    }

    /**
     * <p>
     * Tests ctor ActionManager#ActionManager() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created ActionManager instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new ActionManager instance.", new ActionManager());
    }

    /**
     * <p>
     * Tests ctor ActionManager#ActionManager(int,Log,Level) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created ActionManager instance should not be null.
     * </p>
     */
    public void testCtor3() {
        assertNotNull("Failed to create a new ActionManager instance.", new ActionManager(100, logger, Level.ERROR));
    }

    /**
     * <p>
     * Tests ctor ActionManager#ActionManager(int,Log,Level) for accuracy.
     * It tests the case that when logger is null and expects success.
     * </p>
     */
    public void testCtor3_NullLogger() {
        assertNotNull("Failed to create a new ActionManager instance.", new ActionManager(100, null, Level.ERROR));

        assertNotNull("Failed to create a new ActionManager instance.", new ActionManager(100, null, null));
    }

    /**
     * <p>
     * Tests ctor ActionManager#ActionManager(int,Log,Level) for accuracy.
     * It tests the case that when loggingLevel is null and expects success.
     * </p>
     */
    public void testCtor3_NullLoggingLevel() {
        assertNotNull("Failed to create a new ActionManager instance.", new ActionManager(100, logger, null));
    }

    /**
     * <p>
     * Tests ctor ActionManager#ActionManager(int,Log,Level) for failure.
     * It tests the case that when loggingLevel is invalid and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor3_InvalidLoggingLevel() {
        try {
            new ActionManager(100, logger, Level.CONFIG);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActionManager#getUndoableActionToBeUndone() for accuracy.
     * </p>
     *
     * <p>
     * Verify : getUndoableActionToBeUndone() returns the correct action.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetUndoableActionToBeUndone() throws Exception {
        manager.executeAction(diagramAction);
        manager.executeAction(memberAction);

        Action action = manager.getUndoableActionToBeUndone();
        assertSame("Failed to get the correct action to be un-done.", memberAction, action);
    }

    /**
     * <p>
     * Tests ActionManager#getUndoableActionsToBeUndone() for accuracy.
     * </p>
     *
     * <p>
     * Verify : getUndoableActionsToBeUndone() returns the correct actions.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetUndoableActionsToBeUndone() throws Exception {
        manager.executeAction(diagramAction);
        manager.executeAction(memberAction);

        List<UndoableAction> actions = manager.getUndoableActionsToBeUndone();
        assertEquals("The size should be 2.", 2, actions.size());
        assertSame("Expects same action.", memberAction, actions.get(0));
        assertSame("Expects same action.", diagramAction, actions.get(1));
    }

    /**
     * <p>
     * Tests ActionManager#getUndoableActionToBeRedone() for accuracy.
     * </p>
     *
     * <p>
     * Verify : getUndoableActionToBeRedone() returns the correct action.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetUndoableActionToBeRedone() throws Exception {
        manager.executeAction(diagramAction);
        manager.executeAction(memberAction);

        manager.undoActions(memberAction);

        Action action = manager.getUndoableActionToBeRedone();
        assertSame("Failed to get the correct action to be re-done.", memberAction, action);
    }

    /**
     * <p>
     * Tests ActionManager#getUndoableActionsToBeRedone() for accuracy.
     * </p>
     *
     * <p>
     * Verify : getUndoableActionsToBeRedone() returns the correct actions.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetUndoableActionsToBeRedone() throws Exception {
        manager.executeAction(diagramAction);
        manager.executeAction(memberAction);

        manager.undoActions(diagramAction);

        List<UndoableAction> actions = manager.getUndoableActionsToBeRedone();
        assertEquals("The size should be 2.", 2, actions.size());
        assertSame("Expects same action.", diagramAction, actions.get(0));
        assertSame("Expects same action.", memberAction, actions.get(1));
    }

    /**
     * <p>
     * Tests ActionManager#undoActions(UndoableAction) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The undo() method of diagramAction should be called.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndoActions() throws Exception {
        manager.executeAction(diagramAction);

        manager.undoActions(diagramAction);

        assertTrue("The undo() method of diagramAction should be called.", diagramAction.isUndoCalled());
    }

    /**
     * <p>
     * Tests ActionManager#undoActions(UndoableAction) for failure.
     * It tests the case that when toAction is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndoActions_NullToAction() throws Exception {
        try {
            manager.undoActions(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActionManager#undoActions(UndoableAction) for failure.
     * It tests the case that when toAction is invalid and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndoActions_InvalidToAction() throws Exception {
        try {
            manager.undoActions(memberAction);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActionManager#redoActions(UndoableAction) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The redo() method of diagramAction should be called.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRedoActions() throws Exception {
        manager.executeAction(diagramAction);
        manager.undoActions(diagramAction);

        manager.redoActions(diagramAction);

        assertTrue("The redo() method of diagramAction should be called.", diagramAction.isRedoCalled());
    }

    /**
     * <p>
     * Tests ActionManager#redoActions(UndoableAction) for failure.
     * It tests the case that when toAction is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRedoActions_NullToAction() throws Exception {
        try {
            manager.redoActions(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActionManager#redoActions(UndoableAction) for failure.
     * It tests the case that when toAction is invalid and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRedoActions_InvalidToAction() throws Exception {
        try {
            manager.redoActions(memberAction);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActionManager#executeAction(Action) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The execute() method of memberAction should be called.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecuteAction() throws Exception {
        manager.executeAction(memberAction);

        assertTrue("The execute() method of memberAction should be called.", memberAction.isExecuted());
    }

    /**
     * <p>
     * Tests ActionManager#executeAction(Action) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the action to be executed is not of TransientAction or UndoableAction type
     * and expects all the edits be discarded.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecuteAction2() throws Exception {
        manager.executeAction(memberAction);
        manager.executeAction(new OpenProjectAction());

        assertEquals("All the edits should be discarded.", 0, manager.getUndoableActionsToBeUndone().size());
    }

    /**
     * <p>
     * Tests ActionManager#executeAction(Action) for failure.
     * It tests the case that when action is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecuteAction_NullAction() throws Exception {
        try {
            manager.executeAction(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActionManager#executeAction(Action) for failure.
     * It tests the case when the die() method has been called in the action to be executed and
     * expects ActionExecutionException.
     * </p>
     */
    public void testExecuteAction_ActionExecutionException() {
        TransientUndoableAction action = new TransientUndoableAction(new PrintClassDiagramAction(),
            "TransientUndoableAction");
        action.die();
        try {
            manager.executeAction(action);
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActionManager#executeAction(Action) for failure.
     * It tests the case when the execute() method of the given action throws exception and
     * expects ActionExecutionException.
     * </p>
     */
    public void testExecuteAction_ActionExecutionException2() {
        System.setProperty("execute", "exception");
        try {
            manager.executeAction(diagramAction);
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        } finally {
            System.clearProperty("execute");
        }
    }
}