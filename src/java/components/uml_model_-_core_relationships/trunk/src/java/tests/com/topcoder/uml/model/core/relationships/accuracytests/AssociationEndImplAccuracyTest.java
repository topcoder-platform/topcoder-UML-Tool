/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships.accuracytests;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.OrderingKind;
import com.topcoder.uml.model.datatypes.ScopeKind;


/**
 * Accuracy test case of <code>AssociationEndImpl</code> class.
 * This class tests <code>AssociationEndImpl</code> for proper behavior. It covers
 * AssociationEndImpl(), setNavigable(boolean), isNavigable(), setOrdering(OrderingKind), getOrdering(),
 * setAggregation(AggregationKind), getAggregation(), setTargetKind(ScopeKind), getTargetKind(),
 * setMultiplicity(Multiplicity), getMultiplicity(), setChangeability(ChangeableKind), getChangeability(),
 * setAssociation(Association), getAssociation(), addQualifier(Attribute), addQualifier(int, Attribute),
 * setQualifier(int, Attribute), removeQualifier(int), removeQualifier(Attribute), clearQualifiers(),
 * getQualifiers(), containsQualifier(Attribute), indexOfQualifier(Attribute), countQualifiers(),
 * setParticipant(Classifier), getParticipant(), addSpecification(Classifier), removeSpecification(Classifier),
 * clearSpecifications(), getSpecifications(), containsSpecification(Classifier), countSpecifications().
 *
 * @author still
 * @version 1.0
 */
public class AssociationEndImplAccuracyTest extends TestCase {
    /** different numbers of items in test. */
    private static final int []DIFFERENT_NUMBERS = new int[]{1, 10, 100, 1000, 3000};

    /** AssociationEndImpl instance used in this test. */
    private AssociationEndImpl instance;
    /**
     * Test suite of AssociationEndImpl.
     *
     * @return Test suite of AssociationEndImpl.
     */
    public static Test suite() {
        return new TestSuite(AssociationEndImplAccuracyTest.class);
    }

    /**
     * Initialization for all tests here.
     */
    protected void setUp() {
        // set up for test
        instance = new AssociationEndImpl();
    }


    /**
     * Test accuracy of AssociationEndImpl() method.
     */
    public void testAssociationEndImpl() {
        assertNotNull("create failed.", instance);
        assertFalse("returning false expected.", instance.isNavigable());
        assertNull("null expected.", instance.getAggregation());
        assertNull("null expected.", instance.getAssociation());
        assertNull("null expected.", instance.getChangeability());
        assertNull("null expected.", instance.getMultiplicity());
        assertNull("null expected.", instance.getOrdering());
        assertNull("null expected.", instance.getParticipant());
        assertNull("null expected.", instance.getTargetKind());
    }

    /**
     * Test AssociationEndImpl for correct type.
     */
    public void testAssociationEndImpl_CorrectType() {
        assertEquals("equal value expected.",
                AssociationEndImpl.class.getSuperclass(), ModelElementAbstractImpl.class);
        assertTrue("true value expected.",
                AssociationEnd.class.isAssignableFrom(AssociationEndImpl.class));
    }

    /**
     * Test accuracy of setNavigable(boolean) method.
     */
    public void testSetNavigable() {
        assertFalse("returning false expected.", instance.isNavigable());

        instance.setNavigable(false);
        assertFalse("returning false expected.", instance.isNavigable());

        instance.setNavigable(true);
        assertTrue("returning true expected.", instance.isNavigable());

        instance.setNavigable(false);
        assertFalse("returning false expected.", instance.isNavigable());

    }

    /**
     * Test accuracy of isNavigable() method.
     */
    public void testIsNavigable() {

        assertFalse("returning false expected.", instance.isNavigable());

        instance.setNavigable(false);
        assertFalse("returning false expected.", instance.isNavigable());

        instance.setNavigable(true);
        assertTrue("returning true expected.", instance.isNavigable());

        instance.setNavigable(false);
        assertFalse("returning false expected.", instance.isNavigable());
    }

    /**
     * Test accuracy of setOrdering(OrderingKind) method.
     */
    public void testSetOrdering() {
        instance.setOrdering(OrderingKind.UNORDERED);
        assertSame("should be same.", OrderingKind.UNORDERED, instance.getOrdering());

        instance.setOrdering(OrderingKind.ORDERED);
        assertSame("should be same.", OrderingKind.ORDERED, instance.getOrdering());

        instance.setOrdering(null);
        assertNull("null expected.", instance.getOrdering());
    }



