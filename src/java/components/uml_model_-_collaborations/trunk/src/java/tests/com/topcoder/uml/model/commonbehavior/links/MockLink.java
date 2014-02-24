/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Collaborations Version 1.0
 *
 * @ MockLink.java
 */

package com.topcoder.uml.model.commonbehavior.links;

import java.util.Collection;
import java.util.List;

import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.statemachines.StateMachine;

/**
 * <p>Mocked for test</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 *
 * @author yinzi
 * @version 1.0
 */
public class MockLink implements Link {
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

    // link

    /**
     * Gets the owner field value. Could be null.
     *
     *
     * @return owner field value
     */
    public Instance getOwner(){return null;}

    /**
     * Sets the owner field value. Null is allowed.
     *
     *
     * @param owner owner field value
     */
    public void setOwner(Instance owner){;}

    /**
     * Appends the LinkEnd to the connections list. It allows duplicates. Null values are not allowed.
     * This is equivalent to using addConnection(countConnections(), connection).
     *
     *
     * @param connection The LinkEnd to add to this list
     * @throws IllegalArgumentException if connection is null
     */
    public void addConnection(LinkEnd connection){;}

    /**
     * Adds the LinkEnd at the index position in the connections list. It allows duplicates. Null values
     * are not allowed. Note that adding at index = countConnections() is equivalent to calling
     * addConnection(connection).
     *
     *
     * @param index the position to insert this LinkEnd in this list
     * @param connection The LinkEnd to add to this list
     * @throws IllegalArgumentException if connection is null
     * @throws IndexOutOfBoundsException if index < 0 or index > connections.size()
     */
    public void addConnection(int index, LinkEnd connection){;}

    /**
     * Appends the LinkEnd instance to the connections list. It allows duplicates. Null values are not
     * allowed. This is equivalent to using addConnections(countConnections(), connections).
     *
     *
     * @param connections The LinkEnd collection to add to this list
     * @throws IllegalArgumentException if connections is null or contains null elements.
     */
    public void addConnections(Collection<LinkEnd> connections){;}

    /**
     * Adds the LinkEnd instances at the index position in the contained connections list. It allows
     * duplicates. Null values are not allowed. Note that adding at index = countConnections() is
     * equivalent to calling addConnections(connections).
     *
     *
     * @param index the position to insert this LinkEnd collection in this list
     * @param connections The LinkEnd collection to add to this list
     * @throws IllegalArgumentException if connections is null or contains null elements
     * @throws IndexOutOfBoundsException if index < 0 or index > countQualifiers()
     */
    public void addConnections(int index, Collection<LinkEnd> connections){;}

    /**
     * Sets the LinkEnd at the index position in the connections list. Null values are not allowed.
     *
     *
     * @param index the position to set this LinkEnd in this list
     * @param connection The LinkEnd to set in this list
     * @throws IllegalArgumentException if connection is null
     * @throws IndexOutOfBoundsException if index < 0 or index >= connections.size()
     */
    public void setConnection(int index, LinkEnd connection){;}

    /**
     * Removes the LinkEnd instance at the index position from the connections list.
     *
     *
     * @return LinkEnd The removed LinkEnd
     * @param index the position of the LinkEnd in this list to remove
     * @throws IndexOutOfBoundsException if index < 0 or index >= connections.size()
     */
    public LinkEnd removeConnection(int index){return null;}

    /**
     * Removes the first instance, by reference, of the passed LinkEnd, from the connections list.
     *
     *
     * @return true if the instance was in the list and was successfully removed, false if it was not
     * removed, or did not exist in the list
     * @param connection The LinkEnd to remove from this list
     * @throws IllegalArgumentException if connection is null
     */
    public boolean removeConnection(LinkEnd connection){return false;}

    /**
     * Removes the instances, by reference, of each passed LinkEnd from the contained connections
     * list. It will iterate via the passed collection using its iterator and remove the first instance,
     * by reference, of each passed LinkEnd, from the contained connections list.
     *
     *
     * @return boolean True if the state of the contained connections list has changed, false otherwise.
     * @param connections Collection of LinkEnd instances to remove from the contained list
     * @throws IllegalArgumentException if connections is null or it contains null elements
     */
    public boolean removeConnections(Collection<LinkEnd> connections){return false;}

