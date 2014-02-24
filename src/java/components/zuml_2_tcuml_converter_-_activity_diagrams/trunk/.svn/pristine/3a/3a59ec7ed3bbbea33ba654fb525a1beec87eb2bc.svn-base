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
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.StateMachineImpl;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLOpaqueExpression;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit tests for <code>ZUMLOpaqueExpressionImpl</code> class.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class ZUMLOpaqueExpressionImplUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(ZUMLOpaqueExpressionImplUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>ZUMLOpaqueExpressionImpl()</code>.
     * </p>
     *
     * <p>
     * The constructor is a trivial one, just test whether the instance can be created.
     * </p>
     */
    public void testCtor() {
        ZUMLOpaqueExpression expression = new ZUMLOpaqueExpressionImpl();
        assertNotNull("Unable to create ZUMLOpaqueExpressionImpl instance.",
            expression);
    }

    /**
     * <p>
     * Accuracy test for <code>convertToTCUML()</code>.
     * </p>
     *
     * <p>
     * Verify that the returned ModelElement is instance of Guard, and it has a
     * corresponding BooleanExpression. And verify that simple attributes are copied
     * to the converted instance.
     * </p>
     */
    public void testConvertToTCUML1() {
        AbstractZUMLOpaqueExpression expression = new ZUMLOpaqueExpressionImpl();

        expression.setBody("body");
        expression.setLanguage("language");

        //Set the Opaque Expression's simple attributes
        expression.setName("OpaqueExpression");

        Namespace namespace = new CollaborationImpl();
        expression.setNamespace(namespace);

        expression.setVisibility(null);
        expression.setSpecification(true);

        ModelElement element = expression.convertToTCUML();

        assertTrue("The ZUMLOpaqueExpressionImpl should be converted to Guard class.",
            element instanceof Guard);

        Guard guard = (Guard) element;
        assertNotNull("The guard should have 1 BooleanExpression.",
            guard.getExpression());
        assertEquals("The body is 'body'", "body",
            guard.getExpression().getBody());
        assertEquals("The language is 'language'", "language",
            guard.getExpression().getLanguage());

        assertEquals("The name should match.", "OpaqueExpression",
            element.getName());
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
        AbstractZUMLOpaqueExpression expression = new ZUMLOpaqueExpressionImpl();

        expression.addStereotype(new StereotypeImpl());
        expression.addTaggedValue(new TaggedValueImpl());
        expression.addReferenceTag(new TaggedValueImpl());
        expression.addSupplierDependency(new DependencyImpl());
        expression.addClientDependency(new DependencyImpl());
        expression.addComment(new CommentImpl());

        TemplateParameter tp = new TemplateParameterImpl();
        expression.setParameterTemplate(tp);

        expression.addDefaultParameter(new TemplateParameterImpl());
        expression.addTemplateParameter(new TemplateParameterImpl());
        expression.addTemplateArgument(new TemplateArgumentImpl());
        expression.addElementImport(new ElementImportImpl());
        expression.addBehavior(new StateMachineImpl());

        ModelElement element = expression.convertToTCUML();

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
        ZUMLOpaqueExpression expression = new ZUMLOpaqueExpressionImpl();

        assertEquals("The convertToTCUML() should always return the same instance.",
            expression.convertToTCUML(), expression.convertToTCUML());
    }
}