    /**
     * Test accuracy of getOrdering() method.
     */
    public void testGetOrdering() {

        instance.setOrdering(OrderingKind.UNORDERED);
        assertSame("should be same.", OrderingKind.UNORDERED, instance.getOrdering());
        assertSame("should be same.", OrderingKind.UNORDERED, instance.getOrdering());

        instance.setOrdering(OrderingKind.ORDERED);
        assertSame("should be same.", OrderingKind.ORDERED, instance.getOrdering());
        assertSame("should be same.", OrderingKind.ORDERED, instance.getOrdering());

        instance.setOrdering(null);
        assertNull("null expected.", instance.getOrdering());
        assertNull("null expected.", instance.getOrdering());
    }

    /**
     * Test accuracy of setAggregation(AggregationKind) method.
     */
    public void testSetAggregation() {
        AggregationKind []kinds = AggregationKind.values();
        for (AggregationKind kind : kinds) {
            instance.setAggregation(kind);
            assertEquals("equal value expected.", kind, instance.getAggregation());
        }

        instance.setAggregation(null);
        assertNull("null expected.", instance.getAggregation());
    }

    /**
     * Test accuracy of getAggregation() method.
     */
    public void testGetAggregation() {
        AggregationKind []kinds = AggregationKind.values();
        for (AggregationKind kind : kinds) {
            instance.setAggregation(kind);
            assertEquals("equal value expected.", kind, instance.getAggregation());
            assertEquals("equal value expected.", kind, instance.getAggregation());
        }

        instance.setAggregation(null);
        assertNull("null expected.", instance.getAggregation());
        assertNull("null expected.", instance.getAggregation());
    }

    /**
     * Test accuracy of setTargetKind(ScopeKind) method.
     */
    public void testSetTargetKind() {

        ScopeKind []kinds = ScopeKind.values();
        for (ScopeKind kind : kinds) {
            instance.setTargetKind(kind);
            assertEquals("equal value expected.", kind, instance.getTargetKind());
        }

        instance.setTargetKind(null);
        assertNull("null expected.", instance.getTargetKind());
    }

    /**
     * Test accuracy of getTargetKind() method.
     */
    public void testGetTargetKind() {

        ScopeKind []kinds = ScopeKind.values();
        for (ScopeKind kind : kinds) {
            instance.setTargetKind(kind);
            assertEquals("equal value expected.", kind, instance.getTargetKind());
            assertEquals("equal value expected.", kind, instance.getTargetKind());
        }

        instance.setTargetKind(null);
        assertNull("null expected.", instance.getTargetKind());
        assertNull("null expected.", instance.getTargetKind());
    }

    /**
     * Test accuracy of setMultiplicity(Multiplicity) method.
     */
    public void testSetMultiplicity() {
        Multiplicity mock = createMock(Multiplicity.class);
        replay(mock);
        instance.setMultiplicity(mock);
        verify(mock);
        assertEquals("equal value expected.", mock, instance.getMultiplicity());

        instance.setMultiplicity(null);
        assertNull("null expected.", instance.getMultiplicity());
    }

    /**
     * Test accuracy of getMultiplicity() method.
     */
    public void testGetMultiplicity() {
        Multiplicity mock = createMock(Multiplicity.class);
        replay(mock);
        instance.setMultiplicity(mock);
        verify(mock);
        assertEquals("equal value expected.", mock, instance.getMultiplicity());
        assertEquals("equal value expected.", mock, instance.getMultiplicity());
    }

    /**
     * Test accuracy of setChangeability(ChangeableKind) method.
     */
    public void testSetChangeability() {

        ChangeableKind []kinds = ChangeableKind.values();
        for (ChangeableKind kind : kinds) {
            instance.setChangeability(kind);
            assertEquals("equal value expected.", kind, instance.getChangeability());
        }

        instance.setChangeability(null);
        assertNull("null expected.", instance.getChangeability());
    }

