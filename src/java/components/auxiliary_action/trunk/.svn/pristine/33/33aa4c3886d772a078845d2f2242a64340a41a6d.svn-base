/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AbstractRemoveGraphElementActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests;

import junit.framework.TestCase;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.uml.actions.auxiliary.failuretests.impls.AbstractRemoveGraphElementActionImpl;

import javax.swing.undo.CannotUndoException;

/**
 * <p>
 * This is a failure tests for <code>AbstractRemoveGraphElementAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AbstractRemoveGraphElementActionFailureTest extends TestCase {

    /**Name.*/
    private static final String NAME = "name";

    /**GraphElement that is used for testing.*/
    private GraphElement node;

    /**AbstractRemoveGraphElementAction instance that is used for testing.*/
    private AbstractRemoveGraphElementActionImpl action;

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
        action = new AbstractRemoveGraphElementActionImpl(NAME, node);
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
     * Tests constrctor AbstractRemoveGraphElementAction(name, node) if name is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfNameNull() {
        try {
            new AbstractRemoveGraphElementActionImpl(null, node);
            fail("IllegalArgumentException is expected because name cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constrctor AbstractRemoveGraphElementAction(name, node) if name is empty.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfNameEmpty() {
        try {
            node.setContainer(new GraphElement() {});
            new AbstractRemoveGraphElementActionImpl("   ", node);
            fail("IllegalArgumentException is expected because name cannot be empty.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constrctor AbstractRemoveGraphElementAction(name, node) if node is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfNodeNull() {
        try {
            new AbstractRemoveGraphElementActionImpl(NAME, null);
            fail("IllegalArgumentException is expected because node cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constrctor AbstractRemoveGraphElementAction(name, node) if node's container is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfNodeContainerNull() {
        try {
            new AbstractRemoveGraphElementActionImpl(NAME, new GraphElement() {});
            fail("IllegalArgumentException is expected because node's container cannot be null.");
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