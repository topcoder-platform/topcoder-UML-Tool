/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.modelmanagement.ModelImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Collection;


/**
 * <p>
 * Demo for this component.
 * </p>
 *
 * The demo will demonstrate the usage of these beans. It will show them being instantiated,
 * then used via their interface. This will be the typical usage of such simple entities under
 * any scenario. This demo will focus on showing how a simple and collection attribute is managed,
 * with the understanding that all other attributes are managed in exactly the same manner, and
 * therefore not shown here.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(Demo.class);
    }

    /**
     * Simple demo, Instantiation.
     *
     */
    public void testDemo1() {
        //4.3.1 Instantiation
        //Create an instance of sample entity: TemplateParameter. All other concrete entities are
        //instantiated in this manner and are not shown here.

        // Create an instance of sample entity
        TemplateParameter templateParameter = new TemplateParameterImpl();
    }

    /**
     * Simple demo, Simple attribute management.
     *
     */
    public void testDemo2() {
        //4.3.2 Simple attribute management
        //Manage a simple attribute: TemplateParameter.parameter. All other simple attributes are
        //managed in this manner and are not shown here.

        // Create sample entity with a simple attribute to manage
        TemplateParameter templateParameter = new TemplateParameterImpl();

        // Use setter
        ModelElement parameter = new ModelImpl();
        templateParameter.setParameter(parameter);

        // Use getter
        ModelElement retrievedParameter = templateParameter.getParameter();
    }

    /**
     * Simple demo, Collection attribute management.
     *
     */
    public void testDemo3() {
        //4.3.3 Collection attribute management
        //Manage a collection attribute: Comment.annotatedElements.

        // Create sample entity with a collection attribute to manage
        Comment comment = new CommentImpl();

        // Use single-entity add method
        ModelElement ann1 = new ModelImpl();
        comment.addAnnotatedElement(ann1);

        // There is now one annotatedElement in the collection

        // Use multiple-entity add method
        // collection with 5 valid annotatedElements
        Collection<ModelElement> col1 = new ArrayList<ModelElement>();
        ModelElement value1 = new ModelImpl();
        ModelElement value2 = new ModelImpl();
        ModelElement value3 = new ModelImpl();
        ModelElement value4 = new ModelImpl();
        ModelElement value5 = new ModelImpl();
        col1.add(value1);
        col1.add(value2);
        col1.add(value3);
        col1.add(value4);
        col1.add(value5);
        comment.addAnnotatedElements(col1);

        // There will now be 6 annotatedElements in the collection

        // Use contains method to check for annotatedElement presence
        boolean present = comment.containsAnnotatedElement(ann1);

        // This will be true

        // Use count method to get the number of annotatedElements
        int count = comment.countAnnotatedElements();

        // The count will be 6

        // Use single-entity remove method
        boolean removed = comment.removeAnnotatedElement(ann1);

        // This will be true, and the collection size is 5, regardless
        // if ann1 has duplicates in this collection.

        // Use multiple-entity remove method
        // collection with 3 valid annotatedElements, which is a subset of col1.
        Collection<ModelElement> col2 = new ArrayList<ModelElement>();
        col2.add(value1);
        col2.add(value3);
        col2.add(value4);

        boolean altered = comment.removeAnnotatedElements(col2);
        // This will be true, and the collection size is 2

        // Use clear method
        comment.clearAnnotatedElements();

        // The collection size is 0 and contains no annotatedElement
    }
}
