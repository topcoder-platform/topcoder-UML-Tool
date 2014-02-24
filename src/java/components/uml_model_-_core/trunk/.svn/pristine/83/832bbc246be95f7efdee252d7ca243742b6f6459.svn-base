/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import junit.framework.TestCase;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.InstanceAbstractImpl;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * <p>
 * Unit test for <code>ClassifierAbstractImpl</code> class.
 * </p>
 *
 * @author vividmxx
 * @version 1.0
 */
public class ClassifierAbstractImplUnitTests extends TestCase {

    /**
     * <p>
     * This class extends the <code>ClassifierAbstractImpl</code>. It is only used in unit test.
     * </p>
     */
    private class ClassifierImpl extends ClassifierAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public ClassifierImpl() {
        }
    }

    /**
     * This class extends the <code>FeatureAbstractImpl</code>. It is only used in unit test.
     */
    private class FeatureImpl extends FeatureAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public FeatureImpl() {
        }
    }

    /**
     * This class extends <code>ModelElementAbstractImpl</code>. It is only used in unit test.
     */
    private class ModelElementImpl extends ModelElementAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public ModelElementImpl() {
        }
    }

    /**
     * <p>
     * This class extends the <code>StructuralFeatureAbstractImpl</code>. It is only used in unit test.
     * </p>
     */
    public class StructuralFeatureImpl extends StructuralFeatureAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public StructuralFeatureImpl() {
        }
    }

    /**
     * <p>
     * Represents the <code>ClassifierAbstractImpl</code> instance used for tests.
     * </p>
     */
    private ClassifierAbstractImpl testClassifierAbstractImpl;

    /**
     * <p>
     * Set up the test environment.
     * </p>
     */
    protected void setUp() {
        testClassifierAbstractImpl = new ClassifierImpl();
    }

    /**
     * <p>
     * Accuracy test the <code>ClassifierAbstractImpl()</code> constructor. ClassifierAbstractImpl instance should be
     * created.
     * </p>
     */
    public void testClassifierAbstractImplConstructor() {
        assertNotNull("Create ClassifierAbstractImpl object incorrectly.", new ClassifierImpl());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addFeature(Feature)</code>.
     * </p>
     */
    public void testAddFeatureFeature() {
        Feature feature = new FeatureImpl();
        testClassifierAbstractImpl.addFeature(feature);
        assertTrue("Add feature incorrectly.", testClassifierAbstractImpl.containsFeature(feature));
    }

    /**
     * <p>
     * Test the method of <code>addFeature(Feature)</code> with null feature. Should throw IllegalArgumentException.
     * </p>
     */
    public void testAddFeatureFeatureNullFeature() {
        try {
            testClassifierAbstractImpl.addFeature(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>addFeature(int, Feature)</code>.
     * <p>
     */
    public void testAddFeatureIntFeature() {
        Feature feature = new FeatureImpl();
        testClassifierAbstractImpl.addFeature(0, feature);
        assertTrue("Add feature incorrectly.", testClassifierAbstractImpl.containsFeature(feature));
    }

    /**
     * <p>
     * Test the method of <code>addFeature(int, Feature)</code> with negative index. Should throw
     * IndexOutOfBoundsException.
     * </p>
     */
    public void testAddFeatureNegativeIntFeature() {
        try {
            testClassifierAbstractImpl.addFeature(-1, new FeatureImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method of <code>addFeature(int, Feature)</code> with too large index. Should throw
     * IndexOutOfBoundsException.
     * </p>
     */
    public void testAddFeatureTooLargeIntFeature() {
        try {
            testClassifierAbstractImpl.addFeature(100000, new FeatureImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method of <code>addFeature(int, Feature)</code> with null Feature. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddFeatureIntNullFeature() {
        try {
            testClassifierAbstractImpl.addFeature(0, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>setFeature(int, Feature)</code>.
     * </p>
     */
    public void testSetFeature() {
        Feature feature1 = new FeatureImpl();
        testClassifierAbstractImpl.addFeature(0, feature1);

        // replace the feature1 with feature2.
        Feature feature2 = new FeatureImpl();
        testClassifierAbstractImpl.setFeature(0, feature2);
        assertEquals("Set feature incorrectly.", feature2, testClassifierAbstractImpl.removeFeature(0));
    }

    /**
     * <p>
     * Test the method of <code>setFeature(int, Feature)</code> with negative index. Should throw
     * IndexOutOfBoundsException.
     * </p>
     */
    public void testSetFeatureNegativeInt() {
        try {
            testClassifierAbstractImpl.setFeature(-1, new FeatureImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method of <code>setFeature(int, Feature)</code> with too large index. Should throw
     * IndexOutOfBoundsException.
     * </p>
     */
    public void testSetFeatureTooLargeInt() {
        try {
            testClassifierAbstractImpl.setFeature(10000, new FeatureImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method of <code>setFeature(int, Feature)</code> with null feature. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testSetFeatureNullFeature() {
        try {
            testClassifierAbstractImpl.addFeature(new FeatureImpl());
            testClassifierAbstractImpl.setFeature(0, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeFeature(int)</code>.
     * </p>
     */
    public void testRemoveFeatureInt() {
        Feature feature = new FeatureImpl();
        testClassifierAbstractImpl.addFeature(0, feature);
        assertEquals("Remove feature incorrectly.", feature, testClassifierAbstractImpl.removeFeature(0));
    }

    /**
     * <p>
     * Test the method of <code>addFeature(int)</code> with negative index. Should throw IndexOutOfBoundsException.
     * </p>
     */
    public void testRemoveFeatureNegativeInt() {
        try {
            testClassifierAbstractImpl.removeFeature(-1);
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method of <code>addFeature(int)</code> with too large index. Should throw IndexOutOfBoundsException.
     * </p>
     */
    public void testRemoveFeatureTooLargeInt() {
        try {
            testClassifierAbstractImpl.removeFeature(9999);
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeFeature(Feature)</code>.
     * </p>
     */
    public void testRemoveFeatureFeature() {
        Feature feature = new FeatureImpl();
        testClassifierAbstractImpl.addFeature(feature);
        assertTrue("Remove feature incorrectly.", testClassifierAbstractImpl.removeFeature(feature));
    }

    /**
     * <p>
     * Test the method of <code>removeFeature(Feature)</code> with null feature. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveFeatureNullFeature() {
        try {
            testClassifierAbstractImpl.removeFeature(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearFeatures()</code>.
     * </p>
     */
    public void testClearFeatures() {
        testClassifierAbstractImpl.clearFeatures();
        assertEquals("The count of feature should be 0.", 0, testClassifierAbstractImpl.countFeatures());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getFeatures()</code>.
     * </p>
     */
    public void testGetFeatures() {
        testClassifierAbstractImpl.clearFeatures();
        List<Feature> features = new LinkedList<Feature>();
        for (int i = 0; i < 5; ++i) {
            Feature feature = new FeatureImpl();
            features.add(feature);
            testClassifierAbstractImpl.addFeature(feature);
        }
        assertEquals("Get features incorrectly.", features, testClassifierAbstractImpl.getFeatures());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsFeature(Feature)</code>.
     * </p>
     */
    public void testContainsFeature() {
        Feature feature = new FeatureImpl();
        testClassifierAbstractImpl.addFeature(feature);
        assertTrue("Contains feature incorrectly.", testClassifierAbstractImpl.containsFeature(feature));

        assertFalse("Contains feature incorrectly.", testClassifierAbstractImpl.containsFeature(new FeatureImpl()));
    }

    /**
     * <p>
     * Test the method of <code>ContainsFeature(Feature)</code> with null feature. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsFeatureNullFeature() {
        try {
            testClassifierAbstractImpl.containsFeature(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>indexOfFeature(Feature)</code>.
     * </p>
     */
    public void testIndexOfFeature() {
        Feature feature = new FeatureImpl();
        testClassifierAbstractImpl.addFeature(0, feature);
        assertEquals("Index of feature incorrectly.", 0, testClassifierAbstractImpl.indexOfFeature(feature));

        assertEquals("Index of feature incorrectly.", -1, testClassifierAbstractImpl.indexOfFeature(new FeatureImpl()));
    }

    /**
     * <p>
     * Test the method of <code>indexOfFeature(Feature)</code> with null feature. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testIndexOfFeatureNullFeature() {
        try {
            testClassifierAbstractImpl.indexOfFeature(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countFeatures()</code>.
     * </p>
     */
    public void testCountFeatures() {
        testClassifierAbstractImpl.clearFeatures();
        assertEquals("The count of features should be 0.", 0, testClassifierAbstractImpl.countFeatures());

        testClassifierAbstractImpl.addFeature(new FeatureImpl());
        assertEquals("The count of features should be 1.", 1, testClassifierAbstractImpl.countFeatures());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addTypedFeature(TypedFeature)</code>.
     * </p>
     */
    public void testAddTypedFeature() {
        StructuralFeature typedFeature = new StructuralFeatureImpl();
        testClassifierAbstractImpl.addTypedFeature(typedFeature);
        assertTrue("Add typedFeature incorrectly.", testClassifierAbstractImpl.containsTypedFeature(typedFeature));
    }

    /**
     * <p>
     * Test the method of <code>addTypedFeature(TypedFeature)</code> with null typedFeature. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddTypedFeatureNullTypedFeature() {
        try {
            testClassifierAbstractImpl.addTypedFeature(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeTypedFeature(TypedFeature)</code>.
     * </p>
     */
    public void testRemoveTypedFeature() {
        StructuralFeature typedFeature = new StructuralFeatureImpl();
        testClassifierAbstractImpl.addTypedFeature(typedFeature);
        assertTrue("Remove typedFeature incorrectly.", testClassifierAbstractImpl.removeTypedFeature(typedFeature));
    }

    /**
     * <p>
     * Test the method of <code>removeTypedFeature(TypedFeature)</code> with null typedFeature. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveTypedFeatureNullTypedFeature() {
        try {
            testClassifierAbstractImpl.removeTypedFeature(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearTypedFeatures()</code>.
     * <p>
     */
    public void testClearTypedFeatures() {
        testClassifierAbstractImpl.clearTypedFeatures();
        assertEquals("The count of typedFeature should be 0.", 0, testClassifierAbstractImpl.countTypedFeatures());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getTypedFeatures()</code>.
     * </p>
     */
    public void testGetTypedFeatures() {
        testClassifierAbstractImpl.clearTypedFeatures();
        Collection<StructuralFeature> typedFeatures = new ArrayList<StructuralFeature>();
        for (int i = 0; i < 3; ++i) {
            StructuralFeature typedFeature = new StructuralFeatureImpl();
            typedFeatures.add(typedFeature);
            testClassifierAbstractImpl.addTypedFeature(typedFeature);
        }
        assertEquals("Get typedFeatures incorrectly.", typedFeatures, testClassifierAbstractImpl.getTypedFeatures());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsTypedFeature(TypedFeature)</code>.
     * </p>
     */
    public void testContainsTypedFeature() {
        StructuralFeature typedFeature = new StructuralFeatureImpl();
        testClassifierAbstractImpl.addTypedFeature(typedFeature);
        assertTrue("Contains typedFeature incorrectly.", testClassifierAbstractImpl.containsTypedFeature(typedFeature));

        assertFalse("Contains typedFeature incorrectly.", testClassifierAbstractImpl
                .containsTypedFeature(new StructuralFeatureImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsTypedFeature(TypedFeature)</code> with null typedFeature. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsTypedFeatureNullTypedFeature() {
        try {
            testClassifierAbstractImpl.containsTypedFeature(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countTypedFeatures()</code>.
     * </p>
     */
    public void testCountTypedFeatures() {
        testClassifierAbstractImpl.clearTypedFeatures();
        assertEquals("The count of typedFeatures should be 0.", 0, testClassifierAbstractImpl.countTypedFeatures());

        testClassifierAbstractImpl.addTypedFeature(new StructuralFeatureImpl());
        assertEquals("The count of typedFeatures should be 1.", 1, testClassifierAbstractImpl.countTypedFeatures());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addTypedParameter(Parameter)</code>.
     * </p>
     */
    public void testAddTypedParameter() {
        Parameter typedParameter = new ParameterImpl();
        testClassifierAbstractImpl.addTypedParameter(typedParameter);
        assertTrue("Add typedParameter incorrectly.",
            testClassifierAbstractImpl.containsTypedParameter(typedParameter));
    }

    /**
     * <p>
     * Test the method of <code>addTypedParameter(Parameter)</code> with null typedParameter. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddTypedParameterNullTypedParameter() {
        try {
            testClassifierAbstractImpl.addTypedParameter(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeTypedParameter(Parameter)</code>.
     * </p>
     */
    public void testRemoveTypedParameter() {
        Parameter typedParameter = new ParameterImpl();
        testClassifierAbstractImpl.addTypedParameter(typedParameter);
        assertTrue("Remove typedParameter incorrectly.", testClassifierAbstractImpl
                .removeTypedParameter(typedParameter));
    }

    /**
     * <p>
     * Test the method of <code>removeTypedParameter(Parameter)</code> with null typedParameter. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveTypedParameterNullTypedParameter() {
        try {
            testClassifierAbstractImpl.removeTypedParameter(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearTypedParameters()</code>.
     * <p>
     */
    public void testClearTypedParameters() {
        testClassifierAbstractImpl.clearTypedParameters();
        assertEquals("The count of typedParameter should be 0.", 0, testClassifierAbstractImpl.countTypedParameters());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getTypedParameters()</code>.
     * </p>
     */
    public void testGetTypedParameters() {
        testClassifierAbstractImpl.clearTypedParameters();
        Collection<Parameter> typedParameters = new ArrayList<Parameter>();
        for (int i = 0; i < 3; ++i) {
            Parameter typedParameter = new ParameterImpl();
            typedParameters.add(typedParameter);
            testClassifierAbstractImpl.addTypedParameter(typedParameter);
        }
        assertEquals("Get typedParameters incorrectly.", typedParameters, testClassifierAbstractImpl
                .getTypedParameters());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsTypedParameter(Parameter)</code>.
     * </p>
     */
    public void testContainsTypedParameter() {
        Parameter typedParameter = new ParameterImpl();
        testClassifierAbstractImpl.addTypedParameter(typedParameter);
        assertTrue("Contains typedParameter incorrectly.", testClassifierAbstractImpl
                .containsTypedParameter(typedParameter));

        assertFalse("Contains TypedParameter incorrectly.", testClassifierAbstractImpl
                .containsTypedParameter(new ParameterImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsTypedParameter(TypedParameter)</code> with null typedParameter. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsTypedParameterNullTypedParameter() {
        try {
            testClassifierAbstractImpl.containsTypedParameter(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countTypedParameters()</code>.
     * </p>
     */
    public void testCountTypedParameters() {
        testClassifierAbstractImpl.clearTypedParameters();
        assertEquals("The count of typedParameters should be 0.", 0, testClassifierAbstractImpl.countTypedParameters());

        testClassifierAbstractImpl.addTypedParameter(new ParameterImpl());
        assertEquals("The count of typedParameters should be 1.", 1, testClassifierAbstractImpl.countTypedParameters());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addAssociation(AssociationEnd)</code>.
     * </p>
     */
    public void testAddAssociation() {
        AssociationEnd association = new AssociationEndImpl();
        testClassifierAbstractImpl.addAssociation(association);
        assertTrue("Add association incorrectly.", testClassifierAbstractImpl.containsAssociation(association));
    }

    /**
     * <p>
     * Test the method of <code>addAssociation(AssociationEnd)</code> with null association. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddAssociationNullAssociation() {
        try {
            testClassifierAbstractImpl.addAssociation(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeAssociation(AssociationEnd)</code>.
     * </p>
     */
    public void testRemoveAssociation() {
        AssociationEnd association = new AssociationEndImpl();
        testClassifierAbstractImpl.addAssociation(association);
        assertTrue("Remove association incorrectly.", testClassifierAbstractImpl.removeAssociation(association));
    }

    /**
     * <p>
     * Test the method of <code>removeAssociation(AssociationEnd)</code> with null association. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveAssociationNullAssociation() {
        try {
            testClassifierAbstractImpl.removeAssociation(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearAssociations()</code>.
     * <p>
     */
    public void testClearAssociations() {
        testClassifierAbstractImpl.clearAssociations();
        assertEquals("The count of association should be 0.", 0, testClassifierAbstractImpl.countAssociations());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getAssociations()</code>.
     * </p>
     */
    public void testGetAssociations() {
        testClassifierAbstractImpl.clearAssociations();
        Collection<AssociationEnd> associations = new ArrayList<AssociationEnd>();
        for (int i = 0; i < 3; ++i) {
            AssociationEnd association = new AssociationEndImpl();
            associations.add(association);
            testClassifierAbstractImpl.addAssociation(association);
        }
        assertEquals("Get associations incorrectly.", associations, testClassifierAbstractImpl.getAssociations());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsAssociation(AssociationEnd)</code>.
     * </p>
     */
    public void testContainsAssociation() {
        AssociationEnd association = new AssociationEndImpl();
        testClassifierAbstractImpl.addAssociation(association);
        assertTrue("Contains association incorrectly.", testClassifierAbstractImpl.containsAssociation(association));

        assertFalse("Contains Association incorrectly.", testClassifierAbstractImpl
                .containsAssociation(new AssociationEndImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsAssociation(AssociationEnd)</code> with null associationEnd. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsAssociationNullAssociationEnd() {
        try {
            testClassifierAbstractImpl.containsAssociation(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countAssociations()</code>.
     * </p>
     */
    public void testCountAssociations() {
        testClassifierAbstractImpl.clearAssociations();
        assertEquals("The count of associations should be 0.", 0, testClassifierAbstractImpl.countAssociations());

        testClassifierAbstractImpl.addAssociation(new AssociationEndImpl());
        assertEquals("The count of associations should be 1.", 1, testClassifierAbstractImpl.countAssociations());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addSpecifiedEnd(AssociationEnd)</code>.
     * </p>
     */
    public void testAddSpecifiedEnd() {
        AssociationEnd specifiedEnd = new AssociationEndImpl();
        testClassifierAbstractImpl.addSpecifiedEnd(specifiedEnd);
        assertTrue("Add specifiedEnd incorrectly.", testClassifierAbstractImpl.containsSpecifiedEnd(specifiedEnd));
    }

    /**
     * <p>
     * Test the method of <code>addSpecifiedEnd(AssociationEnd)</code> with null specifiedEnd. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddSpecifiedEndNullSpecifiedEnd() {
        try {
            testClassifierAbstractImpl.addSpecifiedEnd(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeSpecifiedEnd(AssociationEnd)</code>.
     * </p>
     */
    public void testRemoveSpecifiedEnd() {
        AssociationEnd specifiedEnd = new AssociationEndImpl();
        testClassifierAbstractImpl.addSpecifiedEnd(specifiedEnd);
        assertTrue("Remove specifiedEnd incorrectly.", testClassifierAbstractImpl.removeSpecifiedEnd(specifiedEnd));
    }

    /**
     * <p>
     * Test the method of <code>removeSpecifiedEnd(AssociationEnd)</code> with null specifiedEnd. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveSpecifiedEndNullSpecifiedEnd() {
        try {
            testClassifierAbstractImpl.removeSpecifiedEnd(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearSpecifiedEnds()</code>.
     * <p>
     */
    public void testClearSpecifiedEnds() {
        testClassifierAbstractImpl.clearSpecifiedEnds();
        assertEquals("The count of specifiedEnd should be 0.", 0, testClassifierAbstractImpl.countSpecifiedEnds());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getSpecifiedEnds()</code>.
     * </p>
     */
    public void testGetSpecifiedEnds() {
        testClassifierAbstractImpl.clearSpecifiedEnds();
        Collection<AssociationEnd> specifiedEnds = new ArrayList<AssociationEnd>();
        for (int i = 0; i < 3; ++i) {
            AssociationEnd specifiedEnd = new AssociationEndImpl();
            specifiedEnds.add(specifiedEnd);
            testClassifierAbstractImpl.addSpecifiedEnd(specifiedEnd);
        }
        assertEquals("Get specifiedEnds incorrectly.", specifiedEnds, testClassifierAbstractImpl.getSpecifiedEnds());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsSpecifiedEnd(AssociationEnd)</code>.
     * </p>
     */
    public void testContainsSpecifiedEnd() {
        AssociationEnd specifiedEnd = new AssociationEndImpl();
        testClassifierAbstractImpl.addSpecifiedEnd(specifiedEnd);
        assertTrue("Contains specifiedEnd incorrectly.", testClassifierAbstractImpl.containsSpecifiedEnd(specifiedEnd));

        assertFalse("Contains SpecifiedEnd incorrectly.", testClassifierAbstractImpl
                .containsSpecifiedEnd(new AssociationEndImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsSpecifiedEnd(AssociationEnd)</code> with null specifiedEnd. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsSpecifiedEndNullSpecifiedEnd() {
        try {
            testClassifierAbstractImpl.containsSpecifiedEnd(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countSpecifiedEnds()</code>.
     * </p>
     */
    public void testCountSpecifiedEnds() {
        testClassifierAbstractImpl.clearSpecifiedEnds();
        assertEquals("The count of specifiedEnds should be 0.", 0, testClassifierAbstractImpl.countSpecifiedEnds());

        testClassifierAbstractImpl.addSpecifiedEnd(new AssociationEndImpl());
        assertEquals("The count of specifiedEnds should be 1.", 1, testClassifierAbstractImpl.countSpecifiedEnds());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addPowertypeRange(Generalization)</code>.
     * </p>
     */
    public void testAddPowertypeRange() {
        Generalization powertypeRange = new GeneralizationImpl();
        testClassifierAbstractImpl.addPowertypeRange(powertypeRange);
        assertTrue("Add powertypeRange incorrectly.",
            testClassifierAbstractImpl.containsPowertypeRange(powertypeRange));
    }

    /**
     * <p>
     * Test the method of <code>addPowertypeRange(Generalization)</code> with null powertypeRange. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddPowertypeRangeNullPowertypeRange() {
        try {
            testClassifierAbstractImpl.addPowertypeRange(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removePowertypeRange(Generalization)</code>.
     * </p>
     */
    public void testRemovePowertypeRange() {
        Generalization powertypeRange = new GeneralizationImpl();
        testClassifierAbstractImpl.addPowertypeRange(powertypeRange);
        assertTrue("Remove powertypeRange incorrectly.", testClassifierAbstractImpl
                .removePowertypeRange(powertypeRange));
    }

    /**
     * <p>
     * Test the method of <code>removePowertypeRange(Generalization)</code> with null powertypeRange. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemovePowertypeRangeNullPowertypeRange() {
        try {
            testClassifierAbstractImpl.removePowertypeRange(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearPowertypeRanges()</code>.
     * <p>
     */
    public void testClearPowertypeRanges() {
        testClassifierAbstractImpl.clearPowertypeRanges();
        assertEquals("The count of powertypeRange should be 0.", 0, testClassifierAbstractImpl.countPowertypeRanges());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getPowertypeRanges()</code>.
     * </p>
     */
    public void testGetPowertypeRanges() {
        testClassifierAbstractImpl.clearPowertypeRanges();
        Collection<Generalization> powertypeRanges = new ArrayList<Generalization>();
        for (int i = 0; i < 3; ++i) {
            Generalization powertypeRange = new GeneralizationImpl();
            powertypeRanges.add(powertypeRange);
            testClassifierAbstractImpl.addPowertypeRange(powertypeRange);
        }
        assertEquals("Get powertypeRanges incorrectly.", powertypeRanges, testClassifierAbstractImpl
                .getPowertypeRanges());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsPowertypeRange(Generalization)</code>.
     * </p>
     */
    public void testContainsPowertypeRange() {
        Generalization powertypeRange = new GeneralizationImpl();
        testClassifierAbstractImpl.addPowertypeRange(powertypeRange);
        assertTrue("Contains powertypeRange incorrectly.", testClassifierAbstractImpl
                .containsPowertypeRange(powertypeRange));

        assertFalse("Contains PowertypeRange incorrectly.", testClassifierAbstractImpl
                .containsPowertypeRange(new GeneralizationImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsPowertypeRange(Generalization)</code> with null powertypeRange. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsPowertypeRangeNullPowertypeRange() {
        try {
            testClassifierAbstractImpl.containsPowertypeRange(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countPowertypeRanges()</code>.
     * </p>
     */
    public void testCountPowertypeRanges() {
        testClassifierAbstractImpl.clearPowertypeRanges();
        assertEquals("The count of powertypeRanges should be 0.", 0, testClassifierAbstractImpl.countPowertypeRanges());

        testClassifierAbstractImpl.addPowertypeRange(new GeneralizationImpl());
        assertEquals("The count of powertypeRanges should be 1.", 1, testClassifierAbstractImpl.countPowertypeRanges());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addObjectFlowState(ObjectFlowState)</code>.
     * </p>
     */
    public void testAddObjectFlowState() {
        ObjectFlowState objectFlowState = new ObjectFlowStateImpl();
        testClassifierAbstractImpl.addObjectFlowState(objectFlowState);
        assertTrue("Add objectFlowState incorrectly.", testClassifierAbstractImpl
                .containsObjectFlowState(objectFlowState));
    }

    /**
     * <p>
     * Test the method of <code>addObjectFlowState(ObjectFlowState)</code> with null objectFlowState. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddObjectFlowStateNullObjectFlowState() {
        try {
            testClassifierAbstractImpl.addObjectFlowState(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeObjectFlowState(ObjectFlowState)</code>.
     * </p>
     */
    public void testRemoveObjectFlowState() {
        ObjectFlowState objectFlowState = new ObjectFlowStateImpl();
        testClassifierAbstractImpl.addObjectFlowState(objectFlowState);
        assertTrue("Remove objectFlowState incorrectly.", testClassifierAbstractImpl
                .removeObjectFlowState(objectFlowState));
    }

    /**
     * <p>
     * Test the method of <code>removeObjectFlowState(ObjectFlowState)</code> with null objectFlowState. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveObjectFlowStateNullObjectFlowState() {
        try {
            testClassifierAbstractImpl.removeObjectFlowState(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearObjectFlowStates()</code>.
     * <p>
     */
    public void testClearObjectFlowStates() {
        testClassifierAbstractImpl.clearObjectFlowStates();
        assertEquals("The count of objectFlowState should be 0.",
            0, testClassifierAbstractImpl.countObjectFlowStates());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getObjectFlowStates()</code>.
     * </p>
     */
    public void testGetObjectFlowStates() {
        testClassifierAbstractImpl.clearObjectFlowStates();
        Collection<ObjectFlowState> objectFlowStates = new ArrayList<ObjectFlowState>();
        for (int i = 0; i < 3; ++i) {
            ObjectFlowState objectFlowState = new ObjectFlowStateImpl();
            objectFlowStates.add(objectFlowState);
            testClassifierAbstractImpl.addObjectFlowState(objectFlowState);
        }
        assertEquals("Get objectFlowStates incorrectly.", objectFlowStates, testClassifierAbstractImpl
                .getObjectFlowStates());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsObjectFlowState(ObjectFlowState)</code>.
     * </p>
     */
    public void testContainsObjectFlowState() {
        ObjectFlowState objectFlowState = new ObjectFlowStateImpl();
        testClassifierAbstractImpl.addObjectFlowState(objectFlowState);
        assertTrue("Contains objectFlowState incorrectly.", testClassifierAbstractImpl
                .containsObjectFlowState(objectFlowState));

        assertFalse("Contains ObjectFlowState incorrectly.", testClassifierAbstractImpl
                .containsObjectFlowState(new ObjectFlowStateImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsObjectFlowState(objectFlowState)</code> with null objectFlowState. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsObjectFlowStateNullObjectFlowState() {
        try {
            testClassifierAbstractImpl.containsObjectFlowState(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countObjectFlowStates()</code>.
     * </p>
     */
    public void testCountObjectFlowStates() {
        testClassifierAbstractImpl.clearObjectFlowStates();
        assertEquals("The count of objectFlowStates should be 0.", 0, testClassifierAbstractImpl
                .countObjectFlowStates());

        testClassifierAbstractImpl.addObjectFlowState(new ObjectFlowStateImpl());
        assertEquals("The count of objectFlowStates should be 1.", 1, testClassifierAbstractImpl
                .countObjectFlowStates());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addInstance(Instance)</code>.
     * </p>
     */
    public void testAddInstance() {
        Instance instance = new InstanceAbstractImpl() {};
        testClassifierAbstractImpl.addInstance(instance);
        assertTrue("Add instance incorrectly.", testClassifierAbstractImpl.containsInstance(instance));
    }

    /**
     * <p>
     * Test the method of <code>addInstance(Instance)</code> with null instance. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddInstanceNullInstance() {
        try {
            testClassifierAbstractImpl.addInstance(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeInstance(Instance)</code>.
     * </p>
     */
    public void testRemoveInstance() {
        Instance instance = new InstanceAbstractImpl() {};
        testClassifierAbstractImpl.addInstance(instance);
        assertTrue("Remove instance incorrectly.", testClassifierAbstractImpl.removeInstance(instance));
    }

    /**
     * <p>
     * Test the method of <code>removeInstance(Instance)</code> with null instance. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveInstanceNullInstance() {
        try {
            testClassifierAbstractImpl.removeInstance(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test the method of <code>clearInstances()</code>.
     * <p>
     */
    public void testClearInstances() {
        testClassifierAbstractImpl.clearInstances();
        assertEquals("The count of instance should be 0.", 0, testClassifierAbstractImpl.countInstances());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getInstances()</code>.
     * </p>
     */
    public void testGetInstances() {
        testClassifierAbstractImpl.clearInstances();
        Collection<Instance> instances = new ArrayList<Instance>();
        for (int i = 0; i < 3; ++i) {
            Instance instance = new InstanceAbstractImpl() {};
            instances.add(instance);
            testClassifierAbstractImpl.addInstance(instance);
        }
        assertEquals("Get instances incorrectly.", instances, testClassifierAbstractImpl.getInstances());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsInstance(Instance)</code>.
     * </p>
     */
    public void testContainsInstance() {
        Instance instance = new InstanceAbstractImpl() {};
        testClassifierAbstractImpl.addInstance(instance);
        assertTrue("Contains instance incorrectly.", testClassifierAbstractImpl.containsInstance(instance));

        assertFalse("Contains Instance incorrectly.", testClassifierAbstractImpl.containsInstance(new InstanceAbstractImpl() {}));
    }

    /**
     * <p>
     * Test the method of <code>containsInstance(Instance)</code> with null instance. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsInstanceNullInstance() {
        try {
            testClassifierAbstractImpl.containsInstance(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countInstances()</code>.
     * </p>
     */
    public void testCountInstances() {
        testClassifierAbstractImpl.clearInstances();
        assertEquals("The count of instances should be 0.", 0, testClassifierAbstractImpl.countInstances());

        testClassifierAbstractImpl.addInstance(new InstanceAbstractImpl() {});
        assertEquals("The count of instances should be 1.", 1, testClassifierAbstractImpl.countInstances());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addOwnedElement(ModelElement)</code>.
     * </p>
     */
    public void testAddOwnedElement() {
        ModelElement ownedElement = new ModelElementImpl();
        testClassifierAbstractImpl.addOwnedElement(ownedElement);
        assertTrue("Add ownedElement incorrectly.", testClassifierAbstractImpl.containsOwnedElement(ownedElement));
    }

    /**
     * <p>
     * Test the method of <code>addOwnedElement(ModelElement)</code> with null ownedElement. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddOwnedElementNullOwnedElement() {
        try {
            testClassifierAbstractImpl.addOwnedElement(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeOwnedElement(OwnedElement)</code>.
     * </p>
     */
    public void testRemoveOwnedElement() {
        ModelElement ownedElement = new ModelElementImpl();
        testClassifierAbstractImpl.addOwnedElement(ownedElement);
        assertTrue("Remove ownedElement incorrectly.", testClassifierAbstractImpl.removeOwnedElement(ownedElement));
    }

    /**
     * <p>
     * Test the method of <code>removeOwnedElement(ModelElement)</code> with null ownedElement. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveOwnedElementNullOwnedElement() {
        try {
            testClassifierAbstractImpl.removeOwnedElement(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearOwnedElements()</code>.
     * <p>
     */
    public void testClearOwnedElements() {
        testClassifierAbstractImpl.clearOwnedElements();
        assertEquals("The count of ownedElement should be 0.", 0, testClassifierAbstractImpl.countOwnedElements());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getOwnedElements()</code>.
     * </p>
     */
    public void testGetOwnedElements() {
        testClassifierAbstractImpl.clearOwnedElements();
        Collection<ModelElement> ownedElements = new ArrayList<ModelElement>();
        for (int i = 0; i < 3; ++i) {
            ModelElement ownedElement = new ModelElementImpl();
            ownedElements.add(ownedElement);
            testClassifierAbstractImpl.addOwnedElement(ownedElement);
        }
        assertEquals("Get ownedElements incorrectly.", ownedElements, testClassifierAbstractImpl.getOwnedElements());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsOwnedElement(ModelElement)</code>.
     * </p>
     */
    public void testContainsOwnedElement() {
        ModelElement ownedElement = new ModelElementImpl();
        testClassifierAbstractImpl.addOwnedElement(ownedElement);
        assertTrue("Contains ownedElement incorrectly.", testClassifierAbstractImpl.containsOwnedElement(ownedElement));

        assertFalse("Contains OwnedElement incorrectly.", testClassifierAbstractImpl
                .containsOwnedElement(new ModelElementImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsOwnedElement(ModelElement)</code> with null ownedElement. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsOwnedElementNullModelElement() {
        try {
            testClassifierAbstractImpl.containsOwnedElement(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countOwnedElements()</code>.
     * </p>
     */
    public void testCountOwnedElements() {
        testClassifierAbstractImpl.clearOwnedElements();
        assertEquals("The count of ownedElements should be 0.", 0, testClassifierAbstractImpl.countOwnedElements());

        testClassifierAbstractImpl.addOwnedElement(new ModelElementImpl());
        assertEquals("The count of ownedElements should be 1.", 1, testClassifierAbstractImpl.countOwnedElements());
    }

}
