/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.failuretests;

import java.io.PrintStream;

import com.topcoder.xmi.writer.AbstractXMITransformer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Failure test for AbstractXMITransformer class.
 *
 * @author iamajia
 * @version 1.0
 */
public class AbstractXMITransformerFailureTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private AbstractXMITransformer abstractXMITransformer = new MockXMITransformer();
    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(AbstractXMITransformerFailureTest.class);
    }

    /**
     * Failure test of <code>setXMIWriter(XMIWriter writer)</code> method.
     *
     * <p>
     * writer is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetXMIWriterFailureNullWriter() throws Exception {
        try {
            abstractXMITransformer.setXMIWriter(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * This mock class is used in the test.
     *
     * @author iamajia
     * @version 1.0
     */
    private class MockXMITransformer extends AbstractXMITransformer {
        /**
         * <p>
         * Do nothing.
         * </p>
         *
         * @param element
         *            the element to transform.
         * @param out
         *            the PrintStream object to write the transformation data.
         */
        public void transform(Object element, PrintStream out) {
            // do nothing.
        }
    }
}