    /**
     * Removes all elements from the connections list.
     *
     */
    public void clearConnections(){;}

    /**
     * Returns a shallow copy of the connections list.
     *
     *
     * @return shallow copy of the connections list
     */
    public List<LinkEnd> getConnections(){return null;}

    /**
     * Checks if the LinkEnd is contained in the connections list. The check is done by reference.
     *
     *
     * @return true if the LinkEnd is in the list, false otherwise
     * @param connection The LinkEnd to check for its presence in this list
     * @throws IllegalArgumentException if connection is null
     */
    public boolean containsConnection(LinkEnd connection){return false;}

    /**
     * Gets the index of the appearance of the LinkEnd, by reference, in the connections list. It will
     * always return the index of the first instance of the LinkEnd if there are duplicates in the list.
     * It will return -1 if the LinkEnd instance is not in the list.
     *
     *
     * @return the index of the LinkEnd instance in the list, or -1 if not found
     * @param connection LinkEnd instance to look for
     * @throws IllegalArgumentException if argument is null.
     */
    public int indexOfConnection(LinkEnd connection){return 0;}

    /**
     * Returns the size of the connections list.
     *
     *
     * @return the number of elements in the list
     */
    public int countConnections(){return 0;}

    /**
     * Adds the Stimulus into the stimuli collection. It allows duplicates. Null values are not allowed.
     *
     *
     * @param stimulus The Stimulus to add to this collection
     * @throws IllegalArgumentException if stimulus is null
     */
    public void addStimulus(Stimulus stimulus){;}

    /**
     * Adds the Stimulus instances into the stimuli collection. It allows duplicates. The collection must
     * not be null or contain null elements.
     *
     *
     * @param stimuli Collection of Stimulus instances to add to the contained collection
     * @throws IllegalArgumentException if stimuli is null or it contains null elements
     */
    public void addStimuli(Collection<Stimulus> stimuli){;}

    /**
     * Removes the first instance, by reference, of the passed Stimulus, from the stimuli collection.
     * Since this is a collection, this operation does not guarantee which instance of the referenced
     * Stimulus will be removed if there are multiple references to the same instance in the collection.
     *
     *
     * @return true if the instance was in the collection and was successfully removed, false if it was
     * not removed, or did not exist in the collection
     * @param stimulus The Stimulus to remove from this collection
     * @throws IllegalArgumentException if stimulus is null
     */
    public boolean removeStimulus(Stimulus stimulus){return false;}

    /**
     * Removes the instances, by reference, of each passed Stimulus from the contained stimuli
     * collection. Since this is a collection, this operation does not guarantee which instance of the
     * referenced Stimulus will be removed if there are multiple references to the same instance in the
     * collection. This equally applies to the case if there are multiple duplicates in the passed collection.
     *
     *
     * @return boolean True if the state of the contained stimuli collection has changed, false otherwise.
     * @param stimuli Collection of Stimulus instances to remove from the contained collection
     * @throws IllegalArgumentException if stimuli is null or it contains null elements
     */
    public boolean removeStimuli(Collection<Stimulus> stimuli){return false;}

    /**
     * Removes all elements from the stimuli collection.
     *
     */
    public void clearStimuli(){;}

    /**
     * Returns a shallow copy of the stimuli collection.
     *
     *
     * @return shallow copy of the stimuli collection
     */
    public Collection<Stimulus> getStimuli(){return null;}

    /**
     * Checks if the Stimulus is contained in the stimuli collection. The check is done by reference.
     *
     *
     * @return true if the Stimulus is in the collection, false otherwise
     * @param stimulus The Stimulus to check for its presence in this collection
     * @throws IllegalArgumentException if stimulus is null
     */
    public boolean containsStimulus(Stimulus stimulus){return false;}

    /**
     * Returns the size of the stimuli collection.
     *
     *
     * @return the number of elements in the collection
     */
    public int countStimuli(){return 0;}
}
