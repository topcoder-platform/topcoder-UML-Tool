/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Collaborations Version 1.0
 *
 * @ DependencyImplTest.java
 */
package com.topcoder.uml.model.core.dependencies;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.ModelElement;

import junit.framework.TestCase;

/**
 * <p>Tests for DependencyImpl class.</p>
 *
 * @author yinzi
 * @version 1.0
 */
public class DependencyImplTests extends TestCase {
    /**
     * <p>MessageImpl used for testing. It is instantiated in SetUp.</p>
     */
    private DependencyImpl dependencyImpl;

    /**
     * <p>Sets up test environment, creates object used for test.</p>
     */
    public void setUp() {
        dependencyImpl = new DependencyImpl();
    }

    /**
     * <p>Tears down test environment, disposes object used for test.</p>
     */
    public void tearDown() {
        dependencyImpl = null;
    }

    /**
     * <p>Tests inheritance of <c>DependencyImpl</c>.</p>
     * <p><c>DependencyImpl</c> should inherit from <c>Dependency</c>.</p>
     */
    public void testDependencyImplAccuracyInheritDependency() {
        assertEquals("MessageImpl should inherit from Message.",
                true, dependencyImpl instanceof Dependency);
    }

    /**
     * <p>Tests accuracy of <c>DependencyImpl</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testDependencyImplAccuracy() {
        assertEquals("Value should be gotten correctly.",
                0, dependencyImpl.countSuppliers());
        assertEquals("Value should be gotten correctly.",
                0, dependencyImpl.countClients());
    }

    /**
     * <p>Tests <c>addSupplier(ModelElement)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testAddSupplier_Null() {
        try {
            dependencyImpl.addSupplier((ModelElement) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>addSupplier(ModelElement)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testAddSupplier_Accuracy() {
        ModelElement testObj = new ModelElementAbstractImpl() {};
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsSupplier(testObj));
        dependencyImpl.addSupplier(testObj);
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsSupplier(testObj));
    }

    /**
     * <p>Tests <c>addSupplier(Collection)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testAddSuppliers_Null() {
        try {
            dependencyImpl.addSuppliers((Collection<ModelElement>) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests <c>addSupplier(Collection)</c> method with collection contans
     * null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testAddSuppliers_ContainsNull() {
        try {
            Collection<ModelElement> collection = new ArrayList<ModelElement>();
            collection.add(new ModelElementAbstractImpl() {});
            collection.add(null);
            dependencyImpl.addSuppliers(collection);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>addSupplier(Collection)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testAddSuppliers_Accuracy() {
        Collection<ModelElement> collection = new ArrayList<ModelElement>();
        ModelElement testObj1 = new ModelElementAbstractImpl() {};
        collection.add(testObj1);
        ModelElement testObj2 = new ModelElementAbstractImpl() {};
        collection.add(testObj2);

        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsSupplier(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsSupplier(testObj2));
        dependencyImpl.addSuppliers(collection);
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsSupplier(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsSupplier(testObj2));
    }

    /**
     * <p>Tests <c>removeSupplier(ModelElement)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testRemoveSupplier_Null() {
        try {
            dependencyImpl.removeSupplier((ModelElement) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>removeSupplier(ModelElement)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveSupplier_Accuracy1() {
        ModelElement testObj = new ModelElementAbstractImpl() {};
        dependencyImpl.addSupplier(testObj);
        dependencyImpl.addSupplier(testObj);

        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.removeSupplier(testObj));
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsSupplier(testObj));
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.removeSupplier(testObj));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsSupplier(testObj));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.removeSupplier(testObj));
    }

    /**
     * <p>Tests accuracy of <c>removeSupplier(ModelElement)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveSupplier_Accuracy2() {
        ModelElement testObj = new ModelElementAbstractImpl() {};
        dependencyImpl.addSupplier(testObj);

        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.removeSupplier(testObj));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsSupplier(testObj));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.removeSupplier(testObj));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsSupplier(testObj));
    }

    /**
     * <p>Tests <c>removeSuppliers(Collection)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testRemoveSuppliers_Null() {
        try {
            dependencyImpl.removeSuppliers((Collection<ModelElement>) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests <c>removeSuppliers(Collection)</c> method with collection contains null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testRemoveSuppliers_ConainsNull() {
        try {
            Collection<ModelElement> collection = new ArrayList<ModelElement>();
            collection.add(new ModelElementAbstractImpl() {});
            collection.add(null);
            dependencyImpl.removeSuppliers(collection);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>removeSuppliers(ModelElement)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveSuppliers_Accuracy1() {
        ModelElement testObj1 = new ModelElementAbstractImpl() {};
        ModelElement testObj2 = new ModelElementAbstractImpl() {};
        dependencyImpl.addSupplier(testObj1);
        dependencyImpl.addSupplier(testObj2);
        dependencyImpl.addSupplier(testObj1);

        Collection<ModelElement> collection = new ArrayList<ModelElement>();
        collection.add(testObj1);
        collection.add(testObj2);
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsSupplier(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsSupplier(testObj2));
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.removeSuppliers(collection));

        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsSupplier(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsSupplier(testObj2));
    }

    /**
     * <p>Tests accuracy of <c>removeSuppliers(ModelElement)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveSuppliers_Accuracy2() {
        ModelElement testObj1 = new ModelElementAbstractImpl() {};
        ModelElement testObj2 = new ModelElementAbstractImpl() {};
        dependencyImpl.addSupplier(testObj1);
        dependencyImpl.addSupplier(testObj2);

        Collection<ModelElement> collection = new ArrayList<ModelElement>();
        collection.add(testObj1);
        collection.add(testObj2);
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsSupplier(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsSupplier(testObj2));
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.removeSuppliers(collection));

        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsSupplier(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsSupplier(testObj2));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.removeSuppliers(collection));

    }

    /**
     * <p>Tests accuracy of <c>clearSuppliers()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testClearSuppliers_Accuracy() {
        ModelElement testObj1 = new ModelElementAbstractImpl() {};
        ModelElement testObj2 = new ModelElementAbstractImpl() {};
        dependencyImpl.addSupplier(testObj1);
        dependencyImpl.addSupplier(testObj2);
        assertEquals("Value should be gotten correctly.",
                2, dependencyImpl.countSuppliers());
        dependencyImpl.clearSuppliers();
        assertEquals("Value should be gotten correctly.",
                0, dependencyImpl.countSuppliers());
    }

    /**
     * <p>Tests accuracy of <c>getSuppliers()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testGetSuppliers_Accuracy() {
        ModelElement testObj1 = new ModelElementAbstractImpl() {};
        ModelElement testObj2 = new ModelElementAbstractImpl() {};
        ModelElement testObj3 = new ModelElementAbstractImpl() {};
        dependencyImpl.addSupplier(testObj1);
        dependencyImpl.addSupplier(testObj2);
        dependencyImpl.addSupplier(testObj2);
        Collection<ModelElement> collection = dependencyImpl.getSuppliers();
        assertEquals("Value should be gotten correctly.",
                true, collection.contains(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collection.contains(testObj2));
        assertEquals("Value should be gotten correctly.",
                false, collection.contains(testObj3));
    }

    /**
     * <p>Tests <c>containsSupplier(ModelElement)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testContainsSupplier_Null() {
        try {
            dependencyImpl.containsSupplier((ModelElement) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>containsSupplier(ModelElement)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testContainsSupplier_Accuracy() {
        ModelElement testObj = new ModelElementAbstractImpl() {};
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsSupplier(testObj));
        dependencyImpl.addSupplier(testObj);
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsSupplier(testObj));
    }

    /**
     * <p>Tests accuracy of <c>countSuppliers()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testcountSuppliers_Accuracy() {
        assertEquals("Value should be gotten correctly.",
                0, dependencyImpl.countSuppliers());
        ModelElement testObj = new ModelElementAbstractImpl() {};
        dependencyImpl.addSupplier(testObj);
        assertEquals("Value should be gotten correctly.",
                1, dependencyImpl.countSuppliers());
        dependencyImpl.addSupplier(testObj);
        dependencyImpl.addSupplier(testObj);
        assertEquals("Value should be gotten correctly.",
                3, dependencyImpl.countSuppliers());
    }

    /**
     * <p>Tests <c>addClient(ModelElement)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testAddClient_Null() {
        try {
            dependencyImpl.addClient((ModelElement) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>addParticipatingModelElement(ModelElement)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testAddParticipatingModelElement_Accuracy() {
        ModelElement testObj = new ModelElementAbstractImpl() {};
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsClient(testObj));
        dependencyImpl.addClient(testObj);
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsClient(testObj));
    }

    /**
     * <p>Tests <c>addClient(Collection)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testAddClients_Null() {
        try {
            dependencyImpl.addClients((Collection<ModelElement>) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests <c>addClient(Collection)</c> method with collection contans
     * null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testAddClients_ContainsNull() {
        try {
            Collection<ModelElement> collection = new ArrayList<ModelElement>();
            collection.add(new ModelElementAbstractImpl() {});
            collection.add(null);
            dependencyImpl.addClients(collection);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>addClient(Collection)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testAddClients_Accuracy() {
        Collection<ModelElement> collection = new ArrayList<ModelElement>();
        ModelElement testObj1 = new ModelElementAbstractImpl() {};
        collection.add(testObj1);
        ModelElement testObj2 = new ModelElementAbstractImpl() {};
        collection.add(testObj2);

        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsClient(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsClient(testObj2));
        dependencyImpl.addClients(collection);
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsClient(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsClient(testObj2));
    }

    /**
     * <p>Tests <c>removeClient(ModelElement)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testRemoveClient_Null() {
        try {
            dependencyImpl.removeClient((ModelElement) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>removeClient(ModelElement)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveClient_Accuracy1() {
        ModelElement testObj = new ModelElementAbstractImpl() {};
        dependencyImpl.addClient(testObj);
        dependencyImpl.addClient(testObj);

        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.removeClient(testObj));
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsClient(testObj));
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.removeClient(testObj));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsClient(testObj));
    }

    /**
     * <p>Tests accuracy of <c>removeClient(ModelElement)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveClient_Accuracy2() {
        ModelElement testObj = new ModelElementAbstractImpl() {};
        dependencyImpl.addClient(testObj);

        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.removeClient(testObj));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsClient(testObj));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.removeClient(testObj));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsClient(testObj));
    }

    /**
     * <p>Tests <c>removeClients(Collection)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testRemoveClients_Null() {
        try {
            dependencyImpl.removeClients((Collection<ModelElement>) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests <c>removeClients(Collection)</c> method with collection contains null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testRemoveClients_ConainsNull() {
        try {
            Collection<ModelElement> collection = new ArrayList<ModelElement>();
            collection.add(new ModelElementAbstractImpl() {});
            collection.add(null);
            dependencyImpl.removeClients(collection);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>removeClients(ModelElement)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveClients_Accuracy1() {
        ModelElement testObj1 = new ModelElementAbstractImpl() {};
        ModelElement testObj2 = new ModelElementAbstractImpl() {};
        dependencyImpl.addClient(testObj1);
        dependencyImpl.addClient(testObj2);
        dependencyImpl.addClient(testObj1);

        Collection<ModelElement> collection = new ArrayList<ModelElement>();
        collection.add(testObj1);
        collection.add(testObj2);
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsClient(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsClient(testObj2));
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.removeClients(collection));
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsClient(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsClient(testObj2));
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.removeClients(collection));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsClient(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsClient(testObj2));
    }
    /**
     * <p>Tests accuracy of <c>removeClients(ModelElement)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveClients_Accuracy2() {
        ModelElement testObj1 = new ModelElementAbstractImpl() {};
        ModelElement testObj2 = new ModelElementAbstractImpl() {};
        dependencyImpl.addClient(testObj1);
        dependencyImpl.addClient(testObj2);

        Collection<ModelElement> collection = new ArrayList<ModelElement>();
        collection.add(testObj1);
        collection.add(testObj2);
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsClient(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsClient(testObj2));
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.removeClients(collection));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsClient(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsClient(testObj2));
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.removeClients(collection));
    }

    /**
     * <p>Tests accuracy of <c>clearClients()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testClearClients_Accuracy() {
        ModelElement testObj1 = new ModelElementAbstractImpl() {};
        ModelElement testObj2 = new ModelElementAbstractImpl() {};
        dependencyImpl.addClient(testObj1);
        dependencyImpl.addClient(testObj2);
        assertEquals("Value should be gotten correctly.",
                2, dependencyImpl.countClients());
        dependencyImpl.clearClients();
        assertEquals("Value should be gotten correctly.",
                0, dependencyImpl.countClients());
    }

    /**
     * <p>Tests accuracy of <c>getClients()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testGetClients_Accuracy() {
        ModelElement testObj1 = new ModelElementAbstractImpl() {};
        ModelElement testObj2 = new ModelElementAbstractImpl() {};
        ModelElement testObj3 = new ModelElementAbstractImpl() {};
        dependencyImpl.addClient(testObj1);
        dependencyImpl.addClient(testObj2);
        dependencyImpl.addClient(testObj2);
        Collection<ModelElement> collection = dependencyImpl.getClients();
        assertEquals("Value should be gotten correctly.",
                true, collection.contains(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collection.contains(testObj2));
        assertEquals("Value should be gotten correctly.",
                false, collection.contains(testObj3));
    }

    /**
     * <p>Tests <c>containsClient(ModelElement)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testContainsClient_Null() {
        try {
            dependencyImpl.containsClient((ModelElement) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>containsClient(ModelElement)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testContainsClient_Accuracy() {
        ModelElement testObj = new ModelElementAbstractImpl() {};
        assertEquals("Value should be gotten correctly.",
                false, dependencyImpl.containsClient(testObj));
        dependencyImpl.addClient(testObj);
        assertEquals("Value should be gotten correctly.",
                true, dependencyImpl.containsClient(testObj));
    }

    /**
     * <p>Tests accuracy of <c>countClients()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testcountClients_Accuracy() {
        assertEquals("Value should be gotten correctly.",
                0, dependencyImpl.countClients());
        ModelElement testObj = new ModelElementAbstractImpl() {};
        dependencyImpl.addClient(testObj);
        assertEquals("Value should be gotten correctly.",
                1, dependencyImpl.countClients());
        dependencyImpl.addClient(testObj);
        dependencyImpl.addClient(testObj);
        assertEquals("Value should be gotten correctly.",
                3, dependencyImpl.countClients());
    }

}
