/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.classifiers.CopyGeneralizationAction;
import com.topcoder.uml.model.core.relationships.Generalization;

/**
 * <p>
 * Failure test for <code>{@link CopyGeneralizationAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CopyGeneralizationActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CopyGeneralizationAction#CopyGeneralizationAction(Generalization)}</code>
     * constructor. method.
     * </p>
     */
    public void testCtor_1_NullGeneralization() {
        assertConstructorException(CopyGeneralizationAction.class, new Class[] {Generalization.class},
            new Object[] {null}, IllegalArgumentException.class,
            "If the generalization is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Fail test for <code>{@link CopyGeneralizationAction#CopyGeneralizationAction(Generalization, Clipboard)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_2_NullGeneralization() {
        assertConstructorException(CopyGeneralizationAction.class, new Class[] {Generalization.class, Clipboard.class},
            new Object[] {null, new Clipboard("test")}, IllegalArgumentException.class,
            "If the generalization is null, should throw IllegalArgumentException.");
    }
}
