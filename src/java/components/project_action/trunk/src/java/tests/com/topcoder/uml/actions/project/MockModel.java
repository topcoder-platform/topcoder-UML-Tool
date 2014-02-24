/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.modelmanagement.Model;

/**
 * <p>
 * This is a mock implementation of Model.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockModel implements Model {

    /** Variable to check whether clearElementImports is called. Will be set to true once the method is called. */
    private static boolean clearElementImport = false;

    /** Variable to check whether clearBehaviors is called. Will be set to true once the method is called. */
    private static boolean clearBehavior = false;

    /**
     * Variable to check whether clearClientDependencies is called. Will be set to true once the method is
     * called.
     */
    private static boolean clearClientDependencie = false;

    /** Variable to check whether clearComments is called. Will be set to true once the method is called. */
    private static boolean clearComment = false;

    /**
     * Variable to check whether clearDefaultParameters is called. Will be set to true once the method is
     * called.
     */
    private static boolean clearDefaultParameter = false;

    /**
     * Variable to check whether clearGeneralizations is called. Will be set to true once the method is
     * called.
     */
    private static boolean clearGeneralization = false;

    /** Variable to check whether clearOwnedElements is called. Will be set to true once the method is called. */
    private static boolean clearOwnedElement = false;

    /** Variable to check whether clearReferenceTags is called. Will be set to true once the method is called. */
    private static boolean clearReferenceTag = false;

    /**
     * Variable to check whether clearSpecializations is called. Will be set to true once the method is
     * called.
     */
    private static boolean clearSpecialization = false;

    /** Variable to check whether clearStereoTypes is called. Will be set to true once the method is called. */
    private static boolean clearStereoType = false;

    /**
     * Variable to check whether clearSupplierDependencies is called. Will be set to true once the method is
     * called.
     */
    private static boolean clearSupplierDependencie = false;

    /** Variable to check whether clearTaggedValues is called. Will be set to true once the method is called. */
    private static boolean clearTaggedValue = false;

    /**
     * Variable to check whether clearTemplateArguments is called. Will be set to true once the method is
     * called.
     */
    private static boolean clearTemplateArgument = false;

    /**
     * Variable to check whether clearTemplateParameters is called. Will be set to true once the method is
     * called.
     */
    private static boolean clearTemplateParameter = false;

    /**
     * <p>
     * Represents a list of TaggedValue objects.
     * </p>
     */
    private final List<TaggedValue> taggedValues = new ArrayList<TaggedValue>();

    /**
     * This method returns the clearElementImport boolean variable.
     *
     * @return boolean value informing whether the value is set or not
     */
    public boolean clearElementImportStatus() {
        return clearElementImport;
    }

    /**
     * This method returns the clearBehavior boolean variable.
     *
     * @return boolean value informing whether the value is set or not
     */
    public boolean clearBehaviorStatus() {
        return clearBehavior;
    }

    /**
     * This method returns the clearClientDependencie boolean variable.
     *
     * @return boolean value informing whether the value is set or not
     */
    public boolean clearClientDependencieStatus() {
        return clearClientDependencie;
    }

    /**
     * This method returns the clearComment boolean variable.
     *
     * @return boolean value informing whether the value is set or not
     */
    public boolean clearCommentStatus() {
        return clearComment;
    }

    /**
     * This method returns the clearDefaultParameter boolean variable.
     *
     * @return boolean value informing whether the value is set or not
     */
    public boolean clearDefaultParameterStatus() {
        return clearDefaultParameter;
    }

    /**
     * This method returns the clearGeneralization boolean variable.
     *
     * @return boolean value informing whether the value is set or not
     */
    public boolean clearGeneralizationStatus() {
        return clearGeneralization;
    }

    /**
     * This method returns the clearOwnedElement boolean variable.
     *
     * @return boolean value informing whether the value is set or not
     */
    public boolean clearOwnedElementStatus() {
        return clearOwnedElement;
    }

    /**
     * This method returns the clearReferenceTag boolean variable.
     *
     * @return boolean value informing whether the value is set or not
     */
    public boolean clearReferenceTagStatus() {
        return clearReferenceTag;
    }

    /**
     * This method returns the clearSpecialization boolean variable.
     *
     * @return boolean value informing whether the value is set or not
     */
    public boolean clearSpecializationStatus() {
        return clearSpecialization;
    }

    /**
     * This method returns the clearStereoType boolean variable.
     *
     * @return boolean value informing whether the value is set or not
     */
    public boolean clearStereoTypeStatus() {
        return clearStereoType;
    }

    /**
     * This method returns the clearSupplierDependencie boolean variable.
     *
     * @return boolean value informing whether the value is set or not
     */
    public boolean clearSupplierDependencieStatus() {
        return clearSupplierDependencie;
    }

    /**
     * This method returns the clearTaggedValue boolean variable.
     *
     * @return boolean value informing whether the value is set or not
     */
    public boolean clearTaggedValueStatus() {
        return clearTaggedValue;
    }

    /**
     * This method returns the clearTemplateArgument boolean variable.
     *
     * @return boolean value informing whether the value is set or not
     */
    public boolean clearTemplateArgumentStatus() {
        return clearTemplateArgument;
    }

    /**
     * This method returns the clearTemplateParameter boolean variable.
     *
     * @return boolean value informing whether the value is set or not
     */
    public boolean clearTemplateParameterStatus() {
        return clearTemplateParameter;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param elementImport elementImport
     */
    public void addElementImport(ElementImport elementImport) {
        //

    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param elementImports elementImports
     */
    public void addElementImports(Collection<ElementImport> elementImports) {
        //

    }

    /**
     * <p>
     * Sets the boolean variable for testing.
     * </p>
     */
    public void clearElementImports() {
        clearElementImport = true;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param elementImport elementImport
     * @return false
     */
    public boolean containsElementImport(ElementImport elementImport) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return 0
     */
    public int countElementImports() {
        return 0;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public Collection<ElementImport> getElementImports() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param elementImport elementImport
     * @return false
     */
    public boolean removeElementImport(ElementImport elementImport) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param elementImports elementImports
     * @return false
     */
    public boolean removeElementImports(Collection<ElementImport> elementImports) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param ownedElement ownedElement
     */
    public void addOwnedElement(ModelElement ownedElement) {
    }

    /**
     * <p>
     * Sets the boolean variable for testing.
     * </p>
     */
    public void clearOwnedElements() {
        clearOwnedElement = true;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param ownedElement ownedElement
     * @return false
     */
    public boolean containsOwnedElement(ModelElement ownedElement) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return 0
     */
    public int countOwnedElements() {
        return 0;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public Collection<ModelElement> getOwnedElements() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param ownedElement ownedElement
     * @return false
     */
    public boolean removeOwnedElement(ModelElement ownedElement) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param behavior behavior
     */
    public void addBehavior(StateMachine behavior) {
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param clientDependency clientDependency
     */
    public void addClientDependency(Dependency clientDependency) {
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param comment comment
     */
    public void addComment(Comment comment) {
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param defaultParameter defaultParameter
     */
    public void addDefaultParameter(TemplateParameter defaultParameter) {
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param referenceTag referenceTag
     */
    public void addReferenceTag(TaggedValue referenceTag) {
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param stereoType stereoType
     */
    public void addStereoType(Stereotype stereoType) {
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param supplierDependency supplierDependency
     */
    public void addSupplierDependency(Dependency supplierDependency) {
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param taggedValue taggedValue
     */
    public void addTaggedValue(TaggedValue taggedValue) {
        taggedValues.add(taggedValue);
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param templateArgument templateArgument
     */
    public void addTemplateArgument(TemplateArgument templateArgument) {
        //

    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param templateParameter templateParameter
     */
    public void addTemplateParameter(TemplateParameter templateParameter) {
        //

    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param index index
     * @param templateParameter templateParameter
     */
    public void addTemplateParameter(int index, TemplateParameter templateParameter) {
        //

    }

    /**
     * <p>
     * Sets the boolean variable for testing.
     * </p>
     */
    public void clearBehaviors() {
        clearBehavior = true;
    }

    /**
     * <p>
     * Sets the boolean variable for testing.
     * </p>
     */
    public void clearClientDependencies() {
        clearClientDependencie = true;
    }

    /**
     * <p>
     * Sets the boolean variable for testing.
     * </p>
     */
    public void clearComments() {
        clearComment = true;
    }

    /**
     * <p>
     * Sets the boolean variable for testing.
     * </p>
     */
    public void clearDefaultParameters() {
        clearDefaultParameter = true;
    }

    /**
     * <p>
     * Sets the boolean variable for testing.
     * </p>
     */
    public void clearReferenceTags() {
        clearReferenceTag = true;
    }

    /**
     * <p>
     * Sets the boolean variable for testing.
     * </p>
     */
    public void clearStereoTypes() {
        clearStereoType = true;
    }

    /**
     * <p>
     * Sets the boolean variable for testing.
     * </p>
     */
    public void clearSupplierDependencies() {
        clearSupplierDependencie = true;
    }

    /**
     * <p>
     * Sets the boolean variable for testing.
     * </p>
     */
    public void clearTaggedValues() {
        clearTaggedValue = true;
    }

    /**
     * <p>
     * Sets the boolean variable for testing.
     * </p>
     */
    public void clearTemplateArguments() {
        clearTemplateArgument = true;
    }

    /**
     * <p>
     * Sets the boolean variable for testing.
     * </p>
     */
    public void clearTemplateParameters() {
        clearTemplateParameter = true;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param behavior behavior
     * @return false
     */
    public boolean containsBehavior(StateMachine behavior) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param clientDependency clientDependency
     * @return false
     */
    public boolean containsClientDependency(Dependency clientDependency) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param comment comment
     * @return false
     */
    public boolean containsComment(Comment comment) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param defaultParameter defaultParameter
     * @return false
     */
    public boolean containsDefaultParameter(TemplateParameter defaultParameter) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param referenceTag referenceTag
     * @return false
     */
    public boolean containsReferenceTag(TaggedValue referenceTag) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param stereoType stereoType
     * @return false
     */
    public boolean containsStereoType(Stereotype stereoType) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param supplierDependency supplierDependency
     * @return false
     */
    public boolean containsSupplierDependency(Dependency supplierDependency) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param taggedValue taggedValue
     * @return false
     */
    public boolean containsTaggedValue(TaggedValue taggedValue) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param templateArgument templateArgument
     * @return false
     */
    public boolean containsTemplateArgument(TemplateArgument templateArgument) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param templateParameter templateParameter
     * @return false
     */
    public boolean containsTemplateParameter(TemplateParameter templateParameter) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return 0
     */
    public int countBehaviors() {
        return 0;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return 0
     */
    public int countClientDependencies() {
        return 0;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return 0
     */
    public int countComments() {
        return 0;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return 0
     */
    public int countDefaultParameters() {
        return 0;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return 0
     */
    public int countReferenceTags() {
        return 0;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return 0
     */
    public int countStereoTypes() {
        return 0;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return 0
     */
    public int countSupplierDependencies() {
        return 0;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return 0
     */
    public int countTaggedValues() {
        return 0;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return 0
     */
    public int countTemplateArguments() {
        return 0;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return 0
     */
    public int countTemplateParameters() {
        return 0;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public Collection<StateMachine> getBehaviors() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public Collection<Dependency> getClientDependencies() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public Collection<Comment> getComments() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public Collection<TemplateParameter> getDefaultParameters() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public String getName() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public Namespace getNamespace() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public TemplateParameter getParameterTemplate() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public Collection<TaggedValue> getReferenceTags() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public Collection<Stereotype> getStereoTypes() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public Collection<Dependency> getSupplierDependencies() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Returns the taggedvalues variable wrapped in ArrayList.
     * </p>
     *
     * @return the taggedvalues variable wrapped in ArrayList.
     */
    public Collection<TaggedValue> getTaggedValues() {
        return new ArrayList<TaggedValue>(taggedValues);
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public Collection<TemplateArgument> getTemplateArguments() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public List<TemplateParameter> getTemplateParameters() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public VisibilityKind getVisibility() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param templateParameter templateParameter
     * @return 0
     */
    public int indexOfTemplateParameter(TemplateParameter templateParameter) {
        return 0;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return false
     */
    public boolean isSpecification() {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param behavior behavior
     * @return false
     */
    public boolean removeBehavior(StateMachine behavior) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param clientDependency clientDependency
     * @return false
     */
    public boolean removeClientDependency(Dependency clientDependency) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param comment comment
     * @return false
     */
    public boolean removeComment(Comment comment) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param defaultParameter defaultParameter
     * @return false
     */
    public boolean removeDefaultParameter(TemplateParameter defaultParameter) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param referenceTag referenceTag
     * @return false
     */
    public boolean removeReferenceTag(TaggedValue referenceTag) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param stereoType stereoType
     * @return false
     */
    public boolean removeStereoType(Stereotype stereoType) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param supplierDependency supplierDependency
     * @return false
     */
    public boolean removeSupplierDependency(Dependency supplierDependency) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param taggedValue taggedValue
     * @return false
     */
    public boolean removeTaggedValue(TaggedValue taggedValue) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param templateArgument templateArgument
     * @return false
     */
    public boolean removeTemplateArgument(TemplateArgument templateArgument) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param index index
     * @return null
     */
    public TemplateParameter removeTemplateParameter(int index) {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param templateParameter templateParameter
     * @return false
     */
    public boolean removeTemplateParameter(TemplateParameter templateParameter) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param name name
     */
    public void setName(String name) {
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param namespace namespace
     */
    public void setNamespace(Namespace namespace) {
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param parameterTemplate parameterTemplate
     */
    public void setParameterTemplate(TemplateParameter parameterTemplate) {
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param isSpecification isSpecification
     */
    public void setSpecification(boolean isSpecification) {
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param index index
     * @param templateParameter templateParameter
     */
    public void setTemplateParameter(int index, TemplateParameter templateParameter) {
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param visibility visibility
     */
    public void setVisibility(VisibilityKind visibility) {
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param generalization generalization
     */
    public void addGeneralization(Generalization generalization) {
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param specialization specialization
     */
    public void addSpecialization(Generalization specialization) {
    }

    /**
     * <p>
     * Sets the boolean variable for testing.
     * </p>
     */
    public void clearGeneralizations() {
        clearGeneralization = true;
    }

    /**
     * <p>
     * Sets the boolean variable for testing.
     * </p>
     */
    public void clearSpecializations() {
        clearSpecialization = true;

    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param generalization generalization
     * @return false
     */
    public boolean containsGeneralization(Generalization generalization) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param specialization specialization
     * @return false
     */
    public boolean containsSpecialization(Generalization specialization) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return 0
     */
    public int countGeneralizations() {
        return 0;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return 0
     */
    public int countSpecializations() {
        return 0;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public Collection<Generalization> getGeneralizations() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return null
     */
    public Collection<Generalization> getSpecializations() {
        return null;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return false
     */
    public boolean isAbstract() {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return false
     */
    public boolean isLeaf() {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @return false
     */
    public boolean isRoot() {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param generalization generalization
     * @return false
     */
    public boolean removeGeneralization(Generalization generalization) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param specialization specialization
     * @return false
     */
    public boolean removeSpecialization(Generalization specialization) {
        return false;
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param isAbstract isAbstract
     */
    public void setAbstract(boolean isAbstract) {
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param isLeaf isLeaf
     */
    public void setLeaf(boolean isLeaf) {
    }

    /**
     * <p>
     * Mock Stub implementation. Does nothing.
     * </p>
     *
     * @param isRoot isRoot
     */
    public void setRoot(boolean isRoot) {
    }

    public void addStereotype(Stereotype arg0) {
        // TODO Auto-generated method stub
        
    }

    public boolean removeStereotype(Stereotype arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public void clearStereotypes() {
        // TODO Auto-generated method stub
        
    }

    public Collection<Stereotype> getStereotypes() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean containsStereotype(Stereotype arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public int countStereotypes() {
        // TODO Auto-generated method stub
        return 0;
    }
}
