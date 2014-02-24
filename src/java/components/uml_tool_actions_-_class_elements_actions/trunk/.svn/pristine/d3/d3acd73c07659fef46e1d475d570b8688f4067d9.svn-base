/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.MockClassToolUtil;
import com.topcoder.uml.actions.model.classifiers.MockInstanceImpl;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.model.statemachines.StateMachineImpl;

/**
 * Accuracy tests for ClassToolUtil.
 * 
 * @author superZZ
 * @version 1.0
 */
public class ClassToolUtilTest extends TestCase {
    /**
     * Unload logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        TestUtil.unloadConfiguration();
    }

    /**
     * TestUtil instance.
     */
    private TestUtil testUtil = TestUtil.getInstance();

    /**
     * ClassToolUtil instance used for test.
     */
    private MockClassToolUtil classToolUtil = new MockClassToolUtil();

    /**
     * AbstractionImpl instance for test.
     */
    private Classifier modelElement = new ClassImpl();

    /**
     * Namespace instance for test.
     */
    private Namespace namespace = testUtil.getNamespace();

    /**
     * The Namespace instance for test.
     */
    private Namespace originalNamespace = new ModelImpl();

    /**
     * Setup routine for JUnit.
     * 
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestUtil.loadConfiguration();

        // modelElement
        modelElement.setNamespace(originalNamespace);

        // simple attributes
        modelElement.setVisibility(VisibilityKind.PUBLIC);
        modelElement.setSpecification(true);

        // reference attributes
        StereotypeImpl stereoType = new StereotypeImpl();
        modelElement.addStereotype(stereoType);
        stereoType.addExtendedElement(modelElement);

        TemplateArgumentImpl templateArgument = new TemplateArgumentImpl();
        modelElement.addTemplateArgument(templateArgument);

        ElementImportImpl elementImport = new ElementImportImpl();
        modelElement.addElementImport(elementImport);

        StateMachineImpl behavior = new StateMachineImpl();
        modelElement.addBehavior(behavior);

        // create new attributes
        TaggedValueImpl taggedValue = new TaggedValueImpl();
        modelElement.addTaggedValue(taggedValue);

        TaggedValueImpl referenceTag = new TaggedValueImpl();
        modelElement.addReferenceTag(referenceTag);

        TemplateParameterImpl parameterTemplate = new TemplateParameterImpl();
        modelElement.setParameterTemplate(parameterTemplate);

        TemplateParameterImpl defaultParameter = new TemplateParameterImpl();
        modelElement.addDefaultParameter(defaultParameter);

        EnumerationImpl oldClassifier = new EnumerationImpl();

        // simple attributes
        oldClassifier.setAbstract(true);
        oldClassifier.setLeaf(true);
        oldClassifier.setRoot(true);

        // By referenc attribute
        AttributeImpl typedFeature = new AttributeImpl();
        oldClassifier.addTypedFeature(typedFeature);

        oldClassifier.addReferenceTag(referenceTag);

        ParameterImpl typedParameter = new ParameterImpl();
        oldClassifier.addTypedParameter(typedParameter);

        GeneralizationImpl powertypeRange = new GeneralizationImpl();
        oldClassifier.addPowertypeRange(powertypeRange);

        ObjectFlowStateImpl objectFlowState = new ObjectFlowStateImpl();
        oldClassifier.addObjectFlowState(objectFlowState);

        MockInstanceImpl instance = new MockInstanceImpl();
        oldClassifier.addInstance(instance);

        // By creating new object.
        AttributeImpl attribute = new AttributeImpl();
        oldClassifier.addFeature(attribute);
        OperationImpl operation = new OperationImpl();
        oldClassifier.addFeature(operation);
        MethodImpl method = new MethodImpl();
        oldClassifier.addFeature(method);
    }

    /**
     * Test method for {@link ClassToolUtil#ClassToolUtil()}.
     */
    public void testClassToolUtil() {
        new MockClassToolUtil();
    }

    /**
     * Test method for {@link ClassToolUtil#addElementToModel(ModelElement)}.
     */
    public void testAddElementToModel() {
        classToolUtil.addElementToModel(modelElement, namespace);

        assertTrue("Model element should be owned by namespace.", namespace
                .containsOwnedElement(modelElement));
        assertEquals("Namespace is incorrect.", modelElement.getNamespace(),
                namespace);
    }

