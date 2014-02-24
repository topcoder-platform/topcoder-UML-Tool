/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.classifiers.CutPackageAction;
import com.topcoder.uml.model.modelmanagement.Package;

/**
 * <p>
 * Failure test for <code>{@link CutPackageAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CutPackageActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CutPackageAction#CutPackageAction(Package)}</code> constructor.
     * </p>
     */
    public void testCtor_1_NullPackage() {
        assertConstructorException(CutPackageAction.class, new Class[] {Package.class}, new Object[] {null},
            IllegalArgumentException.class, "If the package is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Fail test for <code>{@link CutPackageAction#CutPackageAction(Package, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCtor_2_NullPackage() {
        assertConstructorException(CutPackageAction.class, new Class[] {Package.class, Clipboard.class}, new Object[] {
            null, new Clipboard("test")}, IllegalArgumentException.class,
            "If the package is null, should throw IllegalArgumentException.");
    }
}
