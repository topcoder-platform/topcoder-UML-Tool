/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * A model element is an element that is an abstraction drawn from the system being modeled. Contrast with view element,
 * which is an element whose purpose is to provide a presentation of information for human comprehension.
 * </p>
 * <p>
 * In the meta model, a ModelElement is a named entity in a Model. It is the base for all modeling meta classes in the
 * UML (even though it is not displayed explicitly as such on diagrams for ElementOwnership, ElementResidence,
 * ElementImport, TemplateParameter, TemplateArgument, and Argument). All other modeling metaclasses are either direct
 * or indirect subclasses of ModelElement.
 * </p>
 * <p>
 * Each ModelElement can be regarded as a template. A template has a set of templateParameters that denotes which of the
 * parts of a ModelElement are the template parameters. A ModelElement is a template when there is at least one template
 * parameter. If it is not a template, a ModelElement cannot have template parameters. However, such embedded parameters
 * are not usually complete and need not satisfy well-formedness rules. It is the arguments supplied when the template
 * is instantiated that must be well formed.
 * </p>
 * <p>
 * Partially instantiated templates are allowed. This is the case when there are arguments provided for some, but not
 * all templateParameters. A partially instantiated template is still a template, since it still has parameters.
 * </p>
 * <p>
 * A ModelElement has the following properties:
 * <ul>
 * <li>name: An identifier for the ModelElement within its containing Namespace. </li>
 * <li>visibility: A VisibilityKind instance referenced by the ModelElement.</li>
 * <li>isSpecification: True if this ModelElement is a specification.</li>
 * <li>stereotypes: An unordered collection of Stereotypes. If a model element is classified by a stereotype, then its
 * children are also classified by the stereotype. They may use the tags defined on the stereotype and they are subject
 * to constraints imposed by the stereotype. </li>
 * <li>taggedValues: An unordered collection of TaggedValues. If a tag is defined to apply to a model element (for
 * example, because it is classified by a stereotype defining the tag), then the tag applies to children of the model
 * element. </li>
 * <li>referenceTags: An unordered collection of TaggedValues owned by the ModelElement.</li>
 * <li>namespace: Designates the Namespace that contains the ModelElement. Every ModelElement except a root element
 * must belong to exactly one Namespace or else be a composite part of another ModelElement (which is a kind of virtual
 * namespace). The pathname of Namespace or ModelElement names starting from the root package provides a unique
 * designation for every ModelElement. The association attribute visibility specifies the visibility of the element
 * outside its namespace (see ElementOwnership). </li>
 * <li>supplierDependencies: Inverse of supplier. Designates a set of Dependency in which the ModelElement is a
 * supplier. </li>
 * <li>clientDependencies: Inverse of client. Designates a set of Dependency in which the ModelElement is a client.
 * </li>
 * <li>comments: An unordered collection of Comments owned by the ModelElement.</li>
 * <li>parameterTemplate: A TemplateParameter instance referenced by the ModelElement.</li>
 * <li>defaultParameters: An unordered collection of TemplateParameter owned by the ModelElement.</li>
 * <li>templateParameters: (association class TemplateParameter) A composite aggregation ordered list of parameters.
 * Each parameter is a dummy ModelElement designated as a placeholder for a real ModelElement to be substituted during a
 * binding of the template (see Binding). The real model element must be of the same kind (or a descendant kind) as the
 * dummy ModelElement. The properties of the dummy ModelElement are ignored, except the name of the dummy element is
 * used as the name of the template parameter. The association class TemplateParameter may be associated with a default
 * ModelElement of the same kind as the dummy ModelElement. In the case of a Binding that does not supply an argument
 * corresponding to the parameter, the value of the default ModelElement is used. If a Binding lacks an argument and
 * there is no default ModelElement, the construct is invalid. Note that the template parameter element lacks structure.
 * For example, a parameter that is a Class lacks Features; they are found in the actual argument. </li>
 * <li>templateArguments: Indicates zero or more TemplateArgument for which the model element is an argument in a
 * template binding. </li>
 * <li>elementImports: An unordered collection of ElementImports owned by the ModelElement.</li>
 * <li>behaviors: An unordered collection of StateMachine owned by the ModelElement.</li>
 * </ul>
 * </p>
 * <p>
 * <b>Thread Safety</b>: Implementations of this interface are not required to be thread-safe, since thread safety
 * should be handled by the application itself.
 * </p>
 *
 * @author Pisky, vividmxx
 * @version 1.0
 */
