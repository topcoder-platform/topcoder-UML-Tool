/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;

import com.topcoder.util.actionmanager.TransientAction;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * <p>
 * This abstract class provides all logic for Copy actions for all elements and contains all attributes  which are
 * common for them. It realize TransientAction interface. Provide copying stimulus to clipboard.
 * </p>
 *
 * <p>
 * Class contains reference to some model element which is mutable and that is why it is mutable  and is not thread
 * safety too.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
abstract class CopyAction implements TransientAction {
    /**
     * <p>
     * Represent Clipboard for this action.
     * </p>
     */
    private final Clipboard clipboard;

    /**
     * <p>
     * Represent UsecaseToolUtil instance for current action.
     * </p>
     */
    private final UsecaseToolUtil usecaseToolUtil;

    /**
     * <p>
     * Represent ModelElement instance for current action.
     * </p>
     */
    private final ModelElement modelElement;

    /**
     * <p>
     * Constructor which provides configuration for copy action.
     * </p>
     *
     * @param modelElement ModelElement instance, should not be null.
     * @param usecaseToolUtil usecaseToolUtil instance, should not be null.
     * @param clipboard Clipboard instance, can be null.
     *
     * @throws IllegalArgumentException when modelElement or usecaseToolUtil is null.
     */
    protected CopyAction(ModelElement modelElement, UsecaseToolUtil usecaseToolUtil, Clipboard clipboard) {
        Helper.checkNull("modelElement", modelElement);
        Helper.checkNull("usecaseToolUtil", usecaseToolUtil);
        this.modelElement = modelElement;
        this.usecaseToolUtil = usecaseToolUtil;

        if (clipboard == null) {
            this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        } else {
            this.clipboard = clipboard;
        }
    }

    /**
     * <p>
     * This is method which is used for running copy action logic.
     * </p>
     */
    public void execute() {
        usecaseToolUtil.addElementToClipboard(usecaseToolUtil.copyElement(modelElement), clipboard);
    }
}
