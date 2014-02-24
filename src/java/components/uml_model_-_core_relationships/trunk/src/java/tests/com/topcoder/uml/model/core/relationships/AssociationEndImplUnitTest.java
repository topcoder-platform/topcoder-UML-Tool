/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.OrderingKind;
import com.topcoder.uml.model.datatypes.ScopeKind;

import junit.framework.TestCase;

import java.util.Collection;
import java.util.List;


/**
 * Unit test for AssociationEndImpl.
 *
 * @author fanse
 * @version 1.0
 */
public class AssociationEndImplUnitTest extends TestCase {
    /**
     * The AssociationEndImpl instance for test.
     */
    private AssociationEndImpl assoEndIml = null;

    /**
     * The Attribute instance for test.
     */
    private Attribute attribute1 = new AttributeImpl();

    /**
     * The Attribute instance for test.
     */
    private Attribute attribute2 = new AttributeImpl();

    /**
     * The Classifier instance for test.
     */
    private Classifier classifier1 = new ClassImpl();

    /**
     * The Classifier instance for test.
     */
    private Classifier classifier2 = new ClassImpl();

    /**
     * Create the test instance.
     */
    public void setUp() {
        assoEndIml = new AssociationEndImpl();
    }

    /**
     * Tear down the test instance.
     */
    public void tearDown() {
        assoEndIml = null;
    }

    /**
     * Test constructor accuracy. No exception will be thrown.
     */
    public void testConstructorAccuracy() {
        AssociationEndImpl ctorImpl = new AssociationEndImpl();

        assertNotNull("The ctorImpl should not be null.", ctorImpl);
        // Check default fields.
        assertFalse("initialized field wrong.", ctorImpl.isNavigable());
        assertNull("initialized field wrong.", ctorImpl.getOrdering());
        assertNull("initialized field wrong.", ctorImpl.getAggregation());
        assertNull("initialized field wrong.", ctorImpl.getTargetKind());
        assertNull("initialized field wrong.", ctorImpl.getMultiplicity());
        assertNull("initialized field wrong.", ctorImpl.getChangeability());
        assertNull("initialized field wrong.", ctorImpl.getAssociation());
        assertNull("initialized field wrong.", ctorImpl.getParticipant());
        assertNotNull("initialized field wrong.", ctorImpl.getQualifiers());
        assertNotNull("initialized field wrong.", ctorImpl.getSpecifications());
    }

    /**
     * Test inheritance of <c>AssociationEndImpl</c>.
     * <c>AssociationEndImpl</c> should inherit from <c>ModelElementAbstractImpl</c>.
     */
    public void testAssociationEndImplAccuracyInheritModelElementAbstractImpl() {
        assertTrue("AssociationEndImpl should inherit from ModelElementAbstractImpl.",
            ((Object) new AssociationEndImpl()) instanceof ModelElementAbstractImpl);
    }

    /**
     * Test inheritance of <c>AssociationEndImpl</c>.
     * <c>AssociationEndImpl</c> should inherit from <c>AssociationEnd</c>.
     */
    public void testAssociationEndImplAccuracyInheritAssociationEnd() {
        assertTrue("AssociationEndImpl should inherit from AssociationEnd.",
            ((Object) new AssociationEndImpl()) instanceof AssociationEnd);
    }

    /**
     * Tests setNavigable(boolean). Value should be set correctly.
     */
    public void testSetNavigableAccuracy() {
        boolean test = true;
        assoEndIml.setNavigable(test);
        assertEquals("Value should be set correctly.", test,
            assoEndIml.isNavigable());
    }

    /**
     * Tests isNavigable. Value should be gotten correctly.
     */
    public void testIsNavigableAccuracy() {
        boolean test = true;
        assoEndIml.setNavigable(test);
        assertEquals("Value should be getton correctly.", test,
            assoEndIml.isNavigable());
    }

