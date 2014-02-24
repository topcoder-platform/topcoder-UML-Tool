/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager.failuretests;

import java.io.File;
import java.util.Iterator;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.ActionManager;
import com.topcoder.util.actionmanager.ActionManagerConfigurationException;
import com.topcoder.util.actionmanager.TransientUndoableAction;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.log.Level;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.LogFactory;

import junit.framework.TestCase;

/**
 * Failure test cases for class <code>ActionManager</code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class FailureTestActionManager extends TestCase {

    /**
     * Represents the ActionManager instance for testing.
     */
    private ActionManager manager = null;

    /**
     * Represents the Log instance for testing.
     */
    private static Log log = LogFactory.getLog();

    /**
     * Set up the environment.
     *
     * @throws Exception to junit.
     */
    public void setUp() throws Exception  {
       manager = new ActionManager();
       ConfigManager cm = ConfigManager.getInstance();
       for (Iterator iter = cm.getAllNamespaces(); iter.hasNext();) {
           cm.removeNamespace((String) iter.next());
       }
       cm.add(new File("test_files/failure/config.xml").getAbsolutePath());
    }

    /**
     * Tear down the environment.
     *
     * clear all the namespace in the config manager.
     * @throws Exception to junit.
     */
    public void tearDown() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        for (Iterator iter = cm.getAllNamespaces(); iter.hasNext();) {
            cm.removeNamespace((String) iter.next());
        }
    }

    /**
     * Test the constructor <code>ActionManager(String namespace) </code>.
     *
     * <p>
     * If namespace is null, or empty (trimed) , IllegalArgumentException should be thrown.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testActionManagerString_1() throws Exception {
        try {
            new ActionManager(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // oK.
        }
    }

    /**
     * Test the constructor <code>ActionManager(String namespace) </code>.
     *
     * <p>
     * If namespace is null, or empty (trimed) , IllegalArgumentException should be thrown.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testActionManagerString_2() throws Exception {
        try {
            new ActionManager("");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // oK.
        }
    }

    /**
     * Test the constructor <code>ActionManager(String namespace) </code>.
     *
     * <p>
     * If namespace is null, or empty (trimed) , IllegalArgumentException should be thrown.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testActionManagerString_3() throws Exception {
        try {
            new ActionManager("           ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // oK.
        }
    }


    /**
     * Test the constructor <code>ActionManager(String namespace) </code>.
     *
     * <p>
     * In this test case, the required config property MaximumUndoableActions is tested.
     * </p>
     *
     * <p>
     * If MaximumUndoableActions is < 1, ActionManagerConfigurationException should be thrown.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testActionManagerString_4() throws Exception {
        try {
            new ActionManager("invalidMaxnum1");
        } catch (ActionManagerConfigurationException e) {
            fail("ActionManagerConfigurationException is expected.");
        }
    }


    /**
     * Test the constructor <code>ActionManager(String namespace) </code>.
     *
     * <p>
     * In this test case, the required config property MaximumUndoableActions is tested.
     * </p>
     *
     * <p>
     * If MaximumUndoableActions is < 1, ActionManagerConfigurationException should be thrown.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testActionManagerString_5() throws Exception {
        try {
            new ActionManager("invalidMaxnum2");
            fail("ActionManagerConfigurationException is expected.");
        } catch (ActionManagerConfigurationException e) {
            // oK.
        }
    }


    /**
     * Test the constructor <code>ActionManager(String namespace) </code>.
     *
     * <p>
     * In this test case, the required config property MaximumUndoableActions is tested.
     * </p>
     *
     * <p>
     * If MaximumUndoableActions is < 1, ActionManagerConfigurationException should be thrown.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testActionManagerString_6() throws Exception {
        try {
            new ActionManager("invalidMaxnum3");
            fail("ActionManagerConfigurationException is expected.");
        } catch (ActionManagerConfigurationException e) {
            // oK.
        }
    }


    /**
     * Test the constructor <code>ActionManager(String namespace) </code>.
     *
     * <p>
     * In this test case, the required config property MaximumUndoableActions is tested.
     * </p>
     *
     * <p>
     * If MaximumUndoableActions number is not formatted as as an Integer,
     *  ActionManagerConfigurationException should be thrown.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testActionManagerString_7() throws Exception {
        try {
            new ActionManager("invalidMaxnum4");
            fail("ActionManagerConfigurationException is expected.");
        } catch (ActionManagerConfigurationException e) {
            // oK.
        }
    }

    /**
     * Test the constructor <code>ActionManager(String namespace) </code>.
     *
     * <p>
     * In this test case, the required config property MaximumUndoableActions is tested.
     * </p>
     *
     * <p>
     * If MaximumUndoableActions number is missing  ActionManagerConfigurationException should be thrown.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testActionManagerString_8() throws Exception {
        try {
            new ActionManager("invalidMaxnum5");
            fail("ActionManagerConfigurationException is expected.");
        } catch (ActionManagerConfigurationException e) {
            // oK.
        }
    }


    /**
     * Test the constructor <code>ActionManager(String namespace) </code>.
     *
     * <p>
     * If the logger name is not a supported one, ActionManagerConfigurationException should be thrown.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testActionManagerString_9() throws Exception {
        try {
            new ActionManager("invalidLogLevel");
            fail("ActionManagerConfigurationException is expected.");
        } catch (ActionManagerConfigurationException e) {
            // oK.
        }
    }

    /**
     * Test method <code>ActionManager(int maxUndoableActions, Log logger, Level loggingLevel) </code>.
     *
     * <p>
     * If the maxUndoableActions is < 1, IllegalArgumentException should be thrown.
     * </p>
     */
    public void testActionManagerintLogLevel_1() {
        try {
            new ActionManager(-1, null,  Level.ALL);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }


    /**
     * Test method <code>ActionManager(int maxUndoableActions, Log logger, Level loggingLevel) </code>.
     *
     * <p>
     * If the maxUndoableActions is < 1, IllegalArgumentException should be thrown.
     * </p>
     */
    public void testActionManagerintLogLevel_2() {
        try {
            new ActionManager(0, null,  Level.ALL);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }


    /**
     * Test method <code>ActionManager(int maxUndoableActions, Log logger, Level loggingLevel) </code>.
     *
     * <p>
     * If the loggingLevel is not supported such as Level.All,  IllegalArgumentException should be thrown.
     * </p>
     */
    public void testActionManagerintLogLevel_3() {
        try {
            new ActionManager(1, log,  Level.ALL);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }

    /**
     * Test method <code> void executeAction(Action action) </code>.
     *
     * @throws Exception to junit
     */
    public void testExecuteAction_1() throws Exception  {
        try {
            manager.executeAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }


    /**
     * Test method <code> void executeAction(Action action) </code>.
     *
     * @throws Exception to junit
     */
    public void testExecuteAction_2() throws Exception  {
        try {
            manager.executeAction(new MyTransientAction());
            fail("ActionExecutionException is expected.");
        } catch (ActionExecutionException e) {
            // Ok.
        }
    }

    /**
     * Test method <code>void undoActions(UndoableAction toAction) </code>.
     */
    public void testUndoActions_1() {
        try {
            manager.undoActions(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }

    /**
     * Test method <code>void undoActions(UndoableAction toAction) </code>.
     */
    public void testUndoActions_2() {
        try {
            manager.undoActions(new TransientUndoableAction(new MyTransientAction(), "name"));
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }

    /**
     * Test method <code>void redoActions(UndoableAction toAction) </code>.
     *
     */
    public void testRedoActions_1() {
        try {
            manager.redoActions(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }

    /**
     * Test method <code>void redoActions(UndoableAction toAction) </code>.
     */
    public void testRedoActions_2() {
        try {
            manager.redoActions(new TransientUndoableAction(new MyTransientAction(), "name"));
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }
}