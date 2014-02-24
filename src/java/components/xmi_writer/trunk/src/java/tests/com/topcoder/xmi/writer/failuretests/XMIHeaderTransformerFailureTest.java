/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.failuretests;

import com.topcoder.xmi.writer.transformers.xmiheader.XMIHeaderTransformer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Failure test for XMIHeaderTransformer class.
 *
 * @author iamajia
 * @version 1.0
 */
public class XMIHeaderTransformerFailureTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private XMIHeaderTransformer xmiHeaderTransformer = new XMIHeaderTransformer("test", "test", "test");

    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(XMIHeaderTransformerFailureTest.class);
    }

    /**
     * Failure test of
     * <code>XMIHeaderTransformer(String exporter, String exporterVersion, String metaModelVersion)</code>
     * constructor.
     * <p>
     * exporter is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIHeaderTransformerFailureNullExporter() throws Exception {
        try {
            new XMIHeaderTransformer(null, "test", "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>XMIHeaderTransformer(String exporter, String exporterVersion, String metaModelVersion)</code>
     * constructor.
     * <p>
     * exporter is empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIHeaderTransformerFailureEmptyExporter() throws Exception {
        try {
            new XMIHeaderTransformer("  ", "test", "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>XMIHeaderTransformer(String exporter, String exporterVersion, String metaModelVersion)</code>
     * constructor.
     * <p>
     * exporterVersion is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIHeaderTransformerFailureNullExporterVersion() throws Exception {
        try {
            new XMIHeaderTransformer("test", null, "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>XMIHeaderTransformer(String exporter, String exporterVersion, String metaModelVersion)</code>
     * constructor.
     * <p>
     * exporterVersion is empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIHeaderTransformerFailureEmptyExporterVersion() throws Exception {
        try {
            new XMIHeaderTransformer("test", "  ", "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>XMIHeaderTransformer(String exporter, String exporterVersion, String metaModelVersion)</code>
     * constructor.
     * <p>
     * metaModelVersion is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIHeaderTransformerFailureNullMetaModelVersion() throws Exception {
        try {
            new XMIHeaderTransformer("test", "test", null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>XMIHeaderTransformer(String exporter, String exporterVersion, String metaModelVersion)</code>
     * constructor.
     * <p>
     * metaModelVersion is empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMIHeaderTransformerFailureEmptyMetaModelVersion() throws Exception {
        try {
            new XMIHeaderTransformer("test", "test", "  ");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>transform(Object element, PrintStream out)</code>
     * method.
     * <p>
     * out is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testTransformFailureNullOut() throws Exception {
        try {
            xmiHeaderTransformer.transform(null, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
