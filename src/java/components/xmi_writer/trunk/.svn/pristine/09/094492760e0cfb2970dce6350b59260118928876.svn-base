/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer;

import java.io.PrintStream;

/**
 * <p>
 * This class defines the interface to transform an element object and write the transformation result into the out
 * <code>{@link PrintStream}</code>.
 * </p>
 * <p>
 * It also contains methods to set and get the <code>{@link XMIWriter}</code> it is registered to.
 * </p>
 * <p>
 * <strong>Notes</strong>: The implementation should <b>NEVER</b> close the passed <code>{@link PrintStream}</code>
 * instance.
 * </p>
 * <p>
 * <strong>Thread-safety</strong>: the implementation doesn't need to be thread-safe.
 * </p>
 *
 * @author Standlove, FireIce
 * @version 1.0
 */
public interface XMITransformer {
    /**
     * <p>
     * Transforms the given element object and write the transformation result into the out
     * <code>{@link PrintStream}</code> object.
     * </p>
     * <p>
     * <strong>Notes</strong>: The element argument could be null if it is <b>NEVER</b> used by the transformer.
     * </p>
     *
     * @param element
     *            the element object to transform.
     * @param out
     *            the <code>PrintStream</code> object to write the transformation data.
     * @throws IllegalArgumentException
     *             if the out argument is <code>null</code>.
     * @throws UnknownElementException
     *             if the xmiId for a specific element to get is not defined.
     * @throws ElementAlreadyExistsException
     *             if the xmiId for a specific element to add already exists.
     * @throws XMITransformException
     *             if any error occurs during the transform, this exception is mainly used to wrap the underlying
     *             exceptions.
     */
    public void transform(Object element, PrintStream out) throws UnknownElementException,
            ElementAlreadyExistsException, XMITransformException;

    /**
     * <p>
     * Sets the <code>{@link XMIWriter}</code> object for this transformer.
     * </p>
     *
     * @param writer
     *            the <code>XMIWriter</code> object this transformer registered to.
     * @throws IllegalArgumentException
     *             if the writer is <code>null</code>.
     */
    public void setXMIWriter(XMIWriter writer);

    /**
     * <p>
     * Gets the <code>{@link XMIWriter}</code> object for this transformer.
     * </p>
     *
     * @return the <code>XMIWriter</code> object for this transformer.
     */
    public XMIWriter getXMIWriter();
}
