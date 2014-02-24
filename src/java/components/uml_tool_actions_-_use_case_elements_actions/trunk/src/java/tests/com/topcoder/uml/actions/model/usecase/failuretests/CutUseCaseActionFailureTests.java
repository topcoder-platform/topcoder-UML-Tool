/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CutUseCaseAction;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

/**
 * <p>
 * Failure test for <code>{@link CutUseCaseAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CutUseCaseActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CutUseCaseAction#CutUseCaseAction(UseCase)}</code> constructor.
     * </p>
     */
    public void testCtor_1_nullUseCase() {
        assertConstructorException(CutUseCaseAction.class, new Class[] {UseCase.class}, new Object[] {null},
            IllegalArgumentException.class, "If actor is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link CutUseCaseAction#CutUseCaseAction(UseCase, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCtor_2_nullUseCase() {
        assertConstructorException(CutUseCaseAction.class, new Class[] {UseCase.class, Clipboard.class}, new Object[] {
            null, new Clipboard("Hello")}, IllegalArgumentException.class,
            "If actor is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link CutUseCaseAction#CutUseCaseAction(UseCase, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCtor_2_nullClipboard() {
        assertConstructorException(CutUseCaseAction.class, new Class[] {UseCase.class, Clipboard.class}, new Object[] {
            new UseCaseImpl(), null}, IllegalArgumentException.class,
            "If clipboard is null, should throw IllegalArgumentException.");
    }
}
