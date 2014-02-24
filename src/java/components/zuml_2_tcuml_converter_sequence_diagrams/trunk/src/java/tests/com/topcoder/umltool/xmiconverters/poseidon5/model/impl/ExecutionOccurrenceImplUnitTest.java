/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.model.impl;

import com.topcoder.umltool.xmiconverters.poseidon5.model.ExecutionOccurrence;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit tests for <code>ExecutionOccurrenceImpl</code> class.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class ExecutionOccurrenceImplUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(ExecutionOccurrenceImplUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>ExecutionOccurrenceImpl()</code>.
     * </p>
     */
    public void testCtor() {
        ExecutionOccurrence eo = new ExecutionOccurrenceImpl();
        assertNotNull("Unable to create ExecutionOccurrenceImpl class.", eo);
    }
}
