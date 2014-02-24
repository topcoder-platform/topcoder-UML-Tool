/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.model.usecase.ModelTransfer;
import com.topcoder.uml.actions.model.usecase.PasteSubsystemAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;
import com.topcoder.uml.model.usecases.ActorImpl;

/**
 * <p>
 * Failure test for <code>{@link PasteSubsystemAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class PasteSubsystemActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link PasteSubsystemAction#PasteSubsystemAction(Transferable, Namespace)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_1_nullTransferable() {
        assertConstructorException(PasteSubsystemAction.class, new Class[] {Transferable.class, Namespace.class},
            new Object[] {null, new MockNamespace()}, IllegalArgumentException.class,
            "If the transferable is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link PasteSubsystemAction#PasteSubsystemAction(Transferable, Namespace)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_1_nullNamespace() {
        assertConstructorException(PasteSubsystemAction.class, new Class[] {Transferable.class, Namespace.class},
            new Object[] {new ModelTransfer(new SubsystemImpl()), null}, IllegalArgumentException.class,
            "If the namespace is null, should throw IllegalArgumentException.");
    }

}
