/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.accuracytests;

import java.lang.reflect.Field;

import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.NameChangedEvent;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Accuracy test for <code>NameChangedEvent</code>.
 * 
 * @author enefem21
 * @version 1.0
 */
public class NameChangedEventTest extends TestCase {

    /** Unit under test. */
    private NameChangedEvent nameChangedEvent;

    private DocumentTreeNode documentTreeNode;

    /**
     * <p>
     * Return the suite for this unit test.
     * </p>
     *
     * @return the suite
     */
    public static Test suite() {
        return new TestSuite(NameChangedEventTest.class);
    }
    
    /**
     * Sets the unit test up.
     * 
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();

        documentTreeNode = new DocumentTreeNode(new PackageImpl());
        nameChangedEvent = new NameChangedEvent(documentTreeNode, "java.lang");
    }

    /**
     * Tears the unit test down.
     * 
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        nameChangedEvent = null;

        super.tearDown();
    }

    /**
     * Test constructor for accuracy. Condition: normal. Expect: all states are set as expected.
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testNameChangedEvent() throws Exception {
        NameChangedEvent nameChangedEvent = new NameChangedEvent(documentTreeNode, "java.lang");

        // check the treeNode fields
        Field treeNodeField = NameChangedEvent.class.getDeclaredField("treeNode");
        treeNodeField.setAccessible(true);
        assertEquals("The field is not set as expected", documentTreeNode, treeNodeField.get(nameChangedEvent));

        // check the newName fields
        Field newNameField = NameChangedEvent.class.getDeclaredField("newName");
        newNameField.setAccessible(true);
        assertEquals("The field is not set as expected", "java.lang", newNameField.get(nameChangedEvent));
    }

    /**
     * Test <code>getTreeNode</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetTreeNode() {
        assertEquals("Returned value is not as expected", documentTreeNode, nameChangedEvent.getTreeNode());
    }

    /**
     * Test <code>getNewName</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetNewName() {
        assertEquals("Returned value is not as expected", "java.lang", nameChangedEvent.getNewName());
    }

}