    /**
     * Test accuracy of getChangeability() method.
     */
    public void testGetChangeability() {
        ChangeableKind []kinds = ChangeableKind.values();
        for (ChangeableKind kind : kinds) {
            instance.setChangeability(kind);
            assertEquals("equal value expected.", kind, instance.getChangeability());
            assertEquals("equal value expected.", kind, instance.getChangeability());
        }

        instance.setChangeability(null);
        assertNull("null expected.", instance.getChangeability());
        assertNull("null expected.", instance.getChangeability());
    }

    /**
     * Test accuracy of setAssociation(Association) method.
     */
    public void testSetAssociation() {
        Association mock = createMock(Association.class);
        instance.setAssociation(mock);
        assertEquals("equal value expected.", mock, instance.getAssociation());

        Association association = new AssociationImpl();
        instance.setAssociation(association);
        assertEquals("equal value expected.", association, instance.getAssociation());

        instance.setAssociation(null);
        assertNull("null expected.", instance.getAssociation());
    }

    /**
     * Test accuracy of getAssociation() method.
     */
    public void testGetAssociation() {

        Association mock = createMock(Association.class);
        instance.setAssociation(mock);
        assertEquals("equal value expected.", mock, instance.getAssociation());
        assertEquals("equal value expected.", mock, instance.getAssociation());

        Association association = new AssociationImpl();
        instance.setAssociation(association);
        assertEquals("equal value expected.", association, instance.getAssociation());
        assertEquals("equal value expected.", association, instance.getAssociation());

        instance.setAssociation(null);
        assertNull("null expected.", instance.getAssociation());
        assertNull("null expected.", instance.getAssociation());
    }

    /**
     * Test accuracy of addQualifier(Attribute) method.
     */
    public void testAddQualifier() {

        for (int i:DIFFERENT_NUMBERS) {
            List<Attribute> qualifiers = new ArrayList<Attribute>();
            for (int j = 0; j < i; j++) {
                Attribute qualifier = createMock(Attribute.class);
                replay(qualifier);
                instance.addQualifier(qualifier);
                // ensure any Attribute method is not called
                verify(qualifier);
                qualifiers.add(qualifier);
                assertEquals("equal value expected.", j + 1, instance.countQualifiers());
            }
            for (Attribute qualifier: qualifiers) {
                assertTrue("returning true expected.", instance.containsQualifier(qualifier));
            }
            instance.clearQualifiers();
        }
    }