public interface ModelElement extends Element {
    /**
     * <p>
     * Sets the name of the current object.
     * </p>
     *
     * @param name
     *            the name to be set for this object.
     */
    void setName(String name);

    /**
     * <p>
     * Gets the name of the current object.
     * </p>
     *
     * @return the name of this object.
     */
    String getName();

    /**
     * <p>
     * Sets the visibility of the current object.
     * </p>
     *
     * @param visibility
     *            the visibility to be set for this object.
     */
    void setVisibility(VisibilityKind visibility);

    /**
     * <p>
     * Gets the visibility of the current object.
     * </p>
     *
     * @return the visibility of this object.
     */
    public VisibilityKind getVisibility();

    /**
     * <p>
     * Sets if the current object is specification.
     * </p>
     *
     * @param isSpecification
     *            a boolean value stating if the current object is specification.
     */
    void setSpecification(boolean isSpecification);

    /**
     * <p>
     * Gets a boolean value that is true if the current object is specification.
     * </p>
     *
     * @return <code>true</code> if the current object is specification, otherwise <code>false</code>.
     */
    boolean isSpecification();

    /**
     * <p>
     * Adds a stereo type to the collection of the current object.
     * </p>
     *
     * @param stereotype
     *            the stereo type to be added.
     * @throws IllegalArgumentException
     *             if <code>stereoType</code> is null.
     */
    void addStereotype(Stereotype stereotype);

    /**
     * <p>
     * Removes a stereo type from the collection of the current object.
     * </p>
     *
     * @param stereotype
     *            the stereo type to be removed.
     * @throws IllegalArgumentException
     *             if <code>stereoType</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal, i.e. its collection
     *         contained the specified stereo type.
     */
    boolean removeStereotype(Stereotype stereotype);

    /**
     * <p>
     * Removes all the objects of type "stereo type" from the collection of the current object.
     * </p>
     */
    void clearStereotypes();

    /**
     * <p>
     * Gets all the objects of type "stereo type" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>Stereotype</code> added to the collection of current object.
     */
    Collection<Stereotype> getStereotypes();

    /**
     * <p>
     * Checks if a stereo type is contained in the collection of the current object.
     * </p>
     *
     * @param stereotype
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>stereotype</code> is null.
     * @return <code>true</code> if <code>stereoType</code> is contained in the collection of the current object.
     */
    boolean containsStereotype(Stereotype stereotype);

    /**
     * <p>
     * Returns the number of objects of type "stereo type" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Stereotype</code> inserted in the collection of the current
     *         object.
     */
    int countStereotypes();

    /**
     * <p>
     * Adds a tagged value to the collection of the current object.
     * </p>
     *
     * @param taggedValue
     *            the tagged value to be added.
     * @throws IllegalArgumentException
     *             if <code>taggedValue</code> is null.
     */
    void addTaggedValue(TaggedValue taggedValue);

    /**
     * <p>
     * Removes a tagged value from the collection of the current object.
     * </p>
     *
     * @param taggedValue
     *            the tagged value to be removed.
     * @throws IllegalArgumentException
     *             if <code>taggedValue</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal, i.e. its collection
     *         contained the specified tagged value.
     */
    boolean removeTaggedValue(TaggedValue taggedValue);

    /**
     * <p>
     * Removes all the objects of type "tagged value" from the collection of the current object.
     * </p>
     */
    void clearTaggedValues();

    /**
     * <p>
     * Gets all the objects of type "tagged value" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>TaggedValue</code> added to the collection of current object.
     */
    Collection<TaggedValue> getTaggedValues();

