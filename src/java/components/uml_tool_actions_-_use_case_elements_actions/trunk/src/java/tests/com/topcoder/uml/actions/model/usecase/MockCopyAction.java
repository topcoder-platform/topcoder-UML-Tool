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
public class MockCopyAction extends CopyAction {
    /**
     * The constructor.
     *
     * @param modelElement the ModelElement instance
     * @param usecaseToolUtil the UsecaseToolUtil instance
     * @param clipboard the Clipboard instance
     */
    public MockCopyAction(ModelElement modelElement, UsecaseToolUtil usecaseToolUtil, Clipboard clipboard) {
        super(modelElement, usecaseToolUtil, clipboard);
    }
}
