/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AbstractPasteGraphElementActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests;

import junit.framework.TestCase;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.failuretests.impls.AbstractPasteGraphElementActionImpl;

import javax.swing.undo.CannotUndoException;

/**
 * <p>
 * This is a failure tests for <code>AbstractPasteGraphElementAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AbstractPasteGraphElementActionFailureTest extends TestCase {

    /**Name.*/
    private static final String NAME = "name";

    /**GraphElement that is used for testing.*/
    private GraphElement child;

    /**GraphNode that is used for testing.*/
    private GraphNode parent;

    /**AbstractPasteGraphElementAction instance that will be tested.*/
    private AbstractPasteGraphElementActionImpl action;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        Helper.clearNamespace();
        Helper.initNamespace();

        child = new GraphElement() {};
        parent = new GraphNode();
        action = new AbstractPasteGraphElementActionImpl(NAME, child, parent);
    }

    /**
     * <p>
     * Tear down.
     * </p>
     *
     * @throws Exception exception
     */
    public void tearDown() throws Exception {
        Helper.clearNamespace();
    }

    /**
     * <p>
     * Tests constrctor AbstractPasteGraphElementAction(name, content, parent) if name is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfNameNull() {
        try {
            new AbstractPasteGraphElementActionImpl(null, child, parent);
            fail("IllegalArgumentException is expected because name cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constrctor AbstractPasteGraphElementAction(name, content, parent) if name is empty.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfNameEmpty() {
        try {
            new AbstractPasteGraphElementActionImpl("   ", child, parent);
            fail("IllegalArgumentException is expected because name cannot be empty.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constrctor AbstractPasteGraphElementAction(name, content, parent) if content is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfContentNull() {
        try {
            new AbstractPasteGraphElementActionImpl(NAME, null, parent);
            fail("IllegalArgumentException is expected because content cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constrctor AbstractPasteGraphElementAction(name, content, parent) if content is not instance
     * of GrappElement.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfContentInvalid() {
        try {
            new AbstractPasteGraphElementActionImpl(NAME, new Object(), parent);
            fail("IllegalArgumentException is expected because content must be instance of GrappElement.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constrctor AbstractPasteGraphElementAction(name, content, parent) if parent is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfParentNull() {
        try {
            new AbstractPasteGraphElementActionImpl(NAME, child, null);
            fail("IllegalArgumentException is expected because parent cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method undo() if action is already dead.
     * CannotUndoException is expected.
     * </p>
     */
    public void testUndoIfDead() {
        action.die();
        try {
            action.undo();
            fail("CannotUndoException is expected because action is already dead.");
        } catch (CannotUndoException e) {
            //success
        }
    }
}