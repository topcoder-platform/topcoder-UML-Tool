/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This is the mock class of RemoveAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockRemoveAction extends RemoveAction {

    /**
     * <p>
     * Mock constructor which provide configuration for remove action.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @param classToolUtil
     *            ClassToolUtil instance, null impossible
     * @throws IllegalArgumentException
     *             when some parameter is null
     */
    protected MockRemoveAction(ModelElement modelElement, ClassToolUtil classToolUtil) {
        super(modelElement, classToolUtil);
    }
}