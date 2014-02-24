/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.util.Collection;
import java.util.List;

import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.StructuralFeature;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.statemachines.StateMachine;

/**
 * <p>
 * This is a mock implementation of Classifier.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockClassifier implements Classifier {
    /**
     * <p>
     * Mock Stub implementation. Returns zero.
     * </p>
     *
     * @return zero all the time.
     */
    public int countInstances() {
        return 0;
    }

    public void addAssociation(AssociationEnd arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addFeature(Feature arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addFeature(int arg0, Feature arg1) {
        // TODO Auto-generated method stub
        
    }

    public void addInstance(Instance arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addObjectFlowState(ObjectFlowState arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addPowertypeRange(Generalization arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addSpecifiedEnd(AssociationEnd arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addTypedFeature(StructuralFeature arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addTypedParameter(Parameter arg0) {
        // TODO Auto-generated method stub
        
    }

    public void clearAssociations() {
        // TODO Auto-generated method stub
        
    }

    public void clearFeatures() {
        // TODO Auto-generated method stub
        
    }

    public void clearInstances() {
        // TODO Auto-generated method stub
        
    }

    public void clearObjectFlowStates() {
        // TODO Auto-generated method stub
        
    }

    public void clearPowertypeRanges() {
        // TODO Auto-generated method stub
        
    }

    public void clearSpecifiedEnds() {
        // TODO Auto-generated method stub
        
    }

    public void clearTypedFeatures() {
        // TODO Auto-generated method stub
        
    }

    public void clearTypedParameters() {
        // TODO Auto-generated method stub
        
    }

    public boolean containsAssociation(AssociationEnd arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsFeature(Feature arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsInstance(Instance arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsObjectFlowState(ObjectFlowState arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsPowertypeRange(Generalization arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsSpecifiedEnd(AssociationEnd arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsTypedFeature(StructuralFeature arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsTypedParameter(Parameter arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public int countAssociations() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countFeatures() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countObjectFlowStates() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countPowertypeRanges() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countSpecifiedEnds() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countTypedFeatures() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countTypedParameters() {
        // TODO Auto-generated method stub
        return 0;
    }

    public Collection<AssociationEnd> getAssociations() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Feature> getFeatures() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<Instance> getInstances() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<ObjectFlowState> getObjectFlowStates() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<Generalization> getPowertypeRanges() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<AssociationEnd> getSpecifiedEnds() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<StructuralFeature> getTypedFeatures() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<Parameter> getTypedParameters() {
        // TODO Auto-generated method stub
        return null;
    }

    public int indexOfFeature(Feature arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    public boolean removeAssociation(AssociationEnd arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public Feature removeFeature(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean removeFeature(Feature arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeInstance(Instance arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeObjectFlowState(ObjectFlowState arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removePowertypeRange(Generalization arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeSpecifiedEnd(AssociationEnd arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeTypedFeature(StructuralFeature arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeTypedParameter(Parameter arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public void setFeature(int arg0, Feature arg1) {
        // TODO Auto-generated method stub
        
    }

    public void addGeneralization(Generalization arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addSpecialization(Generalization arg0) {
        // TODO Auto-generated method stub
        
    }

    public void clearGeneralizations() {
        // TODO Auto-generated method stub
        
    }

    public void clearSpecializations() {
        // TODO Auto-generated method stub
        
    }

    public boolean containsGeneralization(Generalization arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsSpecialization(Generalization arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public int countGeneralizations() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countSpecializations() {
        // TODO Auto-generated method stub
        return 0;
    }

    public Collection<Generalization> getGeneralizations() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<Generalization> getSpecializations() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean isAbstract() {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean isLeaf() {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean isRoot() {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeGeneralization(Generalization arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeSpecialization(Generalization arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public void setAbstract(boolean arg0) {
        // TODO Auto-generated method stub
        
    }

    public void setLeaf(boolean arg0) {
        // TODO Auto-generated method stub
        
    }

    public void setRoot(boolean arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addBehavior(StateMachine arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addClientDependency(Dependency arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addComment(Comment arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addDefaultParameter(TemplateParameter arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addElementImport(ElementImport arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addReferenceTag(TaggedValue arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addStereoType(Stereotype arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addSupplierDependency(Dependency arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addTaggedValue(TaggedValue arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addTemplateArgument(TemplateArgument arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addTemplateParameter(TemplateParameter arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addTemplateParameter(int arg0, TemplateParameter arg1) {
        // TODO Auto-generated method stub
        
    }

    public void clearBehaviors() {
        // TODO Auto-generated method stub
        
    }

    public void clearClientDependencies() {
        // TODO Auto-generated method stub
        
    }

    public void clearComments() {
        // TODO Auto-generated method stub
        
    }

    public void clearDefaultParameters() {
        // TODO Auto-generated method stub
        
    }

    public void clearElementImports() {
        // TODO Auto-generated method stub
        
    }

    public void clearReferenceTags() {
        // TODO Auto-generated method stub
        
    }

    public void clearStereoTypes() {
        // TODO Auto-generated method stub
        
    }

    public void clearSupplierDependencies() {
        // TODO Auto-generated method stub
        
    }

    public void clearTaggedValues() {
        // TODO Auto-generated method stub
        
    }

    public void clearTemplateArguments() {
        // TODO Auto-generated method stub
        
    }

    public void clearTemplateParameters() {
        // TODO Auto-generated method stub
        
    }

    public boolean containsBehavior(StateMachine arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsClientDependency(Dependency arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsComment(Comment arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsDefaultParameter(TemplateParameter arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsElementImport(ElementImport arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsReferenceTag(TaggedValue arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsStereoType(Stereotype arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsSupplierDependency(Dependency arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsTaggedValue(TaggedValue arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsTemplateArgument(TemplateArgument arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsTemplateParameter(TemplateParameter arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public int countBehaviors() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countClientDependencies() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countComments() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countDefaultParameters() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countElementImports() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countReferenceTags() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countStereoTypes() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countSupplierDependencies() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countTaggedValues() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countTemplateArguments() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countTemplateParameters() {
        // TODO Auto-generated method stub
        return 0;
    }

    public Collection<StateMachine> getBehaviors() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<Dependency> getClientDependencies() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<Comment> getComments() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<TemplateParameter> getDefaultParameters() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<ElementImport> getElementImports() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    public Namespace getNamespace() {
        // TODO Auto-generated method stub
        return null;
    }

    public TemplateParameter getParameterTemplate() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<TaggedValue> getReferenceTags() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<Stereotype> getStereoTypes() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<Dependency> getSupplierDependencies() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<TaggedValue> getTaggedValues() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<TemplateArgument> getTemplateArguments() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<TemplateParameter> getTemplateParameters() {
        // TODO Auto-generated method stub
        return null;
    }

    public VisibilityKind getVisibility() {
        // TODO Auto-generated method stub
        return null;
    }

    public int indexOfTemplateParameter(TemplateParameter arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isSpecification() {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeBehavior(StateMachine arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeClientDependency(Dependency arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeComment(Comment arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeDefaultParameter(TemplateParameter arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeElementImport(ElementImport arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeReferenceTag(TaggedValue arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeStereoType(Stereotype arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeSupplierDependency(Dependency arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeTaggedValue(TaggedValue arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeTemplateArgument(TemplateArgument arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public TemplateParameter removeTemplateParameter(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean removeTemplateParameter(TemplateParameter arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public void setName(String arg0) {
        // TODO Auto-generated method stub
        
    }

    public void setNamespace(Namespace arg0) {
        // TODO Auto-generated method stub
        
    }

    public void setParameterTemplate(TemplateParameter arg0) {
        // TODO Auto-generated method stub
        
    }

    public void setSpecification(boolean arg0) {
        // TODO Auto-generated method stub
        
    }

    public void setTemplateParameter(int arg0, TemplateParameter arg1) {
        // TODO Auto-generated method stub
        
    }

    public void setVisibility(VisibilityKind arg0) {
        // TODO Auto-generated method stub
        
    }

    public void addOwnedElement(ModelElement arg0) {
        // TODO Auto-generated method stub
        
    }

    public void clearOwnedElements() {
        // TODO Auto-generated method stub
        
    }

    public boolean containsOwnedElement(ModelElement arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public int countOwnedElements() {
        // TODO Auto-generated method stub
        return 0;
    }

    public Collection<ModelElement> getOwnedElements() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean removeOwnedElement(ModelElement arg0) {
        // TODO Auto-generated method stub
        return false;
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
