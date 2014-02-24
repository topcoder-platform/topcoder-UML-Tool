/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model.stresstests;

import com.topcoder.xmi.writer.transformers.model.ChildDescription;
import com.topcoder.xmi.writer.transformers.model.XMIElementDescription;
import com.topcoder.xmi.writer.transformers.model.xmidescription.ReflectedXMIDescription;

import junit.framework.TestCase;
/**
 * The Stress test of the class ReflectedXMIDescription.
 *
 * @author haozhangr
 * @version 1.0
 */
public class ReflectedXMIDescriptionStressTests extends TestCase {
    /**
     * The ReflectedXMIDescription instance for test.
     */
    private ReflectedXMIDescription reflectedXMIDescription = null;
    /**
     * The setUp of the unit test.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        StressTestHelper.clearConfig();
        StressTestHelper.addConfig();

        reflectedXMIDescription = new ReflectedXMIDescription("com.topcoder.xmi.writer.transformers.model."
                + "xmidescription.ReflectedXMIDescription.stress");
    }
    /**
     * The tearDown, clear the configuration.
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        StressTestHelper.clearConfig();
    }
    /**
     * The Stress Test of the method getXMIElementDescription in class ReflectedXMIDescription.
     * The method is excuted for 500 times, and the time is printed.
     *
     * @throws Exception to JUnit
     */
    public void test_stress_getXMIElementDescription() throws Exception {
        long start = System.currentTimeMillis();
        XMIElementDescription desc = null;
        for(int i = 0; i < StressTestHelper.TIMES; i ++) {
            desc = reflectedXMIDescription.getXMIElementDescription(StressImplement.class);
        }
        long end = System.currentTimeMillis();
        assertEquals("The number of attribute should be 2", 2, desc.getAttributes().size());
        assertEquals("The number of children should be 5.", 5, desc.getChildren().size());
        int refCount = 0;        for(ChildDescription child : desc.getChildren()) {
            if(child.isReference()) {
                refCount ++;
            }
        }
        assertEquals("The number of Reference should be 3.", 3, refCount);
        System.out.println("Excute ReflectedXMIDescription#getXMIElementDescription takes " + (end - start) + " ms.");
    }
}
