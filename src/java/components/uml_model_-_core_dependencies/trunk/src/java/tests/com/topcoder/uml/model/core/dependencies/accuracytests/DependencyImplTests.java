/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.dependencies.accuracytests;
import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.core.relationships.RelationshipAbstractImpl;

/**
 * <p>Unit test for DependencyImpl.</p>
 *
 * @author singlewood
 * @version 1.0
 */
public class DependencyImplTests extends TestCase {
    /**
     * Instance of DependencyImpl for test.
     */
    private DependencyImpl dependencyImpl;

    /**
     * Instance of ModelElement for test.
     */
    private ModelElement[] modelElementArray;

    /**
     * Instance of Collection for test.
     */
    private Collection<ModelElement> collection;

    /**
     * Set up for tests.
     *
     * @throws Exception throw to JUnit.
     */
    protected void setUp() throws Exception {
        dependencyImpl = new DependencyImpl();
        modelElementArray = new ModelElement[10];
        collection = new ArrayList<ModelElement>();
        for (int i = 0; i < modelElementArray.length; i++) {
            modelElementArray[i] = new ModelElementImplAcc(i);
            collection.add(modelElementArray[i]);
        }
    }

    /**
     * Test constructor.
     *
     * @throws Exception throw to JUnit.
     */
    public void testConstructor() throws Exception {
        dependencyImpl = new DependencyImpl();
        assertNotNull(dependencyImpl);
    }

    /**
     * Test if the DependencyImpl extends RelationshipAbstractImpl.
     *
     * @throws Exception throw to JUnit.
     */
    public void testExtendsDependencyImpl() throws Exception {
        assertTrue("DependencyImpl didn't extends RelationshipAbstractImpl",
                dependencyImpl instanceof RelationshipAbstractImpl);
    }

    /**
     * Test if the DependencyImpl implement Dependency.
     *
     * @throws Exception throw to JUnit.
     */
    public void testDependencyImpl() throws Exception {
        assertTrue("DependencyImpl didn't implement Dependency", dependencyImpl instanceof Dependency);
    }

    /**
     * Test addSupplier. See if it correctly add the ModelElement to the dependencyImpl.
     *
     * @throws Exception throw to JUnit.
     */
    public void testAddSupplier() throws Exception {
        dependencyImpl.addSupplier(modelElementArray[0]);
        assertEquals("DependencyImpl#addSupplier doesn't work properly.", 1, dependencyImpl.getSuppliers().size());

        ArrayList<ModelElement> list = (ArrayList<ModelElement>) dependencyImpl.getSuppliers();
        ModelElementImplAcc acc = (ModelElementImplAcc) list.get(0);
        assertEquals("The suppliers doesn't successfully added to dependencyImpl",
                ((ModelElementImplAcc) modelElementArray[0]).getI(), acc.getI());
    }

    /**
     * Test addSuppliers. See if it correctly add the ModelElements to the dependencyImpl.
     *
     * @throws Exception throw to JUnit.
     */
    public void testAddSuppliers() throws Exception {
        dependencyImpl.addSuppliers(collection);
        assertEquals("DependencyImpl#addSuppliers doesn't work properly.", 10, dependencyImpl.getSuppliers().size());

        // Test every element in the suppliers.
        ArrayList<ModelElement> list = (ArrayList<ModelElement>) dependencyImpl.getSuppliers();
        for (ModelElement element : list) {
            assertTrue("The suppliers doesn't successfully added to dependencyImpl",
                    collection.contains(element));
        }
    }

    /**
     * Test removeSupplier. See if it correctly remove an element from dependencyImpl.
     *
     * @throws Exception throw to JUnit.
     */
    public void testRemoveSupplierSuccess() throws Exception {
        //Add test collection to dependencyImpl.
        dependencyImpl.addSuppliers(collection);
        assertEquals("DependencyImpl#addSuppliers doesn't work properly.", 10, dependencyImpl.getSuppliers().size());

        // Remove one element.
        assertTrue("Remove failed.", dependencyImpl.removeSupplier(modelElementArray[5]));
        assertEquals("DependencyImpl#removeSupplier doesn't work properly.", 9, dependencyImpl.getSuppliers().size());

        // Test every element in the suppliers.
        ArrayList<ModelElement> list = (ArrayList<ModelElement>) dependencyImpl.getSuppliers();
        assertFalse("the element was not removed successfully.", list.contains(modelElementArray[5]));
    }

