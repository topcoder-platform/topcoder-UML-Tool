/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.accuracytests;

import java.lang.reflect.Field;

import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.SelectionChangedEvent;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Accuracy test for <code>SelectionChangedEvent</code>.
 * 
 * @author enefem21
 * @version 1.0
 */
public class SelectionChangedEventTest extends TestCase {

    /** Unit under test. */
    private SelectionChangedEvent selectionChangedEvent;

    /** Array of DocumentTreeNode used in unit test. */
    private DocumentTreeNode[] documentTreeNodes;

    /**
     * <p>
     * Return the suite for this unit test.
     * </p>
     * 
     * @return the suite
     */
    public static Test suite() {
        return new TestSuite(SelectionChangedEventTest.class);
    }

    /**
     * Sets the unit test up.
     * 
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();

        documentTreeNodes = new DocumentTreeNode[] {new DocumentTreeNode(new PackageImpl())};

        selectionChangedEvent = new SelectionChangedEvent(documentTreeNodes, new boolean[] {true});
    }

    /**
     * Tears the unit test down.
     * 
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        selectionChangedEvent = null;

        super.tearDown();
    }

    /**
     * Test constructor for accuracy. Condition: normal. Expect: all states are set as expected.
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testSelectionChangedEvent() throws Exception {
        SelectionChangedEvent selectionChangedEvent = new SelectionChangedEvent(documentTreeNodes, new boolean[] {true});

        // check the selectedTreeNodes fields
        Field selectedTreeNodesField = SelectionChangedEvent.class.getDeclaredField("selectedTreeNodes");
        selectedTreeNodesField.setAccessible(true);
        DocumentTreeNode[] nodes = (DocumentTreeNode[]) selectedTreeNodesField.get(selectionChangedEvent);
        assertNotSame("The field is not set as expected", documentTreeNodes, nodes);
        assertEquals("The length is not as expected", documentTreeNodes.length, nodes.length);
    }

    /**
     * Test <code>getSelectedTreeNodes</code> for accuracy. Condition: normal. Expect: returned value is as
     * expected.
     */
    public void testGetSelectedTreeNodes() {
        assertNotSame("Returned value is not as expected", documentTreeNodes, selectionChangedEvent
            .getSelectedTreeNodes());
    }

}
