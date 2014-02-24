/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;

import junit.framework.TestCase;

import sun.awt.datatransfer.TransferableProxy;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Accuracy test for the <code>ActorUtil</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestSubsystemUtil extends TestCase {
    /** The <code>SubsystemUtil</code> instance used to test against. */
    private SubsystemUtil subsystemUtil = new SubsystemUtil();

    /**
     * Test the constructor <code>SubsystemUtil()</code>.
     */
    public void testConstructor() {
        SubsystemUtil util = new SubsystemUtil();
        assertNotNull("Instance of SubsystemUtil should be created.", util);
    }

    /**
     * Test the method <code>addElementToClipboard(ModelElement, Clipboard)</code>.
     */
    public void testAddElementToClipboard() {
        ModelElement subsystem = new SubsystemImpl();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        subsystemUtil.addElementToClipboard(subsystem, clipboard);

        TransferableProxy transferable = (TransferableProxy) clipboard.getContents(null);
        assertTrue("The copied content should be correct.",
            transferable.getTransferDataFlavors()[0].equals(ModelTransfer.SUBSYSTEM_FLAVOR));
    }

    /**
     * Test the method <code>copyElement(ModelElement)</code>.
     */
    public void testCopyElement() {
        ModelElement subsystem = new SubsystemImpl();
        subsystem.setName("name");

        ModelElement ret = subsystemUtil.copyElement(subsystem);
        assertTrue("The returned ModelElement should be an Subsystem.", ret instanceof SubsystemImpl);
        assertTrue("The name of returned Subsystem should be correct.", ret.getName().equals("name"));
    }
}