    /**
     * Test removeSupplier. The element to be removed doesn't contained in dependencyImpl.
     *
     * @throws Exception throw to JUnit.
     */
    public void testRemoveSupplierFailure() throws Exception {
        //Add test collection to dependencyImpl.
        dependencyImpl.addSuppliers(collection);
        assertEquals("DependencyImpl#addSuppliers doesn't work properly.", 10, dependencyImpl.getSuppliers().size());

        // Remove the element.
        assertFalse("Remove failed.", dependencyImpl.removeSupplier(new ModelElementAbstractImpl() {}));
        assertEquals("DependencyImpl#removeSupplier doesn't work properly.", 10, dependencyImpl.getSuppliers().size());
    }

    /**
     * Test removeSuppliers.  See if it correctly remove all the element from dependencyImpl.
     *
     * @throws Exception throw to JUnit.
     */
    public void testRemoveSuppliersSuccess() throws Exception {
        //Add test collection to dependencyImpl.
        dependencyImpl.addSuppliers(collection);
        assertEquals("DependencyImpl#addSuppliers doesn't work properly.", 10, dependencyImpl.getSuppliers().size());

        // Remove the element.
        assertTrue("Remove failed.", dependencyImpl.removeSuppliers(collection));
        assertEquals("DependencyImpl#removeSuppliers doesn't work properly.", 0, dependencyImpl.getSuppliers().size());
    }

    /**
     * Test removeSuppliers.  See if it correctly remove all the element from dependencyImpl.
     *
     * @throws Exception throw to JUnit.
     */
    public void testRemoveSuppliersSuccess2() throws Exception {
        //Add test collection to dependencyImpl.
        dependencyImpl.addSuppliers(collection);
        assertEquals("DependencyImpl#addSuppliers doesn't work properly.", 10, dependencyImpl.getSuppliers().size());

        // Add an extra ModelElement to collection.
        collection.add(new ModelElementAbstractImpl() {});

        // Remove the element.
        assertTrue("Remove failed.", dependencyImpl.removeSuppliers(collection));
        assertEquals("DependencyImpl#removeSuppliers doesn't work properly.", 0, dependencyImpl.getSuppliers().size());
    }

    /**
     * Test clearSuppliers.  See if it clear all the element in the collection.
     *
     * @throws Exception throw to JUnit.
     */
    public void testClearSuppliers() throws Exception {
        //Add test collection to dependencyImpl.
        dependencyImpl.addSuppliers(collection);
        assertEquals("DependencyImpl#addSuppliers doesn't work properly.", 10, dependencyImpl.getSuppliers().size());

        // Remove the element.
        dependencyImpl.clearSuppliers();
        assertEquals("DependencyImpl#clearSuppliers doesn't work properly.", 0, dependencyImpl.getSuppliers().size());
    }

    /**
     * Test getSuppliers.  See if it can get the shallow copy of suppliers.
     *
     * @throws Exception throw to JUnit.
     */
    public void testGetSuppliers() throws Exception {
        //Add test collection to dependencyImpl.
        dependencyImpl.addSuppliers(collection);
        assertEquals("DependencyImpl#addSuppliers doesn't work properly.", 10, dependencyImpl.getSuppliers().size());

        // Test every element in the suppliers.
        ArrayList<ModelElement> list = (ArrayList<ModelElement>) dependencyImpl.getSuppliers();
        for (ModelElement element : list) {
            assertTrue("The suppliers doesn't successfully added to dependencyImpl",
                    collection.contains(element));
        }

        // shallow copy test.
        Collection<ModelElement> innerSuppliers =
            (Collection<ModelElement>) AccuracyHelper
            .getPrivateField(DependencyImpl.class, dependencyImpl, "suppliers");

        assertNotSame("shallow copy failed.", innerSuppliers, dependencyImpl.getSuppliers());
    }

