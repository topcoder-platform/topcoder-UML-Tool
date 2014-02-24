/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.xmiheader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import com.topcoder.xmi.writer.TestHelper;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>{@link XMIHeaderTransformer}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class XMIHeaderTransformerUnitTest extends TestCase {

    /**
     * <p>
     * Represents the exporter used in tests.
     * </p>
     */
    private static final String EXPORTER = "TCUML";

    /**
     * <p>
     * Represents the exporter version used in tests.
     * </p>
     */
    private static final String EXPORTER_VERSION = "1.0";

    /**
     * <p>
     * Represents the meta model version used in tests.
     * </p>
     */
    private static final String META_MODEL_VERSION = "1.2";

    /**
     * <p>
     * Represents the <code>XMIHeaderTransformer</code> instance used for testing transform() method.
     * </p>
     */
    private XMIHeaderTransformer xmiHeaderTransformer = new XMIHeaderTransformer(EXPORTER, EXPORTER_VERSION,
            META_MODEL_VERSION);

    /**
     * <p>
     * Unit test for <code>{@link XMIHeaderTransformer#XMIHeaderTransformer(String, String, String)}</code> method.
     * </p>
     * <p>
     * If the exporter parameter is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testXMIHeaderTransformer_NullExporter() {
        try {
            new XMIHeaderTransformer(null, EXPORTER_VERSION, META_MODEL_VERSION);
            fail("If the exporter parameter is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIHeaderTransformer#XMIHeaderTransformer(String, String, String)}</code> method.
     * </p>
     * <p>
     * If the exporter parameter is empty, should throw IllegalArgumentException.
     * </p>
     */
    public void testXMIHeaderTransformer_EmptyExporter() {
        try {
            new XMIHeaderTransformer("", EXPORTER_VERSION, META_MODEL_VERSION);
            fail("If the exporter parameter is empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIHeaderTransformer#XMIHeaderTransformer(String, String, String)}</code> method.
     * </p>
     * <p>
     * If the exporter parameter is trimmed empty, should throw IllegalArgumentException.
     * </p>
     */
    public void testXMIHeaderTransformer_TrimmedEmptyExporter() {
        try {
            new XMIHeaderTransformer("  ", EXPORTER_VERSION, META_MODEL_VERSION);
            fail("If the exporter parameter is trimmed empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIHeaderTransformer#XMIHeaderTransformer(String, String, String)}</code> method.
     * </p>
     * <p>
     * If the exporter version parameter is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testXMIHeaderTransformer_NullExporterVersion() {
        try {
            new XMIHeaderTransformer(EXPORTER, null, META_MODEL_VERSION);
            fail("If the exporter version parameter is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIHeaderTransformer#XMIHeaderTransformer(String, String, String)}</code> method.
     * </p>
     * <p>
     * If the exporter version parameter is empty, should throw IllegalArgumentException.
     * </p>
     */
    public void testXMIHeaderTransformer_EmptyExporterVersion() {
        try {
            new XMIHeaderTransformer(EXPORTER, "", META_MODEL_VERSION);
            fail("If the exporter version parameter is empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIHeaderTransformer#XMIHeaderTransformer(String, String, String)}</code> method.
     * </p>
     * <p>
     * If the exporter version parameter is trimmed empty, should throw IllegalArgumentException.
     * </p>
     */
    public void testXMIHeaderTransformer_TrimmedEmptyExporterVersion() {
        try {
            new XMIHeaderTransformer(EXPORTER, " ", META_MODEL_VERSION);
            fail("If the exporter version parameter is trimmed empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIHeaderTransformer#XMIHeaderTransformer(String, String, String)}</code> method.
     * </p>
     * <p>
     * If the meta model version parameter is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testXMIHeaderTransformer_NullMetaModelVersion() {
        try {
            new XMIHeaderTransformer(EXPORTER, EXPORTER_VERSION, null);
            fail("If the meta model version parameter is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIHeaderTransformer#XMIHeaderTransformer(String, String, String)}</code> method.
     * </p>
     * <p>
     * If the meta model version parameter is empty, should throw IllegalArgumentException.
     * </p>
     */
    public void testXMIHeaderTransformer_EmptyMetaModelVersion() {
        try {
            new XMIHeaderTransformer(EXPORTER, EXPORTER_VERSION, "");
            fail("If the meta model version parameter is empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIHeaderTransformer#XMIHeaderTransformer(String, String, String)}</code> method.
     * </p>
     * <p>
     * If the meta model version parameter is trimmed empty, should throw IllegalArgumentException.
     * </p>
     */
    public void testXMIHeaderTransformer_TrimmedEmptyMetaModelVersion() {
        try {
            new XMIHeaderTransformer(EXPORTER, EXPORTER_VERSION, "  ");
            fail("If the meta model version parameter is trimmed empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIHeaderTransformer#XMIHeaderTransformer(String, String, String)}</code> method.
     * </p>
     * <p>
     * If all parameters are valid, should successfully create the instance.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testXMIHeaderTransformer_Accuracy() throws Exception {
        assertEquals("exporter field not set.", EXPORTER, TestHelper.getFieldValue(xmiHeaderTransformer, "exporter"));
        assertEquals("exporterVersion field not set.", EXPORTER_VERSION, TestHelper.getFieldValue(xmiHeaderTransformer,
                "exporterVersion"));
        assertEquals("metaModelVersion field not set.", META_MODEL_VERSION, TestHelper.getFieldValue(
                xmiHeaderTransformer, "metaModelVersion"));
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIHeaderTransformer#transform(Object, PrintStream)}</code> method.
     * </p>
     * <p>
     * If the out parameter is null, should throw IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransform_NullOut() throws Exception {
        try {
            xmiHeaderTransformer.transform(new Object(), null);
            fail("If the out parameter is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIHeaderTransformer#transform(Object, PrintStream)}</code> method.
     * </p>
     * <p>
     * If there is some I/O error occurring, the error flag should be set.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransform_IOError() throws Exception {
        PrintStream printStream = new PrintStream(new OutputStream() {
            public void write(int b) throws IOException {
                throw new IOException("test");
            }
        });
        xmiHeaderTransformer.transform(null, printStream);

        assertTrue("there should be some error.", printStream.checkError());
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIHeaderTransformer#transform(Object, PrintStream)}</code> method.
     * </p>
     * <p>
     * If the out parameter is not null and no I/O error occurs, should successfully output the header information.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransform_Accuracy() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        xmiHeaderTransformer.transform(null, printStream);

        String result = byteArrayOutputStream.toString();

        assertTrue("should contains the exporter information.", result.contains(EXPORTER));
        assertTrue("should contains the exporter version information.", result.contains(EXPORTER_VERSION));
        assertTrue("should contains the meta model version information.", result.contains(META_MODEL_VERSION));
    }
}
