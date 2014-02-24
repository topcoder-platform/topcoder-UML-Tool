/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.StructuralFeature;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateMachineImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class ClassToolUtil. Since ClassToolUtil is abstract
 * class the simple sub-class MockClassToolUtil will be used for testing. You
 * can refer to MockClassToolUtil for more detail.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ClassToolUtilTest extends TestCase {

    /**
     * Represent modelElement's name.
     */
    private static final String MODELELEMENT_NAME = "test name";

    /**
     * The Namespace instance used for test.
     */
    private Namespace modelNamespace;

    /**
     * The Namespace instance used for test.
     */
    private Namespace originalNamespace = new ModelImpl();

    /**
     * The ClassToolUtil instance for the test.
     */
    private final ClassToolUtil classToolUtil = new MockClassToolUtil();

    /**
     * The ModelElement instance for the test.
     */
    private ModelElement modelElement;

    /**
     * Represent modelElement's stereoType.
     */
    private Stereotype stereoType;

    /**
     * Represent modelElement's templateArgument.
     */
    private TemplateArgument templateArgument;

    /**
     * Represent modelElement's elementImport.
     */
    private ElementImport elementImport;

    /**
     * Represent modelElement's behavior.
     */
    private StateMachine behavior;

    /**
     * Represent modelElement's taggedValue.
     */
    private TaggedValue taggedValue;

    /**
     * Represent modelElement's referenceTag.
     */
    private TaggedValue referenceTag;

    /**
     * Represent modelElement's parameterTemplate.
     */
    private TemplateParameter parameterTemplate;

    /**
     * Represent modelElement's defaultParameter.
     */
    private TemplateParameter defaultParameter;

    /**
     * The Classifier instance for the test.
     */
    private Classifier oldClassifier;

    /**
     * The Classifier's typedFeature.
     */
    private StructuralFeature typedFeature;

    /**
     * The Classifier's typedParameter.
     */
    private Parameter typedParameter;

    /**
     * The Classifier's powertypeRange.
     */
    private Generalization powertypeRange;

    /**
     * The Classifier's objectFlowState.
     */
    private ObjectFlowState objectFlowState;

    /**
     * The Classifier's instance.
     */
    private Instance instance;

    /**
     * The Classifier's feature.
     */
    private Feature attribute;

    /**
     * The Classifier's feature.
     */
    private Feature method;

    /**
     * The Classifier's feature.
     */
    private Feature operation;

    /**
     * Setup routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void setUp() throws Exception {
        super.setUp();

        // modelElement
        modelNamespace = new ModelImpl();
        modelElement = new AbstractionImpl();
        modelElement.setNamespace(originalNamespace);

        // simple attributes
        modelElement.setName(MODELELEMENT_NAME);
        modelElement.setVisibility(VisibilityKind.PUBLIC);
        modelElement.setSpecification(true);

        // reference attributes
        stereoType = new StereotypeImpl();
        modelElement.addStereotype(stereoType);
        stereoType.addExtendedElement(modelElement);

        templateArgument = new TemplateArgumentImpl();
        modelElement.addTemplateArgument(templateArgument);

        elementImport = new ElementImportImpl();
        modelElement.addElementImport(elementImport);

        behavior = new StateMachineImpl();
        modelElement.addBehavior(behavior);

        // create new attributes
        taggedValue = new TaggedValueImpl();
        modelElement.addTaggedValue(taggedValue);

        referenceTag = new TaggedValueImpl();
        modelElement.addReferenceTag(referenceTag);

        parameterTemplate = new TemplateParameterImpl();
        modelElement.setParameterTemplate(parameterTemplate);

        defaultParameter = new TemplateParameterImpl();
        modelElement.addDefaultParameter(defaultParameter);

        // classifier
        oldClassifier = new EnumerationImpl();

        // simple attributes
        oldClassifier.setAbstract(true);
        oldClassifier.setLeaf(true);
        oldClassifier.setRoot(true);

        // referenc attribute
        typedFeature = new AttributeImpl();
        oldClassifier.addTypedFeature(typedFeature);

        typedParameter = new ParameterImpl();
        oldClassifier.addTypedParameter(typedParameter);

        powertypeRange = new GeneralizationImpl();
        oldClassifier.addPowertypeRange(powertypeRange);

        objectFlowState = new ObjectFlowStateImpl();
        oldClassifier.addObjectFlowState(objectFlowState);

        instance = new MockInstanceImpl();
        oldClassifier.addInstance(instance);

        // create new attributes
        attribute = new AttributeImpl();
        oldClassifier.addFeature(attribute);
        operation = new OperationImpl();
        oldClassifier.addFeature(operation);
        method = new MethodImpl();
        oldClassifier.addFeature(method);
    }

    /**
     * Test addElementToModel, with correct modelElement and namespace.
     */
    public void testAddElementToModel() {
        assertFalse("The modelElement is not in the modelNamespace at beginning.", modelNamespace
                .containsOwnedElement(modelElement));
        assertFalse("The modelElement's namespace should not be modelNamespace at beginning.", modelNamespace
                .equals(modelElement.getNamespace()));

        classToolUtil.addElementToModel(modelElement, modelNamespace);

        assertTrue("The modelElement should be added to the modelNamespace.", modelNamespace
                .containsOwnedElement(modelElement));
        assertEquals("The modelElement's namespace should be modelNamespace.", modelNamespace, modelElement
                .getNamespace());
    }

    /**
     * Test addElementToModel, with null modelElement. IllegalArgumentException
     * is expected.
     */
    public void testAddElementToModelWithNullModelElement() {
        try {
            classToolUtil.addElementToModel(null, modelNamespace);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test addElementToModel, with null namespace. IllegalArgumentException is
     * expected.
     */
    public void testAddElementToModelWithNullNamespace() {
        try {
            classToolUtil.addElementToModel(modelElement, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test removeElementFromModel, with correct modelElement, which in the
     * modelNamespace.
     */
    public void testRemoveElementFromModel() {
        classToolUtil.addElementToModel(modelElement, modelNamespace);

        assertTrue("Should be successfully removed.", classToolUtil.removeElementFromModel(modelElement));

        assertFalse("The modelElement should be removed from the modelNamespace.", modelNamespace
                .containsOwnedElement(modelElement));
        assertEquals("The modelElement's namespace should not be changed.", modelNamespace,
                modelElement.getNamespace());
    }

    /**
     * Test removeElementFromModel, with correct modelElement, which not in the
     * modelNamespace.
     */
    public void testRemoveElementFromModel2() {
        assertFalse("Should remove nothing.", classToolUtil.removeElementFromModel(modelElement));
    }

    /**
     * Test removeElementFromModel, with null modelElement.
     * IllegalArgumentException is expected.
     */
    public void testRemoveElementFromModelWithNullModelElement() {
        try {
            classToolUtil.removeElementFromModel(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test copyModelElementAttributes, with correct oldModelElement and
     * newModelElement. Check simple attributes.
     */
    public void testCopyModelElementAttributesSimple() {
        ModelElement newModelElement = new AbstractionImpl();

        classToolUtil.copyModelElementAttributes(modelElement, newModelElement);

        // change oldModelElement attributes
        modelElement.setName("else name");
        modelElement.setVisibility(VisibilityKind.PRIVATE);
        modelElement.setSpecification(false);

        assertEquals("Copy name failed.", MODELELEMENT_NAME, newModelElement.getName());
        assertEquals("Copy visibility failed.", VisibilityKind.PUBLIC, newModelElement.getVisibility());
        assertEquals("Copy specification failed.", true, newModelElement.isSpecification());
    }

    /**
     * Test copyModelElementAttributes, with correct oldModelElement and
     * newModelElement. Check attributes by reference.
     */
    public void testCopyModelElementAttributesReference() {
        ModelElement newModelElement = new AbstractionImpl();

        classToolUtil.copyModelElementAttributes(modelElement, newModelElement);

        assertTrue("Copy stereotype failed.", newModelElement.containsStereotype(stereoType));
        assertTrue("Copy newModelElement failed.", stereoType.containsExtendedElement(newModelElement));
        assertTrue("Copy templateArgument failed.", newModelElement.containsTemplateArgument(templateArgument));
        assertTrue("Copy elementImport failed.", newModelElement.containsElementImport(elementImport));
        assertTrue("Copy behavior failed.", newModelElement.containsBehavior(behavior));
    }

    /**
     * Test copyModelElementAttributes, with correct oldModelElement and
     * newModelElement. Check attributes by creation.
     */
    public void testCopyModelElementAttributesCreation() {
        ModelElement newModelElement = new AbstractionImpl();

        classToolUtil.copyModelElementAttributes(modelElement, newModelElement);

        assertFalse("Copy taggedValue failed.", newModelElement.getTaggedValues().isEmpty());
        assertFalse("Create taggedValue failed.", newModelElement.containsTaggedValue(taggedValue));

        assertFalse("Copy referenceTag failed.", newModelElement.getReferenceTags().isEmpty());
        assertFalse("Create referenceTag failed.", newModelElement.containsReferenceTag(referenceTag));

        assertFalse("Copy parameterTemplate failed.", newModelElement.getParameterTemplate().equals(parameterTemplate));

        assertFalse("Copy defaultParameter failed.", newModelElement.getDefaultParameters().isEmpty());
        assertFalse("Create defaultParameter failed.", newModelElement.containsDefaultParameter(defaultParameter));
    }

    /**
     * Test copyModelElementAttributes, with null oldModelElement.
     * IllegalArgumentException is expected.
     */
    public void testCopyModelElementAttributesWithNullOld() {
        try {
            ModelElement newModelElement = new AbstractionImpl();
            classToolUtil.copyModelElementAttributes(null, newModelElement);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test copyModelElementAttributes, with null newModelElement.
     * IllegalArgumentException is expected.
     */
    public void testCopyModelElementAttributesWithNullNew() {
        try {
            classToolUtil.copyModelElementAttributes(modelElement, null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test copyClassifierAttributes, with correct oldClassifier and
     * newClassifier. Check simple attributes.
     */
    public void testCopyClassifierAttributesSimple() {
        Classifier newClassifier = new EnumerationImpl();

        classToolUtil.copyClassifierAttributes(oldClassifier, newClassifier);

        // change oldClassifier attributes
        oldClassifier.setAbstract(false);
        oldClassifier.setLeaf(false);
        oldClassifier.setRoot(false);

        assertTrue("Copy abstract failed.", newClassifier.isAbstract());
        assertTrue("Copy leaf failed.", newClassifier.isLeaf());
        assertTrue("Copy root failed.", newClassifier.isRoot());
    }

    /**
     * Test copyClassifierAttributes, with correct oldClassifier and
     * newClassifier. Check attributes by reference.
     */
    public void testCopyClassifierAttributesReference() {
        Classifier newClassifier = new EnumerationImpl();

        classToolUtil.copyClassifierAttributes(oldClassifier, newClassifier);

        assertTrue("Copy typedFeature failed.", newClassifier.containsTypedFeature(typedFeature));
        assertTrue("Copy typedParameter failed.", newClassifier.containsTypedParameter(typedParameter));
        assertTrue("Copy powertypeRange failed.", newClassifier.containsPowertypeRange(powertypeRange));
        assertTrue("Copy objectFlowState failed.", newClassifier.containsObjectFlowState(objectFlowState));
        assertTrue("Copy instance failed.", newClassifier.containsInstance(instance));
    }

    /**
     * Test copyClassifierAttributes, with correct oldClassifier and
     * newClassifier. Check attributes by creation.
     */
    public void testCopyClassifierAttributesCreation() {
        Classifier newClassifier = new EnumerationImpl();

        classToolUtil.copyClassifierAttributes(oldClassifier, newClassifier);

        /**
         * assertFalse("Copy2 failed.",
         * newModelElement.containsTaggedValue(taggedValue));
         *
         * assertFalse("Copy3 failed.",
         * newModelElement.getReferenceTags().isEmpty()); assertFalse("Copy4
         * failed.", newModelElement.containsReferenceTag(referenceTag));
         *
         * assertFalse("Copy5 failed.",
         * newModelElement.getParameterTemplate().equals(parameterTemplate));
         *
         * assertFalse("Copy6 failed.",
         * newModelElement.getDefaultParameters().isEmpty()); assertFalse("Copy7
         * failed.",
         * newModelElement.containsDefaultParameter(defaultParameter));
         */
        assertEquals("Copy failed, should contain 3 features.", 3, newClassifier.countFeatures());
        assertFalse("Create attribute failed.", newClassifier.containsFeature(attribute));
        assertFalse("Create method failed.", newClassifier.containsFeature(method));
        assertFalse("Create attribute failed.", newClassifier.containsFeature(attribute));
    }

    /**
     * Test copyClassifierAttributes, with null oldClassifier.
     * IllegalArgumentException is expected.
     */
    public void testCopyClassifierAttributesWithNullOld() {
        try {
            Classifier newClassifier = new EnumerationImpl();

            classToolUtil.copyClassifierAttributes(null, newClassifier);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test copyClassifierAttributes, with null newClassifier.
     * IllegalArgumentException is expected.
     */
    public void testCopyClassifierAttributesWithNullNew() {
        try {
            classToolUtil.copyClassifierAttributes(oldClassifier, null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }
}