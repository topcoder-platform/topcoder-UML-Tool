/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.classifiers.CutGeneralizationAction;
import com.topcoder.uml.model.core.relationships.Generalization;

/**
 * <p>
 * Failure test for <code>{@link CutGeneralizationAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CutGeneralizationActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CutGeneralizationAction#CutGeneralizationAction(Generalization)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_1_NullGeneralization() {
        assertConstructorException(CutGeneralizationAction.class, new Class[] {Generalization.class},
            new Object[] {null}, IllegalArgumentException.class,
            "If the generalization is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Fail test for <code>{@link CutGeneralizationAction#CutGeneralizationAction(Generalization, Clipboard)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_2_NullGeneralization() {
        assertConstructorException(CutGeneralizationAction.class, new Class[] {Generalization.class, Clipboard.class},
            new Object[] {null, new Clipboard("test")}, IllegalArgumentException.class,
            "If the generalization is null, should throw IllegalArgumentException.");
    }
}
