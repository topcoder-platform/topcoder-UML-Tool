/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.accuracytests;

import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;

import junit.framework.TestCase;

/**
 * AccuracyTest for ObjectImpl class.
 *
 * @author iamajia
 * @version 1.0
 */
public class ObjectImplAccuracyTest extends TestCase {
    /**
     * Accuracy test of <code>ObjectImpl()</code> constructor.
     *
     *
     * @throws Exception
     *             to junit.
     */
    public void testObjectImplAccuracy() throws Exception {
        assertNotNull("instance should be created.", new ObjectImpl());
    }
}
