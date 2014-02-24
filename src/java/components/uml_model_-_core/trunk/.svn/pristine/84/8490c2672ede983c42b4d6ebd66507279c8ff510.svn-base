/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.accuracytests;

import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.core.ClassifierAbstractImpl;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.StructuralFeature;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;

/**
 * <p>
 * Accuracy tests for <code>ClassifierAbstractImpl</code>.
 * </p>
 * @author littlebull
 * @version 1.0
 */
public class ClassifierAbstractImplAccuracyTests extends TestCase {

    /**
     * Represents the <code>ClassifierAbstractImpl</code> instance used for
     * testing.
     */
    private ClassifierAbstractImpl classifier;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        // creates the mocked ClassifierAbstractImpl instance
        classifier = new MockClassifierImpl();
    }

    /**
     * Accuracy test of method <code>addFeature(Feature)</code>,
     * <code>addFeature(int, Feature)</code>,
     * <code>setFeature(int, Feature)</code>,
     * <code>removeFeature(Feature)</code>, <code>removeFeature(int)</code>,
     * <code>containsFeature(Feature)</code>,
     * <code>indexOfFeature(Feature)</code>, <code>clearFeatures()</code>,
     * <code>getFeatures()</code> and <code>countFeatures()</code>.
     */
    public void testFeatureOperations() {
        // initial value is empty LinkedList
        assertEquals(0, classifier.countFeatures());
        // add a Feature
        Feature feature0 = new MockFeatureImpl();
        classifier.addFeature(feature0);
        assertEquals(1, classifier.countFeatures());
        // add another Feature
        Feature feature1 = new MockFeatureImpl();
        classifier.addFeature(0, feature1);
        assertEquals(2, classifier.countFeatures());
        assertEquals(1, classifier.indexOfFeature(feature0));
        assertEquals(0, classifier.indexOfFeature(feature1));
        // set a new Feature
        Feature feature2 = new MockFeatureImpl();
        classifier.setFeature(1, feature2);
        assertEquals(2, classifier.countFeatures());
        assertEquals(1, classifier.indexOfFeature(feature2));
        assertEquals(0, classifier.indexOfFeature(feature1));
        assertFalse(classifier.containsFeature(feature0));
        // remove a Feature
        assertFalse(classifier.removeFeature(feature0));
        assertEquals(feature2, classifier.removeFeature(1));
        assertEquals(1, classifier.countFeatures());
        // get all the Feature
        List<Feature> features = classifier.getFeatures();
        assertEquals(1, features.size());
        // clear all the Feature
        classifier.clearFeatures();
        assertEquals(0, classifier.countFeatures());
    }

    /**
     * Accuracy test of method <code>addTypedFeature(StructuralFeature)</code>,
     * <code>removeTypedFeature(StructuralFeature)</code>,
     * <code>containsTypedFeature(StructuralFeature)</code>,
     * <code>clearTypedFeatures()</code>, <code>getTypedFeatures()</code>
     * and <code>countTypedFeatures()</code>.
     */
    public void testTypedFeatureOperations() {
        // initial value is an empty ArrayList
        assertEquals(0, classifier.countTypedFeatures());
        // add a TypedFeature
        StructuralFeature feature0 = new MockStructuralFeatureImpl();
        classifier.addTypedFeature(feature0);
        assertEquals(1, classifier.countTypedFeatures());
        assertTrue(classifier.containsTypedFeature(feature0));
        // add another two TypedFeatures
        StructuralFeature feature1 = new MockStructuralFeatureImpl();
        classifier.addTypedFeature(feature1);
        StructuralFeature feature2 = feature1;
        classifier.addTypedFeature(feature2);
        assertEquals(3, classifier.countTypedFeatures());
        // get all the TypedFeatures
        Collection<StructuralFeature> features = classifier.getTypedFeatures();
        assertEquals(3, features.size());
        // remove a TypedFeature
        assertTrue(classifier.removeTypedFeature(feature1));
        assertEquals(2, classifier.countTypedFeatures());
        assertFalse(classifier.removeTypedFeature(new MockStructuralFeatureImpl()));
        // clear all the TypedFeatures
        classifier.clearTypedFeatures();
        assertEquals(0, classifier.countTypedFeatures());
    }

    /**
     * Accuracy test of method <code>addTypedParameter(Parameter)</code>,
     * <code>removeTypedParameter(Parameter)</code>,
     * <code>containsTypedParameter(Parameter)</code>,
     * <code>clearTypedParameters()</code>, <code>getTypedParameters()</code>
     * and <code>countTypedParameters()</code>.
     */
    public void testTypedParameterOperations() {
        // initial value is an empty ArrayList
        assertEquals(0, classifier.countTypedParameters());
        // add a TypedParameter
        Parameter parameter0 = new ParameterImpl();
        classifier.addTypedParameter(parameter0);
        assertEquals(1, classifier.countTypedParameters());
        assertTrue(classifier.containsTypedParameter(parameter0));
        // add another two TypedParameters
        Parameter parameter1 = new ParameterImpl();
        classifier.addTypedParameter(parameter1);
        Parameter parameter2 = parameter1;
        classifier.addTypedParameter(parameter2);
        assertEquals(3, classifier.countTypedParameters());
        // get all the TypedParameters
        Collection<Parameter> parameters = classifier.getTypedParameters();
        assertEquals(3, parameters.size());
        // remove a TypedParameter
        assertTrue(classifier.removeTypedParameter(parameter1));
        assertEquals(2, classifier.countTypedParameters());
        assertFalse(classifier.removeTypedParameter(new ParameterImpl()));
        // clear all the TypedParameters
        classifier.clearTypedParameters();
        assertEquals(0, classifier.countTypedParameters());
    }

    /**
     * Accuracy test of method <code>addAssociation(AssociationEnd)</code>,
     * <code>removeAssociation(AssociationEnd)</code>,
     * <code>containsAssociation(AssociationEnd)</code>,
     * <code>clearAssociations()</code>, <code>getAssociations()</code> and
     * <code>countAssociations()</code>.
     */
    public void testAssociationOperations() {
        // initial value is an empty ArrayList
        assertEquals(0, classifier.countAssociations());
        // add a Association
        AssociationEnd association0 = new AssociationEndImpl();
        classifier.addAssociation(association0);
        assertEquals(1, classifier.countAssociations());
        assertTrue(classifier.containsAssociation(association0));
        // add another two Associations
        AssociationEnd association1 = new AssociationEndImpl();
        classifier.addAssociation(association1);
        AssociationEnd association2 = association1;
        classifier.addAssociation(association2);
        assertEquals(3, classifier.countAssociations());
        // get all the Associations
        Collection<AssociationEnd> associations = classifier.getAssociations();
        assertEquals(3, associations.size());
        // remove a Association
        assertTrue(classifier.removeAssociation(association1));
        assertEquals(2, classifier.countAssociations());
        assertFalse(classifier.removeAssociation(new AssociationEndImpl()));
        // clear all the Associations
        classifier.clearAssociations();
        assertEquals(0, classifier.countAssociations());
    }

    /**
     * Accuracy test of method <code>addSpecifiedEnd(AssociationEnd)</code>,
     * <code>removeSpecifiedEnd(AssociationEnd)</code>,
     * <code>containsSpecifiedEnd(AssociationEnd)</code>,
     * <code>clearSpecifiedEnds()</code>, <code>getSpecifiedEnds()</code>
     * and <code>countSpecifiedEnds()</code>.
     */
    public void testSpecifiedEndOperations() {
        // initial value is an empty ArrayList
        assertEquals(0, classifier.countSpecifiedEnds());
        // add a SpecifiedEnd
        AssociationEnd specifiedEnd0 = new AssociationEndImpl();
        classifier.addSpecifiedEnd(specifiedEnd0);
        assertEquals(1, classifier.countSpecifiedEnds());
        assertTrue(classifier.containsSpecifiedEnd(specifiedEnd0));
        // add another two SpecifiedEnds
        AssociationEnd specifiedEnd1 = new AssociationEndImpl();
        classifier.addSpecifiedEnd(specifiedEnd1);
        AssociationEnd specifiedEnd2 = specifiedEnd1;
        classifier.addSpecifiedEnd(specifiedEnd2);
        assertEquals(3, classifier.countSpecifiedEnds());
        // get all the SpecifiedEnds
        Collection<AssociationEnd> specifiedEnds = classifier.getSpecifiedEnds();
        assertEquals(3, specifiedEnds.size());
        // remove a SpecifiedEnd
        assertTrue(classifier.removeSpecifiedEnd(specifiedEnd1));
        assertEquals(2, classifier.countSpecifiedEnds());
        assertFalse(classifier.removeSpecifiedEnd(new AssociationEndImpl()));
        // clear all the SpecifiedEnds
        classifier.clearSpecifiedEnds();
        assertEquals(0, classifier.countSpecifiedEnds());
    }

    /**
     * Accuracy test of method <code>addPowertypeRange(Generalization)</code>,
     * <code>removePowertypeRange(Generalization)</code>,
     * <code>containsPowertypeRange(Generalization)</code>,
     * <code>clearPowertypeRanges()</code>, <code>getPowertypeRanges()</code>
     * and <code>countPowertypeRanges()</code>.
     */
    public void testPowertypeRangeOperations() {
        // initial value is an empty ArrayList
        assertEquals(0, classifier.countPowertypeRanges());
        // add a PowertypeRange
        Generalization range0 = new GeneralizationImpl();
        classifier.addPowertypeRange(range0);
        assertEquals(1, classifier.countPowertypeRanges());
        assertTrue(classifier.containsPowertypeRange(range0));
        // add another two PowertypeRanges
        Generalization range1 = new GeneralizationImpl();
        classifier.addPowertypeRange(range1);
        Generalization range2 = range1;
        classifier.addPowertypeRange(range2);
        assertEquals(3, classifier.countPowertypeRanges());
        // get all the PowertypeRanges
        Collection<Generalization> ranges = classifier.getPowertypeRanges();
        assertEquals(3, ranges.size());
        // remove a PowertypeRange
        assertTrue(classifier.removePowertypeRange(range1));
        assertEquals(2, classifier.countPowertypeRanges());
        assertFalse(classifier.removePowertypeRange(new GeneralizationImpl()));
        // clear all the PowertypeRanges
        classifier.clearPowertypeRanges();
        assertEquals(0, classifier.countPowertypeRanges());
    }

    /**
     * Accuracy test of method <code>addObjectFlowState(ObjectFlowState)</code>,
     * <code>removeObjectFlowState(ObjectFlowState)</code>,
     * <code>containsObjectFlowState(ObjectFlowState)</code>,
     * <code>clearObjectFlowStates()</code>,
     * <code>getObjectFlowStates()</code> and
     * <code>countObjectFlowStates()</code>.
     */
    public void testObjectFlowStateOperations() {
        // initial value is an empty ArrayList
        assertEquals(0, classifier.countObjectFlowStates());
        // add a ObjectFlowState
        ObjectFlowState state0 = new ObjectFlowStateImpl();
        classifier.addObjectFlowState(state0);
        assertEquals(1, classifier.countObjectFlowStates());
        assertTrue(classifier.containsObjectFlowState(state0));
        // add another two ObjectFlowStates
        ObjectFlowState state1 = new ObjectFlowStateImpl();
        classifier.addObjectFlowState(state1);
        ObjectFlowState state2 = state1;
        classifier.addObjectFlowState(state2);
        assertEquals(3, classifier.countObjectFlowStates());
        // get all the ObjectFlowStates
        Collection<ObjectFlowState> states = classifier.getObjectFlowStates();
        assertEquals(3, states.size());
        // remove a ObjectFlowState
        assertTrue(classifier.removeObjectFlowState(state1));
        assertEquals(2, classifier.countObjectFlowStates());
        assertFalse(classifier.removeObjectFlowState(new ObjectFlowStateImpl()));
        // clear all the ObjectFlowStates
        classifier.clearObjectFlowStates();
        assertEquals(0, classifier.countObjectFlowStates());
    }

    /**
     * Accuracy test of method <code>addInstance(Instance)</code>,
     * <code>removeInstance(Instance)</code>,
     * <code>containsInstance(Instance)</code>, <code>clearInstances()</code>,
     * <code>getInstances()</code> and <code>countInstances()</code>.
     */
    public void testInstanceOperations() {
        // initial value is an empty ArrayList
        assertEquals(0, classifier.countInstances());
        // add a Instance
        Instance instance0 = new MockInstanceImpl();
        classifier.addInstance(instance0);
        assertEquals(1, classifier.countInstances());
        assertTrue(classifier.containsInstance(instance0));
        // add another two Instances
        Instance instance1 = new MockInstanceImpl();
        classifier.addInstance(instance1);
        Instance instance2 = instance1;
        classifier.addInstance(instance2);
        assertEquals(3, classifier.countInstances());
        // get all the Instances
        Collection<Instance> instances = classifier.getInstances();
        assertEquals(3, instances.size());
        // remove a Instance
        assertTrue(classifier.removeInstance(instance1));
        assertEquals(2, classifier.countInstances());
        assertFalse(classifier.removeInstance(new MockInstanceImpl()));
        // clear all the Instances
        classifier.clearInstances();
        assertEquals(0, classifier.countInstances());
    }

    /**
     * Accuracy test of method <code>addOwnedElement(ModelElement)</code>,
     * <code>removeOwnedElement(ModelElement)</code>,
     * <code>containsOwnedElement(ModelElement)</code>,
     * <code>clearOwnedElements()</code>, <code>getOwnedElements()</code>
     * and <code>countOwnedElements()</code>.
     */
    public void testOwnedElementOperations() {
        // initial value is an empty ArrayList
        assertEquals(0, classifier.countOwnedElements());
        // add a OwnedElement
        ModelElement element0 = new MockModelElementImpl();
        classifier.addOwnedElement(element0);
        assertEquals(1, classifier.countOwnedElements());
        assertTrue(classifier.containsOwnedElement(element0));
        // add another two OwnedElements
        ModelElement element1 = new MockModelElementImpl();
        classifier.addOwnedElement(element1);
        ModelElement element2 = element1;
        classifier.addOwnedElement(element2);
        assertEquals(3, classifier.countOwnedElements());
        // get all the OwnedElements
        Collection<ModelElement> elements = classifier.getOwnedElements();
        assertEquals(3, elements.size());
        // remove a OwnedElement
        assertTrue(classifier.removeOwnedElement(element1));
        assertEquals(2, classifier.countOwnedElements());
        assertFalse(classifier.removeOwnedElement(new MockModelElementImpl()));
        // clear all the OwnedElements
        classifier.clearOwnedElements();
        assertEquals(0, classifier.countOwnedElements());
    }
}
