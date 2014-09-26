/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.statemachines.StateMachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.LinkedList;

/**
 * <p>
 * This abstract class is a default implementation of the <code>ModelElement</code> interface.
 * </p>
 * <p>
 * The non-collection attributes described by the interface are implemented by simple references to objects, that are
 * set to <code>null</code> by default; the unordered collection attributes are implemented with instances of
 * <code>ArrayList</code>, while the ordered collection attributes are implemented with instances of
 * <code>LinkedList</code>.
 * </p>
 * <p>
 * The non-collection attributes can be set to every reference of the correct type, either <code>null</code> or
 * non-null (and the String attributes can be set to the empty string); the collection attributes can't obviously be
 * <code>null</code>, since they are set during instantiation and can't be changed. Anyway, they can't contain
 * <code>null</code> references while they can contain duplicate entries.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread-safe, since thread safety should be handled by the application
 * itself.
 * </p>
 *
 * @author Pisky, vividmxx
 * @version 1.0
 */
public abstract class ModelElementAbstractImpl extends ElementAbstractImpl implements ModelElement {

    /**
     * <p>
     * An identifier for the ModelElement within its containing Namespace.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private String name;

    /**
     * <p>
     * A VisibilityKind instance referenced by the ModelElement.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private VisibilityKind visibility;

    /**
     * <p>
     * True if this ModelElement is a specification.
     * </p>
     * <p>
     * This value is initially left set to false; after construction, it can be set to either true or false through the
     * appropriate setter.
     * </p>
     */
    private boolean isSpecification;

    /**
     * <p>
     * An unordered collection of Stereotypes. If a model element is classified by a stereotype, then its children are
     * also classified by the stereotype.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<Stereotype> stereotypes;

    /**
     * <p>
     * An unordered collection of TaggedValues.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<TaggedValue> taggedValues;

    /**
     * <p>
     * An unordered collection of TaggedValues owned by the ModelElement.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<TaggedValue> referenceTags;

    /**
     * <p>
     * Designates the Namespace that contains the ModelElement.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private Namespace namespace;

    /**
     * <p>
     * Inverse of supplier. Designates a set of Dependency in which the ModelElement is a supplier.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<Dependency> supplierDependencies;

    /**
     * <p>
     * Inverse of client. Designates a set of Dependency in which the ModelElement is a client.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<Dependency> clientDependencies;

    /**
     * <p>
     * An unordered collection of Comments owned by the ModelElement.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<Comment> comments;

    /**
     * <p>
     * A TemplateParameter instance referenced by the ModelElement.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private TemplateParameter parameterTemplate;

    /**
     * <p>
     * An unordered collection of TemplateParameter owned by the ModelElement.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction.The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<TemplateParameter> defaultParameters;

    /**
     * <p>
     * A composite aggregation ordered list of parameters.
     * </p>
     * <p>
     * This ordered collection is instantiated as an empty <code>LinkedList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it, except
     * for null values; duplicated entries are allowed.
     * </p>
     */
    private final List<TemplateParameter> templateParameters;

    /**
     * <p>
     * Indicates zero or more TemplateArgument for which the model element is an argument in a template binding.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction.The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<TemplateArgument> templateArguments;

    /**
     * <p>
     * An unordered collection of ElementImports owned by the ModelElement.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<ElementImport> elementImports;

    /**
     * <p>
     * An unordered collection of StateMachine owned by the ModelElement.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<StateMachine> behaviors;

    /**
     * <p>
     * Constructs a basic instance of this class.
     * </p>
     */
    protected ModelElementAbstractImpl() {
        stereotypes = new ArrayList<Stereotype>();
        taggedValues = new ArrayList<TaggedValue>();
        referenceTags = new ArrayList<TaggedValue>();
        supplierDependencies = new ArrayList<Dependency>();
        clientDependencies = new ArrayList<Dependency>();
        comments = new ArrayList<Comment>();
        defaultParameters = new ArrayList<TemplateParameter>();
        templateParameters = new LinkedList<TemplateParameter>();
        templateArguments = new ArrayList<TemplateArgument>();
        elementImports = new ArrayList<ElementImport>();
        behaviors = new ArrayList<StateMachine>();
    }

