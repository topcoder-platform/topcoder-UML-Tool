/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.accuracytests;

import java.io.IOException;
import java.io.PrintStream;

import com.topcoder.xmi.writer.AbstractXMITransformer;
import com.topcoder.xmi.writer.ElementAlreadyExistsException;
import com.topcoder.xmi.writer.UnknownElementException;
import com.topcoder.xmi.writer.XMITransformException;

/**
 * <p>
 * This is a mocked subclass of <code>AbstractXMITransformer</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class MockedXMITransformer extends AbstractXMITransformer {

    /**
     * <p>
     * This is a mocked implementation of AbstractXMITransformer.
     * </p>
     *
     * @param element the object to transform
     * @param out the output stream the element to transform to.
     * @throws IllegalArgumentException if the out argument is null
     * @throws UnknownElementException if the xmiId for a specific element to
     *             get is not defined
     * @throws ElementAlreadyExistsException if the xmiId for a specific element
     *             to add already exists
     * @throws IOException if any i/o error occurs
     * @throws XMITransformException if any error occurs during the transform,
     *             this exception is mainly used to wrap the underlying
     *             exceptions
     */
    public void transform(Object element, PrintStream out) throws UnknownElementException,
            ElementAlreadyExistsException, XMITransformException {
        if (element == null) {
            out.println("null");
        } else {
            out.println(element.toString());
        }
    }

}
