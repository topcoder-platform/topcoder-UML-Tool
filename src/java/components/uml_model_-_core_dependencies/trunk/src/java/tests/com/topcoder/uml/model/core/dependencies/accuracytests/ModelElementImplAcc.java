/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core.dependencies.accuracytests;

import com.topcoder.uml.model.core.ModelElementAbstractImpl;

/**
 * Mock class ModelElementImpl.
 * @author singlewood
 * @version 1.0
 */

public class ModelElementImplAcc extends ModelElementAbstractImpl {
    /**
     * Inner int.
     */
    private int i;
    /**
     * Constructor.
     */
    public ModelElementImplAcc(int i) {
        this.i = i;
    }

    /**
     * Return inner int.
     * @return i
     */
    public int getI() {
        return i;
    }
}
