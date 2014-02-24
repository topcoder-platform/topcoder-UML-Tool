/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;

/**
 * <p>
 * This class extends from ClassToolUtil. It overrides some method which is
 * unique for current instance of ModelElement - Enumeration.
 * </p>
 * <p>
 * Thread-safety: Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
class EnumerationUtil extends ClassToolUtil {

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public EnumerationUtil() {
    }

    /**
     * <p>
     * This methods provide adding Enumeration instance to clipboard.
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

        ClassElementsTransfer transfer = new ClassElementsTransfer((Enumeration) modelElement);

        clipboard.setContents(transfer, transfer);
    }

    /**
     * <p>
     * This methods copy special attributes of given modelElement (actually
     * Enumeration instance).
     * </p>
     *
     * @param modelElement
     *            copied ModelElement instance, null impossible;
     * @return created Enumeration instance
     * @throws IllegalArgumentException
     *             when parameter is null
     */
    public ModelElement copyElement(ModelElement modelElement) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Param modelElement should not be null.");
        }

        Enumeration oldEnumeration = (Enumeration) modelElement;
        Enumeration newEnumeration = new EnumerationImpl();

        copyModelElementAttributes(oldEnumeration, newEnumeration);
        copyClassifierAttributes(oldEnumeration, newEnumeration);

        // setting own attribute
        newEnumeration.addLiterals(oldEnumeration.getLiterals());

        return newEnumeration;
    }
}