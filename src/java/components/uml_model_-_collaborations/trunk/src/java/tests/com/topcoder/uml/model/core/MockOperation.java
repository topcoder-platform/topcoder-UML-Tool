/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Collaborations Version 1.0
 *
 * @ MockOperation.java
 */

package com.topcoder.uml.model.core;

import java.util.Collection;
import java.util.List;

import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.statemachines.StateMachine;

/**
 * <p>Mocked for test.</p>
 *
 * @author yinzi
 * @version 1.0
 */
public class MockOperation implements Operation {
    /**
     * <p>
     * Sets the name of the current object.
     * </p>
     *
     * @param name
     *            the name to be set for this object.
     */
    public void setName(String name)
    {
        ;
    }

    /**
     * <p>
     * Gets the name of the current object.
     * </p>
     *
     * @return the name of this object.
     */
    public String getName()
    {
        return null;
    }

    /**
     * <p>
     * Sets the visibility of the current object.
     * </p>
     *
     * @param visibility
     *            the visibility to be set for this object.
     */
    public void setVisibility(VisibilityKind visibility)
    {
       ;
    }

    /**
     * <p>
     * Gets the visibility of the current object.
     * </p>
     *
     * @return the visibility of this object.
     */
    public VisibilityKind getVisibility()
    {
        return null;
    }

    /**
     * <p>
     * Sets if the current object is specification.
     * </p>
     *
     * @param isSpecification
     *            a boolean value stating if the current object is specification.
     */
    public void setSpecification(boolean isSpecification){;}

    /**
     * <p>
     * Gets a boolean value that is true if the current object is specification.
     * </p>
     *
     * @return <code>true</code> if the current object is specification, otherwise <code>false</code>.
     */
    public boolean isSpecification(){return false;}

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
    public void addStereotype(Stereotype stereotype){;}

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
    public boolean removeStereotype(Stereotype stereotype){return false;}

    /**
     * <p>
     * Removes all the objects of type "stereo type" from the collection of the current object.
     * </p>
     */
    public void clearStereotypes(){;}

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
    public Collection<Stereotype> getStereotypes(){return null;}

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
    public boolean containsStereotype(Stereotype stereotype){return false;}

    /**
     * <p>
     * Returns the number of objects of type "stereo type" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Stereotype</code> inserted in the collection of the current
     *         object.
     */
    public int countStereotypes(){return 0;}

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
    public void addTaggedValue(TaggedValue taggedValue){;}

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
    public boolean removeTaggedValue(TaggedValue taggedValue){return false;}

    /**
     * <p>
     * Removes all the objects of type "tagged value" from the collection of the current object.
     * </p>
     */
    public void clearTaggedValues(){;}

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
    public Collection<TaggedValue> getTaggedValues(){return null;}

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
    public boolean containsTaggedValue(TaggedValue taggedValue){return false;}

    /**
     * <p>
     * Returns the number of objects of type "tagged value" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>TaggedValue</code> inserted in the collection of the current
     *         object.
     */
    public int countTaggedValues(){return 0;}

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
    public void addReferenceTag(TaggedValue referenceTag){;}

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
    public boolean removeReferenceTag(TaggedValue referenceTag){return false;}

    /**
     * <p>
     * Removes all the objects of type "reference tag" from the collection of the current object.
     * </p>
     */
    public void clearReferenceTags(){;}

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
    public Collection<TaggedValue> getReferenceTags(){return null;}

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
    public boolean containsReferenceTag(TaggedValue referenceTag){return false;}

    /**
     * <p>
     * Returns the number of objects of type "reference tag" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>TaggedValue</code> inserted in the collection of the current
     *         object.
     */
    public int countReferenceTags(){return 0;}

    /**
     * <p>
     * Sets the namespace of the current object.
     * </p>
     *
     * @param namespace
     *            the namespace to be set for this object.
     */
    public void setNamespace(Namespace namespace){;}

    /**
     * <p>
     * Gets the namespace of the current object.
     * </p>
     *
     * @return the namespace of this object.
     */
    public Namespace getNamespace(){return null;}

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
    public void addSupplierDependency(Dependency supplierDependency){;}

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
    public boolean removeSupplierDependency(Dependency supplierDependency){return false;}

    /**
     * <p>
     * Removes all the objects of type "supplier dependency" from the collection of the current object.
     * </p>
     */
    public void clearSupplierDependencies(){;}

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
    public Collection<Dependency> getSupplierDependencies(){return null;}

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
    public boolean containsSupplierDependency(Dependency supplierDependency){return false;}

