/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Tool_Actions_-_Diagram_Actions Version 1.0 Accuracytests.
 *
 * @ UndoableAbstractActionAccuracyTests.java
 */
package com.topcoder.uml.actions.diagram.accuracytests;

import com.topcoder.uml.actions.diagram.CreateDiagramAction;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>UndoableAbstractAction</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>UndoableAbstractAction</code> class.
 * </p>
 *
 * @author icyriver
 * @version 1.0
 */
public class UndoableAbstractActionAccuracyTests extends TestCase {
    /**
     * <p>
     * Represents the presentation name of the <code>UndoableAbstractAction</code>
     * uses for accuracy tests.
     * </p>
     */
    private static final String name = "Create class diagram title";

    /**
    * <p>
    * Represents an instance of <code>UndoableAbstractAction</code> uses for accuracy tests.
    * </p>
    */
    private CreateDiagramAction test = null;

    /**
     * <p>
     * Represents an instance of <code>Element</code> uses for accuracy tests.
     * </p>
     */
    private Element element = null;

    /**
     * <p>
     * Represents an instance of <code>UMLModelManager</code> uses for accuracy tests.
     * </p>
     */
    private UMLModelManager manager = null;

    /**
     * <p>
     * Test suite of <code>UndoableAbstractActionAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>UndoableAbstractActionAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(UndoableAbstractActionAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        manager = UMLModelManager.getInstance();
        TestHelper.configUMLModelManager();
        TestHelper.loadLogFile();
        element = new MethodImpl();
        test = new MockCreateDiagramAction("class", element, "title");
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        // clean the ConfigManager.
        TestHelper.clearConfig();
        //  clean the UMLModelManager for test.
        manager.clearActivityGraphs();
        manager.clearDiagrams();
    }

    /**
     * <p>
     * Accuracy Test of the <code>UndoableAbstractAction(String)</code>
     * constructor.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUndoableAbstractActionCtor_Basic()
        throws Exception {
        // check for creating successful.
        assertNotNull("Create failed.", test);

        // check the presentationName of the UndoableAbstractAction.
        assertEquals("The presentationName should be equal.", name,
            test.getPresentationName());
        // check the redo presentationName of the UndoableAbstractAction.
        assertEquals("The redo presentationName should be equal.",
            "Redo " + name, test.getRedoPresentationName());
        // check the undo presentationName of the UndoableAbstractAction.
        assertEquals("The undo presentationName should be equal.",
            "Undo " + name, test.getUndoPresentationName());
    }

    /**
     * <p>
     * Accuracy Test of the <code>canRedo()</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCanRedo() throws Exception {
        assertFalse("Should init to false.", test.canRedo());
        test.execute();
        assertFalse("Should can not redo after execute.", test.canRedo());
        test.undo();
        assertTrue("Should can redo after undo.", test.canRedo());
    }

    /**
     * <p>
     * Accuracy Test of the <code>canUndo()</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCanUndo() throws Exception {
        assertFalse("Should init to false.", test.canUndo());
        test.execute();
        assertTrue("Should can undo after execute.", test.canUndo());
        test.undo();
        assertFalse("Should can not undo after undo.", test.canUndo());
        test.redo();
        assertTrue("Should can undo after redo.", test.canUndo());
    }

    /**
     * <p>
     * Accuracy Test of the <code>die()</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testDie() throws Exception {
        test.die();
        assertFalse("Should can not do anything after die.", test.canUndo());
        assertFalse("Should can not do anything after die.", test.canRedo());
    }

    /**
     * <p>
     * Accuracy Test of the <code>getPresentationName()</code> method,
     * <code>getRedoPresentationName()</code> method and <code>getUndoPresentationName()</code> method.
     * </p>
     */
    public void testPresentationName_Operation() {
        // check the presentationName of the UndoableAbstractAction.
        assertEquals("The presentationName should be equal.", name,
            test.getPresentationName());
        // check the redo presentationName of the UndoableAbstractAction.
        assertEquals("The redo presentationName should be equal.",
            "Redo " + name, test.getRedoPresentationName());
        // check the undo presentationName of the UndoableAbstractAction.
        assertEquals("The undo presentationName should be equal.",
            "Undo " + name, test.getUndoPresentationName());

        test = new MockCreateDiagramAction("new class", element, "new title");

        String newName = "Create new class diagram new title";
        //  check the presentationName of the UndoableAbstractAction.
        assertEquals("The presentationName should be equal.", newName,
            test.getPresentationName());
        // check the redo presentationName of the UndoableAbstractAction.
        assertEquals("The redo presentationName should be equal.",
            "Redo " + newName, test.getRedoPresentationName());
        // check the undo presentationName of the UndoableAbstractAction.
        assertEquals("The undo presentationName should be equal.",
            "Undo " + newName, test.getUndoPresentationName());
    }

    /**
     * <p>
     * Accuracy Test of the <code>isSignificant()</code> method.
     * </p>
     */
    public void testIsSignificant() {
        assertTrue("Should always returns true.", test.isSignificant());
    }

    /**
     * <p>
     * Accuracy Test of the <code>execute()</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testExecute() throws Exception {
        assertFalse("Should init to false.", test.canRedo());
        assertFalse("Should init to false.", test.canUndo());
        test.execute();
        assertFalse("Should can not redo after execute.", test.canRedo());
        assertTrue("Should can undo after execute.", test.canUndo());
    }

    /**
     * <p>
     * Accuracy Test of the <code>undo()</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUndo() throws Exception {
        assertFalse("Should init to false.", test.canRedo());
        assertFalse("Should init to false.", test.canUndo());

        test.execute();
        assertFalse("Should can not redo after execute.", test.canRedo());
        assertTrue("Should can undo after execute.", test.canUndo());

        test.undo();
        assertTrue("Should can redo after undo.", test.canRedo());
        assertFalse("Should can not undo after undo.", test.canUndo());
    }

    /**
     * <p>
     * Accuracy Test of the <code>redo()</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testRedo() throws Exception {
        assertFalse("Should init to false.", test.canRedo());
        assertFalse("Should init to false.", test.canUndo());

        test.execute();
        assertFalse("Should can not redo after execute.", test.canRedo());
        assertTrue("Should can undo after execute.", test.canUndo());

        test.undo();
        assertTrue("Should can redo after undo.", test.canRedo());
        assertFalse("Should can not undo after undo.", test.canUndo());

        test.redo();
        assertFalse("Should can not redo after redo.", test.canRedo());
        assertTrue("Should can undo after redo.", test.canUndo());
    }
}
