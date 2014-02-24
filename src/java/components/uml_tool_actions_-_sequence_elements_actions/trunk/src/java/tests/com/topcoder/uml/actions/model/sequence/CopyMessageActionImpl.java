/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * This is a mocked implementation of CopyMessageAction.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class CopyMessageActionImpl extends CopyMessageAction {

    /**
     * <p>
     * Constructor.
     * </p>
     *
     * @param stimulus Stimulus instance, it can not be null
     */
    public CopyMessageActionImpl(Stimulus stimulus) {
        super(stimulus);
    }

    /**
     * <p>
     * Constructor.
     * </p>
     *
     * @param stimulus Stimulus instance, it can not be null
     * @param clipboard Clipboard clipboard, it can not be null
     */
    public CopyMessageActionImpl(Stimulus stimulus, Clipboard clipboard) {
        super(stimulus, clipboard);
    }

}
