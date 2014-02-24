/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * <p>
 * This class provides the logic for Copying object. It implements {@linkplain TransientAction} interface.
 * This class copies all attributes except dependencies, owned elements and comments.
 * </p>
 * <p>
 * <b>Thread Safety :</b> Class is thread safe because it is immutable.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
public class CopyObjectAction implements TransientAction {

    /**
     * <p>
     * Represents Clipboard for this action. Cannot be <code>null</code> and it is set in constructor
     * </p>
     */
    private final Clipboard clipboard;

    /**
     * <p>
     * Represents Clipboard for this action. Cannot be <code>null</code> and it is set in constructor
     * </p>
     */
    private final Object object;

    /**
     * <p>
     * Represents objectUtil instance for current action.
     * </p>
     */
    private final ObjectUtil objectUtil = new ObjectUtil();

    /**
     * <p>
     * Constructs <code>CopyMessageAction</code> with the passed <code>object</code> and the clipboard to
     * the system Clipboard.
     * <p>
     *
     * @param object
     *            Object instance, Cannot be <code>null</code>;
     * @throws IllegalArgumentException
     *             if the object is <code>null</code>.
     */
    public CopyObjectAction(Object object) {
        this(object, Toolkit.getDefaultToolkit().getSystemClipboard());
    }

    /**
     * <p>
     * Constructs <code>CopyMessageAction</code> with the passed <code>object</code> and the
     * <code>clipboard</code>.
     * <p>
     *
     * @param object
     *            Object instance, Cannot be <code>null</code>;
     * @param clipboard
     *            Clipboard instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the object, clipboard is <code>null</code>.
     */
    public CopyObjectAction(Object object, Clipboard clipboard) {
        // check if object is null
        Helper.checkObjectNotNull(object, "object in CopyObjectAction#CopyObjectAction");
        // check if clipboard is null
        Helper.checkObjectNotNull(clipboard, "clipboard in CopyObjectAction#CopyObjectAction");
        this.object = objectUtil.copyObject(object);
        this.clipboard = clipboard;
    }

    /**
     * <p>
     * This method adds the object to the clipboard instance.
     * </p>
     */
    public void execute() {
        objectUtil.addObjectToClipboard(object, clipboard);
    }
}