    /**
     * <p>
     * Sets the name of the current object.
     * </p>
     *
     * @param name
     *            the name to be set for this object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>
     * Gets the name of the current object.
     * </p>
     *
     * @return the name of this object.
     */
    public String getName() {
        return name;
    }

    /**
     * <p>
     * Sets the visibility of the current object.
     * </p>
     *
     * @param visibility
     *            the visibility to be set for this object.
     */
    public void setVisibility(VisibilityKind visibility) {
        this.visibility = visibility;
    }

    /**
     * <p>
     * Gets the visibility of the current object.
     * </p>
     *
     * @return the visibility of this object.
     */
    public VisibilityKind getVisibility() {
        return visibility;
    }

    /**
     * <p>
     * Sets if the current object is specification.
     * </p>
     *
     * @param isSpecification
     *            a boolean value stating if the current object is specification.
     */
    public void setSpecification(boolean isSpecification) {
        this.isSpecification = isSpecification;
    }

    /**
     * <p>
     * Gets a boolean value that is true if the current object is specification.
     * </p>
     *
     * @return <code>true</code> if the current object is specification, otherwise <code>false</code>.
     */
    public boolean isSpecification() {
        return isSpecification;
    }

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
    public void addStereotype(Stereotype stereotype) {
        if (stereotype == null) {
            throw new IllegalArgumentException("The stereoType to be added can't be null.");
        }
        stereotypes.add(stereotype);
    }

    /**
     * <p>
     * Removes a stereo type from the collection of the current object.
     * </p>
     *
     * @param stereotype
     *            the stereo type to be removed.
     * @throws IllegalArgumentException
     *             if <code>stereoType</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    public boolean removeStereotype(Stereotype stereotype) {
        if (stereotype == null) {
            throw new IllegalArgumentException("The stereoType to be removed can't be null.");
        }
        return stereotypes.remove(stereotype);
    }

    /**
     * <p>
     * Removes all the objects of type "stereo type" from the collection of the current object.
     * </p>
     */
    public void clearStereotypes() {
        stereotypes.clear();
    }

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
    public Collection<Stereotype> getStereotypes() {
        return new ArrayList<Stereotype>(stereotypes);
    }

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
    public boolean containsStereotype(Stereotype stereotype) {
        if (stereotype == null) {
            throw new IllegalArgumentException("The stereotype to be tested can't be null.");
        }
        return stereotypes.contains(stereotype);
    }

    /**
     * <p>
     * Returns the number of objects of type "stereo type" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Stereotype</code> inserted in the collection of the current
     *         object.
     */
    public int countStereotypes() {
        return stereotypes.size();
    }

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
    public void addTaggedValue(TaggedValue taggedValue) {
        if (taggedValue == null) {
            throw new IllegalArgumentException("The taggedValue to be added can't be null.");
        }
        taggedValues.add(taggedValue);
    }

    /**
     * <p>
     * Removes a tagged value from the collection of the current object.
     * </p>
     *
     * @param taggedValue
     *            the tagged value to be removed.
     * @throws IllegalArgumentException
     *             if <code>taggedValue</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    public boolean removeTaggedValue(TaggedValue taggedValue) {
        if (taggedValue == null) {
            throw new IllegalArgumentException("The taggedValue to be removed can't be null.");
        }
        return taggedValues.remove(taggedValue);
    }

    /**
     * <p>
     * Removes all the objects of type "tagged value" from the collection of the current object.
     * </p>
     */
    public void clearTaggedValues() {
        taggedValues.clear();
    }

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
    public Collection<TaggedValue> getTaggedValues() {
        return new ArrayList<TaggedValue>(taggedValues);
    }

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
    public boolean containsTaggedValue(TaggedValue taggedValue) {
        if (taggedValue == null) {
            throw new IllegalArgumentException("The taggedValue to be tested can't be null.");
        }
        return taggedValues.contains(taggedValue);
    }

