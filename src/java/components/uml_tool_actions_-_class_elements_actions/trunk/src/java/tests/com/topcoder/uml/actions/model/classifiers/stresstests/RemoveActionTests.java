/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.stresstests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.RemoveAbstractionAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.config.ConfigManager;

/**
 * Stress tests for the class {@link RemoveAbstractionAction}.
 * @author urtks
 * @version 1.0
 */
public class RemoveActionTests extends TestCase {
    /**
     * Represents a ModelElement instance.
     */
    private AbstractionImpl modelElement;

    /**
     * Represents an UMLModelManager instance.
     */
    private UMLModelManager manager;

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
        manager = new UMLModelManager();
        namespace = manager.getModel();

        modelElement.setNamespace(namespace);
        namespace.addOwnedElement(modelElement);
    }

    /**
     * Stress test for the method {@link RemoveAbstractionAction#execute()}.
     * @throws Exception
     *             to JUnit
     */
    public void testExecute() throws Exception {
        for (int i = 0; i < 99; ++i) {
            namespace.addOwnedElement(modelElement);
        }

        RemoveAbstractionAction removeAction = new RemoveAbstractionAction(modelElement);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; ++i) {
            removeAction.execute();
        }
        System.out.println("Running AddAbstractionAction#execute for 100 times takes "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    /**
     * Stress test for the methods {@link RemoveAbstractionAction#undo()} and
     * {@link RemoveAbstractionAction#redo()}.
     * @throws Exception
     *             to JUnit
     */
    public void testUndoAndRedo() throws Exception {
        RemoveAbstractionAction removeAction = new RemoveAbstractionAction(modelElement);

        removeAction.execute();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; ++i) {
            removeAction.undo();
            removeAction.redo();
        }
        System.out.println("Running RemoveAbstractionAction#undo and RemoveAbstractionAction#redo for 100 times takes "
                + (System.currentTimeMillis() - start) + "ms.");
    }
}