    /**
     * Test accuracy of addQualifier(Attribute) method.
     */
    public void testAddQualifier_DuplicateQualifier() {
        Attribute qualifier = createMock(Attribute.class);
        replay(qualifier);
        for (int i:DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                instance.addQualifier(qualifier);
                assertEquals("equal value expected.", j + 1, instance.countQualifiers());
            }
            instance.clearQualifiers();
        }
        // ensure any Attribute method is not called
        verify(qualifier);
    }

    /**
     * Test accuracy of addQualifier(int, Attribute) method.
     */
    public void testAddQualifier_IndexAdd() {
        Random rand = new Random();
        for (int i:DIFFERENT_NUMBERS) {
            List<Attribute> qualifiers = new ArrayList<Attribute>();
            for (int j = 0; j < i; j++) {
                Attribute qualifier = createMock(Attribute.class);
                replay(qualifier);
                int index = rand.nextInt(instance.countQualifiers() + 1);
                instance.addQualifier(index, qualifier);
                // ensure any Attribute method is not called
                verify(qualifier);
                qualifiers.add(qualifier);
                assertEquals("equal value expected.", j + 1, instance.countQualifiers());
            }
            for (Attribute qualifier: qualifiers) {
                assertTrue("returning true expected.", instance.containsQualifier(qualifier));
            }
            instance.clearQualifiers();
        }
    }

    /**
     * Test accuracy of addQualifier(int, Attribute) method.
     */
    public void testAddQualifier_IndexAdd_DuplicateQualifier() {

        for (int i:DIFFERENT_NUMBERS) {
            Attribute qualifier = createMock(Attribute.class);
            replay(qualifier);

            instance.addQualifier(qualifier);
            // we add qualifier <i> times
            for (int j = 0; j < i; j++) {
                instance.addQualifier(j + 1, qualifier);
            }

            List<Attribute> qualifiers = instance.getQualifiers();
            for (Attribute each : qualifiers) {
                assertSame("should be same.", qualifier, each);
            }
            instance.clearQualifiers();
            // ensure any Attribute method is not called
            verify(qualifier);
        }

    }


    /**
     * Test accuracy of setQualifier(int, Attribute) method.
     */
    public void testSetQualifier() {

        for (int i:DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                Attribute qualifier = createMock(Attribute.class);
                instance.addQualifier(qualifier);
                assertEquals("equal value expected.", j + 1, instance.countQualifiers());
            }
            Attribute newQualifier = createMock(Attribute.class);
            replay(newQualifier);
            Random rand = new Random();
            int []indexs = new int[i];
            for (int j = 0; j < i; j++) {
                int index = rand.nextInt(i);
                indexs[j] = index;
                instance.setQualifier(index, newQualifier);
            }
            List<Attribute> qualifiers = instance.getQualifiers();
            for (int index : indexs) {
                assertSame("Should be same.", newQualifier, qualifiers.get(index));
            }
            instance.clearQualifiers();
            // ensure any Attribute method is not called
            verify(newQualifier);
        }
    }

    /**
     * Test accuracy of removeQualifier(int) method.
     */
    public void testRemoveQualifier_Index() {

        for (int i:DIFFERENT_NUMBERS) {
            List<Attribute> qualifiers = new ArrayList<Attribute>();
            for (int j = 0; j < i; j++) {
                Attribute qualifier = createMock(Attribute.class);
                instance.addQualifier(qualifier);
                qualifiers.add(qualifier);
            }

            Attribute newQualifier = createMock(Attribute.class);
            replay(newQualifier);
            Random rand = new Random();
            int index = rand.nextInt(i);
            instance.setQualifier(index, newQualifier);
            assertSame("Should be same.", newQualifier, instance.removeQualifier(index));
            assertEquals("equal value expected.", i - 1, instance.countQualifiers());

            // ensure the code removes the right qualifier
            for (Attribute qualifier: qualifiers) {
                // the index's qualifier has been removed
                if (qualifiers.get(index) != qualifier) {
                    assertTrue("returning true expected.", instance.containsQualifier(qualifier));
                }
            }

            // newQualifier has been removed
            assertFalse("returning false expected.", instance.containsQualifier(newQualifier));
            instance.clearQualifiers();
            // ensure any Attribute method is not called
            verify(newQualifier);
        }
    }

    /**
     * Test accuracy of removeQualifier(Attribute) method.
     */
    public void testRemoveQualifier_Attribute() {
        for (int i:DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                Attribute qualifier = createMock(Attribute.class);
                instance.addQualifier(qualifier);
            }
            List<Attribute> returnedQualifiers = instance.getQualifiers();

            for (int j = returnedQualifiers.size() - 1; j >= 0; j--) {
                replay(returnedQualifiers.get(j));
                assertTrue("returning true expected.", instance.removeQualifier(returnedQualifiers.get(j)));
                verify(returnedQualifiers.get(j));
            }
            assertEquals("equal value expected.", 0, instance.countQualifiers());
        }
    }

    /**
     * Test accuracy of removeQualifier(Attribute) method.
     */
    public void testRemoveQualifier_Attribute2() {
        for (int i:DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                Attribute qualifier = createMock(Attribute.class);
                instance.addQualifier(qualifier);
            }
            List<Attribute> returnedQualifiers = instance.getQualifiers();

            for (Attribute each : returnedQualifiers) {
                assertTrue("returning true expected.", instance.removeQualifier(each));
            }
            assertEquals("equal value expected.", 0, instance.countQualifiers());
        }
    }

    /**
     * Test accuracy of removeQualifier(Attribute) method.
     */
    public void testRemoveQualifier_NotExistedQualifier() {
        for (int i:DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                Attribute qualifier = createMock(Attribute.class);
                instance.addQualifier(qualifier);
            }
            Attribute newQualifier = createMock(Attribute.class);
            replay(newQualifier);
            assertFalse("returning false expected.", instance.removeQualifier(newQualifier));
            // ensure any Attribute method is not called
            verify(newQualifier);

            assertEquals("equal value expected.", i, instance.countQualifiers());
            instance.clearQualifiers();

        }
    }

    /**
     * Test accuracy of removeQualifier(Attribute) method.
     */
    public void testRemoveQualifier_DuplicateQualifier() {
        for (int i:DIFFERENT_NUMBERS) {
            Attribute qualifier = createMock(Attribute.class);
            instance.addQualifier(qualifier);
            // we add qualifier <i> times
            for (int j = 1; j < i; j++) {
                instance.addQualifier(j, qualifier);
            }
            replay(qualifier);
            for (int j = 0; j < i; j++) {
                assertEquals("equal value expected.", i - j, instance.countQualifiers());
                assertTrue("returning true expected.", instance.removeQualifier(qualifier));
                assertEquals("equal value expected.", i - j - 1, instance.countQualifiers());
            }
            // ensure any Attribute method is not called
            verify(qualifier);
        }

    }

    /**
     * Test accuracy of clearQualifiers() method.
     */
    public void testClearQualifiers() {
        for (int i:DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                Attribute qualifier = createMock(Attribute.class);
                instance.addQualifier(qualifier);
            }
            instance.clearQualifiers();
            assertEquals("equal value expected.", 0, instance.countQualifiers());
        }
    }

    /**
     * Test accuracy of clearQualifiers() method.
     */
    public void testClearQualifiers_NoQualifierContained() {
        assertEquals("equal value expected.", 0, instance.countQualifiers());
        instance.clearQualifiers();
        assertEquals("equal value expected.", 0, instance.countQualifiers());
    }

    /**
     * Test accuracy of getQualifiers() method.
     */
    public void testGetQualifiers() {
        // no qualifier is in instance
        assertEquals("equal value expected.", new ArrayList<Attribute>(), instance.getQualifiers());
        for (int i:DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                Attribute qualifier = createMock(Attribute.class);
                instance.addQualifier(qualifier);
            }
            List<Attribute> returnedQualifiers = instance.getQualifiers();
            assertEquals("The right size expected.", i, returnedQualifiers.size());
            // ensure we get the right qualifiers
            for (Attribute each : returnedQualifiers) {
                assertSame("Should be same.", each, instance.removeQualifier(0));
            }
        }

    }

    /**
     * Test accuracy of containsQualifier(Attribute) method.
     */
    public void testContainsQualifier() {
        for (int i:DIFFERENT_NUMBERS) {

            for (int j = 0; j < i; j++) {
                Attribute qualifier = createMock(Attribute.class);
                instance.addQualifier(qualifier);
                assertTrue("returning true expected.", instance.containsQualifier(qualifier));

            }

            Attribute newQualifier = createMock(Attribute.class);
            replay(newQualifier);
            assertFalse("returning false expected.", instance.containsQualifier(newQualifier));
            verify(newQualifier);

            instance.clearQualifiers();
        }
    }

    /**
     * Test accuracy of indexOfQualifier(Attribute) method.
     */
    public void testIndexOfQualifier() {

        for (int i:DIFFERENT_NUMBERS) {
            List<Attribute> qualifiers = new ArrayList<Attribute>();
            for (int j = 0; j < i; j++) {
                Attribute qualifier = createMock(Attribute.class);
                instance.addQualifier(qualifier);
                qualifiers.add(qualifier);
            }

            Attribute newQualifier = createMock(Attribute.class);
            Random rand = new Random();
            int index = rand.nextInt(i);
            instance.setQualifier(index, newQualifier);
            replay(newQualifier);
            assertEquals("equal value expected.", index, instance.indexOfQualifier(newQualifier));
            verify(newQualifier);
            instance.clearQualifiers();
        }
    }


    /**
     * Test accuracy of indexOfQualifier(Attribute) method.
     *
     */
    public void testIndexOfQualifier_DuplicateQualifier() {

        for (int i:DIFFERENT_NUMBERS) {
            List<Attribute> qualifiers = new ArrayList<Attribute>();
            for (int j = 0; j < i; j++) {
                Attribute qualifier = createMock(Attribute.class);
                instance.addQualifier(qualifier);
                qualifiers.add(qualifier);
            }

            Attribute newQualifier = createMock(Attribute.class);
            Random rand = new Random();
            int index = rand.nextInt(i);
            instance.setQualifier(index, newQualifier);
            // add 4 newQualifier's to the end
            instance.addQualifier(newQualifier);
            instance.addQualifier(newQualifier);
            instance.addQualifier(newQualifier);
            instance.addQualifier(newQualifier);
            replay(newQualifier);
            assertEquals("equal value expected.", index, instance.indexOfQualifier(newQualifier));
            verify(newQualifier);
            instance.clearQualifiers();
        }
    }

    /**
     * Test accuracy of indexOfQualifier(Attribute) method.
     */
    public void testIndexOfQualifier_NotExistedQualifier() {

        for (int i:DIFFERENT_NUMBERS) {
            List<Attribute> qualifiers = new ArrayList<Attribute>();
            for (int j = 0; j < i; j++) {
                Attribute qualifier = createMock(Attribute.class);
                instance.addQualifier(qualifier);
                qualifiers.add(qualifier);
            }

            Attribute newQualifier = createMock(Attribute.class);
            replay(newQualifier);
            assertEquals("equal value expected.", -1, instance.indexOfQualifier(newQualifier));
            verify(newQualifier);
            instance.clearQualifiers();
        }
    }

    /**
     * Test accuracy of countQualifiers() method.
     */
    public void testCountQualifiers() {

        for (int i:DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                Attribute qualifier = createMock(Attribute.class);
                instance.addQualifier(0, qualifier);
                replay(qualifier);
                assertEquals("equal value expected.", j + 1, instance.countQualifiers());
                verify(qualifier);
            }
            instance.clearQualifiers();
        }
    }

    /**
     * Test accuracy of setParticipant(Classifier) method.
     */
    public void testSetParticipant() {
        Classifier mock = createMock(Classifier.class);
        replay(mock);
        instance.setParticipant(mock);
        verify(mock);
        assertEquals("equal value expected.", mock, instance.getParticipant());

        Classifier mock2 = createMock(Classifier.class);
        replay(mock2);
        instance.setParticipant(mock2);
        verify(mock2);
        assertEquals("equal value expected.", mock2, instance.getParticipant());

        instance.setParticipant(null);
        assertNull("null expected.", instance.getParticipant());


    }

    /**
     * Test accuracy of getParticipant() method.
     */
    public void testGetParticipant() {

        Classifier mock = createMock(Classifier.class);
        instance.setParticipant(mock);
        assertEquals("equal value expected.", mock, instance.getParticipant());
        assertEquals("equal value expected.", mock, instance.getParticipant());

        Classifier mock2 = createMock(Classifier.class);
        instance.setParticipant(mock2);
        assertEquals("equal value expected.", mock2, instance.getParticipant());
        assertEquals("equal value expected.", mock2, instance.getParticipant());

        instance.setParticipant(null);
        assertNull("null expected.", instance.getParticipant());
        assertNull("null expected.", instance.getParticipant());
    }

    /**
     * Test accuracy of addSpecification(Classifier) method.
     */
    public void testAddSpecification() {

        for (int i:DIFFERENT_NUMBERS) {
            List<Classifier> specifications = new ArrayList<Classifier>();
            for (int j = 0; j < i; j++) {
                Classifier specification = createMock(Classifier.class);
                replay(specification);
                instance.addSpecification(specification);
                // ensure any Classifier method is not called
                verify(specification);
                specifications.add(specification);
                assertEquals("equal value expected.", j + 1, instance.countSpecifications());
            }
            for (Classifier specification: specifications) {
                assertTrue("returning true expected.", instance.containsSpecification(specification));
            }
            instance.clearSpecifications();
        }
    }

    /**
     * Test accuracy of addSpecification(Classifier) method.
     */
    public void testAddSpecification_DuplicateSpecification() {
        Classifier specification = createMock(Classifier.class);
        replay(specification);
        for (int i:DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                instance.addSpecification(specification);
                assertEquals("equal value expected.", j + 1, instance.countSpecifications());
            }
            instance.clearSpecifications();
        }
        // ensure any Classifier method is not called
        verify(specification);
    }


    /**
     * Test accuracy of removeSpecification(Classifier) method.
     */
    public void testRemoveSpecification_Classifier() {
        for (int i:DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                Classifier specification = createMock(Classifier.class);
                instance.addSpecification(specification);
            }
            Collection<Classifier> returnedSpecifications = instance.getSpecifications();
            Classifier[] array = (Classifier[]) returnedSpecifications.toArray(new Classifier[0]);
            for (int j = returnedSpecifications.size() - 1; j >= 0; j--) {
                replay(array[j]);
                assertTrue("returning true expected.", instance.removeSpecification(array[j]));
                verify(array[j]);
            }
            assertEquals("equal value expected.", 0, instance.countSpecifications());
        }
    }

    /**
     * Test accuracy of removeSpecification(Classifier) method.
     */
    public void testRemoveSpecification_Classifier2() {
        for (int i:DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                Classifier specification = createMock(Classifier.class);
                instance.addSpecification(specification);
            }
            Collection<Classifier> returnedSpecifications = instance.getSpecifications();

            for (Classifier each : returnedSpecifications) {
                assertTrue("returning true expected.", instance.removeSpecification(each));
            }
            assertEquals("equal value expected.", 0, instance.countSpecifications());
        }
    }

    /**
     * Test accuracy of removeSpecification(Classifier) method.
     */
    public void testRemoveSpecification_NotExistedSpecification() {
        for (int i:DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                Classifier specification = createMock(Classifier.class);
                instance.addSpecification(specification);
            }
            Classifier newSpecification = createMock(Classifier.class);
            replay(newSpecification);
            assertFalse("returning false expected.", instance.removeSpecification(newSpecification));
            // ensure any Classifier method is not called
            verify(newSpecification);

            assertEquals("equal value expected.", i, instance.countSpecifications());
            instance.clearSpecifications();

        }
    }

    /**
     * Test accuracy of removeSpecification(Classifier) method.
     */
    public void testRemoveSpecification_DuplicateSpecification() {
        for (int i:DIFFERENT_NUMBERS) {
            Classifier specification = createMock(Classifier.class);
            instance.addSpecification(specification);
            // we add specification <i> times
            for (int j = 1; j < i; j++) {
                instance.addSpecification(specification);
            }
            replay(specification);
            for (int j = 0; j < i; j++) {
                assertEquals("equal value expected.", i - j, instance.countSpecifications());
                assertTrue("returning true expected.", instance.removeSpecification(specification));
                assertEquals("equal value expected.", i - j - 1, instance.countSpecifications());
            }
            // ensure any Classifier method is not called
            verify(specification);
        }

    }

    /**
     * Test accuracy of clearSpecifications() method.
     */
    public void testClearSpecifications() {
        for (int i:DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                Classifier specification = createMock(Classifier.class);
                instance.addSpecification(specification);
            }
            instance.clearSpecifications();
            assertEquals("equal value expected.", 0, instance.countSpecifications());
        }
    }

    /**
     * Test accuracy of clearSpecifications() method.
     */
    public void testClearSpecifications_NoSpecificationContained() {
        assertEquals("equal value expected.", 0, instance.countSpecifications());
        instance.clearSpecifications();
        assertEquals("equal value expected.", 0, instance.countSpecifications());
    }

    /**
     * Test accuracy of getSpecifications() method.
     */
    public void testGetSpecifications() {
        // no specification is in instance
        assertEquals("equal value expected.", new ArrayList<Classifier>(), instance.getSpecifications());
        for (int i:DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                Classifier specification = createMock(Classifier.class);
                instance.addSpecification(specification);
            }
            Collection<Classifier> returnedSpecifications = instance.getSpecifications();
            assertEquals("The right size expected.", i, returnedSpecifications.size());
            // ensure we get the right specifications
            for (Classifier each : returnedSpecifications) {
                assertTrue("returning true expected.", instance.removeSpecification(each));
            }
        }

    }

    /**
     * Test accuracy of containsSpecification(Classifier) method.
     */
    public void testContainsSpecification() {
        for (int i:DIFFERENT_NUMBERS) {

            for (int j = 0; j < i; j++) {
                Classifier specification = createMock(Classifier.class);
                instance.addSpecification(specification);
                assertTrue("returning true expected.", instance.containsSpecification(specification));

            }

            Classifier newSpecification = createMock(Classifier.class);
            replay(newSpecification);
            assertFalse("returning false expected.", instance.containsSpecification(newSpecification));
            verify(newSpecification);

            instance.clearSpecifications();
        }
    }

    /**
     * Test accuracy of countSpecifications() method.
     */
    public void testCountSpecifications() {

        for (int i:DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                Classifier specification = createMock(Classifier.class);
                instance.addSpecification(specification);
                replay(specification);
                assertEquals("equal value expected.", j + 1, instance.countSpecifications());
                verify(specification);
            }
            instance.clearSpecifications();
        }
    }
}
