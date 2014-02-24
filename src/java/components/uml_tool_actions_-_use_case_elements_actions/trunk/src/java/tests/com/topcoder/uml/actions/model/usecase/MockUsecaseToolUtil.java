/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;

import java.awt.datatransfer.Clipboard;


/**
 * Mock the class for testing.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockUsecaseToolUtil extends UsecaseToolUtil {
    /**
     * The constructor.
     */
    public MockUsecaseToolUtil() {
        super();
    }

    /**
     * Mock the function.
     *
     * @param modelElement the instance
     * @param clipboard the instance
     */
    public void addElementToClipboard(ModelElement modelElement, Clipboard clipboard) {
    }

    /**
     * Mock the function.
     *
     * @param modelElement the instance
     *
     * @return the instance
     */
    public ModelElement copyElement(ModelElement modelElement) {
        return null;
    }
}
