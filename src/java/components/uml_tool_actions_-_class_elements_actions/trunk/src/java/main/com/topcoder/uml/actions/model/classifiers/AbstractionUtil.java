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
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;

/**
 * <p>
 * This class extends from ClassToolUtil. It overrides some method which is
 * unique for current instance of ModelElement - Abstraction.
 * </p>
 * <p>
 * Thread-safety: Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
class AbstractionUtil extends ClassToolUtil {

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
    public AbstractionUtil() {
    }

    /**
     * <p>
     * This methods provide adding ModelElement instance(which is Abstraction)
     * to namespace and updating its attributes.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @param namespace
     *            Namespace instance, null impossible
     * @throws IllegalArgumentException
     *             when parameter is null
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

        Abstraction abstraction = (Abstraction) modelElement;

        for (ModelElement supplier : abstraction.getSuppliers()) {
            supplier.addSupplierDependency(abstraction);
        }
        for (ModelElement client : abstraction.getClients()) {
            client.addClientDependency(abstraction);
        }

        modelElement.getNamespace().addOwnedElement(modelElement);
    }

    /**
     * <p>
     * This methods provide removing ModelElement instance(which is Abstraction)
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

        Abstraction abstraction = (Abstraction) modelElement;

        for (ModelElement supplier : abstraction.getSuppliers()) {
            supplier.removeSupplierDependency(abstraction);
        }
        for (ModelElement client : abstraction.getClients()) {
            client.removeClientDependency(abstraction);
        }

        return super.removeElementFromModel(modelElement);
    }

    /**
     * <p>
     * This methods provide adding Abstraction instance to clipboard.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible;
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

        ClassElementsTransfer transfer = new ClassElementsTransfer((Abstraction) modelElement);

        clipboard.setContents(transfer, transfer);
    }

    /**
     * <p>
     * This methods copy special attributes of given modelElement (actually
     * Abstraction instance).
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible;
     * @return created Abstraction instance
     * @throws IllegalArgumentException
     *             when parameter is null
     */
    public ModelElement copyElement(ModelElement modelElement) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Param modelElement should not be null.");
        }

        Abstraction oldAbstraction = (Abstraction) modelElement;
        Abstraction newAbstraction = new AbstractionImpl();

        copyModelElementAttributes(oldAbstraction, newAbstraction);

        // copy own attributes
        newAbstraction.setMapping(oldAbstraction.getMapping());

        return newAbstraction;
    }

    /**
     * <p>
     * This method provide calculating namespace for Abstraction.
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

        Abstraction abstraction = (Abstraction) modelElement;
        List<List<Namespace>> lists = new ArrayList<List<Namespace>>();

        // supplier namespace
        for (ModelElement supplier : abstraction.getSuppliers()) {
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
        for (ModelElement client : abstraction.getClients()) {
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
                // Bugfix: UML-12687
                // old code
//                if (lists.get(j).size() < i) {
                if (lists.get(j).size() <= i) {
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