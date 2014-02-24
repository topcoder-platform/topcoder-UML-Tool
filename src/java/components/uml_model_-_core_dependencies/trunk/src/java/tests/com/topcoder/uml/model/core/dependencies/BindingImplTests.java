/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Core Dependencies Version 1.0
 *
 * @ BindingImplTests.java
 */
package com.topcoder.uml.model.core.dependencies;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;

import junit.framework.TestCase;

/**
 * <p>Tests for BindingImpl class.</p>
 *
 * @author yinzi
 * @version 1.0
 */
public class BindingImplTests extends TestCase {
    /**
     * <p>BindingImpl used for testing. It is instantiated in SetUp.</p>
     */
    private BindingImpl bindingImpl;

    /**
     * <p>Sets up test environment, creates object used for test.</p>
     */
    public void setUp() {
        bindingImpl = new BindingImpl();
    }

    /**
     * <p>Tears down test environment, disposes object used for test.</p>
     */
    public void tearDown() {
        bindingImpl = null;
    }

    /**
     * <p>Tests inheritance of <c>BindingImpl</c>.</p>
     * <p><c>BindingImpl</c> should inherit from <c>Binding</c>.</p>
     */
    public void testBindingImplAccuracyInheritBinding() {
        assertEquals("MessageImpl should inherit from Message.",
                true, bindingImpl instanceof Binding);
    }

