/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.stresstests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer;
import com.topcoder.uml.actions.model.classifiers.PasteAbstractionAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.util.config.ConfigManager;

/**
 * Stress tests for the class {@link PasteAbstractionAction}.
 * @author urtks
 * @version 1.0
 */
public class PasteActionTests extends TestCase {
    /**
     * Represents a ModelElement instance.
     */
    private AbstractionImpl modelElement;

    /**
     * Represents a Transferable instance.
     */
    private ClassElementsTransfer transferable;

    /**
     * Represents a Namespace instance.
     */
    private Namespace namespace;

    /**
     * Sets up the test environment.
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        try {
            ConfigManager.getInstance().add("stresstests/logging_wrapper.xml");
        } catch (Exception e) {
        }

        modelElement = new AbstractionImpl();
        transferable = new ClassElementsTransfer((Abstraction) modelElement);
        namespace = new ModelImpl();
    }

    /**
     * Stress test for the method {@link PasteAbstractionAction#execute()}.
     * @throws Exception
     *             to JUnit
     */
    public void testExecute() throws Exception {
        PasteAbstractionAction pasteAction = new PasteAbstractionAction(transferable, namespace);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; ++i) {
            pasteAction.execute();
        }
        System.out.println("Running CutAbstractionAction#execute for 100 times takes "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    /**
     * Stress test for the methods {@link PasteAbstractionAction#undo()} and
     * {@link PasteAbstractionAction#redo()}.
     * @throws Exception
     *             to JUnit
     */
    public void testUndoAndRedo() throws Exception {
        PasteAbstractionAction pasteAction = new PasteAbstractionAction(transferable, namespace);

        pasteAction.execute();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; ++i) {
            pasteAction.undo();
            pasteAction.redo();
        }
        System.out.println("Running PasteAbstractionAction#undo and PasteAbstractionAction#redo for 100 times takes "
                + (System.currentTimeMillis() - start) + "ms.");
    }
}