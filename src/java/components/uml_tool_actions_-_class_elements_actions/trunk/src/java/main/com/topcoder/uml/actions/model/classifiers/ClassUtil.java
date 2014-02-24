/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * <p>
 * This class extends from ClassToolUtil. It overrides some method which is
 * unique for current instance of ModelElement - Class.
 * </p>
 * <p>
 * Thread-safety: Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
class ClassUtil extends ClassToolUtil {

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public ClassUtil() {
    }

    /**
     * <p>
     * This methods provide adding Class instance to clipboard.
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
                (com.topcoder.uml.model.core.classifiers.Class) modelElement);

        clipboard.setContents(transfer, transfer);
    }

    /**
     * <p>
     * This methods copy special attributes of given modelElement (actually
     * Class instance).
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @return created Class instance
     * @throws IllegalArgumentException
     *             when parameter is null
     */
    public ModelElement copyElement(ModelElement modelElement) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Param modelElement should not be null.");
        }

        com.topcoder.uml.model.core.classifiers.Class oldClass =
            (com.topcoder.uml.model.core.classifiers.Class) modelElement;
        com.topcoder.uml.model.core.classifiers.Class newClass = new ClassImpl();

        copyModelElementAttributes(oldClass, newClass);
        copyClassifierAttributes(oldClass, newClass);

        // setting own attribute
        newClass.setActive(oldClass.isActive());

        return newClass;
    }
}