    /**
     * <p>Tests accuracy of <c>BindingImpl</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testBindingImplAccuracy() {
        assertEquals("Value should be gotten correctly.",
                0, bindingImpl.countArguments());
    }

    /**
     * <p>Tests the <c>addArgument(TemplateArgument)</c> with null object.</p>
     * <p> <code>IllegalArgumentException</code> should be thrown.</p>
     */
    public void testAddArgument1_Null() {
        try {
            bindingImpl.addArgument((TemplateArgument) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * <p>Tests the accuracy of <c>addArgument(TemplateArgument)</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testAddArgument1_Accuracy() {
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        TemplateArgument testObj3 = new TemplateArgumentImpl();
        bindingImpl.addArgument(testObj1);
        bindingImpl.addArgument(testObj2);
        bindingImpl.addArgument(testObj3);
        assertEquals("Value should be gotten correctly.", 0, bindingImpl.indexOfArgument(testObj1));
        assertEquals("Value should be gotten correctly.", 1, bindingImpl.indexOfArgument(testObj2));
        assertEquals("Value should be gotten correctly.", 2, bindingImpl.indexOfArgument(testObj3));
    }

    /**
     * <p>Tests the <c>addArgument(int, TemplateArgument)</c> with null object.</p>
     * <p> <code>IllegalArgumentException</code> should be thrown.</p>
     */
    public void testAddArgument2_Null() {
        try {
            bindingImpl.addArgument(0, (TemplateArgument) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * <p>Tests the <c>addArgument(int, TemplateArgument)</c> with negative index.</p>
     * <p> <code>IndexOutOfBoundsException</code> should be thrown.</p>
     */
    public void testAddArgument2_Negative() {
        try {
            bindingImpl.addArgument(-1, new TemplateArgumentImpl());
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            //ok
        }
    }

    /**
     * <p>Tests the <c>addArgument(int, TemplateArgument)</c> with big index.</p>
     * <p> <code>IndexOutOfBoundsException</code> should be thrown.</p>
     */
    public void testAddArgument2_OutOfRange() {
        try {
            bindingImpl.addArgument(new TemplateArgumentImpl());
            bindingImpl.addArgument(2, new TemplateArgumentImpl());
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            //ok
        }
    }

    /**
     * <p>Tests the accuracy of <c>addArgument(int TemplateArgument)</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testAddArgument2_Accuracy() {
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        TemplateArgument testObj3 = new TemplateArgumentImpl();
        bindingImpl.addArgument(0, testObj1);
        bindingImpl.addArgument(0, testObj2);
        bindingImpl.addArgument(1, testObj3);
        assertEquals("Value should be gotten correctly.", 2, bindingImpl.indexOfArgument(testObj1));
        assertEquals("Value should be gotten correctly.", 0, bindingImpl.indexOfArgument(testObj2));
        assertEquals("Value should be gotten correctly.", 1, bindingImpl.indexOfArgument(testObj3));
    }

    /**
     * <p>Tests the <c>addArguments(Collection)</c> with null object.</p>
     * <p> <code>IllegalArgumentException</code> should be thrown.</p>
     */
    public void testAddArguments1_Null() {
        try {
            bindingImpl.addArguments((Collection<TemplateArgument>) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * <p>Tests the <c>addArguments(Collection)</c> with collection contains null object.</p>
     * <p> <code>IllegalArgumentException</code> should be thrown.</p>
     */
    public void testAddArguments1_ContainsNull() {
        try {
            Collection<TemplateArgument> collection = new ArrayList<TemplateArgument>();
            collection.add(null);
            bindingImpl.addArguments(collection);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * <p>Tests the accuracy of <c>addArguments(Collection)</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testAddArguments1_Accuracy() {
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        TemplateArgument testObj3 = new TemplateArgumentImpl();
        TemplateArgument testObj4 = new TemplateArgumentImpl();
        bindingImpl.addArgument(testObj1);
        bindingImpl.addArgument(testObj2);
        assertEquals("Value should be gotten correctly.", 0, bindingImpl.indexOfArgument(testObj1));
        assertEquals("Value should be gotten correctly.", 1, bindingImpl.indexOfArgument(testObj2));
        Collection<TemplateArgument> collection = new ArrayList<TemplateArgument>();
        collection.add(testObj3);
        collection.add(testObj4);
        bindingImpl.addArguments(collection);
        assertEquals("Value should be gotten correctly.", 0, bindingImpl.indexOfArgument(testObj1));
        assertEquals("Value should be gotten correctly.", 1, bindingImpl.indexOfArgument(testObj2));
        assertEquals("Value should be gotten correctly.", 2, bindingImpl.indexOfArgument(testObj3));
        assertEquals("Value should be gotten correctly.", 3, bindingImpl.indexOfArgument(testObj4));
    }

    /**
     * <p>Tests the <c>addArguments(int, Collection)</c> with null object.</p>
     * <p> <code>IllegalArgumentException</code> should be thrown.</p>
     */
    public void testAddArguments2_Null() {
        try {
            bindingImpl.addArguments(0, (Collection<TemplateArgument>) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * <p>Tests the <c>addArguments(Collection)</c> with collection contains null object.</p>
     * <p> <code>IllegalArgumentException</code> should be thrown.</p>
     */
    public void testAddArguments2_ContainsNull() {
        try {
            Collection<TemplateArgument> collection = new ArrayList<TemplateArgument>();
            collection.add(null);
            bindingImpl.addArguments(0, collection);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * <p>Tests the <c>addArguments(int, Collection)</c> with negative index.</p>
     * <p> <code>IndexOutOfBoundsException</code> should be thrown.</p>
     */
    public void testAddArguments2_Negative() {
        try {
            bindingImpl.addArguments(-1, new ArrayList<TemplateArgument>());
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            //ok
        }
    }

    /**
     * <p>Tests the <c>addArguments(int, Collection)</c> with big index.</p>
     * <p> <code>IndexOutOfBoundsException</code> should be thrown.</p>
     */
    public void testAddArguments2_OutOfRange() {
        try {
            bindingImpl.addArgument(new TemplateArgumentImpl());
            bindingImpl.addArguments(2, new ArrayList<TemplateArgument>());
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            //ok
        }
    }

    /**
     * <p>Tests the accuracy of <c>addArguments(int, Collection)</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testAddArguments2_Accuracy() {
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        TemplateArgument testObj3 = new TemplateArgumentImpl();
        TemplateArgument testObj4 = new TemplateArgumentImpl();
        bindingImpl.addArgument(testObj1);
        bindingImpl.addArgument(testObj2);
        assertEquals("Value should be gotten correctly.", 0, bindingImpl.indexOfArgument(testObj1));
        assertEquals("Value should be gotten correctly.", 1, bindingImpl.indexOfArgument(testObj2));
        Collection<TemplateArgument> collection = new ArrayList<TemplateArgument>();
        collection.add(testObj3);
        collection.add(testObj4);
        bindingImpl.addArguments(1, collection);
        assertEquals("Value should be gotten correctly.", 0, bindingImpl.indexOfArgument(testObj1));
        assertEquals("Value should be gotten correctly.", 3, bindingImpl.indexOfArgument(testObj2));
        assertEquals("Value should be gotten correctly.", 1, bindingImpl.indexOfArgument(testObj3));
        assertEquals("Value should be gotten correctly.", 2, bindingImpl.indexOfArgument(testObj4));
    }

    /**
     * <p>Tests the <c>setArgument(int, TemplateArgument)</c> with null object.</p>
     * <p> <code>IllegalArgumentException</code> should be thrown.</p>
     */
    public void testSetArgument_Null() {
        try {
            bindingImpl.setArgument(0, (TemplateArgument) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * <p>Tests the <c>setArgument(int, TemplateArgument)</c> with negative index.</p>
     * <p> <code>IndexOutOfBoundsException</code> should be thrown.</p>
     */
    public void testSetArgument_Negative() {
        try {
            bindingImpl.setArgument(-1, new TemplateArgumentImpl());
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            //ok
        }
    }

    /**
     * <p>Tests the <c>setArgument(int, TemplateArgument)</c> with big index.</p>
     * <p> <code>IndexOutOfBoundsException</code> should be thrown.</p>
     */
    public void testSetArgument_OutOfRange() {
        try {
            bindingImpl.addArgument(new TemplateArgumentImpl());
            bindingImpl.setArgument(1, new TemplateArgumentImpl());
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            //ok
        }
    }

    /**
     * <p>Tests the <c>setArgument(int, TemplateArgument)</c> with big index.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testSetArgument_Accuracy() {
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        bindingImpl.addArgument(testObj1);
        bindingImpl.addArgument(testObj2);
        assertEquals("Value should be gotten correctly.", 0, bindingImpl.indexOfArgument(testObj1));
        assertEquals("Value should be gotten correctly.", 1, bindingImpl.indexOfArgument(testObj2));
        bindingImpl.setArgument(0, testObj2);
        bindingImpl.setArgument(1, testObj1);
        assertEquals("Value should be gotten correctly.", 1, bindingImpl.indexOfArgument(testObj1));
        assertEquals("Value should be gotten correctly.", 0, bindingImpl.indexOfArgument(testObj2));

    }

    /**
     * <p>Tests the <c>removeArgument(int)</c> with negative index.</p>
     * <p> <code>IndexOutOfBoundsException</code> should be thrown.</p>
     */
    public void testRemoveArgument1_Negative() {
        try {
            bindingImpl.removeArgument(-1);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            //ok
        }
    }

    /**
     * <p>Tests the <c>removeArgument(int)</c> with big index.</p>
     * <p> <code>IndexOutOfBoundsException</code> should be thrown.</p>
     */
    public void testRemoveArgument1_OutOfRange() {
        try {
            bindingImpl.addArgument(new TemplateArgumentImpl());
            bindingImpl.removeArgument(1);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            //ok
        }
    }

    /**
     * <p>Tests the accuracy of <c>removeArgument(int)</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveArgument1_Accuracy() {
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        bindingImpl.addArgument(testObj1);
        bindingImpl.addArgument(testObj2);
        assertEquals("Value should be gotten correctly.", testObj2, bindingImpl.removeArgument(1));
        assertEquals("Value should be gotten correctly.", testObj1, bindingImpl.removeArgument(0));
    }

    /**
     * <p>Tests the <c>removeArgument(TemplateArgument)</c> with null object.</p>
     * <p> <code>IllegalArgumentException</code> should be thrown.</p>
     */
    public void testRemoveArgument2_Null() {
        try {
            bindingImpl.removeArgument((TemplateArgument) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * <p>Tests the accuracy of <c>removeArgument(TemplateArgument)</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveArgument2_AccuracyTrue() {
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        bindingImpl.addArgument(testObj1);
        bindingImpl.addArgument(testObj2);
        assertEquals("Value should be gotten correctly.",
                true, bindingImpl.removeArgument(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, bindingImpl.removeArgument(testObj2));
    }

    /**
     * <p>Tests the accuracy of  <c>removeArgument(TemplateArgument)</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveArgument2_AccuracyFalse() {
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        bindingImpl.addArgument(testObj2);
        assertEquals("Value should be gotten correctly.",
                false, bindingImpl.removeArgument(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, bindingImpl.removeArgument(testObj2));
    }

    /**
     * <p>Tests the <c>removeArguments(Collection)</c> with null object.</p>
     * <p> <code>IllegalArgumentException</code> should be thrown.</p>
     */
    public void testRemoveArguments_Null() {
        try {
            bindingImpl.removeArguments((Collection<TemplateArgument>) null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * <p>Tests the <c>removeArguments(Collection)</c> with collection contains null object.</p>
     * <p> <code>IllegalArgumentException</code> should be thrown.</p>
     */
    public void testRemoveArguments_ContainsNull() {
        try {
            Collection<TemplateArgument> collection = new ArrayList<TemplateArgument>();
            collection.add(null);
            bindingImpl.removeArguments(collection);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * <p>Tests the accuracy of  <c>removeArguments(Collection)</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveArguments_AccuracyTrue() {
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        bindingImpl.addArgument(testObj1);
        bindingImpl.addArgument(testObj2);
        bindingImpl.addArgument(testObj1);

        Collection<TemplateArgument> collection = new ArrayList<TemplateArgument>();
        collection.add(testObj1);
        collection.add(testObj2);
        assertEquals("Value should be gotten correctly.",
                true, bindingImpl.removeArguments(collection));
        assertEquals("Value should be gotten correctly.",
                true, bindingImpl.containsArgument(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, bindingImpl.containsArgument(testObj2));
    }

    /**
     * <p>Tests the accuracy of  <c>removeArguments(Collection)</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveArguments_AccuracyFalse() {
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        TemplateArgument testObj3 = new TemplateArgumentImpl();
        bindingImpl.addArgument(testObj1);
        bindingImpl.addArgument(testObj2);
        bindingImpl.addArgument(testObj1);

        Collection<TemplateArgument> collection = new ArrayList<TemplateArgument>();
        collection.add(testObj3);
        assertEquals("Value should be gotten correctly.",
                false, bindingImpl.removeArguments(collection));
        assertEquals("Value should be gotten correctly.",
                true, bindingImpl.containsArgument(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, bindingImpl.containsArgument(testObj2));
    }

    /**
     * <p>Tests the accuracy of  <c>clearArguments()</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testClearArguments_Accuracy() {
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        TemplateArgument testObj3 = new TemplateArgumentImpl();
        bindingImpl.addArgument(testObj1);
        bindingImpl.addArgument(testObj2);
        bindingImpl.addArgument(testObj3);

        bindingImpl.clearArguments();
        assertEquals("Value should be gotten correctly.",
                0, bindingImpl.countArguments());
    }

    /**
     * <p>Tests the accuracy of <c>getArguments()</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testGetArguments_Accuracy1() {
        Collection<TemplateArgument> collection = bindingImpl.getArguments();
        assertEquals("Value should be gotten correctly.",
                0, collection.size());
    }

    /**
     * <p>Tests the accuracy of <c>getArguments()</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testGetArguments_Accuracy2() {
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        TemplateArgument testObj3 = new TemplateArgumentImpl();
        bindingImpl.addArgument(testObj1);
        bindingImpl.addArgument(testObj2);

        Collection<TemplateArgument> collection = bindingImpl.getArguments();
        assertEquals("Value should be gotten correctly.",
                true, collection.contains(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collection.contains(testObj2));
        assertEquals("Value should be gotten correctly.",
                false, collection.contains(testObj3));
    }

    /**
     * <p>Tests the <c>containsArgument(TemplateArgument)</c> with null object.</p>
     * <p> <code>IllegalArgumentException</code> should be thrown.</p>
     */
    public void testContainsArgument_Null() {
        try {
            bindingImpl.containsArgument(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * <p>Tests the accuracy of <c>containsArgument(TemplateArgument)</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testContainsArgument_AccuracyTrue() {
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        TemplateArgument testObj3 = new TemplateArgumentImpl();
        bindingImpl.addArgument(testObj1);
        bindingImpl.addArgument(testObj2);

        assertEquals("Value should be gotten correctly.",
                true, bindingImpl.containsArgument(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, bindingImpl.containsArgument(testObj2));
        assertEquals("Value should be gotten correctly.",
                false, bindingImpl.containsArgument(testObj3));
    }

    /**
     * <p>Tests the accuracy of <c>containsArgument(TemplateArgument)</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testContainsArgument_AccuracyFalse() {
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        TemplateArgument testObj3 = new TemplateArgumentImpl();
        bindingImpl.addArgument(testObj1);
        bindingImpl.addArgument(testObj2);

        assertEquals("Value should be gotten correctly.",
                true, bindingImpl.containsArgument(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, bindingImpl.containsArgument(testObj2));
        assertEquals("Value should be gotten correctly.",
                false, bindingImpl.containsArgument(testObj3));
    }

    /**
     * <p>Tests the <c>indexOfArgument(TemplateArgument)</c> with null object.</p>
     * <p> <code>IllegalArgumentException</code> should be thrown.</p>
     */
    public void testIndexOfArgument_Null() {
        try {
            bindingImpl.indexOfArgument(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * <p>Tests the accuracy of <c>indexOfArgument(TemplateArgument)</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testIndexOfArgument_AccuracyTrue() {
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        TemplateArgument testObj3 = new TemplateArgumentImpl();
        bindingImpl.addArgument(testObj1);
        bindingImpl.addArgument(0, testObj2);

        assertEquals("Value should be gotten correctly.",
                1, bindingImpl.indexOfArgument(testObj1));
        assertEquals("Value should be gotten correctly.",
                0, bindingImpl.indexOfArgument(testObj2));
        assertEquals("Value should be gotten correctly.",
                -1, bindingImpl.indexOfArgument(testObj3));
    }

    /**
     * <p>Tests the accuracy of <c>indexOfArgument(TemplateArgument)</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testIndexOfArgument_AccuracyFalse() {
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        TemplateArgument testObj3 = new TemplateArgumentImpl();
        bindingImpl.addArgument(testObj1);
        bindingImpl.addArgument(0, testObj2);

        assertEquals("Value should be gotten correctly.",
                1, bindingImpl.indexOfArgument(testObj1));
        assertEquals("Value should be gotten correctly.",
                0, bindingImpl.indexOfArgument(testObj2));
        assertEquals("Value should be gotten correctly.",
                -1, bindingImpl.indexOfArgument(testObj3));
    }

    /**
     * <p>Tests the accuracy of <c>countArguments()</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testCountArguments_AccuracyFalse() {
        assertEquals("Value should be gotten correctly.",
                0, bindingImpl.countArguments());
        TemplateArgument testObj1 = new TemplateArgumentImpl();
        TemplateArgument testObj2 = new TemplateArgumentImpl();
        TemplateArgument testObj3 = new TemplateArgumentImpl();
        bindingImpl.addArgument(testObj1);
        bindingImpl.addArgument(0, testObj2);

        assertEquals("Value should be gotten correctly.",
                2, bindingImpl.countArguments());
        bindingImpl.addArgument(2, testObj3);
        assertEquals("Value should be gotten correctly.",
                3, bindingImpl.countArguments());
    }

}
