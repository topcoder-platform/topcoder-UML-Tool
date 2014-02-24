/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.stresstests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CutAbstractionAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.config.ConfigManager;

/**
 * Stress tests for the class {@link CutAbstractionAction}.
 * @author urtks
 * @version 1.0
 */
public class CutActionTests extends TestCase {
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
     * Represents a Clipboard instance.
     */
    private Clipboard clipboard;

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

        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * Stress test for the method {@link CutAbstractionAction#execute()}.
     * @throws Exception
     *             to JUnit
     */
    public void testExecute() throws Exception {
        for (int i = 0; i < 99; ++i) {
            namespace.addOwnedElement(modelElement);
        }

        CutAbstractionAction cutAction = new CutAbstractionAction(modelElement, clipboard);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; ++i) {
            cutAction.execute();
        }
        System.out.println("Running CutAbstractionAction#execute for 100 times takes "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    /**
     * Stress test for the methods {@link CutAbstractionAction#undo()} and
     * {@link CutAbstractionAction#redo()}.
     * @throws Exception
     *             to JUnit
     */
    public void testUndoAndRedo() throws Exception {
        CutAbstractionAction cutAction = new CutAbstractionAction(modelElement, clipboard);

        cutAction.execute();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; ++i) {
            cutAction.undo();
            cutAction.redo();
        }
        System.out.println("Running CutAbstractionAction#undo and CutAbstractionAction#redo for 100 times takes "
                + (System.currentTimeMillis() - start) + "ms.");
    }
}