    /**
     * <p>
     * Checks if a tagged value is contained in the collection of the current object.
     * </p>
     *
     * @param taggedValue
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>taggedValue</code> is null.
     * @return <code>true</code> if <code>taggedValue</code> is contained in the collection of the current object.
     */
    boolean containsTaggedValue(TaggedValue taggedValue);

    /**
     * <p>
     * Returns the number of objects of type "tagged value" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>TaggedValue</code> inserted in the collection of the current
     *         object.
     */
    int countTaggedValues();

    /**
     * <p>
     * Adds a reference tag to the collection of the current object.
     * </p>
     *
     * @param referenceTag
     *            the reference tag to be added.
     * @throws IllegalArgumentException
     *             if <code>referenceTag</code> is null.
     */
    void addReferenceTag(TaggedValue referenceTag);

    /**
     * <p>
     * Removes a reference tag from the collection of the current object.
     * </p>
     *
     * @param referenceTag
     *            the reference tag to be removed.
     * @throws IllegalArgumentException
     *             if <code>referenceTag</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    boolean removeReferenceTag(TaggedValue referenceTag);

    /**
     * <p>
     * Removes all the objects of type "reference tag" from the collection of the current object.
     * </p>
     */
    void clearReferenceTags();

    /**
     * <p>
     * Gets all the objects of type "reference tag" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>TaggedValue</code> added to the collection of current object.
     */
    Collection<TaggedValue> getReferenceTags();

    /**
     * <p>
     * Checks if a reference tag is contained in the collection of the current object.
     * </p>
     *
     * @param referenceTag
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>referenceTag</code> is null.
     * @return <code>true</code> if <code>referenceTag</code> is contained in the collection of the current object.
     */
    boolean containsReferenceTag(TaggedValue referenceTag);

    /**
     * <p>
     * Returns the number of objects of type "reference tag" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>TaggedValue</code> inserted in the collection of the current
     *         object.
     */
    int countReferenceTags();

    /**
     * <p>
     * Sets the namespace of the current object.
     * </p>
     *
     * @param namespace
     *            the namespace to be set for this object.
     */
    void setNamespace(Namespace namespace);

    /**
     * <p>
     * Gets the namespace of the current object.
     * </p>
     *
     * @return the namespace of this object.
     */
    Namespace getNamespace();

    /**
     * <p>
     * Adds a supplier dependency to the collection of the current object.
     * </p>
     *
     * @param supplierDependency
     *            the supplier dependency to be added.
     * @throws IllegalArgumentException
     *             if <code>supplierDependency</code> is null.
     */
    void addSupplierDependency(Dependency supplierDependency);

    /**
     * <p>
     * Removes a supplier dependency from the collection of the current object.
     * </p>
     *
     * @param supplierDependency
     *            the supplier dependency to be removed.
     * @throws IllegalArgumentException
     *             if <code>supplierDependency</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    boolean removeSupplierDependency(Dependency supplierDependency);

    /**
     * <p>
     * Removes all the objects of type "supplier dependency" from the collection of the current object.
     * </p>
     */
    void clearSupplierDependencies();

    /**
     * <p>
     * Gets all the objects of type "supplier dependency" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>Dependency</code> added to the collection of current object.
     */
    Collection<Dependency> getSupplierDependencies();

    /**
     * <p>
     * Checks if a supplier dependency is contained in the collection of the current object.
     * </p>
     *
     * @param supplierDependency
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>supplierDependency</code> is null.
     * @return <code>true</code> if <code>supplierDependency</code> is contained in the collection of the current
     *         object.
     */
    boolean containsSupplierDependency(Dependency supplierDependency);

    /**
     * <p>
     * Returns the number of objects of type "supplier dependency" previously added to the collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>Dependency</code> inserted in the collection of the current
     *         object
     */
    int countSupplierDependencies();

    /**
     * <p>
     * Adds a client dependency to the collection of the current object.
     * </p>
     *
     * @param clientDependency
     *            the client dependency to be added.
     * @throws IllegalArgumentException
     *             if <code>clientDependency</code> is null.
     */
    void addClientDependency(Dependency clientDependency);

