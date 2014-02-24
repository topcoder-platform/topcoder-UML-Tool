/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.accuracytests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.topcoder.xmi.writer.AbstractXMITransformer;
import com.topcoder.xmi.writer.ElementAlreadyExistsException;
import com.topcoder.xmi.writer.UnknownElementException;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.transformers.xmiheader.XMIHeaderTransformer;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy Test for <code>XMIHeaderTransformer</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class XMIHeaderTransformerAccuracyTest extends TestCase {

    /**
     * <p>
     * Represents the exporter written into the header in the transform method.
     * </p>
     */
    private String exporter = "exporter";

    /**
     * <p>
     * Represents the exporter version written into the header in the transform
     * method.
     * </p>
     */
    private String exporterVersion = "0.8";

    /**
     * <p>
     * Represents the meta model version written into the header in the
     * transform method.
     * </p>
     */
    private String metaModelVersion = "0.5";

    /**
     * <p>
     * The expected result of the transform.
     * <p>
     */
    private String xml = "<XMI.header><XMI.documentation><XMI.exporter>" + exporter
            + "</XMI.exporter><XMI.exporterVersion>" + exporterVersion + "</XMI.exporterVersion><XMI.metaModelVersion>"
            + metaModelVersion + "</XMI.metaModelVersion></XMI.documentation></XMI.header>";

    /**
     * <p>
     * The AbstractXMITransformer instance created for testing.
     * </p>
     */
    private AbstractXMITransformer transfer = null;

    /**
     * <p>
     * Set up the enviroment.
     * </p>
     */
    protected void setUp() {
        transfer = new XMIHeaderTransformer(exporter, exporterVersion, metaModelVersion);
    }

    /**
     * <p>
     * Clear the enviroment.
     * </p>
     */
    protected void tearDown() {
        // empty
    }

    /**
     * <p>
     * Accuracy Test for
     * <code>XMIHeaderTransformer(String exporter, String exporterVersion, String metaModelVersion)</code>.
     * </p>
     */
    public void testXMIHeaderTransformerAccuracy() {
        assertNotNull("the ElementAlreadyExistsException instance creation failed.", transfer);
    }

    /**
     * <p>
     * Accuracy Test for <code>transform(Object element, PrintStream out)</code>.
     * </p>
     */
    public void testTransformAccuracy() {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(byteStream);
        try {
            transfer.transform(new Object(), print);
            assertEquals("transform failed.", xml, deleteSpace(byteStream.toString()));
        } catch (UnknownElementException e) {
            fail("no UnknownElementException is expected");
        } catch (ElementAlreadyExistsException e) {
            fail("no ElementAlreadyExistsException is expected");
        } catch (XMITransformException e) {
            fail("no XMITransformException is expected");
        }
    }

    /**
     * <p>
     * Deletes all the spaces in the string.
     * </p>
     *
     * @param value the String to process
     * @return the processed String
     */
    private String deleteSpace(String value) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isWhitespace(value.charAt(i))) {
                buffer.append(value.charAt(i));
            }
        }
        return buffer.toString();
    }

    /**
     * <p>
     * Failure Test for <code>transform(Object element, PrintStream out)</code>.
     * </p>
     * <p>
     * out is null, IllegalArgumentException is expect.
     * </p>
     */
    public void testTransformFailure() {
        try {
            transfer.transform(new Object(), null);
        } catch (IllegalArgumentException e) {
            // expect
        } catch (UnknownElementException e) {
            fail("no UnknownElementException is expected");
        } catch (ElementAlreadyExistsException e) {
            fail("no ElementAlreadyExistsException is expected");
        } catch (XMITransformException e) {
            fail("no XMITransformException is expected");
        }
    }
}