    /**
     * <p>
     * Returns the number of objects of type "supplier dependency" previously added to the collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>Dependency</code> inserted in the collection of the current
     *         object
     */
    public int countSupplierDependencies(){return 0;}

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
    public void addClientDependency(Dependency clientDependency){;}

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
    public boolean removeClientDependency(Dependency clientDependency){return false;}

    /**
     * <p>
     * Removes all the objects of type "client dependency" from the collection of the current object.
     * </p>
     */
    public void clearClientDependencies(){;}

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
    public Collection<Dependency> getClientDependencies(){return null;}

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
    public boolean containsClientDependency(Dependency clientDependency){return false;}

    /**
     * <p>
     * Returns the number of objects of type "client dependency" previously added to the collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>Dependency</code> inserted in the collection of the current
     *         object.
     */
    public int countClientDependencies(){return 0;}

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
    public void addComment(Comment comment){;}

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
    public boolean removeComment(Comment comment){return false;}

    /**
     * <p>
     * Removes all the objects of type "comment" from the collection of the current object.
     * </p>
     */
    public void clearComments(){;}

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
    public Collection<Comment> getComments(){return null;}

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
    public boolean containsComment(Comment comment){return false;}

    /**
     * <p>
     * Returns the number of objects of type "comment" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Comment</code> inserted in the collection of the current object..
     */
    public int countComments(){return 0;}

    /**
     * <p>
     * Sets the parameter template of the current object.
     * </p>
     *
     * @param parameterTemplate
     *            the parameter template to be set for this object.
     */
    public void setParameterTemplate(TemplateParameter parameterTemplate){;}

    /**
     * <p>
     * Gets the parameter template of the current object.
     * </p>
     *
     * @return the parameter template of this object.
     */
    public TemplateParameter getParameterTemplate(){return null;}

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
    public void addDefaultParameter(TemplateParameter defaultParameter){;}

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
    public boolean removeDefaultParameter(TemplateParameter defaultParameter){return false;}

    /**
     * <p>
     * Removes all the objects of type "default parameter" from the collection of the current object.
     * </p>
     */
    public void clearDefaultParameters(){;}

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
    public Collection<TemplateParameter> getDefaultParameters(){return null;}

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
    public boolean containsDefaultParameter(TemplateParameter defaultParameter){return false;}

    /**
     * <p>
     * Returns the number of objects of type "default parameter" previously added to the collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>TemplateParameter</code> inserted in the collection of the
     *         current object.
     */
    public int countDefaultParameters(){return 0;}

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
    public void addTemplateParameter(TemplateParameter templateParameter){;}

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
     *             if <code>index</code> is &lt{;} 0 or gt{;} templateParameters.size().
     */
    public void addTemplateParameter(int index, TemplateParameter templateParameter){;}

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
     *             if <code>index</code> is &lt{;} 0 or gt{;}= templateParameters.size().
     */
    public void setTemplateParameter(int index, TemplateParameter templateParameter){;}

    /**
     * <p>
     * Removes (and fetches) the template parameter at specified index from the ordered collection of the current
     * object.
     * </p>
     *
     * @param index
     *            the index of the template parameter to be removed.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is is &lt{;} 0 or gt{;}= templateParameters.size().
     * @return the removed object of type <code>TemplateParameter</code>.
     */
    public TemplateParameter removeTemplateParameter(int index){return null;}

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
    public boolean removeTemplateParameter(TemplateParameter templateParameter){return false;}

    /**
     * <p>
     * Removes all the objects of type "template parameter" from the ordered collection of the current object.
     * </p>
     */
    public void clearTemplateParameters(){;}

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
    public List<TemplateParameter> getTemplateParameters(){return null;}

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
    public boolean containsTemplateParameter(TemplateParameter templateParameter){return false;}

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
    public int indexOfTemplateParameter(TemplateParameter templateParameter){return 0;}

    /**
     * <p>
     * Returns the number of objects of type "template parameter" previously added to the ordered collection of the
     * current object.
     * </p>
     *
     * @return the quantity of objects of type <code>TemplateParameter</code> inserted in the ordered collection of
     *         the current object.
     */
    public int countTemplateParameters(){return 0;}

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
    public void addTemplateArgument(TemplateArgument templateArgument){;}

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
    public boolean removeTemplateArgument(TemplateArgument templateArgument){return false;}

    /**
     * <p>
     * Removes all the objects of type "template argument" from the collection of the current object.
     * </p>
     */
    public void clearTemplateArguments(){;}

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
    public Collection<TemplateArgument> getTemplateArguments(){return null;}

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
    public boolean containsTemplateArgument(TemplateArgument templateArgument){return false;}

