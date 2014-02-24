/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;

/**
 * <p>
 * This class extends from ClassToolUtil. It overrides some method which is
 * unique for current instance of ModelElement - Generalization.
 * </p>
 * <p>
 * Thread-safety: Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
class GeneralizationUtil extends ClassToolUtil {

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
    public GeneralizationUtil() {
    }

    /**
     * <p>
     * This methods provide adding ModelElement instance(which is
     * Generalization) to namespace and updating its attributes.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @param namespace
     *            Namespace instance, null impossible
     * @throws IllegalArgumentException
     *             when parameter is null
     * @throws InvalidDataContentException
     *             when modelElement is not Generalization
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

        Generalization generalization = (Generalization) modelElement;

        /*
         * BugFix: UML-9993
         * The generalization instance should be added to the child's generalization
         * list, and the parent's specialization list, not just the opposite.
         */
        // old code
//        generalization.getParent().addGeneralization(generalization);
//        generalization.getChild().addSpecialization(generalization);
        generalization.getChild().addGeneralization(generalization);
        generalization.getParent().addSpecialization(generalization);

        modelElement.getNamespace().addOwnedElement(modelElement);
    }

    /**
     * <p>
     * This methods provide adding ModelElement instance(which is
     * Generalization) to namespace and updating its attributes.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @return If method super.removeElementFromModel() return true this method
     *         also return true, otherwise false
     * @throws IllegalArgumentException
     *             when parameter is null
     */
    public boolean removeElementFromModel(ModelElement modelElement) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Param modelElement should not be null.");
        }

        Generalization generalization = (Generalization) modelElement;

        // Bugfix: UML-12689
        // old code
//        generalization.getParent().removeGeneralization(generalization);
//        generalization.getChild().removeSpecialization(generalization);
        generalization.getChild().removeGeneralization(generalization);
        generalization.getParent().removeSpecialization(generalization);

        return super.removeElementFromModel(modelElement);
    }

    /**
     * <p>
     * This methods provide adding Generalization instance to clipboard.
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

        ClassElementsTransfer transfer = new ClassElementsTransfer((Generalization) modelElement);

        clipboard.setContents(transfer, transfer);
    }

    /**
     * <p>
     * This methods copy special attributes of given modelElement (actually
     * Generalization instance).
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @return created Generalization instance
     * @throws IllegalArgumentException
     *             when parameter is null
     */
    public ModelElement copyElement(ModelElement modelElement) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Param modelElement should not be null.");
        }

        Generalization oldGeneralization = (Generalization) modelElement;
        Generalization newGeneralization = new GeneralizationImpl();

        copyModelElementAttributes(oldGeneralization, newGeneralization);

        // copy own attributes
        newGeneralization.setDiscriminator(oldGeneralization.getDiscriminator());
        newGeneralization.setPowertype(oldGeneralization.getPowertype());

        return newGeneralization;
    }

    /**
     * <p>
     * This method provide calculating namespace for Generalization.
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

        Generalization generalization = (Generalization) modelElement;
        Namespace namespace, resultNamespace;

        // parent namespace
        List<Namespace> parentList = new ArrayList<Namespace>();
        namespace = generalization.getParent().getNamespace();
        while (namespace != null) {
            parentList.add(namespace);
            namespace = namespace.getNamespace();
        }
        Collections.reverse(parentList);

        // child namespace
        List<Namespace> childList = new ArrayList<Namespace>();
        namespace = generalization.getChild().getNamespace();
        while (namespace != null) {
            childList.add(namespace);
            namespace = namespace.getNamespace();
        }
        Collections.reverse(childList);

        if (parentList.size() == 0) {
            return null;
        }

        resultNamespace = parentList.get(0);

        for (int i = 1; i < parentList.size(); i++) {
            // Bugfix: UML-12687
            // old code
//            if (childList.size() < i) {
            if (childList.size() <= i) {
                break;
            } else if (parentList.get(i).equals(childList.get(i))) {
                resultNamespace = parentList.get(i);
            } else {
                break;
            }
        }

        return resultNamespace;
    }
}