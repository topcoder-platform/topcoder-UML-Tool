/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.model.sequence.accuracytests.BaseTestCase;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.util.actionmanager.*;

/**
 * <p>
 * Accuracy test for <code>{@link ObjectUndoableAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class ObjectUndoableActionAccuracyTests extends BaseTestCase {
    /**
     * <p>
     * Represents the <code>ObjectUndoableAction</code> instance used in tests.
     * </p>
     */
    private ObjectUndoableAction objectUndoableAction;

    /**
     * <p>
     * Accuracy test for <code>{@link ObjectUndoableAction#ObjectUndoableAction(Object)}</code> constructor.
     * </p>
     */
    public void testObjectUndoableActionAccuracy1() {
        Object object = new ObjectImpl();
        objectUndoableAction = new AccuracyObjectUndoableAction(object);

        assertNotNull("object not created successfully.", objectUndoableAction);
        assertSame(object, objectUndoableAction.getObject());
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ObjectUndoableAction#ObjectUndoableAction(Transferable)}</code> constructor.
     * </p>
     */
    public void testObjectUndoableActionAccuracy2() throws Exception {
        Object object = new ObjectImpl();
        objectUndoableAction = new AccuracyObjectUndoableAction(new CollaborationTransfer(object));

        assertNotNull("object not created successfully.", objectUndoableAction);
        assertSame(object, objectUndoableAction.getObject());
    }

    /**
     * Mock class.
     * @author FireIce
     * @version 1.0
     */
    private class AccuracyObjectUndoableAction extends ObjectUndoableAction {

        public AccuracyObjectUndoableAction(Transferable transferable) throws SequenceConfigurationException {
            super(transferable);
        }

        protected AccuracyObjectUndoableAction(Object object) {
            super(object);
        }

    /**
     * <p>
     * Executes the Action and if there are any problems in the execution of the Action, it is reported by throwing
     * an ActionExecutionException.
     * </p>
     *
     * @throws ActionExecutionException if there are problems in the execution of the action
     */
    public void execute() throws ActionExecutionException {}

    }
}
