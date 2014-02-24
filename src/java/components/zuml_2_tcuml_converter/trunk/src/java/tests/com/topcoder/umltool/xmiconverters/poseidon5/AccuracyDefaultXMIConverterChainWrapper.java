/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

/**
 * <p>
 * <code>DefaultXMIConverterChain</code> is package private thus can not be accessed from another
 * package, so this class extends it, and declared itself as public. In this way, it can be accessed
 * from any other class and <code>DefaultXMIConverterChain</code> can be tested indirectly.
 * </p>
 *
 * @author abram
 * @version 1.0
 */
public class AccuracyDefaultXMIConverterChainWrapper extends DefaultXMIConverterChain {

    /**
     * <p>
     * Simply delegate to the super constructor.
     * </p>
     *
     */
    public AccuracyDefaultXMIConverterChainWrapper() {
        super();
    }

    /**
     * <p>
     * Simply delegate to the super constructor
     * </p>
     *
     * @param next
     *            the next chain to set
     * @param converter
     *            the converter instance of this chain
     * @throws IllegalArgumentException
     *             if any argument is null
     */
    public AccuracyDefaultXMIConverterChainWrapper(XMIConverterChain next, XMIConverter converter) {
        super(next, converter);
    }
}
