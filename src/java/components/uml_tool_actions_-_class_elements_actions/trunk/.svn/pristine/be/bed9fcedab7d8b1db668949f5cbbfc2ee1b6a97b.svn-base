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
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;

/**
 * <p>
 * This class extends from ClassToolUtil. It overrides some method which is
 * unique for current instance of ModelElement - Dependency.
 * </p>
 * <p>
 * Thread-safety: Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
class DependencyUtil extends ClassToolUtil {

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
    public DependencyUtil() {
    }

    /**
     * <p>
     * This methods provide adding ModelElement instance(which is Dependency) to
     * namespace and updating its attributes.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @param namespace
     *            Namespace instance, null impossible
     * @throws IllegalArgumentException
     *             when parameter is null
     * @throws InvalidDataContentException
     *             when modelElement is not Dependency
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

        Dependency dependency = (Dependency) modelElement;

        for (ModelElement supplier : dependency.getSuppliers()) {
            supplier.addSupplierDependency(dependency);
        }
        for (ModelElement client : dependency.getClients()) {
            client.addClientDependency(dependency);
        }

        modelElement.getNamespace().addOwnedElement(modelElement);
    }

    /**
     * <p>
     * This methods provide removing ModelElement instance(which is Dependency)
     * from namespace and updating its attributes.
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

        Dependency dependency = (Dependency) modelElement;

        for (ModelElement supplier : dependency.getSuppliers()) {
            supplier.removeSupplierDependency(dependency);
        }
        for (ModelElement client : dependency.getClients()) {
            client.removeClientDependency(dependency);
        }

        return super.removeElementFromModel(modelElement);
    }

    /**
     * <p>
     * This methods provide adding Dependency instance to clipboard.
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

        ClassElementsTransfer transfer = new ClassElementsTransfer((Dependency) modelElement);

        clipboard.setContents(transfer, transfer);
    }

    /**
     * <p>
     * This methods copy special attributes of given modelElement (actually
     * Dependency instance).
     * </p>
     *
     * @param modelElement
     *            Dependency instance, null impossible
     * @return created Dependency instance
     * @throws IllegalArgumentException
     *             when parameter is null
     * @throws InvalidDataContentException
     *             when modelElement is not Dependency
     */
    public ModelElement copyElement(ModelElement modelElement) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Param modelElement should not be null.");
        }

        Dependency oldDependency = (Dependency) modelElement;
        Dependency newDependency = new DependencyImpl();

        copyModelElementAttributes(oldDependency, newDependency);

        return newDependency;
    }

    /**
     * <p>
     * This method provide calculating namespace for Dependency.
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

        Dependency dependency = (Dependency) modelElement;
        List<List<Namespace>> lists = new ArrayList<List<Namespace>>();

        // supplier namespace
        for (ModelElement supplier : dependency.getSuppliers()) {
            List<Namespace> supplierList = new ArrayList<Namespace>();
            Namespace namespace = supplier.getNamespace();
            while (namespace != null) {
                supplierList.add(namespace);
                namespace = namespace.getNamespace();
            }
            Collections.reverse(supplierList);
            lists.add(supplierList);
        }

        // client namespace
        for (ModelElement client : dependency.getClients()) {
            List<Namespace> clientList = new ArrayList<Namespace>();
            Namespace namespace = client.getNamespace();
            while (namespace != null) {
                clientList.add(namespace);
                namespace = namespace.getNamespace();
            }
            Collections.reverse(clientList);
            lists.add(clientList);
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