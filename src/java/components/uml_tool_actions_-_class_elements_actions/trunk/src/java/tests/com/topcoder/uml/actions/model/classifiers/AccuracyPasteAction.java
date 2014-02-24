/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;

/**
 * Mock class for PasteAction. Widen the visibility of PasteAction to public.
 *
 * @author superZZ
 * @version 1.0
 */

public class AccuracyPasteAction extends PasteAction {
    /**
     * Mock constructor which provide configuration for paste action.
     *
     * @param transferable
     *            Transfarable? instance, null impossible
     * @param dataFlavor
     *            DataFlavor instance, null impossible
     * @param classToolUtil
     *            classToolUtil instance, null impossible
     * @param namespace
     *            Namespace instance, null impossible
     * @throws InvalidDataContentException
     *             if requested data flavor is not supported
     * @throws IllegalArgumentException
     *             when some parameter is null
     */
    public AccuracyPasteAction(Transferable transferable,
            DataFlavor dataFlavor, MockClassToolUtil classToolUtil,
            Namespace namespace) throws InvalidDataContentException {
        super(transferable, dataFlavor, classToolUtil, namespace);
    }

    /**
     * Simple getter for modelElementl attribute.
     *
     * @return modelElement attribute, null impossible
     */
    public ModelElement getModelElement() {
        return super.getModelElement();
    }

    /**
     * Simple getter for classToolUtil attribute.
     *
     * @return classToolUtil attribute, null impossible
     */
    public MockClassToolUtil getClassToolUtil() {
        return (MockClassToolUtil) super.getClassToolUtil();
    }
}