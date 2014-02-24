/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.MultiplicityRange;
import com.topcoder.uml.model.datatypes.MultiplicityRangeImpl;

/**
 * <p>
 * This class extends from ClassToolUtil. It overrides some method which is
 * unique for current instance of ModelElement - Association.
 * </p>
 * <p>
 * Thread-safety: Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
class AssociationUtil extends ClassToolUtil {

    /**
     * <p>
     * Represent whether the namespace need to calculate again.
     * </p>
     */
    private boolean isCalculated = false;

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public AssociationUtil() {
    }

    /**
     * <p>
     * This methods provide adding ModelElement instance(which is Association)
     * to namespace and updating its attributes.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @param namespace
     *            Namespace instance, null impossible
     * @throws IllegalArgumentException
     *             when parameter is null
     * @throws InvalidDataContentException
     *             when modelElement is not Association
     */
    public void addElementToModel(ModelElement modelElement, Namespace namespace) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Param modelElement should not be null.");
        }
        if (namespace == null) {
            throw new IllegalArgumentException("Param namespace should not be null.");
        }

        if (!isCalculated) {
            Namespace calculatedNamespace = setCalculatedNamespace(modelElement);
            if (calculatedNamespace != null) {
                modelElement.setNamespace(calculatedNamespace);
            } else {
                modelElement.setNamespace(namespace);
            }

            isCalculated = true;
        }

        Association association = (Association) modelElement;

        for (AssociationEnd associationEnd : association.getConnections()) {
            for (Classifier classifier : associationEnd.getSpecifications()) {
                classifier.addAssociation(associationEnd);
            }
        }

        modelElement.getNamespace().addOwnedElement(modelElement);
    }

    /**
     * <p>
     * This methods provide adding ModelElement instance(which is Association)
     * to namespace and updating its attributes.
     * </p>
     *
     * @param modelElement
     *            Association instance, null impossible
     * @return If method super.removeElementFromModel() return true this method
     *         also return true, otherwise false
     * @throws IllegalArgumentException
     *             when parameter is null
     * @throws InvalidDataContentException
     *             when modelElement is not Association
     */
    public boolean removeElementFromModel(ModelElement modelElement) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Param modelElement should not be null.");
        }

        Association association = (Association) modelElement;

        for (AssociationEnd associationEnd : association.getConnections()) {
            for (Classifier classifier : associationEnd.getSpecifications()) {
                classifier.removeAssociation(associationEnd);
            }
        }

        return super.removeElementFromModel(modelElement);
    }

    /**
     * <p>
     * This methods provide adding Association instance to clipboard.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @param clipboard
     *            Clipboard instance, null impossible
     * @throws IllegalArgumentException
     *             when some parameter is null
     */
    public void addElementToClipboard(ModelElement modelElement, Clipboard clipboard) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Param modelElement should not be null.");
        }
        if (clipboard == null) {
            throw new IllegalArgumentException("Param clipboard should not be null.");
        }

        ClassElementsTransfer transfer = new ClassElementsTransfer((Association) modelElement);

        clipboard.setContents(transfer, transfer);
    }

    /**
     * <p>
     * This methods copy special attributes of given modelElement (actually
     * Association instance).
     * </p>
     *
     * @param modelElement
     *            Association instance, null impossible
     * @return created Association instance
     * @throws IllegalArgumentException
     *             when parameter is null
     */
    public ModelElement copyElement(ModelElement modelElement) {
        Association oldAssociation = (Association) modelElement;

        Association newAssociation = new AssociationImpl();

        copyModelElementAttributes(oldAssociation, newAssociation);

        AssociationEnd leftEnd = oldAssociation.getConnections().get(0);
        AssociationEnd rightEnd = oldAssociation.getConnections().get(1);

        AssociationEnd newEnd = new AssociationEndImpl();
        copyAssociationEndAttributes(leftEnd, newEnd);
        newEnd.setAssociation(newAssociation);
        newAssociation.addConnection(newEnd);

        newEnd = new AssociationEndImpl();
        copyAssociationEndAttributes(rightEnd, newEnd);
        newEnd.setAssociation(newAssociation);
        newAssociation.addConnection(newEnd);

        // copy own attributes
        newAssociation.setRoot(oldAssociation.isRoot());
        newAssociation.setLeaf(oldAssociation.isLeaf());
        newAssociation.setAbstract(oldAssociation.isAbstract());

        return newAssociation;
    }

    /**
     * <p>
     * This method provides copying attributes of AssociationEnd.
     * </p>
     *
     * @param oldAssociationEnd
     *            old AssociationEnd
     * @param newAssociationEnd
     *            new AssociationEnd
     */
    private void copyAssociationEndAttributes(AssociationEnd oldAssociationEnd, AssociationEnd newAssociationEnd) {
        newAssociationEnd.setAggregation(oldAssociationEnd.getAggregation());
        newAssociationEnd.setChangeability(oldAssociationEnd.getChangeability());
        Multiplicity oldMultiplicity = oldAssociationEnd.getMultiplicity();
        if (oldMultiplicity != null) {
            Multiplicity newMultiplicity = new MultiplicityImpl();
            copyMultiplicityRanges(oldMultiplicity, newMultiplicity);
            newAssociationEnd.setMultiplicity(newMultiplicity);
        }
        newAssociationEnd.setNavigable(oldAssociationEnd.isNavigable());
        newAssociationEnd.setOrdering(oldAssociationEnd.getOrdering());
        newAssociationEnd.setParticipant(oldAssociationEnd.getParticipant());
        newAssociationEnd.setTargetKind(oldAssociationEnd.getTargetKind());
        copyModelElementAttributes(oldAssociationEnd, newAssociationEnd);
    }

    /**
     * <p>
     * This method provides copying MultiplicityRanges of Multiplicity.
     * </p>
     *
     * @param oldMultiplicity
     *            old Multiplicity
     * @param newMultiplicity
     *            new Multiplicity
     */
    private void copyMultiplicityRanges(Multiplicity oldMultiplicity, Multiplicity newMultiplicity) {
        for (MultiplicityRange range : oldMultiplicity.getRanges()) {
            MultiplicityRange newRange = new MultiplicityRangeImpl();
            newRange.setMultiplicity(newMultiplicity);
            newRange.setLower(range.getLower());
            newRange.setUpper(range.getUpper());
            newMultiplicity.addRange(newRange);
        }
    }

    /**
     * <p>
     * This method provide calculating namespace for Association.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @return calculated Namespace
     * @throws IllegalArgumentException
     *             when parameter is null
     */
    private Namespace setCalculatedNamespace(ModelElement modelElement) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Param modelElement should not be null.");
        }

        Association association = (Association) modelElement;
        List<List<Namespace>> lists = new ArrayList<List<Namespace>>();

        // classifier namespace
        for (AssociationEnd associationEnd : association.getConnections()) {
            for (Classifier classifier : associationEnd.getSpecifications()) {
                List<Namespace> classifierList = new ArrayList<Namespace>();
                Namespace namespace = classifier.getNamespace();
                while (namespace != null) {
                    classifierList.add(namespace);
                    namespace = namespace.getNamespace();
                }
                Collections.reverse(classifierList);
                lists.add(classifierList);
            }
        }

        if (lists.size() == 0 || lists.get(0).size() == 0) {
            return null;
        }

        Namespace resultNamespace = lists.get(0).get(0);
        for (int i = 1; i < lists.get(0).size(); i++) {
            // whether other ModelElements having equal namespace:
            // lists.get(0).get(i)
            boolean equal = true;

            // compare with other ModelElements
            for (int j = 1; j < lists.size(); j++) {
                if (lists.get(j).size() < i) {
                    equal = false;
                    break;
                } else if (!lists.get(j).get(i).equals(lists.get(0).get(i))) {
                    equal = false;
                    break;
                }
            }

            if (equal) {
                resultNamespace = lists.get(0).get(i);
            } else {
                break;
            }
        }

        return resultNamespace;
    }
}