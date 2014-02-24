/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * Aggregates all failure tests for UndoableAbstractAction class.
 * @author vilain
 * @version 1.0
 */
public class UndoableAbstractActionFailureTest extends TestCase {

    /**
     * Constructor under test UndoableAbstractAction(String). Failure testing of
     * exception in case presentation name is null.
     */
    public final void testUndoableAbstractActionFailureNull() {
        try {
            new UndoableAbstractAction(null) {
                public void executeAction() {
                }

                public void redoAction() {
                }

                public void undoAction() {
                }
            };
            fail("IllegalArgumentException is expected since presentation name is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test UndoableAbstractAction(String). Failure testing of
     * exception in case presentation name is empty.
     */
    public final void testUndoableAbstractActionFailureEmpty() {
        try {
            new UndoableAbstractAction("") {
                public void executeAction() {
                }

                public void redoAction() {
                }

                public void undoAction() {
                }
            };
            fail("IllegalArgumentException is expected since presentation name is empty");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test UndoableAbstractAction(String). Failure testing of
     * exception in case presentation name is empty trimmed.
     */
    public final void testUndoableAbstractActionFailureEmptyTrimmed() {
        try {
            new UndoableAbstractAction("    ") {
                public void executeAction() {
                }

                public void redoAction() {
                }

                public void undoAction() {
                }
            };
            fail("IllegalArgumentException is expected since presentation name is empty trimmed");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test UndoableAbstractAction.log(Level, String). Failure
     * testing of exception in case level is null.
     */
    public final void testLogLevelStringFailureNull() {
        UndoableAbstractAction undoableAbstractAction = new UndoableAbstractAction("presentationName") {
            public void executeAction() {
            }

            public void redoAction() {
            }

            public void undoAction() {
            }
        };
        try {
            undoableAbstractAction.log(null, "message");
            fail("IllegalArgumentException is expected since level is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test UndoableAbstractAction.execute(). Failure testing of
     * exception in case state is not UNEXECUTED.
     * @throws Exception wraps all exceptions
     */
    public final void testExecuteFailure() throws Exception {
        UndoableAbstractAction undoableAbstractAction = new UndoableAbstractAction("presentationName") {
            public void executeAction() {
            }

            public void redoAction() {
            }

            public void undoAction() {
            }
        };
        undoableAbstractAction.execute();
        try {
            undoableAbstractAction.execute();
            fail("ActionExecutionException is expected since state is not UNEXECUTED");
        } catch (ActionExecutionException e) {
            // good
        }
    }
}