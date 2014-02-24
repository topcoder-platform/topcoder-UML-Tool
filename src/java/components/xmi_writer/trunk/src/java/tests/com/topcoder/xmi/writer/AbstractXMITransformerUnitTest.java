/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer;

import java.io.PrintStream;

import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>{@link AbstractXMITransformer}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class AbstractXMITransformerUnitTest extends TestCase {

    /**
     * <p>
     * Represents the <code>AbstractXMITransformer</code> instance used in tests.
     * </p>
     */
    private AbstractXMITransformer abstractXMITransformer;

    /**
     * <p>
     * Set the testing environment.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    protected void setUp() throws Exception {
        super.setUp();

        abstractXMITransformer = new AbstractXMITransformer() {
            public void transform(Object element, PrintStream out) {
            }
        };
    }

    /**
     * <p>
     * Unit test <code>{@link AbstractXMITransformer#setXMIWriter(XMIWriter)}</code> method.
     * </p>
     * <p>
     * originally it should return null, as it is not set yet.
     * </p>
     */
    public void testGetXMIWriter_Accuracy() {
        assertNull("originally, should return null.", abstractXMITransformer.getXMIWriter());
    }

    /**
     * <p>
     * Unit test for <code>{@link AbstractXMITransformer#setXMIWriter(XMIWriter)}</code> method.
     * </p>
     * <p>
     * If the writer parameter is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testSetXMIWriter_NullWriter() {
        try {
            abstractXMITransformer.setXMIWriter(null);
            fail("If the writer parameter is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link AbstractXMITransformer#setXMIWriter(XMIWriter)}</code> method.
     * </p>
     * <p>
     * If the writer parameter is not null, should set the corresponding field.
     * </p>
     */
    public void testSetXMIWriter_Accuracy() {
        XMIWriter writer = new XMIWriter(new UMLModelManager(), TestHelper.createMandatoryTransformers());
        abstractXMITransformer.setXMIWriter(writer);

        assertSame("the internal field is not set.", writer, abstractXMITransformer.getXMIWriter());
    }
}
