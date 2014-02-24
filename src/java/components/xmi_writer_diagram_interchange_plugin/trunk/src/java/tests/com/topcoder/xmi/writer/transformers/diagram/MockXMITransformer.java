/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram;

import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;

import java.io.PrintStream;


/**
 * Mock {@link XMITransformer}.
 *
 * @author hanno
 * @version 1.0
 */
public class MockXMITransformer implements XMITransformer {
    /**
     * Empty implementation.
     *
     * @return null
     */
    public XMIWriter getXMIWriter() {
        return null;
    }

    /**
     * Empty implementation.
     *
     * @param writer
     *            is ignored
     */
    public void setXMIWriter(XMIWriter writer) {
    }

    /**
     * Empty implementation.
     *
     * @param element
     *            is ignored
     * @param out
     *            is ignored
     */
    public void transform(Object element, PrintStream out) {
    }
}