    /**
     * Tests setOrdering. Value should be set correctly.
     */
    public void testSetOrderingAccuracy() {
        OrderingKind test = OrderingKind.ORDERED;
        assoEndIml.setOrdering(test);
        assertEquals("Value should be set correctly.", test,
            assoEndIml.getOrdering());
    }

    /**
     * Tests getOrdering. Value should be gotten correctly.
     */
    public void testGetOrderingAccuracy() {
        OrderingKind test = OrderingKind.ORDERED;
        assoEndIml.setOrdering(test);
        assertEquals("Value should be getton correctly.", test,
            assoEndIml.getOrdering());
    }

    /**
     * Tests setAggregation. Value should be set correctly.
     */
    public void testSetAggregationAccuracy() {
        AggregationKind test = AggregationKind.COMPOSITE;
        assoEndIml.setAggregation(test);
        assertEquals("Value should be set correctly.", test,
            assoEndIml.getAggregation());
    }

    /**
     * Tests getAggregation. Value should be gotten correctly.
     */
    public void testGetAggregationAccuracy() {
        AggregationKind test = AggregationKind.COMPOSITE;
        assoEndIml.setAggregation(test);
        assertEquals("Value should be getton correctly.", test,
            assoEndIml.getAggregation());
    }

    /**
     * Tests TargetKind. Value should be set correctly.
     */
    public void testSetTargetKindAccuracy() {
        ScopeKind test = ScopeKind.CLASSIFIER;
        assoEndIml.setTargetKind(test);
        assertEquals("Value should be set correctly.", test,
            assoEndIml.getTargetKind());
    }

    /**
     * Tests getTargetKind. Value should be gotten correctly.
     */
    public void testGetTargetKindAccuracy() {
        ScopeKind test = ScopeKind.CLASSIFIER;
        assoEndIml.setTargetKind(test);
        assertEquals("Value should be getton correctly.", test,
            assoEndIml.getTargetKind());
    }

    /**
     * Tests Multiplicity. Value should be set correctly.
     */
    public void testSetMultiplicityAccuracy() {
        Multiplicity test = new MultiplicityImpl();
        assoEndIml.setMultiplicity(test);
        assertEquals("Value should be set correctly.", test,
            assoEndIml.getMultiplicity());
    }

    /**
     * Tests getMultiplicity. Value should be gotten correctly.
     */
    public void testGetMultiplicityAccuracy() {
        Multiplicity test = new MultiplicityImpl();
        assoEndIml.setMultiplicity(test);
        assertEquals("Value should be getton correctly.", test,
            assoEndIml.getMultiplicity());
    }

    /**
     * Tests Changeability. Value should be set correctly.
     */
    public void testSetChangeabilityAccuracy() {
        ChangeableKind test = ChangeableKind.ADD_ONLY;
        assoEndIml.setChangeability(test);
        assertEquals("Value should be set correctly.", test,
            assoEndIml.getChangeability());
    }

    /**
     * Tests getChangeability. Value should be gotten correctly.
     */
    public void testGetChangeabilityAccuracy() {
        ChangeableKind test = ChangeableKind.ADD_ONLY;
        assoEndIml.setChangeability(test);
        assertEquals("Value should be getton correctly.", test,
            assoEndIml.getChangeability());
    }

    /**
     * Tests Association. Value should be set correctly.
     */
    public void testSetAssociationAccuracy() {
        Association test = new AssociationImpl();
        assoEndIml.setAssociation(test);
        assertEquals("Value should be set correctly.", test,
            assoEndIml.getAssociation());
    }

    /**
     * Tests getAssociation. Value should be gotten correctly.
     */
    public void testGetAssociationAccuracy() {
        Association test = new AssociationImpl();
        assoEndIml.setAssociation(test);
        assertEquals("Value should be getton correctly.", test,
            assoEndIml.getAssociation());
    }

