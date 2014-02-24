/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.stresstests;

import com.topcoder.umltool.xmiconverters.poseidon5.handlers.ZUMLHeaderHandler;

/**
 * <p>
 * Stress tests for class ZUMLHeaderHandler.
 * </p>
 * @author extra
 * @version 1.0
 */
public class ZUMLHeaderHandlerStressTests extends BaseStressTests {

    /**
     * <p>
     * Tests ZUMLHeaderHandler#characters(char[], int, int) for stress, it will
     * run 100 times.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCharactor() throws Exception {
        ZUMLHeaderHandler handler = new ZUMLHeaderHandler(new String[] {"1.0", "2.0" });
        handler.startElement(null, null, "XMI.metaModelVersion", null);
        begin();

        for (int i = 0; i < 100; i++) {
            handler.characters("1.0".toCharArray(), 0, 3);
        }
        printResult("ZUMLHeaderHandler#characters(char[], int, int)", 100);
    }
}
