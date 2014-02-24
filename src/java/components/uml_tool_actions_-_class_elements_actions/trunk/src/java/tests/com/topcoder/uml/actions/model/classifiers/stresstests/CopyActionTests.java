/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.stresstests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CopyAbstractionAction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.util.config.ConfigManager;

/**
 * Stress tests for the class {@link CopyAbstractionAction}.
 * @author urtks
 * @version 1.0
 */
public class CopyActionTests extends TestCase {
    /**
     * Represents a ModelElement instance.
     */
    private AbstractionImpl modelElement;

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
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * Stress test for the method {@link CopyAbstractionAction#execute()}.
     * @throws Exception
     *             to JUnit
     */
    public void testExecute() throws Exception {
        CopyAbstractionAction copyAction = new CopyAbstractionAction(modelElement, clipboard);
        copyAction.execute();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; ++i) {
            copyAction.execute();
        }
        System.out.println("Running CopyAbstractionAction#execute for 100 times takes "
                + (System.currentTimeMillis() - start) + "ms.");
    }
}