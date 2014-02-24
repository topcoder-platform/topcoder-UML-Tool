/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.usecases.ActorImpl;

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
public class AccuracyTestActorUtil extends TestCase {
    /** The <code>ActorUtil</code> instance used to test against. */
    private ActorUtil actorUtil = new ActorUtil();

    /**
     * Test the constructor <code>ActorUtil()</code>.
     */
    public void testConstructor() {
        ActorUtil util = new ActorUtil();
        assertNotNull("Instance of ActorUtil should be created.", util);
    }

    /**
     * Test the method <code>addElementToClipboard(ModelElement, Clipboard)</code>.
     */
    public void testAddElementToClipboard() {
        ModelElement actor = new ActorImpl();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        actorUtil.addElementToClipboard(actor, clipboard);

        TransferableProxy transferable = (TransferableProxy) clipboard.getContents(null);
        assertTrue("The copied content should be correct.",
            transferable.getTransferDataFlavors()[0].equals(ModelTransfer.ACTOR_FLAVOR));
    }

    /**
     * Test the method <code>copyElement(ModelElement)</code>.
     */
    public void testCopyElement() {
        ModelElement actor = new ActorImpl();
        actor.setName("name");

        ModelElement ret = actorUtil.copyElement(actor);
        assertTrue("The returned ModelElement should be an actor.", ret instanceof ActorImpl);
        assertTrue("The name of returned actor should be correct.", ret.getName().equals("name"));
    }
}
