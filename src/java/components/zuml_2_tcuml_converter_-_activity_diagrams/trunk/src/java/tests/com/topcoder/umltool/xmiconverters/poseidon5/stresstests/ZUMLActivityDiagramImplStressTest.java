/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.stresstests;

import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.AbstractZUMLActivityDiagram;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityDiagramImpl;

import junit.framework.TestCase;


/**
 * <p>
 * Stress tests for <code>ZUMLActivityDiagramImpl</code>.
 * </p>
 *
 * @author WN
 * @version 1.1
 */
public class ZUMLActivityDiagramImplStressTest extends TestCase {
    /**
     * <p>
     * Stress test for the method convertToTCUML().
     * </p>
     */
    public void testConvertToTCUML() {
        AbstractZUMLActivityDiagram diagram = new ZUMLActivityDiagramImpl();

        long time = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            // for version 1.1, the return should be instance of ActivityGraphImpl
            assertTrue("The result element should be instance of ActivityGraphImpl.",
                diagram.convertToTCUML() instanceof ActivityGraphImpl);
        }

        time = System.currentTimeMillis() - time;

        System.out.println("Stress test for the method convertToTCUML() took " + time + "ms");
    }
}
