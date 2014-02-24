/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.RemovePackageAction;
import com.topcoder.uml.model.modelmanagement.Package;

/**
 * <p>
 * Failure test for <code>{@link RemovePackageAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class RemovePackageActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link RemovePackageAction#RemovePackageAction(Package)}</code> constructor.
     * </p>
     */
    public void testCtor_NullPackage() {
        assertConstructorException(RemovePackageAction.class, new Class[] {Package.class}, new Object[] {null},
            IllegalArgumentException.class, "If the package is null, should throw IllegalArgumentException.");
    }
}
