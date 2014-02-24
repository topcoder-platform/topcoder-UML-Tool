/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core;

import java.util.*;

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
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public interface ModelElement extends Element {

    /**
     * Mock method.
     *
     * @param name
     */
    public void setName(String name);

    /**
     * Mock method.
     *
     * @return
     */
    public String getName();

    /**
     * Mock method.
     *
     * @param visibility
     */
    public void setVisibility(VisibilityKind visibility);

    /**
     * Mock method.
     *
     * @return
     */
    public VisibilityKind getVisibility();

    /**
     * Mock method.
     *
     * @param isSpecification
     */
    public void setSpecification(boolean isSpecification);

    /**
     * Mock method.
     *
     * @return
     */
    public boolean isSpecification();

    /**
     * Mock method.
     *
     * @param stereoType
     */
    public void addStereoType(Stereotype stereoType);

    /**
     * Mock method.
     *
     * @param stereoType
     * @return
     */
    public boolean removeStereoType(Stereotype stereoType);

    /**
     * Mock method.
     */
    public void clearStereoTypes();

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<Stereotype> getStereoTypes();

    /**
     * Mock method.
     *
     * @param stereoType
     * @return
     */
    public boolean containsStereoType(Stereotype stereoType);

    /**
     * Mock method.
     *
     * @return
     */
    public int countStereoTypes();

    /**
     * Mock method.
     *
     * @param taggedValue
     */
    public void addTaggedValue(TaggedValue taggedValue);

    /**
     * Mock method.
     *
     * @param taggedValue
     * @return
     */
    public boolean removeTaggedValue(TaggedValue taggedValue);

    /**
     * Mock method.
     */
    public void clearTaggedValues();

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<TaggedValue> getTaggedValues();

    /**
     * Mock method.
     *
     * @param taggedValue
     * @return
     */
    public boolean containsTaggedValue(TaggedValue taggedValue);

    /**
     * Mock method.
     *
     * @return
     */
    public int countTaggedValues();

    /**
     * Mock method.
     *
     * @param referenceTag
     */
    public void addReferenceTag(TaggedValue referenceTag);

    /**
     * Mock method.
     *
     * @param referenceTag
     * @return
     */
    public boolean removeReferenceTag(TaggedValue referenceTag);

    /**
     * Mock method.
     */
    public void clearReferenceTags();

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<TaggedValue> getReferenceTags();

    /**
     * Mock method.
     *
     * @param referenceTag
     * @return
     */
    public boolean containsReferenceTag(TaggedValue referenceTag);

    /**
     * Mock method.
     *
     * @return
     */
    public int countReferenceTags();

    /**
     * Mock method.
     *
     * @param namespace
     */
    public void setNamespace(Namespace namespace);

    /**
     * Mock method.
     *
     * @return
     */
    public Namespace getNamespace();

    /**
     * Mock method.
     *
     * @param supplierDependency
     */
    public void addSupplierDependency(Dependency supplierDependency);

    /**
     * Mock method.
     *
     * @param supplierDependency
     * @return
     */
    public boolean removeSupplierDependency(Dependency supplierDependency);

    /**
     * Mock method.
     */
    public void clearSupplierDependencies();

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<Dependency> getSupplierDependencies();

    /**
     * Mock method.
     *
     * @param supplierDependency
     * @return
     */
    public boolean containsSupplierDependency(Dependency supplierDependency);

    /**
     * Mock method.
     *
     * @return
     */
    public int countSupplierDependencies();

    /**
     * Mock method.
     *
     * @param clientDependency
     */
    public void addClientDependency(Dependency clientDependency);

    /**
     * Mock method.
     *
     * @param clientDependency
     * @return
     */
    public boolean removeClientDependency(Dependency clientDependency);

    /**
     * Mock method.
     */
    public void clearClientDependencies();

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<Dependency> getClientDependencies();

    /**
     * Mock method.
     *
     * @param clientDependency
     * @return
     */
    public boolean containsClientDependency(Dependency clientDependency);

    /**
     * Mock method.
     *
     * @return
     */
    public int countClientDependencies();

    /**
     * Mock method.
     *
     * @param comment
     */
    public void addComment(Comment comment);

    /**
     * Mock method.
     *
     * @param comment
     * @return
     */
    public boolean removeComment(Comment comment);

    /**
     * Mock method.
     */
    public void clearComments();

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<Comment> getComments();

    /**
     * Mock method.
     *
     * @param comment
     * @return
     */
    public boolean containsComment(Comment comment);

    /**
     * Mock method.
     *
     * @return
     */
    public int countComments();

    /**
     * Mock method.
     *
     * @param comment
     */
    public void setParameterTemplate(TemplateParameter parameterTemplate);

    /**
     * Mock method.
     *
     * @return
     */
    public TemplateParameter getParameterTemplate();

    /**
     * Mock method.
     *
     * @param defaultParameter
     */
    public void addDefaultParameter(TemplateParameter defaultParameter);

    /**
     * Mock method.
     *
     * @param defaultParameter
     * @return
     */
    public boolean removeDefaultParameter(TemplateParameter defaultParameter);

    /**
     * Mock method.
     */
    public void clearDefaultParameters();

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<TemplateParameter> getDefaultParameters();

    /**
     * Mock method.
     *
     * @param defaultParameter
     * @return
     */
    public boolean containsDefaultParameter(TemplateParameter defaultParameter);

    /**
     * Mock method.
     *
     * @return
     */
    public int countDefaultParameters();

    /**
     * Mock method.
     *
     * @param templateParameter
     */
    public void addTemplateParameter(TemplateParameter templateParameter);

    /**
     * Mock method.
     *
     * @param index
     * @param templateParameter
     */
    public void addTemplateParameter(int index, TemplateParameter templateParameter);

    /**
     * Mock method.
     *
     * @param index
     * @param templateParameter
     */
    public void setTemplateParameter(int index, TemplateParameter templateParameter);

    /**
     * Mock method.
     *
     * @param index
     * @return
     */
    public TemplateParameter removeTemplateParameter(int index);

    /**
     * Mock method.
     *
     * @param templateParameter
     * @return
     */
    public boolean removeTemplateParameter(TemplateParameter templateParameter);

    /**
     * Mock method.
     */
    public void clearTemplateParameters();

    /**
     * Mock method.
     *
     * @return
     */
    public List<TemplateParameter> getTemplateParameters();

    /**
     * Mock method.
     *
     * @param templateParameter
     * @return
     */
    public boolean containsTemplateParameter(TemplateParameter templateParameter);

    /**
     * Mock method.
     *
     * @param templateParameter
     * @return
     */
    public int indexOfTemplateParameter(TemplateParameter templateParameter);

    /**
     * Mock method.
     *
     * @return
     */
    public int countTemplateParameters();

    /**
     * Mock method.
     *
     * @param templateArgument
     */
    public void addTemplateArgument(TemplateArgument templateArgument);

    /**
     * Mock method.
     *
     * @param templateArgument
     * @return
     */
    public boolean removeTemplateArgument(TemplateArgument templateArgument);

    /**
     * Mock method.
     *
     */
    public void clearTemplateArguments();

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<TemplateArgument> getTemplateArguments();

    /**
     * Mock method.
     *
     * @param templateArgument
     * @return
     */
    public boolean containsTemplateArgument(TemplateArgument templateArgument);

    /**
     * Mock method.
     *
     * @return
     */
    public int countTemplateArguments();

    /**
     * Mock method.
     *
     * @param elementImport
     */
    public void addElementImport(ElementImport elementImport);

    /**
     * Mock method.
     *
     * @param elementImport
     * @return
     */
    public boolean removeElementImport(ElementImport elementImport);

    /**
     * Mock method.
     */
    public void clearElementImports();

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<ElementImport> getElementImports();

    /**
     * Mock method.
     *
     * @param elementImport
     * @return
     */
    public boolean containsElementImport(ElementImport elementImport);

    /**
     * Mock method.
     *
     * @return
     */
    public int countElementImports();

    /**
     * Mock method.
     *
     * @param behavior
     */
    public void addBehavior(StateMachine behavior);

    /**
     * Mock method.
     *
     * @param behavior
     * @return
     */
    public boolean removeBehavior(StateMachine behavior);

    /**
     * Mock method.
     */
    public void clearBehaviors();

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<StateMachine> getBehaviors();

    /**
     * Mock method.
     *
     * @param behavior
     * @return
     */
    public boolean containsBehavior(StateMachine behavior);
}