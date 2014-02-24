/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.undo.CompoundEdit;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.log.Level;

/**
 * <p>
 * Unit tests for <code>UndoableAbstractAction</code>. It tests the constructor and the <code>execute</code> method.
 * </p>
 *
 * <p>
 * It uses com.topcoder.util.log.basic.BasicLog to log.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UndoableAbstractActionTest extends BaseTestCase {
    /**
     * <p>
     * String representing the name of the action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "PRESENTATION_NAME";

    /**
     * <p>
     * String representing the sample logging string.
     * </p>
     */
    private static final String SAMPLE_LOG = "sample log";

    /**
     * <p>
     * String representing configuration file using Jdk14Log.
     * </p>
     */
    private static final String JDK14_LOGGING_FILE = "jdk1.4Logging.xml";

    /**
     * <p>
     * UndoableAbstractAction instance used for testing.
     * </p>
     */
    private MockUndoableAbstractAction action;

    /**
     * <p>
     * ByteArrayOutputStream instance used for testing.
     * </p>
     */
    private ByteArrayOutputStream out;

    /**
     * <p>
     * The original System.out.
     * </p>
     */
    private PrintStream systemErr;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(UndoableAbstractActionTest.class);
    }

    /**
     * <p>
     * Sets up environment.
     * </p>
     * @throws Exception to Junit
     */
    public void setUp() throws Exception {
        super.setUp();
        action = new MockUndoableAbstractAction(PRESENTATION_NAME);
        out = new ByteArrayOutputStream();
        systemErr = System.err;
        System.setErr(new PrintStream(out));
    }

    /**
     * <p>
     * Tears Down environment.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void tearDown() throws Exception {
        super.tearDown();
        action = null;
        System.setErr(systemErr);
        try {
            out.close();
        } catch (IOException e) {
            // ignore
        }
        out = null;
    }

    /**
     * <p>
     * Tests constructor for 'UndoableAbstractAction(String)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that the UndoableAbstractAction instance is not null.
     * </p>
     */
    public void testUndoableAbstractAction() {
        assertNotNull("The UndoableAbstractAction instance should not be null.", action);
    }

    /**
     * <p>
     * Tests constructor for 'UndoableAbstractAction(String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the representName is null and expects IllegalArgumentException
     * </p>
     */
    public void testUndoableAbstractActionWithNullRepresentName() {
        try {
            new MockUndoableAbstractAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor for 'UndoableAbstractAction(String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the representName is empty and expects IllegalArgumentException
     * </p>
     */
    public void testUndoableAbstractActionWithEmptyRepresentName() {
        try {
            new MockUndoableAbstractAction("   ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests method for 'addEdit(UndoableEdit)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that UndoableAbstractAction.addEdit(UndoableEdit) is correct and it always returns false.
     * </p>
     */
    public void testAddEdit() {
        assertFalse("The addEdit method should return false.", action.addEdit(new CompoundEdit()));
    }

    /**
     * <p>
     * Tests method for 'addEdit(UndoableEdit)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the UndoableEdit is null and verify that UndoableAbstractAction.addEdit(UndoableEdit)
     * is correct and it always returns false.
     * </p>
     */
    public void testAddEditWithNullUndoableEdit() {
        assertFalse("The addEdit method should return false.", action.addEdit(null));
    }

    /**
     * <p>
     * Tests method for 'canRedo()' for accuracy.
     * </p>
     *
     * <p>
     * Verify that If the state is REDOABLE, the method return true; otherwise return false.
     * </p>
     */
    public void testCanRedo() {
        assertFalse("It is impossible to redo this operation.", action.canRedo());
    }

    /**
     * <p>
     * Tests method for 'canRedo()' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the state of the action is REDOABLE, the method return true.
     * </p>
     * @throws ActionExecutionException to Junit
     */
    public void testCanRedoWithCanRedo() throws ActionExecutionException {
        action.execute();
        action.undo();
        assertTrue("It is possible to redo this operation.", action.canRedo());
    }

    /**
     * <p>
     * Tests method for 'CanUndo()' for accuracy.
     * </p>
     *
     * <p>
     * Verify that If the state is UNDOABLE, the method return true; otherwise return false.
     * </p>
     */
    public void testCanUndo() {
        assertFalse("It is impossible to undo this operation.", action.canUndo());
    }

    /**
     * <p>
     * Tests method for 'CanUndo()' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the state of the action is UNDOABLE, the method return true.
     * </p>
     * @throws ActionExecutionException to Junit
     */
    public void testCanRedoWithCanUndo() throws ActionExecutionException {
        action.execute();
        assertTrue("It is possible to undo this operation.", action.canUndo());
    }

    /**
     * <p>
     * Tests method for 'die()' for accuracy.
     * </p>
     *
     * <p>
     * Verify that UndoableAbstractAction.die() is correct.
     * </p>
     */
    public void testDie() {
        action.die();
        assertFalse("It is impossible to undo this operation.", action.canUndo());
        assertFalse("It is impossible to redo this operation.", action.canRedo());
        try {
            action.execute();
            fail("It is impossible to execute this operation and ActionExecutionException is expected.");
        } catch (ActionExecutionException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests method for 'getPresentationName()' for accuracy.
     * </p>
     *
     * <p>
     * Verify that getPresentationName() is correct.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("The PRESENTATION_NAME of the action is incorrect.",
                PRESENTATION_NAME, action.getPresentationName());
    }

    /**
     * <p>
     * Tests method for 'getRedoPresentationName()' for accuracy.
     * </p>
     *
     * <p>
     * Verify that getRedoPresentationName() is correct.
     * </p>
     */
    public void testGetRedoPresentationName() {
        assertEquals("The PRESENTATION_NAME of the action is incorrect.",
                "Redo " + PRESENTATION_NAME, action.getRedoPresentationName());
    }

    /**
     * <p>
     * Tests method for 'getUndoPresentationName()' for accuracy.
     * </p>
     *
     * <p>
     * Verify that getUndoPresentationName() is correct.
     * </p>
     */
    public void testGetUndoPresentationName() {
        assertEquals("The PRESENTATION_NAME of the action is incorrect.",
                "Undo " + PRESENTATION_NAME, action.getUndoPresentationName());
    }

    /**
     * <p>
     * Tests method for 'isSignificant()' for accuracy.
     * </p>
     *
     * <p>
     * Verify that isSignificant() always returns true.
     * </p>
     */
    public void testIsSignificant() {
        assertTrue("The isSignificant() method should always return true", action.isSignificant());
    }

    /**
     * <p>
     * Tests method for 'replaceEdit(UndoableEdit)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that replaceEdit(UndoableEdit) always returns false.
     * </p>
     */
    public void testReplaceEdit() {
        assertFalse("The replaceEdit(UndoableEdit) method should always return false",
                action.replaceEdit(new CompoundEdit()));
    }

    /**
     * <p>
     * Tests method for 'replaceEdit(UndoableEdit)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the UndoableEdit is null and verifies that replaceEdit(UndoableEdit) always returns
     * false.
     * </p>
     */
    public void testReplaceEditWithNullEdit() {
        assertFalse("The replaceEdit(UndoableEdit) method should always return false", action.replaceEdit(null));
    }

    /**
     * <p>
     * Tests method for 'log(String)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that log(String) is correct.
     * </p>
     */
    public void testLogString() {
        action.log(SAMPLE_LOG);
        assertEquals("The logging string is incorrect.", SAMPLE_LOG + System.getProperty("line.separator"),
                out.toString());
    }

    /**
     * <p>
     * Tests method for 'log(String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the String is null and verifies that log(String) is correct.
     * </p>
     */
    public void testLogStringWithNullString() {
        action.log(null);
        assertEquals("The logging string is incorrect.", "null" + System.getProperty("line.separator"),
                out.toString());
    }

    /**
     * <p>
     * Tests method for 'log(String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the String is empty and verifies that log(String) is correct.
     * </p>
     */
    public void testLogStringWithEmptyString() {
        action.log("  ");
        assertEquals("The logging string is incorrect.", "  " + System.getProperty("line.separator"),
                out.toString());
    }

    /**
     * <p>
     * Tests method for 'log(String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that Level.WARNING is set which is higher than Level.INFO and verifies that log(String)
     * doesn't log anything.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testLogStringWithHigherLevel() throws Exception {
        // change to use JDK1.4 logger.
        ChangeToJDK14Configuration(java.util.logging.Level.WARNING);
        // The SAMPLE_LOG will not print out as the INFO Level is lower than WARNING,
        action.log(SAMPLE_LOG);
        assertEquals("The logging string is incorrect.", 0, out.toString().length());
    }

    /**
     * <p>
     * Tests method for 'logError(String)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that logError(String) is correct.
     * </p>
     */
    public void testLogError() {
        action.logError(SAMPLE_LOG);
        assertEquals("The logging string is incorrect.", SAMPLE_LOG + System.getProperty("line.separator"),
                out.toString());
    }

    /**
     * <p>
     * Tests method for 'logError(String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the String is null and verifies that logError(String) is correct.
     * </p>
     */
    public void testlogErrorStringWithNullString() {
        action.logError(null);
        assertEquals("The logging string is incorrect.", "null" + System.getProperty("line.separator"),
                out.toString());
    }

    /**
     * <p>
     * Tests method for 'logError(String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the String is empty and verifies that logError(String) is correct.
     * </p>
     */
    public void testlogErrorStringWithEmptyString() {
        action.logError("  ");
        assertEquals("The logging string is incorrect.", "  " + System.getProperty("line.separator"),
                out.toString());
    }

    /**
     * <p>
     * Tests method for 'logError(String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that Level.OFF is set and verifies that logError(String) doesn't log anything.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testLogStringWithLevelOFF() throws Exception {
        // change to use JDK1.4 logger.
        ChangeToJDK14Configuration(java.util.logging.Level.OFF);
        // The SAMPLE_LOG will not print out as the Level.OFF is set
        action.log(SAMPLE_LOG);
        assertEquals("The logging string is incorrect.", 0, out.toString().length());
    }

    /**
     * <p>
     * Tests method for 'log(Level, String)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that log(Level, String) is correct.
     * </p>
     */
    public void testLogLevelString() {
        action.log(Level.INFO, SAMPLE_LOG);
        assertEquals("The logging string is incorrect.", SAMPLE_LOG + System.getProperty("line.separator"),
                out.toString());
    }

    /**
     * <p>
     * Tests method for 'log(Level, String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the String is null and verifies that log(Level, String) is correct.
     * </p>
     */
    public void testLogLevelStringWithNullString() {
        action.log(Level.INFO, null);
        assertEquals("The logging string is incorrect.", "null" + System.getProperty("line.separator"),
                out.toString());
    }

    /**
     * <p>
     * Tests method for 'log(Level, String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the String is empty and verifies that log(Level, String) is correct.
     * </p>
     */
    public void testLogLevelStringWithEmptyString() {
        action.log(Level.INFO, "   ");
        assertEquals("The logging string is incorrect.", "   " + System.getProperty("line.separator"),
                out.toString());
    }

    /**
     * <p>
     * Tests method for 'log(Level, String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that Level.WARNING is set and verifies that log(Level, String) doesn't log anything.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testLogLevelStringWithHigerLevel() throws Exception {
        // change to use JDK1.4 logger.
        ChangeToJDK14Configuration(java.util.logging.Level.WARNING);
        // The SAMPLE_LOG will not print out as the Level.OFF is set
        action.log(Level.INFO, SAMPLE_LOG);
        assertEquals("The logging string is incorrect.", 0, out.toString().length());
    }

    /**
     * <p>
     * Tests method for 'execute()' for accuracy.
     * </p>
     *
     * <p>
     * Verify that execute() is correct and the executeAction() method is invoke.
     * </p>
     *
     * @throws ActionExecutionException to Junit
     */
    public void testExecute() throws ActionExecutionException {
        action.execute();
        assertEquals("The log string is incorrect.", action.getPresentationName()
                + System.getProperty("line.separator") , out.toString());
        assertTrue("The action should be undoable.", action.canUndo());
        assertNotNull("The ActionExecutionException should not be null.", action.getExecuteException());
    }

    /**
     * <p>
     * Tests method for 'execute()' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the action have already been executed and expects ActionExecutionException.
     * </p>
     * @throws ActionExecutionException to Junit
     */
    public void testExecuteHasBeenExecuted() throws ActionExecutionException {
        action.execute();
        out.reset();
        try {
            action.execute();
            fail("ActionExecutionException is expected.");
        } catch (ActionExecutionException e) {
            assertEquals("The log string is incorrect.",
                    "Can't execute " + action.getPresentationName() + " current state is UNDOABLE"
                    + System.getProperty("line.separator") , out.toString());
            // good
        }
    }

    /**
     * <p>
     * Tests method for 'execute()' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the action throws an ActionExecutionException and expects ActionExecutionException.
     * </p>
     * @throws ActionExecutionException to Junit
     */
    public void testExecuteWithException() throws ActionExecutionException {
        action.setThrowExecuteException(true);
        try {
            action.execute();
            fail("ActionExecutionException is expected.");
        } catch (ActionExecutionException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests method for 'undo()' for accuracy.
     * </p>
     *
     * <p>
     * Verify that undo() is correct and the undoAction() method is invoke.
     * </p>
     * @throws ActionExecutionException to Junit
     */
    public void testUndo() throws ActionExecutionException {
        action.execute();
        out.reset();
        action.undo();
        assertEquals("The log string is incorrect.", action.getUndoPresentationName()
                + System.getProperty("line.separator") , out.toString());
        assertTrue("The action should be redoable.", action.canRedo());
        assertNotNull("The UndoableActionException should not be null.", action.getUndoException());
    }

    /**
     * <p>
     * Tests method for 'undo()' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the action is not undoable and verifies no exception will be thrown and the log string
     * is correct.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testUndoCannotUndo() throws Exception {
        action.execute();
        out.reset();
        action.undo();
        out.reset();
        // already undo, now undo again
        action.undo();
        assertEquals("The log string is incorrect.", "Can't " + action.getUndoPresentationName()
                + " current state is REDOABLE" + System.getProperty("line.separator") , out.toString());
    }

    /**
     * <p>
     * Tests method for 'undo()' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the action throws an UndoableActionException and verifies no UndoableActionException will
     * be thrown and the log string is correct.
     * </p>
     *
     * @throws ActionExecutionException to Junit
     */
    public void testUndoWithException() throws ActionExecutionException {
        action.setThrowUndoException(true);
        action.execute();
        out.reset();
        action.undo();
        assertEquals("The log string is incorrect.", action.getUndoException().getMessage()
                + System.getProperty("line.separator") , out.toString());
    }

    /**
     * <p>
     * Tests method for 'redo()' for accuracy.
     * </p>
     *
     * <p>
     * Verify redo() is correct and the redoAction() method is invoke.
     * </p>
     * @throws ActionExecutionException to Junit
     */
    public void testRedo() throws ActionExecutionException {
        action.execute();
        out.reset();
        action.undo();
        out.reset();
        action.redo();
        assertEquals("The log string is incorrect.", action.getRedoPresentationName()
                + System.getProperty("line.separator") , out.toString());
        assertTrue("The action should be undoable.", action.canUndo());
        assertNotNull("The UndoableActionException should not be null.", action.getRedoException());
    }

    /**
     * <p>
     * Tests method for 'redo()' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the action is not redoable and verifies no exception will be thrown and the log string
     * is correct.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testRedoCannotRedo() throws Exception {
        action.execute();
        out.reset();
        action.redo();
        assertEquals("The log string is incorrect.", "Can't " + action.getRedoPresentationName()
                + " current state is UNDOABLE" + System.getProperty("line.separator") , out.toString());
    }

    /**
     * <p>
     * Tests method for 'redo()' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the action throws an UndoableActionException and verifies no UndoableActionException will
     * be thrown and the log string is correct.
     * </p>
     *
     * @throws ActionExecutionException to Junit
     */
    public void testRedoWithException() throws ActionExecutionException {
        action.setThrowRedoException(true);
        action.execute();
        out.reset();
        action.undo();
        out.reset();
        action.redo();
        assertEquals("The log string is incorrect.", action.getRedoException().getMessage()
                + System.getProperty("line.separator") , out.toString());
    }

    /**
     * <p>
     * Tests method for 'undoAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify that undoAction() is correct.
     * </p>
     *
     * @throws UndoableActionException to Junit
     */
    public void testUndoAction() throws UndoableActionException {
        action.undoAction();
        assertNotNull("The undoAction should be invoked.", action.getUndoException());
    }

    /**
     * <p>
     * Tests method for 'undoAction()' for failure.
     * </p>
     *
     * <p>
     * It tests the case that undoAction throw a UndoableActionException and expects UndoableActionException.
     * </p>
     *
     * @throws UndoableActionException to Junit
     */
    public void testUndoActionWithException() throws UndoableActionException {
        action.setThrowUndoException(true);
        try {
            action.undoAction();
            fail("UndoableActionException is expected.");
        } catch (UndoableActionException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests method for 'redoAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify that redoAction() is correct.
     * </p>
     *
     * @throws UndoableActionException to Junit
     */
    public void testRedoAction() throws UndoableActionException {
        action.redoAction();
        assertNotNull("The redoAction should be invoked.", action.getRedoException());
    }

    /**
     * <p>
     * Tests method for 'redoAction()' for failure.
     * </p>
     *
     * <p>
     * It tests the case that redoAction throw a UndoableActionException and expects UndoableActionException.
     * </p>
     *
     * @throws UndoableActionException to Junit
     */
    public void testRedoActionWithException() throws UndoableActionException {
        action.setThrowRedoException(true);
        try {
            action.redoAction();
            fail("UndoableActionException is expected.");
        } catch (UndoableActionException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests method for 'executeAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify that executeAction() is correct.
     * </p>
     *
     * @throws ActionExecutionException to Junit
     */
    public void testExecuteAction() throws ActionExecutionException {
        action.executeAction();
        assertNotNull("The executeAction should be invoked.", action.getExecuteException());
    }

    /**
     * <p>
     * Tests method for 'executeAction()' for failure.
     * </p>
     *
     * <p>
     * It tests the case that executeAction throw a ActionExecutionException and expects ActionExecutionException.
     * </p>
     *
     * @throws ActionExecutionException to Junit
     */
    public void testExecuteActionWithException() throws ActionExecutionException {
        action.setThrowExecuteException(true);
        try {
            action.executeAction();
            fail("ActionExecutionException is expected.");
        } catch (ActionExecutionException e) {
            // good
        }
    }

    /**
     * <p>
     * Change the configuration to Jdk1.4 configuration using Jdk14Log and create the new UndoableAbstractAction.
     * It also set the java.util.logging.Level.
     * </p>
     *
     * @param level the Level to set
     *
     * @throws Exception to Junit
     */
    private void ChangeToJDK14Configuration(java.util.logging.Level level) throws Exception {
        // change to use JDK1.4 logger.
        ConfigManager configManager = ConfigManager.getInstance();
        configManager.removeNamespace(LOG_NAMESPACE);
        configManager.add(JDK14_LOGGING_FILE);
        action = new MockUndoableAbstractAction(PRESENTATION_NAME);
        Logger logger = LogManager.getLogManager().getLogger(MockUndoableAbstractAction.class.getName());
        logger.setLevel(level);
    }
}