    /**
     * <p>
     * Returns the number of objects of type "template argument" previously added to the collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>TemplateArgument</code> inserted in the collection of the current
     *         object.
     */
    public int countTemplateArguments(){return 0;}

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
    public void addElementImport(ElementImport elementImport){;}

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
    public boolean removeElementImport(ElementImport elementImport){return false;}

    /**
     * <p>
     * Removes all the objects of type "element import" from the collection of the current object.
     * </p>
     */
    public void clearElementImports(){;}

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
    public Collection<ElementImport> getElementImports(){return null;}

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
    public boolean containsElementImport(ElementImport elementImport){return false;}

    /**
     * <p>
     * Returns the number of objects of type "element import" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>ElementImport</code> inserted in the collection of the current
     *         object.
     */
    public int countElementImports(){return 0;}

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
    public void addBehavior(StateMachine behavior){;}

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
    public boolean removeBehavior(StateMachine behavior){return false;}

    /**
     * <p>
     * Removes all the objects of type "behavior" from the collection of the current object.
     * </p>
     */
    public void clearBehaviors(){;}

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
    public Collection<StateMachine> getBehaviors(){return null;}

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
    public boolean containsBehavior(StateMachine behavior){return false;}

    /**
     * <p>
     * Returns the number of objects of type "behavior" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>StateMachine</code> inserted in the collection of the current
     *         object
     */
    public int countBehaviors(){return 0;}
    //operation
    /**
     * <p>
     * Sets the concurrency of the current object.
     * </p>
     *
     * @param concurrency
     *            the concurrency to be set for this object.
     */
    public void setConcurrency(CallConcurrencyKind concurrency){;}

    /**
     * <p>
     * Gets the concurrency of the current object.
     * </p>
     *
     * @return the concurrency of this object.
     */
    public CallConcurrencyKind getConcurrency(){return null;}

    /**
     * <p>
     * Sets if the current object is root.
     * </p>
     *
     * @param isRoot
     *            a boolean value stating if the current object is root.
     */
    public void setRoot(boolean isRoot){;}

    /**
     * <p>
     * Gets a boolean value that is true if the current object is root.
     * </p>
     *
     * @return <code>true</code> if the current object is root, otherwise <code>false</code>.
     */
    public boolean isRoot(){return false;}

    /**
     * <p>
     * Sets if the current object is leaf.
     * </p>
     *
     * @param isLeaf
     *            a boolean value stating if the current object is leaf.
     */
    public void setLeaf(boolean isLeaf){;}

    /**
     * <p>
     * Gets a boolean value that is true if the current object is leaf.
     * </p>
     *
     * @return <code>true</code> if the current object is leaf, otherwise <code>false</code>.
     */
    public boolean isLeaf(){return false;}

    /**
     * <p>
     * Sets if the current object is abstract.
     * </p>
     *
     * @param isAbstract
     *            a boolean value stating if the current object is abstract.
     */
    public void setAbstract(boolean isAbstract){;}

    /**
     * <p>
     * Gets a boolean value that is true if the current object is abstract.
     * </p>
     *
     * @return <code>true</code> if the current object is abstract, otherwise <code>false</code>
     */
    public boolean isAbstract(){return false;}

    /**
     * <p>
     * Sets the specification of the current object.
     * </p>
     *
     * @param specification
     *            the specification to be set for this object.
     */
    public void setSpecification(String specification){;}

    /**
     * <p>
     * Gets the specification of the current object.
     * </p>
     *
     * @return the specification of this object.
     */
    public String getSpecification(){return null;}

    /**
     * <p>
     * Adds a method to the collection of the current object.
     * </p>
     *
     * @param method
     *            the method to be added.
     * @throws IllegalArgumentException
     *             if <code>method</code> is null.
     */
    public void addMethod(Method method){;}

    /**
     * <p>
     * Removes a method from the collection of the current object.
     * </p>
     *
     * @param method
     *            the method to be removed.
     * @throws IllegalArgumentException
     *             if <code>method</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    public boolean removeMethod(Method method){return false;}

    /**
     * <p>
     * Removes all the objects of type "method" from the collection of the current object.
     * </p>
     */
    public void clearMethods(){;}

    /**
     * <p>
     * Gets all the objects of type "method" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type <code>Method</code>
     *         added to the collection of current object.
     */
    public Collection<Method> getMethods(){return null;}

    /**
     * <p>
     * Checks if a method is contained in the collection of the current object.
     * </p>
     *
     * @param method
     *            the method to be tested.
     * @throws IllegalArgumentException
     *             if <code>method</code> is null.
     * @return <code>true</code> if <code>method</code> is contained in the collection of the current object.
     */
    public boolean containsMethod(Method method){return false;}