    /**
     * <p>
     * Returns the number of objects of type "tagged value" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>TaggedValue</code> inserted in the collection of the current
     *         object.
     */
    public int countTaggedValues() {
        return taggedValues.size();
    }

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
    public void addReferenceTag(TaggedValue referenceTag) {
        if (referenceTag == null) {
            throw new IllegalArgumentException("The referenceTag to be added can't be null.");
        }
        referenceTags.add(referenceTag);
    }

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
    public boolean removeReferenceTag(TaggedValue referenceTag) {
        if (referenceTag == null) {
            throw new IllegalArgumentException("The referenceTag to be removed can't be null.");
        }
        return referenceTags.remove(referenceTag);
    }

    /**
     * <p>
     * Removes all the objects of type "reference tag" from the collection of the current object.
     * </p>
     */
    public void clearReferenceTags() {
        referenceTags.clear();
    }

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
    public Collection<TaggedValue> getReferenceTags() {
        return new ArrayList<TaggedValue>(referenceTags);
    }

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
    public boolean containsReferenceTag(TaggedValue referenceTag) {
        if (referenceTag == null) {
            throw new IllegalArgumentException("The referenceTag to be tested can't be null.");
        }
        return referenceTags.contains(referenceTag);
    }

    /**
     * <p>
     * Returns the number of objects of type "reference tag" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>TaggedValue</code> inserted in the collection of the current
     *         object.
     */
    public int countReferenceTags() {
        return referenceTags.size();
    }

    /**
     * <p>
     * Sets the namespace of the current object.
     * </p>
     *
     * @param namespace
     *            the namespace to be set for this object.
     */
    public void setNamespace(Namespace namespace) {
        this.namespace = namespace;
    }

    /**
     * <p>
     * Gets the namespace of the current object.
     * </p>
     *
     * @return the namespace of this object.
     */
    public Namespace getNamespace() {
        return namespace;
    }

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
    public void addSupplierDependency(Dependency supplierDependency) {
        if (supplierDependency == null) {
            throw new IllegalArgumentException("The supplierDependency to be added can't be null.");
        }
        supplierDependencies.add(supplierDependency);
    }

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
    public boolean removeSupplierDependency(Dependency supplierDependency) {
        if (supplierDependency == null) {
            throw new IllegalArgumentException("The supplierDependency to be removed can't be null.");
        }
        return supplierDependencies.remove(supplierDependency);
    }

    /**
     * <p>
     * Removes all the objects of type "supplier dependency" from the collection of the current object.
     * </p>
     */
    public void clearSupplierDependencies() {
        supplierDependencies.clear();
    }

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
    public Collection<Dependency> getSupplierDependencies() {
        return new ArrayList<Dependency>(supplierDependencies);
    }

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
    public boolean containsSupplierDependency(Dependency supplierDependency) {
        if (supplierDependency == null) {
            throw new IllegalArgumentException("The supplierDependency to be tested can't be null.");
        }
        return supplierDependencies.contains(supplierDependency);
    }

    /**
     * <p>
     * Returns the number of objects of type "supplier dependency" previously added to the collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>Dependency</code> inserted in the collection of the current
     *         object
     */
    public int countSupplierDependencies() {
        return supplierDependencies.size();
    }

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
    public void addClientDependency(Dependency clientDependency) {
        if (clientDependency == null) {
            throw new IllegalArgumentException("The clientDependency to be added can't be null.");
        }
        clientDependencies.add(clientDependency);
    }

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
    public boolean removeClientDependency(Dependency clientDependency) {
        if (clientDependency == null) {
            throw new IllegalArgumentException("The clientDependency to be removed can't be null.");
        }
        return clientDependencies.remove(clientDependency);
    }

