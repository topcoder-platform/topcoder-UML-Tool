/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.util.log.Level;
import com.topcoder.util.log.LogFactory;

/**
 * <p>
 * This class is used for transporting model elements through a system
 * clipboard. It contain 9 custom DataFlavor instances, each element has own
 * DataFlavor. Class also implements interface ClipboardOwner for providing
 * ability to be owner for elements in clipboard. It has eight public
 * constructors for setting different types of data flavors without using
 * instanceof operator.
 * </p>
 * <p>
 * Thread-safety: Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class ClassElementsTransfer implements Transferable, ClipboardOwner {

    /**
     * <p>
     * Represent DataFlavor for Class implementation.
     * </p>
     */
    public static final DataFlavor CLASS_FLAVOR = new DataFlavor(com.topcoder.uml.model.core.classifiers.Class.class,
            "Class");

    /**
     * <p>
     * Represent DataFlavor for Interface implementation.
     * </p>
     */
    public static final DataFlavor INTERFACE_FLAVOR = new DataFlavor(Interface.class, "Interface");

    /**
     * <p>
     * Represent DataFlavor for Enumeration implementation.
     * </p>
     */
    public static final DataFlavor ENUMERATION_FLAVOR = new DataFlavor(Enumeration.class, "Enumeration");

    /**
     * <p>
     * Represent DataFlavor for Package implementation.
     * </p>
     */
    public static final DataFlavor PACKAGE_FLAVOR = new DataFlavor(
            com.topcoder.uml.model.modelmanagement.Package.class, "Package");

    /**
     * <p>
     * Represent DataFlavor for Abstraction implementation.
     * </p>
     */
    public static final DataFlavor ABSTRACTION_FLAVOR = new DataFlavor(Abstraction.class, "Abstraction");

    /**
     * <p>
     * Represent DataFlavor for Association implementation.
     * </p>
     */
    public static final DataFlavor ASSOCIATION_FLAVOR = new DataFlavor(Association.class, "Association");

    /**
     * <p>
     * Represent DataFlavor for Dependency implementation.
     * </p>
     */
    public static final DataFlavor DEPENDENCY_FLAVOR = new DataFlavor(Dependency.class, "Dependency");

    /**
     * <p>
     * Represent DataFlavor for Generalization implementation.
     * </p>
     */
    public static final DataFlavor GENERALIZATION_FLAVOR = new DataFlavor(Generalization.class, "Generalization");

    /**
     * <p>
     * Represent DataFlavor for Exception implementation.
     * </p>
     */
    public static final DataFlavor EXCEPTION_FLAVOR = new DataFlavor(
            com.topcoder.uml.model.core.classifiers.Class.class, "Exception");

    /**
     * <p>
     * Represent one of possible values for data flavors object.
     * </p>
     */
    private final Element element;

    /**
     * <p>
     * Represent supported DataFlavor for current instance of this class.
     * </p>
     */
    private final DataFlavor supportedFlavor;

    /**
     * <p>
     * Constructor which set attribute element by given Class instance.
     * </p>
     *
     * @param classElement
     *            Class instance, null impossible
     * @throws IllegalArgumentException
     *             when classElement is null
     */
    public ClassElementsTransfer(com.topcoder.uml.model.core.classifiers.Class classElement) {
        if (classElement == null) {
            throw new IllegalArgumentException("Param classElement should not be null.");
        }

        element = classElement;

        ExceptionUtil util = new ExceptionUtil();

        if (util.isException(classElement)) {
            supportedFlavor = EXCEPTION_FLAVOR;
        } else {
            supportedFlavor = CLASS_FLAVOR;
        }
    }

    /**
     * <p>
     * Constructor which set attribute element by given Interface instance.
     * </p>
     *
     * @param interfaceElement
     *            Interface instance, null impossible
     * @throws IllegalArgumentException
     *             when interfaceElement is null
     */
    public ClassElementsTransfer(Interface interfaceElement) {
        if (interfaceElement == null) {
            throw new IllegalArgumentException("Param interfaceElement should not be null.");
        }

        element = interfaceElement;
        supportedFlavor = INTERFACE_FLAVOR;
    }

    /**
     * <p>
     * Constructor which set attribute element by given Enumeration instance.
     * </p>
     *
     * @param enumeration
     *            Enumeration instance, null impossible
     * @throws IllegalArgumentException
     *             when enumeration is null
     */
    public ClassElementsTransfer(Enumeration enumeration) {
        if (enumeration == null) {
            throw new IllegalArgumentException("Param enumeration should not be null.");
        }

        this.element = enumeration;
        this.supportedFlavor = ENUMERATION_FLAVOR;
    }

    /**
     * <p>
     * Constructor which set attribute element by given Package instance.
     * </p>
     *
     * @param packageElement
     *            Package instance, null impossible
     * @throws IllegalArgumentException
     *             when packageElement is null
     */
    public ClassElementsTransfer(com.topcoder.uml.model.modelmanagement.Package packageElement) {
        if (packageElement == null) {
            throw new IllegalArgumentException("Param packageElement should not be null.");
        }

        this.element = packageElement;
        this.supportedFlavor = PACKAGE_FLAVOR;
    }

    /**
     * <p>
     * Constructor which set attribute element by given Abstraction instance.
     * </p>
     *
     * @param abstraction
     *            Abstraction instance, null impossible
     * @throws IllegalArgumentException
     *             when abstraction is null
     */
    public ClassElementsTransfer(Abstraction abstraction) {
        if (abstraction == null) {
            throw new IllegalArgumentException("Param abstraction should not be null.");
        }

        this.element = abstraction;
        this.supportedFlavor = ABSTRACTION_FLAVOR;
    }

    /**
     * <p>
     * Constructor which set attribute element by given Association instance.
     * </p>
     *
     * @param association
     *            Association instance, null impossible
     * @throws IllegalArgumentException
     *             when association is null
     */
    public ClassElementsTransfer(Association association) {
        if (association == null) {
            throw new IllegalArgumentException("Param association should not be null.");
        }

        this.element = association;
        this.supportedFlavor = ASSOCIATION_FLAVOR;
    }

    /**
     * <p>
     * Constructor which set attribute element by given Dependency instance.
     * </p>
     *
     * @param dependency
     *            Dependency instance, null impossible
     * @throws IllegalArgumentException
     *             when dependency is null
     */
    public ClassElementsTransfer(Dependency dependency) {
        if (dependency == null) {
            throw new IllegalArgumentException("Param dependency should not be null.");
        }

        this.element = dependency;
        this.supportedFlavor = DEPENDENCY_FLAVOR;
    }

    /**
     * <p>
     * Constructor which set attribute element by given Generalization instance.
     * </p>
     *
     * @param generalization
     *            Generalization instance, null impossible
     * @throws IllegalArgumentException
     *             when generalization is null
     */
    public ClassElementsTransfer(Generalization generalization) {
        if (generalization == null) {
            throw new IllegalArgumentException("Param generalization should not be null.");
        }

        this.element = generalization;
        this.supportedFlavor = GENERALIZATION_FLAVOR;
    }

    /**
     * <p>
     * Notifies this object that it is no longer the clipboard owner. This
     * method will be called when another application or another object within
     * this application asserts ownership of the clipboard.
     * </p>
     *
     * @param clipboard
     *            Clipboard instance, not null
     * @param transferable
     *            Transferable instance, not null
     * @throws IllegalArgumentException
     *             when clipboard or transferable is null
     */
    public void lostOwnership(Clipboard clipboard, Transferable transferable) {
        if (clipboard == null) {
            throw new IllegalArgumentException("Param clipboard should not be null.");
        }
        if (transferable == null) {
            throw new IllegalArgumentException("Param transferable should not be null.");
        }

        LogFactory.getLog(this.getClass().getName()).log(
                Level.WARN,
                "Clipboard " + clipboard.getName() + " contains "
                        + transferable.getTransferDataFlavors()[0].getHumanPresentableName());
    }

    /**
     * <p>
     * Return array of supported data flavors.
     * </p>
     *
     * @return an array of data flavors in which this data can be transferred
     */
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[] {supportedFlavor};
    }

    /**
     * <p>
     * Check whether or not the specified data flavor is supported for this
     * object.
     * </p>
     *
     * @param dataFlavor
     *            Some DataFlavor instance, null impossible
     * @return true if this given dataFlavor is supported for this object,
     *         otherwise return false
     * @throws IllegalArgumentException
     *             when dataFlavor is null
     */
    public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        if (dataFlavor == null) {
            throw new IllegalArgumentException("Param dataFlavor should not be null.");
        }

        return dataFlavor.equals(supportedFlavor);
    }

    /**
     * <p>
     * Return an object which represents the data to be transferred.
     * </p>
     *
     * @param dataFlavor
     *            Some DataFlavor instance, null impossible
     * @return an object which represents the data to be transferred
     * @throws IllegalArgumentException
     *             when dataFlavor is null
     * @throws UnsupportedFlavorException
     *             if given dataFlavor is not supported
     */
    public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException {
        if (isDataFlavorSupported(dataFlavor)) {
            return element;
        } else {
            throw new UnsupportedFlavorException(dataFlavor);
        }
    }
}