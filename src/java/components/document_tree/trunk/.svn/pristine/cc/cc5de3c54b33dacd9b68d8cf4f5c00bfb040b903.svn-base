/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for DocumentTreeNodeType.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class DocumentTreeNodeTypeTests extends TestCase {
    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DocumentTreeNodeTypeTests.class);
    }

    /**
     * <p>
     * Tests DocumentTreeNodeType#valueOf(String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the three DocumentTreeNodeType enumerations should be returned.
     * </p>
     */
    public void testValueOf() {
        assertSame("It verifies the DIAGRAM_CATEGORY DocumentTreeNodeType", DocumentTreeNodeType.DIAGRAM_CATEGORY,
            DocumentTreeNodeType.valueOf("DIAGRAM_CATEGORY"));
        assertSame("It verifies the GRAPH_ELEMENT DocumentTreeNodeType", DocumentTreeNodeType.GRAPH_ELEMENT,
            DocumentTreeNodeType.valueOf("GRAPH_ELEMENT"));
        assertSame("It verifies the MODEL_ELEMENT DocumentTreeNodeType", DocumentTreeNodeType.MODEL_ELEMENT,
            DocumentTreeNodeType.valueOf("MODEL_ELEMENT"));
    }

    /**
     * <p>
     * Tests DocumentTreeNodeType#values() for accuracy.
     * </p>
     *
     * <p>
     * It verifies the three DocumentTreeNodeType enumerations should be returned.
     * </p>
     */
    public void testValues() {
        DocumentTreeNodeType[] documentTreeNodeTypes = DocumentTreeNodeType.values();

        assertEquals("There should be three document tree node types defined.", 3, documentTreeNodeTypes.length);
        assertSame("It verifies the GRAPH_ELEMENT DocumentTreeNodeType", DocumentTreeNodeType.GRAPH_ELEMENT,
            documentTreeNodeTypes[0]);
        assertSame("It verifies the MODEL_ELEMENT DocumentTreeNodeType", DocumentTreeNodeType.MODEL_ELEMENT,
            documentTreeNodeTypes[1]);
        assertSame("It verifies the DIAGRAM_CATEGORY DocumentTreeNodeType", DocumentTreeNodeType.DIAGRAM_CATEGORY,
            documentTreeNodeTypes[2]);
    }

}