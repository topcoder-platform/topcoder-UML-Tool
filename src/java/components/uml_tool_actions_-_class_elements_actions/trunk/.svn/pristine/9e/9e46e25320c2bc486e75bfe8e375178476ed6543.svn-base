/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;

import com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.modelmanagement.Package;

/**
 * <p>
 * Failure test for <code>{@link com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer}</code> method.
 * </p>
 * @author Zhang Guiqiang
 */
public class ClassElementsTransferFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link ClassElementsTransfer#ClassElementsTransfer(Enumeration)}</code> contructor.
     * </p>
     */
    public void testCtor_NullEnumeration() {
        assertConstructorException(ClassElementsTransfer.class, new Class[] {Enumeration.class}, new Object[] {null},
            IllegalArgumentException.class, "If the enumeration is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link ClassElementsTransfer#ClassElementsTransfer(com.topcoder.uml.model.core.classifiers.Class)}</code>
     * contructor.
     * </p>
     */
    public void testCtor_NullClass() {
        assertConstructorException(ClassElementsTransfer.class,
            new Class[] {com.topcoder.uml.model.core.classifiers.Class.class}, new Object[] {null},
            IllegalArgumentException.class, "If the class is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link ClassElementsTransfer#ClassElementsTransfer(Interface)}</code> contructor.
     * </p>
     */
    public void testCtor_NullInterface() {
        assertConstructorException(ClassElementsTransfer.class, new Class[] {Interface.class}, new Object[] {null},
            IllegalArgumentException.class, "If the interface is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link ClassElementsTransfer#ClassElementsTransfer(Package)}</code> contructor.
     * </p>
     */
    public void testCtor_NullPackage() {
        assertConstructorException(ClassElementsTransfer.class, new Class[] {Package.class}, new Object[] {null},
            IllegalArgumentException.class, "If the package is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link ClassElementsTransfer#ClassElementsTransfer(Abstraction)}</code> contructor.
     * </p>
     */
    public void testCtor_NullAbstraction() {
        assertConstructorException(ClassElementsTransfer.class, new Class[] {Abstraction.class}, new Object[] {null},
            IllegalArgumentException.class, "If the abstraction is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link ClassElementsTransfer#ClassElementsTransfer(Association)}</code> contructor.
     * </p>
     */
    public void testCtor_NullAssociation() {
        assertConstructorException(ClassElementsTransfer.class, new Class[] {Association.class}, new Object[] {null},
            IllegalArgumentException.class, "If the association is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link ClassElementsTransfer#ClassElementsTransfer(Dependency)}</code> contructor.
     * </p>
     */
    public void testCtor_NullDependency() {
        assertConstructorException(ClassElementsTransfer.class, new Class[] {Dependency.class}, new Object[] {null},
            IllegalArgumentException.class, "If the dependency is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link ClassElementsTransfer#ClassElementsTransfer(Generalization)}</code> contructor.
     * </p>
     */
    public void testCtor_NullGeneralization() {
        assertConstructorException(ClassElementsTransfer.class, new Class[] {Generalization.class},
            new Object[] {null}, IllegalArgumentException.class,
            "If the generalization is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link ClassElementsTransfer#lostOwnership(Clipboard, Transferable)}</code> method.
     * </p>
     */
    public void testLostOwnership_NullClipboard() {
        try {
            new ClassElementsTransfer(new DependencyImpl()).lostOwnership(null, new ClassElementsTransfer(
                new DependencyImpl()));
            fail("If clipboard is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ClassElementsTransfer#lostOwnership(Clipboard, Transferable)}</code> method.
     * </p>
     */
    public void testLostOwnership_NullTransferable() {
        try {
            new ClassElementsTransfer(new DependencyImpl()).lostOwnership(new Clipboard("test"), null);
            fail("If clipboard is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ClassElementsTransfer#isDataFlavorSupported(DataFlavor)}</code> method.
     * </p>
     */
    public void testIsDataFlavorSupported_NullDataFlavor() {
        try {
            new ClassElementsTransfer(new DependencyImpl()).isDataFlavorSupported(null);
            fail("If dataFlavor is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ClassElementsTransfer#getTransferData(DataFlavor)}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testGetTransferData_NullDataFlavor() throws Exception {
        try {
            new ClassElementsTransfer(new DependencyImpl()).getTransferData(null);
            fail("If dataFlavor is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ClassElementsTransfer#getTransferData(DataFlavor)}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testGetTransferData_UnsupportedDataFlavor() throws Exception {
        try {
            new ClassElementsTransfer(new DependencyImpl()).getTransferData(new DataFlavor());
            fail("If dataFlavor is not supported, should throw UnsupportedFlavorException.");
        } catch (UnsupportedFlavorException e) {
            // expected
        }
    }
}
