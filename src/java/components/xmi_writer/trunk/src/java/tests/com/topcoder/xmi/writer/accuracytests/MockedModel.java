/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.accuracytests;

import com.topcoder.uml.model.modelmanagement.ModelImpl;

/**
 * <p>
 * This is a mocked implementation of <code>Model</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class MockedModel extends ModelImpl {
    /**
     * <p>
     * This is a mocked fields used for testing.
     * </p>
     */
    private int label;

    /**
     * <p>
     * Constructor.
     * </p>
     *
     * @param label the label for testing
     */
    public MockedModel(int label) {
        this.label = label;
    }

    /**
     * <p>
     * This is a mocked implementation of <code>toString</code>.
     * </p>
     *
     * @return the string representation of the object
     */
    public String toString() {
        return "<Model>this is a model " + label + "</Model>";
    }
}
