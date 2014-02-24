/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;

import java.awt.datatransfer.Clipboard;


/**
 * <p>
 * This class extends from UsecaseToolUtil. It overrides some method which is unique for current instance of
 * ModelElement Subsystem.
 * </p>
 *
 * <p>
 * Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
class SubsystemUtil extends UsecaseToolUtil {
    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public SubsystemUtil() {
    }

    /**
     * <p>
     * This method provides adding Subsystem instance to clipboard.
     * </p>
     *
     * @param modelElement ModelElement instance, should not be null.
     * @param clipboard Clipboard instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null.
     */
    public void addElementToClipboard(ModelElement modelElement, Clipboard clipboard) {
        Helper.checkNull("modelElement", modelElement);
        Helper.checkNull("clipboard", clipboard);

        Subsystem subsystem = (Subsystem) modelElement;
        ModelTransfer transfer = new ModelTransfer(subsystem);
        clipboard.setContents(transfer, transfer);
    }

    /**
     * <p>
     * This methods copy special attributes of given modelElement (actually Subsystem instance).
     * </p>
     *
     * @param modelElement copied ModelElement instance, should not be null.
     *
     * @return created Subsystem instance.
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public ModelElement copyElement(ModelElement modelElement) {
        Helper.checkNull("modelElement", modelElement);

        Subsystem oldSubsystem = (Subsystem) modelElement;
        Subsystem newSubsystem = new SubsystemImpl();
        copyModelElementAttributes(oldSubsystem, newSubsystem);
        copyClassifierAttributes(oldSubsystem, newSubsystem);

        return newSubsystem;
    }
}
