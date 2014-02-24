/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core;

import java.util.*;

import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.statemachines.StateMachine;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public abstract class ModelElementAbstractImpl extends ElementAbstractImpl implements ModelElement {

    /**
     * Mock attribute.
     */
    private String name = "test";

    /**
     * Mock attribute.
     */
    private VisibilityKind visibility = VisibilityKind.PRIVATE;

    /**
     * Mock attribute.
     */
    private boolean isSpecification = false;

    /**
     * Mock attribute.
     */
    private final Collection<Stereotype> stereotypes = new ArrayList<Stereotype>();

    /**
     * Mock attribute.
     */
    private final Collection<TaggedValue> taggedValues = new ArrayList<TaggedValue>();

    /**
     * Mock attribute.
     */
    private final Collection<TaggedValue> referenceTags = new ArrayList<TaggedValue>();

    /**
     * Mock attribute.
     */
    private Namespace namespace;
    
    /**
     * Mock attribute. 
     */
    private Collection<Dependency> supplierDependencies = new ArrayList<Dependency>();
    
    /**
     * Mock attribute. 
     */
    private Collection<Dependency> clientDependencies = new ArrayList<Dependency>();

    /**
     * Mock attribute.
     */
    private TemplateParameter parameterTemplate;

    /**
     * Mock attribute.
     */
    private final Collection<TemplateParameter> defaultParameter = new ArrayList<TemplateParameter>();

    /**
     * Mock attribute.
     */
    private final List<TemplateParameter> templateParameters = new LinkedList<TemplateParameter>();

    /**
     * Mock attribute.
     */
    private final Collection<TemplateArgument> templateArguments = new ArrayList<TemplateArgument>();

    /**
     * Mock attribute.
     */
    private final Collection<ElementImport> elementImports = new ArrayList<ElementImport>();

    /**
     * Mock attribute.
     */
    private final Collection<StateMachine> behaviors = new ArrayList<StateMachine>();

    /**
     * Mock method.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Mock method.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Mock method.
     *
     * @param visibility
     */
    public void setVisibility(VisibilityKind visibility) {
        this.visibility = visibility;
    }

    /**
     * Mock method.
     *
     * @return
     */
    public VisibilityKind getVisibility() {
        return this.visibility;
    }

    /**
     * Mock method.
     *
     * @param isSpecification
     */
    public void setSpecification(boolean isSpecification) {
        this.isSpecification = isSpecification;
    }

    /**
     * Mock method.
     *
     * @return
     */
    public boolean isSpecification() {
        return this.isSpecification;
    }

    /**
     * Mock method.
     *
     * @param stereoType
     */
    public void addStereoType(Stereotype stereoType) {
        this.stereotypes.add(stereoType);
    }

    /**
     * <p>
     * Removes a stereo type from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         stereo type
     * @param stereoType
     *            the stereo type to be removed
     * @throws IllegalArgumentException
     *             if <code>stereoType</code> is null
     */
    public boolean removeStereoType(Stereotype stereoType) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "stereo type" from the collection of the
     * current object.
     * </p>
     */
    public void clearStereoTypes() {
    }

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<Stereotype> getStereoTypes() {
        return stereotypes;
    }

    /**
     * Mock method.
     *
     * @param stereoType
     * @return
     */
    public boolean containsStereoType(Stereotype stereoType) {
        return stereotypes.contains(stereoType);
    }

    /**
     * <p>
     * Returns the number of objects of type "stereo type" previously added to
     * the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Stereotype</code>
     *         inserted in the collection of the current object
     */
    public int countStereoTypes() {
        return 0;
    }

    /**
     * Mock method.
     *
     * @param taggedValue
     */
    public void addTaggedValue(TaggedValue taggedValue) {
        this.taggedValues.add(taggedValue);
    }

    /**
     * <p>
     * Removes a tagged value from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         tagged value
     * @param taggedValue
     *            the tagged value to be removed
     * @throws IllegalArgumentException
     *             if <code>taggedValue</code> is null
     */
    public boolean removeTaggedValue(TaggedValue taggedValue) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "tagged value" from the collection of the
     * current object.
     * </p>
     */
    public void clearTaggedValues() {
    }

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<TaggedValue> getTaggedValues() {
        return this.taggedValues;
    }

    /**
     * Mock method.
     *
     * @return
     * @param taggedValue
     */
    public boolean containsTaggedValue(TaggedValue taggedValue) {
        return this.taggedValues.contains(taggedValue);
    }

    /**
     * <p>
     * Returns the number of objects of type "tagged value" previously added to
     * the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>TaggedValue</code>
     *         inserted in the collection of the current object
     */
    public int countTaggedValues() {
        return 0;
    }

    /**
     * Mock method.
     *
     * @param referenceTag
     */
    public void addReferenceTag(TaggedValue referenceTag) {
        this.referenceTags.add(referenceTag);
    }

    /**
     * <p>
     * Removes a reference tag from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         reference tag
     * @param referenceTag
     *            the reference tag to be removed
     * @throws IllegalArgumentException
     *             if <code>referenceTag</code> is null
     */
    public boolean removeReferenceTag(TaggedValue referenceTag) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "reference tag" from the collection of
     * the current object.
     * </p>
     */
    public void clearReferenceTags() {
    }

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<TaggedValue> getReferenceTags() {
        return this.referenceTags;
    }

    /**
     * Mock method.
     *
     * @return
     * @param referenceTag
     */
    public boolean containsReferenceTag(TaggedValue referenceTag) {
        return this.referenceTags.contains(referenceTag);
    }

    /**
     * <p>
     * Returns the number of objects of type "reference tag" previously added to
     * the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>TaggedValue</code>
     *         inserted in the collection of the current object
     */
    public int countReferenceTags() {
        return 0;
    }

    /**
     * Mock method.
     *
     * @param namespace
     */
    public void setNamespace(Namespace namespace) {
        this.namespace = namespace;
    }

    /**
     * Mock method.
     *
     * @return
     */
    public Namespace getNamespace() {
        return this.namespace;
    }

    /**
     * <p>
     * Adds a supplier dependency to the collection of the current object.
     * </p>
     *
     * @param supplierDependency
     *            the supplier dependency to be added
     * @throws IllegalArgumentException
     *             if <code>supplierDependency</code> is null
     */
    public void addSupplierDependency(Dependency supplierDependency) {
        this.supplierDependencies.add(supplierDependency);
    }

    /**
     * <p>
     * Removes a supplier dependency from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         supplier dependency
     * @param supplierDependency
     *            the supplier dependency to be removed
     * @throws IllegalArgumentException
     *             if <code>supplierDependency</code> is null
     */
    public boolean removeSupplierDependency(Dependency supplierDependency) {
        return this.supplierDependencies.remove(supplierDependency);
    }

    /**
     * <p>
     * Removes all the objects of type "supplier dependency" from the collection
     * of the current object.
     * </p>
     */
    public void clearSupplierDependencies() {
    }

    /**
     * <p>
     * Gets all the objects of type "supplier dependency" previously added to
     * the collection of the current object.
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all
     *         the objects of type <code>Dependency</code> added to the
     *         collection of current object
     */
    public Collection<Dependency> getSupplierDependencies() {
        return this.supplierDependencies;
    }

    /**
     * <p>
     * Checks if a supplier dependency is contained in the collection of the
     * current object.
     * </p>
     *
     * @return <code>true</code> if <code>supplierDependency</code> is
     *         contained in the collection of the current object
     * @param supplierDependency
     */
    public boolean containsSupplierDependency(Dependency supplierDependency) {
        return this.supplierDependencies.contains(supplierDependency);
    }

    /**
     * <p>
     * Returns the number of objects of type "supplier dependency" previously
     * added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Dependency</code>
     *         inserted in the collection of the current object
     */
    public int countSupplierDependencies() {
        return 0;
    }

    /**
     * <p>
     * Adds a client dependency to the collection of the current object.
     * </p>
     *
     * @param clientDependency
     *            the client dependency to be added
     * @throws IllegalArgumentException
     *             if <code>clientDependency</code> is null
     */
    public void addClientDependency(Dependency clientDependency) {
        this.clientDependencies.add(clientDependency);
    }

    /**
     * <p>
     * Removes a client dependency from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         client dependency
     * @param clientDependency
     *            the client dependency to be removed
     * @throws IllegalArgumentException
     *             if <code>clientDependency</code> is null
     */
    public boolean removeClientDependency(Dependency clientDependency) {
        return this.clientDependencies.remove(clientDependency);
    }

    /**
     * <p>
     * Removes all the objects of type "client dependency" from the collection
     * of the current object.
     * </p>
     */
    public void clearClientDependencies() {
    }

    /**
     * <p>
     * Gets all the objects of type "client dependency" previously added to the
     * collection of the current object.
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all
     *         the objects of type <code>Dependency</code> added to the
     *         collection of current object
     */
    public Collection<Dependency> getClientDependencies() {
        return this.clientDependencies;
    }

    /**
     * <p>
     * Checks if a client dependency is contained in the collection of the
     * current object.
     * </p>
     *
     * @return <code>true</code> if <code>clientDependency</code> is
     *         contained in the collection of the current object
     * @param clientDependency
     */
    public boolean containsClientDependency(Dependency clientDependency) {
        return this.clientDependencies.contains(clientDependency);
    }

    /**
     * <p>
     * Returns the number of objects of type "client dependency" previously
     * added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Dependency</code>
     *         inserted in the collection of the current object
     */
    public int countClientDependencies() {
        return 0;
    }

    /**
     * <p>
     * Adds a comment to the collection of the current object.
     * </p>
     *
     * @param comment
     *            the comment to be added
     * @throws IllegalArgumentException
     *             if <code>comment</code> is null
     */
    public void addComment(Comment comment) {
    }

    /**
     * <p>
     * Removes a comment from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         comment
     * @param comment
     *            the comment to be removed
     * @throws IllegalArgumentException
     *             if <code>comment</code> is null
     */
    public boolean removeComment(Comment comment) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "comment" from the collection of the
     * current object.
     * </p>
     */
    public void clearComments() {
    }

    /**
     * <p>
     * Gets all the objects of type "comment" previously added to the collection
     * of the current object.
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all
     *         the objects of type <code>Comment</code> added to the
     *         collection of current object
     */
    public Collection<Comment> getComments() {
        // your code here
        return null;
    }

    /**
     * <p>
     * Checks if a comment is contained in the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if <code>comment</code> is contained in the
     *         collection of the current object
     * @param comment
     */
    public boolean containsComment(Comment comment) {
        return false;
    }

    /**
     * <p>
     * Returns the number of objects of type "comment" previously added to the
     * collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Comment</code> inserted
     *         in the collection of the current object
     */
    public int countComments() {
        return 0;
    }

    /**
     * Mock method.
     *
     * @param parameterTemplate
     */
    public void setParameterTemplate(TemplateParameter parameterTemplate) {
        this.parameterTemplate = parameterTemplate;
    }

    /**
     * Mock method.
     *
     * @return
     */
    public TemplateParameter getParameterTemplate() {
        return this.parameterTemplate;
    }

    /**
     * Mock method.
     *
     * @param defaultParameter
     */
    public void addDefaultParameter(TemplateParameter defaultParameter) {
        this.defaultParameter.add(defaultParameter);
    }

    /**
     * <p>
     * Removes a default parameter from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         default parameter
     * @param defaultParameter
     *            the default parameter to be removed
     * @throws IllegalArgumentException
     *             if <code>defaultParameter</code> is null
     */
    public boolean removeDefaultParameter(TemplateParameter defaultParameter) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "default parameter" from the collection
     * of the current object.
     * </p>
     */
    public void clearDefaultParameters() {
    }

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<TemplateParameter> getDefaultParameters() {
        return this.defaultParameter;
    }

    /**
     * Mock method.
     *
     * @return
     * @param defaultParameter
     */
    public boolean containsDefaultParameter(TemplateParameter defaultParameter) {
        return this.defaultParameter.contains(defaultParameter);
    }

    /**
     * <p>
     * Returns the number of objects of type "default parameter" previously
     * added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>TemplateParameter</code>
     *         inserted in the collection of the current object
     */
    public int countDefaultParameters() {
        return 0;
    }

    /**
     * Mock method.
     *
     * @param templateParameter
     */
    public void addTemplateParameter(TemplateParameter templateParameter) {
        this.templateParameters.add(templateParameter);
    }

    /**
     * <p>
     * Adds a template parameter at specified index of the ordered collection of
     * the current object.
     * </p>
     *
     * @param index
     * @param templateParameter
     *            the template parameter to be added
     * @throws IllegalArgumentException
     *             if <code>templateParameter</code> is null
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is not valid, i.e. the condition <i>0 <=
     *             index < countTemplateParameters()</i> does not hold.
     */
    public void addTemplateParameter(int index, TemplateParameter templateParameter) {
    }

    /**
     * <p>
     * Sets the template parameter at specified index of the ordered collection
     * of the current object.
     * </p>
     *
     * @param index
     * @param templateParameter
     *            the template parameter to be added
     * @throws IllegalArgumentException
     *             if <code>templateParameter</code> is null
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is not valid, i.e. the condition <i>0 <=
     *             index < countTemplateParameters()</i> does not hold.
     */
    public void setTemplateParameter(int index, TemplateParameter templateParameter) {
    }

    /**
     * <p>
     * Removes (and fetches) the template parameter at specified index from the
     * ordered collection of the current object.
     * </p>
     *
     * @return the removed object of type <code>TemplateParameter</code>
     * @param index
     *            the index of the template parameter to be removed
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is not valid, i.e. the condition <i>0 <=
     *             index < countTemplateParameters()</i> does not hold.
     */
    public TemplateParameter removeTemplateParameter(int index) {
        return null;
    }

    /**
     * <p>
     * Removes a template parameter from the ordered collection of the current
     * object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         template parameter
     * @param templateParameter
     *            the template parameter to be removed
     * @throws IllegalArgumentException
     *             if <code>templateParameter</code> is null
     */
    public boolean removeTemplateParameter(TemplateParameter templateParameter) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "template parameter" from the ordered
     * collection of the current object.
     * </p>
     */
    public void clearTemplateParameters() {
    }

    /**
     * Mock method.
     *
     * @return
     */
    public List<TemplateParameter> getTemplateParameters() {
        return this.templateParameters;
    }

    /**
     * Mock method.
     *
     * @return
     * @param templateParameter
     */
    public boolean containsTemplateParameter(TemplateParameter templateParameter) {
        return this.templateParameters.contains(templateParameter);
    }

    /**
     * <p>
     * Gets the index of the specified template parameter in the ordered
     * collection of the current object, or -1 if such a collection doesn't
     * contain it.
     * </p>
     *
     * @return the index of the specified <code>TemplateParameter</code> in
     *         the ordered collection of the current object, or -1 if such a
     *         collection doesn't contain it.
     * @param templateParameter
     * @throws IllegalArgumentException
     *             if <code>templateParameter</code> is null
     */
    public int indexOfTemplateParameter(TemplateParameter templateParameter) {
        return 0;
    }

    /**
     * <p>
     * Returns the number of objects of type "template parameter" previously
     * added to the ordered collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>TemplateParameter</code>
     *         inserted in the ordered collection of the current object
     */
    public int countTemplateParameters() {
        return 0;
    }

    /**
     * Mock method.
     *
     * @param templateArgument
     */
    public void addTemplateArgument(TemplateArgument templateArgument) {
        this.templateArguments.add(templateArgument);
    }

    /**
     * <p>
     * Removes a template argument from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         template argument
     * @param templateArgument
     *            the template argument to be removed
     * @throws IllegalArgumentException
     *             if <code>templateArgument</code> is null
     */
    public boolean removeTemplateArgument(TemplateArgument templateArgument) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "template argument" from the collection
     * of the current object.
     * </p>
     */
    public void clearTemplateArguments() {
    }

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<TemplateArgument> getTemplateArguments() {
        return this.templateArguments;
    }

    /**
     * Mock method.
     *
     * @return
     * @param templateArgument
     */
    public boolean containsTemplateArgument(TemplateArgument templateArgument) {
        return this.templateArguments.contains(templateArgument);
    }

    /**
     * <p>
     * Returns the number of objects of type "template argument" previously
     * added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>TemplateArgument</code>
     *         inserted in the collection of the current object
     */
    public int countTemplateArguments() {
        return 0;
    }

    /**
     * Mock method.
     *
     * @param elementImport
     */
    public void addElementImport(ElementImport elementImport) {
        this.elementImports.add(elementImport);
    }

    /**
     * <p>
     * Removes a element import from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         element import
     * @param elementImport
     *            the element import to be removed
     * @throws IllegalArgumentException
     *             if <code>elementImport</code> is null
     */
    public boolean removeElementImport(ElementImport elementImport) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "element import" from the collection of
     * the current object.
     * </p>
     */
    public void clearElementImports() {
    }

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<ElementImport> getElementImports() {
        return this.elementImports;
    }

    /**
     * Mock method.
     *
     * @return
     * @param elementImport
     */
    public boolean containsElementImport(ElementImport elementImport) {
        return this.elementImports.contains(elementImport);
    }

    /**
     * <p>
     * Returns the number of objects of type "element import" previously added
     * to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>ElementImport</code>
     *         inserted in the collection of the current object
     */
    public int countElementImports() {
        return 0;
    }

    /**
     * Mock method.
     *
     * @param behavior
     */
    public void addBehavior(StateMachine behavior) {
        this.behaviors.add(behavior);
    }

    /**
     * <p>
     * Removes a behavior from the collection of the current object.
     * </p>
     *
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         behavior
     * @param behavior
     *            the behavior to be removed
     * @throws IllegalArgumentException
     *             if <code>behavior</code> is null
     */
    public boolean removeBehavior(StateMachine behavior) {
        return false;
    }

    /**
     * <p>
     * Removes all the objects of type "behavior" from the collection of the
     * current object.
     * </p>
     */
    public void clearBehaviors() {
    }

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<StateMachine> getBehaviors() {
        return this.behaviors;
    }

    /**
     * Mock method.
     *
     * @return
     * @param behavior
     */
    public boolean containsBehavior(StateMachine behavior) {
        return this.behaviors.contains(behavior);
    }
}