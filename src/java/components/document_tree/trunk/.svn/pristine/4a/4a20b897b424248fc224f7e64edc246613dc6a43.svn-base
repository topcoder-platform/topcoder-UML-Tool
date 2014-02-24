/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for DocumentTreeViewType.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class DocumentTreeViewTypeTests extends TestCase {
    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DocumentTreeViewTypeTests.class);
    }

    /**
     * <p>
     * Tests DocumentTreeViewType#valueOf(String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the three DocumentTreeViewType enumerations should be returned.
     * </p>
     */
    public void testValueOf() {
        assertSame("It verifies the DIAGRAM_CENTRIC DocumentTreeViewType", DocumentTreeViewType.DIAGRAM_CENTRIC,
            DocumentTreeViewType.valueOf("DIAGRAM_CENTRIC"));
        assertSame("It verifies the PACKAGE_CENTRIC DocumentTreeViewType", DocumentTreeViewType.PACKAGE_CENTRIC,
            DocumentTreeViewType.valueOf("PACKAGE_CENTRIC"));
        assertSame("It verifies the CLASS_CENTRIC DocumentTreeViewType", DocumentTreeViewType.CLASS_CENTRIC,
            DocumentTreeViewType.valueOf("CLASS_CENTRIC"));
    }

    /**
     * <p>
     * Tests DocumentTreeViewType#values() for accuracy.
     * </p>
     *
     * <p>
     * It verifies the three DocumentTreeViewType enumerations should be returned.
     * </p>
     */
    public void testValues() {
        DocumentTreeViewType[] documentTreeViewTypes = DocumentTreeViewType.values();

        assertEquals("There should be three document tree view types defined.", 3, documentTreeViewTypes.length);
        assertSame("It verifies the DIAGRAM_CENTRIC DocumentTreeViewType", DocumentTreeViewType.DIAGRAM_CENTRIC,
            documentTreeViewTypes[0]);
        assertSame("It verifies the PACKAGE_CENTRIC DocumentTreeViewType", DocumentTreeViewType.PACKAGE_CENTRIC,
            documentTreeViewTypes[1]);
        assertSame("It verifies the CLASS_CENTRIC DocumentTreeViewType", DocumentTreeViewType.CLASS_CENTRIC,
            documentTreeViewTypes[2]);
    }

}