    /**
     * <p>
     * Removes a client dependency from the collection of the current object.
     * </p>
     *
     * @param clientDependency
     *            the client dependency to be removed.
     * @throws IllegalArgumentException
     *             if <code>clientDependency</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    boolean removeClientDependency(Dependency clientDependency);

    /**
     * <p>
     * Removes all the objects of type "client dependency" from the collection of the current object.
     * </p>
     */
    void clearClientDependencies();

    /**
     * <p>
     * Gets all the objects of type "client dependency" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>Dependency</code> added to the collection of current object.
     */
    Collection<Dependency> getClientDependencies();

    /**
     * <p>
     * Checks if a client dependency is contained in the collection of the current object.
     * </p>
     *
     * @param clientDependency
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>clientDependency</code> is null.
     * @return <code>true</code> if <code>clientDependency</code> is contained in the collection of the current
     *         object.
     */
    boolean containsClientDependency(Dependency clientDependency);

    /**
     * <p>
     * Returns the number of objects of type "client dependency" previously added to the collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>Dependency</code> inserted in the collection of the current
     *         object.
     */
    int countClientDependencies();

    /**
     * <p>
     * Adds a comment to the collection of the current object.
     * </p>
     *
     * @param comment
     *            the comment to be added.
     * @throws IllegalArgumentException
     *             if <code>comment</code> is null.
     */
    void addComment(Comment comment);

    /**
     * <p>
     * Removes a comment from the collection of the current object.
     * </p>
     *
     * @param comment
     *            the comment to be removed.
     * @throws IllegalArgumentException
     *             if <code>comment</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    boolean removeComment(Comment comment);

    /**
     * <p>
     * Removes all the objects of type "comment" from the collection of the current object.
     * </p>
     */
    void clearComments();

    /**
     * <p>
     * Gets all the objects of type "comment" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type <code>Comment</code>
     *         added to the collection of current object.
     */
    Collection<Comment> getComments();

    /**
     * <p>
     * Checks if a comment is contained in the collection of the current object.
     * </p>
     *
     * @param comment
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>comment</code> is null.
     * @return <code>true</code> if <code>comment</code> is contained in the collection of the current object.
     */
    boolean containsComment(Comment comment);

    /**
     * <p>
     * Returns the number of objects of type "comment" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Comment</code> inserted in the collection of the current object..
     */
    int countComments();

    /**
     * <p>
     * Sets the parameter template of the current object.
     * </p>
     *
     * @param parameterTemplate
     *            the parameter template to be set for this object.
     */
    void setParameterTemplate(TemplateParameter parameterTemplate);

    /**
     * <p>
     * Gets the parameter template of the current object.
     * </p>
     *
     * @return the parameter template of this object.
     */
    TemplateParameter getParameterTemplate();

    /**
     * <p>
     * Adds a default parameter to the collection of the current object.
     * </p>
     *
     * @param defaultParameter
     *            the default parameter to be added.
     * @throws IllegalArgumentException
     *             if <code>defaultParameter</code> is null..
     */
    void addDefaultParameter(TemplateParameter defaultParameter);

    /**
     * <p>
     * Removes a default parameter from the collection of the current object.
     * </p>
     *
     * @param defaultParameter
     *            the default parameter to be removed
     * @throws IllegalArgumentException
     *             if <code>defaultParameter</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    boolean removeDefaultParameter(TemplateParameter defaultParameter);

    /**
     * <p>
     * Removes all the objects of type "default parameter" from the collection of the current object.
     * </p>
     */
    void clearDefaultParameters();

    /**
     * <p>
     * Gets all the objects of type "default parameter" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>TemplateParameter</code> added to the collection of current object.
     */
    Collection<TemplateParameter> getDefaultParameters();

    /**
     * <p>
     * Checks if a default parameter is contained in the collection of the current object.
     * </p>
     *
     * @param defaultParameter
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>defaultParameter</code> is null.
     * @return <code>true</code> if <code>defaultParameter</code> is contained in the collection of the current
     *         object.
     */
    boolean containsDefaultParameter(TemplateParameter defaultParameter);

