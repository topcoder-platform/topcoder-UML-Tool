/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.failuretests;

import java.awt.datatransfer.Transferable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.sequence.ObjectUndoableActionImpl;
import com.topcoder.uml.actions.model.sequence.SequenceConfigurationException;
import com.topcoder.uml.model.commonbehavior.instances.Object;
/**
 * <p>
 * Failure test for ObjectUndoableAction.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class ObjectUndoableActionFailureTest extends TestCase {

    /**
     * <p>
     * Loads the configuration files.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.loadConfig();
    }

    /**
     * <p>
     * Unloads the configuration files.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        Helper.unloadConfig();
    }

    /**
     * <p>
     * Failure Test for
     * <code>ObjectUndoableAction(Object object)</code>.
     * </p>
     * <p>
     * object is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1NullObject() {
        try {
            new ObjectUndoableActionImpl((Object) null);
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * <p>
     * Failure Test for
     * <code>ObjectUndoableAction(Object object)</code>.
     * </p>
     * <p>
     * object is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1NullStimulus() {
        try {
            new ObjectUndoableActionImpl((Transferable) null);
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (SequenceConfigurationException e) {
            fail("stimulus is null, IllegalArgumentException is expected.");
        }
    }

}