    /**
     * Test method for
     * {@link ClassToolUtil#removeElementFromModel(ModelElement)}.
     */
    public void testRemoveElementFromModel() {
        classToolUtil.addElementToModel(modelElement, namespace);

        assertTrue("Model element should be owned by namespace.", namespace
                .containsOwnedElement(modelElement));
        assertEquals("Namespace is incorrect.", modelElement.getNamespace(),
                namespace);

        assertTrue(classToolUtil.removeElementFromModel(modelElement));

        assertFalse("Model element should be owned by namespace.", namespace
                .containsOwnedElement(modelElement));

        assertFalse("Removing should fail.", classToolUtil
                .removeElementFromModel(modelElement));
    }

    /**
     * Test method for
     * {@link ClassToolUtil#copyModelElementAttributes(ModelElement, ModelElement)}.
     */
    public void testCopyModelElementAttributes() {
        Classifier newElement = new ClassImpl();

        classToolUtil.copyModelElementAttributes(modelElement, newElement);

        // simple attributes and Strings
        assertEquals("Name is incorrect.", newElement.getName(), modelElement
                .getName());
        assertEquals("isSpecification is incorrect", newElement
                .isSpecification(), modelElement.isSpecification());

        // by reference
        assertEquals("templateParameters is incorrect", modelElement
                .getTemplateParameters().size(), newElement
                .getTemplateParameters().size());
        assertEquals("templateArguments is incorrect", modelElement
                .getTemplateArguments().size(), newElement
                .getTemplateArguments().size());
        assertEquals("stereotypes is incorrect", modelElement.getStereotypes()
                .size(), newElement.getStereotypes().size());
        assertEquals("ElementImports number is incorrect.", newElement
                .getElementImports().size(), modelElement.getElementImports()
                .size());
        assertEquals("Behaviors size is incorrect.", newElement.getBehaviors()
                .size(), modelElement.getBehaviors().size());

        // by creating new object
        assertEquals("taggedValues size is incorrect.", newElement
                .getTaggedValues().size(), modelElement.getTaggedValues()
                .size());
        assertEquals("ReferenceTags size is incorrect.", newElement
                .getReferenceTags().size(), modelElement.getReferenceTags()
                .size());
        assertTrue("ParameterTemplate is incorrect.", newElement
                .getParameterTemplate() != modelElement.getParameterTemplate());
        assertEquals("defaultParameters size is incorrect.", newElement
                .getDefaultParameters().size(), modelElement
                .getDefaultParameters().size());
    }

    /**
     * Test method for
     * {@link ClassToolUtil#copyClassifierAttributes(Classifier, Classifier)}.
     */
    public void testCopyClassifierAttributes() {
        Classifier newElement = new ClassImpl();

        classToolUtil.copyClassifierAttributes(modelElement, newElement);

        // Simple attributes and Strings.
        assertEquals("isRoot is incorrect.", modelElement.isRoot(), newElement
                .isRoot());
        assertEquals("isLeaf is incorrect.", modelElement.isLeaf(), newElement
                .isLeaf());
        assertEquals("isAbstract is incorrect.", modelElement.isAbstract(),
                newElement.isAbstract());

        // By reference.
        assertEquals("typedFeatures is incorrect.", modelElement
                .getTypedFeatures(), newElement.getTypedFeatures());
        assertEquals("typedParameters is incorrect.", modelElement
                .getTypedParameters(), newElement.getTypedParameters());
        assertEquals("powertypeRanges is incorrect.", modelElement
                .getPowertypeRanges(), newElement.getPowertypeRanges());
        assertEquals("ObjectFlowStates is incorrect.", modelElement
                .getObjectFlowStates(), newElement.getObjectFlowStates());
        assertEquals("instances is incorrect.", modelElement.getInstances(),
                newElement.getInstances());

        // By creating new object.
        assertEquals("Number of features is incorrect.", modelElement
                .getFeatures().size(), newElement.getFeatures().size());
    }

}
