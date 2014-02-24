/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.util.Iterator;

import com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.util.config.ConfigManager;

/**
 * Test util class. Providing helper methods for testing.
 *
 * @author superZZ
 * @version 1.0
 */
class TestUtil {
    /**
     * The Abstraction instance used for test.
     */
    private final Abstraction abstraction = new AbstractionImpl();

    /**
     * The Transferable instance used for test.
     */
    private final ClassElementsTransfer transferable = new ClassElementsTransfer(
            abstraction);

    /**
     * The Namespace instance used for test.
     */
    private final Model namespace = new ModelImpl();

    /**
     * Return Transferable instance. An AbstractionImpl is wrapped.
     *
     * @return Transferable instance. An AbstractionImpl is wrapped.
     */
    public Transferable getTransferable() {
        return transferable;
    }

    /**
     * Return a namespace instance.
     *
     * @return a namespace instance.
     */
    public Namespace getNamespace() {
        return namespace;
    }

    /**
     * The Clipboard instance for the test.
     */
    public static final Clipboard CLIPBORAD = Toolkit.getDefaultToolkit()
            .getSystemClipboard();

    /**
     * Return an instance for TestUtil.
     *
     * @return an instance for TestUtil.
     */
    public static TestUtil getInstance() {
        return new TestUtil();
    }

    /**
     * Return an Exception instance.
     *
     * @return an Exception instance.
     */
    public Class getException() {
        Class exception = new ClassImpl();
        Stereotype stereoType = new StereotypeImpl();
        stereoType.setName("Exception");
        exception.addStereotype(stereoType);

        return exception;
    }

    /**
     * Load logger configuration.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public static void loadConfiguration() throws Exception {
        unloadConfiguration();

        ConfigManager.getInstance().add("com.topcoder.util.log",
                "accuracytests/Logging.xml",
                ConfigManager.CONFIG_XML_FORMAT);
        // FIXME
//        ConfigManager.getInstance().add("com.topcoder.util.log",
//                "accuracytests/Logging.xml",
//                ConfigManager.CONFIG_XML_FORMAT);
        ConfigManager.getInstance().add(new File("test_files/accuracytests/config.xml").getCanonicalPath());
    }

    /**
     * Unload logger configuration.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    public static void unloadConfiguration() throws Exception {
        // FIXME
//        if (ConfigManager.getInstance()
//                .existsNamespace("com.topcoder.util.log")) {
//            ConfigManager.getInstance()
//                    .removeNamespace("com.topcoder.util.log");
//        }
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator i = cm.getAllNamespaces(); i.hasNext();) {
            cm.removeNamespace((String) i.next());
        }
    }
}
