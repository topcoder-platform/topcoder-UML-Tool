/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import java.util.Collection;
import java.util.List;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import junit.framework.TestCase;

/**
 * This demo will show the api that is provided for a list attribute, a collection attribute and a simple attribute.
 *
 * @author DanLazar, fanse
 * @version 1.0
 */
public class Demo extends TestCase {
    /**
     * Demo for the api of a list attribute; Association class is used to show this.
     */
    public void testDemoListList() {
        Association association = new AssociationImpl();

        // add a connection
        AssociationEnd connection1 = new AssociationEndImpl();
        association.addConnection(connection1);

        // add another connection at the beginning of the list
        AssociationEnd connection2 = new AssociationEndImpl();
        association.addConnection(0, connection2);

        // set another connection on the second position of the list
        AssociationEnd connection3 = new AssociationEndImpl();
        association.setConnection(1, connection3);

        // get the number of the connections; the size=2
        System.out.println("size=" + association.countConnections());

        // get the index of connection3; it will be 1
        System.out.println("index=" + association.indexOfConnection(connection3));

        // check if connection3 is contained; it will print true
        System.out.println(association.containsConnection(connection3));

        // get a copy of the connection list
        List<AssociationEnd> conn = association.getConnections();

        // get the size of the conn; the size=2
        System.out.println("size=" + conn.size());

        // get the index of connection3; it will be 1
        System.out.println("index=" + conn.indexOf(connection3));

        // check if connection3 is contained; it will print true
        System.out.println(association.containsConnection(connection3));

        // remove connection3; it will print true
        System.out.println(association.removeConnection(connection3));

        // remove the connection at index 0
        AssociationEnd ae = association.removeConnection(0);

        // the returned value should be connection2. It will print true
        System.out.println(ae == connection2);

        // to clear all associations from the list the following call can be made
        association.clearConnections();
    }

    /**
     * Demo for a collection attribute; AssociationEnd class is used.
     */
    public void testDemoCollection() {
        AssociationEnd ae = new AssociationEndImpl();

        // add a 2 specifications
        Classifier specification1 = new ClassImpl();
        ae.addSpecification(specification1);
        Classifier specification2 = new ClassImpl();
        ae.addSpecification(specification2);

        // count specifications; it will print 2
        System.out.println(ae.countSpecifications());
        // check if specification2 is contained; it will print true
        System.out.println(ae.containsSpecification(specification2));

        // get a collection of all specifications
        Collection<Classifier> specs = ae.getSpecifications();

        // get the size of specs; it will print 2
        System.out.println(specs.size());
        // check if specification1 is contained; it will print true
        System.out.println(specs.contains(specification1));
        // check if specification2 is contained; it will print true
        System.out.println(specs.contains(specification2));

        // remove specification2; it will print true
        System.out.println(ae.removeSpecification(specification2));

        // clear all specifications
        ae.clearSpecifications();
    }

    /**
     * Demo for a simple attribute; Generalization class is used.
     */
    public void testDemoSimpleAttribute() {
        Generalization generalization = new GeneralizationImpl();

        // set the discriminator field; all the three calls are valid
        generalization.setDiscriminator(" ");
        generalization.setDiscriminator(null);
        generalization.setDiscriminator("test");

        // get the discriminator field
        System.out.println(generalization.getDiscriminator());
    }

    /**
     * AssociationClassImpl has an extra constructor (added for convenience).
     */
    public void testDemoAssoClassImpl() {
        Association association = new AssociationImpl();
        AssociationClass ac = new AssociationClassImpl(association);
        assertNotNull("AssociationClassImpl should have an extra constructor", ac);
    }
}
