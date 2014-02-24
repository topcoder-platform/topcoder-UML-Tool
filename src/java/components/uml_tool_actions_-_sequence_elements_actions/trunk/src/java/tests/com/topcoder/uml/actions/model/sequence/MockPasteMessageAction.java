/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;

/**
 * <p>
 * This class is the mock extension of PasteMessageAction used for testing.
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class MockPasteMessageAction extends PasteMessageAction {

    /**
     * <p>
     * Mock Stub. Just calls the super.
     * </p>
     *
     * @param transferable
     *            Transferable instance, Cannot be <code>null</code>
     * @param collaboration
     *            Collaboration instance, Cannot be <code>null</code>
     * @param dataFlavor
     *            DataFlavor instance, Cannot be <code>null</code>
     * @throws SequenceConfigurationException
     *             any exception while calling the super
     * @throws IllegalArgumentException
     *             if the <code>transferable, collaboration, dataFlavor</code> is <code>null</code>.
     */
    public MockPasteMessageAction(Transferable transferable, Collaboration collaboration, DataFlavor dataFlavor)
        throws SequenceConfigurationException {
        super(transferable, collaboration, dataFlavor);
    }
}
