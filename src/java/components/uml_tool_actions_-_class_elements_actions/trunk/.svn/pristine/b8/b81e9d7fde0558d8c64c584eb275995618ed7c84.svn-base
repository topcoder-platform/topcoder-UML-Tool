/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * <p>
 * This abstract class provides all logic for Copy actions for all elements and
 * contains all attributes which are common for them. It realize TransientAction
 * interface. Provide copying modelElement to clipboard.
 * </p>
 * <p>
 * Thread-safety: Class contains reference to some model element which is
 * mutable and that is why it is mutable and is not thread safety.
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
     * Represent ModelElement instance for current action. This is used to keep
     * current element instance for copy action.
     * </p>
     */
    private final ModelElement modelElement;

    /**
     * <p>
     * Represent ClassToolUtil instance for current action. This is used to keep
     * current utility class instance for copy action.
     * </p>
     */
    private final ClassToolUtil classToolUtil;

    /**
     * <p>
     * Constructor which provide configuration for copy action.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @param classToolUtil
     *            ClassToolUtil instance, null impossible
     * @param clipboard
     *            Clipboard instance, null possible
     * @throws IllegalArgumentException
     *             when some parameter is null except clipboard
     */
    protected CopyAction(ModelElement modelElement, ClassToolUtil classToolUtil, Clipboard clipboard) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Param modelElement should not be null.");
        }
        if (classToolUtil == null) {
            throw new IllegalArgumentException("Param classToolUtil should not be null.");
        }

        this.modelElement = modelElement;
        this.classToolUtil = classToolUtil;
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
        classToolUtil.addElementToClipboard(classToolUtil.copyElement(modelElement), clipboard);
    }
}