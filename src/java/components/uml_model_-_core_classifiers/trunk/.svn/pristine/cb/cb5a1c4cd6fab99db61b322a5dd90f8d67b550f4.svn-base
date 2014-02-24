/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

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
 * any scenario. This demo will focus on showing how a simple and list attribute is managed,
 * with the understanding that all other attributes are managed in exactly the same manner,
 * and therefore not shown here.
 *
 * @author argolite, TCSDEVELOPER
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
        //Create an instance of sample entity: EnumerationLiteral. All other concrete entities
        //are instantiated in this manner and are not shown here.

        // Create an instance of sample entity
        EnumerationLiteral enumerationLiteral = new EnumerationLiteralImpl();
    }

    /**
     * Simple demo, Simple attribute management.
     *
     */
    public void testDemo2() {
        //4.3.2 Simple attribute management
        //Manage a simple attribute: EnumerationLiteral.enumeration. All other simple attributes
        //are managed in this manner and are not shown here.

        // Create sample entity with a simple attribute to manage
        EnumerationLiteral enumerationLiteral = new EnumerationLiteralImpl();

        // Use setter
        Enumeration enumeration = new EnumerationImpl();
        enumerationLiteral.setEnumeration(enumeration);

        // Use getter
        Enumeration retrievedEnumeration = enumerationLiteral.getEnumeration();
    }

    /**
     * Simple demo, List attribute management.
     *
     */
    public void testDemo3() {
        //4.3.3 List attribute management
        //Manage a list attribute: Enumeration.literals.

        // Create sample entity with a list attribute to manage
        Enumeration enumeration = new EnumerationImpl();

        // Use single-entity add method
        EnumerationLiteral lit1 = new EnumerationLiteralImpl();
        enumeration.addLiteral(lit1);

        // There is now one literal in the list

        // Use multiple-entity add method
        // collection with 5 valid literals
        Collection<EnumerationLiteral> col1 = new ArrayList<EnumerationLiteral>();
        EnumerationLiteral value1 = new EnumerationLiteralImpl();
        EnumerationLiteral value2 = new EnumerationLiteralImpl();
        EnumerationLiteral value3 = new EnumerationLiteralImpl();
        EnumerationLiteral value4 = new EnumerationLiteralImpl();
        EnumerationLiteral value5 = new EnumerationLiteralImpl();
        col1.add(value1);
        col1.add(value2);
        col1.add(value3);
        col1.add(value4);
        col1.add(value5);

        enumeration.addLiterals(col1);
        // There will now be 6 literals in the list

        // Use single-entity, indexed add method, using lit1 again
        enumeration.addLiteral(2, lit1);

        // There are now 7 literals in the list, with
        // another lit1 in third spot

        // Use multiple-entity, indexed add method
        // collection with 2 valid literals
        Collection<EnumerationLiteral> col2 = new ArrayList<EnumerationLiteral>();
        col2.add(value2);
        col2.add(value4);
        enumeration.addLiterals(3, col2);

        // There will now be 9 literals in the list, with these two
        // literals in fourth and fifth spots

        // Use contains method to check for literal presence
        boolean present = enumeration.containsLiteral(lit1);

        // This will be true. It will locate the lit1 reference
        // in the first spot.

        // Use count method to get the number of literals
        int count = enumeration.countLiterals();

        // The count will be 9. Duplicates are counted as separate entities.

        // Use single-entity remove method
        boolean removed = enumeration.removeLiteral(lit1);

        // This will be true, and the list size is 8, regardless
        // if lit1 has duplicates in this list, which it does, and these
        // are not removed

        // Use multiple-entity remove method, using above col2
        boolean altered = enumeration.removeLiterals(col2);
        // This will be true, and the list size is 6

        // Use clear method
        enumeration.clearLiterals();

        // The list size is 0 and contains no literals
    }
}