    /**
     * <p>
     * Returns the number of objects of type "default parameter" previously added to the collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>TemplateParameter</code> inserted in the collection of the
     *         current object.
     */
    int countDefaultParameters();

    /**
     * <p>
     * Adds a template parameter at the end of the ordered collection of the current object.
     * </p>
     *
     * @param templateParameter
     *            the template parameter to be added.
     * @throws IllegalArgumentException
     *             if <code>templateParameter</code> is null.
     */
    void addTemplateParameter(TemplateParameter templateParameter);

    /**
     * <p>
     * Adds a template parameter at specified index of the ordered collection of the current object.
     * </p>
     *
     * @param index
     *            the index at which to add
     * @param templateParameter
     *            the template parameter to be added.
     * @throws IllegalArgumentException
     *             if <code>templateParameter</code> is null.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt; 0 or gt; templateParameters.size().
     */
    void addTemplateParameter(int index, TemplateParameter templateParameter);

    /**
     * <p>
     * Sets the template parameter at specified index of the ordered collection of the current object.
     * </p>
     *
     * @param index
     *            index of element to replace.
     * @param templateParameter
     *            the template parameter to be added.
     * @throws IllegalArgumentException
     *             if <code>templateParameter</code> is null.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt; 0 or gt;= templateParameters.size().
     */
    void setTemplateParameter(int index, TemplateParameter templateParameter);

    /**
     * <p>
     * Removes (and fetches) the template parameter at specified index from the ordered collection of the current
     * object.
     * </p>
     *
     * @param index
     *            the index of the template parameter to be removed.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is is &lt; 0 or gt;= templateParameters.size().
     * @return the removed object of type <code>TemplateParameter</code>.
     */
    TemplateParameter removeTemplateParameter(int index);

    /**
     * <p>
     * Removes a template parameter from the ordered collection of the current object.
     * </p>
     *
     * @param templateParameter
     *            the template parameter to be removed.
     * @throws IllegalArgumentException
     *             if <code>templateParameter</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    boolean removeTemplateParameter(TemplateParameter templateParameter);

    /**
     * <p>
     * Removes all the objects of type "template parameter" from the ordered collection of the current object.
     * </p>
     */
    void clearTemplateParameters();

    /**
     * <p>
     * Gets all the objects of type "template parameter" previously added to the ordered collection of the current
     * object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned list do not change the state of current object (i.e.
     * the returned list is a copy of the internal one of the current object). However, if an element contained in it is
     * modified, the state of the current object is modified accordingly (i.e. the internal and the returned lists share
     * references to the same objects).
     * </p>
     *
     * @return a <code>java.util.List</code> instance, containing all the objects of type
     *         <code>TemplateParameter</code> added to the collection of current object.
     */
    List<TemplateParameter> getTemplateParameters();

    /**
     * <p>
     * Checks if a template parameter is contained in the ordered collection of the current object.
     * </p>
     *
     * @param templateParameter
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>templateParameter</code> is null.
     * @return <code>true</code> if <code>templateParameter</code> is contained in the collection of the current
     *         object.
     */
    boolean containsTemplateParameter(TemplateParameter templateParameter);

    /**
     * <p>
     * Gets the index of the specified template parameter in the ordered collection of the current object, or -1 if such
     * a collection doesn't contain it.
     * </p>
     *
     * @param templateParameter
     *            the desired element.
     * @throws IllegalArgumentException
     *             if <code>templateParameter</code> is null.
     * @return the index of the specified <code>TemplateParameter</code> in the ordered collection of the current
     *         object, or -1 if such a collection doesn't contain it.
     */
    int indexOfTemplateParameter(TemplateParameter templateParameter);

    /**
     * <p>
     * Returns the number of objects of type "template parameter" previously added to the ordered collection of the
     * current object.
     * </p>
     *
     * @return the quantity of objects of type <code>TemplateParameter</code> inserted in the ordered collection of
     *         the current object.
     */
    int countTemplateParameters();

