/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
/**
 * <p>
 * Failure test for MessageUtil.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class MessageUtilFailureTest extends TestCase {

    /**
     * <p>
     * MessageUtil instance created for testing.
     * </p>
     */
    private MessageUtil util;

    /**
     * <p>
     * Stimulus instance created for testing.
     * </p>
     */
    private Stimulus stimulus;

    /**
     * <p>
     * Clipboard instance created for testing.
     * <p>
     */
    private Clipboard clipboard;

    /**
     * <p>
     * Loads the configuration files.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        util = new MessageUtil();
        clipboard = new Clipboard("clip");
    }

    /**
     * <p>
     * Unloads the configuration files.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        // empty
    }

    /**
     * <p>
     * Failure test for
     * <code>addStimulusToCollaboration(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddStimulusToCollaboration() {
        try {
            util.addStimulusToCollaboration(null);
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>removeStimulusFromCollaboration(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveStimulusFromCollaboration() {
        try {
            util.removeStimulusFromCollaboration(null);
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>addStimulusToClipboard(Stimulus stimulus, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddStimulusToClipboardNullStimulus() {
        try {
            util.addStimulusToClipboard(null, clipboard);
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>addStimulusToClipboard(Stimulus stimulus, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * clipboard is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddStimulusToClipboardNullClipboard() {
        try {
            util.addStimulusToClipboard(stimulus, null);
            fail("clipboard is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>copyStimulus(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCopyStimulus() {
        try {
            util.copyStimulus(null);
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>checkStimulusNamespace(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCheckStimulusNamespace() {
        try {
            util.checkStimulusNamespace(null);
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>checkCreateMessage(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is null, false is expected.
     * </p>
     */
    public void testCheckCreateMessage() {
        try {
            assertFalse("stimulus is null, IllegalArgumentException is expected.", util.checkCreateMessage(null));
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>checkSynchronousMessage(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCheckSynchronousMessage() {
        try {
            assertFalse("stimulus is null, IllegalArgumentException is expected.", util.checkSynchronousMessage(null));
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>checkAsynchronousMessage(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCheckAsynchronousMessage() {
        try {
            assertFalse("stimulus is null, IllegalArgumentException is expected.",
                    util.checkAsynchronousMessage(null));
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>checkSendSignalMessage(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCheckSendSignalMessage() {
        try {
            assertFalse("stimulus is null, IllegalArgumentException is expected.",
                    util.checkSendSignalMessage(null));
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>checkReturnMessage(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCheckReturnMessage() {
        try {
            assertFalse("stimulus is null, IllegalArgumentException is expected.",
                    util.checkReturnMessage(null));
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

}
