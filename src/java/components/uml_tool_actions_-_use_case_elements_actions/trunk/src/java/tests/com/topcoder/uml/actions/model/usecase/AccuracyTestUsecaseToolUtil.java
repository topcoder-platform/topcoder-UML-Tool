/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.actions.model.usecase.accuracytests.MockClassifierImpl;
import com.topcoder.uml.actions.model.usecase.accuracytests.MockInstanceImpl;
import com.topcoder.uml.actions.model.usecase.accuracytests.MockNamespaceImpl;
import com.topcoder.uml.actions.model.usecase.accuracytests.MockStructuralFeatureImpl;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
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
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.TestCase;

import java.awt.datatransfer.Clipboard;


/**
 * Accuracy test for the <code>UsecaseToolUtil</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestUsecaseToolUtil extends TestCase {
    /** The <code>UsecaseToolUtil</code> instance used to test against. */
    private UsecaseToolUtil util = new MockUsecaseToolUtil();

    /**
     * Test the constructor <code>UsecaseToolUtil()</code>.
     */
    public void testConstructor() {
        UsecaseToolUtil u = new MockUsecaseToolUtil();
        assertNotNull("Instance of UsecaseToolUtil should be created.", u);
    }

    /**
     * Test the method <code>addElementToModel(ModelElement, Namespace)</code>.
     */
    public void testAddElementToModel() {
        ModelElement useCase = new UseCaseImpl();
        Namespace namespace = new MockNamespaceImpl();
        util.addElementToModel(useCase, namespace);

        assertTrue("Namespace should be set.", useCase.getNamespace().equals(namespace));
        assertTrue("Owned element should be set.", namespace.getOwnedElements().contains(useCase));
    }

    /**
     * Test the method <code>removeElementFromModel(ModelElement)</code>.
     */
    public void testRemoveElementFromModel() {
        ModelElement useCase = new UseCaseImpl();
        Namespace namespace = new MockNamespaceImpl();
        assertFalse("False should be returned.", util.removeElementFromModel(useCase));
        util.addElementToModel(useCase, namespace);

        assertTrue("True should be returned.", util.removeElementFromModel(useCase));
        assertFalse("Element should be removed.", namespace.getOwnedElements().contains(useCase));
        assertFalse("False should be returned.", util.removeElementFromModel(useCase));
    }

    /**
     * Test the method <code>copyModelElementAttributes(ModelElement, ModelElement)</code>.
     */
    public void testCopyModelElementAttributes() {
        ModelElement oldUseCase = new UseCaseImpl();
        ModelElement newUseCase = new UseCaseImpl();

        oldUseCase.setName("name");
        oldUseCase.setVisibility(VisibilityKind.PROTECTED);
        oldUseCase.setSpecification(true);

        Stereotype stereotype = new StereotypeImpl();
        TemplateParameter parameter = new TemplateParameterImpl();
        TemplateArgument argument = new TemplateArgumentImpl();
        ElementImport elementImport = new ElementImportImpl();
        StateMachine behavior = new StateMachineImpl();

        oldUseCase.addStereotype(stereotype);
        oldUseCase.addTemplateParameter(parameter);
        oldUseCase.addTemplateArgument(argument);
        oldUseCase.addElementImport(elementImport);
        oldUseCase.addBehavior(behavior);

        TaggedValue taggedValue = new TaggedValueImpl();
        TemplateParameter templateParameter = new TemplateParameterImpl();

        oldUseCase.addReferenceTag(taggedValue);
        oldUseCase.addTaggedValue(taggedValue);
        oldUseCase.setParameterTemplate(templateParameter);
        oldUseCase.addDefaultParameter(templateParameter);

        util.copyModelElementAttributes(oldUseCase, newUseCase);
        assertTrue("The name should be copied.", newUseCase.getName().equals("name"));
        assertTrue("The visibility should be copied.", newUseCase.getVisibility().equals(VisibilityKind.PROTECTED));
        assertTrue("The specification flag should be copied.", newUseCase.isSpecification());
        assertTrue("The stereotype should be copied.", newUseCase.containsStereotype(stereotype));
        assertTrue("The parameter should be copied.", newUseCase.containsTemplateParameter(parameter));
        assertTrue("The argument should be copied.", newUseCase.containsTemplateArgument(argument));
        assertTrue("The elementImport should be copied.", newUseCase.containsElementImport(elementImport));
        assertTrue("The behavior should be copied.", newUseCase.containsBehavior(behavior));
        assertTrue("The referenceTag should be copied.", newUseCase.getReferenceTags().size() == 1);
        assertTrue("The taggedValue should be copied.", newUseCase.getTaggedValues().size() == 1);
        assertTrue("The defaultParameter should be copied.", newUseCase.getDefaultParameters().size() == 1);
        assertNotNull("The parameterTemplate should be copied.", newUseCase.getParameterTemplate());
    }

    /**
     * Test the method <code>copyClassifierAttributes(Classifier, Classifier)</code>.
     */
    public void testCopyClassifierAttributes() {
        Classifier oldClassifier = new MockClassifierImpl();
        Classifier newClassifier = new MockClassifierImpl();

        oldClassifier.setRoot(true);
        oldClassifier.setLeaf(true);
        oldClassifier.setAbstract(true);

        StructuralFeature feature = new MockStructuralFeatureImpl();
        Parameter parameter = new ParameterImpl();
        Generalization generalization = new GeneralizationImpl();
        ObjectFlowState objectFlowState = new ObjectFlowStateImpl();
        Instance instance = new MockInstanceImpl();

        oldClassifier.addTypedFeature(feature);
        oldClassifier.addTypedParameter(parameter);
        oldClassifier.addPowertypeRange(generalization);
        oldClassifier.addObjectFlowState(objectFlowState);
        oldClassifier.addInstance(instance);
        oldClassifier.addFeature(feature);
        oldClassifier.addFeature(new AttributeImpl());
        oldClassifier.addFeature(new MethodImpl());
        oldClassifier.addFeature(new OperationImpl());

        util.copyClassifierAttributes(oldClassifier, newClassifier);
        assertTrue("The root should be copied.", newClassifier.isRoot());
        assertTrue("The leaf should be copied.", newClassifier.isLeaf());
        assertTrue("The abstract should be copied.", newClassifier.isAbstract());
        assertTrue("The feature should be copied.", newClassifier.containsTypedFeature(feature));
        assertTrue("The parameter should be copied.", newClassifier.containsTypedParameter(parameter));
        assertTrue("The generalization should be copied.", newClassifier.containsPowertypeRange(generalization));
        assertTrue("The objectFlowState should be copied.", newClassifier.containsObjectFlowState(objectFlowState));
        assertTrue("The instance should be copied.", newClassifier.containsInstance(instance));
        assertTrue("The features should be copied.", newClassifier.getFeatures().size() == 3);
    }

    /**
     * This is a mock implementation of <code>UsecaseToolUtil</code>, it is only used in test.
     */
    private class MockUsecaseToolUtil extends UsecaseToolUtil {
        /**
         * The default constructor which simply calls the constructor of super class.
         */
        public MockUsecaseToolUtil() {
            super();
        }

        /**
         * Simply returns.
         *
         * @param modelElement ignored.
         * @param clipboard ignored.
         */
        public void addElementToClipboard(ModelElement modelElement, Clipboard clipboard) {
        }

        /**
         * Simply returns null.
         *
         * @param modelElement ignored.
         *
         * @return null.
         */
        public ModelElement copyElement(ModelElement modelElement) {
            return null;
        }
    }
}
