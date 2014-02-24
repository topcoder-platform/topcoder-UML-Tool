/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.stresstests;

import java.io.PrintStream;

import com.topcoder.xmi.writer.AbstractXMITransformer;

/**
 * <p> A mock class extends <code>AbstractXMITransformer</code>, used for testing. </p>
 *
 * @author yinzi
 * @version 1.0
 */
public class MockXMITransformer extends AbstractXMITransformer {

    /**
     * <p> Represents the content data should be written to output stream. </p>
     */
    private String content;

    /**
     * <p> Empty constructor. </p>
     */
    public MockXMITransformer() {
        super();
    }

    /**
     * <p> Constructor with String parameter. Served as mock of Model transformer, ActivityGraph
     * transformer and Diagram transformer. </p>
     *
     * @param content the content data to be written to output stream
     */
    public MockXMITransformer(String content) {
        this.content = content;
    }

    /**
     * <p> Write the XMI content data to the output stream. </p>
     *
     * @param element the element to transform (Ignored by this transformer)
     * @param out the PrintStream object to write the transformation data
     *
     * @throws IllegalArgumentException if the <tt>out</tt> argument is null
     */
    public void transform(Object element, PrintStream out) {
        //check the parameter
        if (out == null) {
            throw new IllegalArgumentException("The parameter named [out] is null.");
        }

        //write the content data
        out.println("      " + content);
    }
}