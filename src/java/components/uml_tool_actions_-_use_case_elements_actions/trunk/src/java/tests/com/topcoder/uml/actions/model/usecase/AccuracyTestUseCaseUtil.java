/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.TestCase;

import sun.awt.datatransfer.TransferableProxy;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Accuracy test for the <code>UseCaseUtil</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestUseCaseUtil extends TestCase {
    /** The <code>UseCaseUtil</code> instance used to test against. */
    private UseCaseUtil useCaseUtil = new UseCaseUtil();

    /**
     * Test the constructor <code>UseCaseUtil()</code>.
     */
    public void testConstructor() {
        UseCaseUtil util = new UseCaseUtil();
        assertNotNull("Instance of UseCaseUtil should be created.", util);
    }

    /**
     * Test the method <code>addElementToClipboard(ModelElement, Clipboard)</code>.
     */
    public void testAddElementToClipboard() {
        ModelElement useCase = new UseCaseImpl();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        useCaseUtil.addElementToClipboard(useCase, clipboard);

        TransferableProxy transferable = (TransferableProxy) clipboard.getContents(null);
        assertTrue("The copied content should be correct.",
            transferable.getTransferDataFlavors()[0].equals(ModelTransfer.USECASE_FLAVOR));
    }

    /**
     * Test the method <code>copyElement(ModelElement)</code>.
     */
    public void testCopyElement() {
        ModelElement useCase = new UseCaseImpl();
        useCase.setName("name");

        ModelElement ret = useCaseUtil.copyElement(useCase);
        assertTrue("The returned ModelElement should be an UseCase.", ret instanceof UseCaseImpl);
        assertTrue("The name of returned UseCase should be correct.", ret.getName().equals("name"));
    }
}