    /**
     * <p>
     * Removes all the objects of type "client dependency" from the collection of the current object.
     * </p>
     */
    public void clearClientDependencies() {
        clientDependencies.clear();
    }

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
    public Collection<Dependency> getClientDependencies() {
        return new ArrayList<Dependency>(clientDependencies);
    }

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
    public boolean containsClientDependency(Dependency clientDependency) {
        if (clientDependency == null) {
            throw new IllegalArgumentException("The clientDependency to be tested can't be null.");
        }
        return clientDependencies.contains(clientDependency);
    }

    /**
     * <p>
     * Returns the number of objects of type "client dependency" previously added to the collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>Dependency</code> inserted in the collection of the current
     *         object.
     */
    public int countClientDependencies() {
        return clientDependencies.size();
    }

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
    public void addComment(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("The comment to be added can't be null.");
        }
        comments.add(comment);
    }

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
    public boolean removeComment(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("The comment to be removed can't be null.");
        }
        return comments.remove(comment);
    }

    /**
     * <p>
     * Removes all the objects of type "comment" from the collection of the current object.
     * </p>
     */
    public void clearComments() {
        comments.clear();
    }

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
    public Collection<Comment> getComments() {
        return new ArrayList<Comment>(comments);
    }

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
    public boolean containsComment(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("The comment to be tested can't be null.");
        }
        return comments.contains(comment);
    }

    /**
     * <p>
     * Returns the number of objects of type "comment" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Comment</code> inserted in the collection of the current object.
     */
    public int countComments() {
        return comments.size();
    }

    /**
     * <p>
     * Sets the parameter template of the current object.
     * </p>
     *
     * @param parameterTemplate
     *            the parameter template to be set for this object.
     */
    public void setParameterTemplate(TemplateParameter parameterTemplate) {
        this.parameterTemplate = parameterTemplate;
    }

    /**
     * <p>
     * Gets the parameter template of the current object.
     * </p>
     *
     * @return the parameter template of this object.
     */
    public TemplateParameter getParameterTemplate() {
        return parameterTemplate;
    }

    /**
     * <p>
     * Adds a default parameter to the collection of the current object.
     * </p>
     *
     * @param defaultParameter
     *            the default parameter to be added.
     * @throws IllegalArgumentException
     *             if <code>defaultParameter</code> is null.
     */
    public void addDefaultParameter(TemplateParameter defaultParameter) {
        if (defaultParameter == null) {
            throw new IllegalArgumentException("The defaultParameter to be added can't be null.");
        }
        defaultParameters.add(defaultParameter);
    }

    /**
     * <p>
     * Removes a default parameter from the collection of the current object.
     * </p>
     *
     * @param defaultParameter
     *            the default parameter to be removed.
     * @throws IllegalArgumentException
     *             if <code>defaultParameter</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    public boolean removeDefaultParameter(TemplateParameter defaultParameter) {
        if (defaultParameter == null) {
            throw new IllegalArgumentException("The defaultParameter to be removed can't be null.");
        }
        return defaultParameters.remove(defaultParameter);
    }

    /**
     * <p>
     * Removes all the objects of type "default parameter" from the collection of the current object.
     * </p>
     */
    public void clearDefaultParameters() {
        defaultParameters.clear();
    }

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
    public Collection<TemplateParameter> getDefaultParameters() {
        return new ArrayList<TemplateParameter>(defaultParameters);
    }

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
    public boolean containsDefaultParameter(TemplateParameter defaultParameter) {
        if (defaultParameter == null) {
            throw new IllegalArgumentException("The defaultParameter to be tested can't be null.");
        }
        return defaultParameters.contains(defaultParameter);
    }

    /**
     * <p>
     * Returns the number of objects of type "default parameter" previously added to the collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>TemplateParameter</code> inserted in the collection of the
     *         current object.
     */
    public int countDefaultParameters() {
        return defaultParameters.size();
    }

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
    public void addTemplateParameter(TemplateParameter templateParameter) {
        if (templateParameter == null) {
            throw new IllegalArgumentException("The templateParameter to be added can't be null.");
        }
        templateParameters.add(templateParameter);
    }

    /**
     * <p>
     * Adds a template parameter at specified index of the ordered collection of the current object.
     * </p>
     *
     * @param index
     *            index of element to added.
     * @param templateParameter
     *            the template parameter to be added.
     * @throws IllegalArgumentException
     *             if <code>templateParameter</code> is null.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt; 0 or &gt; templateParameters.size().
     */
    public void addTemplateParameter(int index, TemplateParameter templateParameter) {
        if (templateParameter == null) {
            throw new IllegalArgumentException("The templateParameter to be added can't be null.");
        }
        templateParameters.add(index, templateParameter);
    }

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
     *             if <code>index</code> is &lt; 0 or &gt; templateParameters.size().
     */
    public void setTemplateParameter(int index, TemplateParameter templateParameter) {
        if (templateParameter == null) {
            throw new IllegalArgumentException("The templateParameter to set can't be null.");
        }
        templateParameters.set(index, templateParameter);
    }

    /**
     * <p>
     * Removes (and fetches) the template parameter at specified index from the ordered collection of the current
     * object.
     * </p>
     *
     * @param index
     *            the index of the template parameter to be removed.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt; 0 or &gt;= templateParameters.size().
     * @return the removed object of type <code>TemplateParameter</code>.
     */
    public TemplateParameter removeTemplateParameter(int index) {
        return templateParameters.remove(index);
    }

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
    public boolean removeTemplateParameter(TemplateParameter templateParameter) {
        if (templateParameter == null) {
            throw new IllegalArgumentException("The templateParameter to be removed can't be null.");
        }
        return templateParameters.remove(templateParameter);
    }

    /**
     * <p>
     * Removes all the objects of type "template parameter" from the ordered collection of the current object.
     * </p>
     */
    public void clearTemplateParameters() {
        templateParameters.clear();
    }

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
    public List<TemplateParameter> getTemplateParameters() {
        return new LinkedList<TemplateParameter>(templateParameters);
    }

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
    public boolean containsTemplateParameter(TemplateParameter templateParameter) {
        if (templateParameter == null) {
            throw new IllegalArgumentException("The templateParameter to check can't be null.");
        }
        return templateParameters.contains(templateParameter);
    }

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
    public int indexOfTemplateParameter(TemplateParameter templateParameter) {
        if (templateParameter == null) {
            throw new IllegalArgumentException("The templateParameter to query can't be null.");
        }
        return templateParameters.indexOf(templateParameter);
    }

    /**
     * <p>
     * Returns the number of objects of type "template parameter" previously added to the ordered collection of the
     * current object.
     * </p>
     *
     * @return the quantity of objects of type <code>TemplateParameter</code> inserted in the ordered collection of
     *         the current object.
     */
    public int countTemplateParameters() {
        return templateParameters.size();
    }

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
    public void addTemplateArgument(TemplateArgument templateArgument) {
        if (templateArgument == null) {
            throw new IllegalArgumentException("The templateArgument to be added can't be null.");
        }
        templateArguments.add(templateArgument);
    }

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
    public boolean removeTemplateArgument(TemplateArgument templateArgument) {
        if (templateArgument == null) {
            throw new IllegalArgumentException("The templateArgument to be removed can't be null.");
        }
        return templateArguments.remove(templateArgument);
    }

    /**
     * <p>
     * Removes all the objects of type "template argument" from the collection of the current object.
     * </p>
     */
    public void clearTemplateArguments() {
        templateArguments.clear();
    }

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
    public Collection<TemplateArgument> getTemplateArguments() {
        return new ArrayList<TemplateArgument>(templateArguments);
    }

    /**
     * <p>
     * Checks if a template argument is contained in the collection of the current object.
     * </p>
     *
     * @param templateArgument
     *            the desired element.
     * @throws IllegalArgumentException
     *             if <code>templateArgument</code> is null.
     * @return <code>true</code> if <code>templateArgument</code> is contained in the collection of the current
     *         object.
     */
    public boolean containsTemplateArgument(TemplateArgument templateArgument) {
        if (templateArgument == null) {
            throw new IllegalArgumentException("The templateArgument to be tested can't be null.");
        }
        return templateArguments.contains(templateArgument);
    }

    /**
     * <p>
     * Returns the number of objects of type "template argument" previously added to the collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>TemplateArgument</code> inserted in the collection of the current
     *         object.
     */
    public int countTemplateArguments() {
        return templateArguments.size();
    }

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
    public void addElementImport(ElementImport elementImport) {
        if (elementImport == null) {
            throw new IllegalArgumentException("The elementImport to be added can't be null.");
        }
        elementImports.add(elementImport);
    }

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
    public boolean removeElementImport(ElementImport elementImport) {
        if (elementImport == null) {
            throw new IllegalArgumentException("The elementImport to be removed can't be null.");
        }
        return elementImports.remove(elementImport);
    }

    /**
     * <p>
     * Removes all the objects of type "element import" from the collection of the current object.
     * </p>
     */
    public void clearElementImports() {
        elementImports.clear();
    }

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
    public Collection<ElementImport> getElementImports() {
        return new ArrayList<ElementImport>(elementImports);
    }

    /**
     * <p>
     * Checks if a element import is contained in the collection of the current object.
     * </p>
     *
     * @param elementImport
     *            the desired element.
     * @throws IllegalArgumentException
     *             if <code>elementImport</code> is null.
     * @return <code>true</code> if <code>elementImport</code> is contained in the collection of the current object.
     */
    public boolean containsElementImport(ElementImport elementImport) {
        if (elementImport == null) {
            throw new IllegalArgumentException("The elementImport to be tested can't be null.");
        }
        return elementImports.contains(elementImport);
    }

    /**
     * <p>
     * Returns the number of objects of type "element import" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>ElementImport</code> inserted in the collection of the current
     *         object.
     */
    public int countElementImports() {
        return elementImports.size();
    }

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
    public void addBehavior(StateMachine behavior) {
        if (behavior == null) {
            throw new IllegalArgumentException("The behavior to be added can't be null.");
        }
        behaviors.add(behavior);
    }

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
    public boolean removeBehavior(StateMachine behavior) {
        if (behavior == null) {
            throw new IllegalArgumentException("The behavior to be removed can't be null.");
        }
        return behaviors.remove(behavior);
    }

    /**
     * <p>
     * Removes all the objects of type "behavior" from the collection of the current object.
     * </p>
     */
    public void clearBehaviors() {
        behaviors.clear();
    }

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
    public Collection<StateMachine> getBehaviors() {
        return new ArrayList<StateMachine>(behaviors);
    }

    /**
     * <p>
     * Checks if a behavior is contained in the collection of the current object.
     * </p>
     *
     * @param behavior
     *            the desired element.
     * @throws IllegalArgumentException
     *             if <code>behavior</code> is null.
     * @return <code>true</code> if <code>behavior</code> is contained in the collection of the current object.
     */
    public boolean containsBehavior(StateMachine behavior) {
        if (behavior == null) {
            throw new IllegalArgumentException("The behavior to be tested can't be null.");
        }
        return behaviors.contains(behavior);
    }

    /**
     * <p>
     * Returns the number of objects of type "behavior" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>StateMachine</code> inserted in the collection of the current
     *         object.
     */
    public int countBehaviors() {
        return behaviors.size();
    }
}
