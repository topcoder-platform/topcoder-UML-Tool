/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer;
import com.topcoder.uml.actions.model.classifiers.PasteExceptionAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

/**
 * <p>
 * Failure test for <code>{@link PasteExceptionAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class PasteExceptionActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link PasteExceptionAction#PasteExceptionAction(Transferable, Namespace)}</code>
     * </p>
     */
    public void testCtorNullTransferable() {
        assertConstructorException(PasteExceptionAction.class, new Class[] {Transferable.class, Namespace.class},
            new Object[] {null, new PackageImpl()}, IllegalArgumentException.class,
            "If the transferable is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link PasteExceptionAction#PasteExceptionAction(Transferable, Namespace)}</code>
     * </p>
     */
    public void testCtorNullNamespace() {
        com.topcoder.uml.model.core.classifiers.Class exception = new ClassImpl();
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("exception");
        exception.addStereotype(stereotype);
        assertConstructorException(PasteExceptionAction.class, new Class[] {Transferable.class, Namespace.class},
            new Object[] {new ClassElementsTransfer(exception), null}, IllegalArgumentException.class,
            "If the namespace is null, should throw IllegalArgumentException.");
    }
}