    /**
     * <p>
     * Adds a template argument to the collection of the current object.
     * </p>
     *
     * @param templateArgument
     *            the template argument to be added.
     * @throws IllegalArgumentException
     *             if <code>templateArgument</code> is null.
     */
    void addTemplateArgument(TemplateArgument templateArgument);

    /**
     * <p>
     * Removes a template argument from the collection of the current object.
     * </p>
     *
     * @param templateArgument
     *            the template argument to be removed.
     * @throws IllegalArgumentException
     *             if <code>templateArgument</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    boolean removeTemplateArgument(TemplateArgument templateArgument);

    /**
     * <p>
     * Removes all the objects of type "template argument" from the collection of the current object.
     * </p>
     */
    void clearTemplateArguments();

    /**
     * <p>
     * Gets all the objects of type "template argument" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>TemplateArgument</code> added to the collection of current object.
     */
    Collection<TemplateArgument> getTemplateArguments();

    /**
     * <p>
     * Checks if a template argument is contained in the collection of the current object.
     * </p>
     *
     * @param templateArgument
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>templateArgument</code> is null.
     * @return <code>true</code> if <code>templateArgument</code> is contained in the collection of the current
     *         object.
     */
    boolean containsTemplateArgument(TemplateArgument templateArgument);

    /**
     * <p>
     * Returns the number of objects of type "template argument" previously added to the collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>TemplateArgument</code> inserted in the collection of the current
     *         object.
     */
    int countTemplateArguments();

    /**
     * <p>
     * Adds a element import to the collection of the current object.
     * </p>
     *
     * @param elementImport
     *            the element import to be added.
     * @throws IllegalArgumentException
     *             if <code>elementImport</code> is null.
     */
    void addElementImport(ElementImport elementImport);

    /**
     * <p>
     * Removes a element import from the collection of the current object.
     * </p>
     *
     * @param elementImport
     *            the element import to be removed.
     * @throws IllegalArgumentException
     *             if <code>elementImport</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    boolean removeElementImport(ElementImport elementImport);

    /**
     * <p>
     * Removes all the objects of type "element import" from the collection of the current object.
     * </p>
     */
    void clearElementImports();

    /**
     * <p>
     * Gets all the objects of type "element import" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>ElementImport</code> added to the collection of current object.
     */
    Collection<ElementImport> getElementImports();

    /**
     * <p>
     * Checks if a element import is contained in the collection of the current object.
     * </p>
     *
     * @param elementImport
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>elementImport</code> is null.
     * @return <code>true</code> if <code>elementImport</code> is contained in the collection of the current object.
     */
    boolean containsElementImport(ElementImport elementImport);

    /**
     * <p>
     * Returns the number of objects of type "element import" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>ElementImport</code> inserted in the collection of the current
     *         object.
     */
    int countElementImports();

    /**
     * <p>
     * Adds a behavior to the collection of the current object.
     * </p>
     *
     * @param behavior
     *            the behavior to be added.
     * @throws IllegalArgumentException
     *             if <code>behavior</code> is null.
     */
    void addBehavior(StateMachine behavior);

    /**
     * <p>
     * Removes a behavior from the collection of the current object.
     * </p>
     *
     * @param behavior
     *            the behavior to be removed.
     * @throws IllegalArgumentException
     *             if <code>behavior</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    boolean removeBehavior(StateMachine behavior);

    /**
     * <p>
     * Removes all the objects of type "behavior" from the collection of the current object.
     * </p>
     */
    void clearBehaviors();

    /**
     * <p>
     * Gets all the objects of type "behavior" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>StateMachine</code> added to the collection of current object.
     */
    Collection<StateMachine> getBehaviors();

    /**
     * <p>
     * Checks if a behavior is contained in the collection of the current object.
     * </p>
     *
     * @param behavior
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>behavior</code> is null.
     * @return <code>true</code> if <code>behavior</code> is contained in the collection of the current object.
     */
    boolean containsBehavior(StateMachine behavior);

    /**
     * <p>
     * Returns the number of objects of type "behavior" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>StateMachine</code> inserted in the collection of the current
     *         object
     */
    int countBehaviors();
}
