/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.Transition;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit tests for <code>ZUMLExceptionHandlerImpl</code> class.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class ZUMLExceptionHandlerImplUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(ZUMLExceptionHandlerImplUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>ZUMLExceptionHandlerImpl()</code>.
     * </p>
     *
     * <p>
     * The constructor is a trivial one, just test whether the instance can be created.
     * </p>
     */
    public void testCtor() {
        ZUMLActivityEdge edge = new ZUMLExceptionHandlerImpl();
        assertNotNull("Unable to create ZUMLExceptionHandlerImpl instance.",
            edge);
    }

    /**
     * <p>
     * Accuracy test for <code>convertToTCUML()</code>.
     * </p>
     *
     * <p>
     * Verify that the returned ModelElement is instance of Transition, and its
     * source, target and guard should be converted too. And verify that simple
     * attributes are copied to the converted instance.
     * </p>
     */
    public void testConvertToTCUML1() {
        AbstractZUMLActivityEdge edge = new ZUMLExceptionHandlerImpl();

        //Set its source, target, guard
        edge.setSource(new ZUMLInitialNodeImpl());
        edge.setTarget(new ZUMLFlowFinalNodeImpl());
        edge.setGuard(new ZUMLOpaqueExpressionImpl());

        //Set its simple attributes
        edge.setName("exception");

        Namespace namespace = new CollaborationImpl();
        edge.setNamespace(namespace);

        edge.setVisibility(null);
        edge.setSpecification(true);

        ModelElement element = edge.convertToTCUML();

        assertTrue("The ZUMLExceptionHandlerImpl should be converted to Transition class.",
            element instanceof Transition);

        Transition transition = (Transition) element;

        assertNotNull("It should have a source vertex.", transition.getSource());
        assertNotNull("It should have a target vertex.", transition.getTarget());
        assertNotNull("It should have a guard.", transition.getGuard());

        assertEquals("The name should match.", "exception", element.getName());
        assertEquals("The namespace should match.", namespace,
            element.getNamespace());
        assertNull("The visibility is set to null.", element.getVisibility());
        assertTrue("The specification is set to true.",
            element.isSpecification());
    }

    /**
     * <p>
     * Accuracy test for <code>convertToTCUML()</code>.
     * </p>
     *
     * <p>
     * Verify that the common attribute from ModelElement is copied to the converted instance.
     * Complex attributes are verified in this test case. Simple attributes are verified in
     * the previous test case.
     * </p>
     */
    public void testConvertToTCUML2() {
        AbstractZUMLActivityEdge edge = new ZUMLExceptionHandlerImpl();

        //Each edge should have source and target node.
        edge.setSource(new ZUMLInitialNodeImpl());
        edge.setTarget(new ZUMLFlowFinalNodeImpl());

        edge.addStereotype(new StereotypeImpl());
        edge.addTaggedValue(new TaggedValueImpl());
        edge.addReferenceTag(new TaggedValueImpl());
        edge.addSupplierDependency(new DependencyImpl());
        edge.addClientDependency(new DependencyImpl());
        edge.addComment(new CommentImpl());

        TemplateParameter tp = new TemplateParameterImpl();
        edge.setParameterTemplate(tp);

        edge.addDefaultParameter(new TemplateParameterImpl());
        edge.addTemplateParameter(new TemplateParameterImpl());
        edge.addTemplateArgument(new TemplateArgumentImpl());
        edge.addElementImport(new ElementImportImpl());
        edge.addBehavior(new StateMachineImpl());

        ModelElement element = edge.convertToTCUML();

        assertEquals("There should be 1 stereotype.", 1,
            element.getStereotypes().size());
        assertEquals("There should be 0 taggedValue.", 0,
            element.getTaggedValues().size());
        assertEquals("There should be 1 referenceTag.", 1,
            element.getReferenceTags().size());
        assertEquals("There should be 1 supplierDependency.", 1,
            element.getSupplierDependencies().size());
        assertEquals("There should be 1 clientDependency.", 1,
            element.getClientDependencies().size());
        assertEquals("There should be 1 comment.", 1,
            element.getComments().size());
        assertEquals("The parameterTemplate should match.", tp,
            element.getParameterTemplate());
        assertEquals("There should be 1 defaultParameter.", 1,
            element.getDefaultParameters().size());
        assertEquals("There should be 1 templateParameter.", 1,
            element.getTemplateParameters().size());
        assertEquals("There should be 1 templateArgument.", 1,
            element.getTemplateArguments().size());
        assertEquals("There should be 1 elementImport.", 1,
            element.getElementImports().size());
        assertEquals("There should be 1 behavior.", 1,
            element.getBehaviors().size());
    }

    /**
     * <p>
     * Accuracy test for <code>convertToTCUML()</code>.
     * </p>
     *
     * <p>
     * Verify that convertToTCUML() always returns the same instance.
     * </p>
     */
    public void testConvertToTCUML3() {
        AbstractZUMLActivityEdge edge = new ZUMLExceptionHandlerImpl();

        //Each edge should have source and target node.
        edge.setSource(new ZUMLInitialNodeImpl());
        edge.setTarget(new ZUMLFlowFinalNodeImpl());

        assertEquals("The convertToTCUML() should always return the same instance.",
            edge.convertToTCUML(), edge.convertToTCUML());
    }
}
