/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.accuracytests;

import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateMachineImpl;

/**
 * <p>
 * Accuracy tests for <code>ModelElementAbstractImpl</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class ModelElementAbstractImplAccuracyTests extends TestCase {

    /** Represents the mocked <code>ModelElementAbstractImpl</code> instance used for testing. */
    private ModelElementAbstractImpl element;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        //creates the mocked ModelElementAbstractImpl instance
        element = new MockModelElementImpl();
    }

    /**
     * Accuracy test of method <code>setName(String)</code> and <code>getName()</code>.
     */
    public void testNameSetterAndGetter() {
        //the initial value is null
        assertNull(element.getName());
        //set the name with empty String
        element.setName("");
        assertEquals("", element.getName());
        //set the name with non-empty String
        element.setName("some name");
        assertEquals("some name", element.getName());
        //set the name with null
        element.setName(null);
        assertNull(element.getName());
    }

    /**
     * Accuracy test of method <code>setVisibility(VisibilityKind)</code> and <code>getVisibility()</code>.
     */
    public void testVisibilitySetterAndGetter() {
        //initial value is null
        assertNull(element.getVisibility());
        //set the Visibility with specified VisibilityKind
        element.setVisibility(VisibilityKind.PUBLIC);
        assertEquals(VisibilityKind.PUBLIC, element.getVisibility());
        //set the Visibility with null
        element.setVisibility(null);
        assertNull(element.getVisibility());
    }

    /**
     * Accuracy test of method <code>setSpecification(boolean)</code> and <code>isSpecification()</code>.
     */
    public void testSpecificationSetterAndGetter() {
        //initial value is false
        assertFalse(element.isSpecification());
        //sets the specification with true
        element.setSpecification(true);
        assertTrue(element.isSpecification());
        //sets the specification with false
        element.setSpecification(false);
        assertFalse(element.isSpecification());
    }

    /**
     * Accuracy test of method <code>addStereotype(Stereotype)</code>, <code>removeStereotype(Stereotype)</code>,
     * <code>containsStereotype(Stereotype)</code>, <code>clearStereotypes()</code>, <code>getStereotypes()</code>
     * and <code>countStereotypes()</code>.
     */
    public void testStereotypeOperations() {
        //initial value is an empty ArrayList
        assertEquals(0, element.countStereotypes());
        //add a Stereotype
        Stereotype stereotype0 = new StereotypeImpl();
        Stereotype stereotype1 = new StereotypeImpl();
        element.addStereotype(stereotype0);
        assertEquals(1, element.countStereotypes());
        assertTrue(element.containsStereotype(stereotype0));
        assertFalse(element.containsStereotype(stereotype1));
        //add another Stereotype
        element.addStereotype(stereotype1);
        assertEquals(2, element.countStereotypes());
        assertTrue(element.containsStereotype(stereotype1));
        //tests the getter
        Collection<Stereotype> stereotypes = element.getStereotypes();
        assertNotNull(stereotypes);
        assertEquals(2, stereotypes.size());
        assertTrue(stereotypes.contains(stereotype0));
        assertTrue(stereotypes.contains(stereotype1));
        //tests the remove and clear operations
        element.removeStereotype(stereotype0);
        assertEquals(1, element.countStereotypes());
        assertFalse(element.containsStereotype(stereotype0));
        assertTrue(element.containsStereotype(stereotype1));
        element.clearStereotypes();
        assertEquals(0, element.countStereotypes());
        assertFalse(element.containsStereotype(stereotype1));
    }

    /**
     * Accuracy test of method <code>addTaggedValue(TaggedValue)</code>, <code>removeTaggedValue(TaggedValue)</code>,
     * <code>containsTaggedValue(TaggedValue)</code>, <code>clearTaggedValues()</code>, <code>getTaggedValues()</code>
     * and <code>countTaggedValues()</code>.
     */
    public void testTaggedValueOperations() {
        //initial value is an empty ArrayList
        assertEquals(0, element.countTaggedValues());
        //add a TaggedValue
        TaggedValue taggedValue0 = new TaggedValueImpl();
        element.addTaggedValue(taggedValue0);
        assertEquals(1, element.countTaggedValues());
        assertTrue(element.containsTaggedValue(taggedValue0));
        //add another two TaggedValues
        TaggedValue taggedValue1 = new TaggedValueImpl();
        element.addTaggedValue(taggedValue1);
        TaggedValue taggedValue2 = taggedValue1;
        element.addTaggedValue(taggedValue2);
        assertEquals(3, element.countTaggedValues());
        //get all the TaggedValues
        Collection<TaggedValue> taggedValues = element.getTaggedValues();
        assertEquals(3, taggedValues.size());
        //remove a TaggedValue
        assertTrue(element.removeTaggedValue(taggedValue1));
        assertEquals(2, element.countTaggedValues());
        assertFalse(element.removeTaggedValue(new TaggedValueImpl()));
        //clear all the TaggedValues
        element.clearTaggedValues();
        assertEquals(0, element.countTaggedValues());
    }

    /**
     * Accuracy test of method <code>addReferenceTag(TaggedValue)</code>,
     * <code>removeReferenceTag(TaggedValue)</code>, <code>containsReferenceTag(TaggedValue)</code>,
     * <code>clearReferenceTags()</code>, <code>getReferenceTags()</code> and <code>countReferenceTags()</code>.
     */
    public void testReferenceTagOperations() {
        //initial value is an empty ArrayList
        assertEquals(0, element.countReferenceTags());
        //add a ReferenceTag
        TaggedValue taggedValue0 = new TaggedValueImpl();
        element.addReferenceTag(taggedValue0);
        assertEquals(1, element.countReferenceTags());
        assertTrue(element.containsReferenceTag(taggedValue0));
        //add another two ReferenceTags
        TaggedValue taggedValue1 = new TaggedValueImpl();
        element.addReferenceTag(taggedValue1);
        TaggedValue taggedValue2 = taggedValue1;
        element.addReferenceTag(taggedValue2);
        assertEquals(3, element.countReferenceTags());
        //get all the ReferenceTags
        Collection<TaggedValue> taggedValues = element.getReferenceTags();
        assertEquals(3, taggedValues.size());
        //remove a ReferenceTag
        assertTrue(element.removeReferenceTag(taggedValue1));
        assertEquals(2, element.countReferenceTags());
        assertFalse(element.removeReferenceTag(new TaggedValueImpl()));
        //clear all the ReferenceTags
        element.clearReferenceTags();
        assertEquals(0, element.countReferenceTags());
    }

    /**
     * Accuracy test of methods <code>setNamespace(Namespace)</code> and <code>getNamespace()</code>.
     */
    public void testNamespaceSetterAndGetter() {
        //initial value
        assertNull(element.getNamespace());
        //set a valid Namespace
        Namespace namespace = new MockNamespaceImpl();
        element.setNamespace(namespace);
        assertNotNull(element.getNamespace());
        //set a null Namespace
        element.setNamespace(null);
        assertNull(element.getNamespace());
    }

    /**
     * Accuracy test of method <code>addSupplierDependency(Dependency)</code>,
     * <code>removeSupplierDependency(Dependency)</code>, <code>containsSupplierDependency(Dependency)</code>,
     * <code>clearSupplierDependencys()</code>, <code>getSupplierDependencys()</code> and
     * <code>countSupplierDependencys()</code>.
     */
    public void testSupplierDependencyOperations() {
        //initial value is an empty ArrayList
        assertEquals(0, element.countSupplierDependencies());
        //add a SupplierDependency
        Dependency dependency0 = new DependencyImpl();
        element.addSupplierDependency(dependency0);
        assertEquals(1, element.countSupplierDependencies());
        assertTrue(element.containsSupplierDependency(dependency0));
        //add another two SupplierDependencies
        Dependency dependency1 = new DependencyImpl();
        element.addSupplierDependency(dependency1);
        Dependency dependency2 = dependency1;
        element.addSupplierDependency(dependency2);
        assertEquals(3, element.countSupplierDependencies());
        //get all the SupplierDependencies
        Collection<Dependency> dependencies = element.getSupplierDependencies();
        assertEquals(3, dependencies.size());
        //remove a SupplierDependency
        assertTrue(element.removeSupplierDependency(dependency1));
        assertEquals(2, element.countSupplierDependencies());
        assertFalse(element.removeSupplierDependency(new DependencyImpl()));
        //clear all the SupplierDependencys
        element.clearSupplierDependencies();
        assertEquals(0, element.countSupplierDependencies());
    }

    /**
     * Accuracy test of method <code>addClientDependency(Dependency)</code>,
     * <code>removeClientDependency(Dependency)</code>, <code>containsClientDependency(Dependency)</code>,
     * <code>clearClientDependencys()</code>, <code>getClientDependencys()</code> and
     * <code>countClientDependencys()</code>.
     */
    public void testClientDependencyOperations() {
        //initial value is an empty ArrayList
        assertEquals(0, element.countClientDependencies());
        //add a ClientDependency
        Dependency dependency0 = new DependencyImpl();
        element.addClientDependency(dependency0);
        assertEquals(1, element.countClientDependencies());
        assertTrue(element.containsClientDependency(dependency0));
        //add another two ClientDependencies
        Dependency dependency1 = new DependencyImpl();
        element.addClientDependency(dependency1);
        Dependency dependency2 = dependency1;
        element.addClientDependency(dependency2);
        assertEquals(3, element.countClientDependencies());
        //get all the ClientDependencies
        Collection<Dependency> dependencies = element.getClientDependencies();
        assertEquals(3, dependencies.size());
        //remove a ClientDependency
        assertTrue(element.removeClientDependency(dependency1));
        assertEquals(2, element.countClientDependencies());
        assertFalse(element.removeClientDependency(new DependencyImpl()));
        //clear all the ClientDependencys
        element.clearClientDependencies();
        assertEquals(0, element.countClientDependencies());
    }

    /**
     * Accuracy test of method <code>addComment(Comment)</code>, <code>removeComment(Comment)</code>,
     * <code>containsComment(Comment)</code>, <code>clearComments()</code>, <code>getComments()</code>
     * and <code>countComments()</code>.
     */
    public void testCommentOperations() {
        //initial value is an empty ArrayList
        assertEquals(0, element.countComments());
        //add a Comment
        Comment taggedValue0 = new CommentImpl();
        element.addComment(taggedValue0);
        assertEquals(1, element.countComments());
        assertTrue(element.containsComment(taggedValue0));
        //add another two Comments
        Comment taggedValue1 = new CommentImpl();
        element.addComment(taggedValue1);
        Comment taggedValue2 = taggedValue1;
        element.addComment(taggedValue2);
        assertEquals(3, element.countComments());
        //get all the Comments
        Collection<Comment> taggedValues = element.getComments();
        assertEquals(3, taggedValues.size());
        //remove a Comment
        assertTrue(element.removeComment(taggedValue1));
        assertEquals(2, element.countComments());
        assertFalse(element.removeComment(new CommentImpl()));
        //clear all the Comments
        element.clearComments();
        assertEquals(0, element.countComments());
    }

    /**
     * Accuracy test of methods <code>setParameterTemplate(TemplateParameter)</code> and
     * <code>getParameterTemplate()</code>.
     */
    public void testTemplateParameterSetterAndGetter() {
        //initial value
        assertNull(element.getParameterTemplate());
        //set a valid TemplateParameter
        TemplateParameter parameter = new TemplateParameterImpl();
        element.setParameterTemplate(parameter);
        assertNotNull(element.getParameterTemplate());
        //set a null TemplateParameter
        element.setParameterTemplate(null);
        assertNull(element.getParameterTemplate());
    }

    /**
     * Accuracy test of method <code>addDefaultParameter(TemplateParameter)</code>,
     * <code>removeDefaultParameter(TemplateParameter)</code>,
     * <code>containsDefaultParameter(TemplateParameter)</code>, <code>clearDefaultParameters()</code>,
     * <code>getDefaultParameters()</code> and <code>countDefaultParameters()</code>.
     */
    public void testDefaultParameterOperations() {
        //initial value is an empty ArrayList
        assertEquals(0, element.countDefaultParameters());
        //add a DefaultParameter
        TemplateParameter parameter0 = new TemplateParameterImpl();
        element.addDefaultParameter(parameter0);
        assertEquals(1, element.countDefaultParameters());
        assertTrue(element.containsDefaultParameter(parameter0));
        //add another two DefaultParameters
        TemplateParameter parameter1 = new TemplateParameterImpl();
        element.addDefaultParameter(parameter1);
        TemplateParameter parameter2 = parameter1;
        element.addDefaultParameter(parameter2);
        assertEquals(3, element.countDefaultParameters());
        //get all the DefaultParameters
        Collection<TemplateParameter> parameters = element.getDefaultParameters();
        assertEquals(3, parameters.size());
        //remove a DefaultParameter
        assertTrue(element.removeDefaultParameter(parameter1));
        assertEquals(2, element.countDefaultParameters());
        assertFalse(element.removeDefaultParameter(new TemplateParameterImpl()));
        //clear all the DefaultParameters
        element.clearDefaultParameters();
        assertEquals(0, element.countDefaultParameters());
    }

    /**
     * Accuracy test of method <code>addTemplateParameter(TemplateParameter)</code>,
     * <code>addTemplateParameter(int, TemplateParameter)</code>,
     * <code>setTemplateParameter(int, TemplateParameter)</code>,
     * <code>removeTemplateParameter(TemplateParameter)</code>,
     * <code>removeTemplateParameter(int)</code>,
     * <code>containsTemplateParameter(TemplateParameter)</code>,
     * <code>indexOfTemplateParameter(TemplateParameter)</code>,
     * <code>clearTemplateParameters()</code>,
     * <code>getTemplateParameters()</code> and <code>countTemplateParameters()</code>.
     */
    public void testTemplateParameterOperations() {
        //initial value is empty LinkedList
        assertEquals(0, element.countTemplateParameters());
        //add a TemplateParameter
        TemplateParameter parameter0 = new TemplateParameterImpl();
        element.addTemplateParameter(parameter0);
        assertEquals(1, element.countTemplateParameters());
        //add another TemplateParameter
        TemplateParameter parameter1 = new TemplateParameterImpl();
        element.addTemplateParameter(0, parameter1);
        assertEquals(2, element.countTemplateParameters());
        assertEquals(1, element.indexOfTemplateParameter(parameter0));
        assertEquals(0, element.indexOfTemplateParameter(parameter1));
        //set a new TemplateParameter
        TemplateParameter parameter2 = new TemplateParameterImpl();
        element.setTemplateParameter(1, parameter2);
        assertEquals(2, element.countTemplateParameters());
        assertEquals(1, element.indexOfTemplateParameter(parameter2));
        assertEquals(0, element.indexOfTemplateParameter(parameter1));
        assertFalse(element.containsTemplateParameter(parameter0));
        //remove a TemplateParameter
        assertFalse(element.removeTemplateParameter(parameter0));
        assertEquals(parameter2, element.removeTemplateParameter(1));
        assertEquals(1, element.countTemplateParameters());
        //get all the TemplateParameter
        List<TemplateParameter> parameters = element.getTemplateParameters();
        assertEquals(1, parameters.size());
        //clear all the TemplateParameter
        element.clearTemplateParameters();
        assertEquals(0, element.countTemplateParameters());
    }

    /**
     * Accuracy test of method <code>addTemplateArgument(TemplateArgument)</code>,
     * <code>removeTemplateArgument(TemplateArgument)</code>, <code>containsTemplateArgument(TemplateArgument)</code>,
     * <code>clearTemplateArguments()</code>, <code>getTemplateArguments()</code> and
     * <code>countTemplateArguments()</code>.
     */
    public void testTemplateArgumentOperations() {
        //initial value is an empty ArrayList
        assertEquals(0, element.countTemplateArguments());
        //add a TemplateArgument
        TemplateArgument argument0 = new TemplateArgumentImpl();
        element.addTemplateArgument(argument0);
        assertEquals(1, element.countTemplateArguments());
        assertTrue(element.containsTemplateArgument(argument0));
        //add another two TemplateArguments
        TemplateArgument argument1 = new TemplateArgumentImpl();
        element.addTemplateArgument(argument1);
        TemplateArgument argument2 = argument1;
        element.addTemplateArgument(argument2);
        assertEquals(3, element.countTemplateArguments());
        //get all the TemplateArguments
        Collection<TemplateArgument> arguments = element.getTemplateArguments();
        assertEquals(3, arguments.size());
        //remove a TemplateArgument
        assertTrue(element.removeTemplateArgument(argument1));
        assertEquals(2, element.countTemplateArguments());
        assertFalse(element.removeTemplateArgument(new TemplateArgumentImpl()));
        //clear all the TemplateArguments
        element.clearTemplateArguments();
        assertEquals(0, element.countTemplateArguments());
    }

    /**
     * Accuracy test of method <code>addElementImport(ElementImport)</code>,
     * <code>removeElementImport(ElementImport)</code>, <code>containsElementImport(ElementImport)</code>,
     * <code>clearElementImports()</code>, <code>getElementImports()</code> and <code>countElementImports()</code>.
     */
    public void testElementImportOperations() {
        //initial value is an empty ArrayList
        assertEquals(0, element.countElementImports());
        //add a ElementImport
        ElementImport elementImport0 = new ElementImportImpl();
        element.addElementImport(elementImport0);
        assertEquals(1, element.countElementImports());
        assertTrue(element.containsElementImport(elementImport0));
        //add another two ElementImports
        ElementImport elementImport1 = new ElementImportImpl();
        element.addElementImport(elementImport1);
        ElementImport elementImport2 = elementImport1;
        element.addElementImport(elementImport2);
        assertEquals(3, element.countElementImports());
        //get all the ElementImports
        Collection<ElementImport> elementImports = element.getElementImports();
        assertEquals(3, elementImports.size());
        //remove a ElementImport
        assertTrue(element.removeElementImport(elementImport1));
        assertEquals(2, element.countElementImports());
        assertFalse(element.removeElementImport(new ElementImportImpl()));
        //clear all the ElementImports
        element.clearElementImports();
        assertEquals(0, element.countElementImports());
    }

    /**
     * Accuracy test of method <code>addBehavior(StateMachine)</code>,
     * <code>removeBehavior(StateMachine)</code>, <code>containsBehavior(StateMachine)</code>,
     * <code>clearBehaviors()</code>, <code>getBehaviors()</code> and <code>countBehaviors()</code>.
     */
    public void testBehaviorOperations() {
        //initial value is an empty ArrayList
        assertEquals(0, element.countBehaviors());
        //add a Behavior
        StateMachine elementImport0 = new StateMachineImpl();
        element.addBehavior(elementImport0);
        assertEquals(1, element.countBehaviors());
        assertTrue(element.containsBehavior(elementImport0));
        //add another two Behaviors
        StateMachine elementImport1 = new StateMachineImpl();
        element.addBehavior(elementImport1);
        StateMachine elementImport2 = elementImport1;
        element.addBehavior(elementImport2);
        assertEquals(3, element.countBehaviors());
        //get all the Behaviors
        Collection<StateMachine> elementImports = element.getBehaviors();
        assertEquals(3, elementImports.size());
        //remove a Behavior
        assertTrue(element.removeBehavior(elementImport1));
        assertEquals(2, element.countBehaviors());
        assertFalse(element.removeBehavior(new StateMachineImpl()));
        //clear all the Behaviors
        element.clearBehaviors();
        assertEquals(0, element.countBehaviors());
    }
}
