/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

/**
 * <p>
 * This class extends from ClassToolUtil. It overrides some method which is
 * unique for current instance of ModelElement - Package.
 * </p>
 * <p>
 * Thread-safety: Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
class PackageUtil extends ClassToolUtil {

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public PackageUtil() {
    }

    /**
     * <p>
     * This methods provide adding Package instance to clipboard.
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

        ClassElementsTransfer transfer = new ClassElementsTransfer(
                (com.topcoder.uml.model.modelmanagement.Package) modelElement);

        clipboard.setContents(transfer, transfer);
    }

    /**
     * <p>
     * This methods copy special attributes of given modelElement (actually
     * Package instance).
     * </p>
     *
     * @param modelElement
     *            copied ModelElement instance, null impossible;
     * @return created Package instance
     * @throws IllegalArgumentException
     *             when parameter is null
     */
    public com.topcoder.uml.model.core.ModelElement copyElement(com.topcoder.uml.model.core.ModelElement modelElement) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Param modelElement should not be null.");
        }

        com.topcoder.uml.model.modelmanagement.Package oldPackage =
            (com.topcoder.uml.model.modelmanagement.Package) modelElement;
        com.topcoder.uml.model.modelmanagement.Package newPackage = new PackageImpl();

        copyModelElementAttributes(oldPackage, newPackage);

        // setting own attributes
        newPackage.setRoot(oldPackage.isRoot());
        newPackage.setLeaf(oldPackage.isLeaf());
        newPackage.setAbstract(oldPackage.isAbstract());

        return newPackage;
    }
}