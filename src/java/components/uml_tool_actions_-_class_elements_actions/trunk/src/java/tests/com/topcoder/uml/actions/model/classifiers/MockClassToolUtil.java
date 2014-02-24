/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This is the mock class of ClassToolUtil.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockClassToolUtil extends ClassToolUtil {

    /**
     * Mock method. Do nothing.
     *
     * @param modelElement
     *            ModelElement instance, null impossible;
     * @param clipboard
     *            Clipboard instance, null impossible
     * @throws IllegalArgumentException
     *             when parameter is null
     */
    public void addElementToClipboard(ModelElement modelElement, Clipboard clipboard) {
    }

    /**
     * Mock method. Do nothing.
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @throws IllegalArgumentException
     *             when some parameter is null
     * @return modelElement
     */
    public ModelElement copyElement(ModelElement modelElement) {
        return null;
    }

    /**
     * Mock protected method, for test.
     *
     * @param oldModelElement
     *            ModelElement instance, null impossible
     * @param newModelElement
     *            ModelElement instance, null impossible
     * @throws IllegalArgumentException
     *             when some parameter is null
     */
    public void copyModelElementAttributes(ModelElement oldModelElement, ModelElement newModelElement) {
        super.copyModelElementAttributes(oldModelElement, newModelElement);
    }

    /**
     * Mock protected method, for test.
     *
     * @param oldClassifier
     *            Classifier instance, null impossible
     * @param newClassifier
     *            Classifier instance, null impossible
     * @throws IllegalArgumentException
     *             when some parameter is null
     */
    public void copyClassifierAttributes(Classifier oldClassifier, Classifier newClassifier) {
        super.copyClassifierAttributes(oldClassifier, newClassifier);
    }
}