    /**
     * Test containsSupplier.  See if it correctly judge the existence of element.
     *
     * @throws Exception throw to JUnit.
     */
    public void testContainsSupplier() throws Exception {
        //Add test collection to dependencyImpl.
        dependencyImpl.addSuppliers(collection);
        for (int i = 0; i < modelElementArray.length; i++) {
            assertTrue("DependencyImpl#containsSupplier doesn't work properly.",
                    dependencyImpl.containsSupplier((modelElementArray[i])));
        }
        assertFalse("DependencyImpl#clearSuppliers doesn't work properly.",
                dependencyImpl.containsSupplier(new ModelElementAbstractImpl() {}));
    }

    /**
     * Test countSuppliers.  See if it correctly count the size of inner list.
     *
     * @throws Exception throw to JUnit.
     */
    public void testCountSuppliers() throws Exception {
        //Add test collection to dependencyImpl.
        dependencyImpl.addSuppliers(collection);
        assertEquals("DependencyImpl#addSuppliers doesn't work properly.", 10, dependencyImpl.getSuppliers().size());

        assertEquals("DependencyImpl#clearSuppliers doesn't work properly.", 10, dependencyImpl.countSuppliers());
    }

    /**
     * Test addClient. See if it correctly add the ModelElement to the dependencyImpl.
     *
     * @throws Exception throw to JUnit.
     */
    public void testAddClient() throws Exception {
        dependencyImpl.addClient(modelElementArray[0]);
        assertEquals("DependencyImpl#addClient doesn't work properly.", 1, dependencyImpl.getClients().size());

        ArrayList<ModelElement> list = (ArrayList<ModelElement>) dependencyImpl.getClients();
        ModelElementImplAcc acc = (ModelElementImplAcc) list.get(0);
        assertEquals("The suppliers doesn't successfully added to dependencyImpl",
                ((ModelElementImplAcc) modelElementArray[0]).getI(), acc.getI());
    }

    /**
     * Test addClients. See if it correctly add the ModelElements to the dependencyImpl.
     *
     * @throws Exception throw to JUnit.
     */
    public void testAddClients() throws Exception {
        dependencyImpl.addClients(collection);
        assertEquals("DependencyImpl#addClients doesn't work properly.", 10, dependencyImpl.getClients().size());

        // Test every element in the suppliers.
        ArrayList<ModelElement> list = (ArrayList<ModelElement>) dependencyImpl.getClients();
        for (ModelElement element : list) {
            assertTrue("The suppliers doesn't successfully added to dependencyImpl",
                    collection.contains(element));
        }
    }

    /**
     * Test removeClient. See if it correctly remove an element from dependencyImpl.
     *
     * @throws Exception throw to JUnit.
     */
    public void testRemoveClientSuccess() throws Exception {
        //Add test collection to dependencyImpl.
        dependencyImpl.addClients(collection);
        assertEquals("DependencyImpl#addClients doesn't work properly.", 10, dependencyImpl.getClients().size());

        // Remove one element.
        assertTrue("Remove failed.", dependencyImpl.removeClient(modelElementArray[5]));
        assertEquals("DependencyImpl#removeClient doesn't work properly.", 9, dependencyImpl.getClients().size());

        // Test every element in the suppliers.
        ArrayList<ModelElement> list = (ArrayList<ModelElement>) dependencyImpl.getClients();
        assertFalse("the element was not removed successfully.", list.contains(modelElementArray[5]));
    }

    /**
     * Test removeClient. The element to be removed doesn't contained in dependencyImpl.
     *
     * @throws Exception throw to JUnit.
     */
    public void testRemoveClientFailure() throws Exception {
        //Add test collection to dependencyImpl.
        dependencyImpl.addClients(collection);
        assertEquals("DependencyImpl#addClients doesn't work properly.", 10, dependencyImpl.getClients().size());

        // Remove the element.
        assertFalse("Remove failed.", dependencyImpl.removeClient(new ModelElementAbstractImpl() {}));
        assertEquals("DependencyImpl#removeClient doesn't work properly.", 10, dependencyImpl.getClients().size());
    }

