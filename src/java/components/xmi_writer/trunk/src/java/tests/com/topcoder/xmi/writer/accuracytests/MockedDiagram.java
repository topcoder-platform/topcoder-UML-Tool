/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.accuracytests;

import com.topcoder.diagraminterchange.Diagram;

/**
 * <p>
 * This is a mocked subclass of <code>Diagram</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class MockedDiagram extends Diagram {
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
    public MockedDiagram(int label) {
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
        return "<Diagram>this is a MockedDiagram " + label + "</Diagram>";
    }
}
