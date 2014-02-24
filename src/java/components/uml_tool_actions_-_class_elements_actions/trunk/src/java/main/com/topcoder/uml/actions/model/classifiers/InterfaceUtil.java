/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;

/**
 * <p>
 * This class extends from ClassToolUtil. It overrides some method which is
 * unique for current instance of ModelElement - Interface.
 * </p>
 * <p>
 * Thread-safety: Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
class InterfaceUtil extends ClassToolUtil {

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public InterfaceUtil() {
    }

    /**
     * <p>
     * This methods provide adding Interface instance to clipboard.
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

        ClassElementsTransfer transfer = new ClassElementsTransfer((Interface) modelElement);

        clipboard.setContents(transfer, transfer);
    }

    /**
     * <p>
     * This methods copy special attributes of given modelElement (actually
     * Interface instance).
     * </p>
     *
     * @param modelElement
     *            copied ModelElement instance, null impossible;
     * @return created Interface instance
     * @throws IllegalArgumentException
     *             when parameter is null
     */
    public ModelElement copyElement(ModelElement modelElement) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Param modelElement should not be null.");
        }

        Interface oldInterface = (Interface) modelElement;
        Interface newInterface = new InterfaceImpl();

        copyModelElementAttributes(oldInterface, newInterface);
        copyClassifierAttributes(oldInterface, newInterface);

        return newInterface;
    }
}