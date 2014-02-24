/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkEnd;
import com.topcoder.uml.model.commonbehavior.links.LinkEndImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;

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
 * any scenario. This demo will focus on showing how a simple, collection, and list attribute
 * is managed, with the understanding that all other attributes are managed in exactly the same
 * manner, and therefore not shown here.
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
        //Create an instance of sample entity: Procedure. All other concrete entities are
        //instantiated in this manner and are not shown here.

        // Create an instance of sample entity
        Procedure procedure = new ProcedureImpl();
    }

    /**
     * Simple demo, Simple attribute management.
     *
     */
    public void testDemo2() {
        //4.3.2 Simple attribute management
        //Manage a simple attribute: Procedure.expression. All other simple attributes are
        //managed in this manner and are not shown here.

        // Create sample entity with a simple attribute to manage
        Procedure procedure = new ProcedureImpl();

        // Use setter
        Expression expression = new ExpressionImpl();
        procedure.setExpression(expression);

        // Use getter
        Expression retrievedExpression = procedure.getExpression();
    }

    /**
     * Simple demo, Collection attribute management.
     *
     */
    public void testDemo3() {
        //4.3.3 Collection attribute management
        //Manage a collection attribute: Link.stimuli. All other collection attributes
        //are managed in this manner and are not shown here.

        // Create sample entity with a collection attribute to manage
        Link link = new LinkImpl();

        // Use single-entity add method
        Stimulus stim1 = new StimulusImpl();
        link.addStimulus(stim1);

        // There is now one stimulus in the collection

        // Use multiple-entity add method
        //collection with 5 valid stimuli
        Collection<Stimulus> col1 = new ArrayList<Stimulus>();
        Stimulus value1 = new StimulusImpl();
        Stimulus value2 = new StimulusImpl();
        Stimulus value3 = new StimulusImpl();
        Stimulus value4 = new StimulusImpl();
        Stimulus value5 = new StimulusImpl();
        col1.add(value1);
        col1.add(value2);
        col1.add(value3);
        col1.add(value4);
        col1.add(value5);

        link.addStimuli(col1);

        // There will now be 6 stimuli in the collection

        // Use contains method to check for stimulus presence
        boolean present = link.containsStimulus(stim1);

        // This will be true

        // Use count method to get the number of stimuli
        int count = link.countStimuli();

        // The count will be 6

        // Use single-entity remove method
        boolean removed = link.removeStimulus(stim1);

        // This will be true, and the collection size is 5, regardless
        // if stim1 has duplicates in this collection.

        // Use multiple-entity remove method
        //     collection with 3 valid stimuli, which is a subset of col1.
        Collection<Stimulus> col2 = new ArrayList<Stimulus>();
        col2.add(value1);
        col2.add(value3);
        col2.add(value4);

        boolean altered = link.removeStimuli(col2);
        // This will be true, and the collection size is 2

        // Use clear method
        link.clearStimuli();

        // The collection size is 0 and contains no stimuli
    }

    /**
     * Simple demo, List attribute management.
     *
     */
    public void testDemo4() {
        //4.3.4 List attribute management
        //Manage a list attribute: Link.connections.

        // Create sample entity with a list attribute to manage
        Link link = new LinkImpl();

        // Use single-entity add method
        LinkEnd conn1 = new LinkEndImpl();
        link.addConnection(conn1);

        // There is now one connection in the list

        // Use multiple-entity add method
        //     collection with 5 valid connections
        Collection<LinkEnd> col1 = new ArrayList<LinkEnd>();
        LinkEnd value1 = new LinkEndImpl();
        LinkEnd value2 = new LinkEndImpl();
        LinkEnd value3 = new LinkEndImpl();
        LinkEnd value4 = new LinkEndImpl();
        LinkEnd value5 = new LinkEndImpl();
        col1.add(value1);
        col1.add(value2);
        col1.add(value3);
        col1.add(value4);
        col1.add(value5);
        link.addConnections(col1);
        // There will now be 6 connections in the list

        // Use single-entity, indexed add method, using conn1 again
        link.addConnection(2, conn1);

        // There are now 7 connections in the list, with
        // another conn1 in third spot

        // Use multiple-entity, indexed add method
        //     collection with 2 valid connections
        Collection<LinkEnd> col2 = new ArrayList<LinkEnd>();
        col2.add(value2);
        col2.add(value3);
        link.addConnections(3, col2);

        // There will now be 9 connections in the list, with these two
        // connections in fourth and fifth spots

        // Use contains method to check for connection presence
        boolean present = link.containsConnection(conn1);

        // This will be true. It will locate the conn1 reference
        // in the first spot.

        // Use count method to get the number of connections
        int count = link.countConnections();

        // The count will be 9. Duplicates are counted as separate entities.

        // Use single-entity remove method
        boolean removed = link.removeConnection(conn1);

        // This will be true, and the list size is 8, regardless
        // if conn1 has duplicates in this list, which it does, and these
        // are not removed

        // Use multiple-entity remove method, using above col2
        boolean altered = link.removeConnections(col2);
        // This will be true, and the list size is 6

        // Use clear method
        link.clearConnections();

        // The list size is 0 and contains no connections
    }
}
