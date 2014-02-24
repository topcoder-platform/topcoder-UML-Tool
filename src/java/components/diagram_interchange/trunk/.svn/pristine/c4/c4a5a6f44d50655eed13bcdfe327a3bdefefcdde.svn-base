/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS DiagramElement_Interchange Version 1.0 Accuracytests.
 *
 * @ DiagramElementAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Reference;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Collection;


/**
 * <p>
 * The <code>DiagramElement</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>DiagramElement</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class DiagramElementAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>DiagramElement</code> used for tests.
     * </p>
     */
    private DiagramElement test = null;

    /**
     * <p>
     * Test suite of <code>DiagramElementAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>DiagramElementAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(DiagramElementAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats some new instances for accuracy test.
     * </p>
     */
    protected void setUp() {
        test = new DiagramElementDefaultImpl();
    }

    /**
     * <p>
     * Accuracy Test of the <code>DiagramElement()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new DiagramElementDefaultImpl());

        // get the original value of isVisible to check the constructor
        assertTrue("The isVisible expected to be true", test.isVisible());

        // get the original value of container to check the constructor
        assertNull("The container expected to be null", test.getContainer());

        // get the original value of properties collection to check the constructor
        assertEquals("The links collection expected to be empty", 0,
            test.countProperties());

       // get the original value of references collection to check the constructor
        assertEquals("The references collection expected to be empty", 0,
            test.countReferences());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setVisible(boolean)</code> method and
     * <code>isVisible()</code>.
     * </p>
     */
    public void testVisible_Operation() {
      //  set the isVisible to false.
        test.setVisible(false);
        // get the value of isVisible to check.
        assertFalse("The isVisible expected to be false", test.isVisible());

        // set the isVisible to true.
        test.setVisible(true);
        // get the value of isVisible to check.
        assertTrue("The isVisible expected to be true", test.isVisible());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setContainer(GraphElement)</code> method and
     * <code>getContainer()</code>.
     * </p>
     */
    public void testContainer_Operation() {
        // creat a new GraphElement.
        GraphElement element = new GraphEdge();

        // set the container.
        test.setContainer(element);

        // get the container.
        assertEquals("The container expected to be equal", element,
            test.getContainer());

        // set the container to null.
        test.setContainer(null);
        assertNull("The container expected to be null", test.getContainer());
    }

    /**
     * <p>
     * Accuracy Test of the Properties correlative method, such like :
     * <code>addProperty(Property)</code> method, <code>getProperties()</code> and also other method.
     * </p>
     */
    public void testProperties_Operation() {
        // creat some new Properties.
        Property property = new Property();
        Property property2 = new Property();

        // add the property.
        test.addProperty(property);

        // get the elements of properties collection to test.
        assertEquals("The properties collection expected to be 1 element", 1,
            test.countProperties());
        assertTrue("The properties expected to be in the collection",
            test.containsProperty(property));

        // get a copy of the collection.
        Collection<Property> newProperties = test.getProperties();

        // get the elements of properties collection to test.
        assertEquals("The properties collection expected to be 1 element", 1,
            newProperties.size());
        assertTrue("The properties expected to be in the collection",
            newProperties.contains(property));

        // clear the new collection.
        newProperties.clear();

        // still one element in properties collection.
        assertEquals("The properties collection expected to be 1 element", 1,
            test.countProperties());

        // non exist eiement can not be removed.
        assertFalse("The properties can not be removed",
            test.removeProperty(property2));
        assertTrue("The properties expected to be removed",
            test.removeProperty(property));

        // add the property then clear it.
        test.addProperty(property);
        test.clearProperties();

        // get the elements of properties collection to test.
        assertEquals("The properties collection expected to be empty", 0,
            test.countProperties());
    }

    /**
     * <p>
     * Accuracy Test of the References correlative method, such like :
     * <code>addReference(Reference)</code> method, <code>getReferences()</code> and also other method.
     * </p>
     */
    public void testReferences_Operation() {
        // creat some new References.
        Reference reference = new Reference();
        Reference reference2 = new Reference();

        // add the reference.
        test.addReference(reference);

        // get the elements of references collection to test.
        assertEquals("The references collection expected to be 1 element", 1,
            test.countReferences());
        assertTrue("The references expected to be in the collection",
            test.containsReference(reference));

        // get a copy of the collection.
        Collection<Reference> newReferences = test.getReferences();

        // get the elements of references collection to test.
        assertEquals("The references collection expected to be 1 element", 1,
            newReferences.size());
        assertTrue("The references expected to be in the collection",
            newReferences.contains(reference));

        // clear the new collection.
        newReferences.clear();

        // still one element in references collection.
        assertEquals("The references collection expected to be 1 element", 1,
            test.countReferences());

        // non exist eiement can not be removed.
        assertFalse("The references can not be removed",
            test.removeReference(reference2));
        assertTrue("The references expected to be removed",
            test.removeReference(reference));

        // add the reference then clear it.
        test.addReference(reference);
        test.clearReferences();

        // get the elements of references collection to test.
        assertEquals("The references collection expected to be empty", 0,
            test.countReferences());
    }

    /**
     * <p>
     * A inner class which extends the <code>DiagramElement</code> class, used for
     * accuracy test only.
     * </p>
     */
    class DiagramElementDefaultImpl extends DiagramElement {
        // use default constructor.
    }
}
