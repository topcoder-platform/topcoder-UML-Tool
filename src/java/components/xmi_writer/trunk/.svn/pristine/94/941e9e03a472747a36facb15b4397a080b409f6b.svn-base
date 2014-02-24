/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.accuracytests;

import java.util.HashMap;
import java.util.Map;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.AbstractXMITransformer;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy Test for <code>AbstractXMITransformer</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class AbstractXMITransformerAccuracyTest extends TestCase {
    /**
     * <p>
     * The XMIWriter instance created for testing.
     * </p>
     */
    private XMIWriter writer = null;

    /**
     * <p>
     * The UMLModelManager instance created for testing.
     * </p>
     */
    private UMLModelManager manager = new UMLModelManager();

    /**
     * <p>
     * The Map<TransformerType, XMITransformer> instance created for testing.
     * </p>
     */
    private Map<TransformerType, XMITransformer> transformers = new HashMap<TransformerType, XMITransformer>();

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
        transfer = new MockedXMITransformer();
        transformers.put(TransformerType.Model, new MockedXMITransformer());
        transformers.put(TransformerType.ActivityGraph, new MockedXMITransformer());
        transformers.put(TransformerType.Diagram, new MockedXMITransformer());
        writer = new XMIWriter(manager, transformers);
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
     * Accuracy test for <code>getXMIWriter()</code>.
     * </p>
     */
    public void testGetXMIWriter() {
        assertNull("getXMIWriter failed.", transfer.getXMIWriter());
        transfer.setXMIWriter(writer);
        assertEquals("getXMIWriter failed.", writer, transfer.getXMIWriter());
    }

    /**
     * <p>
     * Accuracy test for <code>setXMIWriter(XMIWriter writer)</code>.
     * </p>
     */
    public void testSetXMIWriterAccuracy() {
        transfer.setXMIWriter(writer);
        assertEquals("setXMIWriter failed.", writer, transfer.getXMIWriter());
    }

    /**
     * <p>
     * Failure test for <code>setXMIWriter(XMIWriter writer)</code>.
     * </p>
     * <p>
     * writer is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetXMIWriterFailure() {
        try {
            transfer.setXMIWriter(null);
            fail("writer is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
