/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model.accuracytests;

import com.topcoder.xmi.writer.AbstractXMITransformer;

import java.io.PrintStream;

/**
 * <p>
 * A mock class extends <code>AbstractXMITransformer</code>, used for testing.
 * </p>
 *
 * <p>
 * This mock class is also served as the mock class of Model transformer, ActivityGraph transformer and Diagram
 * transformer.
 * </p>
 *
 * @author catcher
 * @version 1.0
 */
public class MockTransformer extends AbstractXMITransformer {

    /**
     * <p>
     * Represents the content data should be written to output stream.
     * Passed in from constructor.
     * </p>
     */
    private String content;

    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    public MockTransformer() {
        super();
    }

    /**
     * <p>
     * Constructor with String parameter. Served as mock of Model transformer, ActivityGraph transformer and Diagram
     * transformer.
     * </p>
     *
     * @param content
     *            the content data to be written to output stream
     */
    public MockTransformer(String content) {
        this.content = content;
    }

    /**
     * <p>
     * Write the XMI content data to the output stream.
     * </p>
     *
     * @param element
     *            the element to transform (Ignored by this transformer)
     * @param out
     *            the PrintStream object to write the transformation data
     *
     * @throws IllegalArgumentException
     *             if the <tt>out</tt> argument is null
     */
    public void transform(Object element, PrintStream out) {
        //check the parameter
        if (out == null) {
            throw new IllegalArgumentException("The parameter named [out] is null.");
        }

        //write the content data
        out.println( content);
    }
}