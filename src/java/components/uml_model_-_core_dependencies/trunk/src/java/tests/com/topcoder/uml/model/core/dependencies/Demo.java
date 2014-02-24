/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Core Dependencies Version 1.0
 *
 * @ Demo.java
 */
package com.topcoder.uml.model.core.dependencies;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.datatypes.expressions.MappingExpression;
import com.topcoder.uml.model.datatypes.expressions.MappingExpressionImpl;

import junit.framework.TestCase;

/**
 * <p> The demo will demonstrate the usage of these beans. It will show them being instantiated,
 * then used via their interface. This will be the typical usage of such simple entities under any
 * scenario. This demo will focus on showing how a simple, collection, and list attribute is managed,
 * with the understanding that all other attributes are managed in exactly the same manner, and
 * therefore not shown here. </p>
 *
 * @author yinzi
 * @version 1.0
 */
public class Demo extends TestCase {

    /**
     * Create an instance of sample entity: Abstraction. All other concrete entities are instantiated
     * in this manner and are not shown here.
     */
    public void testInstantiationDemo() {
        // Create an instance of Usage
        Usage usage = new UsageImpl();

        // Create an instance of Abstraction
        Abstraction abstraction = new AbstractionImpl();

        // Create an instance of MappingExpression
        MappingExpression mapping = new MappingExpressionImpl();

        // Use setter
        abstraction.setMapping(mapping);
        // Use getter
        MappingExpression retrievedMapping = abstraction.getMapping();
    }

    /**
     * Manage a collection attribute: Dependency.suppliers. All other collection attributes are managed
     * in this manner and are not shown here.
     */
    public void testCollectionDemo() {
        // Create sample entity with a collection attribute to manage
        Dependency dependency = new DependencyImpl();

        // Use single-entity add method
        ModelElement supp1 = new ModelElementAbstractImpl() {};
        dependency.addSupplier(supp1);
        // There is now one supplier in the collection
        // Use multiple-entity add method
        Collection<ModelElement> col1 = new ArrayList<ModelElement>();
        ModelElement supp2 = new ModelElementAbstractImpl() {};
        ModelElement supp3 = new ModelElementAbstractImpl() {};

        // collection with 3 valid suppliers
        col1.add(supp1);
        col1.add(supp2);
        col1.add(supp3);
        dependency.addSuppliers(col1);

        // There will now be 4 suppliers in the collection
        // Use contains method to check for supplier presence
        // This will be true
        boolean present1 = dependency.containsSupplier(supp1);
        boolean present2 = dependency.containsSupplier(supp2);
        boolean present3 = dependency.containsSupplier(supp3);

        // Use count method to get the number of suppliers
        // The count will be 4
        int count = dependency.countSuppliers();

        // Get the Collection
        Collection<ModelElement> collection = dependency.getSuppliers();

        // Use single-entity remove method
        // This will be true, and the collection size is 3
        boolean removed = dependency.removeSupplier(supp1);


        // if supp1 has duplicates in this collection.
        // Use multiple-entity remove method
        Collection<ModelElement> col2 = new ArrayList<ModelElement>();
        col2.add(supp2);
        col2.add(supp3);

        // This will be true, and the collection size is 1
        boolean altered = dependency.removeSuppliers(col2);

        // Use clear method
        // The collection size is 0 and contains no suppliers
        dependency.clearSuppliers();


        // Use single-entity add method
        ModelElement client1 = new ModelElementAbstractImpl() {};
        dependency.addClient(client1);
        // There is now one supplier in the collection
        // Use multiple-entity add method
        Collection<ModelElement> col3 = new ArrayList<ModelElement>();
        ModelElement client2 = new ModelElementAbstractImpl() {};
        ModelElement client3 = new ModelElementAbstractImpl() {};

        // collection with 3 valid suppliers
        col3.add(client1);
        col3.add(client2);
        col3.add(client3);
        dependency.addClients(col3);

        // There will now be 4 suppliers in the collection
        // Use contains method to check for supplier presence
        // This will be true
        present1 = dependency.containsClient(client1);
        present2 = dependency.containsClient(client2);
        present3 = dependency.containsClient(client3);

        // Use count method to get the number of suppliers
        // The count will be 4
        count = dependency.countClients();

        // Get the Collection
        collection = dependency.getClients();

        // Use single-entity remove method
        // This will be true, and the collection size is 3
        removed = dependency.removeClient(client1);


        // if client1 has duplicates in this collection.
        // Use multiple-entity remove method
        Collection<ModelElement> col4 = new ArrayList<ModelElement>();
        col4.add(client2);
        col4.add(client3);

        // This will be true, and the collection size is 1
        altered = dependency.removeClients(col4);

        // Use clear method
        // The collection size is 0 and contains no suppliers
        dependency.clearClients();
    }


    /**
     * Manage a collection attribute: Binding.arguments.
     */
    public void testListDemo() {
        // Create sample entity with a list attribute to manage
        Binding binding = new BindingImpl();

        // Use single-entity add method
        TemplateArgument arg1 = new TemplateArgumentImpl();
        // There is now one argument in the list
        binding.addArgument(arg1);

        // Use multiple-entity add method
        Collection<TemplateArgument> col1 = new ArrayList<TemplateArgument>();
        TemplateArgument arg2 = new TemplateArgumentImpl();
        TemplateArgument arg3 = new TemplateArgumentImpl();
        //collection with 3 valid arguments
        col1.add(arg1);
        col1.add(arg2);
        col1.add(arg3);
        // There will now be 4 arguments in the list
        binding.addArguments(col1);

        // Use single-entity, indexed add method, using arg1 again
        binding.addArgument(2, arg1);
        // There are now 5 arguments in the list, with another arg1 in third spot

        // Use multiple-entity, indexed add method
        Collection<TemplateArgument> col2 = new ArrayList<TemplateArgument>();
        //collection with 2 valid arguments
        col2.add(arg2);
        col2.add(arg3);
        // There will now be 7 arguments in the list, with these two
        // arguments in fourth and fifth spots
        binding.addArguments(3, col2);

        // Set the Argument
        binding.setArgument(5, arg1);

        // Get the Collection
        Collection<TemplateArgument> collection = binding.getArguments();

        // Gets the index of the appearance of the TemplateArgument
        int n = binding.indexOfArgument(arg2);

        // Use contains method to check for argument presence
        // This will be true. It will locate the arg1 reference in the first spot.
        boolean present = binding.containsArgument(arg1);

        // Use count method to get the number of arguments
        // The count will be 7. Duplicates are counted as separate entities.
        int count = binding.countArguments();

        // Removes the TemplateArgument instance at the index position
        TemplateArgument arg4 = binding.removeArgument(5);

        // Use single-entity remove method
        // This will be true, and the list size is 6, regardless if arg1 has duplicates
        // in this list, which it does, and these are not removed
        boolean removed = binding.removeArgument(arg1);

        // Use multiple-entity remove method, using above col2
        // This will be true, and the list size is 4
        boolean altered = binding.removeArguments(col2);

        // Use clear method
        // The list size is 0 and contains no arguments
        binding.clearArguments();
    }
}