    /**
     * Test removeClients.  See if it correctly remove all the element from dependencyImpl.
     *
     * @throws Exception throw to JUnit.
     */
    public void testRemoveClientsSuccess() throws Exception {
        //Add test collection to dependencyImpl.
        dependencyImpl.addClients(collection);
        assertEquals("DependencyImpl#addClients doesn't work properly.", 10, dependencyImpl.getClients().size());

        // Remove the element.
        assertTrue("Remove failed.", dependencyImpl.removeClients(collection));
        assertEquals("DependencyImpl#removeClients doesn't work properly.", 0, dependencyImpl.getClients().size());
    }

    /**
     * Test removeClients.  See if it correctly remove all the element from dependencyImpl.
     *
     * @throws Exception throw to JUnit.
     */
    public void testRemoveClientsSuccess2() throws Exception {
        //Add test collection to dependencyImpl.
        dependencyImpl.addClients(collection);
        assertEquals("DependencyImpl#addClients doesn't work properly.", 10, dependencyImpl.getClients().size());

        // Add an extra ModelElement to collection.
        collection.add(new ModelElementAbstractImpl() {});

        // Remove the element.
        assertTrue("Remove failed.", dependencyImpl.removeClients(collection));
        assertEquals("DependencyImpl#removeClients doesn't work properly.", 0, dependencyImpl.getClients().size());
    }

    /**
     * Test clearClients.  See if it clear all the element in the collection.
     *
     * @throws Exception throw to JUnit.
     */
    public void testClearClients() throws Exception {
        //Add test collection to dependencyImpl.
        dependencyImpl.addClients(collection);
        assertEquals("DependencyImpl#addClients doesn't work properly.", 10, dependencyImpl.getClients().size());

        // Remove the element.
        dependencyImpl.clearClients();
        assertEquals("DependencyImpl#clearClients doesn't work properly.", 0, dependencyImpl.getClients().size());
    }

    /**
     * Test getClients.  See if it can get the shallow copy of clients.
     *
     * @throws Exception throw to JUnit.
     */
    public void testGetClients() throws Exception {
        //Add test collection to dependencyImpl.
        dependencyImpl.addClients(collection);
        assertEquals("DependencyImpl#addClients doesn't work properly.", 10, dependencyImpl.getClients().size());

        // Test every element in the clients.
        ArrayList<ModelElement> list = (ArrayList<ModelElement>) dependencyImpl.getClients();
        for (ModelElement element : list) {
            assertTrue("The clients doesn't successfully added to dependencyImpl",
                    collection.contains(element));
        }

        // shallow copy test.
        Collection<ModelElement> innerClients =
            (Collection<ModelElement>) AccuracyHelper
            .getPrivateField(DependencyImpl.class, dependencyImpl, "clients");

        assertNotSame("shallow copy failed.", innerClients, dependencyImpl.getClients());
    }

    /**
     * Test containsClient.  See if it correctly judge the existence of element.
     *
     * @throws Exception throw to JUnit.
     */
    public void testContainsClient() throws Exception {
        //Add test collection to dependencyImpl.
        dependencyImpl.addClients(collection);
        for (int i = 0; i < modelElementArray.length; i++) {
            assertTrue("DependencyImpl#containsClient doesn't work properly.",
                    dependencyImpl.containsClient((modelElementArray[i])));
        }
        assertFalse("DependencyImpl#clearClients doesn't work properly.",
                dependencyImpl.containsClient(new ModelElementAbstractImpl() {}));
    }

    /**
     * Test countClients.  See if it correctly count the size of inner list.
     *
     * @throws Exception throw to JUnit.
     */
    public void testCountClients() throws Exception {
        //Add test collection to dependencyImpl.
        dependencyImpl.addClients(collection);
        assertEquals("DependencyImpl#addClients doesn't work properly.", 10, dependencyImpl.getClients().size());

        assertEquals("DependencyImpl#clearClients doesn't work properly.", 10, dependencyImpl.countClients());
    }
}
