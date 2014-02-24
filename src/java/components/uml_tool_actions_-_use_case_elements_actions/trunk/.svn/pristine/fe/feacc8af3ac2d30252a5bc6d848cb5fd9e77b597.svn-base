/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.UseCase;

import com.topcoder.util.log.Level;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.LogFactory;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

import java.io.IOException;


/**
 * <p>
 * This class is used for transporting model elements through a system clipboard. It contain 5 custom DataFlavor
 * instances each element has own DataFlavor. Class also implement interface ClipboardOwner for providing ability to
 * be owner for elements in clipboard. It has five public constructors for setting different types of data flavors
 * without using instanceof operator.
 * </p>
 *
 * <p>
 * Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class ModelTransfer implements Transferable, ClipboardOwner {
    /**
     * <p>
     * Represent DataFlavor for Actor implementation.
     * </p>
     */
    public static final DataFlavor ACTOR_FLAVOR = new DataFlavor(Actor.class, "Actor");

    /**
     * <p>
     * Represent DataFlavor for UseCase implementation.
     * </p>
     */
    public static final DataFlavor USECASE_FLAVOR = new DataFlavor(UseCase.class, "Use Case");

    /**
     * <p>
     * Represent DataFlavor for Subsystem implementation.
     * </p>
     */
    public static final DataFlavor SUBSYSTEM_FLAVOR = new DataFlavor(Subsystem.class, "Subsystem");

    /**
     * <p>
     * Represent DataFlavor for Include implementation.
     * </p>
     */
    public static final DataFlavor INCLUDE_FLAVOR = new DataFlavor(Include.class, "Include");

    /**
     * <p>
     * Represent DataFlavor for Extend implementation.
     * </p>
     */
    public static final DataFlavor EXTEND_FLAVOR = new DataFlavor(Extend.class, "Extend");

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
     * Constructor which set attribute element by given Actor instance.
     * </p>
     *
     * @param actor Actor instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null
     */
    public ModelTransfer(Actor actor) {
        Helper.checkNull("actor", actor);
        this.element = actor;
        this.supportedFlavor = ACTOR_FLAVOR;
    }

    /**
     * <p>
     * Constructor which set attribute element by given UseCase instance.
     * </p>
     *
     * @param useCase UseCase instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public ModelTransfer(UseCase useCase) {
        Helper.checkNull("useCase", useCase);
        this.element = useCase;
        this.supportedFlavor = USECASE_FLAVOR;
    }

    /**
     * <p>
     * Constructor which set attribute element by given Subsystem instance.
     * </p>
     *
     * @param subsystem Subsystem instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public ModelTransfer(Subsystem subsystem) {
        Helper.checkNull("subsystem", subsystem);
        this.element = subsystem;
        this.supportedFlavor = SUBSYSTEM_FLAVOR;
    }

    /**
     * <p>
     * Constructor which set attribute element by given Include instance.
     * </p>
     *
     * @param include Include instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public ModelTransfer(Include include) {
        Helper.checkNull("include", include);
        this.element = include;
        this.supportedFlavor = INCLUDE_FLAVOR;
    }

    /**
     * <p>
     * Constructor which set attribute element by given Extend instance.
     * </p>
     *
     * @param extend Extend instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public ModelTransfer(Extend extend) {
        Helper.checkNull("extend", extend);
        this.element = extend;
        this.supportedFlavor = EXTEND_FLAVOR;
    }

    /**
     * <p>
     * Notifies this object that it is no longer the clipboard owner. This method will be called when another
     * application or another object within this application asserts ownership of the clipboard.
     * </p>
     *
     * @param clipboard the Clipboard instance, should not be null.
     * @param transferable the Transferable instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null
     */
    public void lostOwnership(Clipboard clipboard, Transferable transferable) {
        Helper.checkNull("clipboard", clipboard);
        Helper.checkNull("transferable", transferable);

        DataFlavor[] flavors = transferable.getTransferDataFlavors();

        String name = clipboard.getName();
        Log log = LogFactory.getLog(this.getClass().getName()); 
        for (int i = 0; i < flavors.length; i++) {
            log.log(Level.INFO, flavors[i].getHumanPresentableName() + " lost owner ship in " + name + ".");
        }
    }

    /**
     * <p>
     * Return array of supported data flavors.
     * </p>
     *
     * @return array with 1 elements which contain supportedFlavor.
     */
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[] {supportedFlavor};
    }

    /**
     * <p>
     * Check if supported by this implementation given DataFlavor instance.
     * </p>
     *
     * @param dataFlavor Some DataFlavor instance, should not be null.
     *
     * @return return true if this given dataFlavor is equal supportedFlavor, otherwise return false
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        Helper.checkNull("dataFlavor", dataFlavor);

        return dataFlavor.equals(supportedFlavor);
    }

    /**
     * <p>
     * Return element attribute if its type are the same with which was  mentioned in supported data flavor.
     * </p>
     *
     * @param dataFlavor Some DataFlavor instance, should not be null.
     *
     * @return If given dataFlavor is not supported throw UnsupportedFlavorException, In other way return element
     *         attribute
     *
     * @throws IOException if the data is no longer available in the requested flavor.
     * @throws UnsupportedFlavorException if given dataFlavor is not supported.
     */
    public Object getTransferData(DataFlavor dataFlavor)
        throws IOException, UnsupportedFlavorException {
        if (dataFlavor == null) {
            throw new IOException("The given dataFlavor should not be null.");
        }

        if (!isDataFlavorSupported(dataFlavor)) {
            throw new UnsupportedFlavorException(dataFlavor);
        }

        return element;
    }
}
