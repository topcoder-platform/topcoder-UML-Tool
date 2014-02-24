/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.DiagramElementUndoableAction;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * This is the failure test cases for DiagramElementUndoableAction class.
 * Since DiagramElementUndoableAction is abstract class, we create a subclass for it to test.
 * 
 * @author Xuchen
 * @version 1.0
 */
public class DiagramElementUndoableActionFailureTest extends TestCase {

    /** The DiagramElementUndoableAction instance used for testing. */
    private DiagramElementUndoableAction action;
    
    /** The GraphElement instance used for testing. */ 
    private GraphElement element;
    
    /**
     * Set up the testing environment.
     */
    protected void setUp() {
        element = new GraphNode();
        action = new DiagramElementUndoableActionSubClass(element);
    }
    
    /**
     * Test redo() method when it can not redo.
     * It should throw CannotRedoException.
     */
    public void testRedo() {
        try {
            action.redo();
            fail("It should CannotRedoException.");
        } catch (CannotRedoException e) {
            // success
        }
    }
    
    /**
     * Test undo() method when it can not undo.
     * It should throw CannotUndoException.
     */
    public void testUndo() {
        try {
            action.undo();
            fail("It should CannotUndoException.");
        } catch (CannotUndoException e) {
            // success
        }
    }
    
    /**
     * Test die() method.
     * It should throw UnsupportedOperationException.
     */
    public void testDie() {
        try {
            action.die();
            fail("It should UnsupportedOperationException.");
        } catch (UnsupportedOperationException e) {
            // success
        }        
    }
    
    /**
     * Test isSignificant() method.
     * It should throw UnsupportedOperationException.
     */
    public void testIsSignificant() {
        try {
            action.isSignificant();
            fail("It should UnsupportedOperationException.");
        } catch (UnsupportedOperationException e) {
            // success
        }        
    }
    
    /**
     * Test addEdit() method.
     * It should throw UnsupportedOperationException.
     */
    public void testAddEdit() {
        try {
            action.addEdit(null);
            fail("It should UnsupportedOperationException.");
        } catch (UnsupportedOperationException e) {
            // success
        }        
    }
    
    /**
     * Test replaceEdit() method.
     * It should throw UnsupportedOperationException.
     */
    public void testReplaceEdit() {
        try {
            action.replaceEdit(null);
            fail("It should UnsupportedOperationException.");
        } catch (UnsupportedOperationException e) {
            // success
        }        
    }
    
    /**
     * Test getUndoPresentationName() method.
     * It should throw UnsupportedOperationException.
     */
    public void testGetUndoPresentationName() {
        try {
            action.getUndoPresentationName();
            fail("It should UnsupportedOperationException.");
        } catch (UnsupportedOperationException e) {
            // success
        }        
    }
    
    /**
     * Test getRedoPresentationName() method.
     * It should throw UnsupportedOperationException.
     */
    public void testGetRedoPresentationName() {
        try {
            action.getRedoPresentationName();
            fail("It should UnsupportedOperationException.");
        } catch (UnsupportedOperationException e) {
            // success
        }        
    }
    
    /**
     * Test getPresentationName() method.
     * It should throw UnsupportedOperationException.
     */
    public void testGetPresentationName() {
        try {
            action.getPresentationName();
            fail("It should UnsupportedOperationException.");
        } catch (UnsupportedOperationException e) {
            // success
        }        
    }
    
    /**
     * Test setLastException() method.
     * It should throw IllegalArgumentException.
     */
    public void testSetLastException() {
        try {
            ((DiagramElementUndoableActionSubClass) action).setLastException(null);
            fail("It should IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }        
    }
    
    /**
     * A simple DiagramElementUndoableAction subclass which is used for testing purpose.
     * 
     * @author Xuchen
     * @version 1.0
     */
    class DiagramElementUndoableActionSubClass extends DiagramElementUndoableAction {
    
        /**
         * Create DiagramElementUndoableActionSubClass instance.
         * @param element the element to be processed
         */
        public DiagramElementUndoableActionSubClass(GraphElement element) {
            super(element);
        }
        
        /**
         * Empty execute.
         */
        public void execute() {
            // empty
        }
        
        /**
         * Wrap inner setLastException method.
         * @param exception the exception to set 
         * @throws IllegalArgumentException thrown if the exception is null
         */
        public void setLastException(ActionExecutionException exception) {
            super.setLastException(exception);
        }
    }
}
