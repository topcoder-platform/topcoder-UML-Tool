/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.Method;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateMachineImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test cases for <code>{@link UsecaseToolUtil}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UsecaseToolUtilTest extends TestCase {
    /** The UsecaseToolUtil instance for testing. */
    private UsecaseToolUtil usecaseToolUtil;

    /** The ModelElement instance for testing. */
    private ModelElement modelElement;

    /** The Namespace instance for testing. */
    private Namespace namespace;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        usecaseToolUtil = new MockUsecaseToolUtil();
        modelElement = new MockModelElementAbstractImpl();
        namespace = new MockNamespaceAbstractImpl();
    }

    /**
     * <p>
     * Test <code>{@link UsecaseToolUtil#UsecaseToolUtil()}</code> with success process.
     * </p>
     */
    public void testConstructor_Success() {
        usecaseToolUtil = new MockUsecaseToolUtil();
        assertNotNull(usecaseToolUtil);
    }

    /**
     * <p>
     * Test <code>{@link UsecaseToolUtil#addElementToModel(ModelElement, Namespace)}</code> with null ModelElement.
     * Should throw an Exception here.
     * </p>
     */
    public void testAddElementToModel_ModelElementNamespace_NullModelElement() {
        try {
            usecaseToolUtil.addElementToModel(null, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link UsecaseToolUtil#addElementToModel(ModelElement, Namespace)}</code> with null namespace. Should
     * throw an Exception here.
     * </p>
     */
    public void testAddElementToModel_ModelElementNamespace_NullNamespace() {
        try {
            usecaseToolUtil.addElementToModel(modelElement, null);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link UsecaseToolUtil#addElementToModel(ModelElement, Namespace)}</code> with success process.
     * </p>
     */
    public void testAddElementToModel_ModelElementNamespace_Success() {
        usecaseToolUtil.addElementToModel(modelElement, namespace);
        assertEquals(namespace, modelElement.getNamespace());
        assertTrue(modelElement.getNamespace().getOwnedElements().contains(modelElement));
    }

    /**
     * <p>
     * Test <code>{@link UsecaseToolUtil#removeElementFromModel(ModelElement)}</code> with null ModelElement. Should
     * throw an Exception here.
     * </p>
     */
    public void testRemoveElementFromModel_ModelElement_Null() {
        try {
            usecaseToolUtil.removeElementFromModel(null);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link UsecaseToolUtil#removeElementFromModel(ModelElement)}</code> with success process.
     * </p>
     */
    public void testRemoveElementFromModel_ModelElement_Success() {
        assertFalse(usecaseToolUtil.removeElementFromModel(modelElement));
        usecaseToolUtil.addElementToModel(modelElement, namespace);
        assertTrue(usecaseToolUtil.removeElementFromModel(modelElement));
    }

    /**
     * <p>
     * Test <code>{@link UsecaseToolUtil#copyModelElementAttributes(ModelElement, ModelElement)}</code> with null
     * ModelElement. Should throw an Exception here.
     * </p>
     */
    public void testCopyModelElementAttributes_ModelElementModelElement_Null1() {
        try {
            usecaseToolUtil.copyModelElementAttributes(null, new MockModelElementAbstractImpl());
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link UsecaseToolUtil#copyModelElementAttributes(ModelElement, ModelElement)}</code> with null
     * ModelElement. Should throw an Exception here.
     * </p>
     */
    public void testCopyModelElementAttributes_ModelElementModelElement_Null2() {
        try {
            usecaseToolUtil.copyModelElementAttributes(new MockModelElementAbstractImpl(), null);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link UsecaseToolUtil#copyModelElementAttributes(ModelElement, ModelElement)}</code> with success
     * process.
     * </p>
     */
    public void testCopyModelElementAttributes_ModelElementModelElement_Success() {
        ModelElement newElement = new MockModelElementAbstractImpl();
        //set the old element's values
        modelElement.setName("name");
        modelElement.setSpecification(true);
        modelElement.setVisibility(VisibilityKind.PUBLIC);

        Stereotype stereotype = new StereotypeImpl();
        modelElement.addStereotype(stereotype);

        TemplateParameter templateParameter = new TemplateParameterImpl();
        modelElement.addTemplateParameter(templateParameter);

        TemplateArgument templateArgument = new TemplateArgumentImpl();
        modelElement.addTemplateArgument(templateArgument);

        ElementImport elementImport = new ElementImportImpl();
        modelElement.addElementImport(elementImport);

        StateMachine stateMachine = new StateMachineImpl();
        modelElement.addBehavior(stateMachine);

        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setDataValue("str");
        modelElement.addTaggedValue(taggedValue);
        modelElement.addReferenceTag(taggedValue);
        modelElement.addDefaultParameter(templateParameter);
        //call the copy method
        usecaseToolUtil.copyModelElementAttributes(modelElement, newElement);
        //verify the new element's values
        assertEquals("name", newElement.getName());
        assertTrue(newElement.isSpecification());
        assertEquals(VisibilityKind.PUBLIC, newElement.getVisibility());
        assertEquals(stereotype, newElement.getStereotypes().iterator().next());
        assertEquals(templateParameter, newElement.getTemplateParameters().get(0));
        assertEquals(templateArgument, newElement.getTemplateArguments().iterator().next());
        assertEquals(elementImport, newElement.getElementImports().iterator().next());
        assertEquals(stateMachine, newElement.getBehaviors().iterator().next());
        assertEquals("str", modelElement.getTaggedValues().iterator().next().getDataValue());
        assertEquals("str", modelElement.getReferenceTags().iterator().next().getDataValue());
        assertEquals(templateParameter, modelElement.getDefaultParameters().iterator().next());
    }

    /**
     * <p>
     * Test <code>{@link UsecaseToolUtil#copyClassifierAttributes(Classifier, Classifier)}</code> with null Classifier.
     * Should throw an Exception here.
     * </p>
     */
    public void testCopyClassifierAttributes_ClassifierClassifier_Null1() {
        try {
            usecaseToolUtil.copyClassifierAttributes(null, new MockClassifierAbstractImpl());
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link UsecaseToolUtil#copyClassifierAttributes(Classifier, Classifier)}</code> with null Classifier.
     * Should throw an Exception here.
     * </p>
     */
    public void testCopyClassifierAttributes_ClassifierClassifier_Null2() {
        try {
            usecaseToolUtil.copyClassifierAttributes(new MockClassifierAbstractImpl(), null);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link UsecaseToolUtil#copyClassifierAttributes(Classifier, Classifier)}</code> with success process.
     * </p>
     */
    public void testCopyClassifierAttributes_ClassifierClassifier_Success() {
        Classifier oldClassifier = new MockClassifierAbstractImpl();
        Classifier newClassifier = new MockClassifierAbstractImpl();
        //set the old element's values
        oldClassifier.setRoot(true);
        oldClassifier.setLeaf(true);
        oldClassifier.setAbstract(true);

        Parameter parameter = new ParameterImpl();
        oldClassifier.addTypedParameter(parameter);

        Generalization generalization = new GeneralizationImpl();
        oldClassifier.addPowertypeRange(generalization);

        ObjectFlowState objectFlowState = new ObjectFlowStateImpl();
        oldClassifier.addObjectFlowState(objectFlowState);

        Attribute newAttribute = new AttributeImpl();
        Method newMethod = new MethodImpl();
        Operation newOperation = new OperationImpl();
        oldClassifier.addFeature(newAttribute);
        oldClassifier.addFeature(newMethod);
        oldClassifier.addFeature(newOperation);
        //call the copy function
        usecaseToolUtil.copyClassifierAttributes(oldClassifier, newClassifier);
        //verify the new element's values
        assertEquals(true, newClassifier.isRoot());
        assertEquals(true, newClassifier.isLeaf());
        assertEquals(true, newClassifier.isAbstract());
        assertEquals(parameter, newClassifier.getTypedParameters().iterator().next());
        assertEquals(generalization, newClassifier.getPowertypeRanges().iterator().next());
        assertEquals(objectFlowState, newClassifier.getObjectFlowStates().iterator().next());
        assertNotNull(newClassifier.getFeatures().get(0));
        assertNotNull(newClassifier.getFeatures().get(1));
        assertNotNull(newClassifier.getFeatures().get(2));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(UsecaseToolUtilTest.class);
    }
}
