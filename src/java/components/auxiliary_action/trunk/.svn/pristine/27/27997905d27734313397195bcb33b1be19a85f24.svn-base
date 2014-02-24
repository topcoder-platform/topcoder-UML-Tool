/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AbstractCutGraphElementActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests;

import junit.framework.TestCase;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.uml.actions.auxiliary.failuretests.impls.AbstractCutGraphElementActionImpl;

import javax.swing.undo.CannotUndoException;

/**
 * <p>
 * This is a failure tests for <code>AbstractCutGraphElementAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AbstractCutGraphElementActionFailureTest extends TestCase {

    /**Name.*/
    private static final String NAME = "name";

    /**GraphElement that is used for testing.*/
    private GraphElement node;

    /**AbstractCutGraphElementAction instance that is used for testing.*/
    private AbstractCutGraphElementActionImpl action;

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

        node = new GraphElement() {};
        node.setContainer(new GraphElement() {});
        action = new AbstractCutGraphElementActionImpl(NAME, node, null);
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
     * Tests constrctor AbstractCutGraphElementAction(name, node, clipboard) if name is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfNameNull() {
        try {
            new AbstractCutGraphElementActionImpl(null, node, null);
            fail("IllegalArgumentException is expected because name cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constrctor AbstractCutGraphElementAction(name, node, clipboard) if name is empty.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfNameEmpty() {
        try {
            new AbstractCutGraphElementActionImpl("   ", node, null);
            fail("IllegalArgumentException is expected because name cannot be empty.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constrctor AbstractCutGraphElementAction(name, node, clipboard) if node is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfNodeNull() {
        try {
            new AbstractCutGraphElementActionImpl(NAME, null, null);
            fail("IllegalArgumentException is expected because node cannot be null.");
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