    /**
     * Test addQualifier with null. IllegalArgumentException should be thrown because of the invalid parameter.
     */
    public void testAddQualifierWithNull() {
        try {
            assoEndIml.addQualifier(null);
            fail(
                "IllegalArgumentException should be thrown because of the invalid parameter.");
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test addQualifier accuracy. No exception should be thrown.
     */
    public void testAddQualifierAccuracy() {
        assoEndIml.addQualifier(attribute1);

        assertTrue("Add assoEnd failed.",
            assoEndIml.containsQualifier(attribute1));
    }

    /**
     * Test addQualifier accuracy for allowing duplicates. No exception should be thrown.
     */
    public void testAddQualifierAccuracyDuplicates() {
        assoEndIml.addQualifier(attribute1);
        assoEndIml.addQualifier(attribute1);

        assertTrue("Add assoEnds failed.", assoEndIml.countQualifiers() == 2);
    }

    /**
     * Test addQualifier at index with null.
     * IllegalArgumentException should be thrown because of the invalid parameter.
     */
    public void testAddQualifierAtIndexWithNull() {
        try {
            assoEndIml.addQualifier(0, null);
            fail(
                "IllegalArgumentException should be thrown because of the invalid parameter.");
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test addQualifier at index with null.
     * IndexOutOfBoundsException should be thrown because of the invalid parameter.
     */
    public void testAddQualifierAtIndexWithNegative() {
        try {
            assoEndIml.addQualifier(-1, attribute1);
            fail(
                "IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }
    }

    /**
     * Test addQualifier at index with null.
     * IndexOutOfBoundsException should be thrown because of the invalid parameter.
     */
    public void testAddQualifierAtIndexWithUpperBounds() {
        try {
            assoEndIml.addQualifier(1, attribute1);
            fail(
                "IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }
    }

    /**
     * Test addQualifier at index accuracy.
     * No exception should be thrown.
     */
    public void testAddQualifierAtIndexAccuracy() {
        assoEndIml.addQualifier(0, attribute1);

        assertTrue("Add assoEnds failed.",
            assoEndIml.containsQualifier(attribute1));
    }

    /**
     * Test setQualifier with null.
     * IllegalArgumentException should be thrown because of the invalid parameter.
     */
    public void testSetQualifierWithNull() {
        try {
            assoEndIml.setQualifier(0, null);
            fail(
                "IllegalArgumentException should be thrown because of the invalid parameter.");
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test setQualifier with null.
     * IndexOutOfBoundsException should be thrown because of the invalid parameter.
     */
    public void testSetQualifierWithNegative() {
        try {
            assoEndIml.setQualifier(-1, attribute1);
            fail(
                "IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }
    }

    /**
     * Test setQualifier with null.
     * IndexOutOfBoundsException should be thrown because of the invalid parameter.
     */
    public void testSetQualifierWithUpperBounds() {
        try {
            assoEndIml.setQualifier(0, attribute1);
            fail(
                "IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }
    }

    /**
     * Test setQualifier accuracy.
     * No exception should be thrown.
     */
    public void testSetQualifierAtIndexAccuracy() {
        assoEndIml.addQualifier(attribute1);
        assoEndIml.setQualifier(0, attribute2);

        assertFalse("Set assoEnds failed.",
            assoEndIml.containsQualifier(attribute1));
        assertTrue("Set assoEnds failed.",
            assoEndIml.containsQualifier(attribute2));
    }

    /**
     * Test removeQualifier with negative.
     * IndexOutOfBoundsException should be thrown.
     */
    public void testRemoveQualifierWithNegative() {
        try {
            assoEndIml.removeQualifier(-1);
            fail(
                "IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException ex) {
            // expected.
        }
    }

    /**
     * Test removeQualifier with upper bound.
     * IndexOutOfBoundsException should be thrown.
     */
    public void testRemoveQualifierWithUpperBound() {
        try {
            assoEndIml.removeQualifier(0);
            fail(
                "IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException ex) {
            // expected.
        }
    }

    /**
     * Test removeQualifier with index accuracy.
     * IndexOutOfBoundsException should be thrown.
     */
    public void testRemoveQualifierWithIndexAccuracy() {
        assoEndIml.addQualifier(attribute1);
        assoEndIml.removeQualifier(0);

        assertFalse("Remove connection failed.",
            assoEndIml.containsQualifier(attribute1));
    }

    /**
     * Test removeQualifier with null.
     * IllegalArgumentException should be thrown because of the invalid parameter.
     */
    public void testRemoveQualifierWithNull() {
        try {
            assoEndIml.removeQualifier(null);
            fail(
                "IllegalArgumentException should be thrown because of the invalid parameter.");
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test removeQualifier accuracy. No exception should be thrown.
     */
    public void testRemoveQualifierAccuracy() {
        assoEndIml.addQualifier(attribute1);
        assoEndIml.addQualifier(attribute2);
        assoEndIml.removeQualifier(attribute1);
        assertTrue("Remove assoEnd failed.", assoEndIml.countQualifiers() == 1);
        assertFalse("Remove assoEnd failed.",
            assoEndIml.containsQualifier(attribute1));
    }

    /**
     * Test clearQualifiers accuracy. No exception should be thrown.
     */
    public void testClearQualifiersAccuracy() {
        assoEndIml.addQualifier(attribute1);
        assoEndIml.addQualifier(attribute2);
        assoEndIml.clearQualifiers();

        assertTrue("Clear assoEnds failed.", assoEndIml.countQualifiers() == 0);
    }

    /**
     * Test getQualifiers accuracy for contained assoEnd. No exception should be thrown.
     */
    public void testGetQualifiers1() {
        assoEndIml.addQualifier(attribute1);
        assoEndIml.addQualifier(attribute2);

        List<Attribute> list = assoEndIml.getQualifiers();

        assertNotNull("Get assoEnds failed.", list);
        assertTrue("Get wrong assoEnds.", list.size() == 2);
        assertTrue("Get wrong assoEnds.", list.contains(attribute1));
        assertTrue("Get wrong assoEnds.", list.contains(attribute2));
    }

    /**
     * Test containQualifier with null. IllegalArgumentException should be thrown because of the invalid parameter.
     */
    public void testContainQualifierWithNull() {
        try {
            assoEndIml.containsQualifier(null);
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test containQualifier accuracy. No exception should be thrown.
     */
    public void testContainQualifierAccracy() {
        assoEndIml.addQualifier(attribute1);

        assertTrue("containsQualifier returns a wrong value.",
            assoEndIml.containsQualifier(attribute1));
        assertFalse("containsQualifier returns a wrong value.",
            assoEndIml.containsQualifier(attribute2));
    }

    /**
     * Test countQualifiers accuracy. No exception should be thrown.
     */
    public void testCountQualifiersAccuracy() {
        assertTrue("Count assoEnds error.", assoEndIml.countQualifiers() == 0);
        assoEndIml.addQualifier(attribute1);
        assoEndIml.addQualifier(attribute2);
        assertTrue("Count assoEnds error.", assoEndIml.countQualifiers() == 2);
        assoEndIml.removeQualifier(attribute1);
        assertTrue("Count assoEnds error.", assoEndIml.countQualifiers() == 1);
    }

    /**
     * Tests Participant. Value should be set correctly.
     */
    public void testSetParticipantAccuracy() {
        Classifier test = new ClassImpl();
        assoEndIml.setParticipant(test);
        assertEquals("Value should be set correctly.", test,
            assoEndIml.getParticipant());
    }

    /**
     * Tests getParticipant. Value should be gotten correctly.
     */
    public void testGetParticipantAccuracy() {
        Classifier test = new ClassImpl();
        assoEndIml.setParticipant(test);
        assertEquals("Value should be getton correctly.", test,
            assoEndIml.getParticipant());
    }

    /**
     * Test addSpecification with null. IllegalArgumentException should be thrown because of the invalid parameter.
     */
    public void testAddSpecificationWithNull() {
        try {
            assoEndIml.addSpecification(null);
            fail(
                "IllegalArgumentException should be thrown because of the invalid parameter.");
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test addSpecification accuracy. No exception should be thrown.
     */
    public void testAddSpecificationAccuracy() {
        assoEndIml.addSpecification(classifier1);

        assertTrue("Add assoEnd failed.",
            assoEndIml.containsSpecification(classifier1));
    }

    /**
     * Test addSpecification accuracy for allowing duplicates. No exception should be thrown.
     */
    public void testAddSpecificationAccuracyDuplicates() {
        assoEndIml.addSpecification(classifier1);
        assoEndIml.addSpecification(classifier1);

        assertTrue("Add assoEnds failed.", assoEndIml.countSpecifications() == 2);
    }

    /**
     * Test removeSpecification with null.
     * IllegalArgumentException should be thrown because of the invalid parameter.
     */
    public void testRemoveSpecificationWithNull() {
        try {
            assoEndIml.removeSpecification(null);
            fail(
                "IllegalArgumentException should be thrown because of the invalid parameter.");
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test removeSpecification accuracy. No exception should be thrown.
     */
    public void testRemoveSpecificationAccuracy() {
        assoEndIml.addSpecification(classifier1);
        assoEndIml.addSpecification(classifier2);
        assoEndIml.removeSpecification(classifier1);
        assertTrue("Remove assoEnd failed.",
            assoEndIml.countSpecifications() == 1);
        assertFalse("Remove assoEnd failed.",
            assoEndIml.containsSpecification(classifier1));
    }

    /**
     * Test clearSpecifications accuracy. No exception should be thrown.
     */
    public void testClearSpecificationsAccuracy() {
        assoEndIml.addSpecification(classifier1);
        assoEndIml.addSpecification(classifier2);
        assoEndIml.clearSpecifications();

        assertTrue("Clear assoEnds failed.",
            assoEndIml.countSpecifications() == 0);
    }

    /**
     * Test getSpecifications accuracy for contained assoEnd. No exception should be thrown.
     */
    public void testGetSpecifications1() {
        assoEndIml.addSpecification(classifier1);
        assoEndIml.addSpecification(classifier2);

        Collection<Classifier> collection = assoEndIml.getSpecifications();

        assertNotNull("Get assoEnds failed.", collection);
        assertTrue("Get wrong assoEnds.", collection.size() == 2);
        assertTrue("Get wrong assoEnds.", collection.contains(classifier1));
        assertTrue("Get wrong assoEnds.", collection.contains(classifier2));
    }

    /**
     * Test containSpecification with null. IllegalArgumentException should be thrown because of the invalid parameter.
     */
    public void testContainSpecificationWithNull() {
        try {
            assoEndIml.containsSpecification(null);
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test containSpecification accuracy. No exception should be thrown.
     */
    public void testContainSpecificationAccracy() {
        assoEndIml.addSpecification(classifier1);

        assertTrue("containsSpecification returns a wrong value.",
            assoEndIml.containsSpecification(classifier1));
        assertFalse("containsSpecification returns a wrong value.",
            assoEndIml.containsSpecification(classifier2));
    }

    /**
     * Test countSpecifications accuracy. No exception should be thrown.
     */
    public void testCountSpecificationsAccuracy() {
        assertTrue("Count assoEnds error.",
            assoEndIml.countSpecifications() == 0);
        assoEndIml.addSpecification(classifier1);
        assoEndIml.addSpecification(classifier2);
        assertTrue("Count assoEnds error.",
            assoEndIml.countSpecifications() == 2);
        assoEndIml.removeSpecification(classifier1);
        assertTrue("Count assoEnds error.",
            assoEndIml.countSpecifications() == 1);
    }
}
