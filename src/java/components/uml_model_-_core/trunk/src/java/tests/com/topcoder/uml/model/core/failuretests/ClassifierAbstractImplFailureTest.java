/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.ClassifierAbstractImpl;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.FeatureAbstractImpl;

/**
 * Aggregates all failure tests for ClassifierAbstractImpl class.
 * @author vilain
 * @version 1.0
 */
public class ClassifierAbstractImplFailureTest extends TestCase {

    /**
     * Index for testing.
     */
    private int index = 0;

    /**
     * Instance of Feature for testing.
     */
    private Feature feature;

    /**
     * Instance of BehavioralFeatureAbstractImpl for testing.
     */
    private ClassifierAbstractImpl classifierAbstractImpl;

    /**
     * Setting up environment for each test case.
     */
    protected void setUp() {
        feature = new FeatureAbstractImpl() {
        };
        classifierAbstractImpl = new ClassifierAbstractImpl() {
        };
    }

    /**
     * Method under test ClassifierAbstractImpl.addFeature(Feature). Failure
     * testing of exception in case feature is null.
     */
    public final void testAddFeatureFeature() {
        try {
            classifierAbstractImpl.addFeature(null);
            fail("IllegalArgumentException is expected since feature is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.addFeature(int, Feature).
     * Failure testing of exception in case index is out of bounds.
     */
    public final void testAddFeatureIntFeatureIndexLess() {
        try {
            classifierAbstractImpl.addFeature(-1, feature);
            fail("IndexOutOfBoundsException is expected since index is out of bounds");
        } catch (IndexOutOfBoundsException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.addFeature(int, Feature).
     * Failure testing of exception in case index is out of bounds.
     */
    public final void testAddFeatureIntFeatureIndexGreater() {
        try {
            classifierAbstractImpl.addFeature(1, feature);
            fail("IndexOutOfBoundsException is expected since index is out of bounds");
        } catch (IndexOutOfBoundsException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.addFeature(int, Feature).
     * Failure testing of exception in case feature is null.
     */
    public final void testAddFeatureIntFeatureNull() {
        try {
            classifierAbstractImpl.addFeature(index, null);
            fail("IllegalArgumentException is expected since feature is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.setFeature(int, Feature).
     * Failure testing of exception in case index is out of bounds.
     */
    public final void testSetFeatureIndexLess() {
        try {
            classifierAbstractImpl.setFeature(-1, feature);
            fail("IndexOutOfBoundsException is expected since index is out of bounds");
        } catch (IndexOutOfBoundsException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.setFeature(int, Feature).
     * Failure testing of exception in case index is out of bounds.
     */
    public final void testSetFeatureIndexGreater() {
        try {
            classifierAbstractImpl.setFeature(0, feature);
            fail("IndexOutOfBoundsException is expected since index is out of bounds");
        } catch (IndexOutOfBoundsException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.setFeature(int, Feature).
     * Failure testing of exception in case feature is null.
     */
    public final void testSetFeatureIntFeatureNull() {
        classifierAbstractImpl.addFeature(feature);
        try {
            classifierAbstractImpl.setFeature(index, null);
            fail("IllegalArgumentException is expected since feature is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.removeFeature(int). Failure
     * testing of exception in case index is out of bounds.
     */
    public final void testRemoveFeatureIntIndexLess() {
        try {
            classifierAbstractImpl.removeFeature(-1);
            fail("IndexOutOfBoundsException is expected since index is out of bounds");
        } catch (IndexOutOfBoundsException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.removeFeature(int). Failure
     * testing of exception in case index is out of bounds.
     */
    public final void testRemoveFeatureIntIndexGreater() {
        classifierAbstractImpl.addFeature(feature);
        try {
            classifierAbstractImpl.removeFeature(1);
            fail("IndexOutOfBoundsException is expected since index is out of bounds");
        } catch (IndexOutOfBoundsException e) {
            // good
        }

    }

    /**
     * Method under test ClassifierAbstractImpl.removeFeature(Feature). Failure
     * testing of exception in case feature is null.
     */
    public final void testRemoveFeatureFeatureNull() {
        try {
            classifierAbstractImpl.removeFeature(null);
            fail("IllegalArgumentException is expected since feature is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.containsFeature(Feature).
     * Failure testing of exception in case feature is null.
     */
    public final void testContainsFeatureNull() {
        try {
            classifierAbstractImpl.containsFeature(null);
            fail("IllegalArgumentException is expected since feature is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.indexOfFeature(Feature). Failure
     * testing of exception in case feature is null.
     */
    public final void testIndexOfFeatureNull() {
        try {
            classifierAbstractImpl.indexOfFeature(null);
            fail("IllegalArgumentException is expected since feature is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.addTypedFeature(StructuralFeature). Failure
     * testing of exception in case typed feature is null.
     */
    public final void testAddTypedFeatureNull() {
        try {
            classifierAbstractImpl.addTypedFeature(null);
            fail("IllegalArgumentException is expected since typed feature is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.removeTypedFeature(StructuralFeature). Failure
     * testing of exception in case typed feature is null.
     */
    public final void testRemoveTypedFeatureNull() {
        try {
            classifierAbstractImpl.removeTypedFeature(null);
            fail("IllegalArgumentException is expected since typed feature is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.containsTypedFeature(StructuralFeature). Failure
     * testing of exception in case typed feature is null.
     */
    public final void testContainsTypedFeatureNull() {
        try {
            classifierAbstractImpl.containsTypedFeature(null);
            fail("IllegalArgumentException is expected since typed feature is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.addTypedParameter(Parameter).
     * Failure testing of exception in case typed parameter is null.
     */
    public final void testAddTypedParameterNull() {
        try {
            classifierAbstractImpl.addTypedParameter(null);
            fail("IllegalArgumentException is expected since typed parameter is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.removeTypedParameter(Parameter).
     * Failure testing of exception in case typed parameter is null.
     */
    public final void testRemoveTypedParameterNull() {
        try {
            classifierAbstractImpl.removeTypedParameter(null);
            fail("IllegalArgumentException is expected since typed parameter is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.containsTypedParameter(Parameter). Failure testing
     * of exception in case typed parameter is null.
     */
    public final void testContainsTypedParameterNull() {
        try {
            classifierAbstractImpl.containsTypedParameter(null);
            fail("IllegalArgumentException is expected since typed parameter is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.addAssociation(AssociationEnd).
     * Failure testing of exception in case association is null.
     */
    public final void testAddAssociationNull() {
        try {
            classifierAbstractImpl.addAssociation(null);
            fail("IllegalArgumentException is expected since association is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.removeAssociation(AssociationEnd). Failure testing
     * of exception in case association is null.
     */
    public final void testRemoveAssociationNull() {
        try {
            classifierAbstractImpl.removeAssociation(null);
            fail("IllegalArgumentException is expected since association is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.containsAssociation(AssociationEnd). Failure
     * testing of exception in case association is null.
     */
    public final void testContainsAssociationNull() {
        try {
            classifierAbstractImpl.containsAssociation(null);
            fail("IllegalArgumentException is expected since association is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.addSpecifiedEnd(SpecifiedEndEnd). Failure testing
     * of exception in case specified end is null.
     */
    public final void testAddSpecifiedEndNull() {
        try {
            classifierAbstractImpl.addSpecifiedEnd(null);
            fail("IllegalArgumentException is expected since specified end is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.removeSpecifiedEnd(SpecifiedEndEnd). Failure
     * testing of exception in case specified end is null.
     */
    public final void testRemoveSpecifiedEndNull() {
        try {
            classifierAbstractImpl.removeSpecifiedEnd(null);
            fail("IllegalArgumentException is expected since specified end is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.containsSpecifiedEnd(SpecifiedEndEnd). Failure
     * testing of exception in case specified end is null.
     */
    public final void testContainsSpecifiedEndNull() {
        try {
            classifierAbstractImpl.containsSpecifiedEnd(null);
            fail("IllegalArgumentException is expected since specified end is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.addPowertypeRange(Generalization). Failure testing
     * of exception in case powertype range is null.
     */
    public final void testAddPowertypeRangeNull() {
        try {
            classifierAbstractImpl.addPowertypeRange(null);
            fail("IllegalArgumentException is expected since powertype range is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.removePowertypeRange(Generalization). Failure
     * testing of exception in case powertype range is null.
     */
    public final void testRemovePowertypeRangeNull() {
        try {
            classifierAbstractImpl.removePowertypeRange(null);
            fail("IllegalArgumentException is expected since powertype range is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.containsPowertypeRange(Generalization). Failure
     * testing of exception in case powertype range is null.
     */
    public final void testContainsPowertypeRangeNull() {
        try {
            classifierAbstractImpl.containsPowertypeRange(null);
            fail("IllegalArgumentException is expected since powertype range is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.addObjectFlowState(ObjectFlowState). Failure
     * testing of exception in case object flow state is null.
     */
    public final void testAddObjectFlowStateNull() {
        try {
            classifierAbstractImpl.addObjectFlowState(null);
            fail("IllegalArgumentException is expected since object flow state is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.removeObjectFlowState(ObjectFlowState). Failure
     * testing of exception in case object flow state is null.
     */
    public final void testRemoveObjectFlowStateNull() {
        try {
            classifierAbstractImpl.removeObjectFlowState(null);
            fail("IllegalArgumentException is expected since object flow state is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.containsObjectFlowState(ObjectFlowState). Failure
     * testing of exception in case object flow state is null.
     */
    public final void testContainsObjectFlowStateNull() {
        try {
            classifierAbstractImpl.containsObjectFlowState(null);
            fail("IllegalArgumentException is expected since object flow state is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.addInstance(Instance). Failure
     * testing of exception in case instance is null.
     */
    public final void testAddInstanceNull() {
        try {
            classifierAbstractImpl.addInstance(null);
            fail("IllegalArgumentException is expected since instance is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.removeInstance(Instance).
     * Failure testing of exception in case instance is null.
     */
    public final void testRemoveInstanceNull() {
        try {
            classifierAbstractImpl.removeInstance(null);
            fail("IllegalArgumentException is expected since instance is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.containsInstance(Instance).
     * Failure testing of exception in case instance is null.
     */
    public final void testContainsInstanceNull() {
        try {
            classifierAbstractImpl.containsInstance(null);
            fail("IllegalArgumentException is expected since instance is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test ClassifierAbstractImpl.addOwnedElement(ModelElement).
     * Failure testing of exception in case owned element is null.
     */
    public final void testAddOwnedElementNull() {
        try {
            classifierAbstractImpl.addOwnedElement(null);
            fail("IllegalArgumentException is expected since owned element is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.removeOwnedElement(ModelElement). Failure testing
     * of exception in case owned element is null.
     */
    public final void testRemoveOwnedElementNull() {
        try {
            classifierAbstractImpl.removeOwnedElement(null);
            fail("IllegalArgumentException is expected since owned element is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * ClassifierAbstractImpl.containsOwnedElement(ModelElement). Failure
     * testing of exception in case owned element is null.
     */
    public final void testContainsOwnedElementNull() {
        try {
            classifierAbstractImpl.containsOwnedElement(null);
            fail("IllegalArgumentException is expected since owned element is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}