/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.stresstests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.topcoder.xmi.writer.transformers.xmiheader.XMIHeaderTransformer;

import junit.framework.TestCase;

/**
 * <p> Stress tests for <code>XMIHeaderTransformer</code>. </p>
 *
 * @author yinzi
 * @version 1.0
 */
public class XMIHeaderTransformerStressTests extends TestCase {
    /** The number of operations in the stress tests. */
    private static final int TIMES = 1000;

    /** Represents the exporter parameter value. */
    private static final String EXPORTER = "TCUML";

    /** Represents the exporter version parameter value. */
    private static final String EXPORTER_VERSION = "1.0";

    /** Represents the meta model version parameter value. */
    private static final String META_MODEL_VERSION = "1.2";

    /** Represents the <code>XMIHeaderTransformer</code> instance used for testing. */
    private XMIHeaderTransformer transformer;

    /**
     * <p> Set up the test environment. </p>
     */
    protected void setUp() {
        transformer = new XMIHeaderTransformer(EXPORTER, EXPORTER_VERSION, META_MODEL_VERSION);
    }

    /**
     * <p> Stress test of method <code>transform(Object, PrintStream)</code>. </p>
     *
     * @throws Exception to JUnit
     */
    public void testTransform() throws Exception {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);

        long startTime = System.currentTimeMillis();
        try {
            for (int i = 0; i < TIMES; i++) {
                //transform the XMI Header to print stream
                transformer.transform(new Object(), printStream);
            }

            // Simply verify the OutputStream
            String result = stream.toString();
            assertTrue("should contains the exporter information.", result.contains(EXPORTER));
            assertTrue("should contains the exporter version information.", result.contains(EXPORTER_VERSION));
            assertTrue("should contains the meta model version information.", result.contains(META_MODEL_VERSION));

            long endTime = System.currentTimeMillis();
            System.out.println("Stress tests: " + "transform(Object, PrintStream) in " + TIMES
                    + " times takes " + (endTime - startTime) + "ms");
        }  finally {
            printStream.close();
        }
    }
}
