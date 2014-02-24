/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.failuretests;

import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;

import junit.framework.TestCase;

import org.w3c.dom.Document;


/**
 * <p>
 * This is the failure test base for all the sub-classes of DiagramInterchangeElementTransformer.
 * </p>
 *
 * <p>
 * Concrete tests for sub-classes will only need to initialize the necessary fields before testing.
 * </p>
 *
 * @author magicpig
 * @version 1.0
 */
public class TransformerFailureBase extends TestCase {
    /** Property instance for testing. */
    protected Object element;

    /** Document instance for testing. */
    protected Document document;

    /** Diagram2XMITransformer instance for testing. */
    protected Diagram2XMITransformer caller;

    /** The name of the sub class which is being tested. */
    protected String suhClassName;

    /** DiagramInterchangeElementTransformer instance which is being tested. */
    protected DiagramInterchangeElementTransformer instance;

    /**
     * Sets up testing environment. Just initializes the document and caller field.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        document = FailureHelper.createDocument();
        caller = new Diagram2XMITransformer(FailureHelper.createTransformersMap(),
                FailureHelper.createTagNameMap());
    }

    /**
     * <p>
     * Failure test for method transform. <br>
     * Failure condition : Null element. <br>
     * Expected result : IllegalArgumentException. <br>
     * </p>
     *
     * @throws Excpetion when error occurs
     */
    public void testTransformWithNullElement() throws Exception {
        try {
            instance.transform(null, document, caller);
            fail("IllegalArgumentException is excepted[" + suhClassName + "].");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method transform. <br>
     * Failure condition : the element is of invalid type. <br>
     * Expected result : ClassCastException. <br>
     * </p>
     *
     * @throws Excpetion when error occurs
     */
    public void testTransformWithInvalidElementType() throws Exception {
        try {
            instance.transform("invalid", document, caller);
            fail("ClassCastException is excepted.");
        } catch (ClassCastException cce) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method transform. <br>
     * Failure condition : Null document. <br>
     * Expected result : IllegalArgumentException. <br>
     * </p>
     *
     * @throws Excpetion when error occurs
     */
    public void testTransformWithNullDocument() throws Exception {
        try {
            instance.transform(element, null, caller);
            fail("IllegalArgumentException is excepted[" + suhClassName + "].");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for method transform. <br>
     * Failure condition : Null caller. <br>
     * Expected result : IllegalArgumentException. <br>
     * </p>
     *
     * @throws Excpetion when error occurs
     */
    public void testTransformWithNullCaller() throws Exception {
        try {
            instance.transform(element, document, null);
            fail("IllegalArgumentException is excepted[" + suhClassName + "].");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }
}