    /**
     * <p>
     * Returns the number of objects of type "method" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Method</code> inserted in the collection of the current object.
     */
    public int countMethods(){return 0;}

    /**
     * <p>
     * Sets if the current object is query.
     * </p>
     *
     * @param isQuery
     *            a boolean value stating if the current object is query.
     */
    public void setQuery(boolean isQuery){;}

    /**
     * <p>
     * Gets a boolean value that is true if the current object is query.
     * </p>
     *
     * @return <code>true</code> if the current object is query, otherwise <code>false</code>.
     */
    public boolean isQuery(){return false;}

    /**
     * <p>
     * Adds a parameter at the end of the ordered collection of the current object.
     * </p>
     *
     * @param parameter
     *            the parameter to be added.
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null.
     */
    public void addParameter(Parameter parameter){;}

    /**
     * <p>
     * Adds a parameter at specified index of the ordered collection of the current object.
     * </p>
     *
     * @param index
     *            index at which the parameter is to be added.
     * @param parameter
     *            the parameter to be added.
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt{;} 0 or &gt{;} parameters.size.
     */
    public void addParameter(int index, Parameter parameter){;}

    /**
     * <p>
     * Sets the parameter at specified index of the ordered collection of the current object.
     * </p>
     *
     * @param index
     *            index at which the parameter is to be set.
     * @param parameter
     *            the parameter to be added.
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt{;} 0 or &gt{;}= parameters.size.
     */
    public void setParameter(int index, Parameter parameter){;}

    /**
     * <p>
     * Removes (and fetches) the parameter at specified index from the ordered collection of the current object.
     * </p>
     *
     * @param index
     *            the index of the parameter to be removed.
     * @throws IndexOutOfBoundsException
     *             if <code>index</code> is &lt{;} 0 or &gt{;}= parameters.size.
     * @return the removed object of type <code>Parameter</code>.
     */
    public Parameter removeParameter(int index){return null;}

    /**
     * <p>
     * Removes a parameter from the ordered collection of the current object.
     * </p>
     *
     * @param parameter
     *            the parameter to be removed.
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    public boolean removeParameter(Parameter parameter){return false;}

    /**
     * <p>
     * Removes all the objects of type "parameter" from the ordered collection of the current object.
     * </p>
     */
    public void clearParameters(){;}

    /**
     * <p>
     * Gets all the objects of type "parameter" previously added to the ordered collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned list do not change the state of current object (i.e.
     * the returned list is a copy of the internal one of the current object). However, if an element contained in it is
     * modified, the state of the current object is modified accordingly (i.e. the internal and the returned lists share
     * references to the same objects).
     * </p>
     *
     * @return a <code>java.util.List</code> instance, containing all the objects of type <code>Parameter</code>
     *         added to the collection of current object.
     */
    public List<Parameter> getParameters(){return null;}

    /**
     * <p>
     * Checks if a parameter is contained in the ordered collection of the current object.
     * </p>
     *
     * @param parameter
     *            element whose presence in this List is to be tested.
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null.
     * @return <code>true</code> if <code>parameter</code> is contained in the collection of the current object.
     */
    public boolean containsParameter(Parameter parameter){return false;}

    /**
     * <p>
     * Gets the index of the specified template parameter in the ordered collection of the current object, or -1 if such
     * a collection doesn't contain it.
     * </p>
     *
     * @param parameter
     *            the search object.
     * @throws IllegalArgumentException
     *             if <code>parameter</code> is null.
     * @return the index of the specified <code>Parameter</code> in the ordered collection of the current object, or
     *         -1 if such a collection doesn't contain it.
     */
    public int indexOfParameter(Parameter parameter){return 0;}

    /**
     * <p>
     * Returns the number of objects of type "parameter" previously added to the ordered collection of the current
     * object.
     * </p>
     *
     * @return the quantity of objects of type <code>Parameter</code> inserted in the ordered collection of the
     *         current object.
     */
    public int countParameters(){return 0;}
    /**
     * <p>
     * Sets the owner of the current object.
     * </p>
     *
     * @param owner
     *            the owner to be set for this object.
     */
    public void setOwner(Classifier owner){;}

    /**
     * <p>
     * Gets the owner of the current object.
     * </p>
     *
     * @return the owner of this object.
     */
    public Classifier getOwner(){return null;}

    /**
     * <p>
     * Sets the owner scope of the current object.
     * </p>
     *
     * @param ownerScope
     *            the owner scope to be set for this object.
     */
    public void setOwnerScope(ScopeKind ownerScope){;}

    /**
     * <p>
     * Gets the owner scope of the current object.
     * </p>
     *
     * @return the owner scope of this object.
     */
    public ScopeKind getOwnerScope(){return null;}
}
